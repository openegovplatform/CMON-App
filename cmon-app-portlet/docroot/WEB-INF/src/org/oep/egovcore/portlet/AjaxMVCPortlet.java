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

package org.oep.egovcore.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.oep.egovcore.util.LiferayURL;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author hoangtrung.nguyen
 */
/**
*
* AjaxMVCPortlet abstract class
*   
* This class is used to declare AjaxMVCPortlet 
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
public abstract class AjaxMVCPortlet extends MVCPortlet {
	
	public static final Log _log = LogFactoryUtil.getLog(AjaxMVCPortlet.class);
	
	public static final String KEY_AJAX_RESPONSE = "AjaxResponse";
	
	/*
	 * Khong overwrite method nay
	 * Neu muon su dung resource request cua liferay
	 * 		 thi chi can extends class nay
	 * 		va code phuong thuc co ten = ten cua resourceID truyen tu <portlet:resourceURL/>
	 * 
	 * Vi du: can download 1 file bang resource request
	 * 	thi tao url o jsp: <portlet:resourceURL id="downloadFileXYZ"/>
	 *  sau do tao class va method nhu sau:
	 *  class XYZPortlet extends AjaxMVCPortlet {
	 *  	public void downloadFileXYZ(ResourceRequest request, ResourceResponse response) {
	 *  		// code gi tuy` thich'
	 *  	}
	 *  }
	 * 
	 */
	
	
	/**
	  * This is fucntion serveResource
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, ResourceResponse response
	  * @return void
	  */
	public final void serveResource(ResourceRequest request, ResourceResponse response)
		throws IOException, PortletException 
	{
		
		// Tên method
		String methodName = request.getResourceID();
		int status = AjaxResponse.STATUS_OK;
		Method method = null;
		String contentType = request.getContentType();
		UploadPortletRequest urequest = null;
		AjaxResponse ajaxResponse = new AjaxResponse(response);;
		if (contentType != null && contentType.contains(ContentTypes.MULTIPART_FORM_DATA)) {
			urequest = PortalUtil.getUploadPortletRequest(request);
			if (urequest == null) {
				_log.error("UPLOADED FILES GET OVER THE LIMIT OF PORTAL");
				return;
			}
		}
			
		// Get the method and invoke it
		try {
			if (urequest != null) {
				
				urequest.setAttribute(KEY_AJAX_RESPONSE, ajaxResponse);
				
				if (LiferayURL.isAjaxRequest(urequest)) {
					method = this.getClass().getMethod(methodName, UploadPortletRequest.class, AjaxResponse.class);
					method.invoke(this, urequest, ajaxResponse);
				} else {
					method = this.getClass().getMethod(methodName, UploadPortletRequest.class, ResourceResponse.class);
					method.invoke(this, urequest, response);
				}
				
			} else {
				
				request.setAttribute(KEY_AJAX_RESPONSE, ajaxResponse);

				if (LiferayURL.isAjaxRequest(request)) {
					method = this.getClass().getMethod(methodName, ResourceRequest.class, AjaxResponse.class);
					method.invoke(this, request, ajaxResponse);
				} else {
					method = this.getClass().getMethod(methodName, ResourceRequest.class, ResourceResponse.class);
					method.invoke(this, request, response);
				}
				
			}
		} catch (Exception e) {
			
			// Exception do method ném ra
			if (urequest != null) {
				if (e instanceof InvocationTargetException) {
					handleException(((InvocationTargetException)e).getTargetException(), urequest, response);
				} else {
					handleException(e, urequest, response);
				}
			} else {
				if (e instanceof InvocationTargetException) {
					handleException(((InvocationTargetException)e).getTargetException(), request, response);
				} else {
					handleException(e, request, response);
				}
			}
			
			status = AjaxResponse.STATUS_EXCEPTION;
		}
		
		if (ajaxResponse.isUsed()) {
			ajaxResponse.setStatus(status);
			PrintWriter writer = response.getWriter();
			response.setCharacterEncoding(StringPool.UTF8);
			if (urequest != null) {
				response.setContentType(ContentTypes.TEXT_HTML);
			} else {
				response.setContentType(ContentTypes.APPLICATION_JSON);
			}
			writer.write(ajaxResponse.getOutput().toString());
			writer.flush();
			writer.close();
		}
	}
	/**
	  * This is fucntion getAjaxResponse
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request
	  * @return AjaxResponse
	  */
	public static AjaxResponse getAjaxResponse(ResourceRequest request) {
		return (AjaxResponse) request.getAttribute(KEY_AJAX_RESPONSE);
	}
	/**
	  * This is fucntion getAjaxResponse 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param UploadPortletRequest
	  * @return AjaxResponse
	  */
	public static AjaxResponse getAjaxResponse(UploadPortletRequest request) {
		return (AjaxResponse) request.getAttribute(KEY_AJAX_RESPONSE);
	}
	/**
	  * This is fucntion handleException 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Throwable e, UploadPortletRequest request, ResourceResponse response
	  * @return void
	  */
	public void handleException(Throwable e, UploadPortletRequest request, ResourceResponse response) {
		_log.error(e);
		getAjaxResponse(request).sendMessage("[SERVER_ERROR] " +  ExceptionUtils.getRootCauseMessage(e));
	}
	/**
	  * This is fucntion handleException 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Throwable e, ResourceRequest request, ResourceResponse response
	  * @return void
	  */
	public void handleException(Throwable e, ResourceRequest request, ResourceResponse response) {
		_log.error(e);
		getAjaxResponse(request).sendMessage("[SERVER_ERROR] " +  ExceptionUtils.getRootCauseMessage(e));
	}
}
