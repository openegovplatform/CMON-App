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

package org.oep.cmon.dao.dvc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author liemnn
 */
public class ThuTucHanhChinhLocalServiceClp
	implements ThuTucHanhChinhLocalService {
	public ThuTucHanhChinhLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addThuTucHanhChinhMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThuTucHanhChinh",
				org.oep.cmon.dao.dvc.model.ThuTucHanhChinh.class);

		_createThuTucHanhChinhMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createThuTucHanhChinh", long.class);

		_deleteThuTucHanhChinhMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThuTucHanhChinh", long.class);

		_deleteThuTucHanhChinhMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThuTucHanhChinh",
				org.oep.cmon.dao.dvc.model.ThuTucHanhChinh.class);

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

		_fetchThuTucHanhChinhMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchThuTucHanhChinh", long.class);

		_getThuTucHanhChinhMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThuTucHanhChinh", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getThuTucHanhChinhsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThuTucHanhChinhs", int.class, int.class);

		_getThuTucHanhChinhsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThuTucHanhChinhsCount");

		_updateThuTucHanhChinhMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThuTucHanhChinh",
				org.oep.cmon.dao.dvc.model.ThuTucHanhChinh.class);

		_updateThuTucHanhChinhMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThuTucHanhChinh",
				org.oep.cmon.dao.dvc.model.ThuTucHanhChinh.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getDSThongTinThuTucByUngDungMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSThongTinThuTucByUngDung", long.class);

		_countByThuTucLienThongIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByThuTucLienThongId", long.class);

		_fetchThongTinThuTuc2CoQuanMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchThongTinThuTuc2CoQuan", long.class, long.class);

		_getDSThongTinThuTuc2CanBoMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSThongTinThuTuc2CanBo",
				org.oep.cmon.dao.cc.model.CongChuc.class);

		_getDSThongTinThuTucLienThongNoiGui2CanBoMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSThongTinThuTucLienThongNoiGui2CanBo",
				org.oep.cmon.dao.cc.model.CongChuc.class);

		_getDSThongTinThuTucLienThongNoiNhan2CanBoMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSThongTinThuTucLienThongNoiNhan2CanBo",
				org.oep.cmon.dao.cc.model.CongChuc.class);

		_countByCQQLMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByCQQL", long.class);

		_getListTTHCByCQQLMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getListTTHCByCQQL", long.class);

		_getDSThuTucHanhChinhMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSThuTucHanhChinh", java.lang.Long.class, int.class);

		_getThuTucHanhChinhBoiMaMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThuTucHanhChinhBoiMa", java.lang.String.class);

		_findAllMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"findAll");

		_findByTrangThaiMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTrangThai", int.class);

		_getListTTHCByCQQLAndMaMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getListTTHCByCQQLAndMa", long.class, java.lang.String.class);

		_searchByUngDungOrNhomMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByUngDungOrNhom", java.lang.Long.class,
				java.lang.Long.class, int.class, int.class);

		_countByUngDungOrNhomMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByUngDungOrNhom", java.lang.Long.class,
				java.lang.Long.class);

		_searchByTTHCIdOrGDIdMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByTTHCIdOrGDId", java.lang.Long.class,
				java.lang.Long.class, java.lang.Integer.class, int.class,
				int.class);

		_countByTTHCIdOrGDIdMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTTHCIdOrGDId", java.lang.Long.class,
				java.lang.Long.class, java.lang.Integer.class);

		_searchByTTHC2HDBMMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchByTTHC2HDBM", java.lang.Long.class,
				java.lang.Long.class, java.lang.Integer.class, int.class,
				int.class);

		_countByTTHC2HDBMMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTTHC2HDBM", java.lang.Long.class, java.lang.Long.class,
				java.lang.Integer.class);

		_getTenCQQLMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTenCQQL", long.class, int.class, int.class);

		_getTenDTSDMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTenDTSD", long.class, int.class, int.class);

		_getTenDMGTMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTenDMGT", long.class, int.class, int.class);
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh addThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThuTucHanhChinhMethodKey0,
				ClpSerializer.translateInput(thuTucHanhChinh));

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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh createThuTucHanhChinh(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createThuTucHanhChinhMethodKey1,
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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteThuTucHanhChinh(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThuTucHanhChinhMethodKey2,
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

	public void deleteThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThuTucHanhChinhMethodKey3,
				ClpSerializer.translateInput(thuTucHanhChinh));

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

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchThuTucHanhChinh(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchThuTucHanhChinhMethodKey8,
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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinh(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThuTucHanhChinhMethodKey9,
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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getThuTucHanhChinhs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThuTucHanhChinhsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public int getThuTucHanhChinhsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThuTucHanhChinhsCountMethodKey12);

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

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThuTucHanhChinhMethodKey13,
				ClpSerializer.translateInput(thuTucHanhChinh));

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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateThuTucHanhChinh(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThuTucHanhChinhMethodKey14,
				ClpSerializer.translateInput(thuTucHanhChinh), merge);

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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucByUngDung(
		long ungDungId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSThongTinThuTucByUngDungMethodKey17,
				ungDungId);

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

		return (java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByThuTucLienThongId(long thuTucLienThongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByThuTucLienThongIdMethodKey18,
				thuTucLienThongId);

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

	public org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan fetchThongTinThuTuc2CoQuan(
		long thuTucId, long coQuanId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchThongTinThuTuc2CoQuanMethodKey19,
				thuTucId, coQuanId);

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

		return (org.oep.cmon.dao.beans.thongtinthutuc2coquan.ThongTinThuTuc2CoQuan)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTuc2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSThongTinThuTuc2CanBoMethodKey20,
				ClpSerializer.translateInput(canBo));

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

		return (java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiGui2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSThongTinThuTucLienThongNoiGui2CanBoMethodKey21,
				ClpSerializer.translateInput(canBo));

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

		return (java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc> getDSThongTinThuTucLienThongNoiNhan2CanBo(
		org.oep.cmon.dao.cc.model.CongChuc canBo) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSThongTinThuTucLienThongNoiNhan2CanBoMethodKey22,
				ClpSerializer.translateInput(canBo));

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

		return (java.util.List<org.oep.cmon.dao.beans.thongtinthutuc.ThongTinThuTuc>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByCQQL(long coQuanQuanLyId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByCQQLMethodKey23,
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

		return ((Long)returnObj).longValue();
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQL(
		long coQuanQuanLyId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getListTTHCByCQQLMethodKey24,
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getDSThuTucHanhChinh(
		java.lang.Long nhomId, int status) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSThuTucHanhChinhMethodKey25,
				ClpSerializer.translateInput(nhomId), status);

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh getThuTucHanhChinhBoiMa(
		java.lang.String code) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThuTucHanhChinhBoiMaMethodKey26,
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

		return (org.oep.cmon.dao.dvc.model.ThuTucHanhChinh)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findAllMethodKey27);

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTrangThaiMethodKey28,
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> getListTTHCByCQQLAndMa(
		long coQuanQuanLyId, java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getListTTHCByCQQLAndMaMethodKey29,
				coQuanQuanLyId, ClpSerializer.translateInput(ma));

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> searchByUngDungOrNhom(
		java.lang.Long ungDungId, java.lang.Long nhomId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByUngDungOrNhomMethodKey30,
				ClpSerializer.translateInput(ungDungId),
				ClpSerializer.translateInput(nhomId), start, end);

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByUngDungOrNhom(java.lang.Long ungDungId,
		java.lang.Long nhomId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByUngDungOrNhomMethodKey31,
				ClpSerializer.translateInput(ungDungId),
				ClpSerializer.translateInput(nhomId));

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

	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> searchByTTHCIdOrGDId(
		java.lang.Long tthcid, java.lang.Long dgId, java.lang.Integer daXoa,
		int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByTTHCIdOrGDIdMethodKey32,
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByTTHCIdOrGDId(java.lang.Long tthcid, java.lang.Long dgId,
		java.lang.Integer daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTTHCIdOrGDIdMethodKey33,
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

	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> searchByTTHC2HDBM(
		java.lang.Long tthcid, java.lang.Long loaiTL, java.lang.Integer daXoa,
		int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchByTTHC2HDBMMethodKey34,
				ClpSerializer.translateInput(tthcid),
				ClpSerializer.translateInput(loaiTL),
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

		return (java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan>)ClpSerializer.translateOutput(returnObj);
	}

	public long countByTTHC2HDBM(java.lang.Long tthcid, java.lang.Long loaiTL,
		java.lang.Integer daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTTHC2HDBMMethodKey35,
				ClpSerializer.translateInput(tthcid),
				ClpSerializer.translateInput(loaiTL),
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

	public java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy> getTenCQQL(
		long thuTucHanhChinhId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTenCQQLMethodKey36,
				thuTucHanhChinhId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> getTenDTSD(
		long thuTucHanhChinhId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTenDTSDMethodKey37,
				thuTucHanhChinhId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> getTenDMGT(
		long thuTucHanhChinhId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTenDMGTMethodKey38,
				thuTucHanhChinhId, start, end);

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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addThuTucHanhChinhMethodKey0;
	private MethodKey _createThuTucHanhChinhMethodKey1;
	private MethodKey _deleteThuTucHanhChinhMethodKey2;
	private MethodKey _deleteThuTucHanhChinhMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchThuTucHanhChinhMethodKey8;
	private MethodKey _getThuTucHanhChinhMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getThuTucHanhChinhsMethodKey11;
	private MethodKey _getThuTucHanhChinhsCountMethodKey12;
	private MethodKey _updateThuTucHanhChinhMethodKey13;
	private MethodKey _updateThuTucHanhChinhMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getDSThongTinThuTucByUngDungMethodKey17;
	private MethodKey _countByThuTucLienThongIdMethodKey18;
	private MethodKey _fetchThongTinThuTuc2CoQuanMethodKey19;
	private MethodKey _getDSThongTinThuTuc2CanBoMethodKey20;
	private MethodKey _getDSThongTinThuTucLienThongNoiGui2CanBoMethodKey21;
	private MethodKey _getDSThongTinThuTucLienThongNoiNhan2CanBoMethodKey22;
	private MethodKey _countByCQQLMethodKey23;
	private MethodKey _getListTTHCByCQQLMethodKey24;
	private MethodKey _getDSThuTucHanhChinhMethodKey25;
	private MethodKey _getThuTucHanhChinhBoiMaMethodKey26;
	private MethodKey _findAllMethodKey27;
	private MethodKey _findByTrangThaiMethodKey28;
	private MethodKey _getListTTHCByCQQLAndMaMethodKey29;
	private MethodKey _searchByUngDungOrNhomMethodKey30;
	private MethodKey _countByUngDungOrNhomMethodKey31;
	private MethodKey _searchByTTHCIdOrGDIdMethodKey32;
	private MethodKey _countByTTHCIdOrGDIdMethodKey33;
	private MethodKey _searchByTTHC2HDBMMethodKey34;
	private MethodKey _countByTTHC2HDBMMethodKey35;
	private MethodKey _getTenCQQLMethodKey36;
	private MethodKey _getTenDTSDMethodKey37;
	private MethodKey _getTenDMGTMethodKey38;
}