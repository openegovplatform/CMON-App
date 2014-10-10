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

package org.oep.cmon.userreg.portlet.util;

/** 
 * This is class StringUtil
 * 
 * Use this class to pad n character to an existing string
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  12-Sept-2012  Nam Dinh    Create new
 */
public class StringUtil {
	
	/**
	 * This is function adding a sequence of character to an existing string
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param str
	 * @param c
	 * @param length
	 * @param rightSide (true: padding to the right, false: padding to the left)
	 * @return String
	 */
	public static String pad(String str, char c, int length, boolean rightSide){
		  
		String retstr = "";

		char[] ca = new char[length];
		
		for (int i = 0; i < ca.length; i++){
			ca[i] = c;
		}
		
		String buff = new String(ca);

		if (rightSide) {
			buff = str + buff;
			retstr = buff.substring(0, length);
		} else {
			buff = buff + str;
			retstr = buff.substring(buff.length() - length);
		}
		
		return retstr;
	}
}
