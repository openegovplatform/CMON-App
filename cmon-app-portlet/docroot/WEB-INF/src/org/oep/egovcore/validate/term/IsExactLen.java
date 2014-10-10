package org.oep.egovcore.validate.term;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestString;

/**
 * This is class IsExactLen  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsExactLen extends RequestString {
	
	private int _len;
	
	public IsExactLen() {}
	
	public IsExactLen(int len) {
		_len = len;
	}
	
	public IsExactLen setLen(int len) {
		_len = len;
		return this;
	}
	
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_EXACT_LEN);
	}

	public String message(String target) {
		return getTemplate().sub(target, _len);
	}
	
	public String messageEN(String target) {
		return getTemplate().subEN(target, _len);
	}
	
	@Override
	protected boolean _isValid(String value) {
		return value.length() == _len;
	}
}
