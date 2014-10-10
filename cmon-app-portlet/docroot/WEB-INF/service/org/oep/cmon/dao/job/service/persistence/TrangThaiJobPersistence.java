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

import org.oep.cmon.dao.job.model.TrangThaiJob;

/**
 * The persistence interface for the trang thai job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see TrangThaiJobPersistenceImpl
 * @see TrangThaiJobUtil
 * @generated
 */
public interface TrangThaiJobPersistence extends BasePersistence<TrangThaiJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TrangThaiJobUtil} to access the trang thai job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the trang thai job in the entity cache if it is enabled.
	*
	* @param trangThaiJob the trang thai job
	*/
	public void cacheResult(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob);

	/**
	* Caches the trang thai jobs in the entity cache if it is enabled.
	*
	* @param trangThaiJobs the trang thai jobs
	*/
	public void cacheResult(
		java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> trangThaiJobs);

	/**
	* Creates a new trang thai job with the primary key. Does not add the trang thai job to the database.
	*
	* @param ID the primary key for the new trang thai job
	* @return the new trang thai job
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob create(long ID);

	/**
	* Removes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job that was removed
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException;

	public org.oep.cmon.dao.job.model.TrangThaiJob updateImpl(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the trang thai job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchTrangThaiJobException} if it could not be found.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob findByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException;

	/**
	* Returns the trang thai job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job, or <code>null</code> if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob fetchByPrimaryKey(long ID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the trang thai jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai jobs where JobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param JobId the job ID
	* @param start the lower bound of the range of trang thai jobs
	* @param end the upper bound of the range of trang thai jobs (not inclusive)
	* @return the range of matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai jobs where JobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param JobId the job ID
	* @param start the lower bound of the range of trang thai jobs
	* @param end the upper bound of the range of trang thai jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first trang thai job in the ordered set where JobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param JobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching trang thai job
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a matching trang thai job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob findByJobId_First(
		int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException;

	/**
	* Returns the last trang thai job in the ordered set where JobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param JobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching trang thai job
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a matching trang thai job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob findByJobId_Last(int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException;

	/**
	* Returns the trang thai jobs before and after the current trang thai job in the ordered set where JobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ID the primary key of the current trang thai job
	* @param JobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next trang thai job
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob[] findByJobId_PrevAndNext(
		long ID, int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException;

	/**
	* Returns all the trang thai jobs.
	*
	* @return the trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the trang thai jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai jobs
	* @param end the upper bound of the range of trang thai jobs (not inclusive)
	* @return the range of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the trang thai jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of trang thai jobs
	* @param end the upper bound of the range of trang thai jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai jobs where JobId = &#63; from the database.
	*
	* @param JobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the trang thai jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the number of matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of trang thai jobs.
	*
	* @return the number of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}