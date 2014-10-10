package org.oep.egovcore.validate.term.file;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.oep.egovcore.util.Helper;
import org.oep.egovcore.util.StringPool;
import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestFile;


import com.liferay.portal.kernel.util.FileUtil;

/**
 * This is class FileExtension  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class FileExtension extends RequestFile {

	private String[] _allowExtensions;
	
	public FileExtension() {}
	
	public FileExtension(String[] allowExtensions) {
		_allowExtensions = allowExtensions;
	}
	
	public FileExtension setExtensions(String[] allowExtension) {
		_allowExtensions = allowExtension;
		return this;
	}
	
	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_INVALID_FILE_EXTENSION);
	}

	@Override
	protected boolean _isValid(File file) {
		return (_allowExtensions == null || _allowExtensions.length == 0)
			? true
			: Helper.inArray(
				_allowExtensions,
				FileUtil.getExtension(file.getName()).toLowerCase(),
				true
			);
	}
	
	public String message(String target) {
		return getTemplate().sub(
			target,
			MessageTemplate.format(
				StringUtils.join(_allowExtensions, StringPool.COMMA_AND_SPACE)
			)
		);
	}
	
	public String messageEN(String target) {
		return getTemplate().subEN(
			target,
			MessageTemplate.format(
				StringUtils.join(_allowExtensions, StringPool.COMMA_AND_SPACE)
			)
		);
	}
}
