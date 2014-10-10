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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Liemnn
 */
public class TaiLieuChungThucFinderUtil {
	public static long isUsed(java.lang.Long id) {
		return getFinder().isUsed(id);
	}

	public static int getMaxVersion(java.lang.Long userId,
		java.lang.Long giayToId) {
		return getFinder().getMaxVersion(userId, giayToId);
	}

	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getLastVersion(
		java.lang.Long userId, java.lang.Long giayToId) {
		return getFinder().getLastVersion(userId, giayToId);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHoSoId(
		java.lang.Long hosoId) {
		return getFinder().findByHoSoId(hosoId);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(
		long hosoId, int loai) {
		return getFinder().findTaiLieuXuLyByHoSoAndLoai(hosoId, loai);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> searchByCongDanId2DanhMucGiayTo(
		java.lang.String group, java.lang.Long congDanId,
		java.lang.Long doiTuongId, int start, int end) {
		return getFinder()
				   .searchByCongDanId2DanhMucGiayTo(group, congDanId,
			doiTuongId, start, end);
	}

	public static long countByCongDanId2DanhMucGiayTo(java.lang.String group,
		java.lang.Long congDanId, java.lang.Long doiTuongId) {
		return getFinder()
				   .countByCongDanId2DanhMucGiayTo(group, congDanId, doiTuongId);
	}

	public static TaiLieuChungThucFinder getFinder() {
		if (_finder == null) {
			_finder = (TaiLieuChungThucFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.tlct.service.ClpSerializer.getServletContextName(),
					TaiLieuChungThucFinder.class.getName());

			ReferenceRegistry.registerReference(TaiLieuChungThucFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TaiLieuChungThucFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TaiLieuChungThucFinderUtil.class,
			"_finder");
	}

	private static TaiLieuChungThucFinder _finder;
}