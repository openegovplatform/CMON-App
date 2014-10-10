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

import org.oep.cmon.dao.nsd.model.NhomNguoiDung;

/**
 * The persistence interface for the nhom nguoi dung service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NhomNguoiDungPersistenceImpl
 * @see NhomNguoiDungUtil
 * @generated
 */
public interface NhomNguoiDungPersistence extends BasePersistence<NhomNguoiDung> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NhomNguoiDungUtil} to access the nhom nguoi dung persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the nhom nguoi dung in the entity cache if it is enabled.
	*
	* @param nhomNguoiDung the nhom nguoi dung
	*/
	public void cacheResult(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung);

	/**
	* Caches the nhom nguoi dungs in the entity cache if it is enabled.
	*
	* @param nhomNguoiDungs the nhom nguoi dungs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> nhomNguoiDungs);

	/**
	* Creates a new nhom nguoi dung with the primary key. Does not add the nhom nguoi dung to the database.
	*
	* @param id the primary key for the new nhom nguoi dung
	* @return the new nhom nguoi dung
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung create(long id);

	/**
	* Removes the nhom nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom nguoi dung
	* @return the nhom nguoi dung that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	public org.oep.cmon.dao.nsd.model.NhomNguoiDung updateImpl(
		org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the nhom nguoi dung with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException} if it could not be found.
	*
	* @param id the primary key of the nhom nguoi dung
	* @return the nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns the nhom nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nhom nguoi dung
	* @return the nhom nguoi dung, or <code>null</code> if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the nhom nguoi dungs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nhom nguoi dungs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @return the range of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nhom nguoi dungs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first nhom nguoi dung in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns the last nhom nguoi dung in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns the nhom nguoi dungs before and after the current nhom nguoi dung in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nhom nguoi dung
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns all the nhom nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nhom nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @return the range of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nhom nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first nhom nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns the last nhom nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a matching nhom nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns the nhom nguoi dungs before and after the current nhom nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nhom nguoi dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nhom nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException if a nhom nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.NhomNguoiDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNhomNguoiDungException;

	/**
	* Returns all the nhom nguoi dungs.
	*
	* @return the nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the nhom nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @return the range of nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the nhom nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nhom nguoi dungs
	* @param end the upper bound of the range of nhom nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.NhomNguoiDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nhom nguoi dungs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nhom nguoi dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the nhom nguoi dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nhom nguoi dungs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nhom nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of nhom nguoi dungs.
	*
	* @return the number of nhom nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}