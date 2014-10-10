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

package org.oep.cmon.dao.touchscreen.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong;

import java.util.List;

/**
 * The persistence utility for the tra cuu ho so t t h c cong service. This utility wraps {@link TraCuuHoSoTTHCCongPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TraCuuHoSoTTHCCongPersistence
 * @see TraCuuHoSoTTHCCongPersistenceImpl
 * @generated
 */
public class TraCuuHoSoTTHCCongUtil {
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
	public static void clearCache(TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) {
		getPersistence().clearCache(traCuuHoSoTTHCCong);
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
	public static List<TraCuuHoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TraCuuHoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TraCuuHoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TraCuuHoSoTTHCCong update(
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong, boolean merge)
		throws SystemException {
		return getPersistence().update(traCuuHoSoTTHCCong, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TraCuuHoSoTTHCCong update(
		TraCuuHoSoTTHCCong traCuuHoSoTTHCCong, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(traCuuHoSoTTHCCong, merge, serviceContext);
	}

	/**
	* Caches the tra cuu ho so t t h c cong in the entity cache if it is enabled.
	*
	* @param traCuuHoSoTTHCCong the tra cuu ho so t t h c cong
	*/
	public static void cacheResult(
		org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong traCuuHoSoTTHCCong) {
		getPersistence().cacheResult(traCuuHoSoTTHCCong);
	}

	/**
	* Caches the tra cuu ho so t t h c congs in the entity cache if it is enabled.
	*
	* @param traCuuHoSoTTHCCongs the tra cuu ho so t t h c congs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> traCuuHoSoTTHCCongs) {
		getPersistence().cacheResult(traCuuHoSoTTHCCongs);
	}

	/**
	* Creates a new tra cuu ho so t t h c cong with the primary key. Does not add the tra cuu ho so t t h c cong to the database.
	*
	* @param id the primary key for the new tra cuu ho so t t h c cong
	* @return the new tra cuu ho so t t h c cong
	*/
	public static org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tra cuu ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong that was removed
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong updateImpl(
		org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong traCuuHoSoTTHCCong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(traCuuHoSoTTHCCong, merge);
	}

	/**
	* Returns the tra cuu ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException} if it could not be found.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tra cuu ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong, or <code>null</code> if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tra cuu ho so t t h c congs.
	*
	* @return the tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tra cuu ho so t t h c congs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tra cuu ho so t t h c congs
	* @param end the upper bound of the range of tra cuu ho so t t h c congs (not inclusive)
	* @return the range of tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tra cuu ho so t t h c congs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tra cuu ho so t t h c congs
	* @param end the upper bound of the range of tra cuu ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tra cuu ho so t t h c congs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tra cuu ho so t t h c congs.
	*
	* @return the number of tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TraCuuHoSoTTHCCongPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TraCuuHoSoTTHCCongPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.touchscreen.service.ClpSerializer.getServletContextName(),
					TraCuuHoSoTTHCCongPersistence.class.getName());

			ReferenceRegistry.registerReference(TraCuuHoSoTTHCCongUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TraCuuHoSoTTHCCongPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TraCuuHoSoTTHCCongUtil.class,
			"_persistence");
	}

	private static TraCuuHoSoTTHCCongPersistence _persistence;
}