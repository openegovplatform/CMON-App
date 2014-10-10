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

import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;

import java.util.List;

/**
 * The persistence utility for the tinh trang hon nhan service. This utility wraps {@link TinhTrangHonNhanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see TinhTrangHonNhanPersistence
 * @see TinhTrangHonNhanPersistenceImpl
 * @generated
 */
public class TinhTrangHonNhanUtil {
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
	public static void clearCache(TinhTrangHonNhan tinhTrangHonNhan) {
		getPersistence().clearCache(tinhTrangHonNhan);
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
	public static List<TinhTrangHonNhan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TinhTrangHonNhan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TinhTrangHonNhan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TinhTrangHonNhan update(TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge) throws SystemException {
		return getPersistence().update(tinhTrangHonNhan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TinhTrangHonNhan update(TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tinhTrangHonNhan, merge, serviceContext);
	}

	/**
	* Caches the tinh trang hon nhan in the entity cache if it is enabled.
	*
	* @param tinhTrangHonNhan the tinh trang hon nhan
	*/
	public static void cacheResult(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan) {
		getPersistence().cacheResult(tinhTrangHonNhan);
	}

	/**
	* Caches the tinh trang hon nhans in the entity cache if it is enabled.
	*
	* @param tinhTrangHonNhans the tinh trang hon nhans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> tinhTrangHonNhans) {
		getPersistence().cacheResult(tinhTrangHonNhans);
	}

	/**
	* Creates a new tinh trang hon nhan with the primary key. Does not add the tinh trang hon nhan to the database.
	*
	* @param id the primary key for the new tinh trang hon nhan
	* @return the new tinh trang hon nhan
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tinh trang hon nhan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan updateImpl(
		org.oep.cmon.dao.cd.model.TinhTrangHonNhan tinhTrangHonNhan,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tinhTrangHonNhan, merge);
	}

	/**
	* Returns the tinh trang hon nhan with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException} if it could not be found.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tinh trang hon nhan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tinh trang hon nhan
	* @return the tinh trang hon nhan, or <code>null</code> if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tinh trang hon nhans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the tinh trang hon nhans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the tinh trang hon nhans where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a matching tinh trang hon nhan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the tinh trang hon nhans before and after the current tinh trang hon nhan in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tinh trang hon nhan
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tinh trang hon nhan
	* @throws org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException if a tinh trang hon nhan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.cd.model.TinhTrangHonNhan[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchTinhTrangHonNhanException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the tinh trang hon nhans.
	*
	* @return the tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @return the range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tinh trang hon nhans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tinh trang hon nhans
	* @param end the upper bound of the range of tinh trang hon nhans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.cd.model.TinhTrangHonNhan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tinh trang hon nhans where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the tinh trang hon nhans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tinh trang hon nhans where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of tinh trang hon nhans.
	*
	* @return the number of tinh trang hon nhans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TinhTrangHonNhanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TinhTrangHonNhanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.cd.service.ClpSerializer.getServletContextName(),
					TinhTrangHonNhanPersistence.class.getName());

			ReferenceRegistry.registerReference(TinhTrangHonNhanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TinhTrangHonNhanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TinhTrangHonNhanUtil.class,
			"_persistence");
	}

	private static TinhTrangHonNhanPersistence _persistence;
}