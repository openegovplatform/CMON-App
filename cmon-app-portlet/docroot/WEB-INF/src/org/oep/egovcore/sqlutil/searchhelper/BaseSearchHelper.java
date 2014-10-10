package org.oep.egovcore.sqlutil.searchhelper;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
*
* BaseSearchHelper abstract class
*   
* This class is used to declare BaseSearchHelper 
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
public abstract class BaseSearchHelper {

	public static final int DEFAULT_START = 1;
	public static final int DEFAULT_END = 15;
	public static final String REQUEST_START_PNAME = "start";
	public static final String REQUEST_END_PNAME = "end";
	public static final String START_ALIAS = "start__";
	public static final String END_ALIAS = "end__";
	public static final String PREFIX = "SELECT * FROM (WITH result__ AS (";
	public static final String SUFFIX = " ) SELECT (SELECT MAX(ROWNUM) FROM result__) resultCount__ , result__.*, ROWNUM AS r_ FROM result__ WHERE rownum < :end__) WHERE r_ >= :start__";
	
	
	/**
	  * This is fucntion _setStartEnd
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Query query, PortletRequest request
	  * @return void
	  */
	protected void _setStartEnd(Query query, PortletRequest request) {
		int start = ParamUtil.getInteger(request, REQUEST_START_PNAME, DEFAULT_START);
		int end = ParamUtil.getInteger(request, REQUEST_END_PNAME, start + DEFAULT_END);
		query.setInteger(START_ALIAS, start);
		query.setInteger(END_ALIAS, end);
	}
	
	
	/**
	  * This is fucntion _wrapSQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String sql, String prefix, String suffix
	  * @return String
	  */
	protected String _wrapSQL(String sql, String prefix, String suffix) {
		return new StringBuilder(prefix)
			.append(sql)
			.append(StringPool.SPACE)
			.append(suffix)
			.toString();
	}
}
