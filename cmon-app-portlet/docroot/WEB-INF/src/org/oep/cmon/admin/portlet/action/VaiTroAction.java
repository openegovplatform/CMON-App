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

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.model.VaiTroClp;

import org.oep.cmon.dao.nsd.service.VaiTroLocalServiceUtil;

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
 * This is class VaiTroAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class VaiTroAction {

	/**
	 * This is function search VaiTro
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
	public void searchVaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<VaiTro> results = findByTenVaiTro(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmvt_list.jsp");
	}
	
	/**
	 * This is function find DanhMucUngDung by TenUngDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<DanhMucUngDung>
	 */
	public List<DanhMucUngDung> findByTenUngDung(String keyWord) {
		List<DanhMucUngDung> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(DanhMucUngDung.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = DanhMucUngDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<DanhMucUngDung>();
		}
		return results;
	}
	
	/**
	 * This is function VaiTro by TenVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<VaiTro>
	 */
	public List<VaiTro> findByTenVaiTro(String keyWord) {
		List<VaiTro> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = VaiTroLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = VaiTroLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<VaiTro>();
		}
		return results;
	}

	/**
	 * This is function count VaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return long
	 */
	private long countVaiTroRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(VaiTro.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return VaiTroLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * This is function delete VaiTro
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
	public void deleteVaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String doiTuongSuDungId = ParamUtil.getString(actionRequest, "VaiTroId");
		
		// Process Jason feed
		try {
//			VaiTro doiTuongSuDung = VaiTroLocalServiceUtil.fetchVaiTro(ConvertUtil.convertToLong(doiTuongSuDungId));
//			doiTuongSuDung.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			VaiTroLocalServiceUtil.updateVaiTro(doiTuongSuDung);
			VaiTroLocalServiceUtil.deleteVaiTro(ConvertUtil.convertToLong(doiTuongSuDungId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteVaiTro");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmvt_list.jsp");
	}

	/**
	 * This is function edit or add VaiTro
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
	public void editOrAddVaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String VaiTroId = ParamUtil.getString(actionRequest, "VaiTroId");
		String tenVaiTro = ParamUtil.getString(actionRequest, "tenVaiTro").trim();
		String moTaVaiTro = ParamUtil.getString(actionRequest, "moTaVaiTro").trim();
		String maVaiTro = ParamUtil.getString(actionRequest, "maVaiTro").trim();
		String trangThaiVaiTro = ParamUtil.getString(actionRequest, "trangThaiVaiTro").trim();
		String ungDungId = ParamUtil.getString(actionRequest, "UngDungId");

		if (validationInput(tenVaiTro, VaiTroId, maVaiTro, actionRequest)) {
			VaiTro doiTuongSuDung = null;
			if (VaiTroId.trim().length() > 0) {
				try {
					doiTuongSuDung = VaiTroLocalServiceUtil.fetchVaiTro(ConvertUtil.convertToLong(VaiTroId));
					doiTuongSuDung.setTen(tenVaiTro);
					doiTuongSuDung.setMa(maVaiTro);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setMoTa(moTaVaiTro);
					doiTuongSuDung.setUngDungId(ConvertUtil.convertToLong(ungDungId));
					doiTuongSuDung.setTrangThai(ConvertUtil.convertToInt(trangThaiVaiTro));
					VaiTroLocalServiceUtil.updateVaiTro(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedUpdateVaiTro", "CompletedUpdateVaiTro");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = VaiTroBusiness.VIEW_VAI_TRO;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorUpdateVaiTro");
				}
			} else {
				try {
					doiTuongSuDung = new VaiTroClp();
					doiTuongSuDung.setId(CounterLocalServiceUtil.increment(VaiTro.class.getName()));
					doiTuongSuDung.setTen(tenVaiTro);
					doiTuongSuDung.setMoTa(moTaVaiTro);
					doiTuongSuDung.setMa(maVaiTro);
					doiTuongSuDung.setUngDungId(ConvertUtil.convertToLong(ungDungId));
					doiTuongSuDung.setTrangThai(ConvertUtil.convertToInt(trangThaiVaiTro));
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgayTao(new Date());
					doiTuongSuDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					VaiTroLocalServiceUtil.addVaiTro(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedAddVaiTro", "CompletedAddVaiTro");
					actionResponse.setRenderParameter("completed", "completed");
					//VaiTroId = String.valueOf(doiTuongSuDung.getId());
					//actionType = VaiTroBusiness.VIEW_VAI_TRO;
					tenVaiTro = "";
					moTaVaiTro = "";
					maVaiTro = "";
					trangThaiVaiTro = "";
					ungDungId = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorAddVaiTro");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("VaiTroId", VaiTroId);
		actionResponse.setRenderParameter("maVaiTro", maVaiTro);
		actionResponse.setRenderParameter("moTaVaiTro", moTaVaiTro);
		actionResponse.setRenderParameter("tenVaiTro", tenVaiTro);
		actionResponse.setRenderParameter("trangThaiVaiTro", trangThaiVaiTro);
		actionResponse.setRenderParameter("UngDungId", ungDungId);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmvt_add.jsp");

		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
	}

	/**
	 * This is function validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenDoiTuongSuDung
	 * @param doiTuongSuDungId
	 * @param actionRequest
	 * @param maDoiTuongSuDung
	 * @return boolean
	 */
	private boolean validationInput(String tenDoiTuongSuDung, String doiTuongSuDungId, String maDoiTuongSuDung, ActionRequest actionRequest) {
		if (maDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaVaiTro");
		}
		if (tenDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenVaiTro");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			VaiTro doiTuongSuDung = null;
			try {

				// Kiem tra theo Ma
				try {
					doiTuongSuDung = null;
					doiTuongSuDung = VaiTroLocalServiceUtil.findTheoMa(maDoiTuongSuDung);
				} catch (Exception es) {
				}
				if (doiTuongSuDung != null) {
					if (doiTuongSuDung.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (doiTuongSuDungId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
							SessionErrors.add(actionRequest, "exitMaVaiTro");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaVaiTro");
					}
				}

				// Kiem tra theo Ten
//				try {
//					doiTuongSuDung = null;
//					doiTuongSuDung = VaiTroLocalServiceUtil.findTheoTen(tenDoiTuongSuDung);
//				} catch (Exception es) {
//				}
//				if (doiTuongSuDung != null) {
//					if (doiTuongSuDungId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
//							SessionErrors.add(actionRequest, "exitTenVaiTro");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenVaiTro");
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
