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

package org.oep.cmon.dao.cd.service.persistence;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.cd.model.impl.ChuyenMonImpl;

import org.oep.cmon.dao.cd.model.ChuyenMon;
import org.oep.cmon.dao.cd.service.persistence.ChuyenMonFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
*
* ChuyenMonFinderImpl class
*   
* This class is used to get ChuyenMon information 
* from database use Custom sql
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
@SuppressWarnings("unchecked")
public class ChuyenMonFinderImpl extends BasePersistenceImpl<ChuyenMon>
		implements ChuyenMonFinder {
	
	/**
	  * This is fucntion fetch ChuyenMon by congDan2CCGPId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDan2CCGPId
	  * @return List<ChuyenMon>
	  */
	public List<ChuyenMon> fetchListByCongDan2CCGPId(long congDan2CCGPId) {
		String sql = CustomSQLUtil.get("org.oep.csms.condan2ccgp.listChuyenMon");
		Session session = openSession();
		SQLQuery query = session.createSQLQuery(sql);
		List<ChuyenMon> out;
		query.addEntity(ChuyenMon.class.getSimpleName(), ChuyenMonImpl.class);
		query.setLong("congDan2CCGPId", congDan2CCGPId);
		out = (List<ChuyenMon>) 
			QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		closeSession(session);
		return out;
	}
	
	/**
	  * This is fucntion get ChuyenMon by MaDanhMucUngDung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDanhMucUngDung
	  * @return List<ChuyenMon>
	  */
	public List<ChuyenMon> getDanhSachChuyenMonByMaDanhMucUngDung(
			String maDanhMucUngDung) {

		List<ChuyenMon> result = null;

		Session session = null;

		try {

			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String base = "SELECT * FROM CMON_CHUYENMON ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			sqlBuilder.append("INNER JOIN CMON_DANHMUCUNGDUNG ");
			sqlBuilder
					.append("ON CMON_CHUYENMON.DANHMUCUNGDUNGID = CMON_DANHMUCUNGDUNG.ID ");
			sqlBuilder.append("WHERE CMON_DANHMUCUNGDUNG.MA = '"
					+ maDanhMucUngDung);
			sqlBuilder.append("'");

			String sql = sqlBuilder.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ChuyenMon", ChuyenMonImpl.class);

			QueryPos.getInstance(q);
			// execute the query and return a list from the db
			int start = 0;
			int end = 100;
			result = (List<ChuyenMon>) QueryUtil.list(q, getDialect(), start, end);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}

		return result;
	}
	
	/**
	  * This is fucntion get ChuyenMon by ChaId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String idUngDung ; String chaId
	  * @return List<ChuyenMon>
	  */
	public List<ChuyenMon> getChuyenMonChaId(String idUngDung, String chaId) {
		Session session = null;

		try {
			session = openSession();

			String sql = " select * from cmon_chuyenmon cm ";

		 
			List<String> criteria = new ArrayList<String>();

			if (Validator.isNotNull(idUngDung)) {
				criteria.add(" cm.danhmucungdungid =?");
			}
			if (Validator.isNotNull(chaId)) {
				criteria.add(" cm.chaid =?");
			}

			sql += " WHERE ";

			if (!criteria.isEmpty()) {
				for (String criterion : criteria) {
					sql = sql + criterion + " and ";
				}
			}

			sql += " cm.daxoa =0  ";

			StringBuffer sqlBuilder = new StringBuffer(sql);
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.addEntity("CMON_CHUYENMON", ChuyenMonImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(idUngDung)) {
				qPos.add(idUngDung);
			}
			if (Validator.isNotNull(chaId)) {
				qPos.add(chaId);
			}
			List<ChuyenMon> list= (List<ChuyenMon>) QueryUtil.list(q, getDialect(), 0, QueryUtil.ALL_POS,false);
			 
			if(list != null && list.size()>0){
				return list;
			}
			else{
				return null;}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}

		return null;
	}
	
	/**
	  * This is fucntion get ChuyenMon by idUngDung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String idUngDung
	  * @return List<ChuyenMon>
	  */
	public List<ChuyenMon> getChuyenMonByChaIdNull(String idUngDung) {
		Session session = null;

		try {
			session = openSession();
			String sql = " select * from cmon_chuyenmon cm where";
		
			new ArrayList<String>();
	 
			if (Validator.isNotNull(idUngDung)) {
				sql = sql + " cm.danhmucungdungid = ? and ";
			}
			sql += " cm.chaid is null and cm.daxoa = 0  ";

			StringBuffer sqlBuilder = new StringBuffer(sql);
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.addEntity("CMON_CHUYENMON", ChuyenMonImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(idUngDung)) {
				qPos.add(idUngDung);
			}

			List<ChuyenMon> list= (List<ChuyenMon>) QueryUtil.list(q, getDialect(), 0, QueryUtil.ALL_POS,false);
			 
			if(list != null && list.size()>0){
				return list;
			}
			else{
				return null;}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}

		return null;
	}
	
	
}
