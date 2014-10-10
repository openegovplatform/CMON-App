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

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

import java.util.List;

/**
 * The persistence utility for the don vi hanh chinh service. This utility wraps {@link DonViHanhChinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see DonViHanhChinhPersistence
 * @see DonViHanhChinhPersistenceImpl
 * @generated
 */
public class DonViHanhChinhUtil {
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
	public static void clearCache(DonViHanhChinh donViHanhChinh) {
		getPersistence().clearCache(donViHanhChinh);
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
	public static List<DonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DonViHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DonViHanhChinh update(DonViHanhChinh donViHanhChinh,
		boolean merge) throws SystemException {
		return getPersistence().update(donViHanhChinh, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DonViHanhChinh update(DonViHanhChinh donViHanhChinh,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(donViHanhChinh, merge, serviceContext);
	}

	/**
	* Caches the don vi hanh chinh in the entity cache if it is enabled.
	*
	* @param donViHanhChinh the don vi hanh chinh
	*/
	public static void cacheResult(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh) {
		getPersistence().cacheResult(donViHanhChinh);
	}

	/**
	* Caches the don vi hanh chinhs in the entity cache if it is enabled.
	*
	* @param donViHanhChinhs the don vi hanh chinhs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> donViHanhChinhs) {
		getPersistence().cacheResult(donViHanhChinhs);
	}

	/**
	* Creates a new don vi hanh chinh with the primary key. Does not add the don vi hanh chinh to the database.
	*
	* @param id the primary key for the new don vi hanh chinh
	* @return the new don vi hanh chinh
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the don vi hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh updateImpl(
		org.oep.cmon.dao.qlhc.model.DonViHanhChinh donViHanhChinh, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(donViHanhChinh, merge);
	}

	/**
	* Returns the don vi hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the don vi hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the don vi hanh chinh
	* @return the don vi hanh chinh, or <code>null</code> if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa,
			start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByCapDonViHanhChinhId(
		long capDonViHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa,
			start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByCapDonViHanhChinhId_First(
		long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByCapDonViHanhChinhId_First(capDonViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByCapDonViHanhChinhId_Last(
		long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByCapDonViHanhChinhId_Last(capDonViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByCapDonViHanhChinhId_PrevAndNext(
		long id, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByCapDonViHanhChinhId_PrevAndNext(id,
			capDonViHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChaId(chaId, daXoa);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChaId(chaId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByChaId(
		java.lang.Long chaId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChaId(chaId, daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByChaId_First(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByChaId_First(chaId, daXoa, orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByChaId_Last(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByChaId_Last(chaId, daXoa, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByChaId_PrevAndNext(
		long id, java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByChaId_PrevAndNext(id, chaId, daXoa, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuocGiaId(quocGiaId);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByQuocGiaId(quocGiaId, start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByQuocGiaId(
		long quocGiaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByQuocGiaId(quocGiaId, start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByQuocGiaId_First(
		long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByQuocGiaId_First(quocGiaId, orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByQuocGiaId_Last(
		long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByQuocGiaId_Last(quocGiaId, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param quocGiaId the quoc gia ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByQuocGiaId_PrevAndNext(
		long id, long quocGiaId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByQuocGiaId_PrevAndNext(id, quocGiaId, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns the don vi hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByMaDVHC(ma);
	}

	/**
	* Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByMaDVHC(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaDVHC(ma);
	}

	/**
	* Returns the don vi hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByMaDVHC(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaDVHC(ma, retrieveFromCache);
	}

	/**
	* Returns the don vi hanh chinh where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence().findByTenDVHC(ten);
	}

	/**
	* Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByTenDVHC(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTenDVHC(ten);
	}

	/**
	* Returns the don vi hanh chinh where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching don vi hanh chinh, or <code>null</code> if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh fetchByTenDVHC(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTenDVHC(ten, retrieveFromCache);
	}

	/**
	* Returns all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);
	}

	/**
	* Returns a range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa,
			start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findByByQuocId(
		long quocGiaId, long capDonViHanhChinhId, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa,
			start, end, orderByComparator);
	}

	/**
	* Returns the first don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByByQuocId_First(
		long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByByQuocId_First(quocGiaId, capDonViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a matching don vi hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh findByByQuocId_Last(
		long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByByQuocId_Last(quocGiaId, capDonViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the don vi hanh chinhs before and after the current don vi hanh chinh in the ordered set where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current don vi hanh chinh
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next don vi hanh chinh
	* @throws org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException if a don vi hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.DonViHanhChinh[] findByByQuocId_PrevAndNext(
		long id, long quocGiaId, long capDonViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		return getPersistence()
				   .findByByQuocId_PrevAndNext(id, quocGiaId,
			capDonViHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns all the don vi hanh chinhs.
	*
	* @return the don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @return the range of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the don vi hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi hanh chinhs
	* @param end the upper bound of the range of don vi hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.DonViHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the don vi hanh chinhs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the don vi hanh chinhs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCapDonViHanhChinhId(long capDonViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa);
	}

	/**
	* Removes all the don vi hanh chinhs where chaId = &#63; and daXoa = &#63; from the database.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChaId(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChaId(chaId, daXoa);
	}

	/**
	* Removes all the don vi hanh chinhs where quocGiaId = &#63; from the database.
	*
	* @param quocGiaId the quoc gia ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByQuocGiaId(long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByQuocGiaId(quocGiaId);
	}

	/**
	* Removes all the don vi hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes the don vi hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaDVHC(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		getPersistence().removeByMaDVHC(ma);
	}

	/**
	* Removes the don vi hanh chinh where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTenDVHC(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchDonViHanhChinhException {
		getPersistence().removeByTenDVHC(ten);
	}

	/**
	* Removes all the don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByQuocId(long quocGiaId,
		long capDonViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);
	}

	/**
	* Removes all the don vi hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of don vi hanh chinhs where capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCapDonViHanhChinhId(long capDonViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCapDonViHanhChinhId(capDonViHanhChinhId, daXoa);
	}

	/**
	* Returns the number of don vi hanh chinhs where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChaId(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChaId(chaId, daXoa);
	}

	/**
	* Returns the number of don vi hanh chinhs where quocGiaId = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByQuocGiaId(long quocGiaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByQuocGiaId(quocGiaId);
	}

	/**
	* Returns the number of don vi hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of don vi hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaDVHC(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaDVHC(ma);
	}

	/**
	* Returns the number of don vi hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTenDVHC(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTenDVHC(ten);
	}

	/**
	* Returns the number of don vi hanh chinhs where quocGiaId = &#63; and capDonViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param quocGiaId the quoc gia ID
	* @param capDonViHanhChinhId the cap don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByQuocId(long quocGiaId, long capDonViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByByQuocId(quocGiaId, capDonViHanhChinhId, daXoa);
	}

	/**
	* Returns the number of don vi hanh chinhs.
	*
	* @return the number of don vi hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DonViHanhChinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DonViHanhChinhPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					DonViHanhChinhPersistence.class.getName());

			ReferenceRegistry.registerReference(DonViHanhChinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DonViHanhChinhPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DonViHanhChinhUtil.class,
			"_persistence");
	}

	private static DonViHanhChinhPersistence _persistence;
}