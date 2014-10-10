package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.term.datetime.abs.IsDateTime;

/**
 * This is class IsDayMonthYear  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsDayMonthYear extends IsDateTime {

	public IsDayMonthYear() {
		super(DateTimeUtil.DF);
	}

	@Override
	protected boolean _isValid(String value) {
		return DateTimeUtil.parseDate(value) != null;
	}
}
