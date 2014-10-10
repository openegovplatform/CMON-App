package org.oep.cmon.job.process;

import java.util.Date;

import org.oep.cmon.job.activity.IJobActivity;
import org.oep.cmon.job.activity.UpdateDocumentResultJa;
import org.oep.cmon.job.activity.UpdateDocumentStatusJa;
import org.oep.cmon.job.activity.UpdateOssDocumentJa;


/** 
 * This is abstract class OSSIntegrationJp
 * 
 * This interface defines method for job process class. It implements some logging information
 * 
 * 
 * Version: 1.0
 *  
 * History: 
 *   DATE        AUTHOR      DESCRIPTION 
 *  ------------------------------------------------- 
 *  24-May-2013  Nam Dinh    Create new
 */
public class OSSIntegrationJp extends JobProcessAbst {

	/**
	 * This is  function runProcess
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param args
	 * @throws Exception
	 */  
	@Override
	public void runProcess(String[] args) throws Exception {
		IJobActivity updateOssDocmentJa = new UpdateOssDocumentJa();		
		// Run the insert OSS document JA
		updateOssDocmentJa.runActivity(args);	
		
		// Run the update status
		IJobActivity updateStatusJa = new UpdateDocumentStatusJa();
		updateStatusJa.runActivity(args);
		
		// Run the update result
		IJobActivity updateDocumentResultJa = new UpdateDocumentResultJa();
		updateDocumentResultJa.runActivity(args);
	}
}
