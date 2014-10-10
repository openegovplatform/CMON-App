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

import org.oep.cmon.dao.report.model.Lephi_chitiet;

/**
 * The persistence interface for the lephi_chitiet service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_chitietPersistenceImpl
 * @see Lephi_chitietUtil
 * @generated
 */
public interface Lephi_chitietPersistence extends BasePersistence<Lephi_chitiet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lephi_chitietUtil} to access the lephi_chitiet persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lephi_chitiet in the entity cache if it is enabled.
	*
	* @param lephi_chitiet the lephi_chitiet
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet);

	/**
	* Caches the lephi_chitiets in the entity cache if it is enabled.
	*
	* @param lephi_chitiets the lephi_chitiets
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> lephi_chitiets);

	/**
	* Creates a new lephi_chitiet with the primary key. Does not add the lephi_chitiet to the database.
	*
	* @param ID the primary key for the new lephi_chitiet
	* @return the new lephi_chitiet
	*/
	public org.oep.cmon.dao.report.model.Lephi_chitiet create(long ID);

	/**
	* Removes the lephi_chitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_chitiet remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_chitietException;

	public org.oep.cmon.dao.report.model.Lephi_chitiet updateImpl(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lephi_chitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_chitietException} if it could not be found.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet
	* @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_chitiet findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_chitietException;

	/**
	* Returns the lephi_chitiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet, or <code>null</code> if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_chitiet fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lephi_chitiets.
	*
	* @return the lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lephi_chitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_chitiets
	* @param end the upper bound of the range of lephi_chitiets (not inclusive)
	* @return the range of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lephi_chitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_chitiets
	* @param end the upper bound of the range of lephi_chitiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lephi_chitiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lephi_chitiets.
	*
	* @return the number of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}