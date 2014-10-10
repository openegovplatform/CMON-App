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
public interface AnhXaFinder {
	public java.lang.String getCodeById(java.lang.String table,
		java.lang.Long id);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDSByTenOrMa(
		java.lang.String table, java.lang.String code, java.lang.String ten);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> search(
		java.lang.String keyword, java.lang.Long appId, java.lang.String table,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countSearch(java.lang.String keyword, java.lang.Long appId,
		java.lang.String table)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.String> getListTable()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacCQQL(
		java.lang.String maKhac, java.lang.String tenBang);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacTTHC(
		java.lang.String maKhac, java.lang.String tenBang);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang, long maUngDungId);

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacGPLX(
		java.lang.String maKhac, java.lang.String tenBang);
}