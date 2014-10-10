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

import org.oep.cmon.dao.qlhc.service.base.DonViHanhChinhLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;
import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;
import org.oep.cmon.dao.qlhc.service.persistence.DonViHanhChinhFinderUtil;

/**
 * The implementation of the don vi hanh chinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.qlhc.service.base.DonViHanhChinhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil
 */
/**
*
* DonViHanhChinhLocalServiceImpl class
*   
* This class is used to get DonViHanhChinh information 
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
public class DonViHanhChinhLocalServiceImpl
	extends DonViHanhChinhLocalServiceBaseImpl {

	/**
	  * This is fucntion findByChaId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long chaId,int daXoa
	  * @return List<DonViHanhChinh>
	  */
	public List<DonViHanhChinh> findByChaId(long chaId,int daXoa){

		try {
			return donViHanhChinhPersistence.findByChaId(chaId,daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByQuocGiaId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long quocGiaId, long capDonViHanhChinhId, int daXoa
	  * @return List<DonViHanhChinh>
	  */
	public List<DonViHanhChinh> findByQuocGiaId(long quocGiaId, long capDonViHanhChinhId, int daXoa){

		try {
			return donViHanhChinhPersistence.findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	  * @return List<DonViHanhChinh>
	  */
	public List<DonViHanhChinh> findByDaXoa(int daXoa) throws SystemException {

		return donViHanhChinhPersistence.findByTrangThai(daXoa);
	}
	
	/**
	  * This is fucntion findByMaDVHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return DonViHanhChinh
	  */
	public DonViHanhChinh findByMaDVHC(String ma) throws SystemException, NoSuchDonViHanhChinhException {

		return donViHanhChinhPersistence.findByMaDVHC(ma);
	}
	
	/**
	  * This is fucntion findByTenDVHC 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return DonViHanhChinh
	  */
	public DonViHanhChinh findByTenDVHC(String ten) throws SystemException, NoSuchDonViHanhChinhException {

		return donViHanhChinhPersistence.findByTenDVHC(ten);
	}
	
	/**
	  * This is fucntion getDanhSachTinhThanh
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<DonViHanhChinh>
	  */
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDanhSachTinhThanh(){
		return DonViHanhChinhFinderUtil.dsTinhThanh();
	}
	
	/**
	  * This is fucntion getDSDonViHanhChinhTheoCapId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long capId,int daXoa
	  * @return List<DonViHanhChinh>
	  */
	public List<DonViHanhChinh> getDSDonViHanhChinhTheoCapId(Long capId,int daXoa){
		try {
			return donViHanhChinhPersistence.findByCapDonViHanhChinhId(capId, daXoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.qlhc.service.DonViHanhChinhLocalServiceUtil} to access the don vi hanh chinh local service.
	 */
}