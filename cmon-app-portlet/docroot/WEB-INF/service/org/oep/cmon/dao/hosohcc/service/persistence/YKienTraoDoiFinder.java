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

package org.oep.cmon.dao.hosohcc.service.persistence;

/**
 * @author LIEMNn
 */
public interface YKienTraoDoiFinder {
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoi(
		long hosothutuchanhchinhid, long tkNguoiDungId,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countYKienTraoDoi(long hosothutuchanhchinhid)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoiAndLoai(
		long hosothutuchanhchinhid, long tkNguoiDungId, java.lang.String loai,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(
		long hosothutuchanhchinhid, long loai)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countYKienTraoDoiAndLoai(long hosothutuchanhchinhid,
		long tkNguoiDungId, java.lang.String loai, java.lang.String tieuDe)
		throws com.liferay.portal.kernel.exception.SystemException;
}