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
 * This class is a wrapper for {@link TaiKhoanNguoiDung}.
 * </p>
 *
 * @author    Liemnn
 * @see       TaiKhoanNguoiDung
 * @generated
 */
public class TaiKhoanNguoiDungWrapper implements TaiKhoanNguoiDung,
	ModelWrapper<TaiKhoanNguoiDung> {
	public TaiKhoanNguoiDungWrapper(TaiKhoanNguoiDung taiKhoanNguoiDung) {
		_taiKhoanNguoiDung = taiKhoanNguoiDung;
	}

	public Class<?> getModelClass() {
		return TaiKhoanNguoiDung.class;
	}

	public String getModelClassName() {
		return TaiKhoanNguoiDung.class.getName();
	}

	/**
	* Returns the primary key of this tai khoan nguoi dung.
	*
	* @return the primary key of this tai khoan nguoi dung
	*/
	public long getPrimaryKey() {
		return _taiKhoanNguoiDung.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tai khoan nguoi dung.
	*
	* @param primaryKey the primary key of this tai khoan nguoi dung
	*/
	public void setPrimaryKey(long primaryKey) {
		_taiKhoanNguoiDung.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tai khoan nguoi dung.
	*
	* @return the ID of this tai khoan nguoi dung
	*/
	public long getId() {
		return _taiKhoanNguoiDung.getId();
	}

	/**
	* Sets the ID of this tai khoan nguoi dung.
	*
	* @param id the ID of this tai khoan nguoi dung
	*/
	public void setId(long id) {
		_taiKhoanNguoiDung.setId(id);
	}

	/**
	* Returns the ten dang nhap of this tai khoan nguoi dung.
	*
	* @return the ten dang nhap of this tai khoan nguoi dung
	*/
	public java.lang.String getTenDangNhap() {
		return _taiKhoanNguoiDung.getTenDangNhap();
	}

	/**
	* Sets the ten dang nhap of this tai khoan nguoi dung.
	*
	* @param tenDangNhap the ten dang nhap of this tai khoan nguoi dung
	*/
	public void setTenDangNhap(java.lang.String tenDangNhap) {
		_taiKhoanNguoiDung.setTenDangNhap(tenDangNhap);
	}

	/**
	* Returns the mat khau of this tai khoan nguoi dung.
	*
	* @return the mat khau of this tai khoan nguoi dung
	*/
	public java.lang.String getMatKhau() {
		return _taiKhoanNguoiDung.getMatKhau();
	}

	/**
	* Sets the mat khau of this tai khoan nguoi dung.
	*
	* @param matKhau the mat khau of this tai khoan nguoi dung
	*/
	public void setMatKhau(java.lang.String matKhau) {
		_taiKhoanNguoiDung.setMatKhau(matKhau);
	}

	/**
	* Returns the ten nguoi dung of this tai khoan nguoi dung.
	*
	* @return the ten nguoi dung of this tai khoan nguoi dung
	*/
	public java.lang.String getTenNguoiDung() {
		return _taiKhoanNguoiDung.getTenNguoiDung();
	}

	/**
	* Sets the ten nguoi dung of this tai khoan nguoi dung.
	*
	* @param tenNguoiDung the ten nguoi dung of this tai khoan nguoi dung
	*/
	public void setTenNguoiDung(java.lang.String tenNguoiDung) {
		_taiKhoanNguoiDung.setTenNguoiDung(tenNguoiDung);
	}

	/**
	* Returns the cau hoi mat khau of this tai khoan nguoi dung.
	*
	* @return the cau hoi mat khau of this tai khoan nguoi dung
	*/
	public java.lang.String getCauHoiMatKhau() {
		return _taiKhoanNguoiDung.getCauHoiMatKhau();
	}

	/**
	* Sets the cau hoi mat khau of this tai khoan nguoi dung.
	*
	* @param cauHoiMatKhau the cau hoi mat khau of this tai khoan nguoi dung
	*/
	public void setCauHoiMatKhau(java.lang.String cauHoiMatKhau) {
		_taiKhoanNguoiDung.setCauHoiMatKhau(cauHoiMatKhau);
	}

	/**
	* Returns the cau tra loi mat khau of this tai khoan nguoi dung.
	*
	* @return the cau tra loi mat khau of this tai khoan nguoi dung
	*/
	public java.lang.String getCauTraLoiMatKhau() {
		return _taiKhoanNguoiDung.getCauTraLoiMatKhau();
	}

	/**
	* Sets the cau tra loi mat khau of this tai khoan nguoi dung.
	*
	* @param cauTraLoiMatKhau the cau tra loi mat khau of this tai khoan nguoi dung
	*/
	public void setCauTraLoiMatKhau(java.lang.String cauTraLoiMatKhau) {
		_taiKhoanNguoiDung.setCauTraLoiMatKhau(cauTraLoiMatKhau);
	}

	/**
	* Returns the email of this tai khoan nguoi dung.
	*
	* @return the email of this tai khoan nguoi dung
	*/
	public java.lang.String getEmail() {
		return _taiKhoanNguoiDung.getEmail();
	}

	/**
	* Sets the email of this tai khoan nguoi dung.
	*
	* @param email the email of this tai khoan nguoi dung
	*/
	public void setEmail(java.lang.String email) {
		_taiKhoanNguoiDung.setEmail(email);
	}

	/**
	* Returns the ngay tao of this tai khoan nguoi dung.
	*
	* @return the ngay tao of this tai khoan nguoi dung
	*/
	public java.util.Date getNgayTao() {
		return _taiKhoanNguoiDung.getNgayTao();
	}

	/**
	* Sets the ngay tao of this tai khoan nguoi dung.
	*
	* @param ngayTao the ngay tao of this tai khoan nguoi dung
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_taiKhoanNguoiDung.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this tai khoan nguoi dung.
	*
	* @return the da xoa of this tai khoan nguoi dung
	*/
	public int getDaXoa() {
		return _taiKhoanNguoiDung.getDaXoa();
	}

	/**
	* Sets the da xoa of this tai khoan nguoi dung.
	*
	* @param daXoa the da xoa of this tai khoan nguoi dung
	*/
	public void setDaXoa(int daXoa) {
		_taiKhoanNguoiDung.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this tai khoan nguoi dung.
	*
	* @return the ngay sua of this tai khoan nguoi dung
	*/
	public java.util.Date getNgaySua() {
		return _taiKhoanNguoiDung.getNgaySua();
	}

	/**
	* Sets the ngay sua of this tai khoan nguoi dung.
	*
	* @param ngaySua the ngay sua of this tai khoan nguoi dung
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_taiKhoanNguoiDung.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this tai khoan nguoi dung.
	*
	* @return the nguoi tao of this tai khoan nguoi dung
	*/
	public java.lang.String getNguoiTao() {
		return _taiKhoanNguoiDung.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this tai khoan nguoi dung.
	*
	* @param nguoiTao the nguoi tao of this tai khoan nguoi dung
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_taiKhoanNguoiDung.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this tai khoan nguoi dung.
	*
	* @return the nguoi sua of this tai khoan nguoi dung
	*/
	public java.lang.String getNguoiSua() {
		return _taiKhoanNguoiDung.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this tai khoan nguoi dung.
	*
	* @param nguoiSua the nguoi sua of this tai khoan nguoi dung
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_taiKhoanNguoiDung.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the trang thai of this tai khoan nguoi dung.
	*
	* @return the trang thai of this tai khoan nguoi dung
	*/
	public int getTrangThai() {
		return _taiKhoanNguoiDung.getTrangThai();
	}

	/**
	* Sets the trang thai of this tai khoan nguoi dung.
	*
	* @param trangThai the trang thai of this tai khoan nguoi dung
	*/
	public void setTrangThai(int trangThai) {
		_taiKhoanNguoiDung.setTrangThai(trangThai);
	}

	/**
	* Returns the loai doi tuong ID of this tai khoan nguoi dung.
	*
	* @return the loai doi tuong ID of this tai khoan nguoi dung
	*/
	public java.lang.Long getLoaiDoiTuongId() {
		return _taiKhoanNguoiDung.getLoaiDoiTuongId();
	}

	/**
	* Sets the loai doi tuong ID of this tai khoan nguoi dung.
	*
	* @param loaiDoiTuongId the loai doi tuong ID of this tai khoan nguoi dung
	*/
	public void setLoaiDoiTuongId(java.lang.Long loaiDoiTuongId) {
		_taiKhoanNguoiDung.setLoaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns the tai khoan nguoi dung ID of this tai khoan nguoi dung.
	*
	* @return the tai khoan nguoi dung ID of this tai khoan nguoi dung
	*/
	public java.lang.Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDung.getTaiKhoanNguoiDungId();
	}

	/**
	* Sets the tai khoan nguoi dung ID of this tai khoan nguoi dung.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID of this tai khoan nguoi dung
	*/
	public void setTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDung.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	public boolean isNew() {
		return _taiKhoanNguoiDung.isNew();
	}

	public void setNew(boolean n) {
		_taiKhoanNguoiDung.setNew(n);
	}

	public boolean isCachedModel() {
		return _taiKhoanNguoiDung.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_taiKhoanNguoiDung.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _taiKhoanNguoiDung.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _taiKhoanNguoiDung.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taiKhoanNguoiDung.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taiKhoanNguoiDung.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taiKhoanNguoiDung.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaiKhoanNguoiDungWrapper((TaiKhoanNguoiDung)_taiKhoanNguoiDung.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung taiKhoanNguoiDung) {
		return _taiKhoanNguoiDung.compareTo(taiKhoanNguoiDung);
	}

	@Override
	public int hashCode() {
		return _taiKhoanNguoiDung.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung> toCacheModel() {
		return _taiKhoanNguoiDung.toCacheModel();
	}

	public org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung toEscapedModel() {
		return new TaiKhoanNguoiDungWrapper(_taiKhoanNguoiDung.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taiKhoanNguoiDung.toString();
	}

	public java.lang.String toXmlString() {
		return _taiKhoanNguoiDung.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taiKhoanNguoiDung.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TaiKhoanNguoiDung getWrappedTaiKhoanNguoiDung() {
		return _taiKhoanNguoiDung;
	}

	public TaiKhoanNguoiDung getWrappedModel() {
		return _taiKhoanNguoiDung;
	}

	public void resetOriginalValues() {
		_taiKhoanNguoiDung.resetOriginalValues();
	}

	private TaiKhoanNguoiDung _taiKhoanNguoiDung;
}