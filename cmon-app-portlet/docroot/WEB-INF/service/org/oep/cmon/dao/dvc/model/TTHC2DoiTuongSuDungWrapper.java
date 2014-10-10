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
 * This class is a wrapper for {@link TTHC2DoiTuongSuDung}.
 * </p>
 *
 * @author    liemnn
 * @see       TTHC2DoiTuongSuDung
 * @generated
 */
public class TTHC2DoiTuongSuDungWrapper implements TTHC2DoiTuongSuDung,
	ModelWrapper<TTHC2DoiTuongSuDung> {
	public TTHC2DoiTuongSuDungWrapper(TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		_tthc2DoiTuongSuDung = tthc2DoiTuongSuDung;
	}

	public Class<?> getModelClass() {
		return TTHC2DoiTuongSuDung.class;
	}

	public String getModelClassName() {
		return TTHC2DoiTuongSuDung.class.getName();
	}

	/**
	* Returns the primary key of this t t h c2 doi tuong su dung.
	*
	* @return the primary key of this t t h c2 doi tuong su dung
	*/
	public long getPrimaryKey() {
		return _tthc2DoiTuongSuDung.getPrimaryKey();
	}

	/**
	* Sets the primary key of this t t h c2 doi tuong su dung.
	*
	* @param primaryKey the primary key of this t t h c2 doi tuong su dung
	*/
	public void setPrimaryKey(long primaryKey) {
		_tthc2DoiTuongSuDung.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this t t h c2 doi tuong su dung.
	*
	* @return the ID of this t t h c2 doi tuong su dung
	*/
	public long getId() {
		return _tthc2DoiTuongSuDung.getId();
	}

	/**
	* Sets the ID of this t t h c2 doi tuong su dung.
	*
	* @param id the ID of this t t h c2 doi tuong su dung
	*/
	public void setId(long id) {
		_tthc2DoiTuongSuDung.setId(id);
	}

	/**
	* Returns the ngay tao of this t t h c2 doi tuong su dung.
	*
	* @return the ngay tao of this t t h c2 doi tuong su dung
	*/
	public java.util.Date getNgayTao() {
		return _tthc2DoiTuongSuDung.getNgayTao();
	}

	/**
	* Sets the ngay tao of this t t h c2 doi tuong su dung.
	*
	* @param ngayTao the ngay tao of this t t h c2 doi tuong su dung
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_tthc2DoiTuongSuDung.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this t t h c2 doi tuong su dung.
	*
	* @return the ngay sua of this t t h c2 doi tuong su dung
	*/
	public java.util.Date getNgaySua() {
		return _tthc2DoiTuongSuDung.getNgaySua();
	}

	/**
	* Sets the ngay sua of this t t h c2 doi tuong su dung.
	*
	* @param ngaySua the ngay sua of this t t h c2 doi tuong su dung
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_tthc2DoiTuongSuDung.setNgaySua(ngaySua);
	}

	/**
	* Returns the da xoa of this t t h c2 doi tuong su dung.
	*
	* @return the da xoa of this t t h c2 doi tuong su dung
	*/
	public int getDaXoa() {
		return _tthc2DoiTuongSuDung.getDaXoa();
	}

	/**
	* Sets the da xoa of this t t h c2 doi tuong su dung.
	*
	* @param daXoa the da xoa of this t t h c2 doi tuong su dung
	*/
	public void setDaXoa(int daXoa) {
		_tthc2DoiTuongSuDung.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this t t h c2 doi tuong su dung.
	*
	* @return the nguoi tao of this t t h c2 doi tuong su dung
	*/
	public java.lang.String getNguoiTao() {
		return _tthc2DoiTuongSuDung.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this t t h c2 doi tuong su dung.
	*
	* @param nguoiTao the nguoi tao of this t t h c2 doi tuong su dung
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_tthc2DoiTuongSuDung.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this t t h c2 doi tuong su dung.
	*
	* @return the nguoi sua of this t t h c2 doi tuong su dung
	*/
	public java.lang.String getNguoiSua() {
		return _tthc2DoiTuongSuDung.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this t t h c2 doi tuong su dung.
	*
	* @param nguoiSua the nguoi sua of this t t h c2 doi tuong su dung
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_tthc2DoiTuongSuDung.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this t t h c2 doi tuong su dung.
	*
	* @return the thu tuc hanh chinh ID of this t t h c2 doi tuong su dung
	*/
	public long getThuTucHanhChinhId() {
		return _tthc2DoiTuongSuDung.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this t t h c2 doi tuong su dung.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this t t h c2 doi tuong su dung
	*/
	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_tthc2DoiTuongSuDung.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the loai doi tuong ID of this t t h c2 doi tuong su dung.
	*
	* @return the loai doi tuong ID of this t t h c2 doi tuong su dung
	*/
	public long getLoaiDoiTuongId() {
		return _tthc2DoiTuongSuDung.getLoaiDoiTuongId();
	}

	/**
	* Sets the loai doi tuong ID of this t t h c2 doi tuong su dung.
	*
	* @param loaiDoiTuongId the loai doi tuong ID of this t t h c2 doi tuong su dung
	*/
	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_tthc2DoiTuongSuDung.setLoaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns the trang thai of this t t h c2 doi tuong su dung.
	*
	* @return the trang thai of this t t h c2 doi tuong su dung
	*/
	public int getTrangThai() {
		return _tthc2DoiTuongSuDung.getTrangThai();
	}

	/**
	* Sets the trang thai of this t t h c2 doi tuong su dung.
	*
	* @param trangThai the trang thai of this t t h c2 doi tuong su dung
	*/
	public void setTrangThai(int trangThai) {
		_tthc2DoiTuongSuDung.setTrangThai(trangThai);
	}

	public boolean isNew() {
		return _tthc2DoiTuongSuDung.isNew();
	}

	public void setNew(boolean n) {
		_tthc2DoiTuongSuDung.setNew(n);
	}

	public boolean isCachedModel() {
		return _tthc2DoiTuongSuDung.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tthc2DoiTuongSuDung.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tthc2DoiTuongSuDung.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tthc2DoiTuongSuDung.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tthc2DoiTuongSuDung.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tthc2DoiTuongSuDung.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tthc2DoiTuongSuDung.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TTHC2DoiTuongSuDungWrapper((TTHC2DoiTuongSuDung)_tthc2DoiTuongSuDung.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung tthc2DoiTuongSuDung) {
		return _tthc2DoiTuongSuDung.compareTo(tthc2DoiTuongSuDung);
	}

	@Override
	public int hashCode() {
		return _tthc2DoiTuongSuDung.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung> toCacheModel() {
		return _tthc2DoiTuongSuDung.toCacheModel();
	}

	public org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung toEscapedModel() {
		return new TTHC2DoiTuongSuDungWrapper(_tthc2DoiTuongSuDung.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tthc2DoiTuongSuDung.toString();
	}

	public java.lang.String toXmlString() {
		return _tthc2DoiTuongSuDung.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tthc2DoiTuongSuDung.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TTHC2DoiTuongSuDung getWrappedTTHC2DoiTuongSuDung() {
		return _tthc2DoiTuongSuDung;
	}

	public TTHC2DoiTuongSuDung getWrappedModel() {
		return _tthc2DoiTuongSuDung;
	}

	public void resetOriginalValues() {
		_tthc2DoiTuongSuDung.resetOriginalValues();
	}

	private TTHC2DoiTuongSuDung _tthc2DoiTuongSuDung;
}