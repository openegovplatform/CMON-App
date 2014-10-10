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

package org.oep.cmon.portlet.admin.congchuc.utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;


import com.liferay.counter.service.CounterLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;

import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;


/**
 * This is class LiferayUtils
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class LiferayUtils {
	
	/**
	 * This is  function change password of CongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userId: userId of liferay this is value of column taikhoannguoidungid in table  : cmon_taikhoannguoidung
	 * @param password
	 * @param rePassword
	 * @return boolean
	 */
	public static boolean changePassword(long userId,String password,String rePassword){
		try{
			UserLocalServiceUtil.updatePassword(userId, password, rePassword, false);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	/**
	 * This is function delete auser of liferay By userid
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userId: userId of liferay this is value of column taikhoannguoidungid in table  : cmon_taikhoannguoidung
	 * @return boolean
	 */
	public static boolean removeUser(long userId){
		try{
			UserLocalServiceUtil.deleteUser(userId);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

	/**
	 *  This is function create user liferay for congchuc
	 *  step 1: get organization of CongChuc 
	 *  step 2: create account liferay with ogranization 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param hoVaTen
	 * @param email
	 * @param password
	 * @param rePassword
	 * @param creatorUserId
	 * @param compnayId
	 * @return boolean
	 */
	public static boolean addUser(String hoVaTen,String email,String password,String rePassword,long creatorUserId,long compnayId){
		try{
			boolean autoPassword =false;
			String screenName = getScreenNameByEmail(email);
			boolean autoScreenName = false;
			long facebookId = 0;
			String openId = StringPool.BLANK;
			Locale locale = LocaleUtil.getDefault();
			String firstName =hoVaTen;
			String middleName = screenName;
			String lastName =screenName;
			int prefixId = 0;
			
			int suffixId = 0;
			boolean male = true;
			
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
			
			//for set organization
			String orgName = getOrganizationForCanBo();
			Organization organization = null;
			try {
				 organization = OrganizationLocalServiceUtil.getOrganization(compnayId, orgName);
				 organizationIds = new long[]{organization.getOrganizationId()};
				 
			} catch (Exception es) {
			}
			

			ServiceContext serviceContext = new ServiceContext();
			User user = UserLocalServiceUtil.addUser(
				creatorUserId, compnayId, autoPassword, password, rePassword,
				autoScreenName, screenName, email, facebookId, openId,
				locale, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
				organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		
				
	 }
	
	/**
	 *  This is function add User Group to liferay
	 * @param creatorUserid
	 * @param companyId
	 * @param userGroupName
	 * @return
	 */
	/**
	 * This is  function change password of CongChuc
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userId: userId of liferay this is value of column taikhoannguoidungid in table  : cmon_taikhoannguoidung
	 * @param password
	 * @param rePassword
	 * @return boolean
	 */
	public UserGroup addUserGroup(long creatorUserid,long companyId,String userGroupName){
		
		try {
			UserGroup  userGroup =UserGroupLocalServiceUtil
					.addUserGroup(creatorUserid, companyId, userGroupName, userGroupName);
			return userGroup;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	/**
	 * This is  function remove/delete UserGroup
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userGroupId
	 * @return boolean
	 */
	public boolean removeUserGroup(long userGroupId){
		
		try {
			UserGroupLocalServiceUtil.deleteUserGroup(userGroupId);
			return true;
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * This is  function unset role group
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param userGroup
	 * @param companyId
	 * @return boolean
	 */
	public  boolean unsetRoleGroups(UserGroup userGroup,long companyId){
		try{
			//delete all role assign for Group
			List<Role> rList = RoleLocalServiceUtil.getRoles(companyId);
			if(rList != null){
				for (Role role : rList) {
					try{
						GroupLocalServiceUtil.unsetRoleGroups(role.getRoleId(), new long[]{userGroup.getGroup().getGroupId()});
						
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}	
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	/**
	 * This is  function add User to UserGroup
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param groupId
	 * @param userGroupId
	 * @param userId
	 * @return boolean
	 */
	public boolean addUserToUserGroup(long groupId,long userGroupId,long userId){
		try{
		
			long[] userIds = {userId};	
	
			UserLocalServiceUtil.addGroupUsers(groupId, userIds);
			
		
			UserLocalServiceUtil.addUserGroupUsers(userGroupId, userIds);
				
			
			
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * This is  function remove User from UserGroup
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param companyId
	 * @param groupId
	 * @param userGroupId
	 * @param userId
	 * @return boolean
	 */
	public boolean removeUserFromUserGroup(long companyId,long groupId,long userGroupId,long userId){
		try{
			
			long[] groupIds = {groupId};
			long[] userIds = {userId};	
		
			UserLocalServiceUtil.unsetUserGroupUsers(userGroupId, userIds);
			
			GroupLocalServiceUtil.unsetUserGroups(userId, groupIds);
			
			
			
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * This is  function auto create screen name by email
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param email
	 * @return String
	 */
		private  static String getScreenNameByEmail(String email){
				
				
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
		
		/**
		 * This is  function get default organization for citizen
		 * Version: 1.0
		 *  
		 * History: 
		 *   DATE        AUTHOR      DESCRIPTION 
		 *  ------------------------------------------------- 
		 *  3-March-2013  Nam Dinh    Create new
		 * @return String
		 */
		private static String getOrganizationForCanBo() {
			try {
				String maOrg = WebserviceFactory.getThamSoService().getValue("CMON_ADMIN_CONG_CHUC_ORGANIZATION_ID");
				if (maOrg.length() == 0) {
					maOrg = "CB";
				}
				return DoiTuongSuDungLocalServiceUtil.findByMa(maOrg).getTen();
			} catch (SystemException e) {
				e.printStackTrace();
			}

			return "";
		}	
	
}
