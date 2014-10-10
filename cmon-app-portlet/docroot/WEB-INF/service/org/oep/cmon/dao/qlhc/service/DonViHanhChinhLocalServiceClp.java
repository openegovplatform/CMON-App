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
public class DonViHanhChinhLocalServiceClp implements DonViHanhChinhLocalService {
	public DonViHanhChinhLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addDonViHanhChinhMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addDonViHanhChinh",
				org.oep.cmon.dao.qlhc.model.DonViHanhChinh.class);

		_createDonViHanhChinhMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createDonViHanhChinh", long.class);

		_deleteDonViHanhChinhMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDonViHanhChinh", long.class);

		_deleteDonViHanhChinhMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteDonViHanhChinh",
				org.oep.cmon.dao.qlhc.model.DonViHanhChinh.class);

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

		_fetchDonViHanhChinhMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchDonViHanhChinh", long.class);

		_getDonViHanhChinhMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDonViHanhChinh", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getDonViHanhChinhsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDonViHanhChinhs", int.class, int.class);

		_getDonViHanhChinhsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDonViHanhChinhsCount");

		_updateDonViHanhChinhMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDonViHanhChinh",
				org.oep.cmon.dao.qlhc.model.DonViHanhChinh.class);

		_updateDonViHanhChinhMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateDonViHanhChinh",
				org.oep.cmon.dao.qlhc.model.DonViHanhChinh.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByChaIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByChaId", long.class, int.class);

		_findByQuocGiaIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByQuocGiaId", long.class, long.class, int.class);

		_findByDaXoaMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByDaXoa", int.class);

		_findByMaDVHCMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaDVHC", java.lang.String.class);

		_findByTenDVHCMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTenDVHC", java.lang.String.class);

		_getDanhSachTinhThanhMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDanhSachTinhThanh");

		_getDSDonViHanhChinhTheoCapIdMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSDonViHanhChinhTheoCapId", java.lang.Long.class, int.class);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh addDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addDonViHanhChinhMethodKey0,
				ClpSerializer.translateInput(donViHanhChinh));

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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh createDonViHanhChinh(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createDonViHanhChinhMethodKey1,
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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteDonViHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDonViHanhChinhMethodKey2,
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

	public void deleteDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteDonViHanhChinhMethodKey3,
				ClpSerializer.translateInput(donViHanhChinh));

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

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchDonViHanhChinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchDonViHanhChinhMethodKey8,
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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh getDonViHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDonViHanhChinhMethodKey9,
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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDonViHanhChinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDonViHanhChinhsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public int getDonViHanhChinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDonViHanhChinhsCountMethodKey12);

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

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDonViHanhChinhMethodKey13,
				ClpSerializer.translateInput(donViHanhChinh));

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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateDonViHanhChinh(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateDonViHanhChinhMethodKey14,
				ClpSerializer.translateInput(donViHanhChinh), merge);

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

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		long chaId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByChaIdMethodKey17,
				chaId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByQuocGiaIdMethodKey18,
				quocGiaId, capDonViHanhChinhId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByDaXoa(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByDaXoaMethodKey19,
				daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaDVHCMethodKey20,
				ClpSerializer.translateInput(ma));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException) {
				throw (org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTenDVHCMethodKey21,
				ClpSerializer.translateInput(ten));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException) {
				throw (org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.qlhc.model.DonViHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDanhSachTinhThanh() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDanhSachTinhThanhMethodKey22);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> getDSDonViHanhChinhTheoCapId(
		java.lang.Long capId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSDonViHanhChinhTheoCapIdMethodKey23,
				ClpSerializer.translateInput(capId), daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addDonViHanhChinhMethodKey0;
	private MethodKey _createDonViHanhChinhMethodKey1;
	private MethodKey _deleteDonViHanhChinhMethodKey2;
	private MethodKey _deleteDonViHanhChinhMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchDonViHanhChinhMethodKey8;
	private MethodKey _getDonViHanhChinhMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getDonViHanhChinhsMethodKey11;
	private MethodKey _getDonViHanhChinhsCountMethodKey12;
	private MethodKey _updateDonViHanhChinhMethodKey13;
	private MethodKey _updateDonViHanhChinhMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByChaIdMethodKey17;
	private MethodKey _findByQuocGiaIdMethodKey18;
	private MethodKey _findByDaXoaMethodKey19;
	private MethodKey _findByMaDVHCMethodKey20;
	private MethodKey _findByTenDVHCMethodKey21;
	private MethodKey _getDanhSachTinhThanhMethodKey22;
	private MethodKey _getDSDonViHanhChinhTheoCapIdMethodKey23;
}