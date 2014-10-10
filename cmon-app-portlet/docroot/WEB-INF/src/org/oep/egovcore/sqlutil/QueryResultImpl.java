package org.oep.egovcore.sqlutil;

import java.util.List;

import org.oep.egovcore.sqlutil.QueryResult;
/**
*
* QueryResultImpl  class
*   
* This class is used to declare QueryResultImpl 
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
public class QueryResultImpl<T> implements QueryResult<T> {
	
	private List<T> _result;
	private long _resultCount;
	private int _fetchedCount;
	
	/**
	  * This is Contructor QueryResultImpl
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param List<T> result, long resultCount, int fetchedCount
	  * @return 
	  */
	public QueryResultImpl(List<T> result, long resultCount, int fetchedCount) {
		_result = result;
		_resultCount = resultCount;
		_fetchedCount = fetchedCount;
	}
	
	
	/**
	  * This is fucntion getResultCount
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return long
	  */
	public long getResultCount() {
		return _resultCount;
	}
	
	/**
	  * This is fucntion getFetchedCount
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return int
	  */
	public int getFetchedCount() {
		return _fetchedCount;
	}
	
	/**
	  * This is fucntion getResult
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<T>
	  */
	public List<T> getResult() {
		return _result;
	}
}