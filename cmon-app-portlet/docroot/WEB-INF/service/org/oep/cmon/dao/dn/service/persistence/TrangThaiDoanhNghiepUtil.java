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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep;

import java.util.List;

/**
 * The persistence utility for the trang thai doanh nghiep service. This utility wraps {@link TrangThaiDoanhNghiepPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TrangThaiDoanhNghiepPersistence
 * @see TrangThaiDoanhNghiepPersistenceImpl
 * @generated
 */
public class TrangThaiDoanhNghiepUtil {
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
	public static void clearCache(TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		getPersistence().clearCache(trangThaiDoanhNghiep);
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
	public static List<TrangThaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrangThaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrangThaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TrangThaiDoanhNghiep update(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep, boolean merge)
		throws SystemException {
		return getPersistence().update(trangThaiDoanhNghiep, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TrangThaiDoanhNghiep update(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(trangThaiDoanhNghiep, merge, serviceContext);
	}

	/**
	* Caches the trang thai doanh nghiep in the entity cache if it is enabled.
	*
	* @param trangThaiDoanhNghiep the trang thai doanh nghiep
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		getPersistence().cacheResult(trangThaiDoanhNghiep);
	}

	/**
	* Caches the trang thai doanh nghieps in the entity cache if it is enabled.
	*
	* @param trangThaiDoanhNghieps the trang thai doanh nghieps
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> trangThaiDoanhNghieps) {
		getPersistence().cacheResult(trangThaiDoanhNghieps);
	}

	/**
	* Creates a new trang thai doanh nghiep with the primary key. Does not add the trang thai doanh nghiep to the database.
	*
	* @param id the primary key for the new trang thai doanh nghiep
	* @return the new trang thai doanh nghiep
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the trang thai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai doanh nghiep
	* @return the trang thai doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trangThaiDoanhNghiep, merge);
	}

	/**
	* Returns the trang thai doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the trang thai doanh nghiep
	* @return the trang thai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the trang thai doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai doanh nghiep
	* @return the trang thai doanh nghiep, or <code>null</code> if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the trang thai doanh nghiep where id = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException} if it could not be found.
	*
	* @param id the ID
	* @return the matching trang thai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep findById(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the trang thai doanh nghiep where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching trang thai doanh nghiep, or <code>null</code> if a matching trang thai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep fetchById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the trang thai doanh nghiep where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trang thai doanh nghiep, or <code>null</code> if a matching trang thai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep fetchById(
		long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Returns all the trang thai doanh nghieps where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findByDaXoa(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa);
	}

	/**
	* Returns a range of all the trang thai doanh nghieps where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai doanh nghieps
	* @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	* @return the range of matching trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findByDaXoa(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the trang thai doanh nghieps where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai doanh nghieps
	* @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findByDaXoa(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep findByDaXoa_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence().findByDaXoa_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a matching trang thai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep findByDaXoa_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence().findByDaXoa_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the trang thai doanh nghieps before and after the current trang thai doanh nghiep in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trang thai doanh nghiep
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException if a trang thai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep[] findByDaXoa_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		return getPersistence()
				   .findByDaXoa_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the trang thai doanh nghieps.
	*
	* @return the trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the trang thai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai doanh nghieps
	* @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	* @return the range of trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the trang thai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai doanh nghieps
	* @param end the upper bound of the range of trang thai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the trang thai doanh nghiep where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchTrangThaiDoanhNghiepException {
		getPersistence().removeById(id);
	}

	/**
	* Removes all the trang thai doanh nghieps where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDaXoa(daXoa);
	}

	/**
	* Removes all the trang thai doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trang thai doanh nghieps where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the number of trang thai doanh nghieps where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDaXoa(daXoa);
	}

	/**
	* Returns the number of trang thai doanh nghieps.
	*
	* @return the number of trang thai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrangThaiDoanhNghiepPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrangThaiDoanhNghiepPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dn.service.ClpSerializer.getServletContextName(),
					TrangThaiDoanhNghiepPersistence.class.getName());

			ReferenceRegistry.registerReference(TrangThaiDoanhNghiepUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TrangThaiDoanhNghiepPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TrangThaiDoanhNghiepUtil.class,
			"_persistence");
	}

	private static TrangThaiDoanhNghiepPersistence _persistence;
}