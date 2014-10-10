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

package org.oep.cmon.userreg.portlet.action;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.oep.cmon.portlet.document.util.FormatUtil;
import org.oep.cmon.portlet.taocongdan.action.TaoCongDanAction;
import org.oep.cmon.userreg.portlet.mail.AccountCreationRequestMail;
import org.oep.cmon.userreg.portlet.mail.CitizenCreationRequestMail;
import org.oep.cmon.userreg.portlet.util.AuthenticateCodeUtil;
import org.oep.cmon.userreg.portlet.util.CheckCaptchaUtil;
import org.oep.cmon.userreg.portlet.util.ScaleImageUtil;
import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDanClp;
import org.oep.cmon.dao.csms.service.YeuCauDangKyCongDanLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/** 
 * This is class UserRegActionPortlet
 * 
 * This class contains all logics related to user registation
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Nam Dinh    Create new
 */
public class UserRegActionPortlet extends MVCPortlet {
	/** Birth date format */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/** Key to generate id on csms_yeucaudangkycongdan table */
	private static final String CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE = "CSMS_YEUCAUDANGKYCONGDAN";
	
	/** Only request for account */
	private static final int ACCOUNT_ONLY_TYPE = 1;
	
	/** Request for both account and citizen information type */
	private static final int ACCOUNT_AND_CITIZEN_TYPE = 0;
	
	private static Log _log = LogFactoryUtil.getLog(TaoCongDanAction.class);
	
