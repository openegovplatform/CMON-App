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

import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;

/**
 * The persistence interface for the t t h c2 doi tuong su dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2DoiTuongSuDungPersistenceImpl
 * @see TTHC2DoiTuongSuDungUtil
 * @generated
 */
public interface TTHC2DoiTuongSuDungPersistence extends BasePersistence<TTHC2DoiTuongSuDung> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTHC2DoiTuongSuDungUtil} to access the t t h c2 doi tuong su dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t t h c2 doi tuong su dung in the entity cache if it is enabled.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung);

	/**
	* Caches the t t h c2 doi tuong su dungs in the entity cache if it is enabled.
	*
	* @param tthc2DoiTuongSuDungs the t t h c2 doi tuong su dungs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> tthc2DoiTuongSuDungs);

	/**
	* Creates a new t t h c2 doi tuong su dung with the primary key. Does not add the t t h c2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new t t h c2 doi tuong su dung
	* @return the new t t h c2 doi tuong su dung
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung create(long id);

	/**
	* Removes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException} if it could not be found.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung, or <code>null</code> if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_First(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_Last(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByTT2LoaiDoiTuong_PrevAndNext(
		long id, long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException;

	/**
	* Returns all the t t h c2 doi tuong su dungs.
	*
	* @return the t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 doi tuong su dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 doi tuong su dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 doi tuong su dungs.
	*
	* @return the number of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}