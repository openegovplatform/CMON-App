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

package org.oep.cmon.dao.tlct.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Liemnn
 */
public class DanhMucGiayToFinderUtil {
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchDanhMucGiayTo(
		java.lang.String group, java.lang.Long doiTuongId, int start, int end) {
		return getFinder().searchDanhMucGiayTo(group, doiTuongId, start, end);
	}

	public static long countDanhMucGiayTo(java.lang.String group,
		java.lang.Long doiTuongId) {
		return getFinder().countDanhMucGiayTo(group, doiTuongId);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchByTTHCIdOrGDId(
		java.lang.String group, java.lang.String doituong,
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchByTTHCIdOrGDId(group, doituong, tthcid, dgId, daXoa,
			start, end);
	}

	public static long countByTTHCIdOrGDId(java.lang.String group,
		java.lang.String doituong, java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByTTHCIdOrGDId(group, doituong, tthcid, dgId, daXoa);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listByCongDan(
		java.lang.Long doiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().listByCongDan(doiTuongId);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listGiayToKetQua(
		long thutuchanhchinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().listGiayToKetQua(thutuchanhchinhId);
	}

	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listGiayToBCNopDon(
		long hosothutuchccId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().listGiayToBCNopDon(hosothutuchccId);
	}

	public static DanhMucGiayToFinder getFinder() {
		if (_finder == null) {
			_finder = (DanhMucGiayToFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.tlct.service.ClpSerializer.getServletContextName(),
					DanhMucGiayToFinder.class.getName());

			ReferenceRegistry.registerReference(DanhMucGiayToFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DanhMucGiayToFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DanhMucGiayToFinderUtil.class,
			"_finder");
	}

	private static DanhMucGiayToFinder _finder;
}