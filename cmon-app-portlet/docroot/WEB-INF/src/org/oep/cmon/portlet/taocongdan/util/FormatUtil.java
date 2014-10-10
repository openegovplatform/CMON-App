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

package org.oep.cmon.portlet.taocongdan.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.oep.cmon.dao.cd.model.CongDan;

import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;


/**
*
* FormatUtil class
*   
* This class is used to provide util
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
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
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
	  * This is fucntion parseDateToString
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String parseDateToString(Date date) {
		try {
			return formatDateShort.format(date);
		} catch (Exception es) {
		}
		return "";
	}
 
	/**
	  * This is fucntion isEmpty
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return boolean
	  */
	public static boolean isEmpty(String value) {
		return value == null || "".equals(StringUtil.trim(value));
	}
	
	/**
	  * This is fucntion isEmpty
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param List<T>
	  * @return boolean
	  */
	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.size() == 0;
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
	  * This is fucntion checkIfIsAValidEmail
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return boolean
	  */
	public static boolean checkIfIsAValidEmail(String email) {

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
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
			 //SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
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
	  * @return List<CongDan>
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
	
	/**
	  * This is fucntion getTenDayDu1
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongDan
	  * @return String
	  */
	public static String getTenDayDu1(CongDan congDan) {
	StringBuilder result = new StringBuilder();
	try {
		result.append(congDan.getHo());
		result.append(congDan.getDem());
		result.append(congDan.getTen());
	
		
	} catch (Exception e) {
	}
	return result.toString();
	}

	
	/**
	  * This is fucntion checkData
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long number1, Long number2
	  * @return String
	  */
	public static String checkData(Long number1, Long number2) {
		String out = StringPool.BLANK;
		if (number1 != null && number2 != null && number1.equals(number2)) {
			out = "selected";
		}
		return out;
	}
	
}

