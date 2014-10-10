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

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author liemnn
 */
public class DanhMucGiayTo2DoiTuongSuDungLocalServiceClp
	implements DanhMucGiayTo2DoiTuongSuDungLocalService {
	public DanhMucGiayTo2DoiTuongSuDungLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDanhMucGiayTo2DoiTuongSuDungMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDanhMucGiayTo2DoiTuongSuDung",
				org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung.class);

		_createDanhMucGiayTo2DoiTuongSuDungMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDanhMucGiayTo2DoiTuongSuDung", long.class);

		_deleteDanhMucGiayTo2DoiTuongSuDungMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDanhMucGiayTo2DoiTuongSuDung", long.class);

		_deleteDanhMucGiayTo2DoiTuongSuDungMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDanhMucGiayTo2DoiTuongSuDung",
				org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung.class);

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

		_fetchDanhMucGiayTo2DoiTuongSuDungMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDanhMucGiayTo2DoiTuongSuDung", long.class);

		_getDanhMucGiayTo2DoiTuongSuDungMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTo2DoiTuongSuDung", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getDanhMucGiayTo2DoiTuongSuDungsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTo2DoiTuongSuDungs", int.class, int.class);

		_getDanhMucGiayTo2DoiTuongSuDungsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTo2DoiTuongSuDungsCount");

		_updateDanhMucGiayTo2DoiTuongSuDungMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDanhMucGiayTo2DoiTuongSuDung",
				org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung.class);

		_updateDanhMucGiayTo2DoiTuongSuDungMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDanhMucGiayTo2DoiTuongSuDung",
				org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getTheoLoaiGT_DSDMGT2DTSDMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTheoLoaiGT_DSDMGT2DTSD", java.lang.Long.class);

		_getTheoLoaiDT_DSDMGT2DTSDMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTheoLoaiDT_DSDMGT2DTSD", java.lang.Long.class);
	}

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung addDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDanhMucGiayTo2DoiTuongSuDungMethodKey0,
				ClpSerializer.translateInput(danhMucGiayTo2DoiTuongSuDung));

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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung createDanhMucGiayTo2DoiTuongSuDung(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDanhMucGiayTo2DoiTuongSuDungMethodKey1,
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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDanhMucGiayTo2DoiTuongSuDung(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDanhMucGiayTo2DoiTuongSuDungMethodKey2,
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

	public void deleteDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDanhMucGiayTo2DoiTuongSuDungMethodKey3,
				ClpSerializer.translateInput(danhMucGiayTo2DoiTuongSuDung));

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

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung fetchDanhMucGiayTo2DoiTuongSuDung(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDanhMucGiayTo2DoiTuongSuDungMethodKey8,
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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung getDanhMucGiayTo2DoiTuongSuDung(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayTo2DoiTuongSuDungMethodKey9,
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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getDanhMucGiayTo2DoiTuongSuDungs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayTo2DoiTuongSuDungsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDanhMucGiayTo2DoiTuongSuDungsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayTo2DoiTuongSuDungsCountMethodKey12);

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

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDanhMucGiayTo2DoiTuongSuDungMethodKey13,
				ClpSerializer.translateInput(danhMucGiayTo2DoiTuongSuDung));

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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateDanhMucGiayTo2DoiTuongSuDung(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDanhMucGiayTo2DoiTuongSuDungMethodKey14,
				ClpSerializer.translateInput(danhMucGiayTo2DoiTuongSuDung),
				merge);

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

		return (org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiGT_DSDMGT2DTSD(
		java.lang.Long loaiGiayToId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTheoLoaiGT_DSDMGT2DTSDMethodKey17,
				ClpSerializer.translateInput(loaiGiayToId));

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> getTheoLoaiDT_DSDMGT2DTSD(
		java.lang.Long loaiDoiTuongId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTheoLoaiDT_DSDMGT2DTSDMethodKey18,
				ClpSerializer.translateInput(loaiDoiTuongId));

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDanhMucGiayTo2DoiTuongSuDungMethodKey0;
	private MethodKey _createDanhMucGiayTo2DoiTuongSuDungMethodKey1;
	private MethodKey _deleteDanhMucGiayTo2DoiTuongSuDungMethodKey2;
	private MethodKey _deleteDanhMucGiayTo2DoiTuongSuDungMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDanhMucGiayTo2DoiTuongSuDungMethodKey8;
	private MethodKey _getDanhMucGiayTo2DoiTuongSuDungMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDanhMucGiayTo2DoiTuongSuDungsMethodKey11;
	private MethodKey _getDanhMucGiayTo2DoiTuongSuDungsCountMethodKey12;
	private MethodKey _updateDanhMucGiayTo2DoiTuongSuDungMethodKey13;
	private MethodKey _updateDanhMucGiayTo2DoiTuongSuDungMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getTheoLoaiGT_DSDMGT2DTSDMethodKey17;
	private MethodKey _getTheoLoaiDT_DSDMGT2DTSDMethodKey18;
}