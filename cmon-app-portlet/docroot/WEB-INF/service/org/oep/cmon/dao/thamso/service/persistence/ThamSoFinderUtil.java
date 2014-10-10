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

package org.oep.cmon.dao.thamso.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNN
 */
public class ThamSoFinderUtil {
	public static java.util.List<java.lang.String> fetchList(
		java.util.List<java.lang.String> keyList) {
		return getFinder().fetchList(keyList);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByTen(ten, start, end);
	}

	public static long countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByTen(ten);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTenUDHT(
		java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchByTenUDHT(ten, ungDungId, heThongId, start, end);
	}

	public static long countByTenUDHT(java.lang.String ten,
		java.lang.Long ungDungId, java.lang.Long heThongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countByTenUDHT(ten, ungDungId, heThongId);
	}

	public static ThamSoFinder getFinder() {
		if (_finder == null) {
			_finder = (ThamSoFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.thamso.service.ClpSerializer.getServletContextName(),
					ThamSoFinder.class.getName());

			ReferenceRegistry.registerReference(ThamSoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ThamSoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ThamSoFinderUtil.class, "_finder");
	}

	private static ThamSoFinder _finder;
}