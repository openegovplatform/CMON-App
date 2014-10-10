package org.oep.egovcore.validate.datasource;

import javax.portlet.PortletRequest;

/**
 * This is interface PortletRequestSource  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public interface PortletRequestSource<T> {
	public abstract T getValue(PortletRequest request, String param);
}
