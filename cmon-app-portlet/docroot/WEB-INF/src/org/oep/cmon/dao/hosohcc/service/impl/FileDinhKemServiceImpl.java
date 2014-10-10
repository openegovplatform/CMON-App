/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.hosohcc.service.impl;

import org.oep.cmon.dao.hosohcc.service.base.FileDinhKemServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.hosohcc.model.FileDinhKem;
import org.oep.cmon.dao.hosohcc.service.FileDinhKemLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.persistence.FileDinhKemUtil;

/**
 * The implementation of the file dinh kem remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.FileDinhKemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LIEMNn
 * @see org.oep.cmon.dao.hosohcc.service.base.FileDinhKemServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.FileDinhKemServiceUtil
 */
/**
*
* FileDinhKemServiceImpl class
*   
* This class is used to get FileDinhKem information 
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
public class FileDinhKemServiceImpl extends FileDinhKemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.FileDinhKemServiceUtil} to access the file dinh kem remote service.
	 */
	/**
	  * This is fucntion addFileDinhKem
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param FileDinhKem
	  * @return FileDinhKem
	  */
	public FileDinhKem addFileDinhKem(FileDinhKem fileDinhKem){
		try {
			FileDinhKemLocalServiceUtil.addFileDinhKem(fileDinhKem);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}