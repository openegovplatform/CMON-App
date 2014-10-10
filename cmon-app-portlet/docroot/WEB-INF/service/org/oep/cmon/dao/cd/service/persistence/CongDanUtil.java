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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.cd.model.CongDan;

import java.util.List;

/**
 * The persistence utility for the cong dan service. This utility wraps {@link CongDanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CongDanPersistence
 * @see CongDanPersistenceImpl
 * @generated
 */
public class CongDanUtil {
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
	public static void clearCache(CongDan congDan) {
		getPersistence().clearCache(congDan);
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
	public static List<CongDan> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CongDan update(CongDan congDan, boolean merge)
		throws SystemException {
		return getPersistence().update(congDan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CongDan update(CongDan congDan, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(congDan, merge, serviceContext);
	}

	/**
	* Caches the cong dan in the entity cache if it is enabled.
	*
	* @param congDan the cong dan
	*/
	public static void cacheResult(org.oep.cmon.dao.cd.model.CongDan congDan) {
		getPersistence().cacheResult(congDan);
	}

	/**
	* Caches the cong dans in the entity cache if it is enabled.
	*
	* @param congDans the cong dans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.CongDan> congDans) {
		getPersistence().cacheResult(congDans);
	}

	/**
	* Creates a new cong dan with the primary key. Does not add the cong dan to the database.
	*
	* @param id the primary key for the new cong dan
	* @return the new cong dan
	*/
	public static org.oep.cmon.dao.cd.model.CongDan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cd.model.CongDan updateImpl(
		org.oep.cmon.dao.cd.model.CongDan congDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(congDan, merge);
	}

	/**
	* Returns the cong dan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cong dan
	* @return the cong dan, or <code>null</code> if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the cong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the cong dans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns the cong dan where ma = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the cong dan where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByEmailAndCMND(email, soCmnd);
	}

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmailAndCMND(email, soCmnd);
	}

	/**
	* Returns the cong dan where email = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByEmailAndCMND(
		java.lang.String email, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAndCMND(email, soCmnd, retrieveFromCache);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByNgaySinhAndCMND(ngaySinh, soCmnd);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNgaySinhAndCMND(ngaySinh, soCmnd);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinhAndCMND(
		java.util.Date ngaySinh, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNgaySinhAndCMND(ngaySinh, soCmnd, retrieveFromCache);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or throws a {@link org.oep.cmon.dao.cd.NoSuchCongDanException} if it could not be found.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByNgaySinh(ngaySinh, soCmnd);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNgaySinh(ngaySinh, soCmnd);
	}

	/**
	* Returns the cong dan where ngaySinh = &#63; and soCmnd = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cong dan, or <code>null</code> if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan fetchByNgaySinh(
		java.util.Date ngaySinh, java.lang.String soCmnd,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNgaySinh(ngaySinh, soCmnd, retrieveFromCache);
	}

	/**
	* Returns all the cong dans where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the cong dans where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the cong dans where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns all the cong dans where email = &#63;.
	*
	* @param email the email
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns a range of all the cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end);
	}

	/**
	* Returns an ordered range of all the cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByEmail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end, orderByComparator);
	}

	/**
	* Returns the first cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByEmail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	* Returns the last cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByEmail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan[] findByEmail_PrevAndNext(
		long id, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findByEmail_PrevAndNext(id, email, orderByComparator);
	}

	/**
	* Returns all the cong dans where soCmnd = &#63;.
	*
	* @param soCmnd the so cmnd
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoCmnd(soCmnd);
	}

	/**
	* Returns a range of all the cong dans where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoCmnd(soCmnd, start, end);
	}

	/**
	* Returns an ordered range of all the cong dans where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findBySoCmnd(
		java.lang.String soCmnd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySoCmnd(soCmnd, start, end, orderByComparator);
	}

	/**
	* Returns the first cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findBySoCmnd_First(
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findBySoCmnd_First(soCmnd, orderByComparator);
	}

	/**
	* Returns the last cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findBySoCmnd_Last(
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence().findBySoCmnd_Last(soCmnd, orderByComparator);
	}

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan[] findBySoCmnd_PrevAndNext(
		long id, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findBySoCmnd_PrevAndNext(id, soCmnd, orderByComparator);
	}

	/**
	* Returns all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @return the matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByM_T_S(ma, ten, soCmnd);
	}

	/**
	* Returns a range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByM_T_S(ma, ten, soCmnd, start, end);
	}

	/**
	* Returns an ordered range of all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findByM_T_S(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByM_T_S(ma, ten, soCmnd, start, end, orderByComparator);
	}

	/**
	* Returns the first cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByM_T_S_First(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findByM_T_S_First(ma, ten, soCmnd, orderByComparator);
	}

	/**
	* Returns the last cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a matching cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan findByM_T_S_Last(
		java.lang.String ma, java.lang.String ten, java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findByM_T_S_Last(ma, ten, soCmnd, orderByComparator);
	}

	/**
	* Returns the cong dans before and after the current cong dan in the ordered set where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current cong dan
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cong dan
	* @throws org.oep.cmon.dao.cd.NoSuchCongDanException if a cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.CongDan[] findByM_T_S_PrevAndNext(
		long id, java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		return getPersistence()
				   .findByM_T_S_PrevAndNext(id, ma, ten, soCmnd,
			orderByComparator);
	}

	/**
	* Returns all the cong dans.
	*
	* @return the cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @return the range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong dans
	* @param end the upper bound of the range of cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.CongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cong dans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes the cong dan where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the cong dan where email = &#63; and soCmnd = &#63; from the database.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailAndCMND(java.lang.String email,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		getPersistence().removeByEmailAndCMND(email, soCmnd);
	}

	/**
	* Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNgaySinhAndCMND(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		getPersistence().removeByNgaySinhAndCMND(ngaySinh, soCmnd);
	}

	/**
	* Removes the cong dan where ngaySinh = &#63; and soCmnd = &#63; from the database.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNgaySinh(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchCongDanException {
		getPersistence().removeByNgaySinh(ngaySinh, soCmnd);
	}

	/**
	* Removes all the cong dans where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the cong dans where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmail(email);
	}

	/**
	* Removes all the cong dans where soCmnd = &#63; from the database.
	*
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySoCmnd(java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySoCmnd(soCmnd);
	}

	/**
	* Removes all the cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63; from the database.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByM_T_S(java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByM_T_S(ma, ten, soCmnd);
	}

	/**
	* Removes all the cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cong dans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of cong dans where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of cong dans where email = &#63; and soCmnd = &#63;.
	*
	* @param email the email
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAndCMND(java.lang.String email,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAndCMND(email, soCmnd);
	}

	/**
	* Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNgaySinhAndCMND(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNgaySinhAndCMND(ngaySinh, soCmnd);
	}

	/**
	* Returns the number of cong dans where ngaySinh = &#63; and soCmnd = &#63;.
	*
	* @param ngaySinh the ngay sinh
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNgaySinh(java.util.Date ngaySinh,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNgaySinh(ngaySinh, soCmnd);
	}

	/**
	* Returns the number of cong dans where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of cong dans where email = &#63;.
	*
	* @param email the email
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Returns the number of cong dans where soCmnd = &#63;.
	*
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySoCmnd(java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySoCmnd(soCmnd);
	}

	/**
	* Returns the number of cong dans where ma = &#63; and ten = &#63; and soCmnd = &#63;.
	*
	* @param ma the ma
	* @param ten the ten
	* @param soCmnd the so cmnd
	* @return the number of matching cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByM_T_S(java.lang.String ma, java.lang.String ten,
		java.lang.String soCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByM_T_S(ma, ten, soCmnd);
	}

	/**
	* Returns the number of cong dans.
	*
	* @return the number of cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CongDanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CongDanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					CongDanPersistence.class.getName());

			ReferenceRegistry.registerReference(CongDanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CongDanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CongDanUtil.class, "_persistence");
	}

	private static CongDanPersistence _persistence;
}