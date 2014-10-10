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

import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;

/**
 * The persistence interface for the ho so anh xa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoAnhXaPersistenceImpl
 * @see HoSoAnhXaUtil
 * @generated
 */
public interface HoSoAnhXaPersistence extends BasePersistence<HoSoAnhXa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoAnhXaUtil} to access the ho so anh xa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho so anh xa in the entity cache if it is enabled.
	*
	* @param hoSoAnhXa the ho so anh xa
	*/
	public void cacheResult(org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa);

	/**
	* Caches the ho so anh xas in the entity cache if it is enabled.
	*
	* @param hoSoAnhXas the ho so anh xas
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> hoSoAnhXas);

	/**
	* Creates a new ho so anh xa with the primary key. Does not add the ho so anh xa to the database.
	*
	* @param id the primary key for the new ho so anh xa
	* @return the new ho so anh xa
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa create(long id);

	/**
	* Removes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns the ho so anh xa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa, or <code>null</code> if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param id the ID
	* @return the matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so anh xas where maHoSo = &#63;.
	*
	* @param maHoSo the ma ho so
	* @return the matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so anh xas where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so anh xas where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByMaHoSo_First(
		java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns the last ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByMaHoSo_Last(
		java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns the ho so anh xas before and after the current ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so anh xa
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa[] findByMaHoSo_PrevAndNext(
		long id, java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Returns all the ho so anh xas.
	*
	* @return the ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the ho so anh xa where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Removes the ho so anh xa where hoSoTTHCCongId = &#63; from the database.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException;

	/**
	* Removes all the ho so anh xas where maHoSo = &#63; from the database.
	*
	* @param maHoSo the ma ho so
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaHoSo(java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so anh xas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so anh xas where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so anh xas where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so anh xas where maHoSo = &#63;.
	*
	* @param maHoSo the ma ho so
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaHoSo(java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so anh xas.
	*
	* @return the number of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}