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

import org.oep.cmon.dao.report.model.Role2TTHC;

import java.util.List;

/**
 * The persistence utility for the role2 t t h c service. This utility wraps {@link Role2TTHCPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2TTHCPersistence
 * @see Role2TTHCPersistenceImpl
 * @generated
 */
public class Role2TTHCUtil {
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
	public static void clearCache(Role2TTHC role2TTHC) {
		getPersistence().clearCache(role2TTHC);
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
	public static List<Role2TTHC> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Role2TTHC> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Role2TTHC> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Role2TTHC update(Role2TTHC role2TTHC, boolean merge)
		throws SystemException {
		return getPersistence().update(role2TTHC, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Role2TTHC update(Role2TTHC role2TTHC, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(role2TTHC, merge, serviceContext);
	}

	/**
	* Caches the role2 t t h c in the entity cache if it is enabled.
	*
	* @param role2TTHC the role2 t t h c
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC) {
		getPersistence().cacheResult(role2TTHC);
	}

	/**
	* Caches the role2 t t h cs in the entity cache if it is enabled.
	*
	* @param role2TTHCs the role2 t t h cs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Role2TTHC> role2TTHCs) {
		getPersistence().cacheResult(role2TTHCs);
	}

	/**
	* Creates a new role2 t t h c with the primary key. Does not add the role2 t t h c to the database.
	*
	* @param ID the primary key for the new role2 t t h c
	* @return the new role2 t t h c
	*/
	public static org.oep.cmon.dao.report.model.Role2TTHC create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the role2 t t h c with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 t t h c
	* @return the role2 t t h c that was removed
	* @throws org.oep.cmon.dao.report.NoSuchRole2TTHCException if a role2 t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2TTHC remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2TTHCException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.report.model.Role2TTHC updateImpl(
		org.oep.cmon.dao.report.model.Role2TTHC role2TTHC, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(role2TTHC, merge);
	}

	/**
	* Returns the role2 t t h c with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2TTHCException} if it could not be found.
	*
	* @param ID the primary key of the role2 t t h c
	* @return the role2 t t h c
	* @throws org.oep.cmon.dao.report.NoSuchRole2TTHCException if a role2 t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2TTHC findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2TTHCException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the role2 t t h c with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the role2 t t h c
	* @return the role2 t t h c, or <code>null</code> if a role2 t t h c with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2TTHC fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the role2 t t h cs.
	*
	* @return the role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2TTHC> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the role2 t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 t t h cs
	* @param end the upper bound of the range of role2 t t h cs (not inclusive)
	* @return the range of role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2TTHC> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the role2 t t h cs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 t t h cs
	* @param end the upper bound of the range of role2 t t h cs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2TTHC> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the role2 t t h cs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of role2 t t h cs.
	*
	* @return the number of role2 t t h cs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Role2TTHCPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Role2TTHCPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Role2TTHCPersistence.class.getName());

			ReferenceRegistry.registerReference(Role2TTHCUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(Role2TTHCPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(Role2TTHCUtil.class, "_persistence");
	}

	private static Role2TTHCPersistence _persistence;
}