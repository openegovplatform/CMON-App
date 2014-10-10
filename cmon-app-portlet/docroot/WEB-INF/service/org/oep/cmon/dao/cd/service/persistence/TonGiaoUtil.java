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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.cd.model.TonGiao;

import java.util.List;

/**
 * The persistence utility for the ton giao service. This utility wraps {@link TonGiaoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TonGiaoPersistence
 * @see TonGiaoPersistenceImpl
 * @generated
 */
public class TonGiaoUtil {
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
	public static void clearCache(TonGiao tonGiao) {
		getPersistence().clearCache(tonGiao);
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
	public static List<TonGiao> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TonGiao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TonGiao> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TonGiao update(TonGiao tonGiao, boolean merge)
		throws SystemException {
		return getPersistence().update(tonGiao, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TonGiao update(TonGiao tonGiao, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tonGiao, merge, serviceContext);
	}

	/**
	* Caches the ton giao in the entity cache if it is enabled.
	*
	* @param tonGiao the ton giao
	*/
	public static void cacheResult(org.oep.cmon.dao.cd.model.TonGiao tonGiao) {
		getPersistence().cacheResult(tonGiao);
	}

	/**
	* Caches the ton giaos in the entity cache if it is enabled.
	*
	* @param tonGiaos the ton giaos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.TonGiao> tonGiaos) {
		getPersistence().cacheResult(tonGiaos);
	}

	/**
	* Creates a new ton giao with the primary key. Does not add the ton giao to the database.
	*
	* @param id the primary key for the new ton giao
	* @return the new ton giao
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the ton giao with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ton giao
	* @return the ton giao that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTonGiaoException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cd.model.TonGiao updateImpl(
		org.oep.cmon.dao.cd.model.TonGiao tonGiao, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tonGiao, merge);
	}

	/**
	* Returns the ton giao with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTonGiaoException} if it could not be found.
	*
	* @param id the primary key of the ton giao
	* @return the ton giao
	* @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTonGiaoException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the ton giao with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ton giao
	* @return the ton giao, or <code>null</code> if a ton giao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the ton giaos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the ton giaos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of ton giaos
	* @param end the upper bound of the range of ton giaos (not inclusive)
	* @return the range of matching ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the ton giaos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of ton giaos
	* @param end the upper bound of the range of ton giaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first ton giao in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ton giao
	* @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a matching ton giao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTonGiaoException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last ton giao in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ton giao
	* @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a matching ton giao could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTonGiaoException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the ton giaos before and after the current ton giao in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current ton giao
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ton giao
	* @throws org.oep.cmon.dao.cd.NoSuchTonGiaoException if a ton giao with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TonGiao[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTonGiaoException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the ton giaos.
	*
	* @return the ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ton giaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ton giaos
	* @param end the upper bound of the range of ton giaos (not inclusive)
	* @return the range of ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ton giaos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ton giaos
	* @param end the upper bound of the range of ton giaos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TonGiao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ton giaos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the ton giaos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ton giaos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of ton giaos.
	*
	* @return the number of ton giaos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TonGiaoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TonGiaoPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					TonGiaoPersistence.class.getName());

			ReferenceRegistry.registerReference(TonGiaoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TonGiaoPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TonGiaoUtil.class, "_persistence");
	}

	private static TonGiaoPersistence _persistence;
}