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

import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;

import java.util.List;

/**
 * The persistence utility for the so danh muc service. This utility wraps {@link SoDanhMucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see SoDanhMucPersistence
 * @see SoDanhMucPersistenceImpl
 * @generated
 */
public class SoDanhMucUtil {
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
	public static void clearCache(SoDanhMuc soDanhMuc) {
		getPersistence().clearCache(soDanhMuc);
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
	public static List<SoDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SoDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SoDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SoDanhMuc update(SoDanhMuc soDanhMuc, boolean merge)
		throws SystemException {
		return getPersistence().update(soDanhMuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SoDanhMuc update(SoDanhMuc soDanhMuc, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(soDanhMuc, merge, serviceContext);
	}

	/**
	* Caches the so danh muc in the entity cache if it is enabled.
	*
	* @param soDanhMuc the so danh muc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc) {
		getPersistence().cacheResult(soDanhMuc);
	}

	/**
	* Caches the so danh mucs in the entity cache if it is enabled.
	*
	* @param soDanhMucs the so danh mucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> soDanhMucs) {
		getPersistence().cacheResult(soDanhMucs);
	}

	/**
	* Creates a new so danh muc with the primary key. Does not add the so danh muc to the database.
	*
	* @param id the primary key for the new so danh muc
	* @return the new so danh muc
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the so danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc that was removed
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(soDanhMuc, merge);
	}

	/**
	* Returns the so danh muc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException} if it could not be found.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the so danh muc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the so danh muc
	* @return the so danh muc, or <code>null</code> if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoTTHCID(thuTucHanhChinhId, start, end);
	}

	/**
	* Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCID(
		java.lang.Long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCID(thuTucHanhChinhId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCID_First(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCID_First(thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCID_Last(
		java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCID_Last(thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoTTHCID_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCID_PrevAndNext(id, thuTucHanhChinhId,
			orderByComparator);
	}

	/**
	* Returns all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTheoCOQUANQUANLYID(coQuanQuanLiId);
	}

	/**
	* Returns a range of all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoCOQUANQUANLYID(coQuanQuanLiId, start, end);
	}

	/**
	* Returns an ordered range of all the so danh mucs where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoCOQUANQUANLYID(
		java.lang.Long coQuanQuanLiId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoCOQUANQUANLYID(coQuanQuanLiId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoCOQUANQUANLYID_First(
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoCOQUANQUANLYID_First(coQuanQuanLiId,
			orderByComparator);
	}

	/**
	* Returns the last so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoCOQUANQUANLYID_Last(
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoCOQUANQUANLYID_Last(coQuanQuanLiId,
			orderByComparator);
	}

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoCOQUANQUANLYID_PrevAndNext(
		long id, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoCOQUANQUANLYID_PrevAndNext(id, coQuanQuanLiId,
			orderByComparator);
	}

	/**
	* Returns all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId);
	}

	/**
	* Returns a range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId,
			coQuanQuanLiId, start, end);
	}

	/**
	* Returns an ordered range of all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID(thuTucHanhChinhId,
			coQuanQuanLiId, start, end, orderByComparator);
	}

	/**
	* Returns the first so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCIDAndCQQLID_First(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID_First(thuTucHanhChinhId,
			coQuanQuanLiId, orderByComparator);
	}

	/**
	* Returns the last so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a matching so danh muc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc findByTheoTTHCIDAndCQQLID_Last(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID_Last(thuTucHanhChinhId,
			coQuanQuanLiId, orderByComparator);
	}

	/**
	* Returns the so danh mucs before and after the current so danh muc in the ordered set where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current so danh muc
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next so danh muc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException if a so danh muc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.chungthuc.model.SoDanhMuc[] findByTheoTTHCIDAndCQQLID_PrevAndNext(
		long id, java.lang.Long thuTucHanhChinhId,
		java.lang.Long coQuanQuanLiId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchSoDanhMucException {
		return getPersistence()
				   .findByTheoTTHCIDAndCQQLID_PrevAndNext(id,
			thuTucHanhChinhId, coQuanQuanLiId, orderByComparator);
	}

	/**
	* Returns all the so danh mucs.
	*
	* @return the so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the so danh mucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the so danh mucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the so danh mucs where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Removes all the so danh mucs where coQuanQuanLiId = &#63; from the database.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoCOQUANQUANLYID(java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTheoCOQUANQUANLYID(coQuanQuanLiId);
	}

	/**
	* Removes all the so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId);
	}

	/**
	* Removes all the so danh mucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of so danh mucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoTTHCID(java.lang.Long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTheoTTHCID(thuTucHanhChinhId);
	}

	/**
	* Returns the number of so danh mucs where coQuanQuanLiId = &#63;.
	*
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoCOQUANQUANLYID(java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTheoCOQUANQUANLYID(coQuanQuanLiId);
	}

	/**
	* Returns the number of so danh mucs where thuTucHanhChinhId = &#63; and coQuanQuanLiId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param coQuanQuanLiId the co quan quan li ID
	* @return the number of matching so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTheoTTHCIDAndCQQLID(
		java.lang.Long thuTucHanhChinhId, java.lang.Long coQuanQuanLiId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTheoTTHCIDAndCQQLID(thuTucHanhChinhId, coQuanQuanLiId);
	}

	/**
	* Returns the number of so danh mucs.
	*
	* @return the number of so danh mucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the ho so chung thucs associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @return the ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHoSoChungThucs(pk);
	}

	/**
	* Returns a range of all the ho so chung thucs associated with the so danh muc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the so danh muc
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @return the range of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHoSoChungThucs(pk, start, end);
	}

	/**
	* Returns an ordered range of all the ho so chung thucs associated with the so danh muc.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the so danh muc
	* @param start the lower bound of the range of so danh mucs
	* @param end the upper bound of the range of so danh mucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.chungthuc.model.HoSoChungThuc> getHoSoChungThucs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getHoSoChungThucs(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of ho so chung thucs associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @return the number of ho so chung thucs associated with the so danh muc
	* @throws SystemException if a system exception occurred
	*/
	public static int getHoSoChungThucsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getHoSoChungThucsSize(pk);
	}

	/**
	* Returns <code>true</code> if the ho so chung thuc is associated with the so danh muc.
	*
	* @param pk the primary key of the so danh muc
	* @param hoSoChungThucPK the primary key of the ho so chung thuc
	* @return <code>true</code> if the ho so chung thuc is associated with the so danh muc; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsHoSoChungThuc(long pk, long hoSoChungThucPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsHoSoChungThuc(pk, hoSoChungThucPK);
	}

	/**
	* Returns <code>true</code> if the so danh muc has any ho so chung thucs associated with it.
	*
	* @param pk the primary key of the so danh muc to check for associations with ho so chung thucs
	* @return <code>true</code> if the so danh muc has any ho so chung thucs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsHoSoChungThucs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsHoSoChungThucs(pk);
	}

	public static SoDanhMucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SoDanhMucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.chungthuc.service.ClpSerializer.getServletContextName(),
					SoDanhMucPersistence.class.getName());

			ReferenceRegistry.registerReference(SoDanhMucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(SoDanhMucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(SoDanhMucUtil.class, "_persistence");
	}

	private static SoDanhMucPersistence _persistence;
}