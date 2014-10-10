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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoAnhXa}.
 * </p>
 *
 * @author    LIEMNn
 * @see       HoSoAnhXa
 * @generated
 */
public class HoSoAnhXaWrapper implements HoSoAnhXa, ModelWrapper<HoSoAnhXa> {
	public HoSoAnhXaWrapper(HoSoAnhXa hoSoAnhXa) {
		_hoSoAnhXa = hoSoAnhXa;
	}

	public Class<?> getModelClass() {
		return HoSoAnhXa.class;
	}

	public String getModelClassName() {
		return HoSoAnhXa.class.getName();
	}

	/**
	* Returns the primary key of this ho so anh xa.
	*
	* @return the primary key of this ho so anh xa
	*/
	public long getPrimaryKey() {
		return _hoSoAnhXa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so anh xa.
	*
	* @param primaryKey the primary key of this ho so anh xa
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoAnhXa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho so anh xa.
	*
	* @return the ID of this ho so anh xa
	*/
	public long getId() {
		return _hoSoAnhXa.getId();
	}

	/**
	* Sets the ID of this ho so anh xa.
	*
	* @param id the ID of this ho so anh xa
	*/
	public void setId(long id) {
		_hoSoAnhXa.setId(id);
	}

	/**
	* Returns the ho so t t h c cong ID of this ho so anh xa.
	*
	* @return the ho so t t h c cong ID of this ho so anh xa
	*/
	public long getHoSoTTHCCongId() {
		return _hoSoAnhXa.getHoSoTTHCCongId();
	}

	/**
	* Sets the ho so t t h c cong ID of this ho so anh xa.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID of this ho so anh xa
	*/
	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoAnhXa.setHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the ma ho so of this ho so anh xa.
	*
	* @return the ma ho so of this ho so anh xa
	*/
	public java.lang.String getMaHoSo() {
		return _hoSoAnhXa.getMaHoSo();
	}

	/**
	* Sets the ma ho so of this ho so anh xa.
	*
	* @param maHoSo the ma ho so of this ho so anh xa
	*/
	public void setMaHoSo(java.lang.String maHoSo) {
		_hoSoAnhXa.setMaHoSo(maHoSo);
	}

	/**
	* Returns the trang thai of this ho so anh xa.
	*
	* @return the trang thai of this ho so anh xa
	*/
	public int getTrangThai() {
		return _hoSoAnhXa.getTrangThai();
	}

	/**
	* Sets the trang thai of this ho so anh xa.
	*
	* @param trangThai the trang thai of this ho so anh xa
	*/
	public void setTrangThai(int trangThai) {
		_hoSoAnhXa.setTrangThai(trangThai);
	}

	/**
	* Returns the ngay sua of this ho so anh xa.
	*
	* @return the ngay sua of this ho so anh xa
	*/
	public java.util.Date getNgaySua() {
		return _hoSoAnhXa.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ho so anh xa.
	*
	* @param ngaySua the ngay sua of this ho so anh xa
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hoSoAnhXa.setNgaySua(ngaySua);
	}

	/**
	* Returns the ngay tao of this ho so anh xa.
	*
	* @return the ngay tao of this ho so anh xa
	*/
	public java.util.Date getNgayTao() {
		return _hoSoAnhXa.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ho so anh xa.
	*
	* @param ngayTao the ngay tao of this ho so anh xa
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hoSoAnhXa.setNgayTao(ngayTao);
	}

	public boolean isNew() {
		return _hoSoAnhXa.isNew();
	}

	public void setNew(boolean n) {
		_hoSoAnhXa.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoAnhXa.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoAnhXa.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoAnhXa.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoAnhXa.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoAnhXa.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoAnhXa.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoAnhXa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoAnhXaWrapper((HoSoAnhXa)_hoSoAnhXa.clone());
	}

	public int compareTo(org.oep.cmon.dao.hosohcc.model.HoSoAnhXa hoSoAnhXa) {
		return _hoSoAnhXa.compareTo(hoSoAnhXa);
	}

	@Override
	public int hashCode() {
		return _hoSoAnhXa.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosohcc.model.HoSoAnhXa> toCacheModel() {
		return _hoSoAnhXa.toCacheModel();
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoAnhXa toEscapedModel() {
		return new HoSoAnhXaWrapper(_hoSoAnhXa.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoAnhXa.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoAnhXa.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoAnhXa.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoAnhXa getWrappedHoSoAnhXa() {
		return _hoSoAnhXa;
	}

	public HoSoAnhXa getWrappedModel() {
		return _hoSoAnhXa;
	}

	public void resetOriginalValues() {
		_hoSoAnhXa.resetOriginalValues();
	}

	private HoSoAnhXa _hoSoAnhXa;
}