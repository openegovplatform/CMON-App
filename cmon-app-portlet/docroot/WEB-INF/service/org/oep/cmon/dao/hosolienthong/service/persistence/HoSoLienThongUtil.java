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

package org.oep.cmon.dao.hosolienthong.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;

import java.util.List;

/**
 * The persistence utility for the ho so lien thong service. This utility wraps {@link HoSoLienThongPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThongPersistence
 * @see HoSoLienThongPersistenceImpl
 * @generated
 */
public class HoSoLienThongUtil {
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
	public static void clearCache(HoSoLienThong hoSoLienThong) {
		getPersistence().clearCache(hoSoLienThong);
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
	public static List<HoSoLienThong> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoSoLienThong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoSoLienThong> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static HoSoLienThong update(HoSoLienThong hoSoLienThong,
		boolean merge) throws SystemException {
		return getPersistence().update(hoSoLienThong, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static HoSoLienThong update(HoSoLienThong hoSoLienThong,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(hoSoLienThong, merge, serviceContext);
	}

	/**
	* Caches the ho so lien thong in the entity cache if it is enabled.
	*
	* @param hoSoLienThong the ho so lien thong
	*/
	public static void cacheResult(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong) {
		getPersistence().cacheResult(hoSoLienThong);
	}

	/**
	* Caches the ho so lien thongs in the entity cache if it is enabled.
	*
	* @param hoSoLienThongs the ho so lien thongs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> hoSoLienThongs) {
		getPersistence().cacheResult(hoSoLienThongs);
	}

	/**
	* Creates a new ho so lien thong with the primary key. Does not add the ho so lien thong to the database.
	*
	* @param id the primary key for the new ho so lien thong
	* @return the new ho so lien thong
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ho so lien thong with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong that was removed
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong updateImpl(
		org.oep.cmon.dao.hosolienthong.model.HoSoLienThong hoSoLienThong,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(hoSoLienThong, merge);
	}

	/**
	* Returns the ho so lien thong with the primary key or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ho so lien thong with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho so lien thong
	* @return the ho so lien thong, or <code>null</code> if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ho so lien thongs where hoSoId = &#63;.
	*
	* @param hoSoId the ho so ID
	* @return the matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHoSoId(hoSoId);
	}

	/**
	* Returns a range of all the ho so lien thongs where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHoSoId(hoSoId, start, end);
	}

	/**
	* Returns an ordered range of all the ho so lien thongs where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findByHoSoId(
		long hoSoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHoSoId(hoSoId, start, end, orderByComparator);
	}

	/**
	* Returns the first ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByHoSoId_First(
		long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence().findByHoSoId_First(hoSoId, orderByComparator);
	}

	/**
	* Returns the last ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByHoSoId_Last(
		long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence().findByHoSoId_Last(hoSoId, orderByComparator);
	}

	/**
	* Returns the ho so lien thongs before and after the current ho so lien thong in the ordered set where hoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ho so lien thong
	* @param hoSoId the ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a ho so lien thong with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong[] findByHoSoId_PrevAndNext(
		long id, long hoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence()
				   .findByHoSoId_PrevAndNext(id, hoSoId, orderByComparator);
	}

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or throws a {@link org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException} if it could not be found.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the matching ho so lien thong
	* @throws org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong findByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		return getPersistence().findByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* Returns the ho so lien thong where maSoBienNhanLucGui = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ho so lien thong, or <code>null</code> if a matching ho so lien thong could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosolienthong.model.HoSoLienThong fetchByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMaSoBienNhanLucGui(maSoBienNhanLucGui,
			retrieveFromCache);
	}

	/**
	* Returns all the ho so lien thongs.
	*
	* @return the ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @return the range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ho so lien thongs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho so lien thongs
	* @param end the upper bound of the range of ho so lien thongs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosolienthong.model.HoSoLienThong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ho so lien thongs where hoSoId = &#63; from the database.
	*
	* @param hoSoId the ho so ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHoSoId(hoSoId);
	}

	/**
	* Removes the ho so lien thong where maSoBienNhanLucGui = &#63; from the database.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosolienthong.NoSuchHoSoLienThongException {
		getPersistence().removeByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* Removes all the ho so lien thongs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ho so lien thongs where hoSoId = &#63;.
	*
	* @param hoSoId the ho so ID
	* @return the number of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHoSoId(long hoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHoSoId(hoSoId);
	}

	/**
	* Returns the number of ho so lien thongs where maSoBienNhanLucGui = &#63;.
	*
	* @param maSoBienNhanLucGui the ma so bien nhan luc gui
	* @return the number of matching ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMaSoBienNhanLucGui(
		java.lang.String maSoBienNhanLucGui)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMaSoBienNhanLucGui(maSoBienNhanLucGui);
	}

	/**
	* Returns the number of ho so lien thongs.
	*
	* @return the number of ho so lien thongs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HoSoLienThongPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HoSoLienThongPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosolienthong.service.ClpSerializer.getServletContextName(),
					HoSoLienThongPersistence.class.getName());

			ReferenceRegistry.registerReference(HoSoLienThongUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(HoSoLienThongPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(HoSoLienThongUtil.class,
			"_persistence");
	}

	private static HoSoLienThongPersistence _persistence;
}