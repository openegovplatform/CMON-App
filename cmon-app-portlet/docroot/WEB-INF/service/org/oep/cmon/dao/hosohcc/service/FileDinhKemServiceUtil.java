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
 * The utility for the file dinh kem remote service. This utility wraps {@link org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author LIEMNn
 * @see FileDinhKemService
 * @see org.oep.cmon.dao.hosohcc.service.base.FileDinhKemServiceBaseImpl
 * @see org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemServiceImpl
 * @generated
 */
public class FileDinhKemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.oep.cmon.dao.hosohcc.service.impl.FileDinhKemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* This is fucntion addFileDinhKem
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param FileDinhKem
	* @return FileDinhKem
	*/
	public static org.oep.cmon.dao.hosohcc.model.FileDinhKem addFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem) {
		return getService().addFileDinhKem(fileDinhKem);
	}

	public static void clearService() {
		_service = null;
	}

	public static FileDinhKemService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FileDinhKemService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					FileDinhKemService.class.getName(), portletClassLoader);

			_service = new FileDinhKemServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(FileDinhKemServiceUtil.class,
				"_service");
			MethodCache.remove(FileDinhKemService.class);
		}

		return _service;
	}

	public void setService(FileDinhKemService service) {
		MethodCache.remove(FileDinhKemService.class);

		_service = service;

		ReferenceRegistry.registerReference(FileDinhKemServiceUtil.class,
			"_service");
		MethodCache.remove(FileDinhKemService.class);
	}

	private static FileDinhKemService _service;
}