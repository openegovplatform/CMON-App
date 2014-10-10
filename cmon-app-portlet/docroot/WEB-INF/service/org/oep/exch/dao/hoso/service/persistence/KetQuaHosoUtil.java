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

import org.oep.exch.dao.hoso.model.KetQuaHoso;

import java.util.List;

/**
 * The persistence utility for the ket qua hoso service. This utility wraps {@link KetQuaHosoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see KetQuaHosoPersistence
 * @see KetQuaHosoPersistenceImpl
 * @generated
 */
public class KetQuaHosoUtil {
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
	public static void clearCache(KetQuaHoso ketQuaHoso) {
		getPersistence().clearCache(ketQuaHoso);
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
	public static List<KetQuaHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KetQuaHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KetQuaHoso> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static KetQuaHoso update(KetQuaHoso ketQuaHoso, boolean merge)
		throws SystemException {
		return getPersistence().update(ketQuaHoso, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static KetQuaHoso update(KetQuaHoso ketQuaHoso, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ketQuaHoso, merge, serviceContext);
	}

	/**
	* Caches the ket qua hoso in the entity cache if it is enabled.
	*
	* @param ketQuaHoso the ket qua hoso
	*/
	public static void cacheResult(
		org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso) {
		getPersistence().cacheResult(ketQuaHoso);
	}

	/**
	* Caches the ket qua hosos in the entity cache if it is enabled.
	*
	* @param ketQuaHosos the ket qua hosos
	*/
	public static void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> ketQuaHosos) {
		getPersistence().cacheResult(ketQuaHosos);
	}

	/**
	* Creates a new ket qua hoso with the primary key. Does not add the ket qua hoso to the database.
	*
	* @param id the primary key for the new ket qua hoso
	* @return the new ket qua hoso
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ket qua hoso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException {
		return getPersistence().remove(id);
	}

	public static org.oep.exch.dao.hoso.model.KetQuaHoso updateImpl(
		org.oep.exch.dao.hoso.model.KetQuaHoso ketQuaHoso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ketQuaHoso, merge);
	}

	/**
	* Returns the ket qua hoso with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchKetQuaHosoException} if it could not be found.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ket qua hoso with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ket qua hoso
	* @return the ket qua hoso, or <code>null</code> if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns a range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @return the range of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiXuLy(TrangThaiXuLy, start, end);
	}

	/**
	* Returns an ordered range of all the ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findByTrangThaiXuLy(
		int TrangThaiXuLy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiXuLy(TrangThaiXuLy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso findByTrangThaiXuLy_First(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_First(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the last ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a matching ket qua hoso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso findByTrangThaiXuLy_Last(
		int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_Last(TrangThaiXuLy, orderByComparator);
	}

	/**
	* Returns the ket qua hosos before and after the current ket qua hoso in the ordered set where TrangThaiXuLy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ket qua hoso
	* @param TrangThaiXuLy the trang thai xu ly
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ket qua hoso
	* @throws org.oep.exch.dao.hoso.NoSuchKetQuaHosoException if a ket qua hoso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.exch.dao.hoso.model.KetQuaHoso[] findByTrangThaiXuLy_PrevAndNext(
		long id, int TrangThaiXuLy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchKetQuaHosoException {
		return getPersistence()
				   .findByTrangThaiXuLy_PrevAndNext(id, TrangThaiXuLy,
			orderByComparator);
	}

	/**
	* Returns all the ket qua hosos.
	*
	* @return the ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ket qua hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @return the range of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ket qua hosos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ket qua hosos
	* @param end the upper bound of the range of ket qua hosos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.exch.dao.hoso.model.KetQuaHoso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ket qua hosos where TrangThaiXuLy = &#63; from the database.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Removes all the ket qua hosos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ket qua hosos where TrangThaiXuLy = &#63;.
	*
	* @param TrangThaiXuLy the trang thai xu ly
	* @return the number of matching ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThaiXuLy(int TrangThaiXuLy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThaiXuLy(TrangThaiXuLy);
	}

	/**
	* Returns the number of ket qua hosos.
	*
	* @return the number of ket qua hosos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static KetQuaHosoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KetQuaHosoPersistence)PortletBeanLocatorUtil.locate(org.oep.exch.dao.hoso.service.ClpSerializer.getServletContextName(),
					KetQuaHosoPersistence.class.getName());

			ReferenceRegistry.registerReference(KetQuaHosoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(KetQuaHosoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(KetQuaHosoUtil.class, "_persistence");
	}

	private static KetQuaHosoPersistence _persistence;
}