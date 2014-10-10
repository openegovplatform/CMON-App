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

import org.oep.cmon.dao.thamso.service.AnhXaLocalServiceUtil;

/**
 * This is class DeleteThread
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class DeleteThread extends Thread {


	public static Boolean running = false;
	
	private Long appId;
	private String table;
	private Boolean deleteMapping = false;
	
	
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
	 * @param deleteMapping
	 */
	public DeleteThread(Long appId,String table,Boolean deleteMapping){
		this.appId =appId;
		this.table =table;
		this.deleteMapping =deleteMapping;
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
		synchronized (DeleteThread.running) {
			if(!this.running){
				DeleteThread.running = true;
				try {
					
					AnhXaLocalServiceUtil.deleteMapping(appId, table, deleteMapping);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					DeleteThread.running = false;
				}finally{
					DeleteThread.running = false;
				}
			}
		}
		
	}
}
