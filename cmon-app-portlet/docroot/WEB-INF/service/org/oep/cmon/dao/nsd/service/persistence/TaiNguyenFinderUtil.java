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

package org.oep.cmon.dao.nsd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Liemnn
 */
public class TaiNguyenFinderUtil {
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> searchByVaiTroId(
		java.lang.Long vaiTroId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByVaiTroId(vaiTroId, daXoa, start, end);
	}

	public static long countByVaiTroId(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByVaiTroId(vaiTroId, daXoa);
	}

	public static TaiNguyenFinder getFinder() {
		if (_finder == null) {
			_finder = (TaiNguyenFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					TaiNguyenFinder.class.getName());

			ReferenceRegistry.registerReference(TaiNguyenFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TaiNguyenFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TaiNguyenFinderUtil.class, "_finder");
	}

	private static TaiNguyenFinder _finder;
}