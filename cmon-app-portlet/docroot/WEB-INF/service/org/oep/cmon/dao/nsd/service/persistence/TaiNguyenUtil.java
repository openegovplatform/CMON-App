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

package org.oep.cmon.dao.nsd.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.nsd.model.TaiNguyen;

import java.util.List;

/**
 * The persistence utility for the tai nguyen service. This utility wraps {@link TaiNguyenPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiNguyenPersistence
 * @see TaiNguyenPersistenceImpl
 * @generated
 */
public class TaiNguyenUtil {
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
	public static void clearCache(TaiNguyen taiNguyen) {
		getPersistence().clearCache(taiNguyen);
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
	public static List<TaiNguyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaiNguyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaiNguyen> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TaiNguyen update(TaiNguyen taiNguyen, boolean merge)
		throws SystemException {
		return getPersistence().update(taiNguyen, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TaiNguyen update(TaiNguyen taiNguyen, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taiNguyen, merge, serviceContext);
	}

	/**
	* Caches the tai nguyen in the entity cache if it is enabled.
	*
	* @param taiNguyen the tai nguyen
	*/
	public static void cacheResult(
		org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen) {
		getPersistence().cacheResult(taiNguyen);
	}

	/**
	* Caches the tai nguyens in the entity cache if it is enabled.
	*
	* @param taiNguyens the tai nguyens
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> taiNguyens) {
		getPersistence().cacheResult(taiNguyens);
	}

	/**
	* Creates a new tai nguyen with the primary key. Does not add the tai nguyen to the database.
	*
	* @param id the primary key for the new tai nguyen
	* @return the new tai nguyen
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tai nguyen with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.nsd.model.TaiNguyen updateImpl(
		org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taiNguyen, merge);
	}

	/**
	* Returns the tai nguyen with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tai nguyen with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tai nguyen
	* @return the tai nguyen, or <code>null</code> if a tai nguyen with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchTaiNguyenException} if it could not be found.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the matching tai nguyen
	* @throws org.oep.cmon.dao.nsd.NoSuchTaiNguyenException if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen findByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException {
		return getPersistence()
				   .findByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa);
	}

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen fetchByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa);
	}

	/**
	* Returns the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tai nguyen, or <code>null</code> if a matching tai nguyen could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.TaiNguyen fetchByTen(
		java.lang.String ten, int loai, java.lang.String giaTri,
		java.lang.Long ungDungId, java.lang.Long heThongId, int daXoa,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa,
			retrieveFromCache);
	}

	/**
	* Returns all the tai nguyens.
	*
	* @return the tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tai nguyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai nguyens
	* @param end the upper bound of the range of tai nguyens (not inclusive)
	* @return the range of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tai nguyens.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai nguyens
	* @param end the upper bound of the range of tai nguyens (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.TaiNguyen> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the tai nguyen where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63; from the database.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten, int loai,
		java.lang.String giaTri, java.lang.Long ungDungId,
		java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchTaiNguyenException {
		getPersistence()
			.removeByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa);
	}

	/**
	* Removes all the tai nguyens from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tai nguyens where ten = &#63; and loai = &#63; and giaTri = &#63; and ungDungId = &#63; and heThongId = &#63; and daXoa = &#63;.
	*
	* @param ten the ten
	* @param loai the loai
	* @param giaTri the gia tri
	* @param ungDungId the ung dung ID
	* @param heThongId the he thong ID
	* @param daXoa the da xoa
	* @return the number of matching tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten, int loai,
		java.lang.String giaTri, java.lang.Long ungDungId,
		java.lang.Long heThongId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTen(ten, loai, giaTri, ungDungId, heThongId, daXoa);
	}

	/**
	* Returns the number of tai nguyens.
	*
	* @return the number of tai nguyens
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaiNguyenPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaiNguyenPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					TaiNguyenPersistence.class.getName());

			ReferenceRegistry.registerReference(TaiNguyenUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TaiNguyenPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TaiNguyenUtil.class, "_persistence");
	}

	private static TaiNguyenPersistence _persistence;
}