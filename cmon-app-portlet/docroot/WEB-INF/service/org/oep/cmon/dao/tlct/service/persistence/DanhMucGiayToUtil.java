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

package org.oep.cmon.dao.tlct.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;

import java.util.List;

/**
 * The persistence utility for the danh muc giay to service. This utility wraps {@link DanhMucGiayToPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see DanhMucGiayToPersistence
 * @see DanhMucGiayToPersistenceImpl
 * @generated
 */
public class DanhMucGiayToUtil {
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
	public static void clearCache(DanhMucGiayTo danhMucGiayTo) {
		getPersistence().clearCache(danhMucGiayTo);
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
	public static List<DanhMucGiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhMucGiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhMucGiayTo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhMucGiayTo update(DanhMucGiayTo danhMucGiayTo,
		boolean merge) throws SystemException {
		return getPersistence().update(danhMucGiayTo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhMucGiayTo update(DanhMucGiayTo danhMucGiayTo,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhMucGiayTo, merge, serviceContext);
	}

	/**
	* Caches the danh muc giay to in the entity cache if it is enabled.
	*
	* @param danhMucGiayTo the danh muc giay to
	*/
	public static void cacheResult(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo) {
		getPersistence().cacheResult(danhMucGiayTo);
	}

	/**
	* Caches the danh muc giay tos in the entity cache if it is enabled.
	*
	* @param danhMucGiayTos the danh muc giay tos
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> danhMucGiayTos) {
		getPersistence().cacheResult(danhMucGiayTos);
	}

	/**
	* Creates a new danh muc giay to with the primary key. Does not add the danh muc giay to to the database.
	*
	* @param id the primary key for the new danh muc giay to
	* @return the new danh muc giay to
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the danh muc giay to with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to that was removed
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo updateImpl(
		org.oep.cmon.dao.tlct.model.DanhMucGiayTo danhMucGiayTo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhMucGiayTo, merge);
	}

	/**
	* Returns the danh muc giay to with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the danh muc giay to with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the danh muc giay to
	* @return the danh muc giay to, or <code>null</code> if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().findByByMa(ma);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma);
	}

	/**
	* Returns the danh muc giay to where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh muc giay to, or <code>null</code> if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo fetchByByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma, retrieveFromCache);
	}

	/**
	* Returns all the danh muc giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the danh muc giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay tos where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a matching danh muc giay to could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the danh muc giay tos before and after the current danh muc giay to in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current danh muc giay to
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next danh muc giay to
	* @throws org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException if a danh muc giay to with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.DanhMucGiayTo[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the danh muc giay tos.
	*
	* @return the danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @return the range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the danh muc giay tos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh muc giay tos
	* @param end the upper bound of the range of danh muc giay tos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.DanhMucGiayTo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the danh muc giay to where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes the danh muc giay to where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchDanhMucGiayToException {
		getPersistence().removeByByMa(ma);
	}

	/**
	* Removes all the danh muc giay tos where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the danh muc giay tos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh muc giay tos where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of danh muc giay tos where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByMa(ma);
	}

	/**
	* Returns the number of danh muc giay tos where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of danh muc giay tos.
	*
	* @return the number of danh muc giay tos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhMucGiayToPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhMucGiayToPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.tlct.service.ClpSerializer.getServletContextName(),
					DanhMucGiayToPersistence.class.getName());

			ReferenceRegistry.registerReference(DanhMucGiayToUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhMucGiayToPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhMucGiayToUtil.class,
			"_persistence");
	}

	private static DanhMucGiayToPersistence _persistence;
}