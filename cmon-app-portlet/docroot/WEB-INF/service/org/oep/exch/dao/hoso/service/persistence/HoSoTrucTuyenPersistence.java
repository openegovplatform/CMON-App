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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;

/**
 * The persistence interface for the ho so truc tuyen service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoTrucTuyenPersistenceImpl
 * @see HoSoTrucTuyenUtil
 * @generated
 */
public interface HoSoTrucTuyenPersistence extends BasePersistence<HoSoTrucTuyen> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoTrucTuyenUtil} to access the ho so truc tuyen persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho so truc tuyen in the entity cache if it is enabled.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	*/
	public void cacheResult(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen);

	/**
	* Caches the ho so truc tuyens in the entity cache if it is enabled.
	*
	* @param hoSoTrucTuyens the ho so truc tuyens
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> hoSoTrucTuyens);

	/**
	* Creates a new ho so truc tuyen with the primary key. Does not add the ho so truc tuyen to the database.
	*
	* @param id the primary key for the new ho so truc tuyen
	* @return the new ho so truc tuyen
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen create(long id);

	/**
	* Removes the ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException} if it could not be found.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns the ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen, or <code>null</code> if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @return the range of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByNoiChuyenHoSo_First(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns the last ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByNoiChuyenHoSo_Last(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns the ho so truc tuyens before and after the current ho so truc tuyen in the ordered set where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so truc tuyen
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen[] findByNoiChuyenHoSo_PrevAndNext(
		long id, java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @return the range of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByMaDonViTiepNhan_First(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns the last ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a matching ho so truc tuyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByMaDonViTiepNhan_Last(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns the ho so truc tuyens before and after the current ho so truc tuyen in the ordered set where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so truc tuyen
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.HoSoTrucTuyen[] findByMaDonViTiepNhan_PrevAndNext(
		long id, java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException;

	/**
	* Returns all the ho so truc tuyens.
	*
	* @return the ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @return the range of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so truc tuyens
	* @param end the upper bound of the range of ho so truc tuyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNoiChuyenHoSo(java.lang.String NoiChuyenHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMaDonViTiepNhan(java.lang.String MaDonViTiepNhan,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so truc tuyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int countByNoiChuyenHoSo(java.lang.String NoiChuyenHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int countByMaDonViTiepNhan(java.lang.String MaDonViTiepNhan,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so truc tuyens.
	*
	* @return the number of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}