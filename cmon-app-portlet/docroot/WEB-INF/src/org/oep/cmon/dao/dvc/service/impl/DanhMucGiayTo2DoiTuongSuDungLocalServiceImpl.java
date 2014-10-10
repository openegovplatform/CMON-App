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

import org.oep.cmon.dao.dvc.service.base.DanhMucGiayTo2DoiTuongSuDungLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;

/**
 * The implementation of the danh muc giay to2 doi tuong su dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.DanhMucGiayTo2DoiTuongSuDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil
 */
/**
*
* DanhMucGiayTo2DoiTuongSuDungLocalServiceImpl class
*   
* This class is used to get DanhMucGiayTo2DoiTuongSuDung information 
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
public class DanhMucGiayTo2DoiTuongSuDungLocalServiceImpl
	extends DanhMucGiayTo2DoiTuongSuDungLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.DanhMucGiayTo2DoiTuongSuDungLocalServiceUtil} to access the danh muc giay to2 doi tuong su dung local service.
	 */
	/**
	  * This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiGiayToId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long loaiGiayToId
	  * @return List<DanhMucGiayTo2DoiTuongSuDung>
	  */
	public List<DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiGT_DSDMGT2DTSD(Long loaiGiayToId){
		try {
			return danhMucGiayTo2DoiTuongSuDungPersistence.findByloaiGiayToId(loaiGiayToId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	  * This is fucntion get DanhMucGiayTo2DoiTuongSuDung by loaiDoiTuongId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long loaiDoiTuongId
	  * @return List<DanhMucGiayTo2DoiTuongSuDung>
	  */
	public List<DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiDT_DSDMGT2DTSD(Long loaiDoiTuongId){
		try {
			return danhMucGiayTo2DoiTuongSuDungPersistence.findByloaiDoiTuongId(loaiDoiTuongId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}