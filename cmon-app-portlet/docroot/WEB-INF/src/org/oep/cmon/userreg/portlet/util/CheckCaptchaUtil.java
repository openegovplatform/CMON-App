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

import java.util.Enumeration;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

/** 
 * Captcha utility class
 * 
 * This class contains all utility method regarding captcha
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-April-2013  Nam Dinh    Create new
 */
public class CheckCaptchaUtil {

	
	/**
	 * This is function check if captcha text is true
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @throws request
	 * @throws captchaField
	 * @return boolean
	 */
	public static boolean isTrue(PortletRequest request, String captchaField) {
        String enteredCaptchaText = ParamUtil.getString(request, captchaField);

        PortletSession session = request.getPortletSession();
        
        String captchaText = getCaptchaValueFromSession(session);
        
        if (Validator.isNull(captchaText)) {
            return false;
        }
        
        if (!enteredCaptchaText.equals(captchaText)) {
            return false;
        }
        
        return true;
    }
	
	/**
	 * This is function get captcha text from session
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param session
	 * @return String
	 */
    private static String getCaptchaValueFromSession(PortletSession session) {
        Enumeration<String> atNames = session.getAttributeNames();
        
        while (atNames.hasMoreElements()) {
            String name = atNames.nextElement();
            if (name.contains("CAPTCHA_TEXT")) {
                return (String) session.getAttribute(name);
            }
        }
        
        return null;
    }
}
