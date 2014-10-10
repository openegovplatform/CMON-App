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

import org.oep.cmon.dao.report.model.CongChuc2Role;

/**
 * The persistence interface for the cong chuc2 role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see CongChuc2RolePersistenceImpl
 * @see CongChuc2RoleUtil
 * @generated
 */
public interface CongChuc2RolePersistence extends BasePersistence<CongChuc2Role> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongChuc2RoleUtil} to access the cong chuc2 role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cong chuc2 role in the entity cache if it is enabled.
	*
	* @param congChuc2Role the cong chuc2 role
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role);

	/**
	* Caches the cong chuc2 roles in the entity cache if it is enabled.
	*
	* @param congChuc2Roles the cong chuc2 roles
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> congChuc2Roles);

	/**
	* Creates a new cong chuc2 role with the primary key. Does not add the cong chuc2 role to the database.
	*
	* @param ID the primary key for the new cong chuc2 role
	* @return the new cong chuc2 role
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role create(long ID);

	/**
	* Removes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role that was removed
	* @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCongChuc2RoleException;

	public org.oep.cmon.dao.report.model.CongChuc2Role updateImpl(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc2 role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchCongChuc2RoleException} if it could not be found.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role
	* @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCongChuc2RoleException;

	/**
	* Returns the cong chuc2 role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role, or <code>null</code> if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.CongChuc2Role fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong chuc2 roles.
	*
	* @return the cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @return the range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chuc2 roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chuc2 roles.
	*
	* @return the number of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}