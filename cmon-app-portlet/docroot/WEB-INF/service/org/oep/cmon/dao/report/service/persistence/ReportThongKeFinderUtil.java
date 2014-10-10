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
public class ReportThongKeFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.ReportThongKe> getListReportThongKeGroupByIDCoQuan(
		java.lang.String IDDonViQuanLy, java.lang.String arrThang,
		java.lang.String nam) throws java.lang.Exception {
		return getFinder()
				   .getListReportThongKeGroupByIDCoQuan(IDDonViQuanLy,
			arrThang, nam);
	}

	public static void reportScheduler() {
		getFinder().reportScheduler();
	}

	public static ReportThongKeFinder getFinder() {
		if (_finder == null) {
			_finder = (ReportThongKeFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					ReportThongKeFinder.class.getName());

			ReferenceRegistry.registerReference(ReportThongKeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ReportThongKeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ReportThongKeFinderUtil.class,
			"_finder");
	}

	private static ReportThongKeFinder _finder;
}