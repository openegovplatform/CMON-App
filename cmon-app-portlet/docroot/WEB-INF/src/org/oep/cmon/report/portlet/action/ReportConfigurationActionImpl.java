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

package org.oep.cmon.report.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * This is class ReportConfigurationActionImpl  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ReportConfigurationActionImpl extends DefaultConfigurationAction {

	/**
	 * This is function processAction
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, com.liferay.portal.kernel.util.Constants.CMD);
		if (!com.liferay.portal.kernel.util.Constants.UPDATE.equals(cmd)) {
			return;
		}
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		String[] id_capcoquan = ParamUtil.getParameterValues(actionRequest,"id_capcoquan[]");
		prefs.setValues("id_capcoquan", id_capcoquan);
		prefs.store();
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

}
