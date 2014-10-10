package org.oep.egovcore.validate.term.abs;

import javax.portlet.PortletRequest;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is abstract class RequestStringArray  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestStringArray extends Term<String[]> implements
	PortletRequestSource<String[]>, UploadRequestSource<String[]> {

	@Override
	public String[] getValue(UploadPortletRequest request, String param) {
		return ParamUtil.getParameterValues(request, param);
	}

	@Override
	public String[] getValue(PortletRequest request, String param) {
		return ParamUtil.getParameterValues(request, param);
	}
	
	@Override
	protected boolean _isInputed(String[] value) {
		return value.length > 0;
	}
}
