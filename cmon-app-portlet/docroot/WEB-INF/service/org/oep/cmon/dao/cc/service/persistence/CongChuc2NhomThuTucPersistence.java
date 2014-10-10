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

import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;

/**
 * The persistence interface for the cong chuc2 nhom thu tuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChuc2NhomThuTucPersistenceImpl
 * @see CongChuc2NhomThuTucUtil
 * @generated
 */
public interface CongChuc2NhomThuTucPersistence extends BasePersistence<CongChuc2NhomThuTuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CongChuc2NhomThuTucUtil} to access the cong chuc2 nhom thu tuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cong chuc2 nhom thu tuc in the entity cache if it is enabled.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	*/
	public void cacheResult(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc);

	/**
	* Caches the cong chuc2 nhom thu tucs in the entity cache if it is enabled.
	*
	* @param congChuc2NhomThuTucs the cong chuc2 nhom thu tucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> congChuc2NhomThuTucs);

	/**
	* Creates a new cong chuc2 nhom thu tuc with the primary key. Does not add the cong chuc2 nhom thu tuc to the database.
	*
	* @param id the primary key for the new cong chuc2 nhom thu tuc
	* @return the new cong chuc2 nhom thu tuc
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc create(long id);

	/**
	* Removes the cong chuc2 nhom thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc that was removed
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc updateImpl(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc2 nhom thu tuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the cong chuc2 nhom thu tuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc, or <code>null</code> if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param id the ID
	* @return the matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @return the matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @return the range of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChuc_First(
		long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the last cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChuc_Last(
		long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the cong chuc2 nhom thu tucs before and after the current cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc2 nhom thu tuc
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc[] findByCongChuc_PrevAndNext(
		long id, long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cong chuc2 nhom thu tucs.
	*
	* @return the cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cong chuc2 nhom thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @return the range of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cong chuc2 nhom thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cong chuc2 nhom thu tuc where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Removes all the cong chuc2 nhom thu tucs where congChucId = &#63; from the database.
	*
	* @param congChucId the cong chuc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCongChuc(long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; from the database.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException;

	/**
	* Removes all the cong chuc2 nhom thu tucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chuc2 nhom thu tucs where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCongChuc(long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63; and nhomThuTucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCongChucAndNhomThuTuc(long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cong chuc2 nhom thu tucs.
	*
	* @return the number of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}