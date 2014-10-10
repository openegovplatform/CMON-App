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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the ho so t t h c cong remote service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongService
 * @see org.oep.cmon.dao.hosohcc.service.base.HoSoTTHCCongServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongServiceImpl
 * @generated
 */
public class HoSoTTHCCongServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.HoSoTTHCCongServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* This is fucntion addHoSoTTHCCong
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param HoSoTTHCCong
	* @return HoSoTTHCCong
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong) {
		return getService().addHoSoTTHCCong(hoSoTTHCCong);
	}

	public static void clearService() {
		_service = null;
	}

	public static HoSoTTHCCongService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					HoSoTTHCCongService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					HoSoTTHCCongService.class.getName(), portletClassLoader);

			_service = new HoSoTTHCCongServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(HoSoTTHCCongServiceUtil.class,
				"_service");
			MethodCache.remove(HoSoTTHCCongService.class);
		}

		return _service;
	}

	public void setService(HoSoTTHCCongService service) {
		MethodCache.remove(HoSoTTHCCongService.class);

		_service = service;

		ReferenceRegistry.registerReference(HoSoTTHCCongServiceUtil.class,
			"_service");
		MethodCache.remove(HoSoTTHCCongService.class);
	}

	private static HoSoTTHCCongService _service;
}