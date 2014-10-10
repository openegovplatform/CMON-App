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

import org.oep.cmon.dao.dvc.service.base.DoiTuongSuDungLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;

/**
 * The implementation of the doi tuong su dung local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.dvc.service.base.DoiTuongSuDungLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil
 */

/**
*
* DoiTuongSuDungLocalServiceImpl class
*   
* This class is used to get DoiTuongSuDung information 
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
public class DoiTuongSuDungLocalServiceImpl
	extends DoiTuongSuDungLocalServiceBaseImpl {
	
	/**
	  * This is fucntion find DoiTuongSuDung by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return DoiTuongSuDung
	  */
	public DoiTuongSuDung findByMa(String ma) throws SystemException {
		return doiTuongSuDungPersistence.fetchByMa(ma);
	}
	/**
	  * This is fucntion find DoiTuongSuDung by ten 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ten
	  * @return DoiTuongSuDung
	  */
	public DoiTuongSuDung findByTen(String ten) throws SystemException {
		return doiTuongSuDungPersistence.fetchByTen(ten);
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dvc.service.DoiTuongSuDungLocalServiceUtil} to access the doi tuong su dung local service.
	 */
	/**
	  * This is fucntion find DoiTuongSuDung by trangthai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<DoiTuongSuDung>
	  */
	public List<DoiTuongSuDung> getDSDoiTuongSuDung(int daXoa){
		try {
			return doiTuongSuDungPersistence.findByTrangThai(daXoa);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}