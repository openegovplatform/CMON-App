package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.MonthCompare;

/**
 * This is class IsMonthLater  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsMonthLater extends MonthCompare {

	public IsMonthLater() {
		super(TYPE_GT);
	}
	
	public IsMonthLater(String myMilestone) {
		super(myMilestone, TYPE_GT);
	}
	
	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_LATER);
	}
}
