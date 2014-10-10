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

import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;

import java.util.List;

/**
 * The persistence utility for the tai lieu chung thuc service. This utility wraps {@link TaiLieuChungThucPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see TaiLieuChungThucPersistence
 * @see TaiLieuChungThucPersistenceImpl
 * @generated
 */
public class TaiLieuChungThucUtil {
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
	public static void clearCache(TaiLieuChungThuc taiLieuChungThuc) {
		getPersistence().clearCache(taiLieuChungThuc);
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
	public static List<TaiLieuChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaiLieuChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaiLieuChungThuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TaiLieuChungThuc update(TaiLieuChungThuc taiLieuChungThuc,
		boolean merge) throws SystemException {
		return getPersistence().update(taiLieuChungThuc, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TaiLieuChungThuc update(TaiLieuChungThuc taiLieuChungThuc,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taiLieuChungThuc, merge, serviceContext);
	}

	/**
	* Caches the tai lieu chung thuc in the entity cache if it is enabled.
	*
	* @param taiLieuChungThuc the tai lieu chung thuc
	*/
	public static void cacheResult(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc) {
		getPersistence().cacheResult(taiLieuChungThuc);
	}

	/**
	* Caches the tai lieu chung thucs in the entity cache if it is enabled.
	*
	* @param taiLieuChungThucs the tai lieu chung thucs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> taiLieuChungThucs) {
		getPersistence().cacheResult(taiLieuChungThucs);
	}

	/**
	* Creates a new tai lieu chung thuc with the primary key. Does not add the tai lieu chung thuc to the database.
	*
	* @param id the primary key for the new tai lieu chung thuc
	* @return the new tai lieu chung thuc
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the tai lieu chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tai lieu chung thuc
	* @return the tai lieu chung thuc that was removed
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc updateImpl(
		org.oep.cmon.dao.tlct.model.TaiLieuChungThuc taiLieuChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taiLieuChungThuc, merge);
	}

	/**
	* Returns the tai lieu chung thuc with the primary key or throws a {@link org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException} if it could not be found.
	*
	* @param id the primary key of the tai lieu chung thuc
	* @return the tai lieu chung thuc
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the tai lieu chung thuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tai lieu chung thuc
	* @return the tai lieu chung thuc, or <code>null</code> if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @return the matching tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		java.lang.Long hoSoTTHCCId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);
	}

	/**
	* Returns a range of all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @param start the lower bound of the range of tai lieu chung thucs
	* @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	* @return the range of matching tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		java.lang.Long hoSoTTHCCId, int loai, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai, start, end);
	}

	/**
	* Returns an ordered range of all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @param start the lower bound of the range of tai lieu chung thucs
	* @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findByHosotthcCongIdAndLoai(
		java.lang.Long hoSoTTHCCId, int loai, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByHosotthcCongIdAndLoai(hoSoTTHCCId, loai, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tai lieu chung thuc
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHosotthcCongIdAndLoai_First(
		java.lang.Long hoSoTTHCCId, int loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence()
				   .findByHosotthcCongIdAndLoai_First(hoSoTTHCCId, loai,
			orderByComparator);
	}

	/**
	* Returns the last tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tai lieu chung thuc
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findByHosotthcCongIdAndLoai_Last(
		java.lang.Long hoSoTTHCCId, int loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence()
				   .findByHosotthcCongIdAndLoai_Last(hoSoTTHCCId, loai,
			orderByComparator);
	}

	/**
	* Returns the tai lieu chung thucs before and after the current tai lieu chung thuc in the ordered set where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current tai lieu chung thuc
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tai lieu chung thuc
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a tai lieu chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc[] findByHosotthcCongIdAndLoai_PrevAndNext(
		long id, java.lang.Long hoSoTTHCCId, int loai,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence()
				   .findByHosotthcCongIdAndLoai_PrevAndNext(id, hoSoTTHCCId,
			loai, orderByComparator);
	}

	/**
	* Returns the tai lieu chung thuc where noiLuuTruId = &#63; or throws a {@link org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException} if it could not be found.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the matching tai lieu chung thuc
	* @throws org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException if a matching tai lieu chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc findBynoiLuuTruId(
		long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		return getPersistence().findBynoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the tai lieu chung thuc where noiLuuTruId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the matching tai lieu chung thuc, or <code>null</code> if a matching tai lieu chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc fetchBynoiLuuTruId(
		long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBynoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the tai lieu chung thuc where noiLuuTruId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching tai lieu chung thuc, or <code>null</code> if a matching tai lieu chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.tlct.model.TaiLieuChungThuc fetchBynoiLuuTruId(
		long noiLuuTruId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBynoiLuuTruId(noiLuuTruId, retrieveFromCache);
	}

	/**
	* Returns all the tai lieu chung thucs.
	*
	* @return the tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tai lieu chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai lieu chung thucs
	* @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	* @return the range of tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tai lieu chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tai lieu chung thucs
	* @param end the upper bound of the range of tai lieu chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.tlct.model.TaiLieuChungThuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63; from the database.
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByHosotthcCongIdAndLoai(
		java.lang.Long hoSoTTHCCId, int loai)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);
	}

	/**
	* Removes the tai lieu chung thuc where noiLuuTruId = &#63; from the database.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBynoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.tlct.NoSuchTaiLieuChungThucException {
		getPersistence().removeBynoiLuuTruId(noiLuuTruId);
	}

	/**
	* Removes all the tai lieu chung thucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tai lieu chung thucs where hoSoTTHCCId = &#63; and loai = &#63;.
	*
	* @param hoSoTTHCCId the ho so t t h c c ID
	* @param loai the loai
	* @return the number of matching tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByHosotthcCongIdAndLoai(java.lang.Long hoSoTTHCCId,
		int loai) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByHosotthcCongIdAndLoai(hoSoTTHCCId, loai);
	}

	/**
	* Returns the number of tai lieu chung thucs where noiLuuTruId = &#63;.
	*
	* @param noiLuuTruId the noi luu tru ID
	* @return the number of matching tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBynoiLuuTruId(long noiLuuTruId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBynoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the number of tai lieu chung thucs.
	*
	* @return the number of tai lieu chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaiLieuChungThucPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaiLieuChungThucPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.tlct.service.ClpSerializer.getServletContextName(),
					TaiLieuChungThucPersistence.class.getName());

			ReferenceRegistry.registerReference(TaiLieuChungThucUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TaiLieuChungThucPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TaiLieuChungThucUtil.class,
			"_persistence");
	}

	private static TaiLieuChungThucPersistence _persistence;
}