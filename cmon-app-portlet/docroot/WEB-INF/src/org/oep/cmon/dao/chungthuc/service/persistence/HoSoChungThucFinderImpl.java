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

package org.oep.cmon.dao.chungthuc.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.chungthuc.model.impl.HoSoChungThucImpl;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;
import org.oep.cmon.dao.chungthuc.service.persistence.HoSoChungThucFinder;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* HoSoChungThucFinderImpl class
*   
* This class is used to get HoSoChungThuc information 
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
public class HoSoChungThucFinderImpl extends BasePersistenceImpl<HoSoChungThuc>
implements HoSoChungThucFinder {

	/**
	  * This is fucntion get HoSoChungThuc by tthcId, canBoTiepNhanId,coQuanId,soChungThuc and paging param
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end
	  * @return List<HoSoChungThuc>
	  */
	public List<HoSoChungThuc> getHoSoChungThucByTTHCAndSCT(long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String base = "SELECT * FROM CMON_HOSOCHUNGTHUC hsct ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			
			if (coQuanId > 0) {
				sqlBuilder.append("INNER JOIN CMON_CONGCHUC cc on cc.ID = hsct.CANBOTIEPNHANID where cc.COQUANQUANLYID = ? ");
			}
			
			List<String> criteria = new ArrayList<String>();
			
			if (tthcId > 0) {
				criteria.add("hsct.THUTUCHANHCHINHID = ?");
			}
			
			if (canBoTiepNhanId > 0) {
				criteria.add("hsct.CANBOTIEPNHANID = ?");
			}
			
			if (Validator.isNotNull(soChungThuc)) {
				criteria.add("hsct.SOCHUNGTHUC like ?");
			}
			
			if (!criteria.isEmpty()) {
				if (coQuanId <= 0) {
					sqlBuilder.append("WHERE ");
					
				} else {
					sqlBuilder.append("AND ");
				}

				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY hsct.NGAYTAO DESC NULLS LAST ");

			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoChungThuc", HoSoChungThucImpl.class);

			int queryPos = 0;
			//QueryPos qPos = QueryPos.getInstance(q);

			if (coQuanId > 0) {
				q.setLong(queryPos++, coQuanId);
			}
			
			if (tthcId > 0) {
				q.setLong(queryPos++, tthcId);
			}
	
			if (canBoTiepNhanId > 0) {
				q.setLong(queryPos++, canBoTiepNhanId);
			}
			
			if (Validator.isNotNull(soChungThuc)) {
				q.setString(queryPos++, soChungThuc);
			}


			// execute the query and return a list from the db
			return (List<HoSoChungThuc>) QueryUtil.list(q, getDialect(), start,
					end);
			
		} catch (Exception e) {
			throw new SystemException(e);
			
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/**
	  * This is fucntion count HoSoChungThuc by tthcId, canBoTiepNhanId,coQuanId,soChungThuc and param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end
	  * @return int
	  */
	public int countHoSoChungThucByTTHCAndSCT(long tthcId, long canBoTiepNhanId, long coQuanId, String soChungThuc, int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String base = "SELECT count(*) as total FROM CMON_HOSOCHUNGTHUC hsct ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			
			if (coQuanId > 0) {
				sqlBuilder.append("INNER JOIN CMON_CONGCHUC cc on cc.ID = hsct.CANBOTIEPNHANID where cc.COQUANQUANLYID = ? ");
			}
			
			List<String> criteria = new ArrayList<String>();
			
			if (tthcId > 0) {
				criteria.add("hsct.THUTUCHANHCHINHID = ?");
			}
			
			if (canBoTiepNhanId > 0) {
				criteria.add("hsct.CANBOTIEPNHANID = ?");
			}
			
			if (Validator.isNotNull(soChungThuc)) {
				criteria.add("hsct.SOCHUNGTHUC like ?");
			}
			
			if (!criteria.isEmpty()) {
				if (coQuanId <= 0) {
					sqlBuilder.append("WHERE ");
					
				} else {
					sqlBuilder.append("AND ");
				}
				
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY hsct.NGAYSUA DESC NULLS LAST ");

			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			//q.addEntity("HoSoChungThuc", HoSoChungThucImpl.class);

			int queryPos = 0;
			//QueryPos qPos = QueryPos.getInstance(q);

			if (coQuanId > 0) {
				q.setLong(queryPos++, coQuanId);
			}
			
			if (tthcId > 0) {
				q.setLong(queryPos++, tthcId);
			}
	
			if (canBoTiepNhanId > 0) {
				q.setLong(queryPos++, canBoTiepNhanId);
			}
			
			if (Validator.isNotNull(soChungThuc)) {
				q.setString(queryPos++, soChungThuc);
			}

			
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;

			
		} catch (Exception e) {
			throw new SystemException(e);
			
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		
	}
	
}
