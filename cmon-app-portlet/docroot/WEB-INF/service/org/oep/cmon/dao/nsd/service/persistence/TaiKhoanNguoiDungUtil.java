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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

import java.util.List;

/**
 * The persistence utility for the tai khoan nguoi dung service. This utility wraps {@link TaiKhoanNguoiDungPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDungPersistence
 * @see TaiKhoanNguoiDungPersistenceImpl
 * @generated
 */
public class TaiKhoanNguoiDungUtil {
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
	public static void clearCache(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		getPersistence().clearCache(taiKhoanNguoiDung);
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
	public static List<TaiKhoanNguoiDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaiKhoanNguoiDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaiKhoanNguoiDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TaiKhoanNguoiDung update(
		TaiKhoanNguoiDung taiKhoanNguoiDung, boolean merge)
		throws SystemException {
		return getPersistence().update(taiKhoanNguoiDung, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TaiKhoanNguoiDung update(
		TaiKhoanNguoiDung taiKhoanNguoiDung, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taiKhoanNguoiDung, merge, serviceContext);
	}

	/**
	* Caches the tai khoan nguoi dung in the entity cache if it is enabled.
	*
	* @param taiKhoanNguoiDung the tai khoan nguoi dung
	*/
	public static void cacheResult(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung) {
		getPersistence().cacheResult(taiKhoanNguoiDung);
	}

	/**
	* Caches the tai khoan nguoi dungs in the entity cache if it is enabled.
	*
	* @param taiKhoanNguoiDungs the tai khoan nguoi dungs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> taiKhoanNguoiDungs) {
		getPersistence().cacheResult(taiKhoanNguoiDungs);
	}

	/**
	* Creates a new tai khoan nguoi dung with the primary key. Does not add the tai khoan nguoi dung to the database.
	*
	* @param id the primary key for the new tai khoan nguoi dung
	* @return the new tai khoan nguoi dung
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tai khoan nguoi dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung updateImpl(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taiKhoanNguoiDung, merge);
	}

	/**
	* Returns the tai khoan nguoi dung with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tai khoan nguoi dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tai khoan nguoi dung
	* @return the tai khoan nguoi dung, or <code>null</code> if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException} if it could not be found.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenDangNhap(
		java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByTenDangNhap(tenDangNhap);
	}

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByTenDangNhap(
		java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTenDangNhap(tenDangNhap);
	}

	/**
	* Returns the tai khoan nguoi dung where tenDangNhap = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param tenDangNhap the ten dang nhap
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tai khoan nguoi dung, or <code>null</code> if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung fetchByTenDangNhap(
		java.lang.String tenDangNhap, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTenDangNhap(tenDangNhap, retrieveFromCache);
	}

	/**
	* Returns all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTenNguoiDung(tenNguoiDung);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTenNguoiDung(tenNguoiDung, start, end);
	}

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTenNguoiDung(
		java.lang.String tenNguoiDung, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTenNguoiDung(tenNguoiDung, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenNguoiDung_First(
		java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTenNguoiDung_First(tenNguoiDung, orderByComparator);
	}

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTenNguoiDung_Last(
		java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTenNguoiDung_Last(tenNguoiDung, orderByComparator);
	}

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where tenNguoiDung = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param tenNguoiDung the ten nguoi dung
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTenNguoiDung_PrevAndNext(
		long id, java.lang.String tenNguoiDung,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTenNguoiDung_PrevAndNext(id, tenNguoiDung,
			orderByComparator);
	}

	/**
	* Returns all the tai khoan nguoi dungs where email = &#63;.
	*
	* @param email the email
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end);
	}

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByEmail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end, orderByComparator);
	}

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByEmail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByEmail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByEmail_PrevAndNext(
		long id, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByEmail_PrevAndNext(id, email, orderByComparator);
	}

	/**
	* Returns all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa, start,
			end);
	}

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa, start,
			end, orderByComparator);
	}

	/**
	* Returns the first tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDung_First(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung_First(taiKhoanNguoiDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a matching tai khoan nguoi dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung findByTaiKhoanNguoiDung_Last(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung_Last(taiKhoanNguoiDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the tai khoan nguoi dungs before and after the current tai khoan nguoi dung in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai khoan nguoi dung
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai khoan nguoi dung
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException if a tai khoan nguoi dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung[] findByTaiKhoanNguoiDung_PrevAndNext(
		long id, java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		return getPersistence()
				   .findByTaiKhoanNguoiDung_PrevAndNext(id,
			taiKhoanNguoiDungId, daXoa, orderByComparator);
	}

	/**
	* Returns all the tai khoan nguoi dungs.
	*
	* @return the tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @return the range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tai khoan nguoi dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai khoan nguoi dungs
	* @param end the upper bound of the range of tai khoan nguoi dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the tai khoan nguoi dung where tenDangNhap = &#63; from the database.
	*
	* @param tenDangNhap the ten dang nhap
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenDangNhap(java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiKhoanNguoiDungException {
		getPersistence().removeByTenDangNhap(tenDangNhap);
	}

	/**
	* Removes all the tai khoan nguoi dungs where tenNguoiDung = &#63; from the database.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenNguoiDung(java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTenNguoiDung(tenNguoiDung);
	}

	/**
	* Removes all the tai khoan nguoi dungs where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmail(email);
	}

	/**
	* Removes all the tai khoan nguoi dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Removes all the tai khoan nguoi dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tai khoan nguoi dungs where tenDangNhap = &#63;.
	*
	* @param tenDangNhap the ten dang nhap
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenDangNhap(java.lang.String tenDangNhap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenDangNhap(tenDangNhap);
	}

	/**
	* Returns the number of tai khoan nguoi dungs where tenNguoiDung = &#63;.
	*
	* @param tenNguoiDung the ten nguoi dung
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenNguoiDung(java.lang.String tenNguoiDung)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenNguoiDung(tenNguoiDung);
	}

	/**
	* Returns the number of tai khoan nguoi dungs where email = &#63;.
	*
	* @param email the email
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Returns the number of tai khoan nguoi dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of tai khoan nguoi dungs where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the number of matching tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaiKhoanNguoiDung(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTaiKhoanNguoiDung(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns the number of tai khoan nguoi dungs.
	*
	* @return the number of tai khoan nguoi dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaiKhoanNguoiDungPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaiKhoanNguoiDungPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					TaiKhoanNguoiDungPersistence.class.getName());

			ReferenceRegistry.registerReference(TaiKhoanNguoiDungUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TaiKhoanNguoiDungPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TaiKhoanNguoiDungUtil.class,
			"_persistence");
	}

	private static TaiKhoanNguoiDungPersistence _persistence;
}