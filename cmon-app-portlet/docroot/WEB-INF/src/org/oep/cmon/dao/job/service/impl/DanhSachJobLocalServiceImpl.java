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


package org.oep.cmon.dao.job.service.impl;

import org.oep.cmon.dao.job.service.base.DanhSachJobLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.job.NoSuchDanhSachJobException;
import org.oep.cmon.dao.job.model.DanhSachJob;

/**
 * The implementation of the danh sach job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.job.service.DanhSachJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhNT
 * @see org.oep.cmon.dao.job.service.base.DanhSachJobLocalServiceBaseImpl
 * @see org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil
 */

/**
*
* DanhSachJobLocalServiceImpl class
*   
* This class is used to get DanhSachJob information 
* from database
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
public class DanhSachJobLocalServiceImpl extends DanhSachJobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil} to access the danh sach job local service.
	 */
	/**
	  * This is fucntion findByJobClass
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String jobClassName
	  * @return DanhSachJob
	  */
	public DanhSachJob findByJobClass(String jobClassName) throws NoSuchDanhSachJobException, SystemException {
		return danhSachJobPersistence.findByJobClass(jobClassName);
	}
	/**
	  * This is fucntion findByJobId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int jobId
	  * @return DanhSachJob
	  */
	public DanhSachJob findByJobId(int jobId) throws NoSuchDanhSachJobException, SystemException {
		return danhSachJobPersistence.findByJobId(jobId);
	}
}