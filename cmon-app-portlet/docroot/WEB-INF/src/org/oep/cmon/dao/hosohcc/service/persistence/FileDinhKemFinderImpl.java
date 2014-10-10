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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSoImpl;
import org.oep.cmon.dao.hosohcc.model.impl.FileDinhKemImpl;
import org.oep.egovcore.sqlutil.BeanSQLQuery;

import org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo;
import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.persistence.FileDinhKemFinder;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author win_64
 */
/**
*
* FileDinhKemFinderImpl class
*   
* This class is used to get FileDinhKem information 
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
public class FileDinhKemFinderImpl extends BasePersistenceImpl<FileDinhKem> implements FileDinhKemFinder {

	
	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long danhMucGiayToId
	  * @return List<>
	  */
	public List findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(long hoSoTTHCCongId, long danhMucGiayToId) {
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = " + hoSoTTHCCongId 
					+ " AND DANHMUCGIAYTOID = " + danhMucGiayToId ;
			
	
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);
			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FileDinhKem>();
		} finally {
			closeSession(session);
		}
    }
	
	/**
	  * This is fucntion getDSGiayToKhiBoSungHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HoSoTTHCCong
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(HoSoTTHCCong hoSo) throws Exception {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.hosohcc.FileDinhKem.getDSGiayToKhiBoSungHoSo");
		BeanSQLQuery<GiayToDinhKemHoSo> beanQuery = 
			new BeanSQLQuery<GiayToDinhKemHoSo>(GiayToDinhKemHoSoImpl.class, this, sql);
		beanQuery.setLong("hoSoId", hoSo.getId());
		beanQuery.setLong("thuTucId", hoSo.getThuTucHanhChinhId());
		beanQuery.setInteger("giaiDoanDauVao", Constants.GIAIDOAN_GIAYTO_DAUVAO);
		beanQuery.setInteger("giaiDoanXuLy", Constants.GIAIDOAN_DANGXULY);
		beanQuery.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return beanQuery.getBeanResult();
	}
	
	/**
	  * This is fucntion getDSGiayToPhienBanMoiNhatByHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(long hoSoId) throws Exception {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.hosohcc.FileDinhKem.getDSGiayToPhienBanMoiNhatByHoSo");
		BeanSQLQuery<GiayToDinhKemHoSo> beanQuery = 
			new BeanSQLQuery<GiayToDinhKemHoSo>(GiayToDinhKemHoSoImpl.class, this, sql);
		beanQuery.setLong("hoSoId", hoSoId);
		beanQuery.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return beanQuery.getBeanResult();
	}
	
	/**
	  * This is fucntion getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoId, int giaiDoan
	  * @return List<GiayToDinhKemHoSo>
	  */
	public List<GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(long hoSoId, int giaiDoan) throws Exception {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.hosohcc.FileDinhKem.getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan");
		BeanSQLQuery<GiayToDinhKemHoSo> beanQuery = 
			new BeanSQLQuery<GiayToDinhKemHoSo>(GiayToDinhKemHoSoImpl.class, this, sql);
		beanQuery.setLong("hoSoId", hoSoId);
		beanQuery.setInteger("giaiDoan", giaiDoan);
		beanQuery.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return beanQuery.getBeanResult();
	}
	
	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and NOILUUTRUTAILIEUID > 0 and thutuc2giaytoid in (select id from cmon_thutuc2giayto where giaidoan = ?) order BY ID ASC";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);
			qPos.add(giaiDoan);

			// execute the query and return a list from the db
			return (List<FileDinhKem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			//e.printStackTrace();
			
			return new ArrayList<FileDinhKem>();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	// add new function for tich hop lai xe
	/**
	  * This is fucntion findTaiLieuDinhKemTichHop 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<>
	  */
	public List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT NOILUUTRUTAILIEUID, DANHMUCGIAYTOID FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and NOILUUTRUTAILIEUID is not null";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);			

			// execute the query and return a list from the db
			return QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			//e.printStackTrace();
			
			return new ArrayList();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
    }
	
	/**
	  * This is fucntion findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, long thuTuc2GiayToId,long danhMucGiayToId
	  * @return FileDinhKem
	  */
	public FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(long hoSoTTHCCongId, long thuTuc2GiayToId,long danhMucGiayToId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from CMON_GIAYTODINHKEMHOSO gt where gt.ID =(select MAX(ID) from CMON_GIAYTODINHKEMHOSO gt where GT.HOSOTTHCCONGID =? and gt.THUTUC2GIAYTOID=? and GT.DANHMUCGIAYTOID =?)";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);
			qPos.add(thuTuc2GiayToId);
			qPos.add(danhMucGiayToId);

			// execute the query and return a list from the db
			return (FileDinhKem)QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/**
	  * This is fucntion findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and DATRA=1  and thutuc2giaytoid in (select id from cmon_thutuc2giayto where giaidoan = ?)";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);
			qPos.add(giaiDoan);

			// execute the query and return a list from the db
			return (List<FileDinhKem>) QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FileDinhKem>();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/**
	  * This is fucntion findFileDinhKemDifferent
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemDifferent(long hoSoTTHCCongId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "select * from CMON_GIAYTODINHKEMHOSO gt where GT.THUTUC2GIAYTOID is null  and GT.HOSOTTHCCONGID = ?  and gt.DANHMUCGIAYTOID is NULL";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);

			// execute the query and return a list from the db
			return (List<FileDinhKem>)QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		
		return null;
	}
	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(long hoSoTTHCCongId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and NOILUUTRUTAILIEUID > 0 and DANHMUCGIAYTOID is null and THUTUC2GIAYTOID is null";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);

			// execute the query and return a list from the db

			List<FileDinhKem> data = (List<FileDinhKem>)QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FileDinhKem>();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}
	
	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongId(long hoSoTTHCCongId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and NOILUUTRUTAILIEUID is not null and (thutuc2giaytoid is null or thutuc2giaytoid = '') and (danhmucgiaytoid is null or danhmucgiaytoid = '')";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);

			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FileDinhKem>();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}

	/**
	  * This is fucntion findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<FileDinhKem>
	  */
	public List<FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(long hoSoTTHCCongId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT * FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = ? and THUTUC2GIAYTOID in (select id from cmon_thutuc2giayto where giaidoan = 1 and daxoa = 0) AND DAXOA = 0";
			// Now that we have built the query, we can do all the usual stuff.
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("FileDinhKem", FileDinhKemImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(hoSoTTHCCongId);

			List data = QueryUtil.list(q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			// execute the query and return a list from the db
			return  data;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<FileDinhKem>();
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
	}

	/**
	  * This is fucntion findByHoSoTTHCCongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return List<>
	  */
	public List findByHoSoTTHCCongId(long hoSoTTHCCongId) throws SystemException {
        /// This stuff is basic set up
        Session session = null;
        try {
            session = openSession();
            // Here ends the basic set up; 

            //now we build the query. Note that we use the name of the tables from the database!
            String sql = "SELECT NOILUUTRUTAILIEUID FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = " + hoSoTTHCCongId;
            sql += " and (NOILUUTRUTAILIEUID is not null or NOILUUTRUTAILIEUID = '')";
            
            // Now that we have built the query, we can do all the usual stuff.
            SQLQuery q = session.createSQLQuery(sql);

            //execute the query and return a list from the db
            return q.list();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            closeSession(session);
        }

        return new ArrayList();
    }
	
	
	/**
	  * This is fucntion findFileUploadByHoSoTTHCCongIdAndGiaiDoan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, int giaiDoan
	  * @return List<>
	  */
	public List findFileUploadByHoSoTTHCCongIdAndGiaiDoan(long hoSoTTHCCongId, int giaiDoan) throws SystemException {
        /// This stuff is basic set up
        Session session = null;
        try {
            session = openSession();
            // Here ends the basic set up; 

            //now we build the query. Note that we use the name of the tables from the database!
            String sql = "SELECT NOILUUTRUTAILIEUID FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = " + hoSoTTHCCongId;
            sql += " and (NOILUUTRUTAILIEUID is not null or NOILUUTRUTAILIEUID = '') and thutuc2giaytoid in (select id from cmon_thutuc2giayto where giaidoan = " + giaiDoan + ")";
            
            // Now that we have built the query, we can do all the usual stuff.
            SQLQuery q = session.createSQLQuery(sql);

            //execute the query and return a list from the db
            return q.list();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            closeSession(session);
        }

        return new ArrayList();
    }
	
	/**
	  * This is fucntion findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thutuchanhchinhid, int giaiDoan
	  * @return List<>
	  */
	public List findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(long thutuchanhchinhid, int giaiDoan) throws SystemException {
        /// This stuff is basic set up
        Session session = null;
        try {
            session = openSession();
            // Here ends the basic set up; 

            //now we build the query. Note that we use the name of the tables from the database!
            //String sql = "select * from cmon_danhmucgiayto where id in (select danhmucgiaytoid from cmon_thutuc2giayto where giaidoan = " + giaiDoan + " and thutuchanhchinhid = " + thutuchanhchinhid + ")";
            String sql = "select d.id, d.ma, d.ten, d.gioihandungluong,d.kieutailieu, t.batbuoc, t.id from cmon_thutuc2giayto t left join cmon_danhmucgiayto d on t.danhmucgiaytoid = d.id where t.giaidoan = " + giaiDoan + " and t.thutuchanhchinhid = " + thutuchanhchinhid + " order by t.THUTUHIENTHI";
            
            // Now that we have built the query, we can do all the usual stuff.
            SQLQuery q = session.createSQLQuery(sql);

            //execute the query and return a list from the db
            List listDanhMucGiayTos = q.list();
            return listDanhMucGiayTos;
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            closeSession(session);
        }

        return new ArrayList();
    }
	
	/**
	  * This is fucntion findNoiLuuTruFileTraKetQua 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return Long
	  */
	public Long findNoiLuuTruFileTraKetQua(long hoSoTTHCCongId) throws SystemException {
		// / This stuff is basic set up
		Session session = null;
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT luutru.noiluutruid as ID FROM CMON_GIAYTODINHKEMHOSO dinhkem");
			sql.append(" JOIN CMON_THUTUC2GIAYTO tt2gt on tt2gt.id=dinhkem.thutuc2giaytoid");
			sql.append(" JOIN CMON_NOILUUTRUTAILIEU luutru on luutru.id=dinhkem.noiluutrutailieuid");
			sql.append(" WHERE  tt2gt.daxoa= ?");
			sql.append(" AND tt2gt.giaidoan= ?");
			sql.append(" AND dinhkem.hosotthccongid = ?");
			
			SQLQuery q = session.createSQLQuery(sql.toString());
			

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(org.oep.sharedservice.cmon.Constants.ACTIVATED);
			qPos.add(org.oep.sharedservice.cmon.Constants.STEP.STEP3);
			qPos.add(hoSoTTHCCongId);
		
			
			Iterator<Object> itr = (Iterator<Object>) QueryUtil.iterate(q,getDialect(), 0, 1);
            while (itr.hasNext()) {
				BigDecimal a= (BigDecimal)itr.next();
			
				return a.longValue();
				
			}
			
			
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			// must have this to close the hibernate session..
			// if you fail to do this.. you will have a lot of open sessions�
			closeSession(session);
		}
		return null;
	}
	
	/**
	  * This is fucntion findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId, String maLoaiTaiLieuDuocThayThe
	  * @return List<>
	  */
	public List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(long hoSoTTHCCongId, String maLoaiTaiLieuDuocThayThe) throws SystemException {
        /// This stuff is basic set up
        Session session = null;
        try {
            session = openSession();
            // Here ends the basic set up; 

            //now we build the query. Note that we use the name of the tables from the database!
            String sql = "SELECT NOILUUTRUTAILIEUID,THUTUC2GIAYTOID,DANHMUCGIAYTOID FROM CMON_GIAYTODINHKEMHOSO where HOSOTTHCCONGID = " + hoSoTTHCCongId;
            if (maLoaiTaiLieuDuocThayThe.trim().length() > 0) {
            	sql += " and MALOAITAILIEUDUOCTHAYTHE = '" + maLoaiTaiLieuDuocThayThe + "' order by NOILUUTRUTAILIEUID, THUTUC2GIAYTOID";
            } else {
            	sql += " and (MALOAITAILIEUDUOCTHAYTHE is null or MALOAITAILIEUDUOCTHAYTHE = '') and THUTUC2GIAYTOID in (select id from cmon_thutuc2giayto where giaidoan = 1) order by NOILUUTRUTAILIEUID, THUTUC2GIAYTOID";
            }
            

            // Now that we have built the query, we can do all the usual stuff.
            SQLQuery q = session.createSQLQuery(sql);

            //execute the query and return a list from the db
            return q.list();
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            closeSession(session);
        }

        return new ArrayList();
    }

}
