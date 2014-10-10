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

package org.oep.cmon.dao.chungthuc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SoDanhMuc}.
 * </p>
 *
 * @author    vietho
 * @see       SoDanhMuc
 * @generated
 */
public class SoDanhMucWrapper implements SoDanhMuc, ModelWrapper<SoDanhMuc> {
	public SoDanhMucWrapper(SoDanhMuc soDanhMuc) {
		_soDanhMuc = soDanhMuc;
	}

	public Class<?> getModelClass() {
		return SoDanhMuc.class;
	}

	public String getModelClassName() {
		return SoDanhMuc.class.getName();
	}

	/**
	* Returns the primary key of this so danh muc.
	*
	* @return the primary key of this so danh muc
	*/
	public long getPrimaryKey() {
		return _soDanhMuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this so danh muc.
	*
	* @param primaryKey the primary key of this so danh muc
	*/
	public void setPrimaryKey(long primaryKey) {
		_soDanhMuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this so danh muc.
	*
	* @return the ID of this so danh muc
	*/
	public long getId() {
		return _soDanhMuc.getId();
	}

	/**
	* Sets the ID of this so danh muc.
	*
	* @param id the ID of this so danh muc
	*/
	public void setId(long id) {
		_soDanhMuc.setId(id);
	}

	/**
	* Returns the ten so of this so danh muc.
	*
	* @return the ten so of this so danh muc
	*/
	public java.lang.String getTenSo() {
		return _soDanhMuc.getTenSo();
	}

	/**
	* Sets the ten so of this so danh muc.
	*
	* @param tenSo the ten so of this so danh muc
	*/
	public void setTenSo(java.lang.String tenSo) {
		_soDanhMuc.setTenSo(tenSo);
	}

	/**
	* Returns the so so of this so danh muc.
	*
	* @return the so so of this so danh muc
	*/
	public java.lang.String getSoSo() {
		return _soDanhMuc.getSoSo();
	}

	/**
	* Sets the so so of this so danh muc.
	*
	* @param soSo the so so of this so danh muc
	*/
	public void setSoSo(java.lang.String soSo) {
		_soDanhMuc.setSoSo(soSo);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this so danh muc.
	*
	* @return the thu tuc hanh chinh ID of this so danh muc
	*/
	public java.lang.Long getThuTucHanhChinhId() {
		return _soDanhMuc.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this so danh muc.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this so danh muc
	*/
	public void setThuTucHanhChinhId(java.lang.Long thuTucHanhChinhId) {
		_soDanhMuc.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the nam of this so danh muc.
	*
	* @return the nam of this so danh muc
	*/
	public java.lang.Long getNam() {
		return _soDanhMuc.getNam();
	}

	/**
	* Sets the nam of this so danh muc.
	*
	* @param nam the nam of this so danh muc
	*/
	public void setNam(java.lang.Long nam) {
		_soDanhMuc.setNam(nam);
	}

	/**
	* Returns the theo quyet dinh of this so danh muc.
	*
	* @return the theo quyet dinh of this so danh muc
	*/
	public java.lang.String getTheoQuyetDinh() {
		return _soDanhMuc.getTheoQuyetDinh();
	}

	/**
	* Sets the theo quyet dinh of this so danh muc.
	*
	* @param theoQuyetDinh the theo quyet dinh of this so danh muc
	*/
	public void setTheoQuyetDinh(java.lang.String theoQuyetDinh) {
		_soDanhMuc.setTheoQuyetDinh(theoQuyetDinh);
	}

	/**
	* Returns the co quan quan li ID of this so danh muc.
	*
	* @return the co quan quan li ID of this so danh muc
	*/
	public java.lang.Long getCoQuanQuanLiId() {
		return _soDanhMuc.getCoQuanQuanLiId();
	}

	/**
	* Sets the co quan quan li ID of this so danh muc.
	*
	* @param coQuanQuanLiId the co quan quan li ID of this so danh muc
	*/
	public void setCoQuanQuanLiId(java.lang.Long coQuanQuanLiId) {
		_soDanhMuc.setCoQuanQuanLiId(coQuanQuanLiId);
	}

	public boolean isNew() {
		return _soDanhMuc.isNew();
	}

	public void setNew(boolean n) {
		_soDanhMuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _soDanhMuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_soDanhMuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _soDanhMuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _soDanhMuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_soDanhMuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _soDanhMuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_soDanhMuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SoDanhMucWrapper((SoDanhMuc)_soDanhMuc.clone());
	}

	public int compareTo(org.oep.cmon.dao.chungthuc.model.SoDanhMuc soDanhMuc) {
		return _soDanhMuc.compareTo(soDanhMuc);
	}

	@Override
	public int hashCode() {
		return _soDanhMuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.chungthuc.model.SoDanhMuc> toCacheModel() {
		return _soDanhMuc.toCacheModel();
	}

	public org.oep.cmon.dao.chungthuc.model.SoDanhMuc toEscapedModel() {
		return new SoDanhMucWrapper(_soDanhMuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _soDanhMuc.toString();
	}

	public java.lang.String toXmlString() {
		return _soDanhMuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_soDanhMuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SoDanhMuc getWrappedSoDanhMuc() {
		return _soDanhMuc;
	}

	public SoDanhMuc getWrappedModel() {
		return _soDanhMuc;
	}

	public void resetOriginalValues() {
		_soDanhMuc.resetOriginalValues();
	}

	private SoDanhMuc _soDanhMuc;
}