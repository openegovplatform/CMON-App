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
public class ReportTongHopFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> getListReportTongHopGroupByIDNhomThuTuc(
		java.lang.String IDDonVi, java.lang.String arrIDNhomThuTuc,
		java.lang.String arrThang, java.lang.String nam)
		throws java.lang.Exception {
		return getFinder()
				   .getListReportTongHopGroupByIDNhomThuTuc(IDDonVi,
			arrIDNhomThuTuc, arrThang, nam);
	}

	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHop> getListReportTongHop(
		java.lang.String IDDonVi, java.lang.String arrIDNhomThuTuc,
		java.lang.String nam) throws java.lang.Exception {
		return getFinder().getListReportTongHop(IDDonVi, arrIDNhomThuTuc, nam);
	}

	public static ReportTongHopFinder getFinder() {
		if (_finder == null) {
			_finder = (ReportTongHopFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					ReportTongHopFinder.class.getName());

			ReferenceRegistry.registerReference(ReportTongHopFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ReportTongHopFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ReportTongHopFinderUtil.class,
			"_finder");
	}

	private static ReportTongHopFinder _finder;
}