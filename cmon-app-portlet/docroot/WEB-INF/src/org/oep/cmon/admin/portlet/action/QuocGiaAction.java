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

import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.QuocGia;
import org.oep.cmon.dao.qlhc.model.QuocGiaClp;

import org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil;

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
 * This is class QuocGiaAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class QuocGiaAction {

	/**
	 * This is function search QuocGia
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
	public void searchQuocGiaRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord").trim();
		String keyWordHidden = ParamUtil.getString(actionRequest, "searchKeyWordHidden").trim();
		if (keyWordHidden.compareTo(keyWord) == 0) {
			keyWord = "";
		}
		
		List<QuocGia> results = findByTenQuocGia(keyWord);

		// Set the result back to session
		actionRequest.setAttribute("SEARCH_REQUEST_RESULT", results);
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/quoc_gia_list.jsp");
	}
	
	
	/**
	 * This is function find QuocGia by TenQuocGia
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @List<QuocGia>
	 */
	public List<QuocGia> findByTenQuocGia(String keyWord) {
		List<QuocGia> results = null;

		if (keyWord.trim().length() > 0) {
			// Query code request using keyword
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(QuocGia.class);		
					
			// This is a test line for display all request if there's no search criteria
			Criterion criteriaTen = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");
			Criterion criteriaMa = RestrictionsFactoryUtil.ilike("ma", "%" + keyWord + "%");
			Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
			Criterion criteria = RestrictionsFactoryUtil.or(criteriaTen, criteriaMa);
					
			// Define search criteria
			query = query.add(RestrictionsFactoryUtil.and(criteria, criteriaTrangThai));
					
			try {
				results = QuocGiaLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		} else {
			try {
				DynamicQuery query = DynamicQueryFactoryUtil.forClass(QuocGia.class);		
				
				// This is a test line for display all request if there's no search criteria
				Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
						
				// Define search criteria
				query = query.add(criteriaTrangThai);
						
				results = QuocGiaLocalServiceUtil.dynamicQuery(query);
			} catch (SystemException e) {
			}
		}

		if (results == null) {
			results = new ArrayList<QuocGia>();
		}
		return results;
	}

	/**
	 * This is function search QuocGia by TenQuocGia
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param keyWord
	 * @return long
	 */
	private long countQuocGiaRequest(String keyWord) throws Exception {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(QuocGia.class);		
		
		// This is a test line for display all request if there's no search criteria
		Criterion criteria = RestrictionsFactoryUtil.ilike("ten", "%" + keyWord + "%");			
		
		// Define search criteria
		query = query.add( criteria );
		
		try {
			return QuocGiaLocalServiceUtil.dynamicQueryCount(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * This is function delete QuocGia
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
	public void deleteQuocGiaRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = actionRequest.getParameter("searchKeyWord");

		// Get search keyword, the keyword is code
		String quocGiaId = ParamUtil.getString(actionRequest, "quocGiaId");
		
		// Process Jason feed
		try {
//			QuocGia quocGia = QuocGiaLocalServiceUtil.fetchQuocGia(ConvertUtil.convertToLong(quocGiaId));
//			quocGia.setDaXoa(SetParamUtil.DA_XOA_DEACTIVATE);
//			QuocGiaLocalServiceUtil.updateQuocGia(quocGia);
			QuocGiaLocalServiceUtil.deleteQuocGia(ConvertUtil.convertToLong(quocGiaId));
			actionRequest.setAttribute("delete_success", "delete_success");
		} catch (Exception es) {
			SetParamUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteQuocGia");
		}

		// Hidden default error message
		SetParamUtil.setParameter(actionRequest, actionResponse, keyWord);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/quoc_gia_list.jsp");
	}

	/**
	 * This is function edti or add QuocGia
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
	public void editOrAddQuocGiaRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = actionRequest.getParameter("searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String quocGiaId = ParamUtil.getString(actionRequest, "quocGiaId");
		String maQuocGia = ParamUtil.getString(actionRequest, "maQuocGia").trim();
		String tenQuocGia = ParamUtil.getString(actionRequest, "tenQuocGia").trim();

		if (validationInput(maQuocGia, tenQuocGia, quocGiaId, actionRequest)) {
			QuocGia quocGia = null;
			if (quocGiaId.trim().length() > 0) {
				try {
					quocGia = QuocGiaLocalServiceUtil.fetchQuocGia(ConvertUtil.convertToLong(quocGiaId));
					quocGia.setMa(maQuocGia);
					quocGia.setTen(tenQuocGia);
					quocGia.setNgaySua(new Date());
					quocGia.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					QuocGiaLocalServiceUtil.updateQuocGia(quocGia);
					actionResponse.setRenderParameter("CompletedUpdateQuocGia", "CompletedUpdateQuocGia");
					actionResponse.setRenderParameter("completed", "completed");
//					actionType = QuocGiaBusiness.VIEW_QUOC_GIA;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(quocGia.toString());
					SessionErrors.add(actionRequest, "errorUpdateQuocGia");
				}
			} else {
				try {
					quocGia = new QuocGiaClp();
					quocGia.setId(CounterLocalServiceUtil.increment(QuocGia.class.getName()));
					quocGia.setMa(maQuocGia);
					quocGia.setTen(tenQuocGia);
					quocGia.setNgaySua(new Date());
					quocGia.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					quocGia.setNgayTao(new Date());
					quocGia.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					quocGia.setPhienBan(1);
					QuocGiaLocalServiceUtil.addQuocGia(quocGia);
					actionResponse.setRenderParameter("CompletedAddQuocGia", "CompletedAddQuocGia");
					actionResponse.setRenderParameter("completed", "completed");
					//quocGiaId = String.valueOf(quocGia.getId());
					maQuocGia = "";
					tenQuocGia = "";
					//actionType = QuocGiaBusiness.VIEW_QUOC_GIA;
				} catch (Exception es) {
					SetParamUtil.printException(es);
					SetParamUtil.printError(quocGia.toString());
					SessionErrors.add(actionRequest, "errorAddQuocGia");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("ActionType", actionType);
		actionResponse.setRenderParameter("quocGiaId", quocGiaId);
		actionResponse.setRenderParameter("maQuocGia", maQuocGia);
		actionResponse.setRenderParameter("tenQuocGia", tenQuocGia);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/quoc_gia_add.jsp");

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
	 *  @param maQuocGia
	 *  @param tenQuocGia
	 * @param quocGiaId
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String maQuocGia, String tenQuocGia, String quocGiaId, ActionRequest actionRequest) {
		if (maQuocGia.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaQuocGia");
		}
		if (tenQuocGia.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenQuocGia");
		}
		// Neu thong tin nhap khac rong
		if (SessionErrors.isEmpty(actionRequest)) {
			QuocGia quocGia = null;
			try {
				// Kieam tra theo Ma
				try {
					quocGia = QuocGiaLocalServiceUtil.findByMaQuocGia(maQuocGia);
				} catch (NoSuchQuocGiaException es) {
				}
				if (quocGia != null) {
					if (quocGia.getDaXoa() == SetParamUtil.DA_XOA_DEACTIVATE) {
						return true;
					}
					if (quocGiaId.trim().length() > 0) {
						if (ConvertUtil.convertToLong(quocGiaId) != quocGia.getId()) {
							SessionErrors.add(actionRequest, "exitMaQuocGia");
						}
					} else {
						SessionErrors.add(actionRequest, "exitMaQuocGia");
					}
				}

				// Kiem tra theo Ten
//				try {
//					quocGia = null;
//					quocGia = QuocGiaLocalServiceUtil.findByTen(tenQuocGia);
//				} catch (NoSuchQuocGiaException es) {
//				}
//				if (quocGia != null) {
//					if (quocGiaId.trim().length() > 0) {
//						if (ConvertUtil.convertToLong(quocGiaId) != quocGia.getId()) {
//							SessionErrors.add(actionRequest, "exitTenQuocGia");
//						}
//					} else {
//						SessionErrors.add(actionRequest, "exitTenQuocGia");
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
