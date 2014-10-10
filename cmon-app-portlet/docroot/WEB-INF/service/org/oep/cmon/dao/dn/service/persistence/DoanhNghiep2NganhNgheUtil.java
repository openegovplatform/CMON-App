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

package org.oep.cmon.dao.dn.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe;

import java.util.List;

/**
 * The persistence utility for the doanh nghiep2 nganh nghe service. This utility wraps {@link DoanhNghiep2NganhNghePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DoanhNghiep2NganhNghePersistence
 * @see DoanhNghiep2NganhNghePersistenceImpl
 * @generated
 */
public class DoanhNghiep2NganhNgheUtil {
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
	public static void clearCache(DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		getPersistence().clearCache(doanhNghiep2NganhNghe);
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
	public static List<DoanhNghiep2NganhNghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DoanhNghiep2NganhNghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DoanhNghiep2NganhNghe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DoanhNghiep2NganhNghe update(
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe, boolean merge)
		throws SystemException {
		return getPersistence().update(doanhNghiep2NganhNghe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DoanhNghiep2NganhNghe update(
		DoanhNghiep2NganhNghe doanhNghiep2NganhNghe, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(doanhNghiep2NganhNghe, merge, serviceContext);
	}

	/**
	* Caches the doanh nghiep2 nganh nghe in the entity cache if it is enabled.
	*
	* @param doanhNghiep2NganhNghe the doanh nghiep2 nganh nghe
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe) {
		getPersistence().cacheResult(doanhNghiep2NganhNghe);
	}

	/**
	* Caches the doanh nghiep2 nganh nghes in the entity cache if it is enabled.
	*
	* @param doanhNghiep2NganhNghes the doanh nghiep2 nganh nghes
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> doanhNghiep2NganhNghes) {
		getPersistence().cacheResult(doanhNghiep2NganhNghes);
	}

	/**
	* Creates a new doanh nghiep2 nganh nghe with the primary key. Does not add the doanh nghiep2 nganh nghe to the database.
	*
	* @param id the primary key for the new doanh nghiep2 nganh nghe
	* @return the new doanh nghiep2 nganh nghe
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the doanh nghiep2 nganh nghe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe that was removed
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe updateImpl(
		org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe doanhNghiep2NganhNghe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(doanhNghiep2NganhNghe, merge);
	}

	/**
	* Returns the doanh nghiep2 nganh nghe with the primary key or throws a {@link org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException} if it could not be found.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe
	* @throws org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dn.NoSuchDoanhNghiep2NganhNgheException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the doanh nghiep2 nganh nghe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doanh nghiep2 nganh nghe
	* @return the doanh nghiep2 nganh nghe, or <code>null</code> if a doanh nghiep2 nganh nghe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the doanh nghiep2 nganh nghes.
	*
	* @return the doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the doanh nghiep2 nganh nghes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghiep2 nganh nghes
	* @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	* @return the range of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the doanh nghiep2 nganh nghes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doanh nghiep2 nganh nghes
	* @param end the upper bound of the range of doanh nghiep2 nganh nghes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the doanh nghiep2 nganh nghes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of doanh nghiep2 nganh nghes.
	*
	* @return the number of doanh nghiep2 nganh nghes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DoanhNghiep2NganhNghePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DoanhNghiep2NganhNghePersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dn.service.ClpSerializer.getServletContextName(),
					DoanhNghiep2NganhNghePersistence.class.getName());

			ReferenceRegistry.registerReference(DoanhNghiep2NganhNgheUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DoanhNghiep2NganhNghePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DoanhNghiep2NganhNgheUtil.class,
			"_persistence");
	}

	private static DoanhNghiep2NganhNghePersistence _persistence;
}