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

package org.oep.cmon.portlet.document.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.document.business.CitizenDocumentBusiness;
import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.ipmslist.business.FormOfflineBusiness;
import org.oep.cmon.util.Helpers;
import org.oep.sharedservice.cmon.provider.document.DocumentServiceImpl;
import org.oep.sharedservice.cmon.provider.document.IDocumentService;
import org.oep.sharedservice.cmon.provider.model.ResultUpload;
import org.oep.sharedservice.cmon.provider.storage.IDocumentStorage;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;

import org.oep.cmon.dao.tlct.service.DanhMucGiayToLocalServiceUtil;
import org.oep.cmon.dao.tlct.service.TaiLieuChungThucLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class CitizenDocumentPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenDocumentPortlet extends MVCPortlet {
 
	private Log _log = LogFactoryUtil.getLog(CitizenDocumentPortlet.class);
	
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
	 * @throws IOException
	 * @throws PortletException
	 */
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		try {
			String resourceId = resourceRequest.getResourceID();
			if (resourceId.equals("listDanhMucGiayTo")) {
				long dmgtId = ParamUtil.getLong(resourceRequest, "danhMucGiayToId");
				long congDanId = ParamUtil.getLong(resourceRequest, "congDanId");

				JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
				//JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
				
				if (dmgtId > 0 && congDanId > 0) {
					if(checkExistChungThuc(dmgtId, congDanId))
					{
						jsonFeed.put("exist", "true");
					}
					else
					{
						jsonFeed.put("exist", "false");
					}
				}			
				
				//jsonFeed.put("name", _name);
				
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("UTF-8");
				resourceResponse.getWriter().write(jsonFeed.toString());
				resourceResponse.flushBuffer();
			}
		} catch (Exception e) {
			_log.error("serveResource(): error", e);
		}
	}
	
	/**
	 * This is function search ChungThucCongDan
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
	public void searchChungThucCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord", "");


		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);

		PortletPreferences prefs = actionRequest.getPreferences();

		int cur = ParamUtil.getInteger(actionRequest, "curCTCD", 1);
		int delta = ParamUtil.getInteger(actionRequest, "deltaCTCD",
				Constants.Paging.DELTA);
		prefs.setValue("curCTCD", String.valueOf(cur));
		prefs.setValue("deltaCTCD", String.valueOf(delta));
		prefs.store();

		setSearchParameter(actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/document/citizen/citizen_document_list.jsp");
	}

	/**
	 * This is function delete ChungThucCongDan
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
	public void deleteChungThucCongDan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// set parameters for search
		setSearchParameter(actionRequest, actionResponse);

		// Get search keyword, the keyword is code
		String taiLieuId = ParamUtil.getString(actionRequest, "id", "");
		
		try {
			//Change status
			TaiLieuChungThuc taiLieuChungThuc = TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(FormatUtil.convertToLong(taiLieuId));
			String documentTypeCode = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(taiLieuChungThuc.getDanhMucGiayToId()).getMa();
			IDocumentService service = new DocumentServiceImpl();
			boolean result = service.doDelete(PortalUtil.getUser(actionRequest).getUserId(), documentTypeCode);
			if(result)
			{
				SessionMessages.add(actionRequest, "successDelete");
			}
			else
			{
				SessionErrors.add(actionRequest, "errorDelete");
			}
				
			//taiLieuChungThuc.setTrangThai(Constants.Citizen.TrangThai_XoaTam);
			//TaiLieuChungThucLocalServiceUtil.updateTaiLieuChungThuc(taiLieuChungThuc);
			//SessionMessages.add(actionRequest, "successDelete");
		} catch (Exception es) {
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDelete");
		}

		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/citizen/citizen_document_list.jsp");
	}
	
	/**
	 * This is function add ChungThucCongDan
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
	public void addChungThucCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		setSearchParameter(actionRequest, actionResponse);

		actionResponse.setRenderParameter("modeView", CitizenDocumentBusiness.ADD_TAI_LIEU);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/citizen/citizen_document_form.jsp");
	}

	/**
	 * This is function edit ChungThucCongDan
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
	public void editChungThucCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		setSearchParameter(actionRequest, actionResponse);

		long id = ParamUtil.getLong(actionRequest, "id");
		TaiLieuChungThuc taiLieuChungThuc =TaiLieuChungThucLocalServiceUtil.fetchTaiLieuChungThuc(id);
		if (taiLieuChungThuc == null) {
			SessionErrors.add(actionRequest, "notExist");
			actionResponse.setRenderParameter("jspPage",
					"/html/portlet/document/citizen/citizen_document_list.jsp");
			return;
		}

		actionResponse.setRenderParameter("luuTruId", String.valueOf(taiLieuChungThuc.getId()));
		actionResponse.setRenderParameter("file", String.valueOf(taiLieuChungThuc.getNoiLuuTruId()));
		actionResponse.setRenderParameter("danhMucGiayToId", String.valueOf(taiLieuChungThuc.getDanhMucGiayToId()));

		actionResponse.setRenderParameter("modeView", CitizenDocumentBusiness.UPDATE_TAI_LIEU);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/citizen/citizen_document_form.jsp");
	}

	/**
	 * This is function edit or add ChungThucCongDan
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
	public void editOrAddChungThucRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		String modeView = ParamUtil.getString(uploadRequest, "modeView");
		String luuTruId = ParamUtil.getString(uploadRequest, "luuTruId");
		String danhMucGiayToId = ParamUtil.getString(uploadRequest, "danhMucGiayToId");
		//String file = ParamUtil.getString(uploadRequest, "file");
		long doiTuongId = ParamUtil.getLong(uploadRequest, "doiTuongId");
		long congDanId = ParamUtil.getLong(uploadRequest, "congDanId");
		//long noiLuuTruId=0L;
		File fileUpload=uploadRequest.getFile("file");
		String sourceFileName =uploadRequest.getFileName("file");
		byte[] bytes = FileUtil.getBytes(fileUpload);
		
		if (validationInput(danhMucGiayToId, sourceFileName, actionRequest)) {
			TaiLieuChungThuc taiLieu = null;
			if (!Helpers.isEmpty(luuTruId)) {
				try {
					DanhMucGiayTo danhmuc = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(danhMucGiayToId));
					String documentTypeCode = danhmuc.getMa();
					//String documentName = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(danhMucGiayToId)).getTen();
					IDocumentService service = new DocumentServiceImpl();
					ResultUpload result = service.doUpload(PortalUtil.getUser(actionRequest).getUserId(), null, documentTypeCode, bytes, sourceFileName, false, false);
					if (result.getCode().compareTo(Constants.UPLOAD_OK) == 0 && result != null) {
						SessionMessages.add(actionRequest, "successUpdate");
					}
					else
					{
						SessionErrors.add(actionRequest, "errorUploadFile");
					}
					
				} catch (Exception es) {
					_log.error(es.getMessage(), es);
					SessionErrors.add(actionRequest, "errorAddOrUpdate");
				}
			} else {
				try {
				     DanhMucGiayTo danhmuc = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(danhMucGiayToId));
					String documentTypeCode = danhmuc.getMa();
					//String documentName = DanhMucGiayToLocalServiceUtil.fetchDanhMucGiayTo(FormatUtil.convertToLong(danhMucGiayToId)).getTen();
					IDocumentService service = new DocumentServiceImpl();
					long userId= PortalUtil.getUser(actionRequest).getUserId();
					ResultUpload result = service.doUpload(userId, null, documentTypeCode, bytes, sourceFileName, false, false);
					
					if (result.getCode().compareTo(Constants.UPLOAD_OK) == 0 && result != null) {
						SessionMessages.add(actionRequest, "successAdd");
						//file = "";
						sourceFileName = "";
						danhMucGiayToId = "";
					}else	{
						String fileType = danhmuc.getKieuTaiLieu();
						long fileSize = danhmuc.getGioiHanDungLuong();
						actionResponse.setRenderParameter("fileType", String.valueOf(fileType));
						actionResponse.setRenderParameter("fileSize", String.valueOf(fileSize));
						//SessionErrors.add(actionRequest, "errorUploadFile");
						actionResponse.setRenderParameter("errorUploadFile", "errorUploadFile");
					}
				} catch (Exception es) {
					_log.error(es.getMessage(), es);
					SessionErrors.add(actionRequest, "errorAddOrUpdate");
				}
			}
		}

		//set parameters
		setSearchParameter(actionRequest, actionResponse);
		// Set the result back to session
		actionResponse.setRenderParameter("modeView", modeView);
		actionResponse.setRenderParameter("luuTruId", luuTruId);
		actionResponse.setRenderParameter("doiTuongId", String.valueOf(doiTuongId));
		actionResponse.setRenderParameter("congDanId", String.valueOf(congDanId));
		actionResponse.setRenderParameter("danhMucGiayToId", danhMucGiayToId);
		actionResponse.setRenderParameter("file", sourceFileName);
		actionResponse.setRenderParameter("jspPage", "/html/portlet/document/citizen/citizen_document_form.jsp");
	}
	
	/**
	 * This is function view ChungThucCongDan
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
	public void viewChungThucCongDan(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		setSearchParameter(actionRequest, actionResponse);
		
		String doiTuongId = ParamUtil.getString(actionRequest, "doiTuongId");
		String congDanId = ParamUtil.getString(actionRequest, "congDanId");
		String danhMucGiayToId = ParamUtil.getString(actionRequest, "danhMucGiayToId");

		actionResponse.setRenderParameter("doiTuongId",doiTuongId);
		actionResponse.setRenderParameter("congDanId",congDanId);
		actionResponse.setRenderParameter("danhMucGiayToId",danhMucGiayToId);
		actionResponse.setRenderParameter("jspPage",
				"/html/portlet/document/citizen/citizen_document_history.jsp");
	}
	
	/**
	 * This is function check status URL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httlReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void checkTrangThaiUrl(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
		JSONObject jsonFeed = checkTrangThai(resourceRequest, httpReq);

		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(httpReq);
		
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.getWriter().write(jsonFeed.toString());
		resourceResponse.getWriter().close();
	}
	
	/**
	 * This is function check status
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httlReq
	 * @throws Exception
	 * @return JSONObject
	 */
	public JSONObject checkTrangThai(ActionRequest resourceRequest,
			ActionResponse httpReq) throws Exception {
		String danhMucGiayToId = ParamUtil.getString(resourceRequest, "danhMucGiayToId");
		String congDanId = ParamUtil.getString(resourceRequest, "congDanId");
				
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		//JSONArray _name = JSONFactoryUtil.getJSONFactory().createJSONArray();
	
			try {
						
				if(checkExistChungThuc(FormatUtil.convertToLong(danhMucGiayToId), FormatUtil.convertToLong(congDanId)))
				{
					jsonFeed.put("exist", "true");
				}
				else
				{
					jsonFeed.put("exist", "false");
				}
			} catch (Exception es) {
				jsonFeed.put("exist", "error");
			}
			
		//jsonFeed.put("name", _name);

		return jsonFeed;
	}
	
	/**
	 * This is function check exist ChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dmtId
	 * @param congDanId
	 * @return boolean
	 */
	private boolean checkExistChungThuc(long dmgtId, long congDanId) {
		try {
			return CitizenDocumentBusiness.checkExistChungThuc(dmgtId, congDanId);
		} catch (Exception e) {
			_log.error("checkExistChungThuc(long, long): error", e);
		}
		return false;
	}
	
	/**
	 * This is function list TaiLieuChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchKeyWord 
	 * @param congDanId
	 * @param doiTuongId
	 * @param start
	 * @param end
	 * @return List<TaiLieuChungThuc>
	 */ 
	public List<TaiLieuChungThuc> listTaiLieuChungThuc(String searchKeyWord, Long congDanId, Long doiTuongId, int start, int end) {
		try {
			return  TaiLieuChungThucLocalServiceUtil.searchCongDanId2DanhMucGiayTo(searchKeyWord, congDanId, doiTuongId, start, end);
		} catch (Exception e) {
			_log.error("listTaiLieuChungThuc(String, Long, Long, int, int): error", e);
		}
		return new ArrayList<TaiLieuChungThuc>();
	}

	/**
	 * This is function count TaiLieuChungThuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchKeyWord
	 * @param congDanId
	 * @param doiTuongId
	 * @return long
	 */
	public long countTaiLieuChungThuc(String searchKeyWord, Long congDanId, Long doiTuongId) {
		try {
			return TaiLieuChungThucLocalServiceUtil.countCongDanId2DanhMucGiayTo(searchKeyWord, congDanId, doiTuongId);
		} catch (Exception e) {
			_log.error("countTaiLieuChungThuc(String, Long, Long): error", e);
		}
		return 0;
	}

	/**
	 * This is function list TaiLieuChungThuc history
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param danhMucGiayToId
	 * @param congDanId
	 * @param start
	 * @param end
	 */
	public List<TaiLieuChungThuc> listTaiLieuChungThucHistory(Long danhMucGiayToId, Long congDanId, int start, int end) {
		try {
			return CitizenDocumentBusiness.findByChungThucHistory(danhMucGiayToId, congDanId, start, end);
		} catch (Exception e) {
			_log.error("listTaiLieuChungThucHistory(Long, Long, Long, int, int): error", e);
		}
		return new ArrayList<TaiLieuChungThuc>();
	}

	/**
	 * This is function count TaiLieuChungThuc history
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param danhMucGiayToId
	 * @param congDanId
	 */
	public long countTaiLieuChungThucHistory(Long danhMucGiayToId, Long congDanId) {
		try {
			return CitizenDocumentBusiness.countByChungThucHistory(danhMucGiayToId, congDanId);
		} catch (Exception e) {
			_log.error("countByChungThucHistory(Long, Long, Long): error", e);
		}
		return 0;
	}
	
	/**
	 * This is function get list DanhMucGiayTo by CongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param doiTuongId
	 * @return List<DanhMucGiayTo>
	 */
	public List<DanhMucGiayTo> listByCongDan(Long doiTuongId) {
		try {
			return DanhMucGiayToLocalServiceUtil.listByCongDan(doiTuongId);
		} catch (Exception e) {
			_log.error("listByCongDan(Long): error", e);
		}
		return new ArrayList<DanhMucGiayTo>();
	}
	
	/**
	 * This is function check validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param dmgtId
	 * @param file
	 * @param actionRequest
	 * @return boolean
	 */
	private boolean validationInput(String dmgtId, String file,
			ActionRequest actionRequest) {
		if (Helpers.isEmpty(dmgtId)) {
			SessionErrors.add(actionRequest, "emptyDanhMucGiayTo");
		}
		if (Helpers.isEmpty(file)) {
			SessionErrors.add(actionRequest, "emptyFile");
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is function check status URL
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httlReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	private void setSearchParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		
		String cur = ParamUtil.getString(actionRequest, "cur");
		if (!Helpers.isEmpty(cur)) {
			actionResponse.setRenderParameter("cur",
					ParamUtil.getString(actionRequest, "cur"));
		}
		String delta = ParamUtil.getString(actionRequest, "delta");
		if (!Helpers.isEmpty(delta)) {
			actionResponse.setRenderParameter("delta",
					ParamUtil.getString(actionRequest, "delta"));
		}
	}

	/**
	 * This is function set search parameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portletURL
	 * @param cur
	 * @param delta
	 */
	public void setSearchParameter(PortletURL portletURL, int cur, int delta) {
		
		portletURL.setParameter("cur", String.valueOf(cur));
		portletURL.setParameter("delta", String.valueOf(delta));
	}

}
