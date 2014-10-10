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

package org.oep.cmon.dao.touchscreen.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh;

/**
 * The persistence interface for the tra cuu thu tuc hanh chinh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author VIENPN
 * @see TraCuuThuTucHanhChinhPersistenceImpl
 * @see TraCuuThuTucHanhChinhUtil
 * @generated
 */
public interface TraCuuThuTucHanhChinhPersistence extends BasePersistence<TraCuuThuTucHanhChinh> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TraCuuThuTucHanhChinhUtil} to access the tra cuu thu tuc hanh chinh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tra cuu thu tuc hanh chinh in the entity cache if it is enabled.
	*
	* @param traCuuThuTucHanhChinh the tra cuu thu tuc hanh chinh
	*/
	public void cacheResult(
		org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh traCuuThuTucHanhChinh);

	/**
	* Caches the tra cuu thu tuc hanh chinhs in the entity cache if it is enabled.
	*
	* @param traCuuThuTucHanhChinhs the tra cuu thu tuc hanh chinhs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh> traCuuThuTucHanhChinhs);

	/**
	* Creates a new tra cuu thu tuc hanh chinh with the primary key. Does not add the tra cuu thu tuc hanh chinh to the database.
	*
	* @param id the primary key for the new tra cuu thu tuc hanh chinh
	* @return the new tra cuu thu tuc hanh chinh
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh create(
		long id);

	/**
	* Removes the tra cuu thu tuc hanh chinh with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tra cuu thu tuc hanh chinh
	* @return the tra cuu thu tuc hanh chinh that was removed
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException;

	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh updateImpl(
		org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh traCuuThuTucHanhChinh,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tra cuu thu tuc hanh chinh with the primary key or throws a {@link org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException} if it could not be found.
	*
	* @param id the primary key of the tra cuu thu tuc hanh chinh
	* @return the tra cuu thu tuc hanh chinh
	* @throws org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException if a tra cuu thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.touchscreen.NoSuchTraCuuThuTucHanhChinhException;

	/**
	* Returns the tra cuu thu tuc hanh chinh with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tra cuu thu tuc hanh chinh
	* @return the tra cuu thu tuc hanh chinh, or <code>null</code> if a tra cuu thu tuc hanh chinh with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tra cuu thu tuc hanh chinhs.
	*
	* @return the tra cuu thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tra cuu thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tra cuu thu tuc hanh chinhs
	* @param end the upper bound of the range of tra cuu thu tuc hanh chinhs (not inclusive)
	* @return the range of tra cuu thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tra cuu thu tuc hanh chinhs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tra cuu thu tuc hanh chinhs
	* @param end the upper bound of the range of tra cuu thu tuc hanh chinhs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tra cuu thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tra cuu thu tuc hanh chinhs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tra cuu thu tuc hanh chinhs.
	*
	* @return the number of tra cuu thu tuc hanh chinhs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}