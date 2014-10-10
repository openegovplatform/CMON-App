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

package org.oep.cmon.dao.hosolienthong.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author hoangtrung.nguyen
 */
public class HoSoLienThongLocalServiceClp implements HoSoLienThongLocalService {
	public HoSoLienThongLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addHoSoLienThongMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addHoSoLienThong",
				org.oep.cmon.dao.hosolienthong.model.HoSoLienThong.class);

		_createHoSoLienThongMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createHoSoLienThong", long.class);

		_deleteHoSoLienThongMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteHoSoLienThong", long.class);

		_deleteHoSoLienThongMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteHoSoLienThong",
				org.oep.cmon.dao.hosolienthong.model.HoSoLienThong.class);

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

		_fetchHoSoLienThongMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchHoSoLienThong", long.class);

		_getHoSoLienThongMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoLienThong", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getHoSoLienThongsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoLienThongs", int.class, int.class);

		_getHoSoLienThongsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoLienThongsCount");

		_updateHoSoLienThongMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateHoSoLienThong",
				org.oep.cmon.dao.hosolienthong.model.HoSoLienThong.class);

		_updateHoSoLienThongMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateHoSoLienThong",
				org.oep.cmon.dao.hosolienthong.model.HoSoLienThong.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_countByMaSoBienNhanLucGuiMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByMaSoBienNhanLucGui", java.lang.String.class);

		_fetchByMaSoBienNhanLucGuiMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchByMaSoBienNhanLucGui", java.lang.String.class);

		_countByHoSoIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByHoSoId", long.class);

		_fetchByHoSoIdAndThuTuLienThongMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchByHoSoIdAndThuTuLienThong", long.class, int.class);

		_findByHoSoIdMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoId", long.class);

		_searchHoSoNoiNhanMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchHoSoNoiNhan", javax.portlet.PortletRequest.class,
				org.oep.cmon.dao.cc.model.CongChuc.class, long[].class);

		_searchHoSoNoiGuiMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchHoSoNoiGui", javax.portlet.PortletRequest.class,
				org.oep.cmon.dao.cc.model.CongChuc.class, long[].class);
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong addHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addHoSoLienThongMethodKey0,
				ClpSerializer.translateInput(hoSoLienThong));

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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong createHoSoLienThong(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createHoSoLienThongMethodKey1,
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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteHoSoLienThong(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteHoSoLienThongMethodKey2,
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

	public void deleteHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteHoSoLienThongMethodKey3,
				ClpSerializer.translateInput(hoSoLienThong));

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

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchHoSoLienThong(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchHoSoLienThongMethodKey8,
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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong getHoSoLienThong(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoLienThongMethodKey9,
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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> getHoSoLienThongs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoLienThongsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong>)ClpSerializer.translateOutput(returnObj);
	}

	public int getHoSoLienThongsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoLienThongsCountMethodKey12);

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

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateHoSoLienThongMethodKey13,
				ClpSerializer.translateInput(hoSoLienThong));

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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateHoSoLienThong(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateHoSoLienThongMethodKey14,
				ClpSerializer.translateInput(hoSoLienThong), merge);

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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
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

	public int countByMaSoBienNhanLucGui(java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByMaSoBienNhanLucGuiMethodKey17,
				ClpSerializer.translateInput(maSoBienNhanLucGui));

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

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchByMaSoBienNhanLucGuiMethodKey18,
				ClpSerializer.translateInput(maSoBienNhanLucGui));

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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public int countByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByHoSoIdMethodKey19,
				hoSoId);

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

	public org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByHoSoIdAndThuTuLienThong(
		long hoSoId, int thuTu)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchByHoSoIdAndThuTuLienThongMethodKey20,
				hoSoId, thuTu);

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

		return (org.oep.cmon.dao.hosolienthong.model.HoSoLienThong)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoIdMethodKey21,
				hoSoId);

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

		return (java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiNhan(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiNhan, long[] thuTucNhanIds) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchHoSoNoiNhanMethodKey22,
				ClpSerializer.translateInput(request),
				ClpSerializer.translateInput(canBoNoiNhan),
				ClpSerializer.translateInput(thuTucNhanIds));

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

		return (org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> searchHoSoNoiGui(
		javax.portlet.PortletRequest request,
		org.oep.cmon.dao.cc.model.CongChuc canBoNoiGui, long[] thuTucGuiIds) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchHoSoNoiGuiMethodKey23,
				ClpSerializer.translateInput(request),
				ClpSerializer.translateInput(canBoNoiGui),
				ClpSerializer.translateInput(thuTucGuiIds));

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

		return (org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addHoSoLienThongMethodKey0;
	private MethodKey _createHoSoLienThongMethodKey1;
	private MethodKey _deleteHoSoLienThongMethodKey2;
	private MethodKey _deleteHoSoLienThongMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchHoSoLienThongMethodKey8;
	private MethodKey _getHoSoLienThongMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getHoSoLienThongsMethodKey11;
	private MethodKey _getHoSoLienThongsCountMethodKey12;
	private MethodKey _updateHoSoLienThongMethodKey13;
	private MethodKey _updateHoSoLienThongMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _countByMaSoBienNhanLucGuiMethodKey17;
	private MethodKey _fetchByMaSoBienNhanLucGuiMethodKey18;
	private MethodKey _countByHoSoIdMethodKey19;
	private MethodKey _fetchByHoSoIdAndThuTuLienThongMethodKey20;
	private MethodKey _findByHoSoIdMethodKey21;
	private MethodKey _searchHoSoNoiNhanMethodKey22;
	private MethodKey _searchHoSoNoiGuiMethodKey23;
}