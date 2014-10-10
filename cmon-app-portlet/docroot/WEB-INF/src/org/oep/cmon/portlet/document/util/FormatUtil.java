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

package org.oep.cmon.portlet.document.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;

import org.oep.cmon.admin.portlet.util.ConvertUtil;


import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;


/**
 * This is class FormatUtil
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class FormatUtil {
	
	public static int DA_XOA_DEACTIVATE = 1;
	public static int DA_XOA_ACTIVATE= 0;
	
	private static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * This is function getFormatDate
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */    
	public static String getFormatDate(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
	/**
	 * This is function convertToInt
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return int
	 */    
	public static int convertToInt(String value) {
		try {
			return Integer.parseInt(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/**
	 * This is function convertToLong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return long
	 */    
	public static long convertToLong(String value) {
		try {
			return Long.parseLong(value.trim());
		} catch (Exception es) {
		}
		
		return 0;
	}
	
	/**
	 * This is function parseStringToDate
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param data
	 * @return Date
	 */    
	public static Date parseStringToDate(String data) {
		try {
			 //SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
			return parser.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	/**
	 * This is function formatInteger
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param data
	 * @return Integer
	 */    
	public static Integer formatInteger(String data) {
		try {
			return Integer.parseInt(data.trim());
		} catch (Exception es) {
		}
		return null;
	}
	
	/**
	 * This is function parseDateToTring
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */    
	public static String parseDateToTring(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}

	/**
	 * This is function setParameter
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @param value
	 */ 
	public static void setParameter(ActionRequest actionRequest, ActionResponse actionResponse, String value) {
		if (value != null) {
			actionResponse.setRenderParameter("searchKeyWord", value);
		}

		// Hidden default error message
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	 * This is function search printError
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param err
	 */    
	public static void printError(String err) {
		System.out.println(err);
	}
	
	/**
	 * This is function printExceptiony
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param err
	 */    
	public static void printException(Exception err) {
		err.printStackTrace();
	}
	
	/**
	 * This is function setParams
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resourceRequest
	 */    
	public static void setParams(ActionRequest resourceRequest) {
		Enumeration<String> listName = resourceRequest.getParameterNames();
		String values = "";
		while (listName.hasMoreElements()) {
			values = listName.nextElement();
			resourceRequest.setAttribute(values,
					ParamUtil.getString(resourceRequest, values));
		}
	}
	
	/**
	 * This is function getValueLong
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resHttpServletRequest
	 * @param key
	 * @return long
	 */    
	public static long getValueLong(HttpServletRequest resHttpServletRequest,
			String key) {
		try {
			if (resHttpServletRequest.getAttribute(key) != null) {
				return ConvertUtil.convertToLong(resHttpServletRequest.getAttribute(key)
						.toString().trim());
			}
		} catch (Exception es) {
		}

		return 0;
	}

	/**
	 * This is function getValueString
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param resHttpServletRequest
	 * @param key
	 * @return String
	 */    
	public static String getValueString(
			HttpServletRequest resHttpServletRequest, String key) {
		try {
			if (resHttpServletRequest.getAttribute(key) != null) {
				return resHttpServletRequest.getAttribute(key).toString()
						.trim();
			}
		} catch (Exception es) {
		}

		return "";
	}
}
