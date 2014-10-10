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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.business.TaiKhoanNguoiDungBusiness;
import org.oep.cmon.admin.portlet.util.ConvertUtil;
import org.oep.cmon.admin.portlet.util.EncryptionUtil;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * This is class TaiKhoanNguoiDungAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TaiKhoanNguoiDungAction {
	/** Search by code option */
	private static String SEARCH_LOGIN_NAME_OPTION = "0";
	
	/** Search by name option */
	private static String SEARCH_USER_NAME_OPTION = "1";
	
	/** Serch by email option */
	private static String SEARCH_USER_EMAIL_OPTION = "2";
	
	/** Action mode, 0: insert, 1: edit */
	private static int INSERT_MODE = 0;
	
	/** Action mode, 0: insert, 1: edit */
	private static int EDIT_MODE = 1;
	
	
	/**
	 * This is function search TaiKhoanNguoiDungPopup
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
		//// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		this.searchTaiKhoanNguoiDung(searchOption, keyWord, actionRequest, actionResponse);
	}
	
	/**
	 * This is function search TaiKhoanNguoiDung
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
		//// Get the search option
		String searchOption = ParamUtil.getString(actionRequest, "searchOption");
		
		// Get the search keyword if submitted
		String keyWord = ParamUtil.getString(actionRequest, "keyWord");
		
		this.searchTaiKhoanNguoiDung(searchOption, keyWord, actionRequest, actionResponse);
	}

	/**
	 * This is function search TaiKhoanNguoiDung
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param searchOption
	 * @param keyWord
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void searchTaiKhoanNguoiDung(String searchOption, String keyWord, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		// Redirect User
		int popup = ParamUtil.getInteger(actionRequest, "popup");
		List<TaiKhoanNguoiDung> results = null;
		
		if ( popup < 1) {
			results = TaiKhoanNguoiDungLocalServiceUtil.findTaiKhoanNguoiDung(keyWord, searchOption);
		} else {
			results = TaiKhoanNguoiDungLocalServiceUtil.findTaiKhoanNguoiDungPopup(keyWord, searchOption);
		}
		if (results == null) {
			results = new ArrayList<TaiKhoanNguoiDung>();
		}

		// Set the result back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_RESULT", results);
		
		// Store the search option to session for coming back to search screen from edit screen
		Map<String, String> searchParam = new HashMap<String, String>();

		if (Validator.isNull(searchOption)) {
			searchOption = SEARCH_LOGIN_NAME_OPTION;
		}
		
		searchParam.put("searchOption", searchOption);		
		searchParam.put("keyWord", keyWord);
		
		// Set the search param back to session
		actionRequest.getPortletSession().setAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_PARAMS", searchParam);
		
		if ( popup < 1) {
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_list.jsp");
		} else {
			actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_list_popup.jsp");
		}
		actionResponse.setRenderParameter("searchOption", searchOption);
		actionResponse.setRenderParameter("keyWord", keyWord);
	}
	
	/**
	 * This is function add or edit TaiKhoanNguoiDung
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
		// Get the  required parameters
		// Action mode (0: Insert, 1: Edit);
		int mode = ParamUtil.getInteger(actionRequest, "mode");
		
		Map <String, String> userRequest = (Map <String, String>)actionRequest.getPortletSession().getAttribute("USER_REQUEST_TKND_OBJECT");
		if (userRequest == null ) {
			userRequest = new HashMap<String, String>();
		}
		
		String email = ParamUtil.getString(actionRequest, "email").trim();
		userRequest.put("email", email);

		// We use email as login name as well
		String loginName = email;// ParamUtil.getString(actionRequest, "loginName").trim();
		userRequest.put("loginName", loginName);
		
		String fullName = ParamUtil.getString(actionRequest, "fullName").trim();
		userRequest.put("fullName", fullName);
		
		String password = ParamUtil.getString(actionRequest, "password").trim();
		userRequest.put("password", password);	
		
		String trangThai = ParamUtil.getString(actionRequest, "trangThai").trim();
		userRequest.put("trangThai", trangThai);
		
		String loaiDoiTuong = ParamUtil.getString(actionRequest, "loaiDoiTuong").trim();
		userRequest.put("loaiDoiTuong", loaiDoiTuong);
		
		String liferayID = ParamUtil.getString(actionRequest, "liferayID").trim();
		userRequest.put("TaiKhoanLiferayID", liferayID);
		
		
		
//		String coQuanQuanLy = ParamUtil.getString(actionRequest, "coQuanQuanLy").trim();
//		userRequest.put("coQuanQuanLy", coQuanQuanLy);

		// Validate parameteter
		// Set the data back to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_TKND_OBJECT", userRequest);
				
		// Check login name
		if (Validator.isNull(loginName)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.loginName");
		}
		
		// Check full name
		if (Validator.isNull(fullName)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.fullName");
		}
		
		// Check password
		if (mode == INSERT_MODE && Validator.isNull(password)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.password");
		}
		
		// Check email
		if (Validator.isNull(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.email");
		}
		
		if (Validator.isNotNull(email) && !Validator.isEmailAddress(email)) {
			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.emailNotValid");
		}
		
		// Check co quan quan ly
//		if (Validator.isNull(coQuanQuanLy)) {
//			SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.coQuanQuanLy");
//		}	
		
		// Check duplicate information
		if ( mode == INSERT_MODE) {
		
			if ( Validator.isNotNull(loginName)) {
				TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(loginName);				
				
				if ( taiKhoan != null ) {
					SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateLoginName");
				}
			}
			
			// Check duplicate email
			List <TaiKhoanNguoiDung> lst = TaiKhoanNguoiDungLocalServiceUtil.findByEmail(email);
			if ( lst.size() > 0 ) {	
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateEmail");
		
			}		
		} else {
			
			// Get the id
			long id = Long.parseLong( userRequest.get("id") );
			
			if ( Validator.isNotNull(loginName)) {
				TaiKhoanNguoiDung taiKhoan = TaiKhoanNguoiDungLocalServiceUtil.findByTenDangNhap(loginName);				
				
				if ( taiKhoan != null ) {					
					// Check if the login name to be updated is already owned by another
					if ( taiKhoan.getId() != id ) {
						SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateLoginName");
					}
				}
			}
			
			// Check duplicate email
			List <TaiKhoanNguoiDung> lst = TaiKhoanNguoiDungLocalServiceUtil.findByEmail(email);
			if ( lst.size() > 0 ) {
				// Get the first object in the list
				TaiKhoanNguoiDung obj = lst.get(0);
				
				// Check if the email to be updated is already owned by another
				if ( obj.getId() != id ) {
					SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.duplicateEmail");
				}
			}		
		}		
		
		// Redirect
		String redirectUrl = ParamUtil.getString(actionRequest, "redirectUrl");
		if ( !SessionErrors.isEmpty(actionRequest)) {			
			actionResponse.sendRedirect(redirectUrl);
			
			return;
		}
		
		TaiKhoanNguoiDungBusiness taiKhoanNguoiDungBs = new TaiKhoanNguoiDungBusiness();
		
		TaiKhoanNguoiDung nguoiDung = taiKhoanNguoiDungBs.toEntity(mode, userRequest, actionRequest);
		
		long userId = 0;
		
		if ( nguoiDung.getTrangThai() != 0) {
			// Create user on LDAP server
			//remove add user to ldap by liemnn
			/*boolean status = taiKhoanNguoiDungBs.createUserOnLDAP(nguoiDung.getEmail(), EncryptionUtil.decrypt(nguoiDung.getMatKhau()), nguoiDung.getTenNguoiDung());
			if (!status) {
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_taikhoannguoidung.err.ldap");
				actionResponse.sendRedirect(redirectUrl);
				
				return;		
			}	*/	
			
			// Create portal user
			try {
				userId = taiKhoanNguoiDungBs.createPortalUser(nguoiDung, actionRequest);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		// Insert/updatye record here
		if (mode == INSERT_MODE) {
			try{
				new TaiKhoanNguoiDungBusiness().insert(nguoiDung, userId, actionRequest);
			} catch (Exception e){			
				e.printStackTrace();
				
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.unKnown");
			
				// Redirect to error page
				actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
			
				return;
			}
		} else {
			try{
				if (ConvertUtil.convertToLong(liferayID) > 0) {
					nguoiDung.setTaiKhoanNguoiDungId(ConvertUtil.convertToLong(liferayID));
				}
				new TaiKhoanNguoiDungBusiness().edit(nguoiDung, EncryptionUtil.encrypt(password), actionRequest);
			} catch (Exception e){			
				e.printStackTrace();
				
				SessionErrors.add(actionRequest, "vn.dtt.cmon.admin.form.add_edit_coquanquanly.err.unKnown");
			
				// Redirect to error page
				actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/err_page.jsp");
			
				return;
			}
		}
		
		// Remove attribute
		actionRequest.getPortletSession().removeAttribute("USER_REQUEST_TKND_OBJECT");
		
		// Redirect user
		if (mode == INSERT_MODE) {
			// Add success message
			SessionMessages.add(actionRequest, "success");
			
			actionResponse.sendRedirect(redirectUrl);
		} else {
			// Redirect to search screen
			Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_PARAMS");
			
			String searchOption = searchParam.get("searchOption");
	
			String keyWord = searchParam.get("keyWord");
			
			// Do the search
			this.searchTaiKhoanNguoiDung(searchOption,  keyWord, actionRequest, actionResponse);
		}		
	}
	
	/**
	 * This is function delete TaiKhoanNguoiDung
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
		long id = ParamUtil.getLong(actionRequest, "id");
		
		new TaiKhoanNguoiDungBusiness().delete(id, actionRequest);
		
		// Redirect to search page
		Map<String,String> searchParam = (Map<String,String>)actionRequest.getPortletSession().getAttribute("SEARCH_TAI_KHOAN_NGUOI_DUNG_PARAMS");
		
		String searchOption = searchParam.get("searchOption");
		
		String keyWord = searchParam.get("keyWord");
		
		// Do the search
		this.searchTaiKhoanNguoiDung(searchOption,  keyWord, actionRequest, actionResponse);
	}
	
	/**
	 * This is function view TaiKhoanNguoiDung
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
		long id = ParamUtil.getLong(actionRequest, "id");
		
		// Query the data
		TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.getTaiKhoanNguoiDung(id);
		
		Map <String, String> userRequest = new HashMap<String, String>();
		
		userRequest.put("id", nguoiDung.getId() + "");
		
		userRequest.put("loginName", nguoiDung.getTenDangNhap());
		
		userRequest.put("fullName", nguoiDung.getTenNguoiDung());
		try {
			String decryptPassword = EncryptionUtil.decrypt(nguoiDung.getMatKhau());
			
			userRequest.put("password", decryptPassword); 
		} catch (Exception es){
			userRequest.put("password", "");
		}
		
		userRequest.put("email", nguoiDung.getEmail());
		
		userRequest.put("trangThai", nguoiDung.getTrangThai() + "");
		try {
			userRequest.put("loaiDoiTuong", nguoiDung.getLoaiDoiTuongId() + "");
		} catch (Exception es) {
			userRequest.put("loaiDoiTuong", "");
		}
		
		try {
			userRequest.put("TaiKhoanLiferayID", nguoiDung.getTaiKhoanNguoiDungId() + "");
		} catch (Exception es) {
			userRequest.put("TaiKhoanLiferayID", "");
		}
		
//		long idCoQuanQuanLy = nguoiDung.getCoQuanQuanLyId();
//		
//		if ( idCoQuanQuanLy > 0) {		
//			// Get name of co quan quan ly
//			CoQuanQuanLy coQuan = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(idCoQuanQuanLy);
//		
//			userRequest.put("coQuanQuanLy", coQuan.getId() + "-" + coQuan.getTen());
//		} else {
//			userRequest.put("coQuanQuanLy", "");
//		}
		
		// Set object to session
		actionRequest.getPortletSession().setAttribute("USER_REQUEST_TKND_OBJECT", userRequest );

		// Redirect to add/edit screen
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/tai_khoan_nguoi_dung_add_edit.jsp");
		actionResponse.setRenderParameter("mode", EDIT_MODE + "");
	}
}
