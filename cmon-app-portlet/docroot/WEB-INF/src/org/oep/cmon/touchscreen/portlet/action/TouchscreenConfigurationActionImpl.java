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

package org.oep.cmon.touchscreen.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * This is class TouchscreenConfigurationActionImpl  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TouchscreenConfigurationActionImpl extends DefaultConfigurationAction {


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
		String id_donvi = ParamUtil.getString(actionRequest, "id_donvi");
		prefs.setValues("id_capcoquan", id_capcoquan);
		prefs.setValue("id_donvi",id_donvi);
		prefs.store();
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}
	
	/**
	 * This is function render
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param config
	 * @param renderRequest
	 * @param renderResponse
	 * @throws Exception
	 * @return String
	 */
	@Override
	public String render(PortletConfig config, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/portlet/touchscreen/configuration.jsp";
	}

}
