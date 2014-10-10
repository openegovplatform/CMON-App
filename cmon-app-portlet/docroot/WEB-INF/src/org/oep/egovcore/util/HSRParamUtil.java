package org.oep.egovcore.util;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * HttpServletRequest parameters util
 * @author hoangtrung.nguyen
 * @TODO Get parameters duoc truyen toi' JSP o? hau` het' truong` hop.
 * 		- Goi truc tiep den' file jsp
 * 		- Su dung <jsp:include page="jspPath"><jsp:param name="paramName" value="value"/>
 * 		- Goi toi' 1 javax.action, sau do' action render file JSP 
 * 		- Include file JSP include(jspPath, RenderRequest, RenderResponse)
 * 		- Truong hop su dung portlet:param: &[portnet namespace]_paramName=value
 * 		- Truong hop su dung parameter binh` thuong` &paramName=value
 */


/**
*
* HSRParamUtil  class
*   
* This class is used to declare HSRParamUtil 
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
public class HSRParamUtil {
	
	/**
	  * This is Function getLong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String param
	  * @return long
	  */
	public static long getLong(HttpServletRequest request, String param) {
		
		long out = ParamUtil.getLong(request, param);
		
		if (out == 0L) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			out = ParamUtil.getLong(request, plParam);
		}
		
		if (out == 0L) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			HttpServletRequest rq = PortalUtil.getOriginalServletRequest(request);
			out = ParamUtil.getLong(rq, plParam);
			if (out == 0L) {
				out = ParamUtil.getLong(rq, param);
			}
		}
		return out;
	}
	
	
	/**
	  * This is Function getInteger
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String param
	  * @return int
	  */
	public static int getInteger(HttpServletRequest request, String param) {
		
		int out = ParamUtil.getInteger(request, param);
		
		if (out == 0) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			out = ParamUtil.getInteger(request, plParam);
		}
		
		if (out == 0) {
			HttpServletRequest rq = PortalUtil.getOriginalServletRequest(request);
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			out = ParamUtil.getInteger(rq, plParam);
			if (out == 0) {
				out = ParamUtil.getInteger(rq, param);
			}
		}
		return out;
	}
	
	
	/**
	  * This is Function getString
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String param
	  * @return String
	  */
	public static String getString(HttpServletRequest request, String param) {
		
		String out = ParamUtil.getString(request, param).trim();
		
		if (out.isEmpty()) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			out = ParamUtil.getString(request, plParam).trim();
		}
		
		if (out.isEmpty()) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			HttpServletRequest rq = PortalUtil.getOriginalServletRequest(request);
			out = ParamUtil.getString(rq, plParam).trim();
			if (out.isEmpty()) {
				out = ParamUtil.getString(rq, param).trim();
			}
		}
		return out;
	}
	
	
	/**
	  * This is Function getBoolean
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String param
	  * @return boolean
	  */
	public static boolean getBoolean(HttpServletRequest request, String param) {
		
		boolean out = ParamUtil.getBoolean(request, param);
		
		if (!out) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			out = ParamUtil.getBoolean(request, plParam);
		}
		
		if (!out) {
			String plParam = PortalUtil.getPortletNamespace(PortalUtil.getPortletId(request)) + param;
			HttpServletRequest rq = PortalUtil.getOriginalServletRequest(request);
			out = ParamUtil.getBoolean(rq, plParam);
			if (!out) {
				out = ParamUtil.getBoolean(rq, param);
			}
		}
		return out;
	}
}
