package org.oep.egovcore.validate.term.datetime.abs;

import java.util.Date;

import org.oep.egovcore.validate.term.abs.RequestString;


/**
 * This is abstract class DateTimeCompare  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public abstract class DateTimeCompare extends RequestString {
	
	public static final int TYPE_EQ = 1;
	public static final int TYPE_GT = 2;
	public static final int TYPE_GTE = 3;
	public static final int TYPE_LT = 4;
	public static final int TYPE_LTE = 5;
	
	public static final int COMPARE_RESULT_EQUAL = 0;
	public static final int COMPARE_RESULT_MILESTONE_GREATER = -1;
	public static final int COMPARE_RESULT_TARGET_GREATER = 1;
	
	protected java.util.Date _milestone;
	private int _type;
	private int _compareResult;
	
	/**
	 * This is function getCompareResult
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @return int
	 */
	public int getCompareResult() {
		return _compareResult;
	}
	
	/**
	 * This is function DateTimeCompare
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param type
	 * @return Date
	 */
	public DateTimeCompare(int type) {
		_type = type;
	}
	
	/**
	 * This is function DateTimeCompare
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param milestone
	 * @param type
	 * @return Datetime
	 */
	public DateTimeCompare(java.util.Date milestone, int type) {
		_milestone = milestone;
		_type = type;
	}
	
	/**
	 * This is function setType
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return DateTimeCompare
	 */
	public DateTimeCompare setType(int type) {
		_type = type;
		return this;
	}
	
	/**
	 * This is function setMilestone
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param milestone
	 * @return DateTimeCompare
	 */
	public DateTimeCompare setMilestone(Date milestone) {
		_milestone = milestone;
		return this;
	}

	/**
	 * This is function check
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param value
	 * @return boolean
	 */
	public boolean check(Date value) {
		boolean out = false;
		if (value != null && _milestone != null) {
			_compareResult = value.compareTo(_milestone);
			switch (_type) {
				case TYPE_GT:
					out = _compareResult > 0;
					break;
				case TYPE_GTE:
					out = _compareResult >= 0;
					break;
				case TYPE_LT:
					out = _compareResult < 0;
					break;
				case TYPE_LTE:
					out = _compareResult <= 0;
					break;
				default:
					out = _compareResult == 0;
			}
		}
		return out;
	}
}
