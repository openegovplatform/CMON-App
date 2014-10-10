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

import org.oep.cmon.dao.report.model.Baocaochitiet;

import java.util.List;

/**
 * The persistence utility for the baocaochitiet service. This utility wraps {@link BaocaochitietPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see BaocaochitietPersistence
 * @see BaocaochitietPersistenceImpl
 * @generated
 */
public class BaocaochitietUtil {
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
	public static void clearCache(Baocaochitiet baocaochitiet) {
		getPersistence().clearCache(baocaochitiet);
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
	public static List<Baocaochitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Baocaochitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Baocaochitiet> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Baocaochitiet update(Baocaochitiet baocaochitiet,
		boolean merge) throws SystemException {
		return getPersistence().update(baocaochitiet, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Baocaochitiet update(Baocaochitiet baocaochitiet,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(baocaochitiet, merge, serviceContext);
	}

	/**
	* Caches the baocaochitiet in the entity cache if it is enabled.
	*
	* @param baocaochitiet the baocaochitiet
	*/
	public static void cacheResult(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet) {
		getPersistence().cacheResult(baocaochitiet);
	}

	/**
	* Caches the baocaochitiets in the entity cache if it is enabled.
	*
	* @param baocaochitiets the baocaochitiets
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> baocaochitiets) {
		getPersistence().cacheResult(baocaochitiets);
	}

	/**
	* Creates a new baocaochitiet with the primary key. Does not add the baocaochitiet to the database.
	*
	* @param MASOHOSO the primary key for the new baocaochitiet
	* @return the new baocaochitiet
	*/
	public static org.oep.cmon.dao.report.model.Baocaochitiet create(
		java.lang.String MASOHOSO) {
		return getPersistence().create(MASOHOSO);
	}

	/**
	* Removes the baocaochitiet with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet that was removed
	* @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Baocaochitiet remove(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchBaocaochitietException {
		return getPersistence().remove(MASOHOSO);
	}

	public static org.oep.cmon.dao.report.model.Baocaochitiet updateImpl(
		org.oep.cmon.dao.report.model.Baocaochitiet baocaochitiet, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(baocaochitiet, merge);
	}

	/**
	* Returns the baocaochitiet with the primary key or throws a {@link org.oep.cmon.dao.report.NoSuchBaocaochitietException} if it could not be found.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet
	* @throws org.oep.cmon.dao.report.NoSuchBaocaochitietException if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Baocaochitiet findByPrimaryKey(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.report.NoSuchBaocaochitietException {
		return getPersistence().findByPrimaryKey(MASOHOSO);
	}

	/**
	* Returns the baocaochitiet with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param MASOHOSO the primary key of the baocaochitiet
	* @return the baocaochitiet, or <code>null</code> if a baocaochitiet with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.report.model.Baocaochitiet fetchByPrimaryKey(
		java.lang.String MASOHOSO)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(MASOHOSO);
	}

	/**
	* Returns all the baocaochitiets.
	*
	* @return the baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the baocaochitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of baocaochitiets
	* @param end the upper bound of the range of baocaochitiets (not inclusive)
	* @return the range of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the baocaochitiets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of baocaochitiets
	* @param end the upper bound of the range of baocaochitiets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.report.model.Baocaochitiet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the baocaochitiets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of baocaochitiets.
	*
	* @return the number of baocaochitiets
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BaocaochitietPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BaocaochitietPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.report.service.ClpSerializer.getServletContextName(),
					BaocaochitietPersistence.class.getName());

			ReferenceRegistry.registerReference(BaocaochitietUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(BaocaochitietPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(BaocaochitietUtil.class,
			"_persistence");
	}

	private static BaocaochitietPersistence _persistence;
}