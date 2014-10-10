package org.oep.egovcore.sqlutil;

import java.util.Date;

import javax.portlet.PortletRequest;

import org.oep.egovcore.util.DateTimeUtil;


import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author trungnnh
 * Build sql động theo request param
 */

/**
*
* DynamicSQLBuilder  class
*   
* This class is used to declare DynamicSQLBuilder 
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
public class DynamicSQLBuilder extends SQLBuilder {
	
	public PortletRequest _request;
	
	/**
	  * This is Contructor DynamicSQLBuilder
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String staticSQL, PortletRequest request
	  * @return 
	  */
	public DynamicSQLBuilder(String staticSQL, PortletRequest request) {
		super(staticSQL);
		_request = request;
	}
	
	public PortletRequest getRequest() {
		return _request;
	}
	
	/**
	  * This is fucntion dynStringLeft
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, String ignoreValue
	  * @return int
	  */
	public void dynStringLeft(String dbField, String requestField, String ignoreValue) {
		String value = ParamUtil.getString(_request, requestField, ignoreValue);
		if ( !value.equals(ignoreValue) ) {
			stringLeft(dbField, value);
		}
	}
	
	/**
	  * This is fucntion dynStringLeft
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynStringLeft(String dbField, String requestField) {
		dynStringLeft(dbField, requestField, StringPool.BLANK);
	}
	
	/**
	  * This is fucntion dynStringRight
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynStringRight(String dbField, String requestField) {
		dynStringRight(dbField, requestField, StringPool.BLANK);
	}
	
	/**
	  * This is fucntion dynStringRight
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, String ignoreValue
	  * @return void
	  */
	public void dynStringRight(String dbField, String requestField, String ignoreValue) {
		String value = ParamUtil.getString(_request, requestField, ignoreValue);
		if ( !value.equals(ignoreValue) ) {
			stringRight(dbField, value);
		}
	}
	/**
	  * This is fucntion dynStringFull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, String ignoreValue
	  * @return void
	  */
	public void dynStringFull(String dbField, String requestField, String ignoreValue) {
		String value = ParamUtil.getString(_request, requestField, ignoreValue);
		if ( !value.equals(ignoreValue) ) {
			stringFull(dbField, value);
		}
	}
	/**
	  * This is fucntion dynStringFull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynStringFull(String dbField, String requestField) {
		dynStringFull(dbField, requestField, StringPool.BLANK);
	}
	/**
	  * This is fucntion dynStringEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, String ignoreValue
	  * @return void
	  */
	public void dynStringEQ(String dbField, String requestField, String ignoreValue) {
		String value = ParamUtil.getString(_request, requestField, ignoreValue);
		if ( !value.equals(ignoreValue) ) {
			eq(dbField, value);
		}
	}
	/**
	  * This is fucntion dynStringEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynStringEQ(String dbField, String requestField) {
		dynStringEQ(dbField, requestField, StringPool.BLANK);
	}
	/**
	  * This is fucntion dynIntegerEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, int ignoreValue
	  * @return void
	  */
	public void dynIntegerEQ(String dbField, String requestField, int ignoreValue) {
		int value = ParamUtil.getInteger(_request, requestField, ignoreValue);
		if ( value != ignoreValue ) {
			eq(dbField, value);
		}
	}
	/**
	  * This is fucntion dynIntegerEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynIntegerEQ(String dbField, String requestField) {
		dynIntegerEQ(dbField, requestField, 0);
	}
	/**
	  * This is fucntion dynIntegerEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, int ignoreValue
	  * @return void
	  */
	public void dynIntegerEQ(String field, int ignoreValue) {
		dynIntegerEQ(field, field, ignoreValue);
	}
	/**
	  * This is fucntion dynLongEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField, long ignoreValue
	  * @return void
	  */
	public void dynLongEQ(String dbField, String requestField, long ignoreValue) {
		long value = ParamUtil.getLong(_request, requestField, ignoreValue);
		if ( value != ignoreValue ) {
			eq(dbField, value);
		}
	}
	/**
	  * This is fucntion dynLongEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynLongEQ(String dbField, String requestField) {
		dynLongEQ(dbField, requestField, 0L);
	}
	/**
	  * This is fucntion dynLongEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long ignoreValue
	  * @return void
	  */
	public void dynLongEQ(String field, long ignoreValue) {
		dynLongEQ(field, field, ignoreValue);
	}
	/**
	  * This is fucntion dynDateEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynDateEQ(String dbField, String requestField) {
		Date value = DateTimeUtil.getRequestDate(_request, requestField);
		if ( value != null ) {
			eq(dbField, value);
		}
	}
	/**
	  * This is fucntion dynDateGT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynDateGT(String dbField, String requestField) {
		Date value = DateTimeUtil.getRequestDate(_request, dbField);
		if ( value != null ) {
			gt(dbField, value);
		}
	}
	/**
	  * This is fucntion dynDateGTE
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynDateGTE(String dbField, String requestField) {
		Date value = DateTimeUtil.getRequestDate(_request, dbField);
		if ( value != null ) {
			gte(dbField, value);
		}
	}
	/**
	  * This is fucntion dynDateLT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynDateLT(String dbField, String requestField) {
		Date value = DateTimeUtil.getRequestDate(_request, dbField);
		if ( value != null ) {
			lt(dbField, value);
		}
	}
	/**
	  * This is fucntion dynDateLTE
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestField
	  * @return void
	  */
	public void dynDateLTE(String dbField, String requestField) {
		Date value = DateTimeUtil.getRequestDate(_request, dbField);
		if ( value != null ) {
			lte(dbField, value);
		}
	}
	/**
	  * This is fucntion dynDateBTW
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestFieldFrom, String requestFieldTo
	  * @return void
	  */
	public void dynDateBTW(String dbField, String requestFieldFrom, String requestFieldTo) {
		Date value;
		value = DateTimeUtil.getRequestDate(_request, requestFieldFrom);
		if ( value != null ) {
			gte(dbField, value);
		}
		
		value = DateTimeUtil.getRequestDate(_request, requestFieldTo);
		if ( value != null ) {
			lte(dbField, value);
		}
	}
	/**
	  * This is fucntion dynInString
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestFields
	  * @return void
	  */
	public void dynInString(String dbField, String requestFields) {
		in(dbField, ParamUtil.getParameterValues(_request, requestFields));
	}
	/**
	  * This is fucntion dynInLong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestFields
	  * @return void
	  */
	public void dynInLong(String dbField, String requestFields) {
		in(dbField, ParamUtil.getLongValues(_request, requestFields));
	}
	/**
	  * This is fucntion dynInInteger
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dbField, String requestFields
	  * @return void
	  */
	public void dynInInteger(String dbField, String requestFields) {
		in(dbField, ParamUtil.getIntegerValues(_request, requestFields));
	}
}