package org.oep.egovcore.util;

import java.io.File;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
*
* Helper  class
*   
* This class is used to declare Helper 
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
public class Helper {
	
	/**
	  * This is fucntion getReadableVolume
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long bytes
	  * @return String
	  */
	public static String getReadableVolume(long bytes) {
		int unit = 1024;
		if (bytes < unit) {
			return bytes + " B";
		}
		int exp = (int) (Math.log(bytes) / Math.log(unit));
		char pre = ("KMGTPE").charAt(exp-1);
		return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
	}
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int[] arr, int val
	  * @return boolean
	  */
	
	public static boolean inArray(int[] arr, int val) {
		if (arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; ++ i) {
			if (arr[i] == val) {
				return true;
			}
		}
		return false;
	}
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Integer[] arr, int val
	  * @return boolean
	  */
	public static boolean inArray(Integer[] arr, int val) {
		if (arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; ++ i) {
			if (arr[i] == val) {
				return true;
			}
		}
		return false;
	}
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long[] arr, long val
	  * @return boolean
	  */
	public static boolean inArray(long[] arr, long val) {
		if (arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; ++ i) {
			if (arr[i] == val) {
				return true;
			}
		}
		return false;
	}
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long[] arr, long val
	  * @return boolean
	  */
	public static boolean inArray(Long[] arr, long val) {
		if (arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; ++ i) {
			if (arr[i] == val) {
				return true;
			}
		}
		return false;
	}
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String[] arr, String val
	  * @return boolean
	  */
	public static boolean inArray(String[] arr, String val) {
		if (arr == null) {
			return false;
		}
		for (int i = 0; i < arr.length; ++ i) {
			if (arr[i].trim().equals(val.trim())) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	  * This is fucntion inArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String[] arr, String val, boolean isIgnoreCase
	  * @return boolean
	  */
	public static boolean inArray(String[] arr, String val, boolean isIgnoreCase) {
		if (arr == null) {
			return false;
		}
		
		if (isIgnoreCase) {
			for (int i = 0; i < arr.length; ++ i) {
				if (arr[i].trim().equalsIgnoreCase(val.trim())) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < arr.length; ++ i) {
				if (arr[i].trim().equals(val.trim())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	/**
	  * This is fucntion stringFromArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String[] arr, int i
	  * @return String
	  */
	public static String stringFromArray(String[] arr, int i) {
		return (arr == null || arr.length <= i || arr[i] == null)
			? StringPool.BLANK
			: arr[i].trim();
	}
	
	
	/**
	  * This is fucntion fileFromArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param File[] arr, int i
	  * @return File
	  */
	public static File fileFromArray(File[] arr, int i) {
		return (arr == null || arr.length <= i || arr[i] == null)
			? null
			: arr[i];
	}
	
	
	/**
	  * This is fucntion numberFromArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int[] arr, int i
	  * @return int
	  */
	public static int numberFromArray(int[] arr, int i) {
		return (arr == null || arr.length <= i) ? 0 : arr[i];
	}
	
	
	/**
	  * This is fucntion numberFromArray
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long[] arr, int i
	  * @return long
	  */
	public static long numberFromArray(long[] arr, int i) {
		return (arr == null || arr.length <= i) ? 0 : arr[i];
	}
	
	
	/**
	  * This is fucntion parseArrayLONG
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String in
	  * @return Long[]
	  */
	public static Long[] parseArrayLONG(String in) {
		String[] inArr = StringUtils.split(in, StringPool.COMMA);
		Long[] out = new Long[inArr.length];
		for (int i = 0; i < out.length; i ++) {
	    	out[i] = GetterUtil.getLong(inArr[i]);
		}
		return out;
	}
	
	
	/**
	  * This is fucntion parseArrayLong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String in
	  * @return long[]
	  */
	public static long[] parseArrayLong(String in) {
		String[] inArr = StringUtils.split(in, StringPool.COMMA);
		long[] out = new long[inArr.length];
		for (int i = 0; i < out.length; i ++) {
			out[i] = GetterUtil.getLong(inArr[i]);
		}
		return out;
	}
	
	
	/**
	  * This is fucntion parseArrayINTEGER
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String in
	  * @return Integer[]
	  */
	public static Integer[] parseArrayINTEGER(String in) {
		String[] inArr = StringUtils.split(in, StringPool.COMMA);
		Integer[] out = new Integer[inArr.length];
		for (int i = 0; i < out.length; i ++) {
			out[i] = GetterUtil.getInteger(inArr[i]);
		}
		return out;
	}
	
	
	/**
	  * This is fucntion parseArrayInt
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return int[]
	  */
	public static int[] parseArrayInt(String in) {
		String[] inArr = StringUtils.split(in, StringPool.COMMA);
		int[] out = new int[inArr.length];
		for (int i = 0; i < out.length; i ++) {
			out[i] = GetterUtil.getInteger(inArr[i]);
		}
		return out;
	}
	
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int[] arr
	  * @return String
	  */
	public static String join(int[] arr) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (int n : arr) {
			out.append(n).append(StringPool.COMMA);
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long[] arr
	  * @return String
	  */
	public static String join(long[] arr) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (long n : arr) {
			out.append(n).append(StringPool.COMMA);
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Collection<?> collection
	  * @return String
	  */
	public static String join(Collection<?> collection) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (Object o : collection) {
			if (o != null) {
				out.append(o).append(StringPool.COMMA);
			}
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Collection<?> collection, boolean escapeString
	  * @return String
	  */
	public static String join(Collection<?> collection, boolean escapeString) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (Object o : collection) {
			if (o != null) {
				if (escapeString) {
					out
						.append(StringPool.APOSTROPHE)
						.append(o)
						.append(StringPool.APOSTROPHE)
						.append(StringPool.COMMA);
				} else {
					out.append(o).append(StringPool.COMMA);
				}
			}
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
	
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param T[] arr
	  * @return <T> String
	  */
	public static <T> String join(T[] arr) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (T o : arr) {
			if (o != null) {
				out.append(o).append(StringPool.COMMA);
			}
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
	
	
	/**
	  * This is fucntion join
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param T[] arr, boolean escapeString
	  * @return <T> String
	  */
	public static <T> String join(T[] arr, boolean escapeString) {
		StringBuilder out = new StringBuilder(StringPool.BLANK);
		
		for (T o : arr) {
			if (o != null) {
				if (escapeString) {
					out
						.append(StringPool.APOSTROPHE)
						.append(o)
						.append(StringPool.APOSTROPHE)
						.append(StringPool.COMMA);
				} else {
					out.append(o).append(StringPool.COMMA);
				}
			}
		}
		
		if (out.length() > 0) {
			out.deleteCharAt(out.length() - 1);
		}
		
		return out.toString();
	}
}
