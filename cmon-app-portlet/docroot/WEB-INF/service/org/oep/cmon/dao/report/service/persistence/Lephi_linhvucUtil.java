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

import org.oep.cmon.dao.report.model.Lephi_linhvuc;

import java.util.List;

/**
 * The persistence utility for the lephi_linhvuc service. This utility wraps {@link Lephi_linhvucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_linhvucPersistence
 * @see Lephi_linhvucPersistenceImpl
 * @generated
 */
public class Lephi_linhvucUtil {
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
	public static void clearCache(Lephi_linhvuc lephi_linhvuc) {
		getPersistence().clearCache(lephi_linhvuc);
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
	public static List<Lephi_linhvuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lephi_linhvuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lephi_linhvuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Lephi_linhvuc update(Lephi_linhvuc lephi_linhvuc,
		boolean merge) throws SystemException {
		return getPersistence().update(lephi_linhvuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Lephi_linhvuc update(Lephi_linhvuc lephi_linhvuc,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lephi_linhvuc, merge, serviceContext);
	}

	/**
	* Caches the lephi_linhvuc in the entity cache if it is enabled.
	*
	* @param lephi_linhvuc the lephi_linhvuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc) {
		getPersistence().cacheResult(lephi_linhvuc);
	}

	/**
	* Caches the lephi_linhvucs in the entity cache if it is enabled.
	*
	* @param lephi_linhvucs the lephi_linhvucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> lephi_linhvucs) {
		getPersistence().cacheResult(lephi_linhvucs);
	}

	/**
	* Creates a new lephi_linhvuc with the primary key. Does not add the lephi_linhvuc to the database.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key for the new lephi_linhvuc
	* @return the new lephi_linhvuc
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc create(
		int NHOMTHUTUCHANHCHINHID) {
		return getPersistence().create(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Removes the lephi_linhvuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc remove(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_linhvucException {
		return getPersistence().remove(NHOMTHUTUCHANHCHINHID);
	}

	public static org.oep.cmon.dao.report.model.Lephi_linhvuc updateImpl(
		org.oep.cmon.dao.report.model.Lephi_linhvuc lephi_linhvuc, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lephi_linhvuc, merge);
	}

	/**
	* Returns the lephi_linhvuc with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_linhvucException} if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc
	* @throws org.oep.cmon.dao.report.NoSuchLephi_linhvucException if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc findByPrimaryKey(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_linhvucException {
		return getPersistence().findByPrimaryKey(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns the lephi_linhvuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param NHOMTHUTUCHANHCHINHID the primary key of the lephi_linhvuc
	* @return the lephi_linhvuc, or <code>null</code> if a lephi_linhvuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_linhvuc fetchByPrimaryKey(
		int NHOMTHUTUCHANHCHINHID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(NHOMTHUTUCHANHCHINHID);
	}

	/**
	* Returns all the lephi_linhvucs.
	*
	* @return the lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @return the range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lephi_linhvucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_linhvucs
	* @param end the upper bound of the range of lephi_linhvucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_linhvuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lephi_linhvucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lephi_linhvucs.
	*
	* @return the number of lephi_linhvucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lephi_linhvucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lephi_linhvucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Lephi_linhvucPersistence.class.getName());

			ReferenceRegistry.registerReference(Lephi_linhvucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(Lephi_linhvucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(Lephi_linhvucUtil.class,
			"_persistence");
	}

	private static Lephi_linhvucPersistence _persistence;
}