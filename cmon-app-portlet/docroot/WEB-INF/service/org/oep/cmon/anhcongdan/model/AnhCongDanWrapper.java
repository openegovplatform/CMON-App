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

package org.oep.cmon.anhcongdan.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AnhCongDan}.
 * </p>
 *
 * @author    BinhNT
 * @see       AnhCongDan
 * @generated
 */
public class AnhCongDanWrapper implements AnhCongDan, ModelWrapper<AnhCongDan> {
	public AnhCongDanWrapper(AnhCongDan anhCongDan) {
		_anhCongDan = anhCongDan;
	}

	public Class<?> getModelClass() {
		return AnhCongDan.class;
	}

	public String getModelClassName() {
		return AnhCongDan.class.getName();
	}

	/**
	* Returns the primary key of this anh cong dan.
	*
	* @return the primary key of this anh cong dan
	*/
	public long getPrimaryKey() {
		return _anhCongDan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this anh cong dan.
	*
	* @param primaryKey the primary key of this anh cong dan
	*/
	public void setPrimaryKey(long primaryKey) {
		_anhCongDan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this anh cong dan.
	*
	* @return the ID of this anh cong dan
	*/
	public long getId() {
		return _anhCongDan.getId();
	}

	/**
	* Sets the ID of this anh cong dan.
	*
	* @param id the ID of this anh cong dan
	*/
	public void setId(long id) {
		_anhCongDan.setId(id);
	}

	/**
	* Returns the ma of this anh cong dan.
	*
	* @return the ma of this anh cong dan
	*/
	public java.lang.String getMa() {
		return _anhCongDan.getMa();
	}

	/**
	* Sets the ma of this anh cong dan.
	*
	* @param ma the ma of this anh cong dan
	*/
	public void setMa(java.lang.String ma) {
		_anhCongDan.setMa(ma);
	}

	/**
	* Returns the email of this anh cong dan.
	*
	* @return the email of this anh cong dan
	*/
	public java.lang.String getEmail() {
		return _anhCongDan.getEmail();
	}

	/**
	* Sets the email of this anh cong dan.
	*
	* @param email the email of this anh cong dan
	*/
	public void setEmail(java.lang.String email) {
		_anhCongDan.setEmail(email);
	}

	/**
	* Returns the anh of this anh cong dan.
	*
	* @return the anh of this anh cong dan
	*/
	public java.lang.String getAnh() {
		return _anhCongDan.getAnh();
	}

	/**
	* Sets the anh of this anh cong dan.
	*
	* @param anh the anh of this anh cong dan
	*/
	public void setAnh(java.lang.String anh) {
		_anhCongDan.setAnh(anh);
	}

	public boolean isNew() {
		return _anhCongDan.isNew();
	}

	public void setNew(boolean n) {
		_anhCongDan.setNew(n);
	}

	public boolean isCachedModel() {
		return _anhCongDan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_anhCongDan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _anhCongDan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _anhCongDan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anhCongDan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anhCongDan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anhCongDan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnhCongDanWrapper((AnhCongDan)_anhCongDan.clone());
	}

	public int compareTo(org.oep.cmon.anhcongdan.model.AnhCongDan anhCongDan) {
		return _anhCongDan.compareTo(anhCongDan);
	}

	@Override
	public int hashCode() {
		return _anhCongDan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.anhcongdan.model.AnhCongDan> toCacheModel() {
		return _anhCongDan.toCacheModel();
	}

	public org.oep.cmon.anhcongdan.model.AnhCongDan toEscapedModel() {
		return new AnhCongDanWrapper(_anhCongDan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anhCongDan.toString();
	}

	public java.lang.String toXmlString() {
		return _anhCongDan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhCongDan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AnhCongDan getWrappedAnhCongDan() {
		return _anhCongDan;
	}

	public AnhCongDan getWrappedModel() {
		return _anhCongDan;
	}

	public void resetOriginalValues() {
		_anhCongDan.resetOriginalValues();
	}

	private AnhCongDan _anhCongDan;
}