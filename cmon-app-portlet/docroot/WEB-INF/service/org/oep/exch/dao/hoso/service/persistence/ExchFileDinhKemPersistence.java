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

package org.oep.exch.dao.hoso.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.exch.dao.hoso.model.ExchFileDinhKem;

/**
 * The persistence interface for the exch file dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NAM
 * @see ExchFileDinhKemPersistenceImpl
 * @see ExchFileDinhKemUtil
 * @generated
 */
public interface ExchFileDinhKemPersistence extends BasePersistence<ExchFileDinhKem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExchFileDinhKemUtil} to access the exch file dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the exch file dinh kem in the entity cache if it is enabled.
	*
	* @param exchFileDinhKem the exch file dinh kem
	*/
	public void cacheResult(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem);

	/**
	* Caches the exch file dinh kems in the entity cache if it is enabled.
	*
	* @param exchFileDinhKems the exch file dinh kems
	*/
	public void cacheResult(
		java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> exchFileDinhKems);

	/**
	* Creates a new exch file dinh kem with the primary key. Does not add the exch file dinh kem to the database.
	*
	* @param id the primary key for the new exch file dinh kem
	* @return the new exch file dinh kem
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem create(long id);

	/**
	* Removes the exch file dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem that was removed
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;

	public org.oep.exch.dao.hoso.model.ExchFileDinhKem updateImpl(
		org.oep.exch.dao.hoso.model.ExchFileDinhKem exchFileDinhKem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the exch file dinh kem with the primary key or throws a {@link org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException} if it could not be found.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;

	/**
	* Returns the exch file dinh kem with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the exch file dinh kem
	* @return the exch file dinh kem, or <code>null</code> if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the exch file dinh kems where OnlineId = &#63;.
	*
	* @param OnlineId the online ID
	* @return the matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the exch file dinh kems where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @return the range of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the exch file dinh kems where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findByOnlineId(
		long OnlineId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem findByOnlineId_First(
		long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;

	/**
	* Returns the last exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a matching exch file dinh kem could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem findByOnlineId_Last(
		long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;

	/**
	* Returns the exch file dinh kems before and after the current exch file dinh kem in the ordered set where OnlineId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current exch file dinh kem
	* @param OnlineId the online ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next exch file dinh kem
	* @throws org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException if a exch file dinh kem with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.exch.dao.hoso.model.ExchFileDinhKem[] findByOnlineId_PrevAndNext(
		long id, long OnlineId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.exch.dao.hoso.NoSuchExchFileDinhKemException;

	/**
	* Returns all the exch file dinh kems.
	*
	* @return the exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the exch file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @return the range of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the exch file dinh kems.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of exch file dinh kems
	* @param end the upper bound of the range of exch file dinh kems (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.exch.dao.hoso.model.ExchFileDinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the exch file dinh kems where OnlineId = &#63; from the database.
	*
	* @param OnlineId the online ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOnlineId(long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the exch file dinh kems from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of exch file dinh kems where OnlineId = &#63;.
	*
	* @param OnlineId the online ID
	* @return the number of matching exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public int countByOnlineId(long OnlineId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of exch file dinh kems.
	*
	* @return the number of exch file dinh kems
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}