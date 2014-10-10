package org.oep.egovcore.validate.term.business;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.IsNumeral;
import org.oep.egovcore.validate.term.abs.RequestString;

/**
 * This is class IsSoCMND 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsSoCMND extends RequestString {
	
	private static final int LEN1 = 9;
	private static final int LEN2 = 12;
	public static final String KEY = "business.soCMND";
	
	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(KEY);
	}

	@Override
	protected boolean _isValid(String value) {
		value = value.trim();
		return value.length() == LEN1
			|| value.length() == LEN2
			&& IsNumeral.check(value);
	}
}
