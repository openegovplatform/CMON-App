package org.oep.egovcore.sqlutil;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.oep.egovcore.util.StringPool;


import com.liferay.portal.kernel.dao.orm.CacheMode;
import com.liferay.portal.kernel.dao.orm.LockMode;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.ScrollableResults;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author hoangtrung.nguyen
 */
/**
*
* BeanSQLQuery<T>  class
*   
* This class is used to declare BeanSQLQuery<T> 
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
@SuppressWarnings("rawtypes")
public class BeanSQLQuery<T> implements Query {
	
	public BeanSQLQuery(Class<? extends T> beanClass, BasePersistenceImpl<?> persistence, String sql) throws IntrospectionException {
		_beanClass = beanClass;
		sql = _parseSQL(sql, Introspector.getBeanInfo(_beanClass).getPropertyDescriptors());
		_persistence = persistence;
		_session = _persistence.openSession();
		_query = _session.createSQLQuery(sql);
	}
	/**
	  * This is fucntion addScalar
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, ResourceResponse response
	  * @return BeanSQLQuery
	  */
	public BeanSQLQuery addScalar(String arg0, Type arg1) {
		if (_otherScalarCount < _otherScalars.size()) {
			OtherScalar scalar = _otherScalars.get(_otherScalarCount);
			if (scalar.name.equals(arg0.trim())) {
				scalar.type = arg1;
				++ _otherScalarCount;
			}
		}
		return this;
	}
	/**
	  * This is fucntion query
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int start, int end
	  * @return void
	  */
	@SuppressWarnings("unchecked")
	public void query(int start, int end) throws Exception {
		
		_addScalars();
		
		List<Object[]> rawList = (List<Object[]>) QueryUtil.list(
			_query, _persistence.getDialect(), start, end
		);
		
		_persistence.closeSession(_session);
		
		T bean;
		Object value;
		_beanResult = new ArrayList<T>();
		Object[] otherResult;
		boolean isOtherScalarsAdded = (_otherScalarCount > 0);
		if (isOtherScalarsAdded) {
			_otherScalarResult = new ArrayList<Object[]>();
		}
		
		for (Object[] raw : rawList) {
			
			// Result to bean properties
			bean = _beanClass.newInstance();
			for (FoundBeanProp prop : _foundBeanProps) {
				
				value = raw[prop.index];
				Class<?> type = prop.desc.getPropertyType();
				
				if (value == null
					&& (
						type.equals(long.class)
					||	type.equals(int.class)		
					||	type.equals(boolean.class)		
					||	type.equals(double.class)		
					||	type.equals(float.class)		
					)
				) {
					continue;
				}
				
				prop.desc.getWriteMethod().invoke(bean, value);
			}
			
			_beanResult.add(bean);
			
			// Other results
			if (isOtherScalarsAdded) {
				otherResult = new Object[_otherScalarCount];
				for (int i = 0; i < _otherScalarCount; ++ i) {
					value = raw[_otherScalars.get(i).index];
					otherResult[i] = value;
				}
				_otherScalarResult.add(otherResult);
			}
		}
		
	}
	/**
	  * This is fucntion getBeanResult
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, ResourceResponse response
	  * @return List<T>
	  */
	public List<T> getBeanResult() {
		return _beanResult;
	}
	/**
	  * This is fucntion getOtherResult
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param ResourceRequest request, ResourceResponse response
	  * @return List<Object[]>
	  */
	public List<Object[]> getOtherResult() {
		return _otherScalarResult;
	}
	/**
	  * This is fucntion _parseSQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String sql, PropertyDescriptor[] props
	  * @return String
	  */
	private String _parseSQL(String sql, PropertyDescriptor[] props) {
		
		Pattern patt = Pattern.compile(HOLDER_PATTERN);
 		Matcher m = patt.matcher(sql);
 		String paramName;
 		StringBuilder sqlBdr = new StringBuilder(sql);
 		int trimmedLen = 0;
 		int i = 0;
 		
		_foundBeanProps = new ArrayList<FoundBeanProp>();
		_otherScalars = new ArrayList<OtherScalar>();
 		
 		while (m.find()) {
 			
 			paramName = StringUtils.stripStart(m.group(1).trim(), StringPool.UNDERLINE);
 			PropertyDescriptor desc = _getBeanPropDescByName(props, paramName);
 			
 			if (desc == null) {
 				OtherScalar scalar = new OtherScalar();
 				scalar.index = i;
 				scalar.name = paramName;
 				_otherScalars.add(scalar);
 			} else {
 				FoundBeanProp foundProp = new FoundBeanProp();
 				foundProp.index = i;
 				foundProp.desc = desc;
 				_foundBeanProps.add(foundProp);
 			}
 			
 			sqlBdr.replace( m.start() - trimmedLen, m.end() - trimmedLen, paramName );
 			trimmedLen += m.group(0).length() - paramName.length();
			++ i;
 		}
 		
		return sqlBdr.toString();
 		
	}
	/**
	  * This is fucntion _addScalars
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return void
	  */
	private void _addScalars() {
		
		for (FoundBeanProp prop : _foundBeanProps) {
			
			Class<?> cls = prop.desc.getPropertyType();
			Type type;
			
			if (cls.equals(String.class)) {
				type = Type.STRING;
			} else if (cls.equals(long.class) || cls.equals(Long.class)) {
				type = Type.LONG;
			} else if (cls.equals(int.class) || cls.equals(Integer.class)) {
				type = Type.INTEGER;
			} else if (cls.equals(Date.class)) {
				type = Type.DATE;
			} else if (cls.equals(boolean.class) || cls.equals(Boolean.class)) {
				type = Type.BOOLEAN;
			} else if (cls.equals(double.class) || cls.equals(Double.class)) {
				type = Type.DOUBLE;
			} else if (cls.equals(float.class) || cls.equals(Float.class)) {
				type = Type.FLOAT;
				
			} else {
				type = Type.STRING;
			}
			
			_query.addScalar(prop.desc.getName(), type);
		}
		
		for (OtherScalar scalar : _otherScalars) {
			_query.addScalar(scalar.name, scalar.type);
		}
	}
	/**
	  * This is fucntion _getBeanPropDescByName
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param PropertyDescriptor[] props, String propName
	  * @return PropertyDescriptor
	  */
	private PropertyDescriptor _getBeanPropDescByName(PropertyDescriptor[] props, String propName) {
		PropertyDescriptor out = null;
		
		for (int i = 0; i < props.length; ++ i) {
			
			if (props[i].getName().equals(propName)
				&& !props[i].getPropertyType().equals(Class.class)
				&& props[i].getWriteMethod() != null
			) {
				out = props[i];
				break;
			}
		}
		return out;
	}
	
	private Class<? extends T> _beanClass;
	private BasePersistenceImpl<?> _persistence;
	private Session _session;
	private SQLQuery _query;
	private List<FoundBeanProp> _foundBeanProps;
	private List<OtherScalar> _otherScalars;
	private List<Object[]> _otherScalarResult = Collections.emptyList();
	private List<T> _beanResult = Collections.emptyList();
	private int _otherScalarCount = 0;
	
	private static class OtherScalar {
		public int index;
		public String name;
		public Type type;
	}
	
	private static class FoundBeanProp {
		public int index;
		public PropertyDescriptor desc;
	}
	
	private static final String HOLDER_PATTERN = "\\$\\{((?:\\s*[\\w_]\\s*)+)\\}";
	
	protected Log _log = LogFactoryUtil.getLog(BeanSQLQuery.class);
	
	@Override
	public int executeUpdate() throws ORMException {
		return _query.executeUpdate();
	}

	@Override()
	public Iterator iterate() throws ORMException {
		return _query.iterate();
	}

	@Override
	public Iterator iterate(boolean arg0) throws ORMException {
		return _query.iterate(arg0);
	}

	@Override
	public List list() throws ORMException {
		return _query.list();
	}

	@Override
	public List list(boolean arg0) throws ORMException {
		return _query.list(arg0);
	}

	@Override
	public List list(boolean arg0, boolean arg1) throws ORMException {
		return _query.list(arg0, arg1);
	}

	@Override
	public ScrollableResults scroll() throws ORMException {
		return _query.scroll();
	}

	@Override
	public Query setBoolean(int arg0, boolean arg1) {
		return _query.setBoolean(arg0, arg1);
	}

	@Override
	public Query setBoolean(String arg0, boolean arg1) {
		return _query.setBoolean(arg0, arg1);
	}

	@Override
	public Query setCacheMode(CacheMode arg0) {
		return _query.setCacheMode(arg0);
	}

	@Override
	public Query setCacheRegion(String arg0) {
		return _query.setCacheRegion(arg0);
	}

	@Override
	public Query setCacheable(boolean arg0) {
		return _query.setCacheable(arg0);
	}

	@Override
	public Query setDouble(int arg0, double arg1) {
		return _query.setDouble(arg0, arg1);
	}

	@Override
	public Query setDouble(String arg0, double arg1) {
		return _query.setDouble(arg0, arg1);
	}

	@Override
	public Query setFirstResult(int arg0) {
		return _query.setFirstResult(arg0);
	}

	@Override
	public Query setFloat(int arg0, float arg1) {
		return _query.setFloat(arg0, arg1);
	}

	@Override
	public Query setFloat(String arg0, float arg1) {
		return _query.setFloat(arg0, arg1);
	}

	@Override
	public Query setInteger(int arg0, int arg1) {
		return _query.setInteger(arg0, arg1);
	}

	@Override
	public Query setInteger(String arg0, int arg1) {
		return _query.setInteger(arg0, arg1);
	}

	@Override
	public Query setLockMode(String arg0, LockMode arg1) {
		return _query.setLockMode(arg0, arg1);
	}

	@Override
	public Query setLong(int arg0, long arg1) {
		return _query.setLong(arg0, arg1);
	}

	@Override
	public Query setLong(String arg0, long arg1) {
		return _query.setLong(arg0, arg1);
	}

	@Override
	public Query setMaxResults(int arg0) {
		return _query.setMaxResults(arg0);
	}

	@Override
	public Query setSerializable(int arg0, Serializable arg1) {
		return _query.setSerializable(arg0, arg1);
	}

	@Override
	public Query setSerializable(String arg0, Serializable arg1) {
		return _query.setSerializable(arg0, arg1);
	}

	@Override
	public Query setShort(int arg0, short arg1) {
		return _query.setShort(arg0, arg1);
	}

	@Override
	public Query setShort(String arg0, short arg1) {
		return _query.setShort(arg0, arg1);
	}

	@Override
	public Query setString(int arg0, String arg1) {
		return _query.setString(arg0, arg1);
	}

	@Override
	public Query setString(String arg0, String arg1) {
		return _query.setString(arg0, arg1);
	}

	@Override
	public Query setTimestamp(int arg0, Timestamp arg1) {
		return _query.setTimestamp(arg0, arg1);
	}

	@Override
	public Query setTimestamp(String arg0, Timestamp arg1) {
		return _query.setTimestamp(arg0, arg1);
	}

	@Override
	public Object uniqueResult() throws ORMException {
		return _query.uniqueResult();
	}
}
