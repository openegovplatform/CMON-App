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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;

/**
 * The persistence interface for the so danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see SoDanhMucPersistenceImpl
 * @see SoDanhMucUtil
 * @generated
 */
public interface SoDanhMucPersistence extends BasePersistence<SoDanhMuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SoDanhMucUtil} to access the so danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the so danh muc in the entity cache if it is enabled.
	*
	* @param soDanhMuc the so danh muc
	*/
	public void cacheResult(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc);

	/**
	* Caches the so danh mucs in the entity cache if it is enabled.
	*
	* @param soDanhMucs the so danh mucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> soDanhMucs);

	/**
	* Creates a new so danh muc with the primary key. Does not add the so danh muc to the database.
	*
	* @param id the primary key for the new so danh muc
	* @return the new so danh muc
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc create(long id);

	/**
	* Removes the so danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc that was removed
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the so danh muc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException} if it could not be found.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the so danh muc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc, or <code>null</code> if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCID_First(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCID_Last(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoTTHCID_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoCOQUANQUANLYID_First(
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the last so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoCOQUANQUANLYID_Last(
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoCOQUANQUANLYID_PrevAndNext(
		long id, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCIDAndCQQLID_First(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCIDAndCQQLID_Last(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoTTHCIDAndCQQLID_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId,
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException;

	/**
	* Returns all the so danh mucs.
	*
	* @return the so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the so danh mucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the so danh mucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the so danh mucs where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the so danh mucs where coQuanQuanLiId = &#63; from the database.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTheoCOQUANQUANLYID(java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTheoTTHCIDAndCQQLID(java.lang.Long thuTucHanhChinhId,
		java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the so danh mucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of so danh mucs where coQuanQuanLiId = &#63;.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTheoCOQUANQUANLYID(java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTheoTTHCIDAndCQQLID(java.lang.Long thuTucHanhChinhId,
		java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of so danh mucs.
	*
	* @return the number of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so chung thucs associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @return the ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so chung thucs associated with the so danh muc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the so danh muc
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so chung thucs associated with the so danh muc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the so danh muc
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so chung thucs associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @return the number of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public int getHoSoChungThucsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the ho so chung thuc is associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @param hoSoChungThucPK the primary key of the ho so chung thuc
	* @return <code>true</code> if the ho so chung thuc is associated with the so danh muc; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHoSoChungThuc(long pk, long hoSoChungThucPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the so danh muc has any ho so chung thucs associated with it.
	*
	* @param pk the primary key of the so danh muc to check for associations with ho so chung thucs
	* @return <code>true</code> if the so danh muc has any ho so chung thucs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsHoSoChungThucs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}