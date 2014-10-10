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

import org.oep.cmon.dao.report.model.DanhMucRole;

import java.util.List;

/**
 * The persistence utility for the danh muc role service. This utility wraps {@link DanhMucRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see DanhMucRolePersistence
 * @see DanhMucRolePersistenceImpl
 * @generated
 */
public class DanhMucRoleUtil {
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
	public static void clearCache(DanhMucRole danhMucRole) {
		getPersistence().clearCache(danhMucRole);
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
	public static List<DanhMucRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhMucRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhMucRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhMucRole update(DanhMucRole danhMucRole, boolean merge)
		throws SystemException {
		return getPersistence().update(danhMucRole, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhMucRole update(DanhMucRole danhMucRole, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhMucRole, merge, serviceContext);
	}

	/**
	* Caches the danh muc role in the entity cache if it is enabled.
	*
	* @param danhMucRole the danh muc role
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole) {
		getPersistence().cacheResult(danhMucRole);
	}

	/**
	* Caches the danh muc roles in the entity cache if it is enabled.
	*
	* @param danhMucRoles the danh muc roles
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> danhMucRoles) {
		getPersistence().cacheResult(danhMucRoles);
	}

	/**
	* Creates a new danh muc role with the primary key. Does not add the danh muc role to the database.
	*
	* @param ID the primary key for the new danh muc role
	* @return the new danh muc role
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the danh muc role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role that was removed
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucRoleException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.report.model.DanhMucRole updateImpl(
		org.oep.cmon.dao.report.model.DanhMucRole danhMucRole, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhMucRole, merge);
	}

	/**
	* Returns the danh muc role with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchDanhMucRoleException} if it could not be found.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role
	* @throws org.oep.cmon.dao.report.NoSuchDanhMucRoleException if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchDanhMucRoleException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the danh muc role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the danh muc role
	* @return the danh muc role, or <code>null</code> if a danh muc role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.DanhMucRole fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the danh muc roles.
	*
	* @return the danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh muc roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc roles
	* @param end the upper bound of the range of danh muc roles (not inclusive)
	* @return the range of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh muc roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc roles
	* @param end the upper bound of the range of danh muc roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.DanhMucRole> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the danh muc roles from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh muc roles.
	*
	* @return the number of danh muc roles
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhMucRolePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhMucRolePersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					DanhMucRolePersistence.class.getName());

			ReferenceRegistry.registerReference(DanhMucRoleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhMucRolePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhMucRoleUtil.class,
			"_persistence");
	}

	private static DanhMucRolePersistence _persistence;
}