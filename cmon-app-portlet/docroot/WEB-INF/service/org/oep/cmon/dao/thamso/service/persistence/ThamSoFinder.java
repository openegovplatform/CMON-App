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

package org.oep.cmon.dao.thamso.service.persistence;

/**
 * @author LIEMNN
 */
public interface ThamSoFinder {
	public java.util.List<java.lang.String> fetchList(
		java.util.List<java.lang.String> keyList);

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTenUDHT(
		java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByTenUDHT(java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId)
		throws com.liferay.portal.kernel.exception.SystemException;
}