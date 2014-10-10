/*
 * Copyright (c) 2014 by Open eGovPlatform (http://http://openegovplatform.org/).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oep.cmon.dao.thamso.service.persistence;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.thamso.model.impl.AnhXaImpl;

import org.oep.cmon.dao.thamso.model.AnhXa;

import org.oep.cmon.dao.thamso.service.persistence.AnhXaFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* AnhXaFinderImpl class
*   
* This class is used to get AnhXa information 
* from database
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
public class AnhXaFinderImpl extends BasePersistenceImpl<AnhXa> implements AnhXaFinder{
	
	/**
	  * This is fucntion getCodeById
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String table,Long id
	  * @return String
	  */
	public String getCodeById(String table, Long id) {
		Session session = null;
		try {
			session = openSession();

			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT ma  FROM " + table);

			sql.append(" WHERE id= ?");

			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("ma", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);

			if (id != null && id.intValue() > 0) {
				qPos.add(id);
			}

			Iterator<String> itr = q.iterate();

			if (itr.hasNext()) {
				String value = itr.next();

				if (value != null) {
					return value;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}
		return null;
	}
	/**
	  * This is fucntion getDSByTenOrMa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String table,String code,String ten
	  * @return List<AnhXa>
	  */
	public List<AnhXa>  getDSByTenOrMa(String table,String code,String ten){
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT id,ma,ten FROM "+table);
           
            sql.append(" WHERE daXoa=0 ");
            
            if(code !=null && code.trim().length()>0 ){
            	sql.append(" AND LOWER(ma)=LOWER(?) ");
            }
            if(ten != null && ten.trim().length()>0){
            	sql.append(" AND LOWER(ten)= LOWER(?) ");
            }
            
           
            sql.append(" ORDER BY LOWER(id) DESC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("id", Type.LONG);
            q.addScalar("ma", Type.STRING);
            q.addScalar("ten", Type.STRING);
           
            
            QueryPos qPos = QueryPos.getInstance(q);
           
            if(code !=null && code.trim().length()>0 ){
            	qPos.add(code);	   
            }
            if(ten != null && ten.trim().length()>0){
            	qPos.add(ten);  
            }
             
           
             
            Iterator<Object[]> itr = (Iterator<Object[]>)  QueryUtil.iterate(q,getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            List<AnhXa> result = new ArrayList<AnhXa>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				AnhXa t = new AnhXaImpl();
				t.setId((Long)a[0]);
				t.setMaDNG((String)a[1]);
				t.setTenDNG((String)a[2]);				
				result.add(t);
			}
			return result;
			
             
            
        } catch (Exception e) {  
             
        } finally {  
            
            closeSession(session);  
        } 
        return null;
    
	}
	/**
	  * This is fucntion search
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword,Long appId,String table,int start,int end
	  * @return List<AnhXa>
	  */
	public List<AnhXa> search(String keyword,Long appId,String table,int start,int end) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT a.id,a.madng,a.tendng,a.makhac,a.tenkhac,a.tenbang,a.danhmucungdungid FROM CMON_DANHMUCANHXA a");
           
            sql.append(" WHERE a.daXoa=0 ");
            
            if(keyword !=null && keyword.trim().length()>0 ){
            	sql.append(" AND (a.tenkhac like ? OR a.tendng like ?) ");
            }
            if(table != null && table.trim().length()>0){
            	sql.append(" AND a.tenbang = ? ");
            }
            if(appId != null && appId.intValue()>0){
            	sql.append(" AND a.danhmucungdungid = ? ");
            }
           
            sql.append(" ORDER BY LOWER(a.tendng) ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("id", Type.LONG);
            q.addScalar("madng", Type.STRING);
            q.addScalar("tendng", Type.STRING);
            q.addScalar("makhac", Type.STRING);
            q.addScalar("tenkhac", Type.STRING);
            q.addScalar("tenbang", Type.STRING);
            q.addScalar("danhmucungdungid", Type.LONG);
            
            QueryPos qPos = QueryPos.getInstance(q);
           
            if(keyword !=null && keyword.trim().length()>0 ){
            	qPos.add("%"+keyword+"%");	   
            }
            if(table != null && table.trim().length()>0){
            	qPos.add(table);  
            }
             
            if(appId != null && appId.intValue()>0){
            	qPos.add(appId);	   
            }
             
             
            Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<AnhXa> result = new ArrayList<AnhXa>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				AnhXa t = new AnhXaImpl();
				t.setId((Long)a[0]);
				t.setMaDNG((String)a[1]);
				t.setTenDNG((String)a[2]);
				t.setMaKhac((String)a[3]);
				t.setTenKhac((String)a[4]);
				t.setTenBang((String)a[5]);
				if(a[6] != null){
					t.setUngDungId((Long)a[6]);
				}
				result.add(t);
			}
			return result;
			
             
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        } 
    
	}
	
	/**
	  * This is fucntion countSearch 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyword,Long appId,String table
	  * @return long
	  */
	public long countSearch(String keyword,Long appId,String table) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT COUNT(*) AS TOTAL FROM CMON_DANHMUCANHXA a");
           
            sql.append(" WHERE a.daXoa=0 ");
            
            if(keyword !=null && keyword.trim().length()>0 ){
            	sql.append(" AND (a.tenkhac like ? OR a.tendng like ?) ");
            }
            if(table != null && table.trim().length()>0){
            	sql.append(" AND a.tenbang = ? ");
            }
            if(appId != null && appId.intValue()>0){
            	sql.append(" AND a.danhmucungdungid = ? ");
            }
           
          
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TOTAL", Type.LONG);
            
            
            QueryPos qPos = QueryPos.getInstance(q);
           
            if(keyword !=null && keyword.trim().length()>0 ){
            	qPos.add("%"+keyword+"%");	   
            }
            if(table != null && table.trim().length()>0){
            	qPos.add(table);  
            }
             
            if(appId != null && appId.intValue()>0){
            	qPos.add(appId);	   
            }
             
            Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long value = itr.next();

				if (value != null) {
					return value;
				}
			}
			
             
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        } 
        return 0;
    
	}
	
	
	/**
	  * This is fucntion getListTable
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<String>
	  */
	public List<String> getListTable() throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT TENBANG FROM CMON_DANHMUCANHXA ");           
            sql.append(" GROUP BY TENBANG");                       
            sql.append(" ORDER BY LOWER(TENBANG) ASC");
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TENBANG", Type.STRING);
         
            Iterator<String> itr = q.iterate();
            
            List<String> result = new ArrayList<String>();
			while (itr.hasNext()) {
				String v= itr.next();
				result.add(v);
			}
			return result;
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	/**
	  * This is fucntion getMaKhacExCh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getMaKhacExCh(String maDNG, String tenBang) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from cmon_danhmucanhxa where madng = ? and tenbang = ? and daXoa=0 and danhmucungdungid is null";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AnhXa", AnhXaImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(maDNG);
			qPos.add(tenBang);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<AnhXa>();
	}
	/**
	  * This is fucntion getDNGFromMaKhacCQQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maKhac, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacCQQL(String maKhac, String tenBang) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from cmon_danhmucanhxa where maKhac = ? and tenbang = ? and daXoa=0 and danhmucungdungid is null";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AnhXa", AnhXaImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(maKhac);
			qPos.add(tenBang);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<AnhXa>();
	}
	/**
	  * This is fucntion getDNGFromMaKhacTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maKhac, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacTTHC(String maKhac, String tenBang) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from cmon_danhmucanhxa where maKhac = ? and tenbang = ? and daXoa=0";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AnhXa", AnhXaImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(maKhac);
			qPos.add(tenBang);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<AnhXa>();
	}
	/**
	  * This is fucntion getMaKhacExCh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDNG, String tenBang, long maUngDungId
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getMaKhacExCh(String maDNG, String tenBang, long maUngDungId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from cmon_danhmucanhxa where madng = ? and tenbang = ? and danhmucungdungid = ? and daXoa=0";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AnhXa", AnhXaImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(maDNG);
			qPos.add(tenBang);
			qPos.add(maUngDungId);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<AnhXa>();
	}
	/**
	  * This is fucntion getDNGFromMaKhacGPLX
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maKhac, String tenBang
	  * @return List<AnhXa>
	  */
	public List<AnhXa> getDNGFromMaKhacGPLX(String maKhac, String tenBang) {
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from cmon_danhmucanhxa where maKhac = ? and tenbang = ? and daXoa=0 and danhmucungdungid is not null";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("AnhXa", AnhXaImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(maKhac);
			qPos.add(tenBang);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<AnhXa>();
	}
}
