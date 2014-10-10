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

import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;

import java.util.List;

/**
 * The persistence utility for the chuc vu2 vai tro service. This utility wraps {@link ChucVu2VaiTroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ChucVu2VaiTroPersistence
 * @see ChucVu2VaiTroPersistenceImpl
 * @generated
 */
public class ChucVu2VaiTroUtil {
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
	public static void clearCache(ChucVu2VaiTro chucVu2VaiTro) {
		getPersistence().clearCache(chucVu2VaiTro);
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
	public static List<ChucVu2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChucVu2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChucVu2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ChucVu2VaiTro update(ChucVu2VaiTro chucVu2VaiTro,
		boolean merge) throws SystemException {
		return getPersistence().update(chucVu2VaiTro, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ChucVu2VaiTro update(ChucVu2VaiTro chucVu2VaiTro,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(chucVu2VaiTro, merge, serviceContext);
	}

	/**
	* Caches the chuc vu2 vai tro in the entity cache if it is enabled.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	*/
	public static void cacheResult(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro) {
		getPersistence().cacheResult(chucVu2VaiTro);
	}

	/**
	* Caches the chuc vu2 vai tros in the entity cache if it is enabled.
	*
	* @param chucVu2VaiTros the chuc vu2 vai tros
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> chucVu2VaiTros) {
		getPersistence().cacheResult(chucVu2VaiTros);
	}

	/**
	* Creates a new chuc vu2 vai tro with the primary key. Does not add the chuc vu2 vai tro to the database.
	*
	* @param id the primary key for the new chuc vu2 vai tro
	* @return the new chuc vu2 vai tro
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the chuc vu2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateImpl(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(chucVu2VaiTro, merge);
	}

	/**
	* Returns the chuc vu2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException} if it could not be found.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the chuc vu2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro, or <code>null</code> if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or throws a {@link org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException} if it could not be found.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @return the matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId);
	}

	/**
	* Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @return the matching chuc vu2 vai tro, or <code>null</code> if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId);
	}

	/**
	* Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching chuc vu2 vai tro, or <code>null</code> if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId,
			retrieveFromCache);
	}

	/**
	* Returns all the chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVaiTroId(vaiTroId);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVaiTroId(vaiTroId, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVaiTroId(vaiTroId, start, end, orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroId_First(
		java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByVaiTroId_First(vaiTroId, orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroId_Last(
		java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByVaiTroId_Last(vaiTroId, orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where vaiTroId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param vaiTroId the vai tro ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByVaiTroId_PrevAndNext(
		long id, java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByVaiTroId_PrevAndNext(id, vaiTroId, orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCoQuanQuanLyId(coQuanQuanLyId, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyId(coQuanQuanLyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyId_First(
		java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyId_First(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyId_Last(
		java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyId_Last(coQuanQuanLyId, orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByCoQuanQuanLyId_PrevAndNext(
		long id, java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyId_PrevAndNext(id, coQuanQuanLyId,
			orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChucVuId(chucVuId);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChucVuId(chucVuId, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuId(chucVuId, start, end, orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuId_First(
		java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByChucVuId_First(chucVuId, orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuId_Last(
		java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByChucVuId_Last(chucVuId, orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param chucVuId the chuc vu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuId_PrevAndNext(
		long id, java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuId_PrevAndNext(id, chucVuId, orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVaiTroIdAndDaXoa(vaiTroId, daXoa);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVaiTroIdAndDaXoa(vaiTroId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVaiTroIdAndDaXoa(vaiTroId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroIdAndDaXoa_First(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByVaiTroIdAndDaXoa_First(vaiTroId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroIdAndDaXoa_Last(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByVaiTroIdAndDaXoa_Last(vaiTroId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByVaiTroIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByVaiTroIdAndDaXoa_PrevAndNext(id, vaiTroId, daXoa,
			orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa, start,
			end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa, start,
			end, orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_First(
		java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa_First(coQuanQuanLyId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_Last(
		java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa_Last(coQuanQuanLyId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByCoQuanQuanLyIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByCoQuanQuanLyIdAndDaXoa_PrevAndNext(id,
			coQuanQuanLyId, daXoa, orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByChucVuIdAndDaXoa(chucVuId, daXoa);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuIdAndDaXoa(chucVuId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuIdAndDaXoa(chucVuId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndDaXoa_First(
		java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndDaXoa_First(chucVuId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndDaXoa_Last(
		java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndDaXoa_Last(chucVuId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndDaXoa_PrevAndNext(id, chucVuId, daXoa,
			orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId,
			daXoa);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId,
			daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId,
			daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_First(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId_First(chucVuId,
			coQuanQuanLyId, daXoa, orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_Last(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId_Last(chucVuId,
			coQuanQuanLyId, daXoa, orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuIdAndCoQuanQuanLyId_PrevAndNext(
		long id, java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId,
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByChucVuIdAndCoQuanQuanLyId_PrevAndNext(id, chucVuId,
			coQuanQuanLyId, daXoa, orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa);
	}

	/**
	* Returns a range of all the chuc vu2 vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDaXoa(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByDaXoa_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByDaXoa_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByDaXoa_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence().findByDaXoa_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the chuc vu2 vai tros before and after the current chuc vu2 vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current chuc vu2 vai tro
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByDaXoa_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		return getPersistence()
				   .findByDaXoa_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the chuc vu2 vai tros.
	*
	* @return the chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the chuc vu2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @return the range of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the chuc vu2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of chuc vu2 vai tros
	* @param end the upper bound of the range of chuc vu2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChucVu2VaiTro(java.lang.Long vaiTroId,
		java.lang.Long coQuanQuanLyId, java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException {
		getPersistence()
			.removeByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId);
	}

	/**
	* Removes all the chuc vu2 vai tros where vaiTroId = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVaiTroId(java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVaiTroId(vaiTroId);
	}

	/**
	* Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCoQuanQuanLyId(java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChucVuId(java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChucVuId(chucVuId);
	}

	/**
	* Removes all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVaiTroIdAndDaXoa(java.lang.Long vaiTroId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVaiTroIdAndDaXoa(vaiTroId, daXoa);
	}

	/**
	* Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa);
	}

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChucVuIdAndDaXoa(java.lang.Long chucVuId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByChucVuIdAndDaXoa(chucVuId, daXoa);
	}

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId, daXoa);
	}

	/**
	* Removes all the chuc vu2 vai tros where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDaXoa(daXoa);
	}

	/**
	* Removes all the chuc vu2 vai tros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChucVu2VaiTro(java.lang.Long vaiTroId,
		java.lang.Long coQuanQuanLyId, java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByChucVu2VaiTro(vaiTroId, coQuanQuanLyId, chucVuId);
	}

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVaiTroId(java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVaiTroId(vaiTroId);
	}

	/**
	* Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCoQuanQuanLyId(java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCoQuanQuanLyId(coQuanQuanLyId);
	}

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChucVuId(java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChucVuId(chucVuId);
	}

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVaiTroIdAndDaXoa(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVaiTroIdAndDaXoa(vaiTroId, daXoa);
	}

	/**
	* Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCoQuanQuanLyIdAndDaXoa(coQuanQuanLyId, daXoa);
	}

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChucVuIdAndDaXoa(java.lang.Long chucVuId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByChucVuIdAndDaXoa(chucVuId, daXoa);
	}

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByChucVuIdAndCoQuanQuanLyId(chucVuId, coQuanQuanLyId,
			daXoa);
	}

	/**
	* Returns the number of chuc vu2 vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDaXoa(daXoa);
	}

	/**
	* Returns the number of chuc vu2 vai tros.
	*
	* @return the number of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ChucVu2VaiTroPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ChucVu2VaiTroPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.qlhc.service.ClpSerializer.getServletContextName(),
					ChucVu2VaiTroPersistence.class.getName());

			ReferenceRegistry.registerReference(ChucVu2VaiTroUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ChucVu2VaiTroPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ChucVu2VaiTroUtil.class,
			"_persistence");
	}

	private static ChucVu2VaiTroPersistence _persistence;
}