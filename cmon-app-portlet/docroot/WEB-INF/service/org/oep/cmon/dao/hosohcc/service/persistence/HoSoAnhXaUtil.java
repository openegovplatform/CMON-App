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

import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;

import java.util.List;

/**
 * The persistence utility for the ho so anh xa service. This utility wraps {@link HoSoAnhXaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see HoSoAnhXaPersistence
 * @see HoSoAnhXaPersistenceImpl
 * @generated
 */
public class HoSoAnhXaUtil {
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
	public static void clearCache(HoSoAnhXa hoSoAnhXa) {
		getPersistence().clearCache(hoSoAnhXa);
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
	public static List<HoSoAnhXa> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoAnhXa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoAnhXa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoAnhXa update(HoSoAnhXa hoSoAnhXa, boolean merge)
		throws SystemException {
		return getPersistence().update(hoSoAnhXa, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoAnhXa update(HoSoAnhXa hoSoAnhXa, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoAnhXa, merge, serviceContext);
	}

	/**
	* Caches the ho so anh xa in the entity cache if it is enabled.
	*
	* @param hoSoAnhXa the ho so anh xa
	*/
	public static void cacheResult(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa) {
		getPersistence().cacheResult(hoSoAnhXa);
	}

	/**
	* Caches the ho so anh xas in the entity cache if it is enabled.
	*
	* @param hoSoAnhXas the ho so anh xas
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> hoSoAnhXas) {
		getPersistence().cacheResult(hoSoAnhXas);
	}

	/**
	* Creates a new ho so anh xa with the primary key. Does not add the ho so anh xa to the database.
	*
	* @param id the primary key for the new ho so anh xa
	* @return the new ho so anh xa
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho so anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa updateImpl(
		org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoAnhXa, merge);
	}

	/**
	* Returns the ho so anh xa with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho so anh xa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so anh xa
	* @return the ho so anh xa, or <code>null</code> if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the ho so anh xa where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param id the ID
	* @return the matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the ho so anh xa where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchById(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException} if it could not be found.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the ho so anh xa where hoSoTTHCCongId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so anh xa, or <code>null</code> if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa fetchByHoSoTTHCCongId(
		long hoSoTTHCCongId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByHoSoTTHCCongId(hoSoTTHCCongId, retrieveFromCache);
	}

	/**
	* Returns all the ho so anh xas where maHoSo = &#63;.
	*
	* @param maHoSo the ma ho so
	* @return the matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaHoSo(maHoSo);
	}

	/**
	* Returns a range of all the ho so anh xas where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaHoSo(maHoSo, start, end);
	}

	/**
	* Returns an ordered range of all the ho so anh xas where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findByMaHoSo(
		java.lang.String maHoSo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaHoSo(maHoSo, start, end, orderByComparator);
	}

	/**
	* Returns the first ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByMaHoSo_First(
		java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().findByMaHoSo_First(maHoSo, orderByComparator);
	}

	/**
	* Returns the last ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a matching ho so anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa findByMaHoSo_Last(
		java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence().findByMaHoSo_Last(maHoSo, orderByComparator);
	}

	/**
	* Returns the ho so anh xas before and after the current ho so anh xa in the ordered set where maHoSo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so anh xa
	* @param maHoSo the ma ho so
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so anh xa
	* @throws org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException if a ho so anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.HoSoAnhXa[] findByMaHoSo_PrevAndNext(
		long id, java.lang.String maHoSo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		return getPersistence()
				   .findByMaHoSo_PrevAndNext(id, maHoSo, orderByComparator);
	}

	/**
	* Returns all the ho so anh xas.
	*
	* @return the ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @return the range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ho so anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so anh xas
	* @param end the upper bound of the range of ho so anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the ho so anh xa where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		getPersistence().removeById(id);
	}

	/**
	* Removes the ho so anh xa where hoSoTTHCCongId = &#63; from the database.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchHoSoAnhXaException {
		getPersistence().removeByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Removes all the ho so anh xas where maHoSo = &#63; from the database.
	*
	* @param maHoSo the ma ho so
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaHoSo(java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaHoSo(maHoSo);
	}

	/**
	* Removes all the ho so anh xas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so anh xas where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the number of ho so anh xas where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the number of ho so anh xas where maHoSo = &#63;.
	*
	* @param maHoSo the ma ho so
	* @return the number of matching ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaHoSo(java.lang.String maHoSo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaHoSo(maHoSo);
	}

	/**
	* Returns the number of ho so anh xas.
	*
	* @return the number of ho so anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoSoAnhXaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoAnhXaPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					HoSoAnhXaPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoAnhXaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoAnhXaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoAnhXaUtil.class, "_persistence");
	}

	private static HoSoAnhXaPersistence _persistence;
}