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

package org.oep.cmon.portlet.mapping.utils;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;
import org.oep.cmon.dao.thamso.service.persistence.AnhXaFinderUtil;



/**
 * This is class SynchThread
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class SynchThread extends Thread{
	


	public static Boolean running = false;
	
	private Long appId;
	private String table;
	private boolean overwriteAll = false;
	
	/**
	 * This is constructor
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param appId
	 * @param table
	 * @param overwriteAll
	 */
	public SynchThread(Long appId,String table,boolean overwriteAll){
		this.appId =appId;
		this.table =table;
		this.overwriteAll =overwriteAll;
	}

	/**
	 * This is function run
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 */
	public void run() {
		// TODO Auto-generated method stub
		synchronized (SynchThread.running) {
			if(!SynchThread.running){
			try {
				SynchThread.running =true;
				AnhXaLocalServiceUtil.synchronize(this.appId, this.table, this.overwriteAll);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				SynchThread.running=false;
			}finally{
				SynchThread.running=false;
			}
			}
		}
		
	}
	
	
	

}
