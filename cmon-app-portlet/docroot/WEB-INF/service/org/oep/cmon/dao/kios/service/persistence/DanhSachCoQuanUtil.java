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

import org.oep.cmon.dao.kios.model.DanhSachCoQuan;

import java.util.List;

/**
 * The persistence utility for the danh sach co quan service. This utility wraps {@link DanhSachCoQuanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhSachCoQuanPersistence
 * @see DanhSachCoQuanPersistenceImpl
 * @generated
 */
public class DanhSachCoQuanUtil {
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
	public static void clearCache(DanhSachCoQuan danhSachCoQuan) {
		getPersistence().clearCache(danhSachCoQuan);
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
	public static List<DanhSachCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhSachCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhSachCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhSachCoQuan update(DanhSachCoQuan danhSachCoQuan,
		boolean merge) throws SystemException {
		return getPersistence().update(danhSachCoQuan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhSachCoQuan update(DanhSachCoQuan danhSachCoQuan,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhSachCoQuan, merge, serviceContext);
	}

	/**
	* Caches the danh sach co quan in the entity cache if it is enabled.
	*
	* @param danhSachCoQuan the danh sach co quan
	*/
	public static void cacheResult(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan) {
		getPersistence().cacheResult(danhSachCoQuan);
	}

	/**
	* Caches the danh sach co quans in the entity cache if it is enabled.
	*
	* @param danhSachCoQuans the danh sach co quans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> danhSachCoQuans) {
		getPersistence().cacheResult(danhSachCoQuans);
	}

	/**
	* Creates a new danh sach co quan with the primary key. Does not add the danh sach co quan to the database.
	*
	* @param id the primary key for the new danh sach co quan
	* @return the new danh sach co quan
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachCoQuan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the danh sach co quan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh sach co quan
	* @return the danh sach co quan that was removed
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException if a danh sach co quan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachCoQuan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.kios.model.DanhSachCoQuan updateImpl(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhSachCoQuan, merge);
	}

	/**
	* Returns the danh sach co quan with the primary key or throws a {@link org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException} if it could not be found.
	*
	* @param id the primary key of the danh sach co quan
	* @return the danh sach co quan
	* @throws org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException if a danh sach co quan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachCoQuan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.kios.NoSuchDanhSachCoQuanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the danh sach co quan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh sach co quan
	* @return the danh sach co quan, or <code>null</code> if a danh sach co quan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.kios.model.DanhSachCoQuan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the danh sach co quans.
	*
	* @return the danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh sach co quans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach co quans
	* @param end the upper bound of the range of danh sach co quans (not inclusive)
	* @return the range of danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh sach co quans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach co quans
	* @param end the upper bound of the range of danh sach co quans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.kios.model.DanhSachCoQuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the danh sach co quans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh sach co quans.
	*
	* @return the number of danh sach co quans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhSachCoQuanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhSachCoQuanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.kios.service.ClpSerializer.getServletContextName(),
					DanhSachCoQuanPersistence.class.getName());

			ReferenceRegistry.registerReference(DanhSachCoQuanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhSachCoQuanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhSachCoQuanUtil.class,
			"_persistence");
	}

	private static DanhSachCoQuanPersistence _persistence;
}