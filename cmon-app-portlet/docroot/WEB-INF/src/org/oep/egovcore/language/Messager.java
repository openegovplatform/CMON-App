package org.oep.egovcore.language;

import com.liferay.portal.kernel.util.StringPool;
/**
*
* Messager abstract class
*   
* This class is used to declare Messager 
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
public abstract class Messager {
	
	public static final String SEP = StringPool.PERIOD;
	protected String _prefix;
	
	public void setPrefix(String prefix) {
		_prefix = (prefix == null) ? StringPool.BLANK : prefix;
	}
	
	public String getPrefix() {
		return _prefix;
	}
	
	public String getFullKey(String key) {
		return createKey(_prefix, key);
	}
	
	public Messager(String prefix) {
		setPrefix(prefix);
	}
	
	public static String createKey(String prefix, String key) {
		return new StringBuilder(prefix).append(SEP).append(key).toString();
	}
	
	public static String substitute(String out, Object... args) {
		if (out == null) {
			return StringPool.BLANK;
		}
		for (int i = 0; i < args.length; ++ i) {
			if (args[i] == null) {
				continue;
			}
			out = out.replace(
				new StringBuilder(StringPool.OPEN_CURLY_BRACE)
					.append(i)
					.append(StringPool.CLOSE_CURLY_BRACE)
				, args[i].toString()
			);
		}
		return out;
	}
	
	public abstract String get(String key);
	public abstract String sub(String key, Object... args);
	public abstract String getEN(String key);
	public abstract String subEN(String key, Object... args);
}
