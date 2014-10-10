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

package org.oep.cmon.dao.hosohcc.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.hosohcc.model.FileDinhKem;

/**
 * The persistence interface for the file dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LIEMNn
 * @see FileDinhKemPersistenceImpl
 * @see FileDinhKemUtil
 * @generated
 */
public interface FileDinhKemPersistence extends BasePersistence<FileDinhKem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileDinhKemUtil} to access the file dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the file dinh kem in the entity cache if it is enabled.
	*
	* @param fileDinhKem the file dinh kem
	*/
	public void cacheResult(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem);

	/**
	* Caches the file dinh kems in the entity cache if it is enabled.
	*
	* @param fileDinhKems the file dinh kems
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> fileDinhKems);

	/**
	* Creates a new file dinh kem with the primary key. Does not add the file dinh kem to the database.
	*
	* @param id the primary key for the new file dinh kem
	* @return the new file dinh kem
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem create(long id);

	/**
	* Removes the file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the file dinh kem
	* @return the file dinh kem that was removed
	* @throws org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException;

	public org.oep.cmon.dao.hosohcc.model.FileDinhKem updateImpl(
		org.oep.cmon.dao.hosohcc.model.FileDinhKem fileDinhKem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the file dinh kem with the primary key or throws a {@link org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException} if it could not be found.
	*
	* @param id the primary key of the file dinh kem
	* @return the file dinh kem
	* @throws org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.hosohcc.NoSuchFileDinhKemException;

	/**
	* Returns the file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the file dinh kem
	* @return the file dinh kem, or <code>null</code> if a file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.hosohcc.model.FileDinhKem fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the file dinh kems.
	*
	* @return the file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of file dinh kems
	* @param end the upper bound of the range of file dinh kems (not inclusive)
	* @return the range of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of file dinh kems
	* @param end the upper bound of the range of file dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.hosohcc.model.FileDinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the file dinh kems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of file dinh kems.
	*
	* @return the number of file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}