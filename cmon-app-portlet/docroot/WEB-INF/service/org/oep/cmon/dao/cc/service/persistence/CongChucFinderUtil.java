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
public class CongChucFinderUtil {
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end) {
		return getFinder().listCanBoTiepNhan(coQuanQuanLyId, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCongChuc(
		long coQuanQuanLyId, java.lang.String maOrTenOrEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .listCongChuc(coQuanQuanLyId, maOrTenOrEmail, start, end);
	}

	public static int countListCongChuc(long coQuanQuanLyId,
		java.lang.String maOrTenOrEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countListCongChuc(coQuanQuanLyId, maOrTenOrEmail);
	}

	public static CongChucFinder getFinder() {
		if (_finder == null) {
			_finder = (CongChucFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cc.service.ClpSerializer.getServletContextName(),
					CongChucFinder.class.getName());

			ReferenceRegistry.registerReference(CongChucFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CongChucFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CongChucFinderUtil.class, "_finder");
	}

	private static CongChucFinder _finder;
}