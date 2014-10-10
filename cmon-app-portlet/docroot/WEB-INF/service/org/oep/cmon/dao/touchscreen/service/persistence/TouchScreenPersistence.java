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

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.touchscreen.model.TouchScreen;

/**
 * The persistence interface for the touch screen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TouchScreenPersistenceImpl
 * @see TouchScreenUtil
 * @generated
 */
public interface TouchScreenPersistence extends BasePersistence<TouchScreen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TouchScreenUtil} to access the touch screen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the touch screen in the entity cache if it is enabled.
	*
	* @param touchScreen the touch screen
	*/
	public void cacheResult(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen);

	/**
	* Caches the touch screens in the entity cache if it is enabled.
	*
	* @param touchScreens the touch screens
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> touchScreens);

	/**
	* Creates a new touch screen with the primary key. Does not add the touch screen to the database.
	*
	* @param ID the primary key for the new touch screen
	* @return the new touch screen
	*/
	public org.oep.cmon.dao.touchscreen.model.TouchScreen create(long ID);

	/**
	* Removes the touch screen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen that was removed
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TouchScreen remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException;

	public org.oep.cmon.dao.touchscreen.model.TouchScreen updateImpl(
		org.oep.cmon.dao.touchscreen.model.TouchScreen touchScreen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the touch screen with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException} if it could not be found.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TouchScreen findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTouchScreenException;

	/**
	* Returns the touch screen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the touch screen
	* @return the touch screen, or <code>null</code> if a touch screen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TouchScreen fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the touch screens.
	*
	* @return the touch screens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TouchScreen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the touch screens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of touch screens.
	*
	* @return the number of touch screens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}