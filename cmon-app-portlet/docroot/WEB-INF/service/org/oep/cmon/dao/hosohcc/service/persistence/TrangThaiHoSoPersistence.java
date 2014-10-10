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

import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;

/**
 * The persistence interface for the trang thai ho so service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see TrangThaiHoSoPersistenceImpl
 * @see TrangThaiHoSoUtil
 * @generated
 */
public interface TrangThaiHoSoPersistence extends BasePersistence<TrangThaiHoSo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrangThaiHoSoUtil} to access the trang thai ho so persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the trang thai ho so in the entity cache if it is enabled.
	*
	* @param trangThaiHoSo the trang thai ho so
	*/
	public void cacheResult(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo);

	/**
	* Caches the trang thai ho sos in the entity cache if it is enabled.
	*
	* @param trangThaiHoSos the trang thai ho sos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> trangThaiHoSos);

	/**
	* Creates a new trang thai ho so with the primary key. Does not add the trang thai ho so to the database.
	*
	* @param id the primary key for the new trang thai ho so
	* @return the new trang thai ho so
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo create(long id);

	/**
	* Removes the trang thai ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo updateImpl(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai ho so with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Returns the trang thai ho so with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so, or <code>null</code> if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai ho so where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	*
	* @param id the ID
	* @return the matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the trang thai ho sos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai ho sos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @return the range of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai ho sos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByTrangThaiHoSo_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Returns the last trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByTrangThaiHoSo_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Returns the trang thai ho sos before and after the current trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trang thai ho so
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo[] findByTrangThaiHoSo_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Returns all the trang thai ho sos.
	*
	* @return the trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @return the range of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the trang thai ho so where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException;

	/**
	* Removes all the trang thai ho sos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThaiHoSo(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai ho sos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai ho sos where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai ho sos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThaiHoSo(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai ho sos.
	*
	* @return the number of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}