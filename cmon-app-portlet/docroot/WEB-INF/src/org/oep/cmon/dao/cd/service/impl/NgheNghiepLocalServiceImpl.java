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


package org.oep.cmon.dao.cd.service.impl;

import java.util.List;

import org.oep.cmon.dao.cd.service.base.NgheNghiepLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.cd.model.NgheNghiep;

/**
 * The implementation of the nghe nghiep local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cd.service.NgheNghiepLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhNT
 * @see vn.dtt.cmon.dao.cd.service.base.NgheNghiepLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cd.service.NgheNghiepLocalServiceUtil
 */
/**
*
* NgheNghiepLocalServiceImpl class
*   
* This class is used to get NgheNghiep information 
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
public class NgheNghiepLocalServiceImpl extends NgheNghiepLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cd.service.NgheNghiepLocalServiceUtil} to access the nghe nghiep local service.
	 */
	/**
	  * This is fucntion findAll NgheNghiep by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<NgheNghiep>
	  */
	public List<NgheNghiep> findAll() throws SystemException
	{
		return ngheNghiepPersistence.findAll();
	}
}