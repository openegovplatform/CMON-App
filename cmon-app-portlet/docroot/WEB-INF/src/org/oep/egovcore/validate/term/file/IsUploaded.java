package org.oep.egovcore.validate.term.file;

import java.io.File;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestFile;


/**
 * This is class IsUploaded  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsUploaded extends RequestFile {

	@Override
	protected boolean _isValid(File file) {
		return _isInputed(file);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_IS_FILE_UPLOADED);
	}
}
