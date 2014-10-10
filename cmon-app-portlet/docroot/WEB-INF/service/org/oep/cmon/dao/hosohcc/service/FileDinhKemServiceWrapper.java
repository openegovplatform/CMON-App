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
 * This class is a wrapper for {@link FileDinhKemService}.
 * </p>
 *
 * @author    LIEMNn
 * @see       FileDinhKemService
 * @generated
 */
public class FileDinhKemServiceWrapper implements FileDinhKemService,
	ServiceWrapper<FileDinhKemService> {
	public FileDinhKemServiceWrapper(FileDinhKemService fileDinhKemService) {
		_fileDinhKemService = fileDinhKemService;
	}

	/**
	* This is fucntion addFileDinhKem
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param FileDinhKem
	* @return FileDinhKem
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem addFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem) {
		return _fileDinhKemService.addFileDinhKem(fileDinhKem);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FileDinhKemService getWrappedFileDinhKemService() {
		return _fileDinhKemService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFileDinhKemService(
		FileDinhKemService fileDinhKemService) {
		_fileDinhKemService = fileDinhKemService;
	}

	public FileDinhKemService getWrappedService() {
		return _fileDinhKemService;
	}

	public void setWrappedService(FileDinhKemService fileDinhKemService) {
		_fileDinhKemService = fileDinhKemService;
	}

	private FileDinhKemService _fileDinhKemService;
}