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


package org.oep.cmon.dao.hosohcc.service.impl;

import java.util.List;

import org.oep.cmon.dao.hosohcc.service.base.TrangThaiHoSoLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;

/**
 * The implementation of the trang thai ho so local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see org.oep.cmon.dao.hosohcc.service.base.TrangThaiHoSoLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil
 */
/**
*
* TrangThaiHoSoLocalServiceImpl class
*   
* This class is used to get TrangThaiHoSo information 
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
public class TrangThaiHoSoLocalServiceImpl
	extends TrangThaiHoSoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.TrangThaiHoSoLocalServiceUtil} to access the trang thai ho so local service.
	 */
	
	/**
	  * This is fucntion findAll 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<TrangThaiHoSo>
	  */
	public List<TrangThaiHoSo> findAll() throws SystemException {
		return trangThaiHoSoPersistence.findAll();
	}
	
	/**
	  * This is fucntion findAll
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int start, int end
	  * @return List<TrangThaiHoSo>
	  */
	public List<TrangThaiHoSo> findAll(int start, int end) throws SystemException {
		return trangThaiHoSoPersistence.findAll(start, end);
	}

	/**
	  * This is fucntion findById
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long id
	  * @return TrangThaiHoSo
	  */
	public TrangThaiHoSo findById(long id) throws SystemException {
		try {
			return trangThaiHoSoPersistence.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion getListTrangThaiHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<TrangThaiHoSo>
	  */
	public List<TrangThaiHoSo> getListTrangThaiHoSo(int daXoa) throws SystemException {
		return trangThaiHoSoPersistence.findByTrangThaiHoSo(daXoa);
	}
}