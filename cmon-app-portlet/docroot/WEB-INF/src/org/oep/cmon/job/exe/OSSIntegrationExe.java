package org.oep.cmon.job.exe;

import java.util.Date;

import org.oep.cmon.job.process.IJobProcess;

import org.oep.cmon.dao.job.model.DanhSachJob;
import org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

/** 
 * This is class OSSIntegrationExe
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  28-May-2013  Nam Dinh    Create new
 */
public class OSSIntegrationExe implements MessageListener{
	
	/**
	 * This is  function receive
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
		try {
			// Fetch Job
			DanhSachJob danhSachJob = DanhSachJobLocalServiceUtil.findByJobId(100);
			
			// Build parameters
			
			String[] args = new String[4];
			
			args[0] = danhSachJob.getJobClass();
			
			args[1] = String.valueOf(danhSachJob.getJobId());
			
			args[2] = danhSachJob.getJobName();
			
			args[3] = "0"; // Scheduled
			
			IJobProcess job = (IJobProcess)(Class.forName(danhSachJob.getJobClass()).newInstance());
			
			job.run(args);
		} catch (Exception e) {
			e.printStackTrace();
		}				
	}
}
