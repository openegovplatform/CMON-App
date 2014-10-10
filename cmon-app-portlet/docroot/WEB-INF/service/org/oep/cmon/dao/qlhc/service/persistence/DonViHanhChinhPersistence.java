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

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

/**
 * The persistence interface for the don vi hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see DonViHanhChinhPersistenceImpl
 * @see DonViHanhChinhUtil
 * @generated
 */
public interface DonViHanhChinhPersistence extends BasePersistence<DonViHanhChinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DonViHanhChinhUtil} to access the don vi hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the don vi hanh chinh in the entity cache if it is enabled.
	*
	* @param donViHanhChinh the don vi hanh chinh
	*/
	public void cacheResult(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh);

	/**
	* Caches the don vi hanh chinhs in the entity cache if it is enabled.
	*
	* @param donViHanhChinhs the don vi hanh chinhs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> donViHanhChinhs);

	/**
	* Creates a new don vi hanh chinh with the primary key. Does not add the don vi hanh chinh to the database.
	*
	* @param id the primary key for the new don vi hanh chinh
	* @return the new don vi hanh chinh
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh create(long id);

	/**
	* Removes the don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateImpl(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the don vi hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh, or <code>null</code> if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByCapDonViHanhChinhId_First(
		long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByCapDonViHanhChinhId_Last(
		long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByCapDonViHanhChinhId_PrevAndNext(
		long id, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByChaId_First(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByChaId_Last(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByChaId_PrevAndNext(
		long id, java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByQuocGiaId_First(
		long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByQuocGiaId_Last(
		long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByQuocGiaId_PrevAndNext(
		long id, long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByMaDVHC(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the don vi hanh chinh where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByTenDVHC(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByByQuocId_First(
		long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByByQuocId_Last(
		long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByByQuocId_PrevAndNext(
		long id, long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Returns all the don vi hanh chinhs.
	*
	* @return the don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCapDonViHanhChinhId(long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63; from the database.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChaId(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where quocGiaId = &#63; from the database.
	*
	* @param quocGiaId the quoc gia ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByQuocGiaId(long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the don vi hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaDVHC(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Removes the don vi hanh chinh where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTenDVHC(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException;

	/**
	* Removes all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByQuocId(long quocGiaId, long capDonViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the don vi hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCapDonViHanhChinhId(long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByChaId(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where quocGiaId = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByQuocGiaId(long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaDVHC(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTenDVHC(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByByQuocId(long quocGiaId, long capDonViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of don vi hanh chinhs.
	*
	* @return the number of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}