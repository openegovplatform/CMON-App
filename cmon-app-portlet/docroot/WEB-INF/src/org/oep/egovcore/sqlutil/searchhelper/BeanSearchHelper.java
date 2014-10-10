package org.oep.egovcore.sqlutil.searchhelper;

import java.util.List;

import org.oep.egovcore.sqlutil.BeanSQLQuery;
import org.oep.egovcore.sqlutil.DynamicSQLBuilder;
import org.oep.egovcore.sqlutil.QueryResultImpl;

import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* BeanSearchHelper  class
*   
* This class is used to declare BeanSearchHelper 
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
public class BeanSearchHelper<T> extends BaseSearchHelper {
	
	public static final String SUFFIX = " ) SELECT (SELECT MAX(ROWNUM) FROM result__) ${resultCount__} , result__.*, ROWNUM AS r_ FROM result__ WHERE rownum < :end__) WHERE r_ >= :start__";
	

	public BeanSearchHelper(BasePersistenceImpl<?> persistence, DynamicSQLBuilder sqlBuider, Class<? extends T> beanClass) {
		_persistence = persistence;
		_sqlBuilder = sqlBuider;
		_beanClass = beanClass;
	}
	/**
	  * This is fucntion search
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return QueryResult<T>
	  */
	public QueryResult<T> search() throws Exception {
		
		String sql = _wrapSQL(_sqlBuilder.build(), PREFIX, SUFFIX);
		BeanSQLQuery<T> beanQuery = new BeanSQLQuery<T>(_beanClass, _persistence, sql);
		_sqlBuilder.bindParams(beanQuery);
		_setStartEnd(beanQuery, _sqlBuilder.getRequest());
		beanQuery.addScalar("resultCount__", Type.LONG);
		beanQuery.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<T> beanResult = beanQuery.getBeanResult();
		
		int fetchedCount = beanResult.size();
		long resultCount = fetchedCount;
		
		List<Object[]> otherResult = beanQuery.getOtherResult();
		
		if (!otherResult.isEmpty()) {
			resultCount = (Long) otherResult.get(0)[0];
		}
		
		return new QueryResultImpl<T>(beanResult, resultCount, fetchedCount);
	}

	private BasePersistenceImpl<?> _persistence;
	private DynamicSQLBuilder _sqlBuilder;
	private Class<? extends T> _beanClass;

}
