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

package org.oep.cmon.dao.hosohcc.service.persistence;

import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.cc.model.impl.CongChucImpl;
import org.oep.cmon.dao.hosohcc.model.impl.YKienTraoDoiImpl;

import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;
import org.oep.cmon.dao.hosohcc.service.persistence.YKienTraoDoiFinder;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* YKienTraoDoiFinderImpl class
*   
* This class is used to get YKienTraoDoi information 
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
public class YKienTraoDoiFinderImpl extends BasePersistenceImpl<YKienTraoDoi> implements YKienTraoDoiFinder{
	public List<YKienTraoDoi> listYKienTraoDoi(long hosothutuchanhchinhid, long tkNguoiDungId, String tieuDe, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM cmon_ykientraodoi where hosotthccongid = "+hosothutuchanhchinhid+ " AND (nguoinhanid= "+tkNguoiDungId+" OR nguoiguiid ="+tkNguoiDungId+")");
			if (Validator.isNotNull(tieuDe)) {
				query.append(" AND (TIEUDE like '%" + tieuDe + "%') ");
			}
			query.append(" ORDER BY thoigianguiykien ");
			String sql = query.toString();
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("YKienTraoDoi", YKienTraoDoiImpl.class);
			 
						// execute the query and return a list from the db
			return (List<YKienTraoDoi>) QueryUtil.list(q, getDialect(),  start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	/**
	  * This is fucntion countYKienTraoDoi 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchanhchinhid
	  * @return int
	  */
	public int countYKienTraoDoi(long hosothutuchanhchinhid) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT count(*) as total FROM cmon_ykientraodoi where hosotthccongid = ");
			query.append(hosothutuchanhchinhid);
			String sql = query.toString();
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
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
			closeSession(session);
		}
	}
	/**
	  * This is fucntion listCanBoTiepNhan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, int start, int end
	  * @return List<CongChuc>
	  */
	public List<CongChuc> listCanBoTiepNhan(long coQuanQuanLyId, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT * FROM CMON_CONGCHUC T1 , CMON_CHUCVU T2 WHERE T1.CHUCVUID = T2.ID AND T1.COQUANQUANLYID = "+coQuanQuanLyId+" AND " +
					"T2.MA =(SELECT GIATRI FROM CMON_THAMSO WHERE TEN ='CHUCVU_MOTCUA')");
			String sql = query.toString();

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("CongChuc", CongChucImpl.class);
			 
						// execute the query and return a list from the db
			return (List<CongChuc>) QueryUtil.list(q, getDialect(),  start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	/**
	  * This is fucntion listYKienTraoDoiAndLoai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchanhchinhid, long tkNguoiDungId, String loai, String tieuDe, int start, int end
	  * @return List<YKienTraoDoi>
	  */
	public List<YKienTraoDoi> listYKienTraoDoiAndLoai(long hosothutuchanhchinhid, long tkNguoiDungId, String loai, String tieuDe, int start, int end)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT *  FROM cmon_ykientraodoi where hosotthccongid = "+hosothutuchanhchinhid+ "  AND loai IN (" + loai + ")");
			
			if (tkNguoiDungId > 0) {
				query.append(" AND (NGUOIGUIID = "+ tkNguoiDungId+" or NGUOINHANID= "+ tkNguoiDungId+")");
			}
			
			if (Validator.isNotNull(tieuDe)) {
				query.append(" AND (TIEUDE like '%" + tieuDe + "%') ");
			}
			
			query.append(" ORDER BY thoigianguiykien ");
			String sql = query.toString();
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("YKienTraoDoi", YKienTraoDoiImpl.class);
			 
						// execute the query and return a list from the db
			return (List<YKienTraoDoi>) QueryUtil.list(q, getDialect(),  start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	//Quocdv add code
	
	/**
	  * This is fucntion findYKienByHoSoTTHCCongIdAndLoai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchanhchinhid,long loai
	  * @return List<YKienTraoDoi>
	  */
	public List<YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(long hosothutuchanhchinhid,long loai)
			throws SystemException {
		Session session = null;
		try {
			session = openSession();
			String query = "SELECT * FROM cmon_ykientraodoi where hosotthccongid = "+hosothutuchanhchinhid+" AND loai ="+loai+" order BY id asc ";
		 
			SQLQuery q = session.createSQLQuery(query);
			q.setCacheable(false);
			q.addEntity("YKienTraoDoi", YKienTraoDoiImpl.class);
			 
			//execute the query and return a list from the db
			return (List<YKienTraoDoi>)QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	
	/**
	  * This is fucntion countYKienTraoDoiAndLoai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosothutuchanhchinhid, long tkNguoiDungId, String loai, String tieuDe
	  * @return int
	  */
	public int countYKienTraoDoiAndLoai(long hosothutuchanhchinhid, long tkNguoiDungId, String loai, String tieuDe) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			StringBuilder query = new StringBuilder();
			
			query.append("SELECT count(*) as total FROM cmon_ykientraodoi where hosotthccongid = "+hosothutuchanhchinhid+ "  AND loai IN (" + loai + ")");
			
			if (tkNguoiDungId > 0) {
				query.append(" AND (nguoinhanid= "+tkNguoiDungId+" OR nguoiguiid ="+tkNguoiDungId+")");
			}
			
			if (Validator.isNotNull(tieuDe)) {
				query.append(" AND (TIEUDE like '%" + tieuDe + "%') ");
			}
			
			String sql = query.toString();
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar("total", com.liferay.portal.kernel.dao.orm.Type.LONG);
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
			closeSession(session);
		}
	}
	
}
