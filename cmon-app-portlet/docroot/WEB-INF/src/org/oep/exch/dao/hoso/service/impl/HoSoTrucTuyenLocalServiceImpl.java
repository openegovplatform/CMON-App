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


package org.oep.exch.dao.hoso.service.impl;

import java.util.List;

import org.oep.exch.dao.hoso.service.base.HoSoTrucTuyenLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;

/**
 * The implementation of the ho so truc tuyen local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NAM
 * @see org.oep.exch.dao.hoso.service.base.HoSoTrucTuyenLocalServiceBaseImpl
 * @see org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil
 */
/**
*
* HoSoTrucTuyenLocalServiceImpl class
*   
* This class is used to get HoSoTrucTuyen information 
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
public class HoSoTrucTuyenLocalServiceImpl
	extends HoSoTrucTuyenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.exch.dao.hoso.service.HoSoTrucTuyenLocalServiceUtil} to access the ho so truc tuyen local service.
	 */
	/**
	  * This is fucntion findByNoiChuyenHoSo 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String dest, int trangThai
	  * @return List<HoSoTrucTuyen>
	  */
	public List<HoSoTrucTuyen> findByNoiChuyenHoSo(String dest, int trangThai) throws SystemException {
		return hoSoTrucTuyenPersistence.findByNoiChuyenHoSo(dest, trangThai);
	}
	/**
	  * This is fucntion findByMaDonViTiepNhan 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maDonViTiepNhan, int trangThai
	  * @return List<HoSoTrucTuyen>
	  */
	public List<HoSoTrucTuyen> findByMaDonViTiepNhan(String maDonViTiepNhan, int trangThai) throws SystemException {
		return hoSoTrucTuyenPersistence.findByMaDonViTiepNhan(maDonViTiepNhan, trangThai);
	}
}