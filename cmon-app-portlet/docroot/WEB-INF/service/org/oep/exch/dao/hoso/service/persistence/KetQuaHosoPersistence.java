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

import org.oep.exch.dao.hoso.model.KetQuaHoso;

/**
 * The persistence interface for the ket qua hoso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see KetQuaHosoPersistenceImpl
 * @see KetQuaHosoUtil
 * @generated
 */
public interface KetQuaHosoPersistence extends BasePersistence<KetQuaHoso> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KetQuaHosoUtil} to access the ket qua hoso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ket qua hoso in the entity cache if it is enabled.
	*
	* @param ketQuaHoso the ket qua hoso
	*/
	public void cacheResult(org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso);

	/**
	* Caches the ket qua hosos in the entity cache if it is enabled.
	*
	* @param ketQuaHosos the ket qua hosos
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> ketQuaHosos);

	/**
	* Creates a new ket qua hoso with the primary key. Does not add the ket qua hoso to the database.
	*
	* @param id the primary key for the new ket qua hoso
	* @return the new ket qua hoso
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso create(long id);

	/**
	* Removes the ket qua hoso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;

	public org.oep.exch.dao.hoso.model.KetQuaHoso updateImpl(
		org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ket qua hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchKetQuaHosoException} if it could not be found.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;

	/**
	* Returns the ket qua hoso with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso, or <code>null</code> if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @return the range of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;

	/**
	* Returns the last ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;

	/**
	* Returns the ket qua hosos before and after the current ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ket qua hoso
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.KetQuaHoso[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException;

	/**
	* Returns all the ket qua hosos.
	*
	* @return the ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ket qua hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @return the range of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ket qua hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ket qua hosos where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ket qua hosos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ket qua hosos.
	*
	* @return the number of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}