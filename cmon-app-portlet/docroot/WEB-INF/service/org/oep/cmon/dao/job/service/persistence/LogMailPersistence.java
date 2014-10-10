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

package org.oep.cmon.dao.job.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.oep.cmon.dao.job.model.LogMail;

/**
 * The persistence interface for the log mail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LogMailPersistenceImpl
 * @see LogMailUtil
 * @generated
 */
public interface LogMailPersistence extends BasePersistence<LogMail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogMailUtil} to access the log mail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the log mail in the entity cache if it is enabled.
	*
	* @param logMail the log mail
	*/
	public void cacheResult(org.oep.cmon.dao.job.model.LogMail logMail);

	/**
	* Caches the log mails in the entity cache if it is enabled.
	*
	* @param logMails the log mails
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.job.model.LogMail> logMails);

	/**
	* Creates a new log mail with the primary key. Does not add the log mail to the database.
	*
	* @param id the primary key for the new log mail
	* @return the new log mail
	*/
	public org.oep.cmon.dao.job.model.LogMail create(long id);

	/**
	* Removes the log mail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the log mail
	* @return the log mail that was removed
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	public org.oep.cmon.dao.job.model.LogMail updateImpl(
		org.oep.cmon.dao.job.model.LogMail logMail, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the log mail with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchLogMailException} if it could not be found.
	*
	* @param id the primary key of the log mail
	* @return the log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the log mail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the log mail
	* @return the log mail, or <code>null</code> if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log mails where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByHoSoTTHCCongId(
		long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log mails where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the log mails where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByHoSoTTHCCongId(
		long hoSoTTHCCongId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log mail in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByHoSoTTHCCongId_First(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the last log mail in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByHoSoTTHCCongId_Last(
		long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the log mails before and after the current log mail in the ordered set where hoSoTTHCCongId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current log mail
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail[] findByByHoSoTTHCCongId_PrevAndNext(
		long id, long hoSoTTHCCongId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns all the log mails where status = &#63;.
	*
	* @param status the status
	* @return the matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log mails where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the log mails where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log mail in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByStatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the last log mail in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByStatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the log mails before and after the current log mail in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current log mail
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail[] findByByStatus_PrevAndNext(
		long id, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns all the log mails where createTime = &#63;.
	*
	* @param createTime the create time
	* @return the matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByCreateTime(
		java.util.Date createTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log mails where createTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createTime the create time
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByCreateTime(
		java.util.Date createTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the log mails where createTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createTime the create time
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findByByCreateTime(
		java.util.Date createTime, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first log mail in the ordered set where createTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createTime the create time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByCreateTime_First(
		java.util.Date createTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the last log mail in the ordered set where createTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createTime the create time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a matching log mail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail findByByCreateTime_Last(
		java.util.Date createTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns the log mails before and after the current log mail in the ordered set where createTime = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param id the primary key of the current log mail
	* @param createTime the create time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next log mail
	* @throws org.oep.cmon.dao.job.NoSuchLogMailException if a log mail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.LogMail[] findByByCreateTime_PrevAndNext(
		long id, java.util.Date createTime,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchLogMailException;

	/**
	* Returns all the log mails.
	*
	* @return the log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @return the range of log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the log mails.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of log mails
	* @param end the upper bound of the range of log mails (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of log mails
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.LogMail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log mails where hoSoTTHCCongId = &#63; from the database.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log mails where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log mails where createTime = &#63; from the database.
	*
	* @param createTime the create time
	* @throws SystemException if a system exception occurred
	*/
	public void removeByByCreateTime(java.util.Date createTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log mails from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log mails where hoSoTTHCCongId = &#63;.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID
	* @return the number of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public int countByByHoSoTTHCCongId(long hoSoTTHCCongId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log mails where status = &#63;.
	*
	* @param status the status
	* @return the number of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public int countByByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log mails where createTime = &#63;.
	*
	* @param createTime the create time
	* @return the number of matching log mails
	* @throws SystemException if a system exception occurred
	*/
	public int countByByCreateTime(java.util.Date createTime)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log mails.
	*
	* @return the number of log mails
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}