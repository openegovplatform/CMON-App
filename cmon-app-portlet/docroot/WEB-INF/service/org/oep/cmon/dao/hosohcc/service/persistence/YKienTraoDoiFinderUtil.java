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

package org.oep.cmon.dao.hosohcc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNn
 */
public class YKienTraoDoiFinderUtil {
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoi(
		long hosothutuchanhchinhid, long tkNguoiDungId,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .listYKienTraoDoi(hosothutuchanhchinhid, tkNguoiDungId,
			tieuDe, start, end);
	}

	public static int countYKienTraoDoi(long hosothutuchanhchinhid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countYKienTraoDoi(hosothutuchanhchinhid);
	}

	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().listCanBoTiepNhan(coQuanQuanLyId, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoiAndLoai(
		long hosothutuchanhchinhid, long tkNguoiDungId, java.lang.String loai,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .listYKienTraoDoiAndLoai(hosothutuchanhchinhid,
			tkNguoiDungId, loai, tieuDe, start, end);
	}

	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(
		long hosothutuchanhchinhid, long loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findYKienByHoSoTTHCCongIdAndLoai(hosothutuchanhchinhid, loai);
	}

	public static int countYKienTraoDoiAndLoai(long hosothutuchanhchinhid,
		long tkNguoiDungId, java.lang.String loai, java.lang.String tieuDe)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countYKienTraoDoiAndLoai(hosothutuchanhchinhid,
			tkNguoiDungId, loai, tieuDe);
	}

	public static YKienTraoDoiFinder getFinder() {
		if (_finder == null) {
			_finder = (YKienTraoDoiFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					YKienTraoDoiFinder.class.getName());

			ReferenceRegistry.registerReference(YKienTraoDoiFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(YKienTraoDoiFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(YKienTraoDoiFinderUtil.class,
			"_finder");
	}

	private static YKienTraoDoiFinder _finder;
}