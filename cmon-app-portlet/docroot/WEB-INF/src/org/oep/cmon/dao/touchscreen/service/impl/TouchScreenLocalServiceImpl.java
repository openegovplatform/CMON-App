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


package org.oep.cmon.dao.touchscreen.service.impl;

import java.util.List;

import org.oep.cmon.dao.touchscreen.service.base.TouchScreenLocalServiceBaseImpl;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

/**
 * The implementation of the touch screen local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.oep.cmon.dao.touchscreen.service.TouchScreenLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author VIENPN
 * @see org.oep.cmon.dao.touchscreen.service.base.TouchScreenLocalServiceBaseImpl
 * @see org.oep.cmon.dao.touchscreen.service.TouchScreenLocalServiceUtil
 */
/**
*
* TouchScreenLocalServiceImpl class
*   
* This class is used to get TouchScreen information 
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
public class TouchScreenLocalServiceImpl extends
		TouchScreenLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.oep.cmon.dao.touchscreen.service.TouchScreenLocalServiceUtil} to
	 * access the touch screen local service.
	 */
	/**
	  * This is fucntion countHoSoTrucTiep
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param int loaihoso, String nam
	  * @return long
	  */
	public long countHoSoTrucTiep(int loaihoso, String nam)
			throws Exception {
		return touchScreenFinder.countHoSoTrucTiep(loaihoso, nam);
	}

	/**
	  * This is fucntion countHoSoByTrangThai 
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String arrTrangThai, String nam,String type
	  * @return long
	  */
	public long countHoSoByTrangThai(String arrTrangThai, String nam,
			String type) throws Exception {
		return touchScreenFinder.countHoSoByTrangThai(arrTrangThai, nam, type);
	}
}