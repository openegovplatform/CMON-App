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

package org.oep.cmon.dao.tlct.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;

/**
 * The persistence interface for the danh muc giay to service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DanhMucGiayToPersistenceImpl
 * @see DanhMucGiayToUtil
 * @generated
 */
public interface DanhMucGiayToPersistence extends BasePersistence<DanhMucGiayTo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhMucGiayToUtil} to access the danh muc giay to persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh muc giay to in the entity cache if it is enabled.
	*
	* @param danhMucGiayTo the danh muc giay to
	*/
	public void cacheResult(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo);

	/**
	* Caches the danh muc giay tos in the entity cache if it is enabled.
	*
	* @param danhMucGiayTos the danh muc giay tos
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> danhMucGiayTos);

	/**
	* Creates a new danh muc giay to with the primary key. Does not add the danh muc giay to to the database.
	*
	* @param id the primary key for the new danh muc giay to
	* @return the new danh muc giay to
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo create(long id);

	/**
	* Removes the danh muc giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to that was removed
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateImpl(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc giay to with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns the danh muc giay to with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to, or <code>null</code> if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc giay to where ma = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc giay to where ma = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh muc giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh muc giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh muc giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns the last danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns the danh muc giay tos before and after the current danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current danh muc giay to
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.tlct.model.DanhMucGiayTo[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Returns all the danh muc giay tos.
	*
	* @return the danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the danh muc giay to where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Removes the danh muc giay to where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException;

	/**
	* Removes all the danh muc giay tos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the danh muc giay tos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc giay tos where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc giay tos where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh muc giay tos.
	*
	* @return the number of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}