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

package org.oep.cmon.dao.chungthuc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc;

/**
 * The persistence interface for the thanh phan ho so chung thuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vietho
 * @see ThanhPhanHoSoChungThucPersistenceImpl
 * @see ThanhPhanHoSoChungThucUtil
 * @generated
 */
public interface ThanhPhanHoSoChungThucPersistence extends BasePersistence<ThanhPhanHoSoChungThuc> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThanhPhanHoSoChungThucUtil} to access the thanh phan ho so chung thuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the thanh phan ho so chung thuc in the entity cache if it is enabled.
	*
	* @param thanhPhanHoSoChungThuc the thanh phan ho so chung thuc
	*/
	public void cacheResult(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc);

	/**
	* Caches the thanh phan ho so chung thucs in the entity cache if it is enabled.
	*
	* @param thanhPhanHoSoChungThucs the thanh phan ho so chung thucs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> thanhPhanHoSoChungThucs);

	/**
	* Creates a new thanh phan ho so chung thuc with the primary key. Does not add the thanh phan ho so chung thuc to the database.
	*
	* @param thanhPhanHoSoId the primary key for the new thanh phan ho so chung thuc
	* @return the new thanh phan ho so chung thuc
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc create(
		long thanhPhanHoSoId);

	/**
	* Removes the thanh phan ho so chung thuc with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc that was removed
	* @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc remove(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc updateImpl(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the thanh phan ho so chung thuc with the primary key or throws a {@link org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException} if it could not be found.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc findByPrimaryKey(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;

	/**
	* Returns the thanh phan ho so chung thuc with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param thanhPhanHoSoId the primary key of the thanh phan ho so chung thuc
	* @return the thanh phan ho so chung thuc, or <code>null</code> if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc fetchByPrimaryKey(
		long thanhPhanHoSoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @return the matching thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		java.lang.Long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @return the range of matching thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		java.lang.Long hoSoChungThucId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findByTheoHoSoChungThucId(
		java.lang.Long hoSoChungThucId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching thanh phan ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a matching thanh phan ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc findByTheoHoSoChungThucId_First(
		java.lang.Long hoSoChungThucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;

	/**
	* Returns the last thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching thanh phan ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a matching thanh phan ho so chung thuc could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc findByTheoHoSoChungThucId_Last(
		java.lang.Long hoSoChungThucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;

	/**
	* Returns the thanh phan ho so chung thucs before and after the current thanh phan ho so chung thuc in the ordered set where hoSoChungThucId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param thanhPhanHoSoId the primary key of the current thanh phan ho so chung thuc
	* @param hoSoChungThucId the ho so chung thuc ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next thanh phan ho so chung thuc
	* @throws org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException if a thanh phan ho so chung thuc with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc[] findByTheoHoSoChungThucId_PrevAndNext(
		long thanhPhanHoSoId, java.lang.Long hoSoChungThucId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.chungthuc.NoSuchThanhPhanHoSoChungThucException;

	/**
	* Returns all the thanh phan ho so chung thucs.
	*
	* @return the thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the thanh phan ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @return the range of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the thanh phan ho so chung thucs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of thanh phan ho so chung thucs
	* @param end the upper bound of the range of thanh phan ho so chung thucs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thanh phan ho so chung thucs where hoSoChungThucId = &#63; from the database.
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTheoHoSoChungThucId(java.lang.Long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the thanh phan ho so chung thucs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thanh phan ho so chung thucs where hoSoChungThucId = &#63;.
	*
	* @param hoSoChungThucId the ho so chung thuc ID
	* @return the number of matching thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public int countByTheoHoSoChungThucId(java.lang.Long hoSoChungThucId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of thanh phan ho so chung thucs.
	*
	* @return the number of thanh phan ho so chung thucs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}