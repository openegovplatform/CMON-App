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

package org.oep.cmon.dao.cc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Liemnn
 */
public class ChucVuFinderUtil {
	public static java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByCoQuanQuanLy(
		long coQuanQuanLyId, long daXoa) {
		return getFinder().findByCoQuanQuanLy(coQuanQuanLyId, daXoa);
	}

	public static ChucVuFinder getFinder() {
		if (_finder == null) {
			_finder = (ChucVuFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cc.service.ClpSerializer.getServletContextName(),
					ChucVuFinder.class.getName());

			ReferenceRegistry.registerReference(ChucVuFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ChucVuFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ChucVuFinderUtil.class, "_finder");
	}

	private static ChucVuFinder _finder;
}