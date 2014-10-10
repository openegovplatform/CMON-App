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

package org.oep.cmon.dao.cd.service.persistence;

/**
 * @author LIEMNN
 */
public interface ChuyenMonFinder {
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> fetchListByCongDan2CCGPId(
		long congDan2CCGPId);

	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getDanhSachChuyenMonByMaDanhMucUngDung(
		java.lang.String maDanhMucUngDung);

	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getChuyenMonChaId(
		java.lang.String idUngDung, java.lang.String chaId);

	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> getChuyenMonByChaIdNull(
		java.lang.String idUngDung);
}