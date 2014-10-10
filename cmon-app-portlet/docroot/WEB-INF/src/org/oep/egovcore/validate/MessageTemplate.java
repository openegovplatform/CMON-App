package org.oep.egovcore.validate;

import org.oep.egovcore.language.CmonMessagerUtil;
import org.oep.egovcore.language.Messager;

import com.liferay.portal.kernel.util.StringPool;

/**
 * This is class MessageTemplate  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class MessageTemplate {
	public static final String KEY_FILLED = "filled";
	public static final String KEY_SELECTED = "selected";
	public static final String KEY_CHECKED = "checked";
	public static final String KEY_INVALID_FILL = "invalid_fill";
	public static final String KEY_INVALID_CHOICE = "invalid_choice";
	public static final String KEY_EXACT_LEN = "exact_len";
	public static final String KEY_NUMBER = "number";
	public static final String KEY_NUMBER_GT0 = "number_gt0";
	public static final String KEY_NUMBER_GTE0 = "number_gte0";
	public static final String KEY_NUMERAL = "numeral";
	public static final String KEY_DATE_EARLIER = "date_earlier";
	public static final String KEY_DATE_EARLIER_OR_EQUAL = "date_earlier_or_equal";
	public static final String KEY_DATE_LATER = "date_later";
	public static final String KEY_DATE_LATER_OR_EQUAL = "date_later_or_equal";
	public static final String KEY_DAY_IN_PAST = "day_in_past";
	public static final String KEY_DAY_IN_PAST_OR_TODAY = "day_in_past_or_today";
	public static final String KEY_MONTH_EARLIER = "month_earlier";
	public static final String KEY_MONTH_EARLIER_OR_EQUAL = "month_earlier_or_equal";
	public static final String KEY_MONTH_IN_PAST = "month_in_past";
	public static final String KEY_MONTH_IN_PAST_OR_CURRENT = "month_in_past_or_current";
	public static final String KEY_MOMENT_LATER = "moment_later";
	public static final String KEY_INVALID_FILE_EXTENSION = "invalid_file_extension";
	public static final String KEY_MAX_FILE_SIZE = "max_file_size";
	public static final String KEY_IS_FILE_UPLOADED = "is_file_uploaded";
	public static final String KEY_EMPTY_GRID = "empty_grid";
	
	private static final String PREFIX = "validate_message_template";
	private static final String TARGET_FORMAT = "\"{t}\"";
	private static final String TARGET_HOLDER = "{t}";
	
	public MessageTemplate(String templateKey) {
		String key = Messager.createKey(PREFIX, templateKey);
		_vi = CmonMessagerUtil.get(key);
		_en = CmonMessagerUtil.getEN(key);
		_targetFormat = TARGET_FORMAT;
	}
	
	public MessageTemplate noFormat() {
		_targetFormat = TARGET_HOLDER;
		return this;
	}
	
	public static String format(String pattern, Object target) {
		if (target != null) {
			return pattern.replace(TARGET_HOLDER, target.toString());
		} else {
			return StringPool.BLANK;
		}
	}
	
	public static String format(Object target) {
		return format(TARGET_FORMAT, target);
	}
	
	public void setTargetFormat(String s) {
		_targetFormat = s;
	}
	
	private String _vi;
	private String _en;
	private String _targetFormat;
	
	/**
	 * This is function sub  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param target
	 * @param agrs
	 * @return String
	 */
	public String sub(String target, Object... agrs) {
		if (target == null) {
			return StringPool.BLANK;
		}
		Object[] o = new Object[agrs.length + 1];
		o[0] = format(_targetFormat, target);
		for (int i = 0; i < agrs.length; ++ i) {
			o[i + 1] = agrs[i];
		}
		return Messager.substitute(_vi, o);
	}
	
	/**
	 * This is function subEN  
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param target
	 * @param agrs
	 * @return String
	 */
	public String subEN(String target, Object... agrs) {
		if (target == null) {
			return StringPool.BLANK;
		}
		Object[] o = new Object[agrs.length + 1];
		o[0] = format(_targetFormat, target);
		for (int i = 0; i < agrs.length; ++ i) {
			o[i + 1] = agrs[i];
		}
		return Messager.substitute(_en, o);
	}
}
