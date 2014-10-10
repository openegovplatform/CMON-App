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

package org.oep.cmon.portlet.quanlyvaitro.action;

import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.oep.cmon.Constants;
import org.oep.cmon.portlet.quanlyvaitro.business.QuanLyVaiTroBusiness;
import org.oep.cmon.util.Helpers;

import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTroClp;
import org.oep.cmon.dao.nsd.model.VaiTro;
import org.oep.cmon.dao.nsd.model.VaiTroClp;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class QuanLyVaiTroPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class QuanLyVaiTroPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil
			.getLog(QuanLyVaiTroPortlet.class);
	
	
	/**
	 * This is function prepareVaiTroRequest
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
	public void prepareVaiTroRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_log.info("prepareVaiTroRequest:start");
		try {
			//set parameters
			setSearchParameter(actionRequest, actionResponse);
			
			VaiTro vaiTro = null;
			String vaiTroId = ParamUtil.getString(actionRequest, "vaiTroId", "");
			String actionType = ParamUtil.getString(actionRequest, "actionType");
			String ten  = "";
			String ma   = "";
			String mota   = "";
			String ungDungId = "";
			String trangThai = "";

			if (!Helpers.isEmpty(vaiTroId)) {
				vaiTro = QuanLyVaiTroBusiness.getVaiTroById(Long.valueOf(vaiTroId));
				if (vaiTro != null) {
						
					ten  = vaiTro.getTen();
					ma   = vaiTro.getMa();
					mota = vaiTro.getMoTa();
					ungDungId = String.valueOf(vaiTro.getUngDungId());
					trangThai = String.valueOf(vaiTro.getTrangThai());
				}
			}			
			setParameterForEditAndAddVaiTro(vaiTroId, actionType, ten, ma, ungDungId, trangThai, mota, actionResponse);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		actionResponse.setRenderParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_add.jsp");
	}
	
	/**
	 * This is function setParameterForEditAndAddVaiTro
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @param actionType
	 * @param ten 
	 * @param ma
	 * @param ungDungId
	 * @param trangThai
	 * @param mota
	 * @param actionResponse
	 * @throws Exception
	 */
	private void setParameterForEditAndAddVaiTro(String vaiTroId, String actionType, String ten, String ma,
			String ungDungId, String trangThai, String mota,
			ActionResponse actionResponse) throws Exception {
		
		actionResponse.setRenderParameter("vaiTroId", vaiTroId);
		actionResponse.setRenderParameter("actionType", actionType);
		actionResponse.setRenderParameter("ten", ten);
		actionResponse.setRenderParameter("ma", ma);
		actionResponse.setRenderParameter("mota", mota);
		actionResponse.setRenderParameter("ungDungId", ungDungId);
		actionResponse.setRenderParameter("trangThai", trangThai);
	}

	//VaiTro
	/**
	 * This is function searchVaiTroRequest
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
		// Set the result back to session
		setSearchParameter(actionRequest, actionResponse);
		
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord", "");


		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);

		actionResponse.setRenderParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
	}
	
	/**
	 * This is function deleteVaiTroRequest
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
		try {
			setSearchParameter(actionRequest, actionResponse);
			String vaiTroId = ParamUtil.getString(actionRequest, "vaiTroId", "");
			
			if (!Helpers.isEmpty(vaiTroId)) {
				VaiTro vaiTro = QuanLyVaiTroBusiness.getVaiTroById(Long.valueOf(vaiTroId));
				if (vaiTro == null) {
					SessionErrors.add(actionRequest, "notExist");
					actionResponse
							.setRenderParameter("jspPage",
									"/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
					return;
				}
	
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
						.getAttribute(WebKeys.THEME_DISPLAY);
				String emailAddress = themeDisplay.getUser().getEmailAddress();
				Date currentDate = new Date();
	
				vaiTro.setNgaySua(currentDate);
				vaiTro.setNguoiSua(emailAddress);
				vaiTro.setDaXoa(org.oep.cmon.Constants.INACTIVE);
				QuanLyVaiTroBusiness.updateVaiTro(vaiTro);
				SessionMessages.add(actionRequest, "deleteCompleted");
			}
		} catch (Exception e) {
			_log.error("deleteVaiTroRequest(): error", e);
			SessionErrors.add(actionRequest, "deleteError");
		}

		actionResponse.setRenderParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_list.jsp");
	}

	/**
	 * This is function editOrAddVaiTroRequest
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
		//set parameters
		setSearchParameter(actionRequest, actionResponse);
		
		// Get params
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String emailAddress = themeDisplay.getUser().getEmailAddress();
		
		String actionType 	= ParamUtil.getString(actionRequest, "actionType", "");
		String vaiTroId 	= ParamUtil.getString(actionRequest, "vaiTroId", "");
		String ten 			= ParamUtil.getString(actionRequest, "ten", "");
		String ma 			= ParamUtil.getString(actionRequest, "ma", "");
		String mota 			= ParamUtil.getString(actionRequest, "mota", "");
		String ungDungId	= ParamUtil.getString(actionRequest, "ungDungId", "");
		String trangThai 	= ParamUtil.getString(actionRequest, "trangThai", "");	
		
		setParameterForEditAndAddVaiTro(vaiTroId, actionType, ten, ma, ungDungId, trangThai, mota, actionResponse);
		
		// set taiNguyen to request
		String[] taiNguyenDest = ParamUtil.getParameterValues(actionRequest, "taiNguyenDest");
		List<List<TaiNguyen>> configList = QuanLyVaiTroBusiness.findAllTaiNguyenByVaiTro(taiNguyenDest);
		if (configList != null && configList.size() > 1) {
			actionRequest.setAttribute("taiNguyenList", configList.get(0));
			actionRequest.setAttribute("taiNguyenConfigList", configList.get(1));
		}
		
		Date today = org.oep.cmon.util.DateUtil.getCurrentDate();
		try {
					
			
			if (validationVaiTroInput(vaiTroId, ten, ma, ungDungId, trangThai, actionRequest)) {
				VaiTro vaiTro = new VaiTroClp();
				vaiTro.setTen(ten);
				vaiTro.setMa(ma);
				vaiTro.setUngDungId(Long.valueOf(ungDungId));
				vaiTro.setTrangThai(Integer.valueOf(trangThai));
				vaiTro.setDaXoa(Constants.ACTIVE);
				vaiTro.setNgaySua(today);
				vaiTro.setNguoiSua(emailAddress);
				vaiTro.setMoTa(mota);
	
				if (Helpers.isEmpty(vaiTroId)) { // Add New
					
					vaiTro.setNgayTao(today);
					vaiTro.setNguoiTao(emailAddress);
					QuanLyVaiTroBusiness.saveVaiTro(vaiTro);
					SessionMessages.add(actionRequest, "successAddVaiTro");
					setParameterForEditAndAddVaiTro("", actionType, "", "", "", "", "", actionResponse);
					actionRequest.setAttribute("taiNguyenList", null);
					actionRequest.setAttribute("taiNguyenConfigList", null);
					
				} else { // Update
					vaiTro.setId(Long.valueOf(vaiTroId));
					QuanLyVaiTroBusiness.updateVaiTro(vaiTro);
					SessionMessages.add(actionRequest, "successUpdateVaiTro");
				}
				
				// save configuration
				if (taiNguyenDest != null && taiNguyenDest.length > 0) {
					// delete
					QuanLyVaiTroBusiness.deleteTaiNguyen2VaiTro(vaiTroId);
					
					// add new config
					TaiNguyen2VaiTro taiNguyen2VaiTro = null;
					if (taiNguyenDest.length > 0) {
						for (String taiNguyenId : taiNguyenDest) {
							taiNguyen2VaiTro = new TaiNguyen2VaiTroClp();
							taiNguyen2VaiTro.setVaiTroId(vaiTro.getId());
							taiNguyen2VaiTro.setTaiNguyenId(Long.valueOf(taiNguyenId));
							taiNguyen2VaiTro.setNguoiTao(emailAddress);
							taiNguyen2VaiTro.setDaXoa(Constants.ACTIVE);
							taiNguyen2VaiTro.setNgayTao(today);
							QuanLyVaiTroBusiness.saveTaiNguyen2VaiTro(taiNguyen2VaiTro);				
						}
					}
				}				
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "errorAddOrUpdate");
		}
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/quanlyvaitro/quan_ly_vai_tro_add.jsp");

	}

	/**
	 * This is function validationVaiTroInput
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param vaiTroId
	 * @param ten 
	 * @param ma
	 * @param ungDungId
	 * @param trangThai
	 * @param actionRequest
	 * @throws Exception
	 * @return boolean
	 */
	private boolean validationVaiTroInput(String vaiTroId, String ten, String ma, String ungDungId, String trangThai, ActionRequest actionRequest) throws Exception {
		
		if (Helpers.isEmpty(ten)) {
			SessionErrors.add(actionRequest, "emptyTen");
		}
		if (Helpers.isEmpty(ma)) {
			SessionErrors.add(actionRequest, "emptyMa");
		} else {
			if (QuanLyVaiTroBusiness.checkExistingVaiTro(vaiTroId, ma)) {
				SessionErrors.add(actionRequest, "existMa");
			}
		}
		if (Helpers.isEmpty(ungDungId)) {
			SessionErrors.add(actionRequest, "emptyUngDungId");
		}
		if (Helpers.isEmpty(trangThai)) {
			SessionErrors.add(actionRequest, "emptyTrangThai");
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
	
	/**
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
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
	 * This is function setSearchParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portletURL
	 * @param renderRequest
	 * @throws Exception
	 */
	public void setSearchParameter(PortletURL portletURL, RenderRequest renderRequest) {
	
		String cur = ParamUtil.getString(renderRequest, "cur");
		String delta = ParamUtil.getString(renderRequest, "delta");
		
		PortletPreferences prefs = null;

		if (renderRequest != null) {
			prefs = renderRequest.getPreferences();
			if (prefs != null) {
				cur = prefs.getValue("curCC", cur);
				delta = prefs.getValue("deltaCC", delta);
			}
		}
		portletURL.setParameter("cur", cur);
		portletURL.setParameter("delta", delta);
	}
}
