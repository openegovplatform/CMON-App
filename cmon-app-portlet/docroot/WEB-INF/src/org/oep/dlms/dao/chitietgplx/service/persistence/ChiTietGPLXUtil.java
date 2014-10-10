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

package org.oep.dlms.dao.chitietgplx.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;


import java.util.List;

import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX;

/**
 * The persistence utility for the chi tiet g p l x service. This utility wraps {@link ChiTietGPLXPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hunghq
 * @see ChiTietGPLXPersistence
 * @see ChiTietGPLXPersistenceImpl
 * @generated
 */
public class ChiTietGPLXUtil {
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
	public static void clearCache(ChiTietGPLX chiTietGPLX) {
		getPersistence().clearCache(chiTietGPLX);
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
	public static List<ChiTietGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChiTietGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChiTietGPLX> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ChiTietGPLX update(ChiTietGPLX chiTietGPLX, boolean merge)
		throws SystemException {
		return getPersistence().update(chiTietGPLX, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ChiTietGPLX update(ChiTietGPLX chiTietGPLX, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chiTietGPLX, merge, serviceContext);
	}

	/**
	* Caches the chi tiet g p l x in the entity cache if it is enabled.
	*
	* @param chiTietGPLX the chi tiet g p l x
	*/
	public static void cacheResult(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX) {
		getPersistence().cacheResult(chiTietGPLX);
	}

	/**
	* Caches the chi tiet g p l xs in the entity cache if it is enabled.
	*
	* @param chiTietGPLXs the chi tiet g p l xs
	*/
	public static void cacheResult(
		java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> chiTietGPLXs) {
		getPersistence().cacheResult(chiTietGPLXs);
	}

	/**
	* Creates a new chi tiet g p l x with the primary key. Does not add the chi tiet g p l x to the database.
	*
	* @param id the primary key for the new chi tiet g p l x
	* @return the new chi tiet g p l x
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the chi tiet g p l x with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x that was removed
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException {
		return getPersistence().remove(id);
	}

	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX updateImpl(
		org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX chiTietGPLX, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chiTietGPLX, merge);
	}

	/**
	* Returns the chi tiet g p l x with the primary key or throws a {@link org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException} if it could not be found.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the chi tiet g p l x with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chi tiet g p l x
	* @return the chi tiet g p l x, or <code>null</code> if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* @param idGPLX the id g p l x
	* @return the matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGPLX(idGPLX);
	}

	/**
	* Returns a range of all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @return the range of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGPLX(idGPLX, start, end);
	}

	/**
	* Returns an ordered range of all the chi tiet g p l xs where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findByGPLX(
		long idGPLX, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGPLX(idGPLX, start, end, orderByComparator);
	}

	/**
	* Returns the first chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByGPLX_First(
		long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException {
		return getPersistence().findByGPLX_First(idGPLX, orderByComparator);
	}

	/**
	* Returns the last chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a matching chi tiet g p l x could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX findByGPLX_Last(
		long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException {
		return getPersistence().findByGPLX_Last(idGPLX, orderByComparator);
	}

	/**
	* Returns the chi tiet g p l xs before and after the current chi tiet g p l x in the ordered set where idGPLX = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chi tiet g p l x
	* @param idGPLX the id g p l x
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chi tiet g p l x
	* @throws org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException if a chi tiet g p l x with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX[] findByGPLX_PrevAndNext(
		long id, long idGPLX,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.dlms.dao.chitietgplx.NoSuchChiTietGPLXException {
		return getPersistence()
				   .findByGPLX_PrevAndNext(id, idGPLX, orderByComparator);
	}

	/**
	* Returns all the chi tiet g p l xs.
	*
	* @return the chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chi tiet g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @return the range of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chi tiet g p l xs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chi tiet g p l xs
	* @param end the upper bound of the range of chi tiet g p l xs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the chi tiet g p l xs where idGPLX = &#63; from the database.
	*
	* @param idGPLX the id g p l x
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGPLX(long idGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGPLX(idGPLX);
	}

	/**
	* Removes all the chi tiet g p l xs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chi tiet g p l xs where idGPLX = &#63;.
	*
	* @param idGPLX the id g p l x
	* @return the number of matching chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGPLX(long idGPLX)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGPLX(idGPLX);
	}

	/**
	* Returns the number of chi tiet g p l xs.
	*
	* @return the number of chi tiet g p l xs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChiTietGPLXPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChiTietGPLXPersistence)PortletBeanLocatorUtil.locate(org.oep.dlms.dao.chitietgplx.service.ClpSerializer.getServletContextName(),
					ChiTietGPLXPersistence.class.getName());

			ReferenceRegistry.registerReference(ChiTietGPLXUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ChiTietGPLXPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ChiTietGPLXUtil.class,
			"_persistence");
	}

	private static ChiTietGPLXPersistence _persistence;
}