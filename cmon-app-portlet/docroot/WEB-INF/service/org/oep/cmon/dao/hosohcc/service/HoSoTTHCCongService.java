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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * The interface for the ho so t t h c cong remote service.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongServiceUtil
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongServiceImpl
 * @generated
 */
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface HoSoTTHCCongService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoTTHCCongServiceUtil} to access the ho so t t h c cong remote service. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* This is fucntion addHoSoTTHCCong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param HoSoTTHCCong
	* @return HoSoTTHCCong
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong);
}