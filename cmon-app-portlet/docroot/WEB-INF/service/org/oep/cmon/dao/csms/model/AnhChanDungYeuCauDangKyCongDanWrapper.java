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

package org.oep.cmon.dao.csms.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link AnhChanDungYeuCauDangKyCongDan}.
 * </p>
 *
 * @author    NAM
 * @see       AnhChanDungYeuCauDangKyCongDan
 * @generated
 */
public class AnhChanDungYeuCauDangKyCongDanWrapper
	implements AnhChanDungYeuCauDangKyCongDan,
		ModelWrapper<AnhChanDungYeuCauDangKyCongDan> {
	public AnhChanDungYeuCauDangKyCongDanWrapper(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		_anhChanDungYeuCauDangKyCongDan = anhChanDungYeuCauDangKyCongDan;
	}

	public Class<?> getModelClass() {
		return AnhChanDungYeuCauDangKyCongDan.class;
	}

	public String getModelClassName() {
		return AnhChanDungYeuCauDangKyCongDan.class.getName();
	}

	/**
	* Returns the primary key of this anh chan dung yeu cau dang ky cong dan.
	*
	* @return the primary key of this anh chan dung yeu cau dang ky cong dan
	*/
	public long getPrimaryKey() {
		return _anhChanDungYeuCauDangKyCongDan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this anh chan dung yeu cau dang ky cong dan.
	*
	* @param primaryKey the primary key of this anh chan dung yeu cau dang ky cong dan
	*/
	public void setPrimaryKey(long primaryKey) {
		_anhChanDungYeuCauDangKyCongDan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this anh chan dung yeu cau dang ky cong dan.
	*
	* @return the ID of this anh chan dung yeu cau dang ky cong dan
	*/
	public long getId() {
		return _anhChanDungYeuCauDangKyCongDan.getId();
	}

	/**
	* Sets the ID of this anh chan dung yeu cau dang ky cong dan.
	*
	* @param id the ID of this anh chan dung yeu cau dang ky cong dan
	*/
	public void setId(long id) {
		_anhChanDungYeuCauDangKyCongDan.setId(id);
	}

	/**
	* Returns the anh chan dung of this anh chan dung yeu cau dang ky cong dan.
	*
	* @return the anh chan dung of this anh chan dung yeu cau dang ky cong dan
	*/
	public java.lang.String getAnhChanDung() {
		return _anhChanDungYeuCauDangKyCongDan.getAnhChanDung();
	}

	/**
	* Sets the anh chan dung of this anh chan dung yeu cau dang ky cong dan.
	*
	* @param AnhChanDung the anh chan dung of this anh chan dung yeu cau dang ky cong dan
	*/
	public void setAnhChanDung(java.lang.String AnhChanDung) {
		_anhChanDungYeuCauDangKyCongDan.setAnhChanDung(AnhChanDung);
	}

	public boolean isNew() {
		return _anhChanDungYeuCauDangKyCongDan.isNew();
	}

	public void setNew(boolean n) {
		_anhChanDungYeuCauDangKyCongDan.setNew(n);
	}

	public boolean isCachedModel() {
		return _anhChanDungYeuCauDangKyCongDan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_anhChanDungYeuCauDangKyCongDan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _anhChanDungYeuCauDangKyCongDan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _anhChanDungYeuCauDangKyCongDan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_anhChanDungYeuCauDangKyCongDan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _anhChanDungYeuCauDangKyCongDan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_anhChanDungYeuCauDangKyCongDan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AnhChanDungYeuCauDangKyCongDanWrapper((AnhChanDungYeuCauDangKyCongDan)_anhChanDungYeuCauDangKyCongDan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		return _anhChanDungYeuCauDangKyCongDan.compareTo(anhChanDungYeuCauDangKyCongDan);
	}

	@Override
	public int hashCode() {
		return _anhChanDungYeuCauDangKyCongDan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan> toCacheModel() {
		return _anhChanDungYeuCauDangKyCongDan.toCacheModel();
	}

	public org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan toEscapedModel() {
		return new AnhChanDungYeuCauDangKyCongDanWrapper(_anhChanDungYeuCauDangKyCongDan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _anhChanDungYeuCauDangKyCongDan.toString();
	}

	public java.lang.String toXmlString() {
		return _anhChanDungYeuCauDangKyCongDan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_anhChanDungYeuCauDangKyCongDan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AnhChanDungYeuCauDangKyCongDan getWrappedAnhChanDungYeuCauDangKyCongDan() {
		return _anhChanDungYeuCauDangKyCongDan;
	}

	public AnhChanDungYeuCauDangKyCongDan getWrappedModel() {
		return _anhChanDungYeuCauDangKyCongDan;
	}

	public void resetOriginalValues() {
		_anhChanDungYeuCauDangKyCongDan.resetOriginalValues();
	}

	private AnhChanDungYeuCauDangKyCongDan _anhChanDungYeuCauDangKyCongDan;
}