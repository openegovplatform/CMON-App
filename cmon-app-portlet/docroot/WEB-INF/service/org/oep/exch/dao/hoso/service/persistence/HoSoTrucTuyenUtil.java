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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;

import java.util.List;

/**
 * The persistence utility for the ho so truc tuyen service. This utility wraps {@link HoSoTrucTuyenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoTrucTuyenPersistence
 * @see HoSoTrucTuyenPersistenceImpl
 * @generated
 */
public class HoSoTrucTuyenUtil {
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
	public static void clearCache(HoSoTrucTuyen hoSoTrucTuyen) {
		getPersistence().clearCache(hoSoTrucTuyen);
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
	public static List<HoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoTrucTuyen update(HoSoTrucTuyen hoSoTrucTuyen,
		boolean merge) throws SystemException {
		return getPersistence().update(hoSoTrucTuyen, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoTrucTuyen update(HoSoTrucTuyen hoSoTrucTuyen,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoTrucTuyen, merge, serviceContext);
	}

	/**
	* Caches the ho so truc tuyen in the entity cache if it is enabled.
	*
	* @param hoSoTrucTuyen the ho so truc tuyen
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen) {
		getPersistence().cacheResult(hoSoTrucTuyen);
	}

	/**
	* Caches the ho so truc tuyens in the entity cache if it is enabled.
	*
	* @param hoSoTrucTuyens the ho so truc tuyens
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> hoSoTrucTuyens) {
		getPersistence().cacheResult(hoSoTrucTuyens);
	}

	/**
	* Creates a new ho so truc tuyen with the primary key. Does not add the ho so truc tuyen to the database.
	*
	* @param id the primary key for the new ho so truc tuyen
	* @return the new ho so truc tuyen
	*/
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.HoSoTrucTuyen hoSoTrucTuyen, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoTrucTuyen, merge);
	}

	/**
	* Returns the ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException} if it could not be found.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so truc tuyen
	* @return the ho so truc tuyen, or <code>null</code> if a ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy);
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy, start, end);
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByNoiChuyenHoSo(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy, start,
			end, orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByNoiChuyenHoSo_First(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByNoiChuyenHoSo_First(NoiChuyenHoSo, TrangThaiXuLy,
			orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByNoiChuyenHoSo_Last(
		java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByNoiChuyenHoSo_Last(NoiChuyenHoSo, TrangThaiXuLy,
			orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen[] findByNoiChuyenHoSo_PrevAndNext(
		long id, java.lang.String NoiChuyenHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByNoiChuyenHoSo_PrevAndNext(id, NoiChuyenHoSo,
			TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy);
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy,
			start, end);
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy,
			start, end, orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByMaDonViTiepNhan_First(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByMaDonViTiepNhan_First(MaDonViTiepNhan, TrangThaiXuLy,
			orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen findByMaDonViTiepNhan_Last(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByMaDonViTiepNhan_Last(MaDonViTiepNhan, TrangThaiXuLy,
			orderByComparator);
	}

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
	public static org.oep.exch.dao.hoso.model.HoSoTrucTuyen[] findByMaDonViTiepNhan_PrevAndNext(
		long id, java.lang.String MaDonViTiepNhan, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoTrucTuyenException {
		return getPersistence()
				   .findByMaDonViTiepNhan_PrevAndNext(id, MaDonViTiepNhan,
			TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns all the ho so truc tuyens.
	*
	* @return the ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoTrucTuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNoiChuyenHoSo(java.lang.String NoiChuyenHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy);
	}

	/**
	* Removes all the ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaDonViTiepNhan(
		java.lang.String MaDonViTiepNhan, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy);
	}

	/**
	* Removes all the ho so truc tuyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so truc tuyens where NoiChuyenHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param NoiChuyenHoSo the noi chuyen ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNoiChuyenHoSo(java.lang.String NoiChuyenHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNoiChuyenHoSo(NoiChuyenHoSo, TrangThaiXuLy);
	}

	/**
	* Returns the number of ho so truc tuyens where MaDonViTiepNhan = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaDonViTiepNhan the ma don vi tiep nhan
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaDonViTiepNhan(java.lang.String MaDonViTiepNhan,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMaDonViTiepNhan(MaDonViTiepNhan, TrangThaiXuLy);
	}

	/**
	* Returns the number of ho so truc tuyens.
	*
	* @return the number of ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoSoTrucTuyenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoTrucTuyenPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					HoSoTrucTuyenPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoTrucTuyenUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoTrucTuyenPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoTrucTuyenUtil.class,
			"_persistence");
	}

	private static HoSoTrucTuyenPersistence _persistence;
}