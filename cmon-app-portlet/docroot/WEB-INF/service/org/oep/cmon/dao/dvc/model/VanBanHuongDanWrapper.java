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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VanBanHuongDan}.
 * </p>
 *
 * @author    liemnn
 * @see       VanBanHuongDan
 * @generated
 */
public class VanBanHuongDanWrapper implements VanBanHuongDan,
	ModelWrapper<VanBanHuongDan> {
	public VanBanHuongDanWrapper(VanBanHuongDan vanBanHuongDan) {
		_vanBanHuongDan = vanBanHuongDan;
	}

	public Class<?> getModelClass() {
		return VanBanHuongDan.class;
	}

	public String getModelClassName() {
		return VanBanHuongDan.class.getName();
	}

	/**
	* Returns the primary key of this van ban huong dan.
	*
	* @return the primary key of this van ban huong dan
	*/
	public long getPrimaryKey() {
		return _vanBanHuongDan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this van ban huong dan.
	*
	* @param primaryKey the primary key of this van ban huong dan
	*/
	public void setPrimaryKey(long primaryKey) {
		_vanBanHuongDan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this van ban huong dan.
	*
	* @return the ID of this van ban huong dan
	*/
	public long getId() {
		return _vanBanHuongDan.getId();
	}

	/**
	* Sets the ID of this van ban huong dan.
	*
	* @param id the ID of this van ban huong dan
	*/
	public void setId(long id) {
		_vanBanHuongDan.setId(id);
	}

	/**
	* Returns the noi luu tru ID of this van ban huong dan.
	*
	* @return the noi luu tru ID of this van ban huong dan
	*/
	public long getNoiLuuTruId() {
		return _vanBanHuongDan.getNoiLuuTruId();
	}

	/**
	* Sets the noi luu tru ID of this van ban huong dan.
	*
	* @param noiLuuTruId the noi luu tru ID of this van ban huong dan
	*/
	public void setNoiLuuTruId(long noiLuuTruId) {
		_vanBanHuongDan.setNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the ten tai lieu of this van ban huong dan.
	*
	* @return the ten tai lieu of this van ban huong dan
	*/
	public java.lang.String getTenTaiLieu() {
		return _vanBanHuongDan.getTenTaiLieu();
	}

	/**
	* Sets the ten tai lieu of this van ban huong dan.
	*
	* @param tenTaiLieu the ten tai lieu of this van ban huong dan
	*/
	public void setTenTaiLieu(java.lang.String tenTaiLieu) {
		_vanBanHuongDan.setTenTaiLieu(tenTaiLieu);
	}

	/**
	* Returns the mo ta of this van ban huong dan.
	*
	* @return the mo ta of this van ban huong dan
	*/
	public java.lang.String getMoTa() {
		return _vanBanHuongDan.getMoTa();
	}

	/**
	* Sets the mo ta of this van ban huong dan.
	*
	* @param moTa the mo ta of this van ban huong dan
	*/
	public void setMoTa(java.lang.String moTa) {
		_vanBanHuongDan.setMoTa(moTa);
	}

	/**
	* Returns the loai tai lieu of this van ban huong dan.
	*
	* @return the loai tai lieu of this van ban huong dan
	*/
	public long getLoaiTaiLieu() {
		return _vanBanHuongDan.getLoaiTaiLieu();
	}

	/**
	* Sets the loai tai lieu of this van ban huong dan.
	*
	* @param loaiTaiLieu the loai tai lieu of this van ban huong dan
	*/
	public void setLoaiTaiLieu(long loaiTaiLieu) {
		_vanBanHuongDan.setLoaiTaiLieu(loaiTaiLieu);
	}

	/**
	* Returns the ngay tao of this van ban huong dan.
	*
	* @return the ngay tao of this van ban huong dan
	*/
	public java.util.Date getNgayTao() {
		return _vanBanHuongDan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this van ban huong dan.
	*
	* @param ngayTao the ngay tao of this van ban huong dan
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_vanBanHuongDan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this van ban huong dan.
	*
	* @return the ngay sua of this van ban huong dan
	*/
	public java.util.Date getNgaySua() {
		return _vanBanHuongDan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this van ban huong dan.
	*
	* @param ngaySua the ngay sua of this van ban huong dan
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_vanBanHuongDan.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this van ban huong dan.
	*
	* @return the da xoa of this van ban huong dan
	*/
	public int getDaXoa() {
		return _vanBanHuongDan.getDaXoa();
	}

	/**
	* Sets the da xoa of this van ban huong dan.
	*
	* @param daXoa the da xoa of this van ban huong dan
	*/
	public void setDaXoa(int daXoa) {
		_vanBanHuongDan.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this van ban huong dan.
	*
	* @return the nguoi tao of this van ban huong dan
	*/
	public java.lang.String getNguoiTao() {
		return _vanBanHuongDan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this van ban huong dan.
	*
	* @param nguoiTao the nguoi tao of this van ban huong dan
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_vanBanHuongDan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this van ban huong dan.
	*
	* @return the nguoi sua of this van ban huong dan
	*/
	public java.lang.String getNguoiSua() {
		return _vanBanHuongDan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this van ban huong dan.
	*
	* @param nguoiSua the nguoi sua of this van ban huong dan
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_vanBanHuongDan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this van ban huong dan.
	*
	* @return the thu tuc hanh chinh ID of this van ban huong dan
	*/
	public long getThuTucHanhChinhId() {
		return _vanBanHuongDan.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this van ban huong dan.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this van ban huong dan
	*/
	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_vanBanHuongDan.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	public boolean isNew() {
		return _vanBanHuongDan.isNew();
	}

	public void setNew(boolean n) {
		_vanBanHuongDan.setNew(n);
	}

	public boolean isCachedModel() {
		return _vanBanHuongDan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_vanBanHuongDan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _vanBanHuongDan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _vanBanHuongDan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vanBanHuongDan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vanBanHuongDan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vanBanHuongDan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VanBanHuongDanWrapper((VanBanHuongDan)_vanBanHuongDan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.VanBanHuongDan vanBanHuongDan) {
		return _vanBanHuongDan.compareTo(vanBanHuongDan);
	}

	@Override
	public int hashCode() {
		return _vanBanHuongDan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.VanBanHuongDan> toCacheModel() {
		return _vanBanHuongDan.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.VanBanHuongDan toEscapedModel() {
		return new VanBanHuongDanWrapper(_vanBanHuongDan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vanBanHuongDan.toString();
	}

	public java.lang.String toXmlString() {
		return _vanBanHuongDan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vanBanHuongDan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VanBanHuongDan getWrappedVanBanHuongDan() {
		return _vanBanHuongDan;
	}

	public VanBanHuongDan getWrappedModel() {
		return _vanBanHuongDan;
	}

	public void resetOriginalValues() {
		_vanBanHuongDan.resetOriginalValues();
	}

	private VanBanHuongDan _vanBanHuongDan;
}