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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.exch.dao.hoso.model.TrangThaiHoso;

import java.util.List;

/**
 * The persistence utility for the trang thai hoso service. This utility wraps {@link TrangThaiHosoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see TrangThaiHosoPersistence
 * @see TrangThaiHosoPersistenceImpl
 * @generated
 */
public class TrangThaiHosoUtil {
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
	public static void clearCache(TrangThaiHoso trangThaiHoso) {
		getPersistence().clearCache(trangThaiHoso);
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
	public static List<TrangThaiHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrangThaiHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrangThaiHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TrangThaiHoso update(TrangThaiHoso trangThaiHoso,
		boolean merge) throws SystemException {
		return getPersistence().update(trangThaiHoso, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TrangThaiHoso update(TrangThaiHoso trangThaiHoso,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(trangThaiHoso, merge, serviceContext);
	}

	/**
	* Caches the trang thai hoso in the entity cache if it is enabled.
	*
	* @param trangThaiHoso the trang thai hoso
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso) {
		getPersistence().cacheResult(trangThaiHoso);
	}

	/**
	* Caches the trang thai hosos in the entity cache if it is enabled.
	*
	* @param trangThaiHosos the trang thai hosos
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> trangThaiHosos) {
		getPersistence().cacheResult(trangThaiHosos);
	}

	/**
	* Creates a new trang thai hoso with the primary key. Does not add the trang thai hoso to the database.
	*
	* @param id the primary key for the new trang thai hoso
	* @return the new trang thai hoso
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the trang thai hoso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.TrangThaiHoso updateImpl(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trangThaiHoso, merge);
	}

	/**
	* Returns the trang thai hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException} if it could not be found.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the trang thai hoso with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso, or <code>null</code> if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns a range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @return the range of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy, start, end);
	}

	/**
	* Returns an ordered range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiXuLy(TrangThaiXuLy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_First(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the last trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_Last(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the trang thai hosos before and after the current trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trang thai hoso
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.TrangThaiHoso[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_PrevAndNext(id, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns all the trang thai hosos.
	*
	* @return the trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the trang thai hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @return the range of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the trang thai hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the trang thai hosos where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Removes all the trang thai hosos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the number of trang thai hosos.
	*
	* @return the number of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrangThaiHosoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrangThaiHosoPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					TrangThaiHosoPersistence.class.getName());

			ReferenceRegistry.registerReference(TrangThaiHosoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TrangThaiHosoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TrangThaiHosoUtil.class,
			"_persistence");
	}

	private static TrangThaiHosoPersistence _persistence;
}