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

package org.oep.cmon.portlet.taocongdan.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.oep.cmon.portlet.taocongdan.util.FormatUtil;

import org.oep.cmon.dao.cd.model.CongDan;
import org.oep.cmon.dao.cd.service.CongDanLocalServiceUtil;
import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.TaiKhoanNguoiDungLocalServiceUtil;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
*
* TaoCongDanPortlet class
*   
* This class is used to process render view TaoCongDanPortlet
*
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
public class TaoCongDanPortlet extends MVCPortlet {
	
	private Log _log = LogFactoryUtil.getLog(TaoCongDanPortlet.class);
	
	
	/**
	  * This is fucntion serveResource
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest resourceRequest, ResourceResponse resourceResponse
	  * @return void
	  */
	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {
		
		String resourceId = resourceRequest.getResourceID();
		try
		{
			
			JSONObject  jsonFeed = JSONFactoryUtil.createJSONObject();
						
			if (resourceId.equals("listDVHC")) {
				long chaId = ParamUtil.getLong(resourceRequest, "DVHC_chaId");
				long id = ParamUtil.getLong(resourceRequest, "DVHC_id");
				List<DonViHanhChinh> hvhcList = new ArrayList<DonViHanhChinh>();
				if (chaId > 0) {
					hvhcList = DonViHanhChinhLocalServiceUtil.findByChaId(chaId, FormatUtil.DA_XOA_ACTIVATE);
				} else if (id > 0) {
					DonViHanhChinh donViHanhChinh;
					
					donViHanhChinh = DonViHanhChinhLocalServiceUtil.getDonViHanhChinh(id);
					if (donViHanhChinh != null) {
						hvhcList.add(donViHanhChinh);
					}
					
				}
				JSONObject jSONObject = JSONFactoryUtil.createJSONObject();
				if (!FormatUtil.isEmpty(hvhcList)) {
					for (DonViHanhChinh donViHanhChinh : hvhcList) {
						jSONObject.put(
								String.valueOf(donViHanhChinh.getId()),
								donViHanhChinh.getTen());
					}
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("UTF-8");
				resourceResponse.getWriter().write(jSONObject.toString());
				resourceResponse.flushBuffer();
			}
		}
		catch (Exception e) {
			_log.error("serveResource(): error", e);
		}

	}
 
	/**
	  * This is fucntion searchCongDanRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse
	  * @return void
	  */
	public void searchCongDanRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception 
	{
		String keyWord = ParamUtil.getString(actionRequest, "searchKeyWord");
		
		String typeTKNDId=ParamUtil.getString(actionRequest, "typeTKNDId");
						
		setSearchParameter(actionRequest, actionResponse);	
		actionResponse.setRenderParameter("searchKeyWord", keyWord);
		actionRequest.getPortletSession().setAttribute("searchKeyWord", keyWord);
		actionResponse.setRenderParameter("typeTKNDId", typeTKNDId);
		actionRequest.getPortletSession().setAttribute("typeTKNDId", typeTKNDId);
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_list.jsp");
		
	}
	
	/**
	  * This is fucntion deleteCongDanRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest,ActionResponse actionResponse
	  * @return void
	  */
	public void deleteCongDanRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {		
		String keyWord = actionRequest.getParameter("searchKeyWord");
		long congDanId = ParamUtil.getLong(actionRequest, "congDanId");
		try
		{
			CongDan congDan = CongDanLocalServiceUtil.fetchCongDan(congDanId);
			congDan.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
			congDan.setTaiKhoanNguoiDungId(null);
			CongDanLocalServiceUtil.updateCongDan(congDan);
			Long taiKhoanNDId = congDan.getTaiKhoanNguoiDungId();
			if(taiKhoanNDId!=null && taiKhoanNDId > 0)
			{
				TaiKhoanNguoiDung taiKhoanND=TaiKhoanNguoiDungLocalServiceUtil.fetchTaiKhoanNguoiDung(taiKhoanNDId);
				taiKhoanND.setDaXoa(FormatUtil.DA_XOA_DEACTIVATE);
				TaiKhoanNguoiDungLocalServiceUtil.updateTaiKhoanNguoiDung(taiKhoanND);
				
				long userId = taiKhoanND.getTaiKhoanNguoiDungId();
				if(userId > 0)
				{
					UserLocalServiceUtil.deleteUser(userId);
				}
			}
			
			actionRequest.setAttribute("delete_success", "delete_success");
			SessionMessages.add(actionRequest, "successDeleteTaiKhoan");	
	
		} catch (Exception es) {
				
			// TODO: handle exception
			FormatUtil.printException(es);
			SessionErrors.add(actionRequest, "errorDeleteTaiKhoan");				
		}
		// Hidden default error message
		setSearchParameter(actionRequest, actionResponse);
		FormatUtil.setParameter(actionRequest, actionResponse, keyWord);
		// Redirect to document list jsp
		actionResponse.setRenderParameter("jspPage", "/html/portlet/taocongdan/tao_cong_dan_list.jsp");

	}
	
	/**
	  * This is fucntion setSearchParameter
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest,	ActionResponse actionResponse
	  * @return void
	  */
	public void setSearchParameter(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		String cur = ParamUtil.getString(actionRequest, "cur");
		if (!FormatUtil.isEmpty(cur)) {
			actionResponse.setRenderParameter("cur",
					ParamUtil.getString(actionRequest, "cur"));
		}
		String delta = ParamUtil.getString(actionRequest, "delta");
		if (!FormatUtil.isEmpty(delta)) {
			actionResponse.setRenderParameter("delta",
					ParamUtil.getString(actionRequest, "delta"));
		}

	}

	/**
	  * This is fucntion setSearchParameter
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletURL portletURL, RenderRequest renderRequest
	  * @return void
	  */
	public void setSearchParameter(PortletURL portletURL, RenderRequest renderRequest) {
	
		String cur = ParamUtil.getString(renderRequest, "cur");
		String delta = ParamUtil.getString(renderRequest, "delta");
		
		PortletPreferences prefs = null;

		if (renderRequest != null) {
			prefs = renderRequest.getPreferences();
			if (prefs != null) {
				cur = prefs.getValue("curTK", cur);
				delta = prefs.getValue("deltaTK", delta);
			}
		}
		portletURL.setParameter("cur", cur);
		portletURL.setParameter("delta", delta);
	}
	

	/**
	  * This is fucntion addEditTaoCongDan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ActionRequest actionRequest, ActionResponse actionResponse 
	  * @return void
	  */
	public void addEditTaoCongDan(ActionRequest actionRequest, ActionResponse actionResponse 
			 ) throws Exception {
		new  TaoCongDanAction().addEditTaoCongDan(actionRequest, actionResponse);

		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		SessionMessages.add(actionRequest,  portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

	}
	
	
}
