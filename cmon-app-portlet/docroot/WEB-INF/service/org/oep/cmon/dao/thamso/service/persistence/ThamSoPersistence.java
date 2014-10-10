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

import org.oep.cmon.dao.thamso.model.ThamSo;

/**
 * The persistence interface for the tham so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ThamSoPersistenceImpl
 * @see ThamSoUtil
 * @generated
 */
public interface ThamSoPersistence extends BasePersistence<ThamSo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThamSoUtil} to access the tham so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tham so in the entity cache if it is enabled.
	*
	* @param thamSo the tham so
	*/
	public void cacheResult(org.oep.cmon.dao.thamso.model.ThamSo thamSo);

	/**
	* Caches the tham sos in the entity cache if it is enabled.
	*
	* @param thamSos the tham sos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> thamSos);

	/**
	* Creates a new tham so with the primary key. Does not add the tham so to the database.
	*
	* @param Id the primary key for the new tham so
	* @return the new tham so
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo create(long Id);

	/**
	* Removes the tham so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the tham so
	* @return the tham so that was removed
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo remove(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	public org.oep.cmon.dao.thamso.model.ThamSo updateImpl(
		org.oep.cmon.dao.thamso.model.ThamSo thamSo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tham so with the primary key or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	*
	* @param Id the primary key of the tham so
	* @return the tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo findByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the tham so with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Id the primary key of the tham so
	* @return the tham so, or <code>null</code> if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo fetchByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tham so where Ten = &#63; or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	*
	* @param Ten the ten
	* @return the matching tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo findByTen(java.lang.String Ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the tham so where Ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param Ten the ten
	* @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo fetchByTen(java.lang.String Ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tham so where Ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param Ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo fetchByTen(
		java.lang.String Ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tham sos where DaXoa = &#63;.
	*
	* @param DaXoa the da xoa
	* @return the matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findByDaXoa(
		int DaXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tham sos where DaXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param DaXoa the da xoa
	* @param start the lower bound of the range of tham sos
	* @param end the upper bound of the range of tham sos (not inclusive)
	* @return the range of matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findByDaXoa(
		int DaXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tham sos where DaXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param DaXoa the da xoa
	* @param start the lower bound of the range of tham sos
	* @param end the upper bound of the range of tham sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findByDaXoa(
		int DaXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tham so in the ordered set where DaXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param DaXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo findByDaXoa_First(int DaXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the last tham so in the ordered set where DaXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param DaXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo findByDaXoa_Last(int DaXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the tham sos before and after the current tham so in the ordered set where DaXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current tham so
	* @param DaXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a tham so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo[] findByDaXoa_PrevAndNext(
		long Id, int DaXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the tham so where giaTri = &#63; or throws a {@link org.oep.cmon.dao.thamso.NoSuchThamSoException} if it could not be found.
	*
	* @param giaTri the gia tri
	* @return the matching tham so
	* @throws org.oep.cmon.dao.thamso.NoSuchThamSoException if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo findByGiaTri(
		java.lang.String giaTri)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Returns the tham so where giaTri = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param giaTri the gia tri
	* @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo fetchByGiaTri(
		java.lang.String giaTri)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tham so where giaTri = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param giaTri the gia tri
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tham so, or <code>null</code> if a matching tham so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.thamso.model.ThamSo fetchByGiaTri(
		java.lang.String giaTri, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tham sos.
	*
	* @return the tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tham sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tham sos
	* @param end the upper bound of the range of tham sos (not inclusive)
	* @return the range of tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tham sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tham sos
	* @param end the upper bound of the range of tham sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tham sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.thamso.model.ThamSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tham so where Ten = &#63; from the database.
	*
	* @param Ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String Ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Removes all the tham sos where DaXoa = &#63; from the database.
	*
	* @param DaXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDaXoa(int DaXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tham so where giaTri = &#63; from the database.
	*
	* @param giaTri the gia tri
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGiaTri(java.lang.String giaTri)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchThamSoException;

	/**
	* Removes all the tham sos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tham sos where Ten = &#63;.
	*
	* @param Ten the ten
	* @return the number of matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String Ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tham sos where DaXoa = &#63;.
	*
	* @param DaXoa the da xoa
	* @return the number of matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public int countByDaXoa(int DaXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tham sos where giaTri = &#63;.
	*
	* @param giaTri the gia tri
	* @return the number of matching tham sos
	* @throws SystemException if a system exception occurred
	*/
	public int countByGiaTri(java.lang.String giaTri)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tham sos.
	*
	* @return the number of tham sos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}