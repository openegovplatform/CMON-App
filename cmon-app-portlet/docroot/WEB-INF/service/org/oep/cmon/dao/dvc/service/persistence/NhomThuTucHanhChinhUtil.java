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

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;

import java.util.List;

/**
 * The persistence utility for the nhom thu tuc hanh chinh service. This utility wraps {@link NhomThuTucHanhChinhPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see NhomThuTucHanhChinhPersistence
 * @see NhomThuTucHanhChinhPersistenceImpl
 * @generated
 */
public class NhomThuTucHanhChinhUtil {
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
	public static void clearCache(NhomThuTucHanhChinh nhomThuTucHanhChinh) {
		getPersistence().clearCache(nhomThuTucHanhChinh);
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
	public static List<NhomThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NhomThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NhomThuTucHanhChinh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NhomThuTucHanhChinh update(
		NhomThuTucHanhChinh nhomThuTucHanhChinh, boolean merge)
		throws SystemException {
		return getPersistence().update(nhomThuTucHanhChinh, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NhomThuTucHanhChinh update(
		NhomThuTucHanhChinh nhomThuTucHanhChinh, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(nhomThuTucHanhChinh, merge, serviceContext);
	}

	/**
	* Caches the nhom thu tuc hanh chinh in the entity cache if it is enabled.
	*
	* @param nhomThuTucHanhChinh the nhom thu tuc hanh chinh
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh nhomThuTucHanhChinh) {
		getPersistence().cacheResult(nhomThuTucHanhChinh);
	}

	/**
	* Caches the nhom thu tuc hanh chinhs in the entity cache if it is enabled.
	*
	* @param nhomThuTucHanhChinhs the nhom thu tuc hanh chinhs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> nhomThuTucHanhChinhs) {
		getPersistence().cacheResult(nhomThuTucHanhChinhs);
	}

	/**
	* Creates a new nhom thu tuc hanh chinh with the primary key. Does not add the nhom thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new nhom thu tuc hanh chinh
	* @return the new nhom thu tuc hanh chinh
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the nhom thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nhom thu tuc hanh chinh
	* @return the nhom thu tuc hanh chinh that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh nhomThuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nhomThuTucHanhChinh, merge);
	}

	/**
	* Returns the nhom thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the nhom thu tuc hanh chinh
	* @return the nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the nhom thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nhom thu tuc hanh chinh
	* @return the nhom thu tuc hanh chinh, or <code>null</code> if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the nhom thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the nhom thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @return the range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the nhom thu tuc hanh chinhs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first nhom thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last nhom thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the nhom thu tuc hanh chinhs before and after the current nhom thu tuc hanh chinh in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nhom thu tuc hanh chinh
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the nhom thu tuc hanh chinhs where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @return the matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByDanhMucUngDungId(
		long danhMucUngDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDanhMucUngDungId(danhMucUngDungId, daXoa);
	}

	/**
	* Returns a range of all the nhom thu tuc hanh chinhs where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @return the range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByDanhMucUngDungId(
		long danhMucUngDungId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDanhMucUngDungId(danhMucUngDungId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the nhom thu tuc hanh chinhs where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByDanhMucUngDungId(
		long danhMucUngDungId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDanhMucUngDungId(danhMucUngDungId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first nhom thu tuc hanh chinh in the ordered set where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByDanhMucUngDungId_First(
		long danhMucUngDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence()
				   .findByDanhMucUngDungId_First(danhMucUngDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last nhom thu tuc hanh chinh in the ordered set where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByDanhMucUngDungId_Last(
		long danhMucUngDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence()
				   .findByDanhMucUngDungId_Last(danhMucUngDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the nhom thu tuc hanh chinhs before and after the current nhom thu tuc hanh chinh in the ordered set where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nhom thu tuc hanh chinh
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh[] findByDanhMucUngDungId_PrevAndNext(
		long id, long danhMucUngDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence()
				   .findByDanhMucUngDungId_PrevAndNext(id, danhMucUngDungId,
			daXoa, orderByComparator);
	}

	/**
	* Returns all the nhom thu tuc hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the nhom thu tuc hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @return the range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the nhom thu tuc hanh chinhs where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first nhom thu tuc hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last nhom thu tuc hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the nhom thu tuc hanh chinhs before and after the current nhom thu tuc hanh chinh in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nhom thu tuc hanh chinh
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a nhom thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns the nhom thu tuc hanh chinh where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching nhom thu tuc hanh chinh
	* @throws org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh findByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		return getPersistence().findByByMa(ma);
	}

	/**
	* Returns the nhom thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching nhom thu tuc hanh chinh, or <code>null</code> if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh fetchByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma);
	}

	/**
	* Returns the nhom thu tuc hanh chinh where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching nhom thu tuc hanh chinh, or <code>null</code> if a matching nhom thu tuc hanh chinh could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh fetchByByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma, retrieveFromCache);
	}

	/**
	* Returns all the nhom thu tuc hanh chinhs.
	*
	* @return the nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the nhom thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @return the range of nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the nhom thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nhom thu tuc hanh chinhs
	* @param end the upper bound of the range of nhom thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the nhom thu tuc hanh chinhs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the nhom thu tuc hanh chinhs where danhMucUngDungId = &#63; and daXoa = &#63; from the database.
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDanhMucUngDungId(long danhMucUngDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDanhMucUngDungId(danhMucUngDungId, daXoa);
	}

	/**
	* Removes all the nhom thu tuc hanh chinhs where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the nhom thu tuc hanh chinh where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchNhomThuTucHanhChinhException {
		getPersistence().removeByByMa(ma);
	}

	/**
	* Removes all the nhom thu tuc hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of nhom thu tuc hanh chinhs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of nhom thu tuc hanh chinhs where danhMucUngDungId = &#63; and daXoa = &#63;.
	*
	* @param danhMucUngDungId the danh muc ung dung ID
	* @param daXoa the da xoa
	* @return the number of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDanhMucUngDungId(long danhMucUngDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDanhMucUngDungId(danhMucUngDungId, daXoa);
	}

	/**
	* Returns the number of nhom thu tuc hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of nhom thu tuc hanh chinhs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByMa(ma);
	}

	/**
	* Returns the number of nhom thu tuc hanh chinhs.
	*
	* @return the number of nhom thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NhomThuTucHanhChinhPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NhomThuTucHanhChinhPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					NhomThuTucHanhChinhPersistence.class.getName());

			ReferenceRegistry.registerReference(NhomThuTucHanhChinhUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(NhomThuTucHanhChinhPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(NhomThuTucHanhChinhUtil.class,
			"_persistence");
	}

	private static NhomThuTucHanhChinhPersistence _persistence;
}