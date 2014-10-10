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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author vietho
 */
public class HoSoChungThucFinderUtil {
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucByTTHCAndSCT(
		long tthcId, long canBoTiepNhanId, long coQuanId,
		java.lang.String soChungThuc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getHoSoChungThucByTTHCAndSCT(tthcId, canBoTiepNhanId,
			coQuanId, soChungThuc, start, end);
	}

	public static int countHoSoChungThucByTTHCAndSCT(long tthcId,
		long canBoTiepNhanId, long coQuanId, java.lang.String soChungThuc,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countHoSoChungThucByTTHCAndSCT(tthcId, canBoTiepNhanId,
			coQuanId, soChungThuc, start, end);
	}

	public static HoSoChungThucFinder getFinder() {
		if (_finder == null) {
			_finder = (HoSoChungThucFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.chungthuc.service.ClpSerializer.getServletContextName(),
					HoSoChungThucFinder.class.getName());

			ReferenceRegistry.registerReference(HoSoChungThucFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HoSoChungThucFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HoSoChungThucFinderUtil.class,
			"_finder");
	}

	private static HoSoChungThucFinder _finder;
}