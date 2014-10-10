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

package org.oep.cmon.dao.dvc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;

import java.util.List;

/**
 * The persistence utility for the t t h c2 co quan quan ly service. This utility wraps {@link TTHC2CoQuanQuanLyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see TTHC2CoQuanQuanLyPersistence
 * @see TTHC2CoQuanQuanLyPersistenceImpl
 * @generated
 */
public class TTHC2CoQuanQuanLyUtil {
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
	public static void clearCache(TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		getPersistence().clearCache(tthc2CoQuanQuanLy);
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
	public static List<TTHC2CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TTHC2CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TTHC2CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TTHC2CoQuanQuanLy update(
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy, boolean merge)
		throws SystemException {
		return getPersistence().update(tthc2CoQuanQuanLy, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TTHC2CoQuanQuanLy update(
		TTHC2CoQuanQuanLy tthc2CoQuanQuanLy, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tthc2CoQuanQuanLy, merge, serviceContext);
	}

	/**
	* Caches the t t h c2 co quan quan ly in the entity cache if it is enabled.
	*
	* @param tthc2CoQuanQuanLy the t t h c2 co quan quan ly
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy tthc2CoQuanQuanLy) {
		getPersistence().cacheResult(tthc2CoQuanQuanLy);
	}

	/**
	* Caches the t t h c2 co quan quan lies in the entity cache if it is enabled.
	*
	* @param tthc2CoQuanQuanLies the t t h c2 co quan quan lies
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> tthc2CoQuanQuanLies) {
		getPersistence().cacheResult(tthc2CoQuanQuanLies);
	}

	/**
	* Creates a new t t h c2 co quan quan ly with the primary key. Does not add the t t h c2 co quan quan ly to the database.
	*
	* @param id the primary key for the new t t h c2 co quan quan ly
	* @return the new t t h c2 co quan quan ly
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the t t h c2 co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy tthc2CoQuanQuanLy,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tthc2CoQuanQuanLy, merge);
	}

	/**
	* Returns the t t h c2 co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException} if it could not be found.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the t t h c2 co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the t t h c2 co quan quan ly
	* @return the t t h c2 co quan quan ly, or <code>null</code> if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByThuTucHanhChinhId(thuTucHanhChinhId, daXoa);
	}

	/**
	* Returns a range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByThuTucHanhChinhId(
		long thuTucHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByThuTucHanhChinhId(thuTucHanhChinhId, daXoa, start,
			end, orderByComparator);
	}

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByThuTucHanhChinhId_First(
		long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByThuTucHanhChinhId_First(thuTucHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByThuTucHanhChinhId_Last(
		long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByThuTucHanhChinhId_Last(thuTucHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByThuTucHanhChinhId_PrevAndNext(
		long id, long thuTucHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByThuTucHanhChinhId_PrevAndNext(id, thuTucHanhChinhId,
			daXoa, orderByComparator);
	}

	/**
	* Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId, start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanQuanLyId(
		long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyId(coQuanQuanLyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanQuanLyId_First(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanQuanLyId_First(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanQuanLyId_Last(
		long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanQuanLyId_Last(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByCoQuanQuanLyId_PrevAndNext(
		long id, long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanQuanLyId_PrevAndNext(id, coQuanQuanLyId,
			orderByComparator);
	}

	/**
	* Returns all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId);
	}

	/**
	* Returns a range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId,
			start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findByCoQuanAndThuTuc(
		long coQuanQuanLyId, long thuTucHanhChinhId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_First(
		long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanAndThuTuc_First(coQuanQuanLyId,
			thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the last t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a matching t t h c2 co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy findByCoQuanAndThuTuc_Last(
		long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanAndThuTuc_Last(coQuanQuanLyId,
			thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns the t t h c2 co quan quan lies before and after the current t t h c2 co quan quan ly in the ordered set where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current t t h c2 co quan quan ly
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next t t h c2 co quan quan ly
	* @throws org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException if a t t h c2 co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy[] findByCoQuanAndThuTuc_PrevAndNext(
		long id, long coQuanQuanLyId, long thuTucHanhChinhId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchTTHC2CoQuanQuanLyException {
		return getPersistence()
				   .findByCoQuanAndThuTuc_PrevAndNext(id, coQuanQuanLyId,
			thuTucHanhChinhId, orderByComparator);
	}

	/**
	* Returns all the t t h c2 co quan quan lies.
	*
	* @return the t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the t t h c2 co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @return the range of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the t t h c2 co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of t t h c2 co quan quan lies
	* @param end the upper bound of the range of t t h c2 co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the t t h c2 co quan quan lies where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByThuTucHanhChinhId(long thuTucHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByThuTucHanhChinhId(thuTucHanhChinhId, daXoa);
	}

	/**
	* Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Removes all the t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId);
	}

	/**
	* Removes all the t t h c2 co quan quan lies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of t t h c2 co quan quan lies where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of t t h c2 co quan quan lies where thuTucHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByThuTucHanhChinhId(long thuTucHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByThuTucHanhChinhId(thuTucHanhChinhId, daXoa);
	}

	/**
	* Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCoQuanQuanLyId(long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the number of t t h c2 co quan quan lies where coQuanQuanLyId = &#63; and thuTucHanhChinhId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID
	* @return the number of matching t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCoQuanAndThuTuc(long coQuanQuanLyId,
		long thuTucHanhChinhId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCoQuanAndThuTuc(coQuanQuanLyId, thuTucHanhChinhId);
	}

	/**
	* Returns the number of t t h c2 co quan quan lies.
	*
	* @return the number of t t h c2 co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TTHC2CoQuanQuanLyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TTHC2CoQuanQuanLyPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					TTHC2CoQuanQuanLyPersistence.class.getName());

			ReferenceRegistry.registerReference(TTHC2CoQuanQuanLyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TTHC2CoQuanQuanLyPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TTHC2CoQuanQuanLyUtil.class,
			"_persistence");
	}

	private static TTHC2CoQuanQuanLyPersistence _persistence;
}