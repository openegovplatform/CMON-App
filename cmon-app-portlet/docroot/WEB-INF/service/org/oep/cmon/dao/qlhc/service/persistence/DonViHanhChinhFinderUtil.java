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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNN
 */
public class DonViHanhChinhFinderUtil {
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> dsTinhThanh() {
		return getFinder().dsTinhThanh();
	}

	public static DonViHanhChinhFinder getFinder() {
		if (_finder == null) {
			_finder = (DonViHanhChinhFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					DonViHanhChinhFinder.class.getName());

			ReferenceRegistry.registerReference(DonViHanhChinhFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DonViHanhChinhFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DonViHanhChinhFinderUtil.class,
			"_finder");
	}

	private static DonViHanhChinhFinder _finder;
}