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

import org.oep.cmon.dao.qlhc.model.QuocGia;

import java.util.List;

/**
 * The persistence utility for the quoc gia service. This utility wraps {@link QuocGiaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see QuocGiaPersistence
 * @see QuocGiaPersistenceImpl
 * @generated
 */
public class QuocGiaUtil {
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
	public static void clearCache(QuocGia quocGia) {
		getPersistence().clearCache(quocGia);
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
	public static List<QuocGia> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuocGia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuocGia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static QuocGia update(QuocGia quocGia, boolean merge)
		throws SystemException {
		return getPersistence().update(quocGia, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static QuocGia update(QuocGia quocGia, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(quocGia, merge, serviceContext);
	}

	/**
	* Caches the quoc gia in the entity cache if it is enabled.
	*
	* @param quocGia the quoc gia
	*/
	public static void cacheResult(org.oep.cmon.dao.qlhc.model.QuocGia quocGia) {
		getPersistence().cacheResult(quocGia);
	}

	/**
	* Caches the quoc gias in the entity cache if it is enabled.
	*
	* @param quocGias the quoc gias
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> quocGias) {
		getPersistence().cacheResult(quocGias);
	}

	/**
	* Creates a new quoc gia with the primary key. Does not add the quoc gia to the database.
	*
	* @param id the primary key for the new quoc gia
	* @return the new quoc gia
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the quoc gia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the quoc gia
	* @return the quoc gia that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.qlhc.model.QuocGia updateImpl(
		org.oep.cmon.dao.qlhc.model.QuocGia quocGia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(quocGia, merge);
	}

	/**
	* Returns the quoc gia with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	*
	* @param id the primary key of the quoc gia
	* @return the quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the quoc gia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the quoc gia
	* @return the quoc gia, or <code>null</code> if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the quoc gias where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the quoc gias where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @return the range of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the quoc gias where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first quoc gia in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last quoc gia in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the quoc gias before and after the current quoc gia in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current quoc gia
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns the quoc gia where ten = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns the quoc gia where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten);
	}

	/**
	* Returns the quoc gia where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten, retrieveFromCache);
	}

	/**
	* Returns the quoc gia where ma = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchQuocGiaException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByMaQuocGia(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByMaQuocGia(ma);
	}

	/**
	* Returns the quoc gia where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchByMaQuocGia(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaQuocGia(ma);
	}

	/**
	* Returns the quoc gia where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching quoc gia, or <code>null</code> if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia fetchByMaQuocGia(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaQuocGia(ma, retrieveFromCache);
	}

	/**
	* Returns all the quoc gias where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the quoc gias where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @return the range of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the quoc gias where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first quoc gia in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last quoc gia in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a matching quoc gia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the quoc gias before and after the current quoc gia in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current quoc gia
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next quoc gia
	* @throws org.oep.cmon.dao.qlhc.NoSuchQuocGiaException if a quoc gia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.QuocGia[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the quoc gias.
	*
	* @return the quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the quoc gias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @return the range of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the quoc gias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of quoc gias
	* @param end the upper bound of the range of quoc gias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.QuocGia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the quoc gias where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the quoc gia where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes the quoc gia where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaQuocGia(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchQuocGiaException {
		getPersistence().removeByMaQuocGia(ma);
	}

	/**
	* Removes all the quoc gias where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the quoc gias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of quoc gias where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of quoc gias where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of quoc gias where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaQuocGia(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaQuocGia(ma);
	}

	/**
	* Returns the number of quoc gias where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of quoc gias.
	*
	* @return the number of quoc gias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static QuocGiaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (QuocGiaPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					QuocGiaPersistence.class.getName());

			ReferenceRegistry.registerReference(QuocGiaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(QuocGiaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(QuocGiaUtil.class, "_persistence");
	}

	private static QuocGiaPersistence _persistence;
}