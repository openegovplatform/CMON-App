package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.MonthCompare;

/**
 * This is class IsMonthLaterOrEqual  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsMonthLaterOrEqual extends MonthCompare {
	
	public IsMonthLaterOrEqual() {
		super(TYPE_GTE);
	}
	
	public IsMonthLaterOrEqual(String myMilestone) {
		super(myMilestone, TYPE_GTE);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_LATER_OR_EQUAL);
	}
}
