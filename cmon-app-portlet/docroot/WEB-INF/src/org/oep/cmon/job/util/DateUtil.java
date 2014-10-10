package org.oep.cmon.job.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;

/** 
 * This is class DateUtil
 * 
 * This class contains method to manipulate a date
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-May-2013  Nam Dinh    Create new
 */
public class DateUtil {
	
	/** Date format pattern */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/** Date time format */
	private static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	
	/**
	 * This constructor will prevent user from initializing this class
	 */
	private DateUtil(){
		// Do nothing
	}
	
	/**
	 * This is  function isDate
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return boolean
	 */  
	public static boolean isDate(String date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
		try {
			df.parse(date);
		} catch (ParseException e) {
			// Swallow exception
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * This is  function isDateTime
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return boolean
	 */  
	public static boolean isDateTime(String date) {
		DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
		df.setLenient(false);
		try {
			df.parse(date);
		} catch (ParseException e) {
			// Swallow exception
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * This is  function parseDate
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return date
	 */  
	public static Date parseDate(String date) {
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		df.setLenient(false);
	
		try {
			return df.parse(date);
		} catch (ParseException e) {
			
			return null;
		}
	}
	
	/**
	 * This is  function parseDateTime
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return date
	 */  
	public static Date parseDateTime(String date) {
		
		DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
		df.setLenient(false);
	
		try {
			return df.parse(date);
		} catch (ParseException e) {
			
			return null;
		}
	}
	
	/**
	 * This is  function parseDateTime
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param date
	 * @return String
	 */  
	public static String parseDateTime(Date date) {
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	
		try {
			return df.format(date);
		} catch (Exception e) {
			return df.format(new Date());
		}
	}
	
	/**
	 * This is  function getHoSoTTHCCongByMaSoHoSo
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param maSoHoSo
	 * @return List<HoSoTTHCCong>
	 */  
	public static List<HoSoTTHCCong> getHoSoTTHCCongByMaSoHoSo(String maSoHoSo) {
		try {
			return HoSoTTHCCongLocalServiceUtil.findByMaSoHoSo(maSoHoSo);
		} catch (Exception e) {
			try {
				return HoSoTTHCCongLocalServiceUtil.findByMaSoHoSo(maSoHoSo);
			} catch (Exception e1) {
			}
		}
		
		return new ArrayList<HoSoTTHCCong>();
	}

}
