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

package org.oep.cmon.dao.csms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author NAM
 */
public class YeuCauDangKyCongDanFinderUtil {
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByKeyword(
		java.lang.String keyword, int trangThaiYeuCau, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByKeyword(keyword, trangThaiYeuCau, start, end);
	}

	public static int countByKeyword(java.lang.String keyword,
		int trangThaiYeuCau)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByKeyword(keyword, trangThaiYeuCau);
	}

	public static YeuCauDangKyCongDanFinder getFinder() {
		if (_finder == null) {
			_finder = (YeuCauDangKyCongDanFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.csms.service.ClpSerializer.getServletContextName(),
					YeuCauDangKyCongDanFinder.class.getName());

			ReferenceRegistry.registerReference(YeuCauDangKyCongDanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(YeuCauDangKyCongDanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(YeuCauDangKyCongDanFinderUtil.class,
			"_finder");
	}

	private static YeuCauDangKyCongDanFinder _finder;
}