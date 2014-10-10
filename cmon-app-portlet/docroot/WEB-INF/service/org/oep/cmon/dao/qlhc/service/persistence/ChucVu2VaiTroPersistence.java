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

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;

/**
 * The persistence interface for the chuc vu2 vai tro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see ChucVu2VaiTroPersistenceImpl
 * @see ChucVu2VaiTroUtil
 * @generated
 */
public interface ChucVu2VaiTroPersistence extends BasePersistence<ChucVu2VaiTro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChucVu2VaiTroUtil} to access the chuc vu2 vai tro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the chuc vu2 vai tro in the entity cache if it is enabled.
	*
	* @param chucVu2VaiTro the chuc vu2 vai tro
	*/
	public void cacheResult(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro);

	/**
	* Caches the chuc vu2 vai tros in the entity cache if it is enabled.
	*
	* @param chucVu2VaiTros the chuc vu2 vai tros
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> chucVu2VaiTros);

	/**
	* Creates a new chuc vu2 vai tro with the primary key. Does not add the chuc vu2 vai tro to the database.
	*
	* @param id the primary key for the new chuc vu2 vai tro
	* @return the new chuc vu2 vai tro
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro create(long id);

	/**
	* Removes the chuc vu2 vai tro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro that was removed
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro updateImpl(
		org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro chucVu2VaiTro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the chuc vu2 vai tro with the primary key or throws a {@link org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException} if it could not be found.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro
	* @throws org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns the chuc vu2 vai tro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the chuc vu2 vai tro
	* @return the chuc vu2 vai tro, or <code>null</code> if a chuc vu2 vai tro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @return the matching chuc vu2 vai tro, or <code>null</code> if a matching chuc vu2 vai tro could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro fetchByChucVu2VaiTro(
		java.lang.Long vaiTroId, java.lang.Long coQuanQuanLyId,
		java.lang.Long chucVuId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroId(
		java.lang.Long vaiTroId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroId_First(
		java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroId_Last(
		java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByVaiTroId_PrevAndNext(
		long id, java.lang.Long vaiTroId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyId(
		java.lang.Long coQuanQuanLyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyId_First(
		java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyId_Last(
		java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByCoQuanQuanLyId_PrevAndNext(
		long id, java.lang.Long coQuanQuanLyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuId(
		java.lang.Long chucVuId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuId_First(
		java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuId_Last(
		java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuId_PrevAndNext(
		long id, java.lang.Long chucVuId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByVaiTroIdAndDaXoa(
		java.lang.Long vaiTroId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroIdAndDaXoa_First(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByVaiTroIdAndDaXoa_Last(
		java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByVaiTroIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long vaiTroId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByCoQuanQuanLyIdAndDaXoa(
		java.lang.Long coQuanQuanLyId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_First(
		java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByCoQuanQuanLyIdAndDaXoa_Last(
		java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByCoQuanQuanLyIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndDaXoa(
		java.lang.Long chucVuId, int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndDaXoa_First(
		java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndDaXoa_Last(
		java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuIdAndDaXoa_PrevAndNext(
		long id, java.lang.Long chucVuId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByChucVuIdAndCoQuanQuanLyId(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_First(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByChucVuIdAndCoQuanQuanLyId_Last(
		java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByChucVuIdAndCoQuanQuanLyId_PrevAndNext(
		long id, java.lang.Long chucVuId, java.lang.Long coQuanQuanLyId,
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findByDaXoa(
		int daXoa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByDaXoa_First(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro findByDaXoa_Last(
		int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

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
	public org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro[] findByDaXoa_PrevAndNext(
		long id, int daXoa,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Returns all the chuc vu2 vai tros.
	*
	* @return the chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the chuc vu2 vai tro where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChucVu2VaiTro(java.lang.Long vaiTroId,
		java.lang.Long coQuanQuanLyId, java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.qlhc.NoSuchChucVu2VaiTroException;

	/**
	* Removes all the chuc vu2 vai tros where vaiTroId = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVaiTroId(java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCoQuanQuanLyId(java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChucVuId(java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63; from the database.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVaiTroIdAndDaXoa(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCoQuanQuanLyIdAndDaXoa(java.lang.Long coQuanQuanLyId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChucVuIdAndDaXoa(java.lang.Long chucVuId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63; from the database.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByChucVuIdAndCoQuanQuanLyId(java.lang.Long chucVuId,
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros where daXoa = &#63; from the database.
	*
	* @param daXoa the da xoa
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the chuc vu2 vai tros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and coQuanQuanLyId = &#63; and chucVuId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param chucVuId the chuc vu ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByChucVu2VaiTro(java.lang.Long vaiTroId,
		java.lang.Long coQuanQuanLyId, java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByVaiTroId(java.lang.Long vaiTroId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByCoQuanQuanLyId(java.lang.Long coQuanQuanLyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByChucVuId(java.lang.Long chucVuId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where vaiTroId = &#63; and daXoa = &#63;.
	*
	* @param vaiTroId the vai tro ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByVaiTroIdAndDaXoa(java.lang.Long vaiTroId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByCoQuanQuanLyIdAndDaXoa(java.lang.Long coQuanQuanLyId,
		int daXoa) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByChucVuIdAndDaXoa(java.lang.Long chucVuId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where chucVuId = &#63; and coQuanQuanLyId = &#63; and daXoa = &#63;.
	*
	* @param chucVuId the chuc vu ID
	* @param coQuanQuanLyId the co quan quan ly ID
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByChucVuIdAndCoQuanQuanLyId(java.lang.Long chucVuId,
		java.lang.Long coQuanQuanLyId, int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros where daXoa = &#63;.
	*
	* @param daXoa the da xoa
	* @return the number of matching chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countByDaXoa(int daXoa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of chuc vu2 vai tros.
	*
	* @return the number of chuc vu2 vai tros
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}