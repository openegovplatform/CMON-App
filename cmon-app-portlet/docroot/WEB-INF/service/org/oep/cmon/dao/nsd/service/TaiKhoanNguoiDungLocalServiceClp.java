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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Liemnn
 */
public class TaiKhoanNguoiDungLocalServiceClp
	implements TaiKhoanNguoiDungLocalService {
	public TaiKhoanNguoiDungLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addTaiKhoanNguoiDungMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addTaiKhoanNguoiDung",
				org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung.class);

		_createTaiKhoanNguoiDungMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createTaiKhoanNguoiDung", long.class);

		_deleteTaiKhoanNguoiDungMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTaiKhoanNguoiDung", long.class);

		_deleteTaiKhoanNguoiDungMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTaiKhoanNguoiDung",
				org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung.class);

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

		_fetchTaiKhoanNguoiDungMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchTaiKhoanNguoiDung", long.class);

		_getTaiKhoanNguoiDungMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiKhoanNguoiDung", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getTaiKhoanNguoiDungsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiKhoanNguoiDungs", int.class, int.class);

		_getTaiKhoanNguoiDungsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiKhoanNguoiDungsCount");

		_updateTaiKhoanNguoiDungMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTaiKhoanNguoiDung",
				org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung.class);

		_updateTaiKhoanNguoiDungMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTaiKhoanNguoiDung",
				org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByTenDangNhapMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTenDangNhap", java.lang.String.class);

		_findByTaiKhoanNguoiDungIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTaiKhoanNguoiDungId", long.class);

		_findByEmailMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByEmail", java.lang.String.class);

		_fetchByLiferayUserIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchByLiferayUserId", long.class);

		_findByTaiKhoanNguoiDungMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTaiKhoanNguoiDung", java.lang.Long.class, int.class);

		_findTaiKhoanNguoiDungPopupMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTaiKhoanNguoiDungPopup", java.lang.String.class,
				java.lang.String.class);

		_findTaiKhoanNguoiDungMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTaiKhoanNguoiDung", java.lang.String.class,
				java.lang.String.class);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung addTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addTaiKhoanNguoiDungMethodKey0,
				ClpSerializer.translateInput(taiKhoanNguoiDung));

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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung createTaiKhoanNguoiDung(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createTaiKhoanNguoiDungMethodKey1,
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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteTaiKhoanNguoiDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTaiKhoanNguoiDungMethodKey2,
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

	public void deleteTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTaiKhoanNguoiDungMethodKey3,
				ClpSerializer.translateInput(taiKhoanNguoiDung));

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

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchTaiKhoanNguoiDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchTaiKhoanNguoiDungMethodKey8,
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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung getTaiKhoanNguoiDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiKhoanNguoiDungMethodKey9,
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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> getTaiKhoanNguoiDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiKhoanNguoiDungsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung>)ClpSerializer.translateOutput(returnObj);
	}

	public int getTaiKhoanNguoiDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiKhoanNguoiDungsCountMethodKey12);

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

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTaiKhoanNguoiDungMethodKey13,
				ClpSerializer.translateInput(taiKhoanNguoiDung));

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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateTaiKhoanNguoiDung(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTaiKhoanNguoiDungMethodKey14,
				ClpSerializer.translateInput(taiKhoanNguoiDung), merge);

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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
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

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTenDangNhapMethodKey17,
				ClpSerializer.translateInput(tenDangNhap));

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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTaiKhoanNguoiDungIdMethodKey18,
				taiKhoanNguoiDungId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException) {
				throw (org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByEmailMethodKey19,
				ClpSerializer.translateInput(email));

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

		return (java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByLiferayUserId(
		long liferayUserId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchByLiferayUserIdMethodKey20,
				liferayUserId);

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

		return (org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTaiKhoanNguoiDungMethodKey21,
				ClpSerializer.translateInput(taiKhoanId), daXoa);

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

		return (java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDungPopup(
		java.lang.String keyWord, java.lang.String option) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTaiKhoanNguoiDungPopupMethodKey22,
				ClpSerializer.translateInput(keyWord),
				ClpSerializer.translateInput(option));

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

		return (java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findTaiKhoanNguoiDung(
		java.lang.String keyWord, java.lang.String option) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTaiKhoanNguoiDungMethodKey23,
				ClpSerializer.translateInput(keyWord),
				ClpSerializer.translateInput(option));

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

		return (java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addTaiKhoanNguoiDungMethodKey0;
	private MethodKey _createTaiKhoanNguoiDungMethodKey1;
	private MethodKey _deleteTaiKhoanNguoiDungMethodKey2;
	private MethodKey _deleteTaiKhoanNguoiDungMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchTaiKhoanNguoiDungMethodKey8;
	private MethodKey _getTaiKhoanNguoiDungMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getTaiKhoanNguoiDungsMethodKey11;
	private MethodKey _getTaiKhoanNguoiDungsCountMethodKey12;
	private MethodKey _updateTaiKhoanNguoiDungMethodKey13;
	private MethodKey _updateTaiKhoanNguoiDungMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByTenDangNhapMethodKey17;
	private MethodKey _findByTaiKhoanNguoiDungIdMethodKey18;
	private MethodKey _findByEmailMethodKey19;
	private MethodKey _fetchByLiferayUserIdMethodKey20;
	private MethodKey _findByTaiKhoanNguoiDungMethodKey21;
	private MethodKey _findTaiKhoanNguoiDungPopupMethodKey22;
	private MethodKey _findTaiKhoanNguoiDungMethodKey23;
}