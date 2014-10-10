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

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLyClp;


import org.oep.cmon.dao.qlhc.service.CapCoQuanQuanLyLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is  class CapCoQuanQuanLyAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CapCoQuanQuanLyAction extends MVCPortlet {

	/** Search by code option */
	private static String SEARCH_CODE_OPTION = "0";
	
	/** Search by name option */
	private static String SEARCH_NAME_OPTION = "1";
	
	/**
	 * This is  function search CapCoQuanQuanLy
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
	@SuppressWarnings("unchecked")
	public void searchCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
				
		// Get the parent id if submitted
		String strParentId = ParamUtil.getString(actionRequest, "parentId");
		long parentId = 0;
				
		if ( Validator.isNotNull(strParentId)) {
			parentId = Long.parseLong(strParentId);
		}
				
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
				
		// Build the query		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CapCoQuanQuanLy.class);
				
		// Always search un-deleted record
		query = query.add( PropertyFactoryUtil.forName("daXoa").eq(0));		
				
		// Add the criteria incase keyword search is not null
		if ( Validator.isNotNull(searchOption) && Validator.isNotNull(keyWord)) {
			Criterion criteria = null;		
					
		// Define search criteria
		if ( searchOption.equals(SEARCH_CODE_OPTION)) {
			criteria = RestrictionsFactoryUtil.ilike("ma", keyWord + "%");	
		} else {
			criteria = RestrictionsFactoryUtil.ilike("ten", keyWord + "%");
		} 
					
		// Define search criteria
		query = query.add( criteria );
		}
		
		if ("".equals(keyWord) || keyWord == null) {
			// Query by parent id
			if (parentId > 0) {
				query = query.add( PropertyFactoryUtil.forName("chaId").eq(parentId));		
			} else {
				// Search all highest level
				query = query.add( PropertyFactoryUtil.forName("chaId").isNull());
			}
		}

		List<CapCoQuanQuanLy> results = null;
				
		try {
			results = CapCoQuanQuanLyLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_CO_QUAN_QUAN_LY_RESULT", results);
				
		// Redirect User
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
		actionResponse.setRenderParameter("parentId", String.valueOf(parentId ));
				
		if (Validator.isNull(searchOption)) {
				searchOption = SEARCH_NAME_OPTION;
		}
				
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);	
	}
	
	
	/**
	 * This is  function delete CapCoQuanQuanLy
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
	public void deleteCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be Ten
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String capCoQuanQuanLyId = ParamUtil.getString(actionRequest,"capCoQuanQuanLyId");
		
		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		try {
			CapCoQuanQuanLyLocalServiceUtil.deleteCapCoQuanQuanLy(ConvertUtil.convertToLong(capCoQuanQuanLyId));
			jsonFeed.put("ket_qua", "true");
		} catch (Exception es) {
			jsonFeed.put("ket_qua", "false");
		}

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		jsonFeed.put("searchKeyWord", keyWord);
		resourceResponse.getWriter().write(jsonFeed.toString());
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
	}
	
	/**
	 * This is  function add CapCoQuanQuanLy
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
	public void addCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String actionName = ParamUtil.getString(actionRequest, "actionName");
		String parentId = ParamUtil.getString(actionRequest,"parentId");
		String capCoQuanQuanLyId = ParamUtil.getString(actionRequest,"capCoQuanQuanLyId");
		if (!"".equals(parentId) && parentId != null) {
			capCoQuanQuanLyId = parentId;
		}
		String ma = ParamUtil.getString(actionRequest, "ma");
		String ten = ParamUtil.getString(actionRequest, "ten");

		CapCoQuanQuanLy capCoQuanQuanLy = new CapCoQuanQuanLyClp();
		if (validationInput(ma, ten, actionRequest)) {
			if (capCoQuanQuanLyId.trim().length() > 0) {
				try {
					capCoQuanQuanLy.setId(CounterLocalServiceUtil.increment(Constants.class.getName()));
					capCoQuanQuanLy.setMa(ma);
					capCoQuanQuanLy.setTen(ten);
					capCoQuanQuanLy.setNgayTao(new Date());
					capCoQuanQuanLy.setNguoiTao(themeDisplay.getUser().getEmailAddress());
					capCoQuanQuanLy.setNgaySua(new Date());
					capCoQuanQuanLy.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					capCoQuanQuanLy.setPhienBan(1);
					if (Long.valueOf(capCoQuanQuanLyId) > 0) {
						capCoQuanQuanLy.setChaId(Long.valueOf(capCoQuanQuanLyId));
					} 
					CapCoQuanQuanLyLocalServiceUtil.addCapCoQuanQuanLy(capCoQuanQuanLy);
					actionResponse.setRenderParameter("CompletedAddCapCoQuanQuanLy","CompletedAddCapCoQuanQuanLy");
					actionResponse.setRenderParameter("completed", "completed");
				} catch (Exception es) {
					SessionErrors.add(actionRequest, "errorAddCapCoQuanQuanLy");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("actionName", actionName);
		actionResponse.setRenderParameter("capCoQuanQuanLyId", capCoQuanQuanLyId);
		actionResponse.setRenderParameter("ma", ma);
		actionResponse.setRenderParameter("ten", ten);
		actionResponse.setRenderParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
		
	}
	
	/**
	 * This is  function update CapCoQuanQuanLy
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
	public void updateCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		String actionType = ParamUtil.getString(actionRequest, "actionType");
		String capCoQuanQuanLyId = ParamUtil.getString(actionRequest, "capCoQuanQuanLyId");
		String ma = ParamUtil.getString(actionRequest, "ma");
		String ten = ParamUtil.getString(actionRequest, "ten");

		CapCoQuanQuanLy capCoQuanQuanLy = null;
		if (validationInput(ma, ten, actionRequest)) {
			if (capCoQuanQuanLyId.trim().length() > 0) {
				try {
					capCoQuanQuanLy = CapCoQuanQuanLyLocalServiceUtil.fetchCapCoQuanQuanLy(ConvertUtil.convertToLong(capCoQuanQuanLyId));
					capCoQuanQuanLy.setMa(ma);
					capCoQuanQuanLy.setTen(ten);
					capCoQuanQuanLy.setNgaySua(new Date());
					capCoQuanQuanLy.setNguoiSua(themeDisplay.getUser().getEmailAddress());
					CapCoQuanQuanLyLocalServiceUtil.updateCapCoQuanQuanLy(capCoQuanQuanLy);
					actionResponse.setRenderParameter("CompletedUpdateCapCoQuanQuanLy","CompletedUpdateCapCoQuanQuanLy");
					actionResponse.setRenderParameter("completed", "completed");
				} catch (Exception es) {
					SessionErrors.add(actionRequest, "errorUpdateCapCoQuanQuanLy");
				}
			}
		}

		// Set the result back to session
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("actionType", actionType);
		actionResponse.setRenderParameter("capCoQuanQuanLyId", capCoQuanQuanLyId);
		actionResponse.setRenderParameter("ma", ma);
		actionResponse.setRenderParameter("ten", ten);
		actionResponse.setRenderParameter("jspPage","/html/portlet/admin/cap_co_quan_quan_ly_list.jsp");
		
	}
	
	/**
	 * This is  function validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maCapCoQuanQuanLy
	 * @param tenCapCoQuanQuanLy
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String maCapCoQuanQuanLy, String tenCapCoQuanQuanLy, ActionRequest actionRequest) {
		if (maCapCoQuanQuanLy.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyMaCapCoQuanQuanLy");
		}
		if (tenCapCoQuanQuanLy.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenCapCoQuanQuanLy");
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}
		
		return false;
	}
	
}
