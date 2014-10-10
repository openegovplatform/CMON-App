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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Thanhdd
 */
public class ThongTinThanhToanFinderUtil {
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> searchByCoQuanQuanLyHoSo_QT(
		long coQuanQuanLyId, java.lang.String searchProfileCode, int loaiPhi,
		int start, int end) {
		return getFinder()
				   .searchByCoQuanQuanLyHoSo_QT(coQuanQuanLyId,
			searchProfileCode, loaiPhi, start, end);
	}

	public static int countByCoQuanQuanLyHoSo_QT(long coQuanQuanLyId,
		java.lang.String searchProfileCode, int loaiPhi) {
		return getFinder()
				   .countByCoQuanQuanLyHoSo_QT(coQuanQuanLyId,
			searchProfileCode, loaiPhi);
	}

	public static ThongTinThanhToanFinder getFinder() {
		if (_finder == null) {
			_finder = (ThongTinThanhToanFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.ttthanhtoan.service.ClpSerializer.getServletContextName(),
					ThongTinThanhToanFinder.class.getName());

			ReferenceRegistry.registerReference(ThongTinThanhToanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThongTinThanhToanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThongTinThanhToanFinderUtil.class,
			"_finder");
	}

	private static ThongTinThanhToanFinder _finder;
}