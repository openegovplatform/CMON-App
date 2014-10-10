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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author LIEMNN
 */
public class CongDanFinderUtil {
	public static org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> search(
		javax.portlet.PortletRequest request) throws java.lang.Exception {
		return getFinder().search(request);
	}

	public static org.oep.cmon.dao.cd.model.CongDan getCongDanByLiferayUserId(
		java.lang.Long liferayUserId) {
		return getFinder().getCongDanByLiferayUserId(liferayUserId);
	}

	public static CongDanFinder getFinder() {
		if (_finder == null) {
			_finder = (CongDanFinder)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					CongDanFinder.class.getName());

			ReferenceRegistry.registerReference(CongDanFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CongDanFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CongDanFinderUtil.class, "_finder");
	}

	private static CongDanFinder _finder;
}