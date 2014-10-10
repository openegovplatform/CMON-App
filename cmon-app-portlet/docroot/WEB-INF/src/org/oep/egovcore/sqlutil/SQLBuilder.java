package org.oep.egovcore.sqlutil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.oep.egovcore.util.DateTimeUtil;
import org.oep.egovcore.util.Helper;


import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * @author hoangtrung.nguyen
 */
/**
*
* SQLBuilder  class
*   
* This class is used to declare SQLBuilder 
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
public class SQLBuilder {
	
	public static final String WHERE_HOLDER = "__where__";
	public static final String ORDER_HOLDER = "__order__";
	
	private static final String BEGIN_ORDER = " ORDER BY ";
	private static final String AND = " AND ";
	private static final String OR = " OR ";
	private static final String ASC = " ASC,";
	private static final String DESC = " DESC,";
	private static final String LIKE = " LIKE ";
	private static final String IS_NULL = " IS NULL ";
	private static final String IS_NOT_NULL = " IS NOT NULL ";
	private static final String CONCAT = " || ";
	private static final String PERCENT = " '%' ";
	private static final String TO_DATE = "TO_DATE('";
	private static final String STR_PARAM_SEP = "','";
	private static final String STR_END_FUNC = "')";
	private static final String BEGIN_WHERE = " WHERE 1=1 ";
	private static final String BEGIN_IN = " IN ( ";
	
	private StringBuilder _where;
	private List<String> _values;
	private StringBuilder _orders;
	private String _staticSQL;
	private String _holder;
	
	/**
	  * This is Contructor 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String
	  * @return 
	  */
	public SQLBuilder(String staticSQL) {
		_staticSQL = staticSQL;
		_where = new StringBuilder();
		_values = new ArrayList<String>();
		_orders = new StringBuilder();
		_holder = new StringBuilder(StringPool.UNDERLINE)
			.append(hashCode())
			.append(StringPool.UNDERLINE)
			.toString()
		;
	}
	
	/**
	  * This is fucntion stringLeft
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void stringLeft(String field, String value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(LIKE)
			.append(_genParamHolder(value))
			.append(CONCAT)
			.append(PERCENT);
	}
	
	/**
	  * This is fucntion stringRight
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void stringRight(String field, String value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(LIKE)
			.append(PERCENT)
			.append(CONCAT)
			.append(_genParamHolder(value))
		;
	}
	
	/**
	  * This is fucntion stringFull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void stringFull(String field, String value) {
		value = value.trim().replaceAll(" +", StringPool.SPACE).toLowerCase();
		_where
			.append(AND)
			.append("LOWER(")
			.append(field.trim())
			.append(StringPool.CLOSE_PARENTHESIS)
			.append(LIKE)
			.append(PERCENT)
			.append(CONCAT)
			.append(_genParamHolder(value))
			.append(CONCAT)
			.append(PERCENT);
	}
	
	/**
	  * This is fucntion eq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void eq(String field, String value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.EQUAL)
			.append(_genParamHolder(value))
		;
	}
	/**
	  * This is fucntion eq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long value
	  * @return void
	  */
	public void eq(String field, long value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion eq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, int value
	  * @return void
	  */
	public void eq(String field, int value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion neq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void neq(String field, String value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.NOT_EQUAL)
			.append(_genParamHolder(value))
		;
	}
	/**
	  * This is fucntion neq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long value
	  * @return void
	  */
	public void neq(String field, long value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.NOT_EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion neq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, int value
	  * @return void
	  */
	public void neq(String field, int value) {
		_where
			.append(AND)
			.append(field.trim())
			.append(StringPool.NOT_EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion eq
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date value
	  * @return void
	  */
	public void eq(String field, Date value) {
		if (value != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(value);
			cal.add(Calendar.DATE, 1);
			gte(field, value);
			lt(field, cal.getTime());
		}
	}
	/**
	  * This is fucntion gt
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date value
	  * @return void
	  */
	public void gt(String field, Date value) {
		if (value != null) {
			_where
				.append(AND)
				.append(field.trim())
				.append(StringPool.GREATER_THAN)
				.append(TO_DATE)
				.append(DateTimeUtil.getDayMonthYear(value))
				.append(STR_PARAM_SEP)
				.append(DateTimeUtil.DF)
				.append(STR_END_FUNC);
		}
	}
	/**
	  * This is fucntion gte
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date value
	  * @return void
	  */
	public void gte(String field, Date value) {
		if (value != null) {
			_where
				.append(AND)
				.append(field.trim())
				.append(StringPool.GREATER_THAN_OR_EQUAL)
				.append(TO_DATE)
				.append(DateTimeUtil.getDayMonthYear(value))
				.append(STR_PARAM_SEP)
				.append(DateTimeUtil.DF)
				.append(STR_END_FUNC);
		}
	}
	/**
	  * This is fucntion lt
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date value
	  * @return void
	  */
	public void lt(String field, Date value) {
		if (value != null) {
			_where
				.append(AND)
				.append(field.trim())
				.append(StringPool.LESS_THAN)
				.append(TO_DATE)
				.append(DateTimeUtil.getDayMonthYear(value))
				.append(STR_PARAM_SEP)
				.append(DateTimeUtil.DF)
				.append(STR_END_FUNC);
		}
	}
	/**
	  * This is fucntion lte
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date value
	  * @return void
	  */
	public void lte(String field, Date value) {
		if (value != null) {
			_where
				.append(AND)
				.append(field.trim())
				.append(StringPool.LESS_THAN_OR_EQUAL)
				.append(TO_DATE)
				.append(DateTimeUtil.getDayMonthYear(value))
				.append(STR_PARAM_SEP)
				.append(DateTimeUtil.DF)
				.append(STR_END_FUNC);
		}
	}
	
	/**
	  * This is fucntion btw
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Date date1, Date date2
	  * @return void
	  */
	public void btw(String field, Date date1, Date date2) {
		gte(field, date1);
		lte(field, date2);
	}
	/**
	  * This is fucntion preEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void preEQ(String field, String value) {
		_where
			.insert(0, value)
			.insert(0, StringPool.EQUAL)
			.insert(0, field.trim())
			.insert(0, AND);
	}
	/**
	  * This is fucntion preEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long value
	  * @return void
	  */
	public void preEQ(String field, long value) {
		_where
			.insert(0, value)
			.insert(0, StringPool.EQUAL)
			.insert(0, field.trim())
			.insert(0, AND);
	}
	/**
	  * This is fucntion orEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long value
	  * @return void
	  */
	public void orEQ(String field, long value) {
		_where
			.append(OR)
			.append(field.trim())
			.append(StringPool.EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion preOrEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long value
	  * @return void
	  */
	public void preOrEQ(String field, long value) {
		_where
			.insert(0, value)
			.insert(0, StringPool.EQUAL)
			.insert(0, field.trim())
			.insert(0, OR);
	}
	/**
	  * This is fucntion orEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void orEQ(String field, String value) {
		_where
			.append(OR)
			.append(field.trim())
			.append(StringPool.EQUAL)
			.append(value);
	}
	/**
	  * This is fucntion preOrEQ
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, String value
	  * @return void
	  */
	public void preOrEQ(String field, String value) {
		_where
			.insert(0, value)
			.insert(0, StringPool.EQUAL)
			.insert(0, field.trim())
			.insert(0, OR);
	}
	/**
	  * This is fucntion isNull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field
	  * @return void
	  */
	public void isNull(String field) {
		_where
			.append(AND)
			.append(field.trim())
			.append(IS_NULL);
	}
	
	
	/**
	  * This is fucntion preIsNull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field
	  * @return void
	  */
	public void preIsNull(String field) {
		_where
			.insert(0, IS_NULL)
			.insert(0, field.trim())
			.insert(0, AND);
	}
	
	
	/**
	  * This is fucntion isNotNull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field
	  * @return void
	  */
	public void isNotNull(String field) {
		_where
			.append(AND)
			.append(field.trim())
			.append(IS_NOT_NULL);
	}
	
	/**
	  * This is fucntion preIsNotNull
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field
	  * @return void
	  */
	public void preIsNotNull(String field) {
		_where
			.insert(0, IS_NOT_NULL)
			.insert(0, field.trim())
			.insert(0, AND);
	}
	
	/**
	  * This is fucntion in
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, Collection<?> collection
	  * @return void
	  */
	public void in(String field, Collection<?> collection) {
		
		if (collection != null && !collection.isEmpty()) {
			_where
				.append(AND)
				.append(field.trim())
				.append(BEGIN_IN)
				.append(Helper.join(collection))
				.append(StringPool.CLOSE_PARENTHESIS)
			;
		}
	}
	
	/**
	  * This is fucntion in
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, T[] arr
	  * @return void
	  */
	public <T> void in(String field, T[] arr) {
		
		if (arr != null && arr.length > 0) {
			_where
				.append(AND)
				.append(field.trim())
				.append(BEGIN_IN)
				.append(Helper.join(arr))
				.append(StringPool.CLOSE_PARENTHESIS)
			;
		}
	}
	
	/**
	  * This is fucntion in
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, int[] arr
	  * @return void
	  */
	public void in(String field, int[] arr) {
		
		if (arr != null && arr.length > 0) {
			_where
				.append(AND)
				.append(field.trim())
				.append(BEGIN_IN)
				.append(Helper.join(arr))
				.append(StringPool.CLOSE_PARENTHESIS)
			;
		}
	}
	
	/**
	  * This is fucntion in
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String field, long[] arr
	  * @return void
	  */
	public void in(String field, long[] arr) {
		
		if (arr != null && arr.length > 0) {
			_where
				.append(AND)
				.append(field.trim())
				.append(BEGIN_IN)
				.append(Helper.join(arr))
				.append(StringPool.CLOSE_PARENTHESIS)
			;
		}
	}
	
	/**
	  * This is fucntion orderASC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String fields
	  * @return void
	  */
	public void orderASC(String fields) {
		_orders.append(fields + ASC);
	}
	
	/**
	  * This is fucntion orderDESC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String fields
	  * @return void
	  */
	public void orderDESC(String fields) {
		_orders.append(fields + DESC);
	}
	
	protected Log _log = LogFactoryUtil.getLog(SQLBuilder.class); 
	
	
	/**
	  * This is fucntion build
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return String
	  */
	public String build() {
		
		_staticSQL = _staticSQL.replaceFirst(
			WHERE_HOLDER,
			_where.insert(0, BEGIN_WHERE).toString()
		);
		
		if (_orders.length() > 0) {
			_orders.deleteCharAt(_orders.length() - 1);
			_orders.insert(0, BEGIN_ORDER).append(StringPool.SPACE);
			
			if (_staticSQL.contains(ORDER_HOLDER)) {
				_staticSQL = _staticSQL.replaceFirst(
					ORDER_HOLDER,
					_orders.toString()
				);
			} else {
				_staticSQL = _staticSQL + _orders;
			}
		}
		
		return _staticSQL;
	}
	
	
	/**
	  * This is fucntion bindParams
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Query query
	  * @return void
	  */
	public void bindParams(Query query) {
		int size = _values.size();
        for(int i = 0; i < size; ++ i) {
        	query.setString(_holder + i, _values.get(i));
        }
	}
	
	/**
	  * This is fucntion _genParamHolder
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String value
	  * @return String
	  */
	private String _genParamHolder(String value) {
		String out = new StringBuilder(StringPool.COLON)
			.append(_holder)
			.append(_values.size())
			.toString();
		_values.add(value);
		return out;
	}
}
