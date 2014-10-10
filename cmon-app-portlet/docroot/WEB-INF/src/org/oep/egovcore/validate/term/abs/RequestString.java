package org.oep.egovcore.validate.term.abs;

import javax.portlet.PortletRequest;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;


/**
 * This is abstract class RequestString  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestString extends Term<String>
	implements PortletRequestSource<String>, UploadRequestSource<String> {
	
	@Override
	public String getValue(UploadPortletRequest request, String param) {
		return ParamUtil.getString(request, param);
	}

	@Override
	public String getValue(PortletRequest request, String param) {
		return ParamUtil.getString(request, param);
	}
	
	@Override
	protected boolean _isInputed(String value) {
		return !value.isEmpty();
	}
}
