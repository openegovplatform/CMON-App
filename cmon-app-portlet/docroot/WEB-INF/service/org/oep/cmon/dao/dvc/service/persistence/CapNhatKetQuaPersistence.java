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

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.dvc.model.CapNhatKetQua;

/**
 * The persistence interface for the cap nhat ket qua service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liemnn
 * @see CapNhatKetQuaPersistenceImpl
 * @see CapNhatKetQuaUtil
 * @generated
 */
public interface CapNhatKetQuaPersistence extends BasePersistence<CapNhatKetQua> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapNhatKetQuaUtil} to access the cap nhat ket qua persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cap nhat ket qua in the entity cache if it is enabled.
	*
	* @param capNhatKetQua the cap nhat ket qua
	*/
	public void cacheResult(
		org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua);

	/**
	* Caches the cap nhat ket quas in the entity cache if it is enabled.
	*
	* @param capNhatKetQuas the cap nhat ket quas
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> capNhatKetQuas);

	/**
	* Creates a new cap nhat ket qua with the primary key. Does not add the cap nhat ket qua to the database.
	*
	* @param id the primary key for the new cap nhat ket qua
	* @return the new cap nhat ket qua
	*/
	public org.oep.cmon.dao.dvc.model.CapNhatKetQua create(long id);

	/**
	* Removes the cap nhat ket qua with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua that was removed
	* @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CapNhatKetQua remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException;

	public org.oep.cmon.dao.dvc.model.CapNhatKetQua updateImpl(
		org.oep.cmon.dao.dvc.model.CapNhatKetQua capNhatKetQua, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cap nhat ket qua with the primary key or throws a {@link org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException} if it could not be found.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua
	* @throws org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CapNhatKetQua findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.dvc.NoSuchCapNhatKetQuaException;

	/**
	* Returns the cap nhat ket qua with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the cap nhat ket qua
	* @return the cap nhat ket qua, or <code>null</code> if a cap nhat ket qua with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.dvc.model.CapNhatKetQua fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cap nhat ket quas.
	*
	* @return the cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cap nhat ket quas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap nhat ket quas
	* @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	* @return the range of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cap nhat ket quas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cap nhat ket quas
	* @param end the upper bound of the range of cap nhat ket quas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.dvc.model.CapNhatKetQua> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cap nhat ket quas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cap nhat ket quas.
	*
	* @return the number of cap nhat ket quas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}