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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.oep.cmon.dao.report.model.impl.BaocaochitietImpl;

import org.oep.cmon.dao.report.model.Baocaochitiet;
import org.oep.cmon.dao.report.service.persistence.BaocaochitietFinder;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

public class BaocaochitietFinderImpl extends BasePersistenceImpl<Baocaochitiet> implements BaocaochitietFinder {
	@SuppressWarnings("unchecked")
	public List<Baocaochitiet> hienthiDanhsachBaocao( String[] listloaihoso, String ngaynhan_tungay, String ngaynhan_denngay, String trangthai, String tinhtrang, String loaidangky, int start, int end){
		Session session = null;
		List<Baocaochitiet> listresult = null;
		if(listloaihoso == null && trangthai.equals("") && ngaynhan_tungay.equals("") && ngaynhan_denngay.equals("") && tinhtrang.equals("") && loaidangky.equals("")){
			return listresult;
		}else{
			try {
			 	session = openSession();
			 	String Idloaihoso_sql = "";
				if(listloaihoso != null){
					for(int i=0;i<listloaihoso.length;i++){
						Idloaihoso_sql += listloaihoso[i];
						if(i<listloaihoso.length-1){
							Idloaihoso_sql += ",";
						}
					}
				}
				String base = "select e.ID LINHVUCID, a.MASOHOSO, b.TEN, c.TRANGTHAI, d.DIACHIHIENNAY, d.DIENTHOAIDIDONG, " +
	        	 		"a.HOTENNGUOINOPHOSO, a.CHUSOHUU as NGUOIDAIDIENPHAPLUAT, " +
	        	 		"TO_CHAR(TO_DATE(a.NGAYNHANHOSO,'DD-MON-RR'),'dd/MM/yyyy') NGAYNHANHOSO,TO_CHAR(TO_DATE(a.NGAYTRAKETQUA,'DD-MON-RR'), 'dd/MM/yyyy') NGAYTRAKETQUA,TO_CHAR(TO_DATE(a.NGAYHENTRAKETQUA,'DD-MON-RR'), 'dd/MM/yyyy') NGAYHENTRAKETQUA , e.TEN LINHVUC, a.GHICHU " +
	        	 		"from " +
	        	 		"CMON_HOSOTTHCCONG a inner join CMON_THUTUCHANHCHINH b on a.THUTUCHANHCHINHID = b.ID " +
	        	 		"inner join CMON_TRANGTHAIHOSO c on a.TRANGTHAIHOSO = c.ID " +
	        	 		"left join CSMS_CONGDAN d on a.NGUOIDAIDIENPHAPLUATID = d.ID "+
	        	 		"inner join CMON_NHOMTHUTUCHANHCHINH e on b.NHOMTHUTUCHANHCHINHID = e.ID ";
	        	if(listloaihoso != null || !trangthai.equals("") || !ngaynhan_tungay.equals("") || !ngaynhan_denngay.equals("") || !tinhtrang.equals("") || !loaidangky.equals("")){
	        		base += "where 1=1";
	        	}
				if(listloaihoso != null){
					base += " AND a.THUTUCHANHCHINHID IN ("+Idloaihoso_sql+")";
				}
				if(!trangthai.equals("")){
	
					base += "AND a.TRANGTHAIHOSO ="+trangthai;
				}
				Calendar dateTime = Calendar.getInstance();
				SimpleDateFormat nam_format = new SimpleDateFormat("yyyy");
				 Date time = dateTime.getTime();
				String year = nam_format.format(time);
				 if(!ngaynhan_tungay.equals("")){
					 if(!ngaynhan_denngay.equals("")){
						 base += " AND a.NGAYNHANHOSO >=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR')";
						 base += " AND a.NGAYNHANHOSO <=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR') ";
		        	 }else{
		        		 ngaynhan_denngay = "01/12/"+ngaynhan_tungay.substring(6,10);
		        		 base += " AND a.NGAYNHANHOSO >=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR')";
		        		 base += " AND a.NGAYNHANHOSO <=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR') ";
		        	 }
				 }else{
					 if(!ngaynhan_denngay.equals("")){
						 ngaynhan_tungay = "01/01/"+ngaynhan_denngay.substring(6,10);
						 base += " AND a.NGAYNHANHOSO >=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_tungay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR')";
		        		 base += " AND a.NGAYNHANHOSO <=  TO_DATE(TO_CHAR(TO_DATE('"+ngaynhan_denngay+"', 'dd/MM/yyyy'),'DD-MON-RR'),'DD-MON_RR')";
		        	 }
				 }
				 
				 if(!tinhtrang.equals("")){
					if(tinhtrang.equals("0")){
						base += " AND a.NGAYTRAKETQUA = a.NGAYHENTRAKETQUA";
					}else if(tinhtrang.equals("1")){
						base += " AND a.NGAYTRAKETQUA < a.NGAYHENTRAKETQUA";
					}else if(tinhtrang.equals("2")){
						base += " AND a.NGAYTRAKETQUA > a.NGAYHENTRAKETQUA";
					}
				 }
				 
				 if(!loaidangky.equals("")){
					 base+=" AND a.LOAIHOSO ="+Integer.parseInt(loaidangky);
				 }
	        	
	        	 base += " order by e.ID asc ";
		        StringBuffer sqlBuffer = new StringBuffer(base);
		        String sql = sqlBuffer.toString();
	        	SQLQuery q = session.createSQLQuery(sql);
	            q.setCacheable(false);
	            q.addEntity("Baocaochitiet",BaocaochitietImpl.class);
	            listresult = (List<Baocaochitiet>)q.list();
	          
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				closeSession(session);
			}
		}
		return listresult;
	}
}
