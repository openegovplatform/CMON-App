package org.oep.egovcore.language;

import java.util.Locale;
import java.util.ResourceBundle;

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author hoangtrung.nguyen
 */
/**
*
* CmonMessagerUtil class
*   
* This class is used to declare CmonMessagerUtil 
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
public class CmonMessagerUtil {
	
	public static CmonMessager forPrefix(String prefix) {
		return new CmonMessager(prefix);
	}
	
	public static String sub(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return Messager.substitute(get(key), args);
	}
	
	public static String subEN(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return Messager.substitute(getEN(key), args);
	}
	
	public static String get(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		if (_viBundle.containsKey(key)) {
			return _viBundle.getString(key);
		} else {
			return key;
		}
	}
	
	public static String getEN(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		if (_enBundle.containsKey(key)) {
			return _enBundle.getString(key);
		} else {
			return key;
		}
	}
	
	private static final String PATH = "/content/cmon/Language";
	private static ResourceBundle _viBundle = ResourceBundle.getBundle(PATH, new Locale("vi"));
	private static ResourceBundle _enBundle = ResourceBundle.getBundle(PATH, Locale.ENGLISH);
	
	public static void clearCache() {
		ResourceBundle.clearCache(CmonMessagerUtil.class.getClassLoader());
	}
}
