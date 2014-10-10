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
public class CoQuanQuanLyFinderUtil {
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSCoQuanQuanlyByDonViHanhChinhId(
		java.lang.String donviHanhChinhIds) {
		return getFinder().getDSCoQuanQuanlyByDonViHanhChinhId(donviHanhChinhIds);
	}

	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSCoQuanQuanlyByMaOrTen(
		java.lang.String maOrTen, int start, int end) {
		return getFinder().getDSCoQuanQuanlyByMaOrTen(maOrTen, start, end);
	}

	public static int countDSCoQuanQuanlyByMaOrTen(java.lang.String maOrTen) {
		return getFinder().countDSCoQuanQuanlyByMaOrTen(maOrTen);
	}

	public static CoQuanQuanLyFinder getFinder() {
		if (_finder == null) {
			_finder = (CoQuanQuanLyFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					CoQuanQuanLyFinder.class.getName());

			ReferenceRegistry.registerReference(CoQuanQuanLyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CoQuanQuanLyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CoQuanQuanLyFinderUtil.class,
			"_finder");
	}

	private static CoQuanQuanLyFinder _finder;
}