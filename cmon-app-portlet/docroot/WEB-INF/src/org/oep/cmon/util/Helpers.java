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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.util.StringUtil;

/** 
 * This is abstract class Helpers
 * 
 * This class contains logics related to cmon_conghuc table
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public abstract class Helpers {
	/** 
	 * This is function insert CongChuc
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param userRequest
	 * @param request
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean isEmpty(String value) {
		return value == null || "".equals(StringUtil.trim(value));
	}

	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.size() == 0;
	}

	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return map == null || map.size() == 0;
	}

	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	public static boolean equals(String value1, String value2) {
		return value1 != null && value1 != null
				&& value1.equalsIgnoreCase(value2);
	}
	public static String toInputHtml(String input) {
		return input == null ? "" : input;
	}
	public static String toInputHtml(Date input) {
		return (String) (input == null ? "" : input.toString());
	}
	public static String toInputHtml(Integer input) {
		return (String) ((input == null || input==0 ) ? "" : input.toString());
	}
	public static String toInputHtml(Long input) {
		return (String) ((input == null || input==0 ) ? "" : input.toString());
	}
	
}
