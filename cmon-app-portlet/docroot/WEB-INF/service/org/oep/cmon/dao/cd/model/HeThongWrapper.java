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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HeThong}.
 * </p>
 *
 * @author    LIEMNN
 * @see       HeThong
 * @generated
 */
public class HeThongWrapper implements HeThong, ModelWrapper<HeThong> {
	public HeThongWrapper(HeThong heThong) {
		_heThong = heThong;
	}

	public Class<?> getModelClass() {
		return HeThong.class;
	}

	public String getModelClassName() {
		return HeThong.class.getName();
	}

	/**
	* Returns the primary key of this he thong.
	*
	* @return the primary key of this he thong
	*/
	public long getPrimaryKey() {
		return _heThong.getPrimaryKey();
	}

	/**
	* Sets the primary key of this he thong.
	*
	* @param primaryKey the primary key of this he thong
	*/
	public void setPrimaryKey(long primaryKey) {
		_heThong.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this he thong.
	*
	* @return the ID of this he thong
	*/
	public long getId() {
		return _heThong.getId();
	}

	/**
	* Sets the ID of this he thong.
	*
	* @param id the ID of this he thong
	*/
	public void setId(long id) {
		_heThong.setId(id);
	}

	/**
	* Returns the ma of this he thong.
	*
	* @return the ma of this he thong
	*/
	public java.lang.String getMa() {
		return _heThong.getMa();
	}

	/**
	* Sets the ma of this he thong.
	*
	* @param ma the ma of this he thong
	*/
	public void setMa(java.lang.String ma) {
		_heThong.setMa(ma);
	}

	/**
	* Returns the ten of this he thong.
	*
	* @return the ten of this he thong
	*/
	public java.lang.String getTen() {
		return _heThong.getTen();
	}

	/**
	* Sets the ten of this he thong.
	*
	* @param ten the ten of this he thong
	*/
	public void setTen(java.lang.String ten) {
		_heThong.setTen(ten);
	}

	/**
	* Returns the mo ta of this he thong.
	*
	* @return the mo ta of this he thong
	*/
	public java.lang.String getMoTa() {
		return _heThong.getMoTa();
	}

	/**
	* Sets the mo ta of this he thong.
	*
	* @param moTa the mo ta of this he thong
	*/
	public void setMoTa(java.lang.String moTa) {
		_heThong.setMoTa(moTa);
	}

	/**
	* Returns the ngay tao of this he thong.
	*
	* @return the ngay tao of this he thong
	*/
	public java.util.Date getNgayTao() {
		return _heThong.getNgayTao();
	}

	/**
	* Sets the ngay tao of this he thong.
	*
	* @param ngayTao the ngay tao of this he thong
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_heThong.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this he thong.
	*
	* @return the da xoa of this he thong
	*/
	public int getDaXoa() {
		return _heThong.getDaXoa();
	}

	/**
	* Sets the da xoa of this he thong.
	*
	* @param daXoa the da xoa of this he thong
	*/
	public void setDaXoa(int daXoa) {
		_heThong.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this he thong.
	*
	* @return the nguoi tao of this he thong
	*/
	public java.lang.String getNguoiTao() {
		return _heThong.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this he thong.
	*
	* @param nguoiTao the nguoi tao of this he thong
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_heThong.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this he thong.
	*
	* @return the nguoi sua of this he thong
	*/
	public java.lang.String getNguoiSua() {
		return _heThong.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this he thong.
	*
	* @param nguoiSua the nguoi sua of this he thong
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_heThong.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this he thong.
	*
	* @return the ngay sua of this he thong
	*/
	public java.util.Date getNgaySua() {
		return _heThong.getNgaySua();
	}

	/**
	* Sets the ngay sua of this he thong.
	*
	* @param ngaySua the ngay sua of this he thong
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_heThong.setNgaySua(ngaySua);
	}

	/**
	* Returns the trang thai of this he thong.
	*
	* @return the trang thai of this he thong
	*/
	public int getTrangThai() {
		return _heThong.getTrangThai();
	}

	/**
	* Sets the trang thai of this he thong.
	*
	* @param trangThai the trang thai of this he thong
	*/
	public void setTrangThai(int trangThai) {
		_heThong.setTrangThai(trangThai);
	}

	public boolean isNew() {
		return _heThong.isNew();
	}

	public void setNew(boolean n) {
		_heThong.setNew(n);
	}

	public boolean isCachedModel() {
		return _heThong.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_heThong.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _heThong.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _heThong.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_heThong.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _heThong.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_heThong.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeThongWrapper((HeThong)_heThong.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.HeThong heThong) {
		return _heThong.compareTo(heThong);
	}

	@Override
	public int hashCode() {
		return _heThong.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.HeThong> toCacheModel() {
		return _heThong.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.HeThong toEscapedModel() {
		return new HeThongWrapper(_heThong.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _heThong.toString();
	}

	public java.lang.String toXmlString() {
		return _heThong.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_heThong.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HeThong getWrappedHeThong() {
		return _heThong;
	}

	public HeThong getWrappedModel() {
		return _heThong;
	}

	public void resetOriginalValues() {
		_heThong.resetOriginalValues();
	}

	private HeThong _heThong;
}