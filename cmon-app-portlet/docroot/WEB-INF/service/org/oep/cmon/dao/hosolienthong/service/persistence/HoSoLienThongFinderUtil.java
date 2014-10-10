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

package org.oep.cmon.dao.hosolienthong.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author hoangtrung.nguyen
 */
public class HoSoLienThongFinderUtil {
	public static org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiNhan(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		return getFinder()
				   .searchHoSoNoiNhan(request, canBoNoiNhan, thuTucNhanIds);
	}

	public static org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiGui(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		return getFinder().searchHoSoNoiGui(request, canBoNoiGui, thuTucGuiIds);
	}

	public static HoSoLienThongFinder getFinder() {
		if (_finder == null) {
			_finder = (HoSoLienThongFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosolienthong.service.ClpSerializer.getServletContextName(),
					HoSoLienThongFinder.class.getName());

			ReferenceRegistry.registerReference(HoSoLienThongFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HoSoLienThongFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HoSoLienThongFinderUtil.class,
			"_finder");
	}

	private static HoSoLienThongFinder _finder;
}