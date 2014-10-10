package org.oep.cmon.dao.report.service.persistence;

import java.util.List;

import org.oep.cmon.dao.dvc.model.impl.ThuTucHanhChinhImpl;
import org.oep.cmon.dao.report.model.impl.CoQuanQuanLy2LinhVucImpl;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;
import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;
import org.oep.cmon.dao.report.service.persistence.CoQuanQuanLy2LinhVucFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

/**
*
* CoQuanQuanLy2LinhVucFinderImpl class
*   
* This class is used to get CoQuanQuanLy2LinhVuc information 
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
public class CoQuanQuanLy2LinhVucFinderImpl extends BasePersistenceImpl<CoQuanQuanLy2LinhVuc> implements CoQuanQuanLy2LinhVucFinder {
	
	/**
	  * This is fucntion getLinhvucByIdDonvi
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_donvibaocao
	  * @return List<CoQuanQuanLy2LinhVuc>
	  */
	@SuppressWarnings("unchecked")
	public List<CoQuanQuanLy2LinhVuc> getLinhvucByIdDonvi(String id_donvibaocao) throws Exception {
		Session session = null;
		List<CoQuanQuanLy2LinhVuc> listresult=null;
		try {
			session = openSession();
			String base =" select distinct(nhomthutuchanhchinhid),tennhomtthc from cmon_view_coquanquanly2linhvuc where coquanquanlyid  in ("+id_donvibaocao+") ";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("CoQuanQuanLy2LinhVuc",CoQuanQuanLy2LinhVucImpl.class);
			listresult = (List<CoQuanQuanLy2LinhVuc>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	
	/**
	  * This is fucntion getTTHC
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String nhomtthc_id,String donvi_id
	  * @return List<ThuTucHanhChinh>
	  */
	@SuppressWarnings("unchecked")
	public List<ThuTucHanhChinh> getTTHC(String nhomtthc_id,String donvi_id) throws Exception {
		Session session = null;
		List<ThuTucHanhChinh> listresult=null;
		try {
			session = openSession();
			String base ="select distinct a.ID,a.MA,a.TEN,a.songayxuly, a.ngaytao,a.nguoitao,a.ngaysua,a.nguoisua,a.trangthai, a.phienban,a.daxoa,a.nhomthutuchanhchinhid,";
			base+=" a.cantichhop,a.madng,a.lephi,a.donvilephi,a.phi,a.donviphi,a.tenmaudontokhai,a.capcoquanquanlyid,a.uengineprocessname,a.thutuclienthongid,";
			base+=" null as TRINHTUTHUCHIEN,null as YEUCAUDIEUKIENTHUCHIEN, null as CANCUPHAPLY, null as THANHPHANHOSO, null as LINHVUCTHUCHIEN, null as CACHTHUCHIEN"; 
			base+=" from cmon_thutuchanhchinh a  ";
			base+=" inner join cmon_tthc2coquanquanly b on a.id = b.thutuchanhchinhid ";
			base+=" inner join cmon_coquanquanly c on b.coquanquanlyid = c.id ";
			base+=" where a.nhomthutuchanhchinhid in("+nhomtthc_id+") and c.id in ("+donvi_id+") ";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ThuTucHanhChinh",ThuTucHanhChinhImpl.class);
			listresult = (List<ThuTucHanhChinh>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	
}
