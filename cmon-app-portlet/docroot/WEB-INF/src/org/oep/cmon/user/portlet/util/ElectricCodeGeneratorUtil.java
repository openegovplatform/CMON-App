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

package org.oep.cmon.user.portlet.util;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * Citizen electric code generator
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE         AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  4-March-2013  Nam Dinh    Create new
 */
public class ElectricCodeGeneratorUtil {

	/**
	 * Constructor
	 */
	private ElectricCodeGeneratorUtil () {
		// Do nothing, this constructor will prevent user from initializing this class
	}
	
	/**
	 * Generate code by province code
	 * 
	 * @param provinceCode
	 * @param birthDate
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static String generateCode(String provinceCode, Date birthDate, long provinceId) throws PortalException, SystemException{
		// Get province id
		return generateCode(provinceId, birthDate );
	}
	
	
	/**
	 * Generate citizen electronic code
	 * 
	 * @return
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	@SuppressWarnings("unchecked")
	public static String generateCode(long provinceId, Date birthDate) throws PortalException, SystemException{
		// Truncate time portion in date object
		Date birthDay = DateUtil.truncateTimePortion(birthDate);
		
		// Check in database if there's existing person with the same birth day and province code
		DynamicQuery queryCongDan = DynamicQueryFactoryUtil.forClass(CongDan.class);		
		queryCongDan = queryCongDan.add(PropertyFactoryUtil.forName("ngaySinh").eq(birthDay));
		queryCongDan = queryCongDan.add(RestrictionsFactoryUtil.eq("diaChiThuongTruTinhId",provinceId));
		
		
		// Order by MaCongDan desc
		queryCongDan = queryCongDan.addOrder(OrderFactoryUtil.desc("ma"));
		
		// Query data
		List<CongDan> results = null;
		try {
			results = CongDanLocalServiceUtil.dynamicQuery(queryCongDan);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		if ( results.size() > 0 ) {
			// In case there's existing user with the same birth day and province
			CongDan congDan = results.get(0);	
			
			// Get citizen code
			String czCodeString = congDan.getMa();
			
			DecimalFormat nf = new DecimalFormat("0");			
			
			// Get the code portion from citizen code (the last one is lun digit)
			String code = czCodeString.substring(0, czCodeString.length() - 1);
			
			// increment code by 1
			code = nf.format( Double.parseDouble(code) + 1 );
			
			String checkDigit = LunUtil.generateDigit(code);
			
			return ( code + checkDigit);
		}
		
		// Generate brand new citizen code should goes here
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthDate);
		
		// Get the year portion from birth date
		int year = cal.get(Calendar.YEAR);
		
		// Get the day indicating number of day in the year, the first day of year will be 1/1
		int dayTh = cal.get(Calendar.DAY_OF_YEAR);
		
		// Sequence number
		int seq = 1;
		
		// Get province code from province ID
		String provinceCode = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(provinceId).getMa();
		
		String citizenCode = provinceCode + StringUtil.pad(String.valueOf(dayTh), '0', 3, false) + year + StringUtil.pad(String.valueOf(seq), '0', 3, false) ;
		
		// Adding check digit
		citizenCode += LunUtil.generateDigit(citizenCode);
		
		return citizenCode;		
	}
}
