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
public class AnhXaLocalServiceClp implements AnhXaLocalService {
	public AnhXaLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addAnhXaMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addAnhXa", org.oep.cmon.dao.thamso.model.AnhXa.class);

		_createAnhXaMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createAnhXa", long.class);

		_deleteAnhXaMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteAnhXa", long.class);

		_deleteAnhXaMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteAnhXa", org.oep.cmon.dao.thamso.model.AnhXa.class);

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

		_fetchAnhXaMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchAnhXa", long.class);

		_getAnhXaMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAnhXa", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getAnhXasMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAnhXas", int.class, int.class);

		_getAnhXasCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAnhXasCount");

		_updateAnhXaMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateAnhXa", org.oep.cmon.dao.thamso.model.AnhXa.class);

		_updateAnhXaMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateAnhXa", org.oep.cmon.dao.thamso.model.AnhXa.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getMaByIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getMaById", java.lang.String.class, java.lang.Long.class);

		_getAnhXaByApp_Table_CodeMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getAnhXaByApp_Table_Code", java.lang.Long.class,
				java.lang.String.class, java.lang.String.class);

		_synchronizeMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"synchronize", java.lang.Long.class, java.lang.String.class,
				boolean.class);

		_deleteMappingMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteMapping", java.lang.Long.class, java.lang.String.class,
				boolean.class);

		_countSearchMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"countSearch", java.lang.String.class, java.lang.Long.class,
				java.lang.String.class);

		_searchMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", java.lang.String.class, java.lang.Long.class,
				java.lang.String.class, int.class, int.class);

		_getDSBangMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSBang");

		_getMaKhacExChMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getMaKhacExCh", java.lang.String.class, java.lang.String.class);

		_getMaKhacExChMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getMaKhacExCh", java.lang.String.class,
				java.lang.String.class, long.class);

		_getDNGFromMaKhacCQQLMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDNGFromMaKhacCQQL", java.lang.String.class,
				java.lang.String.class);

		_getDNGFromMaKhacTTHCMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDNGFromMaKhacTTHC", java.lang.String.class,
				java.lang.String.class);

		_getDNGFromMaKhacGPLXMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDNGFromMaKhacGPLX", java.lang.String.class,
				java.lang.String.class);
	}

	public org.oep.cmon.dao.thamso.model.AnhXa addAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addAnhXaMethodKey0,
				ClpSerializer.translateInput(anhXa));

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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.AnhXa createAnhXa(long Id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createAnhXaMethodKey1,
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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteAnhXaMethodKey2,
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

	public void deleteAnhXa(org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteAnhXaMethodKey3,
				ClpSerializer.translateInput(anhXa));

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

	public org.oep.cmon.dao.thamso.model.AnhXa fetchAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchAnhXaMethodKey8,
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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXa(long Id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAnhXaMethodKey9, Id);

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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getAnhXas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAnhXasMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public int getAnhXasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAnhXasCountMethodKey12);

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

	public org.oep.cmon.dao.thamso.model.AnhXa updateAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateAnhXaMethodKey13,
				ClpSerializer.translateInput(anhXa));

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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.thamso.model.AnhXa updateAnhXa(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateAnhXaMethodKey14,
				ClpSerializer.translateInput(anhXa), merge);

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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
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

	public java.lang.String getMaById(java.lang.String table, java.lang.Long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getMaByIdMethodKey17,
				ClpSerializer.translateInput(table),
				ClpSerializer.translateInput(id));

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

	public org.oep.cmon.dao.thamso.model.AnhXa getAnhXaByApp_Table_Code(
		java.lang.Long appId, java.lang.String table, java.lang.String code) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getAnhXaByApp_Table_CodeMethodKey18,
				ClpSerializer.translateInput(appId),
				ClpSerializer.translateInput(table),
				ClpSerializer.translateInput(code));

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

		return (org.oep.cmon.dao.thamso.model.AnhXa)ClpSerializer.translateOutput(returnObj);
	}

	public void synchronize(java.lang.Long appId, java.lang.String table,
		boolean overwriteAll)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_synchronizeMethodKey19,
				ClpSerializer.translateInput(appId),
				ClpSerializer.translateInput(table), overwriteAll);

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

	public boolean deleteMapping(java.lang.Long appId, java.lang.String table,
		boolean deleteMapping) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_deleteMappingMethodKey20,
				ClpSerializer.translateInput(appId),
				ClpSerializer.translateInput(table), deleteMapping);

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

		return ((Boolean)returnObj).booleanValue();
	}

	public long countSearch(java.lang.String keyword, java.lang.Long appId,
		java.lang.String table) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countSearchMethodKey21,
				ClpSerializer.translateInput(keyword),
				ClpSerializer.translateInput(appId),
				ClpSerializer.translateInput(table));

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

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> search(
		java.lang.String keyword, java.lang.Long appId, java.lang.String table,
		int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey22,
				ClpSerializer.translateInput(keyword),
				ClpSerializer.translateInput(appId),
				ClpSerializer.translateInput(table), start, end);

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<java.lang.String> getDSBang() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSBangMethodKey23);

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

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getMaKhacExChMethodKey24,
				ClpSerializer.translateInput(maDNG),
				ClpSerializer.translateInput(tenBang));

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getMaKhacExCh(
		java.lang.String maDNG, java.lang.String tenBang, long maUngDungId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getMaKhacExChMethodKey25,
				ClpSerializer.translateInput(maDNG),
				ClpSerializer.translateInput(tenBang), maUngDungId);

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacCQQL(
		java.lang.String maDNG, java.lang.String tenBang) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDNGFromMaKhacCQQLMethodKey26,
				ClpSerializer.translateInput(maDNG),
				ClpSerializer.translateInput(tenBang));

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacTTHC(
		java.lang.String maDNG, java.lang.String tenBang) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDNGFromMaKhacTTHCMethodKey27,
				ClpSerializer.translateInput(maDNG),
				ClpSerializer.translateInput(tenBang));

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> getDNGFromMaKhacGPLX(
		java.lang.String maDNG, java.lang.String tenBang) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDNGFromMaKhacGPLXMethodKey28,
				ClpSerializer.translateInput(maDNG),
				ClpSerializer.translateInput(tenBang));

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

		return (java.util.List<org.oep.cmon.dao.thamso.model.AnhXa>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addAnhXaMethodKey0;
	private MethodKey _createAnhXaMethodKey1;
	private MethodKey _deleteAnhXaMethodKey2;
	private MethodKey _deleteAnhXaMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchAnhXaMethodKey8;
	private MethodKey _getAnhXaMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getAnhXasMethodKey11;
	private MethodKey _getAnhXasCountMethodKey12;
	private MethodKey _updateAnhXaMethodKey13;
	private MethodKey _updateAnhXaMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getMaByIdMethodKey17;
	private MethodKey _getAnhXaByApp_Table_CodeMethodKey18;
	private MethodKey _synchronizeMethodKey19;
	private MethodKey _deleteMappingMethodKey20;
	private MethodKey _countSearchMethodKey21;
	private MethodKey _searchMethodKey22;
	private MethodKey _getDSBangMethodKey23;
	private MethodKey _getMaKhacExChMethodKey24;
	private MethodKey _getMaKhacExChMethodKey25;
	private MethodKey _getDNGFromMaKhacCQQLMethodKey26;
	private MethodKey _getDNGFromMaKhacTTHCMethodKey27;
	private MethodKey _getDNGFromMaKhacGPLXMethodKey28;
}