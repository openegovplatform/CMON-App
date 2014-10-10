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

package org.oep.cmon.dao.thamso.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LIEMNN
 */
public class ThamSoLocalServiceClp implements ThamSoLocalService {
	public ThamSoLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addThamSoMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThamSo", org.oep.cmon.dao.thamso.model.ThamSo.class);

		_createThamSoMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createThamSo", long.class);

		_deleteThamSoMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThamSo", long.class);

		_deleteThamSoMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThamSo", org.oep.cmon.dao.thamso.model.ThamSo.class);

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

		_fetchThamSoMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchThamSo", long.class);

		_getThamSoMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThamSo", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getThamSosMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThamSos", int.class, int.class);

		_getThamSosCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThamSosCount");

		_updateThamSoMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThamSo", org.oep.cmon.dao.thamso.model.ThamSo.class);

		_updateThamSoMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThamSo", org.oep.cmon.dao.thamso.model.ThamSo.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getValueMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getValue", java.lang.String.class);

		_getValuesMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getValues", java.util.List.class);

		_findByTenMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTen", java.lang.String.class);

		_addMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"add", org.oep.cmon.dao.thamso.model.ThamSo.class);

		_searchByTenMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByTen", java.lang.String.class, int.class, int.class);

		_countByDaXoaMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByDaXoa", java.lang.String.class);

		_searchByTenUDHTMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByTenUDHT", java.lang.String.class,
				java.lang.Long.class, java.lang.Long.class, int.class, int.class);

		_countByTenUDHTMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTenUDHT", java.lang.String.class, java.lang.Long.class,
				java.lang.Long.class);

		_getAllMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAll");

		_getThamSoByGiaTriMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThamSoByGiaTri", java.lang.String.class);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo addThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThamSoMethodKey0,
				ClpSerializer.translateInput(thamSo));

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo createThamSo(long Id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createThamSoMethodKey1,
				Id);

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteThamSo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThamSoMethodKey2,
				Id);

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

	public void deleteThamSo(org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThamSoMethodKey3,
				ClpSerializer.translateInput(thamSo));

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

	public org.oep.cmon.dao.thamso.model.ThamSo fetchThamSo(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchThamSoMethodKey8,
				Id);

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo getThamSo(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThamSoMethodKey9, Id);

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> getThamSos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThamSosMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.thamso.model.ThamSo>)ClpSerializer.translateOutput(returnObj);
	}

	public int getThamSosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThamSosCountMethodKey12);

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

	public org.oep.cmon.dao.thamso.model.ThamSo updateThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThamSoMethodKey13,
				ClpSerializer.translateInput(thamSo));

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo updateThamSo(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThamSoMethodKey14,
				ClpSerializer.translateInput(thamSo), merge);

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
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

	public java.lang.String getValue(java.lang.String tenThamSo) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getValueMethodKey17,
				ClpSerializer.translateInput(tenThamSo));

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

	public java.util.List<java.lang.String> getValues(
		java.util.List<java.lang.String> listTenThamSo) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getValuesMethodKey18,
				ClpSerializer.translateInput(listTenThamSo));

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

		return (java.util.List<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo findByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTenMethodKey19,
				ClpSerializer.translateInput(ten));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.thamso.NoSuchThamSoException) {
				throw (org.oep.cmon.dao.thamso.NoSuchThamSoException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo add(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addMethodKey20,
				ClpSerializer.translateInput(thamSo));

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTen(
		java.lang.String ten, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByTenMethodKey21,
				ClpSerializer.translateInput(ten), start, end);

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.ThamSo>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByDaXoa(java.lang.String ten) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByDaXoaMethodKey22,
				ClpSerializer.translateInput(ten));

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

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> searchByTenUDHT(
		java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByTenUDHTMethodKey23,
				ClpSerializer.translateInput(ten),
				ClpSerializer.translateInput(ungDungId),
				ClpSerializer.translateInput(heThongId), start, end);

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.ThamSo>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByTenUDHT(java.lang.String ten, java.lang.Long ungDungId,
		java.lang.Long heThongId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTenUDHTMethodKey24,
				ClpSerializer.translateInput(ten),
				ClpSerializer.translateInput(ungDungId),
				ClpSerializer.translateInput(heThongId));

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

	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> getAll() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAllMethodKey25);

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.ThamSo>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.ThamSo getThamSoByGiaTri(
		java.lang.String giaTri) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThamSoByGiaTriMethodKey26,
				ClpSerializer.translateInput(giaTri));

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

		return (org.oep.cmon.dao.thamso.model.ThamSo)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addThamSoMethodKey0;
	private MethodKey _createThamSoMethodKey1;
	private MethodKey _deleteThamSoMethodKey2;
	private MethodKey _deleteThamSoMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchThamSoMethodKey8;
	private MethodKey _getThamSoMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getThamSosMethodKey11;
	private MethodKey _getThamSosCountMethodKey12;
	private MethodKey _updateThamSoMethodKey13;
	private MethodKey _updateThamSoMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getValueMethodKey17;
	private MethodKey _getValuesMethodKey18;
	private MethodKey _findByTenMethodKey19;
	private MethodKey _addMethodKey20;
	private MethodKey _searchByTenMethodKey21;
	private MethodKey _countByDaXoaMethodKey22;
	private MethodKey _searchByTenUDHTMethodKey23;
	private MethodKey _countByTenUDHTMethodKey24;
	private MethodKey _getAllMethodKey25;
	private MethodKey _getThamSoByGiaTriMethodKey26;
}