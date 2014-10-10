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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;

import java.util.List;

/**
 * The persistence utility for the cap don vi hanh chinh service. This utility wraps {@link CapDonViHanhChinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CapDonViHanhChinhPersistence
 * @see CapDonViHanhChinhPersistenceImpl
 * @generated
 */
public class CapDonViHanhChinhUtil {
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
	public static void clearCache(CapDonViHanhChinh capDonViHanhChinh) {
		getPersistence().clearCache(capDonViHanhChinh);
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
	public static List<CapDonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CapDonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CapDonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CapDonViHanhChinh update(
		CapDonViHanhChinh capDonViHanhChinh, boolean merge)
		throws SystemException {
		return getPersistence().update(capDonViHanhChinh, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CapDonViHanhChinh update(
		CapDonViHanhChinh capDonViHanhChinh, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(capDonViHanhChinh, merge, serviceContext);
	}

	/**
	* Caches the cap don vi hanh chinh in the entity cache if it is enabled.
	*
	* @param capDonViHanhChinh the cap don vi hanh chinh
	*/
	public static void cacheResult(
		org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh capDonViHanhChinh) {
		getPersistence().cacheResult(capDonViHanhChinh);
	}

	/**
	* Caches the cap don vi hanh chinhs in the entity cache if it is enabled.
	*
	* @param capDonViHanhChinhs the cap don vi hanh chinhs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> capDonViHanhChinhs) {
		getPersistence().cacheResult(capDonViHanhChinhs);
	}

	/**
	* Creates a new cap don vi hanh chinh with the primary key. Does not add the cap don vi hanh chinh to the database.
	*
	* @param id the primary key for the new cap don vi hanh chinh
	* @return the new cap don vi hanh chinh
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cap don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap don vi hanh chinh
	* @return the cap don vi hanh chinh that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh updateImpl(
		org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh capDonViHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(capDonViHanhChinh, merge);
	}

	/**
	* Returns the cap don vi hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the cap don vi hanh chinh
	* @return the cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cap don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cap don vi hanh chinh
	* @return the cap don vi hanh chinh, or <code>null</code> if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cap don vi hanh chinhs where cap = &#63;.
	*
	* @param cap the cap
	* @return the matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByCap(
		long cap) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCap(cap);
	}

	/**
	* Returns a range of all the cap don vi hanh chinhs where cap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @return the range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByCap(
		long cap, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCap(cap, start, end);
	}

	/**
	* Returns an ordered range of all the cap don vi hanh chinhs where cap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByCap(
		long cap, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCap(cap, start, end, orderByComparator);
	}

	/**
	* Returns the first cap don vi hanh chinh in the ordered set where cap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByCap_First(
		long cap,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByCap_First(cap, orderByComparator);
	}

	/**
	* Returns the last cap don vi hanh chinh in the ordered set where cap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param cap the cap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByCap_Last(
		long cap,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByCap_Last(cap, orderByComparator);
	}

	/**
	* Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where cap = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap don vi hanh chinh
	* @param cap the cap
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh[] findByCap_PrevAndNext(
		long id, long cap,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByCap_PrevAndNext(id, cap, orderByComparator);
	}

	/**
	* Returns all the cap don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the cap don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @return the range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the cap don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first cap don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last cap don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap don vi hanh chinh
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the cap don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the cap don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @return the range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the cap don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first cap don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last cap don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap don vi hanh chinh
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns the cap don vi hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByMaDonViHanhChinh(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByMaDonViHanhChinh(ma);
	}

	/**
	* Returns the cap don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh fetchByMaDonViHanhChinh(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaDonViHanhChinh(ma);
	}

	/**
	* Returns the cap don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh fetchByMaDonViHanhChinh(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaDonViHanhChinh(ma, retrieveFromCache);
	}

	/**
	* Returns the cap don vi hanh chinh where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByTenDonViHanhChinh(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTenDonViHanhChinh(ten);
	}

	/**
	* Returns the cap don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh fetchByTenDonViHanhChinh(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTenDonViHanhChinh(ten);
	}

	/**
	* Returns the cap don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cap don vi hanh chinh, or <code>null</code> if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh fetchByTenDonViHanhChinh(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTenDonViHanhChinh(ten, retrieveFromCache);
	}

	/**
	* Returns all the cap don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the cap don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @return the range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the cap don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a matching cap don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the cap don vi hanh chinhs before and after the current cap don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cap don vi hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cap don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException if a cap don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the cap don vi hanh chinhs.
	*
	* @return the cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cap don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @return the range of cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cap don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap don vi hanh chinhs
	* @param end the upper bound of the range of cap don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cap don vi hanh chinhs where cap = &#63; from the database.
	*
	* @param cap the cap
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCap(long cap)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCap(cap);
	}

	/**
	* Removes all the cap don vi hanh chinhs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the cap don vi hanh chinhs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes the cap don vi hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaDonViHanhChinh(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		getPersistence().removeByMaDonViHanhChinh(ma);
	}

	/**
	* Removes the cap don vi hanh chinh where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenDonViHanhChinh(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCapDonViHanhChinhException {
		getPersistence().removeByTenDonViHanhChinh(ten);
	}

	/**
	* Removes all the cap don vi hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the cap don vi hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cap don vi hanh chinhs where cap = &#63;.
	*
	* @param cap the cap
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCap(long cap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCap(cap);
	}

	/**
	* Returns the number of cap don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of cap don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of cap don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaDonViHanhChinh(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaDonViHanhChinh(ma);
	}

	/**
	* Returns the number of cap don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenDonViHanhChinh(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenDonViHanhChinh(ten);
	}

	/**
	* Returns the number of cap don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of cap don vi hanh chinhs.
	*
	* @return the number of cap don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CapDonViHanhChinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CapDonViHanhChinhPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					CapDonViHanhChinhPersistence.class.getName());

			ReferenceRegistry.registerReference(CapDonViHanhChinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CapDonViHanhChinhPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CapDonViHanhChinhUtil.class,
			"_persistence");
	}

	private static CapDonViHanhChinhPersistence _persistence;
}