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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoTTHCCongService}.
 * </p>
 *
 * @author    LIEMNn
 * @see       HoSoTTHCCongService
 * @generated
 */
public class HoSoTTHCCongServiceWrapper implements HoSoTTHCCongService,
	ServiceWrapper<HoSoTTHCCongService> {
	public HoSoTTHCCongServiceWrapper(HoSoTTHCCongService hoSoTTHCCongService) {
		_hoSoTTHCCongService = hoSoTTHCCongService;
	}

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
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong) {
		return _hoSoTTHCCongService.addHoSoTTHCCong(hoSoTTHCCong);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public HoSoTTHCCongService getWrappedHoSoTTHCCongService() {
		return _hoSoTTHCCongService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedHoSoTTHCCongService(
		HoSoTTHCCongService hoSoTTHCCongService) {
		_hoSoTTHCCongService = hoSoTTHCCongService;
	}

	public HoSoTTHCCongService getWrappedService() {
		return _hoSoTTHCCongService;
	}

	public void setWrappedService(HoSoTTHCCongService hoSoTTHCCongService) {
		_hoSoTTHCCongService = hoSoTTHCCongService;
	}

	private HoSoTTHCCongService _hoSoTTHCCongService;
}