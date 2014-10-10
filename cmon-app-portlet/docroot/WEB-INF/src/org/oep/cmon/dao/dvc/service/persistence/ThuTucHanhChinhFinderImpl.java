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

package org.oep.cmon.dao.dvc.service.persistence;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTucImpl;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuanImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTuc2GiayToImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.model.impl.VanBanHuongDanImpl;
import org.oep.egovcore.sqlutil.BeanSQLQuery;

import org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc;
import org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan;
import org.oep.cmon.dao.cc.model.CongChuc;
import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.VanBanHuongDan;
import org.oep.cmon.dao.dvc.service.persistence.ThuTucHanhChinhFinder;
import org.oep.cmon.dao.thamso.service.ThamSoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;


/**
*
* ThuTucHanhChinhFinderImpl class
*   
* This class is used to get ThuTucHanhChinh information 
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
@SuppressWarnings("unchecked")
public class ThuTucHanhChinhFinderImpl extends BasePersistenceImpl<ThuTucHanhChinh> implements ThuTucHanhChinhFinder{
	
	
	/**
	  * This is fucntion get ThongTinThuTuc by ungDungId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long ungDungId
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucByUngDung(long ungDungId) throws Exception {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTucByUngDung");
		BeanSQLQuery<ThongTinThuTuc> query 
			= new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
		query.setLong("ungDungId", ungDungId);
		query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return query.getBeanResult();
	}
	
	/**
	  * This is fucntion fetch ThongTinThuTuc2CoQuan by thuTucId, coQuanId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucId, long coQuanId
	  * @return ThongTinThuTuc2CoQuan
	  */
	public ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(long thuTucId, long coQuanId) throws Exception {
		
		String maUngDungCongAn = ThamSoLocalServiceUtil.getValue(Constants.TEN_THAMSO_MA_UNG_DUNG_CONG_AN);
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.fetchThongTinThuTuc2CoQuan");
		
		BeanSQLQuery<ThongTinThuTuc2CoQuan> query 
			= new BeanSQLQuery<ThongTinThuTuc2CoQuan>(ThongTinThuTuc2CoQuanImpl.class, this, sql);
		
		query.setString("maUngDungCongAn", maUngDungCongAn);
		query.setLong("thuTucId", thuTucId);
		query.setLong("coQuanId", coQuanId);
		query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ThongTinThuTuc2CoQuan> ds = query.getBeanResult();
		
		ThongTinThuTuc2CoQuan out = null;
		if (! ds.isEmpty() ) {
			out = ds.get(0);
		}
		
		return out;
	}
	
	protected static final Log _log = LogFactoryUtil.getLog(ThuTucHanhChinhFinderImpl.class);
	
	/**
	  * This is fucntion get ThongTinThuTuc by CongChuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTuc2CanBo(CongChuc canBo) throws Exception {

		// Get theo cau hinh CongChuc2NhomThuTucHanhChinh
		long coQuanId = canBo.getCoQuanQuanLyId();
		String maUngDungChungThuc = ThamSoLocalServiceUtil.getValue(Constants.TEN_THAMSO_MA_UNG_DUNG_CHUNG_THUC);
		
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTuc2CanBo");
		BeanSQLQuery<ThongTinThuTuc> query 
			= new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
		
		query.setLong("canBoId", canBo.getId());
		query.setLong("coQuanId", coQuanId);
		query.setString("maUngDungChungThuc", maUngDungChungThuc);
		query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<ThongTinThuTuc> ds = query.getBeanResult();
		
		// Truong hop can' bo. chua duoc cau hinh CongChuc2NhomThuTucHanhChinh
        // thi se get nhung thu tuc da duoc cau hinh cho co quan cua can' bo.
		if (ds.isEmpty()) {
			sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTuc2CoQuan");
			query = new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
			query.setLong("coQuanId", coQuanId);
			query.setString("maUngDungChungThuc", maUngDungChungThuc);
			query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			ds = query.getBeanResult();
		}
		
		return ds;
	}
	
	/**
	  * This is fucntion get ThongTinThuTuc by CongChuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(CongChuc canBo) throws Exception {
		
		// SQL1, get theo cau hinh CongChuc2NhomThuTucHanhChinh
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTucLienThongNoiGui2CanBo");
		long coQuanId = canBo.getCoQuanQuanLyId();
		BeanSQLQuery<ThongTinThuTuc> query 
			= new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
        query.setLong("canBoId", canBo.getId());
        query.setLong("coQuanId", coQuanId);
        query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        List<ThongTinThuTuc> out = query.getBeanResult();
        
        // Truong hop can' bo. chua duoc cau hinh CongChuc2NhomThuTucHanhChinh
        // Thi se get nhung thu tuc da duoc cau hinh cho co quan cua can' bo.
        if (out.isEmpty()) {
        	sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTucLienThongNoiGui2CoQuan");
        	query = new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
        	query.setLong("coQuanId", coQuanId);
            query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            out = query.getBeanResult();
        }
        
        return out;
	}
	
	/**
	  * This is fucntion get ThongTinThuTuc by CongChuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param CongChuc canBo
	  * @return List<ThongTinThuTuc>
	  */
	public List<ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(CongChuc canBo) throws Exception {
		
		// SQL1, get theo cau hinh CongChuc2NhomThuTucHanhChinh
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTucLienThongNoiNhan2CanBo");
		long coQuanId = canBo.getCoQuanQuanLyId();
		BeanSQLQuery<ThongTinThuTuc> query 
			= new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
        query.setLong("canBoId", canBo.getId());
        query.setLong("coQuanId", coQuanId);
        query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        List<ThongTinThuTuc> out = query.getBeanResult();
        
        // Truong hop can' bo. chua duoc cau hinh CongChuc2NhomThuTucHanhChinh
        // Thi se get nhung thu tuc da duoc cau hinh cho co quan cua can' bo.
        if (out.isEmpty()) {
        	sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThongTinThuTucLienThongNoiNhan2CoQuan");
        	query = new BeanSQLQuery<ThongTinThuTuc>(ThongTinThuTucImpl.class, this, sql);
            query.setLong("coQuanId", coQuanId);
            query.query(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            out = query.getBeanResult();
        }
        
        return out;
	}
	
	/**
	  * This is fucntion count by coQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId
	  * @return long
	  */
	public long countByCQQL(long coQuanQuanLyId) {
        String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.countThuTucByCQQL");
        Session session = openSession();
        SQLQuery query = session.createSQLQuery(sql);
        query.setLong("coQuanQuanLyId", coQuanQuanLyId);
        query.addScalar("total_", Type.LONG);
        long out = (Long) query.uniqueResult();
        closeSession(session);
        return out;
	}
	
	/**
	  * This is fucntion get ThuTucHanhChinh by coQuanQuanLyId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getListTTHCByCQQL(long coQuanQuanLyId) {
		String sql = CustomSQLUtil.get("org.oep.cmon.dao.dvc.getDSThuTucByCQQL");
		Session session = openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.setLong("coQuanQuanLyId", coQuanQuanLyId);
		query.addEntity(ThuTucHanhChinh.class.getSimpleName(), ThuTucHanhChinhImpl.class);
		List<ThuTucHanhChinh> out = (List<ThuTucHanhChinh>)
			QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		closeSession(session);
		return out;
	}
	/**
	  * This is fucntion search ThuTucHanhChinh by ungDungId, nhomId,param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long ungDungId,Long nhomId,int start,int end
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> searchByUngDungOrNhom(Long ungDungId,Long nhomId,int start,int end) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT tt.ID,tt.MA,tt.TEN,tt.TRANGTHAI,ungdung.MA as MAUNGDUNG FROM CMON_THUTUCHANHCHINH tt");
            sql.append(" JOIN CMON_NHOMTHUTUCHANHCHINH nhom on nhom.id = tt.nhomthutuchanhchinhid");
            sql.append(" join CMON_DANHMUCUNGDUNG ungdung on ungdung.id=nhom.danhmucungdungid");
            sql.append(" WHERE tt.daXoa=0 ");
            if(ungDungId != null){
            	sql.append(" AND ungdung.id=? ");
            }
            if(nhomId !=null ){
            	sql.append(" AND nhom.id=? ");
            }
           
            sql.append(" ORDER BY tt.ten ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("ID", Type.LONG);
			q.addScalar("MA", Type.STRING);
			q.addScalar("TEN", Type.STRING);
			q.addScalar("TRANGTHAI", Type.INTEGER);
			q.addScalar("MAUNGDUNG", Type.STRING);
			
			
            QueryPos qPos = QueryPos.getInstance(q);
            if(ungDungId != null){
            	qPos.add(ungDungId);	   
            }
            if(nhomId !=null ){
            	qPos.add(nhomId);	   
            }
            
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<ThuTucHanhChinh> result = new ArrayList<ThuTucHanhChinh>();
			while (itr.hasNext()) {
				try{
					Object[] a= itr.next();
					ThuTucHanhChinh t = new ThuTucHanhChinhImpl();
					t.setId((Long)a[0]);
					t.setMa((String)a[1]);
					t.setTen((String)a[2]);
					t.setTrangThai((Integer)a[3]);
					t.setNguoiTao((String)a[4]);
					result.add(t);
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			return result;
			
             
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	/**
	  * This is fucntion count by ungDungId, nhomId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long ungDungId,Long nhomId
	  * @return long
	  */
	public long countByUngDungOrNhom(Long ungDungId,Long nhomId) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT COUNT(*) AS TOTAL FROM CMON_THUTUCHANHCHINH tt");
            sql.append(" JOIN CMON_NHOMTHUTUCHANHCHINH nhom on nhom.id = tt.nhomthutuchanhchinhid");
            sql.append(" join CMON_DANHMUCUNGDUNG ungdung on ungdung.id=nhom.danhmucungdungid");
            sql.append(" WHERE tt.daXoa=0 ");
            if(ungDungId != null){
            	sql.append(" AND ungdung.id=? ");
            }
            if(nhomId !=null ){
            	sql.append(" AND nhom.id=? ");
            }
           
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TOTAL", Type.LONG);
            QueryPos qPos = QueryPos.getInstance(q);
            if(ungDungId != null){
            	qPos.add(ungDungId);	   
            }
            if(nhomId !=null ){
            	qPos.add(nhomId);	   
            }
             
            
            
            Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long value = itr.next();

				if (value != null) {
					return value;
				}
			}

			
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
        return 0;
	}
	/**
	  * This is fucntion search ThuTuc2GiayTo by tthcid, dgId,daXoa, param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid, Long dgId, Integer daXoa, int start,int end
	  * @return List<ThuTuc2GiayTo>
	  */
	public List<ThuTuc2GiayTo> searchByTTHCIdOrGDId(Long tthcid, Long dgId, Integer daXoa, int start,int end) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT tt2gt.id AS ID , gt.ten AS TEN,  tt2gt.batbuoc AS BATBUOC, ");
            sql.append(" tt2gt.giaidoan AS GIAIDOAN, tt2gt.thutuhienthi AS THUTUHIENTHI, ");
            sql.append(" tt2gt.trangthai as TRANGTHAI, tt2gt.danhmucgiaytoid as danhmucgiaytoid, tt2gt.thutuchanhchinhid as thutuchanhchinhid ");          
            sql.append(" FROM cmon_thutuc2giayto tt2gt ");
            sql.append(" Join cmon_danhmucgiayto gt on gt.id=tt2gt.danhmucgiaytoid");
            sql.append(" Join cmon_thutuchanhchinh tthc on tthc.id=tt2gt.thutuchanhchinhid");
            sql.append(" WHERE 1=1 ");
            if(tthcid != null){
            	sql.append(" AND tt2gt.thutuchanhchinhid=? ");
            }
            if(dgId !=null ){
            	sql.append(" AND tt2gt.giaidoan=? ");
            }
            if(daXoa !=null ){
            	sql.append(" AND tt2gt.daxoa=? ");
            }
           
            sql.append(" ORDER BY tt2gt.thutuhienthi ASC");
            

            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("BATBUOC", Type.INTEGER);
            q.addScalar("GIAIDOAN", Type.INTEGER);
            q.addScalar("THUTUHIENTHI", Type.LONG);
            q.addScalar("TRANGTHAI", Type.STRING);
            q.addScalar("danhmucgiaytoid", Type.LONG);
            q.addScalar("thutuchanhchinhid", Type.LONG);
            
            int queryPos =0;
            if(tthcid != null){
            	 q.setLong(queryPos++, tthcid);	   
            }
            if(dgId !=null ){
            	 q.setLong(queryPos++, dgId);	   
            }
            if(daXoa !=null ){
           	 q.setLong(queryPos++, daXoa);	   
           }
            Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
            List<ThuTuc2GiayTo> result = new ArrayList<ThuTuc2GiayTo>();
			while (itr.hasNext()) {
				Object[] a= itr.next();
				ThuTuc2GiayTo t = new ThuTuc2GiayToImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setNguoiTao((String)a[1]);
				t.setBatBuoc(Integer.valueOf(a[2].toString()));
				t.setGiaidoan(Integer.valueOf(a[3].toString()));
				t.setThuTuHienThi(Long.valueOf(a[4].toString()));
				t.setTrangThai(Integer.parseInt(a[5].toString()));
				t.setDanhMucGiayToId(Long.valueOf(a[6].toString()));
				t.setThuTucHanhChinhId(Long.valueOf(a[7].toString()));
				result.add(t);
			}
			return result;
			
             
            
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
	}
	
	
	/**
	  * This is fucntion count   by tthcid, dgId,daXoa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long tthcid, Long dgId, Integer daXoa
	  * @return long
	  */
	public long countByTTHCIdOrGDId(Long tthcid, Long dgId, Integer daXoa) throws SystemException{
		Session session = null;
        try {  
            session = openSession();
            
            StringBuffer sql = new StringBuffer("");
            sql.append(" SELECT COUNT(*) AS TOTAL FROM cmon_thutuc2giayto tt2gt ");
            sql.append(" Join cmon_danhmucgiayto gt on gt.id=tt2gt.danhmucgiaytoid");
            sql.append(" Join cmon_thutuchanhchinh tthc on tthc.id=tt2gt.thutuchanhchinhid");
            sql.append(" WHERE 1=1 ");
            
            if(tthcid != null){
            	sql.append(" AND tt2gt.thutuchanhchinhid=? ");
            }
            if(dgId !=null ){
            	sql.append(" AND tt2gt.giaidoan=? ");
            }
            if(daXoa !=null ){
            	sql.append(" AND tt2gt.daxoa=? ");
            }
            SQLQuery q = session.createSQLQuery(sql.toString());
            q.addScalar("TOTAL", Type.LONG);
            QueryPos qPos = QueryPos.getInstance(q);
            if(tthcid != null){
            	qPos.add(tthcid);	   
            }
            if(dgId !=null ){
            	qPos.add(dgId);	   
            }
            
            if(daXoa !=null ){
            	qPos.add(daXoa);	   
            }
            
            Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long value = itr.next();

				if (value != null) {
					return value;
				}
			}

			
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            
            closeSession(session);  
        }  		
        return 0;
	}
	/**
	  * This is fucntion get ThuTucHanhChinh by coQuanQuanLyId, ma
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, String ma
	  * @return List<ThuTucHanhChinh>
	  */
	public List<ThuTucHanhChinh> getListTTHCByCQQLAndMa(long coQuanQuanLyId, String ma) throws SystemException{
        Session session = null;
        try {  
            session = openSession();
            String base = "SELECT * FROM CMON_THUTUCHANHCHINH  " ;  
            StringBuffer sqlBuilder = new StringBuffer(base);  
            List<String> criteria = new ArrayList<String>();
            criteria.add(" MA like '%" + ma + "%' and id in (select thutuchanhchinhid from cmon_tthc2coquanquanly where daXoa=0 AND COQUANQUANLYID = ?)");  
            
            if (!criteria.isEmpty()) {  
                sqlBuilder.append("WHERE ");  
                sqlBuilder.append(criteria.remove(0) + " ");  
                for (String criterion : criteria) {  
                    sqlBuilder.append(" AND "+criterion);  
                }  
            } 
            sqlBuilder.append(" ORDER BY ID DESC");
            String sql = sqlBuilder.toString(); 
            SQLQuery q = session.createSQLQuery(sql);
            q.addEntity("ThuTucHanhChinh", ThuTucHanhChinhImpl.class);
            int queryPos =0;
          //  if (coQuanQuanLyId > 0) {  
            	q.setLong(queryPos++, coQuanQuanLyId);	            	
           // }
            return  (List<ThuTucHanhChinh>)QueryUtil.list(q, getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);  
        } catch (Exception e) {  
            throw new SystemException(e);  
        } finally {  
            //must have this to close the hibernate session..  
            // if you fail to do this.. you will have a lot of open sessions�   
            closeSession(session);  
        }  		
	}
	//Huong dan va Bieu Mau
	
	/**
	  * This is fucntion search VanBanHuongDan by tthcid, loaiTL,daXoa,param paging
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Long tthcid, Long loaiTL, Integer daXoa, int start,int end
	  * @return List<VanBanHuongDan>
	  */
		public List<VanBanHuongDan> searchByTTHC2HDBM(Long tthcid, Long loaiTL, Integer daXoa, int start,int end) throws SystemException{
			Session session = null;
	        try {  
	            session = openSession();
	            
	            StringBuffer sql = new StringBuffer("");
	            sql.append(" SELECT vb.id as ID, vb.tentailieu as tentailieu, vb.loaitailieu as loaitailieu, vb.noiluutruid as noiluutruid, vb.thutuchanhchinhid as thutuchanhchinhid from cmon_vanbanhuongdan vb");   
	            sql.append(" Join cmon_thutuchanhchinh tthc on tthc.id=vb.thutuchanhchinhid");
	            sql.append(" WHERE 1=1 ");
	            if(tthcid != null){
	            	sql.append(" AND vb.thutuchanhchinhid=? ");
	            }
	            if(loaiTL !=null ){
	            	sql.append(" AND vb.loaitailieu=? ");
	            }
	            if(daXoa !=null ){
	            	sql.append(" AND vb.daxoa=? ");
	            }
	           
	            sql.append(" ORDER BY vb.tentailieu ASC");
	            

	            SQLQuery q = session.createSQLQuery(sql.toString());
	            q.addScalar("ID", Type.LONG);
	            q.addScalar("tentailieu", Type.STRING);
	            q.addScalar("loaitailieu", Type.LONG);
	            q.addScalar("noiluutruid", Type.LONG);
	            q.addScalar("thutuchanhchinhid", Type.LONG);
	            
	            int queryPos =0;
	            if(tthcid != null){
	            	 q.setLong(queryPos++, tthcid);	   
	            }
	            if(loaiTL !=null ){
	            	 q.setLong(queryPos++, loaiTL);	   
	            }
	            if(daXoa !=null ){
	           	 q.setLong(queryPos++, daXoa);	   
	           }
	            Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
	            List<VanBanHuongDan> result = new ArrayList<VanBanHuongDan>();
				while (itr.hasNext()) {
					Object[] a= itr.next();
					VanBanHuongDan t = new VanBanHuongDanImpl();
					t.setId(Long.valueOf(a[0].toString()));				
					t.setTenTaiLieu((String)a[1]);
					t.setLoaiTaiLieu(Long.valueOf(a[2].toString()));			
					t.setNoiLuuTruId(Long.valueOf(a[3].toString()));			
					t.setThuTucHanhChinhId(Long.valueOf(a[4].toString()));
					result.add(t);
				}
				return result;
				
	             
	            
	        } catch (Exception e) {  
	            throw new SystemException(e);  
	        } finally {  
	            
	            closeSession(session);  
	        }  		
		}
		
		
		/**
		  * This is fucntion count  by tthcid, loaiTL,daXoa
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param Long tthcid, Long loaiTL, Integer daXoa
		  * @return long
		  */
		public long countByTTHC2HDBM(Long tthcid, Long loaiTL, Integer daXoa) throws SystemException{
			Session session = null;
	        try {  
	            session = openSession();
	            
	            StringBuffer sql = new StringBuffer("");
	            sql.append(" SELECT COUNT(*) AS TOTAL from cmon_vanbanhuongdan vb ");
	            sql.append(" Join cmon_thutuchanhchinh tthc on tthc.id=vb.thutuchanhchinhid");            
	            sql.append(" WHERE 1=1 ");
	            
	            if(tthcid != null){
	            	sql.append(" AND vb.thutuchanhchinhid=? ");
	            }
	            if(loaiTL !=null ){
	            	sql.append(" AND vb.loaitailieu=? ");
	            }
	            if(daXoa !=null ){
	            	sql.append(" AND vb.daxoa=? ");
	            }
	            
	            SQLQuery q = session.createSQLQuery(sql.toString());
	            q.addScalar("TOTAL", Type.LONG);
	            QueryPos qPos = QueryPos.getInstance(q);
	            if(tthcid != null){
	            	qPos.add(tthcid);	   
	            }
	            if(loaiTL !=null ){
	            	qPos.add(loaiTL);	   
	            }
	            
	            if(daXoa !=null ){
	            	qPos.add(daXoa);	   
	            }
	            
	            Iterator<Long> itr = q.iterate();

				if (itr.hasNext()) {
					Long value = itr.next();

					if (value != null) {
						return value;
					}
				}

				
	        } catch (Exception e) {  
	            throw new SystemException(e);  
	        } finally {  
	            
	            closeSession(session);  
	        }  		
	        return 0;
		}
		
		/**
		  * This is fucntion get CapCoQuanQuanLy by thuTucHanhChinhId,param paging 
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param long thuTucHanhChinhId,  int start, int end
		  * @return List<CapCoQuanQuanLy>
		  */
		public List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(long thuTucHanhChinhId,  int start, int end) throws SystemException {
			Session session = null;
			try {
				session = openSession();
				StringBuilder query = new StringBuilder();
				query.append("select cmon_capcoquanquanly.ten from cmon_thutuchanhchinh, cmon_capcoquanquanly  where cmon_thutuchanhchinh.capcoquanquanlyid = cmon_capcoquanquanly.id and cmon_thutuchanhchinh.id = "+thuTucHanhChinhId);
				String sql = query.toString();
				
			
				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("CapCoQuanQuanLy",org.oep.cmon.dao.qlhc.model.impl.CapCoQuanQuanLyImpl.class);
				 
				// execute the query and return a list from the db
				return (List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy>) QueryUtil.list(q, getDialect(),  start,end);
			} catch (Exception e) {
				throw new SystemException(e);
			} finally {
				closeSession(session);
			}
		}
		
		/**
		  * This is fucntion find DoiTuongSuDung by thuTucHanhChinhId,param paging 
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param long thuTucHanhChinhId,  int start, int end
		  * @return List<DoiTuongSuDung>
		  */
		public List <org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(long thuTucHanhChinhId,  int start, int end) throws SystemException {
			Session session = null;
			try {
				session = openSession();
				StringBuilder query = new StringBuilder();
				query.append("select cmon_loaidoituong.ten from CMON_TTHC2DOITUONGSUDUNG , cmon_loaidoituong  where CMON_TTHC2DOITUONGSUDUNG.thutuchanhchinhid = "+thuTucHanhChinhId+" and CMON_TTHC2DOITUONGSUDUNG.loaidoituongid = cmon_loaidoituong.id");
				String sql = query.toString();
				
				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("DoiTuongSuDung",org.oep.cmon.dao.dvc.model.impl.DoiTuongSuDungImpl.class);
				 
				// execute the query and return a list from the db
				return (List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung>) QueryUtil.list(q, getDialect(),  start,end);
			} catch (Exception e) {
				throw new SystemException(e);
			} finally {
				closeSession(session);
			}
		}
		
		/**
		  * This is fucntion get DanhMucGiayTo by thuTucHanhChinhId,param paging 
		  * Version: 1.0
		  *  
		  * History: 
		  *   DATE        AUTHOR      DESCRIPTION 
		  *  ------------------------------------------------- 
		  *  3-March-2013  Nam Dinh    Create new
		  * @param long thuTucHanhChinhId,  int start, int end
		  * @return List<DanhMucGiayTo>
		  */
		public List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(long thuTucHanhChinhId,  int start, int end) throws SystemException {
			Session session = null;
			try {
				session = openSession();
				StringBuilder query = new StringBuilder();
				query.append("Select ten from cmon_DANHMUCGIAYTO WHERE ID IN (select danhmucgiaytoid from cmon_thutuc2giayto " +
						" where thutuchanhchinhid = "+thuTucHanhChinhId+" and giaidoan = 3 and danhmucgiaytoid <> 	" +
								"(select to_number(giatri) from cmon_thamso where ten = 'GT_CONGVANTRALOIKHONGDUDK'))");
				String sql = query.toString();
				
				SQLQuery q = session.createSQLQuery(sql);
				q.setCacheable(false);
				q.addEntity("DanhMucGiayTo",org.oep.cmon.dao.tlct.model.impl.DanhMucGiayToImpl.class);
				 
				// execute the query and return a list from the db
				return (List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>) QueryUtil.list(q, getDialect(),  start,end);
			} catch (Exception e) {
				throw new SystemException(e);
			} finally {
				closeSession(session);
			}
		}
		
}
