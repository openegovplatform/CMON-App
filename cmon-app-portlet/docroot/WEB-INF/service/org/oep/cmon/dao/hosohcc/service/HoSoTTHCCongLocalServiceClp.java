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
public class HoSoTTHCCongLocalServiceClp implements HoSoTTHCCongLocalService {
	public HoSoTTHCCongLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addHoSoTTHCCongMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addHoSoTTHCCong",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class);

		_createHoSoTTHCCongMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createHoSoTTHCCong", long.class);

		_deleteHoSoTTHCCongMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteHoSoTTHCCong", long.class);

		_deleteHoSoTTHCCongMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteHoSoTTHCCong",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class);

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

		_fetchHoSoTTHCCongMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchHoSoTTHCCong", long.class);

		_getHoSoTTHCCongMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoTTHCCong", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getHoSoTTHCCongsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoTTHCCongs", int.class, int.class);

		_getHoSoTTHCCongsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoTTHCCongsCount");

		_updateHoSoTTHCCongMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateHoSoTTHCCong",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class);

		_updateHoSoTTHCCongMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateHoSoTTHCCong",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_fetchByMaSoBienNhanMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchByMaSoBienNhan", java.lang.String.class);

		_countByMaCongDanHoSo_QTMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByMaCongDanHoSo_QT", long.class, java.lang.String.class,
				long.class);

		_searchByMaCongDanHoSo_QTMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByMaCongDanHoSo_QT", long.class, java.lang.String.class,
				long.class, int.class, int.class);

		_findByCQQLMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByCQQL", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class, int.class,
				int.class);

		_findByMutilStatusAndTTHCMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, long.class, java.lang.String.class,
				long.class, java.lang.String.class, int.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_findByCBXLMutilStatusAndTTHCMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByCBXLMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, java.lang.String.class, long.class,
				java.lang.String.class, int.class, int.class, int.class);

		_countByCQQLMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByCQQL", java.lang.String.class, long.class,
				java.lang.String.class, long.class, int.class);

		_countHoSoTTHCCongByCoQuanQuanLyMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"countHoSoTTHCCongByCoQuanQuanLy", java.lang.String.class,
				int.class, long.class);

		_countByMutilStatusAndTTHCMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, long.class, java.lang.String.class,
				long.class, java.lang.String.class, int.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_findHoSoTTHCCongMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"findHoSoTTHCCong", java.lang.String.class, int.class,
				long.class, int.class, int.class);

		_updateHOSOTTHCCONGByIdMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateHOSOTTHCCONGById", long.class, int.class);

		_findByMaSoHoSoMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaSoHoSo", java.lang.String.class);

		_findByMaSoBienNhanMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaSoBienNhan", java.lang.String.class);

		_findByLoaiHoSoMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByLoaiHoSo", int.class);

		_findByLoaiHoSoMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByLoaiHoSo", int.class, int.class, int.class);

		_capNhatTrangThaiMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"capNhatTrangThai", java.lang.Long.class, int.class);

		_searchHSDangXuLyMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchHSDangXuLy", java.lang.String.class, long.class,
				int.class, java.lang.String.class, int.class, int.class);

		_countHSDangXuLyMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"countHSDangXuLy", java.lang.String.class, long.class,
				int.class, java.lang.String.class, int.class, int.class);

		_searchHSDangXuLyMutilStatusAndTTHCMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchHSDangXuLyMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countHSDangXuLyMutilStatusAndTTHCMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"countHSDangXuLyMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_searchAllHSDangXuLyMutilStatusAndTTHCMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchAllHSDangXuLyMutilStatusAndTTHC",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.util.List.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class);

		_countAllHSDangXuLyMutilStatusAndTTHCMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"countAllHSDangXuLyMutilStatusAndTTHC", java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.util.List.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_findByTrangThaiHoSoMethodKey39 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTrangThaiHoSo", int.class, java.lang.Long.class);

		_findByThutucId_CongDanIdMethodKey40 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByThutucId_CongDanId", java.lang.Long.class,
				java.lang.Long.class);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong addHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addHoSoTTHCCongMethodKey0,
				ClpSerializer.translateInput(hoSoTTHCCong));

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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong createHoSoTTHCCong(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createHoSoTTHCCongMethodKey1,
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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteHoSoTTHCCong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteHoSoTTHCCongMethodKey2,
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

	public void deleteHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteHoSoTTHCCongMethodKey3,
				ClpSerializer.translateInput(hoSoTTHCCong));

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

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchHoSoTTHCCong(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchHoSoTTHCCongMethodKey8,
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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong getHoSoTTHCCong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoTTHCCongMethodKey9,
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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> getHoSoTTHCCongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoTTHCCongsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int getHoSoTTHCCongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoTTHCCongsCountMethodKey12);

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

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateHoSoTTHCCongMethodKey13,
				ClpSerializer.translateInput(hoSoTTHCCong));

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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateHoSoTTHCCong(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateHoSoTTHCCongMethodKey14,
				ClpSerializer.translateInput(hoSoTTHCCong), merge);

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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
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

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchByMaSoBienNhanMethodKey17,
				ClpSerializer.translateInput(maSoBienNhan));

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

		return (org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong)ClpSerializer.translateOutput(returnObj);
	}

	public long countByMaCongDanHoSo_QT(long congDanNopId,
		java.lang.String maSoHoSo, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByMaCongDanHoSo_QTMethodKey18,
				congDanNopId, ClpSerializer.translateInput(maSoHoSo),
				thuTucHanhChinhId);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchByMaCongDanHoSo_QT(
		long congDanNopId, java.lang.String maSoHoSo, long thuTucHanhChinhId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByMaCongDanHoSo_QTMethodKey19,
				congDanNopId, ClpSerializer.translateInput(maSoHoSo),
				thuTucHanhChinhId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCQQL(
		java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByCQQLMethodKey20,
				ClpSerializer.translateInput(maSoHoSo), thuTucHanhChinhId,
				ClpSerializer.translateInput(maUngDung), cqqlId, trangThai,
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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMutilStatusAndTTHC(
		java.lang.String tthcsIds, java.lang.String maSoHoSo, long idCanBo,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, java.lang.String tuNgay, java.lang.String denNgay,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMutilStatusAndTTHCMethodKey21,
				ClpSerializer.translateInput(tthcsIds),
				ClpSerializer.translateInput(maSoHoSo), idCanBo,
				ClpSerializer.translateInput(maUngDung), cqqlId,
				ClpSerializer.translateInput(trangThais), yeuCauRut,
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCBXLMutilStatusAndTTHC(
		java.lang.String maSoHoSo, java.lang.String thuTucHanhChinhIds,
		java.lang.String maUngDung, long cqqlId, java.lang.String trangThais,
		int yeuCauRut, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByCBXLMutilStatusAndTTHCMethodKey22,
				ClpSerializer.translateInput(maSoHoSo),
				ClpSerializer.translateInput(thuTucHanhChinhIds),
				ClpSerializer.translateInput(maUngDung), cqqlId,
				ClpSerializer.translateInput(trangThais), yeuCauRut, start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByCQQL(java.lang.String maSoHoSo, long thuTucHanhChinhId,
		java.lang.String maUngDung, long cqqlId, int trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByCQQLMethodKey23,
				ClpSerializer.translateInput(maSoHoSo), thuTucHanhChinhId,
				ClpSerializer.translateInput(maUngDung), cqqlId, trangThai);

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

	public long countHoSoTTHCCongByCoQuanQuanLy(java.lang.String maSoHoSo,
		int trangThaiHoSo, long cqqlId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countHoSoTTHCCongByCoQuanQuanLyMethodKey24,
				ClpSerializer.translateInput(maSoHoSo), trangThaiHoSo, cqqlId);

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

		return ((Long)returnObj).longValue();
	}

	public int countByMutilStatusAndTTHC(java.lang.String tthcsIds,
		java.lang.String maSoHoSo, long idCanBo, java.lang.String maUngDung,
		long cqqlId, java.lang.String trangThais, int yeuCauRut,
		java.lang.String tuNgay, java.lang.String denNgay, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByMutilStatusAndTTHCMethodKey25,
				ClpSerializer.translateInput(tthcsIds),
				ClpSerializer.translateInput(maSoHoSo), idCanBo,
				ClpSerializer.translateInput(maUngDung), cqqlId,
				ClpSerializer.translateInput(trangThais), yeuCauRut,
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findHoSoTTHCCong(
		java.lang.String maSoHoSo, int trangThaiHoSo, long cqqlId, int start,
		int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findHoSoTTHCCongMethodKey26,
				ClpSerializer.translateInput(maSoHoSo), trangThaiHoSo, cqqlId,
				start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int updateHOSOTTHCCONGById(long hoSoTTHCCongId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateHOSOTTHCCONGByIdMethodKey27,
				hoSoTTHCCongId, status);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoHoSo(
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaSoHoSoMethodKey28,
				ClpSerializer.translateInput(maSoHoSo));

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByMaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaSoBienNhanMethodKey29,
				ClpSerializer.translateInput(maSoBienNhan));

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByLoaiHoSoMethodKey30,
				loaiHoSo);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByLoaiHoSoMethodKey31,
				loaiHoSo, start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong capNhatTrangThai(
		java.lang.Long id, int status) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_capNhatTrangThaiMethodKey32,
				ClpSerializer.translateInput(id), status);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLy(
		java.lang.String maSoHoSo, long thuTucHanhChinhId, int status,
		java.lang.String emailCanBo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchHSDangXuLyMethodKey33,
				ClpSerializer.translateInput(maSoHoSo), thuTucHanhChinhId,
				status, ClpSerializer.translateInput(emailCanBo), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int countHSDangXuLy(java.lang.String maSoHoSo,
		long thuTucHanhChinhId, int status, java.lang.String emailCanBo,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countHSDangXuLyMethodKey34,
				ClpSerializer.translateInput(maSoHoSo), thuTucHanhChinhId,
				status, ClpSerializer.translateInput(emailCanBo), start, end);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchHSDangXuLyMutilStatusAndTTHCMethodKey35,
				ClpSerializer.translateInput(maSoOrTenNguoiNopHoSo),
				ClpSerializer.translateInput(thuTucHanhChinhIds),
				ClpSerializer.translateInput(status),
				ClpSerializer.translateInput(emailCanBo),
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int countHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.lang.String emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countHSDangXuLyMutilStatusAndTTHCMethodKey36,
				ClpSerializer.translateInput(maSoOrTenNguoiNopHoSo),
				ClpSerializer.translateInput(thuTucHanhChinhIds),
				ClpSerializer.translateInput(status),
				ClpSerializer.translateInput(emailCanBo),
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> searchAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchAllHSDangXuLyMutilStatusAndTTHCMethodKey37,
				ClpSerializer.translateInput(maSoOrTenNguoiNopHoSo),
				ClpSerializer.translateInput(thuTucHanhChinhIds),
				ClpSerializer.translateInput(status),
				ClpSerializer.translateInput(emailCanBo),
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public int countAllHSDangXuLyMutilStatusAndTTHC(
		java.lang.String maSoOrTenNguoiNopHoSo,
		java.lang.String thuTucHanhChinhIds, java.lang.String status,
		java.util.List<java.lang.String> emailCanBo, java.lang.String tuNgay,
		java.lang.String denNgay, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countAllHSDangXuLyMutilStatusAndTTHCMethodKey38,
				ClpSerializer.translateInput(maSoOrTenNguoiNopHoSo),
				ClpSerializer.translateInput(thuTucHanhChinhIds),
				ClpSerializer.translateInput(status),
				ClpSerializer.translateInput(emailCanBo),
				ClpSerializer.translateInput(tuNgay),
				ClpSerializer.translateInput(denNgay), start, end);

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, java.lang.Long coQuanTiepNhanId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTrangThaiHoSoMethodKey39,
				trangThaiHoSo, ClpSerializer.translateInput(coQuanTiepNhanId));

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThutucId_CongDanId(
		java.lang.Long thutucId, java.lang.Long congdanId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByThutucId_CongDanIdMethodKey40,
				ClpSerializer.translateInput(thutucId),
				ClpSerializer.translateInput(congdanId));

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addHoSoTTHCCongMethodKey0;
	private MethodKey _createHoSoTTHCCongMethodKey1;
	private MethodKey _deleteHoSoTTHCCongMethodKey2;
	private MethodKey _deleteHoSoTTHCCongMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchHoSoTTHCCongMethodKey8;
	private MethodKey _getHoSoTTHCCongMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getHoSoTTHCCongsMethodKey11;
	private MethodKey _getHoSoTTHCCongsCountMethodKey12;
	private MethodKey _updateHoSoTTHCCongMethodKey13;
	private MethodKey _updateHoSoTTHCCongMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _fetchByMaSoBienNhanMethodKey17;
	private MethodKey _countByMaCongDanHoSo_QTMethodKey18;
	private MethodKey _searchByMaCongDanHoSo_QTMethodKey19;
	private MethodKey _findByCQQLMethodKey20;
	private MethodKey _findByMutilStatusAndTTHCMethodKey21;
	private MethodKey _findByCBXLMutilStatusAndTTHCMethodKey22;
	private MethodKey _countByCQQLMethodKey23;
	private MethodKey _countHoSoTTHCCongByCoQuanQuanLyMethodKey24;
	private MethodKey _countByMutilStatusAndTTHCMethodKey25;
	private MethodKey _findHoSoTTHCCongMethodKey26;
	private MethodKey _updateHOSOTTHCCONGByIdMethodKey27;
	private MethodKey _findByMaSoHoSoMethodKey28;
	private MethodKey _findByMaSoBienNhanMethodKey29;
	private MethodKey _findByLoaiHoSoMethodKey30;
	private MethodKey _findByLoaiHoSoMethodKey31;
	private MethodKey _capNhatTrangThaiMethodKey32;
	private MethodKey _searchHSDangXuLyMethodKey33;
	private MethodKey _countHSDangXuLyMethodKey34;
	private MethodKey _searchHSDangXuLyMutilStatusAndTTHCMethodKey35;
	private MethodKey _countHSDangXuLyMutilStatusAndTTHCMethodKey36;
	private MethodKey _searchAllHSDangXuLyMutilStatusAndTTHCMethodKey37;
	private MethodKey _countAllHSDangXuLyMutilStatusAndTTHCMethodKey38;
	private MethodKey _findByTrangThaiHoSoMethodKey39;
	private MethodKey _findByThutucId_CongDanIdMethodKey40;
}