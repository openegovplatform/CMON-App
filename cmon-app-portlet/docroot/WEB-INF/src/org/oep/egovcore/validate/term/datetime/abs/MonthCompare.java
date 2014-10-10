package org.oep.egovcore.validate.term.datetime.abs;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.MessageTemplate;

/**
 * This is abstract class MonthCompare 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class MonthCompare extends DateTimeCompare {
	
	private String _myMilestone;
	
	public MonthCompare(int type) {
		super(type);
	}
	
	public MonthCompare(String myMilestone, int type) {
		super(DateTimeUtil.parseDateFromMonthYear(myMilestone), type);
		_myMilestone = myMilestone;
	}
	
	public MonthCompare setMilestone(String myMilestone) {
		_myMilestone = myMilestone;
		super.setMilestone(DateTimeUtil.parseDateFromMonthYear(myMilestone));
		return this;
	}
	
	protected boolean _isValid(String myValue) {
		return check(DateTimeUtil.parseDateFromMonthYear(myValue));
	}

	public String message(String target) {
		return getTemplate().sub(target, MessageTemplate.format(_myMilestone));
	}
	
	public String messageEN(String target) {
		return getTemplate().sub(target, MessageTemplate.format(_myMilestone));
	}
}
