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

package org.oep.cmon.util;

import static org.oep.cmon.Constants.DATE_FORMAT;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.oep.cmon.Constants;


/** 
 * This is class DateUtil
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class DateUtil {

	/** 
	 * This is function parseStringToDate
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param data
	 * @return Date
	 */
	public static Date parseStringToDate(String data) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat(
					Constants.DATE_FORMAT);
			return parser.parse(data);
		} catch (Exception es) {
		}
		return null;
	}

	/** 
	 * This is function parseDateToString
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param data
	 * @return String
	 */
	public static String parseDateToString(Date data) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat(
					Constants.DATE_FORMAT);
			return parser.format(data);
		} catch (Exception es) {
		}
		return null;
	}

	/** 
	 * This is function getCurrentDate
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @return Date
	 */
	public static java.util.Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/** 
	 * This is function getCurrentDateTime
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @return Date
	 */
	public static java.util.Date getCurrentDateTime() {
		return new java.util.Date();
	}
	
	/** 
	 * This is function equalDateByDay
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param date1
	 * @param date2
	 * @return int
	 */
	public static int equalDateByDay(Date date1,Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		//so sanh theo nam
		
		if(cal1.get(Calendar.YEAR) >cal2.get(Calendar.YEAR)){
			return 1;
		}else if(cal1.get(Calendar.YEAR) <cal2.get(Calendar.YEAR)){
			return -1;
		}else{
			//so sanh theo thang
			if(cal1.get(Calendar.MONTH) >cal2.get(Calendar.MONTH)){
				return 1;
			}else if(cal1.get(Calendar.MONTH) <cal2.get(Calendar.MONTH)){
				return -1;
			}else{
				//so sanh theo ngay
				
				if(cal1.get(Calendar.DAY_OF_MONTH) >cal2.get(Calendar.DAY_OF_MONTH)){
					return 1;
				}else if(cal1.get(Calendar.DAY_OF_MONTH) <cal2.get(Calendar.DAY_OF_MONTH)){
					return -1;
				}else{
					return 0;
				}
			}
		}
			
		
		
	}



}
