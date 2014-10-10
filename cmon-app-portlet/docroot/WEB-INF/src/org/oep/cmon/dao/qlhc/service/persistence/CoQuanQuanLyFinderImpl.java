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

package org.oep.cmon.dao.qlhc.service.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.oep.cmon.dao.cc.model.impl.ChucVuImpl;
import org.oep.cmon.dao.qlhc.model.impl.CoQuanQuanLyImpl;
import org.oep.cmon.util.Helpers;

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;
import org.oep.cmon.dao.qlhc.model.CoQuanQuanLyClp;

import org.oep.cmon.dao.qlhc.service.persistence.CoQuanQuanLyFinder;



import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
/**
*
* CoQuanQuanLyFinderImpl class
*   
* This class is used to get CoQuanQuanLy information 
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
public class CoQuanQuanLyFinderImpl extends BasePersistenceImpl<CoQuanQuanLy> implements CoQuanQuanLyFinder {
	
	
	/**
	  * This is fucntion getDSCoQuanQuanlyByDonViHanhChinhId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String donviHanhChinhIds
	  * @return List<CoQuanQuanLy>
	  */
	 public	List<CoQuanQuanLy>  getDSCoQuanQuanlyByDonViHanhChinhId(String donviHanhChinhIds){
		  
			Session session = null;
			StringBuffer sql = new StringBuffer();
			
			try {
				session = openSession();
				
				sql.append("SELECT cq.id,cq.ma,cq.ten FROM CMON_COQUANQUANLY cq");					
				sql.append(" WHERE cq.daXoa=0 AND cq.donvihanhchinhid in("+donviHanhChinhIds+")");
				sql.append(" ORDER BY cq.ten ASC ");
				
				 SQLQuery q = session.createSQLQuery(sql.toString());
	             q.addScalar("ID", Type.LONG);
				 q.addScalar("MA", Type.STRING);
				 q.addScalar("TEN", Type.STRING);
		
				  Iterator<Object[]> itr = (Iterator<Object[]>) QueryUtil.iterate(q,getDialect(),QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		            List<CoQuanQuanLy> result = new ArrayList<CoQuanQuanLy>();
					while (itr.hasNext()) {
						try{
							Object[] a= itr.next();
							CoQuanQuanLy t = new CoQuanQuanLyImpl();
							t.setId((Long)a[0]);
							t.setMa((String)a[1]);
							t.setTen((String)a[2]);							
							result.add(t);
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
					return result;
					
			
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				
				closeSession(session);
			}
			
			return null;
		

		}

	 
	 /**
	  * This is fucntion getDSCoQuanQuanlyByMaOrTen 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maOrTen,int start,int end
	  * @return List<CoQuanQuanLy>
	  */
	 @SuppressWarnings("unchecked")
	public	List<CoQuanQuanLy>  getDSCoQuanQuanlyByMaOrTen(String maOrTen,int start,int end){
		  
		 Session session = null;
	        try {  
	           session = openSession();  
	           	StringBuffer sql = new StringBuffer();
	           	sql.append("SELECT * FROM cmon_coquanquanly WHERE daxoa = 0");  
	            if(!Helpers.isEmpty(maOrTen)){
	            	sql.append(" AND (upper(ma) LIKE(:maOrTen) OR upper(ten) LIKE(:maOrTen))");
	            }
	            sql.append(" ORDER BY ten"); 
	            SQLQuery q = session.createSQLQuery(sql.toString());
	            q.setCacheable(false);
	            q.setString("maOrTen", "%" + maOrTen.toUpperCase() + "%");	           
	            q.addEntity("CoQuanQuanLy", CoQuanQuanLyImpl.class);  

	            List<CoQuanQuanLy> result = (List<CoQuanQuanLy>) QueryUtil.list(q, getDialect(), start, end);
				return result;
	        } catch (Exception e) {  
	        		
	        } finally {  
	            closeSession(session);  
	        }
	        return new ArrayList<CoQuanQuanLy>();

		}
	 
	 /**
	  * This is fucntion countDSCoQuanQuanlyByMaOrTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maOrTen
	  * @return int
	  */
	 public int countDSCoQuanQuanlyByMaOrTen(String maOrTen){
		 int result = 0;
		 Session session = null;

	        try {  
	           session = openSession();  
	           	StringBuffer sql = new StringBuffer();
	           	sql.append("SELECT COUNT(*) FROM cmon_coquanquanly WHERE daxoa = 0");
	           	if(!Helpers.isEmpty(maOrTen)){
	            	sql.append(" AND (ma LIKE(:maOrTen) OR ten LIKE(:maOrTen))");
	            }
	            SQLQuery q = session.createSQLQuery(sql.toString());  
	            q.setCacheable(false);
	            q.setString("maOrTen", "%" + maOrTen + "%");  
	            result = Integer.valueOf(q.uniqueResult().toString());         
	        } catch (Exception e) {  
	        		
	        } finally {  
	            closeSession(session);  
	        }
		 return result;
	 }
	


}
