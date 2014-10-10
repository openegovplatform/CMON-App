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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;

/**
 * The persistence interface for the t t h c2 co quan quan ly service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2CoQuanQuanLyPersistenceImpl
 * @see TTHC2CoQuanQuanLyUtil
 * @generated
 */
public interface TTHC2CoQuanQuanLyPersistence extends BasePersistence<TTHC2CoQuanQuanLy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TTHC2CoQuanQuanLyUtil} to access the t t h c2 co quan quan ly persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the t t h c2 co quan quan ly in the entity cache if it is enabled.
	*
	* @param tthc2CoQuanQuanLy the t t h c2 co quan quan ly
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy tthc2CoQuanQuanLy);

	/**
	* Caches the t t h c2 co quan quan lies in the entity cache if it is enabled.
	*
	* @param tthc2CoQuanQuanLies the t t h c2 co quan quan lies
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> tthc2CoQuanQuanLies);

	/**
	* Creates a new t t h c2 co quan quan ly with the primary key. Does not add the t t h c2 co quan quan ly to the database.
	*
	* @param id the primary key for the new t t h c2 co quan quan ly
	* @return the new t t h c2 co quan quan ly
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy create(long id);

	/**
	* Removes the t t h c2 co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the t t h c2 co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException} if it could not be found.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the t t h c2 co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly, or <code>null</code> if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanQuanLyId_First(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanQuanLyId_Last(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByCoQuanQuanLyId_PrevAndNext(
		long id, long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_First(
		long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_Last(
		long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByCoQuanAndThuTuc_PrevAndNext(
		long id, long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException;

	/**
	* Returns all the t t h c2 co quan quan lies.
	*
	* @return the t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the t t h c2 co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 co quan quan lies where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the t t h c2 co quan quan lies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of t t h c2 co quan quan lies.
	*
	* @return the number of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}