package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.DayCompare;

/**
 * This is class IsDayLater  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsDayLater extends DayCompare {
	
	public IsDayLater() {
		super(TYPE_GT);
	}
	
	public IsDayLater(String dmyMilestone) {
		super(dmyMilestone, TYPE_GT);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_LATER);
	}
}
