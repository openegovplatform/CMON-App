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

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.oep.cmon.dao.job.model.TrangThaiJob;
import org.oep.cmon.dao.job.service.TrangThaiJobLocalServiceUtil;

import com.liferay.portal.kernel.util.ParamUtil;
/**
 * This is class JobStatusAction
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class JobStatusAction {
	
	/**
	 * This is function search JobStatus
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
	public void searchJobStatus(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// Get search keyword, the keyword can either be IdNo, FullName or email address
		int jobId = ParamUtil.getInteger(actionRequest, "keyWord");
		
		List<TrangThaiJob> trangThaiJobLst = null;
		if ( jobId > 0) {		
			trangThaiJobLst = TrangThaiJobLocalServiceUtil.findByJobId(jobId);
		} else {
			trangThaiJobLst = TrangThaiJobLocalServiceUtil.getTrangThaiJobs(0, TrangThaiJobLocalServiceUtil.getTrangThaiJobsCount());
		}
		
		// Set the result back to session
		actionRequest.setAttribute("SEARCH_TRANGTHAI_JOB_RESULT", trangThaiJobLst);
		
		actionResponse.setRenderParameter("jspPage", "/html/portlet/admin/job_monitor.jsp");
		
		actionResponse.setRenderParameter("keyWord", jobId + "");
	}
}
