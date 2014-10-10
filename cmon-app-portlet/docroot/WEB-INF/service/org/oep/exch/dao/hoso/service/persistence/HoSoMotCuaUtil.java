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

import org.oep.exch.dao.hoso.model.HoSoMotCua;

import java.util.List;

/**
 * The persistence utility for the ho so mot cua service. This utility wraps {@link HoSoMotCuaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see HoSoMotCuaPersistence
 * @see HoSoMotCuaPersistenceImpl
 * @generated
 */
public class HoSoMotCuaUtil {
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
	public static void clearCache(HoSoMotCua hoSoMotCua) {
		getPersistence().clearCache(hoSoMotCua);
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
	public static List<HoSoMotCua> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoMotCua> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoMotCua> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoMotCua update(HoSoMotCua hoSoMotCua, boolean merge)
		throws SystemException {
		return getPersistence().update(hoSoMotCua, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoMotCua update(HoSoMotCua hoSoMotCua, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoMotCua, merge, serviceContext);
	}

	/**
	* Caches the ho so mot cua in the entity cache if it is enabled.
	*
	* @param hoSoMotCua the ho so mot cua
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua) {
		getPersistence().cacheResult(hoSoMotCua);
	}

	/**
	* Caches the ho so mot cuas in the entity cache if it is enabled.
	*
	* @param hoSoMotCuas the ho so mot cuas
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> hoSoMotCuas) {
		getPersistence().cacheResult(hoSoMotCuas);
	}

	/**
	* Creates a new ho so mot cua with the primary key. Does not add the ho so mot cua to the database.
	*
	* @param id the primary key for the new ho so mot cua
	* @return the new ho so mot cua
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho so mot cua with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.HoSoMotCua updateImpl(
		org.oep.exch.dao.hoso.model.HoSoMotCua hoSoMotCua, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoMotCua, merge);
	}

	/**
	* Returns the ho so mot cua with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException} if it could not be found.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho so mot cua with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so mot cua
	* @return the ho so mot cua, or <code>null</code> if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns a range of all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy, start, end);
	}

	/**
	* Returns an ordered range of all the ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiXuLy(TrangThaiXuLy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByTrangThaiXuLy_First(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the last ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByTrangThaiXuLy_Last(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the ho so mot cuas before and after the current ho so mot cua in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so mot cua
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByTrangThaiXuLy_PrevAndNext(id, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy);
	}

	/**
	* Returns a range of all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy, start, end);
	}

	/**
	* Returns an ordered range of all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findByMaSoHoSo(
		java.lang.String MaSoHoSo, int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaSoHoSo(MaSoHoSo, TrangThaiXuLy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua findByMaSoHoSo_First(
		java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByMaSoHoSo_First(MaSoHoSo, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns the last ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a matching ho so mot cua could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua findByMaSoHoSo_Last(
		java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByMaSoHoSo_Last(MaSoHoSo, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns the ho so mot cuas before and after the current ho so mot cua in the ordered set where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so mot cua
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so mot cua
	* @throws org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException if a ho so mot cua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.HoSoMotCua[] findByMaSoHoSo_PrevAndNext(
		long id, java.lang.String MaSoHoSo, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchHoSoMotCuaException {
		return getPersistence()
				   .findByMaSoHoSo_PrevAndNext(id, MaSoHoSo, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns all the ho so mot cuas.
	*
	* @return the ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ho so mot cuas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @return the range of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ho so mot cuas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so mot cuas
	* @param end the upper bound of the range of ho so mot cuas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.HoSoMotCua> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho so mot cuas where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Removes all the ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63; from the database.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaSoHoSo(java.lang.String MaSoHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaSoHoSo(MaSoHoSo, TrangThaiXuLy);
	}

	/**
	* Removes all the ho so mot cuas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so mot cuas where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the number of ho so mot cuas where MaSoHoSo = &#63; and TrangThaiXuLy = &#63;.
	*
	* @param MaSoHoSo the ma so ho so
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaSoHoSo(java.lang.String MaSoHoSo,
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaSoHoSo(MaSoHoSo, TrangThaiXuLy);
	}

	/**
	* Returns the number of ho so mot cuas.
	*
	* @return the number of ho so mot cuas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoSoMotCuaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoMotCuaPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					HoSoMotCuaPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoMotCuaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoMotCuaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoMotCuaUtil.class, "_persistence");
	}

	private static HoSoMotCuaPersistence _persistence;
}