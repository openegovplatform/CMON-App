package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.DayCompare;

/**
 * This is class IsDayEarlier  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsDayEarlier extends DayCompare {
	
	public IsDayEarlier() {
		super(TYPE_LT);
	}
	
	public IsDayEarlier(String dmyMilestone) {
		super(dmyMilestone, TYPE_LT);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_EARLIER);
	}
}
