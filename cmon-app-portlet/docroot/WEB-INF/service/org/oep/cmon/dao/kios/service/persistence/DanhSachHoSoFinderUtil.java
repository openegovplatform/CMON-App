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

package org.oep.cmon.dao.kios.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author VIENPN
 */
public class DanhSachHoSoFinderUtil {
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> getListHoSo(
		java.lang.String id_coquan, int start, int end)
		throws java.lang.Exception {
		return getFinder().getListHoSo(id_coquan, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> getListReportThongKeGroupByIDCoQuan(
		java.lang.String arrCapCoQuanid, java.lang.String arrThang,
		java.lang.String nam) throws java.lang.Exception {
		return getFinder()
				   .getListReportThongKeGroupByIDCoQuan(arrCapCoQuanid,
			arrThang, nam);
	}

	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> getListCoQuan(
		java.lang.String arrayCapCoQuanId) throws java.lang.Exception {
		return getFinder().getListCoQuan(arrayCapCoQuanId);
	}

	public static DanhSachHoSoFinder getFinder() {
		if (_finder == null) {
			_finder = (DanhSachHoSoFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.kios.service.ClpSerializer.getServletContextName(),
					DanhSachHoSoFinder.class.getName());

			ReferenceRegistry.registerReference(DanhSachHoSoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DanhSachHoSoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DanhSachHoSoFinderUtil.class,
			"_finder");
	}

	private static DanhSachHoSoFinder _finder;
}