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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;

import java.util.List;

/**
 * The persistence utility for the ho so chung thuc service. This utility wraps {@link HoSoChungThucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see HoSoChungThucPersistence
 * @see HoSoChungThucPersistenceImpl
 * @generated
 */
public class HoSoChungThucUtil {
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
	public static void clearCache(HoSoChungThuc hoSoChungThuc) {
		getPersistence().clearCache(hoSoChungThuc);
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
	public static List<HoSoChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoChungThuc update(HoSoChungThuc hoSoChungThuc,
		boolean merge) throws SystemException {
		return getPersistence().update(hoSoChungThuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoChungThuc update(HoSoChungThuc hoSoChungThuc,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoChungThuc, merge, serviceContext);
	}

	/**
	* Caches the ho so chung thuc in the entity cache if it is enabled.
	*
	* @param hoSoChungThuc the ho so chung thuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.chungthuc.model.HoSoChungThuc hoSoChungThuc) {
		getPersistence().cacheResult(hoSoChungThuc);
	}

	/**
	* Caches the ho so chung thucs in the entity cache if it is enabled.
	*
	* @param hoSoChungThucs the ho so chung thucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> hoSoChungThucs) {
		getPersistence().cacheResult(hoSoChungThucs);
	}

	/**
	* Creates a new ho so chung thuc with the primary key. Does not add the ho so chung thuc to the database.
	*
	* @param hoSoChungThucId the primary key for the new ho so chung thuc
	* @return the new ho so chung thuc
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc create(
		long hoSoChungThucId) {
		return getPersistence().create(hoSoChungThucId);
	}

	/**
	* Removes the ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param hoSoChungThucId the primary key of the ho so chung thuc
	* @return the ho so chung thuc that was removed
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc remove(
		long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence().remove(hoSoChungThucId);
	}

	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.HoSoChungThuc hoSoChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoChungThuc, merge);
	}

	/**
	* Returns the ho so chung thuc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException} if it could not be found.
	*
	* @param hoSoChungThucId the primary key of the ho so chung thuc
	* @return the ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByPrimaryKey(
		long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence().findByPrimaryKey(hoSoChungThucId);
	}

	/**
	* Returns the ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param hoSoChungThucId the primary key of the ho so chung thuc
	* @return the ho so chung thuc, or <code>null</code> if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc fetchByPrimaryKey(
		long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(hoSoChungThucId);
	}

	/**
	* Returns all the ho so chung thucs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findBymaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns a range of all the ho so chung thucs where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoBienNhan(maSoBienNhan, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymaSoBienNhan(maSoBienNhan, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findBymaSoBienNhan_First(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findBymaSoBienNhan_First(maSoBienNhan, orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findBymaSoBienNhan_Last(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findBymaSoBienNhan_Last(maSoBienNhan, orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where maSoBienNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param maSoBienNhan the ma so bien nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findBymaSoBienNhan_PrevAndNext(
		long hoSoChungThucId, java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findBymaSoBienNhan_PrevAndNext(hoSoChungThucId,
			maSoBienNhan, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Returns a range of all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTen_DT_DD_First(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTen_DT_DD_First(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
			orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTen_DT_DD_Last(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTen_DT_DD_Last(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
			orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findByTen_DT_DD_PrevAndNext(
		long hoSoChungThucId, java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTen_DT_DD_PrevAndNext(hoSoChungThucId,
			hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Returns a range of all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoTTHCID(thuTucHanhChinhId, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCID(thuTucHanhChinhId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoTTHCID_First(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCID_First(thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoTTHCID_Last(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCID_Last(thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findByTheoTTHCID_PrevAndNext(
		long hoSoChungThucId, java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCID_PrevAndNext(hoSoChungThucId,
			thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
			soDanhMucId);
	}

	/**
	* Returns a range of all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
			soDanhMucId, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoTTHCIDAndSoDanhMucId(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
			soDanhMucId, start, end, orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoTTHCIDAndSoDanhMucId_First(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId_First(thuTucHanhChinhId,
			soDanhMucId, orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoTTHCIDAndSoDanhMucId_Last(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId_Last(thuTucHanhChinhId,
			soDanhMucId, orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findByTheoTTHCIDAndSoDanhMucId_PrevAndNext(
		long hoSoChungThucId, java.lang.Long thuTucHanhChinhId,
		java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoTTHCIDAndSoDanhMucId_PrevAndNext(hoSoChungThucId,
			thuTucHanhChinhId, soDanhMucId, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs where soDanhMucId = &#63;.
	*
	* @param soDanhMucId the so danh muc ID
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoDanhMuc(
		java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoSoDanhMuc(soDanhMucId);
	}

	/**
	* Returns a range of all the ho so chung thucs where soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soDanhMucId the so danh muc ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoDanhMuc(
		java.lang.Long soDanhMucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoSoDanhMuc(soDanhMucId, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soDanhMucId the so danh muc ID
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoDanhMuc(
		java.lang.Long soDanhMucId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoSoDanhMuc(soDanhMucId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoSoDanhMuc_First(
		java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoDanhMuc_First(soDanhMucId, orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoSoDanhMuc_Last(
		java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoDanhMuc_Last(soDanhMucId, orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where soDanhMucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param soDanhMucId the so danh muc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findByTheoSoDanhMuc_PrevAndNext(
		long hoSoChungThucId, java.lang.Long soDanhMucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoDanhMuc_PrevAndNext(hoSoChungThucId,
			soDanhMucId, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs where soChungThuc = &#63;.
	*
	* @param soChungThuc the so chung thuc
	* @return the matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoChungThuc(
		java.lang.String soChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoSoChungThuc(soChungThuc);
	}

	/**
	* Returns a range of all the ho so chung thucs where soChungThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soChungThuc the so chung thuc
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoChungThuc(
		java.lang.String soChungThuc, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoSoChungThuc(soChungThuc, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs where soChungThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soChungThuc the so chung thuc
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findByTheoSoChungThuc(
		java.lang.String soChungThuc, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoSoChungThuc(soChungThuc, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so chung thuc in the ordered set where soChungThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soChungThuc the so chung thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoSoChungThuc_First(
		java.lang.String soChungThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoChungThuc_First(soChungThuc, orderByComparator);
	}

	/**
	* Returns the last ho so chung thuc in the ordered set where soChungThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soChungThuc the so chung thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a matching ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc findByTheoSoChungThuc_Last(
		java.lang.String soChungThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoChungThuc_Last(soChungThuc, orderByComparator);
	}

	/**
	* Returns the ho so chung thucs before and after the current ho so chung thuc in the ordered set where soChungThuc = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the primary key of the current ho so chung thuc
	* @param soChungThuc the so chung thuc
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException if a ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.HoSoChungThuc[] findByTheoSoChungThuc_PrevAndNext(
		long hoSoChungThucId, java.lang.String soChungThuc,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchHoSoChungThucException {
		return getPersistence()
				   .findByTheoSoChungThuc_PrevAndNext(hoSoChungThucId,
			soChungThuc, orderByComparator);
	}

	/**
	* Returns all the ho so chung thucs.
	*
	* @return the ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho so chung thucs where maSoBienNhan = &#63; from the database.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymaSoBienNhan(maSoBienNhan);
	}

	/**
	* Removes all the ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63; from the database.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen_DT_DD(java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTen_DT_DD(hoTenNguoiNopHoSo, soDienThoaiDiDongNguoiNop,
			soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Removes all the ho so chung thucs where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Removes all the ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoTTHCIDAndSoDanhMucId(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId, soDanhMucId);
	}

	/**
	* Removes all the ho so chung thucs where soDanhMucId = &#63; from the database.
	*
	* @param soDanhMucId the so danh muc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoSoDanhMuc(java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTheoSoDanhMuc(soDanhMucId);
	}

	/**
	* Removes all the ho so chung thucs where soChungThuc = &#63; from the database.
	*
	* @param soChungThuc the so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoSoChungThuc(java.lang.String soChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTheoSoChungThuc(soChungThuc);
	}

	/**
	* Removes all the ho so chung thucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so chung thucs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns the number of ho so chung thucs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen_DT_DD(java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Returns the number of ho so chung thucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Returns the number of ho so chung thucs where thuTucHanhChinhId = &#63; and soDanhMucId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param soDanhMucId the so danh muc ID
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoTTHCIDAndSoDanhMucId(
		java.lang.Long thuTucHanhChinhId, java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTheoTTHCIDAndSoDanhMucId(thuTucHanhChinhId,
			soDanhMucId);
	}

	/**
	* Returns the number of ho so chung thucs where soDanhMucId = &#63;.
	*
	* @param soDanhMucId the so danh muc ID
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoSoDanhMuc(java.lang.Long soDanhMucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTheoSoDanhMuc(soDanhMucId);
	}

	/**
	* Returns the number of ho so chung thucs where soChungThuc = &#63;.
	*
	* @param soChungThuc the so chung thuc
	* @return the number of matching ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoSoChungThuc(java.lang.String soChungThuc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTheoSoChungThuc(soChungThuc);
	}

	/**
	* Returns the number of ho so chung thucs.
	*
	* @return the number of ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	*
	* @param pk the primary key of the ho so chung thuc
	* @return the thanh phan ho so chung thucs associated with the ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getThanhPhanHoSoChungThucs(pk);
	}

	/**
	* Returns a range of all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the ho so chung thuc
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @return the range of thanh phan ho so chung thucs associated with the ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getThanhPhanHoSoChungThucs(pk, start, end);
	}

	/**
	* Returns an ordered range of all the thanh phan ho so chung thucs associated with the ho so chung thuc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the ho so chung thuc
	* @param start the lower bound of the range of ho so chung thucs
	* @param end the upper bound of the range of ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thanh phan ho so chung thucs associated with the ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> getThanhPhanHoSoChungThucs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getThanhPhanHoSoChungThucs(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of thanh phan ho so chung thucs associated with the ho so chung thuc.
	*
	* @param pk the primary key of the ho so chung thuc
	* @return the number of thanh phan ho so chung thucs associated with the ho so chung thuc
	* @throws SystemException if a system exception occurred
	*/
	public static int getThanhPhanHoSoChungThucsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getThanhPhanHoSoChungThucsSize(pk);
	}

	/**
	* Returns <code>true</code> if the thanh phan ho so chung thuc is associated with the ho so chung thuc.
	*
	* @param pk the primary key of the ho so chung thuc
	* @param thanhPhanHoSoChungThucPK the primary key of the thanh phan ho so chung thuc
	* @return <code>true</code> if the thanh phan ho so chung thuc is associated with the ho so chung thuc; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsThanhPhanHoSoChungThuc(long pk,
		long thanhPhanHoSoChungThucPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .containsThanhPhanHoSoChungThuc(pk, thanhPhanHoSoChungThucPK);
	}

	/**
	* Returns <code>true</code> if the ho so chung thuc has any thanh phan ho so chung thucs associated with it.
	*
	* @param pk the primary key of the ho so chung thuc to check for associations with thanh phan ho so chung thucs
	* @return <code>true</code> if the ho so chung thuc has any thanh phan ho so chung thucs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsThanhPhanHoSoChungThucs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsThanhPhanHoSoChungThucs(pk);
	}

	public static HoSoChungThucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoChungThucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.chungthuc.service.ClpSerializer.getServletContextName(),
					HoSoChungThucPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoChungThucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoChungThucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoChungThucUtil.class,
			"_persistence");
	}

	private static HoSoChungThucPersistence _persistence;
}