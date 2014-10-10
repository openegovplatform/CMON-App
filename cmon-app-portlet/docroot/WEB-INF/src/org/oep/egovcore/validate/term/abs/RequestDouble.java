package org.oep.egovcore.validate.term.abs;

import javax.portlet.PortletRequest;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is abstract class RequestDouble  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestDouble extends Term<Double> implements
	PortletRequestSource<Double>, UploadRequestSource<Double> {

	@Override
	public Double getValue(UploadPortletRequest request, String param) {
		return ParamUtil.getDouble(request, param);
	}

	@Override
	public Double getValue(PortletRequest request, String param) {
		return ParamUtil.getDouble(request, param);
	}
	
	@Override
	public boolean _isInputed(Double value) {
		return value != 0D;
	}
}
