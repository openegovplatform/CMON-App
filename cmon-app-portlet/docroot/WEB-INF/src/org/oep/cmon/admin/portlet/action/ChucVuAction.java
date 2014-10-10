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
import org.oep.cmon.dao.cc.model.ChucVuClp;

import org.oep.cmon.dao.cc.service.ChucVuLocalServiceUtil;

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
 * This is  class ChucVuAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ChucVuAction {

	/**
	 * This is function search ChucVu
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
	public void searchChucVuRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<ChucVu> results = findByTenChucVu(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/chuc_vu_list.jsp");
	}
	
	/**
	 * This is function find ChucVu by TenChucVu
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<ChucVu>
	 */
	@SuppressWarnings("unchecked")
	public List<ChucVu> findByTenChucVu(String keyWord) {
		List<ChucVu> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = ChucVuLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(ChucVu.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = ChucVuLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<ChucVu>();
		}
		return results;
	}

	/**
	 * This is  function delete ChucVu
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
	public void deleteChucVuRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String doiTuongSuDungId = ParamUtil.getString(actionRequest, "ChucVuId");
		
		// Process Jason feed
		try {
//			ChucVu doiTuongSuDung = ChucVuLocalServiceUtil.fetchChucVu(ConvertUtil.convertToLong(doiTuongSuDungId));
//			doiTuongSuDung.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			ChucVuLocalServiceUtil.updateChucVu(doiTuongSuDung);
			ChucVuLocalServiceUtil.deleteChucVu(ConvertUtil.convertToLong(doiTuongSuDungId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteChucVu");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/chuc_vu_list.jsp");
	}

	/**
	 * This is  function edit or add ChucVu
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
	public void editOrAddChucVuRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String ChucVuId = ParamUtil.getString(actionRequest, "ChucVuId");
		String tenChucVu = ParamUtil.getString(actionRequest, "tenChucVu").trim();
		String maChucVu = ParamUtil.getString(actionRequest, "maChucVu").trim();

		if (validationInput(tenChucVu, ChucVuId, maChucVu, actionRequest)) {
			ChucVu doiTuongSuDung = null;
			if (ChucVuId.trim().length() > 0) {
				try {
					doiTuongSuDung = ChucVuLocalServiceUtil.fetchChucVu(ConvertUtil.convertToLong(ChucVuId));
					doiTuongSuDung.setTen(tenChucVu);
					doiTuongSuDung.setMa(maChucVu);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					ChucVuLocalServiceUtil.updateChucVu(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedUpdateChucVu", "CompletedUpdateChucVu");
					actionResponse.setRenderParameter("completed", "completed");
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorUpdateChucVu");
				}
			} else {
				try {
					doiTuongSuDung = new ChucVuClp();
					doiTuongSuDung.setId(CounterLocalServiceUtil.increment(ChucVu.class.getName()));
					doiTuongSuDung.setTen(tenChucVu);
					doiTuongSuDung.setMa(maChucVu);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgayTao(new Date());
					doiTuongSuDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					ChucVuLocalServiceUtil.addChucVu(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedAddChucVu", "CompletedAddChucVu");
					actionResponse.setRenderParameter("completed", "completed");
					tenChucVu = "";
					maChucVu = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorAddChucVu");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("ChucVuId", ChucVuId);
		actionResponse.setRenderParameter("maChucVu", maChucVu);
		actionResponse.setRenderParameter("tenChucVu", tenChucVu);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/chuc_vu_add.jsp");

		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	/**
	 * This is  function check validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenDoiTuongSuDung
	 * @param doiTuongSuDungId
	 * @param maDoiTuongSuDung
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String tenDoiTuongSuDung, String doiTuongSuDungId, String maDoiTuongSuDung, ActionRequest actionRequest) {
		if (maDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaChucVu");
		}
		if (tenDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenChucVu");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			ChucVu doiTuongSuDung = null;
			try {

				// Kiem tra theo Ma
				try {
					doiTuongSuDung = null;
					List<ChucVu> list = ChucVuLocalServiceUtil.findMa(maDoiTuongSuDung);
					if (list != null && list.size() > 0) {
						doiTuongSuDung = list.get(0);
					}
				} catch (Exception es) {
				}
				if (doiTuongSuDung != null) {
					if (doiTuongSuDung.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (doiTuongSuDungId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
							SessionErrors.add(actionRequest, "exitMaChucVu");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaChucVu");
					}
				}

//				// Kiem tra theo Ten
//				try {
//					doiTuongSuDung = null;
//					List<ChucVu> list = ChucVuLocalServiceUtil.findTen(tenDoiTuongSuDung);
//					if (list != null && list.size() > 0) {
//						doiTuongSuDung = list.get(0);
//					}
//				} catch (Exception es) {
//				}
//				if (doiTuongSuDung != null) {
//					if (doiTuongSuDungId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
//							SessionErrors.add(actionRequest, "exitTenChucVu");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenChucVu");
//					}
//				}
			} catch (Exception es) {
			}
		}

		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
}
