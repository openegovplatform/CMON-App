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

package org.oep.cmon.dao.nsd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Liemnn
 */
public class TaiKhoanNguoiDungFinderUtil {
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDung(
		java.lang.String keyWord, java.lang.String option) {
		return getFinder().findTaiKhoanNguoiDung(keyWord, option);
	}

	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(
		java.lang.String keyWord, java.lang.String option) {
		return getFinder().findTaiKhoanNguoiDungPopup(keyWord, option);
	}

	public static TaiKhoanNguoiDungFinder getFinder() {
		if (_finder == null) {
			_finder = (TaiKhoanNguoiDungFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					TaiKhoanNguoiDungFinder.class.getName());

			ReferenceRegistry.registerReference(TaiKhoanNguoiDungFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TaiKhoanNguoiDungFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TaiKhoanNguoiDungFinderUtil.class,
			"_finder");
	}

	private static TaiKhoanNguoiDungFinder _finder;
}