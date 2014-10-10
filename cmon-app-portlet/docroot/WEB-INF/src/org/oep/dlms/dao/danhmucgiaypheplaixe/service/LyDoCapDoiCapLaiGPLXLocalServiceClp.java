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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author AnhNT
 */
public class LyDoCapDoiCapLaiGPLXLocalServiceClp
	implements LyDoCapDoiCapLaiGPLXLocalService {
	public LyDoCapDoiCapLaiGPLXLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addLyDoCapDoiCapLaiGPLXMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLyDoCapDoiCapLaiGPLX",
				org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX.class);

		_createLyDoCapDoiCapLaiGPLXMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createLyDoCapDoiCapLaiGPLX", long.class);

		_deleteLyDoCapDoiCapLaiGPLXMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteLyDoCapDoiCapLaiGPLX", long.class);

		_deleteLyDoCapDoiCapLaiGPLXMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteLyDoCapDoiCapLaiGPLX",
				org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchLyDoCapDoiCapLaiGPLXMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchLyDoCapDoiCapLaiGPLX", long.class);

		_getLyDoCapDoiCapLaiGPLXMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLyDoCapDoiCapLaiGPLX", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getLyDoCapDoiCapLaiGPLXsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLyDoCapDoiCapLaiGPLXs", int.class, int.class);

		_getLyDoCapDoiCapLaiGPLXsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLyDoCapDoiCapLaiGPLXsCount");

		_updateLyDoCapDoiCapLaiGPLXMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLyDoCapDoiCapLaiGPLX",
				org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX.class);

		_updateLyDoCapDoiCapLaiGPLXMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLyDoCapDoiCapLaiGPLX",
				org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX addLyDoCapDoiCapLaiGPLX(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLyDoCapDoiCapLaiGPLXMethodKey0,
				ClpSerializer.translateInput(lyDoCapDoiCapLaiGPLX));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX createLyDoCapDoiCapLaiGPLX(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createLyDoCapDoiCapLaiGPLXMethodKey1,
				id);

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

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteLyDoCapDoiCapLaiGPLX(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteLyDoCapDoiCapLaiGPLXMethodKey2,
				id);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteLyDoCapDoiCapLaiGPLX(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteLyDoCapDoiCapLaiGPLXMethodKey3,
				ClpSerializer.translateInput(lyDoCapDoiCapLaiGPLX));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX fetchLyDoCapDoiCapLaiGPLX(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchLyDoCapDoiCapLaiGPLXMethodKey8,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX getLyDoCapDoiCapLaiGPLX(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLyDoCapDoiCapLaiGPLXMethodKey9,
				id);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> getLyDoCapDoiCapLaiGPLXs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLyDoCapDoiCapLaiGPLXsMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX>)ClpSerializer.translateOutput(returnObj);
	}

	public int getLyDoCapDoiCapLaiGPLXsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLyDoCapDoiCapLaiGPLXsCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX updateLyDoCapDoiCapLaiGPLX(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLyDoCapDoiCapLaiGPLXMethodKey13,
				ClpSerializer.translateInput(lyDoCapDoiCapLaiGPLX));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX updateLyDoCapDoiCapLaiGPLX(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLyDoCapDoiCapLaiGPLXMethodKey14,
				ClpSerializer.translateInput(lyDoCapDoiCapLaiGPLX), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

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

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
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
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addLyDoCapDoiCapLaiGPLXMethodKey0;
	private MethodKey _createLyDoCapDoiCapLaiGPLXMethodKey1;
	private MethodKey _deleteLyDoCapDoiCapLaiGPLXMethodKey2;
	private MethodKey _deleteLyDoCapDoiCapLaiGPLXMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchLyDoCapDoiCapLaiGPLXMethodKey8;
	private MethodKey _getLyDoCapDoiCapLaiGPLXMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getLyDoCapDoiCapLaiGPLXsMethodKey11;
	private MethodKey _getLyDoCapDoiCapLaiGPLXsCountMethodKey12;
	private MethodKey _updateLyDoCapDoiCapLaiGPLXMethodKey13;
	private MethodKey _updateLyDoCapDoiCapLaiGPLXMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
}