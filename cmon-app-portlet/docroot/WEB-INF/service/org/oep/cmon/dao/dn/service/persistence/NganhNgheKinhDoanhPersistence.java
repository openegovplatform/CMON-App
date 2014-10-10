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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;

/**
 * The persistence interface for the nganh nghe kinh doanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NganhNgheKinhDoanhPersistenceImpl
 * @see NganhNgheKinhDoanhUtil
 * @generated
 */
public interface NganhNgheKinhDoanhPersistence extends BasePersistence<NganhNgheKinhDoanh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NganhNgheKinhDoanhUtil} to access the nganh nghe kinh doanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the nganh nghe kinh doanh in the entity cache if it is enabled.
	*
	* @param nganhNgheKinhDoanh the nganh nghe kinh doanh
	*/
	public void cacheResult(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh);

	/**
	* Caches the nganh nghe kinh doanhs in the entity cache if it is enabled.
	*
	* @param nganhNgheKinhDoanhs the nganh nghe kinh doanhs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> nganhNgheKinhDoanhs);

	/**
	* Creates a new nganh nghe kinh doanh with the primary key. Does not add the nganh nghe kinh doanh to the database.
	*
	* @param id the primary key for the new nganh nghe kinh doanh
	* @return the new nganh nghe kinh doanh
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh create(long id);

	/**
	* Removes the nganh nghe kinh doanh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh updateImpl(
		org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh nganhNgheKinhDoanh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the nganh nghe kinh doanh with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException} if it could not be found.
	*
	* @param id the primary key of the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nganh nghe kinh doanh
	* @return the nganh nghe kinh doanh, or <code>null</code> if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the nganh nghe kinh doanhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nganh nghe kinh doanhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @return the range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nganh nghe kinh doanhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the last nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nganh nghe kinh doanh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException} if it could not be found.
	*
	* @param ma the ma
	* @param daXoa the da xoa
	* @return the matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByMa(
		java.lang.String ma, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @param daXoa the da xoa
	* @return the matching nganh nghe kinh doanh, or <code>null</code> if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh fetchByMa(
		java.lang.String ma, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param daXoa the da xoa
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching nganh nghe kinh doanh, or <code>null</code> if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh fetchByMa(
		java.lang.String ma, int daXoa, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @return the matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTen(
		java.lang.String ten, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @return the range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTen(
		java.lang.String ten, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByTen(
		java.lang.String ten, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByTen_First(
		java.lang.String ten, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the last nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByTen_Last(
		java.lang.String ten, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where ten = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nganh nghe kinh doanh
	* @param ten the ten
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh[] findByTen_PrevAndNext(
		long id, java.lang.String ten, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @return the matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByCap(
		long cap, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @return the range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByCap(
		long cap, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findByCap(
		long cap, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByCap_First(
		long cap, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the last nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a matching nganh nghe kinh doanh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh findByCap_Last(
		long cap, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns the nganh nghe kinh doanhs before and after the current nganh nghe kinh doanh in the ordered set where cap = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nganh nghe kinh doanh
	* @param cap the cap
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nganh nghe kinh doanh
	* @throws org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException if a nganh nghe kinh doanh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh[] findByCap_PrevAndNext(
		long id, long cap, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Returns all the nganh nghe kinh doanhs.
	*
	* @return the nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nganh nghe kinh doanhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @return the range of nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nganh nghe kinh doanhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nganh nghe kinh doanhs
	* @param end the upper bound of the range of nganh nghe kinh doanhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nganh nghe kinh doanhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the nganh nghe kinh doanh where ma = &#63; and daXoa = &#63; from the database.
	*
	* @param ma the ma
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchNganhNgheKinhDoanhException;

	/**
	* Removes all the nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63; from the database.
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63; from the database.
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCap(long cap, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nganh nghe kinh doanhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nganh nghe kinh doanhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nganh nghe kinh doanhs where ma = &#63; and daXoa = &#63;.
	*
	* @param ma the ma
	* @param daXoa the da xoa
	* @return the number of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nganh nghe kinh doanhs where ten = &#63; and daXoa = &#63;.
	*
	* @param ten the ten
	* @param daXoa the da xoa
	* @return the number of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nganh nghe kinh doanhs where cap = &#63; and daXoa = &#63;.
	*
	* @param cap the cap
	* @param daXoa the da xoa
	* @return the number of matching nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCap(long cap, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nganh nghe kinh doanhs.
	*
	* @return the number of nganh nghe kinh doanhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}