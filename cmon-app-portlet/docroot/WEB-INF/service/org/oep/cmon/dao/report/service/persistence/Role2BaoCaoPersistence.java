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

import org.oep.cmon.dao.report.model.Role2BaoCao;

/**
 * The persistence interface for the role2 bao cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2BaoCaoPersistenceImpl
 * @see Role2BaoCaoUtil
 * @generated
 */
public interface Role2BaoCaoPersistence extends BasePersistence<Role2BaoCao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Role2BaoCaoUtil} to access the role2 bao cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the role2 bao cao in the entity cache if it is enabled.
	*
	* @param role2BaoCao the role2 bao cao
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao);

	/**
	* Caches the role2 bao caos in the entity cache if it is enabled.
	*
	* @param role2BaoCaos the role2 bao caos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Role2BaoCao> role2BaoCaos);

	/**
	* Creates a new role2 bao cao with the primary key. Does not add the role2 bao cao to the database.
	*
	* @param ID the primary key for the new role2 bao cao
	* @return the new role2 bao cao
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao create(long ID);

	/**
	* Removes the role2 bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 bao cao
	* @return the role2 bao cao that was removed
	* @throws org.oep.cmon.dao.report.NoSuchRole2BaoCaoException if a role2 bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2BaoCaoException;

	public org.oep.cmon.dao.report.model.Role2BaoCao updateImpl(
		org.oep.cmon.dao.report.model.Role2BaoCao role2BaoCao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role2 bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2BaoCaoException} if it could not be found.
	*
	* @param ID the primary key of the role2 bao cao
	* @return the role2 bao cao
	* @throws org.oep.cmon.dao.report.NoSuchRole2BaoCaoException if a role2 bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2BaoCaoException;

	/**
	* Returns the role2 bao cao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the role2 bao cao
	* @return the role2 bao cao, or <code>null</code> if a role2 bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2BaoCao fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the role2 bao caos.
	*
	* @return the role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2BaoCao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the role2 bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 bao caos
	* @param end the upper bound of the range of role2 bao caos (not inclusive)
	* @return the range of role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2BaoCao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the role2 bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 bao caos
	* @param end the upper bound of the range of role2 bao caos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2BaoCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the role2 bao caos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of role2 bao caos.
	*
	* @return the number of role2 bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}