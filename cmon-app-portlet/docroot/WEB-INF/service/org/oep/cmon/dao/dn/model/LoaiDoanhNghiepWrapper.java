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

package org.oep.cmon.dao.dn.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LoaiDoanhNghiep}.
 * </p>
 *
 * @author    Liemnn
 * @see       LoaiDoanhNghiep
 * @generated
 */
public class LoaiDoanhNghiepWrapper implements LoaiDoanhNghiep,
	ModelWrapper<LoaiDoanhNghiep> {
	public LoaiDoanhNghiepWrapper(LoaiDoanhNghiep loaiDoanhNghiep) {
		_loaiDoanhNghiep = loaiDoanhNghiep;
	}

	public Class<?> getModelClass() {
		return LoaiDoanhNghiep.class;
	}

	public String getModelClassName() {
		return LoaiDoanhNghiep.class.getName();
	}

	/**
	* Returns the primary key of this loai doanh nghiep.
	*
	* @return the primary key of this loai doanh nghiep
	*/
	public long getPrimaryKey() {
		return _loaiDoanhNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loai doanh nghiep.
	*
	* @param primaryKey the primary key of this loai doanh nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_loaiDoanhNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this loai doanh nghiep.
	*
	* @return the ID of this loai doanh nghiep
	*/
	public long getId() {
		return _loaiDoanhNghiep.getId();
	}

	/**
	* Sets the ID of this loai doanh nghiep.
	*
	* @param id the ID of this loai doanh nghiep
	*/
	public void setId(long id) {
		_loaiDoanhNghiep.setId(id);
	}

	/**
	* Returns the ma of this loai doanh nghiep.
	*
	* @return the ma of this loai doanh nghiep
	*/
	public java.lang.String getMa() {
		return _loaiDoanhNghiep.getMa();
	}

	/**
	* Sets the ma of this loai doanh nghiep.
	*
	* @param ma the ma of this loai doanh nghiep
	*/
	public void setMa(java.lang.String ma) {
		_loaiDoanhNghiep.setMa(ma);
	}

	/**
	* Returns the ten of this loai doanh nghiep.
	*
	* @return the ten of this loai doanh nghiep
	*/
	public java.lang.String getTen() {
		return _loaiDoanhNghiep.getTen();
	}

	/**
	* Sets the ten of this loai doanh nghiep.
	*
	* @param ten the ten of this loai doanh nghiep
	*/
	public void setTen(java.lang.String ten) {
		_loaiDoanhNghiep.setTen(ten);
	}

	/**
	* Returns the mo ta of this loai doanh nghiep.
	*
	* @return the mo ta of this loai doanh nghiep
	*/
	public java.lang.String getMoTa() {
		return _loaiDoanhNghiep.getMoTa();
	}

	/**
	* Sets the mo ta of this loai doanh nghiep.
	*
	* @param moTa the mo ta of this loai doanh nghiep
	*/
	public void setMoTa(java.lang.String moTa) {
		_loaiDoanhNghiep.setMoTa(moTa);
	}

	/**
	* Returns the ngay tao of this loai doanh nghiep.
	*
	* @return the ngay tao of this loai doanh nghiep
	*/
	public java.util.Date getNgayTao() {
		return _loaiDoanhNghiep.getNgayTao();
	}

	/**
	* Sets the ngay tao of this loai doanh nghiep.
	*
	* @param ngayTao the ngay tao of this loai doanh nghiep
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_loaiDoanhNghiep.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this loai doanh nghiep.
	*
	* @return the ngay sua of this loai doanh nghiep
	*/
	public java.util.Date getNgaySua() {
		return _loaiDoanhNghiep.getNgaySua();
	}

	/**
	* Sets the ngay sua of this loai doanh nghiep.
	*
	* @param ngaySua the ngay sua of this loai doanh nghiep
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_loaiDoanhNghiep.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this loai doanh nghiep.
	*
	* @return the nguoi tao of this loai doanh nghiep
	*/
	public java.lang.String getNguoiTao() {
		return _loaiDoanhNghiep.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this loai doanh nghiep.
	*
	* @param nguoiTao the nguoi tao of this loai doanh nghiep
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_loaiDoanhNghiep.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this loai doanh nghiep.
	*
	* @return the nguoi sua of this loai doanh nghiep
	*/
	public java.lang.String getNguoiSua() {
		return _loaiDoanhNghiep.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this loai doanh nghiep.
	*
	* @param nguoiSua the nguoi sua of this loai doanh nghiep
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_loaiDoanhNghiep.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the phien ban of this loai doanh nghiep.
	*
	* @return the phien ban of this loai doanh nghiep
	*/
	public int getPhienBan() {
		return _loaiDoanhNghiep.getPhienBan();
	}

	/**
	* Sets the phien ban of this loai doanh nghiep.
	*
	* @param phienBan the phien ban of this loai doanh nghiep
	*/
	public void setPhienBan(int phienBan) {
		_loaiDoanhNghiep.setPhienBan(phienBan);
	}

	/**
	* Returns the da xoa of this loai doanh nghiep.
	*
	* @return the da xoa of this loai doanh nghiep
	*/
	public int getDaXoa() {
		return _loaiDoanhNghiep.getDaXoa();
	}

	/**
	* Sets the da xoa of this loai doanh nghiep.
	*
	* @param daXoa the da xoa of this loai doanh nghiep
	*/
	public void setDaXoa(int daXoa) {
		_loaiDoanhNghiep.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _loaiDoanhNghiep.isNew();
	}

	public void setNew(boolean n) {
		_loaiDoanhNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _loaiDoanhNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_loaiDoanhNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _loaiDoanhNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _loaiDoanhNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loaiDoanhNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loaiDoanhNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loaiDoanhNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LoaiDoanhNghiepWrapper((LoaiDoanhNghiep)_loaiDoanhNghiep.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dn.model.LoaiDoanhNghiep loaiDoanhNghiep) {
		return _loaiDoanhNghiep.compareTo(loaiDoanhNghiep);
	}

	@Override
	public int hashCode() {
		return _loaiDoanhNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.LoaiDoanhNghiep> toCacheModel() {
		return _loaiDoanhNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.LoaiDoanhNghiep toEscapedModel() {
		return new LoaiDoanhNghiepWrapper(_loaiDoanhNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loaiDoanhNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _loaiDoanhNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loaiDoanhNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LoaiDoanhNghiep getWrappedLoaiDoanhNghiep() {
		return _loaiDoanhNghiep;
	}

	public LoaiDoanhNghiep getWrappedModel() {
		return _loaiDoanhNghiep;
	}

	public void resetOriginalValues() {
		_loaiDoanhNghiep.resetOriginalValues();
	}

	private LoaiDoanhNghiep _loaiDoanhNghiep;
}