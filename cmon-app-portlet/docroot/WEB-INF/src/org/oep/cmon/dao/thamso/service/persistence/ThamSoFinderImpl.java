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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.thamso.model.impl.ThamSoImpl;

import org.oep.cmon.dao.thamso.model.ThamSo;
import org.oep.cmon.dao.thamso.model.ThamSoClp;
import org.oep.cmon.dao.thamso.service.persistence.ThamSoFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* ThamSoFinderImpl class
*   
* This class is used to get ThamSo information 
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
public class ThamSoFinderImpl extends BasePersistenceImpl<ThamSo> implements ThamSoFinder{
	
	/**
	  * This is fucntion fetchList 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param List<String> keyList
	  * @return List<String>
	  */
	@SuppressWarnings("unchecked")
	public List<String> fetchList(List<String> keyList) {
		List<String> out = Collections.emptyList();
		StringBuilder sql = new StringBuilder();
		String keyHolder = "key";
		String select = " UNION ALL SELECT GIATRI FROM CMON_THAMSO WHERE TEN = :";
		int size = keyList.size();
		
		for (int i = 0; i < size; ++ i) {
			sql.append(select).append(keyHolder).append(i);
		}
		
		if (sql.length() > 0) {
			try {
				sql.delete(0, 11);
				Session session = openSession();
				SQLQuery query = session.createSQLQuery(sql.toString());
				for (int i = 0; i < size; ++ i) {
					query.setString(keyHolder + i, keyList.get(i));
				}
				query.addScalar("GIATRI", Type.STRING);
				out = (List<String>) QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				closeSession(session);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return out;
	}
	/**
	  * This is fucntion searchByTen 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten,int start,int end
	  * @return List<ThamSo>
	  */
	public List<ThamSo> searchByTen(String ten,int start,int end) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT t.ID,t.NAME,t.GIATRI FROM CMON_THAMSO t");
           
            sql.append(" WHERE tt.daXoa=0 ");
            
            if(ten !=null ){
            	sql.append(" AND LOWER(t.TEN) like LOWER(?) ");
            }
           
            sql.append(" ORDER BY LOWER(t.TEN) ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            QueryPos qPos = QueryPos.getInstance(q);
           
            if(ten !=null ){
            	qPos.add("%"+ten+"%");	   
            }
             
            Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<ThamSo> result = new ArrayList<ThamSo>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				ThamSo t = new ThamSoClp();
				t.setId(Long.valueOf(a[0].toString()));
				t.setTen((String)a[1]);
				t.setGiaTri((String)a[2]);			
			
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
	  * This is fucntion countByTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return long
	  */
	public long countByTen(String ten) throws SystemException{
		Session session = null;
        try {  
        	 session = openSession();
             
             StringBuffer sql = new StringBuffer("");
             sql.append(" SELECT COUNT(*) AS TOTAL FROM CMON_THAMSO t");
            
             sql.append(" WHERE tt.daXoa=0 ");
             
             if(ten !=null ){
             	sql.append(" AND LOWER(t.TEN) like LOWER(?) ");
             }
            
             sql.append(" ORDER BY LOWER(t.TEN) ASC");
             

             SQLQuery q = session.createSQLQuery(sql.toString());
             q.addScalar("TOTAL", Type.LONG);
             QueryPos qPos = QueryPos.getInstance(q);
            
             if(ten !=null ){
             	qPos.add("%"+ten+"%");	   
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
	  * This is fucntion searchByTenUDHT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, Long ungDungId, Long heThongId, int start,int end
	  * @return List<ThamSo>
	  */
	public List<ThamSo> searchByTenUDHT(String ten, Long ungDungId, Long heThongId, int start,int end) throws SystemException{
		Session session = null;
		List<ThamSo> list = new ArrayList<ThamSo>();
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT ts.* FROM CMON_THAMSO ts");
           
            sql.append(" WHERE ts.daXoa=0 ");
            
            if(Validator.isNotNull(ten)){
            	sql.append(" AND LOWER(ts.TEN) like LOWER(?) ");
            }
            if(Validator.isNotNull(ungDungId)){
            	sql.append(" AND ts.ungDungId = ? ");
            }
            if(Validator.isNotNull(heThongId)){
            	sql.append(" AND ts.heThongId = ? ");
            }
           
            sql.append(" ORDER BY LOWER(ts.TEN) ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.setCacheable(false);
			q.addEntity("ThamSo", ThamSoImpl.class);
            QueryPos qPos = QueryPos.getInstance(q);
           
            if(Validator.isNotNull(ten)){
            	qPos.add("%"+ten+"%");	   
            }
            if(Validator.isNotNull(ungDungId)) {
            	qPos.add(ungDungId);	   
            }
            if(Validator.isNotNull(heThongId)){
            	qPos.add(heThongId);	   
            }
            
        	list = (List<ThamSo>) QueryUtil.list(q, getDialect(), start,
					end, false);
			return list;
			
             
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	
	
	/**
	  * This is fucntion countByTenUDHT
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten, Long ungDungId, Long heThongId
	  * @return long
	  */
	public long countByTenUDHT(String ten, Long ungDungId, Long heThongId) throws SystemException{
		Session session = null;
        try {  
        	 session = openSession();
             
             StringBuffer sql = new StringBuffer("");
             sql.append(" SELECT COUNT(*) AS TOTAL FROM CMON_THAMSO ts");
            
             sql.append(" WHERE ts.daXoa=0 ");
             
             if(Validator.isNotNull(ten)){
             	sql.append(" AND LOWER(ts.TEN) like LOWER(?) ");
             }
             if(Validator.isNotNull(ungDungId)){
             	sql.append(" AND ts.ungDungId = ? ");
             }
             if(Validator.isNotNull(heThongId)){
             	sql.append(" AND ts.heThongId = ? ");
             }
            
             sql.append(" ORDER BY LOWER(ts.TEN) ASC");
             

             SQLQuery q = session.createSQLQuery(sql.toString());
             q.addScalar("TOTAL", Type.LONG);
             QueryPos qPos = QueryPos.getInstance(q);
            
             if(Validator.isNotNull(ten)){
             	qPos.add("%"+ten+"%");	   
             }
             if(Validator.isNotNull(ungDungId)) {
             	qPos.add(ungDungId);	   
             }
             if(Validator.isNotNull(heThongId)){
             	qPos.add(heThongId);	   
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
	
	
}
