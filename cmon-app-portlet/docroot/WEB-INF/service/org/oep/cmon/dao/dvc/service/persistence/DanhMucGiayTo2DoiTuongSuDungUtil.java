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

import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;

import java.util.List;

/**
 * The persistence utility for the danh muc giay to2 doi tuong su dung service. This utility wraps {@link DanhMucGiayTo2DoiTuongSuDungPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see DanhMucGiayTo2DoiTuongSuDungPersistence
 * @see DanhMucGiayTo2DoiTuongSuDungPersistenceImpl
 * @generated
 */
public class DanhMucGiayTo2DoiTuongSuDungUtil {
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
	public static void clearCache(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		getPersistence().clearCache(danhMucGiayTo2DoiTuongSuDung);
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
	public static List<DanhMucGiayTo2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhMucGiayTo2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhMucGiayTo2DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhMucGiayTo2DoiTuongSuDung update(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung, boolean merge)
		throws SystemException {
		return getPersistence().update(danhMucGiayTo2DoiTuongSuDung, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhMucGiayTo2DoiTuongSuDung update(
		DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(danhMucGiayTo2DoiTuongSuDung, merge, serviceContext);
	}

	/**
	* Caches the danh muc giay to2 doi tuong su dung in the entity cache if it is enabled.
	*
	* @param danhMucGiayTo2DoiTuongSuDung the danh muc giay to2 doi tuong su dung
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung) {
		getPersistence().cacheResult(danhMucGiayTo2DoiTuongSuDung);
	}

	/**
	* Caches the danh muc giay to2 doi tuong su dungs in the entity cache if it is enabled.
	*
	* @param danhMucGiayTo2DoiTuongSuDungs the danh muc giay to2 doi tuong su dungs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> danhMucGiayTo2DoiTuongSuDungs) {
		getPersistence().cacheResult(danhMucGiayTo2DoiTuongSuDungs);
	}

	/**
	* Creates a new danh muc giay to2 doi tuong su dung with the primary key. Does not add the danh muc giay to2 doi tuong su dung to the database.
	*
	* @param id the primary key for the new danh muc giay to2 doi tuong su dung
	* @return the new danh muc giay to2 doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the danh muc giay to2 doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung danhMucGiayTo2DoiTuongSuDung,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhMucGiayTo2DoiTuongSuDung, merge);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException} if it could not be found.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh muc giay to2 doi tuong su dung
	* @return the danh muc giay to2 doi tuong su dung, or <code>null</code> if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current danh muc giay to2 doi tuong su dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByloaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByloaiDoiTuongId(loaiDoiTuongId, start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiDoiTuongId(
		long loaiDoiTuongId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByloaiDoiTuongId(loaiDoiTuongId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByloaiDoiTuongId_First(
		long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiDoiTuongId_First(loaiDoiTuongId, orderByComparator);
	}

	/**
	* Returns the last danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByloaiDoiTuongId_Last(
		long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiDoiTuongId_Last(loaiDoiTuongId, orderByComparator);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where loaiDoiTuongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current danh muc giay to2 doi tuong su dung
	* @param loaiDoiTuongId the loai doi tuong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung[] findByloaiDoiTuongId_PrevAndNext(
		long id, long loaiDoiTuongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiDoiTuongId_PrevAndNext(id, loaiDoiTuongId,
			orderByComparator);
	}

	/**
	* Returns all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	*
	* @param loaiGiayToId the loai giay to ID
	* @return the matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByloaiGiayToId(loaiGiayToId);
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiGiayToId the loai giay to ID
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByloaiGiayToId(loaiGiayToId, start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiGiayToId the loai giay to ID
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findByloaiGiayToId(
		long loaiGiayToId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByloaiGiayToId(loaiGiayToId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiGiayToId the loai giay to ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByloaiGiayToId_First(
		long loaiGiayToId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiGiayToId_First(loaiGiayToId, orderByComparator);
	}

	/**
	* Returns the last danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param loaiGiayToId the loai giay to ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a matching danh muc giay to2 doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung findByloaiGiayToId_Last(
		long loaiGiayToId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiGiayToId_Last(loaiGiayToId, orderByComparator);
	}

	/**
	* Returns the danh muc giay to2 doi tuong su dungs before and after the current danh muc giay to2 doi tuong su dung in the ordered set where loaiGiayToId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current danh muc giay to2 doi tuong su dung
	* @param loaiGiayToId the loai giay to ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next danh muc giay to2 doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException if a danh muc giay to2 doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung[] findByloaiGiayToId_PrevAndNext(
		long id, long loaiGiayToId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDanhMucGiayTo2DoiTuongSuDungException {
		return getPersistence()
				   .findByloaiGiayToId_PrevAndNext(id, loaiGiayToId,
			orderByComparator);
	}

	/**
	* Returns all the danh muc giay to2 doi tuong su dungs.
	*
	* @return the danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh muc giay to2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @return the range of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay to2 doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay to2 doi tuong su dungs
	* @param end the upper bound of the range of danh muc giay to2 doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the danh muc giay to2 doi tuong su dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63; from the database.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByloaiDoiTuongId(long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByloaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Removes all the danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63; from the database.
	*
	* @param loaiGiayToId the loai giay to ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByloaiGiayToId(long loaiGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByloaiGiayToId(loaiGiayToId);
	}

	/**
	* Removes all the danh muc giay to2 doi tuong su dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs where loaiDoiTuongId = &#63;.
	*
	* @param loaiDoiTuongId the loai doi tuong ID
	* @return the number of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByloaiDoiTuongId(long loaiDoiTuongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByloaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs where loaiGiayToId = &#63;.
	*
	* @param loaiGiayToId the loai giay to ID
	* @return the number of matching danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByloaiGiayToId(long loaiGiayToId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByloaiGiayToId(loaiGiayToId);
	}

	/**
	* Returns the number of danh muc giay to2 doi tuong su dungs.
	*
	* @return the number of danh muc giay to2 doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhMucGiayTo2DoiTuongSuDungPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhMucGiayTo2DoiTuongSuDungPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					DanhMucGiayTo2DoiTuongSuDungPersistence.class.getName());

			ReferenceRegistry.registerReference(DanhMucGiayTo2DoiTuongSuDungUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(
		DanhMucGiayTo2DoiTuongSuDungPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhMucGiayTo2DoiTuongSuDungUtil.class,
			"_persistence");
	}

	private static DanhMucGiayTo2DoiTuongSuDungPersistence _persistence;
}