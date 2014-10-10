package org.oep.egovcore.language;

import java.util.Locale;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.StringPool;
/**
*
* BusinessMessagerUtil class
*   
* This class is used to declare BusinessMessagerUtil 
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
public class BusinessMessagerUtil {

	public static BusinessMessager forPrefix(PortletRequest request, String prefix) {
		return new BusinessMessager(request, prefix);
	}
	
	public static BusinessMessager forPrefix(HttpServletRequest request, String prefix) {
		return new BusinessMessager(request, prefix);
	}
	
	public static String get(PortletRequest request, String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			request.getLocale(),
			key
		);
	}
	
	public static String get(HttpServletRequest request, String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			request.getLocale(),
			key
		);
	}
	
	public static String getEN(PortletRequest request, String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			Locale.ENGLISH,
			key
		);
	}
	
	public static String getEN(HttpServletRequest request, String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			Locale.ENGLISH,
			key
		);
	}
	
	public static String sub(PortletRequest request, String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			request.getLocale(),
			key,
			args
		);
	}
	
	public static String sub(HttpServletRequest request, String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			request.getLocale(),
			key,
			args
		);
	}
	
	public static String subEN(PortletRequest request, String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			Locale.ENGLISH,
			key,
			args
		);
	}
	
	public static String subEN(HttpServletRequest request, String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(
			(PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG),
			Locale.ENGLISH,
			key,
			args
		);
	}
}
