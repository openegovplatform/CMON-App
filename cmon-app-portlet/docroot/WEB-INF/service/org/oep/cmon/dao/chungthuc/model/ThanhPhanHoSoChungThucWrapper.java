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
 * This class is a wrapper for {@link ThanhPhanHoSoChungThuc}.
 * </p>
 *
 * @author    vietho
 * @see       ThanhPhanHoSoChungThuc
 * @generated
 */
public class ThanhPhanHoSoChungThucWrapper implements ThanhPhanHoSoChungThuc,
	ModelWrapper<ThanhPhanHoSoChungThuc> {
	public ThanhPhanHoSoChungThucWrapper(
		ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		_thanhPhanHoSoChungThuc = thanhPhanHoSoChungThuc;
	}

	public Class<?> getModelClass() {
		return ThanhPhanHoSoChungThuc.class;
	}

	public String getModelClassName() {
		return ThanhPhanHoSoChungThuc.class.getName();
	}

	/**
	* Returns the primary key of this thanh phan ho so chung thuc.
	*
	* @return the primary key of this thanh phan ho so chung thuc
	*/
	public long getPrimaryKey() {
		return _thanhPhanHoSoChungThuc.getPrimaryKey();
	}

	/**
	* Sets the primary key of this thanh phan ho so chung thuc.
	*
	* @param primaryKey the primary key of this thanh phan ho so chung thuc
	*/
	public void setPrimaryKey(long primaryKey) {
		_thanhPhanHoSoChungThuc.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the thanh phan ho so ID of this thanh phan ho so chung thuc.
	*
	* @return the thanh phan ho so ID of this thanh phan ho so chung thuc
	*/
	public long getThanhPhanHoSoId() {
		return _thanhPhanHoSoChungThuc.getThanhPhanHoSoId();
	}

	/**
	* Sets the thanh phan ho so ID of this thanh phan ho so chung thuc.
	*
	* @param thanhPhanHoSoId the thanh phan ho so ID of this thanh phan ho so chung thuc
	*/
	public void setThanhPhanHoSoId(long thanhPhanHoSoId) {
		_thanhPhanHoSoChungThuc.setThanhPhanHoSoId(thanhPhanHoSoId);
	}

	/**
	* Returns the tieu de of this thanh phan ho so chung thuc.
	*
	* @return the tieu de of this thanh phan ho so chung thuc
	*/
	public java.lang.String getTieuDe() {
		return _thanhPhanHoSoChungThuc.getTieuDe();
	}

	/**
	* Sets the tieu de of this thanh phan ho so chung thuc.
	*
	* @param tieuDe the tieu de of this thanh phan ho so chung thuc
	*/
	public void setTieuDe(java.lang.String tieuDe) {
		_thanhPhanHoSoChungThuc.setTieuDe(tieuDe);
	}

	/**
	* Returns the mo ta of this thanh phan ho so chung thuc.
	*
	* @return the mo ta of this thanh phan ho so chung thuc
	*/
	public java.lang.String getMoTa() {
		return _thanhPhanHoSoChungThuc.getMoTa();
	}

	/**
	* Sets the mo ta of this thanh phan ho so chung thuc.
	*
	* @param moTa the mo ta of this thanh phan ho so chung thuc
	*/
	public void setMoTa(java.lang.String moTa) {
		_thanhPhanHoSoChungThuc.setMoTa(moTa);
	}

	/**
	* Returns the ho so chung thuc ID of this thanh phan ho so chung thuc.
	*
	* @return the ho so chung thuc ID of this thanh phan ho so chung thuc
	*/
	public java.lang.Long getHoSoChungThucId() {
		return _thanhPhanHoSoChungThuc.getHoSoChungThucId();
	}

	/**
	* Sets the ho so chung thuc ID of this thanh phan ho so chung thuc.
	*
	* @param hoSoChungThucId the ho so chung thuc ID of this thanh phan ho so chung thuc
	*/
	public void setHoSoChungThucId(java.lang.Long hoSoChungThucId) {
		_thanhPhanHoSoChungThuc.setHoSoChungThucId(hoSoChungThucId);
	}

	/**
	* Returns the thu tuc2 giay to ID of this thanh phan ho so chung thuc.
	*
	* @return the thu tuc2 giay to ID of this thanh phan ho so chung thuc
	*/
	public java.lang.Long getThuTuc2GiayToId() {
		return _thanhPhanHoSoChungThuc.getThuTuc2GiayToId();
	}

	/**
	* Sets the thu tuc2 giay to ID of this thanh phan ho so chung thuc.
	*
	* @param thuTuc2GiayToId the thu tuc2 giay to ID of this thanh phan ho so chung thuc
	*/
	public void setThuTuc2GiayToId(java.lang.Long thuTuc2GiayToId) {
		_thanhPhanHoSoChungThuc.setThuTuc2GiayToId(thuTuc2GiayToId);
	}

	/**
	* Returns the noi luu tru ho so dinh kem ID of this thanh phan ho so chung thuc.
	*
	* @return the noi luu tru ho so dinh kem ID of this thanh phan ho so chung thuc
	*/
	public java.lang.Long getNoiLuuTruHoSoDinhKemId() {
		return _thanhPhanHoSoChungThuc.getNoiLuuTruHoSoDinhKemId();
	}

	/**
	* Sets the noi luu tru ho so dinh kem ID of this thanh phan ho so chung thuc.
	*
	* @param noiLuuTruHoSoDinhKemId the noi luu tru ho so dinh kem ID of this thanh phan ho so chung thuc
	*/
	public void setNoiLuuTruHoSoDinhKemId(java.lang.Long noiLuuTruHoSoDinhKemId) {
		_thanhPhanHoSoChungThuc.setNoiLuuTruHoSoDinhKemId(noiLuuTruHoSoDinhKemId);
	}

	public boolean isNew() {
		return _thanhPhanHoSoChungThuc.isNew();
	}

	public void setNew(boolean n) {
		_thanhPhanHoSoChungThuc.setNew(n);
	}

	public boolean isCachedModel() {
		return _thanhPhanHoSoChungThuc.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_thanhPhanHoSoChungThuc.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _thanhPhanHoSoChungThuc.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _thanhPhanHoSoChungThuc.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thanhPhanHoSoChungThuc.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thanhPhanHoSoChungThuc.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thanhPhanHoSoChungThuc.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThanhPhanHoSoChungThucWrapper((ThanhPhanHoSoChungThuc)_thanhPhanHoSoChungThuc.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc thanhPhanHoSoChungThuc) {
		return _thanhPhanHoSoChungThuc.compareTo(thanhPhanHoSoChungThuc);
	}

	@Override
	public int hashCode() {
		return _thanhPhanHoSoChungThuc.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc> toCacheModel() {
		return _thanhPhanHoSoChungThuc.toCacheModel();
	}

	public org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc toEscapedModel() {
		return new ThanhPhanHoSoChungThucWrapper(_thanhPhanHoSoChungThuc.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thanhPhanHoSoChungThuc.toString();
	}

	public java.lang.String toXmlString() {
		return _thanhPhanHoSoChungThuc.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thanhPhanHoSoChungThuc.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ThanhPhanHoSoChungThuc getWrappedThanhPhanHoSoChungThuc() {
		return _thanhPhanHoSoChungThuc;
	}

	public ThanhPhanHoSoChungThuc getWrappedModel() {
		return _thanhPhanHoSoChungThuc;
	}

	public void resetOriginalValues() {
		_thanhPhanHoSoChungThuc.resetOriginalValues();
	}

	private ThanhPhanHoSoChungThuc _thanhPhanHoSoChungThuc;
}