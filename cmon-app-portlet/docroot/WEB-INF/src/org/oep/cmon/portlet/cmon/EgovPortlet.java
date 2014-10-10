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

package org.oep.cmon.portlet.cmon;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.oep.cmon.Constants;
import org.oep.cmon.util.CmonFields;
import org.oep.egovcore.language.CmonMessagerUtil;
import org.oep.egovcore.portlet.AjaxMVCPortlet;
import org.oep.egovcore.portlet.AjaxResponse;
import org.oep.egovcore.util.StringPool;

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is abstract class EgovPortlet
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class EgovPortlet extends AjaxMVCPortlet {
	
	public static final String NOAUTH_JSP_PATH = "/html/portlet/noauth.jsp";
	public static final String ERROR_JSP_PATH = "/html/portlet/error.jsp";
	
	public void captcha(ResourceRequest request, ResourceResponse response) throws IOException {
		CaptchaUtil.serveImage(request, response);
	}
	
	public void handleNonExistResourceRequest(ResourceRequest request, AjaxResponse ajaxResponse) {
		ajaxResponse.sendErrorMessage(
			CmonMessagerUtil.sub("message.khong_con_ton_tai", CmonMessagerUtil.get("label.hoSo"))
		);
		ajaxResponse.redirect("/");
	}
	
	public void forward2NoAuthPage(RenderRequest request, RenderResponse response) throws IOException, PortletException {
		include(NOAUTH_JSP_PATH, request, response);
	}
	
	public void getListDVHCByParent(ResourceRequest request, AjaxResponse ajaxResponse) {
		
		List<DonViHanhChinh> list =
			DonViHanhChinhLocalServiceUtil.findByChaId(ParamUtil.getLong(request, CmonFields.chaId), Constants.ACTIVE); 
		JSONArray dataJSON = JSONFactoryUtil.createJSONArray();
		for (DonViHanhChinh dvhc : list) {
			dataJSON.put(
				JSONFactoryUtil.createJSONObject()
					.put(CmonFields.id, dvhc.getId())
					.put(CmonFields.ten, dvhc.getTen())
			);
		}
		
		ajaxResponse.send("data", dataJSON);
	}
	
	public void processAction(ActionRequest request, ActionResponse response) {
		try {
			super.processAction(request, response);
		} catch (Exception e) {
			_log.error(e);
			request.setAttribute("exception", e);
			response.setRenderParameter(StringPool.JSP_PAGE, ERROR_JSP_PATH);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(EgovPortlet.class);
}