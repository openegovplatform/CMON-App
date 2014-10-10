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

package org.oep.cmon.dao.qlhc.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;

import java.util.List;

/**
 * The persistence utility for the co quan quan ly service. This utility wraps {@link CoQuanQuanLyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see CoQuanQuanLyPersistence
 * @see CoQuanQuanLyPersistenceImpl
 * @generated
 */
public class CoQuanQuanLyUtil {
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
	public static void clearCache(CoQuanQuanLy coQuanQuanLy) {
		getPersistence().clearCache(coQuanQuanLy);
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
	public static List<CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CoQuanQuanLy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CoQuanQuanLy update(CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws SystemException {
		return getPersistence().update(coQuanQuanLy, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CoQuanQuanLy update(CoQuanQuanLy coQuanQuanLy, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(coQuanQuanLy, merge, serviceContext);
	}

	/**
	* Caches the co quan quan ly in the entity cache if it is enabled.
	*
	* @param coQuanQuanLy the co quan quan ly
	*/
	public static void cacheResult(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy) {
		getPersistence().cacheResult(coQuanQuanLy);
	}

	/**
	* Caches the co quan quan lies in the entity cache if it is enabled.
	*
	* @param coQuanQuanLies the co quan quan lies
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> coQuanQuanLies) {
		getPersistence().cacheResult(coQuanQuanLies);
	}

	/**
	* Creates a new co quan quan ly with the primary key. Does not add the co quan quan ly to the database.
	*
	* @param id the primary key for the new co quan quan ly
	* @return the new co quan quan ly
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the co quan quan ly with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy updateImpl(
		org.oep.cmon.dao.qlhc.model.CoQuanQuanLy coQuanQuanLy, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(coQuanQuanLy, merge);
	}

	/**
	* Returns the co quan quan ly with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException} if it could not be found.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the co quan quan ly with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the co quan quan ly
	* @return the co quan quan ly, or <code>null</code> if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan lies where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCha(chaId, daXoa);
	}

	/**
	* Returns a range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCha(chaId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCha(
		java.lang.Long chaId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCha(chaId, daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCha_First(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByCha_First(chaId, daXoa, orderByComparator);
	}

	/**
	* Returns the last co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCha_Last(
		java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence().findByCha_Last(chaId, daXoa, orderByComparator);
	}

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where chaId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByCha_PrevAndNext(
		long id, java.lang.Long chaId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findByCha_PrevAndNext(id, chaId, daXoa, orderByComparator);
	}

	/**
	* Returns all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa);
	}

	/**
	* Returns a range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCapCoQuanQuanLy_First(
		java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findByCapCoQuanQuanLy_First(capCoQuanQuanlyId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findByCapCoQuanQuanLy_Last(
		java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findByCapCoQuanQuanLy_Last(capCoQuanQuanlyId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findByCapCoQuanQuanLy_PrevAndNext(
		long id, java.lang.Long capCoQuanQuanlyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findByCapCoQuanQuanLy_PrevAndNext(id, capCoQuanQuanlyId,
			daXoa, orderByComparator);
	}

	/**
	* Returns all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydonViHanhChinhId(donViHanhChinhId, daXoa);
	}

	/**
	* Returns a range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydonViHanhChinhId(donViHanhChinhId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydonViHanhChinhId(donViHanhChinhId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findBydonViHanhChinhId_First(
		java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findBydonViHanhChinhId_First(donViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a matching co quan quan ly could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy findBydonViHanhChinhId_Last(
		java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findBydonViHanhChinhId_Last(donViHanhChinhId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the co quan quan lies before and after the current co quan quan ly in the ordered set where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current co quan quan ly
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next co quan quan ly
	* @throws org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException if a co quan quan ly with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.CoQuanQuanLy[] findBydonViHanhChinhId_PrevAndNext(
		long id, java.lang.Long donViHanhChinhId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchCoQuanQuanLyException {
		return getPersistence()
				   .findBydonViHanhChinhId_PrevAndNext(id, donViHanhChinhId,
			daXoa, orderByComparator);
	}

	/**
	* Returns all the co quan quan lies.
	*
	* @return the co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @return the range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the co quan quan lies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of co quan quan lies
	* @param end the upper bound of the range of co quan quan lies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.CoQuanQuanLy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the co quan quan lies where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the co quan quan lies where chaId = &#63; and daXoa = &#63; from the database.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCha(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCha(chaId, daXoa);
	}

	/**
	* Removes all the co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63; from the database.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCapCoQuanQuanLy(
		java.lang.Long capCoQuanQuanlyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa);
	}

	/**
	* Removes all the co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63; from the database.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydonViHanhChinhId(
		java.lang.Long donViHanhChinhId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBydonViHanhChinhId(donViHanhChinhId, daXoa);
	}

	/**
	* Removes all the co quan quan lies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of co quan quan lies where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of co quan quan lies where chaId = &#63; and daXoa = &#63;.
	*
	* @param chaId the cha ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCha(java.lang.Long chaId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCha(chaId, daXoa);
	}

	/**
	* Returns the number of co quan quan lies where capCoQuanQuanlyId = &#63; and daXoa = &#63;.
	*
	* @param capCoQuanQuanlyId the cap co quan quanly ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCapCoQuanQuanLy(java.lang.Long capCoQuanQuanlyId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCapCoQuanQuanLy(capCoQuanQuanlyId, daXoa);
	}

	/**
	* Returns the number of co quan quan lies where donViHanhChinhId = &#63; and daXoa = &#63;.
	*
	* @param donViHanhChinhId the don vi hanh chinh ID
	* @param daXoa the da xoa
	* @return the number of matching co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydonViHanhChinhId(java.lang.Long donViHanhChinhId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydonViHanhChinhId(donViHanhChinhId, daXoa);
	}

	/**
	* Returns the number of co quan quan lies.
	*
	* @return the number of co quan quan lies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CoQuanQuanLyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CoQuanQuanLyPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					CoQuanQuanLyPersistence.class.getName());

			ReferenceRegistry.registerReference(CoQuanQuanLyUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CoQuanQuanLyPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CoQuanQuanLyUtil.class,
			"_persistence");
	}

	private static CoQuanQuanLyPersistence _persistence;
}