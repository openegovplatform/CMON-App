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

package org.oep.cmon.report.portlet.util;

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.servlet.SessionErrors;

/**
 * This is class ReportValidate  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ReportValidate {
	
	/**
	 * This is function validation inputDMBaocao
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param reportname
	 * @param url
	 * @param actionRequest
	 * @return boolean
	 */
	public static boolean validationInputDMBaocao(String reportname, String url, ActionRequest actionRequest) {
		if (reportname.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenBaoCao");
		}
		if (url.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyDuongDan");
		}
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is function validation inputDMRole
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param name
	 * @param actionRequest
	 * @return boolean
	 */
	public static boolean validationInputDMRole(String name,ActionRequest actionRequest) {
		if (name.trim().length() == 0) {
			SessionErrors.add(actionRequest, "emptyTenRole");
		}
		if (SessionErrors.isEmpty(actionRequest)) {
			return true;
		}
		return false;
	}
}
