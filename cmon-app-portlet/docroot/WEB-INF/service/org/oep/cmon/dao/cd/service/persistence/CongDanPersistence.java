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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.cd.model.CongDan;

/**
 * The persistence interface for the cong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CongDanPersistenceImpl
 * @see CongDanUtil
 * @generated
 */
public interface CongDanPersistence extends BasePersistence<CongDan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongDanUtil} to access the cong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cong dan in the entity cache if it is enabled.
	*
	* @param congDan the cong dan
	*/
	public void cacheResult(org.oep.cmon.dao.cd.model.CongDan congDan);

	/**
	* Caches the cong dans in the entity cache if it is enabled.
	*
	* @param congDans the cong dans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.CongDan> congDans);

	/**
	* Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	*
	* @param id the primary key for the new cong dan
	* @return the new cong dan
	*/
	public org.oep.cmon.dao.cd.model.CongDan create(long id);

	/**
	* Removes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	public org.oep.cmon.dao.cd.model.CongDan updateImpl(
		org.oep.cmon.dao.cd.model.CongDan congDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan, or <code>null</code> if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByTrangThai_First(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the last cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByTrangThai_Last(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan where ma = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByMa(java.lang.String ma,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong dans where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the last cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan[] findByTen_PrevAndNext(long id,
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns all the cong dans where email = &#63;.
	*
	* @param email the email
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByEmail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the last cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByEmail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan[] findByEmail_PrevAndNext(
		long id, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns all the cong dans where soCmnd = &#63;.
	*
	* @param soCmnd the so cmnd
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findBySoCmnd_First(
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the last cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findBySoCmnd_Last(
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan[] findBySoCmnd_PrevAndNext(
		long id, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByM_T_S_First(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the last cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan findByM_T_S_Last(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.CongDan[] findByM_T_S_PrevAndNext(
		long id, java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Returns all the cong dans.
	*
	* @return the cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong dans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cong dan where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Removes the cong dan where email = &#63; and soCmnd = &#63; from the database.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailAndCMND(java.lang.String email,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNgaySinhAndCMND(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNgaySinh(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException;

	/**
	* Removes all the cong dans where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong dans where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong dans where soCmnd = &#63; from the database.
	*
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySoCmnd(java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63; from the database.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public void removeByM_T_S(java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where email = &#63; and soCmnd = &#63;.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAndCMND(java.lang.String email,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByNgaySinhAndCMND(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByNgaySinh(java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where email = &#63;.
	*
	* @param email the email
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where soCmnd = &#63;.
	*
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countBySoCmnd(java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByM_T_S(java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong dans.
	*
	* @return the number of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}