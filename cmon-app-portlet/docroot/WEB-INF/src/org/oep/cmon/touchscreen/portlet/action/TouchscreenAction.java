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

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is class TouchscreenAction  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class TouchscreenAction extends MVCPortlet {

	/**
	 * This is function tracuuHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void tracuuHoSo(ActionRequest request, ActionResponse response)
			throws Exception {
//		TestWebservice abc = new TestWebserviceService().getTestWebservicePort();
		String masohs = ParamUtil.getString(request, "masohs");
		if(!masohs.equals("")){
			masohs = masohs.replace(".","").trim();
			if(Validator.isNumber(masohs)){
				HoSoTTHCCong hoSoTTHCCong = new HoSoTTHCCongImpl();
				List<HoSoTTHCCong> listhoso =  HoSoTTHCCongLocalServiceUtil.findByMaSoBienNhan(masohs);
				if(listhoso.size()>0){
					hoSoTTHCCong = listhoso.get(0);
					request.setAttribute("hoso",hoSoTTHCCong);
				}
				
			}
		}
		response.setRenderParameter("jspPage","/html/portlet/touchscreen/view.jsp");
		response.setRenderParameter("viewPage","/html/portlet/touchscreen/lookupdetails.jsp");
		response.setRenderParameter("masohs",masohs);
	}
}
