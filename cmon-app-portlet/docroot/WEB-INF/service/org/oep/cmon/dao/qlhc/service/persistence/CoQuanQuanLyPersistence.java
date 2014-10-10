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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;

/**
 * The persistence interface for the co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanQuanLyPersistenceImpl
 * @see CoQuanQuanLyUtil
 * @generated
 */
public interface CoQuanQuanLyPersistence extends BasePersistence<CoQuanQuanLy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoQuanQuanLyUtil} to access the co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the co quan quan ly in the entity cache if it is enabled.
	*
	* @param coQuanQuanLy the co quan quan ly
	*/
	public void cacheResult(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy);

	/**
	* Caches the co quan quan lies in the entity cache if it is enabled.
	*
	* @param coQuanQuanLies the co quan quan lies
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> coQuanQuanLies);

	/**
	* Creates a new co quan quan ly with the primary key. Does not add the co quan quan ly to the database.
	*
	* @param id the primary key for the new co quan quan ly
	* @return the new co quan quan ly
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy create(long id);

	/**
	* Removes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException} if it could not be found.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly, or <code>null</code> if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the last co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCha_First(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the last co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCha_Last(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByCha_PrevAndNext(
		long id, java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCapCoQuanQuanLy_First(
		java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the last co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCapCoQuanQuanLy_Last(
		java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByCapCoQuanQuanLy_PrevAndNext(
		long id, java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findBydonViHanhChinhId_First(
		java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the last co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findBydonViHanhChinhId_Last(
		java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findBydonViHanhChinhId_PrevAndNext(
		long id, java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException;

	/**
	* Returns all the co quan quan lies.
	*
	* @return the co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan quan lies where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan quan lies where chaId = &#63; and daXoa = &#63; from the database.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCha(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63; from the database.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCapCoQuanQuanLy(java.lang.Long capCoQuanQuanlyId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydonViHanhChinhId(java.lang.Long donViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the co quan quan lies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCha(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCapCoQuanQuanLy(java.lang.Long capCoQuanQuanlyId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countBydonViHanhChinhId(java.lang.Long donViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of co quan quan lies.
	*
	* @return the number of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}