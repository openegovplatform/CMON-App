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

package org.oep.cmon.dao.qlhc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LIEMNN
 */
public class ChucVu2VaiTroLocalServiceClp implements ChucVu2VaiTroLocalService {
	public ChucVu2VaiTroLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addChucVu2VaiTroMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addChucVu2VaiTro",
				org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro.class);

		_createChucVu2VaiTroMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createChucVu2VaiTro", long.class);

		_deleteChucVu2VaiTroMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteChucVu2VaiTro", long.class);

		_deleteChucVu2VaiTroMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteChucVu2VaiTro",
				org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro.class);

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

		_fetchChucVu2VaiTroMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchChucVu2VaiTro", long.class);

		_getChucVu2VaiTroMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getChucVu2VaiTro", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getChucVu2VaiTrosMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getChucVu2VaiTros", int.class, int.class);

		_getChucVu2VaiTrosCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getChucVu2VaiTrosCount");

		_updateChucVu2VaiTroMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateChucVu2VaiTro",
				org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro.class);

		_updateChucVu2VaiTroMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateChucVu2VaiTro",
				org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByIdVaiTroMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdVaiTro", long.class);

		_findByIdCoQuanQuanLyMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdCoQuanQuanLy", long.class);

		_findByIdChucVuMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdChucVu", long.class);

		_findByIdVaiTroAndDaXoaMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdVaiTroAndDaXoa", long.class, int.class);

		_deleteByChucVuIDMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteByChucVuID", long.class);

		_deleteByVaiTroIDMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteByVaiTroID", long.class);

		_findChucVu2VaiTroMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findChucVu2VaiTro", long.class, long.class, long.class);

		_findByIdCoQuanQuanLyAndDaXoaMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdCoQuanQuanLyAndDaXoa", long.class, int.class);

		_findByIdChucVuAndDaXoaMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdChucVuAndDaXoa", long.class, int.class);

		_findTrangThaiMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTrangThai", int.class);

		_findByIdChucVuAndIdCoQuanQuanLyMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByIdChucVuAndIdCoQuanQuanLy", long.class, long.class,
				int.class);
	}

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro addChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addChucVu2VaiTroMethodKey0,
				ClpSerializer.translateInput(chucVu2VaiTro));

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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro createChucVu2VaiTro(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createChucVu2VaiTroMethodKey1,
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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteChucVu2VaiTroMethodKey2,
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

	public void deleteChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteChucVu2VaiTroMethodKey3,
				ClpSerializer.translateInput(chucVu2VaiTro));

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

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchChucVu2VaiTroMethodKey8,
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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro getChucVu2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getChucVu2VaiTroMethodKey9,
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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> getChucVu2VaiTros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getChucVu2VaiTrosMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public int getChucVu2VaiTrosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getChucVu2VaiTrosCountMethodKey12);

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

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateChucVu2VaiTroMethodKey13,
				ClpSerializer.translateInput(chucVu2VaiTro));

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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateChucVu2VaiTro(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateChucVu2VaiTroMethodKey14,
				ClpSerializer.translateInput(chucVu2VaiTro), merge);

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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdVaiTro(
		long vaiTroId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdVaiTroMethodKey17,
				vaiTroId);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdCoQuanQuanLy(
		long coQuanQuanLyId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdCoQuanQuanLyMethodKey18,
				coQuanQuanLyId);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVu(
		long chucVuId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdChucVuMethodKey19,
				chucVuId);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdVaiTroAndDaXoa(
		long vaiTroId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdVaiTroAndDaXoaMethodKey20,
				vaiTroId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteByChucVuID(long chucVuId) {
		MethodHandler methodHandler = new MethodHandler(_deleteByChucVuIDMethodKey21,
				chucVuId);

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

	public void deleteByVaiTroID(long vaiTroId) {
		MethodHandler methodHandler = new MethodHandler(_deleteByVaiTroIDMethodKey22,
				vaiTroId);

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

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findChucVu2VaiTro(
		long vaiTroId, long coQuanQuanLyId, long chucVuId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findChucVu2VaiTroMethodKey23,
				vaiTroId, coQuanQuanLyId, chucVuId);

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

		return (org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdCoQuanQuanLyAndDaXoa(
		long coQuanQuanLyId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdCoQuanQuanLyAndDaXoaMethodKey24,
				coQuanQuanLyId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVuAndDaXoa(
		long chucVuId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdChucVuAndDaXoaMethodKey25,
				chucVuId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findTrangThai(
		int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTrangThaiMethodKey26,
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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByIdChucVuAndIdCoQuanQuanLy(
		long chucVuId, long coQuanQuanLyId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByIdChucVuAndIdCoQuanQuanLyMethodKey27,
				chucVuId, coQuanQuanLyId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addChucVu2VaiTroMethodKey0;
	private MethodKey _createChucVu2VaiTroMethodKey1;
	private MethodKey _deleteChucVu2VaiTroMethodKey2;
	private MethodKey _deleteChucVu2VaiTroMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchChucVu2VaiTroMethodKey8;
	private MethodKey _getChucVu2VaiTroMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getChucVu2VaiTrosMethodKey11;
	private MethodKey _getChucVu2VaiTrosCountMethodKey12;
	private MethodKey _updateChucVu2VaiTroMethodKey13;
	private MethodKey _updateChucVu2VaiTroMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByIdVaiTroMethodKey17;
	private MethodKey _findByIdCoQuanQuanLyMethodKey18;
	private MethodKey _findByIdChucVuMethodKey19;
	private MethodKey _findByIdVaiTroAndDaXoaMethodKey20;
	private MethodKey _deleteByChucVuIDMethodKey21;
	private MethodKey _deleteByVaiTroIDMethodKey22;
	private MethodKey _findChucVu2VaiTroMethodKey23;
	private MethodKey _findByIdCoQuanQuanLyAndDaXoaMethodKey24;
	private MethodKey _findByIdChucVuAndDaXoaMethodKey25;
	private MethodKey _findTrangThaiMethodKey26;
	private MethodKey _findByIdChucVuAndIdCoQuanQuanLyMethodKey27;
}