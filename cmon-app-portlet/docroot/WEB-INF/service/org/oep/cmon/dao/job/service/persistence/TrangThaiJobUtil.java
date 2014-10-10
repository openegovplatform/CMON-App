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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.oep.cmon.dao.job.model.TrangThaiJob;

import java.util.List;

/**
 * The persistence utility for the trang thai job service. This utility wraps {@link TrangThaiJobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see TrangThaiJobPersistence
 * @see TrangThaiJobPersistenceImpl
 * @generated
 */
public class TrangThaiJobUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TrangThaiJob trangThaiJob) {
		getPersistence().clearCache(trangThaiJob);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TrangThaiJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TrangThaiJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TrangThaiJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TrangThaiJob update(TrangThaiJob trangThaiJob, boolean merge)
		throws SystemException {
		return getPersistence().update(trangThaiJob, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TrangThaiJob update(TrangThaiJob trangThaiJob, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(trangThaiJob, merge, serviceContext);
	}

	/**
	* Caches the trang thai job in the entity cache if it is enabled.
	*
	* @param trangThaiJob the trang thai job
	*/
	public static void cacheResult(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob) {
		getPersistence().cacheResult(trangThaiJob);
	}

	/**
	* Caches the trang thai jobs in the entity cache if it is enabled.
	*
	* @param trangThaiJobs the trang thai jobs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> trangThaiJobs) {
		getPersistence().cacheResult(trangThaiJobs);
	}

	/**
	* Creates a new trang thai job with the primary key. Does not add the trang thai job to the database.
	*
	* @param ID the primary key for the new trang thai job
	* @return the new trang thai job
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job that was removed
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.job.model.TrangThaiJob updateImpl(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(trangThaiJob, merge);
	}

	/**
	* Returns the trang thai job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchTrangThaiJobException} if it could not be found.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job
	* @throws org.oep.cmon.dao.job.NoSuchTrangThaiJobException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the trang thai job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job, or <code>null</code> if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.TrangThaiJob fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns all the trang thai jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJobId(JobId);
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJobId(JobId, start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int JobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJobId(JobId, start, end, orderByComparator);
	}

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
	public static org.oep.cmon.dao.job.model.TrangThaiJob findByJobId_First(
		int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException {
		return getPersistence().findByJobId_First(JobId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.job.model.TrangThaiJob findByJobId_Last(
		int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException {
		return getPersistence().findByJobId_Last(JobId, orderByComparator);
	}

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
	public static org.oep.cmon.dao.job.model.TrangThaiJob[] findByJobId_PrevAndNext(
		long ID, int JobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchTrangThaiJobException {
		return getPersistence()
				   .findByJobId_PrevAndNext(ID, JobId, orderByComparator);
	}

	/**
	* Returns all the trang thai jobs.
	*
	* @return the trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the trang thai jobs where JobId = &#63; from the database.
	*
	* @param JobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByJobId(JobId);
	}

	/**
	* Removes all the trang thai jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of trang thai jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the number of matching trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJobId(JobId);
	}

	/**
	* Returns the number of trang thai jobs.
	*
	* @return the number of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TrangThaiJobPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TrangThaiJobPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.job.service.ClpSerializer.getServletContextName(),
					TrangThaiJobPersistence.class.getName());

			ReferenceRegistry.registerReference(TrangThaiJobUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(TrangThaiJobPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(TrangThaiJobUtil.class,
			"_persistence");
	}

	private static TrangThaiJobPersistence _persistence;
}