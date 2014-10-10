package org.oep.egovcore.validate.term.abs;

import java.io.File;

import org.oep.egovcore.validate.Term;
import org.oep.egovcore.validate.datasource.UploadRequestSource;


import com.liferay.portal.kernel.upload.UploadPortletRequest;

/**
 * This is abstract class RequestFile 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class RequestFile extends Term<File> implements UploadRequestSource<File> {
	
	@Override
	public File getValue(UploadPortletRequest request, String param) {
		return request.getFile(param);
	}
	
	@Override
	protected boolean _isInputed(File file) {
		return file != null && file.exists();
	}
}
