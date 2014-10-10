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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.exch.dao.hoso.model.TrangThaiHoso;

/**
 * The persistence interface for the trang thai hoso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see TrangThaiHosoPersistenceImpl
 * @see TrangThaiHosoUtil
 * @generated
 */
public interface TrangThaiHosoPersistence extends BasePersistence<TrangThaiHoso> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrangThaiHosoUtil} to access the trang thai hoso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the trang thai hoso in the entity cache if it is enabled.
	*
	* @param trangThaiHoso the trang thai hoso
	*/
	public void cacheResult(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso);

	/**
	* Caches the trang thai hosos in the entity cache if it is enabled.
	*
	* @param trangThaiHosos the trang thai hosos
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> trangThaiHosos);

	/**
	* Creates a new trang thai hoso with the primary key. Does not add the trang thai hoso to the database.
	*
	* @param id the primary key for the new trang thai hoso
	* @return the new trang thai hoso
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso create(long id);

	/**
	* Removes the trang thai hoso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;

	public org.oep.exch.dao.hoso.model.TrangThaiHoso updateImpl(
		org.oep.exch.dao.hoso.model.TrangThaiHoso trangThaiHoso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException} if it could not be found.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;

	/**
	* Returns the trang thai hoso with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai hoso
	* @return the trang thai hoso, or <code>null</code> if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @return the range of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;

	/**
	* Returns the last trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a matching trang thai hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;

	/**
	* Returns the trang thai hosos before and after the current trang thai hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trang thai hoso
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai hoso
	* @throws org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException if a trang thai hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.TrangThaiHoso[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchTrangThaiHosoException;

	/**
	* Returns all the trang thai hosos.
	*
	* @return the trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @return the range of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai hosos
	* @param end the upper bound of the range of trang thai hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.TrangThaiHoso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai hosos where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai hosos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai hosos.
	*
	* @return the number of trang thai hosos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}