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

package org.oep.cmon.portlet.ipmslist.action;

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
 * This is class Configuration
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class Configuration  implements com.liferay.portal.kernel.portlet.ConfigurationAction {
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
		//Doi voi Can bo xu ly
		String PrefParamName = org.oep.cmon.Constants.XuLyHoSo.PROCESSING_PROFILE_PREF_PARAM;
		String PrefParamValue = ParamUtil.getString(actionRequest, PrefParamName);
		
		prefs.setValue(PrefParamName, PrefParamValue);
		
		//Doi voi Vai tro xu ly
		String vaiTroParamName = org.oep.cmon.Constants.CanBoXuLy.PROCESSING_CAN_BO_PREF_PARAM;
		String vaiTroParamValue = ParamUtil.getString(actionRequest, vaiTroParamName);
		
		prefs.setValue(vaiTroParamName, vaiTroParamValue);

		
		// Save status hoso
		String statusPreParam =  org.oep.cmon.Constants.QuanLiHoSo.HSTTHCC_CURRENT_STATUS_PREF_PARAM;
		String statusPreParamValue = ParamUtil.getString(actionRequest, statusPreParam);
		prefs.setValue(statusPreParam, statusPreParamValue);
		
		// yeu cau rut ho so
		prefs.setValue(org.oep.cmon.Constants.QuanLiHoSo.YEU_CAU_RUT,  
				ParamUtil.getString(actionRequest, "yeucaurut"));
		
		prefs.store();
		// PortletSession portletSession = actionRequest.getPortletSession();
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
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	@Override
	public String render(PortletConfig portletConfig, RenderRequest actionRequest, RenderResponse actionResponse) throws Exception {
		return "/html/portlet/ipmslistportlet/config.jsp";
	}
}
