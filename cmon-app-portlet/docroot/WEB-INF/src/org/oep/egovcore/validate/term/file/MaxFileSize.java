package org.oep.egovcore.validate.term.file;

import java.io.File;

import org.oep.egovcore.util.Helper;
import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestFile;


/**
 * This is class MaxFileSize  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class MaxFileSize extends RequestFile {

	private long _maxByte = 1024*1024*1024;
	
	public MaxFileSize() {}
	
	public MaxFileSize(long maxByte) {
		_maxByte = maxByte;
	}
	
	public MaxFileSize setMaxByte(long maxByte) {
		_maxByte = maxByte;
		return this;
	}
	
	@Override
	protected boolean _isValid(File file) {
		return file.length() <= _maxByte;
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_MAX_FILE_SIZE);
	}
	
	public String message(String target) {
		return getTemplate().sub(target, Helper.getReadableVolume(_maxByte));
	}
	
	public String messageEN(String target) {
		return getTemplate().subEN(target, Helper.getReadableVolume(_maxByte));
	}
}
