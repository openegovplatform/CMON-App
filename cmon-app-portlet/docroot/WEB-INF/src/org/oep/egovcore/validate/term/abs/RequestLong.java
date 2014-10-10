package org.oep.egovcore.validate.term.abs;

import javax.portlet.PortletRequest;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is abstract class RequestLong  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestLong extends Term<Long> implements
	PortletRequestSource<Long>, UploadRequestSource<Long> {

	@Override
	public Long getValue(UploadPortletRequest request, String param) {
		return ParamUtil.getLong(request, param);
	}

	@Override
	public Long getValue(PortletRequest request, String param) {
		return ParamUtil.getLong(request, param);
	}
	
	@Override
	public boolean _isInputed(Long value) {
		return value != 0L;
	}
}
