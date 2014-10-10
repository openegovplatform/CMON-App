package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.term.datetime.abs.IsDateTime;

/**
 * This is class IsHourMitute  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsHourMitute extends IsDateTime {

	public IsHourMitute() {
		super(DateTimeUtil.HMF);
	}

	@Override
	protected boolean _isValid(String value) {
		return DateTimeUtil.parseHourMitute(value) != null;
	}
}
