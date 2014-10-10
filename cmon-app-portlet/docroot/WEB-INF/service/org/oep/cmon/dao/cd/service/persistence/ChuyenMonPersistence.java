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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.cd.model.ChuyenMon;

/**
 * The persistence interface for the chuyen mon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ChuyenMonPersistenceImpl
 * @see ChuyenMonUtil
 * @generated
 */
public interface ChuyenMonPersistence extends BasePersistence<ChuyenMon> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChuyenMonUtil} to access the chuyen mon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chuyen mon in the entity cache if it is enabled.
	*
	* @param chuyenMon the chuyen mon
	*/
	public void cacheResult(org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon);

	/**
	* Caches the chuyen mons in the entity cache if it is enabled.
	*
	* @param chuyenMons the chuyen mons
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> chuyenMons);

	/**
	* Creates a new chuyen mon with the primary key. Does not add the chuyen mon to the database.
	*
	* @param id the primary key for the new chuyen mon
	* @return the new chuyen mon
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon create(long id);

	/**
	* Removes the chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuyen mon
	* @return the chuyen mon that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchChuyenMonException if a chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchChuyenMonException;

	public org.oep.cmon.dao.cd.model.ChuyenMon updateImpl(
		org.oep.cmon.dao.cd.model.ChuyenMon chuyenMon, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chuyen mon with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchChuyenMonException} if it could not be found.
	*
	* @param id the primary key of the chuyen mon
	* @return the chuyen mon
	* @throws org.oep.cmon.dao.cd.NoSuchChuyenMonException if a chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchChuyenMonException;

	/**
	* Returns the chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chuyen mon
	* @return the chuyen mon, or <code>null</code> if a chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.ChuyenMon fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chuyen mons.
	*
	* @return the chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuyen mons
	* @param end the upper bound of the range of chuyen mons (not inclusive)
	* @return the range of chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuyen mons
	* @param end the upper bound of the range of chuyen mons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.ChuyenMon> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuyen mons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuyen mons.
	*
	* @return the number of chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}