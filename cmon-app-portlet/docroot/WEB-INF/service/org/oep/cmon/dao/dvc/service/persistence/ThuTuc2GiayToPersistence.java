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

import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;

/**
 * The persistence interface for the thu tuc2 giay to service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTuc2GiayToPersistenceImpl
 * @see ThuTuc2GiayToUtil
 * @generated
 */
public interface ThuTuc2GiayToPersistence extends BasePersistence<ThuTuc2GiayTo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThuTuc2GiayToUtil} to access the thu tuc2 giay to persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the thu tuc2 giay to in the entity cache if it is enabled.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo);

	/**
	* Caches the thu tuc2 giay tos in the entity cache if it is enabled.
	*
	* @param thuTuc2GiayTos the thu tuc2 giay tos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> thuTuc2GiayTos);

	/**
	* Creates a new thu tuc2 giay to with the primary key. Does not add the thu tuc2 giay to to the database.
	*
	* @param id the primary key for the new thu tuc2 giay to
	* @return the new thu tuc2 giay to
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo create(long id);

	/**
	* Removes the thu tuc2 giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thu tuc2 giay to with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException} if it could not be found.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the thu tuc2 giay to with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to, or <code>null</code> if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the last thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuchanhChinh_First(
		long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuchanhChinh_Last(
		long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByThuTuchanhChinh_PrevAndNext(
		long id, long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuc2GiayTo_First(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuc2GiayTo_Last(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByThuTuc2GiayTo_PrevAndNext(
		long id, long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException;

	/**
	* Returns all the thu tuc2 giay tos.
	*
	* @return the thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thu tuc2 giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thu tuc2 giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc2 giay tos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTuchanhChinh(long thuTucHanhChinhId, int daXoa,
		int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thu tuc2 giay tos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc2 giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTuchanhChinh(long thuTucHanhChinhId, int daXoa,
		int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thu tuc2 giay tos.
	*
	* @return the number of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}