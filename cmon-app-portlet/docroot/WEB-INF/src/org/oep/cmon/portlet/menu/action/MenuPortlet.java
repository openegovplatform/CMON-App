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

package org.oep.cmon.portlet.menu.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.oep.cmon.portlet.menu.util.MenuConstraint;


import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class MenuPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class MenuPortlet extends MVCPortlet {

	
	/**
	 * This is function processAction
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String param = ParamUtil.get(actionRequest, MenuConstraint.SESSION_MENU_SELECTED,"");
		actionRequest.getPortletSession(true).setAttribute(MenuConstraint.SESSION_MENU_SELECTED, param ,PortletSession.APPLICATION_SCOPE);
		
		PortletSession session = actionRequest.getPortletSession();
	    session.setAttribute(MenuConstraint.SESSION_MENU_SELECTED,param ,PortletSession.APPLICATION_SCOPE);
	    

	    actionResponse.sendRedirect(ParamUtil.getString(actionRequest, MenuConstraint.SESSION_MENU_SELECTED));
	    
		
	}
 

}
