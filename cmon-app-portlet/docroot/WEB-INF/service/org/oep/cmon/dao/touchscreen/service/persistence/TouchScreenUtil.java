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

import org.oep.cmon.dao.touchscreen.model.TouchScreen;

import java.util.List;

/**
 * The persistence utility for the touch screen service. This utility wraps {@link TouchScreenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TouchScreenPersistence
 * @see TouchScreenPersistenceImpl
 * @generated
 */
public class TouchScreenUtil {
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
	public static void clearCache(TouchScreen touchScreen) {
		getPersistence().clearCache(touchScreen);
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
	public static List<TouchScreen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TouchScreen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TouchScreen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TouchScreen update(TouchScreen touchScreen, boolean merge)
		throws SystemException {
		return getPersistence().update(touchScreen, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TouchScreen update(TouchScreen touchScreen, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(touchScreen, merge, serviceContext);
	}

	/**
	* Caches the touch screen in the entity cache if it is enabled.
	*
	* @param touchScreen the touch screen
	*/
	public static void cacheResult(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen) {
		getPersistence().cacheResult(touchScreen);
	}

	/**
	* Caches the touch screens in the entity cache if it is enabled.
	*
	* @param touchScreens the touch screens
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> touchScreens) {
		getPersistence().cacheResult(touchScreens);
	}

	/**
	* Creates a new touch screen with the primary key. Does not add the touch screen to the database.
	*
	* @param ID the primary key for the new touch screen
	* @return the new touch screen
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the touch screen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen that was removed
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.touchscreen.model.TouchScreen updateImpl(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(touchScreen, merge);
	}

	/**
	* Returns the touch screen with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException} if it could not be found.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the touch screen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen, or <code>null</code> if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.touchscreen.model.TouchScreen fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the touch screens.
	*
	* @return the touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the touch screens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of touch screens
	* @param end the upper bound of the range of touch screens (not inclusive)
	* @return the range of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the touch screens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of touch screens
	* @param end the upper bound of the range of touch screens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the touch screens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of touch screens.
	*
	* @return the number of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TouchScreenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TouchScreenPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.touchscreen.service.ClpSerializer.getServletContextName(),
					TouchScreenPersistence.class.getName());

			ReferenceRegistry.registerReference(TouchScreenUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TouchScreenPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TouchScreenUtil.class,
			"_persistence");
	}

	private static TouchScreenPersistence _persistence;
}