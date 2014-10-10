package org.oep.egovcore.validate.term.abs;

import javax.portlet.PortletRequest;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.PortletRequestSource;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is abstract class RequestInteger 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestInteger extends Term<Integer> implements
	PortletRequestSource<Integer>, UploadRequestSource<Integer> {

	@Override
	public Integer getValue(UploadPortletRequest request, String param) {
		return ParamUtil.getInteger(request, param);
	}

	@Override
	public Integer getValue(PortletRequest request, String param) {
		return ParamUtil.getInteger(request, param);
	}
	
	@Override
	public boolean _isInputed(Integer value) {
		return value != 0;
	}
}
