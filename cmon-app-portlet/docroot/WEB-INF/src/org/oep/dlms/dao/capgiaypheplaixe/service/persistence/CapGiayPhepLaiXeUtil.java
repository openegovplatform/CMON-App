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

package org.oep.dlms.dao.capgiaypheplaixe.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;


import java.util.List;

import org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe;

/**
 * The persistence utility for the cap giay phep lai xe service. This utility wraps {@link CapGiayPhepLaiXePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see CapGiayPhepLaiXePersistence
 * @see CapGiayPhepLaiXePersistenceImpl
 * @generated
 */
public class CapGiayPhepLaiXeUtil {
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
	public static void clearCache(CapGiayPhepLaiXe capGiayPhepLaiXe) {
		getPersistence().clearCache(capGiayPhepLaiXe);
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
	public static List<CapGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CapGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CapGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CapGiayPhepLaiXe update(CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge) throws SystemException {
		return getPersistence().update(capGiayPhepLaiXe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CapGiayPhepLaiXe update(CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(capGiayPhepLaiXe, merge, serviceContext);
	}

	/**
	* Caches the cap giay phep lai xe in the entity cache if it is enabled.
	*
	* @param capGiayPhepLaiXe the cap giay phep lai xe
	*/
	public static void cacheResult(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe) {
		getPersistence().cacheResult(capGiayPhepLaiXe);
	}

	/**
	* Caches the cap giay phep lai xes in the entity cache if it is enabled.
	*
	* @param capGiayPhepLaiXes the cap giay phep lai xes
	*/
	public static void cacheResult(
		java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> capGiayPhepLaiXes) {
		getPersistence().cacheResult(capGiayPhepLaiXes);
	}

	/**
	* Creates a new cap giay phep lai xe with the primary key. Does not add the cap giay phep lai xe to the database.
	*
	* @param id the primary key for the new cap giay phep lai xe
	* @return the new cap giay phep lai xe
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the cap giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe that was removed
	* @throws org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException {
		return getPersistence().remove(id);
	}

	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe updateImpl(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(capGiayPhepLaiXe, merge);
	}

	/**
	* Returns the cap giay phep lai xe with the primary key or throws a {@link org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException} if it could not be found.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe
	* @throws org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.capgiaypheplaixe.NoSuchCapGiayPhepLaiXeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the cap giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cap giay phep lai xe
	* @return the cap giay phep lai xe, or <code>null</code> if a cap giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the cap giay phep lai xes.
	*
	* @return the cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cap giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap giay phep lai xes
	* @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	* @return the range of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cap giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap giay phep lai xes
	* @param end the upper bound of the range of cap giay phep lai xes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cap giay phep lai xes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cap giay phep lai xes.
	*
	* @return the number of cap giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CapGiayPhepLaiXePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CapGiayPhepLaiXePersistence)PortletBeanLocatorUtil.locate(org.oep.dlms.dao.capgiaypheplaixe.service.ClpSerializer.getServletContextName(),
					CapGiayPhepLaiXePersistence.class.getName());

			ReferenceRegistry.registerReference(CapGiayPhepLaiXeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CapGiayPhepLaiXePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CapGiayPhepLaiXeUtil.class,
			"_persistence");
	}

	private static CapGiayPhepLaiXePersistence _persistence;
}