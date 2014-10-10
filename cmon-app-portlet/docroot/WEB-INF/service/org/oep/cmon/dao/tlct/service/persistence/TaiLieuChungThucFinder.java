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
public interface TaiLieuChungThucFinder {
	public long isUsed(java.lang.Long id);

	public int getMaxVersion(java.lang.Long userId, java.lang.Long giayToId);

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getLastVersion(
		java.lang.Long userId, java.lang.Long giayToId);

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHoSoId(
		java.lang.Long hosoId);

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(
		long hosoId, int loai);

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> searchByCongDanId2DanhMucGiayTo(
		java.lang.String group, java.lang.Long congDanId,
		java.lang.Long doiTuongId, int start, int end);

	public long countByCongDanId2DanhMucGiayTo(java.lang.String group,
		java.lang.Long congDanId, java.lang.Long doiTuongId);
}