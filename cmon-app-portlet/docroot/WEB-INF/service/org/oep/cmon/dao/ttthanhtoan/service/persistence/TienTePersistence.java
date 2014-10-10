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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.ttthanhtoan.model.TienTe;

/**
 * The persistence interface for the tien te service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thanhdd
 * @see TienTePersistenceImpl
 * @see TienTeUtil
 * @generated
 */
public interface TienTePersistence extends BasePersistence<TienTe> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TienTeUtil} to access the tien te persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tien te in the entity cache if it is enabled.
	*
	* @param tienTe the tien te
	*/
	public void cacheResult(org.oep.cmon.dao.ttthanhtoan.model.TienTe tienTe);

	/**
	* Caches the tien tes in the entity cache if it is enabled.
	*
	* @param tienTes the tien tes
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> tienTes);

	/**
	* Creates a new tien te with the primary key. Does not add the tien te to the database.
	*
	* @param id the primary key for the new tien te
	* @return the new tien te
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe create(long id);

	/**
	* Removes the tien te with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tien te
	* @return the tien te that was removed
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	public org.oep.cmon.dao.ttthanhtoan.model.TienTe updateImpl(
		org.oep.cmon.dao.ttthanhtoan.model.TienTe tienTe, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tien te with the primary key or throws a {@link org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException} if it could not be found.
	*
	* @param id the primary key of the tien te
	* @return the tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the tien te with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tien te
	* @return the tien te, or <code>null</code> if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tien tes where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tien tes where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tien tes where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the last tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns all the tien tes where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tien tes where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tien tes where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the last tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns all the tien tes where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tien tes where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tien tes where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the last tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException;

	/**
	* Returns all the tien tes.
	*
	* @return the tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tien tes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tien tes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tien tes where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tien tes where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tien tes where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tien tes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tien tes where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tien tes where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tien tes where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tien tes.
	*
	* @return the number of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}