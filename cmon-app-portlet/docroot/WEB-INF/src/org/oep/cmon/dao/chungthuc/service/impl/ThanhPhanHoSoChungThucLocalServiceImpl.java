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


package org.oep.cmon.dao.chungthuc.service.impl;

import java.util.List;

import org.oep.cmon.dao.chungthuc.service.base.ThanhPhanHoSoChungThucLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc;

/**
 * The implementation of the thanh phan ho so chung thuc local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.dtt.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vietho
 * @see vn.dtt.cmon.dao.chungthuc.service.base.ThanhPhanHoSoChungThucLocalServiceBaseImpl
 * @see vn.dtt.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil
 */
/**
*
* ThanhPhanHoSoChungThucLocalServiceImpl class
*   
* This class is used to get ThanhPhanHoSoChungThuc information 
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
public class ThanhPhanHoSoChungThucLocalServiceImpl
	extends ThanhPhanHoSoChungThucLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.dtt.cmon.dao.chungthuc.service.ThanhPhanHoSoChungThucLocalServiceUtil} to access the thanh phan ho so chung thuc local service.
	 */
	/**
	  * This is fucntion get ThanhPhanHoSoChungThuc by hoSoChungThucId and paging 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoChungThucId, int start, int end
	  * @return List<ThanhPhanHoSoChungThuc>
	  */
	public List<ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucListBy(long hoSoChungThucId, int start, int end) throws SystemException {
		return thanhPhanHoSoChungThucPersistence.findByTheoHoSoChungThucId(hoSoChungThucId, start, end);
	}
	
	/**
	  * This is fucntion remove ThanhPhanHoSoChungThuc by hsctId 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hsctId
	  * @return void
	  */
	public void removeThanhPhanHoSoByHSChungThucId(long hsctId) throws SystemException {
		thanhPhanHoSoChungThucPersistence.removeByTheoHoSoChungThucId(hsctId);
	}
}