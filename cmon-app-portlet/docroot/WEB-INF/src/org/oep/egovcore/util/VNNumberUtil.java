package org.oep.egovcore.util;

import com.liferay.portal.kernel.util.StringPool;

/**
*
* VNNumberUtil  class
*   
* This class is used to declare VNNumberUtil 
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
public class VNNumberUtil {
	
	/**
	  * This is fucntion toNum
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String vnNumStr
	  * @return double
	  */
	public static double toNum(String vnNumStr) {
		double out;
		try {
			out = Double.parseDouble(
				vnNumStr.trim()
				.replace(StringPool.PERIOD, StringPool.BLANK)
				.replace(StringPool.COMMA, StringPool.PERIOD)
			);
		} catch (NumberFormatException nfe) {
			out = 0D;
		}
		return out;
	}
	/**
	  * This is fucntion toVNNum
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param double num
	  * @return String
	  */
	public static String toVNNum(double num) {
		String sNum = String.format("%.2f", num);
		String[] parts = sNum.split("\\.");
		
		sNum = String
			.format("%,15d", Long.parseLong(parts[0]))
			.trim()
			.replace(StringPool.COMMA, StringPool.PERIOD);
		
		return parts[1].equals("00") 
			? sNum 
			: sNum.concat(StringPool.COMMA).concat(parts[1]);
	}
}
