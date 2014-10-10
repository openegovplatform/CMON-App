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

package org.oep.cmon.portlet.thamso.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;

/**
*
* FormatUtil class
*   
* This class is used to process Format
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class FormatUtil {
	
	public static int DA_XOA_DEACTIVATE = 1;
	public static int DA_XOA_ACTIVATE= 0;
	
	private static SimpleDateFormat formatDateShort = new SimpleDateFormat("dd/MM/yyyy");

	/**
	  * This is fucntion getFormatDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
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
	  * This is fucntion convertToInt
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
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
	  * This is fucntion convertToLong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
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
	  * This is fucntion parseStringToDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return Date
	  */
	public static Date parseStringToDate(String data) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
			return parser.parse(data);
		} catch (Exception es) {
		}
		return null;
	}
	
	/**
	  * This is fucntion formatInteger
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
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
	  * This is fucntion setParameter
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse, String value
	  * @return void
	  */
	public static void setParameter(ActionRequest actionRequest, ActionResponse actionResponse, String value) {
		if (value != null) {
			actionResponse.setRenderParameter("searchKeyWord", value);
		}

		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}
	
	/**
	  * This is fucntion printError
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return void
	  */
	public static void printError(String err) {
		System.out.println(err);
	}
	
	/**
	  * This is fucntion printException
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Exception
	  * @return void
	  */
	public static void printException(Exception err) {
		err.printStackTrace();
	}
}
