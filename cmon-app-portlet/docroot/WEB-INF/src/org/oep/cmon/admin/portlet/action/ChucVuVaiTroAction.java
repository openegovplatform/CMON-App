/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.admin.portlet.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.admin.portlet.util.SetParamUtil;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;
import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTroClp;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;

import org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * This is class ChucVuVaiTroAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ChucVuVaiTroAction {

	/**
	 * This is function delete ChucVu2VaiTroRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteChucVu2VaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String chucVuVaiTroId = ParamUtil.getString(actionRequest, "chucVuVaiTroId");
		String coQuanQuanLyId = ParamUtil.getString(actionRequest, "coQuanQuanLyId");
		
		// Process Jason feed
		try {
			ChucVu2VaiTroLocalServiceUtil.deleteChucVu2VaiTro(ConvertUtil.convertToLong(chucVuVaiTroId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteChucVu2VaiTro");
		}

		// Hidden default error message
		actionResponse.setRenderParameter("chucVuVaiTroId", chucVuVaiTroId);
		actionResponse.setRenderParameter("coQuanQuanLyId", coQuanQuanLyId);
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cv.jsp");
	}


	/**
	 * This is function edit or add ChucVu2VaiTroRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editOrAddChucVuVaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String coQuanQuanLyId = ParamUtil.getString(actionRequest, "coQuanQuanLyId");
		String chucVuId = ParamUtil.getString(actionRequest, "chucVuId").trim();
		String vaiTroId = ParamUtil.getString(actionRequest, "vaiTroId").trim();
		String chucVuVaiTroId = ParamUtil.getString(actionRequest, "chucVuVaiTroId").trim();

		if (validationInput(chucVuId, vaiTroId, chucVuVaiTroId, coQuanQuanLyId, actionRequest)) {
			ChucVu2VaiTro doiTuongSuDung = null;
			if (chucVuVaiTroId.trim().length() > 0 && ConvertUtil.convertToLong(chucVuVaiTroId) > 0) {
				try {
					doiTuongSuDung = ChucVu2VaiTroLocalServiceUtil.fetchChucVu2VaiTro(ConvertUtil.convertToLong(chucVuVaiTroId));
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setChucVuId(ConvertUtil.convertToLong(chucVuId));
					doiTuongSuDung.setVaiTroId(ConvertUtil.convertToLong(vaiTroId));

					ChucVu2VaiTroLocalServiceUtil.updateChucVu2VaiTro(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedUpdateChucVu2VaiTro", "CompletedUpdateChucVu2VaiTro");
					actionResponse.setRenderParameter("completed", "completed");
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SessionErrors.add(actionRequest, "errorUpdateChucVu2VaiTro");
				}
			} else {
				try {
					doiTuongSuDung = new ChucVu2VaiTroClp();
					doiTuongSuDung.setId(CounterLocalServiceUtil.increment(ChucVu2VaiTro.class.getName()));
					doiTuongSuDung.setChucVuId(ConvertUtil.convertToLong(chucVuId));
					doiTuongSuDung.setVaiTroId(ConvertUtil.convertToLong(vaiTroId));
					doiTuongSuDung.setCoQuanQuanLyId(ConvertUtil.convertToLong(coQuanQuanLyId));
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgayTao(new Date());
					doiTuongSuDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					ChucVu2VaiTroLocalServiceUtil.addChucVu2VaiTro(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedAddChucVu2VaiTro", "CompletedAddChucVu2VaiTro");
					actionResponse.setRenderParameter("completed", "completed");
					chucVuId = "";
					vaiTroId = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorAddChucVu2VaiTro");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("coQuanQuanLyId", coQuanQuanLyId);
		actionResponse.setRenderParameter("chucVuVaiTroId", chucVuVaiTroId);
		actionResponse.setRenderParameter("chucVuId", chucVuId);
		actionResponse.setRenderParameter("vaiTroId", vaiTroId);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_add_cv.jsp");

		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
	}


	/**
	 * This is function search CoQuanQuanLyRequest
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchCoQuanQuanLyRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<CoQuanQuanLy> results = findByCoQuanQuanLy(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dm_co_quan_quan_ly_chuc_vu_list_cqql.jsp");
	}

	/**
	 * This is function find CoQuanQuanLy by keyWord
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<CoQuanQuanLy>
	 */
	public List<CoQuanQuanLy> findByCoQuanQuanLy(String keyWord) {
		List<CoQuanQuanLy> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CoQuanQuanLy.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);

			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));

			try {
				results = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(CoQuanQuanLy.class);		

				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);

				results = CoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<CoQuanQuanLy>();
		}
		return results;
	}

	/**
	 * This is function find VaiTro by coQuanQuanLyId and chucVuId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @param chucVuId
	 * @return List<VaiTro>
	 */
	public List<VaiTro> findVaiTroByCoQuanQuanLyIdAndChucVuId(long coQuanQuanLyId, long chucVuId) {
		List<VaiTro> results = null;

		if (coQuanQuanLyId > 0 && chucVuId > 0) {
			try {
				List<ChucVu2VaiTro> listChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdChucVuAndIdCoQuanQuanLy(chucVuId, coQuanQuanLyId, 0);
				try {
					List<Object> listVaiTroId = new ArrayList<Object>();
					for (ChucVu2VaiTro chucVu2VaiTro : listChucVu2VaiTros) {
						listVaiTroId.add(chucVu2VaiTro.getVaiTroId());
					}
					if (listVaiTroId.size() > 0) {
						DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
						Criterion criteriaMa = RestrictionsFactoryUtil.in("id", listVaiTroId.toArray());
						Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						Criterion criteria = RestrictionsFactoryUtil.and(criteriaTrangThai, criteriaMa);
								
						// Define search criteria
						query = query.add(criteria);
								
						results = VaiTroLocalServiceUtil.dynamicQuery(query);
					}
				} catch (SystemException e) {
				}
			} catch (Exception e) {
			}
		}

		if (results == null) {
			results = new ArrayList<VaiTro>();
		}
		return results;
	}

	/**
	 * This is function find ChucVu by coQuanQuanLyId and coQuanQuanLyId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param coQuanQuanLyId
	 * @return List<ChucVu2VaiTro>
	 */
	public List<ChucVu2VaiTro> findChucVuByCoQuanQuanLyId(long coQuanQuanLyId) {

		if (coQuanQuanLyId > 0) {
			try {
				List<ChucVu2VaiTro> listChucVu2VaiTros = ChucVu2VaiTroLocalServiceUtil.findByIdCoQuanQuanLyAndDaXoa(coQuanQuanLyId, 0);
				return listChucVu2VaiTros;
			} catch (Exception e) {
			}
		}

		return new ArrayList<ChucVu2VaiTro>();
	}

	/**
	 * This is function find ChucVu by TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<ChucVu>
	 */
	public List<ChucVu> findChucVuByTrangThai() {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
				
		// Define search criteria
		query = query.add(criteriaTrangThai);
				
		try {
			return ChucVuLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}
		return new ArrayList<ChucVu>();
	}

	/**
	 * This is function find VaiTro by TrangThai
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return List<VaiTro>
	 */
	public List<VaiTro> findVaiTroByTrangThai() {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		

		// This is a test line for display all request if there's no search criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);

		// Define search criteria
		query = query.add(criteriaTrangThai);

		try {
			return VaiTroLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
		}
		return new ArrayList<VaiTro>();
	}

	/**
	 * This is  function check validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chucVuId
	 * @param vaiTroId
	 * @param chucVuVaiTroId
	 * @param coQuanQuanLyId
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String chucVuId, String vaiTroId, String chucVuVaiTroId, String coQuanQuanLyId, ActionRequest actionRequest) {
		if (chucVuId.trim().length() == 0 || ConvertUtil.convertToLong(chucVuId) == 0) {
			SessionErrors.add(actionRequest, "emptyChucVuIdChucVu2VaiTro");
		}
		if (vaiTroId.trim().length() == 0 || ConvertUtil.convertToLong(vaiTroId) == 0) {
			SessionErrors.add(actionRequest, "emptyVaiTroIdChucVu2VaiTro");
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu2VaiTro.class);		
			
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaChucVu = RestrictionsFactoryUtil.eq("chucVuId", ConvertUtil.convertToLong(chucVuId));
			Criterion criteriaVaiTro = RestrictionsFactoryUtil.eq("vaiTroId", ConvertUtil.convertToLong(vaiTroId));
			Criterion criteriaDaXoa = RestrictionsFactoryUtil.eq("daXoa", 0);
			Criterion criteriaCoQuanQuanLyId = RestrictionsFactoryUtil.eq("coQuanQuanLyId", ConvertUtil.convertToLong(coQuanQuanLyId));
					
			// Define search criteria
			query = query.add(criteriaChucVu).add(criteriaVaiTro).add(criteriaCoQuanQuanLyId).add(criteriaDaXoa);
			try {
				List<ChucVu2VaiTro> listChucVu2VaiTro = ChucVu2VaiTroLocalServiceUtil.dynamicQuery(query);
				if (listChucVu2VaiTro.size() > 0) {
					if (chucVuVaiTroId.trim().length() > 0) {
						ChucVu2VaiTro chucVu2VaiTro = listChucVu2VaiTro.get(0);
						if (chucVu2VaiTro.getId() != ConvertUtil.convertToLong(chucVuVaiTroId)) {
							SessionErrors.add(actionRequest, "exitChucVu2VaiTro");
						}
					} else {
						SessionErrors.add(actionRequest, "exitChucVu2VaiTro");
					}
				}
			} catch (SystemException e) {
			}
		}
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
}
