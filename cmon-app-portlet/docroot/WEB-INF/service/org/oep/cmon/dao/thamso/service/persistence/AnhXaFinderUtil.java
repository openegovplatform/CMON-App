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
public class AnhXaFinderUtil {
	public static java.lang.String getCodeById(java.lang.String table,
		java.lang.Long id) {
		return getFinder().getCodeById(table, id);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDSByTenOrMa(
		java.lang.String table, java.lang.String code, java.lang.String ten) {
		return getFinder().getDSByTenOrMa(table, code, ten);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> search(
		java.lang.String keyword, java.lang.Long appId, java.lang.String table,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().search(keyword, appId, table, start, end);
	}

	public static long countSearch(java.lang.String keyword,
		java.lang.Long appId, java.lang.String table)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countSearch(keyword, appId, table);
	}

	public static java.util.List<java.lang.String> getListTable()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getListTable();
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang) {
		return getFinder().getMaKhacExCh(maDNG, tenBang);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacCQQL(
		java.lang.String maKhac, java.lang.String tenBang) {
		return getFinder().getDNGFromMaKhacCQQL(maKhac, tenBang);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacTTHC(
		java.lang.String maKhac, java.lang.String tenBang) {
		return getFinder().getDNGFromMaKhacTTHC(maKhac, tenBang);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang, long maUngDungId) {
		return getFinder().getMaKhacExCh(maDNG, tenBang, maUngDungId);
	}

	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacGPLX(
		java.lang.String maKhac, java.lang.String tenBang) {
		return getFinder().getDNGFromMaKhacGPLX(maKhac, tenBang);
	}

	public static AnhXaFinder getFinder() {
		if (_finder == null) {
			_finder = (AnhXaFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.thamso.service.ClpSerializer.getServletContextName(),
					AnhXaFinder.class.getName());

			ReferenceRegistry.registerReference(AnhXaFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(AnhXaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AnhXaFinderUtil.class, "_finder");
	}

	private static AnhXaFinder _finder;
}