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

import org.oep.cmon.dao.job.model.DanhSachJob;

/**
 * The persistence interface for the danh sach job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see DanhSachJobPersistenceImpl
 * @see DanhSachJobUtil
 * @generated
 */
public interface DanhSachJobPersistence extends BasePersistence<DanhSachJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DanhSachJobUtil} to access the danh sach job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the danh sach job in the entity cache if it is enabled.
	*
	* @param danhSachJob the danh sach job
	*/
	public void cacheResult(org.oep.cmon.dao.job.model.DanhSachJob danhSachJob);

	/**
	* Caches the danh sach jobs in the entity cache if it is enabled.
	*
	* @param danhSachJobs the danh sach jobs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> danhSachJobs);

	/**
	* Creates a new danh sach job with the primary key. Does not add the danh sach job to the database.
	*
	* @param ID the primary key for the new danh sach job
	* @return the new danh sach job
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob create(long ID);

	/**
	* Removes the danh sach job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job that was removed
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	public org.oep.cmon.dao.job.model.DanhSachJob updateImpl(
		org.oep.cmon.dao.job.model.DanhSachJob danhSachJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	/**
	* Returns the danh sach job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job, or <code>null</code> if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach job where JobClass = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param JobClass the job class
	* @return the matching danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob findByJobClass(
		java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	/**
	* Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param JobClass the job class
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob fetchByJobClass(
		java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param JobClass the job class
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob fetchByJobClass(
		java.lang.String JobClass, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach job where JobId = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param JobId the job ID
	* @return the matching danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob findByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	/**
	* Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param JobId the job ID
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob fetchByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param JobId the job ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.DanhSachJob fetchByJobId(int JobId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the danh sach jobs.
	*
	* @return the danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the danh sach jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach jobs
	* @param end the upper bound of the range of danh sach jobs (not inclusive)
	* @return the range of danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the danh sach jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of danh sach jobs
	* @param end the upper bound of the range of danh sach jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the danh sach job where JobClass = &#63; from the database.
	*
	* @param JobClass the job class
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobClass(java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	/**
	* Removes the danh sach job where JobId = &#63; from the database.
	*
	* @param JobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException;

	/**
	* Removes all the danh sach jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh sach jobs where JobClass = &#63;.
	*
	* @param JobClass the job class
	* @return the number of matching danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobClass(java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh sach jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the number of matching danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of danh sach jobs.
	*
	* @return the number of danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}