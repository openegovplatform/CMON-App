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

import org.oep.cmon.dao.report.model.DanhMucRole;

/**
 * The persistence interface for the danh muc role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhMucRolePersistenceImpl
 * @see DanhMucRoleUtil
 * @generated
 */
public interface DanhMucRolePersistence extends BasePersistence<DanhMucRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucRoleUtil} to access the danh muc role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh muc role in the entity cache if it is enabled.
	*
	* @param danhMucRole the danh muc role
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole);

	/**
	* Caches the danh muc roles in the entity cache if it is enabled.
	*
	* @param danhMucRoles the danh muc roles
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> danhMucRoles);

	/**
	* Creates a new danh muc role with the primary key. Does not add the danh muc role to the database.
	*
	* @param ID the primary key for the new danh muc role
	* @return the new danh muc role
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole create(long ID);

	/**
	* Removes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role that was removed
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucRoleException;

	public org.oep.cmon.dao.report.model.DanhMucRole updateImpl(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchDanhMucRoleException} if it could not be found.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucRoleException;

	/**
	* Returns the danh muc role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role, or <code>null</code> if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.DanhMucRole fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh muc roles.
	*
	* @return the danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh muc roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc roles
	* @param end the upper bound of the range of danh muc roles (not inclusive)
	* @return the range of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh muc roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc roles
	* @param end the upper bound of the range of danh muc roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the danh muc roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc roles.
	*
	* @return the number of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}