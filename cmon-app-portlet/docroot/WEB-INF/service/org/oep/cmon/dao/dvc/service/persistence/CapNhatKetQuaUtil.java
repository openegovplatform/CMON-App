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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dvc.model.CapNhatKetQua;

import java.util.List;

/**
 * The persistence utility for the cap nhat ket qua service. This utility wraps {@link CapNhatKetQuaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CapNhatKetQuaPersistence
 * @see CapNhatKetQuaPersistenceImpl
 * @generated
 */
public class CapNhatKetQuaUtil {
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
	public static void clearCache(CapNhatKetQua capNhatKetQua) {
		getPersistence().clearCache(capNhatKetQua);
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
	public static List<CapNhatKetQua> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CapNhatKetQua> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CapNhatKetQua> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CapNhatKetQua update(CapNhatKetQua capNhatKetQua,
		boolean merge) throws SystemException {
		return getPersistence().update(capNhatKetQua, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CapNhatKetQua update(CapNhatKetQua capNhatKetQua,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(capNhatKetQua, merge, serviceContext);
	}

	/**
	* Caches the cap nhat ket qua in the entity cache if it is enabled.
	*
	* @param capNhatKetQua the cap nhat ket qua
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua) {
		getPersistence().cacheResult(capNhatKetQua);
	}

	/**
	* Caches the cap nhat ket quas in the entity cache if it is enabled.
	*
	* @param capNhatKetQuas the cap nhat ket quas
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> capNhatKetQuas) {
		getPersistence().cacheResult(capNhatKetQuas);
	}

	/**
	* Creates a new cap nhat ket qua with the primary key. Does not add the cap nhat ket qua to the database.
	*
	* @param id the primary key for the new cap nhat ket qua
	* @return the new cap nhat ket qua
	*/
	public static org.oep.cmon.dao.dvc.model.CapNhatKetQua create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cap nhat ket qua with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CapNhatKetQua remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.CapNhatKetQua updateImpl(
		org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(capNhatKetQua, merge);
	}

	/**
	* Returns the cap nhat ket qua with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException} if it could not be found.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua
	* @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CapNhatKetQua findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cap nhat ket qua with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua, or <code>null</code> if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CapNhatKetQua fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cap nhat ket quas.
	*
	* @return the cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cap nhat ket quas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap nhat ket quas
	* @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	* @return the range of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cap nhat ket quas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap nhat ket quas
	* @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cap nhat ket quas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cap nhat ket quas.
	*
	* @return the number of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CapNhatKetQuaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CapNhatKetQuaPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					CapNhatKetQuaPersistence.class.getName());

			ReferenceRegistry.registerReference(CapNhatKetQuaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CapNhatKetQuaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CapNhatKetQuaUtil.class,
			"_persistence");
	}

	private static CapNhatKetQuaPersistence _persistence;
}