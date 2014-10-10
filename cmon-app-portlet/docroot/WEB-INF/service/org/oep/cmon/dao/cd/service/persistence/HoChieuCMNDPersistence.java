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

package org.oep.cmon.dao.cd.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.cd.model.HoChieuCMND;

/**
 * The persistence interface for the ho chieu c m n d service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNN
 * @see HoChieuCMNDPersistenceImpl
 * @see HoChieuCMNDUtil
 * @generated
 */
public interface HoChieuCMNDPersistence extends BasePersistence<HoChieuCMND> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoChieuCMNDUtil} to access the ho chieu c m n d persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ho chieu c m n d in the entity cache if it is enabled.
	*
	* @param hoChieuCMND the ho chieu c m n d
	*/
	public void cacheResult(org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND);

	/**
	* Caches the ho chieu c m n ds in the entity cache if it is enabled.
	*
	* @param hoChieuCMNDs the ho chieu c m n ds
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> hoChieuCMNDs);

	/**
	* Creates a new ho chieu c m n d with the primary key. Does not add the ho chieu c m n d to the database.
	*
	* @param id the primary key for the new ho chieu c m n d
	* @return the new ho chieu c m n d
	*/
	public org.oep.cmon.dao.cd.model.HoChieuCMND create(long id);

	/**
	* Removes the ho chieu c m n d with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d that was removed
	* @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.HoChieuCMND remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException;

	public org.oep.cmon.dao.cd.model.HoChieuCMND updateImpl(
		org.oep.cmon.dao.cd.model.HoChieuCMND hoChieuCMND, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ho chieu c m n d with the primary key or throws a {@link org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException} if it could not be found.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d
	* @throws org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.HoChieuCMND findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.cd.NoSuchHoChieuCMNDException;

	/**
	* Returns the ho chieu c m n d with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the ho chieu c m n d
	* @return the ho chieu c m n d, or <code>null</code> if a ho chieu c m n d with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.cd.model.HoChieuCMND fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ho chieu c m n ds.
	*
	* @return the ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ho chieu c m n ds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho chieu c m n ds
	* @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	* @return the range of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ho chieu c m n ds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ho chieu c m n ds
	* @param end the upper bound of the range of ho chieu c m n ds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.cd.model.HoChieuCMND> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ho chieu c m n ds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ho chieu c m n ds.
	*
	* @return the number of ho chieu c m n ds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}