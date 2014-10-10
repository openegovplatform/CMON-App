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

import org.oep.cmon.dao.dn.service.base.NganhNgheKinhDoanhLocalServiceBaseImpl;

import org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;
import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;

/**
 * The implementation of the nganh nghe kinh doanh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liemnn
 * @see org.oep.cmon.dao.dn.service.base.NganhNgheKinhDoanhLocalServiceBaseImpl
 * @see org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalServiceUtil
 */
/**
*
* NganhNgheKinhDoanhLocalServiceImpl class
*   
* This class is used to get NganhNgheKinhDoanh information 
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

public class NganhNgheKinhDoanhLocalServiceImpl
	extends NganhNgheKinhDoanhLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.dn.service.NganhNgheKinhDoanhLocalServiceUtil} to access the nganh nghe kinh doanh local service.
	 */
	/**
	  * This is fucntion find NganhNgheKinhDoanh by Cap va trang thai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long cap, int daXoa
	  * @return List<NganhNgheKinhDoanh>
	  */
	public  java.util.List<NganhNgheKinhDoanh> findByCap(
			long cap, int daXoa)
			throws com.liferay.portal.kernel.exception.SystemException {
			return nganhNgheKinhDoanhPersistence.findByCap(cap, daXoa);
		}
	/**
	  * This is fucntion find NganhNgheKinhDoanh by code 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String code,int daxoa
	  * @return NganhNgheKinhDoanh
	  */
	public NganhNgheKinhDoanh findByCode(String code,int daxoa){
		try {
			return nganhNgheKinhDoanhPersistence.findByMa(code, daxoa);
		} catch (NoSuchNganhNgheKinhDoanhException e) {
			// TODO Auto-generated catch block
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}