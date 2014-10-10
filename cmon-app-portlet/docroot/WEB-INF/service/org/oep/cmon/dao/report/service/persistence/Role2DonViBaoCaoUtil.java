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

import org.oep.cmon.dao.report.model.Role2DonViBaoCao;

import java.util.List;

/**
 * The persistence utility for the role2 don vi bao cao service. This utility wraps {@link Role2DonViBaoCaoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see Role2DonViBaoCaoPersistence
 * @see Role2DonViBaoCaoPersistenceImpl
 * @generated
 */
public class Role2DonViBaoCaoUtil {
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
	public static void clearCache(Role2DonViBaoCao role2DonViBaoCao) {
		getPersistence().clearCache(role2DonViBaoCao);
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
	public static List<Role2DonViBaoCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Role2DonViBaoCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Role2DonViBaoCao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Role2DonViBaoCao update(Role2DonViBaoCao role2DonViBaoCao,
		boolean merge) throws SystemException {
		return getPersistence().update(role2DonViBaoCao, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Role2DonViBaoCao update(Role2DonViBaoCao role2DonViBaoCao,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(role2DonViBaoCao, merge, serviceContext);
	}

	/**
	* Caches the role2 don vi bao cao in the entity cache if it is enabled.
	*
	* @param role2DonViBaoCao the role2 don vi bao cao
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao) {
		getPersistence().cacheResult(role2DonViBaoCao);
	}

	/**
	* Caches the role2 don vi bao caos in the entity cache if it is enabled.
	*
	* @param role2DonViBaoCaos the role2 don vi bao caos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> role2DonViBaoCaos) {
		getPersistence().cacheResult(role2DonViBaoCaos);
	}

	/**
	* Creates a new role2 don vi bao cao with the primary key. Does not add the role2 don vi bao cao to the database.
	*
	* @param ID the primary key for the new role2 don vi bao cao
	* @return the new role2 don vi bao cao
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the role2 don vi bao cao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao that was removed
	* @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao updateImpl(
		org.oep.cmon.dao.report.model.Role2DonViBaoCao role2DonViBaoCao,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(role2DonViBaoCao, merge);
	}

	/**
	* Returns the role2 don vi bao cao with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException} if it could not be found.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao
	* @throws org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchRole2DonViBaoCaoException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the role2 don vi bao cao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the role2 don vi bao cao
	* @return the role2 don vi bao cao, or <code>null</code> if a role2 don vi bao cao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Role2DonViBaoCao fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the role2 don vi bao caos.
	*
	* @return the role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the role2 don vi bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 don vi bao caos
	* @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	* @return the range of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the role2 don vi bao caos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of role2 don vi bao caos
	* @param end the upper bound of the range of role2 don vi bao caos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Role2DonViBaoCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the role2 don vi bao caos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of role2 don vi bao caos.
	*
	* @return the number of role2 don vi bao caos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static Role2DonViBaoCaoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (Role2DonViBaoCaoPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					Role2DonViBaoCaoPersistence.class.getName());

			ReferenceRegistry.registerReference(Role2DonViBaoCaoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(Role2DonViBaoCaoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(Role2DonViBaoCaoUtil.class,
			"_persistence");
	}

	private static Role2DonViBaoCaoPersistence _persistence;
}