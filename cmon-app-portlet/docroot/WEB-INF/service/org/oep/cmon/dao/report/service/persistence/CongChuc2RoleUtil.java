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

import org.oep.cmon.dao.report.model.CongChuc2Role;

import java.util.List;

/**
 * The persistence utility for the cong chuc2 role service. This utility wraps {@link CongChuc2RolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see CongChuc2RolePersistence
 * @see CongChuc2RolePersistenceImpl
 * @generated
 */
public class CongChuc2RoleUtil {
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
	public static void clearCache(CongChuc2Role congChuc2Role) {
		getPersistence().clearCache(congChuc2Role);
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
	public static List<CongChuc2Role> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CongChuc2Role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CongChuc2Role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CongChuc2Role update(CongChuc2Role congChuc2Role,
		boolean merge) throws SystemException {
		return getPersistence().update(congChuc2Role, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CongChuc2Role update(CongChuc2Role congChuc2Role,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(congChuc2Role, merge, serviceContext);
	}

	/**
	* Caches the cong chuc2 role in the entity cache if it is enabled.
	*
	* @param congChuc2Role the cong chuc2 role
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role) {
		getPersistence().cacheResult(congChuc2Role);
	}

	/**
	* Caches the cong chuc2 roles in the entity cache if it is enabled.
	*
	* @param congChuc2Roles the cong chuc2 roles
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> congChuc2Roles) {
		getPersistence().cacheResult(congChuc2Roles);
	}

	/**
	* Creates a new cong chuc2 role with the primary key. Does not add the cong chuc2 role to the database.
	*
	* @param ID the primary key for the new cong chuc2 role
	* @return the new cong chuc2 role
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the cong chuc2 role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role that was removed
	* @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCongChuc2RoleException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.report.model.CongChuc2Role updateImpl(
		org.oep.cmon.dao.report.model.CongChuc2Role congChuc2Role, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(congChuc2Role, merge);
	}

	/**
	* Returns the cong chuc2 role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchCongChuc2RoleException} if it could not be found.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role
	* @throws org.oep.cmon.dao.report.NoSuchCongChuc2RoleException if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchCongChuc2RoleException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the cong chuc2 role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the cong chuc2 role
	* @return the cong chuc2 role, or <code>null</code> if a cong chuc2 role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.CongChuc2Role fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the cong chuc2 roles.
	*
	* @return the cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @return the range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cong chuc2 roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cong chuc2 roles
	* @param end the upper bound of the range of cong chuc2 roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.CongChuc2Role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cong chuc2 roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cong chuc2 roles.
	*
	* @return the number of cong chuc2 roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CongChuc2RolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CongChuc2RolePersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					CongChuc2RolePersistence.class.getName());

			ReferenceRegistry.registerReference(CongChuc2RoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CongChuc2RolePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CongChuc2RoleUtil.class,
			"_persistence");
	}

	private static CongChuc2RolePersistence _persistence;
}