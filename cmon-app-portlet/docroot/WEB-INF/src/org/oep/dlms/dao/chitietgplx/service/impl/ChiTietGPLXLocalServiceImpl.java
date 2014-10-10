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


package org.oep.dlms.dao.chitietgplx.service.impl;

import org.oep.dlms.dao.chitietgplx.service.base.ChiTietGPLXLocalServiceBaseImpl;

/**
 * The implementation of the chi tiet g p l x local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.dlms.dao.chitietgplx.service.ChiTietGPLXLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author hunghq
 * @see vn.dtt.dlms.dao.chitietgplx.service.base.ChiTietGPLXLocalServiceBaseImpl
 * @see vn.dtt.dlms.dao.chitietgplx.service.ChiTietGPLXLocalServiceUtil
 */

/**
*
* ChiTietGPLXLocalServiceImpl class
*   
* This class is used to get ChiTietGPLX information 
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
public class ChiTietGPLXLocalServiceImpl extends ChiTietGPLXLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.dlms.dao.chitietgplx.service.ChiTietGPLXLocalServiceUtil} to access the chi tiet g p l x local service.
	 */
	/**
	  * This is fucntion findByGPLX
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<ChiTietGPLX>
	  */
	public java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
			long idGPLX) throws com.liferay.portal.kernel.exception.SystemException {
		return chiTietGPLXPersistence.findByGPLX(idGPLX);
	}
}