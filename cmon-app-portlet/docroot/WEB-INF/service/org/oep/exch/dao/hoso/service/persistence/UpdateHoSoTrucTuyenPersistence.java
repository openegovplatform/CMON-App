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

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen;

/**
 * The persistence interface for the update ho so truc tuyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see UpdateHoSoTrucTuyenPersistenceImpl
 * @see UpdateHoSoTrucTuyenUtil
 * @generated
 */
public interface UpdateHoSoTrucTuyenPersistence extends BasePersistence<UpdateHoSoTrucTuyen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UpdateHoSoTrucTuyenUtil} to access the update ho so truc tuyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the update ho so truc tuyen in the entity cache if it is enabled.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	*/
	public void cacheResult(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen);

	/**
	* Caches the update ho so truc tuyens in the entity cache if it is enabled.
	*
	* @param updateHoSoTrucTuyens the update ho so truc tuyens
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> updateHoSoTrucTuyens);

	/**
	* Creates a new update ho so truc tuyen with the primary key. Does not add the update ho so truc tuyen to the database.
	*
	* @param id the primary key for the new update ho so truc tuyen
	* @return the new update ho so truc tuyen
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen create(long id);

	/**
	* Removes the update ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException;

	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the update ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException} if it could not be found.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException;

	/**
	* Returns the update ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen, or <code>null</code> if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the update ho so truc tuyens.
	*
	* @return the update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the update ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update ho so truc tuyens
	* @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	* @return the range of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the update ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update ho so truc tuyens
	* @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the update ho so truc tuyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of update ho so truc tuyens.
	*
	* @return the number of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}