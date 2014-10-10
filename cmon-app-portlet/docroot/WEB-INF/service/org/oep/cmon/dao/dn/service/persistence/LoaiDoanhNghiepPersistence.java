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

import org.oep.cmon.dao.dn.model.LoaiDoanhNghiep;

/**
 * The persistence interface for the loai doanh nghiep service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see LoaiDoanhNghiepPersistenceImpl
 * @see LoaiDoanhNghiepUtil
 * @generated
 */
public interface LoaiDoanhNghiepPersistence extends BasePersistence<LoaiDoanhNghiep> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoaiDoanhNghiepUtil} to access the loai doanh nghiep persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the loai doanh nghiep in the entity cache if it is enabled.
	*
	* @param loaiDoanhNghiep the loai doanh nghiep
	*/
	public void cacheResult(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep);

	/**
	* Caches the loai doanh nghieps in the entity cache if it is enabled.
	*
	* @param loaiDoanhNghieps the loai doanh nghieps
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> loaiDoanhNghieps);

	/**
	* Creates a new loai doanh nghiep with the primary key. Does not add the loai doanh nghiep to the database.
	*
	* @param id the primary key for the new loai doanh nghiep
	* @return the new loai doanh nghiep
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep create(long id);

	/**
	* Removes the loai doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loai doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Returns the loai doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the loai doanh nghiep
	* @return the loai doanh nghiep, or <code>null</code> if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loai doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loai doanh nghieps where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loai doanh nghieps where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Returns the last loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Returns the loai doanh nghieps before and after the current loai doanh nghiep in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current loai doanh nghiep
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a loai doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Returns the loai doanh nghiep where ten = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching loai doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Returns the loai doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching loai doanh nghiep, or <code>null</code> if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loai doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loai doanh nghiep, or <code>null</code> if a matching loai doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loai doanh nghieps.
	*
	* @return the loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @return the range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loai doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of loai doanh nghieps
	* @param end the upper bound of the range of loai doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loai doanh nghieps where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loai doanh nghiep where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchLoaiDoanhNghiepException;

	/**
	* Removes all the loai doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loai doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loai doanh nghieps where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loai doanh nghieps.
	*
	* @return the number of loai doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}