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
 * This class is a wrapper for {@link TaiNguyen}.
 * </p>
 *
 * @author    Liemnn
 * @see       TaiNguyen
 * @generated
 */
public class TaiNguyenWrapper implements TaiNguyen, ModelWrapper<TaiNguyen> {
	public TaiNguyenWrapper(TaiNguyen taiNguyen) {
		_taiNguyen = taiNguyen;
	}

	public Class<?> getModelClass() {
		return TaiNguyen.class;
	}

	public String getModelClassName() {
		return TaiNguyen.class.getName();
	}

	/**
	* Returns the primary key of this tai nguyen.
	*
	* @return the primary key of this tai nguyen
	*/
	public long getPrimaryKey() {
		return _taiNguyen.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tai nguyen.
	*
	* @param primaryKey the primary key of this tai nguyen
	*/
	public void setPrimaryKey(long primaryKey) {
		_taiNguyen.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tai nguyen.
	*
	* @return the ID of this tai nguyen
	*/
	public long getId() {
		return _taiNguyen.getId();
	}

	/**
	* Sets the ID of this tai nguyen.
	*
	* @param id the ID of this tai nguyen
	*/
	public void setId(long id) {
		_taiNguyen.setId(id);
	}

	/**
	* Returns the ten of this tai nguyen.
	*
	* @return the ten of this tai nguyen
	*/
	public java.lang.String getTen() {
		return _taiNguyen.getTen();
	}

	/**
	* Sets the ten of this tai nguyen.
	*
	* @param ten the ten of this tai nguyen
	*/
	public void setTen(java.lang.String ten) {
		_taiNguyen.setTen(ten);
	}

	/**
	* Returns the mo ta of this tai nguyen.
	*
	* @return the mo ta of this tai nguyen
	*/
	public java.lang.String getMoTa() {
		return _taiNguyen.getMoTa();
	}

	/**
	* Sets the mo ta of this tai nguyen.
	*
	* @param moTa the mo ta of this tai nguyen
	*/
	public void setMoTa(java.lang.String moTa) {
		_taiNguyen.setMoTa(moTa);
	}

	/**
	* Returns the loai of this tai nguyen.
	*
	* @return the loai of this tai nguyen
	*/
	public int getLoai() {
		return _taiNguyen.getLoai();
	}

	/**
	* Sets the loai of this tai nguyen.
	*
	* @param loai the loai of this tai nguyen
	*/
	public void setLoai(int loai) {
		_taiNguyen.setLoai(loai);
	}

	/**
	* Returns the gia tri of this tai nguyen.
	*
	* @return the gia tri of this tai nguyen
	*/
	public java.lang.String getGiaTri() {
		return _taiNguyen.getGiaTri();
	}

	/**
	* Sets the gia tri of this tai nguyen.
	*
	* @param giaTri the gia tri of this tai nguyen
	*/
	public void setGiaTri(java.lang.String giaTri) {
		_taiNguyen.setGiaTri(giaTri);
	}

	/**
	* Returns the trang thai of this tai nguyen.
	*
	* @return the trang thai of this tai nguyen
	*/
	public int getTrangThai() {
		return _taiNguyen.getTrangThai();
	}

	/**
	* Sets the trang thai of this tai nguyen.
	*
	* @param trangThai the trang thai of this tai nguyen
	*/
	public void setTrangThai(int trangThai) {
		_taiNguyen.setTrangThai(trangThai);
	}

	/**
	* Returns the ngay tao of this tai nguyen.
	*
	* @return the ngay tao of this tai nguyen
	*/
	public java.util.Date getNgayTao() {
		return _taiNguyen.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tai nguyen.
	*
	* @param ngayTao the ngay tao of this tai nguyen
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_taiNguyen.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi tao of this tai nguyen.
	*
	* @return the nguoi tao of this tai nguyen
	*/
	public java.lang.String getNguoiTao() {
		return _taiNguyen.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tai nguyen.
	*
	* @param nguoiTao the nguoi tao of this tai nguyen
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_taiNguyen.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay sua of this tai nguyen.
	*
	* @return the ngay sua of this tai nguyen
	*/
	public java.util.Date getNgaySua() {
		return _taiNguyen.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tai nguyen.
	*
	* @param ngaySua the ngay sua of this tai nguyen
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_taiNguyen.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi sua of this tai nguyen.
	*
	* @return the nguoi sua of this tai nguyen
	*/
	public java.lang.String getNguoiSua() {
		return _taiNguyen.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tai nguyen.
	*
	* @param nguoiSua the nguoi sua of this tai nguyen
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_taiNguyen.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this tai nguyen.
	*
	* @return the da xoa of this tai nguyen
	*/
	public int getDaXoa() {
		return _taiNguyen.getDaXoa();
	}

	/**
	* Sets the da xoa of this tai nguyen.
	*
	* @param daXoa the da xoa of this tai nguyen
	*/
	public void setDaXoa(int daXoa) {
		_taiNguyen.setDaXoa(daXoa);
	}

	/**
	* Returns the ung dung ID of this tai nguyen.
	*
	* @return the ung dung ID of this tai nguyen
	*/
	public java.lang.Long getUngDungId() {
		return _taiNguyen.getUngDungId();
	}

	/**
	* Sets the ung dung ID of this tai nguyen.
	*
	* @param ungDungId the ung dung ID of this tai nguyen
	*/
	public void setUngDungId(java.lang.Long ungDungId) {
		_taiNguyen.setUngDungId(ungDungId);
	}

	/**
	* Returns the he thong ID of this tai nguyen.
	*
	* @return the he thong ID of this tai nguyen
	*/
	public java.lang.Long getHeThongId() {
		return _taiNguyen.getHeThongId();
	}

	/**
	* Sets the he thong ID of this tai nguyen.
	*
	* @param heThongId the he thong ID of this tai nguyen
	*/
	public void setHeThongId(java.lang.Long heThongId) {
		_taiNguyen.setHeThongId(heThongId);
	}

	public boolean isNew() {
		return _taiNguyen.isNew();
	}

	public void setNew(boolean n) {
		_taiNguyen.setNew(n);
	}

	public boolean isCachedModel() {
		return _taiNguyen.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_taiNguyen.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _taiNguyen.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _taiNguyen.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taiNguyen.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taiNguyen.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taiNguyen.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaiNguyenWrapper((TaiNguyen)_taiNguyen.clone());
	}

	public int compareTo(org.oep.cmon.dao.nsd.model.TaiNguyen taiNguyen) {
		return _taiNguyen.compareTo(taiNguyen);
	}

	@Override
	public int hashCode() {
		return _taiNguyen.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.TaiNguyen> toCacheModel() {
		return _taiNguyen.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.TaiNguyen toEscapedModel() {
		return new TaiNguyenWrapper(_taiNguyen.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taiNguyen.toString();
	}

	public java.lang.String toXmlString() {
		return _taiNguyen.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taiNguyen.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TaiNguyen getWrappedTaiNguyen() {
		return _taiNguyen;
	}

	public TaiNguyen getWrappedModel() {
		return _taiNguyen;
	}

	public void resetOriginalValues() {
		_taiNguyen.resetOriginalValues();
	}

	private TaiNguyen _taiNguyen;
}