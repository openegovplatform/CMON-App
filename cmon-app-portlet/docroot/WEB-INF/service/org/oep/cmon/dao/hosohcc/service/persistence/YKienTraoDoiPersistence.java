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

package org.oep.cmon.dao.hosohcc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;

/**
 * The persistence interface for the y kien trao doi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see YKienTraoDoiPersistenceImpl
 * @see YKienTraoDoiUtil
 * @generated
 */
public interface YKienTraoDoiPersistence extends BasePersistence<YKienTraoDoi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link YKienTraoDoiUtil} to access the y kien trao doi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the y kien trao doi in the entity cache if it is enabled.
	*
	* @param yKienTraoDoi the y kien trao doi
	*/
	public void cacheResult(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi);

	/**
	* Caches the y kien trao dois in the entity cache if it is enabled.
	*
	* @param yKienTraoDois the y kien trao dois
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> yKienTraoDois);

	/**
	* Creates a new y kien trao doi with the primary key. Does not add the y kien trao doi to the database.
	*
	* @param id the primary key for the new y kien trao doi
	* @return the new y kien trao doi
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi create(long id);

	/**
	* Removes the y kien trao doi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateImpl(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the y kien trao doi with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException} if it could not be found.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns the y kien trao doi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi, or <code>null</code> if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the y kien trao dois where loai = &#63;.
	*
	* @param loai the loai
	* @return the matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y kien trao dois where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y kien trao dois where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByLoai_First(
		long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns the last y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByLoai_Last(
		long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current y kien trao doi
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi[] findByLoai_PrevAndNext(
		long id, long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns all the y kien trao dois where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y kien trao dois where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y kien trao dois where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByTrangThai_First(
		long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns the last y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByTrangThai_Last(
		long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current y kien trao doi
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.YKienTraoDoi[] findByTrangThai_PrevAndNext(
		long id, long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException;

	/**
	* Returns all the y kien trao dois.
	*
	* @return the y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the y kien trao dois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the y kien trao dois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y kien trao dois where loai = &#63; from the database.
	*
	* @param loai the loai
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLoai(long loai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y kien trao dois where trangThai = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the y kien trao dois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y kien trao dois where loai = &#63;.
	*
	* @param loai the loai
	* @return the number of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public int countByLoai(long loai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y kien trao dois where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the number of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of y kien trao dois.
	*
	* @return the number of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}