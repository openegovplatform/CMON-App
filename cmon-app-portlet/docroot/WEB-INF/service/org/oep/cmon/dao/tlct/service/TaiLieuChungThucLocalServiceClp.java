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

package org.oep.cmon.dao.tlct.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Liemnn
 */
public class TaiLieuChungThucLocalServiceClp
	implements TaiLieuChungThucLocalService {
	public TaiLieuChungThucLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addTaiLieuChungThucMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addTaiLieuChungThuc",
				org.oep.cmon.dao.tlct.model.TaiLieuChungThuc.class);

		_createTaiLieuChungThucMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createTaiLieuChungThuc", long.class);

		_deleteTaiLieuChungThucMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTaiLieuChungThuc", long.class);

		_deleteTaiLieuChungThucMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteTaiLieuChungThuc",
				org.oep.cmon.dao.tlct.model.TaiLieuChungThuc.class);

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

		_fetchTaiLieuChungThucMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchTaiLieuChungThuc", long.class);

		_getTaiLieuChungThucMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiLieuChungThuc", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getTaiLieuChungThucsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiLieuChungThucs", int.class, int.class);

		_getTaiLieuChungThucsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTaiLieuChungThucsCount");

		_updateTaiLieuChungThucMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTaiLieuChungThuc",
				org.oep.cmon.dao.tlct.model.TaiLieuChungThuc.class);

		_updateTaiLieuChungThucMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateTaiLieuChungThuc",
				org.oep.cmon.dao.tlct.model.TaiLieuChungThuc.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_isUsedMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"isUsed", java.lang.Long.class);

		_deleteMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"delete", java.lang.Long.class);

		_addMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"add", org.oep.cmon.dao.tlct.model.TaiLieuChungThuc.class);

		_findByDanhMucGiayToMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByDanhMucGiayTo", java.lang.Long.class);

		_findByPhienBanMoiNhatMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByPhienBanMoiNhat", java.lang.Long.class,
				java.lang.Long.class);

		_findByPhienBanMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByPhienBan", java.lang.Long.class, int.class,
				java.lang.Long.class);

		_findByHoSoTTHCCongIdAndTenMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHoSoTTHCCongIdAndTen", java.lang.Long.class,
				java.lang.String.class);

		_getCurrentVersionMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCurrentVersion", java.lang.Long.class);

		_getCurrentVersionMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCurrentVersion", java.lang.Long.class, java.lang.Long.class);

		_getTheoPhienBanMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getTheoPhienBan", java.lang.Long.class, int.class,
				java.lang.Long.class);

		_getHoSoIdMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getHoSoId", java.lang.Long.class);

		_findByNoiLuuTruIdMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByNoiLuuTruId", long.class);

		_findByHosotthcCongIdAndLoaiMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHosotthcCongIdAndLoai", long.class, int.class);

		_findByHosotthcCongIdAndTenMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByHosotthcCongIdAndTen", long.class, java.lang.String.class);

		_getMaxVersionMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"getMaxVersion", java.lang.Long.class, java.lang.Long.class);

		_searchCongDanId2DanhMucGiayToMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchCongDanId2DanhMucGiayTo", java.lang.String.class,
				java.lang.Long.class, java.lang.Long.class, int.class, int.class);

		_findTaiLieuXuLyByHoSoAndLoaiMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"findTaiLieuXuLyByHoSoAndLoai", long.class, int.class);

		_countCongDanId2DanhMucGiayToMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"countCongDanId2DanhMucGiayTo", java.lang.String.class,
				java.lang.Long.class, java.lang.Long.class);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc addTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addTaiLieuChungThucMethodKey0,
				ClpSerializer.translateInput(taiLieuChungThuc));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc createTaiLieuChungThuc(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createTaiLieuChungThucMethodKey1,
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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteTaiLieuChungThuc(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTaiLieuChungThucMethodKey2,
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

	public void deleteTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteTaiLieuChungThucMethodKey3,
				ClpSerializer.translateInput(taiLieuChungThuc));

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

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc fetchTaiLieuChungThuc(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchTaiLieuChungThucMethodKey8,
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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getTaiLieuChungThuc(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiLieuChungThucMethodKey9,
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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> getTaiLieuChungThucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiLieuChungThucsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public int getTaiLieuChungThucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTaiLieuChungThucsCountMethodKey12);

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

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc updateTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTaiLieuChungThucMethodKey13,
				ClpSerializer.translateInput(taiLieuChungThuc));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc updateTaiLieuChungThuc(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateTaiLieuChungThucMethodKey14,
				ClpSerializer.translateInput(taiLieuChungThuc), merge);

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
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

	public boolean isUsed(java.lang.Long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_isUsedMethodKey17,
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

		return ((Boolean)returnObj).booleanValue();
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc delete(
		java.lang.Long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_deleteMethodKey18,
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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc add(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc model) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addMethodKey19,
				ClpSerializer.translateInput(model));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByDanhMucGiayTo(
		java.lang.Long danhmucGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByDanhMucGiayToMethodKey20,
				ClpSerializer.translateInput(danhmucGiayToId));

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByPhienBanMoiNhat(
		java.lang.Long danhmucGiayToId, java.lang.Long chuSohuuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByPhienBanMoiNhatMethodKey21,
				ClpSerializer.translateInput(danhmucGiayToId),
				ClpSerializer.translateInput(chuSohuuId));

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByPhienBan(
		java.lang.Long danhmucGiayToId, int phienBan,
		java.lang.Long nguoiUpLoadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByPhienBanMethodKey22,
				ClpSerializer.translateInput(danhmucGiayToId), phienBan,
				ClpSerializer.translateInput(nguoiUpLoadId));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHoSoTTHCCongIdAndTen(
		java.lang.Long hoSoTTHCCId, java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHoSoTTHCCongIdAndTenMethodKey23,
				ClpSerializer.translateInput(hoSoTTHCCId),
				ClpSerializer.translateInput(ten));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getCurrentVersion(
		java.lang.Long danhmucGiayToId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCurrentVersionMethodKey24,
				ClpSerializer.translateInput(danhmucGiayToId));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getCurrentVersion(
		java.lang.Long danhMucGiayToId, java.lang.Long userId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCurrentVersionMethodKey25,
				ClpSerializer.translateInput(danhMucGiayToId),
				ClpSerializer.translateInput(userId));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc getTheoPhienBan(
		java.lang.Long danhMucGiayToId, int phienban, java.lang.Long userId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getTheoPhienBanMethodKey26,
				ClpSerializer.translateInput(danhMucGiayToId), phienban,
				ClpSerializer.translateInput(userId));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> getHoSoId(
		java.lang.Long hosoId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getHoSoIdMethodKey27,
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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByNoiLuuTruId(
		long noiLuuTruId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByNoiLuuTruIdMethodKey28,
				noiLuuTruId);

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		long hoSoTTHCCId, int loai) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHosotthcCongIdAndLoaiMethodKey29,
				hoSoTTHCCId, loai);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHosotthcCongIdAndTen(
		long hosotthcCongId, java.lang.String ten) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByHosotthcCongIdAndTenMethodKey30,
				hosotthcCongId, ClpSerializer.translateInput(ten));

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

		return (org.oep.cmon.dao.tlct.model.TaiLieuChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public int getMaxVersion(java.lang.Long userId, java.lang.Long giayToId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getMaxVersionMethodKey31,
				ClpSerializer.translateInput(userId),
				ClpSerializer.translateInput(giayToId));

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

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> searchCongDanId2DanhMucGiayTo(
		java.lang.String group, java.lang.Long congDanId,
		java.lang.Long doiTuongId, int start, int end) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchCongDanId2DanhMucGiayToMethodKey32,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(congDanId),
				ClpSerializer.translateInput(doiTuongId), start, end);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findTaiLieuXuLyByHoSoAndLoai(
		long idHoSo, int loai) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findTaiLieuXuLyByHoSoAndLoaiMethodKey33,
				idHoSo, loai);

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

		return (java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public long countCongDanId2DanhMucGiayTo(java.lang.String group,
		java.lang.Long congDanId, java.lang.Long doiTuongId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countCongDanId2DanhMucGiayToMethodKey34,
				ClpSerializer.translateInput(group),
				ClpSerializer.translateInput(congDanId),
				ClpSerializer.translateInput(doiTuongId));

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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addTaiLieuChungThucMethodKey0;
	private MethodKey _createTaiLieuChungThucMethodKey1;
	private MethodKey _deleteTaiLieuChungThucMethodKey2;
	private MethodKey _deleteTaiLieuChungThucMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchTaiLieuChungThucMethodKey8;
	private MethodKey _getTaiLieuChungThucMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getTaiLieuChungThucsMethodKey11;
	private MethodKey _getTaiLieuChungThucsCountMethodKey12;
	private MethodKey _updateTaiLieuChungThucMethodKey13;
	private MethodKey _updateTaiLieuChungThucMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _isUsedMethodKey17;
	private MethodKey _deleteMethodKey18;
	private MethodKey _addMethodKey19;
	private MethodKey _findByDanhMucGiayToMethodKey20;
	private MethodKey _findByPhienBanMoiNhatMethodKey21;
	private MethodKey _findByPhienBanMethodKey22;
	private MethodKey _findByHoSoTTHCCongIdAndTenMethodKey23;
	private MethodKey _getCurrentVersionMethodKey24;
	private MethodKey _getCurrentVersionMethodKey25;
	private MethodKey _getTheoPhienBanMethodKey26;
	private MethodKey _getHoSoIdMethodKey27;
	private MethodKey _findByNoiLuuTruIdMethodKey28;
	private MethodKey _findByHosotthcCongIdAndLoaiMethodKey29;
	private MethodKey _findByHosotthcCongIdAndTenMethodKey30;
	private MethodKey _getMaxVersionMethodKey31;
	private MethodKey _searchCongDanId2DanhMucGiayToMethodKey32;
	private MethodKey _findTaiLieuXuLyByHoSoAndLoaiMethodKey33;
	private MethodKey _countCongDanId2DanhMucGiayToMethodKey34;
}