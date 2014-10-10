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


package org.oep.cmon.dao.hosohcc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.oep.cmon.dao.hosohcc.service.base.HoSoAnhXaLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;
import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;

/**
 * The implementation of the ho so anh xa local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author LIEMNn
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoAnhXaLocalServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil
 */
/**
*
* HoSoAnhXaLocalServiceImpl class
*   
* This class is used to get HoSoAnhXa information 
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
public class HoSoAnhXaLocalServiceImpl extends HoSoAnhXaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.HoSoAnhXaLocalServiceUtil} to access the ho so anh xa local service.
	 */
	/**
	  * This is fucntion findById
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long id
	  * @return HoSoAnhXa
	  */
	public HoSoAnhXa findById(long id) {
		try {
			return hoSoAnhXaPersistence.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByHoSoTTHCCongId
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param long hoSoTTHCCongId
	  * @return HoSoAnhXa
	  */
	public HoSoAnhXa findByHoSoTTHCCongId(long hoSoTTHCCongId) {
		try {
			return hoSoAnhXaPersistence.findByHoSoTTHCCongId(hoSoTTHCCongId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	  * This is fucntion findByMaHoSo
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String maHoSo
	  * @return List<HoSoAnhXa>
	  */
	public List<HoSoAnhXa> findByMaHoSo(String maHoSo) {
		try {
			return hoSoAnhXaPersistence.findByMaHoSo(maHoSo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<HoSoAnhXa>();
	}
}