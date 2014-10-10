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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;

/**
 * The persistence interface for the co quan hanh chinh su nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanHanhChinhSuNghiepPersistenceImpl
 * @see CoQuanHanhChinhSuNghiepUtil
 * @generated
 */
public interface CoQuanHanhChinhSuNghiepPersistence extends BasePersistence<CoQuanHanhChinhSuNghiep> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoQuanHanhChinhSuNghiepUtil} to access the co quan hanh chinh su nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the co quan hanh chinh su nghiep in the entity cache if it is enabled.
	*
	* @param coQuanHanhChinhSuNghiep the co quan hanh chinh su nghiep
	*/
	public void cacheResult(
		org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep);

	/**
	* Caches the co quan hanh chinh su nghieps in the entity cache if it is enabled.
	*
	* @param coQuanHanhChinhSuNghieps the co quan hanh chinh su nghieps
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> coQuanHanhChinhSuNghieps);

	/**
	* Creates a new co quan hanh chinh su nghiep with the primary key. Does not add the co quan hanh chinh su nghiep to the database.
	*
	* @param id the primary key for the new co quan hanh chinh su nghiep
	* @return the new co quan hanh chinh su nghiep
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep create(long id);

	/**
	* Removes the co quan hanh chinh su nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException if a co quan hanh chinh su nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException;

	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep updateImpl(
		org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep coQuanHanhChinhSuNghiep,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the co quan hanh chinh su nghiep with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException} if it could not be found.
	*
	* @param id the primary key of the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException if a co quan hanh chinh su nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanHanhChinhSuNghiepException;

	/**
	* Returns the co quan hanh chinh su nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the co quan hanh chinh su nghiep
	* @return the co quan hanh chinh su nghiep, or <code>null</code> if a co quan hanh chinh su nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the co quan hanh chinh su nghieps.
	*
	* @return the co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan hanh chinh su nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan hanh chinh su nghieps
	* @param end the upper bound of the range of co quan hanh chinh su nghieps (not inclusive)
	* @return the range of co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan hanh chinh su nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan hanh chinh su nghieps
	* @param end the upper bound of the range of co quan hanh chinh su nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan hanh chinh su nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan hanh chinh su nghieps.
	*
	* @return the number of co quan hanh chinh su nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}