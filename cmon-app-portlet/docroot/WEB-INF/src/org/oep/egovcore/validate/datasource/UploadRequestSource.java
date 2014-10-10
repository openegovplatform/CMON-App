package org.oep.egovcore.validate.datasource;

import com.liferay.portal.kernel.upload.UploadPortletRequest;

/**
 * This is interface UploadRequestSource  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public interface UploadRequestSource<T> {
	public abstract T getValue(UploadPortletRequest request, String param);
}
