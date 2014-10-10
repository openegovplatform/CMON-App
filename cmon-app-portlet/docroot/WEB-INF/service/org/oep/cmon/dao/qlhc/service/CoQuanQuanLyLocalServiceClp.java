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
public class CoQuanQuanLyLocalServiceClp implements CoQuanQuanLyLocalService {
	public CoQuanQuanLyLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addCoQuanQuanLyMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCoQuanQuanLy",
				org.oep.cmon.dao.qlhc.model.CoQuanQuanLy.class);

		_createCoQuanQuanLyMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createCoQuanQuanLy", long.class);

		_deleteCoQuanQuanLyMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCoQuanQuanLy", long.class);

		_deleteCoQuanQuanLyMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCoQuanQuanLy",
				org.oep.cmon.dao.qlhc.model.CoQuanQuanLy.class);

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

		_fetchCoQuanQuanLyMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchCoQuanQuanLy", long.class);

		_getCoQuanQuanLyMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLy", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getCoQuanQuanLiesMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLies", int.class, int.class);

		_getCoQuanQuanLiesCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCoQuanQuanLiesCount");

		_updateCoQuanQuanLyMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCoQuanQuanLy",
				org.oep.cmon.dao.qlhc.model.CoQuanQuanLy.class);

		_updateCoQuanQuanLyMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCoQuanQuanLy",
				org.oep.cmon.dao.qlhc.model.CoQuanQuanLy.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByMaMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMa", java.lang.String.class);

		_getDSPhongBanNoiBoMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSPhongBanNoiBo", java.lang.Long.class);

		_findByParentIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByParentId", java.lang.Long.class, int.class);

		_findByCapCoQuanQuanLyIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByCapCoQuanQuanLyId", java.lang.Long.class, int.class);

		_getDSCoQuanQuanlyByMaOrTenMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSCoQuanQuanlyByMaOrTen", java.lang.String.class,
				int.class, int.class);

		_countDSCoQuanQuanlyByMaOrTenMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countDSCoQuanQuanlyByMaOrTen", java.lang.String.class);

		_findByAllDonViHanhChinhIdMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByAllDonViHanhChinhId", java.lang.Long.class, int.class,
				int.class);
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy addCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCoQuanQuanLyMethodKey0,
				ClpSerializer.translateInput(coQuanQuanLy));

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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy createCoQuanQuanLy(long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createCoQuanQuanLyMethodKey1,
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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCoQuanQuanLyMethodKey2,
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

	public void deleteCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCoQuanQuanLyMethodKey3,
				ClpSerializer.translateInput(coQuanQuanLy));

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

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy fetchCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchCoQuanQuanLyMethodKey8,
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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy getCoQuanQuanLy(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLyMethodKey9,
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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getCoQuanQuanLies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLiesMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCoQuanQuanLiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCoQuanQuanLiesCountMethodKey12);

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

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCoQuanQuanLyMethodKey13,
				ClpSerializer.translateInput(coQuanQuanLy));

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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateCoQuanQuanLy(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCoQuanQuanLyMethodKey14,
				ClpSerializer.translateInput(coQuanQuanLy), merge);

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

		return (org.oep.cmon.dao.qlhc.model.CoQuanQuanLy)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaMethodKey17,
				ClpSerializer.translateInput(ma));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.qlhc.NoSuchQuocGiaException) {
				throw (org.oep.cmon.dao.qlhc.NoSuchQuocGiaException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSPhongBanNoiBo(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSPhongBanNoiBoMethodKey18,
				ClpSerializer.translateInput(chaId));

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByParentId(
		java.lang.Long chaId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByParentIdMethodKey19,
				ClpSerializer.translateInput(chaId), daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLyId(
		java.lang.Long capCoQuanQuanlyId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByCapCoQuanQuanLyIdMethodKey20,
				ClpSerializer.translateInput(capCoQuanQuanlyId), daXoa);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> getDSCoQuanQuanlyByMaOrTen(
		java.lang.String maOrTen, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSCoQuanQuanlyByMaOrTenMethodKey21,
				ClpSerializer.translateInput(maOrTen), start, end);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public int countDSCoQuanQuanlyByMaOrTen(java.lang.String maOrTen) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countDSCoQuanQuanlyByMaOrTenMethodKey22,
				ClpSerializer.translateInput(maOrTen));

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

	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByAllDonViHanhChinhId(
		java.lang.Long donviHanhChinhId, int typeSelect, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByAllDonViHanhChinhIdMethodKey23,
				ClpSerializer.translateInput(donviHanhChinhId), typeSelect,
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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addCoQuanQuanLyMethodKey0;
	private MethodKey _createCoQuanQuanLyMethodKey1;
	private MethodKey _deleteCoQuanQuanLyMethodKey2;
	private MethodKey _deleteCoQuanQuanLyMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchCoQuanQuanLyMethodKey8;
	private MethodKey _getCoQuanQuanLyMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getCoQuanQuanLiesMethodKey11;
	private MethodKey _getCoQuanQuanLiesCountMethodKey12;
	private MethodKey _updateCoQuanQuanLyMethodKey13;
	private MethodKey _updateCoQuanQuanLyMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByMaMethodKey17;
	private MethodKey _getDSPhongBanNoiBoMethodKey18;
	private MethodKey _findByParentIdMethodKey19;
	private MethodKey _findByCapCoQuanQuanLyIdMethodKey20;
	private MethodKey _getDSCoQuanQuanlyByMaOrTenMethodKey21;
	private MethodKey _countDSCoQuanQuanlyByMaOrTenMethodKey22;
	private MethodKey _findByAllDonViHanhChinhIdMethodKey23;
}