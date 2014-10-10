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

package org.oep.cmon.portlet.hosolienthong;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
 * This is class Config
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Config implements com.liferay.portal.kernel.portlet.ConfigurationAction {

	/**
	 * This is function processAction
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param config
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	public void processAction(PortletConfig config, ActionRequest request, ActionResponse response) throws Exception {
		String portletResource = ParamUtil.getString(request, "portletResource"); 
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
		prefs.setValue(HSLTFields.loaiDanhSach, ParamUtil.getString(request, HSLTFields.loaiDanhSach));
		prefs.store();
	}

	/**
	 * This is  function server resource
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @throws Exception
	 */
	@Override
	public String render(PortletConfig arg0, RenderRequest arg1,
			RenderResponse arg2) throws Exception {
		return "/html/portlet/hosolienthong/config.jsp";
	}
}
