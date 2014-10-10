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

package org.oep.cmon.dao.ttthanhtoan.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.ttthanhtoan.model.TienTe;

import java.util.List;

/**
 * The persistence utility for the tien te service. This utility wraps {@link TienTePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thanhdd
 * @see TienTePersistence
 * @see TienTePersistenceImpl
 * @generated
 */
public class TienTeUtil {
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
	public static void clearCache(TienTe tienTe) {
		getPersistence().clearCache(tienTe);
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
	public static List<TienTe> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TienTe> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TienTe> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TienTe update(TienTe tienTe, boolean merge)
		throws SystemException {
		return getPersistence().update(tienTe, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TienTe update(TienTe tienTe, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tienTe, merge, serviceContext);
	}

	/**
	* Caches the tien te in the entity cache if it is enabled.
	*
	* @param tienTe the tien te
	*/
	public static void cacheResult(
		org.oep.cmon.dao.ttthanhtoan.model.TienTe tienTe) {
		getPersistence().cacheResult(tienTe);
	}

	/**
	* Caches the tien tes in the entity cache if it is enabled.
	*
	* @param tienTes the tien tes
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> tienTes) {
		getPersistence().cacheResult(tienTes);
	}

	/**
	* Creates a new tien te with the primary key. Does not add the tien te to the database.
	*
	* @param id the primary key for the new tien te
	* @return the new tien te
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tien te with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tien te
	* @return the tien te that was removed
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe updateImpl(
		org.oep.cmon.dao.ttthanhtoan.model.TienTe tienTe, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tienTe, merge);
	}

	/**
	* Returns the tien te with the primary key or throws a {@link org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException} if it could not be found.
	*
	* @param id the primary key of the tien te
	* @return the tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tien te with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tien te
	* @return the tien te, or <code>null</code> if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tien tes where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the tien tes where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the tien tes where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns all the tien tes where ma = &#63;.
	*
	* @param ma the ma
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns a range of all the tien tes where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end);
	}

	/**
	* Returns an ordered range of all the tien tes where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByMa(
		java.lang.String ma, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMa(ma, start, end, orderByComparator);
	}

	/**
	* Returns the first tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByMa_First(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByMa_First(ma, orderByComparator);
	}

	/**
	* Returns the last tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByMa_Last(
		java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByMa_Last(ma, orderByComparator);
	}

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where ma = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param ma the ma
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByMa_PrevAndNext(
		long id, java.lang.String ma,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByMa_PrevAndNext(id, ma, orderByComparator);
	}

	/**
	* Returns all the tien tes where ten = &#63;.
	*
	* @param ten the ten
	* @return the matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns a range of all the tien tes where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end);
	}

	/**
	* Returns an ordered range of all the tien tes where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findByTen(
		java.lang.String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTen(ten, start, end, orderByComparator);
	}

	/**
	* Returns the first tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTen_First(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByTen_First(ten, orderByComparator);
	}

	/**
	* Returns the last tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a matching tien te could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe findByTen_Last(
		java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByTen_Last(ten, orderByComparator);
	}

	/**
	* Returns the tien tes before and after the current tien te in the ordered set where ten = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tien te
	* @param ten the ten
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tien te
	* @throws org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException if a tien te with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.ttthanhtoan.model.TienTe[] findByTen_PrevAndNext(
		long id, java.lang.String ten,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.ttthanhtoan.NoSuchTienTeException {
		return getPersistence().findByTen_PrevAndNext(id, ten, orderByComparator);
	}

	/**
	* Returns all the tien tes.
	*
	* @return the tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tien tes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @return the range of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tien tes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tien tes
	* @param end the upper bound of the range of tien tes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.ttthanhtoan.model.TienTe> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tien tes where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes all the tien tes where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the tien tes where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes all the tien tes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tien tes where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of tien tes where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of tien tes where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of tien tes.
	*
	* @return the number of tien tes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TienTePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TienTePersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.ttthanhtoan.service.ClpSerializer.getServletContextName(),
					TienTePersistence.class.getName());

			ReferenceRegistry.registerReference(TienTeUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TienTePersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TienTeUtil.class, "_persistence");
	}

	private static TienTePersistence _persistence;
}