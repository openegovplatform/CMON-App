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

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX;

import com.liferay.portal.service.persistence.BasePersistence;


/**
 * The persistence interface for the ly do cap doi cap lai g p l x service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see LyDoCapDoiCapLaiGPLXPersistenceImpl
 * @see LyDoCapDoiCapLaiGPLXUtil
 * @generated
 */
public interface LyDoCapDoiCapLaiGPLXPersistence extends BasePersistence<LyDoCapDoiCapLaiGPLX> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LyDoCapDoiCapLaiGPLXUtil} to access the ly do cap doi cap lai g p l x persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ly do cap doi cap lai g p l x in the entity cache if it is enabled.
	*
	* @param lyDoCapDoiCapLaiGPLX the ly do cap doi cap lai g p l x
	*/
	public void cacheResult(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX);

	/**
	* Caches the ly do cap doi cap lai g p l xs in the entity cache if it is enabled.
	*
	* @param lyDoCapDoiCapLaiGPLXs the ly do cap doi cap lai g p l xs
	*/
	public void cacheResult(
		java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> lyDoCapDoiCapLaiGPLXs);

	/**
	* Creates a new ly do cap doi cap lai g p l x with the primary key. Does not add the ly do cap doi cap lai g p l x to the database.
	*
	* @param id the primary key for the new ly do cap doi cap lai g p l x
	* @return the new ly do cap doi cap lai g p l x
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX create(
		long id);

	/**
	* Removes the ly do cap doi cap lai g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x that was removed
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException;

	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ly do cap doi cap lai g p l x with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException} if it could not be found.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException;

	/**
	* Returns the ly do cap doi cap lai g p l x with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x, or <code>null</code> if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ly do cap doi cap lai g p l xs.
	*
	* @return the ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ly do cap doi cap lai g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	* @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	* @return the range of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ly do cap doi cap lai g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	* @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ly do cap doi cap lai g p l xs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ly do cap doi cap lai g p l xs.
	*
	* @return the number of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}