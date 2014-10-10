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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.hosohcc.model.impl.HoSoTTHCCongImpl;
import org.oep.egovcore.util.Helper;
import org.oep.egovcore.validate.term.IsNumeral;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongFinder;
import vn.dtt.sharedservice.bpm.consumer.uengine.Exception_Exception;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrmsService;
import vn.dtt.sharedservice.bpm.consumer.uengine.ProcessInstance;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;


/**
*
* HoSoTTHCCongFinderImpl class
*   
* This class is used to get HoSoTTHCCong information 
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
public class HoSoTTHCCongFinderImpl extends BasePersistenceImpl<HoSoTTHCCong> implements HoSoTTHCCongFinder {
	
	public static Log _log = LogFactoryUtil.getLog(HoSoTTHCCongFinderImpl.class);
	Log logger = LogFactoryUtil.getLog(this.getClass());

	/* 
	 * @TODO Tim kiem HoSoTTHCCong by congDanNopId hoac congDanNopId
	 */
	
	/**
	  * This is fucntion findByMaCongDanHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId, String maSoHoSo, int start, int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByMaCongDanHoSo(long congDanNopId, String maSoHoSo, int start, int end)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			
			if (Validator.isNotNull(congDanNopId)) {
				criteria.add("CONGDANNOPID = ?");
			}
			
			if (Validator.isNotNull(maSoHoSo)) {
				criteria.add("MASOHOSO like ?");
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}

			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			// Setting the positions
			if (Validator.isNotNull(congDanNopId)) {
				qPos.add(congDanNopId);
			}
			
			if (Validator.isNotNull(maSoHoSo)) {
				qPos.add("%" + maSoHoSo + "%");
			}

			// execute the query and return a list from the db
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}

	/* 
	 * @TODO Cap nhat trang thai ho so
	 */
	
	/**
	  * This is fucntion updateHOSOTTHCCONGById
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int status
	  * @return int
	  */
	public int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status) throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = "UPDATE CMON_HOSOTTHCCONG SET DAGUIGIAYHEN = ? WHERE ID = ?";
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(status);
			qPos.add(hoSoTTHCCongId);
			return q.executeUpdate();
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	/* 
	 * @TODO Dem so luong record HoSoTTHCCong by congDanNopId hoac maSoHoSo
	 */
	
	/**
	  * This is fucntion countByMaCongDanHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId, String maSoHoSo
	  * @return int
	  */
	public int countByMaCongDanHoSo(long congDanNopId, String maSoHoSo) throws SystemException {
		Session session = null;
		try {
			
			session = openSession();
			String base = "SELECT COUNT(*) as total FROM CMON_HOSOTTHCCONG ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			
			if (Validator.isNotNull(congDanNopId)) {
				criteria.add("CONGDANNOPID = ?");
			}
			
			if (Validator.isNotNull(maSoHoSo)) {
				criteria.add("MASOHOSO like ?");
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}

			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);

			// Setting the positions
			if (Validator.isNotNull(congDanNopId)) {
				qPos.add(congDanNopId);
			}
			
			if (Validator.isNotNull(maSoHoSo)) {
				qPos.add("%" + maSoHoSo + "%");
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
			closeSession(session);
		}
	}
	
	/*
	 * @TODO Tim kiem HoSoTTHCCong
	 */
	
	/**
	  * This is fucntion findByCQQL 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		long thuTucHanhChinhId,
		String maUngDung,
		long cqqlId,
		int trangThai,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByCQQL(
		String maSoHoSo,
		long thuTucHanhChinhId,
		String maUngDung,
		long cqqlId,
		int trangThai,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG A ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			
			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					criteria.add(" A.MASOHOSO lIKE ? OR A.MASOBIENNHAN LIKE ? ");
				} else {
					criteria.add(
						" LOWER(REGEXP_REPLACE(TRIM(A.HOTENNGUOINOPHOSO),' +',' '))" +
						" LIKE" +
						" '%' || LOWER(REGEXP_REPLACE(TRIM(?),' +',' ')) || '%' "
					);
				}
			}
			
			if (thuTucHanhChinhId > 0) {
				criteria.add("A.thutuchanhchinhid = ?");
			}
			
			if (Validator.isNotNull(maUngDung)) {
				criteria.add("A.MAUNGDUNG = ?");
			}
			
			criteria.add("A.thutuchanhchinhid in (select B.thutuchanhchinhid from cmon_tthc2coquanquanly B where B.COQUANQUANLYID = ? AND B.COQUANQUANLYID = A.COQUANTIEPNHANID)");
			
			if (trangThai >= 0) {
				criteria.add("A.TRANGTHAIHOSO = ?");
			}

			criteria.add("A.DAXOA = 0");
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY A.NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				} else {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				}
			}

			if (thuTucHanhChinhId > 0) {
				q.setLong(queryPos++, thuTucHanhChinhId);
			}
			
			if (Validator.isNotNull(maUngDung)) {
				q.setString(queryPos++, maUngDung);
			}
			
			q.setLong(queryPos++, cqqlId);
			
			if (trangThai >= 0) {
				q.setLong(queryPos++, trangThai);
			}
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}

	/*
	 * @TODO Tim kiem HoSoTTHCCong
	 */
	
	/**
	  * This is fucntion findHoSoTTHCCong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		int trangThaiHoSo,
		long cqqlId,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findHoSoTTHCCong(
		String maSoHoSo,
		int trangThaiHoSo,
		long cqqlId,
		int start,
		int end
	) {
		Session session = null;
		try {
			session = openSession();
			StringBuffer sqlBuilder = new StringBuffer(
				"SELECT * FROM CMON_HOSOTTHCCONG WHERE COQUANTIEPNHANID = ? AND TRANGTHAIHOSO = ?  ");

			if (Validator.isNotNull(maSoHoSo)) {
				sqlBuilder.append(" MASOHOSO lIKE ?");
			}
			
			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			q.setLong(0, cqqlId);
			q.setInteger(1, trangThaiHoSo);
			
			if (Validator.isNotNull(maSoHoSo)) {
				q.setString(2, "%" + maSoHoSo + "%");
			}
			// execute the query and return a list from the db
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		return new ArrayList<HoSoTTHCCong>();
	}

	/*
	 * @TODO Dem so luong record HoSoTTHCCong
	 */
	/**
	  * This is fucntion countHoSoTTHCCongByCoQuanQuanLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo, int trangThaiHoSo, long cqqlId
	  * @return long
	  */
	public long countHoSoTTHCCongByCoQuanQuanLy(String maSoHoSo, int trangThaiHoSo, long cqqlId) {

		Session session = null;
		try {
			
			session = openSession();
			StringBuffer sqlBuilder = new StringBuffer(
				"SELECT count(*) FROM CMON_HOSOTTHCCONG WHERE COQUANTIEPNHANID = ? AND TRANGTHAIHOSO = ?  ");
			new ArrayList<String>();
			
			if (Validator.isNotNull(maSoHoSo)) {
				sqlBuilder.append(" MASOHOSO lIKE ?");
			}

			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			q.setLong(0, cqqlId);
			q.setInteger(1, trangThaiHoSo);
			
			if (Validator.isNotNull(maSoHoSo)) {
				q.setString(2, "%" + maSoHoSo + "%");
			}
		
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		return 0;
	}

	/*
	 * @TODO Tim kiem HoSoTTHCCong
	 */
	
	/**
	  * This is fucntion findByMaCongDanHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId,
		String maSoHoSo,
		long thuTucHanhChinhId,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByMaCongDanHoSo_QT(
		long congDanNopId,
		String maSoHoSo,
		long thuTucHanhChinhId,
		int start,
		int end
	) throws SystemException {

		Session session = null;
		try {

			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG  ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			criteria.add("CONGDANNOPID = ?");

			if (Validator.isNotNull(maSoHoSo)) {
				criteria.add("MASOHOSO lIKE ?");
			}

			if (thuTucHanhChinhId > 0) {
				// criteria.add("THUTUCHANHCHINHID = ?");
				criteria.add("THUTUCHANHCHINHID in (SELECT ID FROM CMON_THUTUCHANHCHINH WHERE NHOMTHUTUCHANHCHINHID = ?)");
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" AND DAXOA = 0 ");
			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			int queryPos = 0;
			q.setLong(queryPos++, congDanNopId);
			
			if (Validator.isNotNull(maSoHoSo)) {
				q.setString(queryPos++, "%" + maSoHoSo + "%");
			}
			
			if (thuTucHanhChinhId > 0) {
				q.setLong(queryPos++, thuTucHanhChinhId);

			}
			// execute the query and return a list from the db
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	} // end

	/*
	 * @TODO Dem so luong record HoSoTTHCCong
	 */
	
	/**
	  * This is fucntion countByMaCongDanHoSo_QT 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long congDanNopId,
		String maSoHoSo,
		long thuTucHanhChinhId
	  * @return int
	  */
	public int countByMaCongDanHoSo_QT(
		long congDanNopId,
		String maSoHoSo,
		long thuTucHanhChinhId
	) throws SystemException {
	
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT COUNT(*) as total FROM CMON_HOSOTTHCCONG ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			criteria.add("CONGDANNOPID = ?");
			
			if (Validator.isNotNull(maSoHoSo)) {
				criteria.add("MASOHOSO like ?");
			}
			
			if (thuTucHanhChinhId > 0) {
				// criteria.add("THUTUCHANHCHINHID = ?");
				criteria.add("THUTUCHANHCHINHID in (SELECT ID FROM CMON_THUTUCHANHCHINH WHERE NHOMTHUTUCHANHCHINHID = ?)");
			}

			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" AND DAXOA = 0 ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			q.setLong(queryPos++, congDanNopId);

			if (Validator.isNotNull(maSoHoSo)) {
				q.setString(queryPos++, "%" + maSoHoSo + "%");
			}
			
			if (thuTucHanhChinhId > 0) {
				q.setLong(queryPos++, thuTucHanhChinhId);
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
			closeSession(session);
		}
	}

	/*
	 * @TODO Dem so luong record HoSoTTHCCong
	 */
	
	/**
	  * This is fucntion countByCQQL
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		long thuTucHanhChinhId,
		String maUngDung,
		long cqqlId,
		int trangThai
	  * @return int
	  */
	public int countByCQQL(
		String maSoHoSo,
		long thuTucHanhChinhId,
		String maUngDung,
		long cqqlId,
		int trangThai
	) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT count(*) as total FROM CMON_HOSOTTHCCONG A ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			
			if (Validator.isNotNull(maSoHoSo)) {
				
				if (IsNumeral.check(maSoHoSo)) {
					criteria.add(" A.MASOHOSO lIKE ? OR A.MASOBIENNHAN LIKE ? ");
				} else {
					criteria.add(
						" LOWER(REGEXP_REPLACE(TRIM(A.HOTENNGUOINOPHOSO),' +',' '))" +
						" LIKE" +
						" '%' || LOWER(REGEXP_REPLACE(TRIM(?),' +',' ')) || '%' "
					);
				}
			}
			
			if (thuTucHanhChinhId > 0) {
				criteria.add("A.thutuchanhchinhid = ?");
			}
			
			if (Validator.isNotNull(maUngDung)) {
				criteria.add("A.MAUNGDUNG = ?");
			}
			
			criteria.add("A.thutuchanhchinhid in (select B.thutuchanhchinhid from cmon_tthc2coquanquanly B where B.COQUANQUANLYID = ? AND B.COQUANQUANLYID = A.COQUANTIEPNHANID)");
			if (trangThai >= 0) {
				criteria.add("A.TRANGTHAIHOSO = ?");
			}
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("total", Type.LONG);
			int queryPos = 0;
			
			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				} else {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				}
			}
			
			if (thuTucHanhChinhId > 0) {
				q.setLong(queryPos++, thuTucHanhChinhId);
			}
			
			if (Validator.isNotNull(maUngDung)) {
				q.setString(queryPos++, maUngDung);
			}
			
			q.setLong(queryPos++, cqqlId);
			
			if (trangThai >= 0) {
				q.setLong(queryPos++, trangThai);
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
			closeSession(session);
		}
	}

	/*
	 * @TODO Tim kiem ho so dang xu ly
	 */
	/**
	  * This is fucntion searchHSDangXuLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchHSDangXuLy(
		String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		String maHoSos = "";
		if (Validator.isNotNull(emailCanBo)) {

			// get ho so can bo phai xu ly
			String sqlStmt = "SELECT * FROM bpm_procinst b WHERE INSTR(b.CURREP, '" + emailCanBo + "') > 0";
			List<ProcessInstance> processInstances = null;
			
			try {
				IBrms iBrms = new IBrmsService().getIBrmsPort();
				processInstances = iBrms.getFromDBBySelectStatement(sqlStmt);
			} catch (Exception_Exception e) {
				return new ArrayList<HoSoTTHCCong>();
			}
			
			if (processInstances != null && processInstances.size() > 0) {
				for (ProcessInstance processInstance : processInstances) {
					if ("".equals(maHoSos)) {
						maHoSos += "'" + processInstance.getInstName() + "'";
					} else {
						maHoSos += ", " + "'" + processInstance.getInstName() + "'";
					}
				}
			} else {
				return new ArrayList<HoSoTTHCCong>();
			}
		} else {
			return new ArrayList<HoSoTTHCCong>();
		}
		
		if ("".equals(maHoSos)) {
			return new ArrayList<HoSoTTHCCong>();
		}
		
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CMON_HOSOTTHCCONG Atthcc WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			if (thuTucHanhChinhId > 0) {
				sqlBuilder.append(" AND THUTUCHANHCHINHID = ? ");
			}
			
			if (status > 0) {
				sqlBuilder.append(" AND TRANGTHAIHOSO = ? ");
			} else {
				sqlBuilder.append(" AND TRANGTHAIHOSO IN (SELECT GIATRI FROM CMON_THAMSO WHERE TEN IN ('TT_TIEPNHAN', 'TT_DAXULYXONG', 'TT_DANGXULY', 'TT_CHOTHUCHIENLIENTHONG')) ");
			}
			
			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}
			
			if (thuTucHanhChinhId > 0) {
				qPos.add(thuTucHanhChinhId);
			}
			
			if (status > 0) {
				qPos.add(status);
			}
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	/*
	 * @TODO Dem so luong ho so dang xu ly
	 */
	
	/**
	  * This is fucntion countHSDangXuLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	  * @return int
	  */
	public int countHSDangXuLy(
		String maSoOrTenNguoiNopHoSo,
		long thuTucHanhChinhId,
		int status,
		String emailCanBo,
		int start,
		int end
	) throws SystemException {
		Session session = null;
		String maHoSos = "";
		
		if (Validator.isNotNull(emailCanBo)) {

			// get ho so can bo phai xu ly
			String sqlStmt = "SELECT * FROM bpm_procinst b WHERE INSTR(b.CURREP, '" + emailCanBo + "') > 0";
			List<ProcessInstance> processInstances = null;
			
			try {
				IBrms iBrms = new IBrmsService().getIBrmsPort();
				processInstances = iBrms.getFromDBBySelectStatement(sqlStmt);
			} catch (Exception_Exception e) {
				return 0;
			}
			
			if (processInstances != null && processInstances.size() > 0) {
				for (ProcessInstance processInstance : processInstances) {
					if ("".equals(maHoSos)) {
						maHoSos += "'" + processInstance.getInstName() + "'";
					} else {
						maHoSos += ", " + "'" + processInstance.getInstName() + "'";
					}
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		
		if ("".equals(maHoSos)) {
			return 0;
		}
		
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CMON_HOSOTTHCCONG Atthcc WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			if (thuTucHanhChinhId > 0) {
				sqlBuilder.append(" AND THUTUCHANHCHINHID = ? ");
			}
			
			if (status > 0) {
				sqlBuilder.append(" AND TRANGTHAIHOSO = ? ");
			} else {
				sqlBuilder.append(" AND TRANGTHAIHOSO IN (SELECT GIATRI FROM CMON_THAMSO WHERE TEN IN ('TT_TIEPNHAN', 'TT_DAXULYXONG', 'TT_DANGXULY', 'TT_CHOTHUCHIENLIENTHONG')) ");
			}
			
			sqlBuilder.append(" AND DAXOA = 0");
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}
			
			if (thuTucHanhChinhId > 0) {
				qPos.add(thuTucHanhChinhId);
			}
			
			if (status > 0) {
				qPos.add(status);
			}
			
			List<HoSoTTHCCong> list = q.list();
			return list.size();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return 0;
	}

	/*
	 * @TODO Tim kiem ho so dang xu ly bang trang thai va thu tuc hanh chinh
	 */
	
	/**
	  * This is fucntion searchHSDangXuLyMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		String maHoSos = "";		
		if (Validator.isNotNull(emailCanBo)) {

		String sqlStmt = "select * from (select c.*, row_number() over (order by moddate desc) as rn   from ( SELECT DISTINCT  b.name , b.instid,b.defid,b.defname,b.status,b.currep, b.moddate FROM bpm_procinst b, bpm_worklist a WHERE a.instid =b.instid and a.endpoint='"
			+ "sonnm@danang.gov.vn"
			+ "' "
			+ "and a.startdate between to_date('"
			+ tuNgay
			+ "','dd/MM/yyyy')  and to_date('"
			+ denNgay
			+ "','dd/MM/yyyy')  ) c)"
		;			
			
			logger.info("SqlStmt cua can bo  dc chon :" + sqlStmt);
			List<ProcessInstance> processInstances = null;
			logger.info("emailCanBo cua can bo  dc chon :" + emailCanBo);
			
			try {
				IBrms iBrms = new IBrmsService().getIBrmsPort();
				processInstances = iBrms.getFromDBBySelectStatement(sqlStmt);
				logger.info("processInstances cua can bo  dc chon :" + processInstances);
			} catch (Exception_Exception e) {
				return new ArrayList<HoSoTTHCCong>();
			}
			
			if (processInstances != null && processInstances.size() > 0) {
				for (ProcessInstance processInstance : processInstances) {
					if ("".equals(maHoSos)) {
						maHoSos += "'" + processInstance.getInstName() + "'";
					} else {
						maHoSos += ", " + "'" + processInstance.getInstName() + "'";
					}
				}
				logger.info("maHoSos cua can bo iffffffff dc chon :" + maHoSos);
			} else {
				return new ArrayList<HoSoTTHCCong>();
			}
		} else {
			return new ArrayList<HoSoTTHCCong>();
		}
		
		if ("".equals(maHoSos)) {
			return new ArrayList<HoSoTTHCCong>();
		}
		
		try {
			logger.info("maHoSos cua userEmail dc chon :" + maHoSos);
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CMON_HOSOTTHCCONG  WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			logger.info("thuTucHanhChinhIds cua userEmail dc chon :" + thuTucHanhChinhIds);
			sqlBuilder.append(" AND DAXOA = 0");
			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			logger.info("CAU SQL :" + sqlBuilder.toString());
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}
			
			logger.info("List xuat ra :"+ (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end));
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return new ArrayList<HoSoTTHCCong>();
	}	
	
	/*
	 * @TODO Get danh sach ma ho so
	 */
	
	/**
	  * This is fucntion getDSMaSoHS
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param List<String> lsMail, String tuNgay, String denNgay, int start, int end
	  * @return String
	  */
	public String getDSMaSoHS(List<String> lsMail, String tuNgay, String denNgay, int start, int end) {
		
		String maHoSos = "";		
		String joinMail= Helper.join(lsMail, true);
		logger.info("Xuat ra joinMail :" + joinMail);
		logger.info("Xuat ra joinMail :" + joinMail);
		
		if (lsMail.size()>0) {

			logger.info("Xuat ra tuNgay :" + tuNgay);
			logger.info("Xuat ra denNgay :" + denNgay);
			logger.info("Xuat ra start :" + start);
			logger.info("Xuat ra end :" + end);
			
			String sqlStmt = "select * from (select c.*, row_number() over (order by name asc) as rn   from ( SELECT DISTINCT  b.name , b.instid,b.defid,b.defname,b.status,b.currep FROM bpm_procinst b, bpm_worklist a WHERE a.instid =b.instid and a.endpoint in (" + joinMail +") "
				+ "and a.startdate between to_date('"
				+ tuNgay
				+ "','dd/MM/yyyy')  and to_date('"
				+ denNgay
				+ "','dd/MM/yyyy')  ) c)"
				+ " where( rn between "
				+ start
				+ "  and " + end + " ) ORDER BY instid desc";

				logger.info("Xuat ra sqlStmt :" + sqlStmt);
			
				List<ProcessInstance> processInstances = null;
				try {
					IBrms iBrms = new IBrmsService().getIBrmsPort();
					processInstances = iBrms.getFromDBBySelectStatement(sqlStmt);					 
					logger.info("Xuat ra processInstances :" + processInstances);
				} catch (Exception_Exception e) {
					e.printStackTrace();
					return "";
				}
				
				if (processInstances != null && processInstances.size() > 0) {
					for (ProcessInstance processInstance : processInstances) {
						if ("".equals(maHoSos)) {
							maHoSos += "'" + processInstance.getInstName() + "'";
						} else {
							maHoSos += ", " + "'" + processInstance.getInstName() + "'";
						}
					}
					
				} else {
					return "";
				}
			}
			
		logger.info("Lay chuoi maHoSos  :" + maHoSos);
		return maHoSos;
	}
	
	/*
	 * @TODO Tim kiem ho so dang xu ly bang trang thai va thu tuc hanh chinh
	 */
	
	/**
	  * This is fucntion searchAllHSDangXuLyMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> lsMaHoSo,
		String tuNgay,
		String denNgay,
		int start, int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> lsMaHoSo,
		String tuNgay,
		String denNgay,
		int start, int end
	) throws SystemException {
		
		Session session = null;
		String maHoSos = Helper.join(lsMaHoSo, true);

		if ("".equals(maHoSos)) {
			return new ArrayList<HoSoTTHCCong>();
		}
		
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CMON_HOSOTTHCCONG Atthcc WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
		
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			if (thuTucHanhChinhIds != null && thuTucHanhChinhIds.length() > 0) {
				sqlBuilder.append(" AND THUTUCHANHCHINHID IN (" + thuTucHanhChinhIds +") ");
			}
			
			if (status != null && status.length() > 0) {
				sqlBuilder.append(" AND TRANGTHAIHOSO  IN (" + status +")");
			}
			
			if (Validator.isNotNull(tuNgay) && Validator.isNotNull(denNgay)) {
				sqlBuilder.append("AND NGAYNOPHOSO BETWEEN TO_DATE ('"+ tuNgay +"','dd/MM/yyyy') AND TO_DATE('"
					+ denNgay + "','dd/MM/yyyy') ");
			}		
			
			sqlBuilder.append(" AND DAXOA = 0");			
			sqlBuilder.append(" ORDER BY NGAYSUA DESC NULLS LAST ");
			logger.info("Lay chuoi sqlBuilder  :" + sqlBuilder);
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);

			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}

			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return  Collections.emptyList();
	}
	
	/*
	 * @TODO Dem so luong ho so dang xu ly bang trang thai va thu tuc hanh chinh
	 */
	/**
	  * This is fucntion countHSDangXuLyMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		String emailCanBo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		String maHoSos = "";
		if (Validator.isNotNull(emailCanBo)) {

			String sqlStmt = "select * from (select c.*, row_number() over (order by moddate desc) as rn   from ( SELECT DISTINCT  b.name , b.instid,b.defid,b.defname,b.status,b.currep,b.moddate FROM bpm_procinst b, bpm_worklist a WHERE a.instid =b.instid and a.endpoint='"
				+ "sonnm@danang.gov.vn"
				+ "' "
				+ "and a.startdate between to_date('"
				+ tuNgay
				+ "','dd/MM/yyyy')  and to_date('"
				+ denNgay
				+ "','dd/MM/yyyy')  ) c)"
			;
		
			logger.info("Lay  sqlStmt trong count :" + sqlStmt);
			List<ProcessInstance> processInstances = null;
			
			try {
				IBrms iBrms = new IBrmsService().getIBrmsPort();
				processInstances = iBrms.getFromDBBySelectStatement(sqlStmt);
				logger.info("Lay  processInstances trong count :" + processInstances);
			} catch (Exception_Exception e) {
				return 0;
			}
			
			if (processInstances != null && processInstances.size() > 0) {
				for (ProcessInstance processInstance : processInstances) {
					if ("".equals(maHoSos)) {
						maHoSos += "'" + processInstance.getInstName() + "'";
					} else {
						maHoSos += ", " + "'" + processInstance.getInstName() + "'";
					}
				}
			} else {
				return 0;
			}
		} else {
			return 0;
		}
		
		logger.info("Lay  maHoSos trong count :" + maHoSos);
		
		if ("".equals(maHoSos)) {
			return 0;
		}
		
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM CMON_HOSOTTHCCONG Atthcc WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			sqlBuilder.append(" AND DAXOA = 0");
			logger.info("Lay  sqlBuilder trong count :" + sqlBuilder);
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			logger.info("Lay  sqlStmt trong count :" + q);
			q.setCacheable(false);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}

			List<HoSoTTHCCong> list = q.list();
			return list.size();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return 0;
	}
		
	/*
	 * @TODO Dem so luong ho so dang xu ly bang trang thai va thu tuc hanh chinh
	 */
	
	/**
	  * This is fucntion countAllHSDangXuLyMutilStatusAndTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> lsMaHoSo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countAllHSDangXuLyMutilStatusAndTTHC(
		String maSoOrTenNguoiNopHoSo,
		String thuTucHanhChinhIds,
		String status,
		List<String> lsMaHoSo,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;

		if(lsMaHoSo==null || lsMaHoSo.isEmpty()) {
			return 0;
		}
		
		String maHoSos = Helper.join(lsMaHoSo, true);
		
		try {
			session = openSession();
			StringBuilder sqlBuilder = new StringBuilder("SELECT COUNT(ID) count_ FROM CMON_HOSOTTHCCONG WHERE ");
			sqlBuilder.append(" MASOHOSO IN ( " + maHoSos +") ");
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				sqlBuilder.append(" AND (MASOHOSO LIKE ? OR MASOBIENNHAN LIKE ? OR UPPER(HOTENNGUOINOPHOSO) LIKE UPPER(?)) ");
			}
			
			if (thuTucHanhChinhIds != null && thuTucHanhChinhIds.length() > 0) {
				sqlBuilder.append(" AND THUTUCHANHCHINHID IN (" + thuTucHanhChinhIds +") ");
			}
			
			if (status != null && status.length() > 0) {
				sqlBuilder.append(" AND TRANGTHAIHOSO  IN (" + status +") ");
			}
			
			if (Validator.isNotNull(tuNgay) && Validator.isNotNull(denNgay)) {
				sqlBuilder.append(" AND NGAYNOPHOSO BETWEEN TO_DATE ('"+ tuNgay +"','dd/MM/yyyy') AND TO_DATE('"
					+ denNgay + "','dd/MM/yyyy') ");
			}
			
			sqlBuilder.append(" AND DAXOA = 0");
			SQLQuery q = session.createSQLQuery(sqlBuilder.toString());
			q.setCacheable(false);
			q.addScalar("count_", Type.INTEGER);
			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(maSoOrTenNguoiNopHoSo)) {
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add(maSoOrTenNguoiNopHoSo + "%");
				qPos.add("%" + maSoOrTenNguoiNopHoSo);
			}
			
			return (Integer) q.uniqueResult();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return 0;
	}

	/*
	 * @TODO Tim kiem ho so bang trang thai va thu tuc hanh chinh
	 */
	
	/**
	  * This is fucntion findByMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tthcIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> findByMutilStatusAndTTHC(
		String tthcIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG A ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					criteria.add(" (A.MASOHOSO lIKE ? OR A.MASOBIENNHAN LIKE ? )");
				} else {
					criteria.add(
						" LOWER(REGEXP_REPLACE(TRIM(A.HOTENNGUOINOPHOSO),' +',' '))" +
						" LIKE" +
						" '%' || LOWER(REGEXP_REPLACE(TRIM(?),' +',' ')) || '%' "
					);
				}
			}
			
			if (tthcIds != null && tthcIds.length()> 0) {
				criteria.add("A.thutuchanhchinhid  IN (" + tthcIds +") ");
			}
			
			if(idCanBo > 0 && (!"0".equals(trangThais))){
				criteria.add("A.CANBOTIEPNHANID  = " + idCanBo +" ");
			}
			
			if (Validator.isNotNull(maUngDung)) {
				criteria.add("A.MAUNGDUNG = ?");
			}
			
			if (cqqlId > 0) {
				 criteria.add("A.thutuchanhchinhid in (select B.thutuchanhchinhid from cmon_tthc2coquanquanly B where B.COQUANQUANLYID = ? AND B.COQUANQUANLYID = A.COQUANTIEPNHANID)");
			}
			
			if (trangThais != null && trangThais.length() > 0) {
				criteria.add("A.TRANGTHAIHOSO IN (" + trangThais + ") ");
			}

			if (Validator.isNotNull(tuNgay) && Validator.isNotNull(denNgay)) {
				criteria.add("A.NGAYNOPHOSO BETWEEN TO_DATE ('"+ tuNgay +"','dd/MM/yyyy') AND TO_DATE('"
					+ denNgay + "','dd/MM/yyyy') ");
					
			}

			criteria.add("A.YEUCAUHUYHOSO = ?");
			criteria.add("A.DAXOA = 0");
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY A.NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				} else {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				}
			}
			
			if (Validator.isNotNull(maUngDung)) {
				q.setString(queryPos++, maUngDung);
			}
			 if (cqqlId > 0) {
				 q.setLong(queryPos++, cqqlId);
			}
			
			q.setInteger(queryPos++, yeuCauRut);
			 
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/*
	 * @TODO Tim kiem ho so
	 */
	
	/**
	  * This is fucntion getDSCongChuc2ThuTuc
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maSoHoSo,
		String thuTucHanhChinhIds,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		int start,
		int end
	  * @return List<HoSoTTHCCong>
	  */
	public List<HoSoTTHCCong> getDSCongChuc2ThuTuc(
		String maSoHoSo,
		String thuTucHanhChinhIds,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		int start,
		int end
	) throws SystemException {
		
		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG A";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					criteria.add(" A.MASOHOSO lIKE ? OR A.MASOBIENNHAN LIKE ? ");
				} else {
					criteria.add(
						" LOWER(REGEXP_REPLACE(TRIM(A.HOTENNGUOINOPHOSO),' +',' '))" +
						" LIKE" +
						" '%' || LOWER(REGEXP_REPLACE(TRIM(?),' +',' ')) || '%' "
					);
				}
			}
			
			if (thuTucHanhChinhIds != null && thuTucHanhChinhIds.length()> 0) {
				criteria.add("A.thutuchanhchinhid  IN (" + thuTucHanhChinhIds +") ");
			}
			
			if (Validator.isNotNull(maUngDung)) {
				criteria.add("A.MAUNGDUNG = ?");
			}
			
			if (cqqlId > 0) {
				criteria.add("A.thutuchanhchinhid in (select B.thutuchanhchinhid from cmon_tthc2coquanquanly B where B.COQUANQUANLYID = ? AND B.COQUANQUANLYID = A.COQUANTIEPNHANID)");
			}
			
			 if (trangThais != null && trangThais.length() > 0) {
				criteria.add("A.TRANGTHAIHOSO IN (" + trangThais + ") ");
			}

			criteria.add("A.YEUCAUHUYHOSO = ?");
			criteria.add("A.DAXOA = 0");
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY A.NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				} else {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				}
			}
			
			if (Validator.isNotNull(maUngDung)) {
				q.setString(queryPos++, maUngDung);
			}
			
			if (cqqlId > 0) {
				 q.setLong(queryPos++, cqqlId);
			}
			
			q.setInteger(queryPos++, yeuCauRut);
			 
			return (List<HoSoTTHCCong>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/*
	 * @TODO Dem so uong ho so bang trang thai va thu tuc hanh chinh
	 */
	
	/**
	  * This is fucntion countByMutilStatusAndTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String tthcIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	  * @return int
	  */
	public int countByMutilStatusAndTTHC(
		String tthcIds,
		String maSoHoSo,
		long idCanBo,
		String maUngDung,
		long cqqlId,
		String trangThais,
		int yeuCauRut,
		String tuNgay,
		String denNgay,
		int start,
		int end
	) {

		Session session = null;
		try {
			session = openSession();
			String base = "SELECT * FROM CMON_HOSOTTHCCONG A ";
			StringBuffer sqlBuilder = new StringBuffer(base);
			List<String> criteria = new ArrayList<String>();
			
			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					criteria.add(" (A.MASOHOSO lIKE ? OR A.MASOBIENNHAN LIKE ? )");
				} else {
					criteria.add(
						" LOWER(REGEXP_REPLACE(TRIM(A.HOTENNGUOINOPHOSO),' +',' '))" +
						" LIKE" +
						" '%' || LOWER(REGEXP_REPLACE(TRIM(?),' +',' ')) || '%' "
					);
				}
			}
			
			if (tthcIds != null && tthcIds.length()> 0) {
				criteria.add("A.thutuchanhchinhid  IN (" + tthcIds +") ");
			}
			
			if(idCanBo > 0 && (!"0".equals(trangThais))){
				criteria.add("A.CANBOTIEPNHANID  = " + idCanBo +" ");
			}		
						
			if (Validator.isNotNull(maUngDung)) {
				criteria.add("A.MAUNGDUNG = ?");
			}
			
			
			 if (cqqlId > 0) {
				 criteria.add("A.thutuchanhchinhid in (select B.thutuchanhchinhid from cmon_tthc2coquanquanly B where B.COQUANQUANLYID = ? AND B.COQUANQUANLYID = A.COQUANTIEPNHANID)");
			}
			 
			if (trangThais != null && trangThais.length() > 0) {
				criteria.add("A.TRANGTHAIHOSO IN (" + trangThais + ") ");
			}
			
			if (Validator.isNotNull(tuNgay) && Validator.isNotNull(denNgay)) {
				criteria.add("A.NGAYNOPHOSO BETWEEN TO_DATE ('"+ tuNgay +"','dd/MM/yyyy') AND TO_DATE('"
					+ denNgay + "','dd/MM/yyyy') ");
					
			}
			criteria.add("A.YEUCAUHUYHOSO = ?");
			criteria.add("A.DAXOA = 0");
			
			if (!criteria.isEmpty()) {
				sqlBuilder.append("WHERE ");
				sqlBuilder.append(criteria.remove(0) + " ");
				for (String criterion : criteria) {
					sqlBuilder.append(" AND " + criterion);
				}
			}
			
			sqlBuilder.append(" ORDER BY A.NGAYSUA DESC NULLS LAST ");
			String sql = sqlBuilder.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("HoSoTTHCCong", HoSoTTHCCongImpl.class);
			int queryPos = 0;

			if (Validator.isNotNull(maSoHoSo)) {
				if (IsNumeral.check(maSoHoSo)) {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				} else {
					q.setString(queryPos++, "%" + maSoHoSo + "%");
				}
			}
			
			if (Validator.isNotNull(maUngDung)) {
				q.setString(queryPos++, maUngDung);
			}
			
			if (cqqlId > 0) {
				 q.setLong(queryPos++, cqqlId);
			}

			q.setInteger(queryPos++, yeuCauRut);
			 
			List<HoSoTTHCCong> list = q.list();
			return list.size();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		return 0;
	}
}
