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

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.report.model.impl.ReportThongKeImpl;

import org.oep.cmon.dao.report.model.ReportThongKe;
import org.oep.cmon.dao.report.service.persistence.ReportThongKeFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* ReportThongKeFinderImpl class
*   
* This class is used to get ReportThongKe information 
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
public class ReportThongKeFinderImpl extends BasePersistenceImpl<ReportThongKe> implements ReportThongKeFinder {
	
	/**
	  * This is fucntion getListReportThongKeGroupByIDCoQuan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String IDDonViQuanLy,String arrThang,String nam
	  * @return List<ReportThongKe>
	  */
	@SuppressWarnings("unchecked")
	public List<ReportThongKe> getListReportThongKeGroupByIDCoQuan(String IDDonViQuanLy,String arrThang,String nam) throws Exception {
		Session session = null;
		StringBuffer sqlBuffer = null;
		String sql = null;
		String base = null;
		SQLQuery q = null;
		List<ReportThongKe> listresult=null;		
		List<String> where = new ArrayList<String>();
		int minThang = 0;
		int maxThang = 0;
		String[] thangs = arrThang.split(",");
		if(thangs.length!=0){
			minThang = Integer.parseInt(thangs[0]);
			maxThang = Integer.parseInt(thangs[thangs.length-1]);
		}
		try {			
			where.add("capcoquanquanlyid = "+IDDonViQuanLy);
			where.add("nam = "+nam);
			if(!arrThang.equals("0")){
				where.add("thang IN ("+arrThang+")");			
			}
			
			String queryWhere = "";
			for (int i = 0; i < where.size(); i++) {
				if(i == 0)queryWhere +=" WHERE ";
				if(i > 0)queryWhere +=" AND ";
				queryWhere += where.get(i);
			}
			session = openSession();
			base =" select capcoquanquanlyid,coquanquanlyid,nam,count(thang) as thang,sum(tiepnhan)+ sum(CASE WHEN thang = "+minThang+" THEN tondau ELSE 0 END) as tongnhan, sum(tiepnhan) as tiepnhan,";
			base += " sum(CASE WHEN thang = "+minThang+" THEN tondau ELSE 0 END) as tondau,sum(tongdagiaiquyet) as tongdagiaiquyet,sum(som) as som,sum(dung) as dung, sum(tre) as tre,";
			base += " sum(tongdanggiaiquyet) as tongdanggiaiquyet,sum(chuadenhan) as chuadenhan, sum(quahan) as quahan,sum(ruthoso) as ruthoso,";
			base += " sum(khonghople) as khonghople, (CASE WHEN sum(tongdagiaiquyet) > 0 THEN ROUND(sum(som+dung)/sum(tongdagiaiquyet),2) ELSE ROUND(sum(som+dung)/1,2) END) as tyle,sum(CASE WHEN thang = "+maxThang+" THEN toncuoi ELSE 0 END) as toncuoi";
			base += " from cmon_rpthongke ";
			base += queryWhere;
			base += " group by capcoquanquanlyid,coquanquanlyid, nam ";
		
			sqlBuffer = new StringBuffer(base);
			sql = sqlBuffer.toString();
			q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("ReportThongKe",ReportThongKeImpl.class);
			listresult = (List<ReportThongKe>) q.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
		return listresult;
	}
	
	
	/**
	  * This is fucntion reportScheduler 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return void
	  */
	public void reportScheduler(){
		Session session = null;
		try {	
		
		session = openSession();
		String base = "CALL cmon_fn_rpcall_processdata()";
		StringBuffer sqlBuffer = new StringBuffer(base);
		String sql = sqlBuffer.toString();
		SQLQuery q = session.createSQLQuery(sql);
		q.setCacheable(false);
		q.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			 closeSession(session); 
		}
	}
}
