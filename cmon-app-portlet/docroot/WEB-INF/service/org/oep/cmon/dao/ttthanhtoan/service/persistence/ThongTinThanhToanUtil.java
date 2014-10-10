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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;

import java.util.List;

/**
 * The persistence utility for the thong tin thanh toan service. This utility wraps {@link ThongTinThanhToanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thanhdd
 * @see ThongTinThanhToanPersistence
 * @see ThongTinThanhToanPersistenceImpl
 * @generated
 */
public class ThongTinThanhToanUtil {
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
	public static void clearCache(ThongTinThanhToan thongTinThanhToan) {
		getPersistence().clearCache(thongTinThanhToan);
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
	public static List<ThongTinThanhToan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ThongTinThanhToan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ThongTinThanhToan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ThongTinThanhToan update(
		ThongTinThanhToan thongTinThanhToan, boolean merge)
		throws SystemException {
		return getPersistence().update(thongTinThanhToan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ThongTinThanhToan update(
		ThongTinThanhToan thongTinThanhToan, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(thongTinThanhToan, merge, serviceContext);
	}

	/**
	* Caches the thong tin thanh toan in the entity cache if it is enabled.
	*
	* @param thongTinThanhToan the thong tin thanh toan
	*/
	public static void cacheResult(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan) {
		getPersistence().cacheResult(thongTinThanhToan);
	}

	/**
	* Caches the thong tin thanh toans in the entity cache if it is enabled.
	*
	* @param thongTinThanhToans the thong tin thanh toans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> thongTinThanhToans) {
		getPersistence().cacheResult(thongTinThanhToans);
	}

	/**
	* Creates a new thong tin thanh toan with the primary key. Does not add the thong tin thanh toan to the database.
	*
	* @param id the primary key for the new thong tin thanh toan
	* @return the new thong tin thanh toan
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the thong tin thanh toan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan that was removed
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan updateImpl(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(thongTinThanhToan, merge);
	}

	/**
	* Returns the thong tin thanh toan with the primary key or throws a {@link org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException} if it could not be found.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the thong tin thanh toan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the thong tin thanh toan
	* @return the thong tin thanh toan, or <code>null</code> if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns a range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @return the range of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHoSoTTHCCongId(hoSoTTHCCongId, start, end);
	}

	/**
	* Returns an ordered range of all the thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoSoTTHCCongId(hoSoTTHCCongId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByHoSoTTHCCongId_First(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException {
		return getPersistence()
				   .findByHoSoTTHCCongId_First(hoSoTTHCCongId, orderByComparator);
	}

	/**
	* Returns the last thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a matching thong tin thanh toan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan findByHoSoTTHCCongId_Last(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException {
		return getPersistence()
				   .findByHoSoTTHCCongId_Last(hoSoTTHCCongId, orderByComparator);
	}

	/**
	* Returns the thong tin thanh toans before and after the current thong tin thanh toan in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current thong tin thanh toan
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thong tin thanh toan
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException if a thong tin thanh toan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan[] findByHoSoTTHCCongId_PrevAndNext(
		long id, long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchThongTinThanhToanException {
		return getPersistence()
				   .findByHoSoTTHCCongId_PrevAndNext(id, hoSoTTHCCongId,
			orderByComparator);
	}

	/**
	* Returns all the thong tin thanh toans.
	*
	* @return the thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the thong tin thanh toans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @return the range of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the thong tin thanh toans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thong tin thanh toans
	* @param end the upper bound of the range of thong tin thanh toans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the thong tin thanh toans where hoSoTTHCCongId = &#63; from the database.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Removes all the thong tin thanh toans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of thong tin thanh toans where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the number of matching thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the number of thong tin thanh toans.
	*
	* @return the number of thong tin thanh toans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ThongTinThanhToanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ThongTinThanhToanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.ttthanhtoan.service.ClpSerializer.getServletContextName(),
					ThongTinThanhToanPersistence.class.getName());

			ReferenceRegistry.registerReference(ThongTinThanhToanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ThongTinThanhToanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ThongTinThanhToanUtil.class,
			"_persistence");
	}

	private static ThongTinThanhToanPersistence _persistence;
}