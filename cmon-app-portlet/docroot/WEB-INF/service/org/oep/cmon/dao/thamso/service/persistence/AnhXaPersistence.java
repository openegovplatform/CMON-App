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

package org.oep.cmon.dao.thamso.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.thamso.model.AnhXa;

/**
 * The persistence interface for the anh xa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see AnhXaPersistenceImpl
 * @see AnhXaUtil
 * @generated
 */
public interface AnhXaPersistence extends BasePersistence<AnhXa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnhXaUtil} to access the anh xa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the anh xa in the entity cache if it is enabled.
	*
	* @param anhXa the anh xa
	*/
	public void cacheResult(org.oep.cmon.dao.thamso.model.AnhXa anhXa);

	/**
	* Caches the anh xas in the entity cache if it is enabled.
	*
	* @param anhXas the anh xas
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> anhXas);

	/**
	* Creates a new anh xa with the primary key. Does not add the anh xa to the database.
	*
	* @param Id the primary key for the new anh xa
	* @return the new anh xa
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa create(long Id);

	/**
	* Removes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa that was removed
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa remove(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	public org.oep.cmon.dao.thamso.model.AnhXa updateImpl(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the anh xa with the primary key or throws a {@link org.oep.cmon.dao.thamso.NoSuchAnhXaException} if it could not be found.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the anh xa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa, or <code>null</code> if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa fetchByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the anh xas where UngDungId = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh xas where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUngDung_First(
		long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUngDung_Last(
		long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa[] findByUngDung_PrevAndNext(
		long Id, long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns all the anh xas where tenBang = &#63;.
	*
	* @param tenBang the ten bang
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh xas where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh xas where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findBytenBang_First(
		java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the last anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findBytenBang_Last(
		java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa[] findBytenBang_PrevAndNext(
		long Id, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_First(
		long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_Last(
		long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa[] findByUD_TB_PrevAndNext(
		long Id, long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_MaDNG_First(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_MaDNG_Last(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.AnhXa[] findByUD_TB_MaDNG_PrevAndNext(
		long Id, long UngDungId, java.lang.String tenBang,
		java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException;

	/**
	* Returns all the anh xas.
	*
	* @return the anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh xas where UngDungId = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUngDung(long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh xas where tenBang = &#63; from the database.
	*
	* @param tenBang the ten bang
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytenBang(java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUD_TB(long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUD_TB_MaDNG(long UngDungId, java.lang.String tenBang,
		java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the anh xas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas where UngDungId = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUngDung(long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas where tenBang = &#63;.
	*
	* @param tenBang the ten bang
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countBytenBang(java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUD_TB(long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countByUD_TB_MaDNG(long UngDungId, java.lang.String tenBang,
		java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of anh xas.
	*
	* @return the number of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}