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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dn.model.DoanhNghiep;

import java.util.List;

/**
 * The persistence utility for the doanh nghiep service. This utility wraps {@link DoanhNghiepPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiepPersistence
 * @see DoanhNghiepPersistenceImpl
 * @generated
 */
public class DoanhNghiepUtil {
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
	public static void clearCache(DoanhNghiep doanhNghiep) {
		getPersistence().clearCache(doanhNghiep);
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
	public static List<DoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DoanhNghiep update(DoanhNghiep doanhNghiep, boolean merge)
		throws SystemException {
		return getPersistence().update(doanhNghiep, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DoanhNghiep update(DoanhNghiep doanhNghiep, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(doanhNghiep, merge, serviceContext);
	}

	/**
	* Caches the doanh nghiep in the entity cache if it is enabled.
	*
	* @param doanhNghiep the doanh nghiep
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep) {
		getPersistence().cacheResult(doanhNghiep);
	}

	/**
	* Caches the doanh nghieps in the entity cache if it is enabled.
	*
	* @param doanhNghieps the doanh nghieps
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> doanhNghieps) {
		getPersistence().cacheResult(doanhNghieps);
	}

	/**
	* Creates a new doanh nghiep with the primary key. Does not add the doanh nghiep to the database.
	*
	* @param id the primary key for the new doanh nghiep
	* @return the new doanh nghiep
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dn.model.DoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(doanhNghiep, merge);
	}

	/**
	* Returns the doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doanh nghiep
	* @return the doanh nghiep, or <code>null</code> if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the doanh nghiep where ma = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the doanh nghiep where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param maSoThue the ma so thue
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByMaSoThue(
		java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByMaSoThue(maSoThue);
	}

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param maSoThue the ma so thue
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMaSoThue(
		java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaSoThue(maSoThue);
	}

	/**
	* Returns the doanh nghiep where maSoThue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param maSoThue the ma so thue
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByMaSoThue(
		java.lang.String maSoThue, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaSoThue(maSoThue, retrieveFromCache);
	}

	/**
	* Returns the doanh nghiep where ten = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten);
	}

	/**
	* Returns the doanh nghiep where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten, retrieveFromCache);
	}

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findBySoGCNDKKD(
		java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findBySoGCNDKKD(soGCNDKKD);
	}

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchBySoGCNDKKD(
		java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySoGCNDKKD(soGCNDKKD);
	}

	/**
	* Returns the doanh nghiep where soGCNDKKD = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchBySoGCNDKKD(
		java.lang.String soGCNDKKD, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySoGCNDKKD(soGCNDKKD, retrieveFromCache);
	}

	/**
	* Returns the doanh nghiep where chaId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param chaId the cha ID
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByChaId(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByChaId(chaId);
	}

	/**
	* Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param chaId the cha ID
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByChaId(
		java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByChaId(chaId);
	}

	/**
	* Returns the doanh nghiep where chaId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param chaId the cha ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByChaId(
		java.lang.Long chaId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByChaId(chaId, retrieveFromCache);
	}

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiepException} if it could not be found.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence().findByNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Returns the doanh nghiep where nguoiDaiDienId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doanh nghiep, or <code>null</code> if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep fetchByNguoiDaiDienId(
		java.lang.Long nguoiDaiDienId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNguoiDaiDienId(nguoiDaiDienId, retrieveFromCache);
	}

	/**
	* Returns all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId, loaiDoiTuongId);
	}

	/**
	* Returns a range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
			loaiDoiTuongId, start, end);
	}

	/**
	* Returns an ordered range of all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
			loaiDoiTuongId, start, end, orderByComparator);
	}

	/**
	* Returns the first doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByGetNguoiDaiDienDoiTuong_First(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong_First(nguoiDaiDienId,
			loaiDoiTuongId, orderByComparator);
	}

	/**
	* Returns the last doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByGetNguoiDaiDienDoiTuong_Last(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong_Last(nguoiDaiDienId,
			loaiDoiTuongId, orderByComparator);
	}

	/**
	* Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doanh nghiep
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep[] findByGetNguoiDaiDienDoiTuong_PrevAndNext(
		long id, java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetNguoiDaiDienDoiTuong_PrevAndNext(id,
			nguoiDaiDienId, loaiDoiTuongId, orderByComparator);
	}

	/**
	* Returns all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @return the matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId);
	}

	/**
	* Returns a range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId, start,
			end);
	}

	/**
	* Returns an ordered range of all the doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByGetLoaiHinhDoanhNghiep_First(
		java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep_First(loaiHinhDoanhNghiepId,
			orderByComparator);
	}

	/**
	* Returns the last doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a matching doanh nghiep could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep findByGetLoaiHinhDoanhNghiep_Last(
		java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep_Last(loaiHinhDoanhNghiepId,
			orderByComparator);
	}

	/**
	* Returns the doanh nghieps before and after the current doanh nghiep in the ordered set where loaiHinhDoanhNghiepId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doanh nghiep
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiepException if a doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep[] findByGetLoaiHinhDoanhNghiep_PrevAndNext(
		long id, java.lang.Long loaiHinhDoanhNghiepId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		return getPersistence()
				   .findByGetLoaiHinhDoanhNghiep_PrevAndNext(id,
			loaiHinhDoanhNghiepId, orderByComparator);
	}

	/**
	* Returns all the doanh nghieps.
	*
	* @return the doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @return the range of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghieps
	* @param end the upper bound of the range of doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the doanh nghiep where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the doanh nghiep where maSoThue = &#63; from the database.
	*
	* @param maSoThue the ma so thue
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaSoThue(java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeByMaSoThue(maSoThue);
	}

	/**
	* Removes the doanh nghiep where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes the doanh nghiep where soGCNDKKD = &#63; from the database.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySoGCNDKKD(java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeBySoGCNDKKD(soGCNDKKD);
	}

	/**
	* Removes the doanh nghiep where chaId = &#63; from the database.
	*
	* @param chaId the cha ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChaId(java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeByChaId(chaId);
	}

	/**
	* Removes the doanh nghiep where nguoiDaiDienId = &#63; from the database.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNguoiDaiDienId(java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiepException {
		getPersistence().removeByNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Removes all the doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63; from the database.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByGetNguoiDaiDienDoiTuong(nguoiDaiDienId, loaiDoiTuongId);
	}

	/**
	* Removes all the doanh nghieps where loaiHinhDoanhNghiepId = &#63; from the database.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId);
	}

	/**
	* Removes all the doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of doanh nghieps where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of doanh nghieps where maSoThue = &#63;.
	*
	* @param maSoThue the ma so thue
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaSoThue(java.lang.String maSoThue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaSoThue(maSoThue);
	}

	/**
	* Returns the number of doanh nghieps where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of doanh nghieps where soGCNDKKD = &#63;.
	*
	* @param soGCNDKKD the so g c n d k k d
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySoGCNDKKD(java.lang.String soGCNDKKD)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySoGCNDKKD(soGCNDKKD);
	}

	/**
	* Returns the number of doanh nghieps where chaId = &#63;.
	*
	* @param chaId the cha ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChaId(java.lang.Long chaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChaId(chaId);
	}

	/**
	* Returns the number of doanh nghieps where nguoiDaiDienId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNguoiDaiDienId(java.lang.Long nguoiDaiDienId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Returns the number of doanh nghieps where nguoiDaiDienId = &#63; and loaiDoiTuongId = &#63;.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGetNguoiDaiDienDoiTuong(
		java.lang.Long nguoiDaiDienId, java.lang.Long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGetNguoiDaiDienDoiTuong(nguoiDaiDienId,
			loaiDoiTuongId);
	}

	/**
	* Returns the number of doanh nghieps where loaiHinhDoanhNghiepId = &#63;.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID
	* @return the number of matching doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGetLoaiHinhDoanhNghiep(
		java.lang.Long loaiHinhDoanhNghiepId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGetLoaiHinhDoanhNghiep(loaiHinhDoanhNghiepId);
	}

	/**
	* Returns the number of doanh nghieps.
	*
	* @return the number of doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DoanhNghiepPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DoanhNghiepPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dn.service.ClpSerializer.getServletContextName(),
					DoanhNghiepPersistence.class.getName());

			ReferenceRegistry.registerReference(DoanhNghiepUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DoanhNghiepPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DoanhNghiepUtil.class,
			"_persistence");
	}

	private static DoanhNghiepPersistence _persistence;
}