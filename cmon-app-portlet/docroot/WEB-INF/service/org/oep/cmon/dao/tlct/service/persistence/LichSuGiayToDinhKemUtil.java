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

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;

import java.util.List;

/**
 * The persistence utility for the lich su giay to dinh kem service. This utility wraps {@link LichSuGiayToDinhKemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see LichSuGiayToDinhKemPersistence
 * @see LichSuGiayToDinhKemPersistenceImpl
 * @generated
 */
public class LichSuGiayToDinhKemUtil {
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
	public static void clearCache(LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		getPersistence().clearCache(lichSuGiayToDinhKem);
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
	public static List<LichSuGiayToDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LichSuGiayToDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LichSuGiayToDinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LichSuGiayToDinhKem update(
		LichSuGiayToDinhKem lichSuGiayToDinhKem, boolean merge)
		throws SystemException {
		return getPersistence().update(lichSuGiayToDinhKem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LichSuGiayToDinhKem update(
		LichSuGiayToDinhKem lichSuGiayToDinhKem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(lichSuGiayToDinhKem, merge, serviceContext);
	}

	/**
	* Caches the lich su giay to dinh kem in the entity cache if it is enabled.
	*
	* @param lichSuGiayToDinhKem the lich su giay to dinh kem
	*/
	public static void cacheResult(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem) {
		getPersistence().cacheResult(lichSuGiayToDinhKem);
	}

	/**
	* Caches the lich su giay to dinh kems in the entity cache if it is enabled.
	*
	* @param lichSuGiayToDinhKems the lich su giay to dinh kems
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> lichSuGiayToDinhKems) {
		getPersistence().cacheResult(lichSuGiayToDinhKems);
	}

	/**
	* Creates a new lich su giay to dinh kem with the primary key. Does not add the lich su giay to dinh kem to the database.
	*
	* @param id the primary key for the new lich su giay to dinh kem
	* @return the new lich su giay to dinh kem
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the lich su giay to dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the lich su giay to dinh kem
	* @return the lich su giay to dinh kem that was removed
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem updateImpl(
		org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem lichSuGiayToDinhKem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(lichSuGiayToDinhKem, merge);
	}

	/**
	* Returns the lich su giay to dinh kem with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException} if it could not be found.
	*
	* @param id the primary key of the lich su giay to dinh kem
	* @return the lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the lich su giay to dinh kem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the lich su giay to dinh kem
	* @return the lich su giay to dinh kem, or <code>null</code> if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @return the matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		java.lang.Long giayToDinhKemHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId);
	}

	/**
	* Returns a range of all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @return the range of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		java.lang.Long giayToDinhKemHoSoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId, start, end);
	}

	/**
	* Returns an ordered range of all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByGiayToDinhKemHoSoId(
		java.lang.Long giayToDinhKemHoSoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem findByByGiayToDinhKemHoSoId_First(
		java.lang.Long giayToDinhKemHoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByGiayToDinhKemHoSoId_First(giayToDinhKemHoSoId,
			orderByComparator);
	}

	/**
	* Returns the last lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem findByByGiayToDinhKemHoSoId_Last(
		java.lang.Long giayToDinhKemHoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByGiayToDinhKemHoSoId_Last(giayToDinhKemHoSoId,
			orderByComparator);
	}

	/**
	* Returns the lich su giay to dinh kems before and after the current lich su giay to dinh kem in the ordered set where giayToDinhKemHoSoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current lich su giay to dinh kem
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem[] findByByGiayToDinhKemHoSoId_PrevAndNext(
		long id, java.lang.Long giayToDinhKemHoSoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByGiayToDinhKemHoSoId_PrevAndNext(id,
			giayToDinhKemHoSoId, orderByComparator);
	}

	/**
	* Returns all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @return the matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
	}

	/**
	* Returns a range of all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @return the range of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId, start, end);
	}

	/**
	* Returns an ordered range of all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findByByNoiLuuTruTaiLieuId(
		long noiLuuTruTaiLieuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem findByByNoiLuuTruTaiLieuId_First(
		long noiLuuTruTaiLieuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByNoiLuuTruTaiLieuId_First(noiLuuTruTaiLieuId,
			orderByComparator);
	}

	/**
	* Returns the last lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a matching lich su giay to dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem findByByNoiLuuTruTaiLieuId_Last(
		long noiLuuTruTaiLieuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByNoiLuuTruTaiLieuId_Last(noiLuuTruTaiLieuId,
			orderByComparator);
	}

	/**
	* Returns the lich su giay to dinh kems before and after the current lich su giay to dinh kem in the ordered set where noiLuuTruTaiLieuId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current lich su giay to dinh kem
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lich su giay to dinh kem
	* @throws org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException if a lich su giay to dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem[] findByByNoiLuuTruTaiLieuId_PrevAndNext(
		long id, long noiLuuTruTaiLieuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchLichSuGiayToDinhKemException {
		return getPersistence()
				   .findByByNoiLuuTruTaiLieuId_PrevAndNext(id,
			noiLuuTruTaiLieuId, orderByComparator);
	}

	/**
	* Returns all the lich su giay to dinh kems.
	*
	* @return the lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lich su giay to dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @return the range of lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lich su giay to dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of lich su giay to dinh kems
	* @param end the upper bound of the range of lich su giay to dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the lich su giay to dinh kems where giayToDinhKemHoSoId = &#63; from the database.
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByGiayToDinhKemHoSoId(
		java.lang.Long giayToDinhKemHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId);
	}

	/**
	* Removes all the lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63; from the database.
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByByNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
	}

	/**
	* Removes all the lich su giay to dinh kems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lich su giay to dinh kems where giayToDinhKemHoSoId = &#63;.
	*
	* @param giayToDinhKemHoSoId the giay to dinh kem ho so ID
	* @return the number of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByGiayToDinhKemHoSoId(
		java.lang.Long giayToDinhKemHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByGiayToDinhKemHoSoId(giayToDinhKemHoSoId);
	}

	/**
	* Returns the number of lich su giay to dinh kems where noiLuuTruTaiLieuId = &#63;.
	*
	* @param noiLuuTruTaiLieuId the noi luu tru tai lieu ID
	* @return the number of matching lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int countByByNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByByNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
	}

	/**
	* Returns the number of lich su giay to dinh kems.
	*
	* @return the number of lich su giay to dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LichSuGiayToDinhKemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LichSuGiayToDinhKemPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.tlct.service.ClpSerializer.getServletContextName(),
					LichSuGiayToDinhKemPersistence.class.getName());

			ReferenceRegistry.registerReference(LichSuGiayToDinhKemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LichSuGiayToDinhKemPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LichSuGiayToDinhKemUtil.class,
			"_persistence");
	}

	private static LichSuGiayToDinhKemPersistence _persistence;
}