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

import org.oep.cmon.dao.report.model.Lephi_linhvuc;

/**
 * The persistence interface for the lephi_linhvuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_linhvucPersistenceImpl
 * @see Lephi_linhvucUtil
 * @generated
 */
public interface Lephi_linhvucPersistence extends BasePersistence<Lephi_linhvuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lephi_linhvucUtil} to access the lephi_linhvuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lephi_linhvuc in the entity cache if it is enabled.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc);

	/**
	* Caches the lephi_linhvucs in the entity cache if it is enabled.
	*
	* @param lephi_linhvucs the lephi_linhvucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> lephi_linhvucs);

	/**
	* Creates a new lephi_linhvuc with the primary key. Does not add the lephi_linhvuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new lephi_linhvuc
	* @return the new lephi_linhvuc
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc create(
		int NHOMTHUTUCHANHCHINHID);

	/**
	* Removes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc remove(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_linhvucException;

	public org.oep.cmon.dao.report.model.Lephi_linhvuc updateImpl(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lephi_linhvuc with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_linhvucException} if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc
	* @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc findByPrimaryKey(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_linhvucException;

	/**
	* Returns the lephi_linhvuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc, or <code>null</code> if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_linhvuc fetchByPrimaryKey(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lephi_linhvucs.
	*
	* @return the lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @return the range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lephi_linhvucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lephi_linhvucs.
	*
	* @return the number of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}