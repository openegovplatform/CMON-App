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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Liemnn
 */
public class DanhMucGiayToLocalServiceClp implements DanhMucGiayToLocalService {
	public DanhMucGiayToLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDanhMucGiayToMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDanhMucGiayTo",
				org.oep.cmon.dao.tlct.model.DanhMucGiayTo.class);

		_createDanhMucGiayToMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDanhMucGiayTo", long.class);

		_deleteDanhMucGiayToMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDanhMucGiayTo", long.class);

		_deleteDanhMucGiayToMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDanhMucGiayTo",
				org.oep.cmon.dao.tlct.model.DanhMucGiayTo.class);

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

		_fetchDanhMucGiayToMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDanhMucGiayTo", long.class);

		_getDanhMucGiayToMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTo", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getDanhMucGiayTosMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTos", int.class, int.class);

		_getDanhMucGiayTosCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayTosCount");

		_updateDanhMucGiayToMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDanhMucGiayTo",
				org.oep.cmon.dao.tlct.model.DanhMucGiayTo.class);

		_updateDanhMucGiayToMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDanhMucGiayTo",
				org.oep.cmon.dao.tlct.model.DanhMucGiayTo.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getGiayToBoiMaMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getGiayToBoiMa", java.lang.String.class);

		_searchDanhMucGiayToMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchDanhMucGiayTo", java.lang.String.class,
				java.lang.Long.class, int.class, int.class);

		_countDanhMucGiayToMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDanhMucGiayTo", java.lang.String.class,
				java.lang.Long.class);

		_searchByTTHCIdOrGDIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByTTHCIdOrGDId", java.lang.String.class,
				java.lang.String.class, java.lang.Long.class,
				java.lang.Long.class, java.lang.Integer.class, int.class,
				int.class);

		_countByTTHCIdOrGDIdMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTTHCIdOrGDId", java.lang.String.class,
				java.lang.String.class, java.lang.Long.class,
				java.lang.Long.class, java.lang.Integer.class);

		_findGiayToKetQuaMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findGiayToKetQua", long.class);

		_finlistGiayToBCNopDonMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"finlistGiayToBCNopDon", long.class);

		_findTheoMaMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTheoMa", java.lang.String.class);

		_getDanhMucGiayToListMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhMucGiayToList", int.class);

		_listByCongDanMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"listByCongDan", java.lang.Long.class);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo addDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDanhMucGiayToMethodKey0,
				ClpSerializer.translateInput(danhMucGiayTo));

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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo createDanhMucGiayTo(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDanhMucGiayToMethodKey1,
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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDanhMucGiayToMethodKey2,
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

	public void deleteDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDanhMucGiayToMethodKey3,
				ClpSerializer.translateInput(danhMucGiayTo));

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

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDanhMucGiayToMethodKey8,
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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo getDanhMucGiayTo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayToMethodKey9,
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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayTos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayTosMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDanhMucGiayTosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayTosCountMethodKey12);

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

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDanhMucGiayToMethodKey13,
				ClpSerializer.translateInput(danhMucGiayTo));

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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateDanhMucGiayTo(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDanhMucGiayToMethodKey14,
				ClpSerializer.translateInput(danhMucGiayTo), merge);

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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
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

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo getGiayToBoiMa(
		java.lang.String ma) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getGiayToBoiMaMethodKey17,
				ClpSerializer.translateInput(ma));

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

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchDanhMucGiayTo(
		java.lang.String group, java.lang.Long doiTuongId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchDanhMucGiayToMethodKey18,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(doiTuongId), start, end);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public long countDanhMucGiayTo(java.lang.String group,
		java.lang.Long doiTuongId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDanhMucGiayToMethodKey19,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(doiTuongId));

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

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> searchByTTHCIdOrGDId(
		java.lang.String group, java.lang.String doituong,
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByTTHCIdOrGDIdMethodKey20,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(doituong),
				ClpSerializer.translateInput(tthcid),
				ClpSerializer.translateInput(dgId),
				ClpSerializer.translateInput(daXoa), start, end);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByTTHCIdOrGDId(java.lang.String group,
		java.lang.String doituong, java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTTHCIdOrGDIdMethodKey21,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(doituong),
				ClpSerializer.translateInput(tthcid),
				ClpSerializer.translateInput(dgId),
				ClpSerializer.translateInput(daXoa));

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

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findGiayToKetQua(
		long thutuchanhchinhId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findGiayToKetQuaMethodKey22,
				thutuchanhchinhId);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> finlistGiayToBCNopDon(
		long hosothutuchccId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_finlistGiayToBCNopDonMethodKey23,
				hosothutuchccId);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findTheoMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTheoMaMethodKey24,
				ClpSerializer.translateInput(ma));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException) {
				throw (org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.tlct.model.DanhMucGiayTo)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getDanhMucGiayToList(
		int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhMucGiayToListMethodKey25,
				daXoa);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> listByCongDan(
		java.lang.Long doiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_listByCongDanMethodKey26,
				ClpSerializer.translateInput(doiTuongId));

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDanhMucGiayToMethodKey0;
	private MethodKey _createDanhMucGiayToMethodKey1;
	private MethodKey _deleteDanhMucGiayToMethodKey2;
	private MethodKey _deleteDanhMucGiayToMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDanhMucGiayToMethodKey8;
	private MethodKey _getDanhMucGiayToMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDanhMucGiayTosMethodKey11;
	private MethodKey _getDanhMucGiayTosCountMethodKey12;
	private MethodKey _updateDanhMucGiayToMethodKey13;
	private MethodKey _updateDanhMucGiayToMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getGiayToBoiMaMethodKey17;
	private MethodKey _searchDanhMucGiayToMethodKey18;
	private MethodKey _countDanhMucGiayToMethodKey19;
	private MethodKey _searchByTTHCIdOrGDIdMethodKey20;
	private MethodKey _countByTTHCIdOrGDIdMethodKey21;
	private MethodKey _findGiayToKetQuaMethodKey22;
	private MethodKey _finlistGiayToBCNopDonMethodKey23;
	private MethodKey _findTheoMaMethodKey24;
	private MethodKey _getDanhMucGiayToListMethodKey25;
	private MethodKey _listByCongDanMethodKey26;
}