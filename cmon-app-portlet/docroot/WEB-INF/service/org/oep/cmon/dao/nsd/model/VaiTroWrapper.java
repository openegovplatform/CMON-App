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
 * This class is a wrapper for {@link VaiTro}.
 * </p>
 *
 * @author    Liemnn
 * @see       VaiTro
 * @generated
 */
public class VaiTroWrapper implements VaiTro, ModelWrapper<VaiTro> {
	public VaiTroWrapper(VaiTro vaiTro) {
		_vaiTro = vaiTro;
	}

	public Class<?> getModelClass() {
		return VaiTro.class;
	}

	public String getModelClassName() {
		return VaiTro.class.getName();
	}

	/**
	* Returns the primary key of this vai tro.
	*
	* @return the primary key of this vai tro
	*/
	public long getPrimaryKey() {
		return _vaiTro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vai tro.
	*
	* @param primaryKey the primary key of this vai tro
	*/
	public void setPrimaryKey(long primaryKey) {
		_vaiTro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this vai tro.
	*
	* @return the ID of this vai tro
	*/
	public long getId() {
		return _vaiTro.getId();
	}

	/**
	* Sets the ID of this vai tro.
	*
	* @param id the ID of this vai tro
	*/
	public void setId(long id) {
		_vaiTro.setId(id);
	}

	/**
	* Returns the ma of this vai tro.
	*
	* @return the ma of this vai tro
	*/
	public java.lang.String getMa() {
		return _vaiTro.getMa();
	}

	/**
	* Sets the ma of this vai tro.
	*
	* @param ma the ma of this vai tro
	*/
	public void setMa(java.lang.String ma) {
		_vaiTro.setMa(ma);
	}

	/**
	* Returns the ten of this vai tro.
	*
	* @return the ten of this vai tro
	*/
	public java.lang.String getTen() {
		return _vaiTro.getTen();
	}

	/**
	* Sets the ten of this vai tro.
	*
	* @param ten the ten of this vai tro
	*/
	public void setTen(java.lang.String ten) {
		_vaiTro.setTen(ten);
	}

	/**
	* Returns the mo ta of this vai tro.
	*
	* @return the mo ta of this vai tro
	*/
	public java.lang.String getMoTa() {
		return _vaiTro.getMoTa();
	}

	/**
	* Sets the mo ta of this vai tro.
	*
	* @param moTa the mo ta of this vai tro
	*/
	public void setMoTa(java.lang.String moTa) {
		_vaiTro.setMoTa(moTa);
	}

	/**
	* Returns the ngay tao of this vai tro.
	*
	* @return the ngay tao of this vai tro
	*/
	public java.util.Date getNgayTao() {
		return _vaiTro.getNgayTao();
	}

	/**
	* Sets the ngay tao of this vai tro.
	*
	* @param ngayTao the ngay tao of this vai tro
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_vaiTro.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this vai tro.
	*
	* @return the da xoa of this vai tro
	*/
	public int getDaXoa() {
		return _vaiTro.getDaXoa();
	}

	/**
	* Sets the da xoa of this vai tro.
	*
	* @param daXoa the da xoa of this vai tro
	*/
	public void setDaXoa(int daXoa) {
		_vaiTro.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this vai tro.
	*
	* @return the nguoi tao of this vai tro
	*/
	public java.lang.String getNguoiTao() {
		return _vaiTro.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this vai tro.
	*
	* @param nguoiTao the nguoi tao of this vai tro
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_vaiTro.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this vai tro.
	*
	* @return the ngay sua of this vai tro
	*/
	public java.util.Date getNgaySua() {
		return _vaiTro.getNgaySua();
	}

	/**
	* Sets the ngay sua of this vai tro.
	*
	* @param ngaySua the ngay sua of this vai tro
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_vaiTro.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this vai tro.
	*
	* @return the nguoi sua of this vai tro
	*/
	public java.lang.String getNguoiSua() {
		return _vaiTro.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this vai tro.
	*
	* @param nguoiSua the nguoi sua of this vai tro
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_vaiTro.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the trang thai of this vai tro.
	*
	* @return the trang thai of this vai tro
	*/
	public int getTrangThai() {
		return _vaiTro.getTrangThai();
	}

	/**
	* Sets the trang thai of this vai tro.
	*
	* @param trangThai the trang thai of this vai tro
	*/
	public void setTrangThai(int trangThai) {
		_vaiTro.setTrangThai(trangThai);
	}

	/**
	* Returns the ung dung ID of this vai tro.
	*
	* @return the ung dung ID of this vai tro
	*/
	public java.lang.Long getUngDungId() {
		return _vaiTro.getUngDungId();
	}

	/**
	* Sets the ung dung ID of this vai tro.
	*
	* @param ungDungId the ung dung ID of this vai tro
	*/
	public void setUngDungId(java.lang.Long ungDungId) {
		_vaiTro.setUngDungId(ungDungId);
	}

	public boolean isNew() {
		return _vaiTro.isNew();
	}

	public void setNew(boolean n) {
		_vaiTro.setNew(n);
	}

	public boolean isCachedModel() {
		return _vaiTro.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vaiTro.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vaiTro.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vaiTro.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vaiTro.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vaiTro.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vaiTro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VaiTroWrapper((VaiTro)_vaiTro.clone());
	}

	public int compareTo(org.oep.cmon.dao.nsd.model.VaiTro vaiTro) {
		return _vaiTro.compareTo(vaiTro);
	}

	@Override
	public int hashCode() {
		return _vaiTro.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.VaiTro> toCacheModel() {
		return _vaiTro.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.VaiTro toEscapedModel() {
		return new VaiTroWrapper(_vaiTro.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vaiTro.toString();
	}

	public java.lang.String toXmlString() {
		return _vaiTro.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vaiTro.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VaiTro getWrappedVaiTro() {
		return _vaiTro;
	}

	public VaiTro getWrappedModel() {
		return _vaiTro;
	}

	public void resetOriginalValues() {
		_vaiTro.resetOriginalValues();
	}

	private VaiTro _vaiTro;
}