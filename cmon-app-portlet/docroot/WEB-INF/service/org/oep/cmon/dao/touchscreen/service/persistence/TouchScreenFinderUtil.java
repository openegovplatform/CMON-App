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

package org.oep.cmon.dao.touchscreen.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author VIENPN
 */
public class TouchScreenFinderUtil {
	public static long countHoSoTrucTiep(int loaihoso, java.lang.String nam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countHoSoTrucTiep(loaihoso, nam);
	}

	public static long countHoSoByTrangThai(java.lang.String arrTrangThai,
		java.lang.String nam, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countHoSoByTrangThai(arrTrangThai, nam, type);
	}

	public static TouchScreenFinder getFinder() {
		if (_finder == null) {
			_finder = (TouchScreenFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.touchscreen.service.ClpSerializer.getServletContextName(),
					TouchScreenFinder.class.getName());

			ReferenceRegistry.registerReference(TouchScreenFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TouchScreenFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TouchScreenFinderUtil.class,
			"_finder");
	}

	private static TouchScreenFinder _finder;
}