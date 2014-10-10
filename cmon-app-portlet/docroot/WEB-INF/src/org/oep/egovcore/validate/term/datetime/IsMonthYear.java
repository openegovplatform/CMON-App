package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.term.datetime.abs.IsDateTime;

/**
 * This is class IsMonthYear  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsMonthYear extends IsDateTime {

	public IsMonthYear() {
		super(DateTimeUtil.MYF);
	}

	@Override
	protected boolean _isValid(String value) {
		return DateTimeUtil.parseDateFromMonthYear(value) != null;
	}
}
