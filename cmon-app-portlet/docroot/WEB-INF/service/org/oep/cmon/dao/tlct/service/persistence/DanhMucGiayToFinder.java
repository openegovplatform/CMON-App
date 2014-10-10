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

package org.oep.cmon.dao.tlct.service.persistence;

/**
 * @author Liemnn
 */
public interface DanhMucGiayToFinder {
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchDanhMucGiayTo(
		java.lang.String group, java.lang.Long doiTuongId, int start, int end);

	public long countDanhMucGiayTo(java.lang.String group,
		java.lang.Long doiTuongId);

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchByTTHCIdOrGDId(
		java.lang.String group, java.lang.String doituong,
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countByTTHCIdOrGDId(java.lang.String group,
		java.lang.String doituong, java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listByCongDan(
		java.lang.Long doiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listGiayToKetQua(
		long thutuchanhchinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listGiayToBCNopDon(
		long hosothutuchccId)
		throws com.liferay.portal.kernel.exception.SystemException;
}