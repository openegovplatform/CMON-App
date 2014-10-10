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

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt;

/**
 * The persistence utility for the don vi gtvt service. This utility wraps {@link DonViGtvtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see DonViGtvtPersistence
 * @see DonViGtvtPersistenceImpl
 * @generated
 */
public class DonViGtvtUtil {
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
	public static void clearCache(DonViGtvt donViGtvt) {
		getPersistence().clearCache(donViGtvt);
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
	public static List<DonViGtvt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DonViGtvt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DonViGtvt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DonViGtvt update(DonViGtvt donViGtvt, boolean merge)
		throws SystemException {
		return getPersistence().update(donViGtvt, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DonViGtvt update(DonViGtvt donViGtvt, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(donViGtvt, merge, serviceContext);
	}

	/**
	* Caches the don vi gtvt in the entity cache if it is enabled.
	*
	* @param donViGtvt the don vi gtvt
	*/
	public static void cacheResult(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt) {
		getPersistence().cacheResult(donViGtvt);
	}

	/**
	* Caches the don vi gtvts in the entity cache if it is enabled.
	*
	* @param donViGtvts the don vi gtvts
	*/
	public static void cacheResult(
		java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> donViGtvts) {
		getPersistence().cacheResult(donViGtvts);
	}

	/**
	* Creates a new don vi gtvt with the primary key. Does not add the don vi gtvt to the database.
	*
	* @param id the primary key for the new don vi gtvt
	* @return the new don vi gtvt
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the don vi gtvt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt that was removed
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException {
		return getPersistence().remove(id);
	}

	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt donViGtvt,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(donViGtvt, merge);
	}

	/**
	* Returns the don vi gtvt with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException} if it could not be found.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchDonViGtvtException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the don vi gtvt with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the don vi gtvt
	* @return the don vi gtvt, or <code>null</code> if a don vi gtvt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the don vi gtvts.
	*
	* @return the don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @return the range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the don vi gtvts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of don vi gtvts
	* @param end the upper bound of the range of don vi gtvts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the don vi gtvts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of don vi gtvts.
	*
	* @return the number of don vi gtvts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DonViGtvtPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DonViGtvtPersistence)PortletBeanLocatorUtil.locate(org.oep.dlms.dao.danhmucgiaypheplaixe.service.ClpSerializer.getServletContextName(),
					DonViGtvtPersistence.class.getName());

			ReferenceRegistry.registerReference(DonViGtvtUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DonViGtvtPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DonViGtvtUtil.class, "_persistence");
	}

	private static DonViGtvtPersistence _persistence;
}