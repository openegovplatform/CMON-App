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

package org.oep.cmon.dao.nsd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NhomNguoiDung}.
 * </p>
 *
 * @author    Liemnn
 * @see       NhomNguoiDung
 * @generated
 */
public class NhomNguoiDungWrapper implements NhomNguoiDung,
	ModelWrapper<NhomNguoiDung> {
	public NhomNguoiDungWrapper(NhomNguoiDung nhomNguoiDung) {
		_nhomNguoiDung = nhomNguoiDung;
	}

	public Class<?> getModelClass() {
		return NhomNguoiDung.class;
	}

	public String getModelClassName() {
		return NhomNguoiDung.class.getName();
	}

	/**
	* Returns the primary key of this nhom nguoi dung.
	*
	* @return the primary key of this nhom nguoi dung
	*/
	public long getPrimaryKey() {
		return _nhomNguoiDung.getPrimaryKey();
	}

	/**
	* Sets the primary key of this nhom nguoi dung.
	*
	* @param primaryKey the primary key of this nhom nguoi dung
	*/
	public void setPrimaryKey(long primaryKey) {
		_nhomNguoiDung.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this nhom nguoi dung.
	*
	* @return the ID of this nhom nguoi dung
	*/
	public long getId() {
		return _nhomNguoiDung.getId();
	}

	/**
	* Sets the ID of this nhom nguoi dung.
	*
	* @param id the ID of this nhom nguoi dung
	*/
	public void setId(long id) {
		_nhomNguoiDung.setId(id);
	}

	/**
	* Returns the ten of this nhom nguoi dung.
	*
	* @return the ten of this nhom nguoi dung
	*/
	public java.lang.String getTen() {
		return _nhomNguoiDung.getTen();
	}

	/**
	* Sets the ten of this nhom nguoi dung.
	*
	* @param ten the ten of this nhom nguoi dung
	*/
	public void setTen(java.lang.String ten) {
		_nhomNguoiDung.setTen(ten);
	}

	/**
	* Returns the mo ta of this nhom nguoi dung.
	*
	* @return the mo ta of this nhom nguoi dung
	*/
	public java.lang.String getMoTa() {
		return _nhomNguoiDung.getMoTa();
	}

	/**
	* Sets the mo ta of this nhom nguoi dung.
	*
	* @param moTa the mo ta of this nhom nguoi dung
	*/
	public void setMoTa(java.lang.String moTa) {
		_nhomNguoiDung.setMoTa(moTa);
	}

	/**
	* Returns the ngay tao of this nhom nguoi dung.
	*
	* @return the ngay tao of this nhom nguoi dung
	*/
	public java.util.Date getNgayTao() {
		return _nhomNguoiDung.getNgayTao();
	}

	/**
	* Sets the ngay tao of this nhom nguoi dung.
	*
	* @param ngayTao the ngay tao of this nhom nguoi dung
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_nhomNguoiDung.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this nhom nguoi dung.
	*
	* @return the da xoa of this nhom nguoi dung
	*/
	public int getDaXoa() {
		return _nhomNguoiDung.getDaXoa();
	}

	/**
	* Sets the da xoa of this nhom nguoi dung.
	*
	* @param daXoa the da xoa of this nhom nguoi dung
	*/
	public void setDaXoa(int daXoa) {
		_nhomNguoiDung.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this nhom nguoi dung.
	*
	* @return the ngay sua of this nhom nguoi dung
	*/
	public java.util.Date getNgaySua() {
		return _nhomNguoiDung.getNgaySua();
	}

	/**
	* Sets the ngay sua of this nhom nguoi dung.
	*
	* @param ngaySua the ngay sua of this nhom nguoi dung
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_nhomNguoiDung.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this nhom nguoi dung.
	*
	* @return the nguoi tao of this nhom nguoi dung
	*/
	public java.lang.String getNguoiTao() {
		return _nhomNguoiDung.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this nhom nguoi dung.
	*
	* @param nguoiTao the nguoi tao of this nhom nguoi dung
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_nhomNguoiDung.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this nhom nguoi dung.
	*
	* @return the nguoi sua of this nhom nguoi dung
	*/
	public java.lang.String getNguoiSua() {
		return _nhomNguoiDung.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this nhom nguoi dung.
	*
	* @param nguoiSua the nguoi sua of this nhom nguoi dung
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_nhomNguoiDung.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the trang thai of this nhom nguoi dung.
	*
	* @return the trang thai of this nhom nguoi dung
	*/
	public int getTrangThai() {
		return _nhomNguoiDung.getTrangThai();
	}

	/**
	* Sets the trang thai of this nhom nguoi dung.
	*
	* @param trangThai the trang thai of this nhom nguoi dung
	*/
	public void setTrangThai(int trangThai) {
		_nhomNguoiDung.setTrangThai(trangThai);
	}

	public boolean isNew() {
		return _nhomNguoiDung.isNew();
	}

	public void setNew(boolean n) {
		_nhomNguoiDung.setNew(n);
	}

	public boolean isCachedModel() {
		return _nhomNguoiDung.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_nhomNguoiDung.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _nhomNguoiDung.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _nhomNguoiDung.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nhomNguoiDung.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nhomNguoiDung.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nhomNguoiDung.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NhomNguoiDungWrapper((NhomNguoiDung)_nhomNguoiDung.clone());
	}

	public int compareTo(org.oep.cmon.dao.nsd.model.NhomNguoiDung nhomNguoiDung) {
		return _nhomNguoiDung.compareTo(nhomNguoiDung);
	}

	@Override
	public int hashCode() {
		return _nhomNguoiDung.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.NhomNguoiDung> toCacheModel() {
		return _nhomNguoiDung.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.NhomNguoiDung toEscapedModel() {
		return new NhomNguoiDungWrapper(_nhomNguoiDung.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nhomNguoiDung.toString();
	}

	public java.lang.String toXmlString() {
		return _nhomNguoiDung.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nhomNguoiDung.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NhomNguoiDung getWrappedNhomNguoiDung() {
		return _nhomNguoiDung;
	}

	public NhomNguoiDung getWrappedModel() {
		return _nhomNguoiDung;
	}

	public void resetOriginalValues() {
		_nhomNguoiDung.resetOriginalValues();
	}

	private NhomNguoiDung _nhomNguoiDung;
}