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

package org.oep.cmon.dao.report.service.persistence;

import java.util.List;

import org.oep.cmon.dao.dvc.model.impl.NhomThuTucHanhChinhImpl;
import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.dao.report.model.impl.DanhMucBaoCaoImpl;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;
import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.report.model.CongChuc2Role;
import org.oep.cmon.dao.report.model.DanhMucBaoCao;
import org.oep.cmon.dao.report.service.persistence.CongChuc2RoleFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* ChucVuLocalServiceImpl class
*   
* This class is used to get ChucVu information 
* from database use custom sql
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
public class CongChuc2RoleFinderImpl extends BasePersistenceImpl<CongChuc2Role>
		implements CongChuc2RoleFinder {

	/**
	  * This is fucntion getDanhsachbaocao
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id
	  * @return List<DanhMucBaoCao>
	  */
	@SuppressWarnings("unchecked")
	public List<DanhMucBaoCao> getDanhsachbaocao(long user_id) throws Exception {
		Session session = null;
		List<DanhMucBaoCao> listresult = null;
		try {
			session = openSession();
			String base = " SELECT CMON_RPDANHMUCBAOCAO.ID, CMON_RPDANHMUCBAOCAO.TENBAOCAO,CMON_RPDANHMUCBAOCAO.DUONGDAN, "
					+ " CMON_RPDANHMUCBAOCAO.ORDERS,CMON_RPDANHMUCBAOCAO.STATUS,CMON_RPDANHMUCBAOCAO.PUBLISH ";
			base += " FROM CMON_TAIKHOANNGUOIDUNG ";
			base += " RIGHT JOIN CMON_RPNGUOIDUNG2ROLE ON CMON_RPNGUOIDUNG2ROLE.TAIKHOANNGUOIDUNGID = CMON_TAIKHOANNGUOIDUNG.ID ";
			base += " RIGHT JOIN CMON_RPROLE2BAOCAO ON CMON_RPROLE2BAOCAO.RPDANHMUCROLEID = CMON_RPNGUOIDUNG2ROLE.RPDANHMUCROLEID ";
			base += " RIGHT JOIN CMON_RPDANHMUCBAOCAO ON CMON_RPDANHMUCBAOCAO.ID = CMON_RPROLE2BAOCAO.BAOCAOID ";
			if (user_id != 0) {
				base += " WHERE CMON_TAIKHOANNGUOIDUNG.ID ="
						+ user_id
						+ " OR CMON_RPDANHMUCBAOCAO.PUBLISH = 1 "
						+ " AND CMON_RPDANHMUCBAOCAO.STATUS=1 GROUP BY CMON_RPDANHMUCBAOCAO.ID, CMON_RPDANHMUCBAOCAO.TENBAOCAO, "
						+ " CMON_RPDANHMUCBAOCAO.DUONGDAN,CMON_RPDANHMUCBAOCAO.ORDERS,CMON_RPDANHMUCBAOCAO.STATUS, "
						+ " CMON_RPDANHMUCBAOCAO.PUBLISH ";
			} else if (user_id == 0) {
				base += " WHERE CMON_RPDANHMUCBAOCAO.PUBLISH = 1 AND CMON_RPDANHMUCBAOCAO.STATUS=1  "
						+ "	GROUP BY CMON_RPDANHMUCBAOCAO.ID, CMON_RPDANHMUCBAOCAO.TENBAOCAO,CMON_RPDANHMUCBAOCAO.DUONGDAN, "
						+ "	CMON_RPDANHMUCBAOCAO.ORDERS, CMON_RPDANHMUCBAOCAO.STATUS,CMON_RPDANHMUCBAOCAO.PUBLISH ";
			}
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DanhMucBaoCao", DanhMucBaoCaoImpl.class);
			listresult = (List<DanhMucBaoCao>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return listresult;
	}

	/**
	  * This is fucntion getCoQuanQuanLy
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id, long baocao_id
	  * @return List<CoQuanQuanLy>
	  */
	@SuppressWarnings("unchecked")
	public List<CoQuanQuanLy> getCoQuanQuanLy(long user_id, long baocao_id)
			throws Exception {
		Session session = null;
		List<CoQuanQuanLy> listresult = null;
		try {
			session = openSession();
			String base = "SELECT CMON_COQUANQUANLY.ID,CMON_COQUANQUANLY.MA,CMON_COQUANQUANLY.TEN,CMON_COQUANQUANLY.DIACHI,";
			base += " CMON_COQUANQUANLY.DIENTHOAI,CMON_COQUANQUANLY.EMAIL,CMON_COQUANQUANLY.FAX,CMON_COQUANQUANLY.WEBSITE,  ";
			base += " CMON_COQUANQUANLY.NOIBO,CMON_COQUANQUANLY.NGAYTAO,CMON_COQUANQUANLY.NGUOITAO,CMON_COQUANQUANLY.NGAYSUA, ";
			base += " CMON_COQUANQUANLY.NGUOISUA,CMON_COQUANQUANLY.PHIENBAN,CMON_COQUANQUANLY.DAXOA,  ";
			base += " DONVIHANHCHINHID,CAPCOQUANQUANLYID,CHAID,MERCHANT,ACCESSCODE,SECURE_SECRET,CMON_COQUANQUANLY.MACAPSOBIENNHAN  ";
			base += " FROM cmon_coquanquanly ";
			base += " INNER JOIN cmon_rprole2donvibaocao ON cmon_coquanquanly.id = cmon_rprole2donvibaocao.donviid ";
			base += " INNER JOIN cmon_rpnguoidung2role ON cmon_rpnguoidung2role.rpdanhmucroleid = cmon_rprole2donvibaocao.rpdanhmucroleid ";
			base += " WHERE cmon_rpnguoidung2role.taikhoannguoidungid = "
					+ user_id + " AND cmon_rprole2donvibaocao.baocaoid="
					+ baocao_id;
			base += " GROUP BY CMON_COQUANQUANLY.ID,CMON_COQUANQUANLY.MA,CMON_COQUANQUANLY.TEN,CMON_COQUANQUANLY.DIACHI,  ";
			base += " CMON_COQUANQUANLY.DIENTHOAI,CMON_COQUANQUANLY.EMAIL,CMON_COQUANQUANLY.FAX,CMON_COQUANQUANLY.WEBSITE,  ";
			base += " CMON_COQUANQUANLY.NOIBO,CMON_COQUANQUANLY.NGAYTAO,CMON_COQUANQUANLY.NGUOITAO,CMON_COQUANQUANLY.NGAYSUA,  ";
			base += " CMON_COQUANQUANLY.NGUOISUA,CMON_COQUANQUANLY.PHIENBAN,CMON_COQUANQUANLY.DAXOA,  ";
			base += " DONVIHANHCHINHID,CAPCOQUANQUANLYID,CHAID,MERCHANT,ACCESSCODE,SECURE_SECRET,CMON_COQUANQUANLY.MACAPSOBIENNHAN ";
			base += " ORDER BY CMON_COQUANQUANLY.TEN ";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("CoQuanQuanLy", CoQuanQuanLyImpl.class);
			listresult = (List<CoQuanQuanLy>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return listresult;
	}

	/**
	  * This is fucntion getNhomTTHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id, long baocao_id,long donvi_id
	  * @return List<NhomThuTucHanhChinh>
	  */
	@SuppressWarnings("unchecked")
	public List<NhomThuTucHanhChinh> getNhomTTHC(long user_id, long baocao_id,
			long donvi_id) throws Exception {
		Session session = null;
		List<NhomThuTucHanhChinh> listresult = null;
		try {
			session = openSession();
			String base = " SELECT distinct CMON_NHOMTHUTUCHANHCHINH.ID, ";
			base += " CMON_NHOMTHUTUCHANHCHINH.MA,CMON_NHOMTHUTUCHANHCHINH.TEN,CMON_NHOMTHUTUCHANHCHINH.NGAYSUA,CMON_NHOMTHUTUCHANHCHINH.NGAYTAO, ";
			base += " CMON_NHOMTHUTUCHANHCHINH.NGUOISUA,CMON_NHOMTHUTUCHANHCHINH.NGUOITAO,CMON_NHOMTHUTUCHANHCHINH.PHIENBAN, ";
			base += " CMON_NHOMTHUTUCHANHCHINH.DANHMUCUNGDUNGID,CMON_NHOMTHUTUCHANHCHINH.DAXOA FROM cmon_nhomthutuchanhchinh ";
			base += " inner join cmon_rprole2nhomtthc on cmon_rprole2nhomtthc.nhomthutuchanhchinhid = cmon_nhomthutuchanhchinh.id ";
			base += " inner join cmon_rpdanhmucrole on cmon_rpdanhmucrole.id = cmon_rprole2nhomtthc.rpdanhmucroleid ";
			base += " inner join cmon_rpnguoidung2role on cmon_rpnguoidung2role.rpdanhmucroleid = cmon_rpdanhmucrole.id ";
			base += " inner join cmon_taikhoannguoidung on cmon_taikhoannguoidung.id = cmon_rpnguoidung2role.taikhoannguoidungid  ";
			base += " inner join cmon_view_coquanquanly2linhvuc on cmon_nhomthutuchanhchinh.id = cmon_view_coquanquanly2linhvuc.nhomthutuchanhchinhid ";
			base += " WHERE CMON_TAIKHOANNGUOIDUNG.ID = " + user_id
					+ " AND cmon_rprole2nhomtthc.baocaoid = " + baocao_id
					+ " and cmon_view_coquanquanly2linhvuc.coquanquanlyid = "
					+ donvi_id;
			base += " order by CMON_NHOMTHUTUCHANHCHINH.ten";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("NhomThuTucHanhChinh", NhomThuTucHanhChinhImpl.class);
			listresult = (List<NhomThuTucHanhChinh>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return listresult;
	}

	/**
	  * This is fucntion getThutuchanhchinh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id,long baocao_id, long donvi_id
	  * @return List<ThuTucHanhChinh>
	  */
	@SuppressWarnings("unchecked")
	public List<ThuTucHanhChinh> getThutuchanhchinh(long user_id,
			long baocao_id, long donvi_id) throws Exception {
		Session session = null;
		List<ThuTucHanhChinh> listresult = null;
		try {
			session = openSession();
			String base = "select distinct a.ID,a.MA,a.TEN,a.songayxuly, a.ngaytao,a.nguoitao,a.ngaysua,a.nguoisua,a.trangthai, a.phienban,a.daxoa,a.nhomthutuchanhchinhid,";
			base += " a.cantichhop,a.madng,a.lephi,a.donvilephi,a.phi,a.donviphi,a.tenmaudontokhai,a.capcoquanquanlyid,a.uengineprocessname,a.thutuclienthongid,";
			base += " null as TRINHTUTHUCHIEN,null as YEUCAUDIEUKIENTHUCHIEN, null as CANCUPHAPLY, null as THANHPHANHOSO, null as LINHVUCTHUCHIEN, null as CACHTHUCHIEN";
			base += " FROM CMON_THUTUCHANHCHINH a";
			base += " inner join cmon_rprole2thutuchanhchinh on cmon_rprole2thutuchanhchinh.thutuchanhchinhid = a.id ";
			base += " inner join cmon_rpdanhmucrole on cmon_rpdanhmucrole.id = cmon_rprole2thutuchanhchinh.rpdanhmucroleid ";
			base += " inner join cmon_rpnguoidung2role on cmon_rpnguoidung2role.rpdanhmucroleid = cmon_rpdanhmucrole.id ";
			base += " inner join cmon_taikhoannguoidung on cmon_taikhoannguoidung.id = cmon_rpnguoidung2role.taikhoannguoidungid ";
			base += " inner join cmon_tthc2coquanquanly on a.id = cmon_tthc2coquanquanly.thutuchanhchinhid ";
			base += " WHERE CMON_TAIKHOANNGUOIDUNG.ID = " + user_id
					+ " AND cmon_rprole2thutuchanhchinh.baocaoid = "
					+ baocao_id
					+ " and cmon_tthc2coquanquanly.coquanquanlyid = "
					+ donvi_id;
			base += " order by a.ten";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ThuTucHanhChinh", ThuTucHanhChinhImpl.class);
			listresult = (List<ThuTucHanhChinh>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return listresult;
	}
	
	/**
	  * This is fucntion testReportPermission
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long user_id,long baocao_id
	  * @return Boolean
	  */
	public Boolean testReportPermission(long user_id,long baocao_id) throws Exception {
		boolean test = false;
		Session session = null;
		try {
			session = openSession();
			String base = "select count(a.id) FROM CMON_THUTUCHANHCHINH a"; 
			base +=" inner join cmon_rprole2thutuchanhchinh on cmon_rprole2thutuchanhchinh.thutuchanhchinhid = a.id";  
			base +=" inner join cmon_rpdanhmucrole on cmon_rpdanhmucrole.id = cmon_rprole2thutuchanhchinh.rpdanhmucroleid";  
			base +=" inner join cmon_rpnguoidung2role on cmon_rpnguoidung2role.rpdanhmucroleid = cmon_rpdanhmucrole.id";
			base +=" inner join cmon_taikhoannguoidung on cmon_taikhoannguoidung.id = cmon_rpnguoidung2role.taikhoannguoidungid";  
			base +=" WHERE cmon_rpnguoidung2role.taikhoannguoidungid = "+user_id;
			base +=" AND cmon_rprole2thutuchanhchinh.baocaoid = " + baocao_id;
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			long count = Long.valueOf(q.uniqueResult().toString());
			
			if(count>0){
				test = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return test;
	}

}
