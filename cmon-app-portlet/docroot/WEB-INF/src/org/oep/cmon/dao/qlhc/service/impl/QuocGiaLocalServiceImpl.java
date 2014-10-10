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

import org.oep.cmon.dao.qlhc.service.base.QuocGiaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.qlhc.NoSuchQuocGiaException;
import org.oep.cmon.dao.qlhc.model.QuocGia;

/**
 * The implementation of the quoc gia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.qlhc.service.QuocGiaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see org.oep.cmon.dao.qlhc.service.base.QuocGiaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil
 */
/**
*
* QuocGiaLocalServiceImpl class
*   
* This class is used to get QuocGia information 
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
public class QuocGiaLocalServiceImpl extends QuocGiaLocalServiceBaseImpl {

	/**
	  * This is fucntion findAll
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<QuocGia>
	  */
	@Override
	public List<QuocGia> findAll() throws SystemException {
		return quocGiaFinder.findAll();
	}
	
	/**
	  * This is fucntion findByMaQuocGia
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return QuocGia
	  */
	public QuocGia findByMaQuocGia(String ma) throws SystemException, NoSuchQuocGiaException {
			return quocGiaPersistence.findByMaQuocGia(ma);
	}
	
	/**
	  * This is fucntion findByTen 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return QuocGia
	  */
	public QuocGia findByTen(String ten) throws SystemException, NoSuchQuocGiaException {
		return quocGiaPersistence.findByTen(ten);
		
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
	  * @return List<QuocGia>
	  */
	public List<QuocGia> findByDaXoa(int daXoa) throws SystemException, NoSuchQuocGiaException {
		return quocGiaFinder.findAll();
		
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.qlhc.service.QuocGiaLocalServiceUtil} to access the quoc gia local service.
	 */
}