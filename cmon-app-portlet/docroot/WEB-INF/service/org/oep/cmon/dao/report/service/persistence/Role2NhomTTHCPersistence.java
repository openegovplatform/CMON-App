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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.report.model.Role2NhomTTHC;

/**
 * The persistence interface for the role2 nhom t t h c service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2NhomTTHCPersistenceImpl
 * @see Role2NhomTTHCUtil
 * @generated
 */
public interface Role2NhomTTHCPersistence extends BasePersistence<Role2NhomTTHC> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Role2NhomTTHCUtil} to access the role2 nhom t t h c persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the role2 nhom t t h c in the entity cache if it is enabled.
	*
	* @param role2NhomTTHC the role2 nhom t t h c
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC);

	/**
	* Caches the role2 nhom t t h cs in the entity cache if it is enabled.
	*
	* @param role2NhomTTHCs the role2 nhom t t h cs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Role2NhomTTHC> role2NhomTTHCs);

	/**
	* Creates a new role2 nhom t t h c with the primary key. Does not add the role2 nhom t t h c to the database.
	*
	* @param ID the primary key for the new role2 nhom t t h c
	* @return the new role2 nhom t t h c
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC create(long ID);

	/**
	* Removes the role2 nhom t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 nhom t t h c
	* @return the role2 nhom t t h c that was removed
	* @throws org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException if a role2 nhom t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException;

	public org.oep.cmon.dao.report.model.Role2NhomTTHC updateImpl(
		org.oep.cmon.dao.report.model.Role2NhomTTHC role2NhomTTHC, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role2 nhom t t h c with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException} if it could not be found.
	*
	* @param ID the primary key of the role2 nhom t t h c
	* @return the role2 nhom t t h c
	* @throws org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException if a role2 nhom t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2NhomTTHCException;

	/**
	* Returns the role2 nhom t t h c with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the role2 nhom t t h c
	* @return the role2 nhom t t h c, or <code>null</code> if a role2 nhom t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2NhomTTHC fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the role2 nhom t t h cs.
	*
	* @return the role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2NhomTTHC> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the role2 nhom t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 nhom t t h cs
	* @param end the upper bound of the range of role2 nhom t t h cs (not inclusive)
	* @return the range of role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2NhomTTHC> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the role2 nhom t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 nhom t t h cs
	* @param end the upper bound of the range of role2 nhom t t h cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2NhomTTHC> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the role2 nhom t t h cs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of role2 nhom t t h cs.
	*
	* @return the number of role2 nhom t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}