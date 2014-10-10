package org.oep.egovcore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.oep.egovcore.Config;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author hoangtrung.nguyen
 */

/**
*
* DateTimeUtil  class
*   
* This class is used to declare DateTimeUtil 
*
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public final class DateTimeUtil {

	private static Config _config = Config.forClass(DateTimeUtil.class);
	public static final String DF = _config.get("df");
	public static final String HMF = _config.get("hmf");
	public static final String MYF = _config.get("myf");
	public static final String TIMEZONE = _config.get("timezone");
	public static final String FIRST_MONTH_DAY = "01/";
	private static SimpleDateFormat _formater = new SimpleDateFormat(DF);
	private static SimpleDateFormat _hmFormater = new SimpleDateFormat(HMF);
	public static final String NGAY = _config.get("text.ngay");
	public static final String THANG = _config.get("text.thang");
	public static final String NAM = _config.get("text.nam");
	public static final String GIO = _config.get("text.gio");
	public static final String PHUT = _config.get("text.phut");
	public static final String GIAY = _config.get("text.giay");
	public static final String SANG = _config.get("text.sang");
	public static final String CHIEU = _config.get("text.chieu");
	
	
	/**
	  * This is fucntion parseHourMitute
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String HHmm
	  * @return int[]
	  */
	public static int[] parseHourMitute(String HHmm) {
		if (HHmm == null) {
			return null;
		}
		String[] tmp = HHmm.trim().split(":");
		if (tmp.length != 2) {
			return null;
		}
		try {
			int h = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			if (h < 0 || h > 23) {
				return null;
			}
			if (m < 0 || h > 59) {
				return null;
			}
			return new int[] {h, m};
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	
	/**
	  * This is fucntion parseDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ddMMyyyy
	  * @return Date
	  */
	public static Date parseDate(String ddMMyyyy) {
        Date date;
        try {
        	date = _formater.parse(ddMMyyyy);
        } catch (ParseException e) {
        	return null;
        }
        if (!_formater.format(date).equals(ddMMyyyy)) {
        	return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

	protected static Log _log = LogFactoryUtil.getLog(DateTimeUtil.class);
	
	
	/**
	  * This is fucntion getDateTimeNow
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return Date
	  */
	public static Date getDateTimeNow() {
		return new org.joda.time.DateTime(org.joda.time.DateTimeZone.forID(TIMEZONE)).toDate();
	}

	/**
	  * This is fucntion parseDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ddMMyyyy, String HHmm
	  * @return Date
	  */
	public static Date parseDate(String ddMMyyyy, String HHmm) {
		Date date = parseDate(ddMMyyyy.trim());
		if (date == null) {
			return null;
		}
		int[] hm = parseHourMitute(HHmm);
		if (hm == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hm[0]);
		cal.set(Calendar.MINUTE, hm[1]);
		return cal.getTime();
	}
	
	/**
	  * This is fucntion parseDateFromMonthYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String MMyyyy
	  * @return Date
	  */
	public static Date parseDateFromMonthYear(String MMyyyy) {
		return parseDate(
			FIRST_MONTH_DAY + MMyyyy.trim()
		);
	}
	
	
	/**
	  * This is fucntion getDayMonthYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return String
	  */
	public static String getDayMonthYear(Date date) {
		return (date == null) ? StringPool.BLANK : _formater.format(date);
	}
	
	public static final int INDEX_NGAY = 0;
	public static final int INDEX_THANG = 1;
	public static final int INDEX_NAM = 2;
	public static final int INDEX_GIO12 = 3;
	public static final int INDEX_PHUT = 4;
	public static final int INDEX_GIAY = 5;
	public static final int INDEX_GIO24 = 6;
	public static final int INDEX_SANGCHIEU = 7;
	
	/**
	  * This is fucntion getDayMonthYearLong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return String
	  */
	public static String getDayMonthYearLong(Date date) {
		String[] arr = getDayMonthYearAsArray(date);
		
		if (arr.length == 0) {
			return StringPool.BLANK;
		}
		
		StringBuilder bdr = new StringBuilder();
		bdr.append(NGAY).append(StringPool.SPACE).append(arr[INDEX_NGAY]);
		bdr.append(StringPool.SPACE);
		bdr.append(THANG).append(StringPool.SPACE).append(arr[INDEX_THANG]);
		bdr.append(StringPool.SPACE);
		bdr.append(NAM).append(StringPool.SPACE).append(arr[INDEX_NAM]);
		return bdr.toString();
	}
	
	
	/**
	  * This is fucntion getDayMonthYearAsArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return String[]
	  */
	public static String[] getDayMonthYearAsArray(Date date) {
		
		String out[] = new String[0];
		
		if (date != null) {
			out = new String[3];
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
				
			String tmp = (StringPool.NUMBER0 + cal.get(Calendar.DAY_OF_MONTH));
			out[INDEX_NGAY] = tmp.substring(tmp.length() - 2, tmp.length());
			
			tmp = (StringPool.NUMBER0 + (cal.get(Calendar.MONTH) + 1) );
			out[INDEX_THANG] = tmp.substring(tmp.length() - 2, tmp.length());
			
			out[INDEX_NAM] = Integer.toString(cal.get(Calendar.YEAR));
		}
		return out;
	}
	
	
	/**
	  * This is fucntion getFullDateTimeAsArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return String[]
	  */
	public static String[] getFullDateTimeAsArray(Date date) {
		
		String out[] = new String[0];

		if (date != null) {
			out = new String[8];
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
				
			String tmp = (StringPool.NUMBER0 + cal.get(Calendar.DAY_OF_MONTH));
			out[INDEX_NGAY] = tmp.substring(tmp.length() - 2, tmp.length());
			
			tmp = (StringPool.NUMBER0 + (cal.get(Calendar.MONTH) + 1) );
			out[INDEX_THANG] = tmp.substring(tmp.length() - 2, tmp.length());
			
			out[INDEX_NAM] = Integer.toString(cal.get(Calendar.YEAR));
			
			tmp = (StringPool.NUMBER0 + cal.get(Calendar.HOUR));
			out[INDEX_GIO12] = tmp.substring(tmp.length() - 2, tmp.length());
			
			tmp = (StringPool.NUMBER0 + cal.get(Calendar.MINUTE));
			out[INDEX_PHUT] = tmp.substring(tmp.length() - 2, tmp.length());
			
			tmp = (StringPool.NUMBER0 + cal.get(Calendar.SECOND));
			out[INDEX_GIAY] = tmp.substring(tmp.length() - 2, tmp.length());
			
			tmp = (StringPool.NUMBER0 + cal.get(Calendar.HOUR_OF_DAY));
			out[INDEX_GIO24] = tmp.substring(tmp.length() - 2, tmp.length());
			
			out[INDEX_SANGCHIEU] = (
				cal.get(Calendar.HOUR_OF_DAY) < 12 
					? SANG
					: CHIEU
			);
		}
		return out;
	}
	
	/**
	  * This is fucntion getFullDateTime
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date, boolean includeSecond
	  * @return String
	  */
	public static String getFullDateTime(Date date, boolean includeSecond) {
		String[] arr = getFullDateTimeAsArray(date);
		
		if (arr.length == 0) {
			return StringPool.BLANK;
		}
		
		StringBuilder bdr = new StringBuilder();
		
		bdr.append(arr[INDEX_GIO24]).append(StringPool.SPACE).append(GIO);
		bdr.append(StringPool.SPACE);
		bdr.append(arr[INDEX_PHUT]).append(StringPool.SPACE).append(PHUT);
		
		if (includeSecond) {
			bdr.append(StringPool.SPACE);
			bdr.append(arr[INDEX_GIAY]).append(StringPool.SPACE).append(GIAY);
		}
		
		bdr.append(StringPool.COMMA_AND_SPACE);
		bdr.append(NGAY).append(StringPool.SPACE).append(arr[INDEX_NGAY]);
		bdr.append(StringPool.SPACE);
		bdr.append(THANG).append(StringPool.SPACE).append(arr[INDEX_THANG]);
		bdr.append(StringPool.SPACE);
		bdr.append(NAM).append(StringPool.SPACE).append(arr[INDEX_NAM]);
		return bdr.toString();
	}
	
	/**
	  * This is fucntion getFullDateTimeShort
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date, boolean includeSecond
	  * @return String
	  */
	public static String getFullDateTimeShort(Date date, boolean includeSecond) {
		String[] arr = getFullDateTimeAsArray(date);
		
		if (arr.length == 0) {
			return StringPool.BLANK;
		}
		
		StringBuilder out = new StringBuilder();
		out.append(arr[INDEX_GIO24]);
		out.append(StringPool.COLON);
		out.append(arr[INDEX_PHUT]);
		if (includeSecond) {
			out.append(StringPool.COLON);
			out.append(arr[INDEX_GIAY]);
		}
		out.append(StringPool.COMMA_AND_SPACE);
		out.append(NGAY);
		out.append(StringPool.SPACE);
		out.append(arr[INDEX_NGAY]);
		out.append(StringPool.SLASH);
		out.append(arr[INDEX_THANG]);
		out.append(StringPool.SLASH);
		out.append(arr[INDEX_NAM]);
		return out.toString();
	}
	
	
	/**
	  * This is fucntion addDay
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date, int daysToAdd
	  * @return Date
	  */
	public static Date addDay(Date date, int daysToAdd) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, daysToAdd);
		return cal.getTime();
	}
	
	
	/**
	  * This is fucntion addMonth
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date, int monthsToAdd
	  * @return Date
	  */
	public static Date addMonth(Date date, int monthsToAdd) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, monthsToAdd);
		return cal.getTime();
	}
	
	/**
	  * This is fucntion getStartOfDay
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return Date
	  */
	public static Date getStartOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	
	/**
	  * This is fucntion getStartOfMonth
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return Date
	  */
	public static Date getStartOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	
	/**
	  * This is fucntion getStartOfYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return Date
	  */
	public static Date getStartOfYear(Date date) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	
	/**
	  * This is fucntion getYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getYear(Date date) {
		if (date == null) {
			return null;
		}
		String s = getDayMonthYear(date);
		String out = StringPool.BLANK;
		if (!s.equals(StringPool.BLANK)) {
			out = s.substring(6);
		}
		return out;
	}
	
	/**
	  * This is fucntion getMonth
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getMonth(Date date) {
		String s = getDayMonthYear(date);
		String out = StringPool.BLANK;
		if (!s.equals(StringPool.BLANK)) {
			out = s.substring(3, 5);
		}
		return out;
	}
	
	/**
	  * This is fucntion getDay
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getDay(Date date) {
		String s = getDayMonthYear(date);
		String out = StringPool.BLANK;
		if (!s.equals(StringPool.BLANK)) {
			out = s.substring(0, 2);
		}
		return out;
	}
	
	/**
	  * This is fucntion getMonthYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getMonthYear(Date date) {
		String s = getDayMonthYear(date);
		String out = StringPool.BLANK;
		if (!s.equals(StringPool.BLANK)) {
			out = s.substring(3);
		}
		return out;
	}
	
	/**
	  * This is fucntion getDayMonth
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getDayMonth(Date date) {
		String s = getDayMonthYear(date);
		String out = StringPool.BLANK;
		if (!s.equals(StringPool.BLANK)) {
			out = s.substring(0, 5);
		}
		return out;
	}
	/**
	  * This is fucntion getHour
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getHour(Date date) {
		return date == null 
			? StringPool.BLANK 
			: _hmFormater.format(date).split(":")[0];
	}
	
	/**
	  * This is fucntion getMinute
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date
	  * @return String
	  */
	public static String getMinute(Date date) {
		return date == null 
			? StringPool.BLANK 
			: _hmFormater.format(date).split(":")[1];
	}
	
	/**
	  * This is fucntion getHourMinute
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Date date
	  * @return String
	  */
	public static String getHourMinute(Date date) {
		return date == null ? StringPool.BLANK : _hmFormater.format(date);
	}
	
	/**
	  * This is fucntion getHourMinuteNow
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return String
	  */
	public static String getHourMinuteNow() {
		return getHourMinute(getDateTimeNow());
	}
	
	/**
	  * This is fucntion getRequestDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String param
	  * @return Date
	  */
	public static Date getRequestDate(HttpServletRequest request, String param) {
		return param == null 
			? null 
			: parseDate(ParamUtil.getString(request, param).trim());
	}
	/**
	  * This is fucntion getRequestDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String param
	  * @return loDateng
	  */
	public static Date getRequestDate(PortletRequest request, String param) {
		return param == null 
			? null 
			: parseDate(ParamUtil.getString(request, param).trim());
	}
	/**
	  * This is fucntion getRequestDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HttpServletRequest request, String ddMMyyyyParam, String HHmmParam
	  * @return Date
	  */
	public static Date getRequestDate(HttpServletRequest request, String ddMMyyyyParam, String HHmmParam) {
		return ddMMyyyyParam == null || HHmmParam == null
			? null 
			: parseDate(
				ParamUtil.getString(request, ddMMyyyyParam),
				ParamUtil.getString(request, HHmmParam)
			);
	}
	/**
	  * This is fucntion getRequestDate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String ddMMyyyyParam, String HHmmParam
	  * @return Date
	  */
	public static Date getRequestDate(PortletRequest request, String ddMMyyyyParam, String HHmmParam) {
		return ddMMyyyyParam == null || HHmmParam == null
			? null 
			: parseDate(
				ParamUtil.getString(request, ddMMyyyyParam),
				ParamUtil.getString(request, HHmmParam)
			);
	}
	/**
	  * This is fucntion getDateOfRequestMonthYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String param
	  * @return Date
	  */
	public static Date getDateOfRequestMonthYear(PortletRequest request, String param) {
		return param == null 
			? null 
			: parseDate(
				FIRST_MONTH_DAY + ParamUtil.getString(request, param).trim()
			);
	}
	/**
	  * This is fucntion getDateOfRequestYear
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PortletRequest request, String param
	  * @return Date
	  */
	public static Date getDateOfRequestYear(PortletRequest request, String param) {
		if (param == null) {
			return null;
		} else {
			Calendar cal = Calendar.getInstance();
			cal.set(ParamUtil.getInteger(request, param), 0, 1);
			return cal.getTime();
		}
	}
}
