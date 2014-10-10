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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LIEMNn
 */
public class HoSoTTHCCongServiceClp implements HoSoTTHCCongService {
	public HoSoTTHCCongServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addHoSoTTHCCongMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addHoSoTTHCCong",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addHoSoTTHCCongMethodKey0,
				ClpSerializer.translateInput(hoSoTTHCCong));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addHoSoTTHCCongMethodKey0;
}