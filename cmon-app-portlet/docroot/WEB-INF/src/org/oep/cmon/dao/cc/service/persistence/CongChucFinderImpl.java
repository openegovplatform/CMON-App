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

import org.oep.cmon.dao.cc.model.impl.CongChucImpl;
import org.oep.cmon.util.Helpers;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.cc.service.persistence.CongChucFinder;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* CongChucLocalServiceImpl class
*   
* This class is used to get CongChuc information 
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
public class CongChucFinderImpl extends BasePersistenceImpl<CongChuc> implements
		CongChucFinder {
	
	
	
	/**
	  * This is fucntion find CongChuc by coQuanQuanLyId and start, end value for paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId; int start ; int end;
	  * @return List<CongChuc>
	  */
	@SuppressWarnings("unchecked")
	public List<CongChuc> listCanBoTiepNhan(long coQuanQuanLyId, int start,
			int end) {
		Session session = null;
		try {
			session = openSession();

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String sql = "SELECT * FROM CMON_CONGCHUC T1 , CMON_CHUCVU T2 WHERE T1.CHUCVUID = T2.ID AND T1.COQUANQUANLYID = "
					+ coQuanQuanLyId
					+ " AND "
					+ "T2.MA =(SELECT GIATRI FROM CMON_THAMSO WHERE TEN ='CHUCVU_MOTCUA') AND T1.DAXOA=0 AND T2.DAXOA=0";

			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("CongChuc", CongChucImpl.class);

			// execute the query and return a list from the db
			return (List<CongChuc>) QueryUtil.list(q, getDialect(),
					QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
		} finally {
			closeSession(session);
		}
		return new ArrayList<CongChuc>();
	}

	/**
	  * This is fucntion find CongChuc by coQuanQuanLyId and keyword and start, end value for paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId; string keyword; int start ; int end;
	  * @return List<CongChuc>
	  */
	@SuppressWarnings("unchecked")
	public List<CongChuc> listCongChuc(long coQuanQuanLyId,
			String maOrTenOrEmail, int start, int end) throws SystemException {
		List<CongChuc> listCongChuc = new ArrayList<CongChuc>();
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT a.* FROM cmon_congchuc a INNER JOIN cmon_taikhoannguoidung b ON a.taikhoannguoidungid = b.id WHERE 1=1");
			if (!Helpers.isEmpty(maOrTenOrEmail)) {
				sql.append(" AND (upper(a.ma) LIKE (:maOrTenOrEmail) OR upper(a.hovaten) LIKE (:maOrTenOrEmail) OR upper(b.email) LIKE(:maOrTenOrEmail))");
			}
			if (coQuanQuanLyId > 0) {
				sql.append(" AND a.coquanquanlyid = :coquanquanlyid");
			}
			sql.append(" ORDER BY a.hovaten ASC");
			
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);
			q.setLong("coquanquanlyid", coQuanQuanLyId);
			q.setString("maOrTenOrEmail", StringPool.PERCENT + maOrTenOrEmail.toUpperCase()
					+ StringPool.PERCENT);
			q.addEntity("CongChuc", CongChucImpl.class);
			listCongChuc = (List<CongChuc>) QueryUtil.list(q, getDialect(),
					start, end);
		} catch (Exception e) {
			
		} finally {
			closeSession(session);
		}
		return listCongChuc;
	}

	/**
	  * This is fucntion count CongChuc by coQuanQuanLyId and keyword 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long : Value of coQuanQuanLyId; string keyword; 
	  * @return int
	  */
	public int countListCongChuc(long coQuanQuanLyId, String maOrTenOrEmail)
			throws SystemException {
		int total = 0;
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT count(a.id) FROM cmon_congchuc a INNER JOIN cmon_taikhoannguoidung b ON a.taikhoannguoidungid = b.id WHERE 1=1");
			if (!Helpers.isEmpty(maOrTenOrEmail)) {
				sql.append(" AND (upper(a.ma) LIKE (:maOrTenOrEmail) OR upper(a.hovaten) LIKE (:maOrTenOrEmail) OR upper(b.email) LIKE(:maOrTenOrEmail))");
			}
			if (coQuanQuanLyId > 0) {
				sql.append(" AND a.coquanquanlyid = :coquanquanlyid");
			}
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.setCacheable(false);
			q.setLong("coquanquanlyid", coQuanQuanLyId);
			q.setString("maOrTenOrEmail", StringPool.PERCENT + maOrTenOrEmail.toUpperCase()
					+ StringPool.PERCENT);
			total = Integer.valueOf(q.uniqueResult().toString());


		} catch (Exception e) {
			
		} finally {
			closeSession(session);
		}
		return total;
	}
}
