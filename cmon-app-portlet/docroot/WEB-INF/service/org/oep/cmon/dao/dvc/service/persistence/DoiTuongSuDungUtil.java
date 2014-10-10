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

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;

import java.util.List;

/**
 * The persistence utility for the doi tuong su dung service. This utility wraps {@link DoiTuongSuDungPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see DoiTuongSuDungPersistence
 * @see DoiTuongSuDungPersistenceImpl
 * @generated
 */
public class DoiTuongSuDungUtil {
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
	public static void clearCache(DoiTuongSuDung doiTuongSuDung) {
		getPersistence().clearCache(doiTuongSuDung);
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
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DoiTuongSuDung> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DoiTuongSuDung update(DoiTuongSuDung doiTuongSuDung,
		boolean merge) throws SystemException {
		return getPersistence().update(doiTuongSuDung, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DoiTuongSuDung update(DoiTuongSuDung doiTuongSuDung,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(doiTuongSuDung, merge, serviceContext);
	}

	/**
	* Caches the doi tuong su dung in the entity cache if it is enabled.
	*
	* @param doiTuongSuDung the doi tuong su dung
	*/
	public static void cacheResult(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung) {
		getPersistence().cacheResult(doiTuongSuDung);
	}

	/**
	* Caches the doi tuong su dungs in the entity cache if it is enabled.
	*
	* @param doiTuongSuDungs the doi tuong su dungs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> doiTuongSuDungs) {
		getPersistence().cacheResult(doiTuongSuDungs);
	}

	/**
	* Creates a new doi tuong su dung with the primary key. Does not add the doi tuong su dung to the database.
	*
	* @param id the primary key for the new doi tuong su dung
	* @return the new doi tuong su dung
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the doi tuong su dung with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung updateImpl(
		org.oep.cmon.dao.dvc.model.DoiTuongSuDung doiTuongSuDung, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(doiTuongSuDung, merge);
	}

	/**
	* Returns the doi tuong su dung with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the doi tuong su dung with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the doi tuong su dung
	* @return the doi tuong su dung, or <code>null</code> if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa);
	}

	/**
	* Returns a range of all the doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTrangThai(daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the doi tuong su dungs where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findByTrangThai(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTrangThai(daXoa, start, end, orderByComparator);
	}

	/**
	* Returns the first doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTrangThai_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().findByTrangThai_First(daXoa, orderByComparator);
	}

	/**
	* Returns the last doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTrangThai_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().findByTrangThai_Last(daXoa, orderByComparator);
	}

	/**
	* Returns the doi tuong su dungs before and after the current doi tuong su dung in the ordered set where daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current doi tuong su dung
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a doi tuong su dung with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung[] findByTrangThai_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence()
				   .findByTrangThai_PrevAndNext(id, daXoa, orderByComparator);
	}

	/**
	* Returns the doi tuong su dung where ten = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param ten the ten
	* @return the matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().findByTen(ten);
	}

	/**
	* Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ten the ten
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByTen(
		java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten);
	}

	/**
	* Returns the doi tuong su dung where ten = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ten the ten
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByTen(
		java.lang.String ten, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTen(ten, retrieveFromCache);
	}

	/**
	* Returns the doi tuong su dung where ma = &#63; or throws a {@link org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException} if it could not be found.
	*
	* @param ma the ma
	* @return the matching doi tuong su dung
	* @throws org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung findByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		return getPersistence().findByMa(ma);
	}

	/**
	* Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ma the ma
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByMa(
		java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma);
	}

	/**
	* Returns the doi tuong su dung where ma = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ma the ma
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching doi tuong su dung, or <code>null</code> if a matching doi tuong su dung could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.dvc.model.DoiTuongSuDung fetchByMa(
		java.lang.String ma, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMa(ma, retrieveFromCache);
	}

	/**
	* Returns all the doi tuong su dungs.
	*
	* @return the doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @return the range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the doi tuong su dungs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of doi tuong su dungs
	* @param end the upper bound of the range of doi tuong su dungs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.dvc.model.DoiTuongSuDung> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the doi tuong su dungs where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTrangThai(daXoa);
	}

	/**
	* Removes the doi tuong su dung where ten = &#63; from the database.
	*
	* @param ten the ten
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		getPersistence().removeByTen(ten);
	}

	/**
	* Removes the doi tuong su dung where ma = &#63; from the database.
	*
	* @param ma the ma
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchDoiTuongSuDungException {
		getPersistence().removeByMa(ma);
	}

	/**
	* Removes all the doi tuong su dungs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of doi tuong su dungs where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTrangThai(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTrangThai(daXoa);
	}

	/**
	* Returns the number of doi tuong su dungs where ten = &#63;.
	*
	* @param ten the ten
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTen(java.lang.String ten)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTen(ten);
	}

	/**
	* Returns the number of doi tuong su dungs where ma = &#63;.
	*
	* @param ma the ma
	* @return the number of matching doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMa(java.lang.String ma)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMa(ma);
	}

	/**
	* Returns the number of doi tuong su dungs.
	*
	* @return the number of doi tuong su dungs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DoiTuongSuDungPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DoiTuongSuDungPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.dvc.service.ClpSerializer.getServletContextName(),
					DoiTuongSuDungPersistence.class.getName());

			ReferenceRegistry.registerReference(DoiTuongSuDungUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DoiTuongSuDungPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DoiTuongSuDungUtil.class,
			"_persistence");
	}

	private static DoiTuongSuDungPersistence _persistence;
}