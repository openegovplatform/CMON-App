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

import org.oep.cmon.dao.cd.model.QuanHeGiaDinh;

/**
 * The persistence interface for the quan he gia dinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see QuanHeGiaDinhPersistenceImpl
 * @see QuanHeGiaDinhUtil
 * @generated
 */
public interface QuanHeGiaDinhPersistence extends BasePersistence<QuanHeGiaDinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuanHeGiaDinhUtil} to access the quan he gia dinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the quan he gia dinh in the entity cache if it is enabled.
	*
	* @param quanHeGiaDinh the quan he gia dinh
	*/
	public void cacheResult(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh);

	/**
	* Caches the quan he gia dinhs in the entity cache if it is enabled.
	*
	* @param quanHeGiaDinhs the quan he gia dinhs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> quanHeGiaDinhs);

	/**
	* Creates a new quan he gia dinh with the primary key. Does not add the quan he gia dinh to the database.
	*
	* @param id the primary key for the new quan he gia dinh
	* @return the new quan he gia dinh
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh create(long id);

	/**
	* Removes the quan he gia dinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the quan he gia dinh
	* @return the quan he gia dinh that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException;

	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh updateImpl(
		org.oep.cmon.dao.cd.model.QuanHeGiaDinh quanHeGiaDinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the quan he gia dinh with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException} if it could not be found.
	*
	* @param id the primary key of the quan he gia dinh
	* @return the quan he gia dinh
	* @throws org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException;

	/**
	* Returns the quan he gia dinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the quan he gia dinh
	* @return the quan he gia dinh, or <code>null</code> if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the quan he gia dinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the quan he gia dinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of quan he gia dinhs
	* @param end the upper bound of the range of quan he gia dinhs (not inclusive)
	* @return the range of matching quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the quan he gia dinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of quan he gia dinhs
	* @param end the upper bound of the range of quan he gia dinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first quan he gia dinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching quan he gia dinh
	* @throws org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException if a matching quan he gia dinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException;

	/**
	* Returns the last quan he gia dinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching quan he gia dinh
	* @throws org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException if a matching quan he gia dinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException;

	/**
	* Returns the quan he gia dinhs before and after the current quan he gia dinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current quan he gia dinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next quan he gia dinh
	* @throws org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException if a quan he gia dinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.QuanHeGiaDinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchQuanHeGiaDinhException;

	/**
	* Returns all the quan he gia dinhs.
	*
	* @return the quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the quan he gia dinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quan he gia dinhs
	* @param end the upper bound of the range of quan he gia dinhs (not inclusive)
	* @return the range of quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the quan he gia dinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quan he gia dinhs
	* @param end the upper bound of the range of quan he gia dinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.QuanHeGiaDinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the quan he gia dinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the quan he gia dinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of quan he gia dinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of quan he gia dinhs.
	*
	* @return the number of quan he gia dinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}