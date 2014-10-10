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

package org.oep.cmon.czprofile.portlet.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.oep.cmon.admin.portlet.business.TaiKhoanNguoiDungBusiness;
import org.oep.cmon.admin.portlet.util.EncryptionUtil;
import org.oep.cmon.portlet.ipmslist.utils.ConvertUtil;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.CongChucLocalServiceUtil;
import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class implementation class CitizenProfileActionPortlet  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenProfileActionPortlet extends MVCPortlet {
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	// updated by thanhdd15/07/2014
	
	//add by duongpt
	//2014-08-01
	private Log _log = LogFactoryUtil.getLog(CitizenProfileActionPortlet.class);
	
	/**
	 * This is  function change password
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
	public void changePassword(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		actionRequest.getPortletSession().setAttribute("change_pass", "tab.czprofile.changepass");
		
//		String oldPassword = ParamUtil.getString(actionRequest, "oldPassword").trim();
//		userRequest.put("oldPassword", oldPassword);
//		
		String newPassword = ParamUtil.getString(actionRequest, "newPassword").trim();
		userRequest.put("newPassword", newPassword);
		
		String confirmPassword = ParamUtil.getString(actionRequest, "confirmPassword").trim();
		userRequest.put("confirmPassword", confirmPassword);
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");

		if ( currentUser == null) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.notLogin");
			actionResponse.sendRedirect(redirectUrl);
			
			return;			
		}		
		
		// Validate params
		
		// Old password
//		if (Validator.isNull(oldPassword)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.oldPassword");
//		}
		
		// New password
		if (Validator.isNull(newPassword)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.newPassword");
		}
		
		// Confirm password
		if (Validator.isNull(confirmPassword)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.confirmPassword");
		}
		
		// New pass and confirm pass
		if (!newPassword.equals(confirmPassword)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.oldPassAndNewPass");
		}
		
		// Check new password and old password
		long userId = currentUser.getUserId();
		
		// Get tai khoan nguoi dung from liferay
		TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTaiKhoanNguoiDungId(userId);
		
		// Get the old password
		String oldDbPassword = taiKhoan.getMatKhau();
//		
		String newEncryptPassword = EncryptionUtil.encrypt(newPassword);
//		
		if ( oldDbPassword.equals(newEncryptPassword)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.newPassSameOldPass");
		}
				
		// Check old password correct or not
		
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
//		TaiKhoanNguoiDungBusiness taiKhoanNguoiDungBs = new TaiKhoanNguoiDungBusiness();

		// Create user on LDAP server
//		if ( ! taiKhoanNguoiDungBs.createUserOnLDAP(taiKhoan.getEmail(), newPassword, taiKhoan.getTenNguoiDung())) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.ldap");
//
//			actionResponse.sendRedirect(redirectUrl);		
//			
//			return;		
//		}		
			
		// Update portal user password
		UserLocalServiceUtil.updatePassword(userId, newPassword, newPassword, false);
		
		// Update tai khoan nguoi dung
		taiKhoan.setMatKhau(newEncryptPassword);
		
		TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoan);
		
		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
		
		// Redirect
		SessionMessages.add(actionRequest, "success");
		
		actionResponse.sendRedirect(redirectUrl);		
	}

	// added by phucnv 2014/03/12
	// updated by thanhdd15/07/2014
	/**
	 * This is  function update detail
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
	public void updateDetail(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		Map<String, String> userRequest = (Map<String, String>) actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");

		// Get all parameters from request
		String id = ParamUtil.getString(actionRequest, "id").trim();
		if (Validator.isNotNull(id)) {
			userRequest.put("id", id);
		}

		/*String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);*/
		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd").trim();
		if ( Validator.isNotNull(noiCapCmnd)) {
			userRequest.put("IDNOICAPCMND", noiCapCmnd);
		}
		/*String ghiChuCmnd = ParamUtil.getString(actionRequest, "ghiChuCmnd").trim();
		userRequest.put("GHICHUCMND", ghiChuCmnd);*/

		String ngayHetHanHoChieuStr = ParamUtil.getString(actionRequest, "ngayHetHanHoChieu");
		
		userRequest.put("NGAYHETHANHOCHIEU", ngayHetHanHoChieuStr);
		/*
		String ghiChuHoChieu = ParamUtil.getString(actionRequest, "ghiChuHoChieu").trim();
		userRequest.put("GHICHUHOCHIEU", ghiChuHoChieu);
		*/
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String trinhDoHocVan = ParamUtil.getString(actionRequest, "trinhDoHocVan");
		if ( Validator.isNotNull(trinhDoHocVan)) {
			userRequest.put("IDTRINHDOHOCVAN", trinhDoHocVan);
		}
		
		String soBhyt = ParamUtil.getString(actionRequest, "soBhyt").trim();
		userRequest.put("SOBAOHIEMYTE", soBhyt);
		
		String tinhTrangHonNhan = ParamUtil.getString(actionRequest, "tinhTrangHonNhan");
		if ( Validator.isNotNull(tinhTrangHonNhan)) {
			userRequest.put("IDTINHTRANGHONNHAN", tinhTrangHonNhan);
		}
		
		String motaDiachiHienTai = ParamUtil.getString(actionRequest, "motaDiachiHienTai").trim();
		userRequest.put("MOTADIACHIHIENTAI", motaDiachiHienTai);		

		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
		
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		// validate data
		// Check noi cap cmnd
		if (Validator.isNull(noiCapCmnd)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.noiCapCmnd");
		}

		// Check gioi tinh
		if (Validator.isNull(gioiTinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.gioiTinh");
		}
		
		// Check tinh trang hon nhan
		if (Validator.isNull(tinhTrangHonNhan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhTrangHonNhan");
		}

		// Check mo ta dia chi hien tai
//		if (Validator.isNull(motaDiachiHienTai)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaDiachiHienTai");
//		}		

		// Validate ngayHetHanHoChieu
		Date ngayHetHanHoChieu = null;
		if (ngayHetHanHoChieuStr != null && !"".equals(ngayHetHanHoChieuStr)) {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			
			df.setLenient(false);
			try {
				ngayHetHanHoChieu = df.parse(ngayHetHanHoChieuStr);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngayHetHanHoChieu.notValid");
			}
		}

		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		
		User currentUser = PortalUtil.getUser(actionRequest);
		if (currentUser == null) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.notLogin");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}

		CongDan citizen = CongDanLocalServiceUtil.fetchCongDan(Long.parseLong(id));
		if (citizen == null) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.notExist");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}

		// Update citizen
		citizen.setTrinhDoHocVanId(Long.parseLong(trinhDoHocVan));
		citizen.setTinhTrangHonNhanId(Long.parseLong(tinhTrangHonNhan));
		citizen.setNoiCapCmndId(Long.parseLong(noiCapCmnd));
		citizen.setGioiTinh(Integer.parseInt(gioiTinh));
		citizen.setDiaChiHienNay(motaDiachiHienTai);
		citizen.setNgayHetHanHoChieu(ngayHetHanHoChieu);
		citizen.setSoBaoHiemYTe(soBhyt);
		
		CongDanLocalServiceUtil.updateCongDan(citizen);

		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");

		// Redirect
		SessionMessages.add(actionRequest, "success");
		actionResponse.sendRedirect(redirectUrl);
	}
	// end adding by phucnv 2014/03/12
	
	//Add by Duongpt 2014-08-01
	//Update Thong tin Cong Chuc
	/**
	 * This is  function update CongChuc detail
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
	public void updateCongChucDetail(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		Map<String, String> userRequest = (Map<String, String>) actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");

		// Get all parameters from request
		String id = ParamUtil.getString(actionRequest, "id").trim();
		_log.info("======= cong dan Id = " + String.valueOf(id));
		if (Validator.isNotNull(id)) {
			userRequest.put("id", id);
		}
		
		String tenDaydu = ParamUtil.getString(actionRequest, "tenDaydu").trim();
		_log.info("======= tenDaydu = " + tenDaydu);
		if ( Validator.isNotNull(tenDaydu)) {
			userRequest.put("tenDaydu", tenDaydu);
		}
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");		
		_log.info("======= ngaySinh = " + ngaySinh);
		userRequest.put("ngaySinh", ngaySinh);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		_log.info("======= gioiTinh = " + String.valueOf(gioiTinh));
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("gioiTinh", gioiTinh);
		}
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		_log.info("======= soCmnd = " + soCmnd);
		if ( Validator.isNotNull(tenDaydu)) {
			userRequest.put("soCmnd", soCmnd);
		}

		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd");		
		_log.info("======= ngayCapCmnd = " + String.valueOf(ngayCapCmnd));
		userRequest.put("ngayCapCmnd", ngayCapCmnd);		

		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd").trim();
		_log.info("======= noiCapCmnd = " + String.valueOf(noiCapCmnd));
		if ( Validator.isNotNull(noiCapCmnd)) {
			userRequest.put("noiCapCmnd", noiCapCmnd);
		}
			
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
		
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		boolean isValid=validationInput(tenDaydu, ngaySinh, soCmnd, ngayCapCmnd, noiCapCmnd, actionRequest);

		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if (!isValid && !SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		
		User currentUser = PortalUtil.getUser(actionRequest);
		if (currentUser == null) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.notLogin");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}

		CongChuc congChuc = CongChucLocalServiceUtil.getCongChuc(Long.parseLong(id));
		_log.info("======= congChuc info = " + congChuc);
		if (congChuc == null) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.input.err.notExist");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}

		// Update cong chuc;
		congChuc.setHoVaTen(tenDaydu);	
		//congChuc.setNoiCapCmndId(Long.parseLong(noiCapCmnd));
		congChuc.setNgaySinh(ConvertUtil.parseStringToDate(ngaySinh));
		congChuc.setGioiTinhId(Integer.parseInt(gioiTinh));
		congChuc.setSoCmnd(soCmnd);
		congChuc.setNgayCapCmnd(ConvertUtil.parseStringToDate(ngayCapCmnd));
		congChuc.setNoiCapCmnd(noiCapCmnd);
		
		
		_log.info("======= congChuc info update: = " + congChuc);
		
		CongChucLocalServiceUtil.updateCongChuc(congChuc);

		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");

		// Redirect
		SessionMessages.add(actionRequest, "success");
		actionResponse.sendRedirect(redirectUrl);
	}
	// end adding by duongpt 2014/08/01
	
	//adding by duongpt 2014-08-04
	//Validate Parameters
	/**
	 * This is  function validation input
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param tenDaydu
	 * @param ngaySinh
	 * @param soCmnd
	 * @param ngayCapCmnd
	 * @param noiCapCmnd
	 * @param actionRequest
	 */
	private boolean validationInput(String tenDaydu, String ngaySinh, String  soCmnd, 
			String ngayCapCmnd, String noiCapCmnd, ActionRequest actionRequest)
	{
		// validate data
		// Check Ho va ten
		if (Validator.isNull(tenDaydu)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.ten.empty");
		}
		
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.ngaysinh.empty");
		}
		
		// Validate ngaySinh
		Date ngaySinhDt = null;
		if (ngaySinh != null && !"".equals(ngaySinh)) {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			
			df.setLenient(false);
			try {
				ngaySinhDt = df.parse(ngaySinh);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.ngaysinh.invalid");
			}
		}
		soCmnd = soCmnd.trim();
		//String strLeng=String.valueOf(soCmnd.length());
	
		// Check So cmnd
		if (Validator.isNull(soCmnd)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.socmnd.empty");
		}
		if((soCmnd.length()<9)||(soCmnd.length()>12))
		{
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.socmnd.invalid");
		}
		if (Validator.isNull(ngayCapCmnd)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.ngaycap.empty");
		}
		// Validate ngayCCmapnd
		Date ngayCapCmndDt = null;
		if (ngayCapCmnd != null && !"".equals(ngayCapCmnd)) {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			
			df.setLenient(false);
			try {
				ngayCapCmndDt = df.parse(ngayCapCmnd);
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.ngaycap.invalid");
			}
		}
		
		// Check noi cap cmnd
		if (Validator.isNull(noiCapCmnd)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.czprofile.form.canbo.input.noicap.empty");
		}
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}

		return false;
	}
}
