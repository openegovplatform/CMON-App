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

package org.oep.cmon.user.portlet.business;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.oep.cmon.util.OrganizationLiferayUtils;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;
import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;
import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/** 
 * This is class CitizenUserBs
 * 
 * This class is used to create an user in liferay portal
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class CitizenUserBs {
	
	/** User full name */
	private String fullName = StringPool.BLANK;
	
	/** User birth date */
	private Date birthDate = null;
	
	/** Email */
	private String email = StringPool.BLANK;
	
	/** Avatar */
	private byte[] avatar = new byte[0]; 
	
	/**
	 * Constructor
	 * 
	 * @param codeRequest
	 * @param actionRequest
	 */
	public CitizenUserBs() {
		// Do nothing
	}
	
	/**
	 * This is function create portal user
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param password
	 * @param themeDisplay
	 * @throws IOException
	 * @throws SystemException
	 * @throws PortalException
	 */
	public long createCitizenUser(String password, ThemeDisplay themeDisplay, YeuCauDangKyCongDan yeuCau) throws IOException, SystemException, PortalException{
		 
		long companyId = themeDisplay.getCompanyId();
		
		// Check if user exists		
		User existUser = null;
		try {
			existUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, this.email);
		} catch (Exception e) {
			// This is the problem of fucking version of LF, when an user doest not exist, it will throw
			// exception instead of return null
		}		
		String citizenOrg = this.getOrganizationForCitizen();
		
		// Update the existing user incase user found
		if ( existUser != null ) {
			UserLocalServiceUtil.updatePassword(existUser.getUserId(), password, password, true);
			// Update portrait
			if (this.avatar.length > 0) {
				UserLocalServiceUtil.updatePortrait(existUser.getUserId(), this.avatar);
			}
			// Update organization
			Organization organization = OrganizationLiferayUtils.getOrganization(companyId, citizenOrg);
			long[] orgIds= {organization.getOrganizationId()};
			UserLocalServiceUtil.updateOrganizations(existUser.getUserId(), orgIds, new ServiceContext());	
			return existUser.getUserId();
		}
		
		// Create new user here
		long creatorUserId = 0;
		boolean autoPassword = false;
		// Lower case the password
		password = password.toLowerCase();
		String password1 = password;
		String password2 = password;
		
		//boolean autoScreenName = true;
		boolean autoScreenName = false;
		
		long userId = CounterLocalServiceUtil.increment(User.class.getName());
		String screenName = "cd"+userId;
		
		String emailAddress = this.email;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = this.fullName;
		String middleName = yeuCau.getTenDem();
		String lastName = yeuCau.getTenCongDan();
		
		int prefixId = 0;
		int suffixId = 0;
		boolean male = true; // Default is male
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.birthDate);
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
		
		// fix loi : LDAP: error code 65 - object class 'inetOrgPerson' requires attribute 'sn'...
		if (Validator.isNull(middleName)) {
			middleName = screenName;
		}
		User user = UserLocalServiceUtil.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		UserLocalServiceUtil.updateLastLogin( user.getUserId(), user.getLoginIP());

		UserLocalServiceUtil.updatePasswordReset(user.getUserId(), true);

		UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
		
		// Update portrait
		if (this.avatar.length > 0) {			
			UserLocalServiceUtil.updatePortrait(user.getUserId(), this.avatar);
		}		
		
		// Add user to organization
		Organization organization = OrganizationLocalServiceUtil.getOrganization(companyId, citizenOrg);
		
		long[] userIds = {user.getUserId()};
				
		UserLocalServiceUtil.addOrganizationUsers(organization.getOrganizationId(), userIds);
		
		return user.getUserId();
	}	
	
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the avatar
	 */
	public byte[] getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	/**
	 * This is function get default organization for citizen
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return organization name
	 * @throws IOException 
	 * @throws SystemException 
	 */
	private String getOrganizationForCitizen() throws IOException, SystemException {
		String maOrg = WebserviceFactory.getThamSoService().getValue("CMON_CONG_DAN_ORGANIZATION_ID");
		if (maOrg.length() == 0) {
			maOrg = "CD";
		}
		// Get doi tuong as cong dan
		DoiTuongSuDung doiTuong = DoiTuongSuDungLocalServiceUtil.findByMa(maOrg);
		
		// Get ten doi tuong as organization name
		return doiTuong.getTen();
	}
}
