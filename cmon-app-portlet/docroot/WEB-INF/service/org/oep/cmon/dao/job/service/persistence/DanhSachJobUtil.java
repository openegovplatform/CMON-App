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

import org.oep.cmon.dao.job.model.DanhSachJob;

import java.util.List;

/**
 * The persistence utility for the danh sach job service. This utility wraps {@link DanhSachJobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see DanhSachJobPersistence
 * @see DanhSachJobPersistenceImpl
 * @generated
 */
public class DanhSachJobUtil {
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
	public static void clearCache(DanhSachJob danhSachJob) {
		getPersistence().clearCache(danhSachJob);
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
	public static List<DanhSachJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DanhSachJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DanhSachJob> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static DanhSachJob update(DanhSachJob danhSachJob, boolean merge)
		throws SystemException {
		return getPersistence().update(danhSachJob, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static DanhSachJob update(DanhSachJob danhSachJob, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(danhSachJob, merge, serviceContext);
	}

	/**
	* Caches the danh sach job in the entity cache if it is enabled.
	*
	* @param danhSachJob the danh sach job
	*/
	public static void cacheResult(
		org.oep.cmon.dao.job.model.DanhSachJob danhSachJob) {
		getPersistence().cacheResult(danhSachJob);
	}

	/**
	* Caches the danh sach jobs in the entity cache if it is enabled.
	*
	* @param danhSachJobs the danh sach jobs
	*/
	public static void cacheResult(
		java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> danhSachJobs) {
		getPersistence().cacheResult(danhSachJobs);
	}

	/**
	* Creates a new danh sach job with the primary key. Does not add the danh sach job to the database.
	*
	* @param ID the primary key for the new danh sach job
	* @return the new danh sach job
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob create(long ID) {
		return getPersistence().create(ID);
	}

	/**
	* Removes the danh sach job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job that was removed
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob remove(long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		return getPersistence().remove(ID);
	}

	public static org.oep.cmon.dao.job.model.DanhSachJob updateImpl(
		org.oep.cmon.dao.job.model.DanhSachJob danhSachJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(danhSachJob, merge);
	}

	/**
	* Returns the danh sach job with the primary key or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob findByPrimaryKey(
		long ID)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		return getPersistence().findByPrimaryKey(ID);
	}

	/**
	* Returns the danh sach job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ID the primary key of the danh sach job
	* @return the danh sach job, or <code>null</code> if a danh sach job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob fetchByPrimaryKey(
		long ID) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ID);
	}

	/**
	* Returns the danh sach job where JobClass = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param JobClass the job class
	* @return the matching danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob findByJobClass(
		java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		return getPersistence().findByJobClass(JobClass);
	}

	/**
	* Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param JobClass the job class
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob fetchByJobClass(
		java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobClass(JobClass);
	}

	/**
	* Returns the danh sach job where JobClass = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param JobClass the job class
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob fetchByJobClass(
		java.lang.String JobClass, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobClass(JobClass, retrieveFromCache);
	}

	/**
	* Returns the danh sach job where JobId = &#63; or throws a {@link org.oep.cmon.dao.job.NoSuchDanhSachJobException} if it could not be found.
	*
	* @param JobId the job ID
	* @return the matching danh sach job
	* @throws org.oep.cmon.dao.job.NoSuchDanhSachJobException if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob findByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		return getPersistence().findByJobId(JobId);
	}

	/**
	* Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param JobId the job ID
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob fetchByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobId(JobId);
	}

	/**
	* Returns the danh sach job where JobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param JobId the job ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching danh sach job, or <code>null</code> if a matching danh sach job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.oep.cmon.dao.job.model.DanhSachJob fetchByJobId(
		int JobId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByJobId(JobId, retrieveFromCache);
	}

	/**
	* Returns all the danh sach jobs.
	*
	* @return the danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.oep.cmon.dao.job.model.DanhSachJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the danh sach job where JobClass = &#63; from the database.
	*
	* @param JobClass the job class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByJobClass(java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		getPersistence().removeByJobClass(JobClass);
	}

	/**
	* Removes the danh sach job where JobId = &#63; from the database.
	*
	* @param JobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.oep.cmon.dao.job.NoSuchDanhSachJobException {
		getPersistence().removeByJobId(JobId);
	}

	/**
	* Removes all the danh sach jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of danh sach jobs where JobClass = &#63;.
	*
	* @param JobClass the job class
	* @return the number of matching danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJobClass(java.lang.String JobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJobClass(JobClass);
	}

	/**
	* Returns the number of danh sach jobs where JobId = &#63;.
	*
	* @param JobId the job ID
	* @return the number of matching danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJobId(int JobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJobId(JobId);
	}

	/**
	* Returns the number of danh sach jobs.
	*
	* @return the number of danh sach jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DanhSachJobPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DanhSachJobPersistence)PortletBeanLocatorUtil.locate(org.oep.cmon.dao.job.service.ClpSerializer.getServletContextName(),
					DanhSachJobPersistence.class.getName());

			ReferenceRegistry.registerReference(DanhSachJobUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(DanhSachJobPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(DanhSachJobUtil.class,
			"_persistence");
	}

	private static DanhSachJobPersistence _persistence;
}