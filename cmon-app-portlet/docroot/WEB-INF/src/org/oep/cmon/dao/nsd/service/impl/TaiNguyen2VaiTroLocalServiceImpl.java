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


package org.oep.cmon.dao.nsd.service.impl;
import java.util.List;

import org.oep.cmon.dao.nsd.service.base.TaiNguyen2VaiTroLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;


import org.oep.cmon.dao.nsd.NoSuchTaiNguyen2VaiTroException;

/**
 * The implementation of the tai nguyen2 vai tro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.nsd.service.base.TaiNguyen2VaiTroLocalServiceBaseImpl
 * @see org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil
 */
/**
*
* TaiNguyen2VaiTroLocalServiceImpl class
*   
* This class is used to get TaiNguyen2VaiTro information 
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
public class TaiNguyen2VaiTroLocalServiceImpl
	extends TaiNguyen2VaiTroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.nsd.service.TaiNguyen2VaiTroLocalServiceUtil} to access the tai nguyen2 vai tro local service.
	 */
	/**
	  * This is fucntion findByVaiTroID
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Long vaiTroId, int daXoa
	  * @return List<TaiNguyen2VaiTro>
	  */
	public List<TaiNguyen2VaiTro> findByVaiTroID(Long vaiTroId, int daXoa) throws SystemException, NoSuchTaiNguyen2VaiTroException {
		return taiNguyen2VaiTroPersistence.findByVaiTroID(vaiTroId, daXoa);
	}
}