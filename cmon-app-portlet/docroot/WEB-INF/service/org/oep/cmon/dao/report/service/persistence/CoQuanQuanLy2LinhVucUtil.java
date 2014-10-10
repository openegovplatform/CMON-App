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

package org.oep.cmon.dao.report.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;

import java.util.List;

/**
 * The persistence utility for the co quan quan ly2 linh vuc service. This utility wraps {@link CoQuanQuanLy2LinhVucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see CoQuanQuanLy2LinhVucPersistence
 * @see CoQuanQuanLy2LinhVucPersistenceImpl
 * @generated
 */
public class CoQuanQuanLy2LinhVucUtil {
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
	public static void clearCache(CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		getPersistence().clearCache(coQuanQuanLy2LinhVuc);
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
	public static List<CoQuanQuanLy2LinhVuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CoQuanQuanLy2LinhVuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CoQuanQuanLy2LinhVuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CoQuanQuanLy2LinhVuc update(
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc, boolean merge)
		throws SystemException {
		return getPersistence().update(coQuanQuanLy2LinhVuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CoQuanQuanLy2LinhVuc update(
		CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(coQuanQuanLy2LinhVuc, merge, serviceContext);
	}

	/**
	* Caches the co quan quan ly2 linh vuc in the entity cache if it is enabled.
	*
	* @param coQuanQuanLy2LinhVuc the co quan quan ly2 linh vuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		getPersistence().cacheResult(coQuanQuanLy2LinhVuc);
	}

	/**
	* Caches the co quan quan ly2 linh vucs in the entity cache if it is enabled.
	*
	* @param coQuanQuanLy2LinhVucs the co quan quan ly2 linh vucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> coQuanQuanLy2LinhVucs) {
		getPersistence().cacheResult(coQuanQuanLy2LinhVucs);
	}

	/**
	* Creates a new co quan quan ly2 linh vuc with the primary key. Does not add the co quan quan ly2 linh vuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new co quan quan ly2 linh vuc
	* @return the new co quan quan ly2 linh vuc
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc create(
		long NHOMTHUTUCHANHCHINHID) {
		return getPersistence().create(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Removes the co quan quan ly2 linh vuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc that was removed
	* @throws org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException if a co quan quan ly2 linh vuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc remove(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException {
		return getPersistence().remove(NHOMTHUTUCHANHCHINHID);
	}

	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc updateImpl(
		org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coQuanQuanLy2LinhVuc, merge);
	}

	/**
	* Returns the co quan quan ly2 linh vuc with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException} if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc
	* @throws org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException if a co quan quan ly2 linh vuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc findByPrimaryKey(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCoQuanQuanLy2LinhVucException {
		return getPersistence().findByPrimaryKey(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the co quan quan ly2 linh vuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the co quan quan ly2 linh vuc
	* @return the co quan quan ly2 linh vuc, or <code>null</code> if a co quan quan ly2 linh vuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc fetchByPrimaryKey(
		long NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns all the co quan quan ly2 linh vucs.
	*
	* @return the co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the co quan quan ly2 linh vucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan ly2 linh vucs
	* @param end the upper bound of the range of co quan quan ly2 linh vucs (not inclusive)
	* @return the range of co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan ly2 linh vucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan ly2 linh vucs
	* @param end the upper bound of the range of co quan quan ly2 linh vucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the co quan quan ly2 linh vucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of co quan quan ly2 linh vucs.
	*
	* @return the number of co quan quan ly2 linh vucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoQuanQuanLy2LinhVucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoQuanQuanLy2LinhVucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					CoQuanQuanLy2LinhVucPersistence.class.getName());

			ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CoQuanQuanLy2LinhVucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CoQuanQuanLy2LinhVucUtil.class,
			"_persistence");
	}

	private static CoQuanQuanLy2LinhVucPersistence _persistence;
}