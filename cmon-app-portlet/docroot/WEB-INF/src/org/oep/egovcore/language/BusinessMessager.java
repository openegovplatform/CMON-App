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
* BusinessMessager class
*   
* This class is used to declare BusinessMessager 
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
public class BusinessMessager extends Messager {
	
	public BusinessMessager(PortletRequest request, String prefix) {
		super(prefix);
		_locale = request.getLocale();
		_config = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	}
	
	public BusinessMessager(HttpServletRequest request, String prefix) {
		super(prefix);
		_locale = request.getLocale();
		_config = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
	}
	
	@Override
	public String get(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(_config, _locale, createKey(_prefix, key));
	}
	
	@Override
	public String sub(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(_config, _locale, createKey(_prefix, key), args);
	}
	
	@Override
	public String getEN(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.get(_config, Locale.ENGLISH, createKey(_prefix, key));
	}
	
	@Override
	public String subEN(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return LanguageUtil.format(_config, Locale.ENGLISH, createKey(_prefix, key), args);
	}
	
	private Locale _locale;
	private PortletConfig _config;
}
