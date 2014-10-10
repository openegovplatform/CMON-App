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

package org.oep.cmon.dao.kios.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhSachCoQuan}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhSachCoQuan
 * @generated
 */
public class DanhSachCoQuanWrapper implements DanhSachCoQuan,
	ModelWrapper<DanhSachCoQuan> {
	public DanhSachCoQuanWrapper(DanhSachCoQuan danhSachCoQuan) {
		_danhSachCoQuan = danhSachCoQuan;
	}

	public Class<?> getModelClass() {
		return DanhSachCoQuan.class;
	}

	public String getModelClassName() {
		return DanhSachCoQuan.class.getName();
	}

	/**
	* Returns the primary key of this danh sach co quan.
	*
	* @return the primary key of this danh sach co quan
	*/
	public long getPrimaryKey() {
		return _danhSachCoQuan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh sach co quan.
	*
	* @param primaryKey the primary key of this danh sach co quan
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhSachCoQuan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this danh sach co quan.
	*
	* @return the ID of this danh sach co quan
	*/
	public long getId() {
		return _danhSachCoQuan.getId();
	}

	/**
	* Sets the ID of this danh sach co quan.
	*
	* @param id the ID of this danh sach co quan
	*/
	public void setId(long id) {
		_danhSachCoQuan.setId(id);
	}

	/**
	* Returns the ten of this danh sach co quan.
	*
	* @return the ten of this danh sach co quan
	*/
	public java.lang.String getTen() {
		return _danhSachCoQuan.getTen();
	}

	/**
	* Sets the ten of this danh sach co quan.
	*
	* @param ten the ten of this danh sach co quan
	*/
	public void setTen(java.lang.String ten) {
		_danhSachCoQuan.setTen(ten);
	}

	/**
	* Returns the cha ID of this danh sach co quan.
	*
	* @return the cha ID of this danh sach co quan
	*/
	public java.lang.Long getChaId() {
		return _danhSachCoQuan.getChaId();
	}

	/**
	* Sets the cha ID of this danh sach co quan.
	*
	* @param chaId the cha ID of this danh sach co quan
	*/
	public void setChaId(java.lang.Long chaId) {
		_danhSachCoQuan.setChaId(chaId);
	}

	/**
	* Returns the ten cap co quan quanly of this danh sach co quan.
	*
	* @return the ten cap co quan quanly of this danh sach co quan
	*/
	public java.lang.String getTenCapCoQuanQuanly() {
		return _danhSachCoQuan.getTenCapCoQuanQuanly();
	}

	/**
	* Sets the ten cap co quan quanly of this danh sach co quan.
	*
	* @param tenCapCoQuanQuanly the ten cap co quan quanly of this danh sach co quan
	*/
	public void setTenCapCoQuanQuanly(java.lang.String tenCapCoQuanQuanly) {
		_danhSachCoQuan.setTenCapCoQuanQuanly(tenCapCoQuanQuanly);
	}

	/**
	* Returns the cap co quan quan ly ID of this danh sach co quan.
	*
	* @return the cap co quan quan ly ID of this danh sach co quan
	*/
	public java.lang.Long getCapCoQuanQuanLyId() {
		return _danhSachCoQuan.getCapCoQuanQuanLyId();
	}

	/**
	* Sets the cap co quan quan ly ID of this danh sach co quan.
	*
	* @param capCoQuanQuanLyId the cap co quan quan ly ID of this danh sach co quan
	*/
	public void setCapCoQuanQuanLyId(java.lang.Long capCoQuanQuanLyId) {
		_danhSachCoQuan.setCapCoQuanQuanLyId(capCoQuanQuanLyId);
	}

	public boolean isNew() {
		return _danhSachCoQuan.isNew();
	}

	public void setNew(boolean n) {
		_danhSachCoQuan.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhSachCoQuan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhSachCoQuan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhSachCoQuan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhSachCoQuan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhSachCoQuan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhSachCoQuan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhSachCoQuan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhSachCoQuanWrapper((DanhSachCoQuan)_danhSachCoQuan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.kios.model.DanhSachCoQuan danhSachCoQuan) {
		return _danhSachCoQuan.compareTo(danhSachCoQuan);
	}

	@Override
	public int hashCode() {
		return _danhSachCoQuan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.kios.model.DanhSachCoQuan> toCacheModel() {
		return _danhSachCoQuan.toCacheModel();
	}

	public org.oep.cmon.dao.kios.model.DanhSachCoQuan toEscapedModel() {
		return new DanhSachCoQuanWrapper(_danhSachCoQuan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhSachCoQuan.toString();
	}

	public java.lang.String toXmlString() {
		return _danhSachCoQuan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhSachCoQuan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhSachCoQuan getWrappedDanhSachCoQuan() {
		return _danhSachCoQuan;
	}

	public DanhSachCoQuan getWrappedModel() {
		return _danhSachCoQuan;
	}

	public void resetOriginalValues() {
		_danhSachCoQuan.resetOriginalValues();
	}

	private DanhSachCoQuan _danhSachCoQuan;
}