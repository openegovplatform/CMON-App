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

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.oep.cmon.admin.portlet.util.EncryptionUtil;

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

import com.liferay.counter.model.Counter;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/** 
 * This is class PortalUserBs
 * 
 * This class is used to create an user in liferay portal
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  1-April-2013  Nam Dinh    Create new
 */
public class PortalUserBs {

	/** Organization config file */
	private static final String ORGANIZATION_CONFIG_FILE = "vn/dtt/cmon/admin/portlet/business/organization_config.properties";
	
	/**
	 * Constructor
	 * 
	 * @param codeRequest
	 * @param actionRequest
	 */
	public PortalUserBs() {
		// Do nothing
	}
	
	/** 
	 * This is function delete User
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param email
	 * @param companyId
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public void deleteUser(String email, long companyId) throws PortalException, SystemException {
		// Check if user exists		
		User existUser = null;
		try {
			existUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
		} catch (Exception e) {
			// This is the problem of fucking version of LF, when an user doest not exist, it will throw
			// exception instead of return null
		}
		
		if (existUser != null ) {
			// Deactivate user
			UserLocalServiceUtil.updateStatus(existUser.getUserId(), WorkflowConstants.STATUS_INACTIVE);
		}				
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
	 * @param companyId
	 * @throws Exception 
	 */
	public long createPortalUser(TaiKhoanNguoiDung nguoiDung, long companyId) throws Exception{
		// Check if user exists		
		User existUser = null;
		try {
			existUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, nguoiDung.getEmail());
		} catch (Exception e) {
			// This is the problem of fucking version of LF, when an user doest not exist, it will throw
			// exception instead of return null
			e.printStackTrace();
		}
		
		// Get code of loai doi tuong
		DoiTuongSuDung doiTuong = DoiTuongSuDungLocalServiceUtil.getDoiTuongSuDung(nguoiDung.getLoaiDoiTuongId());
		String organizationName = doiTuong.getTen();		

		// Update the existing user incase user found
		if ( existUser != null ) {
			// Activate user if it is deactive
			if ( !existUser.isActive() ) {
				UserLocalServiceUtil.updateStatus(existUser.getUserId(), WorkflowConstants.STATUS_APPROVED);
			}			
	
			if (Validator.isNotNull(nguoiDung.getMatKhau())) {
				String decryptPassword = EncryptionUtil.decrypt(nguoiDung.getMatKhau());
				try{
					UserLocalServiceUtil.updatePassword(existUser.getUserId(), decryptPassword, decryptPassword, false);
				} catch (Exception e) {
					e.printStackTrace();
					// Swallow because in this case, liferay throw no exception
				}
			}			

			// Update organization
			Organization organization = OrganizationLocalServiceUtil.getOrganization(companyId, organizationName);
			
			long[] orgIds = new long[1];			
							
			orgIds[0] = organization.getOrganizationId();			
			
			UserLocalServiceUtil.updateOrganizations(existUser.getUserId(), orgIds, new ServiceContext());

			return existUser.getUserId();
		}		

		// Create new user here
		
		long creatorUserId = 0;
		
		boolean autoPassword = false;
		
		// Lower case the password
		String password = EncryptionUtil.decrypt(nguoiDung.getMatKhau());		
	
		String password1 = password;
		
		String password2 = password;
		
		boolean autoScreenName = true;
		
		String screenName = StringPool.BLANK;
		
		String emailAddress = nguoiDung.getEmail();
		
		long facebookId = 0;
		
		String openId = StringPool.BLANK;
		
		Locale locale = LocaleUtil.getDefault();
		
		String firstName = nguoiDung.getTenNguoiDung();
		
		String middleName = getNameByEmail(emailAddress);
		
		String lastName = getNameByEmail(emailAddress);
		
		int prefixId = 0;
		
		int suffixId = 0;
		
		boolean male = true; // Default is male
//		String sex = codeRequest.getGioiTinh();
//		if ( "1".equals(sex)) {
//			male = true;
//		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		// Set the birth day as current date
		int birthdayMonth = cal.get(Calendar.MONTH);
		int birthdayDay = cal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = cal.get(Calendar.YEAR);
		
		String jobTitle = StringPool.BLANK;
		
		long[] groupIds = null;
		
		long[] organizationIds = null;
		
		long[] roleIds = null;
		
		long[] userGroupIds = null;
		
		boolean sendEmail = false;

		ServiceContext serviceContext = new ServiceContext();
		User user = UserLocalServiceUtil.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
		
		try {
			UserLocalServiceUtil.updateLastLogin( user.getUserId(), user.getLoginIP());
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		//UserLocalServiceUtil.updatePasswordReset(user.getUserId(), true);

		try {
			UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		
//		long[] orgIds = new long[1];		
//		
//		orgIds[0] = organization.getOrganizationId();		
		
		//UserLocalServiceUtil.updateOrganizations(user.getUserId(), orgIds, new ServiceContext());	
		try {
			// Add user to organization
			Organization organization = OrganizationLocalServiceUtil.getOrganization(companyId, organizationName);
			
			long[] userIds = {user.getUserId()};
			
			UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
		} catch (Exception es) {
			es.printStackTrace();
		}
		return user.getUserId();		
	}
	
	/** 
	 * This is function get Name by Email
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  21-March-2013  Nam Dinh    Create new
	 * @param email
	 * @return String
	 */
	private String getNameByEmail(String email){
		
		
		try {
			long id= CounterLocalServiceUtil.increment("CB_SCREENNAME");
			if(email != null){
				return email.substring(0,email.indexOf("@"))+id;
			}
			return "CB"+id;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
