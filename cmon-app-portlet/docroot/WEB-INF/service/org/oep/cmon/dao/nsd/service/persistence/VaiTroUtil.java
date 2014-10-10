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

import org.oep.cmon.dao.nsd.model.VaiTro;

import java.util.List;

/**
 * The persistence utility for the vai tro service. This utility wraps {@link VaiTroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see VaiTroPersistence
 * @see VaiTroPersistenceImpl
 * @generated
 */
public class VaiTroUtil {
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
	public static void clearCache(VaiTro vaiTro) {
		getPersistence().clearCache(vaiTro);
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
	public static List<VaiTro> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VaiTro> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VaiTro> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VaiTro update(VaiTro vaiTro, boolean merge)
		throws SystemException {
		return getPersistence().update(vaiTro, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VaiTro update(VaiTro vaiTro, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(vaiTro, merge, serviceContext);
	}

	/**
	* Caches the vai tro in the entity cache if it is enabled.
	*
	* @param vaiTro the vai tro
	*/
	public static void cacheResult(org.oep.cmon.dao.nsd.model.VaiTro vaiTro) {
		getPersistence().cacheResult(vaiTro);
	}

	/**
	* Caches the vai tros in the entity cache if it is enabled.
	*
	* @param vaiTros the vai tros
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> vaiTros) {
		getPersistence().cacheResult(vaiTros);
	}

	/**
	* Creates a new vai tro with the primary key. Does not add the vai tro to the database.
	*
	* @param id the primary key for the new vai tro
	* @return the new vai tro
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.nsd.model.VaiTro updateImpl(
		org.oep.cmon.dao.nsd.model.VaiTro vaiTro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(vaiTro, merge);
	}

	/**
	* Returns the vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the vai tro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the vai tro
	* @return the vai tro, or <code>null</code> if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the vai tros where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the vai tros where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the vai tros where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the vai tros where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns all the vai tros where moTa = &#63;.
	*
	* @param moTa the mo ta
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMoTa(moTa);
	}

	/**
	* Returns a range of all the vai tros where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMoTa(moTa, start, end);
	}

	/**
	* Returns an ordered range of all the vai tros where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByMoTa(
		java.lang.String moTa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMoTa(moTa, start, end, orderByComparator);
	}

	/**
	* Returns the first vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByMoTa_First(
		java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByMoTa_First(moTa, orderByComparator);
	}

	/**
	* Returns the last vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByMoTa_Last(
		java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByMoTa_Last(moTa, orderByComparator);
	}

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where moTa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param moTa the mo ta
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro[] findByMoTa_PrevAndNext(
		long id, java.lang.String moTa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence()
				   .findByMoTa_PrevAndNext(id, moTa, orderByComparator);
	}

	/**
	* Returns the vai tro where ma = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByByMa(ma);
	}

	/**
	* Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro fetchByByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma);
	}

	/**
	* Returns the vai tro where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro fetchByByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByMa(ma, retrieveFromCache);
	}

	/**
	* Returns the vai tro where ten = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchVaiTroException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByByTen(ten);
	}

	/**
	* Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro fetchByByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByTen(ten);
	}

	/**
	* Returns the vai tro where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching vai tro, or <code>null</code> if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro fetchByByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByByTen(ten, retrieveFromCache);
	}

	/**
	* Returns all the vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the vai tros where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a matching vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the vai tros before and after the current vai tro in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current vai tro
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchVaiTroException if a vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.VaiTro[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the vai tros.
	*
	* @return the vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @return the range of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of vai tros
	* @param end the upper bound of the range of vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.VaiTro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the vai tros where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the vai tros where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the vai tros where moTa = &#63; from the database.
	*
	* @param moTa the mo ta
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMoTa(java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMoTa(moTa);
	}

	/**
	* Removes the vai tro where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		getPersistence().removeByByMa(ma);
	}

	/**
	* Removes the vai tro where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchVaiTroException {
		getPersistence().removeByByTen(ten);
	}

	/**
	* Removes all the vai tros where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the vai tros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of vai tros where moTa = &#63;.
	*
	* @param moTa the mo ta
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMoTa(java.lang.String moTa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMoTa(moTa);
	}

	/**
	* Returns the number of vai tros where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByMa(ma);
	}

	/**
	* Returns the number of vai tros where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByTen(ten);
	}

	/**
	* Returns the number of vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of vai tros.
	*
	* @return the number of vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VaiTroPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VaiTroPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					VaiTroPersistence.class.getName());

			ReferenceRegistry.registerReference(VaiTroUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VaiTroPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VaiTroUtil.class, "_persistence");
	}

	private static VaiTroPersistence _persistence;
}