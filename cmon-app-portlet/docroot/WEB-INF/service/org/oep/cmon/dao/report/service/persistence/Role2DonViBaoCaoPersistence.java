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

import org.oep.cmon.dao.report.model.Role2DonViBaoCao;

/**
 * The persistence interface for the role2 don vi bao cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2DonViBaoCaoPersistenceImpl
 * @see Role2DonViBaoCaoUtil
 * @generated
 */
public interface Role2DonViBaoCaoPersistence extends BasePersistence<Role2DonViBaoCao> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Role2DonViBaoCaoUtil} to access the role2 don vi bao cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the role2 don vi bao cao in the entity cache if it is enabled.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao);

	/**
	* Caches the role2 don vi bao caos in the entity cache if it is enabled.
	*
	* @param role2DonViBaoCaos the role2 don vi bao caos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> role2DonViBaoCaos);

	/**
	* Creates a new role2 don vi bao cao with the primary key. Does not add the role2 don vi bao cao to the database.
	*
	* @param ID the primary key for the new role2 don vi bao cao
	* @return the new role2 don vi bao cao
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao create(long ID);

	/**
	* Removes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao that was removed
	* @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException;

	public org.oep.cmon.dao.report.model.Role2DonViBaoCao updateImpl(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the role2 don vi bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException} if it could not be found.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao
	* @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException;

	/**
	* Returns the role2 don vi bao cao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao, or <code>null</code> if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Role2DonViBaoCao fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the role2 don vi bao caos.
	*
	* @return the role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the role2 don vi bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 don vi bao caos
	* @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	* @return the range of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the role2 don vi bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 don vi bao caos
	* @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the role2 don vi bao caos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of role2 don vi bao caos.
	*
	* @return the number of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}