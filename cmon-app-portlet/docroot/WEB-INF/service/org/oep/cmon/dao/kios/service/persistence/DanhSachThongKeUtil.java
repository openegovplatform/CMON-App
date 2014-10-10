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

import org.oep.cmon.dao.kios.model.DanhSachThongKe;

import java.util.List;

/**
 * The persistence utility for the danh sach thong ke service. This utility wraps {@link DanhSachThongKePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachThongKePersistence
 * @see DanhSachThongKePersistenceImpl
 * @generated
 */
public class DanhSachThongKeUtil {
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
	public static void clearCache(DanhSachThongKe danhSachThongKe) {
		getPersistence().clearCache(danhSachThongKe);
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
	public static List<DanhSachThongKe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhSachThongKe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhSachThongKe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhSachThongKe update(DanhSachThongKe danhSachThongKe,
		boolean merge) throws SystemException {
		return getPersistence().update(danhSachThongKe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhSachThongKe update(DanhSachThongKe danhSachThongKe,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhSachThongKe, merge, serviceContext);
	}

	/**
	* Caches the danh sach thong ke in the entity cache if it is enabled.
	*
	* @param danhSachThongKe the danh sach thong ke
	*/
	public static void cacheResult(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe) {
		getPersistence().cacheResult(danhSachThongKe);
	}

	/**
	* Caches the danh sach thong kes in the entity cache if it is enabled.
	*
	* @param danhSachThongKes the danh sach thong kes
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> danhSachThongKes) {
		getPersistence().cacheResult(danhSachThongKes);
	}

	/**
	* Creates a new danh sach thong ke with the primary key. Does not add the danh sach thong ke to the database.
	*
	* @param COQUANQUANLYID the primary key for the new danh sach thong ke
	* @return the new danh sach thong ke
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachThongKe create(
		long COQUANQUANLYID) {
		return getPersistence().create(COQUANQUANLYID);
	}

	/**
	* Removes the danh sach thong ke with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke that was removed
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachThongKe remove(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException {
		return getPersistence().remove(COQUANQUANLYID);
	}

	public static org.oep.cmon.dao.kios.model.DanhSachThongKe updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachThongKe danhSachThongKe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhSachThongKe, merge);
	}

	/**
	* Returns the danh sach thong ke with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException} if it could not be found.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachThongKe findByPrimaryKey(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachThongKeException {
		return getPersistence().findByPrimaryKey(COQUANQUANLYID);
	}

	/**
	* Returns the danh sach thong ke with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param COQUANQUANLYID the primary key of the danh sach thong ke
	* @return the danh sach thong ke, or <code>null</code> if a danh sach thong ke with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachThongKe fetchByPrimaryKey(
		long COQUANQUANLYID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(COQUANQUANLYID);
	}

	/**
	* Returns all the danh sach thong kes.
	*
	* @return the danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh sach thong kes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach thong kes
	* @param end the upper bound of the range of danh sach thong kes (not inclusive)
	* @return the range of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh sach thong kes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach thong kes
	* @param end the upper bound of the range of danh sach thong kes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachThongKe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the danh sach thong kes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh sach thong kes.
	*
	* @return the number of danh sach thong kes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhSachThongKePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhSachThongKePersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.kios.service.ClpSerializer.getServletContextName(),
					DanhSachThongKePersistence.class.getName());

			ReferenceRegistry.registerReference(DanhSachThongKeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhSachThongKePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhSachThongKeUtil.class,
			"_persistence");
	}

	private static DanhSachThongKePersistence _persistence;
}