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

import org.oep.cmon.dao.report.model.Lephi_tonghop;

/**
 * The persistence interface for the lephi_tonghop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_tonghopPersistenceImpl
 * @see Lephi_tonghopUtil
 * @generated
 */
public interface Lephi_tonghopPersistence extends BasePersistence<Lephi_tonghop> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lephi_tonghopUtil} to access the lephi_tonghop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the lephi_tonghop in the entity cache if it is enabled.
	*
	* @param lephi_tonghop the lephi_tonghop
	*/
	public void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop);

	/**
	* Caches the lephi_tonghops in the entity cache if it is enabled.
	*
	* @param lephi_tonghops the lephi_tonghops
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> lephi_tonghops);

	/**
	* Creates a new lephi_tonghop with the primary key. Does not add the lephi_tonghop to the database.
	*
	* @param lephi_tonghopPK the primary key for the new lephi_tonghop
	* @return the new lephi_tonghop
	*/
	public org.oep.cmon.dao.report.model.Lephi_tonghop create(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK);

	/**
	* Removes the lephi_tonghop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_tonghop remove(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_tonghopException;

	public org.oep.cmon.dao.report.model.Lephi_tonghop updateImpl(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the lephi_tonghop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_tonghopException} if it could not be found.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop
	* @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_tonghop findByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_tonghopException;

	/**
	* Returns the lephi_tonghop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop, or <code>null</code> if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.report.model.Lephi_tonghop fetchByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the lephi_tonghops.
	*
	* @return the lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the lephi_tonghops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_tonghops
	* @param end the upper bound of the range of lephi_tonghops (not inclusive)
	* @return the range of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the lephi_tonghops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_tonghops
	* @param end the upper bound of the range of lephi_tonghops (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the lephi_tonghops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of lephi_tonghops.
	*
	* @return the number of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}