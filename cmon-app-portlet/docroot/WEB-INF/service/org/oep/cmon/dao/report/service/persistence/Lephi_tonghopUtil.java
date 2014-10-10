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

import org.oep.cmon.dao.report.model.Lephi_tonghop;

import java.util.List;

/**
 * The persistence utility for the lephi_tonghop service. This utility wraps {@link Lephi_tonghopPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_tonghopPersistence
 * @see Lephi_tonghopPersistenceImpl
 * @generated
 */
public class Lephi_tonghopUtil {
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
	public static void clearCache(Lephi_tonghop lephi_tonghop) {
		getPersistence().clearCache(lephi_tonghop);
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
	public static List<Lephi_tonghop> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lephi_tonghop> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lephi_tonghop> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Lephi_tonghop update(Lephi_tonghop lephi_tonghop,
		boolean merge) throws SystemException {
		return getPersistence().update(lephi_tonghop, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Lephi_tonghop update(Lephi_tonghop lephi_tonghop,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lephi_tonghop, merge, serviceContext);
	}

	/**
	* Caches the lephi_tonghop in the entity cache if it is enabled.
	*
	* @param lephi_tonghop the lephi_tonghop
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop) {
		getPersistence().cacheResult(lephi_tonghop);
	}

	/**
	* Caches the lephi_tonghops in the entity cache if it is enabled.
	*
	* @param lephi_tonghops the lephi_tonghops
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> lephi_tonghops) {
		getPersistence().cacheResult(lephi_tonghops);
	}

	/**
	* Creates a new lephi_tonghop with the primary key. Does not add the lephi_tonghop to the database.
	*
	* @param lephi_tonghopPK the primary key for the new lephi_tonghop
	* @return the new lephi_tonghop
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop create(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK) {
		return getPersistence().create(lephi_tonghopPK);
	}

	/**
	* Removes the lephi_tonghop with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop remove(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_tonghopException {
		return getPersistence().remove(lephi_tonghopPK);
	}

	public static org.oep.cmon.dao.report.model.Lephi_tonghop updateImpl(
		org.oep.cmon.dao.report.model.Lephi_tonghop lephi_tonghop, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lephi_tonghop, merge);
	}

	/**
	* Returns the lephi_tonghop with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_tonghopException} if it could not be found.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop
	* @throws org.oep.cmon.dao.report.NoSuchLephi_tonghopException if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop findByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_tonghopException {
		return getPersistence().findByPrimaryKey(lephi_tonghopPK);
	}

	/**
	* Returns the lephi_tonghop with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lephi_tonghopPK the primary key of the lephi_tonghop
	* @return the lephi_tonghop, or <code>null</code> if a lephi_tonghop with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_tonghop fetchByPrimaryKey(
		org.oep.cmon.dao.report.service.persistence.Lephi_tonghopPK lephi_tonghopPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(lephi_tonghopPK);
	}

	/**
	* Returns all the lephi_tonghops.
	*
	* @return the lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lephi_tonghops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_tonghops
	* @param end the upper bound of the range of lephi_tonghops (not inclusive)
	* @return the range of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lephi_tonghops.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_tonghops
	* @param end the upper bound of the range of lephi_tonghops (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_tonghop> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lephi_tonghops from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lephi_tonghops.
	*
	* @return the number of lephi_tonghops
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lephi_tonghopPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lephi_tonghopPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Lephi_tonghopPersistence.class.getName());

			ReferenceRegistry.registerReference(Lephi_tonghopUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(Lephi_tonghopPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(Lephi_tonghopUtil.class,
			"_persistence");
	}

	private static Lephi_tonghopPersistence _persistence;
}