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

package org.oep.cmon.dao.touchscreen.service.persistence;

import org.oep.cmon.dao.touchscreen.model.TouchScreen;
import org.oep.cmon.dao.touchscreen.service.persistence.TouchScreenFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* TouchScreenFinderImpl class
*   
* This class is used to get TouchScreen information 
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
public class TouchScreenFinderImpl extends BasePersistenceImpl<TouchScreen> implements TouchScreenFinder {
	
	/**
	  * This is fucntion countHoSoTrucTiep 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int loaihoso,String nam
	  * @return long
	  */
	public long countHoSoTrucTiep(int loaihoso,String nam) throws SystemException{
		Session session = null;
		Long count = 0l;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" select count(id) from cmon_hosotthccong");
            sql.append(" where loaihoso = "+loaihoso+" and EXTRACT(year FROM ngaynhanhoso)='"+nam+"' and daxoa = 0");
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.setCacheable(false);
			count = Long.valueOf(q.uniqueResult().toString());
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
        return count;
	}
	
	/**
	  * This is fucntion countHoSoByTrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrTrangThai,String nam,String type
	  * @return long
	  */
	public long countHoSoByTrangThai(String arrTrangThai,String nam,String type) throws SystemException{
		Session session = null;
		Long count = 0l;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" select count(id) from cmon_hosotthccong ");
            sql.append(" where trangthaihoso IN ("+arrTrangThai+") and EXTRACT(year FROM ngaynhanhoso)='"+nam+"' and daxoa = 0");
            if(type.equals("som")){
            	sql.append(" and ngaytraketqua < ngayhentraketqua ");
            }else if(type.equals("dung")){
            	sql.append(" and ngaytraketqua = ngayhentraketqua ");
            }else if(type.equals("tre")){
            	sql.append(" and ngaytraketqua > ngayhentraketqua ");
            }
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.setCacheable(false);
			count = Long.valueOf(q.uniqueResult().toString());
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
        return count;
	}
	
}
