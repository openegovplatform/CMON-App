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

package org.oep.cmon.dao.kios.service.persistence;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.oep.cmon.dao.kios.model.impl.DanhSachCoQuanImpl;
import org.oep.cmon.dao.kios.model.impl.DanhSachHoSoImpl;
import org.oep.cmon.dao.kios.model.impl.DanhSachThongKeImpl;

import org.oep.cmon.dao.kios.model.DanhSachCoQuan;
import org.oep.cmon.dao.kios.model.DanhSachHoSo;
import org.oep.cmon.dao.kios.model.DanhSachThongKe;
import org.oep.cmon.dao.kios.service.persistence.DanhSachHoSoFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* DanhSachHoSoFinderImpl class
*   
* This class is used to get DanhSachHoSo information 
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
public class DanhSachHoSoFinderImpl extends BasePersistenceImpl<DanhSachHoSo> implements DanhSachHoSoFinder {
	
	/**
	  * This is fucntion getListHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_coquan,int start,int end
	  * @return List<DanhSachHoSo>
	  */
	@SuppressWarnings("unchecked")
	public List<DanhSachHoSo> getListHoSo(String id_coquan,int start,int end) throws Exception {
		Session session = null;
		List<DanhSachHoSo> listresult= new ArrayList<DanhSachHoSo>();
		try {
			session = openSession();
			String base ="SELECT * FROM (SELECT hs.id as id_,hs.ngaynhanhoso,hs.tencoquantiepnhan,hs.tenthutuchanhchinh,hs.ngayhentraketqua,";
			base+=" hs.ngaytraketqua,hs.hotennguoinophoso,hs.diachithuongtrunguoinop,hs.sodienthoaididongnguoinop, ";
			base+=" hs.ngayketthucxuly,hs.loaihoso,hs.masobiennhan,hs.chusohuu,hs.lephi,hs.phihoso,hs.emailnguoinop,hs.sodienthoaicodinhnguoinop, ";
			base+=" ntthc.ten as nhomthutuchanhchinhten,tt.trangthai as trangthaihosoten, ROWNUM rNum FROM (SELECT * FROM CMON_HOSOTTHCCONG) hs ";
			base+=" inner join cmon_trangthaihoso tt on hs.trangthaihoso = tt.id ";
			base+=" inner join cmon_thutuchanhchinh tthc on hs.thutuchanhchinhid = tthc.id "; 
			base+=" inner join cmon_nhomthutuchanhchinh ntthc on tthc.nhomthutuchanhchinhid = ntthc.id ";
			if(!id_coquan.equals("0")){
				if(Validator.isNotNull(start) && Validator.isNotNull(end)){
					base +=" WHERE ROWNUM <="+end;
					base +=" and hs.coquantiepnhanid in ("+id_coquan+")) WHERE rnum >="+start;
				}
			}else{
				if(Validator.isNotNull(start) && Validator.isNotNull(end)){
					base +=" WHERE ROWNUM <="+end+" ) WHERE rnum >="+start;
				}
			}
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DanhSachHoSo",DanhSachHoSoImpl.class);
			listresult = (List<DanhSachHoSo>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	/**
	  * This is fucntion getListReportThongKeGroupByIDCoQuan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrCapCoQuanid,String arrThang,String nam
	  * @return List<DanhSachThongKe>
	  */
	@SuppressWarnings("unchecked")
	public List<DanhSachThongKe> getListReportThongKeGroupByIDCoQuan(String arrCapCoQuanid,String arrThang,String nam) throws Exception {
		Session session = null;
		StringBuffer sqlBuffer = null;
		String sql = null;
		String base = null;
		SQLQuery q = null;
		List<DanhSachThongKe> listresult=null;		
		List<String> where = new ArrayList<String>();
		int minThang = 0;
		int maxThang = 0;
		String[] thangs = arrThang.split(",");
		if(thangs.length!=0){
			minThang = Integer.parseInt(thangs[0]);
			maxThang = Integer.parseInt(thangs[thangs.length-1]);
		}
		try {			
			if(!arrCapCoQuanid.equals("0")){
				where.add("rp.capcoquanquanlyid in ("+arrCapCoQuanid+")");
			}
			if(arrThang.equals("0")){
				arrThang = "1,2,3,4,5,6,7,8,9,10,11,12";
			}
			if(nam.equals("0")){
				nam = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			}
			where.add("rp.nam = "+nam);
			if(!arrThang.equals("0")){
				where.add("rp.thang IN ("+arrThang+")");			
			}
			
			String queryWhere = "";
			for (int i = 0; i < where.size(); i++) {
				if(i == 0)queryWhere +=" WHERE ";
				if(i > 0)queryWhere +=" AND ";
				queryWhere += where.get(i);
			}
			session = openSession();
			base =" select rp.capcoquanquanlyid,rp.coquanquanlyid,rp.nam,cqql.ten as tencapcoquanquanly,cq.ten as tencoquanquanly,count(rp.thang) as thang,sum(rp.tiepnhan)+ sum(CASE WHEN rp.thang = "+minThang+" THEN rp.tondau ELSE 0 END) as tongnhan, sum(rp.tiepnhan) as tiepnhan,";
			base += " sum(CASE WHEN rp.thang = "+minThang+" THEN rp.tondau ELSE 0 END) as tondau,sum(rp.tongdagiaiquyet) as tongdagiaiquyet,sum(rp.som) as som,sum(rp.dung) as dung, sum(rp.tre) as tre,";
			base += " sum(rp.tongdanggiaiquyet) as tongdanggiaiquyet,sum(rp.chuadenhan) as chuadenhan, sum(rp.quahan) as quahan,sum(rp.ruthoso) as ruthoso,";
			base += " sum(rp.khonghople) as khonghople, (CASE WHEN sum(rp.tongdagiaiquyet) > 0 THEN ROUND(sum(rp.som+rp.dung)/sum(rp.tongdagiaiquyet),2) ELSE ROUND(sum(rp.som+rp.dung)/1,2) END) as tyle,sum(CASE WHEN rp.thang = "+maxThang+" THEN rp.toncuoi ELSE 0 END) as toncuoi";
			base += " from cmon_rpthongke rp inner join cmon_capcoquanquanly cqql on rp.capcoquanquanlyid = cqql.id ";
			base += " inner join cmon_coquanquanly cq on rp.coquanquanlyid = cq.id  ";
			base += queryWhere;
			base += " group by rp.capcoquanquanlyid,rp.coquanquanlyid, rp.nam,cqql.ten,cq.ten ";
			sqlBuffer = new StringBuffer(base);
			sql = sqlBuffer.toString();
			q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DanhSachThongKe",DanhSachThongKeImpl.class);
			listresult = (List<DanhSachThongKe>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	
	/**
	  * This is fucntion getListCoQuan
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrayCapCoQuanId
	  * @return List<DanhSachCoQuan>
	  */
	@SuppressWarnings("unchecked")
	public List<DanhSachCoQuan> getListCoQuan(String arrayCapCoQuanId) throws Exception {
		Session session = null;
		List<DanhSachCoQuan> listresult= new ArrayList<DanhSachCoQuan>();
		try {
			session = openSession();
			String base ="select a.id as id_ ,a.ten as ten ,a.chaid as chaId ,b.ten as tenCapCoQuanQuanly,b.id as capCoQuanQuanLyId from cmon_coquanquanly a inner join cmon_capcoquanquanly b on a.capcoquanquanlyid = b.id";
			base += " where a.capcoquanquanlyid  in ("+arrayCapCoQuanId+")";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("DanhSachCoQuan",DanhSachCoQuanImpl.class);
			listresult = (List<DanhSachCoQuan>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
}
