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

package org.oep.cmon.dao.hosohcc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author LIEMNn
 */
public class FileDinhKemLocalServiceClp implements FileDinhKemLocalService {
	public FileDinhKemLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addFileDinhKemMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addFileDinhKem",
				org.oep.cmon.dao.hosohcc.model.FileDinhKem.class);

		_createFileDinhKemMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createFileDinhKem", long.class);

		_deleteFileDinhKemMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteFileDinhKem", long.class);

		_deleteFileDinhKemMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteFileDinhKem",
				org.oep.cmon.dao.hosohcc.model.FileDinhKem.class);

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

		_fetchFileDinhKemMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchFileDinhKem", long.class);

		_getFileDinhKemMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFileDinhKem", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getFileDinhKemsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFileDinhKems", int.class, int.class);

		_getFileDinhKemsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFileDinhKemsCount");

		_updateFileDinhKemMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateFileDinhKem",
				org.oep.cmon.dao.hosohcc.model.FileDinhKem.class);

		_updateFileDinhKemMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateFileDinhKem",
				org.oep.cmon.dao.hosohcc.model.FileDinhKem.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findFileDinhKemByHoSoTTHCCongIdAndGiaiDoanMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan", long.class,
				int.class);

		_findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTraMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra", long.class,
				int.class);

		_findFileDinhKemByHoSoTTHCCongIdMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHoSoTTHCCongId", long.class);

		_findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId", long.class,
				long.class, long.class);

		_findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoanMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan", long.class);

		_findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnlineMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline", long.class);

		_findByHoSoTTHCCongIdMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongId", long.class);

		_getDSGiayToKhiBoSungHoSoMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSGiayToKhiBoSungHoSo",
				org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong.class);

		_getDSGiayToKhiTiepNhanHoSoMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSGiayToKhiTiepNhanHoSo", long.class);

		_getDSGiayToPhienBanMoiNhatByHoSoMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSGiayToPhienBanMoiNhatByHoSo", long.class);

		_getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoanMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan", long.class,
				int.class);

		_findByHoSoTTHCCongIDMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongID", long.class);

		_getDSGiayToByHoSoAndThuTuc2GiayToMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getDSGiayToByHoSoAndThuTuc2GiayTo", long.class, long.class);

		_findByFindByHoSoTTHCCongIdAndTaiLieuChungThucIdMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId", long.class,
				long.class);

		_findFileUploadByHoSoTTHCCongIdAndGiaiDoanMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileUploadByHoSoTTHCCongIdAndGiaiDoan", long.class,
				int.class);

		_findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoanMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan", long.class,
				int.class);

		_deleteByHoSoThuTucHanhChinhIdMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteByHoSoThuTucHanhChinhId", long.class);

		_getFileTraKetQuaMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFileTraKetQua", java.lang.Long.class);

		_fetchByHoSoTTHCCongIdMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchByHoSoTTHCCongId", long.class);

		_getLoaiFileKhacMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLoaiFileKhac", long.class);

		_findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayTheMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe", long.class,
				java.lang.String.class);

		_findByMaFileDinhKemAndIdDanhSachHoSoSMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByMaFileDinhKemAndIdDanhSachHoSoS", long.class, long.class);

		_findByHoSoTTHCCongIdAndThuTuc2GiayToIdMethodKey39 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongIdAndThuTuc2GiayToId", long.class, long.class);

		_findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToIdMethodKey40 = new MethodKey(_classLoaderProxy.getClassName(),
				"findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId",
				long.class, long.class);

		_findTaiLieuDinhKemTichHopMethodKey41 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTaiLieuDinhKemTichHop", long.class);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem addFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addFileDinhKemMethodKey0,
				ClpSerializer.translateInput(fileDinhKem));

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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem createFileDinhKem(long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createFileDinhKemMethodKey1,
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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteFileDinhKemMethodKey2,
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

	public void deleteFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteFileDinhKemMethodKey3,
				ClpSerializer.translateInput(fileDinhKem));

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

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem fetchFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchFileDinhKemMethodKey8,
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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem getFileDinhKem(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFileDinhKemMethodKey9,
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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getFileDinhKems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFileDinhKemsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public int getFileDinhKemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFileDinhKemsCountMethodKey12);

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

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateFileDinhKemMethodKey13,
				ClpSerializer.translateInput(fileDinhKem));

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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem updateFileDinhKem(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateFileDinhKemMethodKey14,
				ClpSerializer.translateInput(fileDinhKem), merge);

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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHoSoTTHCCongIdAndGiaiDoanMethodKey17,
				hoSoTTHCCongId, giaiDoan);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTra(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTraMethodKey18,
				hoSoTTHCCongId, giaiDoan);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHoSoTTHCCongIdMethodKey19,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTId(
		long hoSoTTHCCongId, long idThuTuc2GiayTo, long idDanhMucGiayTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTIdMethodKey20,
				hoSoTTHCCongId, idThuTuc2GiayTo, idDanhMucGiayTo);

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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoan(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoanMethodKey21,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnline(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnlineMethodKey22,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdMethodKey23,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiBoSungHoSo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSo)
		throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSGiayToKhiBoSungHoSoMethodKey24,
				ClpSerializer.translateInput(hoSo));

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

		return (java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToKhiTiepNhanHoSo(
		long thuTucId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSGiayToKhiTiepNhanHoSoMethodKey25,
				thuTucId);

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

		return (java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSo(
		long hoSoId) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSGiayToPhienBanMoiNhatByHoSoMethodKey26,
				hoSoId);

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

		return (java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo> getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoan(
		long hoSoId, int giaiDoan) throws java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoanMethodKey27,
				hoSoId, giaiDoan);

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

		return (java.util.List<org.oep.cmon.dao.beans.giaytodinhkemhoso.GiayToDinhKemHoSo>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByHoSoTTHCCongID(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIDMethodKey28,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getDSGiayToByHoSoAndThuTuc2GiayTo(
		long hoSoId, long thuTuc2GiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getDSGiayToByHoSoAndThuTuc2GiayToMethodKey29,
				hoSoId, thuTuc2GiayToId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByFindByHoSoTTHCCongIdAndTaiLieuChungThucId(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByFindByHoSoTTHCCongIdAndTaiLieuChungThucIdMethodKey30,
				hoSoTTHCCongId, taiLieuChungThucId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileUploadByHoSoTTHCCongIdAndGiaiDoan(
		long hoSoTTHCCongId, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileUploadByHoSoTTHCCongIdAndGiaiDoanMethodKey31,
				hoSoTTHCCongId, giaiDoan);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoan(
		long thutuchanhchinhid, int giaiDoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoanMethodKey32,
				thutuchanhchinhid, giaiDoan);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteByHoSoThuTucHanhChinhId(long hosotthcCongId) {
		MethodHandler methodHandler = new MethodHandler(_deleteByHoSoThuTucHanhChinhIdMethodKey33,
				hosotthcCongId);

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

	public java.lang.String getFileTraKetQua(java.lang.Long hosoId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFileTraKetQuaMethodKey34,
				ClpSerializer.translateInput(hosoId));

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

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchByHoSoTTHCCongIdMethodKey35,
				hoSoTTHCCongId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> getLoaiFileKhac(
		long idHoSo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLoaiFileKhacMethodKey36,
				idHoSo);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException) {
				throw (org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayThe(
		long hoSoTTHCCongId, java.lang.String maLoaiTaiLieuDuocThayThe) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayTheMethodKey37,
				hoSoTTHCCongId,
				ClpSerializer.translateInput(maLoaiTaiLieuDuocThayThe));

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

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findByMaFileDinhKemAndIdDanhSachHoSoS(
		long hoSoTTHCCongId, long taiLieuChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByMaFileDinhKemAndIdDanhSachHoSoSMethodKey38,
				hoSoTTHCCongId, taiLieuChungThucId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findByHoSoTTHCCongIdAndThuTuc2GiayToId(
		long hoSoTTHCCongId, long thuTuc2GiayToId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdAndThuTuc2GiayToIdMethodKey39,
				hoSoTTHCCongId, thuTuc2GiayToId);

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

		return (org.oep.cmon.dao.hosohcc.model.FileDinhKem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToId(
		long hoSoTTHCCongId, long danhMucGiayToId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToIdMethodKey40,
				hoSoTTHCCongId, danhMucGiayToId);

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

		return (java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List findTaiLieuDinhKemTichHop(long hoSoTTHCCongId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTaiLieuDinhKemTichHopMethodKey41,
				hoSoTTHCCongId);

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

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addFileDinhKemMethodKey0;
	private MethodKey _createFileDinhKemMethodKey1;
	private MethodKey _deleteFileDinhKemMethodKey2;
	private MethodKey _deleteFileDinhKemMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchFileDinhKemMethodKey8;
	private MethodKey _getFileDinhKemMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getFileDinhKemsMethodKey11;
	private MethodKey _getFileDinhKemsCountMethodKey12;
	private MethodKey _updateFileDinhKemMethodKey13;
	private MethodKey _updateFileDinhKemMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findFileDinhKemByHoSoTTHCCongIdAndGiaiDoanMethodKey17;
	private MethodKey _findFileDinhKemByHSTTHCCIdAndGiaiDoanAndDaTraMethodKey18;
	private MethodKey _findFileDinhKemByHoSoTTHCCongIdMethodKey19;
	private MethodKey _findMaxFileDinhKemByHoSoTTHCCongIdAndTT2GTIdMethodKey20;
	private MethodKey _findFileDinhKemByHoSoTTHCCongIdKhongCoGiaiDoanMethodKey21;
	private MethodKey _findFileDinhKemByHoSoTTHCCongIdGiaiDoan1NopOnlineMethodKey22;
	private MethodKey _findByHoSoTTHCCongIdMethodKey23;
	private MethodKey _getDSGiayToKhiBoSungHoSoMethodKey24;
	private MethodKey _getDSGiayToKhiTiepNhanHoSoMethodKey25;
	private MethodKey _getDSGiayToPhienBanMoiNhatByHoSoMethodKey26;
	private MethodKey _getDSGiayToPhienBanMoiNhatByHoSoAndGiaiDoanMethodKey27;
	private MethodKey _findByHoSoTTHCCongIDMethodKey28;
	private MethodKey _getDSGiayToByHoSoAndThuTuc2GiayToMethodKey29;
	private MethodKey _findByFindByHoSoTTHCCongIdAndTaiLieuChungThucIdMethodKey30;
	private MethodKey _findFileUploadByHoSoTTHCCongIdAndGiaiDoanMethodKey31;
	private MethodKey _findDanhMucGiayToByThuTucHanhChinhIdAndGiaiDoanMethodKey32;
	private MethodKey _deleteByHoSoThuTucHanhChinhIdMethodKey33;
	private MethodKey _getFileTraKetQuaMethodKey34;
	private MethodKey _fetchByHoSoTTHCCongIdMethodKey35;
	private MethodKey _getLoaiFileKhacMethodKey36;
	private MethodKey _findByHoSoTTHCCongIdAndMaLoaiTaiLieuDuocThayTheMethodKey37;
	private MethodKey _findByMaFileDinhKemAndIdDanhSachHoSoSMethodKey38;
	private MethodKey _findByHoSoTTHCCongIdAndThuTuc2GiayToIdMethodKey39;
	private MethodKey _findFileDinhKemByHoSoTTHCCongIdAndDanhMucGiayToIdMethodKey40;
	private MethodKey _findTaiLieuDinhKemTichHopMethodKey41;
}