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
 * This class is a wrapper for {@link LogMail}.
 * </p>
 *
 * @author    BinhNT
 * @see       LogMail
 * @generated
 */
public class LogMailWrapper implements LogMail, ModelWrapper<LogMail> {
	public LogMailWrapper(LogMail logMail) {
		_logMail = logMail;
	}

	public Class<?> getModelClass() {
		return LogMail.class;
	}

	public String getModelClassName() {
		return LogMail.class.getName();
	}

	/**
	* Returns the primary key of this log mail.
	*
	* @return the primary key of this log mail
	*/
	public long getPrimaryKey() {
		return _logMail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this log mail.
	*
	* @param primaryKey the primary key of this log mail
	*/
	public void setPrimaryKey(long primaryKey) {
		_logMail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this log mail.
	*
	* @return the ID of this log mail
	*/
	public long getId() {
		return _logMail.getId();
	}

	/**
	* Sets the ID of this log mail.
	*
	* @param id the ID of this log mail
	*/
	public void setId(long id) {
		_logMail.setId(id);
	}

	/**
	* Returns the type of this log mail.
	*
	* @return the type of this log mail
	*/
	public java.lang.String getType() {
		return _logMail.getType();
	}

	/**
	* Sets the type of this log mail.
	*
	* @param type the type of this log mail
	*/
	public void setType(java.lang.String type) {
		_logMail.setType(type);
	}

	/**
	* Returns the ho so t t h c cong ID of this log mail.
	*
	* @return the ho so t t h c cong ID of this log mail
	*/
	public long getHoSoTTHCCongId() {
		return _logMail.getHoSoTTHCCongId();
	}

	/**
	* Sets the ho so t t h c cong ID of this log mail.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID of this log mail
	*/
	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_logMail.setHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the create time of this log mail.
	*
	* @return the create time of this log mail
	*/
	public java.util.Date getCreateTime() {
		return _logMail.getCreateTime();
	}

	/**
	* Sets the create time of this log mail.
	*
	* @param createTime the create time of this log mail
	*/
	public void setCreateTime(java.util.Date createTime) {
		_logMail.setCreateTime(createTime);
	}

	/**
	* Returns the status of this log mail.
	*
	* @return the status of this log mail
	*/
	public int getStatus() {
		return _logMail.getStatus();
	}

	/**
	* Sets the status of this log mail.
	*
	* @param status the status of this log mail
	*/
	public void setStatus(int status) {
		_logMail.setStatus(status);
	}

	/**
	* Returns the description of this log mail.
	*
	* @return the description of this log mail
	*/
	public java.lang.String getDescription() {
		return _logMail.getDescription();
	}

	/**
	* Sets the description of this log mail.
	*
	* @param description the description of this log mail
	*/
	public void setDescription(java.lang.String description) {
		_logMail.setDescription(description);
	}

	public boolean isNew() {
		return _logMail.isNew();
	}

	public void setNew(boolean n) {
		_logMail.setNew(n);
	}

	public boolean isCachedModel() {
		return _logMail.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_logMail.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _logMail.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _logMail.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_logMail.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _logMail.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_logMail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LogMailWrapper((LogMail)_logMail.clone());
	}

	public int compareTo(org.oep.cmon.dao.job.model.LogMail logMail) {
		return _logMail.compareTo(logMail);
	}

	@Override
	public int hashCode() {
		return _logMail.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.job.model.LogMail> toCacheModel() {
		return _logMail.toCacheModel();
	}

	public org.oep.cmon.dao.job.model.LogMail toEscapedModel() {
		return new LogMailWrapper(_logMail.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _logMail.toString();
	}

	public java.lang.String toXmlString() {
		return _logMail.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_logMail.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LogMail getWrappedLogMail() {
		return _logMail;
	}

	public LogMail getWrappedModel() {
		return _logMail;
	}

	public void resetOriginalValues() {
		_logMail.resetOriginalValues();
	}

	private LogMail _logMail;
}