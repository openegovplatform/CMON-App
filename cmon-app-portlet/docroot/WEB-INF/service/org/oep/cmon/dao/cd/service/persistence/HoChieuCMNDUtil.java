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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.cd.model.HoChieuCMND;

import java.util.List;

/**
 * The persistence utility for the ho chieu c m n d service. This utility wraps {@link HoChieuCMNDPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see HoChieuCMNDPersistence
 * @see HoChieuCMNDPersistenceImpl
 * @generated
 */
public class HoChieuCMNDUtil {
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
	public static void clearCache(HoChieuCMND hoChieuCMND) {
		getPersistence().clearCache(hoChieuCMND);
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
	public static List<HoChieuCMND> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoChieuCMND> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoChieuCMND> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoChieuCMND update(HoChieuCMND hoChieuCMND, boolean merge)
		throws SystemException {
		return getPersistence().update(hoChieuCMND, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoChieuCMND update(HoChieuCMND hoChieuCMND, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoChieuCMND, merge, serviceContext);
	}

	/**
	* Caches the ho chieu c m n d in the entity cache if it is enabled.
	*
	* @param hoChieuCMND the ho chieu c m n d
	*/
	public static void cacheResult(
		org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND) {
		getPersistence().cacheResult(hoChieuCMND);
	}

	/**
	* Caches the ho chieu c m n ds in the entity cache if it is enabled.
	*
	* @param hoChieuCMNDs the ho chieu c m n ds
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> hoChieuCMNDs) {
		getPersistence().cacheResult(hoChieuCMNDs);
	}

	/**
	* Creates a new ho chieu c m n d with the primary key. Does not add the ho chieu c m n d to the database.
	*
	* @param id the primary key for the new ho chieu c m n d
	* @return the new ho chieu c m n d
	*/
	public static org.oep.cmon.dao.cd.model.HoChieuCMND create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho chieu c m n d with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HoChieuCMND remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cd.model.HoChieuCMND updateImpl(
		org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoChieuCMND, merge);
	}

	/**
	* Returns the ho chieu c m n d with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException} if it could not be found.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d
	* @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HoChieuCMND findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho chieu c m n d with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d, or <code>null</code> if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.HoChieuCMND fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ho chieu c m n ds.
	*
	* @return the ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ho chieu c m n ds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho chieu c m n ds
	* @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	* @return the range of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ho chieu c m n ds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho chieu c m n ds
	* @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho chieu c m n ds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho chieu c m n ds.
	*
	* @return the number of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoChieuCMNDPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoChieuCMNDPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					HoChieuCMNDPersistence.class.getName());

			ReferenceRegistry.registerReference(HoChieuCMNDUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoChieuCMNDPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoChieuCMNDUtil.class,
			"_persistence");
	}

	private static HoChieuCMNDPersistence _persistence;
}