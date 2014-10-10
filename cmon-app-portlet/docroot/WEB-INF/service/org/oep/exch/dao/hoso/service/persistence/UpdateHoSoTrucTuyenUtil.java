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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen;

import java.util.List;

/**
 * The persistence utility for the update ho so truc tuyen service. This utility wraps {@link UpdateHoSoTrucTuyenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see UpdateHoSoTrucTuyenPersistence
 * @see UpdateHoSoTrucTuyenPersistenceImpl
 * @generated
 */
public class UpdateHoSoTrucTuyenUtil {
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
	public static void clearCache(UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		getPersistence().clearCache(updateHoSoTrucTuyen);
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
	public static List<UpdateHoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UpdateHoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UpdateHoSoTrucTuyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static UpdateHoSoTrucTuyen update(
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen, boolean merge)
		throws SystemException {
		return getPersistence().update(updateHoSoTrucTuyen, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static UpdateHoSoTrucTuyen update(
		UpdateHoSoTrucTuyen updateHoSoTrucTuyen, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(updateHoSoTrucTuyen, merge, serviceContext);
	}

	/**
	* Caches the update ho so truc tuyen in the entity cache if it is enabled.
	*
	* @param updateHoSoTrucTuyen the update ho so truc tuyen
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen) {
		getPersistence().cacheResult(updateHoSoTrucTuyen);
	}

	/**
	* Caches the update ho so truc tuyens in the entity cache if it is enabled.
	*
	* @param updateHoSoTrucTuyens the update ho so truc tuyens
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> updateHoSoTrucTuyens) {
		getPersistence().cacheResult(updateHoSoTrucTuyens);
	}

	/**
	* Creates a new update ho so truc tuyen with the primary key. Does not add the update ho so truc tuyen to the database.
	*
	* @param id the primary key for the new update ho so truc tuyen
	* @return the new update ho so truc tuyen
	*/
	public static org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the update ho so truc tuyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateImpl(
		org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen updateHoSoTrucTuyen,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(updateHoSoTrucTuyen, merge);
	}

	/**
	* Returns the update ho so truc tuyen with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException} if it could not be found.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen
	* @throws org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchUpdateHoSoTrucTuyenException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the update ho so truc tuyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the update ho so truc tuyen
	* @return the update ho so truc tuyen, or <code>null</code> if a update ho so truc tuyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the update ho so truc tuyens.
	*
	* @return the update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the update ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update ho so truc tuyens
	* @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	* @return the range of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the update ho so truc tuyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of update ho so truc tuyens
	* @param end the upper bound of the range of update ho so truc tuyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.UpdateHoSoTrucTuyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the update ho so truc tuyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of update ho so truc tuyens.
	*
	* @return the number of update ho so truc tuyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UpdateHoSoTrucTuyenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UpdateHoSoTrucTuyenPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					UpdateHoSoTrucTuyenPersistence.class.getName());

			ReferenceRegistry.registerReference(UpdateHoSoTrucTuyenUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(UpdateHoSoTrucTuyenPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(UpdateHoSoTrucTuyenUtil.class,
			"_persistence");
	}

	private static UpdateHoSoTrucTuyenPersistence _persistence;
}