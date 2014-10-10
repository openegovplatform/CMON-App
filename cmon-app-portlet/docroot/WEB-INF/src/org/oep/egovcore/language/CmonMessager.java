package org.oep.egovcore.language;

import com.liferay.portal.kernel.util.StringPool;


/**
*
* CmonMessager class
*   
* This class is used to declare CmonMessager 
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
public class CmonMessager extends Messager {
	
	public CmonMessager(String prefix) {
		super(prefix);
	}

	@Override
	public String get(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return CmonMessagerUtil.get(createKey(_prefix, key));
	}

	@Override
	public String sub(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return CmonMessagerUtil.sub(createKey(_prefix, key), args);
	}

	@Override
	public String getEN(String key) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return CmonMessagerUtil.getEN(createKey(_prefix, key));
	}

	@Override
	public String subEN(String key, Object... args) {
		if (key == null) {
			return StringPool.BLANK;
		}
		return CmonMessagerUtil.subEN(createKey(_prefix, key), args);
	}
}
