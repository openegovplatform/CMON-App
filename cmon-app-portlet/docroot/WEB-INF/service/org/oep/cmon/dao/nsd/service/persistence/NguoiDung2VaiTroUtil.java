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

import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;

import java.util.List;

/**
 * The persistence utility for the nguoi dung2 vai tro service. This utility wraps {@link NguoiDung2VaiTroPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liemnn
 * @see NguoiDung2VaiTroPersistence
 * @see NguoiDung2VaiTroPersistenceImpl
 * @generated
 */
public class NguoiDung2VaiTroUtil {
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
	public static void clearCache(NguoiDung2VaiTro nguoiDung2VaiTro) {
		getPersistence().clearCache(nguoiDung2VaiTro);
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
	public static List<NguoiDung2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NguoiDung2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NguoiDung2VaiTro> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NguoiDung2VaiTro update(NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge) throws SystemException {
		return getPersistence().update(nguoiDung2VaiTro, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NguoiDung2VaiTro update(NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(nguoiDung2VaiTro, merge, serviceContext);
	}

	/**
	* Caches the nguoi dung2 vai tro in the entity cache if it is enabled.
	*
	* @param nguoiDung2VaiTro the nguoi dung2 vai tro
	*/
	public static void cacheResult(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro) {
		getPersistence().cacheResult(nguoiDung2VaiTro);
	}

	/**
	* Caches the nguoi dung2 vai tros in the entity cache if it is enabled.
	*
	* @param nguoiDung2VaiTros the nguoi dung2 vai tros
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> nguoiDung2VaiTros) {
		getPersistence().cacheResult(nguoiDung2VaiTros);
	}

	/**
	* Creates a new nguoi dung2 vai tro with the primary key. Does not add the nguoi dung2 vai tro to the database.
	*
	* @param id the primary key for the new nguoi dung2 vai tro
	* @return the new nguoi dung2 vai tro
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the nguoi dung2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro that was removed
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence().remove(id);
	}

	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro updateImpl(
		org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro nguoiDung2VaiTro,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nguoiDung2VaiTro, merge);
	}

	/**
	* Returns the nguoi dung2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException} if it could not be found.
	*
	* @param id the primary key of the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the nguoi dung2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the nguoi dung2 vai tro
	* @return the nguoi dung2 vai tro, or <code>null</code> if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByVaiTroID(
		java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVaiTroID(vaiTroId, daXoa);
	}

	/**
	* Returns a range of all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @return the range of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByVaiTroID(
		java.lang.Long vaiTroId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVaiTroID(vaiTroId, daXoa, start, end);
	}

	/**
	* Returns an ordered range of all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByVaiTroID(
		java.lang.Long vaiTroId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVaiTroID(vaiTroId, daXoa, start, end,
			orderByComparator);
	}

	/**
	* Returns the first nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByVaiTroID_First(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByVaiTroID_First(vaiTroId, daXoa, orderByComparator);
	}

	/**
	* Returns the last nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByVaiTroID_Last(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByVaiTroID_Last(vaiTroId, daXoa, orderByComparator);
	}

	/**
	* Returns the nguoi dung2 vai tros before and after the current nguoi dung2 vai tro in the ordered set where vaiTroId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nguoi dung2 vai tro
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro[] findByVaiTroID_PrevAndNext(
		long id, java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByVaiTroID_PrevAndNext(id, vaiTroId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or throws a {@link org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException} if it could not be found.
	*
	* @param vaiTroId the vai tro ID
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the matching nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByVaiTroIDAndTaiKhoanNguoiDungId(
		java.lang.Long vaiTroId, java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vaiTroId the vai tro ID
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the matching nguoi dung2 vai tro, or <code>null</code> if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro fetchByVaiTroIDAndTaiKhoanNguoiDungId(
		java.lang.Long vaiTroId, java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param vaiTroId the vai tro ID
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching nguoi dung2 vai tro, or <code>null</code> if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro fetchByVaiTroIDAndTaiKhoanNguoiDungId(
		java.lang.Long vaiTroId, java.lang.Long taiKhoanNguoiDungId, int daXoa,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa, retrieveFromCache);
	}

	/**
	* Returns all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns a range of all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @return the range of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa,
			start, end);
	}

	/**
	* Returns an ordered range of all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa,
			start, end, orderByComparator);
	}

	/**
	* Returns the first nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByTaiKhoanNguoiDungId_First(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_First(taiKhoanNguoiDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the last nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a matching nguoi dung2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro findByTaiKhoanNguoiDungId_Last(
		java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_Last(taiKhoanNguoiDungId, daXoa,
			orderByComparator);
	}

	/**
	* Returns the nguoi dung2 vai tros before and after the current nguoi dung2 vai tro in the ordered set where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current nguoi dung2 vai tro
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next nguoi dung2 vai tro
	* @throws org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException if a nguoi dung2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro[] findByTaiKhoanNguoiDungId_PrevAndNext(
		long id, java.lang.Long taiKhoanNguoiDungId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		return getPersistence()
				   .findByTaiKhoanNguoiDungId_PrevAndNext(id,
			taiKhoanNguoiDungId, daXoa, orderByComparator);
	}

	/**
	* Returns all the nguoi dung2 vai tros.
	*
	* @return the nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the nguoi dung2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @return the range of nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the nguoi dung2 vai tros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of nguoi dung2 vai tros
	* @param end the upper bound of the range of nguoi dung2 vai tros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVaiTroID(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVaiTroID(vaiTroId, daXoa);
	}

	/**
	* Removes the nguoi dung2 vai tro where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVaiTroIDAndTaiKhoanNguoiDungId(
		java.lang.Long vaiTroId, java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.nsd.NoSuchNguoiDung2VaiTroException {
		getPersistence()
			.removeByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Removes all the nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63; from the database.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Removes all the nguoi dung2 vai tros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of nguoi dung2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the number of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVaiTroID(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVaiTroID(vaiTroId, daXoa);
	}

	/**
	* Returns the number of nguoi dung2 vai tros where vaiTroId = &#63; and taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the number of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVaiTroIDAndTaiKhoanNguoiDungId(
		java.lang.Long vaiTroId, java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByVaiTroIDAndTaiKhoanNguoiDungId(vaiTroId,
			taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns the number of nguoi dung2 vai tros where taiKhoanNguoiDungId = &#63; and daXoa = &#63;.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID
	* @param daXoa the da xoa
	* @return the number of matching nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaiKhoanNguoiDungId(
		java.lang.Long taiKhoanNguoiDungId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTaiKhoanNguoiDungId(taiKhoanNguoiDungId, daXoa);
	}

	/**
	* Returns the number of nguoi dung2 vai tros.
	*
	* @return the number of nguoi dung2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NguoiDung2VaiTroPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NguoiDung2VaiTroPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.nsd.service.ClpSerializer.getServletContextName(),
					NguoiDung2VaiTroPersistence.class.getName());

			ReferenceRegistry.registerReference(NguoiDung2VaiTroUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(NguoiDung2VaiTroPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(NguoiDung2VaiTroUtil.class,
			"_persistence");
	}

	private static NguoiDung2VaiTroPersistence _persistence;
}