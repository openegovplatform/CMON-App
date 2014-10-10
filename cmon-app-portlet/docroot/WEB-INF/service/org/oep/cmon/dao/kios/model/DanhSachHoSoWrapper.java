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

package org.oep.cmon.dao.kios.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DanhSachHoSo}.
 * </p>
 *
 * @author    VIENPN
 * @see       DanhSachHoSo
 * @generated
 */
public class DanhSachHoSoWrapper implements DanhSachHoSo,
	ModelWrapper<DanhSachHoSo> {
	public DanhSachHoSoWrapper(DanhSachHoSo danhSachHoSo) {
		_danhSachHoSo = danhSachHoSo;
	}

	public Class<?> getModelClass() {
		return DanhSachHoSo.class;
	}

	public String getModelClassName() {
		return DanhSachHoSo.class.getName();
	}

	/**
	* Returns the primary key of this danh sach ho so.
	*
	* @return the primary key of this danh sach ho so
	*/
	public long getPrimaryKey() {
		return _danhSachHoSo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this danh sach ho so.
	*
	* @param primaryKey the primary key of this danh sach ho so
	*/
	public void setPrimaryKey(long primaryKey) {
		_danhSachHoSo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this danh sach ho so.
	*
	* @return the ID of this danh sach ho so
	*/
	public long getId() {
		return _danhSachHoSo.getId();
	}

	/**
	* Sets the ID of this danh sach ho so.
	*
	* @param id the ID of this danh sach ho so
	*/
	public void setId(long id) {
		_danhSachHoSo.setId(id);
	}

	/**
	* Returns the ngay nhan ho so of this danh sach ho so.
	*
	* @return the ngay nhan ho so of this danh sach ho so
	*/
	public java.util.Date getNgayNhanHoSo() {
		return _danhSachHoSo.getNgayNhanHoSo();
	}

	/**
	* Sets the ngay nhan ho so of this danh sach ho so.
	*
	* @param ngayNhanHoSo the ngay nhan ho so of this danh sach ho so
	*/
	public void setNgayNhanHoSo(java.util.Date ngayNhanHoSo) {
		_danhSachHoSo.setNgayNhanHoSo(ngayNhanHoSo);
	}

	/**
	* Returns the ten co quan tiep nhan of this danh sach ho so.
	*
	* @return the ten co quan tiep nhan of this danh sach ho so
	*/
	public java.lang.String getTenCoQuanTiepNhan() {
		return _danhSachHoSo.getTenCoQuanTiepNhan();
	}

	/**
	* Sets the ten co quan tiep nhan of this danh sach ho so.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan of this danh sach ho so
	*/
	public void setTenCoQuanTiepNhan(java.lang.String tenCoQuanTiepNhan) {
		_danhSachHoSo.setTenCoQuanTiepNhan(tenCoQuanTiepNhan);
	}

	/**
	* Returns the ten thu tuc hanh chinh of this danh sach ho so.
	*
	* @return the ten thu tuc hanh chinh of this danh sach ho so
	*/
	public java.lang.String getTenThuTucHanhChinh() {
		return _danhSachHoSo.getTenThuTucHanhChinh();
	}

	/**
	* Sets the ten thu tuc hanh chinh of this danh sach ho so.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh of this danh sach ho so
	*/
	public void setTenThuTucHanhChinh(java.lang.String tenThuTucHanhChinh) {
		_danhSachHoSo.setTenThuTucHanhChinh(tenThuTucHanhChinh);
	}

	/**
	* Returns the ngay hen tra ket qua of this danh sach ho so.
	*
	* @return the ngay hen tra ket qua of this danh sach ho so
	*/
	public java.util.Date getNgayHenTraKetQua() {
		return _danhSachHoSo.getNgayHenTraKetQua();
	}

	/**
	* Sets the ngay hen tra ket qua of this danh sach ho so.
	*
	* @param ngayHenTraKetQua the ngay hen tra ket qua of this danh sach ho so
	*/
	public void setNgayHenTraKetQua(java.util.Date ngayHenTraKetQua) {
		_danhSachHoSo.setNgayHenTraKetQua(ngayHenTraKetQua);
	}

	/**
	* Returns the ngay tra ket qua of this danh sach ho so.
	*
	* @return the ngay tra ket qua of this danh sach ho so
	*/
	public java.util.Date getNgayTraKetQua() {
		return _danhSachHoSo.getNgayTraKetQua();
	}

	/**
	* Sets the ngay tra ket qua of this danh sach ho so.
	*
	* @param ngayTraKetQua the ngay tra ket qua of this danh sach ho so
	*/
	public void setNgayTraKetQua(java.util.Date ngayTraKetQua) {
		_danhSachHoSo.setNgayTraKetQua(ngayTraKetQua);
	}

	/**
	* Returns the ho ten nguoi nop ho so of this danh sach ho so.
	*
	* @return the ho ten nguoi nop ho so of this danh sach ho so
	*/
	public java.lang.String getHoTenNguoiNopHoSo() {
		return _danhSachHoSo.getHoTenNguoiNopHoSo();
	}

	/**
	* Sets the ho ten nguoi nop ho so of this danh sach ho so.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so of this danh sach ho so
	*/
	public void setHoTenNguoiNopHoSo(java.lang.String hoTenNguoiNopHoSo) {
		_danhSachHoSo.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
	}

	/**
	* Returns the dia chi thuong tru nguoi nop of this danh sach ho so.
	*
	* @return the dia chi thuong tru nguoi nop of this danh sach ho so
	*/
	public java.lang.String getDiaChiThuongTruNguoiNop() {
		return _danhSachHoSo.getDiaChiThuongTruNguoiNop();
	}

	/**
	* Sets the dia chi thuong tru nguoi nop of this danh sach ho so.
	*
	* @param diaChiThuongTruNguoiNop the dia chi thuong tru nguoi nop of this danh sach ho so
	*/
	public void setDiaChiThuongTruNguoiNop(
		java.lang.String diaChiThuongTruNguoiNop) {
		_danhSachHoSo.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
	}

	/**
	* Returns the so dien thoai di dong nguoi nop of this danh sach ho so.
	*
	* @return the so dien thoai di dong nguoi nop of this danh sach ho so
	*/
	public java.lang.String getSoDienThoaiDiDongNguoiNop() {
		return _danhSachHoSo.getSoDienThoaiDiDongNguoiNop();
	}

	/**
	* Sets the so dien thoai di dong nguoi nop of this danh sach ho so.
	*
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop of this danh sach ho so
	*/
	public void setSoDienThoaiDiDongNguoiNop(
		java.lang.String soDienThoaiDiDongNguoiNop) {
		_danhSachHoSo.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
	}

	/**
	* Returns the ngay ket thuc xu ly of this danh sach ho so.
	*
	* @return the ngay ket thuc xu ly of this danh sach ho so
	*/
	public java.util.Date getNgayKetThucXuLy() {
		return _danhSachHoSo.getNgayKetThucXuLy();
	}

	/**
	* Sets the ngay ket thuc xu ly of this danh sach ho so.
	*
	* @param ngayKetThucXuLy the ngay ket thuc xu ly of this danh sach ho so
	*/
	public void setNgayKetThucXuLy(java.util.Date ngayKetThucXuLy) {
		_danhSachHoSo.setNgayKetThucXuLy(ngayKetThucXuLy);
	}

	/**
	* Returns the loai ho so of this danh sach ho so.
	*
	* @return the loai ho so of this danh sach ho so
	*/
	public int getLoaiHoSo() {
		return _danhSachHoSo.getLoaiHoSo();
	}

	/**
	* Sets the loai ho so of this danh sach ho so.
	*
	* @param loaiHoSo the loai ho so of this danh sach ho so
	*/
	public void setLoaiHoSo(int loaiHoSo) {
		_danhSachHoSo.setLoaiHoSo(loaiHoSo);
	}

	/**
	* Returns the ma so bien nhan of this danh sach ho so.
	*
	* @return the ma so bien nhan of this danh sach ho so
	*/
	public java.lang.String getMaSoBienNhan() {
		return _danhSachHoSo.getMaSoBienNhan();
	}

	/**
	* Sets the ma so bien nhan of this danh sach ho so.
	*
	* @param maSoBienNhan the ma so bien nhan of this danh sach ho so
	*/
	public void setMaSoBienNhan(java.lang.String maSoBienNhan) {
		_danhSachHoSo.setMaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns the chu so huu of this danh sach ho so.
	*
	* @return the chu so huu of this danh sach ho so
	*/
	public java.lang.String getChuSoHuu() {
		return _danhSachHoSo.getChuSoHuu();
	}

	/**
	* Sets the chu so huu of this danh sach ho so.
	*
	* @param chuSoHuu the chu so huu of this danh sach ho so
	*/
	public void setChuSoHuu(java.lang.String chuSoHuu) {
		_danhSachHoSo.setChuSoHuu(chuSoHuu);
	}

	/**
	* Returns the le phi of this danh sach ho so.
	*
	* @return the le phi of this danh sach ho so
	*/
	public int getLePhi() {
		return _danhSachHoSo.getLePhi();
	}

	/**
	* Sets the le phi of this danh sach ho so.
	*
	* @param lePhi the le phi of this danh sach ho so
	*/
	public void setLePhi(int lePhi) {
		_danhSachHoSo.setLePhi(lePhi);
	}

	/**
	* Returns the phi ho so of this danh sach ho so.
	*
	* @return the phi ho so of this danh sach ho so
	*/
	public int getPhiHoSo() {
		return _danhSachHoSo.getPhiHoSo();
	}

	/**
	* Sets the phi ho so of this danh sach ho so.
	*
	* @param phiHoSo the phi ho so of this danh sach ho so
	*/
	public void setPhiHoSo(int phiHoSo) {
		_danhSachHoSo.setPhiHoSo(phiHoSo);
	}

	/**
	* Returns the email nguoi nop of this danh sach ho so.
	*
	* @return the email nguoi nop of this danh sach ho so
	*/
	public java.lang.String getEmailNguoiNop() {
		return _danhSachHoSo.getEmailNguoiNop();
	}

	/**
	* Sets the email nguoi nop of this danh sach ho so.
	*
	* @param emailNguoiNop the email nguoi nop of this danh sach ho so
	*/
	public void setEmailNguoiNop(java.lang.String emailNguoiNop) {
		_danhSachHoSo.setEmailNguoiNop(emailNguoiNop);
	}

	/**
	* Returns the so dien thoai co dinh nguoi nop of this danh sach ho so.
	*
	* @return the so dien thoai co dinh nguoi nop of this danh sach ho so
	*/
	public java.lang.String getSoDienThoaiCoDinhNguoiNop() {
		return _danhSachHoSo.getSoDienThoaiCoDinhNguoiNop();
	}

	/**
	* Sets the so dien thoai co dinh nguoi nop of this danh sach ho so.
	*
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop of this danh sach ho so
	*/
	public void setSoDienThoaiCoDinhNguoiNop(
		java.lang.String soDienThoaiCoDinhNguoiNop) {
		_danhSachHoSo.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Returns the nhom thu tuc hanh chinh ten of this danh sach ho so.
	*
	* @return the nhom thu tuc hanh chinh ten of this danh sach ho so
	*/
	public java.lang.String getNhomThuTucHanhChinhTen() {
		return _danhSachHoSo.getNhomThuTucHanhChinhTen();
	}

	/**
	* Sets the nhom thu tuc hanh chinh ten of this danh sach ho so.
	*
	* @param nhomThuTucHanhChinhTen the nhom thu tuc hanh chinh ten of this danh sach ho so
	*/
	public void setNhomThuTucHanhChinhTen(
		java.lang.String nhomThuTucHanhChinhTen) {
		_danhSachHoSo.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinhTen);
	}

	/**
	* Returns the trang thai ho so ten of this danh sach ho so.
	*
	* @return the trang thai ho so ten of this danh sach ho so
	*/
	public java.lang.String getTrangThaiHoSoTen() {
		return _danhSachHoSo.getTrangThaiHoSoTen();
	}

	/**
	* Sets the trang thai ho so ten of this danh sach ho so.
	*
	* @param trangThaiHoSoTen the trang thai ho so ten of this danh sach ho so
	*/
	public void setTrangThaiHoSoTen(java.lang.String trangThaiHoSoTen) {
		_danhSachHoSo.setTrangThaiHoSoTen(trangThaiHoSoTen);
	}

	/**
	* Returns the r num of this danh sach ho so.
	*
	* @return the r num of this danh sach ho so
	*/
	public int getRNum() {
		return _danhSachHoSo.getRNum();
	}

	/**
	* Sets the r num of this danh sach ho so.
	*
	* @param rNum the r num of this danh sach ho so
	*/
	public void setRNum(int rNum) {
		_danhSachHoSo.setRNum(rNum);
	}

	public boolean isNew() {
		return _danhSachHoSo.isNew();
	}

	public void setNew(boolean n) {
		_danhSachHoSo.setNew(n);
	}

	public boolean isCachedModel() {
		return _danhSachHoSo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_danhSachHoSo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _danhSachHoSo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _danhSachHoSo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_danhSachHoSo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _danhSachHoSo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_danhSachHoSo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DanhSachHoSoWrapper((DanhSachHoSo)_danhSachHoSo.clone());
	}

	public int compareTo(org.oep.cmon.dao.kios.model.DanhSachHoSo danhSachHoSo) {
		return _danhSachHoSo.compareTo(danhSachHoSo);
	}

	@Override
	public int hashCode() {
		return _danhSachHoSo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.kios.model.DanhSachHoSo> toCacheModel() {
		return _danhSachHoSo.toCacheModel();
	}

	public org.oep.cmon.dao.kios.model.DanhSachHoSo toEscapedModel() {
		return new DanhSachHoSoWrapper(_danhSachHoSo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _danhSachHoSo.toString();
	}

	public java.lang.String toXmlString() {
		return _danhSachHoSo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_danhSachHoSo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DanhSachHoSo getWrappedDanhSachHoSo() {
		return _danhSachHoSo;
	}

	public DanhSachHoSo getWrappedModel() {
		return _danhSachHoSo;
	}

	public void resetOriginalValues() {
		_danhSachHoSo.resetOriginalValues();
	}

	private DanhSachHoSo _danhSachHoSo;
}