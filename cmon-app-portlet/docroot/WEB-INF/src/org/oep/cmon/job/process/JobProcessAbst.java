package org.oep.cmon.job.process;

import java.util.Date;

import org.oep.cmon.dao.job.model.impl.TrangThaiJobImpl;

import org.oep.cmon.dao.job.model.TrangThaiJob;
import org.oep.cmon.dao.job.service.TrangThaiJobLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/** 
 * This is abstract class JobProcessAbst
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
public abstract class JobProcessAbst implements IJobProcess {
	
	/** Success status */
	private static final int SUCCESS_STATUS = 0;
	
	/** Failure status */
	private static final int FAILURE_STATUS = 1;
	
	/**
	 * This is  function run
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param args
	 */  
	public void run(String[] args) {
		try {
			// Get the job id from argument, the first argument will be the Job process class
			int jobId = Integer.parseInt(args[1]);
			
			// Get the job name
			String jobName = args[2];
			
			int runMode = Integer.parseInt(args[3]);
			
			// Log start time to DB
			long id = this.logStart(jobId, jobName, runMode);
			
			// Error message
			String errMsg = StringPool.BLANK;
			
			try {
				this.runProcess(args);
			} catch (Exception e) {
				e.printStackTrace();
				// Get the error message during execution
				errMsg = e.getMessage() + e.toString();
			}
			
			// Log the end status
			this.logEnd(id, errMsg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * The inherit class will implement this function
	 * 
	 * @param args
	 * @throws Exception
	 */
	public abstract void runProcess(String[] args) throws Exception;
	
	/**
	 * This is  function logStart
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param jobId
	 * @param jobName
	 * @param runMode
	 * @throws SystemException
	 * @return long
	 */  
	private long logStart(int jobId, String jobName, int runMode) throws SystemException {
		TrangThaiJob trangThaiJob = new TrangThaiJobImpl();
		
		trangThaiJob.setID(CounterLocalServiceUtil.increment("job_trangthaijob"));
		
		trangThaiJob.setJobId(jobId);
		
		trangThaiJob.setJobName(jobName);
		
		trangThaiJob.setRunMode(runMode);
		
		trangThaiJob.setStartTime(new Date());
		
		TrangThaiJobLocalServiceUtil.addTrangThaiJob(trangThaiJob);
		
		return trangThaiJob.getID();
	}
	
	/**
	 * This is  function logEnd
	 * Version: 1.0
	 *  
	 * History: 
	 *   DATE        AUTHOR      DESCRIPTION 
	 *  ------------------------------------------------- 
	 *  3-March-2013  Nam Dinh    Create new
	 * @param id
	 * @param errMsg
	 * @throws SystemException 
	 * @throws PortalException 
	 */  
	private void logEnd(long id, String errMsg) throws PortalException, SystemException {
		// Log end time, status
		TrangThaiJob trangThaiJob = TrangThaiJobLocalServiceUtil.getTrangThaiJob(id);
		
		trangThaiJob.setEndTime(new Date());
		
		if (Validator.isNull(errMsg)) {
			trangThaiJob.setStatus(SUCCESS_STATUS); // Success			
		} else {
			trangThaiJob.setStatus(FAILURE_STATUS);
			
			trangThaiJob.setMessage(errMsg);
		}
		
		TrangThaiJobLocalServiceUtil.updateTrangThaiJob(trangThaiJob);		
	}
}
