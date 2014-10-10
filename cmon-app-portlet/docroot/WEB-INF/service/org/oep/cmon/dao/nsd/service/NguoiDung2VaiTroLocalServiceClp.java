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

package org.oep.cmon.dao.nsd.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Liemnn
 */
public class NguoiDung2VaiTroLocalServiceClp
	implements NguoiDung2VaiTroLocalService {
	public NguoiDung2VaiTroLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addNguoiDung2VaiTroMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addNguoiDung2VaiTro",
				org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro.class);

		_createNguoiDung2VaiTroMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createNguoiDung2VaiTro", long.class);

		_deleteNguoiDung2VaiTroMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteNguoiDung2VaiTro", long.class);

		_deleteNguoiDung2VaiTroMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteNguoiDung2VaiTro",
				org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro.class);

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

		_fetchNguoiDung2VaiTroMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchNguoiDung2VaiTro", long.class);

		_getNguoiDung2VaiTroMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getNguoiDung2VaiTro", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getNguoiDung2VaiTrosMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getNguoiDung2VaiTros", int.class, int.class);

		_getNguoiDung2VaiTrosCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getNguoiDung2VaiTrosCount");

		_updateNguoiDung2VaiTroMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateNguoiDung2VaiTro",
				org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro.class);

		_updateNguoiDung2VaiTroMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateNguoiDung2VaiTro",
				org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByVaiTroIDMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByVaiTroID", long.class, int.class);

		_findByVaiTroIDAndTaiKhoanNguoiDungIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByVaiTroIDAndTaiKhoanNguoiDungId", long.class, long.class,
				int.class);

		_findByTaiKhoanNguoiDungIDMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTaiKhoanNguoiDungID", long.class, int.class);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro addNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addNguoiDung2VaiTroMethodKey0,
				ClpSerializer.translateInput(nguoiDung2VaiTro));

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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro createNguoiDung2VaiTro(
		long id) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createNguoiDung2VaiTroMethodKey1,
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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteNguoiDung2VaiTro(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteNguoiDung2VaiTroMethodKey2,
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

	public void deleteNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteNguoiDung2VaiTroMethodKey3,
				ClpSerializer.translateInput(nguoiDung2VaiTro));

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

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro fetchNguoiDung2VaiTro(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchNguoiDung2VaiTroMethodKey8,
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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro getNguoiDung2VaiTro(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getNguoiDung2VaiTroMethodKey9,
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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> getNguoiDung2VaiTros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getNguoiDung2VaiTrosMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public int getNguoiDung2VaiTrosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getNguoiDung2VaiTrosCountMethodKey12);

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

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro updateNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateNguoiDung2VaiTroMethodKey13,
				ClpSerializer.translateInput(nguoiDung2VaiTro));

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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro updateNguoiDung2VaiTro(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateNguoiDung2VaiTroMethodKey14,
				ClpSerializer.translateInput(nguoiDung2VaiTro), merge);

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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByVaiTroID(
		long vaiTroId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByVaiTroIDMethodKey17,
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

		return (java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByVaiTroIDAndTaiKhoanNguoiDungId(
		long vaiTroId, long taiKhoanNguoiDungId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByVaiTroIDAndTaiKhoanNguoiDungIdMethodKey18,
				vaiTroId, taiKhoanNguoiDungId, daXoa);

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

		return (org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByTaiKhoanNguoiDungID(
		long taiKhoanNguoiDungId, int daXoa) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTaiKhoanNguoiDungIDMethodKey19,
				taiKhoanNguoiDungId, daXoa);

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

		return (java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addNguoiDung2VaiTroMethodKey0;
	private MethodKey _createNguoiDung2VaiTroMethodKey1;
	private MethodKey _deleteNguoiDung2VaiTroMethodKey2;
	private MethodKey _deleteNguoiDung2VaiTroMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchNguoiDung2VaiTroMethodKey8;
	private MethodKey _getNguoiDung2VaiTroMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getNguoiDung2VaiTrosMethodKey11;
	private MethodKey _getNguoiDung2VaiTrosCountMethodKey12;
	private MethodKey _updateNguoiDung2VaiTroMethodKey13;
	private MethodKey _updateNguoiDung2VaiTroMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByVaiTroIDMethodKey17;
	private MethodKey _findByVaiTroIDAndTaiKhoanNguoiDungIdMethodKey18;
	private MethodKey _findByTaiKhoanNguoiDungIDMethodKey19;
}