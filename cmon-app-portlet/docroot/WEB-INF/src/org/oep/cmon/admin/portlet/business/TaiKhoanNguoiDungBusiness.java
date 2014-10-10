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

package org.oep.cmon.admin.portlet.business;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.naming.NamingException;
import javax.portlet.ActionRequest;

import org.oep.cmon.admin.portlet.business.LDAP;
import org.oep.cmon.admin.portlet.util.EncryptionUtil;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;

import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/** 
 * This is class TaiKhoanNguoiDungBusiness
 * 
 * This class contains logics related to TaiKhoanNguoiDung table
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-March-2013  Nam Dinh    Create new
 */
public class TaiKhoanNguoiDungBusiness {
	
	/** Action mode, 0: insert, 1: edit */
	private static int INSERT_MODE = 0;
	
	/** Action mode, 0: insert, 1: edit */
	private static int EDIT_MODE = 1;	
	
	/** Tai khoan nguoi dung sequence */
	private static final String TAIKHOANNGUOIDUNG_SEQUENCE = "cmon_taikhoannguoidung";
	
	/** 
	 * This is function insert TaiKhoanNguoiDung
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param nguoiDung
	 * @param userId
	 * @param actionRequest 
	 * @throws Exception
	 */
	public void insert(TaiKhoanNguoiDung nguoiDung, long userId, ActionRequest actionRequest) throws Exception {
		// Insert to DB		
		if ( userId != 0) {
			nguoiDung.setTaiKhoanNguoiDungId(userId);
		}
		
		
		try {
			TaiKhoanNguoiDung taiKhoanNguoiDung = TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(nguoiDung);
		} catch (Exception es) {
			es.printStackTrace();
		}
	}
	
	/** 
	 * This is function edit TaiKhoanNguoiDung
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param nguoiDung
	 * @param password
	 * @param actionRequest 
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 * @throws NamingException 
	 */
	public void edit(TaiKhoanNguoiDung nguoiDung, String password, ActionRequest actionRequest) throws PortalException, SystemException, NamingException, IOException {		
		if (nguoiDung.getTrangThai() == 0) {
			// Inactive user
			this.deleteExternalUser(nguoiDung, actionRequest);

			nguoiDung.setTaiKhoanNguoiDungId(0L);
		}	
		
		// UPdate to DB
		nguoiDung.setMatKhau(password);
		
		TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(nguoiDung);		
	}
	
	/** 
	 * This is function delete user on LF and LDAP
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param nguoiDung
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 * @throws NamingException 
	 */
	private void deleteExternalUser(TaiKhoanNguoiDung nguoiDung, ActionRequest request) throws PortalException, SystemException, NamingException, IOException{
		// Delete liferay user
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		new PortalUserBs().deleteUser(nguoiDung.getEmail(), themeDisplay.getCompanyId());		
		
		// Delete user on LDAP server
		LDAP ldap = new LDAP();
		
		ldap.delete(nguoiDung.getEmail());		
	}
	
	
	/** 
	 * This is function delete user account
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param id
	 * @param actionRequest
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException 
	 * @throws NamingException 
	 */
	public void delete(long id, ActionRequest actionRequest) throws PortalException, SystemException, NamingException, IOException {
		TaiKhoanNguoiDung nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.getTaiKhoanNguoiDung(id);
		
		nguoiDung.setTrangThai(0); // 0: Khong hoat dong
		
		TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(nguoiDung);
				
		// Drop cmon_cc_cmon_tknd_fk constraint in cmon_congchuc to truncate all the data
		this.deleteExternalUser(nguoiDung, actionRequest);
	}
	
	/** 
	 * This is function set data from request object to entity object
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param actionMode
	 * @param userRequest
	 * @param request
	 * @return TaiKhoanNguoiDung
	 * @throws Exception
	 */
	public TaiKhoanNguoiDung toEntity(int actionMode, Map<String, String> userRequest, ActionRequest request) throws Exception{
		TaiKhoanNguoiDung nguoiDung = null;
		
		if (actionMode == INSERT_MODE) {
			nguoiDung = new TaiKhoanNguoiDungClp();
			
			nguoiDung.setId(CounterLocalServiceUtil.increment(TAIKHOANNGUOIDUNG_SEQUENCE));
			
		} else {
			// Edit mode
			nguoiDung = TaiKhoanNguoiDungLocalServiceUtil.getTaiKhoanNguoiDung(Long.parseLong(userRequest.get("id")));
		}
		
		nguoiDung.setTenDangNhap(userRequest.get("loginName"));
		
		String password = userRequest.get("password");
		
		// Encrypt the password
		String encryptedPassword = EncryptionUtil.encrypt(password); 
			
		if (actionMode == EDIT_MODE) {
			String oldPassword = nguoiDung.getMatKhau();
			if ( oldPassword.equals(encryptedPassword)) {
				nguoiDung.setMatKhau(StringPool.BLANK);
			} else {
				nguoiDung.setMatKhau(encryptedPassword);
			}
		} else {
			nguoiDung.setMatKhau(encryptedPassword);
		}
		
		nguoiDung.setTenNguoiDung(userRequest.get("fullName"));
		
		nguoiDung.setEmail(userRequest.get("email"));
		
		nguoiDung.setTrangThai(Integer.parseInt(userRequest.get("trangThai")));
		
		nguoiDung.setLoaiDoiTuongId(Long.parseLong(userRequest.get("loaiDoiTuong")));
		
		// Extract co quan quan ly id from co quan quan ly string
//		String coQuanQuanLy = userRequest.get("coQuanQuanLy");
//		
//		if (Validator.isNotNull(coQuanQuanLy)) {
//			String id = coQuanQuanLy.substring(0, coQuanQuanLy.indexOf("-"));
//		
//			nguoiDung.setCoQuanQuanLyId(Long.parseLong(id));
//		} else {
//			// Remove the relation
//			nguoiDung.setCoQuanQuanLyId(0l);
//		}
		
		// Common columns
		Date currentDate = new Date();
		
		if (actionMode == INSERT_MODE) {
			nguoiDung.setNgayTao(currentDate);
		}
		
		nguoiDung.setNgaySua(currentDate);
		
		User currentUser = PortalUtil.getUser(request);
		
		if ( currentUser != null) {		
			if (actionMode == INSERT_MODE) {
				nguoiDung.setNguoiTao(currentUser.getFullName());
			}
			
			nguoiDung.setNguoiSua(currentUser.getFullName());			
		} else {
			// This is for test without logging in
			if (actionMode == INSERT_MODE) {
				nguoiDung.setNguoiTao("DUMMY");
			}
			
			nguoiDung.setNguoiSua("DUMMY");	
		}
		
		nguoiDung.setDaXoa(0); // Un deleted
		
		return nguoiDung;
	}
	
	/** 
	 * This is function create user on LDAP server
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param email
	 * @param password
	 * @param fullName
	 * @return
	 */
	public boolean createUserOnLDAP(String email, String password, String fullName) {
		try{
			LDAP ldap = new LDAP();
			
			if ( ldap.isExist(email) ){
				ldap.delete(email);
			}
			
			ldap.addEntry(email, password, fullName);
			
		} catch (Exception e){
			// Print out error stack
			e.printStackTrace();		
			
			return false;			
		}
		return true;
	}
	
	/** 
	 * This is function create portal user
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param nguoiDung
	 * @param request
	 * @throws Exception 
	 */
	public long createPortalUser(TaiKhoanNguoiDung nguoiDung, ActionRequest request) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		PortalUserBs user = new  PortalUserBs();
		
		return user.createPortalUser(nguoiDung, themeDisplay.getCompanyId());		
	}
}
