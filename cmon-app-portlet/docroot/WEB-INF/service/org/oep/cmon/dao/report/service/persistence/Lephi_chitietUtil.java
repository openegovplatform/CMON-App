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

import org.oep.cmon.dao.report.model.Lephi_chitiet;

import java.util.List;

/**
 * The persistence utility for the lephi_chitiet service. This utility wraps {@link Lephi_chitietPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Lephi_chitietPersistence
 * @see Lephi_chitietPersistenceImpl
 * @generated
 */
public class Lephi_chitietUtil {
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
	public static void clearCache(Lephi_chitiet lephi_chitiet) {
		getPersistence().clearCache(lephi_chitiet);
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
	public static List<Lephi_chitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lephi_chitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lephi_chitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Lephi_chitiet update(Lephi_chitiet lephi_chitiet,
		boolean merge) throws SystemException {
		return getPersistence().update(lephi_chitiet, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Lephi_chitiet update(Lephi_chitiet lephi_chitiet,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(lephi_chitiet, merge, serviceContext);
	}

	/**
	* Caches the lephi_chitiet in the entity cache if it is enabled.
	*
	* @param lephi_chitiet the lephi_chitiet
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet) {
		getPersistence().cacheResult(lephi_chitiet);
	}

	/**
	* Caches the lephi_chitiets in the entity cache if it is enabled.
	*
	* @param lephi_chitiets the lephi_chitiets
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> lephi_chitiets) {
		getPersistence().cacheResult(lephi_chitiets);
	}

	/**
	* Creates a new lephi_chitiet with the primary key. Does not add the lephi_chitiet to the database.
	*
	* @param ID the primary key for the new lephi_chitiet
	* @return the new lephi_chitiet
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the lephi_chitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet that was removed
	* @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_chitietException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.report.model.Lephi_chitiet updateImpl(
		org.oep.cmon.dao.report.model.Lephi_chitiet lephi_chitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lephi_chitiet, merge);
	}

	/**
	* Returns the lephi_chitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchLephi_chitietException} if it could not be found.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet
	* @throws org.oep.cmon.dao.report.NoSuchLephi_chitietException if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchLephi_chitietException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the lephi_chitiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the lephi_chitiet
	* @return the lephi_chitiet, or <code>null</code> if a lephi_chitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Lephi_chitiet fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the lephi_chitiets.
	*
	* @return the lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lephi_chitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_chitiets
	* @param end the upper bound of the range of lephi_chitiets (not inclusive)
	* @return the range of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lephi_chitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lephi_chitiets
	* @param end the upper bound of the range of lephi_chitiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Lephi_chitiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lephi_chitiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lephi_chitiets.
	*
	* @return the number of lephi_chitiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Lephi_chitietPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Lephi_chitietPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Lephi_chitietPersistence.class.getName());

			ReferenceRegistry.registerReference(Lephi_chitietUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(Lephi_chitietPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(Lephi_chitietUtil.class,
			"_persistence");
	}

	private static Lephi_chitietPersistence _persistence;
}