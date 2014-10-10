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

import org.oep.cmon.dao.report.model.impl.Lephi_chitietImpl;
import org.oep.cmon.dao.report.model.impl.Lephi_linhvucImpl;
import org.oep.cmon.dao.report.model.impl.Lephi_tonghopImpl;

import org.oep.cmon.dao.report.model.Lephi_chitiet;
import org.oep.cmon.dao.report.model.Lephi_linhvuc;
import org.oep.cmon.dao.report.model.Lephi_tonghop;
import org.oep.cmon.dao.report.service.persistence.Lephi_chitietFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* Lephi_chitietFinderImpl class
*   
* This class is used to get Lephi_chitiet information 
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
public class Lephi_chitietFinderImpl extends BasePersistenceImpl<Lephi_chitiet> implements Lephi_chitietFinder {
	
	/**
	  * This is fucntion lephichitiet 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_loaihoso,String ngaynhan_tungay,String ngaynhan_denngay
	  * @return List<Lephi_chitiet>
	  */
	@SuppressWarnings("unchecked")
	public List<Lephi_chitiet> lephichitiet(String id_loaihoso,String ngaynhan_tungay,String ngaynhan_denngay) throws Exception {
		Session session = null;
		List<Lephi_chitiet> listresult=null;
		try {
			session = openSession();
			String base =" select hs.id,tthc.ten as tenhoso,hs.HOTENNGUOINOPHOSO as nguoinop,hs.CHUSOHUU as chuhoso, cd.DIACHIHIENNAY as diachi, ";
			base +=" hs.SOBOHOSO,hs.lephi,hs.phihoso,(hs.lephi+hs.phihoso) as tonglephi, hs.ghichu,tthc.NHOMTHUTUCHANHCHINHID ";
			base +=" from cmon_hosotthccong hs inner join cmon_thutuchanhchinh tthc on hs.THUTUCHANHCHINHID = tthc.id ";
			base +=" left join CSMS_CONGDAN cd on hs.NGUOIDAIDIENPHAPLUATID = cd.id ";		
			base +=" where hs.THUTUCHANHCHINHID in ("+ id_loaihoso +") ";
			if(!ngaynhan_tungay.equals("")){
				base +=" and hs.NGAYNHANHOSO >= TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			if(!ngaynhan_denngay.equals("")){
				base +=" and hs.NGAYNHANHOSO <= TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Lephi_chitiet",Lephi_chitietImpl.class);
			listresult = (List<Lephi_chitiet>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	
	/**
	  * This is fucntion lephilinhvuc 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_linhvuc,String ngaynhan_tungay,String ngaynhan_denngay
	  * @return List<Lephi_linhvuc>
	  */
	@SuppressWarnings("unchecked")
	public List<Lephi_linhvuc> lephilinhvuc(String id_linhvuc,String ngaynhan_tungay,String ngaynhan_denngay) throws Exception {
		Session session = null;
		List<Lephi_linhvuc> listresult=null;
		try {
			session = openSession();
			String base =" select count(hs.id) as tonghoso,sum(hs.lephi) as lephihoso,sum(hs.phihoso) as phihoso,";
			base+=" (sum(hs.lephi)+sum(hs.phihoso)) as tonglephi,tthc.NHOMTHUTUCHANHCHINHID ";	
			base+=" from cmon_hosotthccong hs inner join cmon_thutuchanhchinh tthc on hs.THUTUCHANHCHINHID = tthc.id ";		
			base+=" left join CSMS_CONGDAN cd on hs.NGUOIDAIDIENPHAPLUATID = cd.id ";
			base+=" where hs.THUTUCHANHCHINHID in (select id from cmon_thutuchanhchinh where NHOMTHUTUCHANHCHINHID in("+id_linhvuc+")) ";	
			if(!ngaynhan_tungay.equals("")){
				base +=" and hs.NGAYNHANHOSO >= TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			if(!ngaynhan_denngay.equals("")){
				base +=" and hs.NGAYNHANHOSO <= TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			base+=" group by tthc.NHOMTHUTUCHANHCHINHID ";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Lephi_linhvuc",Lephi_linhvucImpl.class);
			listresult = (List<Lephi_linhvuc>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeSession(session); 
		}
		return listresult;
	}
	
	/**
	  * This is fucntion lephitonghop 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String id_loaihoso,String ngaynhan_tungay,String ngaynhan_denngay
	  * @return List<Lephi_tonghop>
	  */
	@SuppressWarnings("unchecked")
	public List<Lephi_tonghop> lephitonghop(String id_loaihoso,String ngaynhan_tungay,String ngaynhan_denngay) throws Exception {
		Session session = null;
		List<Lephi_tonghop> listresult=null;
		try {
			session = openSession();
			String base =" select c.id as NHOMTHUTUCHANHCHINHID,COUNT(a.id) as tonghoso,SUM(a.LEPHI) as lephi,SUM(a.PHIHOSO) as phihoso, ";
		    base +=" (SUM(a.LEPHI)+SUM(a.PHIHOSO)) as tonglephi,EXTRACT(month FROM a.NGAYNHANHOSO) as thangnhan ";
		    base +=" from CMON_HOSOTTHCCONG a ";
		    base +=" INNER JOIN CMON_THUTUCHANHCHINH b ON a.THUTUCHANHCHINHID = b.ID ";
		    base +=" INNER JOIN CMON_NHOMTHUTUCHANHCHINH c ON c.id = b.nhomthutuchanhchinhid ";
		    base +=" WHERE a.THUTUCHANHCHINHID in ("+id_loaihoso+") ";
			if(!ngaynhan_tungay.equals("")){
				base +=" and a.NGAYNHANHOSO >= TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			if(!ngaynhan_denngay.equals("")){
				base +=" and a.NGAYNHANHOSO <= TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy') ,'DD-MON-RR') ";
			}
			base +=" GROUP BY c.id,EXTRACT(year FROM a.NGAYNHANHOSO),EXTRACT(month FROM a.NGAYNHANHOSO) ";
			StringBuffer sqlBuffer = new StringBuffer(base);
			String sql = sqlBuffer.toString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("Lephi_tonghop",Lephi_tonghopImpl.class);
			listresult = (List<Lephi_tonghop>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}

}
