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
public class YKienTraoDoiLocalServiceClp implements YKienTraoDoiLocalService {
	public YKienTraoDoiLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addYKienTraoDoiMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addYKienTraoDoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class);

		_createYKienTraoDoiMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createYKienTraoDoi", long.class);

		_deleteYKienTraoDoiMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteYKienTraoDoi", long.class);

		_deleteYKienTraoDoiMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteYKienTraoDoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class);

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

		_fetchYKienTraoDoiMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchYKienTraoDoi", long.class);

		_getYKienTraoDoiMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getYKienTraoDoi", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getYKienTraoDoisMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getYKienTraoDois", int.class, int.class);

		_getYKienTraoDoisCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getYKienTraoDoisCount");

		_updateYKienTraoDoiMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateYKienTraoDoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class);

		_updateYKienTraoDoiMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateYKienTraoDoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findYKienByHoSoTTHCCongIdAndLoaiMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findYKienByHoSoTTHCCongIdAndLoai", long.class, long.class);

		_getYkienTraoDoiMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getYkienTraoDoi", long.class);

		_updateStatusMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateStatus", long.class, long.class);

		_findByHoSoTTHCCongIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongId", long.class, int.class, int.class);

		_findByHoSoTTHCCongIdAndLoaiMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongIdAndLoai", long.class, long.class);

		_countByHoSoTTHCCongIdMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByHoSoTTHCCongId", long.class);

		_addYkien_TraodoiMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"addYkien_Traodoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class);

		_updateYkien_TraodoiMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateYkien_Traodoi",
				org.oep.cmon.dao.hosohcc.model.YKienTraoDoi.class);

		_listYKienTraoDoiMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"listYKienTraoDoi", long.class, long.class,
				java.lang.String.class, int.class, int.class);

		_listCanBoTiepNhanMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"listCanBoTiepNhan", long.class, int.class, int.class);

		_listYKienTraoDoiAndLoaiMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"listYKienTraoDoiAndLoai", long.class, long.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_countYKienTraoDoiAndLoaiMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"countYKienTraoDoiAndLoai", long.class, long.class,
				java.lang.String.class, java.lang.String.class);

		_findByHoSoTTHCCongIdMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongId", long.class);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi addYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addYKienTraoDoiMethodKey0,
				ClpSerializer.translateInput(yKienTraoDoi));

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi createYKienTraoDoi(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createYKienTraoDoiMethodKey1,
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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteYKienTraoDoi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteYKienTraoDoiMethodKey2,
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

	public void deleteYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteYKienTraoDoiMethodKey3,
				ClpSerializer.translateInput(yKienTraoDoi));

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

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi fetchYKienTraoDoi(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchYKienTraoDoiMethodKey8,
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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi getYKienTraoDoi(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getYKienTraoDoiMethodKey9,
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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> getYKienTraoDois(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getYKienTraoDoisMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public int getYKienTraoDoisCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getYKienTraoDoisCountMethodKey12);

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

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateYKienTraoDoiMethodKey13,
				ClpSerializer.translateInput(yKienTraoDoi));

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYKienTraoDoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateYKienTraoDoiMethodKey14,
				ClpSerializer.translateInput(yKienTraoDoi), merge);

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findYKienByHoSoTTHCCongIdAndLoai(
		long idHoSo, long idLoai)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findYKienByHoSoTTHCCongIdAndLoaiMethodKey17,
				idHoSo, idLoai);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi getYkienTraoDoi(
		long yKienId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getYkienTraoDoiMethodKey18,
				yKienId);

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateStatus(
		long resourcePrimKey, long status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateStatusMethodKey19,
				resourcePrimKey, status);

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdMethodKey20,
				hoSoTTHCCongId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongIdAndLoai(
		long hoSoTTHCCongId, long loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdAndLoaiMethodKey21,
				hoSoTTHCCongId, loai);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByHoSoTTHCCongIdMethodKey22,
				hoSoTTHCCongId);

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

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi addYkien_Traodoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi newYKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addYkien_TraodoiMethodKey23,
				ClpSerializer.translateInput(newYKienTraoDoi));

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateYkien_Traodoi(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi newYKienTraoDoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateYkien_TraodoiMethodKey24,
				ClpSerializer.translateInput(newYKienTraoDoi));

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

		return (org.oep.cmon.dao.hosohcc.model.YKienTraoDoi)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoi(
		long hoSoTTHCCongId, long tkNguoiDungId, java.lang.String tieuDe,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listYKienTraoDoiMethodKey25,
				hoSoTTHCCongId, tkNguoiDungId,
				ClpSerializer.translateInput(tieuDe), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> listCanBoTiepNhan(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listCanBoTiepNhanMethodKey26,
				coQuanQuanLyId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.cc.model.CongChuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> listYKienTraoDoiAndLoai(
		long hoSoTTHCCongId, long tkNguoiDungId, java.lang.String loai,
		java.lang.String tieuDe, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listYKienTraoDoiAndLoaiMethodKey27,
				hoSoTTHCCongId, tkNguoiDungId,
				ClpSerializer.translateInput(loai),
				ClpSerializer.translateInput(tieuDe), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public int countYKienTraoDoiAndLoai(long hoSoTTHCCongId,
		long tkNguoiDungId, java.lang.String loai, java.lang.String tieuDe)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countYKienTraoDoiAndLoaiMethodKey28,
				hoSoTTHCCongId, tkNguoiDungId,
				ClpSerializer.translateInput(loai),
				ClpSerializer.translateInput(tieuDe));

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdMethodKey29,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addYKienTraoDoiMethodKey0;
	private MethodKey _createYKienTraoDoiMethodKey1;
	private MethodKey _deleteYKienTraoDoiMethodKey2;
	private MethodKey _deleteYKienTraoDoiMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchYKienTraoDoiMethodKey8;
	private MethodKey _getYKienTraoDoiMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getYKienTraoDoisMethodKey11;
	private MethodKey _getYKienTraoDoisCountMethodKey12;
	private MethodKey _updateYKienTraoDoiMethodKey13;
	private MethodKey _updateYKienTraoDoiMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findYKienByHoSoTTHCCongIdAndLoaiMethodKey17;
	private MethodKey _getYkienTraoDoiMethodKey18;
	private MethodKey _updateStatusMethodKey19;
	private MethodKey _findByHoSoTTHCCongIdMethodKey20;
	private MethodKey _findByHoSoTTHCCongIdAndLoaiMethodKey21;
	private MethodKey _countByHoSoTTHCCongIdMethodKey22;
	private MethodKey _addYkien_TraodoiMethodKey23;
	private MethodKey _updateYkien_TraodoiMethodKey24;
	private MethodKey _listYKienTraoDoiMethodKey25;
	private MethodKey _listCanBoTiepNhanMethodKey26;
	private MethodKey _listYKienTraoDoiAndLoaiMethodKey27;
	private MethodKey _countYKienTraoDoiAndLoaiMethodKey28;
	private MethodKey _findByHoSoTTHCCongIdMethodKey29;
}