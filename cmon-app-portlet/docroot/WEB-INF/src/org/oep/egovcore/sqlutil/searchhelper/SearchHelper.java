package org.oep.egovcore.sqlutil.searchhelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.oep.egovcore.sqlutil.DynamicSQLBuilder;
import org.oep.egovcore.sqlutil.QueryResultImpl;

import org.oep.egovcore.sqlutil.QueryResult;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* SearchHelper  class
*   
* This class is used to declare AjaxMVCPortlet 
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
public class SearchHelper<T> extends BaseSearchHelper {
	
	public SearchHelper(BasePersistenceImpl<?> persistence, DynamicSQLBuilder sqlBuilder) {
		_persistence = persistence;
		_sqlBuilder = sqlBuilder;
	}
	/**
	  * This is fucntion createQuery
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return SQLQuery
	  */
	public SQLQuery createQuery() {
		_session = _persistence.openSession();
		String sql = _wrapSQL(_sqlBuilder.build(), PREFIX, SUFFIX);
		_query = _session.createSQLQuery(sql);
		_sqlBuilder.bindParams(_query);
		_setStartEnd(_query, _sqlBuilder.getRequest());
		_query.addScalar("resultCount__", Type.LONG);
		return _query;
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
	@SuppressWarnings("unchecked")
	public QueryResult<T> search() {
		
		if (_query == null) {
			createQuery();
		}
		
		List<Object[]> rawResult = (List<Object[]>) QueryUtil.list(
			_query,
			_persistence.getDialect(), 
			QueryUtil.ALL_POS,
			QueryUtil.ALL_POS
		);
		
		_persistence.closeSession(_session);
		
		int fetchedCount = rawResult.size();
		long resultCount = fetchedCount;
		List<T> result = new ArrayList<T>();
		
		if (fetchedCount > 0) {
			
			resultCount = (Long) rawResult.get(0)[0];
			
			Object[] row;
			for(int i = 0; i < fetchedCount; ++ i) {
				
				row = rawResult.get(i);
				
				if (row.length == 2) {
					result.add((T) row[1]);
				} else {
					result.add((T) Arrays.copyOfRange(row, 1, row.length));
				}
			}
		}
		
        return new QueryResultImpl<T>(result, resultCount, fetchedCount);
	}
	
	private BasePersistenceImpl<?> _persistence;
	private DynamicSQLBuilder _sqlBuilder;
	private Session _session; 
	private SQLQuery _query;
}
