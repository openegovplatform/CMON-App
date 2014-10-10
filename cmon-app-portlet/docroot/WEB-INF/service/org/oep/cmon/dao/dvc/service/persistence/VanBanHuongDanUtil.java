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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dvc.model.VanBanHuongDan;

import java.util.List;

/**
 * The persistence utility for the van ban huong dan service. This utility wraps {@link VanBanHuongDanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see VanBanHuongDanPersistence
 * @see VanBanHuongDanPersistenceImpl
 * @generated
 */
public class VanBanHuongDanUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(VanBanHuongDan vanBanHuongDan) {
		getPersistence().clearCache(vanBanHuongDan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VanBanHuongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VanBanHuongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VanBanHuongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VanBanHuongDan update(VanBanHuongDan vanBanHuongDan,
		boolean merge) throws SystemException {
		return getPersistence().update(vanBanHuongDan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VanBanHuongDan update(VanBanHuongDan vanBanHuongDan,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vanBanHuongDan, merge, serviceContext);
	}

	/**
	* Caches the van ban huong dan in the entity cache if it is enabled.
	*
	* @param vanBanHuongDan the van ban huong dan
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan) {
		getPersistence().cacheResult(vanBanHuongDan);
	}

	/**
	* Caches the van ban huong dans in the entity cache if it is enabled.
	*
	* @param vanBanHuongDans the van ban huong dans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> vanBanHuongDans) {
		getPersistence().cacheResult(vanBanHuongDans);
	}

	/**
	* Creates a new van ban huong dan with the primary key. Does not add the van ban huong dan to the database.
	*
	* @param id the primary key for the new van ban huong dan
	* @return the new van ban huong dan
	*/
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the van ban huong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan updateImpl(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vanBanHuongDan, merge);
	}

	/**
	* Returns the van ban huong dan with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException} if it could not be found.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan
	* @throws org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the van ban huong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the van ban huong dan
	* @return the van ban huong dan, or <code>null</code> if a van ban huong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the van ban huong dans where noiLuuTruId = &#63;.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNoiLuuTruId(noiLuuTruId);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNoiLuuTruId(noiLuuTruId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByNoiLuuTruId(
		long noiLuuTruId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNoiLuuTruId(noiLuuTruId, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByNoiLuuTruId_First(
		long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByNoiLuuTruId_First(noiLuuTruId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByNoiLuuTruId_Last(
		long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByNoiLuuTruId_Last(noiLuuTruId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByNoiLuuTruId_PrevAndNext(
		long id, long noiLuuTruId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByNoiLuuTruId_PrevAndNext(id, noiLuuTruId,
			orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where tenTaiLieu = &#63;.
	*
	* @param tenTaiLieu the ten tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTenTaiLieu(tenTaiLieu);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTenTaiLieu(tenTaiLieu, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTenTaiLieu(
		java.lang.String tenTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTenTaiLieu(tenTaiLieu, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTenTaiLieu_First(
		java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByTenTaiLieu_First(tenTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTenTaiLieu_Last(
		java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByTenTaiLieu_Last(tenTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByTenTaiLieu_PrevAndNext(
		long id, java.lang.String tenTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByTenTaiLieu_PrevAndNext(id, tenTaiLieu,
			orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where loaiTaiLieu = &#63;.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoaiTaiLieu(loaiTaiLieu);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoaiTaiLieu(loaiTaiLieu, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByLoaiTaiLieu(
		long loaiTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLoaiTaiLieu(loaiTaiLieu, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByLoaiTaiLieu_First(
		long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByLoaiTaiLieu_First(loaiTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByLoaiTaiLieu_Last(
		long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByLoaiTaiLieu_Last(loaiTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByLoaiTaiLieu_PrevAndNext(
		long id, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByLoaiTaiLieu_PrevAndNext(id, loaiTaiLieu,
			orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThuTucHanhChinhId(thuTucHanhChinhId);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, start, end,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhId_First(thuTucHanhChinhId,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhId_Last(thuTucHanhChinhId,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhId_PrevAndNext(id, thuTucHanhChinhId,
			orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_First(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_First(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_Last(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_Last(thuTucHanhChinhId,
			loaiTaiLieu, daXoa, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa_PrevAndNext(id,
			thuTucHanhChinhId, loaiTaiLieu, daXoa, orderByComparator);
	}

	/**
	* Returns all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @return the matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_First(
		long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu_First(thuTucHanhChinhId,
			loaiTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan findByThuTucHanhChinhIdAndLoaiTaiLieu_Last(
		long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu_Last(thuTucHanhChinhId,
			loaiTaiLieu, orderByComparator);
	}

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
	public static org.oep.cmon.dao.dvc.model.VanBanHuongDan[] findByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(
		long id, long thuTucHanhChinhId, long loaiTaiLieu,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchVanBanHuongDanException {
		return getPersistence()
				   .findByThuTucHanhChinhIdAndLoaiTaiLieu_PrevAndNext(id,
			thuTucHanhChinhId, loaiTaiLieu, orderByComparator);
	}

	/**
	* Returns all the van ban huong dans.
	*
	* @return the van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.dvc.model.VanBanHuongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the van ban huong dans where noiLuuTruId = &#63; from the database.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Removes all the van ban huong dans where tenTaiLieu = &#63; from the database.
	*
	* @param tenTaiLieu the ten tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenTaiLieu(java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTenTaiLieu(tenTaiLieu);
	}

	/**
	* Removes all the van ban huong dans where loaiTaiLieu = &#63; from the database.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLoaiTaiLieu(long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLoaiTaiLieu(loaiTaiLieu);
	}

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Removes all the van ban huong dans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa);
	}

	/**
	* Removes all the van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu);
	}

	/**
	* Removes all the van ban huong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of van ban huong dans where noiLuuTruId = &#63;.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the number of van ban huong dans where tenTaiLieu = &#63;.
	*
	* @param tenTaiLieu the ten tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenTaiLieu(java.lang.String tenTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenTaiLieu(tenTaiLieu);
	}

	/**
	* Returns the number of van ban huong dans where loaiTaiLieu = &#63;.
	*
	* @param loaiTaiLieu the loai tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLoaiTaiLieu(long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLoaiTaiLieu(loaiTaiLieu);
	}

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the number of van ban huong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @param daXoa the da xoa
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(
		long thuTucHanhChinhId, long loaiTaiLieu, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTucHanhChinhIdAndLoaiTaiLieuDaXoa(thuTucHanhChinhId,
			loaiTaiLieu, daXoa);
	}

	/**
	* Returns the number of van ban huong dans where thuTucHanhChinhId = &#63; and loaiTaiLieu = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param loaiTaiLieu the loai tai lieu
	* @return the number of matching van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhIdAndLoaiTaiLieu(
		long thuTucHanhChinhId, long loaiTaiLieu)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTucHanhChinhIdAndLoaiTaiLieu(thuTucHanhChinhId,
			loaiTaiLieu);
	}

	/**
	* Returns the number of van ban huong dans.
	*
	* @return the number of van ban huong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VanBanHuongDanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VanBanHuongDanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					VanBanHuongDanPersistence.class.getName());

			ReferenceRegistry.registerReference(VanBanHuongDanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VanBanHuongDanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VanBanHuongDanUtil.class,
			"_persistence");
	}

	private static VanBanHuongDanPersistence _persistence;
}