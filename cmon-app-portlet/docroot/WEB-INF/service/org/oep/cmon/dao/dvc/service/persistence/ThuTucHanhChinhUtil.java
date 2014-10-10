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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;

import java.util.List;

/**
 * The persistence utility for the thu tuc hanh chinh service. This utility wraps {@link ThuTucHanhChinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTucHanhChinhPersistence
 * @see ThuTucHanhChinhPersistenceImpl
 * @generated
 */
public class ThuTucHanhChinhUtil {
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
	public static void clearCache(ThuTucHanhChinh thuTucHanhChinh) {
		getPersistence().clearCache(thuTucHanhChinh);
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
	public static List<ThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ThuTucHanhChinh update(ThuTucHanhChinh thuTucHanhChinh,
		boolean merge) throws SystemException {
		return getPersistence().update(thuTucHanhChinh, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ThuTucHanhChinh update(ThuTucHanhChinh thuTucHanhChinh,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(thuTucHanhChinh, merge, serviceContext);
	}

	/**
	* Caches the thu tuc hanh chinh in the entity cache if it is enabled.
	*
	* @param thuTucHanhChinh the thu tuc hanh chinh
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh) {
		getPersistence().cacheResult(thuTucHanhChinh);
	}

	/**
	* Caches the thu tuc hanh chinhs in the entity cache if it is enabled.
	*
	* @param thuTucHanhChinhs the thu tuc hanh chinhs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> thuTucHanhChinhs) {
		getPersistence().cacheResult(thuTucHanhChinhs);
	}

	/**
	* Creates a new thu tuc hanh chinh with the primary key. Does not add the thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new thu tuc hanh chinh
	* @return the new thu tuc hanh chinh
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTucHanhChinh thuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(thuTucHanhChinh, merge);
	}

	/**
	* Returns the thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thu tuc hanh chinh
	* @return the thu tuc hanh chinh, or <code>null</code> if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching thu tuc hanh chinh, or <code>null</code> if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns all the thu tuc hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the thu tuc hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa);
	}

	/**
	* Returns a range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa,
			start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa,
			start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByNhomDanhMucHanhChinh_First(
		long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh_First(nhomThuTucHanhChinhId,
			daXoa, orderByComparator);
	}

	/**
	* Returns the last thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a matching thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh findByNhomDanhMucHanhChinh_Last(
		long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh_Last(nhomThuTucHanhChinhId,
			daXoa, orderByComparator);
	}

	/**
	* Returns the thu tuc hanh chinhs before and after the current thu tuc hanh chinh in the ordered set where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc hanh chinh
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException if a thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTucHanhChinh[] findByNhomDanhMucHanhChinh_PrevAndNext(
		long id, long nhomThuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		return getPersistence()
				   .findByNhomDanhMucHanhChinh_PrevAndNext(id,
			nhomThuTucHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns all the thu tuc hanh chinhs.
	*
	* @return the thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @return the range of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc hanh chinhs
	* @param end the upper bound of the range of thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTucHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the thu tuc hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes the thu tuc hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTucHanhChinhException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the thu tuc hanh chinhs where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNhomDanhMucHanhChinh(
		long nhomThuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa);
	}

	/**
	* Removes all the thu tuc hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of thu tuc hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of thu tuc hanh chinhs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of thu tuc hanh chinhs where nhomThuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param nhomThuTucHanhChinhId the nhom thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNhomDanhMucHanhChinh(long nhomThuTucHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNhomDanhMucHanhChinh(nhomThuTucHanhChinhId, daXoa);
	}

	/**
	* Returns the number of thu tuc hanh chinhs.
	*
	* @return the number of thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThuTucHanhChinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThuTucHanhChinhPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					ThuTucHanhChinhPersistence.class.getName());

			ReferenceRegistry.registerReference(ThuTucHanhChinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ThuTucHanhChinhPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ThuTucHanhChinhUtil.class,
			"_persistence");
	}

	private static ThuTucHanhChinhPersistence _persistence;
}