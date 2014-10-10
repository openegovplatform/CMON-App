package org.oep.egovcore.validate.term.datetime.abs;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.MessageTemplate;

/**
 * This is abstract class DayCompare  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class DayCompare extends DateTimeCompare {

	private String _dmyMilestone;
	
	public DayCompare(int type) {
		super(type);
	}
	
	public DayCompare(String dmyMilestone, int type) {
		super(DateTimeUtil.parseDate(dmyMilestone), type);
		_dmyMilestone = dmyMilestone;
	}
	
	public DayCompare setMilestone(String dmyMilestone) {
		_dmyMilestone = dmyMilestone;
		super.setMilestone(DateTimeUtil.parseDate(dmyMilestone));
		return this;
	}
	
	protected  boolean _isValid(String dmyValue) {
		return check(DateTimeUtil.parseDate(dmyValue));
	}
	
	public String message(String target) {
		return getTemplate().sub(target, MessageTemplate.format(_dmyMilestone));
	}
	
	public String messageEN(String target) {
		return getTemplate().subEN(target, MessageTemplate.format(_dmyMilestone));
	}
}
