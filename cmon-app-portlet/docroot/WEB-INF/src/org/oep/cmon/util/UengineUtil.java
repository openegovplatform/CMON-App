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

package org.oep.cmon.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.oep.cmon.Constants;
import org.oep.egovcore.util.Helper;

import vn.dtt.sharedservice.bpm.consumer.uengine.IBrms;
import vn.dtt.sharedservice.bpm.consumer.uengine.IBrmsService;
import vn.dtt.sharedservice.bpm.consumer.uengine.ProcessInstance;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/** 
 * This is class UengineUtil
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  10-April-2013  Nam Dinh    Create new
 */
public class UengineUtil {
	
	protected static Log logger = LogFactoryUtil.getLog(UengineUtil.class);
	
	/** 
	 * This is function insert CongChuc
	 * 
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  10-April-2013  Nam Dinh    Create new
	 * @param emailCanBos
	 * @param tuNgay (dd/MM/yyyy)
	 * @param denNgay (dd/MM/yyyy)
	 * @throws SystemException
	 * @return List<String>
	 */
	public static final List<String> getAllMaHoSoByCanBo(String[] emailCanBos, String tuNgay, String denNgay, int[] statusHS) throws SystemException {
			
		List<String> out = new ArrayList<String>();
		String emails = Helper.join(emailCanBos, true);
		
		boolean tn= Helper.inArray(statusHS, Constants.TRANGTHAIHOSO.HO_SO_DA_TIEP_NHAN);
		boolean xl= Helper.inArray(statusHS, Constants.TRANGTHAIHOSO.HO_SO_DANG_XU_LY);
		boolean bx= Helper.inArray(statusHS, Constants.TRANGTHAIHOSO.HO_SO_CHO_BO_XUNG);
//		INSTR(b.CURREP, " + emails + ")
		String sqlStmt;
		StringBuilder cond = new StringBuilder();
		if(emailCanBos.length>1){
			for (String email : emailCanBos) {
				cond.append("OR INSTR(b.CURREP, '" + email + "') > 0 ");
			}
			
			cond.delete(0, 3);
		}
		else{
			cond.append("INSTR(b.CURREP, '" + emailCanBos[0] + "') > 0");
		}
		if(tn || xl || bx){
			 sqlStmt = "SELECT * FROM bpm_procinst b WHERE " + cond;
			 logger.info("Xuat boolean :" + tn+xl+bx);
		}else{
			 sqlStmt = "select * from (select c.*, row_number() over (order by moddate desc) as rn   from ( SELECT DISTINCT  b.name , b.instid,b.defid,b.defname,b.status,b.currep, b.moddate FROM bpm_procinst b, bpm_worklist a WHERE a.instid =b.instid " +
			" and a.endpoint IN (" + emails + ")" +
			" and a.startdate between to_date('"+ tuNgay + "','dd/MM/yyyy') " +
			" and to_date('" + denNgay + "','dd/MM/yyyy')  ) c)"
		;
		}
		logger.info("SqlStmt cua can bo  dc chon :" + sqlStmt);
		List<ProcessInstance> processInstances = null;
		logger.info("emailCanBo cua can bo  dc chon :" + emails);
		
		try {
			IBrms uengineWS = new IBrmsService().getIBrmsPort();
			processInstances = uengineWS.getFromDBBySelectStatement(sqlStmt);
			logger.info("processInstances processInstances :" + processInstances);
			int count = processInstances.size();
			for (int i = 0; i < count; ++ i) {
				out.add(processInstances.get(i).getInstName());
			}
		} catch (Exception e) {
			throw new SystemException("LOI KHI GOI WEBSERVICE UENGINE SEARCH DS HO SO"
				+ "<br>DS Email:" + Arrays.toString(emailCanBos)
				+ "<br>tuNgay:" + tuNgay
				+ "<br>denNgay:" + denNgay
				
			);
		}
		logger.info("Ma Ho So Get Duoc Tu Uengine:" + Arrays.toString(out.toArray(new String[out.size()])));
		logger.info("out :" + out);
		return out;
	}

}
