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

package org.oep.cmon.dao.job.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link TrangThaiJob}.
 * </p>
 *
 * @author    BinhNT
 * @see       TrangThaiJob
 * @generated
 */
public class TrangThaiJobWrapper implements TrangThaiJob,
	ModelWrapper<TrangThaiJob> {
	public TrangThaiJobWrapper(TrangThaiJob trangThaiJob) {
		_trangThaiJob = trangThaiJob;
	}

	public Class<?> getModelClass() {
		return TrangThaiJob.class;
	}

	public String getModelClassName() {
		return TrangThaiJob.class.getName();
	}

	/**
	* Returns the primary key of this trang thai job.
	*
	* @return the primary key of this trang thai job
	*/
	public long getPrimaryKey() {
		return _trangThaiJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trang thai job.
	*
	* @param primaryKey the primary key of this trang thai job
	*/
	public void setPrimaryKey(long primaryKey) {
		_trangThaiJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this trang thai job.
	*
	* @return the i d of this trang thai job
	*/
	public long getID() {
		return _trangThaiJob.getID();
	}

	/**
	* Sets the i d of this trang thai job.
	*
	* @param ID the i d of this trang thai job
	*/
	public void setID(long ID) {
		_trangThaiJob.setID(ID);
	}

	/**
	* Returns the job ID of this trang thai job.
	*
	* @return the job ID of this trang thai job
	*/
	public int getJobId() {
		return _trangThaiJob.getJobId();
	}

	/**
	* Sets the job ID of this trang thai job.
	*
	* @param JobId the job ID of this trang thai job
	*/
	public void setJobId(int JobId) {
		_trangThaiJob.setJobId(JobId);
	}

	/**
	* Returns the job name of this trang thai job.
	*
	* @return the job name of this trang thai job
	*/
	public java.lang.String getJobName() {
		return _trangThaiJob.getJobName();
	}

	/**
	* Sets the job name of this trang thai job.
	*
	* @param JobName the job name of this trang thai job
	*/
	public void setJobName(java.lang.String JobName) {
		_trangThaiJob.setJobName(JobName);
	}

	/**
	* Returns the start time of this trang thai job.
	*
	* @return the start time of this trang thai job
	*/
	public java.util.Date getStartTime() {
		return _trangThaiJob.getStartTime();
	}

	/**
	* Sets the start time of this trang thai job.
	*
	* @param StartTime the start time of this trang thai job
	*/
	public void setStartTime(java.util.Date StartTime) {
		_trangThaiJob.setStartTime(StartTime);
	}

	/**
	* Returns the end time of this trang thai job.
	*
	* @return the end time of this trang thai job
	*/
	public java.util.Date getEndTime() {
		return _trangThaiJob.getEndTime();
	}

	/**
	* Sets the end time of this trang thai job.
	*
	* @param EndTime the end time of this trang thai job
	*/
	public void setEndTime(java.util.Date EndTime) {
		_trangThaiJob.setEndTime(EndTime);
	}

	/**
	* Returns the status of this trang thai job.
	*
	* @return the status of this trang thai job
	*/
	public int getStatus() {
		return _trangThaiJob.getStatus();
	}

	/**
	* Sets the status of this trang thai job.
	*
	* @param Status the status of this trang thai job
	*/
	public void setStatus(int Status) {
		_trangThaiJob.setStatus(Status);
	}

	/**
	* Returns the run mode of this trang thai job.
	*
	* @return the run mode of this trang thai job
	*/
	public int getRunMode() {
		return _trangThaiJob.getRunMode();
	}

	/**
	* Sets the run mode of this trang thai job.
	*
	* @param RunMode the run mode of this trang thai job
	*/
	public void setRunMode(int RunMode) {
		_trangThaiJob.setRunMode(RunMode);
	}

	/**
	* Returns the message of this trang thai job.
	*
	* @return the message of this trang thai job
	*/
	public java.lang.String getMessage() {
		return _trangThaiJob.getMessage();
	}

	/**
	* Sets the message of this trang thai job.
	*
	* @param Message the message of this trang thai job
	*/
	public void setMessage(java.lang.String Message) {
		_trangThaiJob.setMessage(Message);
	}

	public boolean isNew() {
		return _trangThaiJob.isNew();
	}

	public void setNew(boolean n) {
		_trangThaiJob.setNew(n);
	}

	public boolean isCachedModel() {
		return _trangThaiJob.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trangThaiJob.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trangThaiJob.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trangThaiJob.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trangThaiJob.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trangThaiJob.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trangThaiJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrangThaiJobWrapper((TrangThaiJob)_trangThaiJob.clone());
	}

	public int compareTo(org.oep.cmon.dao.job.model.TrangThaiJob trangThaiJob) {
		return _trangThaiJob.compareTo(trangThaiJob);
	}

	@Override
	public int hashCode() {
		return _trangThaiJob.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.job.model.TrangThaiJob> toCacheModel() {
		return _trangThaiJob.toCacheModel();
	}

	public org.oep.cmon.dao.job.model.TrangThaiJob toEscapedModel() {
		return new TrangThaiJobWrapper(_trangThaiJob.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trangThaiJob.toString();
	}

	public java.lang.String toXmlString() {
		return _trangThaiJob.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiJob.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrangThaiJob getWrappedTrangThaiJob() {
		return _trangThaiJob;
	}

	public TrangThaiJob getWrappedModel() {
		return _trangThaiJob;
	}

	public void resetOriginalValues() {
		_trangThaiJob.resetOriginalValues();
	}

	private TrangThaiJob _trangThaiJob;
}