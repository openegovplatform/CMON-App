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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author liemnn
 */
public class ThuTuc2GiayToFinderUtil {
	public static java.util.List<org.oep.cmon.dao.beans.giaytodinhkem.GiayToDinhKem> getDSGiayToByThuTucVaGiaiDoan(
		long thuTucId, int giaiDoan) throws java.lang.Exception {
		return getFinder().getDSGiayToByThuTucVaGiaiDoan(thuTucId, giaiDoan);
	}

	public static ThuTuc2GiayToFinder getFinder() {
		if (_finder == null) {
			_finder = (ThuTuc2GiayToFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					ThuTuc2GiayToFinder.class.getName());

			ReferenceRegistry.registerReference(ThuTuc2GiayToFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThuTuc2GiayToFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThuTuc2GiayToFinderUtil.class,
			"_finder");
	}

	private static ThuTuc2GiayToFinder _finder;
}