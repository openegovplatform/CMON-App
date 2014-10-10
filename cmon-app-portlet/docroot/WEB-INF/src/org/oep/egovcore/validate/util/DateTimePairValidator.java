package org.oep.egovcore.validate.util;

import org.oep.egovcore.validate.Validator;
import org.oep.egovcore.validate.term.datetime.IsDayLater;
import org.oep.egovcore.validate.term.datetime.IsDayLaterOrEqual;
import org.oep.egovcore.validate.term.datetime.IsDayMonthYear;
import org.oep.egovcore.validate.term.datetime.IsHourMinuteLater;
import org.oep.egovcore.validate.term.datetime.IsHourMitute;
import org.oep.egovcore.validate.term.datetime.IsMonthLater;
import org.oep.egovcore.validate.term.datetime.IsMonthLaterOrEqual;
import org.oep.egovcore.validate.term.datetime.IsMonthYear;
import org.oep.egovcore.validate.term.datetime.abs.DayCompare;
import org.oep.egovcore.validate.term.datetime.abs.MonthCompare;

/**
 * This is class DateTimePairValidator  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DateTimePairValidator {
	
	/**
	 * This is function forMonth  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param validator
	 * @param lesserMonthField
	 * @param greaterMonthField
	 * @param monthEqual
	 * @return boolean
	 */
	public static boolean forMonth(
		Validator validator,
		String lesserMonthField, 
		String greaterMonthField,
		boolean monthEqual		
	) {
		IsMonthYear thangHopLe = new IsMonthYear();
		validator.check(thangHopLe, lesserMonthField);
		validator.check(thangHopLe, greaterMonthField);
		MonthCompare term = monthEqual ? new IsMonthLaterOrEqual() : new IsMonthLater();
		term.setMilestone(validator.getRequestValue(term, lesserMonthField));
		boolean out = term.isValid(validator.getRequestValue(term, greaterMonthField));
		if ( !out ) {
			validator.putMessage(
				greaterMonthField,
				term.getTemplate(),
				greaterMonthField,
				lesserMonthField
			);
		}
		return out;
	}
	
	/**
	 * This is function forDayMonthYear  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param validator
	 * @param lesserMonthField
	 * @param greaterMonthField
	 * @param dayEqual
	 * @return boolean
	 */
	public static boolean forDayMonthYear(
		Validator validator,
		String lesserDayField, 
		String greaterDayField,
		boolean dayEqual
	) {
		IsDayMonthYear ngayHopLe = new IsDayMonthYear();
		validator.check(ngayHopLe, lesserDayField);
		validator.check(ngayHopLe, greaterDayField);
		DayCompare term = dayEqual ? new IsDayLaterOrEqual() : new IsDayLater();
		term.setMilestone(validator.getRequestValue(term, lesserDayField));
		boolean out = term.isValid(validator.getRequestValue(term, greaterDayField));
		if ( !out ) {
			validator.putMessage(
				greaterDayField,
				term.getTemplate(),
				greaterDayField,
				lesserDayField
			);
		}
		return out;
	}
	
	/**
	 * This is function forDayAndHourMinute  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param validator
	 * @param lesserMonthField
	 * @param lesserHourMinuteField
	 * @param greaterMonthField
	 * @param greaterHourMinuteField
	 * @param dayEqual
	 * @return boolean
	 */
	public static boolean forDayAndHourMinute(
		Validator validator,
		String lesserDayField, String lesserHourMinuteField,
		String greaterDayField, String greaterHourMinuteField,
		boolean dayEqual
	) {
		IsDayMonthYear ngayHopLe = new IsDayMonthYear();
		IsHourMitute gioPhuHopLe = new IsHourMitute();
		validator.check(ngayHopLe, lesserDayField);
		validator.check(gioPhuHopLe, lesserHourMinuteField);
		validator.check(ngayHopLe, greaterDayField);
		validator.check(gioPhuHopLe, greaterHourMinuteField);
		
		DayCompare term = dayEqual ? new IsDayLaterOrEqual() : new IsDayLater();
		term.setMilestone(validator.getRequestValue(term, lesserDayField));
		boolean out = term.isValid(validator.getRequestValue(term, greaterDayField));
		if ( !out ) {
			validator.putMessage(
				greaterDayField,
				term.getTemplate(),
				greaterDayField,
				lesserDayField
			);
		}
		
		if (term.getCompareResult() == DayCompare.COMPARE_RESULT_EQUAL) {
			IsHourMinuteLater hmTerm = new IsHourMinuteLater();
			hmTerm.setMilestone(validator.getRequestValue(hmTerm, lesserHourMinuteField));
			out = hmTerm.isValid(validator.getRequestValue(hmTerm, greaterHourMinuteField));
			if ( !out ) {
				validator.putMessage(
					greaterHourMinuteField,
					hmTerm.getTemplate(),
					greaterHourMinuteField,
					lesserHourMinuteField
				);
			}
		}
		return out;
	}
}
