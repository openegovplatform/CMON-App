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
import java.util.List;

import org.oep.cmon.dao.nsd.model.impl.TaiKhoanNguoiDungImpl;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;
import org.oep.cmon.dao.nsd.service.persistence.TaiKhoanNguoiDungFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
 * @author win_64
 *
 */
/**
*
* TaiKhoanNguoiDungFinderImpl class
*   
* This class is used to get TaiKhoanNguoiDung information 
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
public class TaiKhoanNguoiDungFinderImpl extends BasePersistenceImpl<TaiKhoanNguoiDung> implements TaiKhoanNguoiDungFinder {
	
	/**
	  * This is fucntion findTaiKhoanNguoiDung 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, String option
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findTaiKhoanNguoiDung(String keyWord, String option) {
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_TAIKHOANNGUOIDUNG ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			if (keyWord.trim().length() > 0) {
				if (option.compareTo("0") == 0) {
					criteria.add("TENDANGNHAP like ?");
				} else if (option.compareTo("1") == 0) {
					criteria.add("TENNGUOIDUNG like ?");
				} else {
					criteria.add("EMAIL like ?");
				}
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			} 
			
			sqlBuilder.append(" ORDER BY ID DESC");
			String sql = sqlBuilder.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("TaiKhoanNguoiDung", TaiKhoanNguoiDungImpl.class);

			if (keyWord.trim().length() > 0) {
				QueryPos qPos = QueryPos.getInstance(q);
				// Setting the positions
				if (keyWord.trim().length() > 0) {
					qPos.add("%" + keyWord.trim() + "%");
				}
			}

			// execute the query and return a list from the db
			return (List<TaiKhoanNguoiDung>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<TaiKhoanNguoiDung>();
	} // end

	
	/**
	  * This is fucntion findTaiKhoanNguoiDungPopup
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String keyWord, String option
	  * @return List<TaiKhoanNguoiDung>
	  */
	public List<TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(String keyWord, String option) {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String base = "SELECT * FROM CMON_TAIKHOANNGUOIDUNG ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			if (keyWord.trim().length() > 0) {
				if (option.compareTo("0") == 0) {
					criteria.add("LOWER(TENDANGNHAP) like LOWER(?)");
				} else if (option.compareTo("1") == 0) {
					criteria.add("LOWER(TENNGUOIDUNG) like LOWER(?)");
				} else {
					criteria.add("LOWER(EMAIL) like LOWER(?)");
				}
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
				sqlBuilder.append(" AND ID not in (select TAIKHOANNGUOIDUNGID from CMON_CONGCHUC where TAIKHOANNGUOIDUNGID is not null and DAXOA=0 ) ");
			} else {
				sqlBuilder.append(" WHERE ID not in (select TAIKHOANNGUOIDUNGID from CMON_CONGCHUC where TAIKHOANNGUOIDUNGID is not null and DAXOA=0 )");
			}
			
			sqlBuilder.append(" ORDER BY ID DESC");
			String sql = sqlBuilder.toString();
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("TaiKhoanNguoiDung", TaiKhoanNguoiDungImpl.class);

			if (keyWord.trim().length() > 0) {
				QueryPos qPos = QueryPos.getInstance(q);
				// Setting the positions
				if (keyWord.trim().length() > 0) {
					qPos.add("%" + keyWord.trim() + "%");
				}
			}

			// execute the query and return a list from the db
			return (List<TaiKhoanNguoiDung>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions…
			closeSession(session);
		}
		return new ArrayList<TaiKhoanNguoiDung>();
	} // end
}
