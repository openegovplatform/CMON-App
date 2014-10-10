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

package org.oep.cmon.dao.cd.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LIEMNN
 */
public class CongDanLocalServiceClp implements CongDanLocalService {
	public CongDanLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addCongDanMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCongDan", org.oep.cmon.dao.cd.model.CongDan.class);

		_createCongDanMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createCongDan", long.class);

		_deleteCongDanMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCongDan", long.class);

		_deleteCongDanMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCongDan", org.oep.cmon.dao.cd.model.CongDan.class);

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

		_fetchCongDanMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchCongDan", long.class);

		_getCongDanMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCongDan", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getCongDansMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCongDans", int.class, int.class);

		_getCongDansCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCongDansCount");

		_updateCongDanMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCongDan", org.oep.cmon.dao.cd.model.CongDan.class);

		_updateCongDanMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCongDan", org.oep.cmon.dao.cd.model.CongDan.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getCongDanByLiferayUserIdMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCongDanByLiferayUserId", java.lang.Long.class);

		_searchMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", javax.portlet.PortletRequest.class);

		_findByMaMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMa", java.lang.String.class);

		_findByTaiKhoanNguoiDungIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTaiKhoanNguoiDungId", long.class);

		_findByCMNDMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByCMND", java.lang.String.class);

		_findByEmailMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByEmail", java.lang.String.class);

		_findBySoCmndMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBySoCmnd", java.lang.String.class);

		_saveCongDanMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"saveCongDan", org.oep.cmon.dao.cd.model.CongDan.class);

		_findByEmailAndCMNDMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByEmailAndCMND", java.lang.String.class,
				java.lang.String.class);

		_findByNgaySinhAndCMNDMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByNgaySinhAndCMND", java.sql.Date.class,
				java.lang.String.class);

		_findByNgaySinhAndSoCMNDMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByNgaySinhAndSoCMND", java.util.Date.class,
				java.lang.String.class);

		_findByNgaySinhAndTinhThuongTruIdMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByNgaySinhAndTinhThuongTruId", java.util.Date.class,
				long.class);
	}

	public org.oep.cmon.dao.cd.model.CongDan addCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCongDanMethodKey0,
				ClpSerializer.translateInput(congDan));

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan createCongDan(long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createCongDanMethodKey1,
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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCongDanMethodKey2,
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

	public void deleteCongDan(org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCongDanMethodKey3,
				ClpSerializer.translateInput(congDan));

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

	public org.oep.cmon.dao.cd.model.CongDan fetchCongDan(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchCongDanMethodKey8,
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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan getCongDan(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCongDanMethodKey9,
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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> getCongDans(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCongDansMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.cd.model.CongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCongDansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCongDansCountMethodKey12);

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

	public org.oep.cmon.dao.cd.model.CongDan updateCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCongDanMethodKey13,
				ClpSerializer.translateInput(congDan));

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan updateCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCongDanMethodKey14,
				ClpSerializer.translateInput(congDan), merge);

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
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

	public org.oep.cmon.dao.cd.model.CongDan getCongDanByLiferayUserId(
		java.lang.Long liferayUserId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCongDanByLiferayUserIdMethodKey17,
				ClpSerializer.translateInput(liferayUserId));

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.beans.congdan.CongDan> search(
		javax.portlet.PortletRequest request) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey18,
				ClpSerializer.translateInput(request));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.egovcore.sqlutil.QueryResult<org.oep.cmon.dao.beans.congdan.CongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByMa(java.lang.String ma) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaMethodKey19,
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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByTaiKhoanNguoiDungId(
		long taiKhoanNguoiDungId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTaiKhoanNguoiDungIdMethodKey20,
				taiKhoanNguoiDungId);

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByCMND(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByCMNDMethodKey21,
				ClpSerializer.translateInput(soCmnd));

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

		return (java.util.List<org.oep.cmon.dao.cd.model.CongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByEmailMethodKey22,
				ClpSerializer.translateInput(email));

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

		return (java.util.List<org.oep.cmon.dao.cd.model.CongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBySoCmndMethodKey23,
				ClpSerializer.translateInput(soCmnd));

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

		return (java.util.List<org.oep.cmon.dao.cd.model.CongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan saveCongDan(
		org.oep.cmon.dao.cd.model.CongDan congDan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_saveCongDanMethodKey24,
				ClpSerializer.translateInput(congDan));

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByEmailAndCMNDMethodKey25,
				ClpSerializer.translateInput(email),
				ClpSerializer.translateInput(soCmnd));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.cd.NoSuchCongDanException) {
				throw (org.oep.cmon.dao.cd.NoSuchCongDanException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndCMND(
		java.sql.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNgaySinhAndCMNDMethodKey26,
				ClpSerializer.translateInput(ngaySinh),
				ClpSerializer.translateInput(soCmnd));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.cd.NoSuchCongDanException) {
				throw (org.oep.cmon.dao.cd.NoSuchCongDanException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndSoCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNgaySinhAndSoCMNDMethodKey27,
				ClpSerializer.translateInput(ngaySinh),
				ClpSerializer.translateInput(soCmnd));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.cd.NoSuchCongDanException) {
				throw (org.oep.cmon.dao.cd.NoSuchCongDanException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndTinhThuongTruId(
		java.util.Date ngaySinh, long tinhThuongTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNgaySinhAndTinhThuongTruIdMethodKey28,
				ClpSerializer.translateInput(ngaySinh), tinhThuongTruId);

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

		return (org.oep.cmon.dao.cd.model.CongDan)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addCongDanMethodKey0;
	private MethodKey _createCongDanMethodKey1;
	private MethodKey _deleteCongDanMethodKey2;
	private MethodKey _deleteCongDanMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchCongDanMethodKey8;
	private MethodKey _getCongDanMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getCongDansMethodKey11;
	private MethodKey _getCongDansCountMethodKey12;
	private MethodKey _updateCongDanMethodKey13;
	private MethodKey _updateCongDanMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getCongDanByLiferayUserIdMethodKey17;
	private MethodKey _searchMethodKey18;
	private MethodKey _findByMaMethodKey19;
	private MethodKey _findByTaiKhoanNguoiDungIdMethodKey20;
	private MethodKey _findByCMNDMethodKey21;
	private MethodKey _findByEmailMethodKey22;
	private MethodKey _findBySoCmndMethodKey23;
	private MethodKey _saveCongDanMethodKey24;
	private MethodKey _findByEmailAndCMNDMethodKey25;
	private MethodKey _findByNgaySinhAndCMNDMethodKey26;
	private MethodKey _findByNgaySinhAndSoCMNDMethodKey27;
	private MethodKey _findByNgaySinhAndTinhThuongTruIdMethodKey28;
}