	/**
	 * This is function server resource
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
            ResourceResponse resourceResponse) throws IOException, PortletException {
		// Get resource id
		String resourceId = resourceRequest.getResourceID();
		
		// Generate captcha image and return to client
		if ("captcha".equals(resourceId)) {
			try {
				CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			} catch (Exception e) {            
				e.printStackTrace();
			}
			
			return;
		}
		
		// Process Jason feed
		JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
		if ( "fetchDonViHanhChinh".equals(resourceId) ) {		
			// Get country code from URL
			long parentId = ParamUtil.getInteger(resourceRequest, "parentId");
			
			// Create Jason array o bject
			JSONArray donViHanhChinhArray = JSONFactoryUtil.getJSONFactory().createJSONArray();	
			
			// Query all sub don vi hanh chinh using parent id
			List<DonViHanhChinh> donviHanhChinhList = null;

			donviHanhChinhList = DonViHanhChinhLocalServiceUtil.findByChaId(parentId,Constants.ACTIVATED);			

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
	 * This is function input basic information
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void inputBasic(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException, ParseException {
		// Get the object from session
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		// Get all parameters from request
		String hoCongDan = ParamUtil.getString(actionRequest, "ho").trim().toUpperCase();
		userRequest.put("HOCONGDAN", hoCongDan);
		
		String tenDem = ParamUtil.getString(actionRequest, "dem").trim().toUpperCase();
		userRequest.put("TENDEM", tenDem);		
		
		String tenCongDan = ParamUtil.getString(actionRequest, "ten").trim().toUpperCase();
		userRequest.put("TENCONGDAN", tenCongDan);
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("SOCMND", soCmnd);			
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("EMAIL", email);		
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		userRequest.put("NGAYSINH", ngaySinh);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String danToc = ParamUtil.getString(actionRequest, "danToc");
		if ( Validator.isNotNull(danToc)) {
			userRequest.put("IDDANTOC", danToc);
		}
		
		String tonGiao = ParamUtil.getString(actionRequest, "tonGiao");
		if ( Validator.isNotNull(tonGiao)) {
			userRequest.put("IDTONGIAO", tonGiao);
		}
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		if ( Validator.isNotNull(tinhThuongTru)) {
			userRequest.put("IDTINHTHANHTHUONGTRU", tinhThuongTru);
		}
		
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		if ( Validator.isNotNull(huyenThuongTru)) {
			userRequest.put("IDQUANHUYENTHUONGTRU", huyenThuongTru);
		}
		
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		if ( Validator.isNotNull(xaThuongTru)) {
			userRequest.put("IDPHUONGXATHUONGTRU", xaThuongTru);
		}
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		userRequest.put("MOTADIACHITHUONGTRU", motaThuongTru);
		
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);

		// BinhNT add 2013-12-22 
		String reloadcapchar = ParamUtil.getString(actionRequest, "reloadcapchar").trim();
		if (reloadcapchar.trim().compareTo("reloadcapchar") == 0) {
			String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		// End BinhNT Add 2013-12-22
		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
		}
		
		// Check Ho cong dan
		if (Validator.isNull(hoCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
		}
		
		// Check ten cong dan
		if (Validator.isNull(tenCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
		}
		
		// Check so cmnd
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
		}
		
		if (soCmnd.trim().length() <9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
		}
				
		// Check email
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
		}		
		
		// Check ngay sinh
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
		}
		
		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");

		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Validate data against DB
		
		// Validate birth date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
		}
		
//		// Check if in DB, there's already user request that not processed yet	
//		if (this.requestExists(soCmnd)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
//		}
		
		List<CongDan> congDan = CongDanLocalServiceUtil.findByEmail(email);
		if (congDan.size() > 0){
			if (this.cmndExists(soCmnd)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
			}
			// Check email if exists in CSMS cong dan
			if ( this.emailExistsInCongDan(email)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			}
		}
		
		
		
		if ( !SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
		
		// Check if citizen exists or not
		//String maCongDan = this.citizenExists(hoCongDan, tenDem, tenCongDan, soCmnd, ngaySinh);
		String maCongDan = this.congdanExists(soCmnd, ngaySinh);
		_log.info("ma cong dan:" +maCongDan);
		if ( Validator.isNull(maCongDan)) {
			_log.info("chua co thong tin trong csms_congdan");
			// Redirect to input detail confirm
			String inputDetailDialogUrl = ParamUtil.getString(actionRequest, "inputDetailDialogUrl");
			
			PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
			SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			
			actionResponse.sendRedirect(inputDetailDialogUrl);
			
			return;
		}
		
		else {
			CongDan congDan1 = CongDanLocalServiceUtil.findByMa(maCongDan);
			_log.info("congDan1: "+congDan1);
			
			// Check email if exists in CSMS cong dan
			if ( congDan1.getEmail().length() >0) {
				_log.info("da co tai khoan csms_congdan");
				String accountExistDialog = ParamUtil.getString(actionRequest, "accountExistDialog");
				
				PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.sendRedirect(accountExistDialog);
				return;
			} else {
				_log.info("chua co tai khoan trong csms_congdan");
				String inputDetailDialogUrlExistInCongDan = ParamUtil.getString(actionRequest, "inputDetailDialogUrlExistInCongDan");
				
				PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
				SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				actionResponse.sendRedirect(inputDetailDialogUrlExistInCongDan);
				return;

			}		
			
		}
		
		// Generate authentication code
//		String authCode = AuthenticateCodeUtil.generateAuthCode();
//		
//		// Insert data to yeu cau dang ky cong dan	
//		this.createAccountRequest(maCongDan, authCode, userRequest, actionRequest);
//		
//		String accountCreationUrl = ParamUtil.getString(actionRequest, "accountCreationUrl");
//		
//		accountCreationUrl = accountCreationUrl.replace("DUMMY_AUTH_CODE", authCode);
//		
//		// Send email here
//		this.sendAccountConfirmationEmail(hoCongDan, tenDem, tenCongDan, accountCreationUrl, email);
//		
//		// Redirect to success page	
//		String accountRegisterSuccessUrl = ParamUtil.getString(actionRequest, "accountRegisterSuccessUrl");
//		
//		// Remove object in session
//		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
//		
//		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
//		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
//		
//		// Redirect to account register success page
//		actionResponse.sendRedirect(accountRegisterSuccessUrl);
	}
		
	/**
	 * This is function input detail information about cong dan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 */
	public void inputDetail(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException, ParseException {
		// Get the object from session
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_OBJECT");
		
		// Get all parameters from request
		String hoCongDan = ParamUtil.getString(actionRequest, "ho").trim().toUpperCase();
		userRequest.put("HOCONGDAN", hoCongDan);
		
		String tenDem = ParamUtil.getString(actionRequest, "dem").trim().toUpperCase();
		userRequest.put("TENDEM", tenDem);		
		
		String tenCongDan = ParamUtil.getString(actionRequest, "ten").trim().toUpperCase();
		userRequest.put("TENCONGDAN", tenCongDan);
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		userRequest.put("SOCMND", soCmnd);
		
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		userRequest.put("NGAYCAPCMND", ngayCapCmnd);
		
		String noiCapCmnd = ParamUtil.getString(actionRequest, "noiCapCmnd").trim();
		if ( Validator.isNotNull(noiCapCmnd)) {
			userRequest.put("IDNOICAPCMND", noiCapCmnd);
		}
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("EMAIL", email);
		
//		String soHoChieu = ParamUtil.getString(actionRequest, "soHoChieu").trim();
//		userRequest.put("SOHOCHIEU", soHoChieu);
//		
//		String ngayCapHoChieu = ParamUtil.getString(actionRequest, "ngayCapHoChieu");
//		userRequest.put("NGAYCAPHOCHIEU", ngayCapHoChieu);
//		
//		String noiCapHoChieu = ParamUtil.getString(actionRequest, "noiCapHoChieu").trim();
//		// If the data is not submitted from client, keep the original value from the object in session
//		if ( Validator.isNotNull(noiCapHoChieu)) {
//			userRequest.put("IDNOICAPHOCHIEU", noiCapHoChieu);
//		}
//		
//		String ngayHetHanHoChieu = ParamUtil.getString(actionRequest, "ngayHetHanHoChieu");
//		userRequest.put("NGAYHETHANHOCHIEU", ngayHetHanHoChieu);
//		
//		String ghiChuHoChieu = ParamUtil.getString(actionRequest, "ghiChuHoChieu").trim();
//		userRequest.put("GHICHUHOCHIEU", ghiChuHoChieu);
		
		String gioiTinh = ParamUtil.getString(actionRequest, "gioiTinh");
		if ( Validator.isNotNull(gioiTinh)) {
			userRequest.put("IDGIOITINH", gioiTinh);
		}
		
		String danToc = ParamUtil.getString(actionRequest, "danToc");
		if ( Validator.isNotNull(danToc)) {
			userRequest.put("IDDANTOC", danToc);
		}
		
		String tonGiao = ParamUtil.getString(actionRequest, "tonGiao");
		if ( Validator.isNotNull(tonGiao)) {
			userRequest.put("IDTONGIAO", tonGiao);
		}
		
		String quocTich = ParamUtil.getString(actionRequest, "quocTich");
		if ( Validator.isNotNull(quocTich)) {
			userRequest.put("IDQUOCTICH", String.valueOf(org.oep.cmon.Constants.VIETNAM));
		}
		
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh");
		userRequest.put("NGAYSINH", ngaySinh);
		
//		String dtCoDinh = ParamUtil.getString(actionRequest, "dtCoDinh").trim();
//		userRequest.put("DIENTHOAICODINH", dtCoDinh);
//		
//		String dtDiDong = ParamUtil.getString(actionRequest, "dtDiDong").trim();
//		userRequest.put("DIENTHOAIDIDONG", dtDiDong);
//		
//		String trinhDoHocVan = ParamUtil.getString(actionRequest, "trinhDoHocVan");
//		if ( Validator.isNotNull(trinhDoHocVan)) {
//			userRequest.put("IDTRINHDOHOCVAN", trinhDoHocVan);
//		}
//		
//		String soBhyt = ParamUtil.getString(actionRequest, "soBhyt").trim();
//		userRequest.put("SOBAOHIEMYTE", soBhyt);
//		
//		String ngheNghiep = ParamUtil.getString(actionRequest, "ngheNghiep");
//		if ( Validator.isNotNull(ngheNghiep)) {
//			userRequest.put("IDNGHENGHIEP", ngheNghiep);
//		}
//		
//		String trinhDoChuyenMon = ParamUtil.getString(actionRequest, "trinhDoChuyenMon");
//		if ( Validator.isNotNull(trinhDoChuyenMon)) {
//			userRequest.put("IDTRINHDOCHUYENMON", trinhDoChuyenMon);
//		}
//		
//		String tinhTrangHonNhan = ParamUtil.getString(actionRequest, "tinhTrangHonNhan");
//		if ( Validator.isNotNull(tinhTrangHonNhan)) {
//			userRequest.put("IDTINHTRANGHONNHAN", tinhTrangHonNhan);
//		}
		
//		String tinhNoiSinh = ParamUtil.getString(actionRequest, "tinhNoiSinh");
//		if ( Validator.isNotNull(tinhNoiSinh)) {
//			userRequest.put("IDTINHTHANHNOISINH", tinhNoiSinh);
//		}
//		
//		String huyenNoiSinh = ParamUtil.getString(actionRequest, "huyenNoiSinh");
//		if ( Validator.isNotNull(huyenNoiSinh)) {
//			userRequest.put("IDQUANHUYENNOISINH", huyenNoiSinh);
//		}
//		
//		String xaNoiSinh = ParamUtil.getString(actionRequest, "xaNoiSinh");
//		if ( Validator.isNotNull(xaNoiSinh)) {
//			userRequest.put("IDPHUONGXANOISINH", xaNoiSinh);
//		}
//		
//		String motaNoisinh = ParamUtil.getString(actionRequest, "motaNoisinh").trim();
//		userRequest.put("MOTADIACHINOISINH", motaNoisinh);
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		if ( Validator.isNotNull(tinhThuongTru)) {
			userRequest.put("IDTINHTHANHTHUONGTRU", tinhThuongTru);
		}
		
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		if ( Validator.isNotNull(huyenThuongTru)) {
			userRequest.put("IDQUANHUYENTHUONGTRU", huyenThuongTru);
		}
		
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		if ( Validator.isNotNull(xaThuongTru)) {
			userRequest.put("IDPHUONGXATHUONGTRU", xaThuongTru);
		}
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		userRequest.put("MOTADIACHITHUONGTRU", motaThuongTru);
//		
//		String tinhHienTai = ParamUtil.getString(actionRequest, "tinhHienTai");
//		if ( Validator.isNotNull(tinhHienTai)) {
//			userRequest.put("IDTINHTHANHHIENTAI", tinhHienTai);
//		}
//		
//		String huyenHienTai = ParamUtil.getString(actionRequest, "huyenHienTai");
//		if ( Validator.isNotNull(huyenHienTai)) {
//			userRequest.put("IDQUANHUYENHIENTAI", huyenHienTai);
//		}
//		
//		String xaHienTai = ParamUtil.getString(actionRequest, "xaHienTai");
//		if ( Validator.isNotNull(xaHienTai)) {
//			userRequest.put("IDPHUONGXAHIENTAI", xaHienTai);
//		}
		
//		String motaDiachiHienTai = ParamUtil.getString(actionRequest, "motaDiachiHienTai").trim();
//		userRequest.put("MOTADIACHIHIENTAI", motaDiachiHienTai);		
//		
//		String soHoKhau = ParamUtil.getString(actionRequest, "soHoKhau").trim();
//		userRequest.put("SOHOKHAU", soHoKhau);
//		
//		String chuHo = ParamUtil.getString(actionRequest, "chuHo");
//		userRequest.put("CHUHO", chuHo);
//		
//		String mstCaNhan =  ParamUtil.getString(actionRequest, "mstCaNhan").trim();
//		userRequest.put("MASOTHUECANHAN", mstCaNhan);				
//		
//		String quanHeChuHo = ParamUtil.getString(actionRequest, "quanHeChuHo");
//		if ( Validator.isNotNull(quanHeChuHo)) {
//			userRequest.put("IDQUANHE", quanHeChuHo);	
//		}

		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_OBJECT", userRequest);
		
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		
		// BinhNT add 2013-12-22 
		String reloadcapchar = ParamUtil.getString(actionRequest, "reloadcapchar").trim();
		if (reloadcapchar.trim().compareTo("reloadcapchar") == 0) {
			
			String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
			actionResponse.sendRedirect(redirectUrl);
			return;
		}
//		// End BinhNT Add 2013-12-22
		
		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
		}
		
		// Check Ho cong dan
		if (Validator.isNull(hoCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
		}
		
		// Check ten cong dan
		if (Validator.isNull(tenCongDan)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
		}
		
		// Check so cmnd
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
		}
		
		// Check ngay cap CMND
		if (Validator.isNull(ngayCapCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngayCapCmnd");
		}
		
		long noiCapCmnd1 = ParamUtil.getLong(actionRequest, "noiCapCmnd");
		// Check noi cap cmnd
		if (noiCapCmnd1 == 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.noiCapCmnd");
		}
		
		// Check email
//		if (Validator.isNull(email)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
//		}		
		
		if (soCmnd.trim().length() < 9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
		}
				
		// Check email
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
		}		
		
		// Check gioi tinh
		if (Validator.isNull(gioiTinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.gioiTinh");
		}
		
		// Check dan toc
//		if (Validator.isNull(danToc)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.danToc");
//		}
//		
//		// Check ton giao
//		if (Validator.isNull(tonGiao)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tonGiao");
//		}
//		
//		// Check quoc tich
//		if (Validator.isNull(quocTich)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.quocTich");
//		}
//		
		// Check ngay sinh
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
		}
		
		// Check tinh trang hon nhan
//		if (Validator.isNull(tinhTrangHonNhan)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhTrangHonNhan");
//		}
//		
//		// Check tinh noi sinh
//		if (Validator.isNull(tinhNoiSinh)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhNoiSinh");
//		}
//		
//		// Check huyen noi sinh
//		if (Validator.isNull(huyenNoiSinh)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenNoiSinh");
//		}
//		
//		// Check phuong xa noi sinh
//		if (Validator.isNull(xaNoiSinh)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaNoiSinh");
//		}
		
		// Check tinh thuong tru
		if (Validator.isNull(tinhThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhThuongTru");
		}
		
		// Check huyen thuong tru
		if (Validator.isNull(huyenThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenThuongTru");
		}
		
		// Check xa thuong tru
		if (Validator.isNull(xaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaThuongTru");
		}
//		
//		// Check tinh noi o hien tai
//		if (Validator.isNull(tinhHienTai)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhHienTai");
//		}
//		
//		// Check huyen hien tai
//		if (Validator.isNull(huyenHienTai)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenHienTai");
//		}
//		
//		// Check xa hien tai
//		if (Validator.isNull(xaHienTai)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaHienTai");
//		}
		
		// Check so ho khau
//		if (Validator.isNull(soHoKhau)) {
//			//SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soHoKhau");
//		}
		
		// Check chu ho
//		if (Validator.isNull(chuHo)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.chuHo");
//		}
//		
//		// Check quan he voi chu ho
//		if (Validator.isNull(quanHeChuHo)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.quanHeChuHo");
//		}
		
		// Check mo ta dia chi noi sinh
//		if (Validator.isNull(motaNoisinh)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaNoiSinh");
//		}
		
		// Check mo ta dia chi thuong tru
		if (Validator.isNull(motaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaThuongTru");
		}
		
		// Check mo ta dia chi hien tai
//		if (Validator.isNull(motaDiachiHienTai)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaDiachiHienTai");
//		}		
		
		// In case there's error		
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Check data against DB
		
		// Validate birth date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
		}
		
		// Check if in DB, there's already user request that not processed yet
//		if ( this.requestExists(soCmnd)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
//		}
		
		List<CongDan> congDan = CongDanLocalServiceUtil.findByEmail(email);
		if (congDan.size() > 0){
			if (this.cmndExists(soCmnd)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
			}
			// Check email if exists in CSMS cong dan
			if ( this.emailExistsInCongDan(email)) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			}
			
		}
		
		if ( !SessionErrors.isEmpty(actionRequest)) {
			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		// Check if citizen exists or not
		//String maCongDan = this.citizenExists(hoCongDan, tenDem, tenCongDan, soCmnd, ngaySinh);		
		String maCongDan = this.congdanExists(soCmnd, ngaySinh);
		
		// Generate authentication code
		//String authCode = AuthenticateCodeUtil.generateAuthCode();
		String authCode = ParamUtil.getString(actionRequest, "authCode");
		// Update yeu cau dang ky to DB		
		//long reqId = this.createUserRequest(maCongDan, authCode, userRequest, actionRequest);
		this.createAccountRequest(maCongDan, authCode, userRequest, actionRequest);
		// Update profile picture
		//this.updateAnhChanDung(reqId, actionRequest);
		actionRequest.getPortletSession().removeAttribute("PROFILE_PIC");
		
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_OBJECT");
		
		String accountCreationUrl = ParamUtil.getString(actionRequest, "accountCreationUrl");
		
		accountCreationUrl = accountCreationUrl.replace("DUMMY_AUTH_CODE", authCode);
		
		accountCreationUrl.replace("Userregistrationportlet_WAR_cmonappportlet", "");
		
		String uri =  actionRequest.getScheme() + "://" +   actionRequest.getServerName() ;
		int port = actionRequest.getServerPort();
		String portUrl = String.valueOf(port);
		String friendlyUrl =null;
		if (portUrl.equals("80")){
			friendlyUrl = uri +"/web/guest/home?p_p_id=Userregistrationportlet_WAR_cmonappportlet&jspPage="+
					URLEncoder.encode("/html/portlet/userreg/account_creation.jsp", "UTF-8")+"&authCode="+authCode;
		} else {
			friendlyUrl = uri + ":"+ portUrl +"/web/guest/home?p_p_id=Userregistrationportlet_WAR_cmonappportlet&jspPage="+
					URLEncoder.encode("/html/portlet/userreg/account_creation.jsp", "UTF-8")+"&authCode="+authCode;
		}
		// Send email and redirect
		if ( Validator.isNotNull(maCongDan)){	
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
			// Send email here
			//this.sendAccountConfirmationEmail(hoCongDan, tenDem, tenCongDan, accountCreationUrl, email, uri);
			
			// Redirect to success page	
			//String accountRegisterSuccessUrl = ParamUtil.getString(actionRequest, "accountRegisterSuccessUrl");
			
			// Redirect to account register success page
		//	actionResponse.sendRedirect(accountRegisterSuccessUrl);
			
			//return;
		}
		
		// Send email incase of register both citizen and account
		//this.sendCitizenConfirmationEmail(hoCongDan, tenDem, tenCongDan, friendlyUrl, email, uri);	
		String friendlyUrl1 = ParamUtil.getString(actionRequest, "friendlyUrl");
		this.sendCitizenConfirmationEmail(hoCongDan, tenDem, tenCongDan, friendlyUrl1, email, uri, actionRequest);
		
		// Redirect to success URL
		String citizenRegisterSuccessUrl = ParamUtil.getString(actionRequest, "citizenRegisterSuccessUrl");
		
		actionResponse.sendRedirect(citizenRegisterSuccessUrl);	
		 //actionResponse.setRenderParameter("jspPage", citizenRegisterSuccessUrl);
		//actionResponse.setRenderParameter("emailCongDan", email);
	}
	
	/**
	 * Update anh chan dung
	 * 
	 * @param reqId
	 * @param actionRequest
	 * @throws SystemException
	 * @throws PortalException
	 */
//	private void updateAnhChanDung(long reqId, ActionRequest actionRequest) throws SystemException, PortalException {
//		byte[] imgBytes = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");
//		
//		if ( imgBytes == null || imgBytes.length < 1 ){
//			return;
//		}
//		
//		AnhChanDungYeuCauDangKyCongDan anh = AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.getAnhChanDungYeuCauDangKyCongDan(reqId);
//
//		anh.setAnhChanDung(imgBytes);
//		
//		AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.updateAnhChanDungYeuCauDangKyCongDan(anh);
//	}
	
	/**
	 * This is function create user request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maCongDan
	 * @param authCode
	 * @param userRequest
	 * @param actionRequest
	 * @throws PortalException
	 * @throws SystemException
	 * @throws ParseException
	 * @return long
	 */
	private long createUserRequest( String maCongDan, String authCode, Map <String, String> userRequest, ActionRequest actionRequest ) throws PortalException, SystemException, ParseException {
		YeuCauDangKyCongDan yeuCau = new YeuCauDangKyCongDanClp();
		
		yeuCau.setId(CounterLocalServiceUtil.increment(CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE));
		String ho = userRequest.get("HOCONGDAN");
		yeuCau.setHoCongDan(ho);
		
		String tenDem = userRequest.get("TENDEM");
		yeuCau.setTenDem(tenDem);
		
		String ten = userRequest.get("TENCONGDAN");
		yeuCau.setTenCongDan(ten);
		
		StringBuilder fullName = new StringBuilder();
		fullName.append(ho);
		if (!Validator.isNull(tenDem)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(tenDem);
		}
		if (!Validator.isNull(ten)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(ten);
		}
		yeuCau.setHoVaTen(fullName.toString());
		
		yeuCau.setSoCmnd(userRequest.get("SOCMND"));
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		
		yeuCau.setNgayCapCmnd(df.parse(userRequest.get("NGAYCAPCMND")));
		
		yeuCau.setIDNoiCapCmnd(Long.parseLong(userRequest.get("IDNOICAPCMND")));
		
		yeuCau.setGhiChuCmnd(userRequest.get("GHICHUCMND"));
		
		yeuCau.setEmail(userRequest.get("EMAIL"));
		
		yeuCau.setSoHoChieu(userRequest.get("SOHOCHIEU"));
		
		if ( Validator.isNotNull(userRequest.get("NGAYCAPHOCHIEU"))) {
			yeuCau.setNgayCapHoChieu(df.parse(userRequest.get("NGAYCAPHOCHIEU")));
		}
		
		yeuCau.setIDNoiCapHoChieu((Long.parseLong(userRequest.get("IDNOICAPHOCHIEU"))));
		
		if ( Validator.isNotNull(userRequest.get("NGAYHETHANHOCHIEU"))) {
			yeuCau.setNgayHetHanHoChieu(df.parse(userRequest.get("NGAYHETHANHOCHIEU")));
		}
		
		yeuCau.setGhiChuHoChieu(userRequest.get("GHICHUHOCHIEU"));
		
		yeuCau.setGioiTinh(Integer.parseInt(userRequest.get("IDGIOITINH")));
		
		yeuCau.setIDDanToc(Long.parseLong(userRequest.get("IDDANTOC")));
		
		yeuCau.setIDTonGiao(Long.parseLong(userRequest.get("IDTONGIAO")));
		
		yeuCau.setIDQuocTich(Long.parseLong(userRequest.get("IDQUOCTICH")));
		
		yeuCau.setNgaySinh(df.parse(userRequest.get("NGAYSINH")));
		
		yeuCau.setDienThoaiCoDinh(userRequest.get("DIENTHOAICODINH"));
		
		yeuCau.setDienThoaiDiDong(userRequest.get("DIENTHOAIDIDONG"));
		
		yeuCau.setIDTrinhDoHocVan(Long.parseLong(userRequest.get("IDTRINHDOHOCVAN")));
		
		yeuCau.setSoBaoHiemYte(userRequest.get("SOBAOHIEMYTE"));
		
		yeuCau.setMaSoThueCaNhan(userRequest.get("MASOTHUECANHAN"));
		
		yeuCau.setIDNgheNghiep(Long.parseLong(userRequest.get("IDNGHENGHIEP")));
		
		yeuCau.setIDTrinhDoChuyenMon(Long.parseLong(userRequest.get("IDTRINHDOCHUYENMON")));
		
		yeuCau.setTinhTrangHonNhan(Long.parseLong(userRequest.get("IDTINHTRANGHONNHAN")));
		
		yeuCau.setIDTinhThanhNoiSinh(Long.parseLong(userRequest.get("IDTINHTHANHNOISINH")));
		
		yeuCau.setIDQuanHuyenNoiSinh(Long.parseLong(userRequest.get("IDQUANHUYENNOISINH")));
		
		yeuCau.setIDPhuongXaNoiSinh(Long.parseLong(userRequest.get("IDPHUONGXANOISINH")));
		
		yeuCau.setMoTaDiaChiNoiSinh(userRequest.get("MOTADIACHINOISINH"));
		
		yeuCau.setIDTinhThanhThuongTru(Long.parseLong(userRequest.get("IDTINHTHANHTHUONGTRU")));
		
		yeuCau.setIDQuanHuyenThuongTru(Long.parseLong(userRequest.get("IDQUANHUYENTHUONGTRU")));
		
		yeuCau.setIDPhuongXaThuongTru(Long.parseLong(userRequest.get("IDPHUONGXATHUONGTRU")));
		
		yeuCau.setMoTaDiaChiThuongTru(userRequest.get("MOTADIACHITHUONGTRU"));
		
		yeuCau.setIDTinhThanhHienTai(Long.parseLong(userRequest.get("IDTINHTHANHHIENTAI")));
		
		yeuCau.setIDQuanHuyenHienTai(Long.parseLong(userRequest.get("IDQUANHUYENHIENTAI")));
		
		yeuCau.setIDPhuongXaHienTai(Long.parseLong(userRequest.get("IDPHUONGXAHIENTAI")));
		
		yeuCau.setMoTaDiaChiHienTai(userRequest.get("MOTADIACHIHIENTAI"));		
		
		yeuCau.setSoHoKhau(userRequest.get("SOHOKHAU"));
		
		yeuCau.setChuHo(Integer.parseInt(userRequest.get("CHUHO")));
		
		yeuCau.setIDQuanHe(Long.parseLong(userRequest.get("IDQUANHE")));
		
		yeuCau.setTrangThaiYeuCau(0); // Endorsed		

		if (Validator.isNull(maCongDan)) {
			yeuCau.setLoaiYeuCau(ACCOUNT_AND_CITIZEN_TYPE); // 0: register citizen and account
		} else {
			yeuCau.setLoaiYeuCau(ACCOUNT_ONLY_TYPE); // 1: Generate account immediately
		}
		
		yeuCau.setTrangThaiYeuCau(0); // 0: Newly
		
		yeuCau.setXoa(0);
		
		Date currentDate =  new Date();
		
		yeuCau.setNgayYeuCau(currentDate);
		
		yeuCau.setNgayTao(currentDate);
		
		yeuCau.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(actionRequest);
		
		if ( currentUser != null) {		
			yeuCau.setNguoiTao(currentUser.getFullName());
			
			yeuCau.setNguoiSua(currentUser.getFullName());			
		} else {
			yeuCau.setNguoiTao("DUMMY");
			
			yeuCau.setNguoiSua("DUMMY");
		}
		
		yeuCau.setMaCongDan(maCongDan);
		
		yeuCau.setMaXacNhan(authCode);
		
		// Insert to DB
		
		YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCau);
		
		return yeuCau.getId();
	}
	
	/**
	 * This is function create user request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param url
	 * @param email
	 * @param uri
	 * @throws IOException
	 */
	private void sendAccountConfirmationEmail( String ho, String dem, String ten, String url, String email, String uri ) throws IOException {
		// Send email
		AccountCreationRequestMail mail = new AccountCreationRequestMail();
		
		mail.setEmail(email);
		
		mail.setUrl(url);
		
		mail.setUri(uri);
		
		mail.setFullName(ho + StringPool.SPACE + dem + StringPool.SPACE + ten);
		
		// Send the email
		mail.send();
	}
	
	/**
	 * This is function send citizen confirmation email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param url
	 * @param email
	 * @param uri
	 * @param request
	 * @throws IOException
	 */
	private void sendCitizenConfirmationEmail( String ho, String dem, String ten, String url, String email, String uri, ActionRequest request ) throws IOException {
		// Send email
		CitizenCreationRequestMail mail = new CitizenCreationRequestMail();
		
		mail.setEmail(email);
		
		mail.setUrl(url);
		mail.setUri(uri);
		
		mail.setFullName(ho + StringPool.SPACE + dem + StringPool.SPACE + ten);
		
		// Send the email
		mail.send(email, request);
	}
	
	/**
	 * This is function insert account request
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maCongDan
	 * @param authCode
	 * @param userRequest
	 * @param request
	 * @throws SystemException
	 * @throws ParseException
	 * @throws PortalException
	 */
	private void createAccountRequest(String maCongDan, String authCode, Map<String, String> userRequest, ActionRequest request) throws SystemException, ParseException, PortalException {
		
		YeuCauDangKyCongDan yeuCau = new YeuCauDangKyCongDanClp();
		
		yeuCau.setId(CounterLocalServiceUtil.increment(CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE));
		
		Date currentDate = new Date();
		yeuCau.setNgayYeuCau(currentDate);
		
		String ho = userRequest.get("HOCONGDAN");
		yeuCau.setHoCongDan(ho);
		
		String tenDem = userRequest.get("TENDEM");
		yeuCau.setTenDem(tenDem);
		
		String ten = userRequest.get("TENCONGDAN");
		yeuCau.setTenCongDan(ten);
		
		StringBuilder fullName = new StringBuilder();
		fullName.append(ho);
		if (!Validator.isNull(tenDem)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(tenDem);
		}
		if (!Validator.isNull(ten)) {
			if (fullName.length() > 0) {
				fullName.append(" ");
			}
			fullName.append(ten);
		}
		yeuCau.setHoVaTen(fullName.toString());

		yeuCau.setSoCmnd(userRequest.get("SOCMND"));
		
		yeuCau.setEmail(userRequest.get("EMAIL"));
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		Date birthDay = df.parse(userRequest.get("NGAYSINH"));
		
		yeuCau.setNgaySinh(birthDay);
		
		yeuCau.setLoaiYeuCau(ACCOUNT_AND_CITIZEN_TYPE); // 1: Generate account immediately
		
		yeuCau.setTrangThaiYeuCau(0); // 0: Newly
		
		yeuCau.setXoa(0);
		
		yeuCau.setNgayTao(currentDate);
		
		yeuCau.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			yeuCau.setNguoiTao(currentUser.getFullName());
			
			yeuCau.setNguoiSua(currentUser.getFullName());			
		} else {
			yeuCau.setNguoiTao("DUMMY");
			
			yeuCau.setNguoiSua("DUMMY");
		}
		
		yeuCau.setMaCongDan(maCongDan);
		
		yeuCau.setMaXacNhan(authCode);
		
		// ngaySinh - String
		String ngayCapCmnd = ParamUtil.getString(request, "ngayCapCmnd").trim();
		yeuCau.setNgayCapCmnd(FormatUtil.parseStringToDate(ngayCapCmnd));

		// soCmnd - String
		long noiCapCmnd = ParamUtil.getLong(request, "noiCapCmnd");
		yeuCau.setIDNoiCapCmnd(noiCapCmnd);
		
		// gioiTinh - String
		int gioiTinh = ParamUtil.getInteger(request, "gioiTinh");
		yeuCau.setGioiTinh(gioiTinh);

		// gioiTinh - String
		long danToc = ParamUtil.getLong(request, "danToc");
		yeuCau.setIDDanToc(danToc);
		
		// tonGiao - String
		long tonGiao = ParamUtil.getLong(request, "tonGiao");
		yeuCau.setIDTonGiao(tonGiao);
		yeuCau.setIDQuocTich(org.oep.cmon.Constants.VIETNAM);
		// tinhThuongTru - String
		long tinhThuongTru = ParamUtil.getLong(request, "tinhThuongTru");
		yeuCau.setIDTinhThanhThuongTru(tinhThuongTru);
		
		// huyenThuongTru - String
		long huyenThuongTru = ParamUtil.getLong(request, "huyenThuongTru");
		yeuCau.setIDQuanHuyenThuongTru(huyenThuongTru);
		
		// xaThuongTru - String
		long xaThuongTru = ParamUtil.getLong(request, "xaThuongTru");
		yeuCau.setIDPhuongXaThuongTru(xaThuongTru);
				
		// motaThuongTru - String
		String motaThuongTru = ParamUtil.getString(request, "motaThuongTru").trim();
		yeuCau.setMoTaDiaChiThuongTru(motaThuongTru);

		// Insert to DB
		YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCau);
	}
	
