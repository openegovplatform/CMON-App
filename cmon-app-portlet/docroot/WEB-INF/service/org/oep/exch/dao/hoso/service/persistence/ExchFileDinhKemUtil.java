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

import org.oep.exch.dao.hoso.model.ExchFileDinhKem;

import java.util.List;

/**
 * The persistence utility for the exch file dinh kem service. This utility wraps {@link ExchFileDinhKemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see ExchFileDinhKemPersistence
 * @see ExchFileDinhKemPersistenceImpl
 * @generated
 */
public class ExchFileDinhKemUtil {
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
	public static void clearCache(ExchFileDinhKem exchFileDinhKem) {
		getPersistence().clearCache(exchFileDinhKem);
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
	public static List<ExchFileDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExchFileDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExchFileDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ExchFileDinhKem update(ExchFileDinhKem exchFileDinhKem,
		boolean merge) throws SystemException {
		return getPersistence().update(exchFileDinhKem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ExchFileDinhKem update(ExchFileDinhKem exchFileDinhKem,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(exchFileDinhKem, merge, serviceContext);
	}

	/**
	* Caches the exch file dinh kem in the entity cache if it is enabled.
	*
	* @param exchFileDinhKem the exch file dinh kem
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem) {
		getPersistence().cacheResult(exchFileDinhKem);
	}

	/**
	* Caches the exch file dinh kems in the entity cache if it is enabled.
	*
	* @param exchFileDinhKems the exch file dinh kems
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> exchFileDinhKems) {
		getPersistence().cacheResult(exchFileDinhKems);
	}

	/**
	* Creates a new exch file dinh kem with the primary key. Does not add the exch file dinh kem to the database.
	*
	* @param id the primary key for the new exch file dinh kem
	* @return the new exch file dinh kem
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the exch file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem updateImpl(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(exchFileDinhKem, merge);
	}

	/**
	* Returns the exch file dinh kem with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException} if it could not be found.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the exch file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem, or <code>null</code> if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the exch file dinh kems where OnlineId = &#63;.
	*
	* @param OnlineId the online ID
	* @return the matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOnlineId(OnlineId);
	}

	/**
	* Returns a range of all the exch file dinh kems where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @return the range of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOnlineId(OnlineId, start, end);
	}

	/**
	* Returns an ordered range of all the exch file dinh kems where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOnlineId(OnlineId, start, end, orderByComparator);
	}

	/**
	* Returns the first exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem findByOnlineId_First(
		long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException {
		return getPersistence().findByOnlineId_First(OnlineId, orderByComparator);
	}

	/**
	* Returns the last exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem findByOnlineId_Last(
		long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException {
		return getPersistence().findByOnlineId_Last(OnlineId, orderByComparator);
	}

	/**
	* Returns the exch file dinh kems before and after the current exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current exch file dinh kem
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.ExchFileDinhKem[] findByOnlineId_PrevAndNext(
		long id, long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException {
		return getPersistence()
				   .findByOnlineId_PrevAndNext(id, OnlineId, orderByComparator);
	}

	/**
	* Returns all the exch file dinh kems.
	*
	* @return the exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the exch file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @return the range of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the exch file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the exch file dinh kems where OnlineId = &#63; from the database.
	*
	* @param OnlineId the online ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOnlineId(long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOnlineId(OnlineId);
	}

	/**
	* Removes all the exch file dinh kems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of exch file dinh kems where OnlineId = &#63;.
	*
	* @param OnlineId the online ID
	* @return the number of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOnlineId(long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOnlineId(OnlineId);
	}

	/**
	* Returns the number of exch file dinh kems.
	*
	* @return the number of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExchFileDinhKemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExchFileDinhKemPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					ExchFileDinhKemPersistence.class.getName());

			ReferenceRegistry.registerReference(ExchFileDinhKemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ExchFileDinhKemPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ExchFileDinhKemUtil.class,
			"_persistence");
	}

	private static ExchFileDinhKemPersistence _persistence;
}