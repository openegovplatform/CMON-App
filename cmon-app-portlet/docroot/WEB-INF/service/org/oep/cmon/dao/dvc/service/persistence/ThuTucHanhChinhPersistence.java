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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;

/**
 * The persistence interface for the thu tuc hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTucHanhChinhPersistenceImpl
 * @see ThuTucHanhChinhUtil
 * @generated
 */
public interface ThuTucHanhChinhPersistence extends BasePersistence<ThuTucHanhChinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThuTucHanhChinhUtil} to access the thu tuc hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the thu tuc hanh chinh in the entity cache if it is enabled.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh);

	/**
	* Caches the thu tuc hanh chinhs in the entity cache if it is enabled.
	*
	* @param thuTucHanhChinhs the thu tuc hanh chinhs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> thuTucHanhChinhs);

	/**
	* Creates a new thu tuc hanh chinh with the primary key. Does not add the thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new thu tuc hanh chinh
	* @return the new thu tuc hanh chinh
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh create(long id);

	/**
	* Removes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh, or <code>null</code> if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the thu tuc hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByNhomDanhMucHanhChinh_First(
		long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByNhomDanhMucHanhChinh_Last(
		long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByNhomDanhMucHanhChinh_PrevAndNext(
		long id, long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Returns all the thu tuc hanh chinhs.
	*
	* @return the thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the thu tuc hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException;

	/**
	* Removes all the thu tuc hanh chinhs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNhomDanhMucHanhChinh(long nhomThuTucHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByNhomDanhMucHanhChinh(long nhomThuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc hanh chinhs.
	*
	* @return the number of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}