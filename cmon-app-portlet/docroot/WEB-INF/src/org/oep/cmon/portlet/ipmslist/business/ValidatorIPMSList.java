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

package org.oep.cmon.portlet.ipmslist.business;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


/**
 * This is class ValidatorIPMSList
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public final class ValidatorIPMSList {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final Log LOG = LogFactoryUtil.getLog(ValidatorIPMSList.class);
	/**
	 * This is function checkDateValid
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 *  @param param
	 * @return boolean
	 */
	public static boolean checkDateValid(final String param) {
		if (param == null || param.isEmpty()) {
			LOG.info(" Show param :" + param);
			return true ;
        }
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT,Locale.getDefault());
        format.setLenient(false);
        Date date = format.parse(param, new ParsePosition(0));
        if (date != null) {
        	LOG.info(" Show Date :" + date);
        	return true ;
        }
        return false;

	}

}
