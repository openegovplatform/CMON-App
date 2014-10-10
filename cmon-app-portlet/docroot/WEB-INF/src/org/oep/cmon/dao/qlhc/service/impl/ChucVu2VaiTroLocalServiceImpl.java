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

import org.oep.cmon.dao.qlhc.service.base.ChucVu2VaiTroLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;

/**
 * The implementation of the chuc vu2 vai tro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.qlhc.service.base.ChucVu2VaiTroLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil
 */
/**
*
* ChucVu2VaiTroLocalServiceImpl class
*   
* This class is used to get ChucVu2VaiTro information 
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
public class ChucVu2VaiTroLocalServiceImpl
	extends ChucVu2VaiTroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.qlhc.service.ChucVu2VaiTroLocalServiceUtil} to access the chuc vu2 vai tro local service.
	 */
	
	/**
	  * This is fucntion findByIdVaiTro 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long vaiTroId
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdVaiTro(long vaiTroId)  {

		try {
			return chucVu2VaiTroPersistence.findByVaiTroId(vaiTroId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	/**
	  * This is fucntion findByIdCoQuanQuanLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdCoQuanQuanLy(long coQuanQuanLyId)  {

		try {
			return chucVu2VaiTroPersistence.findByCoQuanQuanLyId(coQuanQuanLyId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	  * This is fucntion findByIdChucVu
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long chucVuId
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdChucVu(long chucVuId) {

		try {
			return chucVu2VaiTroPersistence.findByChucVuId(chucVuId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByIdVaiTroAndDaXoa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long vaiTroId, int daXoa
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdVaiTroAndDaXoa(long vaiTroId, int daXoa) {

		try {
			return chucVu2VaiTroPersistence.findByVaiTroIdAndDaXoa(vaiTroId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	  * This is fucntion deleteByChucVuID
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long chucVuId
	  * @return void
	  */
	public void deleteByChucVuID(long chucVuId)  {

		try {
			chucVu2VaiTroPersistence.removeByChucVuId(chucVuId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	  * This is fucntion deleteByVaiTroID
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long vaiTroId
	  * @return void
	  */
	public void deleteByVaiTroID(long vaiTroId)  {

		try {
			chucVu2VaiTroPersistence.removeByVaiTroId(vaiTroId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/**
	  * This is fucntion findChucVu2VaiTro 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long vaiTroId, long coQuanQuanLyId, long chucVuId
	  * @return ChucVu2VaiTro
	  */
	public ChucVu2VaiTro findChucVu2VaiTro(long vaiTroId, long coQuanQuanLyId, long chucVuId) {

		try {
			return chucVu2VaiTroPersistence.fetchByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
		}

		return null;
	}
	
	
	/**
	  * This is fucntion findByIdCoQuanQuanLyAndDaXoa 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long coQuanQuanLyId, int daXoa
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdCoQuanQuanLyAndDaXoa(long coQuanQuanLyId, int daXoa) {

		try {
			return chucVu2VaiTroPersistence.findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	  * This is fucntion findByIdChucVuAndDaXoa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long chucVuId, int daXoa
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdChucVuAndDaXoa(long chucVuId, int daXoa){

		try {
			return chucVu2VaiTroPersistence.findByChucVuIdAndDaXoa(chucVuId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	  * This is fucntion findTrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findTrangThai(int daXoa) {

		try {
			return chucVu2VaiTroPersistence.findByDaXoa(daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	/**
	  * This is fucntion findByIdChucVuAndIdCoQuanQuanLy 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long chucVuId, long coQuanQuanLyId, int daXoa
	  * @return List<ChucVu2VaiTro>
	  */
	public List<ChucVu2VaiTro> findByIdChucVuAndIdCoQuanQuanLy(long chucVuId, long coQuanQuanLyId, int daXoa) {

		try {
			return chucVu2VaiTroPersistence.findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId, daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
}