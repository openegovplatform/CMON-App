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

package org.oep.cmon.dao.ttthanhtoan.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ThongTinThanhToan}.
 * </p>
 *
 * @author    Thanhdd
 * @see       ThongTinThanhToan
 * @generated
 */
public class ThongTinThanhToanWrapper implements ThongTinThanhToan,
	ModelWrapper<ThongTinThanhToan> {
	public ThongTinThanhToanWrapper(ThongTinThanhToan thongTinThanhToan) {
		_thongTinThanhToan = thongTinThanhToan;
	}

	public Class<?> getModelClass() {
		return ThongTinThanhToan.class;
	}

	public String getModelClassName() {
		return ThongTinThanhToan.class.getName();
	}

	/**
	* Returns the primary key of this thong tin thanh toan.
	*
	* @return the primary key of this thong tin thanh toan
	*/
	public long getPrimaryKey() {
		return _thongTinThanhToan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this thong tin thanh toan.
	*
	* @param primaryKey the primary key of this thong tin thanh toan
	*/
	public void setPrimaryKey(long primaryKey) {
		_thongTinThanhToan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this thong tin thanh toan.
	*
	* @return the ID of this thong tin thanh toan
	*/
	public long getId() {
		return _thongTinThanhToan.getId();
	}

	/**
	* Sets the ID of this thong tin thanh toan.
	*
	* @param id the ID of this thong tin thanh toan
	*/
	public void setId(long id) {
		_thongTinThanhToan.setId(id);
	}

	/**
	* Returns the ho so t t h c cong ID of this thong tin thanh toan.
	*
	* @return the ho so t t h c cong ID of this thong tin thanh toan
	*/
	public long getHoSoTTHCCongId() {
		return _thongTinThanhToan.getHoSoTTHCCongId();
	}

	/**
	* Sets the ho so t t h c cong ID of this thong tin thanh toan.
	*
	* @param hoSoTTHCCongId the ho so t t h c cong ID of this thong tin thanh toan
	*/
	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_thongTinThanhToan.setHoSoTTHCCongId(hoSoTTHCCongId);
	}

	/**
	* Returns the tai khoan nguoi dung nop ID of this thong tin thanh toan.
	*
	* @return the tai khoan nguoi dung nop ID of this thong tin thanh toan
	*/
	public java.lang.Long getTaiKhoanNguoiDungNopId() {
		return _thongTinThanhToan.getTaiKhoanNguoiDungNopId();
	}

	/**
	* Sets the tai khoan nguoi dung nop ID of this thong tin thanh toan.
	*
	* @param taiKhoanNguoiDungNopId the tai khoan nguoi dung nop ID of this thong tin thanh toan
	*/
	public void setTaiKhoanNguoiDungNopId(java.lang.Long taiKhoanNguoiDungNopId) {
		_thongTinThanhToan.setTaiKhoanNguoiDungNopId(taiKhoanNguoiDungNopId);
	}

	/**
	* Returns the tai khoan nguoi dung nhan ID of this thong tin thanh toan.
	*
	* @return the tai khoan nguoi dung nhan ID of this thong tin thanh toan
	*/
	public java.lang.Long getTaiKhoanNguoiDungNhanId() {
		return _thongTinThanhToan.getTaiKhoanNguoiDungNhanId();
	}

	/**
	* Sets the tai khoan nguoi dung nhan ID of this thong tin thanh toan.
	*
	* @param taiKhoanNguoiDungNhanId the tai khoan nguoi dung nhan ID of this thong tin thanh toan
	*/
	public void setTaiKhoanNguoiDungNhanId(
		java.lang.Long taiKhoanNguoiDungNhanId) {
		_thongTinThanhToan.setTaiKhoanNguoiDungNhanId(taiKhoanNguoiDungNhanId);
	}

	/**
	* Returns the loai thanh toan of this thong tin thanh toan.
	*
	* @return the loai thanh toan of this thong tin thanh toan
	*/
	public long getLoaiThanhToan() {
		return _thongTinThanhToan.getLoaiThanhToan();
	}

	/**
	* Sets the loai thanh toan of this thong tin thanh toan.
	*
	* @param loaiThanhToan the loai thanh toan of this thong tin thanh toan
	*/
	public void setLoaiThanhToan(long loaiThanhToan) {
		_thongTinThanhToan.setLoaiThanhToan(loaiThanhToan);
	}

	/**
	* Returns the ten nguoi nop tien of this thong tin thanh toan.
	*
	* @return the ten nguoi nop tien of this thong tin thanh toan
	*/
	public java.lang.String getTenNguoiNopTien() {
		return _thongTinThanhToan.getTenNguoiNopTien();
	}

	/**
	* Sets the ten nguoi nop tien of this thong tin thanh toan.
	*
	* @param tenNguoiNopTien the ten nguoi nop tien of this thong tin thanh toan
	*/
	public void setTenNguoiNopTien(java.lang.String tenNguoiNopTien) {
		_thongTinThanhToan.setTenNguoiNopTien(tenNguoiNopTien);
	}

	/**
	* Returns the ten can bo nhan tien of this thong tin thanh toan.
	*
	* @return the ten can bo nhan tien of this thong tin thanh toan
	*/
	public java.lang.String getTenCanBoNhanTien() {
		return _thongTinThanhToan.getTenCanBoNhanTien();
	}

	/**
	* Sets the ten can bo nhan tien of this thong tin thanh toan.
	*
	* @param tenCanBoNhanTien the ten can bo nhan tien of this thong tin thanh toan
	*/
	public void setTenCanBoNhanTien(java.lang.String tenCanBoNhanTien) {
		_thongTinThanhToan.setTenCanBoNhanTien(tenCanBoNhanTien);
	}

	/**
	* Returns the xac nhan of this thong tin thanh toan.
	*
	* @return the xac nhan of this thong tin thanh toan
	*/
	public long getXacNhan() {
		return _thongTinThanhToan.getXacNhan();
	}

	/**
	* Sets the xac nhan of this thong tin thanh toan.
	*
	* @param xacNhan the xac nhan of this thong tin thanh toan
	*/
	public void setXacNhan(long xacNhan) {
		_thongTinThanhToan.setXacNhan(xacNhan);
	}

	/**
	* Returns the loai phi of this thong tin thanh toan.
	*
	* @return the loai phi of this thong tin thanh toan
	*/
	public long getLoaiPhi() {
		return _thongTinThanhToan.getLoaiPhi();
	}

	/**
	* Sets the loai phi of this thong tin thanh toan.
	*
	* @param loaiPhi the loai phi of this thong tin thanh toan
	*/
	public void setLoaiPhi(long loaiPhi) {
		_thongTinThanhToan.setLoaiPhi(loaiPhi);
	}

	/**
	* Returns the so tien of this thong tin thanh toan.
	*
	* @return the so tien of this thong tin thanh toan
	*/
	public long getSoTien() {
		return _thongTinThanhToan.getSoTien();
	}

	/**
	* Sets the so tien of this thong tin thanh toan.
	*
	* @param soTien the so tien of this thong tin thanh toan
	*/
	public void setSoTien(long soTien) {
		_thongTinThanhToan.setSoTien(soTien);
	}

	/**
	* Returns the ngay thu tien of this thong tin thanh toan.
	*
	* @return the ngay thu tien of this thong tin thanh toan
	*/
	public java.util.Date getNgayThuTien() {
		return _thongTinThanhToan.getNgayThuTien();
	}

	/**
	* Sets the ngay thu tien of this thong tin thanh toan.
	*
	* @param ngayThuTien the ngay thu tien of this thong tin thanh toan
	*/
	public void setNgayThuTien(java.util.Date ngayThuTien) {
		_thongTinThanhToan.setNgayThuTien(ngayThuTien);
	}

	/**
	* Returns the ngay xac nhan of this thong tin thanh toan.
	*
	* @return the ngay xac nhan of this thong tin thanh toan
	*/
	public java.util.Date getNgayXacNhan() {
		return _thongTinThanhToan.getNgayXacNhan();
	}

	/**
	* Sets the ngay xac nhan of this thong tin thanh toan.
	*
	* @param ngayXacNhan the ngay xac nhan of this thong tin thanh toan
	*/
	public void setNgayXacNhan(java.util.Date ngayXacNhan) {
		_thongTinThanhToan.setNgayXacNhan(ngayXacNhan);
	}

	/**
	* Returns the ngay chuyen tien of this thong tin thanh toan.
	*
	* @return the ngay chuyen tien of this thong tin thanh toan
	*/
	public java.util.Date getNgayChuyenTien() {
		return _thongTinThanhToan.getNgayChuyenTien();
	}

	/**
	* Sets the ngay chuyen tien of this thong tin thanh toan.
	*
	* @param ngayChuyenTien the ngay chuyen tien of this thong tin thanh toan
	*/
	public void setNgayChuyenTien(java.util.Date ngayChuyenTien) {
		_thongTinThanhToan.setNgayChuyenTien(ngayChuyenTien);
	}

	/**
	* Returns the y kien of this thong tin thanh toan.
	*
	* @return the y kien of this thong tin thanh toan
	*/
	public java.lang.String getYKien() {
		return _thongTinThanhToan.getYKien();
	}

	/**
	* Sets the y kien of this thong tin thanh toan.
	*
	* @param yKien the y kien of this thong tin thanh toan
	*/
	public void setYKien(java.lang.String yKien) {
		_thongTinThanhToan.setYKien(yKien);
	}

	/**
	* Returns the noi luu tru ID of this thong tin thanh toan.
	*
	* @return the noi luu tru ID of this thong tin thanh toan
	*/
	public long getNoiLuuTruId() {
		return _thongTinThanhToan.getNoiLuuTruId();
	}

	/**
	* Sets the noi luu tru ID of this thong tin thanh toan.
	*
	* @param noiLuuTruId the noi luu tru ID of this thong tin thanh toan
	*/
	public void setNoiLuuTruId(long noiLuuTruId) {
		_thongTinThanhToan.setNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the nguoi tao of this thong tin thanh toan.
	*
	* @return the nguoi tao of this thong tin thanh toan
	*/
	public java.lang.String getNguoiTao() {
		return _thongTinThanhToan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this thong tin thanh toan.
	*
	* @param nguoiTao the nguoi tao of this thong tin thanh toan
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_thongTinThanhToan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this thong tin thanh toan.
	*
	* @return the nguoi sua of this thong tin thanh toan
	*/
	public java.lang.String getNguoiSua() {
		return _thongTinThanhToan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this thong tin thanh toan.
	*
	* @param nguoiSua the nguoi sua of this thong tin thanh toan
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_thongTinThanhToan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay tao of this thong tin thanh toan.
	*
	* @return the ngay tao of this thong tin thanh toan
	*/
	public java.util.Date getNgayTao() {
		return _thongTinThanhToan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this thong tin thanh toan.
	*
	* @param ngayTao the ngay tao of this thong tin thanh toan
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_thongTinThanhToan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this thong tin thanh toan.
	*
	* @return the ngay sua of this thong tin thanh toan
	*/
	public java.util.Date getNgaySua() {
		return _thongTinThanhToan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this thong tin thanh toan.
	*
	* @param ngaySua the ngay sua of this thong tin thanh toan
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_thongTinThanhToan.setNgaySua(ngaySua);
	}

	public boolean isNew() {
		return _thongTinThanhToan.isNew();
	}

	public void setNew(boolean n) {
		_thongTinThanhToan.setNew(n);
	}

	public boolean isCachedModel() {
		return _thongTinThanhToan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_thongTinThanhToan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _thongTinThanhToan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _thongTinThanhToan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_thongTinThanhToan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _thongTinThanhToan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_thongTinThanhToan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ThongTinThanhToanWrapper((ThongTinThanhToan)_thongTinThanhToan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan thongTinThanhToan) {
		return _thongTinThanhToan.compareTo(thongTinThanhToan);
	}

	@Override
	public int hashCode() {
		return _thongTinThanhToan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan> toCacheModel() {
		return _thongTinThanhToan.toCacheModel();
	}

	public org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan toEscapedModel() {
		return new ThongTinThanhToanWrapper(_thongTinThanhToan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _thongTinThanhToan.toString();
	}

	public java.lang.String toXmlString() {
		return _thongTinThanhToan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_thongTinThanhToan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ThongTinThanhToan getWrappedThongTinThanhToan() {
		return _thongTinThanhToan;
	}

	public ThongTinThanhToan getWrappedModel() {
		return _thongTinThanhToan;
	}

	public void resetOriginalValues() {
		_thongTinThanhToan.resetOriginalValues();
	}

	private ThongTinThanhToan _thongTinThanhToan;
}