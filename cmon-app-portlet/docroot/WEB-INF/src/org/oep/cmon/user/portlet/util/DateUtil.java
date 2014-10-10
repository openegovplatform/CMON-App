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

import java.util.Calendar;
import java.util.Date;

/** 
 * Date utility class
 * This class contains method to manipulate date
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  12-Sept-2012  Nam Dinh    Create new
 */
public class DateUtil {
	
	public static Date truncateTimePortion(Date date) {
		// Get Calendar object set to the date and time of the given Date object  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(date);  
		  
		// Set time fields to zero  
		cal.set(Calendar.HOUR_OF_DAY, 0);  
		cal.set(Calendar.MINUTE, 0);  
		cal.set(Calendar.SECOND, 0);  
		cal.set(Calendar.MILLISECOND, 0);  
		  
		// Put it back in the Date object  
		date = cal.getTime();
		
		return date;		
	}
}
