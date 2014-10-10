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

import org.oep.cmon.dao.cd.model.TrinhDoChuyenMon;

/**
 * The persistence interface for the trinh do chuyen mon service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TrinhDoChuyenMonPersistenceImpl
 * @see TrinhDoChuyenMonUtil
 * @generated
 */
public interface TrinhDoChuyenMonPersistence extends BasePersistence<TrinhDoChuyenMon> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrinhDoChuyenMonUtil} to access the trinh do chuyen mon persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the trinh do chuyen mon in the entity cache if it is enabled.
	*
	* @param trinhDoChuyenMon the trinh do chuyen mon
	*/
	public void cacheResult(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon);

	/**
	* Caches the trinh do chuyen mons in the entity cache if it is enabled.
	*
	* @param trinhDoChuyenMons the trinh do chuyen mons
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> trinhDoChuyenMons);

	/**
	* Creates a new trinh do chuyen mon with the primary key. Does not add the trinh do chuyen mon to the database.
	*
	* @param id the primary key for the new trinh do chuyen mon
	* @return the new trinh do chuyen mon
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon create(long id);

	/**
	* Removes the trinh do chuyen mon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @return the trinh do chuyen mon that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;

	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon updateImpl(
		org.oep.cmon.dao.cd.model.TrinhDoChuyenMon trinhDoChuyenMon,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trinh do chuyen mon with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException} if it could not be found.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @return the trinh do chuyen mon
	* @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;

	/**
	* Returns the trinh do chuyen mon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trinh do chuyen mon
	* @return the trinh do chuyen mon, or <code>null</code> if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the trinh do chuyen mons where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trinh do chuyen mons where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @return the range of matching trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trinh do chuyen mons where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first trinh do chuyen mon in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trinh do chuyen mon
	* @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a matching trinh do chuyen mon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;

	/**
	* Returns the last trinh do chuyen mon in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trinh do chuyen mon
	* @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a matching trinh do chuyen mon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;

	/**
	* Returns the trinh do chuyen mons before and after the current trinh do chuyen mon in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trinh do chuyen mon
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trinh do chuyen mon
	* @throws org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException if a trinh do chuyen mon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TrinhDoChuyenMon[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTrinhDoChuyenMonException;

	/**
	* Returns all the trinh do chuyen mons.
	*
	* @return the trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trinh do chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @return the range of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trinh do chuyen mons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trinh do chuyen mons
	* @param end the upper bound of the range of trinh do chuyen mons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TrinhDoChuyenMon> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trinh do chuyen mons where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trinh do chuyen mons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trinh do chuyen mons where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trinh do chuyen mons.
	*
	* @return the number of trinh do chuyen mons
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}