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

package org.oep.dlms.dao.danhmucgiaypheplaixe.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;


import java.util.List;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX;

/**
 * The persistence utility for the ly do cap doi cap lai g p l x service. This utility wraps {@link LyDoCapDoiCapLaiGPLXPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see LyDoCapDoiCapLaiGPLXPersistence
 * @see LyDoCapDoiCapLaiGPLXPersistenceImpl
 * @generated
 */
public class LyDoCapDoiCapLaiGPLXUtil {
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
	public static void clearCache(LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		getPersistence().clearCache(lyDoCapDoiCapLaiGPLX);
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
	public static List<LyDoCapDoiCapLaiGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LyDoCapDoiCapLaiGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LyDoCapDoiCapLaiGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LyDoCapDoiCapLaiGPLX update(
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX, boolean merge)
		throws SystemException {
		return getPersistence().update(lyDoCapDoiCapLaiGPLX, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LyDoCapDoiCapLaiGPLX update(
		LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(lyDoCapDoiCapLaiGPLX, merge, serviceContext);
	}

	/**
	* Caches the ly do cap doi cap lai g p l x in the entity cache if it is enabled.
	*
	* @param lyDoCapDoiCapLaiGPLX the ly do cap doi cap lai g p l x
	*/
	public static void cacheResult(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX) {
		getPersistence().cacheResult(lyDoCapDoiCapLaiGPLX);
	}

	/**
	* Caches the ly do cap doi cap lai g p l xs in the entity cache if it is enabled.
	*
	* @param lyDoCapDoiCapLaiGPLXs the ly do cap doi cap lai g p l xs
	*/
	public static void cacheResult(
		java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> lyDoCapDoiCapLaiGPLXs) {
		getPersistence().cacheResult(lyDoCapDoiCapLaiGPLXs);
	}

	/**
	* Creates a new ly do cap doi cap lai g p l x with the primary key. Does not add the ly do cap doi cap lai g p l x to the database.
	*
	* @param id the primary key for the new ly do cap doi cap lai g p l x
	* @return the new ly do cap doi cap lai g p l x
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ly do cap doi cap lai g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x that was removed
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException {
		return getPersistence().remove(id);
	}

	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX lyDoCapDoiCapLaiGPLX,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lyDoCapDoiCapLaiGPLX, merge);
	}

	/**
	* Returns the ly do cap doi cap lai g p l x with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException} if it could not be found.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchLyDoCapDoiCapLaiGPLXException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ly do cap doi cap lai g p l x with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ly do cap doi cap lai g p l x
	* @return the ly do cap doi cap lai g p l x, or <code>null</code> if a ly do cap doi cap lai g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ly do cap doi cap lai g p l xs.
	*
	* @return the ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ly do cap doi cap lai g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	* @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	* @return the range of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ly do cap doi cap lai g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ly do cap doi cap lai g p l xs
	* @param end the upper bound of the range of ly do cap doi cap lai g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ly do cap doi cap lai g p l xs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ly do cap doi cap lai g p l xs.
	*
	* @return the number of ly do cap doi cap lai g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LyDoCapDoiCapLaiGPLXPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LyDoCapDoiCapLaiGPLXPersistence)PortletBeanLocatorUtil.locate(org.oep.dlms.dao.danhmucgiaypheplaixe.service.ClpSerializer.getServletContextName(),
					LyDoCapDoiCapLaiGPLXPersistence.class.getName());

			ReferenceRegistry.registerReference(LyDoCapDoiCapLaiGPLXUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LyDoCapDoiCapLaiGPLXPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LyDoCapDoiCapLaiGPLXUtil.class,
			"_persistence");
	}

	private static LyDoCapDoiCapLaiGPLXPersistence _persistence;
}