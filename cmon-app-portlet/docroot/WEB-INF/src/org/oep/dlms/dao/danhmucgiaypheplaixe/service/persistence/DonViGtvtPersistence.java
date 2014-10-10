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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service.persistence;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt;

import com.liferay.portal.service.persistence.BasePersistence;


/**
 * The persistence interface for the don vi gtvt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see DonViGtvtPersistenceImpl
 * @see DonViGtvtUtil
 * @generated
 */
public interface DonViGtvtPersistence extends BasePersistence<DonViGtvt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DonViGtvtUtil} to access the don vi gtvt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the don vi gtvt in the entity cache if it is enabled.
	*
	* @param donViGtvt the don vi gtvt
	*/
	public void cacheResult(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt);

	/**
	* Caches the don vi gtvts in the entity cache if it is enabled.
	*
	* @param donViGtvts the don vi gtvts
	*/
	public void cacheResult(
		java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> donViGtvts);

	/**
	* Creates a new don vi gtvt with the primary key. Does not add the don vi gtvt to the database.
	*
	* @param id the primary key for the new don vi gtvt
	* @return the new don vi gtvt
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt create(long id);

	/**
	* Removes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt that was removed
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException;

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the don vi gtvt with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException} if it could not be found.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException;

	/**
	* Returns the don vi gtvt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt, or <code>null</code> if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the don vi gtvts.
	*
	* @return the don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @return the range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi gtvts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi gtvts.
	*
	* @return the number of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}