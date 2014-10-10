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

package org.oep.cmon.dao.nsd.service.persistence;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.nsd.model.impl.TaiNguyenImpl;

import org.oep.cmon.dao.nsd.model.TaiNguyen;
import org.oep.cmon.dao.nsd.service.persistence.TaiNguyenFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author duong.pham
 *
 */

/**
*
* TaiNguyenFinderImpl class
*   
* This class is used to get TaiNguyen information 
* from database use Custom SQl
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
public class TaiNguyenFinderImpl extends BasePersistenceImpl<TaiNguyen> implements TaiNguyenFinder{

	/**
	  * This is fucntion searchByVaiTroId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long vaiTroId, int daXoa, int start, int end
	  * @return List<TaiNguyen>
	  */
	public List<TaiNguyen> searchByVaiTroId(Long vaiTroId, int daXoa, int start, int end) throws SystemException{
		
		Session session = null;
		List<TaiNguyen> list = new ArrayList<TaiNguyen>();
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" Select distinct tn.id, tn.ten, tn.ungdungid, tn.hethongid, tn.loai from cmon_tainguyen tn ");
            sql.append(" LEFT JOIN cmon_tainguyen2vaitro tn2vt ON tn2vt.tainguyenid=tn.ID ");
            sql.append(" LEFT JOIN cmon_vaitro vt ON vt.ID=tn2vt.vaitroid ");
            sql.append(" WHERE 1=1 ");
            
           
            if(vaiTroId !=null ){
            	sql.append(" AND tn2vt.vaitroid=? ");
            }
            if(Validator.isNotNull(daXoa)){
            	sql.append(" AND tn.daxoa=? ");
            }
            sql.append(" ORDER BY tn.ten ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("UNGDUNGID", Type.LONG);
            q.addScalar("HETHONGID", Type.LONG);
            q.addScalar("LOAI", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);
			
			
			if (Validator.isNotNull(vaiTroId)) {				
				qPos.add(vaiTroId);
			}
			if (Validator.isNotNull(daXoa)) {
				qPos.add(daXoa);
			}		
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
			while (itr.hasNext()) {
				Object[] a= itr.next();
				TaiNguyen t=new TaiNguyenImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setTen((String)a[1]);
				t.setUngDungId(Long.valueOf(a[2].toString()));		
				t.setHeThongId(Long.valueOf(a[3].toString()));		
				t.setLoai(Integer.valueOf(a[4].toString()));
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
	  * This is fucntion countByVaiTroId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long vaiTroId, int daXoa
	  * @return long
	  */
	public long countByVaiTroId(Long vaiTroId, int daXoa) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
                       
            StringBuffer sql = new StringBuffer("");           
            sql.append(" Select COUNT(distinct tn.id) AS TOTAL from cmon_tainguyen tn ");
            sql.append(" LEFT JOIN cmon_tainguyen2vaitro tn2vt ON tn2vt.tainguyenid=tn.ID ");
            sql.append(" LEFT JOIN cmon_vaitro vt ON vt.ID=tn2vt.vaitroid ");
            sql.append(" WHERE 1=1 ");
            
           
            if(vaiTroId !=null ){
            	sql.append(" AND tn2vt.vaitroid=? ");
            }
            if(Validator.isNotNull(daXoa)){
            	sql.append(" AND tn.daxoa=? ");
            }
           
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TOTAL", Type.LONG);
            QueryPos qPos = QueryPos.getInstance(q);
            
            if (Validator.isNotNull(vaiTroId)) {				
				qPos.add(vaiTroId);
			}
			if (Validator.isNotNull(daXoa)) {
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
}
