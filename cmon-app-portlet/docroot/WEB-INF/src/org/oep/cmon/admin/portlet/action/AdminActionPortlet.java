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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class AdminActionPortlet  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */

public class AdminActionPortlet extends MVCPortlet {

	/**
	 * This is function serveResource
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws Exception
	 * @throws PortletException
	 */
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();

		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		if ( "fetchDonViHanhChinh".equals(resourceId) ) {		
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory().createJSONArray();	
			
			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;
			
			try {
				donviHanhChinhList = DonViHanhChinhLocalServiceUtil.findByChaId(parentId,Constants.ACTIVATED);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Store all data to jSon object
			for (DonViHanhChinh donViHanhChinh : donviHanhChinhList) {
				donViHanhChinhArray.put( donViHanhChinh.getId() + ":"  + donViHanhChinh.getTen());
			}
		
			jsonFeed.put("donViHanhChinhArray", donViHanhChinhArray );	
		}		
				
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
	}
	
	/**
	 * This is  function search account by user
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
	public void searchTaiKhoanNguoiDung(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new TaiKhoanNguoiDungAction().searchTaiKhoanNguoiDung(actionRequest, actionResponse);	
	}
	
	/**
	 * This is  function search account by user popup
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
	public void searchTaiKhoanNguoiDungPopup(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new TaiKhoanNguoiDungAction().searchTaiKhoanNguoiDungPopup(actionRequest, actionResponse);	
	}
	
	/**
	 * This is  function search Agency Manager
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
	public void searchCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CoQuanQuanLyAction().searchCoQuanQuanLy(actionRequest, actionResponse);	
	}
	
	/**
	 * This is  function search Agency Manager for popup grid
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
	public void searchPopupCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CoQuanQuanLyAction().searchPopupCapCoQuanQuanLy(actionRequest, actionResponse);	
	}
	
	/**
	 * This is  function view Agency Manager
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
	public void viewCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CoQuanQuanLyAction().viewCoQuanQuanLy(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function add role for Agency Manager
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
	public void addQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new  CoQuanQuanLyAction().addQuyenToCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function load role Agency Manager
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
	public void reloadQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new  CoQuanQuanLyAction().reloadQuyenToCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function delete role Agency Manager
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
	public void deleteQuyenToCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new  CoQuanQuanLyAction().deleteQuyenToCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function add edit Agency Manager
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
	public void addEditCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new  CoQuanQuanLyAction().addEditCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	/**
	 * This is  function delete Agency Manager
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
	public void deleteCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new  CoQuanQuanLyAction().deleteCoQuanQuanLy(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search role requese
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
		VaiTroAction action = new VaiTroAction();
		action.searchVaiTroRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function search Agency Manager request
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
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		action.searchCoQuanQuanLyRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete role request
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
		VaiTroAction action = new VaiTroAction();
		action.deleteVaiTroRequest(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function edit or add role request
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
		VaiTroAction action = new VaiTroAction();
		action.editOrAddVaiTroRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function edit á»? add role request
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
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		action.editOrAddChucVuVaiTroRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	/**
	 * This is  function search Agency Manager
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
		ChucVuVaiTroAction action = new ChucVuVaiTroAction();
		action.deleteChucVu2VaiTroRequest(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search system request
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
		HeThongAction action = new HeThongAction();
		action.searchHeThongRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete system request
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
		HeThongAction action = new HeThongAction();
		action.deleteHeThongRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function edit or add system request
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
		HeThongAction action = new HeThongAction();
		action.editOrAddHeThongRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function search administrative unit request
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
	public void searchCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapDonViHanhChinhAction action = new CapDonViHanhChinhAction();
		action.searchCapDonViHanhChinhRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete administrative unit request
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
	public void deleteCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapDonViHanhChinhAction action = new CapDonViHanhChinhAction();
		action.deleteCapDonViHanhChinhRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete administrative unit request
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
	public void editOrAddCapDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapDonViHanhChinhAction action = new CapDonViHanhChinhAction();
		action.editOrAddCapDonViHanhChinhRequest(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search administrative unit request
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
		LoaiDoiTuongAction action = new LoaiDoiTuongAction();
		action.searchLoaiDoiTuongRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete object type request
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
		LoaiDoiTuongAction action = new LoaiDoiTuongAction();
		action.deleteLoaiDoiTuongRequest(actionRequest, actionResponse);
	}


	/**
	 * This is  function edit or add object type request
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
		LoaiDoiTuongAction action = new LoaiDoiTuongAction();
		action.editOrAddLoaiDoiTuongRequest(actionRequest, actionResponse);
	}


	/**
	 * This is  function delete object type request
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
	public void searchDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		DanhMucDonViHanhChinhAction action = new DanhMucDonViHanhChinhAction();
		action.searchDanhMucDonViHanhChinhRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete administrative unit request
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
	public void deleteDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		DanhMucDonViHanhChinhAction action = new DanhMucDonViHanhChinhAction();
		action.deleteDanhMucDonViHanhChinhRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function edit administrative unit request
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
	public void editOrAddDanhMucDonViHanhChinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		DanhMucDonViHanhChinhAction action = new DanhMucDonViHanhChinhAction();
		action.editOrAddDanhMucDonViHanhChinhRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function delete sex request
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
	public void deleteGioiTinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		GioiTinhAction action = new GioiTinhAction();
		action.deleteGioiTinhRequest(actionRequest, actionResponse);
	}

	public void editOrAddGioiTinhRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		GioiTinhAction action = new GioiTinhAction();
		action.editOrAddGioiTinhRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function search minisgtry request
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
		ChucVuAction action = new ChucVuAction();
		action.searchChucVuRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete minisgtry request
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
		ChucVuAction action = new ChucVuAction();
		action.deleteChucVuRequest(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function edit or add minisgtry request
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
		ChucVuAction action = new ChucVuAction();
		action.editOrAddChucVuRequest(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function search country
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
		QuocGiaAction action = new QuocGiaAction();
		action.searchQuocGiaRequest(actionRequest, actionResponse);
	}

	/**
	 * This is  function delete country
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
		QuocGiaAction action = new QuocGiaAction();
		action.deleteQuocGiaRequest(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function edit or add country
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
		QuocGiaAction action = new QuocGiaAction();
		action.editOrAddQuocGiaRequest(actionRequest, actionResponse);
	}

	public void searchCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapCoQuanQuanLyAction action = new CapCoQuanQuanLyAction();
		action.searchCapCoQuanQuanLy(actionRequest, actionResponse);
	}
	
	public void deleteCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapCoQuanQuanLyAction action = new CapCoQuanQuanLyAction();
		action.deleteCapCoQuanQuanLy(actionRequest, actionResponse);
	}
	
	public void addCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapCoQuanQuanLyAction action = new CapCoQuanQuanLyAction();
		action.addCapCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	public void updateCapCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		CapCoQuanQuanLyAction action = new CapCoQuanQuanLyAction();
		action.updateCapCoQuanQuanLy(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function add or edit user account
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
	public void addEditTaiKhoanNguoiDung(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new TaiKhoanNguoiDungAction().addEditTaiKhoanNguoiDung(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function delete user account
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
	public void deleteTaiKhoanNguoiDung(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new TaiKhoanNguoiDungAction().deleteTaiKhoanNguoiDung(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function view user account
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
	public void viewTaiKhoanNguoiDung(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new TaiKhoanNguoiDungAction().viewTaiKhoanNguoiDung(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function add edit civil servants
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
	public void addEditCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().addEditCongChuc(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function delete civil servants
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
	public void deleteCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().deleteCongChuc(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function delete role of civil servants
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
	public void deleteRoleCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().deleteRoleCongChuc(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function deleteRoleCongChucRiengChuaAdd
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
	public void deleteRoleCongChucRiengChuaAdd(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().deleteRoleCongChucRiengChuaAdd(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function add role own civil servants
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
	public void addRoleCongChucRieng(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().addRoleCongChucRieng(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function view civil servants
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
	public void viewCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().viewCongChuc(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search civil servants
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
	public void searchCongChuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().searchCongChuc(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search popup position
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
	public void searchPopUpChucVu(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().searchPopUpChucVu(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search popup role need remove Ajax
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
	public void searchPopUpVaiTroChoCanBoAjax(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().searchPopUpVaiTroChoCanBoAjax(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search popup role need remove
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
	public void searchPopUpVaiTroChoCanBo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new CongChucAction().searchPopUpVaiTroChoCanBo(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function run job
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
	public void runJob(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new RunJobAction().runJob(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function search job status
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
	public void searchJobStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new JobStatusAction().searchJobStatus(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function add public service
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
	public void addDichVuCong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new DichVuCongAction().addDichVuCong(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function add only public service
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
	public void addDichVuCongOnly(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new DichVuCongAction().addDichVuCongOnly(actionRequest, actionResponse);
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is  function assign public service
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
	public void assignDichVuCong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new DichVuCongAction().assignDichVuCong(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function editHoSoMotCua 
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
	public void editHoSoMotCua(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().editHoSoMotCua(actionRequest, actionResponse);
	}
	
	/**
	 * Edit trang thai ho so (for integration)
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editTrangThaiHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().editTrangThaiHoSo(actionRequest, actionResponse);
	}
	
	/**
	 * Edit ket qua ho so (for integration)
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editKetQuaHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().editKetQuaHoSo(actionRequest, actionResponse);
	}
	
	/**
	 * Delete ho so mot cua
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteHoSoMotCua(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().deleteHoSoMotCua(actionRequest, actionResponse);
	}
	
	/**
	 * Delete trang thai ho so
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteTrangThaiHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().deleteTrangThaiHoSo(actionRequest, actionResponse);
	}
	
	/**
	 * Delete ket qua ho so
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void deleteKetQuaHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().deleteKetQuaHoSo(actionRequest, actionResponse);
	}
	
	/**
	 * Search ho so
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchHoSo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		new HoSoTicHopAction().searchHoSo(actionRequest, actionResponse);
	}
	
	/**
	 * This is  function get DonViHanhChinh by Id
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws Exception
	 */
	public void getDonViHanhChinhById(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		String id = ParamUtil.getString(resourceRequest, "id");

		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
		JSONArray _id = JSONFactoryUtil.getJSONFactory().createJSONArray();
		
		// Danh sach don vi hanh chinh
		List<DonViHanhChinh> dsDVHC = findDonViHanhChinhByChaId(Long.parseLong(id));
		
		for (DonViHanhChinh item : dsDVHC) {
			_id.put(item.getId());
			_name.put(item.getTen());
		}
		jsonFeed.put("id", _id);
		jsonFeed.put("name", _name);

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(httpReq);
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}
	
	/**
	 * This is  function find DonViHanhChinh by ChaId
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param chaId
	 * @throws Exception
	 */
	private List<DonViHanhChinh> findDonViHanhChinhByChaId(long chaId) {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(DonViHanhChinh.class);

		// This is a test line for display all request if there's no search
		// criteria
		Criterion criteriaTrangThai = RestrictionsFactoryUtil.eq("daXoa", 0);
		Criterion criteriaChaId = RestrictionsFactoryUtil.eq("chaId", chaId);

		// Define search criteria
		query = query.add(criteriaChaId).add(criteriaTrangThai);

		try {
			return DonViHanhChinhLocalServiceUtil.dynamicQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<DonViHanhChinh>();
	}
}
