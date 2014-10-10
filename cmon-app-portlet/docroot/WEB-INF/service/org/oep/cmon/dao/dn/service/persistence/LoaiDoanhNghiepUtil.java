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

import org.oep.cmon.dao.dn.model.LoaiDoanhNghiep;

import java.util.List;

/**
 * The persistence utility for the loai doanh nghiep service. This utility wraps {@link LoaiDoanhNghiepPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see LoaiDoanhNghiepPersistence
 * @see LoaiDoanhNghiepPersistenceImpl
 * @generated
 */
public class LoaiDoanhNghiepUtil {
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
	public static void clearCache(LoaiDoanhNghiep loaiDoanhNghiep) {
		getPersistence().clearCache(loaiDoanhNghiep);
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
	public static List<LoaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LoaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LoaiDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LoaiDoanhNghiep update(LoaiDoanhNghiep loaiDoanhNghiep,
		boolean merge) throws SystemException {
		return getPersistence().update(loaiDoanhNghiep, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LoaiDoanhNghiep update(LoaiDoanhNghiep loaiDoanhNghiep,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(loaiDoanhNghiep, merge, serviceContext);
	}

	/**
	* Caches the loai doanh nghiep in the entity cache if it is enabled.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep) {
		getPersistence().cacheResult(loaiDoanhNghiep);
	}

	/**
	* Caches the loai doanh nghieps in the entity cache if it is enabled.
	*
	* @param loaiDoanhNghieps the loai doanh nghieps
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> loaiDoanhNghieps) {
		getPersistence().cacheResult(loaiDoanhNghieps);
	}

	/**
	* Creates a new loai doanh nghiep with the primary key. Does not add the loai doanh nghiep to the database.
	*
	* @param id the primary key for the new loai doanh nghiep
	* @return the new loai doanh nghiep
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the loai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(loaiDoanhNghiep, merge);
	}

	/**
	* Returns the loai doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the loai doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep, or <code>null</code> if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the loai doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the loai doanh nghieps where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the loai doanh nghieps where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the loai doanh nghieps before and after the current loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current loai doanh nghiep
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns the loai doanh nghiep where ten = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns the loai doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching loai doanh nghiep, or <code>null</code> if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten);
	}

	/**
	* Returns the loai doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loai doanh nghiep, or <code>null</code> if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten, retrieveFromCache);
	}

	/**
	* Returns all the loai doanh nghieps.
	*
	* @return the loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the loai doanh nghieps where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the loai doanh nghiep where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the loai doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loai doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of loai doanh nghieps where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of loai doanh nghieps.
	*
	* @return the number of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LoaiDoanhNghiepPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LoaiDoanhNghiepPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dn.service.ClpSerializer.getServletContextName(),
					LoaiDoanhNghiepPersistence.class.getName());

			ReferenceRegistry.registerReference(LoaiDoanhNghiepUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LoaiDoanhNghiepPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LoaiDoanhNghiepUtil.class,
			"_persistence");
	}

	private static LoaiDoanhNghiepPersistence _persistence;
}