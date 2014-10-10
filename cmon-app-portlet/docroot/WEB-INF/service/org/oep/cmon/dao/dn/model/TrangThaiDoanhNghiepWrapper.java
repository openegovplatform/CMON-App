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
 * This class is a wrapper for {@link TrangThaiDoanhNghiep}.
 * </p>
 *
 * @author    Liemnn
 * @see       TrangThaiDoanhNghiep
 * @generated
 */
public class TrangThaiDoanhNghiepWrapper implements TrangThaiDoanhNghiep,
	ModelWrapper<TrangThaiDoanhNghiep> {
	public TrangThaiDoanhNghiepWrapper(
		TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		_trangThaiDoanhNghiep = trangThaiDoanhNghiep;
	}

	public Class<?> getModelClass() {
		return TrangThaiDoanhNghiep.class;
	}

	public String getModelClassName() {
		return TrangThaiDoanhNghiep.class.getName();
	}

	/**
	* Returns the primary key of this trang thai doanh nghiep.
	*
	* @return the primary key of this trang thai doanh nghiep
	*/
	public long getPrimaryKey() {
		return _trangThaiDoanhNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this trang thai doanh nghiep.
	*
	* @param primaryKey the primary key of this trang thai doanh nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_trangThaiDoanhNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this trang thai doanh nghiep.
	*
	* @return the ID of this trang thai doanh nghiep
	*/
	public long getId() {
		return _trangThaiDoanhNghiep.getId();
	}

	/**
	* Sets the ID of this trang thai doanh nghiep.
	*
	* @param id the ID of this trang thai doanh nghiep
	*/
	public void setId(long id) {
		_trangThaiDoanhNghiep.setId(id);
	}

	/**
	* Returns the ten of this trang thai doanh nghiep.
	*
	* @return the ten of this trang thai doanh nghiep
	*/
	public java.lang.String getTen() {
		return _trangThaiDoanhNghiep.getTen();
	}

	/**
	* Sets the ten of this trang thai doanh nghiep.
	*
	* @param ten the ten of this trang thai doanh nghiep
	*/
	public void setTen(java.lang.String ten) {
		_trangThaiDoanhNghiep.setTen(ten);
	}

	/**
	* Returns the mo ta of this trang thai doanh nghiep.
	*
	* @return the mo ta of this trang thai doanh nghiep
	*/
	public java.lang.String getMoTa() {
		return _trangThaiDoanhNghiep.getMoTa();
	}

	/**
	* Sets the mo ta of this trang thai doanh nghiep.
	*
	* @param moTa the mo ta of this trang thai doanh nghiep
	*/
	public void setMoTa(java.lang.String moTa) {
		_trangThaiDoanhNghiep.setMoTa(moTa);
	}

	/**
	* Returns the nguoi tao of this trang thai doanh nghiep.
	*
	* @return the nguoi tao of this trang thai doanh nghiep
	*/
	public java.lang.String getNguoiTao() {
		return _trangThaiDoanhNghiep.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this trang thai doanh nghiep.
	*
	* @param nguoiTao the nguoi tao of this trang thai doanh nghiep
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_trangThaiDoanhNghiep.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this trang thai doanh nghiep.
	*
	* @return the ngay tao of this trang thai doanh nghiep
	*/
	public java.util.Date getNgayTao() {
		return _trangThaiDoanhNghiep.getNgayTao();
	}

	/**
	* Sets the ngay tao of this trang thai doanh nghiep.
	*
	* @param ngayTao the ngay tao of this trang thai doanh nghiep
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_trangThaiDoanhNghiep.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this trang thai doanh nghiep.
	*
	* @return the nguoi sua of this trang thai doanh nghiep
	*/
	public java.lang.String getNguoiSua() {
		return _trangThaiDoanhNghiep.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this trang thai doanh nghiep.
	*
	* @param nguoiSua the nguoi sua of this trang thai doanh nghiep
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_trangThaiDoanhNghiep.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this trang thai doanh nghiep.
	*
	* @return the ngay sua of this trang thai doanh nghiep
	*/
	public java.util.Date getNgaySua() {
		return _trangThaiDoanhNghiep.getNgaySua();
	}

	/**
	* Sets the ngay sua of this trang thai doanh nghiep.
	*
	* @param ngaySua the ngay sua of this trang thai doanh nghiep
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_trangThaiDoanhNghiep.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this trang thai doanh nghiep.
	*
	* @return the da xoa of this trang thai doanh nghiep
	*/
	public int getDaXoa() {
		return _trangThaiDoanhNghiep.getDaXoa();
	}

	/**
	* Sets the da xoa of this trang thai doanh nghiep.
	*
	* @param daXoa the da xoa of this trang thai doanh nghiep
	*/
	public void setDaXoa(int daXoa) {
		_trangThaiDoanhNghiep.setDaXoa(daXoa);
	}

	public boolean isNew() {
		return _trangThaiDoanhNghiep.isNew();
	}

	public void setNew(boolean n) {
		_trangThaiDoanhNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _trangThaiDoanhNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_trangThaiDoanhNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _trangThaiDoanhNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _trangThaiDoanhNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_trangThaiDoanhNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _trangThaiDoanhNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_trangThaiDoanhNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TrangThaiDoanhNghiepWrapper((TrangThaiDoanhNghiep)_trangThaiDoanhNghiep.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep trangThaiDoanhNghiep) {
		return _trangThaiDoanhNghiep.compareTo(trangThaiDoanhNghiep);
	}

	@Override
	public int hashCode() {
		return _trangThaiDoanhNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep> toCacheModel() {
		return _trangThaiDoanhNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep toEscapedModel() {
		return new TrangThaiDoanhNghiepWrapper(_trangThaiDoanhNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _trangThaiDoanhNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _trangThaiDoanhNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_trangThaiDoanhNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TrangThaiDoanhNghiep getWrappedTrangThaiDoanhNghiep() {
		return _trangThaiDoanhNghiep;
	}

	public TrangThaiDoanhNghiep getWrappedModel() {
		return _trangThaiDoanhNghiep;
	}

	public void resetOriginalValues() {
		_trangThaiDoanhNghiep.resetOriginalValues();
	}

	private TrangThaiDoanhNghiep _trangThaiDoanhNghiep;
}