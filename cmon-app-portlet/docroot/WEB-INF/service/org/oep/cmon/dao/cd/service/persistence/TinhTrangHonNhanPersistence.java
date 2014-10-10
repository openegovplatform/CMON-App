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

import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;

/**
 * The persistence interface for the tinh trang hon nhan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TinhTrangHonNhanPersistenceImpl
 * @see TinhTrangHonNhanUtil
 * @generated
 */
public interface TinhTrangHonNhanPersistence extends BasePersistence<TinhTrangHonNhan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TinhTrangHonNhanUtil} to access the tinh trang hon nhan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tinh trang hon nhan in the entity cache if it is enabled.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	*/
	public void cacheResult(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan);

	/**
	* Caches the tinh trang hon nhans in the entity cache if it is enabled.
	*
	* @param tinhTrangHonNhans the tinh trang hon nhans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> tinhTrangHonNhans);

	/**
	* Creates a new tinh trang hon nhan with the primary key. Does not add the tinh trang hon nhan to the database.
	*
	* @param id the primary key for the new tinh trang hon nhan
	* @return the new tinh trang hon nhan
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan create(long id);

	/**
	* Removes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;

	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateImpl(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tinh trang hon nhan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException} if it could not be found.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;

	/**
	* Returns the tinh trang hon nhan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan, or <code>null</code> if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tinh trang hon nhans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tinh trang hon nhans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tinh trang hon nhans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;

	/**
	* Returns the last tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;

	/**
	* Returns the tinh trang hon nhans before and after the current tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tinh trang hon nhan
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.TinhTrangHonNhan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException;

	/**
	* Returns all the tinh trang hon nhans.
	*
	* @return the tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tinh trang hon nhans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tinh trang hon nhans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tinh trang hon nhans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tinh trang hon nhans.
	*
	* @return the number of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}