	/**
	 * This is function check if cong dan exixts
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @throws ParseException
	 * @return String
	 */
	private String citizenExists(String ho, String dem, String ten, String soCmnd, String ngaySinh) throws ParseException{
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		Date birthDay = df.parse(ngaySinh);
		
		ho = ho.toUpperCase();
		
		dem = dem.toUpperCase();
		
		ten = ten.toUpperCase();
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		//queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ho").eq(ho));
		//queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("dem").eq(dem));
		//queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ten").eq(ten));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return StringPool.BLANK;
		}
		
		// Return the id
		return (results.get(0)).getMa();
	}
	
	/**
	 * This is function check if cong dan exixts
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param soCmnd
	 * @param ngaySinh
	 * @throws ParseException
	 * @return String
	 */
	private String congdanExists(String soCmnd, String ngaySinh) throws ParseException{
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		Date birthDay = df.parse(ngaySinh);
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("soCmnd").eq(soCmnd));
		
		List<CongDan> results = null;
		
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results == null ||  results.size() < 1) {
			return StringPool.BLANK;
		}
		
		// Return the id
		return (results.get(0)).getMa();
	}
	
	/**
	 * This is function check if email exixts
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 ** @param ho
	 * @param dem
	 * @param ten
	 * @param soCmnd
	 * @param ngaySinh
	 * @param email
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean emailExists(String ho, String dem, String ten, String soCmnd, String ngaySinh, String email) throws SystemException{
		if (Validator.isNull(email)) {
			return false;
		}
		
		// Query all cong dan with email
		List<CongDan> congDanLst = CongDanLocalServiceUtil.findByEmail(email);
		
		// Get the first one
		if ( congDanLst.size() < 1) {
			return false;
		}
		
		ho = ho.toUpperCase();
		
		dem = dem.toUpperCase();
		
		ten = ten.toUpperCase();
		
		CongDan congDan = congDanLst.get(0);
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String ngaySinhCd = df.format(congDan.getNgaySinh());
		
		// Check if email exists
		if ( email.equals(congDan.getEmail())) {
			// Check if email is owned by another person or not
			if ( ho.equals(congDan.getHo()) && dem.equals(congDan.getDem()) 
					&& ten.equals(congDan.getTen()) &&  soCmnd.equals(congDan.getSoCmnd()) && ngaySinh.equals(ngaySinhCd) ) {
					return false;
			} else {
				return true;
			}
		}
		
		return false;		
	}
	
	/**
	 * This is function check if email exixts in CongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param email
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean emailExistsInCongDan(String email) throws SystemException{
		if (Validator.isNull(email)) {
			return false;
		}
		
		// Query all cong dan with email
		List<CongDan> congDanLst = CongDanLocalServiceUtil.findByEmail(email);
		
		// Get the first one
		if ( congDanLst.size() < 1) {
			return false;
		}
		
		CongDan congDan = congDanLst.get(0);
		_log.info("email trong csms_congdan:" +congDan.getEmail());
		
		// Check if email exists
		if ( email.equals(congDan.getEmail())) {
			// Check if email is owned by another person or not
			return true;		
		}
		
		return false;		
	}
	
	
	
	/**
	 * This is function check request registration user already exists
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param soCmnd
	 * @throws SystemException
	 * @return boolean
	 */
	private boolean requestExists(String soCmnd) {
		// Query code request using keyword
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(YeuCauDangKyCongDan.class);

		query = query.add(  PropertyFactoryUtil.forName("TrangThaiYeuCau").eq(0));
		
		query = query.add(  PropertyFactoryUtil.forName("SoCmnd").eq(soCmnd));


		List<YeuCauDangKyCongDan> results = null;
		
		try {
			results = YeuCauDangKyCongDanLocalServiceUtil.dynamicQuery(query);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results != null && results.size() > 0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * This is function check request registration user already exists
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param soCmnd
	 * @return boolean
	 */
	private boolean cmndExists(String soCmnd) {
//		// Query code request using keyword
//		DynamicQuery query = DynamicQueryFactoryUtil.forClass(CongDan.class);
//
//		query = query.add(  PropertyFactoryUtil.forName("TrangThaiYeuCau").eq(0));
//		
//		query = query.add(  PropertyFactoryUtil.forName("SoCmnd").eq(soCmnd));
//		_log.info("query: "+query);
//
//		List<CongDan> results = null;
//		
//		
//		try {
//			results = CongDanLocalServiceUtil.dynamicQuery(query);
//			_log.info("query: "+query);
//		} catch (SystemException e) {
//			e.printStackTrace();
//		}
//		
//		if ( results != null && results.size() > 0){
//			return true;
//		}
//		
//		return false;
		
		if (Validator.isNull(soCmnd)) {
			return false;
		}
		
		// Query all cong dan with email
		List<CongDan> congDanLst = null;
		try {
			congDanLst = CongDanLocalServiceUtil.findByCMND(soCmnd);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Get the first one
		if ( congDanLst.size() < 1) {
			return false;
		}
		
		CongDan congDan = congDanLst.get(0);
		_log.info("so smnd trong csms_congdan:" +congDan.getSoCmnd());
		
		// Check if email exists
		if ( soCmnd.equals(congDan.getSoCmnd())) {
			// Check if email is owned by another person or not
			return true;		
		}
		
		return false;		
	}
	
	/**
	 * This is function upload avatar method
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
	public void uploadAvatar(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        File file = uploadRequest.getFile("file");
        
        byte[]  imgBytes = ScaleImageUtil.scaleImage(file, 160, 160);
        
        // Store to session
        actionRequest.getPortletSession().setAttribute("PROFILE_PIC", imgBytes);
       
        actionResponse.setRenderParameter("jspPage", "/html/portlet/userreg/upload_avatar.jsp");
	}
	
	/**
	 * This is function get avatar method
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void getAvatar(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		// Get image from session
       byte[] imgBytes = (byte[])actionRequest.getPortletSession().getAttribute("PROFILE_PIC");   
     
       HttpServletResponse resp = PortalUtil.getHttpServletResponse(actionResponse);
       resp.setContentType("application/jpg");
       
       ServletResponseUtil.write(resp, imgBytes);       
	}
	
	/**
	 * This is function Endorse
	 * This function will handle event when user click to a link in mail
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
	public void endorse(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String jspErrPage = "/html/portlet/userreg/err_page.jsp";
		
		String jspSuccessPage = "/html/portlet/userreg/success_page.jsp";
				
		String authCode = ParamUtil.getString(actionRequest, "authCode");
		// Check parameter
		if (Validator.isNull(authCode)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.request.notExists");
		}
		
		// Check if yeu cau exists in DB
		 List<YeuCauDangKyCongDan> yeuCauLst = YeuCauDangKyCongDanLocalServiceUtil.findByMaXacNhan(authCode);
		 
		 if ( yeuCauLst.size() < 1) {
			 SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.request.notExists");
		 }
		 
		// Take the first record
		 YeuCauDangKyCongDan yeuCau = yeuCauLst.get(0);
		 
//		 // Check if this request already processed
//		 if ( yeuCau.getTrangThaiYeuCau() > 0) {
//			 SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.request.notExists");
//		 }
//		 
//		 // Redirect
//		 if ( !SessionErrors.isEmpty(actionRequest)) {
//				
//			 actionResponse.setRenderParameter("jspPage", jspErrPage);
//				
//			 return;
//		 }
		 
		 // Check loai yeu cau
		 int type = yeuCau.getLoaiYeuCau();
		 if (type == ACCOUNT_AND_CITIZEN_TYPE) {
			 yeuCau.setTrangThaiYeuCau(1); // 1: Email confirmed
			 
			 // Update the request
			 YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);
			 
			 // Redirect
			 actionResponse.setRenderParameter("jspPage", jspSuccessPage);
			 //actionResponse.sendRedirect(jspSuccessPage);
			 actionResponse.setRenderParameter("type", "0");
			 actionResponse.setRenderParameter("authCode", authCode);
				
			//return;
		 }
		 
		 // Generate random password for user
//		 String password = AuthenticateCodeUtil.generateAuthCode().toLowerCase();
//			
//		 EndorsementBs endorse = new EndorsementBs(actionRequest);
//			
//		 String ho = yeuCau.getHoCongDan();
//		 String dem = yeuCau.getTenDem();
//		 String ten = yeuCau.getTenCongDan();
//		 
//		 String fullName = ho + StringPool.SPACE + dem +StringPool.SPACE + ten;
//		 String email = yeuCau.getEmail();
			
		// Create LDAP user first
//		if ( ! endorse.createLDAPEntry(fullName, email,  password)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.endorse.err.ldap");
//
//			actionResponse.setRenderParameter("jspPage", jspErrPage);
//			
//			return;		
//		}
	
		// Create portal user
//		long userId = endorse.createPortalCitizenUser(yeuCau, password);
//		
//		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
//		
//		String maCongDan = this.citizenExists(ho, dem, ten, yeuCau.getSoCmnd(), df.format(yeuCau.getNgaySinh()));
//		// Create citizen
//		endorse.createCitizen(yeuCau, userId, maCongDan);
//			
//		// Create data on cmon_taikhoan nguoidung
//		endorse.createTaiKhoan(userId, fullName, email, password);	
//			
//		endorse.sendEmail(fullName, email, password);
//		
//		// Update flag
//		yeuCau.setTrangThaiYeuCau(2); // 2: Endorsed
//		
//		YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCau);
//			
//		// Redirect
//		 actionResponse.setRenderParameter("jspPage", jspSuccessPage);
//		 actionResponse.setRenderParameter("type", "1");		
	}
	
	/**
	 * This is function save YeuCauDangKyCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	public void saveYeuCauDangKyCongDan(ActionRequest actionRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {
		
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		
		// email - String
		String email = ParamUtil.getString(actionRequest, "email").trim();
		// ho - String
		String ho = ParamUtil.getString(actionRequest, "ho").trim();
		// email - String
		String dem = ParamUtil.getString(actionRequest, "dem").trim();
		// ho - String
		String ten = ParamUtil.getString(actionRequest, "ten").trim();

		if (validatorsYeuCauDangKyCongDan(actionRequest)) {
			saveYeuCauDangKyCongDanToDB(actionRequest, httpReq);

			String maCongDan = this.congdanExists(soCmnd, ngaySinh);
			// Generate authentication code
			String authCode = AuthenticateCodeUtil.generateAuthCode();
			
			String accountCreationUrl = ParamUtil.getString(actionRequest, "accountCreationUrl");
			
			accountCreationUrl = accountCreationUrl.replace("DUMMY_AUTH_CODE", authCode);
			
			String uri =  actionRequest.getScheme() + "://" +   actionRequest.getServerName() ;
			// Send email and redirect
			if ( Validator.isNotNull(maCongDan)){			
				// Send email here
				this.sendAccountConfirmationEmail(ho, dem, ten, accountCreationUrl, email, uri);
				
				// Redirect to success page	
				String accountRegisterSuccessUrl = ParamUtil.getString(actionRequest, "accountRegisterSuccessUrl");
				
				// Redirect to account register success page
				httpReq.sendRedirect(accountRegisterSuccessUrl);
				
				return;
			}
			
			// Send email incase of register both citizen and account
			this.sendCitizenConfirmationEmail(ho, dem, ten, accountCreationUrl, email, uri, actionRequest);	
			
			// Redirect to success URL
			String citizenRegisterSuccessUrl = ParamUtil.getString(actionRequest, "citizenRegisterSuccessUrl");
			
			httpReq.sendRedirect(citizenRegisterSuccessUrl);
			
		} else {
			
			httpReq.setRenderParameter("jspPage", "/html/portlet/userreg/input_detail_exist_congdan.jsp");
		}
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is function validator YeuCauDangKyCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @throws SystemException
	 * @return boolean
	 */
	private static boolean validatorsYeuCauDangKyCongDan(ActionRequest actionRequest) throws SystemException {
		boolean valid = true;
		
		// Validate captcha
		if ( !CheckCaptchaUtil.isTrue(actionRequest, "captcha") ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.captcha");	
			valid = false;
		}
		
		// Check Ho cong dan
		String ho = ParamUtil.getString(actionRequest, "ho").trim();
		if (Validator.isNull(ho)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.hoCongDan");
			valid = false;
		}
		
		// Check ten cong dan
		String ten = ParamUtil.getString(actionRequest, "ten").trim();
		if (Validator.isNull(ten)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tenCongDan");
			valid = false;
		}
		
		// Check so cmnd
		String soCmnd = ParamUtil.getString(actionRequest, "soCmnd").trim();
		if (Validator.isNull(soCmnd) || !Validator.isNumber(soCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.soCmnd");
			valid = false;
		}
		
		// Check ngay cap CMND
		String ngayCapCmnd = ParamUtil.getString(actionRequest, "ngayCapCmnd").trim();
		if (Validator.isNull(ngayCapCmnd) ) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngayCapCmnd");
			valid = false;
		}
		
		// Check noi cap cmnd
		long noiCapCmnd = ParamUtil.getLong(actionRequest, "noiCapCmnd");
		if (noiCapCmnd ==0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.noiCapCmnd");
		}
		
		// Check email
//				if (Validator.isNull(email)) {
//					SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
//				}		
		
		if (soCmnd.trim().length() < 9 || soCmnd.trim().length() > 12) {
			SessionErrors.add(actionRequest, "err.soCmndVoPhaiNamTrongKhoangTuChinDenMuoiHaiChuSo");
			valid = false;
		}
				
		// Check email
		String email = ParamUtil.getString(actionRequest, "email").trim();
		if (!Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email");
			valid = false;
		}		
		
//				// Check gioi tinh
//				if (Validator.isNull(gioiTinh)) {
//					SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.gioiTinh");
//				}
		
		// Check ngay sinh
		String ngaySinh = ParamUtil.getString(actionRequest, "ngaySinh").trim();
		if (Validator.isNull(ngaySinh)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh");
			valid = false;
		}
		
		String tinhThuongTru = ParamUtil.getString(actionRequest, "tinhThuongTru");
		String huyenThuongTru = ParamUtil.getString(actionRequest, "huyenThuongTru");
		String xaThuongTru = ParamUtil.getString(actionRequest, "xaThuongTru");
		
		String motaThuongTru = ParamUtil.getString(actionRequest, "motaThuongTru").trim();
		if (Validator.isNull(motaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.motaThuongTru");
			valid = false;
		}
		
		if (Validator.isNull(tinhThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.tinhThuongTru");
			valid = false;
		}
		
		// Check huyen thuong tru
		if (Validator.isNull(huyenThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.huyenThuongTru");
			valid = false;
		}
		
		// Check xa thuong tru
		if (Validator.isNull(xaThuongTru)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.xaThuongTru");
			valid = false;
		}
		
		// Check data against DB
		
		// Validate birth date
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date birthDate = null;
		df.setLenient(false);
		try {
			birthDate = df.parse(ngaySinh);
		} catch (Exception e) {
			// Error never happen so this exception will be swallow
		}
		
		if ( birthDate.compareTo(new Date()) > 0) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.ngaySinh.greaterThanCurrent");
			valid = false;
		}
		
		// Check if in DB, there's already user request that not processed yet
//				if ( this.requestExists(soCmnd)) {
//					SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.requestExists");
//				}
//				
//				// Check email if exists in CSMS cong dan
//				if ( this.emailExistsInCongDan(email)) {
//					SessionErrors.add(actionRequest, "vn.dtt.cmon.userreg.form.input.err.email.alreadyOwned");
//				}
		

		if (!valid) {
			FormatUtil.setParams(actionRequest);
			Iterator<String> error = SessionErrors.iterator(actionRequest);
			while (error.hasNext()) {
				_log.info("validate false :"+ error.next());

			}
		}
		return valid;
	}
	
	/**
	 * This is function save YeuCauDangKyCongDan
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 * @param httpReq
	 * @throws NumberFormatException
	 * @throws Exception
	 * @return YeuCauDangKyCongDan
	 */
	public static YeuCauDangKyCongDan saveYeuCauDangKyCongDanToDB(ActionRequest resourceRequest,
			ActionResponse httpReq) throws NumberFormatException, Exception {

		long idYeuCauDangKyCongDan = ParamUtil.getLong(resourceRequest, "yeuCauDangKyCongDanId");
		
		YeuCauDangKyCongDan yeuCauDangKyCongDan =null;
		
		
		if (idYeuCauDangKyCongDan > 0) {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.fetchYeuCauDangKyCongDan(idYeuCauDangKyCongDan);
		} else {
			yeuCauDangKyCongDan = new YeuCauDangKyCongDanClp();
			yeuCauDangKyCongDan.setId(CounterLocalServiceUtil.increment(CSMS_YEUCAUDANGKYCONGDAN_SEQUENCE));
		}

		// email - String
		String email = ParamUtil.getString(resourceRequest, "email").trim();
		yeuCauDangKyCongDan.setEmail(email);

		// ho - String
		String ho = ParamUtil.getString(resourceRequest, "ho").trim();
		yeuCauDangKyCongDan.setHoCongDan(ho);
		
		// email - String
		String dem = ParamUtil.getString(resourceRequest, "dem").trim();
		yeuCauDangKyCongDan.setTenDem(dem);

		// ho - String
		String ten = ParamUtil.getString(resourceRequest, "ten").trim();
		yeuCauDangKyCongDan.setTenCongDan(ten);
		
		// ngaySinh - String
		String ngaySinh = ParamUtil.getString(resourceRequest, "ngaySinh").trim();
		yeuCauDangKyCongDan.setNgaySinh(FormatUtil.parseStringToDate(ngaySinh));

		// soCmnd - String
		String soCmnd = ParamUtil.getString(resourceRequest, "soCmnd").trim();
		yeuCauDangKyCongDan.setSoCmnd(soCmnd);
		
		// ngaySinh - String
		String ngayCapCmnd = ParamUtil.getString(resourceRequest, "ngayCapCmnd").trim();
		yeuCauDangKyCongDan.setNgayCapCmnd(FormatUtil.parseStringToDate(ngayCapCmnd));

		// soCmnd - String
		long noiCapCmnd = ParamUtil.getLong(resourceRequest, "noiCapCmnd");
		yeuCauDangKyCongDan.setIDNoiCapCmnd(noiCapCmnd);
		
		// gioiTinh - String
		int gioiTinh = ParamUtil.getInteger(resourceRequest, "gioiTinh");
		yeuCauDangKyCongDan.setGioiTinh(gioiTinh);

		// gioiTinh - String
		long danToc = ParamUtil.getLong(resourceRequest, "danToc");
		yeuCauDangKyCongDan.setIDDanToc(danToc);
		
		// tonGiao - String
		long tonGiao = ParamUtil.getLong(resourceRequest, "tonGiao");
		yeuCauDangKyCongDan.setIDTonGiao(tonGiao);
		
		// tinhThuongTru - String
		long tinhThuongTru = ParamUtil.getLong(resourceRequest, "tinhThuongTru");
		yeuCauDangKyCongDan.setIDTinhThanhThuongTru(tinhThuongTru);
		
		// huyenThuongTru - String
		long huyenThuongTru = ParamUtil.getLong(resourceRequest, "huyenThuongTru");
		yeuCauDangKyCongDan.setIDQuanHuyenThuongTru(huyenThuongTru);
		
		// xaThuongTru - String
		long xaThuongTru = ParamUtil.getLong(resourceRequest, "xaThuongTru");
		yeuCauDangKyCongDan.setIDPhuongXaThuongTru(xaThuongTru);
				
		// motaThuongTru - String
		String motaThuongTru = ParamUtil.getString(resourceRequest, "motaThuongTru").trim();
		yeuCauDangKyCongDan.setMoTaDiaChiThuongTru(motaThuongTru);

		if (idYeuCauDangKyCongDan > 0) {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.updateYeuCauDangKyCongDan(yeuCauDangKyCongDan);
		} else {
			yeuCauDangKyCongDan = YeuCauDangKyCongDanLocalServiceUtil.addYeuCauDangKyCongDan(yeuCauDangKyCongDan);
		}
		return yeuCauDangKyCongDan;
	}
}
