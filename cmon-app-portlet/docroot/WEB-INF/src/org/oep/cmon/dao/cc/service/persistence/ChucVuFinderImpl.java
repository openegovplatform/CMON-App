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

package org.oep.cmon.dao.cc.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.cc.model.impl.ChucVuImpl;

import org.oep.cmon.dao.cc.model.ChucVu;
import org.oep.cmon.dao.cc.service.persistence.ChucVuFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* ChucVuFinderImpl class
*   
* This class is used to get ChucVu information 
* from database use Custom SQL
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
public class ChucVuFinderImpl extends BasePersistenceImpl<ChucVu> implements
		ChucVuFinder {
	
	/**
	  * This is fucntion find ChucVu by coQuanQuanLyId and TrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId;  long : Value of trangThai
	  * @return List<ChucVu>
	  */
	@SuppressWarnings("unchecked")
	public List<ChucVu> findByCoQuanQuanLy(long coQuanQuanLyId, long daXoa) {
		Session session = null;
		List<ChucVu> listChucVu = new ArrayList<ChucVu>();
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT a.* FROM cmon_chucvu a INNER JOIN (SELECT distinct chucvuid FROM cmon_chucvu2vaitro WHERE coquanquanlyid = :coquanquanlyid) b ON a.id = b.chucvuid");
			sql.append(" AND a.daxoa=:daxoa");
			sql.append(" ORDER BY a.ten ASC");
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);
			q.setLong("coquanquanlyid", coQuanQuanLyId);
			q.setLong("daxoa", daXoa);
			q.addEntity("ChucVu", ChucVuImpl.class);
			listChucVu = (List<ChucVu>) q.list();
			if (listChucVu == null) {
				listChucVu = new ArrayList<ChucVu>();
			}
		} catch (Exception e) {
			
		} finally {
			closeSession(session);
		}
		return listChucVu;
	}
}
