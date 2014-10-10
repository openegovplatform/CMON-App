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

import org.oep.cmon.dao.dvc.model.VanBanHuongDan;

/**
 * The persistence interface for the van ban huong dan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see VanBanHuongDanPersistenceImpl
 * @see VanBanHuongDanUtil
 * @generated
 */
public interface VanBanHuongDanPersistence extends BasePersistence<VanBanHuongDan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VanBanHuongDanUtil} to access the van ban huong dan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the van ban huong dan in the entity cache if it is enabled.
	*
	* @param vanBanHuongDan the van ban huong dan
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan);

	/**
	* Caches the van ban huong dans in the entity cache if it is enabled.
	*
	* @param vanBanHuongDans the van ban huong dans
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> vanBanHuongDans);

	/**
	* Creates a new van ban huong dan with the primary key. Does not add the van ban huong dan to the database.
	*
	* @param id the primary key for the new van ban huong dan
	* @return the new van ban huong dan
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan create(long id);

	/**
	* Removes the van ban huong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	public org.oep.cmon.dao.dvc.model.VanBanHuongDan updateImpl(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the van ban huong dan with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException} if it could not be found.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan, or <code>null</code> if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the van ban huong dans where noiLuuTruId = &#63;.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where noiLuuTruId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruId the noi luu tru ID
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where noiLuuTruId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruId the noi luu tru ID
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruId the noi luu tru ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByNoiLuuTruId_First(
		long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruId the noi luu tru ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByNoiLuuTruId_Last(
		long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where noiLuuTruId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param noiLuuTruId the noi luu tru ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByNoiLuuTruId_PrevAndNext(
		long id, long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where tenTaiLieu = &#63;.
	*
	* @param tenTaiLieu the ten tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where tenTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenTaiLieu the ten tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where tenTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenTaiLieu the ten tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenTaiLieu the ten tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTenTaiLieu_First(
		java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenTaiLieu the ten tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTenTaiLieu_Last(
		java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where tenTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param tenTaiLieu the ten tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByTenTaiLieu_PrevAndNext(
		long id, java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where loaiTaiLieu = &#63;.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiTaiLieu the loai tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiTaiLieu the loai tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByLoaiTaiLieu_First(
		long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByLoaiTaiLieu_Last(
		long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByLoaiTaiLieu_PrevAndNext(
		long id, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_First(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_Last(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_First(
		long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the last van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a matching van ban huong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_Last(
		long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns the van ban huong dans before and after the current van ban huong dan in the ordered set where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current van ban huong dan
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException;

	/**
	* Returns all the van ban huong dans.
	*
	* @return the van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the van ban huong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @return the range of van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the van ban huong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of van ban huong dans
	* @param end the upper bound of the range of van ban huong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where noiLuuTruId = &#63; from the database.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where tenTaiLieu = &#63; from the database.
	*
	* @param tenTaiLieu the ten tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTenTaiLieu(java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where loaiTaiLieu = &#63; from the database.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLoaiTaiLieu(long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public void removeByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the van ban huong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where noiLuuTruId = &#63;.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByNoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where tenTaiLieu = &#63;.
	*
	* @param tenTaiLieu the ten tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTenTaiLieu(java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where loaiTaiLieu = &#63;.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByLoaiTaiLieu(long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countByThuTucHanhChinhIdAndLoaiTaiLieu(long thuTucHanhChinhId,
		long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of van ban huong dans.
	*
	* @return the number of van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}