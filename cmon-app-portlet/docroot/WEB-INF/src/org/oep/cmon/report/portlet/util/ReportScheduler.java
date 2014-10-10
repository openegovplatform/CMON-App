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

package org.oep.cmon.report.portlet.util;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.oep.cmon.dao.report.service.ReportThongKeLocalServiceUtil;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/**
 * This is class ReportScheduler  
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  3-March-2013  Nam Dinh    Create new
 */
public class ReportScheduler implements MessageListener {

	/**
	 * This is function excelTongHopChiTiet
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param arg0
	 * @throws MessageListenerException
	 */
	public void receive(Message arg0) throws MessageListenerException {

		// Here is the buisness logic to be written as per your requirement
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		ReportThongKeLocalServiceUtil.reportScheduler();
	}

}