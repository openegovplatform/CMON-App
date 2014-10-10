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
public class CongChuc2RoleFinderUtil {
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucBaoCao> getDanhsachbaocao(
		long user_id) throws java.lang.Exception {
		return getFinder().getDanhsachbaocao(user_id);
	}

	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLy(
		long user_id, long baocao_id) throws java.lang.Exception {
		return getFinder().getCoQuanQuanLy(user_id, baocao_id);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> getNhomTTHC(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return getFinder().getNhomTTHC(user_id, baocao_id, donvi_id);
	}

	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThutuchanhchinh(
		long user_id, long baocao_id, long donvi_id) throws java.lang.Exception {
		return getFinder().getThutuchanhchinh(user_id, baocao_id, donvi_id);
	}

	public static java.lang.Boolean testReportPermission(long user_id,
		long baocao_id) throws java.lang.Exception {
		return getFinder().testReportPermission(user_id, baocao_id);
	}

	public static CongChuc2RoleFinder getFinder() {
		if (_finder == null) {
			_finder = (CongChuc2RoleFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					CongChuc2RoleFinder.class.getName());

			ReferenceRegistry.registerReference(CongChuc2RoleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CongChuc2RoleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CongChuc2RoleFinderUtil.class,
			"_finder");
	}

	private static CongChuc2RoleFinder _finder;
}