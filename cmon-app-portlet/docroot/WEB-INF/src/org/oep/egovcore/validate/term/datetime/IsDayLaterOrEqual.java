package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.DayCompare;

/**
 * This is class IsDayLaterOrEqual  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsDayLaterOrEqual extends DayCompare {
	
	public IsDayLaterOrEqual() {
		super(TYPE_GTE);
	}
	
	public IsDayLaterOrEqual(String dmyMilestone) {
		super(dmyMilestone, TYPE_GTE);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_LATER_OR_EQUAL);
	}
}
