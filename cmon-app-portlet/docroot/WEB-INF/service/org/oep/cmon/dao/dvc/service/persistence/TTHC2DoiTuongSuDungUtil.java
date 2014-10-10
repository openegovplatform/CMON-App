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

import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;

import java.util.List;

/**
 * The persistence utility for the t t h c2 doi tuong su dung service. This utility wraps {@link TTHC2DoiTuongSuDungPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2DoiTuongSuDungPersistence
 * @see TTHC2DoiTuongSuDungPersistenceImpl
 * @generated
 */
public class TTHC2DoiTuongSuDungUtil {
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
	public static void clearCache(TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		getPersistence().clearCache(tthc2DoiTuongSuDung);
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
	public static List<TTHC2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTHC2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTHC2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TTHC2DoiTuongSuDung update(
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung, boolean merge)
		throws SystemException {
		return getPersistence().update(tthc2DoiTuongSuDung, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TTHC2DoiTuongSuDung update(
		TTHC2DoiTuongSuDung tthc2DoiTuongSuDung, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(tthc2DoiTuongSuDung, merge, serviceContext);
	}

	/**
	* Caches the t t h c2 doi tuong su dung in the entity cache if it is enabled.
	*
	* @param tthc2DoiTuongSuDung the t t h c2 doi tuong su dung
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		getPersistence().cacheResult(tthc2DoiTuongSuDung);
	}

	/**
	* Caches the t t h c2 doi tuong su dungs in the entity cache if it is enabled.
	*
	* @param tthc2DoiTuongSuDungs the t t h c2 doi tuong su dungs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> tthc2DoiTuongSuDungs) {
		getPersistence().cacheResult(tthc2DoiTuongSuDungs);
	}

	/**
	* Creates a new t t h c2 doi tuong su dung with the primary key. Does not add the t t h c2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new t t h c2 doi tuong su dung
	* @return the new t t h c2 doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the t t h c2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tthc2DoiTuongSuDung, merge);
	}

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException} if it could not be found.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the t t h c2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t t h c2 doi tuong su dung
	* @return the t t h c2 doi tuong su dung, or <code>null</code> if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByThuTucHanhChinhId_First(thuTucHanhChinhId,
			orderByComparator);
	}

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByThuTucHanhChinhId_Last(thuTucHanhChinhId,
			orderByComparator);
	}

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByThuTucHanhChinhId_PrevAndNext(id, thuTucHanhChinhId,
			orderByComparator);
	}

	/**
	* Returns all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId,
			daXoa);
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId,
			daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findByTT2LoaiDoiTuong(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId,
			daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_First(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong_First(loaiDoiTuongId,
			thuTucHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns the last t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a matching t t h c2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung findByTT2LoaiDoiTuong_Last(
		long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong_Last(loaiDoiTuongId,
			thuTucHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns the t t h c2 doi tuong su dungs before and after the current t t h c2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 doi tuong su dung
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException if a t t h c2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung[] findByTT2LoaiDoiTuong_PrevAndNext(
		long id, long loaiDoiTuongId, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2DoiTuongSuDungException {
		return getPersistence()
				   .findByTT2LoaiDoiTuong_PrevAndNext(id, loaiDoiTuongId,
			thuTucHanhChinhId, daXoa, orderByComparator);
	}

	/**
	* Returns all the t t h c2 doi tuong su dungs.
	*
	* @return the t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @return the range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 doi tuong su dungs
	* @param end the upper bound of the range of t t h c2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t t h c2 doi tuong su dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Removes all the t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId, daXoa);
	}

	/**
	* Removes all the t t h c2 doi tuong su dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs where loaiDoiTuongId = &#63; and thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTT2LoaiDoiTuong(long loaiDoiTuongId,
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTT2LoaiDoiTuong(loaiDoiTuongId, thuTucHanhChinhId,
			daXoa);
	}

	/**
	* Returns the number of t t h c2 doi tuong su dungs.
	*
	* @return the number of t t h c2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TTHC2DoiTuongSuDungPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TTHC2DoiTuongSuDungPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					TTHC2DoiTuongSuDungPersistence.class.getName());

			ReferenceRegistry.registerReference(TTHC2DoiTuongSuDungUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TTHC2DoiTuongSuDungPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TTHC2DoiTuongSuDungUtil.class,
			"_persistence");
	}

	private static TTHC2DoiTuongSuDungPersistence _persistence;
}