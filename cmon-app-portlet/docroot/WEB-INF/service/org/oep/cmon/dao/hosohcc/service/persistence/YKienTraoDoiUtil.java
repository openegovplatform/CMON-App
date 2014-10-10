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

import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;

import java.util.List;

/**
 * The persistence utility for the y kien trao doi service. This utility wraps {@link YKienTraoDoiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see YKienTraoDoiPersistence
 * @see YKienTraoDoiPersistenceImpl
 * @generated
 */
public class YKienTraoDoiUtil {
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
	public static void clearCache(YKienTraoDoi yKienTraoDoi) {
		getPersistence().clearCache(yKienTraoDoi);
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
	public static List<YKienTraoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YKienTraoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YKienTraoDoi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YKienTraoDoi update(YKienTraoDoi yKienTraoDoi, boolean merge)
		throws SystemException {
		return getPersistence().update(yKienTraoDoi, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YKienTraoDoi update(YKienTraoDoi yKienTraoDoi, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(yKienTraoDoi, merge, serviceContext);
	}

	/**
	* Caches the y kien trao doi in the entity cache if it is enabled.
	*
	* @param yKienTraoDoi the y kien trao doi
	*/
	public static void cacheResult(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi) {
		getPersistence().cacheResult(yKienTraoDoi);
	}

	/**
	* Caches the y kien trao dois in the entity cache if it is enabled.
	*
	* @param yKienTraoDois the y kien trao dois
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> yKienTraoDois) {
		getPersistence().cacheResult(yKienTraoDois);
	}

	/**
	* Creates a new y kien trao doi with the primary key. Does not add the y kien trao doi to the database.
	*
	* @param id the primary key for the new y kien trao doi
	* @return the new y kien trao doi
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the y kien trao doi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi updateImpl(
		org.oep.cmon.dao.hosohcc.model.YKienTraoDoi yKienTraoDoi, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(yKienTraoDoi, merge);
	}

	/**
	* Returns the y kien trao doi with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException} if it could not be found.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the y kien trao doi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the y kien trao doi
	* @return the y kien trao doi, or <code>null</code> if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the y kien trao dois where loai = &#63;.
	*
	* @param loai the loai
	* @return the matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoai(loai);
	}

	/**
	* Returns a range of all the y kien trao dois where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoai(loai, start, end);
	}

	/**
	* Returns an ordered range of all the y kien trao dois where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByLoai(
		long loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLoai(loai, start, end, orderByComparator);
	}

	/**
	* Returns the first y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByLoai_First(
		long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence().findByLoai_First(loai, orderByComparator);
	}

	/**
	* Returns the last y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByLoai_Last(
		long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence().findByLoai_Last(loai, orderByComparator);
	}

	/**
	* Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current y kien trao doi
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi[] findByLoai_PrevAndNext(
		long id, long loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence()
				   .findByLoai_PrevAndNext(id, loai, orderByComparator);
	}

	/**
	* Returns all the y kien trao dois where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai);
	}

	/**
	* Returns a range of all the y kien trao dois where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(trangThai, start, end);
	}

	/**
	* Returns an ordered range of all the y kien trao dois where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findByTrangThai(
		long trangThai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(trangThai, start, end, orderByComparator);
	}

	/**
	* Returns the first y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByTrangThai_First(
		long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence()
				   .findByTrangThai_First(trangThai, orderByComparator);
	}

	/**
	* Returns the last y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a matching y kien trao doi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi findByTrangThai_Last(
		long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence()
				   .findByTrangThai_Last(trangThai, orderByComparator);
	}

	/**
	* Returns the y kien trao dois before and after the current y kien trao doi in the ordered set where trangThai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current y kien trao doi
	* @param trangThai the trang thai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next y kien trao doi
	* @throws org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException if a y kien trao doi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.YKienTraoDoi[] findByTrangThai_PrevAndNext(
		long id, long trangThai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchYKienTraoDoiException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, trangThai, orderByComparator);
	}

	/**
	* Returns all the y kien trao dois.
	*
	* @return the y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the y kien trao dois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @return the range of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the y kien trao dois.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of y kien trao dois
	* @param end the upper bound of the range of y kien trao dois (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.YKienTraoDoi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the y kien trao dois where loai = &#63; from the database.
	*
	* @param loai the loai
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLoai(long loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLoai(loai);
	}

	/**
	* Removes all the y kien trao dois where trangThai = &#63; from the database.
	*
	* @param trangThai the trang thai
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(trangThai);
	}

	/**
	* Removes all the y kien trao dois from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of y kien trao dois where loai = &#63;.
	*
	* @param loai the loai
	* @return the number of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLoai(long loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLoai(loai);
	}

	/**
	* Returns the number of y kien trao dois where trangThai = &#63;.
	*
	* @param trangThai the trang thai
	* @return the number of matching y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(long trangThai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(trangThai);
	}

	/**
	* Returns the number of y kien trao dois.
	*
	* @return the number of y kien trao dois
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YKienTraoDoiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YKienTraoDoiPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					YKienTraoDoiPersistence.class.getName());

			ReferenceRegistry.registerReference(YKienTraoDoiUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(YKienTraoDoiPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(YKienTraoDoiUtil.class,
			"_persistence");
	}

	private static YKienTraoDoiPersistence _persistence;
}