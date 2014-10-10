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

import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;

import java.util.List;

/**
 * The persistence utility for the cong chuc2 nhom thu tuc service. This utility wraps {@link CongChuc2NhomThuTucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see CongChuc2NhomThuTucPersistence
 * @see CongChuc2NhomThuTucPersistenceImpl
 * @generated
 */
public class CongChuc2NhomThuTucUtil {
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
	public static void clearCache(CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		getPersistence().clearCache(congChuc2NhomThuTuc);
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
	public static List<CongChuc2NhomThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CongChuc2NhomThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CongChuc2NhomThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CongChuc2NhomThuTuc update(
		CongChuc2NhomThuTuc congChuc2NhomThuTuc, boolean merge)
		throws SystemException {
		return getPersistence().update(congChuc2NhomThuTuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CongChuc2NhomThuTuc update(
		CongChuc2NhomThuTuc congChuc2NhomThuTuc, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(congChuc2NhomThuTuc, merge, serviceContext);
	}

	/**
	* Caches the cong chuc2 nhom thu tuc in the entity cache if it is enabled.
	*
	* @param congChuc2NhomThuTuc the cong chuc2 nhom thu tuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc) {
		getPersistence().cacheResult(congChuc2NhomThuTuc);
	}

	/**
	* Caches the cong chuc2 nhom thu tucs in the entity cache if it is enabled.
	*
	* @param congChuc2NhomThuTucs the cong chuc2 nhom thu tucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> congChuc2NhomThuTucs) {
		getPersistence().cacheResult(congChuc2NhomThuTucs);
	}

	/**
	* Creates a new cong chuc2 nhom thu tuc with the primary key. Does not add the cong chuc2 nhom thu tuc to the database.
	*
	* @param id the primary key for the new cong chuc2 nhom thu tuc
	* @return the new cong chuc2 nhom thu tuc
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cong chuc2 nhom thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc that was removed
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc updateImpl(
		org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc congChuc2NhomThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(congChuc2NhomThuTuc, merge);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc with the primary key or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong chuc2 nhom thu tuc
	* @return the cong chuc2 nhom thu tuc, or <code>null</code> if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param id the ID
	* @return the matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findById(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchById(
		long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Returns all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @return the matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCongChuc(congChucId);
	}

	/**
	* Returns a range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @return the range of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCongChuc(congChucId, start, end);
	}

	/**
	* Returns an ordered range of all the cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findByCongChuc(
		long congChucId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCongChuc(congChucId, start, end, orderByComparator);
	}

	/**
	* Returns the first cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChuc_First(
		long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence()
				   .findByCongChuc_First(congChucId, orderByComparator);
	}

	/**
	* Returns the last cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChuc_Last(
		long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence()
				   .findByCongChuc_Last(congChucId, orderByComparator);
	}

	/**
	* Returns the cong chuc2 nhom thu tucs before and after the current cong chuc2 nhom thu tuc in the ordered set where congChucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong chuc2 nhom thu tuc
	* @param congChucId the cong chuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a cong chuc2 nhom thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc[] findByCongChuc_PrevAndNext(
		long id, long congChucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence()
				   .findByCongChuc_PrevAndNext(id, congChucId, orderByComparator);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or throws a {@link org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException} if it could not be found.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the matching cong chuc2 nhom thu tuc
	* @throws org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc findByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		return getPersistence()
				   .findByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
	}

	/**
	* Returns the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong chuc2 nhom thu tuc, or <code>null</code> if a matching cong chuc2 nhom thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc fetchByCongChucAndNhomThuTuc(
		long congChucId, long nhomThuTucId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCongChucAndNhomThuTuc(congChucId, nhomThuTucId,
			retrieveFromCache);
	}

	/**
	* Returns all the cong chuc2 nhom thu tucs.
	*
	* @return the cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cong chuc2 nhom thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @return the range of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cong chuc2 nhom thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 nhom thu tucs
	* @param end the upper bound of the range of cong chuc2 nhom thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the cong chuc2 nhom thu tuc where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		getPersistence().removeById(id);
	}

	/**
	* Removes all the cong chuc2 nhom thu tucs where congChucId = &#63; from the database.
	*
	* @param congChucId the cong chuc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCongChuc(long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCongChuc(congChucId);
	}

	/**
	* Removes the cong chuc2 nhom thu tuc where congChucId = &#63; and nhomThuTucId = &#63; from the database.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCongChucAndNhomThuTuc(long congChucId,
		long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cc.NoSuchCongChuc2NhomThuTucException {
		getPersistence().removeByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
	}

	/**
	* Removes all the cong chuc2 nhom thu tucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cong chuc2 nhom thu tucs where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCongChuc(long congChucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCongChuc(congChucId);
	}

	/**
	* Returns the number of cong chuc2 nhom thu tucs where congChucId = &#63; and nhomThuTucId = &#63;.
	*
	* @param congChucId the cong chuc ID
	* @param nhomThuTucId the nhom thu tuc ID
	* @return the number of matching cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCongChucAndNhomThuTuc(long congChucId,
		long nhomThuTucId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCongChucAndNhomThuTuc(congChucId, nhomThuTucId);
	}

	/**
	* Returns the number of cong chuc2 nhom thu tucs.
	*
	* @return the number of cong chuc2 nhom thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CongChuc2NhomThuTucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CongChuc2NhomThuTucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cc.service.ClpSerializer.getServletContextName(),
					CongChuc2NhomThuTucPersistence.class.getName());

			ReferenceRegistry.registerReference(CongChuc2NhomThuTucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CongChuc2NhomThuTucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CongChuc2NhomThuTucUtil.class,
			"_persistence");
	}

	private static CongChuc2NhomThuTucPersistence _persistence;
}