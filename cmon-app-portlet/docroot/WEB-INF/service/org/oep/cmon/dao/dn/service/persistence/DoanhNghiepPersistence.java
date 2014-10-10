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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dn.model.DoanhNghiep;

/**
 * The persistence interface for the doanh nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiepPersistenceImpl
 * @see DoanhNghiepUtil
 * @generated
 */
public interface DoanhNghiepPersistence extends BasePersistence<DoanhNghiep> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DoanhNghiepUtil} to access the doanh nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the doanh nghiep in the entity cache if it is enabled.
	*
	* @param doanhNghiep the doanh nghiep
	*/
	public void cacheResult(org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep);

	/**
	* Caches the doanh nghieps in the entity cache if it is enabled.
	*
	* @param doanhNghieps the doanh nghieps
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> doanhNghieps);

	/**
	* Creates a new doanh nghiep with the primary key. Does not add the doanh nghiep to the database.
	*
	* @param id the primary key for the new doanh nghiep
	* @return the new doanh nghiep
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep create(long id);

	/**
	* Removes the doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	public org.oep.cmon.dao.dn.model.DoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep, or <code>null</code> if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where ma = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param maSoThue the ma so thue
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByMaSoThue(
		java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param maSoThue the ma so thue
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMaSoThue(
		java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param maSoThue the ma so thue
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMaSoThue(
		java.lang.String maSoThue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where ten = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findBySoGCNDKKD(
		java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchBySoGCNDKKD(
		java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchBySoGCNDKKD(
		java.lang.String soGCNDKKD, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where chaId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param chaId the cha ID
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByChaId(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param chaId the cha ID
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByChaId(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param chaId the cha ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByChaId(
		java.lang.Long chaId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep fetchByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByGetNguoiDaiDienDoiTuong_First(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the last doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByGetNguoiDaiDienDoiTuong_Last(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doanh nghiep
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep[] findByGetNguoiDaiDienDoiTuong_PrevAndNext(
		long id, java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @return the matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByGetLoaiHinhDoanhNghiep_First(
		java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the last doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep findByGetLoaiHinhDoanhNghiep_Last(
		java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doanh nghiep
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.DoanhNghiep[] findByGetLoaiHinhDoanhNghiep_PrevAndNext(
		long id, java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Returns all the doanh nghieps.
	*
	* @return the doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the doanh nghiep where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes the doanh nghiep where maSoThue = &#63; from the database.
	*
	* @param maSoThue the ma so thue
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaSoThue(java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes the doanh nghiep where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes the doanh nghiep where soGCNDKKD = &#63; from the database.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySoGCNDKKD(java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes the doanh nghiep where chaId = &#63; from the database.
	*
	* @param chaId the cha ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChaId(java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes the doanh nghiep where nguoiDaiDienId = &#63; from the database.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNguoiDaiDienId(java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException;

	/**
	* Removes all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63; from the database.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGetNguoiDaiDienDoiTuong(java.lang.Long nguoiDaiDienId,
		java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the doanh nghieps where loaiHinhDoanhNghiepId = &#63; from the database.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where maSoThue = &#63;.
	*
	* @param maSoThue the ma so thue
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaSoThue(java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where soGCNDKKD = &#63;.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countBySoGCNDKKD(java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where chaId = &#63;.
	*
	* @param chaId the cha ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByChaId(java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where nguoiDaiDienId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByNguoiDaiDienId(java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByGetNguoiDaiDienDoiTuong(java.lang.Long nguoiDaiDienId,
		java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of doanh nghieps.
	*
	* @return the number of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}