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

package org.oep.cmon.dao.tlct.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.tlct.model.impl.TaiLieuChungThucImpl;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;
import org.oep.cmon.dao.tlct.service.persistence.TaiLieuChungThucFinder;

import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* TaiLieuChungThucFinderImpl class
*   
* This class is used to get TaiLieuChungThuc information 
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
public class TaiLieuChungThucFinderImpl  extends BasePersistenceImpl<TaiLieuChungThuc>
implements TaiLieuChungThucFinder {
	
	/**
	  * This is fucntion isUsed
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long id
	  * @return long
	  */
	public long isUsed(Long id) {
		// TODO Auto-generated method stub

		Session session = null;
		
	try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(*) AS TOTAL FROM CMON_GIAYTODINHKEMHOSO WHERE NOILUUTRUTAILIEUID=?");
			
			
			
			SQLQuery q = session.createSQLQuery(sql.toString());			
			q.addScalar("TOTAL", Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);			
			qPos.add(id);		
			int rows = 0;
			Iterator<Long> itr = q.iterate();
			if (itr.hasNext()) {
				Long count = itr.next();
				if (count != null) {
					rows= count.intValue();
				}
			}
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}
		return 0;
	}
	
	/**
	  * This is fucntion getMaxVersion
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long userId,Long giayToId
	  * @return int
	  */
	public int getMaxVersion(Long userId,Long giayToId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = null;
				StringBuffer sql = new StringBuffer();
				
				try {
					session = openSession();
					sql.append("SELECT d  from TaiLieuChungThuc d ");
					sql.append(" WHERE d.danhMucGiayToId = ? ");
					sql.append(" AND d.chuSohuuId = ? ");
					sql.append(" ORDER BY d.phienBan DESC ");
					
					
					Query q = session.createQuery(sql.toString());
					QueryPos qPos = QueryPos.getInstance(q);
								
					qPos.add(giayToId);
					qPos.add(userId);
					
					List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>)QueryUtil.list(q, getDialect(),0, 2, false);
					if(list != null && list.size()>0){
						
						return list.get(0).getPhienBan();
					}
					
						
				
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					
					closeSession(session);
				}
			

				return 0;
	}
	
	/**
	  * This is fucntion getLastVersion 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long userId,Long giayToId
	  * @return TaiLieuChungThuc
	  */
	public TaiLieuChungThuc getLastVersion(Long userId,Long giayToId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = null;
				StringBuffer sql = new StringBuffer();
				
				try {
					session = openSession();
					sql.append("SELECT d  from TaiLieuChungThuc d ");
					sql.append(" WHERE d.danhMucGiayToId = ? ");
					sql.append(" AND d.chuSohuuId = ? ");
					sql.append(" ORDER BY d.phienBan DESC ");
					
					
					Query q = session.createQuery(sql.toString());
					
					QueryPos qPos = QueryPos.getInstance(q);
								
					qPos.add(giayToId);
					qPos.add(userId);
					
					List<TaiLieuChungThuc> list = (List<TaiLieuChungThuc>)QueryUtil.list(q, getDialect(),0, 2, false);
					if(list != null && list.size()>0){
						
						return list.get(0);
					}
					
						
				
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					
					closeSession(session);
				}
			

				return null;
	}
	
	/**
	  * This is fucntion findByHoSoId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long hosoId
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> findByHoSoId(Long hosoId)
	{
		Session session = null;
		StringBuffer sql = new StringBuffer();
		List<TaiLieuChungThuc> list = new ArrayList<TaiLieuChungThuc>();
		try {
			session = openSession();
			sql.append("SELECT d  from TaiLieuChungThuc d ");
			sql.append(" WHERE d.hoSoTTHCCId = ? ");
			sql.append(" AND d.danhMucGiayToId is null ");
			sql.append(" AND d.trangThai = 0 ");
			sql.append(" ORDER BY d.id DESC ");
			
			
			Query q = session.createQuery(sql.toString());
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);					
			qPos.add(hosoId);
			list = (List<TaiLieuChungThuc>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS,
					 QueryUtil.ALL_POS, false);
			return list;	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeSession(session);
			return list;
		}	

	}
	/**
	  * This is fucntion findTaiLieuXuLyByHoSoAndLoai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hosoId,int loai
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(long hosoId,int loai)
	{
		Session session = null;
		List<TaiLieuChungThuc> list  = null;
		String query ="select * from CMON_NOILUUTRUTAILIEU nlt where nlt.HOSOTTHCCONGID =? and NLT.LOAI=?";
		try {
			session = openSession();
			
			SQLQuery q = session.createSQLQuery(query);
			q.setCacheable(false);
			q.addEntity("TaiLieuChungThuc", TaiLieuChungThucImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);	
			qPos.add(hosoId);
			qPos.add(loai);
			
			list = (List<TaiLieuChungThuc>) QueryUtil.list(q, getDialect(),  QueryUtil.ALL_POS,
					 QueryUtil.ALL_POS, false);
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeSession(session);
			return list;
		}	

	}
	
	/**
	  * This is fucntion searchByCongDanId2DanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group,	Long congDanId, Long doiTuongId, int start, int end
	  * @return List<TaiLieuChungThuc>
	  */
	public List<TaiLieuChungThuc> searchByCongDanId2DanhMucGiayTo(String group,	Long congDanId, Long doiTuongId, int start, int end) {
		// TODO Auto-generated method stub
		Session session = null;
		List<TaiLieuChungThuc> list = new ArrayList<TaiLieuChungThuc>();
		try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT DISTINCT nlttl.ID AS ID, dmgt.TEN AS TEN, dmgt.MA AS MA, nlttl.TRANGTHAI " 
					+", nlttl.NGAYUPLOAD,  nlttl.hieuluctungay, nlttl.hieulucdenngay, nlttl.DANHMUCGIAYTOID, nlttl.noiluutruid,nlttl.phienban as PHIENBAN "
					+ " FROM CMON_NOILUUTRUTAILIEU nlttl "
					+ " INNER JOIN CMON_DANHMUCGIAYTO dmgt ON dmgt.ID=nlttl.DANHMUCGIAYTOID "
					+ " LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID "
					+ " LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID "
					+ " WHERE dmgt.daxoa=0 and dtgt.daxoa=0 and dtgt.trangthai=1 and dt.daxoa=0");
			
			if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(congDanId)) {
				sql.append(" AND nlttl.chusohuuId = ?");
				sql.append(" AND ( nlttl.danhmucgiaytoid, nlttl.phienban ) IN ( SELECT danhmucgiaytoid, MAX(phienban) FROM cmon_noiluutrutailieu where chusohuuid=? GROUP BY danhmucgiaytoid ) ");
			}
			if (Validator.isNotNull(doiTuongId)) {
				sql.append(" AND dt.id = ?");
			}
			
			sql.append(" ORDER BY nlttl.NGAYUPLOAD DESC, LOWER(dmgt.TEN) ASC ");
		
			SQLQuery q = session.createSQLQuery(sql.toString());
			q.addScalar("ID", Type.LONG);
            q.addScalar("TEN", Type.STRING);
            q.addScalar("MA", Type.STRING);
            q.addScalar("TRANGTHAI", Type.INTEGER);
            q.addScalar("NGAYUPLOAD", Type.DATE);
            q.addScalar("HIEULUCTUNGAY", Type.DATE);
            q.addScalar("HIEULUCDENNGAY", Type.DATE);
            q.addScalar("DANHMUCGIAYTOID", Type.LONG);
            q.addScalar("NOILUUTRUID", Type.LONG);
            q.addScalar("PHIENBAN", Type.INTEGER);

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
			}
			if (Validator.isNotNull(congDanId)) {
				qPos.add(congDanId);
				qPos.add(congDanId);
			}
		
			if (Validator.isNotNull(doiTuongId)) {
				qPos.add(doiTuongId);
			}
			
			Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(), start, end);
			while (itr.hasNext()) {
				Object[] a= itr.next();
				TaiLieuChungThuc t=new TaiLieuChungThucImpl();
				t.setId(Long.valueOf(a[0].toString()));				
				t.setTen((String)a[1]);
				t.setGhiChu(a[2].toString());	
				t.setTrangThai(Integer.valueOf(a[3].toString()));
				t.setNgayUpload((java.util.Date)a[4]);
				t.setHieuLucTuNgay((java.util.Date)a[5]);
				t.setHieuLucDenNgay((java.util.Date)a[6]);
				t.setDanhMucGiayToId(Long.valueOf(a[7].toString()));	
				t.setNoiLuuTruId(Long.valueOf(a[8].toString()));
				t.setPhienBan(Integer.valueOf(a[9].toString()));
				list.add(t);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}		return list;
	}

	/**
	  * This is fucntion countByCongDanId2DanhMucGiayTo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String group, Long congDanId, Long doiTuongId
	  * @return long
	  */
	@Override
	public long countByCongDanId2DanhMucGiayTo(String group, Long congDanId, Long doiTuongId) {
		// TODO Auto-generated method stub

		Session session = null;
		
	try {
			session = openSession();
			StringBuffer sql = new StringBuffer("");
			sql.append(" SELECT COUNT(DISTINCT nlttl.ID) AS TOTAL FROM CMON_NOILUUTRUTAILIEU nlttl "
					+ " INNER JOIN CMON_DANHMUCGIAYTO dmgt ON dmgt.ID=nlttl.DANHMUCGIAYTOID "
					+ " LEFT JOIN CMON_DMGIAYTO2DOITUONGSUDUNG dtgt ON dtgt.LOAIGIAYTOID=dmgt.ID "
					+ " LEFT JOIN CMON_LOAIDOITUONG dt ON dt.ID=dtgt.LOAIDOITUONGID "
					+ " WHERE dmgt.daxoa=0 and dtgt.daxoa=0 and dtgt.trangthai=1 and dt.daxoa=0");
			
			if (Validator.isNotNull(group)) {
				sql.append(" AND (LOWER(dmgt.TEN) like LOWER(?) OR LOWER(dmgt.MA) like LOWER(?) )");
			}
			if (Validator.isNotNull(congDanId)) {
				sql.append(" AND nlttl.chusohuuId = ?");
				sql.append(" AND ( nlttl.danhmucgiaytoid, nlttl.phienban ) IN  ( SELECT danhmucgiaytoid, MAX(phienban) FROM cmon_noiluutrutailieu WHERE chusohuuid=? GROUP BY danhmucgiaytoid ) ");
			}
			if (Validator.isNotNull(doiTuongId)) {
				sql.append(" AND dt.id = ?");
			}
			
			SQLQuery q = session.createSQLQuery(sql.toString());			
			q.addScalar("TOTAL", Type.LONG);
			

			QueryPos qPos = QueryPos.getInstance(q);
			
			if (Validator.isNotNull(group)) {
				qPos.add("%" + group + "%");
				qPos.add("%" + group + "%");
			}
			if (Validator.isNotNull(congDanId)) {
				qPos.add(congDanId);
				qPos.add(congDanId);
			}
			
			if (Validator.isNotNull(doiTuongId)) {
				qPos.add(doiTuongId);
			}
			
			int rows = 0;
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					rows= count.intValue();
				}
			}

			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeSession(session);
		}

		return 0;
	}

}
