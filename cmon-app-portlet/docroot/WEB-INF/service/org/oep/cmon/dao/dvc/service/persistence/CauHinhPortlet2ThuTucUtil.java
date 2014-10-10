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

import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;

import java.util.List;

/**
 * The persistence utility for the cau hinh portlet2 thu tuc service. This utility wraps {@link CauHinhPortlet2ThuTucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CauHinhPortlet2ThuTucPersistence
 * @see CauHinhPortlet2ThuTucPersistenceImpl
 * @generated
 */
public class CauHinhPortlet2ThuTucUtil {
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
	public static void clearCache(CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		getPersistence().clearCache(cauHinhPortlet2ThuTuc);
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
	public static List<CauHinhPortlet2ThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CauHinhPortlet2ThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CauHinhPortlet2ThuTuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CauHinhPortlet2ThuTuc update(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc, boolean merge)
		throws SystemException {
		return getPersistence().update(cauHinhPortlet2ThuTuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CauHinhPortlet2ThuTuc update(
		CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(cauHinhPortlet2ThuTuc, merge, serviceContext);
	}

	/**
	* Caches the cau hinh portlet2 thu tuc in the entity cache if it is enabled.
	*
	* @param cauHinhPortlet2ThuTuc the cau hinh portlet2 thu tuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		getPersistence().cacheResult(cauHinhPortlet2ThuTuc);
	}

	/**
	* Caches the cau hinh portlet2 thu tucs in the entity cache if it is enabled.
	*
	* @param cauHinhPortlet2ThuTucs the cau hinh portlet2 thu tucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> cauHinhPortlet2ThuTucs) {
		getPersistence().cacheResult(cauHinhPortlet2ThuTucs);
	}

	/**
	* Creates a new cau hinh portlet2 thu tuc with the primary key. Does not add the cau hinh portlet2 thu tuc to the database.
	*
	* @param thuTucHanhChinhId the primary key for the new cau hinh portlet2 thu tuc
	* @return the new cau hinh portlet2 thu tuc
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc create(
		long thuTucHanhChinhId) {
		return getPersistence().create(thuTucHanhChinhId);
	}

	/**
	* Removes the cau hinh portlet2 thu tuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc remove(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException {
		return getPersistence().remove(thuTucHanhChinhId);
	}

	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc updateImpl(
		org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cauHinhPortlet2ThuTuc, merge);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc findByPrimaryKey(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException {
		return getPersistence().findByPrimaryKey(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param thuTucHanhChinhId the primary key of the cau hinh portlet2 thu tuc
	* @return the cau hinh portlet2 thu tuc, or <code>null</code> if a cau hinh portlet2 thu tuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByPrimaryKey(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException} if it could not be found.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching cau hinh portlet2 thu tuc
	* @throws org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc findByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException {
		return getPersistence().findByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching cau hinh portlet2 thu tuc, or <code>null</code> if a matching cau hinh portlet2 thu tuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc fetchByThuTucHanhChinhId(
		long thuTucHanhChinhId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByThuTucHanhChinhId(thuTucHanhChinhId,
			retrieveFromCache);
	}

	/**
	* Returns all the cau hinh portlet2 thu tucs.
	*
	* @return the cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @return the range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cau hinh portlet2 thu tucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cau hinh portlet2 thu tucs
	* @param end the upper bound of the range of cau hinh portlet2 thu tucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the cau hinh portlet2 thu tuc where thuTucHanhChinhId = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCauHinhPortlet2ThuTucException {
		getPersistence().removeByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Removes all the cau hinh portlet2 thu tucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cau hinh portlet2 thu tucs where thuTucHanhChinhId = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhId(long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the number of cau hinh portlet2 thu tucs.
	*
	* @return the number of cau hinh portlet2 thu tucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CauHinhPortlet2ThuTucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CauHinhPortlet2ThuTucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					CauHinhPortlet2ThuTucPersistence.class.getName());

			ReferenceRegistry.registerReference(CauHinhPortlet2ThuTucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CauHinhPortlet2ThuTucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CauHinhPortlet2ThuTucUtil.class,
			"_persistence");
	}

	private static CauHinhPortlet2ThuTucPersistence _persistence;
}