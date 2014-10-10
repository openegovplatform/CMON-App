package org.oep.egovcore.validate.term.datetime;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.datetime.abs.HourMituteCompare;

/**
 * This is class IsHourMinuteLater  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsHourMinuteLater extends HourMituteCompare {

	public IsHourMinuteLater() {
		super(TYPE_GT);
	}
	
	public IsHourMinuteLater(String hmMilestone) {
		super(hmMilestone, TYPE_GT);
	}

	@Override
	protected MessageTemplate _useTemplate() {
		return new MessageTemplate(MessageTemplate.KEY_DATE_LATER);
	}
}
