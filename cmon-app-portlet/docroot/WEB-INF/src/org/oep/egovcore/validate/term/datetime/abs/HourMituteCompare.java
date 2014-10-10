package org.oep.egovcore.validate.term.datetime.abs;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.validate.MessageTemplate;

/**
 * This is abstract class HourMituteCompare 
 * 
 * Class giup so sanh cac field gio phut (HH:mm)
 * Chi so sanh cac gia tri HH:mm, khong bao gom ngay`
 * Nen khi so sanh se chuyen ve` cung` 1 ngay`
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class HourMituteCompare extends DateTimeCompare {
	
	private String _hmMilestone;
	private static String _day = "01/01/2000";
	
	public HourMituteCompare(int type) {
		super(type);
	}
	
	public HourMituteCompare(String hmMilestone, int type) {
		super(DateTimeUtil.parseDate(_day, hmMilestone), type);
		_hmMilestone = hmMilestone;
	}
	
	public DateTimeCompare setMilestone(String hmMilestone) {
		_hmMilestone = hmMilestone;
		super.setMilestone(DateTimeUtil.parseDate(_day, hmMilestone));
		return this;
	}
	
	protected  boolean _isValid(String hmValue) {
		return check(DateTimeUtil.parseDate(_day, hmValue));
	}
	
	public String message(String target) {
		return getTemplate().sub(target, MessageTemplate.format(_hmMilestone));
	}
	
	public String messageEN(String target) {
		return getTemplate().subEN(target, MessageTemplate.format(_hmMilestone));
	}
}
