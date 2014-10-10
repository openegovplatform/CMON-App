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

package org.oep.cmon.dao.hosohcc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

/**
 * The persistence interface for the ho so t t h c cong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongPersistenceImpl
 * @see HoSoTTHCCongUtil
 * @generated
 */
public interface HoSoTTHCCongPersistence extends BasePersistence<HoSoTTHCCong> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoSoTTHCCongUtil} to access the ho so t t h c cong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho so t t h c cong in the entity cache if it is enabled.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	*/
	public void cacheResult(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong);

	/**
	* Caches the ho so t t h c congs in the entity cache if it is enabled.
	*
	* @param hoSoTTHCCongs the ho so t t h c congs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> hoSoTTHCCongs);

	/**
	* Creates a new ho so t t h c cong with the primary key. Does not add the ho so t t h c cong to the database.
	*
	* @param id the primary key for the new ho so t t h c cong
	* @return the new ho so t t h c cong
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong create(long id);

	/**
	* Removes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException} if it could not be found.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong, or <code>null</code> if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoBienNhan_First(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoBienNhan_Last(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findBymaSoBienNhan_PrevAndNext(
		long id, java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where maSoHoSo = &#63;.
	*
	* @param maSoHoSo the ma so ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where maSoHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoHoSo the ma so ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where maSoHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoHoSo the ma so ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoHoSo the ma so ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoHoSo_First(
		java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoHoSo the ma so ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoHoSo_Last(
		java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where maSoHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param maSoHoSo the ma so ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findBymaSoHoSo_PrevAndNext(
		long id, java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByDV_PB_First(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByDV_PB_Last(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByDV_PB_PrevAndNext(
		long id, java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTenThuTucHanhChinh_First(
		java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTenThuTucHanhChinh_Last(
		java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where tenThuTucHanhChinh = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTenThuTucHanhChinh_PrevAndNext(
		long id, java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTen_DT_DD_First(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTen_DT_DD_Last(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTen_DT_DD_PrevAndNext(
		long id, java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where congDanNopId = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_First(
		java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_Last(
		java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByCongDanNopId_PrevAndNext(
		long id, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByThuTuc_CongDan_First(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByThuTuc_CongDan_Last(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByThuTuc_CongDan_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_TrangThai_First(
		java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_TrangThai_Last(
		java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByCongDanNopId_TrangThai_PrevAndNext(
		long id, java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where loaiHoSo = &#63;.
	*
	* @param loaiHoSo the loai ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where loaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHoSo the loai ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where loaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHoSo the loai ho so
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHoSo the loai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByLoaiHoSo_First(
		int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHoSo the loai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByLoaiHoSo_Last(
		int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where loaiHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param loaiHoSo the loai ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByLoaiHoSo_PrevAndNext(
		long id, int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTrangThaiHoSo_First(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the last ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a matching ho so t t h c cong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTrangThaiHoSo_Last(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns the ho so t t h c congs before and after the current ho so t t h c cong in the ordered set where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so t t h c cong
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTrangThaiHoSo_PrevAndNext(
		long id, int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException;

	/**
	* Returns all the ho so t t h c congs.
	*
	* @return the ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho so t t h c congs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @return the range of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho so t t h c congs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so t t h c congs
	* @param end the upper bound of the range of ho so t t h c congs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where maSoBienNhan = &#63; from the database.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where maSoHoSo = &#63; from the database.
	*
	* @param maSoHoSo the ma so ho so
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymaSoHoSo(java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63; from the database.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDV_PB(java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where tenThuTucHanhChinh = &#63; from the database.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTenThuTucHanhChinh(java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63; from the database.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTen_DT_DD(java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where congDanNopId = &#63; from the database.
	*
	* @param congDanNopId the cong dan nop ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCongDanNopId(java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTuc_CongDan(java.lang.Long thuTucHanhChinhId,
		java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63; from the database.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCongDanNopId_TrangThai(java.lang.Long congDanNopId,
		int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where loaiHoSo = &#63; from the database.
	*
	* @param loaiHoSo the loai ho so
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLoaiHoSo(int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63; from the database.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho so t t h c congs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where maSoHoSo = &#63;.
	*
	* @param maSoHoSo the ma so ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countBymaSoHoSo(java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByDV_PB(java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTenThuTucHanhChinh(java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTen_DT_DD(java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where congDanNopId = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCongDanNopId(java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTuc_CongDan(java.lang.Long thuTucHanhChinhId,
		java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCongDanNopId_TrangThai(java.lang.Long congDanNopId,
		int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where loaiHoSo = &#63;.
	*
	* @param loaiHoSo the loai ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByLoaiHoSo(int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho so t t h c congs.
	*
	* @return the number of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}