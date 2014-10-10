package org.oep.egovcore.validate.term;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestStringArray;

/**
 * This is class IsChecked  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsChecked extends RequestStringArray {

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_CHECKED);
	}

	@Override
	protected boolean _isValid(String[] value) {
		return _isInputed(value);
	}
}
