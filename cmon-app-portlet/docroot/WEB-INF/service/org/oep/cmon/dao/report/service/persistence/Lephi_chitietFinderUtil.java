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
public class Lephi_chitietFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> lephichitiet(
		java.lang.String id_loaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getFinder()
				   .lephichitiet(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> lephilinhvuc(
		java.lang.String id_linhvuc, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getFinder()
				   .lephilinhvuc(id_linhvuc, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> lephitonghop(
		java.lang.String id_loaihoso, java.lang.String ngaynhan_tungay,
		java.lang.String ngaynhan_denngay) throws java.lang.Exception {
		return getFinder()
				   .lephitonghop(id_loaihoso, ngaynhan_tungay, ngaynhan_denngay);
	}

	public static Lephi_chitietFinder getFinder() {
		if (_finder == null) {
			_finder = (Lephi_chitietFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Lephi_chitietFinder.class.getName());

			ReferenceRegistry.registerReference(Lephi_chitietFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(Lephi_chitietFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(Lephi_chitietFinderUtil.class,
			"_finder");
	}

	private static Lephi_chitietFinder _finder;
}