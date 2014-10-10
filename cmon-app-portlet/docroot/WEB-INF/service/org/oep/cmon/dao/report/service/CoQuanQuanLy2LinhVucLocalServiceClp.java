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

package org.oep.cmon.dao.report.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author VIENPN
 */
public class CoQuanQuanLy2LinhVucLocalServiceClp
	implements CoQuanQuanLy2LinhVucLocalService {
	public CoQuanQuanLy2LinhVucLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addCoQuanQuanLy2LinhVucMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCoQuanQuanLy2LinhVuc",
				org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc.class);

		_createCoQuanQuanLy2LinhVucMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createCoQuanQuanLy2LinhVuc", long.class);

		_deleteCoQuanQuanLy2LinhVucMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCoQuanQuanLy2LinhVuc", long.class);

		_deleteCoQuanQuanLy2LinhVucMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCoQuanQuanLy2LinhVuc",
				org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc.class);

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

		_fetchCoQuanQuanLy2LinhVucMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchCoQuanQuanLy2LinhVuc", long.class);

		_getCoQuanQuanLy2LinhVucMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLy2LinhVuc", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getCoQuanQuanLy2LinhVucsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLy2LinhVucs", int.class, int.class);

		_getCoQuanQuanLy2LinhVucsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLy2LinhVucsCount");

		_updateCoQuanQuanLy2LinhVucMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCoQuanQuanLy2LinhVuc",
				org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc.class);

		_updateCoQuanQuanLy2LinhVucMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCoQuanQuanLy2LinhVuc",
				org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getLinhvucByIdDonviMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLinhvucByIdDonvi", java.lang.String.class);

		_getTTHCMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTTHC", java.lang.String.class, java.lang.String.class);
	}

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc addCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCoQuanQuanLy2LinhVucMethodKey0,
				ClpSerializer.translateInput(coQuanQuanLy2LinhVuc));

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc createCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createCoQuanQuanLy2LinhVucMethodKey1,
				NHOMTHUTUCHANHCHINHID);

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCoQuanQuanLy2LinhVuc(long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCoQuanQuanLy2LinhVucMethodKey2,
				NHOMTHUTUCHANHCHINHID);

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

	public void deleteCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCoQuanQuanLy2LinhVucMethodKey3,
				ClpSerializer.translateInput(coQuanQuanLy2LinhVuc));

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

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc fetchCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchCoQuanQuanLy2LinhVucMethodKey8,
				NHOMTHUTUCHANHCHINHID);

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc getCoQuanQuanLy2LinhVuc(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLy2LinhVucMethodKey9,
				NHOMTHUTUCHANHCHINHID);

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> getCoQuanQuanLy2LinhVucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLy2LinhVucsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCoQuanQuanLy2LinhVucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLy2LinhVucsCountMethodKey12);

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

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc updateCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCoQuanQuanLy2LinhVucMethodKey13,
				ClpSerializer.translateInput(coQuanQuanLy2LinhVuc));

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc updateCoQuanQuanLy2LinhVuc(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCoQuanQuanLy2LinhVucMethodKey14,
				ClpSerializer.translateInput(coQuanQuanLy2LinhVuc), merge);

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

		return (org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> getLinhvucByIdDonvi(
		java.lang.String id_donvibaocao) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLinhvucByIdDonviMethodKey17,
				ClpSerializer.translateInput(id_donvibaocao));

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

		return (java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getTTHC(
		java.lang.String nhomtthc_id, java.lang.String donvi_id)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTTHCMethodKey18,
				ClpSerializer.translateInput(nhomtthc_id),
				ClpSerializer.translateInput(donvi_id));

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addCoQuanQuanLy2LinhVucMethodKey0;
	private MethodKey _createCoQuanQuanLy2LinhVucMethodKey1;
	private MethodKey _deleteCoQuanQuanLy2LinhVucMethodKey2;
	private MethodKey _deleteCoQuanQuanLy2LinhVucMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchCoQuanQuanLy2LinhVucMethodKey8;
	private MethodKey _getCoQuanQuanLy2LinhVucMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getCoQuanQuanLy2LinhVucsMethodKey11;
	private MethodKey _getCoQuanQuanLy2LinhVucsCountMethodKey12;
	private MethodKey _updateCoQuanQuanLy2LinhVucMethodKey13;
	private MethodKey _updateCoQuanQuanLy2LinhVucMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getLinhvucByIdDonviMethodKey17;
	private MethodKey _getTTHCMethodKey18;
}