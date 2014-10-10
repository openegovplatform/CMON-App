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


package org.oep.cmon.dao.dn.service.impl;

import org.oep.cmon.dao.dn.service.base.DoanhNghiepLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;
import org.oep.cmon.dao.dn.model.DoanhNghiep;


/**
 * The implementation of the doanh nghiep local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dn.service.DoanhNghiepLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.dn.service.base.DoanhNghiepLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil
 */

/**
*
* DoanhNghiepLocalServiceImpl class
*   
* This class is used to get DoanhNghiep information 
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
public class DoanhNghiepLocalServiceImpl extends DoanhNghiepLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dn.service.DoanhNghiepLocalServiceUtil} to access the doanh nghiep local service.
	 */
	/**
	  * This is fucntion find DoanhNghiep by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return DoanhNghiep
	  */
	public DoanhNghiep findByMaDoanhNghiep(String ma) {

		try {
			return doanhNghiepPersistence.findByMa(ma);
		} catch (Exception e) {
		}
		return null;
	}
	/**
	  * This is fucntion find DoanhNghiep by MaSoThue 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of MaSoThue
	  * @return DoanhNghiep
	  */
	public DoanhNghiep findByMaSoThue(String ma)  {

		try {
			return doanhNghiepPersistence.findByMaSoThue(ma);
		} catch (Exception e) {
		}
		return null;
	}
	/**
	  * This is fucntion find MaSoThue by ten 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of Ten
	  * @return MaSoThue
	  */
	public DoanhNghiep findByTen(String ten)  {

		try {
			return doanhNghiepPersistence.findByTen(ten);
		} catch (Exception e) {
		}
		return null;
	}
	/**
	  * This is fucntion find DoanhNghiep by soGCNDKKD 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of soGCNDKKD
	  * @return DoanhNghiep
	  */
	public DoanhNghiep findBySoGCNDKKD(String soGCNDKKD)  {

		try {
			return doanhNghiepPersistence.findBySoGCNDKKD(soGCNDKKD);
		} catch (Exception e) {
		}
		return null;
	}
	/**
	  * This is fucntion find DoanhNghiep by nguoiDaiDienId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long nguoiDaiDienId
	  * @return List<DoanhNghiep>
	  */
	public java.util.List<DoanhNghiep> getDoanhNghiep2NguoiDaiDienId(
			long nguoiDaiDienId) {
		return doanhNghiepFinder.getDoanhNghiep2NguoiDaiDienId(nguoiDaiDienId);
	}
	/**
	  * This is fucntion find DoanhNghiep by loaiDoiTuongId  ,NguoiDaiDien
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long nguoiDaiDienId, long loaiDoiTuongId
	  * @return List<DoanhNghiep>
	  */
	public java.util.List<DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
			long nguoiDaiDienId, long loaiDoiTuongId)
			throws com.liferay.portal.kernel.exception.SystemException{
		try {
			return doanhNghiepPersistence
					.findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,loaiDoiTuongId);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	  * This is fucntion find DoanhNghiep by nguoiDaiDienId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long nguoiDaiDienId
	  * @return DoanhNghiep
	  */
	public DoanhNghiep findByNguoiDaiDienId(
			long nguoiDaiDienId){
		try {
			return doanhNghiepPersistence.findByNguoiDaiDienId(nguoiDaiDienId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} 
		return null;
	}

	
}