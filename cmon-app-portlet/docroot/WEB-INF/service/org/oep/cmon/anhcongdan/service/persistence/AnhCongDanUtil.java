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

package org.oep.cmon.anhcongdan.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.anhcongdan.model.AnhCongDan;

import java.util.List;

/**
 * The persistence utility for the anh cong dan service. This utility wraps {@link AnhCongDanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see AnhCongDanPersistence
 * @see AnhCongDanPersistenceImpl
 * @generated
 */
public class AnhCongDanUtil {
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
	public static void clearCache(AnhCongDan anhCongDan) {
		getPersistence().clearCache(anhCongDan);
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
	public static List<AnhCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnhCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnhCongDan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AnhCongDan update(AnhCongDan anhCongDan, boolean merge)
		throws SystemException {
		return getPersistence().update(anhCongDan, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AnhCongDan update(AnhCongDan anhCongDan, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(anhCongDan, merge, serviceContext);
	}

	/**
	* Caches the anh cong dan in the entity cache if it is enabled.
	*
	* @param anhCongDan the anh cong dan
	*/
	public static void cacheResult(
		org.oep.cmon.anhcongdan.model.AnhCongDan anhCongDan) {
		getPersistence().cacheResult(anhCongDan);
	}

	/**
	* Caches the anh cong dans in the entity cache if it is enabled.
	*
	* @param anhCongDans the anh cong dans
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> anhCongDans) {
		getPersistence().cacheResult(anhCongDans);
	}

	/**
	* Creates a new anh cong dan with the primary key. Does not add the anh cong dan to the database.
	*
	* @param id the primary key for the new anh cong dan
	* @return the new anh cong dan
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the anh cong dan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the anh cong dan
	* @return the anh cong dan that was removed
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.anhcongdan.model.AnhCongDan updateImpl(
		org.oep.cmon.anhcongdan.model.AnhCongDan anhCongDan, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(anhCongDan, merge);
	}

	/**
	* Returns the anh cong dan with the primary key or throws a {@link org.oep.cmon.anhcongdan.NoSuchAnhCongDanException} if it could not be found.
	*
	* @param id the primary key of the anh cong dan
	* @return the anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the anh cong dan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the anh cong dan
	* @return the anh cong dan, or <code>null</code> if a anh cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the anh cong dans where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the anh cong dans where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @return the range of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the anh cong dans where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first anh cong dan in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last anh cong dan in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the anh cong dans before and after the current anh cong dan in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current anh cong dan
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the anh cong dans where email = &#63;.
	*
	* @param email the email
	* @return the matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email);
	}

	/**
	* Returns a range of all the anh cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @return the range of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByEmail(
		java.lang.String email, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end);
	}

	/**
	* Returns an ordered range of all the anh cong dans where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findByEmail(
		java.lang.String email, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmail(email, start, end, orderByComparator);
	}

	/**
	* Returns the first anh cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan findByEmail_First(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByEmail_First(email, orderByComparator);
	}

	/**
	* Returns the last anh cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a matching anh cong dan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan findByEmail_Last(
		java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence().findByEmail_Last(email, orderByComparator);
	}

	/**
	* Returns the anh cong dans before and after the current anh cong dan in the ordered set where email = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current anh cong dan
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next anh cong dan
	* @throws org.oep.cmon.anhcongdan.NoSuchAnhCongDanException if a anh cong dan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.anhcongdan.model.AnhCongDan[] findByEmail_PrevAndNext(
		long id, java.lang.String email,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.anhcongdan.NoSuchAnhCongDanException {
		return getPersistence()
				   .findByEmail_PrevAndNext(id, email, orderByComparator);
	}

	/**
	* Returns all the anh cong dans.
	*
	* @return the anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the anh cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @return the range of anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the anh cong dans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of anh cong dans
	* @param end the upper bound of the range of anh cong dans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.anhcongdan.model.AnhCongDan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the anh cong dans where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the anh cong dans where email = &#63; from the database.
	*
	* @param email the email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmail(email);
	}

	/**
	* Removes all the anh cong dans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of anh cong dans where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of anh cong dans where email = &#63;.
	*
	* @param email the email
	* @return the number of matching anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmail(email);
	}

	/**
	* Returns the number of anh cong dans.
	*
	* @return the number of anh cong dans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AnhCongDanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AnhCongDanPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.anhcongdan.service.ClpSerializer.getServletContextName(),
					AnhCongDanPersistence.class.getName());

			ReferenceRegistry.registerReference(AnhCongDanUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(AnhCongDanPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(AnhCongDanUtil.class, "_persistence");
	}

	private static AnhCongDanPersistence _persistence;
}