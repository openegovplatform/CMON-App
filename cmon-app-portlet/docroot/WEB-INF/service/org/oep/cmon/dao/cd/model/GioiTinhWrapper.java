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
 * This class is a wrapper for {@link GioiTinh}.
 * </p>
 *
 * @author    LIEMNN
 * @see       GioiTinh
 * @generated
 */
public class GioiTinhWrapper implements GioiTinh, ModelWrapper<GioiTinh> {
	public GioiTinhWrapper(GioiTinh gioiTinh) {
		_gioiTinh = gioiTinh;
	}

	public Class<?> getModelClass() {
		return GioiTinh.class;
	}

	public String getModelClassName() {
		return GioiTinh.class.getName();
	}

	/**
	* Returns the primary key of this gioi tinh.
	*
	* @return the primary key of this gioi tinh
	*/
	public long getPrimaryKey() {
		return _gioiTinh.getPrimaryKey();
	}

	/**
	* Sets the primary key of this gioi tinh.
	*
	* @param primaryKey the primary key of this gioi tinh
	*/
	public void setPrimaryKey(long primaryKey) {
		_gioiTinh.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this gioi tinh.
	*
	* @return the ID of this gioi tinh
	*/
	public long getId() {
		return _gioiTinh.getId();
	}

	/**
	* Sets the ID of this gioi tinh.
	*
	* @param id the ID of this gioi tinh
	*/
	public void setId(long id) {
		_gioiTinh.setId(id);
	}

	/**
	* Returns the ten of this gioi tinh.
	*
	* @return the ten of this gioi tinh
	*/
	public java.lang.String getTen() {
		return _gioiTinh.getTen();
	}

	/**
	* Sets the ten of this gioi tinh.
	*
	* @param ten the ten of this gioi tinh
	*/
	public void setTen(java.lang.String ten) {
		_gioiTinh.setTen(ten);
	}

	/**
	* Returns the ma of this gioi tinh.
	*
	* @return the ma of this gioi tinh
	*/
	public java.lang.String getMa() {
		return _gioiTinh.getMa();
	}

	/**
	* Sets the ma of this gioi tinh.
	*
	* @param ma the ma of this gioi tinh
	*/
	public void setMa(java.lang.String ma) {
		_gioiTinh.setMa(ma);
	}

	/**
	* Returns the ngay tao of this gioi tinh.
	*
	* @return the ngay tao of this gioi tinh
	*/
	public java.util.Date getNgayTao() {
		return _gioiTinh.getNgayTao();
	}

	/**
	* Sets the ngay tao of this gioi tinh.
	*
	* @param ngayTao the ngay tao of this gioi tinh
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_gioiTinh.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this gioi tinh.
	*
	* @return the nguoi tao of this gioi tinh
	*/
	public java.lang.String getNguoiTao() {
		return _gioiTinh.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this gioi tinh.
	*
	* @param nguoiTao the nguoi tao of this gioi tinh
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_gioiTinh.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this gioi tinh.
	*
	* @return the ngay sua of this gioi tinh
	*/
	public java.util.Date getNgaySua() {
		return _gioiTinh.getNgaySua();
	}

	/**
	* Sets the ngay sua of this gioi tinh.
	*
	* @param ngaySua the ngay sua of this gioi tinh
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_gioiTinh.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this gioi tinh.
	*
	* @return the nguoi sua of this gioi tinh
	*/
	public java.lang.String getNguoiSua() {
		return _gioiTinh.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this gioi tinh.
	*
	* @param nguoiSua the nguoi sua of this gioi tinh
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_gioiTinh.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this gioi tinh.
	*
	* @return the da xoa of this gioi tinh
	*/
	public int getDaXoa() {
		return _gioiTinh.getDaXoa();
	}

	/**
	* Sets the da xoa of this gioi tinh.
	*
	* @param daXoa the da xoa of this gioi tinh
	*/
	public void setDaXoa(int daXoa) {
		_gioiTinh.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _gioiTinh.isNew();
	}

	public void setNew(boolean n) {
		_gioiTinh.setNew(n);
	}

	public boolean isCachedModel() {
		return _gioiTinh.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_gioiTinh.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _gioiTinh.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _gioiTinh.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gioiTinh.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gioiTinh.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gioiTinh.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GioiTinhWrapper((GioiTinh)_gioiTinh.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.GioiTinh gioiTinh) {
		return _gioiTinh.compareTo(gioiTinh);
	}

	@Override
	public int hashCode() {
		return _gioiTinh.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.GioiTinh> toCacheModel() {
		return _gioiTinh.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.GioiTinh toEscapedModel() {
		return new GioiTinhWrapper(_gioiTinh.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gioiTinh.toString();
	}

	public java.lang.String toXmlString() {
		return _gioiTinh.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gioiTinh.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public GioiTinh getWrappedGioiTinh() {
		return _gioiTinh;
	}

	public GioiTinh getWrappedModel() {
		return _gioiTinh;
	}

	public void resetOriginalValues() {
		_gioiTinh.resetOriginalValues();
	}

	private GioiTinh _gioiTinh;
}