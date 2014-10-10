package org.oep.egovcore.validate.term;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestString;

/**
 * This is class IsFilled  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsFilled extends RequestString {
	
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_FILLED);
	}
	
	@Override
	protected boolean _isValid(String value) {
		return !value.isEmpty(); 
	}
}
