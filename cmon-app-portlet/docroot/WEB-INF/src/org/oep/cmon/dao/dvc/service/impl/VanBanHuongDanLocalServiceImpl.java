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


package org.oep.cmon.dao.dvc.service.impl;

import java.util.List;

import org.oep.cmon.dao.dvc.service.base.VanBanHuongDanLocalServiceBaseImpl;

import org.oep.cmon.dao.dvc.model.VanBanHuongDan;

/**
 * The implementation of the van ban huong dan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.VanBanHuongDanLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil
 */

/**
*
* VanBanHuongDanLocalServiceImpl class
*   
* This class is used to get VanBanHuongDan information 
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
public class VanBanHuongDanLocalServiceImpl
	extends VanBanHuongDanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.VanBanHuongDanLocalServiceUtil} to access the van ban huong dan local service.
	 */
	/**
	  * This is fucntion find VanBanHuongDan by thuTucHanhChinhId, loaiTaiLieu
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId, long loaiTaiLieu
	  * @return List<VanBanHuongDan>
	  */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(long thuTucHanhChinhId, long loaiTaiLieu){
		try {
			return vanBanHuongDanPersistence.findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId, loaiTaiLieu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion find VanBanHuongDan by thuTucHanhChinhId, loaiTaiLieu,status
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId, long loaiTaiLieu, int status
	  * @return List<VanBanHuongDan>
	  */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuAndDaXoa(long thuTucHanhChinhId, long loaiTaiLieu, int status){
		try {
			return vanBanHuongDanPersistence.findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId, loaiTaiLieu, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	  * This is fucntion find VanBanHuongDan by thuTucHanhChinhId, loaiTaiLieu,status
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long thuTucHanhChinhId, long loaiTaiLieu, int status
	  * @return List<VanBanHuongDan>
	  */
	public List<VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(long thuTucHanhChinhId, long loaiTaiLieu, int status){
		try {
			return vanBanHuongDanPersistence.findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId, loaiTaiLieu, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}