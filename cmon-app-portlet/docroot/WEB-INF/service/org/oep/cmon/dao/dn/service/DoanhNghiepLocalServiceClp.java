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

package org.oep.cmon.dao.dn.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Liemnn
 */
public class DoanhNghiepLocalServiceClp implements DoanhNghiepLocalService {
	public DoanhNghiepLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDoanhNghiepMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDoanhNghiep", org.oep.cmon.dao.dn.model.DoanhNghiep.class);

		_createDoanhNghiepMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDoanhNghiep", long.class);

		_deleteDoanhNghiepMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDoanhNghiep", long.class);

		_deleteDoanhNghiepMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDoanhNghiep", org.oep.cmon.dao.dn.model.DoanhNghiep.class);

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

		_fetchDoanhNghiepMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDoanhNghiep", long.class);

		_getDoanhNghiepMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDoanhNghiep", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getDoanhNghiepsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDoanhNghieps", int.class, int.class);

		_getDoanhNghiepsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDoanhNghiepsCount");

		_updateDoanhNghiepMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDoanhNghiep", org.oep.cmon.dao.dn.model.DoanhNghiep.class);

		_updateDoanhNghiepMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDoanhNghiep",
				org.oep.cmon.dao.dn.model.DoanhNghiep.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByMaDoanhNghiepMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaDoanhNghiep", java.lang.String.class);

		_findByMaSoThueMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaSoThue", java.lang.String.class);

		_findByTenMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTen", java.lang.String.class);

		_findBySoGCNDKKDMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBySoGCNDKKD", java.lang.String.class);

		_getDoanhNghiep2NguoiDaiDienIdMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDoanhNghiep2NguoiDaiDienId", long.class);

		_findByGetNguoiDaiDienDoiTuongMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByGetNguoiDaiDienDoiTuong", long.class, long.class);

		_findByNguoiDaiDienIdMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByNguoiDaiDienId", long.class);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep addDoanhNghiep(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDoanhNghiepMethodKey0,
				ClpSerializer.translateInput(doanhNghiep));

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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep createDoanhNghiep(long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDoanhNghiepMethodKey1,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDoanhNghiepMethodKey2,
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

	public void deleteDoanhNghiep(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDoanhNghiepMethodKey3,
				ClpSerializer.translateInput(doanhNghiep));

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

	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDoanhNghiepMethodKey8,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep getDoanhNghiep(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDoanhNghiepMethodKey9,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> getDoanhNghieps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDoanhNghiepsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDoanhNghiepsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDoanhNghiepsCountMethodKey12);

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

	public org.oep.cmon.dao.dn.model.DoanhNghiep updateDoanhNghiep(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDoanhNghiepMethodKey13,
				ClpSerializer.translateInput(doanhNghiep));

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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep updateDoanhNghiep(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDoanhNghiepMethodKey14,
				ClpSerializer.translateInput(doanhNghiep), merge);

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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
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

	public org.oep.cmon.dao.dn.model.DoanhNghiep findByMaDoanhNghiep(
		java.lang.String ma) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaDoanhNghiepMethodKey17,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep findByMaSoThue(
		java.lang.String ma) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaSoThueMethodKey18,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep findByTen(java.lang.String ten) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTenMethodKey19,
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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep findBySoGCNDKKD(
		java.lang.String soGCNDKKD) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBySoGCNDKKDMethodKey20,
				ClpSerializer.translateInput(soGCNDKKD));

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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> getDoanhNghiep2NguoiDaiDienId(
		long nguoiDaiDienId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDoanhNghiep2NguoiDaiDienIdMethodKey21,
				nguoiDaiDienId);

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

		return (java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		long nguoiDaiDienId, long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByGetNguoiDaiDienDoiTuongMethodKey22,
				nguoiDaiDienId, loaiDoiTuongId);

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

		return (java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep findByNguoiDaiDienId(
		long nguoiDaiDienId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNguoiDaiDienIdMethodKey23,
				nguoiDaiDienId);

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

		return (org.oep.cmon.dao.dn.model.DoanhNghiep)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDoanhNghiepMethodKey0;
	private MethodKey _createDoanhNghiepMethodKey1;
	private MethodKey _deleteDoanhNghiepMethodKey2;
	private MethodKey _deleteDoanhNghiepMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDoanhNghiepMethodKey8;
	private MethodKey _getDoanhNghiepMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDoanhNghiepsMethodKey11;
	private MethodKey _getDoanhNghiepsCountMethodKey12;
	private MethodKey _updateDoanhNghiepMethodKey13;
	private MethodKey _updateDoanhNghiepMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByMaDoanhNghiepMethodKey17;
	private MethodKey _findByMaSoThueMethodKey18;
	private MethodKey _findByTenMethodKey19;
	private MethodKey _findBySoGCNDKKDMethodKey20;
	private MethodKey _getDoanhNghiep2NguoiDaiDienIdMethodKey21;
	private MethodKey _findByGetNguoiDaiDienDoiTuongMethodKey22;
	private MethodKey _findByNguoiDaiDienIdMethodKey23;
}