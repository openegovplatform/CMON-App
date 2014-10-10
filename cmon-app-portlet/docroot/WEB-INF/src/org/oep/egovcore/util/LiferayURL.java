package org.oep.egovcore.util;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.LayoutReference;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;


/**
*
* LiferayURL  class
*   
* This class is used to declare LiferayURL 
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
public class LiferayURL {
	
	public static final String AJAX_URL_MARK = "_is_ajax_request";
	public static final String DEFAULT_JSP = null;
	public static final String DEFAULT_ACTION = null;
	
	private PortletURL _url;
	
	/**
	  * This is Contructor LiferayURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletURL url
	  * @return 
	  */
	public LiferayURL(PortletURL url) {
		_url = url;
	}
	
	
	/**
	  * This is function setParameter
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String name, Object value
	  * @return LiferayURL
	  */
	public LiferayURL setParameter(String name, Object value) {
		if (_url != null && value != null) {
			_url.setParameter(name, value.toString());
		}
		return this;
	}
	
	
	/**
	  * This is Contructor setWindowState
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param WindowState state
	  * @return LiferayURL
	  */
	public LiferayURL setWindowState(WindowState state) throws WindowStateException {
		if (_url != null) {
			_url.setWindowState(state);
		}
		return this;
	}
	
	
	/**
	  * This is Contructor setPortletMode
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletMode mode
	  * @return LiferayURL
	  */
	public LiferayURL setPortletMode(PortletMode mode) throws PortletModeException {
		if (_url != null) {
			_url.setPortletMode(mode);
		}
		return this;
	}
	
	public String toString() {
		return (_url == null) ? StringPool.SLASH : _url.toString();
	}
	
	/**
	  * This is fucntion isPortletAddedToPage
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String portletName
	  * @return boolean
	  */
	public static final boolean isPortletAddedToPage(PortletRequest request, String portletName)
		throws PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName) != 0L;  
	}
	
	/**
	  * This is fucntion isPortletAddedToPage
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String portletName
	  * @return boolean
	  */
	public static final boolean isPortletAddedToPage(HttpServletRequest request, String portletName)
		throws PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName) != 0L; 
	}
	
	
	/**
	  * This is fucntion createActionURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String portletName, String actionName
	  * @return LiferayURL
	  */
	public final static LiferayURL createActionURL(PortletRequest request, String portletName, String actionName) 
		throws Exception 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		PortletURL actionURL = PortletURLFactoryUtil.create(request, portletName, plid, PortletRequest.ACTION_PHASE);
		actionURL.setWindowState(WindowState.NORMAL);
		actionURL.setPortletMode(PortletMode.VIEW);
		if (DEFAULT_ACTION != actionName) {
			actionURL.setParameter(ActionRequest.ACTION_NAME, actionName);
		}
		return new LiferayURL(actionURL);
	}
	
	
	/**
	  * This is fucntion createActionURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String portletName, String actionName
	  * @return LiferayURL
	  */
	public final static LiferayURL createActionURL(HttpServletRequest request, String portletName, String actionName) 
		throws Exception 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		PortletURL actionURL = PortletURLFactoryUtil.create(request, portletName, plid, PortletRequest.ACTION_PHASE);
		actionURL.setWindowState(WindowState.NORMAL);
		actionURL.setPortletMode(PortletMode.VIEW);
		if (DEFAULT_ACTION != actionName) {
			actionURL.setParameter(ActionRequest.ACTION_NAME, actionName);
		}
		return new LiferayURL(actionURL);
	}
	
	
	/**
	  * This is fucntion createActionURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String actionName
	  * @return LiferayURL
	  */
	public final static LiferayURL createActionURL(PortletRequest request, String actionName) 
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return createActionURL(request, themeDisplay.getPortletDisplay().getId(), actionName);
	}
	
	/**
	  * This is fucntion createActionURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String actionName
	  * @return LiferayURL
	  */
	public final static LiferayURL createActionURL(HttpServletRequest request, String actionName) 
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return createActionURL(request, themeDisplay.getPortletDisplay().getId(), actionName);
	}
	
	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String portletName, String jsp
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(PortletRequest request, String portletName, String jsp)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		PortletURL renderURL = PortletURLFactoryUtil.create(request, portletName, plid, PortletRequest.RENDER_PHASE);
		renderURL.setWindowState(WindowState.NORMAL);
		renderURL.setPortletMode(PortletMode.VIEW);
		if (DEFAULT_JSP != jsp) {
			renderURL.setParameter(StringPool.JSP_PAGE, jsp);
		}
		return new LiferayURL(renderURL);
	}
	
	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String portletName, String jsp
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(HttpServletRequest request, String portletName, String jsp)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		PortletURL renderURL = PortletURLFactoryUtil.create(request, portletName, plid, PortletRequest.RENDER_PHASE);
		renderURL.setWindowState(WindowState.NORMAL);
		renderURL.setPortletMode(PortletMode.VIEW);
		if (DEFAULT_JSP != jsp) {
			renderURL.setParameter(StringPool.JSP_PAGE, jsp);
		}
		return new LiferayURL(renderURL);
	}

	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String jsp
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(PortletRequest request, String jsp)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createRenderURL(request, themeDisplay.getPortletDisplay().getId(), jsp);
	}
	
	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String jsp
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(HttpServletRequest request, String jsp)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createRenderURL(request, themeDisplay.getPortletDisplay().getId(), jsp);
	}
	
	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(PortletRequest request)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createRenderURL(request, themeDisplay.getPortletDisplay().getId(), DEFAULT_JSP);
	}
	
	/**
	  * This is fucntion createRenderURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request
	  * @return LiferayURL
	  */
	public final static LiferayURL createRenderURL(HttpServletRequest request)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createRenderURL(request, themeDisplay.getPortletDisplay().getId(), DEFAULT_JSP);
	}
	
	/**
	  * This is fucntion createResourceURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String resourceId
	  * @return LiferayURL
	  */
	public final static LiferayURL createResourceURL(HttpServletRequest request, String resourceId)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createResourceURL(request, themeDisplay.getPortletDisplay().getId(), resourceId);
	}
	
	/**
	  * This is fucntion createResourceURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String resourceId
	  * @return LiferayURL
	  */
	public final static LiferayURL createResourceURL(PortletRequest request, String resourceId)
		throws Exception
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createResourceURL(request, themeDisplay.getPortletDisplay().getId(), resourceId);
	}
	
	/**
	  * This is fucntion createResourceURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String portletName, String resourceId
	  * @return LiferayURL
	  */
	public final static LiferayURL createResourceURL(HttpServletRequest request, String portletName, String resourceId)
		throws PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		LiferayPortletResponse response = 
			PortalUtil.getLiferayPortletResponse(
				(PortletResponse) request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE));
		LiferayPortletURL url = response.createLiferayPortletURL(plid, portletName, PortletRequest.RESOURCE_PHASE);
		url.setResourceID(resourceId);
		return new LiferayURL(url);
	}
	
	/**
	  * This is fucntion createResourceURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String portletName, String resourceId
	  * @return LiferayURL
	  */
	public final static LiferayURL createResourceURL(PortletRequest request, String portletName, String resourceId)
		throws PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletName); 
		LiferayPortletResponse response = 
			PortalUtil.getLiferayPortletResponse(
				(PortletResponse) request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE));
		LiferayPortletURL url = response.createLiferayPortletURL(plid, portletName, PortletRequest.RESOURCE_PHASE);
		url.setResourceID(resourceId);
		return new LiferayURL(url);
	}
	
	/**
	  * This is fucntion getPageURLByConfig
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request,String portletName,String configName,	String configValue,	LiferayURL defaultURL
	  * @return LiferayURL
	  */
	public static LiferayURL getPageURLByConfig(
		HttpServletRequest request,
		String portletName,
		String configName,
		String configValue,
		LiferayURL defaultURL
	) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		LayoutReference[] pageRefs = LayoutLocalServiceUtil.getLayouts(
			themeDisplay.getCompanyId(), portletName, configName, configValue
		);

		if (pageRefs.length > 0) {
			
			return new LiferayURL(PortletURLFactoryUtil.create(
				request,
				portletName,
				pageRefs[0].getLayoutSoap().getPlid(),
				PortletRequest.RENDER_PHASE
			));
			
		} else {
			return defaultURL;
		}
	}
	
	/**
	  * This is fucntion getPageURLByConfig
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request,String portletName,String configName,	String configValue,	LiferayURL defaultURL
	  * @return LiferayURL
	  */
	public static LiferayURL getPageURLByConfig(
		PortletRequest request,
		String portletName,
		String configName,
		String configValue,
		LiferayURL defaultURL
	) throws SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		LayoutReference[] pageRefs = LayoutLocalServiceUtil.getLayouts(
			themeDisplay.getCompanyId(), portletName, configName, configValue
		);
		
		if (pageRefs.length > 0) {
			
			return new LiferayURL(PortletURLFactoryUtil.create(
				request,
				portletName,
				pageRefs[0].getLayoutSoap().getPlid(),
				PortletRequest.RENDER_PHASE
			));
			
		} else {
			return defaultURL;
		}
	}
	
	/**
	  * This is fucntion createAjaxURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String portletName, String methodName
	  * @return LiferayURL
	  */
	public static LiferayURL createAjaxURL(HttpServletRequest request, String portletName, String methodName)
		throws PortalException, SystemException
	{
		return createResourceURL(request, portletName, methodName).setParameter(AJAX_URL_MARK, 1);
	}
	
	
	/**
	  * This is fucntion createAjaxURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String portletName, String methodName
	  * @return LiferayURL
	  */
	public static LiferayURL createAjaxURL(PortletRequest request, String portletName, String methodName)
		throws PortalException, SystemException
	{
		return createResourceURL(request, portletName, methodName).setParameter(AJAX_URL_MARK, 1);
	}
	
	
	/**
	  * This is fucntion createAjaxURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String methodName
	  * @return LiferayURL
	  */
	public static LiferayURL createAjaxURL(HttpServletRequest request, String methodName)
		throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createResourceURL(request, themeDisplay.getPortletDisplay().getId(), methodName).setParameter(AJAX_URL_MARK, 1);
	}
	
	
	/**
	  * This is fucntion createAjaxURL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String methodName
	  * @return LiferayURL
	  */
	public static LiferayURL createAjaxURL(PortletRequest request, String methodName)
		throws PortalException, SystemException
	{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		return createResourceURL(request, themeDisplay.getPortletDisplay().getId(), methodName).setParameter(AJAX_URL_MARK, 1);
	}
	
	
	/**
	  * This is fucntion isAjaxRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request
	  * @return boolean
	  */
	public static boolean isAjaxRequest(PortletRequest request) {
		return ParamUtil.getInteger(request, AJAX_URL_MARK) != 0;
	}
	
	/**
	  * This is fucntion isAjaxRequest
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param UploadPortletRequest request
	  * @return boolean
	  */
	public static boolean isAjaxRequest(UploadPortletRequest request) {
		return ParamUtil.getInteger(request, AJAX_URL_MARK) != 0;
	}
}
