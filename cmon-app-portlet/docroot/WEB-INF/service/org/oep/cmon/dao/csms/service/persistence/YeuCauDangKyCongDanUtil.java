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

package org.oep.cmon.dao.csms.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;

import java.util.List;

/**
 * The persistence utility for the yeu cau dang ky cong dan service. This utility wraps {@link YeuCauDangKyCongDanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see YeuCauDangKyCongDanPersistence
 * @see YeuCauDangKyCongDanPersistenceImpl
 * @generated
 */
public class YeuCauDangKyCongDanUtil {
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
	public static void clearCache(YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		getPersistence().clearCache(yeuCauDangKyCongDan);
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
	public static List<YeuCauDangKyCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YeuCauDangKyCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YeuCauDangKyCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YeuCauDangKyCongDan update(
		YeuCauDangKyCongDan yeuCauDangKyCongDan, boolean merge)
		throws SystemException {
		return getPersistence().update(yeuCauDangKyCongDan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YeuCauDangKyCongDan update(
		YeuCauDangKyCongDan yeuCauDangKyCongDan, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(yeuCauDangKyCongDan, merge, serviceContext);
	}

	/**
	* Caches the yeu cau dang ky cong dan in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyCongDan the yeu cau dang ky cong dan
	*/
	public static void cacheResult(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		getPersistence().cacheResult(yeuCauDangKyCongDan);
	}

	/**
	* Caches the yeu cau dang ky cong dans in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyCongDans the yeu cau dang ky cong dans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> yeuCauDangKyCongDans) {
		getPersistence().cacheResult(yeuCauDangKyCongDans);
	}

	/**
	* Creates a new yeu cau dang ky cong dan with the primary key. Does not add the yeu cau dang ky cong dan to the database.
	*
	* @param id the primary key for the new yeu cau dang ky cong dan
	* @return the new yeu cau dang ky cong dan
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the yeu cau dang ky cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan that was removed
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan updateImpl(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(yeuCauDangKyCongDan, merge);
	}

	/**
	* Returns the yeu cau dang ky cong dan with the primary key or throws a {@link org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException} if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the yeu cau dang ky cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky cong dan
	* @return the yeu cau dang ky cong dan, or <code>null</code> if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* @param MaXacNhan the ma xac nhan
	* @return the matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaXacNhan(MaXacNhan);
	}

	/**
	* Returns a range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMaXacNhan(MaXacNhan, start, end);
	}

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findByMaXacNhan(
		java.lang.String MaXacNhan, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMaXacNhan(MaXacNhan, start, end, orderByComparator);
	}

	/**
	* Returns the first yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByMaXacNhan_First(
		java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence()
				   .findByMaXacNhan_First(MaXacNhan, orderByComparator);
	}

	/**
	* Returns the last yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findByMaXacNhan_Last(
		java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence()
				   .findByMaXacNhan_Last(MaXacNhan, orderByComparator);
	}

	/**
	* Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where MaXacNhan = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current yeu cau dang ky cong dan
	* @param MaXacNhan the ma xac nhan
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan[] findByMaXacNhan_PrevAndNext(
		long id, java.lang.String MaXacNhan,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence()
				   .findByMaXacNhan_PrevAndNext(id, MaXacNhan, orderByComparator);
	}

	/**
	* Returns all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* @param SoCmnd the so cmnd
	* @return the matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoCmnd(SoCmnd);
	}

	/**
	* Returns a range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySoCmnd(SoCmnd, start, end);
	}

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findBySoCmnd(
		java.lang.String SoCmnd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySoCmnd(SoCmnd, start, end, orderByComparator);
	}

	/**
	* Returns the first yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findBySoCmnd_First(
		java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence().findBySoCmnd_First(SoCmnd, orderByComparator);
	}

	/**
	* Returns the last yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a matching yeu cau dang ky cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan findBySoCmnd_Last(
		java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence().findBySoCmnd_Last(SoCmnd, orderByComparator);
	}

	/**
	* Returns the yeu cau dang ky cong dans before and after the current yeu cau dang ky cong dan in the ordered set where SoCmnd = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current yeu cau dang ky cong dan
	* @param SoCmnd the so cmnd
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next yeu cau dang ky cong dan
	* @throws org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException if a yeu cau dang ky cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan[] findBySoCmnd_PrevAndNext(
		long id, java.lang.String SoCmnd,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.csms.NoSuchYeuCauDangKyCongDanException {
		return getPersistence()
				   .findBySoCmnd_PrevAndNext(id, SoCmnd, orderByComparator);
	}

	/**
	* Returns all the yeu cau dang ky cong dans.
	*
	* @return the yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @return the range of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the yeu cau dang ky cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky cong dans
	* @param end the upper bound of the range of yeu cau dang ky cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the yeu cau dang ky cong dans where MaXacNhan = &#63; from the database.
	*
	* @param MaXacNhan the ma xac nhan
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaXacNhan(java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMaXacNhan(MaXacNhan);
	}

	/**
	* Removes all the yeu cau dang ky cong dans where SoCmnd = &#63; from the database.
	*
	* @param SoCmnd the so cmnd
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySoCmnd(java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySoCmnd(SoCmnd);
	}

	/**
	* Removes all the yeu cau dang ky cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of yeu cau dang ky cong dans where MaXacNhan = &#63;.
	*
	* @param MaXacNhan the ma xac nhan
	* @return the number of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaXacNhan(java.lang.String MaXacNhan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaXacNhan(MaXacNhan);
	}

	/**
	* Returns the number of yeu cau dang ky cong dans where SoCmnd = &#63;.
	*
	* @param SoCmnd the so cmnd
	* @return the number of matching yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySoCmnd(java.lang.String SoCmnd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySoCmnd(SoCmnd);
	}

	/**
	* Returns the number of yeu cau dang ky cong dans.
	*
	* @return the number of yeu cau dang ky cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YeuCauDangKyCongDanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YeuCauDangKyCongDanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.csms.service.ClpSerializer.getServletContextName(),
					YeuCauDangKyCongDanPersistence.class.getName());

			ReferenceRegistry.registerReference(YeuCauDangKyCongDanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(YeuCauDangKyCongDanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(YeuCauDangKyCongDanUtil.class,
			"_persistence");
	}

	private static YeuCauDangKyCongDanPersistence _persistence;
}