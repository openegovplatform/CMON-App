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

package org.oep.cmon.portlet.transaction.action;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.oep.sharedservice.cmon.Constants;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;
import org.oep.cmon.dao.dvc.service.DanhMucUngDungLocalServiceUtil;

import com.liferay.portal.kernel.servlet.SessionMessages;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

/**
*
* CustomConfigurationAction class
*   
* This class is used to get information 
* from database
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class CustomConfigurationAction implements com.liferay.portal.kernel.portlet.ConfigurationAction {
	/**
	  * This is fucntion processAction
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse
	  * @return void
	  */
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String cmd = ParamUtil.getString(actionRequest, com.liferay.portal.kernel.util.Constants.CMD);
		if (!cmd.equals(com.liferay.portal.kernel.util.Constants.UPDATE)) {
			return;
		}
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		List<DanhMucUngDung> ungDungs = DanhMucUngDungLocalServiceUtil.getDSUngDung(Constants.ACTIVATED);
		if (ungDungs != null) {
			for (int i = 0; i < ungDungs.size(); i++) {
				DanhMucUngDung instance = (DanhMucUngDung) ungDungs.get(i);
				String maUngDung = instance.getMa().trim().toLowerCase();
				String paramName = maUngDung + "Name";
				String paramId = maUngDung + "Id";
				String portletId = ParamUtil.getString(actionRequest, paramId);
				String portletName = ParamUtil.getString(actionRequest, paramName);

				prefs.setValue(paramId, portletId);
				prefs.setValue(paramName, portletName);
			}
		}

		// added by phucnv 2014/03/19
		String processingProfilePrefParamName = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;
		String processingProfilePrefParamValue = ParamUtil.getString(actionRequest, processingProfilePrefParamName);
		prefs.setValue(processingProfilePrefParamName, processingProfilePrefParamValue);
		// end adding by phucnv 2014/03/19

		prefs.store();
		// PortletSession portletSession = actionRequest.getPortletSession();
		SessionMessages.add(actionRequest, portletConfig.getPortletName() + ".doConfigure");
	}

	/**
	  * This is fucntion render config view 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletConfig portletConfig, RenderRequest actionRequest, RenderResponse actionResponse
	  * @return String 
	  */
	@Override
	public String render(PortletConfig portletConfig, RenderRequest actionRequest, RenderResponse actionResponse) throws Exception {
		return "/html/portlet/transaction/config.jsp";
	}
}
