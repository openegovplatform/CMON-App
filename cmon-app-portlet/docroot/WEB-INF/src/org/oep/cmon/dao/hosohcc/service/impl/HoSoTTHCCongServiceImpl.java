/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.oep.cmon.dao.hosohcc.service.impl;

import org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;
import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;
import org.oep.cmon.dao.hosohcc.service.persistence.HoSoTTHCCongUtil;

/**
 * The implementation of the ho so t t h c cong remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LIEMNn
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongServiceUtil
 */
/**
*
* HoSoTTHCCongServiceImpl class
*   
* This class is used to get HoSoTTHCCong information 
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
public class HoSoTTHCCongServiceImpl extends HoSoTTHCCongServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongServiceUtil} to access the ho so t t h c cong remote service.
	 */
	/**
	  * This is fucntion addHoSoTTHCCong
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param HoSoTTHCCong
	  * @return HoSoTTHCCong
	  */
	public HoSoTTHCCong addHoSoTTHCCong(HoSoTTHCCong hoSoTTHCCong){
		try {
			return HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(hoSoTTHCCong);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}