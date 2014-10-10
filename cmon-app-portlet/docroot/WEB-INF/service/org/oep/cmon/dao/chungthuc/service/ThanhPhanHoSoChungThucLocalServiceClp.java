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

package org.oep.cmon.dao.chungthuc.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author vietho
 */
public class ThanhPhanHoSoChungThucLocalServiceClp
	implements ThanhPhanHoSoChungThucLocalService {
	public ThanhPhanHoSoChungThucLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addThanhPhanHoSoChungThucMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addThanhPhanHoSoChungThuc",
				org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc.class);

		_createThanhPhanHoSoChungThucMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createThanhPhanHoSoChungThuc", long.class);

		_deleteThanhPhanHoSoChungThucMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThanhPhanHoSoChungThuc", long.class);

		_deleteThanhPhanHoSoChungThucMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteThanhPhanHoSoChungThuc",
				org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc.class);

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

		_fetchThanhPhanHoSoChungThucMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchThanhPhanHoSoChungThuc", long.class);

		_getThanhPhanHoSoChungThucMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThanhPhanHoSoChungThuc", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getThanhPhanHoSoChungThucsMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThanhPhanHoSoChungThucs", int.class, int.class);

		_getThanhPhanHoSoChungThucsCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThanhPhanHoSoChungThucsCount");

		_updateThanhPhanHoSoChungThucMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThanhPhanHoSoChungThuc",
				org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc.class);

		_updateThanhPhanHoSoChungThucMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateThanhPhanHoSoChungThuc",
				org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getThanhPhanHoSoChungThucListByMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getThanhPhanHoSoChungThucListBy", long.class, int.class,
				int.class);

		_removeThanhPhanHoSoByHSChungThucIdMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"removeThanhPhanHoSoByHSChungThucId", long.class);
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc addThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addThanhPhanHoSoChungThucMethodKey0,
				ClpSerializer.translateInput(thanhPhanHoSoChungThuc));

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc createThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createThanhPhanHoSoChungThucMethodKey1,
				thanhPhanHoSoId);

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteThanhPhanHoSoChungThuc(long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThanhPhanHoSoChungThucMethodKey2,
				thanhPhanHoSoId);

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

	public void deleteThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteThanhPhanHoSoChungThucMethodKey3,
				ClpSerializer.translateInput(thanhPhanHoSoChungThuc));

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

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc fetchThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchThanhPhanHoSoChungThucMethodKey8,
				thanhPhanHoSoId);

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc getThanhPhanHoSoChungThuc(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThanhPhanHoSoChungThucMethodKey9,
				thanhPhanHoSoId);

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThanhPhanHoSoChungThucsMethodKey11,
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

		return (java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public int getThanhPhanHoSoChungThucsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThanhPhanHoSoChungThucsCountMethodKey12);

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

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThanhPhanHoSoChungThucMethodKey13,
				ClpSerializer.translateInput(thanhPhanHoSoChungThuc));

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateThanhPhanHoSoChungThuc(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateThanhPhanHoSoChungThucMethodKey14,
				ClpSerializer.translateInput(thanhPhanHoSoChungThuc), merge);

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

		return (org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucListBy(
		long hoSoChungThucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getThanhPhanHoSoChungThucListByMethodKey17,
				hoSoChungThucId, start, end);

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

		return (java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc>)ClpSerializer.translateOutput(returnObj);
	}

	public void removeThanhPhanHoSoByHSChungThucId(long hsctId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_removeThanhPhanHoSoByHSChungThucIdMethodKey18,
				hsctId);

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

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addThanhPhanHoSoChungThucMethodKey0;
	private MethodKey _createThanhPhanHoSoChungThucMethodKey1;
	private MethodKey _deleteThanhPhanHoSoChungThucMethodKey2;
	private MethodKey _deleteThanhPhanHoSoChungThucMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchThanhPhanHoSoChungThucMethodKey8;
	private MethodKey _getThanhPhanHoSoChungThucMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getThanhPhanHoSoChungThucsMethodKey11;
	private MethodKey _getThanhPhanHoSoChungThucsCountMethodKey12;
	private MethodKey _updateThanhPhanHoSoChungThucMethodKey13;
	private MethodKey _updateThanhPhanHoSoChungThucMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getThanhPhanHoSoChungThucListByMethodKey17;
	private MethodKey _removeThanhPhanHoSoByHSChungThucIdMethodKey18;
}