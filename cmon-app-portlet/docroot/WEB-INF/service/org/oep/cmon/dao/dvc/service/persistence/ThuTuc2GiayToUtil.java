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

import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;

import java.util.List;

/**
 * The persistence utility for the thu tuc2 giay to service. This utility wraps {@link ThuTuc2GiayToPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see ThuTuc2GiayToPersistence
 * @see ThuTuc2GiayToPersistenceImpl
 * @generated
 */
public class ThuTuc2GiayToUtil {
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
	public static void clearCache(ThuTuc2GiayTo thuTuc2GiayTo) {
		getPersistence().clearCache(thuTuc2GiayTo);
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
	public static List<ThuTuc2GiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThuTuc2GiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThuTuc2GiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ThuTuc2GiayTo update(ThuTuc2GiayTo thuTuc2GiayTo,
		boolean merge) throws SystemException {
		return getPersistence().update(thuTuc2GiayTo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ThuTuc2GiayTo update(ThuTuc2GiayTo thuTuc2GiayTo,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(thuTuc2GiayTo, merge, serviceContext);
	}

	/**
	* Caches the thu tuc2 giay to in the entity cache if it is enabled.
	*
	* @param thuTuc2GiayTo the thu tuc2 giay to
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo) {
		getPersistence().cacheResult(thuTuc2GiayTo);
	}

	/**
	* Caches the thu tuc2 giay tos in the entity cache if it is enabled.
	*
	* @param thuTuc2GiayTos the thu tuc2 giay tos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> thuTuc2GiayTos) {
		getPersistence().cacheResult(thuTuc2GiayTos);
	}

	/**
	* Creates a new thu tuc2 giay to with the primary key. Does not add the thu tuc2 giay to to the database.
	*
	* @param id the primary key for the new thu tuc2 giay to
	* @return the new thu tuc2 giay to
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the thu tuc2 giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo updateImpl(
		org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo thuTuc2GiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(thuTuc2GiayTo, merge);
	}

	/**
	* Returns the thu tuc2 giay to with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException} if it could not be found.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the thu tuc2 giay to with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thu tuc2 giay to
	* @return the thu tuc2 giay to, or <code>null</code> if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan);
	}

	/**
	* Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan,
			start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuchanhChinh(
		long thuTucHanhChinhId, int daXoa, int giaidoan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan,
			start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuchanhChinh_First(
		long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuchanhChinh_First(thuTucHanhChinhId, daXoa,
			giaidoan, orderByComparator);
	}

	/**
	* Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuchanhChinh_Last(
		long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuchanhChinh_Last(thuTucHanhChinhId, daXoa,
			giaidoan, orderByComparator);
	}

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByThuTuchanhChinh_PrevAndNext(
		long id, long thuTucHanhChinhId, int daXoa, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuchanhChinh_PrevAndNext(id, thuTucHanhChinhId,
			daXoa, giaidoan, orderByComparator);
	}

	/**
	* Returns all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @return the matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan);
	}

	/**
	* Returns a range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan, start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findByThuTuc2GiayTo(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan, start, end, orderByComparator);
	}

	/**
	* Returns the first thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuc2GiayTo_First(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuc2GiayTo_First(thuTucHanhChinhId,
			danhMucGiayToId, giaidoan, orderByComparator);
	}

	/**
	* Returns the last thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a matching thu tuc2 giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo findByThuTuc2GiayTo_Last(
		long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuc2GiayTo_Last(thuTucHanhChinhId,
			danhMucGiayToId, giaidoan, orderByComparator);
	}

	/**
	* Returns the thu tuc2 giay tos before and after the current thu tuc2 giay to in the ordered set where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thu tuc2 giay to
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thu tuc2 giay to
	* @throws org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException if a thu tuc2 giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo[] findByThuTuc2GiayTo_PrevAndNext(
		long id, long thuTucHanhChinhId, long danhMucGiayToId, int giaidoan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchThuTuc2GiayToException {
		return getPersistence()
				   .findByThuTuc2GiayTo_PrevAndNext(id, thuTucHanhChinhId,
			danhMucGiayToId, giaidoan, orderByComparator);
	}

	/**
	* Returns all the thu tuc2 giay tos.
	*
	* @return the thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the thu tuc2 giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @return the range of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the thu tuc2 giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thu tuc2 giay tos
	* @param end the upper bound of the range of thu tuc2 giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the thu tuc2 giay tos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTuchanhChinh(long thuTucHanhChinhId,
		int daXoa, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan);
	}

	/**
	* Removes all the thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId, giaidoan);
	}

	/**
	* Removes all the thu tuc2 giay tos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of thu tuc2 giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and daXoa = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param giaidoan the giaidoan
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTuchanhChinh(long thuTucHanhChinhId, int daXoa,
		int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTuchanhChinh(thuTucHanhChinhId, daXoa, giaidoan);
	}

	/**
	* Returns the number of thu tuc2 giay tos where thuTucHanhChinhId = &#63; and danhMucGiayToId = &#63; and giaidoan = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param danhMucGiayToId the danh muc giay to ID
	* @param giaidoan the giaidoan
	* @return the number of matching thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTuc2GiayTo(long thuTucHanhChinhId,
		long danhMucGiayToId, int giaidoan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTuc2GiayTo(thuTucHanhChinhId, danhMucGiayToId,
			giaidoan);
	}

	/**
	* Returns the number of thu tuc2 giay tos.
	*
	* @return the number of thu tuc2 giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThuTuc2GiayToPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThuTuc2GiayToPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					ThuTuc2GiayToPersistence.class.getName());

			ReferenceRegistry.registerReference(ThuTuc2GiayToUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ThuTuc2GiayToPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ThuTuc2GiayToUtil.class,
			"_persistence");
	}

	private static ThuTuc2GiayToPersistence _persistence;
}