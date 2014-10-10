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

package org.oep.cmon.dao.thamso.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.thamso.model.AnhXa;

import java.util.List;

/**
 * The persistence utility for the anh xa service. This utility wraps {@link AnhXaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see AnhXaPersistence
 * @see AnhXaPersistenceImpl
 * @generated
 */
public class AnhXaUtil {
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
	public static void clearCache(AnhXa anhXa) {
		getPersistence().clearCache(anhXa);
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
	public static List<AnhXa> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnhXa> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnhXa> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AnhXa update(AnhXa anhXa, boolean merge)
		throws SystemException {
		return getPersistence().update(anhXa, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AnhXa update(AnhXa anhXa, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(anhXa, merge, serviceContext);
	}

	/**
	* Caches the anh xa in the entity cache if it is enabled.
	*
	* @param anhXa the anh xa
	*/
	public static void cacheResult(org.oep.cmon.dao.thamso.model.AnhXa anhXa) {
		getPersistence().cacheResult(anhXa);
	}

	/**
	* Caches the anh xas in the entity cache if it is enabled.
	*
	* @param anhXas the anh xas
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> anhXas) {
		getPersistence().cacheResult(anhXas);
	}

	/**
	* Creates a new anh xa with the primary key. Does not add the anh xa to the database.
	*
	* @param Id the primary key for the new anh xa
	* @return the new anh xa
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa create(long Id) {
		return getPersistence().create(Id);
	}

	/**
	* Removes the anh xa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa that was removed
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa remove(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().remove(Id);
	}

	public static org.oep.cmon.dao.thamso.model.AnhXa updateImpl(
		org.oep.cmon.dao.thamso.model.AnhXa anhXa, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(anhXa, merge);
	}

	/**
	* Returns the anh xa with the primary key or throws a {@link org.oep.cmon.dao.thamso.NoSuchAnhXaException} if it could not be found.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().findByPrimaryKey(Id);
	}

	/**
	* Returns the anh xa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param Id the primary key of the anh xa
	* @return the anh xa, or <code>null</code> if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa fetchByPrimaryKey(long Id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(Id);
	}

	/**
	* Returns all the anh xas where UngDungId = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUngDung(UngDungId);
	}

	/**
	* Returns a range of all the anh xas where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUngDung(UngDungId, start, end);
	}

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUngDung(
		long UngDungId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUngDung(UngDungId, start, end, orderByComparator);
	}

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUngDung_First(
		long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().findByUngDung_First(UngDungId, orderByComparator);
	}

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUngDung_Last(
		long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().findByUngDung_Last(UngDungId, orderByComparator);
	}

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa[] findByUngDung_PrevAndNext(
		long Id, long UngDungId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUngDung_PrevAndNext(Id, UngDungId, orderByComparator);
	}

	/**
	* Returns all the anh xas where tenBang = &#63;.
	*
	* @param tenBang the ten bang
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytenBang(tenBang);
	}

	/**
	* Returns a range of all the anh xas where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytenBang(tenBang, start, end);
	}

	/**
	* Returns an ordered range of all the anh xas where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findBytenBang(
		java.lang.String tenBang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytenBang(tenBang, start, end, orderByComparator);
	}

	/**
	* Returns the first anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findBytenBang_First(
		java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().findBytenBang_First(tenBang, orderByComparator);
	}

	/**
	* Returns the last anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findBytenBang_Last(
		java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence().findBytenBang_Last(tenBang, orderByComparator);
	}

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa[] findBytenBang_PrevAndNext(
		long Id, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findBytenBang_PrevAndNext(Id, tenBang, orderByComparator);
	}

	/**
	* Returns all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUD_TB(UngDungId, tenBang);
	}

	/**
	* Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUD_TB(UngDungId, tenBang, start, end);
	}

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB(
		long UngDungId, java.lang.String tenBang, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUD_TB(UngDungId, tenBang, start, end,
			orderByComparator);
	}

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_First(
		long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_First(UngDungId, tenBang, orderByComparator);
	}

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_Last(
		long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_Last(UngDungId, tenBang, orderByComparator);
	}

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa[] findByUD_TB_PrevAndNext(
		long Id, long UngDungId, java.lang.String tenBang,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_PrevAndNext(Id, UngDungId, tenBang,
			orderByComparator);
	}

	/**
	* Returns all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @return the matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUD_TB_MaDNG(UngDungId, tenBang, maDNG);
	}

	/**
	* Returns a range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUD_TB_MaDNG(UngDungId, tenBang, maDNG, start, end);
	}

	/**
	* Returns an ordered range of all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findByUD_TB_MaDNG(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUD_TB_MaDNG(UngDungId, tenBang, maDNG, start, end,
			orderByComparator);
	}

	/**
	* Returns the first anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_MaDNG_First(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_MaDNG_First(UngDungId, tenBang, maDNG,
			orderByComparator);
	}

	/**
	* Returns the last anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a matching anh xa could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa findByUD_TB_MaDNG_Last(
		long UngDungId, java.lang.String tenBang, java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_MaDNG_Last(UngDungId, tenBang, maDNG,
			orderByComparator);
	}

	/**
	* Returns the anh xas before and after the current anh xa in the ordered set where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param Id the primary key of the current anh xa
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh xa
	* @throws org.oep.cmon.dao.thamso.NoSuchAnhXaException if a anh xa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.thamso.model.AnhXa[] findByUD_TB_MaDNG_PrevAndNext(
		long Id, long UngDungId, java.lang.String tenBang,
		java.lang.String maDNG,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.thamso.NoSuchAnhXaException {
		return getPersistence()
				   .findByUD_TB_MaDNG_PrevAndNext(Id, UngDungId, tenBang,
			maDNG, orderByComparator);
	}

	/**
	* Returns all the anh xas.
	*
	* @return the anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @return the range of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the anh xas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh xas
	* @param end the upper bound of the range of anh xas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.thamso.model.AnhXa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the anh xas where UngDungId = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUngDung(long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUngDung(UngDungId);
	}

	/**
	* Removes all the anh xas where tenBang = &#63; from the database.
	*
	* @param tenBang the ten bang
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytenBang(java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytenBang(tenBang);
	}

	/**
	* Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUD_TB(long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUD_TB(UngDungId, tenBang);
	}

	/**
	* Removes all the anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63; from the database.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUD_TB_MaDNG(long UngDungId,
		java.lang.String tenBang, java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUD_TB_MaDNG(UngDungId, tenBang, maDNG);
	}

	/**
	* Removes all the anh xas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of anh xas where UngDungId = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUngDung(long UngDungId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUngDung(UngDungId);
	}

	/**
	* Returns the number of anh xas where tenBang = &#63;.
	*
	* @param tenBang the ten bang
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytenBang(java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytenBang(tenBang);
	}

	/**
	* Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUD_TB(long UngDungId, java.lang.String tenBang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUD_TB(UngDungId, tenBang);
	}

	/**
	* Returns the number of anh xas where UngDungId = &#63; and tenBang = &#63; and maDNG = &#63;.
	*
	* @param UngDungId the ung dung ID
	* @param tenBang the ten bang
	* @param maDNG the ma d n g
	* @return the number of matching anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUD_TB_MaDNG(long UngDungId,
		java.lang.String tenBang, java.lang.String maDNG)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUD_TB_MaDNG(UngDungId, tenBang, maDNG);
	}

	/**
	* Returns the number of anh xas.
	*
	* @return the number of anh xas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AnhXaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnhXaPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.thamso.service.ClpSerializer.getServletContextName(),
					AnhXaPersistence.class.getName());

			ReferenceRegistry.registerReference(AnhXaUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AnhXaPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AnhXaUtil.class, "_persistence");
	}

	private static AnhXaPersistence _persistence;
}