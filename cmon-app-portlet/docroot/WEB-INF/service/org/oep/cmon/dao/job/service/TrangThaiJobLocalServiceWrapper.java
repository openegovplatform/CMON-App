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

package org.oep.cmon.dao.job.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrangThaiJobLocalService}.
 * </p>
 *
 * @author    BinhNT
 * @see       TrangThaiJobLocalService
 * @generated
 */
public class TrangThaiJobLocalServiceWrapper implements TrangThaiJobLocalService,
	ServiceWrapper<TrangThaiJobLocalService> {
	public TrangThaiJobLocalServiceWrapper(
		TrangThaiJobLocalService trangThaiJobLocalService) {
		_trangThaiJobLocalService = trangThaiJobLocalService;
	}

	/**
	* Adds the trang thai job to the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @return the trang thai job that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob addTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.addTrangThaiJob(trangThaiJob);
	}

	/**
	* Creates a new trang thai job with the primary key. Does not add the trang thai job to the database.
	*
	* @param ID the primary key for the new trang thai job
	* @return the new trang thai job
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob createTrangThaiJob(long ID) {
		return _trangThaiJobLocalService.createTrangThaiJob(ID);
	}

	/**
	* Deletes the trang thai job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ID the primary key of the trang thai job
	* @throws PortalException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiJob(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_trangThaiJobLocalService.deleteTrangThaiJob(ID);
	}

	/**
	* Deletes the trang thai job from the database. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @throws SystemException if a system exception occurred
	*/
	public void deleteTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiJobLocalService.deleteTrangThaiJob(trangThaiJob);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.dynamicQueryCount(dynamicQuery);
	}

	public org.oep.cmon.dao.job.model.TrangThaiJob fetchTrangThaiJob(long ID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.fetchTrangThaiJob(ID);
	}

	/**
	* Returns the trang thai job with the primary key.
	*
	* @param ID the primary key of the trang thai job
	* @return the trang thai job
	* @throws PortalException if a trang thai job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob getTrangThaiJob(long ID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.getTrangThaiJob(ID);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> getTrangThaiJobs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.getTrangThaiJobs(start, end);
	}

	/**
	* Returns the number of trang thai jobs.
	*
	* @return the number of trang thai jobs
	* @throws SystemException if a system exception occurred
	*/
	public int getTrangThaiJobsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.getTrangThaiJobsCount();
	}

	/**
	* Updates the trang thai job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @return the trang thai job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob updateTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.updateTrangThaiJob(trangThaiJob);
	}

	/**
	* Updates the trang thai job in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param trangThaiJob the trang thai job
	* @param merge whether to merge the trang thai job with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the trang thai job that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.oep.cmon.dao.job.model.TrangThaiJob updateTrangThaiJob(
		org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.updateTrangThaiJob(trangThaiJob, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _trangThaiJobLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_trangThaiJobLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* This is fucntion findByJobId
	* Version: 1.0
	*
	* History:
	*   DATE        AUTHOR      DESCRIPTION
	*  -------------------------------------------------
	*  3-March-2013  Nam Dinh    Create new
	*
	* @param int jobId
	* @return List<TrangThaiJob>
	*/
	public java.util.List<org.oep.cmon.dao.job.model.TrangThaiJob> findByJobId(
		int jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return _trangThaiJobLocalService.findByJobId(jobId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TrangThaiJobLocalService getWrappedTrangThaiJobLocalService() {
		return _trangThaiJobLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTrangThaiJobLocalService(
		TrangThaiJobLocalService trangThaiJobLocalService) {
		_trangThaiJobLocalService = trangThaiJobLocalService;
	}

	public TrangThaiJobLocalService getWrappedService() {
		return _trangThaiJobLocalService;
	}

	public void setWrappedService(
		TrangThaiJobLocalService trangThaiJobLocalService) {
		_trangThaiJobLocalService = trangThaiJobLocalService;
	}

	private TrangThaiJobLocalService _trangThaiJobLocalService;
}