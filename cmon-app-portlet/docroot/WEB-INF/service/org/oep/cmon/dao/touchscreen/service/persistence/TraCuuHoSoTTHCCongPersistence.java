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

import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong;

/**
 * The persistence interface for the tra cuu ho so t t h c cong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TraCuuHoSoTTHCCongPersistenceImpl
 * @see TraCuuHoSoTTHCCongUtil
 * @generated
 */
public interface TraCuuHoSoTTHCCongPersistence extends BasePersistence<TraCuuHoSoTTHCCong> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraCuuHoSoTTHCCongUtil} to access the tra cuu ho so t t h c cong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tra cuu ho so t t h c cong in the entity cache if it is enabled.
	*
	* @param traCuuHoSoTTHCCong the tra cuu ho so t t h c cong
	*/
	public void cacheResult(
		org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong traCuuHoSoTTHCCong);

	/**
	* Caches the tra cuu ho so t t h c congs in the entity cache if it is enabled.
	*
	* @param traCuuHoSoTTHCCongs the tra cuu ho so t t h c congs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> traCuuHoSoTTHCCongs);

	/**
	* Creates a new tra cuu ho so t t h c cong with the primary key. Does not add the tra cuu ho so t t h c cong to the database.
	*
	* @param id the primary key for the new tra cuu ho so t t h c cong
	* @return the new tra cuu ho so t t h c cong
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong create(long id);

	/**
	* Removes the tra cuu ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong that was removed
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException;

	public org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong updateImpl(
		org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong traCuuHoSoTTHCCong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tra cuu ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException} if it could not be found.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuHoSoTTHCCongException;

	/**
	* Returns the tra cuu ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tra cuu ho so t t h c cong
	* @return the tra cuu ho so t t h c cong, or <code>null</code> if a tra cuu ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tra cuu ho so t t h c congs.
	*
	* @return the tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tra cuu ho so t t h c congs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tra cuu ho so t t h c congs.
	*
	* @return the number of tra cuu ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}