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


package org.oep.cmon.dao.cd.service.impl;

import java.util.List;

import org.oep.cmon.dao.cd.service.base.GioiTinhLocalServiceBaseImpl;
import org.oep.sharedservice.cmon.Constants;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.cd.NoSuchGioiTinhException;
import org.oep.cmon.dao.cd.model.GioiTinh;

/**
 * The implementation of the gioi tinh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.cd.service.GioiTinhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BinhNT
 * @see vn.dtt.cmon.dao.cd.service.base.GioiTinhLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.cd.service.GioiTinhLocalServiceUtil
 */

/**
*
* GioiTinhLocalServiceImpl class
*   
* This class is used to get GioiTinh information 
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
public class GioiTinhLocalServiceImpl extends GioiTinhLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.cd.service.GioiTinhLocalServiceUtil} to access the gioi tinh local service.
	 */
	/**
	  * This is fucntion get GioiTinh by TrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<GioiTinh>
	  */
	public List<GioiTinh> getDSGioiTinh(){
		try {
			return gioiTinhPersistence.findByTrangThai(Constants.ACTIVATED);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findAll GioiTinh 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param 
	  * @return List<GioiTinh>
	  */
	public List<GioiTinh> findAll() throws SystemException{
		return gioiTinhPersistence.findAll();
	}
	
	/**
	  * This is fucntion find GioiTinh by Ma 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ma
	  * @return List<GioiTinh>
	  */
	public GioiTinh findByMa(String ma) throws SystemException, NoSuchGioiTinhException {
		return gioiTinhPersistence.findByMa(ma);
	}
	
	/**
	  * This is fucntion find GioiTinh by ten 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String : Value of ten
	  * @return GioiTinh
	  */
	public GioiTinh findByTen(String ten) throws SystemException, NoSuchGioiTinhException {
		return gioiTinhPersistence.findByTen(ten);
		
	}
}