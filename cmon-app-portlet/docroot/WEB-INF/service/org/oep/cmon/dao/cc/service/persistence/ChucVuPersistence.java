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

import org.oep.cmon.dao.cc.model.ChucVu;

/**
 * The persistence interface for the chuc vu service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see ChucVuPersistenceImpl
 * @see ChucVuUtil
 * @generated
 */
public interface ChucVuPersistence extends BasePersistence<ChucVu> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChucVuUtil} to access the chuc vu persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chuc vu in the entity cache if it is enabled.
	*
	* @param chucVu the chuc vu
	*/
	public void cacheResult(org.oep.cmon.dao.cc.model.ChucVu chucVu);

	/**
	* Caches the chuc vus in the entity cache if it is enabled.
	*
	* @param chucVus the chuc vus
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cc.model.ChucVu> chucVus);

	/**
	* Creates a new chuc vu with the primary key. Does not add the chuc vu to the database.
	*
	* @param id the primary key for the new chuc vu
	* @return the new chuc vu
	*/
	public org.oep.cmon.dao.cc.model.ChucVu create(long id);

	/**
	* Removes the chuc vu with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuc vu
	* @return the chuc vu that was removed
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	public org.oep.cmon.dao.cc.model.ChucVu updateImpl(
		org.oep.cmon.dao.cc.model.ChucVu chucVu, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chuc vu with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchChucVuException} if it could not be found.
	*
	* @param id the primary key of the chuc vu
	* @return the chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the chuc vu with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chuc vu
	* @return the chuc vu, or <code>null</code> if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chuc vus where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuc vus where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @return the range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chuc vus where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chuc vu in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByTrangThai_First(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the last chuc vu in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByTrangThai_Last(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the chuc vus before and after the current chuc vu in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns all the chuc vus where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuc vus where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @return the range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chuc vus where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chuc vu in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the last chuc vu in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByMa_Last(java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the chuc vus before and after the current chuc vu in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu[] findByMa_PrevAndNext(long id,
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns all the chuc vus where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuc vus where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @return the range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chuc vus where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first chuc vu in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the last chuc vu in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a matching chuc vu could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns the chuc vus before and after the current chuc vu in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu
	* @throws org.oep.cmon.dao.cc.NoSuchChucVuException if a chuc vu with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.ChucVu[] findByTen_PrevAndNext(long id,
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchChucVuException;

	/**
	* Returns all the chuc vus.
	*
	* @return the chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the chuc vus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @return the range of chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the chuc vus.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vus
	* @param end the upper bound of the range of chuc vus (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.ChucVu> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vus where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vus where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vus where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vus from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vus where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vus where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vus where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vus.
	*
	* @return the number of chuc vus
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}