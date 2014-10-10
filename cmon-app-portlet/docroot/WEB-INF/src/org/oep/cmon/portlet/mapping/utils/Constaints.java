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

package org.oep.cmon.portlet.mapping.utils;

import javax.portlet.PortletSession;

import com.liferay.portal.kernel.util.Validator;

/**
 * This is class Constaints
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Constaints {
	
	public static final String SYNCH_RUNNING="SYNCH_RUNNING";
	public static final String ACTION_SUCCESS="ACTION_SUCCESS";
	public static final String ACTION_ERRORS="ACTION_ERRORS";
	public static final String ACTION_SAVE="SAVE";
	
	public interface Document{
		public static final int NEW =0;
		public static final int APPROVED =1;
		public static final int REJECTED =-1;
		public static final int FROM_OTHER_DVC =2;
		
		public static final int chuaDoiChieu=0;
		public static final int doiChieuKhop=1;
		public static final int doiChieuKhongKhop=-1;
	}
	
	/**
	 * This is function isValidCMND
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param cmnd
	 * @throws boolean
	 */
	public static boolean isValidCMND(String cmnd) {
		if (Validator.isNull(cmnd)) return false;
		cmnd = cmnd.trim();
		if (Validator.isNumber(cmnd) && (cmnd.length() == 9 || cmnd.length() == 12)) {
			return true;
		}
		return false;
	}
	
	public interface Errors{
		public static final String MA_DNG_ISNULL ="MA_DNG_ISNULL";
		public static final String MA_KHAC_ISNULL ="MA_KHAC_ISNULL";
		public static final String TEN_DNG_ISNULL ="TEN_DNG_ISNULL";
		public static final String TEN_KHAC_ISNULL ="TEN_KHAC_ISNULL";
		public static final String BANG_DNG_ISNULL ="BANG_DNG_ISNULL";
		public static final String UNGDUNG_DNG_ISNULL ="UNGDUNG_DNG_ISNULL";
		public static final String SYSTEM ="SYSTEM";
	}
	
	/**
	 * This is function getValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @throws String
	 */
	public static String getValue(String value){
		if(value == null) return "";
		return value;
	}
	
	/**
	 * This is function getSessionValue
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param session
	 * @param name
	 * @param valueDefault
	 * @throws boolean
	 * @return String
	 */
	public static String getSessionValue(PortletSession session,String name,String valueDefault){
		if(session.getAttribute(name) == null){
			return valueDefault;
		}else{
			return (String)session.getAttribute(name);
		}
	}

}
