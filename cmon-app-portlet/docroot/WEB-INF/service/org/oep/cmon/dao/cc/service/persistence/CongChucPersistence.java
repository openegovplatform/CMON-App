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

package org.oep.cmon.dao.cc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.cc.model.CongChuc;

/**
 * The persistence interface for the cong chuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChucPersistenceImpl
 * @see CongChucUtil
 * @generated
 */
public interface CongChucPersistence extends BasePersistence<CongChuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongChucUtil} to access the cong chuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cong chuc in the entity cache if it is enabled.
	*
	* @param congChuc the cong chuc
	*/
	public void cacheResult(org.oep.cmon.dao.cc.model.CongChuc congChuc);

	/**
	* Caches the cong chucs in the entity cache if it is enabled.
	*
	* @param congChucs the cong chucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cc.model.CongChuc> congChucs);

	/**
	* Creates a new cong chuc with the primary key. Does not add the cong chuc to the database.
	*
	* @param id the primary key for the new cong chuc
	* @return the new cong chuc
	*/
	public org.oep.cmon.dao.cc.model.CongChuc create(long id);

	/**
	* Removes the cong chuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc that was removed
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	public org.oep.cmon.dao.cc.model.CongChuc updateImpl(
		org.oep.cmon.dao.cc.model.CongChuc congChuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChucException} if it could not be found.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc, or <code>null</code> if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong chucs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the last cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc[] findByMa_PrevAndNext(long id,
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByTaiKhoanNguoiDungId_First(
		java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the last cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByTaiKhoanNguoiDungId_Last(
		java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc[] findByTaiKhoanNguoiDungId_PrevAndNext(
		long id, java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns all the cong chucs where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByChucVuId_First(
		long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the last cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByChucVuId_Last(
		long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc[] findByChucVuId_PrevAndNext(
		long id, long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByCoQuanQuanLyId_First(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the last cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByCoQuanQuanLyId_Last(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc[] findByCoQuanQuanLyId_PrevAndNext(
		long id, long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns all the cong chucs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByTrangThai_First(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the last cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc findByTrangThai_Last(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException;

	/**
	* Returns all the cong chucs.
	*
	* @return the cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs where taiKhoanNguoiDungId = &#63; from the database.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs where chucVuId = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChucVuId(long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong chucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByChucVuId(long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chucs.
	*
	* @return the number of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}