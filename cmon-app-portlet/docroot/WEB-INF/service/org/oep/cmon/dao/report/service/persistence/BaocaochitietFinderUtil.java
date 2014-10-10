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
public class BaocaochitietFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> hienthiDanhsachBaocao(
		java.lang.String[] listloaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay, java.lang.String trangthai,
		java.lang.String tinhtrang, java.lang.String loaidangky, int start,
		int end) {
		return getFinder()
				   .hienthiDanhsachBaocao(listloaihoso, ngaynhan_tungay,
			ngaynhan_denngay, trangthai, tinhtrang, loaidangky, start, end);
	}

	public static BaocaochitietFinder getFinder() {
		if (_finder == null) {
			_finder = (BaocaochitietFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					BaocaochitietFinder.class.getName());

			ReferenceRegistry.registerReference(BaocaochitietFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BaocaochitietFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BaocaochitietFinderUtil.class,
			"_finder");
	}

	private static BaocaochitietFinder _finder;
}