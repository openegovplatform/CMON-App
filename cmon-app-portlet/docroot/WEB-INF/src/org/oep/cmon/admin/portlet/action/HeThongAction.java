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

import org.oep.cmon.dao.cd.model.HeThong;
import org.oep.cmon.dao.cd.model.HeThongClp;

import org.oep.cmon.dao.cd.service.HeThongLocalServiceUtil;

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
 * This is class HeThongAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class HeThongAction {

	/**
	 * This is function search HeThongRequest
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
	public void searchHeThongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<HeThong> results = findByTenHeThong(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmht_list.jsp");
	}
	
	/**
	 * This is function find HeThong by TenHeThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<HeThong>
	 */
	@SuppressWarnings("unchecked")
	public List<HeThong> findByTenHeThong(String keyWord) {
		List<HeThong> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(HeThong.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = HeThongLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(HeThong.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = HeThongLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<HeThong>();
		}
		return results;
	}

	/**
	 * This is function count HeThong by TenHeThong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return long
	 */
	@SuppressWarnings("unused")
	private long countHeThongRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(HeThong.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return HeThongLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	/**
	 * This is function delete HeThong
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
	public void deleteHeThongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String doiTuongSuDungId = ParamUtil.getString(actionRequest, "heThongId");
		
		// Process Jason feed
		try {
//			HeThong doiTuongSuDung = HeThongLocalServiceUtil.fetchHeThong(ConvertUtil.convertToLong(doiTuongSuDungId));
//			doiTuongSuDung.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			HeThongLocalServiceUtil.updateHeThong(doiTuongSuDung);
			HeThongLocalServiceUtil.deleteHeThong(ConvertUtil.convertToLong(doiTuongSuDungId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteHeThong");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmht_list.jsp");
	}

	/**
	 * This is function edit or add HeThong
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
	public void editOrAddHeThongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String heThongId = ParamUtil.getString(actionRequest, "heThongId");
		String tenHeThong = ParamUtil.getString(actionRequest, "tenHeThong").trim();
		String moTaHeThong = ParamUtil.getString(actionRequest, "moTaHeThong").trim();
		String maHeThong = ParamUtil.getString(actionRequest, "maHeThong").trim();
		String trangThaiHeThong = ParamUtil.getString(actionRequest, "trangThaiHeThong").trim();

		if (validationInput(tenHeThong, heThongId, maHeThong, actionRequest)) {
			HeThong doiTuongSuDung = null;
			if (heThongId.trim().length() > 0) {
				try {
					doiTuongSuDung = HeThongLocalServiceUtil.fetchHeThong(ConvertUtil.convertToLong(heThongId));
					doiTuongSuDung.setTen(tenHeThong);
					doiTuongSuDung.setMa(maHeThong);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setMoTa(moTaHeThong);
					doiTuongSuDung.setTrangThai(ConvertUtil.convertToInt(trangThaiHeThong));
					HeThongLocalServiceUtil.updateHeThong(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedUpdateHeThong", "CompletedUpdateHeThong");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = HeThongBusiness.VIEW_HE_THONG;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorUpdateHeThong");
				}
			} else {
				try {
					doiTuongSuDung = new HeThongClp();
					doiTuongSuDung.setId(CounterLocalServiceUtil.increment(HeThong.class.getName()));
					doiTuongSuDung.setTen(tenHeThong);
					doiTuongSuDung.setMoTa(moTaHeThong);
					doiTuongSuDung.setMa(maHeThong);
					doiTuongSuDung.setTrangThai(ConvertUtil.convertToInt(trangThaiHeThong));
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgayTao(new Date());
					doiTuongSuDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					HeThongLocalServiceUtil.addHeThong(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedAddHeThong", "CompletedAddHeThong");
					actionResponse.setRenderParameter("completed", "completed");
					//heThongId = String.valueOf(doiTuongSuDung.getId());
					//actionType = HeThongBusiness.VIEW_HE_THONG;
					tenHeThong = "";
					moTaHeThong = "";
					maHeThong = "";
					trangThaiHeThong = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorAddHeThong");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("heThongId", heThongId);
		actionResponse.setRenderParameter("trangThaiHeThong", trangThaiHeThong);
		actionResponse.setRenderParameter("maHeThong", maHeThong);
		actionResponse.setRenderParameter("moTaHeThong", moTaHeThong);
		actionResponse.setRenderParameter("tenHeThong", tenHeThong);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/dmht_add.jsp");

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
	 * @param maDoiTuongSuDung
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String tenDoiTuongSuDung, String doiTuongSuDungId, String maDoiTuongSuDung, ActionRequest actionRequest) {
		if (maDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaHeThong");
		}
		if (tenDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenHeThong");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			HeThong doiTuongSuDung = null;
			try {

				// Kiem tra theo Ma
				try {
					doiTuongSuDung = null;
					doiTuongSuDung = HeThongLocalServiceUtil.findTheoMa(maDoiTuongSuDung);
				} catch (Exception es) {
				}
				if (doiTuongSuDung != null) {
					if (doiTuongSuDung.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}

					if (doiTuongSuDungId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
							SessionErrors.add(actionRequest, "exitMaHeThong");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaHeThong");
					}
				}

				// Kiem tra theo Ten
//				try {
//					doiTuongSuDung = null;
//					doiTuongSuDung = HeThongLocalServiceUtil.findTheoTen(tenDoiTuongSuDung);
//				} catch (Exception es) {
//				}
//				if (doiTuongSuDung != null) {
//					if (doiTuongSuDungId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
//							SessionErrors.add(actionRequest, "exitTenHeThong");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenHeThong");
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
