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

import org.oep.cmon.dao.nsd.model.VaiTro;

/**
 * The persistence interface for the vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see VaiTroPersistenceImpl
 * @see VaiTroUtil
 * @generated
 */
public interface VaiTroPersistence extends BasePersistence<VaiTro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VaiTroUtil} to access the vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the vai tro in the entity cache if it is enabled.
	*
	* @param vaiTro the vai tro
	*/
	public void cacheResult(org.oep.cmon.dao.nsd.model.VaiTro vaiTro);

	/**
	* Caches the vai tros in the entity cache if it is enabled.
	*
	* @param vaiTros the vai tros
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> vaiTros);

	/**
	* Creates a new vai tro with the primary key. Does not add the vai tro to the database.
	*
	* @param id the primary key for the new vai tro
	* @return the new vai tro
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro create(long id);

	/**
	* Removes the vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	public org.oep.cmon.dao.nsd.model.VaiTro updateImpl(
		org.oep.cmon.dao.nsd.model.VaiTro vaiTro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro, or <code>null</code> if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vai tros where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vai tros where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the last vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro[] findByMa_PrevAndNext(long id,
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns all the vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vai tros where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vai tros where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the last vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro[] findByTen_PrevAndNext(long id,
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns all the vai tros where moTa = &#63;.
	*
	* @param moTa the mo ta
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vai tros where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vai tros where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByMoTa_First(
		java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the last vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByMoTa_Last(
		java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro[] findByMoTa_PrevAndNext(long id,
		java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tro where ma = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro fetchByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro fetchByByMa(java.lang.String ma,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vai tro where ten = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro fetchByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro fetchByByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByTrangThai_First(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the last vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro findByTrangThai_Last(int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.nsd.model.VaiTro[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Returns all the vai tros.
	*
	* @return the vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vai tros where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vai tros where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vai tros where moTa = &#63; from the database.
	*
	* @param moTa the mo ta
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMoTa(java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the vai tro where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Removes the vai tro where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException;

	/**
	* Removes all the vai tros where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vai tros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where moTa = &#63;.
	*
	* @param moTa the mo ta
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByMoTa(java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vai tros.
	*
	* @return the number of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}