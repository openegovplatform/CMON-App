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

package org.oep.cmon.admin.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.admin.portlet.util.ConvertUtil;

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.service.CoQuanQuanLyLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * This is class RoleByCoQuanQuanLy
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class RoleByCoQuanQuanLy {
	/**
	 * This is function create role for CoQuanQuanLy
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void createRoleByCoQuanQuanLy(ActionRequest actionRequest, ActionResponse actionResponse) {
		String listCoQuanQuanLyId = ParamUtil.getString(actionRequest, "listCoQuanQuanLyId");
		String[] listId = listCoQuanQuanLyId.trim().split(",");
		if (listCoQuanQuanLyId.trim().length() > 0 && listId.length > 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			for (String coQuanQuanLyId : listId) {
				if (ConvertUtil.convertToLong(coQuanQuanLyId) > 0) {
					try {
						CoQuanQuanLy coQuanQuanLy = CoQuanQuanLyLocalServiceUtil.getCoQuanQuanLy(ConvertUtil.convertToLong(coQuanQuanLyId));
					} catch (Exception es) {
						es.printStackTrace();
					}
				}
			}
		}
	}
}
