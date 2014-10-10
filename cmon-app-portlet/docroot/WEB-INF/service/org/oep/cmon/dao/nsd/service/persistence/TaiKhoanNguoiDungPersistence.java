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

package org.oep.cmon.dao.nsd.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

/**
 * The persistence interface for the tai khoan nguoi dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDungPersistenceImpl
 * @see TaiKhoanNguoiDungUtil
 * @generated
 */
public interface TaiKhoanNguoiDungPersistence extends BasePersistence<TaiKhoanNguoiDung> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiKhoanNguoiDungUtil} to access the tai khoan nguoi dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tai khoan nguoi dung in the entity cache if it is enabled.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	*/
	public void cacheResult(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung);

	/**
	* Caches the tai khoan nguoi dungs in the entity cache if it is enabled.
	*
	* @param taiKhoanNguoiDungs the tai khoan nguoi dungs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> taiKhoanNguoiDungs);

	/**
	* Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	*
	* @param id the primary key for the new tai khoan nguoi dung
	* @return the new tai khoan nguoi dung
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung create(long id);

	/**
	* Removes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateImpl(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai khoan nguoi dung with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung, or <code>null</code> if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByTenDangNhap(
		java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tenDangNhap the ten dang nhap
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByTenDangNhap(
		java.lang.String tenDangNhap, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenNguoiDung_First(
		java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenNguoiDung_Last(
		java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTenNguoiDung_PrevAndNext(
		long id, java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns all the tai khoan nguoi dungs where email = &#63;.
	*
	* @param email the email
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByEmail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByEmail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByEmail_PrevAndNext(
		long id, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDung_First(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDung_Last(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTaiKhoanNguoiDung_PrevAndNext(
		long id, java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Returns all the tai khoan nguoi dungs.
	*
	* @return the tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tai khoan nguoi dung where tenDangNhap = &#63; from the database.
	*
	* @param tenDangNhap the ten dang nhap
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTenDangNhap(java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException;

	/**
	* Removes all the tai khoan nguoi dungs where tenNguoiDung = &#63; from the database.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTenNguoiDung(java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tai khoan nguoi dungs where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tai khoan nguoi dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaiKhoanNguoiDung(java.lang.Long taiKhoanNguoiDungId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tai khoan nguoi dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs where tenDangNhap = &#63;.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTenDangNhap(java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTenNguoiDung(java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs where email = &#63;.
	*
	* @param email the email
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaiKhoanNguoiDung(java.lang.Long taiKhoanNguoiDungId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai khoan nguoi dungs.
	*
	* @return the number of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}