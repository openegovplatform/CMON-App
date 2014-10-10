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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep;

import java.util.List;

/**
 * The persistence utility for the yeu cau dang ky doanh nghiep service. This utility wraps {@link YeuCauDangKyDoanhNghiepPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see YeuCauDangKyDoanhNghiepPersistence
 * @see YeuCauDangKyDoanhNghiepPersistenceImpl
 * @generated
 */
public class YeuCauDangKyDoanhNghiepUtil {
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
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		getPersistence().clearCache(yeuCauDangKyDoanhNghiep);
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
	public static List<YeuCauDangKyDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<YeuCauDangKyDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<YeuCauDangKyDoanhNghiep> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static YeuCauDangKyDoanhNghiep update(
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep, boolean merge)
		throws SystemException {
		return getPersistence().update(yeuCauDangKyDoanhNghiep, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static YeuCauDangKyDoanhNghiep update(
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(yeuCauDangKyDoanhNghiep, merge, serviceContext);
	}

	/**
	* Caches the yeu cau dang ky doanh nghiep in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyDoanhNghiep the yeu cau dang ky doanh nghiep
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		getPersistence().cacheResult(yeuCauDangKyDoanhNghiep);
	}

	/**
	* Caches the yeu cau dang ky doanh nghieps in the entity cache if it is enabled.
	*
	* @param yeuCauDangKyDoanhNghieps the yeu cau dang ky doanh nghieps
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep> yeuCauDangKyDoanhNghieps) {
		getPersistence().cacheResult(yeuCauDangKyDoanhNghieps);
	}

	/**
	* Creates a new yeu cau dang ky doanh nghiep with the primary key. Does not add the yeu cau dang ky doanh nghiep to the database.
	*
	* @param id the primary key for the new yeu cau dang ky doanh nghiep
	* @return the new yeu cau dang ky doanh nghiep
	*/
	public static org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the yeu cau dang ky doanh nghiep with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the yeu cau dang ky doanh nghiep
	* @return the yeu cau dang ky doanh nghiep that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep updateImpl(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(yeuCauDangKyDoanhNghiep, merge);
	}

	/**
	* Returns the yeu cau dang ky doanh nghiep with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException} if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky doanh nghiep
	* @return the yeu cau dang ky doanh nghiep
	* @throws org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException if a yeu cau dang ky doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchYeuCauDangKyDoanhNghiepException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the yeu cau dang ky doanh nghiep with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the yeu cau dang ky doanh nghiep
	* @return the yeu cau dang ky doanh nghiep, or <code>null</code> if a yeu cau dang ky doanh nghiep with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the yeu cau dang ky doanh nghieps.
	*
	* @return the yeu cau dang ky doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the yeu cau dang ky doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky doanh nghieps
	* @param end the upper bound of the range of yeu cau dang ky doanh nghieps (not inclusive)
	* @return the range of yeu cau dang ky doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the yeu cau dang ky doanh nghieps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of yeu cau dang ky doanh nghieps
	* @param end the upper bound of the range of yeu cau dang ky doanh nghieps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of yeu cau dang ky doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the yeu cau dang ky doanh nghieps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of yeu cau dang ky doanh nghieps.
	*
	* @return the number of yeu cau dang ky doanh nghieps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static YeuCauDangKyDoanhNghiepPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (YeuCauDangKyDoanhNghiepPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dn.service.ClpSerializer.getServletContextName(),
					YeuCauDangKyDoanhNghiepPersistence.class.getName());

			ReferenceRegistry.registerReference(YeuCauDangKyDoanhNghiepUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(YeuCauDangKyDoanhNghiepPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(YeuCauDangKyDoanhNghiepUtil.class,
			"_persistence");
	}

	private static YeuCauDangKyDoanhNghiepPersistence _persistence;
}