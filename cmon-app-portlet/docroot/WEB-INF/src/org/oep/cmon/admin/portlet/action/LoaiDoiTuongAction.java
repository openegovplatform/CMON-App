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

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDungClp;

import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;

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
 * This is class LoaiDoiTuongAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class LoaiDoiTuongAction {

	/**
	 * This is function search LoaiDoiTuong
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
	public void searchLoaiDoiTuongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden");
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<DoiTuongSuDung> results = findByTenLoaiDoiTuong(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_list.jsp");
	}
	
	/**
	 * This is function find DoiTuongSuDung by TenLoaiDoiTuong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return List<DoiTuongSuDung>
	 */
	public List<DoiTuongSuDung> findByTenLoaiDoiTuong(String keyWord) {
		List<DoiTuongSuDung> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");	
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = DoiTuongSuDungLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<DoiTuongSuDung>();
		}
		return results;
	}

	/**
	 * This is function count DoiTuongSuDung by TenLoaiDoiTuong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return long
	 */
	private long countLoaiDoiTuongRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DoiTuongSuDung.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return DoiTuongSuDungLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * This is function delete DoiTuongSuDung
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
	public void deleteLoaiDoiTuongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String doiTuongSuDungId = ParamUtil.getString(actionRequest, "doiTuongSuDungId");
		
		// Process Jason feed
		try {
//			DoiTuongSuDung doiTuongSuDung = DoiTuongSuDungLocalServiceUtil.fetchDoiTuongSuDung(ConvertUtil.convertToLong(doiTuongSuDungId));
//			doiTuongSuDung.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			DoiTuongSuDungLocalServiceUtil.updateDoiTuongSuDung(doiTuongSuDung);
			DoiTuongSuDungLocalServiceUtil.deleteDoiTuongSuDung(ConvertUtil.convertToLong(doiTuongSuDungId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteDoiTuongSuDung");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_list.jsp");
	}

	/**
	 * This is function edit or add DoiTuongSuDung
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
	public void editOrAddLoaiDoiTuongRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String doiTuongSuDungId = ParamUtil.getString(actionRequest, "doiTuongSuDungId");
		String tenDoiTuongSuDung = ParamUtil.getString(actionRequest, "tenDoiTuongSuDung").trim();
		String moTaDoiTuongSuDung = ParamUtil.getString(actionRequest, "moTaDoiTuongSuDung").trim();
		String maDoiTuongSuDung = ParamUtil.getString(actionRequest, "maDoiTuongSuDung").trim();

		if (validationInput(tenDoiTuongSuDung, doiTuongSuDungId, maDoiTuongSuDung, actionRequest)) {
			DoiTuongSuDung doiTuongSuDung = null;
			if (doiTuongSuDungId.trim().length() > 0) {
				try {
					doiTuongSuDung = DoiTuongSuDungLocalServiceUtil.fetchDoiTuongSuDung(ConvertUtil.convertToLong(doiTuongSuDungId));
					doiTuongSuDung.setTen(tenDoiTuongSuDung);
					doiTuongSuDung.setMa(maDoiTuongSuDung);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setMota(moTaDoiTuongSuDung);
					DoiTuongSuDungLocalServiceUtil.updateDoiTuongSuDung(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedUpdateDoiTuongSuDung", "CompletedUpdateDoiTuongSuDung");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = LoaiDoiTuongBusiness.VIEW_LOAI_DOI_TUONG;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorUpdateDoiTuongSuDung");
				}
			} else {
				try {
					doiTuongSuDung = new DoiTuongSuDungClp();
					doiTuongSuDung.setId(CounterLocalServiceUtil.increment(DoiTuongSuDung.class.getName()));
					doiTuongSuDung.setTen(tenDoiTuongSuDung);
					doiTuongSuDung.setMota(moTaDoiTuongSuDung);
					doiTuongSuDung.setMa(maDoiTuongSuDung);
					doiTuongSuDung.setNgaySua(new Date());
					doiTuongSuDung.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					doiTuongSuDung.setNgayTao(new Date());
					doiTuongSuDung.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					DoiTuongSuDungLocalServiceUtil.addDoiTuongSuDung(doiTuongSuDung);
					actionResponse.setRenderParameter("CompletedAddDoiTuongSuDung", "CompletedAddDoiTuongSuDung");
					actionResponse.setRenderParameter("completed", "completed");
					//doiTuongSuDungId = String.valueOf(doiTuongSuDung.getId());
					//actionType = LoaiDoiTuongBusiness.VIEW_LOAI_DOI_TUONG;
					tenDoiTuongSuDung = "";
					maDoiTuongSuDung = "";
					moTaDoiTuongSuDung = "";
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(doiTuongSuDung.toString());
					SessionErrors.add(actionRequest, "errorAddDoiTuongSuDung");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("doiTuongSuDungId", doiTuongSuDungId);
		actionResponse.setRenderParameter("maDoiTuongSuDung", maDoiTuongSuDung);
		actionResponse.setRenderParameter("moTaDoiTuongSuDung", moTaDoiTuongSuDung);
		actionResponse.setRenderParameter("tenDoiTuongSuDung", tenDoiTuongSuDung);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/loai_doi_tuong_add.jsp");

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
			SessionErrors.add(actionRequest, "emptyMaDoiTuongSuDung");
		}
		if (tenDoiTuongSuDung.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenDoiTuongSuDung");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			DoiTuongSuDung doiTuongSuDung = null;
			try {

				// Kiem tra theo Ma
				try {
					doiTuongSuDung = null;
					doiTuongSuDung = DoiTuongSuDungLocalServiceUtil.findByMa(maDoiTuongSuDung);
				} catch (Exception es) {
				}
				if (doiTuongSuDung != null) {
					if (doiTuongSuDung.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (doiTuongSuDungId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
							SessionErrors.add(actionRequest, "exitMaDoiTuongSuDung");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaDoiTuongSuDung");
					}
				}

				// Kiem tra theo Ten
//				try {
//					doiTuongSuDung = null;
//					doiTuongSuDung = DoiTuongSuDungLocalServiceUtil.findByTen(tenDoiTuongSuDung);
//				} catch (Exception es) {
//				}
//				if (doiTuongSuDung != null) {
//					if (doiTuongSuDung.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
//						return true;
//					}
//					if (doiTuongSuDungId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(doiTuongSuDungId) != doiTuongSuDung.getId()) {
//							SessionErrors.add(actionRequest, "exitTenDoiTuongSuDung");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenDoiTuongSuDung");
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
