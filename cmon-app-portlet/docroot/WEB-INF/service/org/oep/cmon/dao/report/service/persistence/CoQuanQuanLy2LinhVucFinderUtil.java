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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author VIENPN
 */
public class CoQuanQuanLy2LinhVucFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> getLinhvucByIdDonvi(
		java.lang.String id_donvibaocao) throws java.lang.Exception {
		return getFinder().getLinhvucByIdDonvi(id_donvibaocao);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getTTHC(
		java.lang.String nhomtthc_id, java.lang.String donvi_id)
		throws java.lang.Exception {
		return getFinder().getTTHC(nhomtthc_id, donvi_id);
	}

	public static CoQuanQuanLy2LinhVucFinder getFinder() {
		if (_finder == null) {
			_finder = (CoQuanQuanLy2LinhVucFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					CoQuanQuanLy2LinhVucFinder.class.getName());

			ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CoQuanQuanLy2LinhVucFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucFinderUtil.class,
			"_finder");
	}

	private static CoQuanQuanLy2LinhVucFinder _finder;
}