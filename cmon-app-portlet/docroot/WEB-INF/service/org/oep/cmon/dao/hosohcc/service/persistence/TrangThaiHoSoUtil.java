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

package org.oep.cmon.dao.hosohcc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;

import java.util.List;

/**
 * The persistence utility for the trang thai ho so service. This utility wraps {@link TrangThaiHoSoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see TrangThaiHoSoPersistence
 * @see TrangThaiHoSoPersistenceImpl
 * @generated
 */
public class TrangThaiHoSoUtil {
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
	public static void clearCache(TrangThaiHoSo trangThaiHoSo) {
		getPersistence().clearCache(trangThaiHoSo);
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
	public static List<TrangThaiHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrangThaiHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrangThaiHoSo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TrangThaiHoSo update(TrangThaiHoSo trangThaiHoSo,
		boolean merge) throws SystemException {
		return getPersistence().update(trangThaiHoSo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TrangThaiHoSo update(TrangThaiHoSo trangThaiHoSo,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(trangThaiHoSo, merge, serviceContext);
	}

	/**
	* Caches the trang thai ho so in the entity cache if it is enabled.
	*
	* @param trangThaiHoSo the trang thai ho so
	*/
	public static void cacheResult(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo) {
		getPersistence().cacheResult(trangThaiHoSo);
	}

	/**
	* Caches the trang thai ho sos in the entity cache if it is enabled.
	*
	* @param trangThaiHoSos the trang thai ho sos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> trangThaiHoSos) {
		getPersistence().cacheResult(trangThaiHoSos);
	}

	/**
	* Creates a new trang thai ho so with the primary key. Does not add the trang thai ho so to the database.
	*
	* @param id the primary key for the new trang thai ho so
	* @return the new trang thai ho so
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the trang thai ho so with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo updateImpl(
		org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo trangThaiHoSo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trangThaiHoSo, merge);
	}

	/**
	* Returns the trang thai ho so with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the trang thai ho so with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the trang thai ho so
	* @return the trang thai ho so, or <code>null</code> if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the trang thai ho so where id = &#63; or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException} if it could not be found.
	*
	* @param id the ID
	* @return the matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence().findById(id);
	}

	/**
	* Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchById(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id);
	}

	/**
	* Returns the trang thai ho so where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching trang thai ho so, or <code>null</code> if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo fetchById(
		long id, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchById(id, retrieveFromCache);
	}

	/**
	* Returns all the trang thai ho sos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiHoSo(daXoa);
	}

	/**
	* Returns a range of all the trang thai ho sos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @return the range of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThaiHoSo(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the trang thai ho sos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findByTrangThaiHoSo(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThaiHoSo(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByTrangThaiHoSo_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence()
				   .findByTrangThaiHoSo_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a matching trang thai ho so could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo findByTrangThaiHoSo_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence()
				   .findByTrangThaiHoSo_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the trang thai ho sos before and after the current trang thai ho so in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current trang thai ho so
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai ho so
	* @throws org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException if a trang thai ho so with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo[] findByTrangThaiHoSo_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		return getPersistence()
				   .findByTrangThaiHoSo_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the trang thai ho sos.
	*
	* @return the trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the trang thai ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @return the range of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the trang thai ho sos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai ho sos
	* @param end the upper bound of the range of trang thai ho sos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the trang thai ho so where id = &#63; from the database.
	*
	* @param id the ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchTrangThaiHoSoException {
		getPersistence().removeById(id);
	}

	/**
	* Removes all the trang thai ho sos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThaiHoSo(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThaiHoSo(daXoa);
	}

	/**
	* Removes all the trang thai ho sos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trang thai ho sos where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static int countById(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countById(id);
	}

	/**
	* Returns the number of trang thai ho sos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThaiHoSo(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThaiHoSo(daXoa);
	}

	/**
	* Returns the number of trang thai ho sos.
	*
	* @return the number of trang thai ho sos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrangThaiHoSoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrangThaiHoSoPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.hosohcc.service.ClpSerializer.getServletContextName(),
					TrangThaiHoSoPersistence.class.getName());

			ReferenceRegistry.registerReference(TrangThaiHoSoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TrangThaiHoSoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TrangThaiHoSoUtil.class,
			"_persistence");
	}

	private static TrangThaiHoSoPersistence _persistence;
}