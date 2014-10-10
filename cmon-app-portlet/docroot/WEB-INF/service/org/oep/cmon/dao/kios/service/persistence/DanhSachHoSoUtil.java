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

package org.oep.cmon.dao.kios.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.kios.model.DanhSachHoSo;

import java.util.List;

/**
 * The persistence utility for the danh sach ho so service. This utility wraps {@link DanhSachHoSoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachHoSoPersistence
 * @see DanhSachHoSoPersistenceImpl
 * @generated
 */
public class DanhSachHoSoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DanhSachHoSo danhSachHoSo) {
		getPersistence().clearCache(danhSachHoSo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DanhSachHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhSachHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhSachHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhSachHoSo update(DanhSachHoSo danhSachHoSo, boolean merge)
		throws SystemException {
		return getPersistence().update(danhSachHoSo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhSachHoSo update(DanhSachHoSo danhSachHoSo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhSachHoSo, merge, serviceContext);
	}

	/**
	* Caches the danh sach ho so in the entity cache if it is enabled.
	*
	* @param danhSachHoSo the danh sach ho so
	*/
	public static void cacheResult(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo) {
		getPersistence().cacheResult(danhSachHoSo);
	}

	/**
	* Caches the danh sach ho sos in the entity cache if it is enabled.
	*
	* @param danhSachHoSos the danh sach ho sos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> danhSachHoSos) {
		getPersistence().cacheResult(danhSachHoSos);
	}

	/**
	* Creates a new danh sach ho so with the primary key. Does not add the danh sach ho so to the database.
	*
	* @param id the primary key for the new danh sach ho so
	* @return the new danh sach ho so
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the danh sach ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so that was removed
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.kios.model.DanhSachHoSo updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhSachHoSo, merge);
	}

	/**
	* Returns the danh sach ho so with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException} if it could not be found.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachHoSoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the danh sach ho so with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh sach ho so
	* @return the danh sach ho so, or <code>null</code> if a danh sach ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachHoSo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the danh sach ho sos.
	*
	* @return the danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh sach ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach ho sos
	* @param end the upper bound of the range of danh sach ho sos (not inclusive)
	* @return the range of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh sach ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach ho sos
	* @param end the upper bound of the range of danh sach ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachHoSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the danh sach ho sos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh sach ho sos.
	*
	* @return the number of danh sach ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhSachHoSoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhSachHoSoPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.kios.service.ClpSerializer.getServletContextName(),
					DanhSachHoSoPersistence.class.getName());

			ReferenceRegistry.registerReference(DanhSachHoSoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhSachHoSoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhSachHoSoUtil.class,
			"_persistence");
	}

	private static DanhSachHoSoPersistence _persistence;
}