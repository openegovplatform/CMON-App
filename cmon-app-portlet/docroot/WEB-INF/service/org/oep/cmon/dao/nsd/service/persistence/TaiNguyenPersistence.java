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

package org.oep.cmon.dao.nsd.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.nsd.model.TaiNguyen;

/**
 * The persistence interface for the tai nguyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiNguyenPersistenceImpl
 * @see TaiNguyenUtil
 * @generated
 */
public interface TaiNguyenPersistence extends BasePersistence<TaiNguyen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaiNguyenUtil} to access the tai nguyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tai nguyen in the entity cache if it is enabled.
	*
	* @param taiNguyen the tai nguyen
	*/
	public void cacheResult(org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen);

	/**
	* Caches the tai nguyens in the entity cache if it is enabled.
	*
	* @param taiNguyens the tai nguyens
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> taiNguyens);

	/**
	* Creates a new tai nguyen with the primary key. Does not add the tai nguyen to the database.
	*
	* @param id the primary key for the new tai nguyen
	* @return the new tai nguyen
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen create(long id);

	/**
	* Removes the tai nguyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;

	public org.oep.cmon.dao.nsd.model.TaiNguyen updateImpl(
		org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai nguyen with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;

	/**
	* Returns the tai nguyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen, or <code>null</code> if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the matching tai nguyen
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen findByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen fetchByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.TaiNguyen fetchByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tai nguyens.
	*
	* @return the tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tai nguyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai nguyens
	* @param end the upper bound of the range of tai nguyens (not inclusive)
	* @return the range of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tai nguyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai nguyens
	* @param end the upper bound of the range of tai nguyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; from the database.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten, int loai,
		java.lang.String giaTri, java.lang.Long ungDungId,
		java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException;

	/**
	* Removes all the tai nguyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai nguyens where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63;.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the number of matching tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten, int loai,
		java.lang.String giaTri, java.lang.Long ungDungId,
		java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tai nguyens.
	*
	* @return the number of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}