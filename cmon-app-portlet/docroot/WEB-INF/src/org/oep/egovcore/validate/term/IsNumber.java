package org.oep.egovcore.validate.term;

import org.oep.egovcore.validate.MessageTemplate;
import org.oep.egovcore.validate.term.abs.RequestString;

/**
 * This is class IsNumber  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class IsNumber extends RequestString {
	
	public static final int ALL = 0;
	public static final int GT0 = 1;
	public static final int GTE0 = 2;
	
	private int _zeroCompareMark = 0;
	
	public IsNumber() {}
	
	public IsNumber(int zeroCompareMark) {
		_zeroCompareMark = zeroCompareMark;
	}
	
	public IsNumber setZeroCompareMark(int zeroCompareMark) {
		_zeroCompareMark = zeroCompareMark;
		return this;
	}
	
	protected MessageTemplate _useTemplate() {
		switch (_zeroCompareMark) {
			case GT0:
				return new MessageTemplate(MessageTemplate.KEY_NUMBER_GT0);
			case GTE0:
				return new MessageTemplate(MessageTemplate.KEY_NUMBER_GTE0);
			default:
				return new MessageTemplate(MessageTemplate.KEY_NUMBER);
		}
	}

	public static boolean check(String snum, int zeroCompareMark) {
		Double num;
		try {
			num = Double.parseDouble(snum);

			switch (zeroCompareMark) {
				case GT0:
					return num > 0;
				case GTE0:
					return num >= 0;
				default:
					return true;
			}
			
		} catch(NumberFormatException nfe) {
		    return false;  
		}
	}

	@Override
	protected boolean _isValid(String value) {
		return check(value, _zeroCompareMark);
	}
}
