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

package org.oep.cmon.dao.cc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.cc.model.CongChuc;

import java.util.List;

/**
 * The persistence utility for the cong chuc service. This utility wraps {@link CongChucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChucPersistence
 * @see CongChucPersistenceImpl
 * @generated
 */
public class CongChucUtil {
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
	public static void clearCache(CongChuc congChuc) {
		getPersistence().clearCache(congChuc);
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
	public static List<CongChuc> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CongChuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CongChuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CongChuc update(CongChuc congChuc, boolean merge)
		throws SystemException {
		return getPersistence().update(congChuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CongChuc update(CongChuc congChuc, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(congChuc, merge, serviceContext);
	}

	/**
	* Caches the cong chuc in the entity cache if it is enabled.
	*
	* @param congChuc the cong chuc
	*/
	public static void cacheResult(org.oep.cmon.dao.cc.model.CongChuc congChuc) {
		getPersistence().cacheResult(congChuc);
	}

	/**
	* Caches the cong chucs in the entity cache if it is enabled.
	*
	* @param congChucs the cong chucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cc.model.CongChuc> congChucs) {
		getPersistence().cacheResult(congChucs);
	}

	/**
	* Creates a new cong chuc with the primary key. Does not add the cong chuc to the database.
	*
	* @param id the primary key for the new cong chuc
	* @return the new cong chuc
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cong chuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc that was removed
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cc.model.CongChuc updateImpl(
		org.oep.cmon.dao.cc.model.CongChuc congChuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(congChuc, merge);
	}

	/**
	* Returns the cong chuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChucException} if it could not be found.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cong chuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong chuc
	* @return the cong chuc, or <code>null</code> if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cong chucs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the cong chucs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns a range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByTaiKhoanNguoiDungId_First(
		java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_First(taiKhoanNguoiDungId,
			orderByComparator);
	}

	/**
	* Returns the last cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByTaiKhoanNguoiDungId_Last(
		java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_Last(taiKhoanNguoiDungId,
			orderByComparator);
	}

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where taiKhoanNguoiDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc[] findByTaiKhoanNguoiDungId_PrevAndNext(
		long id, java.lang.Long taiKhoanNguoiDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_PrevAndNext(id,
			taiKhoanNguoiDungId, orderByComparator);
	}

	/**
	* Returns all the cong chucs where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChucVuId(chucVuId);
	}

	/**
	* Returns a range of all the cong chucs where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChucVuId(chucVuId, start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByChucVuId(
		long chucVuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuId(chucVuId, start, end, orderByComparator);
	}

	/**
	* Returns the first cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByChucVuId_First(
		long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByChucVuId_First(chucVuId, orderByComparator);
	}

	/**
	* Returns the last cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByChucVuId_Last(
		long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByChucVuId_Last(chucVuId, orderByComparator);
	}

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc[] findByChucVuId_PrevAndNext(
		long id, long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByChucVuId_PrevAndNext(id, chucVuId, orderByComparator);
	}

	/**
	* Returns all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns a range of all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId, start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyId(coQuanQuanLyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByCoQuanQuanLyId_First(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByCoQuanQuanLyId_First(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the last cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByCoQuanQuanLyId_Last(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByCoQuanQuanLyId_Last(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc[] findByCoQuanQuanLyId_PrevAndNext(
		long id, long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByCoQuanQuanLyId_PrevAndNext(id, coQuanQuanLyId,
			orderByComparator);
	}

	/**
	* Returns all the cong chucs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the cong chucs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a matching cong chuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the cong chucs before and after the current cong chuc in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChucException if a cong chuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChucException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the cong chucs.
	*
	* @return the cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cong chucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @return the range of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cong chucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chucs
	* @param end the upper bound of the range of cong chucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cong chucs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the cong chucs where taiKhoanNguoiDungId = &#63; from the database.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Removes all the cong chucs where chucVuId = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChucVuId(long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChucVuId(chucVuId);
	}

	/**
	* Removes all the cong chucs where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Removes all the cong chucs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the cong chucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cong chucs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of cong chucs where taiKhoanNguoiDungId = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns the number of cong chucs where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChucVuId(long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChucVuId(chucVuId);
	}

	/**
	* Returns the number of cong chucs where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the number of cong chucs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of cong chucs.
	*
	* @return the number of cong chucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CongChucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CongChucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cc.service.ClpSerializer.getServletContextName(),
					CongChucPersistence.class.getName());

			ReferenceRegistry.registerReference(CongChucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CongChucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CongChucUtil.class, "_persistence");
	}

	private static CongChucPersistence _persistence;
}