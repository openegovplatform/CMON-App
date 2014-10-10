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

package org.oep.cmon.admin.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.job.process.IJobProcess;

import org.oep.cmon.dao.job.model.DanhSachJob;
import org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;

/**
 * This is class RunJobAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class RunJobAction {
	
	/**
	 * This is function runJob
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void runJob(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long jobRecordId = ParamUtil.getInteger(actionRequest, "id");
		
		// Fetch Job
		DanhSachJob danhSachJob = DanhSachJobLocalServiceUtil.getDanhSachJob(jobRecordId);
		
		// Build parameters
		
		String[] args = new String[4];
		
		args[0] = danhSachJob.getJobClass();
		
		args[1] = String.valueOf(danhSachJob.getJobId());
		
		args[2] = danhSachJob.getJobName();
		
		args[3] = "1"; // Manual start a job
		
		IJobProcess job = (IJobProcess)(Class.forName(danhSachJob.getJobClass()).newInstance());
		
		job.run(args);
		
		// Redirect
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/job_monitor.jsp");
	}
}
