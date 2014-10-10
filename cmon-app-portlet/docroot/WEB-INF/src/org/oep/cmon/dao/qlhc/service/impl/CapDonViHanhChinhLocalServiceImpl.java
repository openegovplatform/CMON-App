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


package org.oep.cmon.dao.qlhc.service.impl;

import java.util.List;

import org.oep.cmon.dao.qlhc.service.base.CapDonViHanhChinhLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException;
import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;

/**
 * The implementation of the cap don vi hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.qlhc.service.base.CapDonViHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil
 */
/**
*
* CapDonViHanhChinhLocalServiceImpl class
*   
* This class is used to get CapDonViHanhChinh information 
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
public class CapDonViHanhChinhLocalServiceImpl
	extends CapDonViHanhChinhLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.qlhc.service.CapDonViHanhChinhLocalServiceUtil} to access the cap don vi hanh chinh local service.
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
	  * @return List<CapDonViHanhChinh>
	  */
	public List<CapDonViHanhChinh> findAll() throws SystemException {
		return capDonViHanhChinhPersistence.findAll();
	}
	/**
	  * This is fucntion findByMaCapDonViHanhChinh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return CapDonViHanhChinh
	  */
	public CapDonViHanhChinh findByMaCapDonViHanhChinh(String ma) throws SystemException, NoSuchCapDonViHanhChinhException {
		return capDonViHanhChinhPersistence.findByMaDonViHanhChinh(ma);
	}
	/**
	  * This is fucntion findByTenCapDonViHanhChinh 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return CapDonViHanhChinh
	  */
	public CapDonViHanhChinh findByTenCapDonViHanhChinh(String ten) throws SystemException, NoSuchCapDonViHanhChinhException {
		return capDonViHanhChinhPersistence.findByTenDonViHanhChinh(ten);
		
	}
	/**
	  * This is fucntion findByDaXoa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<CapDonViHanhChinh>
	  */
	public List<CapDonViHanhChinh> findByDaXoa(int daXoa) throws SystemException {
		return capDonViHanhChinhPersistence.findByTrangThai(daXoa);
	}
	/**
	  * This is fucntion findByCap 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long cap
	  * @return List<CapDonViHanhChinh>
	  */
	public List<CapDonViHanhChinh> findByCap(long cap) throws SystemException {
		return capDonViHanhChinhPersistence.findByCap(cap);
	}
}