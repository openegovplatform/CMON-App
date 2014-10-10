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

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe;

/**
 * The persistence utility for the hang giay phep lai xe service. This utility wraps {@link HangGiayPhepLaiXePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author AnhNT
 * @see HangGiayPhepLaiXePersistence
 * @see HangGiayPhepLaiXePersistenceImpl
 * @generated
 */
public class HangGiayPhepLaiXeUtil {
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
	public static void clearCache(HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		getPersistence().clearCache(hangGiayPhepLaiXe);
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
	public static List<HangGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HangGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HangGiayPhepLaiXe> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HangGiayPhepLaiXe update(
		HangGiayPhepLaiXe hangGiayPhepLaiXe, boolean merge)
		throws SystemException {
		return getPersistence().update(hangGiayPhepLaiXe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HangGiayPhepLaiXe update(
		HangGiayPhepLaiXe hangGiayPhepLaiXe, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hangGiayPhepLaiXe, merge, serviceContext);
	}

	/**
	* Caches the hang giay phep lai xe in the entity cache if it is enabled.
	*
	* @param hangGiayPhepLaiXe the hang giay phep lai xe
	*/
	public static void cacheResult(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe) {
		getPersistence().cacheResult(hangGiayPhepLaiXe);
	}

	/**
	* Caches the hang giay phep lai xes in the entity cache if it is enabled.
	*
	* @param hangGiayPhepLaiXes the hang giay phep lai xes
	*/
	public static void cacheResult(
		java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe> hangGiayPhepLaiXes) {
		getPersistence().cacheResult(hangGiayPhepLaiXes);
	}

	/**
	* Creates a new hang giay phep lai xe with the primary key. Does not add the hang giay phep lai xe to the database.
	*
	* @param id the primary key for the new hang giay phep lai xe
	* @return the new hang giay phep lai xe
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the hang giay phep lai xe with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the hang giay phep lai xe
	* @return the hang giay phep lai xe that was removed
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException if a hang giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException {
		return getPersistence().remove(id);
	}

	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe updateImpl(
		org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe hangGiayPhepLaiXe,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hangGiayPhepLaiXe, merge);
	}

	/**
	* Returns the hang giay phep lai xe with the primary key or throws a {@link org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException} if it could not be found.
	*
	* @param id the primary key of the hang giay phep lai xe
	* @return the hang giay phep lai xe
	* @throws org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException if a hang giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.danhmucgiaypheplaixe.NoSuchHangGiayPhepLaiXeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the hang giay phep lai xe with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the hang giay phep lai xe
	* @return the hang giay phep lai xe, or <code>null</code> if a hang giay phep lai xe with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the hang giay phep lai xes.
	*
	* @return the hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the hang giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of hang giay phep lai xes
	* @param end the upper bound of the range of hang giay phep lai xes (not inclusive)
	* @return the range of hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the hang giay phep lai xes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of hang giay phep lai xes
	* @param end the upper bound of the range of hang giay phep lai xes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the hang giay phep lai xes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of hang giay phep lai xes.
	*
	* @return the number of hang giay phep lai xes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HangGiayPhepLaiXePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HangGiayPhepLaiXePersistence)PortletBeanLocatorUtil.locate(org.oep.dlms.dao.danhmucgiaypheplaixe.service.ClpSerializer.getServletContextName(),
					HangGiayPhepLaiXePersistence.class.getName());

			ReferenceRegistry.registerReference(HangGiayPhepLaiXeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HangGiayPhepLaiXePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HangGiayPhepLaiXeUtil.class,
			"_persistence");
	}

	private static HangGiayPhepLaiXePersistence _persistence;
}