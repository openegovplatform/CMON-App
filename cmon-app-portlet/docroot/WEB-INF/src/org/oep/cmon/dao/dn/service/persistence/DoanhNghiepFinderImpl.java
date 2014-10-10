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

package org.oep.cmon.dao.dn.service.persistence;

import java.util.List;

import org.oep.cmon.dao.dn.model.impl.DoanhNghiepImpl;

import org.oep.cmon.dao.dn.model.DoanhNghiep;
import org.oep.cmon.dao.dn.service.persistence.DoanhNghiepFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* DoanhNghiepFinderImpl class
*   
* This class is used to get DoanhNghiep information 
* from database use Custom Sql
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
public class DoanhNghiepFinderImpl   extends BasePersistenceImpl<DoanhNghiep> implements DoanhNghiepFinder {

	/**
	  * This is fucntion find DoanhNghiep by nguoiDaiDienId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long nguoiDaiDienId
	  * @return List<DoanhNghiep>
	  */	
public java.util.List<DoanhNghiep> getDoanhNghiep2NguoiDaiDienId(long nguoiDaiDienId){
		
		java.util.List<DoanhNghiep> result = null;
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String base = " SELECT * FROM BRMS_DOANHNGHIEP  ";
			StringBuffer sqlBuilder = new StringBuffer(base);

			sqlBuilder.append(" WHERE NGUOIDAIDIENID = ");
			sqlBuilder.append(nguoiDaiDienId);

			String sql = sqlBuilder.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DoanhNghiep", DoanhNghiepImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			// execute the query and return a list from the db
			result = (List<DoanhNghiep>) QueryUtil
					.list(q, getDialect(), 0, 100);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		return result;
		
	}

}

