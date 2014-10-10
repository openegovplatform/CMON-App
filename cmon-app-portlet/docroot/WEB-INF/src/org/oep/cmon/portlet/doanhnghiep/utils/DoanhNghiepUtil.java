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

package org.oep.cmon.portlet.doanhnghiep.utils;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.oep.cmon.portlet.admin.congchuc.utils.LiferayUtils;

import org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDungClp;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import vn.dtt.sharedservice.WebserviceFactory;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.User;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

public class DoanhNghiepUtil {
	
	public static TaiKhoanNguoiDung addTaiKhoanDoanhNghiep(long companyId,long creatorUserId,String shortName,String email,String password,String rePassword,String giaTriCauHinhLoaiDoiTuong){
		
		try{
			boolean autoPassword =false;
			String screenName = getScreenNameByEmail(email);
			boolean autoScreenName = false;
			long facebookId = 0;
			String openId = StringPool.BLANK;
			Locale locale = LocaleUtil.getDefault();
			String firstName =shortName;
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
			String orgName = getOrganizationNameByObjectType(giaTriCauHinhLoaiDoiTuong);
			Organization organization = null;
			try {
				 organization = OrganizationLocalServiceUtil.getOrganization(companyId, orgName);
				 organizationIds = new long[]{organization.getOrganizationId()};
				 
			} catch (Exception es) {
			}
			

			ServiceContext serviceContext = new ServiceContext();
			User user = UserLocalServiceUtil.addUser(
				creatorUserId, companyId, autoPassword, password, rePassword,
				autoScreenName, screenName, email, facebookId, openId,
				locale, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
				organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
			
			//add tai khoan to cmon_taikhonanguoidung
			if(user != null){
				return addTaiKhoanNguoiDung(user);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	
	
	/**
	 * This is function remove taikhoan of doanh nghiep
	 * @param companyId
	 * @param email
	 * @return
	 */
	
	public static boolean removeTaiKhoanDoanhNghiep(long companyId,String email){
		
		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);
			if(user != null){
				UserLocalServiceUtil.deleteUser(user.getUserId());
				List<TaiKhoanNguoiDung> tList = TaiKhoanNguoiDungLocalServiceUtil.findByEmail(email);
				if(tList != null){
					for (TaiKhoanNguoiDung taiKhoanNguoiDung : tList) {
						TaiKhoanNguoiDungLocalServiceUtil.deleteTaiKhoanNguoiDung(taiKhoanNguoiDung.getId());
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
			
	}
	
	
	/**
	 *  This is fuction change password for doanhnghiep
	 * @param userId: userId of liferay this is value of column taikhoannguoidungid in table  : cmon_taikhoannguoidung
	 * @param password
	 * @param rePassword
	 * @return
	 */
	
	public static boolean changePassword(long userId,String password,String rePassword){
		return LiferayUtils.changePassword(userId, password, rePassword);
		
	}
	
	
	
	
	
	
	private static TaiKhoanNguoiDung addTaiKhoanNguoiDung(User user) throws SystemException{
		TaiKhoanNguoiDung model = new TaiKhoanNguoiDungClp();
		long id = CounterLocalServiceUtil.increment("cmon_taikhoannguoidung");
		model.setId(id);
		model.setTaiKhoanNguoiDungId(user.getUserId());
		model.setEmail(user.getEmailAddress());
		model.setDaXoa(0);
		model.setLoaiDoiTuongId(1L);
		model.setNgayTao(new Date());
		model.setNguoiTao(user.getEmailAddress());
		model.setTenDangNhap(user.getScreenName());
		model.setMatKhau(user.getPassword());
		model.setTenDangNhap(user.getFirstName());
		model.setTenNguoiDung(user.getFullName());
		return TaiKhoanNguoiDungLocalServiceUtil.addTaiKhoanNguoiDung(model);
		
	}
	
	
	
	/**
	 * Get default organization for citizen
	 * 
	 * @return organization name
	 * @throws IOException 
	 * @throws SystemException 
	 */
	private static String getOrganizationNameByObjectType(String giaTriCauHinhLoaiDoiTuong) {
		try {
			
			return DoiTuongSuDungLocalServiceUtil.findByMa(giaTriCauHinhLoaiDoiTuong).getTen();
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return "DN";
	}	

	/**
	 * This is fuction auto create screen name by email
	 * @param email
	 * @return
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
}
