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

package org.oep.cmon.dao.tlct.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl;

//import com.liferay.util.StringUtil;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Type;

import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.oep.cmon.dao.tlct.service.persistence.DanhMucGiayToFinder;

/**
 * @author duong.pham
 * 
 */
/**
*
* DanhMucGiayToFinderImpl class
*   
* This class is used to get DanhMucGiayTo information 
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
public class DanhMucGiayToFinderImpl extends BasePersistenceImpl<DanhMucGiayTo>
		implements DanhMucGiayToFinder {

	/**
	  * This is fucntion searchDanhMucGiayTo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,Long doiTuongId, int start, int end
	  * @return List<DanhMucGiayTo>
	  */
	@Override
	public List<DanhMucGiayTo> searchDanhMucGiayTo(String group,
			Long doiTuongId, int start, int end) {
		// TODO Auto-generated method stub
		Session session = null;
		List<DanhMucGiayTo> list = new ArrayList<DanhMucGiayTo>();
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append( "SELECT distinct dmgt.ID AS ID, dmgt.TEN AS TEN, dmgt.MA AS MA from CMON_DANHMUCGIAYTO dmgt "
					+ " LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID "
					+ " LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID "
					+ " WHERE dmgt.daxoa=0 ");
			
			
			if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(doiTuongId)) {
				sql.append(" AND dt.id = ?");
			}
			
			sql.append(" ORDER BY LOWER(dmgt.TEN) ASC ");
		
			SQLQuery q = session.createSQLQuery(sql.toString());
			//q.setCacheable(false);
			//q.addEntity("DanhMucGiayTo", DanhMucGiayToImpl.class);
			q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("MA", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
				//qPos.add(group);
			}
		
			if (Validator.isNotNull(doiTuongId)) {
				qPos.add(doiTuongId);
			}
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
			while (itr.hasNext()) {
				Object[] a= itr.next();
				DanhMucGiayTo t=new DanhMucGiayToImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setTen((String)a[1]);
				t.setMa(a[2].toString());		
				list.add(t);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}		return list;
	}

	/**
	  * This is fucntion countDanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group, Long doiTuongId
	  * @return long
	  */
	@Override
	public long countDanhMucGiayTo(String group, Long doiTuongId) {
		// TODO Auto-generated method stub

		Session session = null;
		
	try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append("SELECT COUNT(distinct dmgt.id) AS TOTAL from CMON_DANHMUCGIAYTO dmgt "
					+ " LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID "
					+ " LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID "
					+ " WHERE dmgt.daxoa=0 ");
			

			if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(doiTuongId)) {
				sql.append(" AND dt.id = ?");
			}
			
			SQLQuery q = session.createSQLQuery(sql.toString());			
			q.addScalar("TOTAL", Type.LONG);
			

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
			}
			
			if (Validator.isNotNull(doiTuongId)) {
				qPos.add(doiTuongId);
			}
			
			int rows = 0;
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					rows= count.intValue();
				}
			}

			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}

		return 0;
	}
	
	/**
	  * This is fucntion searchByTTHCIdOrGDId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> searchByTTHCIdOrGDId(String group,
			String doituong, Long tthcid, Long dgId, Integer daXoa, int start,int end) throws SystemException{
		
		Session session = null;
		List<DanhMucGiayTo> list = new ArrayList<DanhMucGiayTo>();
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" Select distinct dmgt.ID AS ID, dmgt.TEN AS TEN, dmgt.MA AS MA from cmon_danhmucgiayto dmgt ");
            sql.append(" LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID ");
            sql.append(" LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID ");
            sql.append(" WHERE 1=1 ");
            
            if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(doituong)) {
				sql.append(" AND dt.MA like ?");
			}
			
            if(tthcid != null){
            	sql.append(" AND dmgt.id not in (Select tt2gt.danhmucgiaytoid from  cmon_thutuc2giayto tt2gt ");
            	sql.append(" where tt2gt.thutuchanhchinhid=? ");
            }
            if(dgId !=null ){
            	sql.append(" AND tt2gt.giaidoan=? ");
            }
            if(daXoa !=null ){
            	sql.append(" AND tt2gt.daxoa=?) ");
            	sql.append(" AND dmgt.daxoa=? ");
            }
           
            sql.append(" ORDER BY dmgt.ten ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("MA", Type.STRING);
			

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
			}
		
			if (Validator.isNotNull(doituong)) {
				qPos.add(doituong);
			}
			
			if (Validator.isNotNull(tthcid)) {				
				qPos.add(tthcid);
			}
		
			if (Validator.isNotNull(dgId)) {
				qPos.add(dgId);
			}
			if (Validator.isNotNull(daXoa)) {
				qPos.add(daXoa);
				qPos.add(daXoa);
			}		
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
			while (itr.hasNext()) {
				Object[] a= itr.next();
				DanhMucGiayTo t=new DanhMucGiayToImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setTen((String)a[1]);
				t.setMa(a[2].toString());		
				list.add(t);
			}
			return list;
			
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	
	
	/**
	  * This is fucntion countByTTHCIdOrGDId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,String doituong, Long tthcid, Long dgId, Integer daXoa
	  * @return long
	  */
	public long countByTTHCIdOrGDId(String group,
			String doituong, Long tthcid, Long dgId, Integer daXoa) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
                       
            StringBuffer sql = new StringBuffer("");
            sql.append(" Select COUNT(distinct dmgt.id) AS TOTAL from cmon_danhmucgiayto dmgt ");
            sql.append(" LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID ");
            sql.append(" LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID ");
            sql.append(" WHERE 1=1 ");
                        
            if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(doituong)) {
				sql.append(" AND dt.MA like ?");
			}
            if(tthcid != null){
            	sql.append(" AND dmgt.id not in (Select tt2gt.danhmucgiaytoid from  cmon_thutuc2giayto tt2gt ");
            	sql.append(" where tt2gt.thutuchanhchinhid=? ");
            }
            if(dgId !=null ){
            	sql.append(" AND tt2gt.giaidoan=? ");
            }
            if(daXoa !=null ){
            	sql.append(" AND tt2gt.daxoa=?) ");
            	sql.append(" AND dmgt.daxoa=? ");
            }
           
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TOTAL", Type.LONG);
            QueryPos qPos = QueryPos.getInstance(q);
            
            if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
			}
		
			if (Validator.isNotNull(doituong)) {
				qPos.add(doituong);
			}
			
            if(tthcid != null){
            	qPos.add(tthcid);	   
            }
            if(dgId !=null ){
            	qPos.add(dgId);	   
            }            
            if(daXoa !=null ){
            	qPos.add(daXoa);	
            	qPos.add(daXoa);
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
	  * This is fucntion listByCongDan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long doiTuongId
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> listByCongDan(Long doiTuongId) throws SystemException{
		
		Session session = null;
		List<DanhMucGiayTo> list = new ArrayList<DanhMucGiayTo>();
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT distinct dmgt.ID AS ID, dmgt.TEN AS TEN, dmgt.MA AS MA FROM cmon_danhmucgiayto dmgt ");
            sql.append(" LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID ");
            sql.append(" LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID ");
            sql.append(" WHERE dmgt.daxoa=0 and dtgt.daxoa=0 and dtgt.trangthai=1 and dt.daxoa=0");
           
			if (Validator.isNotNull(doiTuongId)) {
				sql.append(" AND dt.id = ?");
			}
			           
            sql.append(" ORDER BY dmgt.ten ASC");
            
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("MA", Type.STRING);

			QueryPos qPos = QueryPos.getInstance(q);
		
			if (Validator.isNotNull(doiTuongId)) {
				qPos.add(doiTuongId);
			}
						
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q, getDialect(),  QueryUtil.ALL_POS,
					 QueryUtil.ALL_POS, false);
			while (itr.hasNext()) {
				Object[] a= itr.next();
				DanhMucGiayTo t=new DanhMucGiayToImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setTen((String)a[1]);
				t.setMa(a[2].toString());		
				list.add(t);
			}
			return list;
			
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	/**
	  * This is fucntion listGiayToKetQua
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thutuchanhchinhId
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> listGiayToKetQua(long thutuchanhchinhId) throws SystemException
	{
		  Session session = null;
	        try {  
	            session = openSession();
	            String sql = "select * from CMON_DANHMUCGIAYTO gt where GT.ID in (select TTGT.DANHMUCGIAYTOID from CMON_THUTUC2GIAYTO ttgt where TTGT.GIAIDOAN =3 and TTGT.THUTUCHANHCHINHID=? and ttgt.daxoa=0)" ;  
	           
	            
	           
	            
	            SQLQuery q = session.createSQLQuery(sql);
	            q.addEntity("DanhMucGiayTo", DanhMucGiayToImpl.class);
	            QueryPos qPos = QueryPos.getInstance(q);  
	            qPos.add(thutuchanhchinhId);
	            return  (List<DanhMucGiayTo>)QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	            
	        } catch (Exception e) { 
	       
	            throw new SystemException(e);  
	        } finally {  
	            //must have this to close the hibernate session..  
	            // if you fail to do this.. you will have a lot of open sessions�   
	            closeSession(session);  
	        }  
	}
	
	/**
	  * This is fucntion listGiayToBCNopDon 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchccId
	  * @return List<DanhMucGiayTo>
	  */
	public List<DanhMucGiayTo> listGiayToBCNopDon(long hosothutuchccId) throws SystemException
	{
		Session session = null;
        try {  
            session = openSession();
            String sql = "select * from CMON_DANHMUCGIAYTO gt where GT.ID in(select GT.DANHMUCGIAYTOID from CMON_GIAYTODINHKEMHOSO gt  WHERE gt.HOSOTTHCCONGID=? and GT.TTHSTAITHOIDIEMDINHKEM =1 and GT.DAXOA =0 and GT.BANCHINH =1)";  
           
            
       
            
            SQLQuery q = session.createSQLQuery(sql);
            q.addEntity("DanhMucGiayTo", DanhMucGiayToImpl.class);
            QueryPos qPos = QueryPos.getInstance(q);  
            qPos.add(hosothutuchccId);
            
            return  (List<DanhMucGiayTo>)QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            
        } catch (Exception e) { 
     
            throw new SystemException(e);  
        } finally {  
            //must have this to close the hibernate session..  
            // if you fail to do this.. you will have a lot of open sessions�   
            closeSession(session);  
        }  
	  
	}
}
