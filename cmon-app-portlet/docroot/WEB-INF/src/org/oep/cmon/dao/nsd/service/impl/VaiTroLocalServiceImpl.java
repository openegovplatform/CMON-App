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

import org.oep.cmon.dao.nsd.service.base.VaiTroLocalServiceBaseImpl;

import org.oep.cmon.dao.nsd.NoSuchVaiTroException;
import org.oep.cmon.dao.nsd.model.VaiTro;

/**
 * The implementation of the vai tro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.commonapp.dao.nsd.service.VaiTroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.commonapp.dao.nsd.service.base.VaiTroLocalServiceBaseImpl
 * @see org.oep.commonapp.dao.nsd.service.VaiTroLocalServiceUtil
 */
/**
*
* VaiTroLocalServiceImpl class
*   
* This class is used to get VaiTro information 
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
public class VaiTroLocalServiceImpl extends VaiTroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.commonapp.dao.nsd.service.VaiTroLocalServiceUtil} to access the vai tro local service.
	 */
	/**
	  * This is fucntion findTheoTen
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ten
	  * @return VaiTro
	  */
	public  VaiTro findTheoTen(String ten) throws com.liferay.portal.kernel.exception.SystemException, NoSuchVaiTroException {
			return vaiTroPersistence.findByByTen(ten);
		}
	/**
	  * This is fucntion findTheoMa
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String ma
	  * @return VaiTro
	  */
	public  VaiTro findTheoMa(String ma) throws com.liferay.portal.kernel.exception.SystemException, NoSuchVaiTroException {
		return vaiTroPersistence.findByByMa(ma);
	}
	/**
	  * This is fucntion findByTrangThai
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int daXoa
	  * @return List<VaiTro>
	  */
	public  List<VaiTro> findByTrangThai(int daXoa) throws com.liferay.portal.kernel.exception.SystemException, NoSuchVaiTroException {
		return vaiTroPersistence.findByTrangThai(daXoa);
	}
}
