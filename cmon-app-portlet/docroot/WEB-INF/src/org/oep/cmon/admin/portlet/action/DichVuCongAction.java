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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;
import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLyClp;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinhClp;

import org.oep.cmon.dao.dvc.service.TTHC2CoQuanQuanLyLocalServiceUtil;
import org.oep.cmon.dao.dvc.service.ThuTucHanhChinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * This is class DichVuCongAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DichVuCongAction {
	
	/**
	 * This is function add DichVuCong
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
		// Get the  required parameters
		
		@SuppressWarnings("unchecked")
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_DVC_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
			
		String ma = ParamUtil.getString(actionRequest, "ma");
		userRequest.put("ma", ma);
		
		String ten = ParamUtil.getString(actionRequest, "ten");
		userRequest.put("ten", ten);
		
		String groupId = ParamUtil.getString(actionRequest, "groupId");
		userRequest.put("groupId", groupId);		

		
		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy");
		userRequest.put("coQuanQuanLy", coQuanQuanLy);
				
		// Check login name
		if (Validator.isNull(ma)) {
			SessionErrors.add(actionRequest, "err.ma");
		}
		
		// Check full name
		if (Validator.isNull(ten)) {
			SessionErrors.add(actionRequest, "err.ten");
		}
		
		// Check password
		if (Validator.isNull(groupId)) {
			SessionErrors.add(actionRequest, "err.groupId");
		}
		
		// Check email
		if (Validator.isNull(coQuanQuanLy)) {
			SessionErrors.add(actionRequest, "err.coQuanQuanLy");
		}		
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Process the data here
		String coQuanId = coQuanQuanLy.substring(0, coQuanQuanLy.indexOf("-"));		
		
		// Insert thu tuc hanh chinh to DB
		ThuTucHanhChinh thuTuc = new ThuTucHanhChinhClp();
		
		thuTuc.setId(CounterLocalServiceUtil.increment("cmon_thutuchanhchinh"));
		
		thuTuc.setMa(ma);
		
		thuTuc.setTen(ten);
		
		thuTuc.setSoNgayXuLy(10);
		
		thuTuc.setTrangThai(1);
		
		thuTuc.setPhienBan(1);
		
		thuTuc.setNhomThuTucHanhChinhId(Long.parseLong(groupId));
		
		Date currentDate = new Date();
		
		thuTuc.setNgayTao(currentDate);
		
		thuTuc.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		if ( currentUser != null) {		
			thuTuc.setNguoiTao(currentUser.getFullName());
			thuTuc.setNguoiSua(currentUser.getFullName());			
		} else {
			// This is for test without logging in
			thuTuc.setNguoiTao("DUMMY");
			thuTuc.setNguoiSua("DUMMY");	
		}
		
		
		thuTuc.setDaXoa(0);
		
		ThuTucHanhChinhLocalServiceUtil.addThuTucHanhChinh(thuTuc);
		
		// Assign dich vu to co quan quan ly
		this.assignDichVuToCoQuanQuanLy(thuTuc.getId(), Long.parseLong(coQuanId), actionRequest);
				
		//Redirect
		userRequest.put("ma", "");
		
		userRequest.put("ten", "");
		
		SessionMessages.add(actionRequest, "success");
		
		actionResponse.sendRedirect(redirectUrl);		
	}
	
	/**
	 * This is function add DichVuCong Only
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
		@SuppressWarnings("unchecked")
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_DVC_ONLY_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
			
		String ma = ParamUtil.getString(actionRequest, "ma");
		userRequest.put("ma", ma);
		
		String ten = ParamUtil.getString(actionRequest, "ten");
		userRequest.put("ten", ten);
		
		String groupId = ParamUtil.getString(actionRequest, "groupId");
		userRequest.put("groupId", groupId);
		
		// Check login name
		if (Validator.isNull(ma)) {
			SessionErrors.add(actionRequest, "err.ma");
		}
		
		// Check full name
		if (Validator.isNull(ten)) {
			SessionErrors.add(actionRequest, "err.ten");
		}
		
		// Check password
		if (Validator.isNull(groupId)) {
			SessionErrors.add(actionRequest, "err.groupId");
		}		
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Insert thu tuc hanh chinh to DB
		ThuTucHanhChinh thuTuc = new ThuTucHanhChinhClp();
		
		thuTuc.setId(CounterLocalServiceUtil.increment("cmon_thutuchanhchinh"));
		
		thuTuc.setMa(ma);
		
		thuTuc.setTen(ten);
		
		thuTuc.setSoNgayXuLy(10);
		
		thuTuc.setTrangThai(1);
		
		thuTuc.setPhienBan(1);
		
		thuTuc.setNhomThuTucHanhChinhId(Long.parseLong(groupId));
		
		Date currentDate = new Date();
		
		thuTuc.setNgayTao(currentDate);
		
		thuTuc.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		if ( currentUser != null) {		
			thuTuc.setNguoiTao(currentUser.getFullName());
			thuTuc.setNguoiSua(currentUser.getFullName());			
		} else {
			// This is for test without logging in
			thuTuc.setNguoiTao("DUMMY");
			thuTuc.setNguoiSua("DUMMY");	
		}
		
		
		thuTuc.setDaXoa(0);
		
		ThuTucHanhChinhLocalServiceUtil.addThuTucHanhChinh(thuTuc);
			
		//Redirect
		userRequest.put("ma", "");
		
		userRequest.put("ten", "");
		
		SessionMessages.add(actionRequest, "success");
		
		actionResponse.sendRedirect(redirectUrl);	
	}
	
	/**
	 * This is function assign to DichVuCong 
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
		@SuppressWarnings("unchecked")
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_DVC_DONVI_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
			
		String ma = ParamUtil.getString(actionRequest, "ma");
		userRequest.put("ma", ma);
	
		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy");
		userRequest.put("coQuanQuanLy", coQuanQuanLy);
				
		// Check login name
		if (Validator.isNull(ma)) {
			SessionErrors.add(actionRequest, "err.ma");
		}
		
		// Check co quan quan ly
		if (Validator.isNull(coQuanQuanLy)) {
			SessionErrors.add(actionRequest, "err.coQuanQuanLy");
		}		
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Extrach co quan quan ly id
		String coQuanId = coQuanQuanLy.substring(0, coQuanQuanLy.indexOf("-"));
		
		// Split array of dich vu cong
		String[] maDvcArray = ma.split(",");
		
		List<String> errList = new ArrayList<String>();
		
		// Check the existence of dich vu cong
		for(String maDichVu:maDvcArray) {
			// Delete the existence relation first
			ThuTucHanhChinh thuTuc = ThuTucHanhChinhLocalServiceUtil.getThuTucHanhChinhBoiMa(maDichVu);
			
			if ( thuTuc == null) {
				errList.add(maDichVu);
				
				continue;
			}
			
			// Insert to DB
			this.assignDichVuToCoQuanQuanLy(thuTuc.getId(), Long.parseLong(coQuanId), actionRequest);			
		}
		
		if ( errList.size() > 0) {
		
			actionRequest.getPortletSession().setAttribute("MA_DICH_VU_ERR", errList);
		} else {
			actionRequest.getPortletSession().removeAttribute("MA_DICH_VU_ERR");
		}
		
		// Redirect
		SessionMessages.add(actionRequest, "success");
		
		actionResponse.sendRedirect(redirectUrl);
	}
	
	/**
	 * This is function assign DichVuToCoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param idDichVu
	 * @param idCoQuan
	 * @param request
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void assignDichVuToCoQuanQuanLy(long idDichVu, long idCoQuan, ActionRequest request) throws SystemException, PortalException {
		
		List<TTHC2CoQuanQuanLy> lst = TTHC2CoQuanQuanLyLocalServiceUtil.findByCoQuanAndThuTuc(idCoQuan, idDichVu);
		
		// Ignore if dich vu cong was already deployed at this don vi tiep nhan
		if (lst.size() > 0) {
			return;
		}
		
		// Deploy thu tuc at co quan quan ly
		TTHC2CoQuanQuanLy deploy = new TTHC2CoQuanQuanLyClp();
		
		deploy.setId(CounterLocalServiceUtil.increment("cmon_tthc2coquanquanly"));
		
		deploy.setCoQuanQuanLyId(idCoQuan);
		
		deploy.setSoNgayXyLy(10); // Temporarily
		
		deploy.setThuTucHanhChinhId(idDichVu);
		
		deploy.setTrangThai(1);
		
		Date currentDate = new Date();
		
		deploy.setNgayTao(currentDate);
		
		deploy.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			deploy.setNguoiTao(currentUser.getFullName());
			deploy.setNguoiSua(currentUser.getFullName());			
		} else {
			// This is for test without logging in
			deploy.setNguoiTao("DUMMY");
			deploy.setNguoiSua("DUMMY");	
		}		
		
		deploy.setDaXoa(0);
		
		TTHC2CoQuanQuanLyLocalServiceUtil.addTTHC2CoQuanQuanLy(deploy);
	}
}
