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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

import java.util.List;

/**
 * The persistence utility for the ho so t t h c cong service. This utility wraps {@link HoSoTTHCCongPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoTTHCCongPersistence
 * @see HoSoTTHCCongPersistenceImpl
 * @generated
 */
public class HoSoTTHCCongUtil {
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
	public static void clearCache(HoSoTTHCCong hoSoTTHCCong) {
		getPersistence().clearCache(hoSoTTHCCong);
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
	public static List<HoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoTTHCCong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoTTHCCong update(HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws SystemException {
		return getPersistence().update(hoSoTTHCCong, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoTTHCCong update(HoSoTTHCCong hoSoTTHCCong, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoTTHCCong, merge, serviceContext);
	}

	/**
	* Caches the ho so t t h c cong in the entity cache if it is enabled.
	*
	* @param hoSoTTHCCong the ho so t t h c cong
	*/
	public static void cacheResult(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong) {
		getPersistence().cacheResult(hoSoTTHCCong);
	}

	/**
	* Caches the ho so t t h c congs in the entity cache if it is enabled.
	*
	* @param hoSoTTHCCongs the ho so t t h c congs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> hoSoTTHCCongs) {
		getPersistence().cacheResult(hoSoTTHCCongs);
	}

	/**
	* Creates a new ho so t t h c cong with the primary key. Does not add the ho so t t h c cong to the database.
	*
	* @param id the primary key for the new ho so t t h c cong
	* @return the new ho so t t h c cong
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho so t t h c cong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoTTHCCong, merge);
	}

	/**
	* Returns the ho so t t h c cong with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException} if it could not be found.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho so t t h c cong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so t t h c cong
	* @return the ho so t t h c cong, or <code>null</code> if a ho so t t h c cong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoBienNhan(maSoBienNhan);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoBienNhan(maSoBienNhan, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoBienNhan(
		java.lang.String maSoBienNhan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymaSoBienNhan(maSoBienNhan, start, end,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoBienNhan_First(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findBymaSoBienNhan_First(maSoBienNhan, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoBienNhan_Last(
		java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findBymaSoBienNhan_Last(maSoBienNhan, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findBymaSoBienNhan_PrevAndNext(
		long id, java.lang.String maSoBienNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findBymaSoBienNhan_PrevAndNext(id, maSoBienNhan,
			orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where maSoHoSo = &#63;.
	*
	* @param maSoHoSo the ma so ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoHoSo(maSoHoSo);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymaSoHoSo(maSoHoSo, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findBymaSoHoSo(
		java.lang.String maSoHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymaSoHoSo(maSoHoSo, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoHoSo_First(
		java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().findBymaSoHoSo_First(maSoHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findBymaSoHoSo_Last(
		java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().findBymaSoHoSo_Last(maSoHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findBymaSoHoSo_PrevAndNext(
		long id, java.lang.String maSoHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findBymaSoHoSo_PrevAndNext(id, maSoHoSo, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
			start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByDV_PB(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi,
			start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByDV_PB_First(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByDV_PB_First(tenCoQuanTiepNhan,
			tenPhongBanXuLyHienThoi, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByDV_PB_Last(
		java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByDV_PB_Last(tenCoQuanTiepNhan,
			tenPhongBanXuLyHienThoi, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByDV_PB_PrevAndNext(
		long id, java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByDV_PB_PrevAndNext(id, tenCoQuanTiepNhan,
			tenPhongBanXuLyHienThoi, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTenThuTucHanhChinh(tenThuTucHanhChinh);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTenThuTucHanhChinh(tenThuTucHanhChinh, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTenThuTucHanhChinh(tenThuTucHanhChinh, start, end,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTenThuTucHanhChinh_First(
		java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTenThuTucHanhChinh_First(tenThuTucHanhChinh,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTenThuTucHanhChinh_Last(
		java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTenThuTucHanhChinh_Last(tenThuTucHanhChinh,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTenThuTucHanhChinh_PrevAndNext(
		long id, java.lang.String tenThuTucHanhChinh,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTenThuTucHanhChinh_PrevAndNext(id,
			tenThuTucHanhChinh, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTen_DT_DD(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTen_DT_DD(
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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTen_DT_DD_First(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTen_DT_DD_First(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTen_DT_DD_Last(
		java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTen_DT_DD_Last(hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTen_DT_DD_PrevAndNext(
		long id, java.lang.String hoTenNguoiNopHoSo,
		java.lang.String soDienThoaiDiDongNguoiNop,
		java.lang.String soDienThoaiCoDinhNguoiNop,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTen_DT_DD_PrevAndNext(id, hoTenNguoiNopHoSo,
			soDienThoaiDiDongNguoiNop, soDienThoaiCoDinhNguoiNop,
			orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where congDanNopId = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCongDanNopId(congDanNopId);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCongDanNopId(congDanNopId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId(
		java.lang.Long congDanNopId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCongDanNopId(congDanNopId, start, end,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_First(
		java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_First(congDanNopId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_Last(
		java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_Last(congDanNopId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByCongDanNopId_PrevAndNext(
		long id, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_PrevAndNext(id, congDanNopId,
			orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId,
			start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId,
			start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByThuTuc_CongDan_First(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByThuTuc_CongDan_First(thuTucHanhChinhId, congDanNopId,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByThuTuc_CongDan_Last(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByThuTuc_CongDan_Last(thuTucHanhChinhId, congDanNopId,
			orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByThuTuc_CongDan_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByThuTuc_CongDan_PrevAndNext(id, thuTucHanhChinhId,
			congDanNopId, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo,
			start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo,
			start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_TrangThai_First(
		java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai_First(congDanNopId,
			trangThaiHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByCongDanNopId_TrangThai_Last(
		java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai_Last(congDanNopId,
			trangThaiHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByCongDanNopId_TrangThai_PrevAndNext(
		long id, java.lang.Long congDanNopId, int trangThaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByCongDanNopId_TrangThai_PrevAndNext(id, congDanNopId,
			trangThaiHoSo, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where loaiHoSo = &#63;.
	*
	* @param loaiHoSo the loai ho so
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoaiHoSo(loaiHoSo);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoaiHoSo(loaiHoSo, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByLoaiHoSo(
		int loaiHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLoaiHoSo(loaiHoSo, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByLoaiHoSo_First(
		int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().findByLoaiHoSo_First(loaiHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByLoaiHoSo_Last(
		int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence().findByLoaiHoSo_Last(loaiHoSo, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByLoaiHoSo_PrevAndNext(
		long id, int loaiHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByLoaiHoSo_PrevAndNext(id, loaiHoSo, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @return the matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId,
			start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findByTrangThaiHoSo(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId,
			start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTrangThaiHoSo_First(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTrangThaiHoSo_First(trangThaiHoSo, daXoa,
			coQuanTiepNhanId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong findByTrangThaiHoSo_Last(
		int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTrangThaiHoSo_Last(trangThaiHoSo, daXoa,
			coQuanTiepNhanId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong[] findByTrangThaiHoSo_PrevAndNext(
		long id, int trangThaiHoSo, int daXoa, java.lang.Long coQuanTiepNhanId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoTTHCCongException {
		return getPersistence()
				   .findByTrangThaiHoSo_PrevAndNext(id, trangThaiHoSo, daXoa,
			coQuanTiepNhanId, orderByComparator);
	}

	/**
	* Returns all the ho so t t h c congs.
	*
	* @return the ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho so t t h c congs where maSoBienNhan = &#63; from the database.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymaSoBienNhan(maSoBienNhan);
	}

	/**
	* Removes all the ho so t t h c congs where maSoHoSo = &#63; from the database.
	*
	* @param maSoHoSo the ma so ho so
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymaSoHoSo(java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymaSoHoSo(maSoHoSo);
	}

	/**
	* Removes all the ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63; from the database.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDV_PB(java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi);
	}

	/**
	* Removes all the ho so t t h c congs where tenThuTucHanhChinh = &#63; from the database.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTenThuTucHanhChinh(tenThuTucHanhChinh);
	}

	/**
	* Removes all the ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63; from the database.
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
	* Removes all the ho so t t h c congs where congDanNopId = &#63; from the database.
	*
	* @param congDanNopId the cong dan nop ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCongDanNopId(java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCongDanNopId(congDanNopId);
	}

	/**
	* Removes all the ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTuc_CongDan(
		java.lang.Long thuTucHanhChinhId, java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId);
	}

	/**
	* Removes all the ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63; from the database.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo);
	}

	/**
	* Removes all the ho so t t h c congs where loaiHoSo = &#63; from the database.
	*
	* @param loaiHoSo the loai ho so
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLoaiHoSo(int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLoaiHoSo(loaiHoSo);
	}

	/**
	* Removes all the ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63; from the database.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId);
	}

	/**
	* Removes all the ho so t t h c congs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so t t h c congs where maSoBienNhan = &#63;.
	*
	* @param maSoBienNhan the ma so bien nhan
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymaSoBienNhan(java.lang.String maSoBienNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns the number of ho so t t h c congs where maSoHoSo = &#63;.
	*
	* @param maSoHoSo the ma so ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymaSoHoSo(java.lang.String maSoHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymaSoHoSo(maSoHoSo);
	}

	/**
	* Returns the number of ho so t t h c congs where tenCoQuanTiepNhan = &#63; and tenPhongBanXuLyHienThoi = &#63;.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDV_PB(java.lang.String tenCoQuanTiepNhan,
		java.lang.String tenPhongBanXuLyHienThoi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByDV_PB(tenCoQuanTiepNhan, tenPhongBanXuLyHienThoi);
	}

	/**
	* Returns the number of ho so t t h c congs where tenThuTucHanhChinh = &#63;.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenThuTucHanhChinh(
		java.lang.String tenThuTucHanhChinh)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenThuTucHanhChinh(tenThuTucHanhChinh);
	}

	/**
	* Returns the number of ho so t t h c congs where hoTenNguoiNopHoSo = &#63; and soDienThoaiDiDongNguoiNop = &#63; and soDienThoaiCoDinhNguoiNop = &#63;.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop
	* @return the number of matching ho so t t h c congs
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
	* Returns the number of ho so t t h c congs where congDanNopId = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCongDanNopId(java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCongDanNopId(congDanNopId);
	}

	/**
	* Returns the number of ho so t t h c congs where thuTucHanhChinhId = &#63; and congDanNopId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param congDanNopId the cong dan nop ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTuc_CongDan(java.lang.Long thuTucHanhChinhId,
		java.lang.Long congDanNopId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTuc_CongDan(thuTucHanhChinhId, congDanNopId);
	}

	/**
	* Returns the number of ho so t t h c congs where congDanNopId = &#63; and trangThaiHoSo = &#63;.
	*
	* @param congDanNopId the cong dan nop ID
	* @param trangThaiHoSo the trang thai ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCongDanNopId_TrangThai(
		java.lang.Long congDanNopId, int trangThaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCongDanNopId_TrangThai(congDanNopId, trangThaiHoSo);
	}

	/**
	* Returns the number of ho so t t h c congs where loaiHoSo = &#63;.
	*
	* @param loaiHoSo the loai ho so
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLoaiHoSo(int loaiHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLoaiHoSo(loaiHoSo);
	}

	/**
	* Returns the number of ho so t t h c congs where trangThaiHoSo = &#63; and daXoa = &#63; and coQuanTiepNhanId = &#63;.
	*
	* @param trangThaiHoSo the trang thai ho so
	* @param daXoa the da xoa
	* @param coQuanTiepNhanId the co quan tiep nhan ID
	* @return the number of matching ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThaiHoSo(int trangThaiHoSo, int daXoa,
		java.lang.Long coQuanTiepNhanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTrangThaiHoSo(trangThaiHoSo, daXoa, coQuanTiepNhanId);
	}

	/**
	* Returns the number of ho so t t h c congs.
	*
	* @return the number of ho so t t h c congs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoSoTTHCCongPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoTTHCCongPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					HoSoTTHCCongPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoTTHCCongUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoTTHCCongPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoTTHCCongUtil.class,
			"_persistence");
	}

	private static HoSoTTHCCongPersistence _persistence;
}