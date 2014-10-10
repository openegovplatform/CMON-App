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
 * This class is a wrapper for {@link DanhSachJob}.
 * </p>
 *
 * @author    BinhNT
 * @see       DanhSachJob
 * @generated
 */
public class DanhSachJobWrapper implements DanhSachJob,
	ModelWrapper<DanhSachJob> {
	public DanhSachJobWrapper(DanhSachJob danhSachJob) {
		_danhSachJob = danhSachJob;
	}

	public Class<?> getModelClass() {
		return DanhSachJob.class;
	}

	public String getModelClassName() {
		return DanhSachJob.class.getName();
	}

	/**
	* Returns the primary key of this danh sach job.
	*
	* @return the primary key of this danh sach job
	*/
	public long getPrimaryKey() {
		return _danhSachJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh sach job.
	*
	* @param primaryKey the primary key of this danh sach job
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhSachJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this danh sach job.
	*
	* @return the i d of this danh sach job
	*/
	public long getID() {
		return _danhSachJob.getID();
	}

	/**
	* Sets the i d of this danh sach job.
	*
	* @param ID the i d of this danh sach job
	*/
	public void setID(long ID) {
		_danhSachJob.setID(ID);
	}

	/**
	* Returns the job class of this danh sach job.
	*
	* @return the job class of this danh sach job
	*/
	public java.lang.String getJobClass() {
		return _danhSachJob.getJobClass();
	}

	/**
	* Sets the job class of this danh sach job.
	*
	* @param JobClass the job class of this danh sach job
	*/
	public void setJobClass(java.lang.String JobClass) {
		_danhSachJob.setJobClass(JobClass);
	}

	/**
	* Returns the job ID of this danh sach job.
	*
	* @return the job ID of this danh sach job
	*/
	public int getJobId() {
		return _danhSachJob.getJobId();
	}

	/**
	* Sets the job ID of this danh sach job.
	*
	* @param JobId the job ID of this danh sach job
	*/
	public void setJobId(int JobId) {
		_danhSachJob.setJobId(JobId);
	}

	/**
	* Returns the job name of this danh sach job.
	*
	* @return the job name of this danh sach job
	*/
	public java.lang.String getJobName() {
		return _danhSachJob.getJobName();
	}

	/**
	* Sets the job name of this danh sach job.
	*
	* @param JobName the job name of this danh sach job
	*/
	public void setJobName(java.lang.String JobName) {
		_danhSachJob.setJobName(JobName);
	}

	/**
	* Returns the description of this danh sach job.
	*
	* @return the description of this danh sach job
	*/
	public java.lang.String getDescription() {
		return _danhSachJob.getDescription();
	}

	/**
	* Sets the description of this danh sach job.
	*
	* @param Description the description of this danh sach job
	*/
	public void setDescription(java.lang.String Description) {
		_danhSachJob.setDescription(Description);
	}

	public boolean isNew() {
		return _danhSachJob.isNew();
	}

	public void setNew(boolean n) {
		_danhSachJob.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhSachJob.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhSachJob.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhSachJob.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhSachJob.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhSachJob.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhSachJob.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhSachJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhSachJobWrapper((DanhSachJob)_danhSachJob.clone());
	}

	public int compareTo(org.oep.cmon.dao.job.model.DanhSachJob danhSachJob) {
		return _danhSachJob.compareTo(danhSachJob);
	}

	@Override
	public int hashCode() {
		return _danhSachJob.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.job.model.DanhSachJob> toCacheModel() {
		return _danhSachJob.toCacheModel();
	}

	public org.oep.cmon.dao.job.model.DanhSachJob toEscapedModel() {
		return new DanhSachJobWrapper(_danhSachJob.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhSachJob.toString();
	}

	public java.lang.String toXmlString() {
		return _danhSachJob.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhSachJob.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhSachJob getWrappedDanhSachJob() {
		return _danhSachJob;
	}

	public DanhSachJob getWrappedModel() {
		return _danhSachJob;
	}

	public void resetOriginalValues() {
		_danhSachJob.resetOriginalValues();
	}

	private DanhSachJob _danhSachJob;
}