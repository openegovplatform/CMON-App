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
 * This class is a wrapper for {@link YeuCauDangKyDoanhNghiep}.
 * </p>
 *
 * @author    Liemnn
 * @see       YeuCauDangKyDoanhNghiep
 * @generated
 */
public class YeuCauDangKyDoanhNghiepWrapper implements YeuCauDangKyDoanhNghiep,
	ModelWrapper<YeuCauDangKyDoanhNghiep> {
	public YeuCauDangKyDoanhNghiepWrapper(
		YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		_yeuCauDangKyDoanhNghiep = yeuCauDangKyDoanhNghiep;
	}

	public Class<?> getModelClass() {
		return YeuCauDangKyDoanhNghiep.class;
	}

	public String getModelClassName() {
		return YeuCauDangKyDoanhNghiep.class.getName();
	}

	/**
	* Returns the primary key of this yeu cau dang ky doanh nghiep.
	*
	* @return the primary key of this yeu cau dang ky doanh nghiep
	*/
	public long getPrimaryKey() {
		return _yeuCauDangKyDoanhNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this yeu cau dang ky doanh nghiep.
	*
	* @param primaryKey the primary key of this yeu cau dang ky doanh nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_yeuCauDangKyDoanhNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this yeu cau dang ky doanh nghiep.
	*
	* @return the ID of this yeu cau dang ky doanh nghiep
	*/
	public long getId() {
		return _yeuCauDangKyDoanhNghiep.getId();
	}

	/**
	* Sets the ID of this yeu cau dang ky doanh nghiep.
	*
	* @param id the ID of this yeu cau dang ky doanh nghiep
	*/
	public void setId(long id) {
		_yeuCauDangKyDoanhNghiep.setId(id);
	}

	/**
	* Returns the loai doi tuong ID of this yeu cau dang ky doanh nghiep.
	*
	* @return the loai doi tuong ID of this yeu cau dang ky doanh nghiep
	*/
	public long getLoaiDoiTuongId() {
		return _yeuCauDangKyDoanhNghiep.getLoaiDoiTuongId();
	}

	/**
	* Sets the loai doi tuong ID of this yeu cau dang ky doanh nghiep.
	*
	* @param loaiDoiTuongId the loai doi tuong ID of this yeu cau dang ky doanh nghiep
	*/
	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_yeuCauDangKyDoanhNghiep.setLoaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns the ten of this yeu cau dang ky doanh nghiep.
	*
	* @return the ten of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getTen() {
		return _yeuCauDangKyDoanhNghiep.getTen();
	}

	/**
	* Sets the ten of this yeu cau dang ky doanh nghiep.
	*
	* @param ten the ten of this yeu cau dang ky doanh nghiep
	*/
	public void setTen(java.lang.String ten) {
		_yeuCauDangKyDoanhNghiep.setTen(ten);
	}

	/**
	* Returns the ma so thue of this yeu cau dang ky doanh nghiep.
	*
	* @return the ma so thue of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getMaSoThue() {
		return _yeuCauDangKyDoanhNghiep.getMaSoThue();
	}

	/**
	* Sets the ma so thue of this yeu cau dang ky doanh nghiep.
	*
	* @param maSoThue the ma so thue of this yeu cau dang ky doanh nghiep
	*/
	public void setMaSoThue(java.lang.String maSoThue) {
		_yeuCauDangKyDoanhNghiep.setMaSoThue(maSoThue);
	}

	/**
	* Returns the ma giay phep of this yeu cau dang ky doanh nghiep.
	*
	* @return the ma giay phep of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getMaGiayPhep() {
		return _yeuCauDangKyDoanhNghiep.getMaGiayPhep();
	}

	/**
	* Sets the ma giay phep of this yeu cau dang ky doanh nghiep.
	*
	* @param maGiayPhep the ma giay phep of this yeu cau dang ky doanh nghiep
	*/
	public void setMaGiayPhep(java.lang.String maGiayPhep) {
		_yeuCauDangKyDoanhNghiep.setMaGiayPhep(maGiayPhep);
	}

	/**
	* Returns the ngay cap of this yeu cau dang ky doanh nghiep.
	*
	* @return the ngay cap of this yeu cau dang ky doanh nghiep
	*/
	public java.util.Date getNgayCap() {
		return _yeuCauDangKyDoanhNghiep.getNgayCap();
	}

	/**
	* Sets the ngay cap of this yeu cau dang ky doanh nghiep.
	*
	* @param ngayCap the ngay cap of this yeu cau dang ky doanh nghiep
	*/
	public void setNgayCap(java.util.Date ngayCap) {
		_yeuCauDangKyDoanhNghiep.setNgayCap(ngayCap);
	}

	/**
	* Returns the email of this yeu cau dang ky doanh nghiep.
	*
	* @return the email of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getEmail() {
		return _yeuCauDangKyDoanhNghiep.getEmail();
	}

	/**
	* Sets the email of this yeu cau dang ky doanh nghiep.
	*
	* @param email the email of this yeu cau dang ky doanh nghiep
	*/
	public void setEmail(java.lang.String email) {
		_yeuCauDangKyDoanhNghiep.setEmail(email);
	}

	/**
	* Returns the ho nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @return the ho nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getHoNguoiDaiDien() {
		return _yeuCauDangKyDoanhNghiep.getHoNguoiDaiDien();
	}

	/**
	* Sets the ho nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @param hoNguoiDaiDien the ho nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public void setHoNguoiDaiDien(java.lang.String hoNguoiDaiDien) {
		_yeuCauDangKyDoanhNghiep.setHoNguoiDaiDien(hoNguoiDaiDien);
	}

	/**
	* Returns the ten dem nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @return the ten dem nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getTenDemNguoiDaiDien() {
		return _yeuCauDangKyDoanhNghiep.getTenDemNguoiDaiDien();
	}

	/**
	* Sets the ten dem nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @param tenDemNguoiDaiDien the ten dem nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public void setTenDemNguoiDaiDien(java.lang.String tenDemNguoiDaiDien) {
		_yeuCauDangKyDoanhNghiep.setTenDemNguoiDaiDien(tenDemNguoiDaiDien);
	}

	/**
	* Returns the ten nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @return the ten nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getTenNguoiDaiDien() {
		return _yeuCauDangKyDoanhNghiep.getTenNguoiDaiDien();
	}

	/**
	* Sets the ten nguoi dai dien of this yeu cau dang ky doanh nghiep.
	*
	* @param tenNguoiDaiDien the ten nguoi dai dien of this yeu cau dang ky doanh nghiep
	*/
	public void setTenNguoiDaiDien(java.lang.String tenNguoiDaiDien) {
		_yeuCauDangKyDoanhNghiep.setTenNguoiDaiDien(tenNguoiDaiDien);
	}

	/**
	* Returns the so c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @return the so c m n d of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getSoCMND() {
		return _yeuCauDangKyDoanhNghiep.getSoCMND();
	}

	/**
	* Sets the so c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @param soCMND the so c m n d of this yeu cau dang ky doanh nghiep
	*/
	public void setSoCMND(java.lang.String soCMND) {
		_yeuCauDangKyDoanhNghiep.setSoCMND(soCMND);
	}

	/**
	* Returns the ngay cap c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @return the ngay cap c m n d of this yeu cau dang ky doanh nghiep
	*/
	public java.util.Date getNgayCapCMND() {
		return _yeuCauDangKyDoanhNghiep.getNgayCapCMND();
	}

	/**
	* Sets the ngay cap c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @param ngayCapCMND the ngay cap c m n d of this yeu cau dang ky doanh nghiep
	*/
	public void setNgayCapCMND(java.util.Date ngayCapCMND) {
		_yeuCauDangKyDoanhNghiep.setNgayCapCMND(ngayCapCMND);
	}

	/**
	* Returns the noi cap c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @return the noi cap c m n d of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getNoiCapCMND() {
		return _yeuCauDangKyDoanhNghiep.getNoiCapCMND();
	}

	/**
	* Sets the noi cap c m n d of this yeu cau dang ky doanh nghiep.
	*
	* @param noiCapCMND the noi cap c m n d of this yeu cau dang ky doanh nghiep
	*/
	public void setNoiCapCMND(java.lang.String noiCapCMND) {
		_yeuCauDangKyDoanhNghiep.setNoiCapCMND(noiCapCMND);
	}

	/**
	* Returns the mo ta nganh nghe kinh doanh of this yeu cau dang ky doanh nghiep.
	*
	* @return the mo ta nganh nghe kinh doanh of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getMoTaNganhNgheKinhDoanh() {
		return _yeuCauDangKyDoanhNghiep.getMoTaNganhNgheKinhDoanh();
	}

	/**
	* Sets the mo ta nganh nghe kinh doanh of this yeu cau dang ky doanh nghiep.
	*
	* @param moTaNganhNgheKinhDoanh the mo ta nganh nghe kinh doanh of this yeu cau dang ky doanh nghiep
	*/
	public void setMoTaNganhNgheKinhDoanh(
		java.lang.String moTaNganhNgheKinhDoanh) {
		_yeuCauDangKyDoanhNghiep.setMoTaNganhNgheKinhDoanh(moTaNganhNgheKinhDoanh);
	}

	/**
	* Returns the loai hinh doanh nghiep of this yeu cau dang ky doanh nghiep.
	*
	* @return the loai hinh doanh nghiep of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getLoaiHinhDoanhNghiep() {
		return _yeuCauDangKyDoanhNghiep.getLoaiHinhDoanhNghiep();
	}

	/**
	* Sets the loai hinh doanh nghiep of this yeu cau dang ky doanh nghiep.
	*
	* @param loaiHinhDoanhNghiep the loai hinh doanh nghiep of this yeu cau dang ky doanh nghiep
	*/
	public void setLoaiHinhDoanhNghiep(java.lang.String loaiHinhDoanhNghiep) {
		_yeuCauDangKyDoanhNghiep.setLoaiHinhDoanhNghiep(loaiHinhDoanhNghiep);
	}

	/**
	* Returns the tru so of this yeu cau dang ky doanh nghiep.
	*
	* @return the tru so of this yeu cau dang ky doanh nghiep
	*/
	public java.lang.String getTruSo() {
		return _yeuCauDangKyDoanhNghiep.getTruSo();
	}

	/**
	* Sets the tru so of this yeu cau dang ky doanh nghiep.
	*
	* @param truSo the tru so of this yeu cau dang ky doanh nghiep
	*/
	public void setTruSo(java.lang.String truSo) {
		_yeuCauDangKyDoanhNghiep.setTruSo(truSo);
	}

	/**
	* Returns the tru so xa ID of this yeu cau dang ky doanh nghiep.
	*
	* @return the tru so xa ID of this yeu cau dang ky doanh nghiep
	*/
	public long getTruSoXaId() {
		return _yeuCauDangKyDoanhNghiep.getTruSoXaId();
	}

	/**
	* Sets the tru so xa ID of this yeu cau dang ky doanh nghiep.
	*
	* @param truSoXaId the tru so xa ID of this yeu cau dang ky doanh nghiep
	*/
	public void setTruSoXaId(long truSoXaId) {
		_yeuCauDangKyDoanhNghiep.setTruSoXaId(truSoXaId);
	}

	/**
	* Returns the tru so huyen ID of this yeu cau dang ky doanh nghiep.
	*
	* @return the tru so huyen ID of this yeu cau dang ky doanh nghiep
	*/
	public long getTruSoHuyenId() {
		return _yeuCauDangKyDoanhNghiep.getTruSoHuyenId();
	}

	/**
	* Sets the tru so huyen ID of this yeu cau dang ky doanh nghiep.
	*
	* @param truSoHuyenId the tru so huyen ID of this yeu cau dang ky doanh nghiep
	*/
	public void setTruSoHuyenId(long truSoHuyenId) {
		_yeuCauDangKyDoanhNghiep.setTruSoHuyenId(truSoHuyenId);
	}

	/**
	* Returns the tru so tinh ID of this yeu cau dang ky doanh nghiep.
	*
	* @return the tru so tinh ID of this yeu cau dang ky doanh nghiep
	*/
	public long getTruSoTinhId() {
		return _yeuCauDangKyDoanhNghiep.getTruSoTinhId();
	}

	/**
	* Sets the tru so tinh ID of this yeu cau dang ky doanh nghiep.
	*
	* @param truSoTinhId the tru so tinh ID of this yeu cau dang ky doanh nghiep
	*/
	public void setTruSoTinhId(long truSoTinhId) {
		_yeuCauDangKyDoanhNghiep.setTruSoTinhId(truSoTinhId);
	}

	/**
	* Returns the trang thai of this yeu cau dang ky doanh nghiep.
	*
	* @return the trang thai of this yeu cau dang ky doanh nghiep
	*/
	public int getTrangThai() {
		return _yeuCauDangKyDoanhNghiep.getTrangThai();
	}

	/**
	* Sets the trang thai of this yeu cau dang ky doanh nghiep.
	*
	* @param trangThai the trang thai of this yeu cau dang ky doanh nghiep
	*/
	public void setTrangThai(int trangThai) {
		_yeuCauDangKyDoanhNghiep.setTrangThai(trangThai);
	}

	public boolean isNew() {
		return _yeuCauDangKyDoanhNghiep.isNew();
	}

	public void setNew(boolean n) {
		_yeuCauDangKyDoanhNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _yeuCauDangKyDoanhNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_yeuCauDangKyDoanhNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _yeuCauDangKyDoanhNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _yeuCauDangKyDoanhNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_yeuCauDangKyDoanhNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _yeuCauDangKyDoanhNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_yeuCauDangKyDoanhNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YeuCauDangKyDoanhNghiepWrapper((YeuCauDangKyDoanhNghiep)_yeuCauDangKyDoanhNghiep.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep yeuCauDangKyDoanhNghiep) {
		return _yeuCauDangKyDoanhNghiep.compareTo(yeuCauDangKyDoanhNghiep);
	}

	@Override
	public int hashCode() {
		return _yeuCauDangKyDoanhNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep> toCacheModel() {
		return _yeuCauDangKyDoanhNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep toEscapedModel() {
		return new YeuCauDangKyDoanhNghiepWrapper(_yeuCauDangKyDoanhNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _yeuCauDangKyDoanhNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _yeuCauDangKyDoanhNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_yeuCauDangKyDoanhNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YeuCauDangKyDoanhNghiep getWrappedYeuCauDangKyDoanhNghiep() {
		return _yeuCauDangKyDoanhNghiep;
	}

	public YeuCauDangKyDoanhNghiep getWrappedModel() {
		return _yeuCauDangKyDoanhNghiep;
	}

	public void resetOriginalValues() {
		_yeuCauDangKyDoanhNghiep.resetOriginalValues();
	}

	private YeuCauDangKyDoanhNghiep _yeuCauDangKyDoanhNghiep;
}