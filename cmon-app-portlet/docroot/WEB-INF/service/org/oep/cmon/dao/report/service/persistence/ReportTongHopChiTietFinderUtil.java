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
public class ReportTongHopChiTietFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.ReportTongHopChiTiet> getListReportTongHopChiTietGroupByIDThuTuc(
		java.lang.String IDDonVi, java.lang.String arrIDThuTuc,
		java.lang.String arrThang, java.lang.String nam)
		throws java.lang.Exception {
		return getFinder()
				   .getListReportTongHopChiTietGroupByIDThuTuc(IDDonVi,
			arrIDThuTuc, arrThang, nam);
	}

	public static ReportTongHopChiTietFinder getFinder() {
		if (_finder == null) {
			_finder = (ReportTongHopChiTietFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					ReportTongHopChiTietFinder.class.getName());

			ReferenceRegistry.registerReference(ReportTongHopChiTietFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ReportTongHopChiTietFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ReportTongHopChiTietFinderUtil.class,
			"_finder");
	}

	private static ReportTongHopChiTietFinder _finder;
}