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

package org.oep.cmon.dao.hosohcc.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link HoSoTTHCCong}.
 * </p>
 *
 * @author    LIEMNn
 * @see       HoSoTTHCCong
 * @generated
 */
public class HoSoTTHCCongWrapper implements HoSoTTHCCong,
	ModelWrapper<HoSoTTHCCong> {
	public HoSoTTHCCongWrapper(HoSoTTHCCong hoSoTTHCCong) {
		_hoSoTTHCCong = hoSoTTHCCong;
	}

	public Class<?> getModelClass() {
		return HoSoTTHCCong.class;
	}

	public String getModelClassName() {
		return HoSoTTHCCong.class.getName();
	}

	/**
	* Returns the primary key of this ho so t t h c cong.
	*
	* @return the primary key of this ho so t t h c cong
	*/
	public long getPrimaryKey() {
		return _hoSoTTHCCong.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ho so t t h c cong.
	*
	* @param primaryKey the primary key of this ho so t t h c cong
	*/
	public void setPrimaryKey(long primaryKey) {
		_hoSoTTHCCong.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this ho so t t h c cong.
	*
	* @return the ID of this ho so t t h c cong
	*/
	public long getId() {
		return _hoSoTTHCCong.getId();
	}

	/**
	* Sets the ID of this ho so t t h c cong.
	*
	* @param id the ID of this ho so t t h c cong
	*/
	public void setId(long id) {
		_hoSoTTHCCong.setId(id);
	}

	/**
	* Returns the ma so ho so of this ho so t t h c cong.
	*
	* @return the ma so ho so of this ho so t t h c cong
	*/
	public java.lang.String getMaSoHoSo() {
		return _hoSoTTHCCong.getMaSoHoSo();
	}

	/**
	* Sets the ma so ho so of this ho so t t h c cong.
	*
	* @param maSoHoSo the ma so ho so of this ho so t t h c cong
	*/
	public void setMaSoHoSo(java.lang.String maSoHoSo) {
		_hoSoTTHCCong.setMaSoHoSo(maSoHoSo);
	}

	/**
	* Returns the ngay nop ho so of this ho so t t h c cong.
	*
	* @return the ngay nop ho so of this ho so t t h c cong
	*/
	public java.util.Date getNgayNopHoSo() {
		return _hoSoTTHCCong.getNgayNopHoSo();
	}

	/**
	* Sets the ngay nop ho so of this ho so t t h c cong.
	*
	* @param ngayNopHoSo the ngay nop ho so of this ho so t t h c cong
	*/
	public void setNgayNopHoSo(java.util.Date ngayNopHoSo) {
		_hoSoTTHCCong.setNgayNopHoSo(ngayNopHoSo);
	}

	/**
	* Returns the ngay nhan ho so of this ho so t t h c cong.
	*
	* @return the ngay nhan ho so of this ho so t t h c cong
	*/
	public java.util.Date getNgayNhanHoSo() {
		return _hoSoTTHCCong.getNgayNhanHoSo();
	}

	/**
	* Sets the ngay nhan ho so of this ho so t t h c cong.
	*
	* @param ngayNhanHoSo the ngay nhan ho so of this ho so t t h c cong
	*/
	public void setNgayNhanHoSo(java.util.Date ngayNhanHoSo) {
		_hoSoTTHCCong.setNgayNhanHoSo(ngayNhanHoSo);
	}

	/**
	* Returns the ten co quan tiep nhan of this ho so t t h c cong.
	*
	* @return the ten co quan tiep nhan of this ho so t t h c cong
	*/
	public java.lang.String getTenCoQuanTiepNhan() {
		return _hoSoTTHCCong.getTenCoQuanTiepNhan();
	}

	/**
	* Sets the ten co quan tiep nhan of this ho so t t h c cong.
	*
	* @param tenCoQuanTiepNhan the ten co quan tiep nhan of this ho so t t h c cong
	*/
	public void setTenCoQuanTiepNhan(java.lang.String tenCoQuanTiepNhan) {
		_hoSoTTHCCong.setTenCoQuanTiepNhan(tenCoQuanTiepNhan);
	}

	/**
	* Returns the ten thu tuc hanh chinh of this ho so t t h c cong.
	*
	* @return the ten thu tuc hanh chinh of this ho so t t h c cong
	*/
	public java.lang.String getTenThuTucHanhChinh() {
		return _hoSoTTHCCong.getTenThuTucHanhChinh();
	}

	/**
	* Sets the ten thu tuc hanh chinh of this ho so t t h c cong.
	*
	* @param tenThuTucHanhChinh the ten thu tuc hanh chinh of this ho so t t h c cong
	*/
	public void setTenThuTucHanhChinh(java.lang.String tenThuTucHanhChinh) {
		_hoSoTTHCCong.setTenThuTucHanhChinh(tenThuTucHanhChinh);
	}

	/**
	* Returns the ngay hen tra ket qua of this ho so t t h c cong.
	*
	* @return the ngay hen tra ket qua of this ho so t t h c cong
	*/
	public java.util.Date getNgayHenTraKetQua() {
		return _hoSoTTHCCong.getNgayHenTraKetQua();
	}

	/**
	* Sets the ngay hen tra ket qua of this ho so t t h c cong.
	*
	* @param ngayHenTraKetQua the ngay hen tra ket qua of this ho so t t h c cong
	*/
	public void setNgayHenTraKetQua(java.util.Date ngayHenTraKetQua) {
		_hoSoTTHCCong.setNgayHenTraKetQua(ngayHenTraKetQua);
	}

	/**
	* Returns the ngay tra ket qua of this ho so t t h c cong.
	*
	* @return the ngay tra ket qua of this ho so t t h c cong
	*/
	public java.util.Date getNgayTraKetQua() {
		return _hoSoTTHCCong.getNgayTraKetQua();
	}

	/**
	* Sets the ngay tra ket qua of this ho so t t h c cong.
	*
	* @param ngayTraKetQua the ngay tra ket qua of this ho so t t h c cong
	*/
	public void setNgayTraKetQua(java.util.Date ngayTraKetQua) {
		_hoSoTTHCCong.setNgayTraKetQua(ngayTraKetQua);
	}

	/**
	* Returns the ngay nop ho so goc of this ho so t t h c cong.
	*
	* @return the ngay nop ho so goc of this ho so t t h c cong
	*/
	public java.util.Date getNgayNopHoSoGoc() {
		return _hoSoTTHCCong.getNgayNopHoSoGoc();
	}

	/**
	* Sets the ngay nop ho so goc of this ho so t t h c cong.
	*
	* @param ngayNopHoSoGoc the ngay nop ho so goc of this ho so t t h c cong
	*/
	public void setNgayNopHoSoGoc(java.util.Date ngayNopHoSoGoc) {
		_hoSoTTHCCong.setNgayNopHoSoGoc(ngayNopHoSoGoc);
	}

	/**
	* Returns the ngay hen nop ho so goc of this ho so t t h c cong.
	*
	* @return the ngay hen nop ho so goc of this ho so t t h c cong
	*/
	public java.util.Date getNgayHenNopHoSoGoc() {
		return _hoSoTTHCCong.getNgayHenNopHoSoGoc();
	}

	/**
	* Sets the ngay hen nop ho so goc of this ho so t t h c cong.
	*
	* @param ngayHenNopHoSoGoc the ngay hen nop ho so goc of this ho so t t h c cong
	*/
	public void setNgayHenNopHoSoGoc(java.util.Date ngayHenNopHoSoGoc) {
		_hoSoTTHCCong.setNgayHenNopHoSoGoc(ngayHenNopHoSoGoc);
	}

	/**
	* Returns the ten can bo tiep nhan of this ho so t t h c cong.
	*
	* @return the ten can bo tiep nhan of this ho so t t h c cong
	*/
	public java.lang.String getTenCanBoTiepNhan() {
		return _hoSoTTHCCong.getTenCanBoTiepNhan();
	}

	/**
	* Sets the ten can bo tiep nhan of this ho so t t h c cong.
	*
	* @param tenCanBoTiepNhan the ten can bo tiep nhan of this ho so t t h c cong
	*/
	public void setTenCanBoTiepNhan(java.lang.String tenCanBoTiepNhan) {
		_hoSoTTHCCong.setTenCanBoTiepNhan(tenCanBoTiepNhan);
	}

	/**
	* Returns the chuc vu can bo tiep nhan of this ho so t t h c cong.
	*
	* @return the chuc vu can bo tiep nhan of this ho so t t h c cong
	*/
	public java.lang.String getChucVuCanBoTiepNhan() {
		return _hoSoTTHCCong.getChucVuCanBoTiepNhan();
	}

	/**
	* Sets the chuc vu can bo tiep nhan of this ho so t t h c cong.
	*
	* @param chucVuCanBoTiepNhan the chuc vu can bo tiep nhan of this ho so t t h c cong
	*/
	public void setChucVuCanBoTiepNhan(java.lang.String chucVuCanBoTiepNhan) {
		_hoSoTTHCCong.setChucVuCanBoTiepNhan(chucVuCanBoTiepNhan);
	}

	/**
	* Returns the ho ten nguoi nop ho so of this ho so t t h c cong.
	*
	* @return the ho ten nguoi nop ho so of this ho so t t h c cong
	*/
	public java.lang.String getHoTenNguoiNopHoSo() {
		return _hoSoTTHCCong.getHoTenNguoiNopHoSo();
	}

	/**
	* Sets the ho ten nguoi nop ho so of this ho so t t h c cong.
	*
	* @param hoTenNguoiNopHoSo the ho ten nguoi nop ho so of this ho so t t h c cong
	*/
	public void setHoTenNguoiNopHoSo(java.lang.String hoTenNguoiNopHoSo) {
		_hoSoTTHCCong.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
	}

	/**
	* Returns the dia chi thuong tru nguoi nop of this ho so t t h c cong.
	*
	* @return the dia chi thuong tru nguoi nop of this ho so t t h c cong
	*/
	public java.lang.String getDiaChiThuongTruNguoiNop() {
		return _hoSoTTHCCong.getDiaChiThuongTruNguoiNop();
	}

	/**
	* Sets the dia chi thuong tru nguoi nop of this ho so t t h c cong.
	*
	* @param diaChiThuongTruNguoiNop the dia chi thuong tru nguoi nop of this ho so t t h c cong
	*/
	public void setDiaChiThuongTruNguoiNop(
		java.lang.String diaChiThuongTruNguoiNop) {
		_hoSoTTHCCong.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
	}

	/**
	* Returns the so dien thoai co dinh nguoi nop of this ho so t t h c cong.
	*
	* @return the so dien thoai co dinh nguoi nop of this ho so t t h c cong
	*/
	public java.lang.String getSoDienThoaiCoDinhNguoiNop() {
		return _hoSoTTHCCong.getSoDienThoaiCoDinhNguoiNop();
	}

	/**
	* Sets the so dien thoai co dinh nguoi nop of this ho so t t h c cong.
	*
	* @param soDienThoaiCoDinhNguoiNop the so dien thoai co dinh nguoi nop of this ho so t t h c cong
	*/
	public void setSoDienThoaiCoDinhNguoiNop(
		java.lang.String soDienThoaiCoDinhNguoiNop) {
		_hoSoTTHCCong.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
	}

	/**
	* Returns the ten can bo tra ket qua of this ho so t t h c cong.
	*
	* @return the ten can bo tra ket qua of this ho so t t h c cong
	*/
	public java.lang.String getTenCanBoTraKetQua() {
		return _hoSoTTHCCong.getTenCanBoTraKetQua();
	}

	/**
	* Sets the ten can bo tra ket qua of this ho so t t h c cong.
	*
	* @param tenCanBoTraKetQua the ten can bo tra ket qua of this ho so t t h c cong
	*/
	public void setTenCanBoTraKetQua(java.lang.String tenCanBoTraKetQua) {
		_hoSoTTHCCong.setTenCanBoTraKetQua(tenCanBoTraKetQua);
	}

	/**
	* Returns the chuc vu can bo tra ket qua of this ho so t t h c cong.
	*
	* @return the chuc vu can bo tra ket qua of this ho so t t h c cong
	*/
	public java.lang.String getChucVuCanBoTraKetQua() {
		return _hoSoTTHCCong.getChucVuCanBoTraKetQua();
	}

	/**
	* Sets the chuc vu can bo tra ket qua of this ho so t t h c cong.
	*
	* @param chucVuCanBoTraKetQua the chuc vu can bo tra ket qua of this ho so t t h c cong
	*/
	public void setChucVuCanBoTraKetQua(java.lang.String chucVuCanBoTraKetQua) {
		_hoSoTTHCCong.setChucVuCanBoTraKetQua(chucVuCanBoTraKetQua);
	}

	/**
	* Returns the ho ten nguoi nhan ket qua of this ho so t t h c cong.
	*
	* @return the ho ten nguoi nhan ket qua of this ho so t t h c cong
	*/
	public java.lang.String getHoTenNguoiNhanKetQua() {
		return _hoSoTTHCCong.getHoTenNguoiNhanKetQua();
	}

	/**
	* Sets the ho ten nguoi nhan ket qua of this ho so t t h c cong.
	*
	* @param hoTenNguoiNhanKetQua the ho ten nguoi nhan ket qua of this ho so t t h c cong
	*/
	public void setHoTenNguoiNhanKetQua(java.lang.String hoTenNguoiNhanKetQua) {
		_hoSoTTHCCong.setHoTenNguoiNhanKetQua(hoTenNguoiNhanKetQua);
	}

	/**
	* Returns the dia chi thuong tru nguoi nhan k q of this ho so t t h c cong.
	*
	* @return the dia chi thuong tru nguoi nhan k q of this ho so t t h c cong
	*/
	public java.lang.String getDiaChiThuongTruNguoiNhanKQ() {
		return _hoSoTTHCCong.getDiaChiThuongTruNguoiNhanKQ();
	}

	/**
	* Sets the dia chi thuong tru nguoi nhan k q of this ho so t t h c cong.
	*
	* @param diaChiThuongTruNguoiNhanKQ the dia chi thuong tru nguoi nhan k q of this ho so t t h c cong
	*/
	public void setDiaChiThuongTruNguoiNhanKQ(
		java.lang.String diaChiThuongTruNguoiNhanKQ) {
		_hoSoTTHCCong.setDiaChiThuongTruNguoiNhanKQ(diaChiThuongTruNguoiNhanKQ);
	}

	/**
	* Returns the so dien thoai nguoi nhan of this ho so t t h c cong.
	*
	* @return the so dien thoai nguoi nhan of this ho so t t h c cong
	*/
	public java.lang.String getSoDienThoaiNguoiNhan() {
		return _hoSoTTHCCong.getSoDienThoaiNguoiNhan();
	}

	/**
	* Sets the so dien thoai nguoi nhan of this ho so t t h c cong.
	*
	* @param soDienThoaiNguoiNhan the so dien thoai nguoi nhan of this ho so t t h c cong
	*/
	public void setSoDienThoaiNguoiNhan(java.lang.String soDienThoaiNguoiNhan) {
		_hoSoTTHCCong.setSoDienThoaiNguoiNhan(soDienThoaiNguoiNhan);
	}

	/**
	* Returns the ngay cap of this ho so t t h c cong.
	*
	* @return the ngay cap of this ho so t t h c cong
	*/
	public java.util.Date getNgayCap() {
		return _hoSoTTHCCong.getNgayCap();
	}

	/**
	* Sets the ngay cap of this ho so t t h c cong.
	*
	* @param ngayCap the ngay cap of this ho so t t h c cong
	*/
	public void setNgayCap(java.util.Date ngayCap) {
		_hoSoTTHCCong.setNgayCap(ngayCap);
	}

	/**
	* Returns the lan cap of this ho so t t h c cong.
	*
	* @return the lan cap of this ho so t t h c cong
	*/
	public long getLanCap() {
		return _hoSoTTHCCong.getLanCap();
	}

	/**
	* Sets the lan cap of this ho so t t h c cong.
	*
	* @param lanCap the lan cap of this ho so t t h c cong
	*/
	public void setLanCap(long lanCap) {
		_hoSoTTHCCong.setLanCap(lanCap);
	}

	/**
	* Returns the ten co quan cap of this ho so t t h c cong.
	*
	* @return the ten co quan cap of this ho so t t h c cong
	*/
	public java.lang.String getTenCoQuanCap() {
		return _hoSoTTHCCong.getTenCoQuanCap();
	}

	/**
	* Sets the ten co quan cap of this ho so t t h c cong.
	*
	* @param tenCoQuanCap the ten co quan cap of this ho so t t h c cong
	*/
	public void setTenCoQuanCap(java.lang.String tenCoQuanCap) {
		_hoSoTTHCCong.setTenCoQuanCap(tenCoQuanCap);
	}

	/**
	* Returns the hieu luc tu ngay of this ho so t t h c cong.
	*
	* @return the hieu luc tu ngay of this ho so t t h c cong
	*/
	public java.util.Date getHieuLucTuNgay() {
		return _hoSoTTHCCong.getHieuLucTuNgay();
	}

	/**
	* Sets the hieu luc tu ngay of this ho so t t h c cong.
	*
	* @param hieuLucTuNgay the hieu luc tu ngay of this ho so t t h c cong
	*/
	public void setHieuLucTuNgay(java.util.Date hieuLucTuNgay) {
		_hoSoTTHCCong.setHieuLucTuNgay(hieuLucTuNgay);
	}

	/**
	* Returns the hieu luc den ngay of this ho so t t h c cong.
	*
	* @return the hieu luc den ngay of this ho so t t h c cong
	*/
	public java.util.Date getHieuLucDenNgay() {
		return _hoSoTTHCCong.getHieuLucDenNgay();
	}

	/**
	* Sets the hieu luc den ngay of this ho so t t h c cong.
	*
	* @param hieuLucDenNgay the hieu luc den ngay of this ho so t t h c cong
	*/
	public void setHieuLucDenNgay(java.util.Date hieuLucDenNgay) {
		_hoSoTTHCCong.setHieuLucDenNgay(hieuLucDenNgay);
	}

	/**
	* Returns the trang thai ho so of this ho so t t h c cong.
	*
	* @return the trang thai ho so of this ho so t t h c cong
	*/
	public int getTrangThaiHoSo() {
		return _hoSoTTHCCong.getTrangThaiHoSo();
	}

	/**
	* Sets the trang thai ho so of this ho so t t h c cong.
	*
	* @param trangThaiHoSo the trang thai ho so of this ho so t t h c cong
	*/
	public void setTrangThaiHoSo(int trangThaiHoSo) {
		_hoSoTTHCCong.setTrangThaiHoSo(trangThaiHoSo);
	}

	/**
	* Returns the da xoa of this ho so t t h c cong.
	*
	* @return the da xoa of this ho so t t h c cong
	*/
	public int getDaXoa() {
		return _hoSoTTHCCong.getDaXoa();
	}

	/**
	* Sets the da xoa of this ho so t t h c cong.
	*
	* @param daXoa the da xoa of this ho so t t h c cong
	*/
	public void setDaXoa(int daXoa) {
		_hoSoTTHCCong.setDaXoa(daXoa);
	}

	/**
	* Returns the nguoi tao of this ho so t t h c cong.
	*
	* @return the nguoi tao of this ho so t t h c cong
	*/
	public java.lang.String getNguoiTao() {
		return _hoSoTTHCCong.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this ho so t t h c cong.
	*
	* @param nguoiTao the nguoi tao of this ho so t t h c cong
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_hoSoTTHCCong.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the ngay tao of this ho so t t h c cong.
	*
	* @return the ngay tao of this ho so t t h c cong
	*/
	public java.util.Date getNgayTao() {
		return _hoSoTTHCCong.getNgayTao();
	}

	/**
	* Sets the ngay tao of this ho so t t h c cong.
	*
	* @param ngayTao the ngay tao of this ho so t t h c cong
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_hoSoTTHCCong.setNgayTao(ngayTao);
	}

	/**
	* Returns the nguoi sua of this ho so t t h c cong.
	*
	* @return the nguoi sua of this ho so t t h c cong
	*/
	public java.lang.String getNguoiSua() {
		return _hoSoTTHCCong.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this ho so t t h c cong.
	*
	* @param nguoiSua the nguoi sua of this ho so t t h c cong
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_hoSoTTHCCong.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the ngay sua of this ho so t t h c cong.
	*
	* @return the ngay sua of this ho so t t h c cong
	*/
	public java.util.Date getNgaySua() {
		return _hoSoTTHCCong.getNgaySua();
	}

	/**
	* Sets the ngay sua of this ho so t t h c cong.
	*
	* @param ngaySua the ngay sua of this ho so t t h c cong
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_hoSoTTHCCong.setNgaySua(ngaySua);
	}

	/**
	* Returns the thu tuc hanh chinh ID of this ho so t t h c cong.
	*
	* @return the thu tuc hanh chinh ID of this ho so t t h c cong
	*/
	public java.lang.Long getThuTucHanhChinhId() {
		return _hoSoTTHCCong.getThuTucHanhChinhId();
	}

	/**
	* Sets the thu tuc hanh chinh ID of this ho so t t h c cong.
	*
	* @param thuTucHanhChinhId the thu tuc hanh chinh ID of this ho so t t h c cong
	*/
	public void setThuTucHanhChinhId(java.lang.Long thuTucHanhChinhId) {
		_hoSoTTHCCong.setThuTucHanhChinhId(thuTucHanhChinhId);
	}

	/**
	* Returns the cong dan nop ID of this ho so t t h c cong.
	*
	* @return the cong dan nop ID of this ho so t t h c cong
	*/
	public java.lang.Long getCongDanNopId() {
		return _hoSoTTHCCong.getCongDanNopId();
	}

	/**
	* Sets the cong dan nop ID of this ho so t t h c cong.
	*
	* @param congDanNopId the cong dan nop ID of this ho so t t h c cong
	*/
	public void setCongDanNopId(java.lang.Long congDanNopId) {
		_hoSoTTHCCong.setCongDanNopId(congDanNopId);
	}

	/**
	* Returns the dia chi thuong tru nguoi nhan k q ID of this ho so t t h c cong.
	*
	* @return the dia chi thuong tru nguoi nhan k q ID of this ho so t t h c cong
	*/
	public java.lang.Long getDiaChiThuongTruNguoiNhanKQId() {
		return _hoSoTTHCCong.getDiaChiThuongTruNguoiNhanKQId();
	}

	/**
	* Sets the dia chi thuong tru nguoi nhan k q ID of this ho so t t h c cong.
	*
	* @param diaChiThuongTruNguoiNhanKQId the dia chi thuong tru nguoi nhan k q ID of this ho so t t h c cong
	*/
	public void setDiaChiThuongTruNguoiNhanKQId(
		java.lang.Long diaChiThuongTruNguoiNhanKQId) {
		_hoSoTTHCCong.setDiaChiThuongTruNguoiNhanKQId(diaChiThuongTruNguoiNhanKQId);
	}

	/**
	* Returns the co quan tiep nhan ID of this ho so t t h c cong.
	*
	* @return the co quan tiep nhan ID of this ho so t t h c cong
	*/
	public java.lang.Long getCoQuanTiepNhanId() {
		return _hoSoTTHCCong.getCoQuanTiepNhanId();
	}

	/**
	* Sets the co quan tiep nhan ID of this ho so t t h c cong.
	*
	* @param coQuanTiepNhanId the co quan tiep nhan ID of this ho so t t h c cong
	*/
	public void setCoQuanTiepNhanId(java.lang.Long coQuanTiepNhanId) {
		_hoSoTTHCCong.setCoQuanTiepNhanId(coQuanTiepNhanId);
	}

	/**
	* Returns the can bo tra ket qua ID of this ho so t t h c cong.
	*
	* @return the can bo tra ket qua ID of this ho so t t h c cong
	*/
	public java.lang.Long getCanBoTraKetQuaId() {
		return _hoSoTTHCCong.getCanBoTraKetQuaId();
	}

	/**
	* Sets the can bo tra ket qua ID of this ho so t t h c cong.
	*
	* @param canBoTraKetQuaId the can bo tra ket qua ID of this ho so t t h c cong
	*/
	public void setCanBoTraKetQuaId(java.lang.Long canBoTraKetQuaId) {
		_hoSoTTHCCong.setCanBoTraKetQuaId(canBoTraKetQuaId);
	}

	/**
	* Returns the can bo tiep nhan ID of this ho so t t h c cong.
	*
	* @return the can bo tiep nhan ID of this ho so t t h c cong
	*/
	public java.lang.Long getCanBoTiepNhanId() {
		return _hoSoTTHCCong.getCanBoTiepNhanId();
	}

	/**
	* Sets the can bo tiep nhan ID of this ho so t t h c cong.
	*
	* @param canBoTiepNhanId the can bo tiep nhan ID of this ho so t t h c cong
	*/
	public void setCanBoTiepNhanId(java.lang.Long canBoTiepNhanId) {
		_hoSoTTHCCong.setCanBoTiepNhanId(canBoTiepNhanId);
	}

	/**
	* Returns the dia chi thuong tru nguoi nop ID of this ho so t t h c cong.
	*
	* @return the dia chi thuong tru nguoi nop ID of this ho so t t h c cong
	*/
	public java.lang.Long getDiaChiThuongTruNguoiNopId() {
		return _hoSoTTHCCong.getDiaChiThuongTruNguoiNopId();
	}

	/**
	* Sets the dia chi thuong tru nguoi nop ID of this ho so t t h c cong.
	*
	* @param diaChiThuongTruNguoiNopId the dia chi thuong tru nguoi nop ID of this ho so t t h c cong
	*/
	public void setDiaChiThuongTruNguoiNopId(
		java.lang.Long diaChiThuongTruNguoiNopId) {
		_hoSoTTHCCong.setDiaChiThuongTruNguoiNopId(diaChiThuongTruNguoiNopId);
	}

	/**
	* Returns the so dien thoai di dong nguoi nop of this ho so t t h c cong.
	*
	* @return the so dien thoai di dong nguoi nop of this ho so t t h c cong
	*/
	public java.lang.String getSoDienThoaiDiDongNguoiNop() {
		return _hoSoTTHCCong.getSoDienThoaiDiDongNguoiNop();
	}

	/**
	* Sets the so dien thoai di dong nguoi nop of this ho so t t h c cong.
	*
	* @param soDienThoaiDiDongNguoiNop the so dien thoai di dong nguoi nop of this ho so t t h c cong
	*/
	public void setSoDienThoaiDiDongNguoiNop(
		java.lang.String soDienThoaiDiDongNguoiNop) {
		_hoSoTTHCCong.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
	}

	/**
	* Returns the phong ban xu ly hien thoi ID of this ho so t t h c cong.
	*
	* @return the phong ban xu ly hien thoi ID of this ho so t t h c cong
	*/
	public java.lang.Long getPhongBanXuLyHienThoiId() {
		return _hoSoTTHCCong.getPhongBanXuLyHienThoiId();
	}

	/**
	* Sets the phong ban xu ly hien thoi ID of this ho so t t h c cong.
	*
	* @param phongBanXuLyHienThoiId the phong ban xu ly hien thoi ID of this ho so t t h c cong
	*/
	public void setPhongBanXuLyHienThoiId(java.lang.Long phongBanXuLyHienThoiId) {
		_hoSoTTHCCong.setPhongBanXuLyHienThoiId(phongBanXuLyHienThoiId);
	}

	/**
	* Returns the ten phong ban xu ly hien thoi of this ho so t t h c cong.
	*
	* @return the ten phong ban xu ly hien thoi of this ho so t t h c cong
	*/
	public java.lang.String getTenPhongBanXuLyHienThoi() {
		return _hoSoTTHCCong.getTenPhongBanXuLyHienThoi();
	}

	/**
	* Sets the ten phong ban xu ly hien thoi of this ho so t t h c cong.
	*
	* @param tenPhongBanXuLyHienThoi the ten phong ban xu ly hien thoi of this ho so t t h c cong
	*/
	public void setTenPhongBanXuLyHienThoi(
		java.lang.String tenPhongBanXuLyHienThoi) {
		_hoSoTTHCCong.setTenPhongBanXuLyHienThoi(tenPhongBanXuLyHienThoi);
	}

	/**
	* Returns the can bo xu ly hien thoi ID of this ho so t t h c cong.
	*
	* @return the can bo xu ly hien thoi ID of this ho so t t h c cong
	*/
	public java.lang.Long getCanBoXuLyHienThoiId() {
		return _hoSoTTHCCong.getCanBoXuLyHienThoiId();
	}

	/**
	* Sets the can bo xu ly hien thoi ID of this ho so t t h c cong.
	*
	* @param canBoXuLyHienThoiId the can bo xu ly hien thoi ID of this ho so t t h c cong
	*/
	public void setCanBoXuLyHienThoiId(java.lang.Long canBoXuLyHienThoiId) {
		_hoSoTTHCCong.setCanBoXuLyHienThoiId(canBoXuLyHienThoiId);
	}

	/**
	* Returns the ten can bo xu ly hien thoi of this ho so t t h c cong.
	*
	* @return the ten can bo xu ly hien thoi of this ho so t t h c cong
	*/
	public java.lang.String getTenCanBoXuLyHienThoi() {
		return _hoSoTTHCCong.getTenCanBoXuLyHienThoi();
	}

	/**
	* Sets the ten can bo xu ly hien thoi of this ho so t t h c cong.
	*
	* @param tenCanBoXuLyHienThoi the ten can bo xu ly hien thoi of this ho so t t h c cong
	*/
	public void setTenCanBoXuLyHienThoi(java.lang.String tenCanBoXuLyHienThoi) {
		_hoSoTTHCCong.setTenCanBoXuLyHienThoi(tenCanBoXuLyHienThoi);
	}

	/**
	* Returns the danh gia ket qua of this ho so t t h c cong.
	*
	* @return the danh gia ket qua of this ho so t t h c cong
	*/
	public int getDanhGiaKetQua() {
		return _hoSoTTHCCong.getDanhGiaKetQua();
	}

	/**
	* Sets the danh gia ket qua of this ho so t t h c cong.
	*
	* @param danhGiaKetQua the danh gia ket qua of this ho so t t h c cong
	*/
	public void setDanhGiaKetQua(int danhGiaKetQua) {
		_hoSoTTHCCong.setDanhGiaKetQua(danhGiaKetQua);
	}

	/**
	* Returns the ghi chu of this ho so t t h c cong.
	*
	* @return the ghi chu of this ho so t t h c cong
	*/
	public java.lang.String getGhiChu() {
		return _hoSoTTHCCong.getGhiChu();
	}

	/**
	* Sets the ghi chu of this ho so t t h c cong.
	*
	* @param ghiChu the ghi chu of this ho so t t h c cong
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_hoSoTTHCCong.setGhiChu(ghiChu);
	}

	/**
	* Returns the ngay ket thuc xu ly of this ho so t t h c cong.
	*
	* @return the ngay ket thuc xu ly of this ho so t t h c cong
	*/
	public java.util.Date getNgayKetThucXuLy() {
		return _hoSoTTHCCong.getNgayKetThucXuLy();
	}

	/**
	* Sets the ngay ket thuc xu ly of this ho so t t h c cong.
	*
	* @param ngayKetThucXuLy the ngay ket thuc xu ly of this ho so t t h c cong
	*/
	public void setNgayKetThucXuLy(java.util.Date ngayKetThucXuLy) {
		_hoSoTTHCCong.setNgayKetThucXuLy(ngayKetThucXuLy);
	}

	/**
	* Returns the loai ho so of this ho so t t h c cong.
	*
	* @return the loai ho so of this ho so t t h c cong
	*/
	public int getLoaiHoSo() {
		return _hoSoTTHCCong.getLoaiHoSo();
	}

	/**
	* Sets the loai ho so of this ho so t t h c cong.
	*
	* @param loaiHoSo the loai ho so of this ho so t t h c cong
	*/
	public void setLoaiHoSo(int loaiHoSo) {
		_hoSoTTHCCong.setLoaiHoSo(loaiHoSo);
	}

	/**
	* Returns the yeu cau huy ho so of this ho so t t h c cong.
	*
	* @return the yeu cau huy ho so of this ho so t t h c cong
	*/
	public int getYeuCauHuyHoSo() {
		return _hoSoTTHCCong.getYeuCauHuyHoSo();
	}

	/**
	* Sets the yeu cau huy ho so of this ho so t t h c cong.
	*
	* @param yeuCauHuyHoSo the yeu cau huy ho so of this ho so t t h c cong
	*/
	public void setYeuCauHuyHoSo(int yeuCauHuyHoSo) {
		_hoSoTTHCCong.setYeuCauHuyHoSo(yeuCauHuyHoSo);
	}

	/**
	* Returns the ma so bien nhan of this ho so t t h c cong.
	*
	* @return the ma so bien nhan of this ho so t t h c cong
	*/
	public java.lang.String getMaSoBienNhan() {
		return _hoSoTTHCCong.getMaSoBienNhan();
	}

	/**
	* Sets the ma so bien nhan of this ho so t t h c cong.
	*
	* @param maSoBienNhan the ma so bien nhan of this ho so t t h c cong
	*/
	public void setMaSoBienNhan(java.lang.String maSoBienNhan) {
		_hoSoTTHCCong.setMaSoBienNhan(maSoBienNhan);
	}

	/**
	* Returns the ten bang chua ho so of this ho so t t h c cong.
	*
	* @return the ten bang chua ho so of this ho so t t h c cong
	*/
	public java.lang.String getTenBangChuaHoSo() {
		return _hoSoTTHCCong.getTenBangChuaHoSo();
	}

	/**
	* Sets the ten bang chua ho so of this ho so t t h c cong.
	*
	* @param tenBangChuaHoSo the ten bang chua ho so of this ho so t t h c cong
	*/
	public void setTenBangChuaHoSo(java.lang.String tenBangChuaHoSo) {
		_hoSoTTHCCong.setTenBangChuaHoSo(tenBangChuaHoSo);
	}

	/**
	* Returns the chu so huu of this ho so t t h c cong.
	*
	* @return the chu so huu of this ho so t t h c cong
	*/
	public java.lang.String getChuSoHuu() {
		return _hoSoTTHCCong.getChuSoHuu();
	}

	/**
	* Sets the chu so huu of this ho so t t h c cong.
	*
	* @param chuSoHuu the chu so huu of this ho so t t h c cong
	*/
	public void setChuSoHuu(java.lang.String chuSoHuu) {
		_hoSoTTHCCong.setChuSoHuu(chuSoHuu);
	}

	/**
	* Returns the so bo ho so of this ho so t t h c cong.
	*
	* @return the so bo ho so of this ho so t t h c cong
	*/
	public int getSoBoHoSo() {
		return _hoSoTTHCCong.getSoBoHoSo();
	}

	/**
	* Sets the so bo ho so of this ho so t t h c cong.
	*
	* @param soBoHoSo the so bo ho so of this ho so t t h c cong
	*/
	public void setSoBoHoSo(int soBoHoSo) {
		_hoSoTTHCCong.setSoBoHoSo(soBoHoSo);
	}

	/**
	* Returns the le phi of this ho so t t h c cong.
	*
	* @return the le phi of this ho so t t h c cong
	*/
	public int getLePhi() {
		return _hoSoTTHCCong.getLePhi();
	}

	/**
	* Sets the le phi of this ho so t t h c cong.
	*
	* @param lePhi the le phi of this ho so t t h c cong
	*/
	public void setLePhi(int lePhi) {
		_hoSoTTHCCong.setLePhi(lePhi);
	}

	/**
	* Returns the phi ho so of this ho so t t h c cong.
	*
	* @return the phi ho so of this ho so t t h c cong
	*/
	public int getPhiHoSo() {
		return _hoSoTTHCCong.getPhiHoSo();
	}

	/**
	* Sets the phi ho so of this ho so t t h c cong.
	*
	* @param phiHoSo the phi ho so of this ho so t t h c cong
	*/
	public void setPhiHoSo(int phiHoSo) {
		_hoSoTTHCCong.setPhiHoSo(phiHoSo);
	}

	/**
	* Returns the trich yeu of this ho so t t h c cong.
	*
	* @return the trich yeu of this ho so t t h c cong
	*/
	public java.lang.String getTrichYeu() {
		return _hoSoTTHCCong.getTrichYeu();
	}

	/**
	* Sets the trich yeu of this ho so t t h c cong.
	*
	* @param trichYeu the trich yeu of this ho so t t h c cong
	*/
	public void setTrichYeu(java.lang.String trichYeu) {
		_hoSoTTHCCong.setTrichYeu(trichYeu);
	}

	/**
	* Returns the ngay hen t b thue of this ho so t t h c cong.
	*
	* @return the ngay hen t b thue of this ho so t t h c cong
	*/
	public java.util.Date getNgayHenTBThue() {
		return _hoSoTTHCCong.getNgayHenTBThue();
	}

	/**
	* Sets the ngay hen t b thue of this ho so t t h c cong.
	*
	* @param ngayHenTBThue the ngay hen t b thue of this ho so t t h c cong
	*/
	public void setNgayHenTBThue(java.util.Date ngayHenTBThue) {
		_hoSoTTHCCong.setNgayHenTBThue(ngayHenTBThue);
	}

	/**
	* Returns the email nguoi nop of this ho so t t h c cong.
	*
	* @return the email nguoi nop of this ho so t t h c cong
	*/
	public java.lang.String getEmailNguoiNop() {
		return _hoSoTTHCCong.getEmailNguoiNop();
	}

	/**
	* Sets the email nguoi nop of this ho so t t h c cong.
	*
	* @param emailNguoiNop the email nguoi nop of this ho so t t h c cong
	*/
	public void setEmailNguoiNop(java.lang.String emailNguoiNop) {
		_hoSoTTHCCong.setEmailNguoiNop(emailNguoiNop);
	}

	/**
	* Returns the ma ung dung of this ho so t t h c cong.
	*
	* @return the ma ung dung of this ho so t t h c cong
	*/
	public java.lang.String getMaUngDung() {
		return _hoSoTTHCCong.getMaUngDung();
	}

	/**
	* Sets the ma ung dung of this ho so t t h c cong.
	*
	* @param maUngDung the ma ung dung of this ho so t t h c cong
	*/
	public void setMaUngDung(java.lang.String maUngDung) {
		_hoSoTTHCCong.setMaUngDung(maUngDung);
	}

	/**
	* Returns the da gui giay hen of this ho so t t h c cong.
	*
	* @return the da gui giay hen of this ho so t t h c cong
	*/
	public int getDaGuiGiayHen() {
		return _hoSoTTHCCong.getDaGuiGiayHen();
	}

	/**
	* Sets the da gui giay hen of this ho so t t h c cong.
	*
	* @param daGuiGiayHen the da gui giay hen of this ho so t t h c cong
	*/
	public void setDaGuiGiayHen(int daGuiGiayHen) {
		_hoSoTTHCCong.setDaGuiGiayHen(daGuiGiayHen);
	}

	/**
	* Returns the nguoi dai dien phap luat of this ho so t t h c cong.
	*
	* @return the nguoi dai dien phap luat of this ho so t t h c cong
	*/
	public java.lang.String getNguoiDaiDienPhapLuat() {
		return _hoSoTTHCCong.getNguoiDaiDienPhapLuat();
	}

	/**
	* Sets the nguoi dai dien phap luat of this ho so t t h c cong.
	*
	* @param nguoiDaiDienPhapLuat the nguoi dai dien phap luat of this ho so t t h c cong
	*/
	public void setNguoiDaiDienPhapLuat(java.lang.String nguoiDaiDienPhapLuat) {
		_hoSoTTHCCong.setNguoiDaiDienPhapLuat(nguoiDaiDienPhapLuat);
	}

	/**
	* Returns the nguoi dai dien phap luat ID of this ho so t t h c cong.
	*
	* @return the nguoi dai dien phap luat ID of this ho so t t h c cong
	*/
	public java.lang.Long getNguoiDaiDienPhapLuatId() {
		return _hoSoTTHCCong.getNguoiDaiDienPhapLuatId();
	}

	/**
	* Sets the nguoi dai dien phap luat ID of this ho so t t h c cong.
	*
	* @param nguoiDaiDienPhapLuatId the nguoi dai dien phap luat ID of this ho so t t h c cong
	*/
	public void setNguoiDaiDienPhapLuatId(java.lang.Long nguoiDaiDienPhapLuatId) {
		_hoSoTTHCCong.setNguoiDaiDienPhapLuatId(nguoiDaiDienPhapLuatId);
	}

	/**
	* Returns the chuyen sang mot cua of this ho so t t h c cong.
	*
	* @return the chuyen sang mot cua of this ho so t t h c cong
	*/
	public int getChuyenSangMotCua() {
		return _hoSoTTHCCong.getChuyenSangMotCua();
	}

	/**
	* Sets the chuyen sang mot cua of this ho so t t h c cong.
	*
	* @param chuyenSangMotCua the chuyen sang mot cua of this ho so t t h c cong
	*/
	public void setChuyenSangMotCua(int chuyenSangMotCua) {
		_hoSoTTHCCong.setChuyenSangMotCua(chuyenSangMotCua);
	}

	/**
	* Returns the doi tuong can xu ly ID of this ho so t t h c cong.
	*
	* @return the doi tuong can xu ly ID of this ho so t t h c cong
	*/
	public java.lang.Long getDoiTuongCanXuLyId() {
		return _hoSoTTHCCong.getDoiTuongCanXuLyId();
	}

	/**
	* Sets the doi tuong can xu ly ID of this ho so t t h c cong.
	*
	* @param doiTuongCanXuLyId the doi tuong can xu ly ID of this ho so t t h c cong
	*/
	public void setDoiTuongCanXuLyId(java.lang.Long doiTuongCanXuLyId) {
		_hoSoTTHCCong.setDoiTuongCanXuLyId(doiTuongCanXuLyId);
	}

	/**
	* Returns the ly do of this ho so t t h c cong.
	*
	* @return the ly do of this ho so t t h c cong
	*/
	public java.lang.String getLyDo() {
		return _hoSoTTHCCong.getLyDo();
	}

	/**
	* Sets the ly do of this ho so t t h c cong.
	*
	* @param lyDo the ly do of this ho so t t h c cong
	*/
	public void setLyDo(java.lang.String lyDo) {
		_hoSoTTHCCong.setLyDo(lyDo);
	}

	/**
	* Returns the mo ta thanh phan ho so of this ho so t t h c cong.
	*
	* @return the mo ta thanh phan ho so of this ho so t t h c cong
	*/
	public java.lang.String getMoTaThanhPhanHoSo() {
		return _hoSoTTHCCong.getMoTaThanhPhanHoSo();
	}

	/**
	* Sets the mo ta thanh phan ho so of this ho so t t h c cong.
	*
	* @param moTaThanhPhanHoSo the mo ta thanh phan ho so of this ho so t t h c cong
	*/
	public void setMoTaThanhPhanHoSo(java.lang.String moTaThanhPhanHoSo) {
		_hoSoTTHCCong.setMoTaThanhPhanHoSo(moTaThanhPhanHoSo);
	}

	/**
	* Returns the lien ket thanh phan ho so of this ho so t t h c cong.
	*
	* @return the lien ket thanh phan ho so of this ho so t t h c cong
	*/
	public java.lang.String getLienKetThanhPhanHoSo() {
		return _hoSoTTHCCong.getLienKetThanhPhanHoSo();
	}

	/**
	* Sets the lien ket thanh phan ho so of this ho so t t h c cong.
	*
	* @param lienKetThanhPhanHoSo the lien ket thanh phan ho so of this ho so t t h c cong
	*/
	public void setLienKetThanhPhanHoSo(java.lang.String lienKetThanhPhanHoSo) {
		_hoSoTTHCCong.setLienKetThanhPhanHoSo(lienKetThanhPhanHoSo);
	}

	/**
	* Returns the so ngay xu ly of this ho so t t h c cong.
	*
	* @return the so ngay xu ly of this ho so t t h c cong
	*/
	public java.lang.Long getSoNgayXuLy() {
		return _hoSoTTHCCong.getSoNgayXuLy();
	}

	/**
	* Sets the so ngay xu ly of this ho so t t h c cong.
	*
	* @param soNgayXuLy the so ngay xu ly of this ho so t t h c cong
	*/
	public void setSoNgayXuLy(java.lang.Long soNgayXuLy) {
		_hoSoTTHCCong.setSoNgayXuLy(soNgayXuLy);
	}

	/**
	* Returns the da tra ket qua truc tuyen of this ho so t t h c cong.
	*
	* @return the da tra ket qua truc tuyen of this ho so t t h c cong
	*/
	public java.lang.Long getDaTraKetQuaTrucTuyen() {
		return _hoSoTTHCCong.getDaTraKetQuaTrucTuyen();
	}

	/**
	* Sets the da tra ket qua truc tuyen of this ho so t t h c cong.
	*
	* @param daTraKetQuaTrucTuyen the da tra ket qua truc tuyen of this ho so t t h c cong
	*/
	public void setDaTraKetQuaTrucTuyen(java.lang.Long daTraKetQuaTrucTuyen) {
		_hoSoTTHCCong.setDaTraKetQuaTrucTuyen(daTraKetQuaTrucTuyen);
	}

	/**
	* Returns the e mail nguoi nhan of this ho so t t h c cong.
	*
	* @return the e mail nguoi nhan of this ho so t t h c cong
	*/
	public java.lang.String getEMailNguoiNhan() {
		return _hoSoTTHCCong.getEMailNguoiNhan();
	}

	/**
	* Sets the e mail nguoi nhan of this ho so t t h c cong.
	*
	* @param eMailNguoiNhan the e mail nguoi nhan of this ho so t t h c cong
	*/
	public void setEMailNguoiNhan(java.lang.String eMailNguoiNhan) {
		_hoSoTTHCCong.setEMailNguoiNhan(eMailNguoiNhan);
	}

	/**
	* Returns the ngay sinh nguoi nhan of this ho so t t h c cong.
	*
	* @return the ngay sinh nguoi nhan of this ho so t t h c cong
	*/
	public java.util.Date getNgaySinhNguoiNhan() {
		return _hoSoTTHCCong.getNgaySinhNguoiNhan();
	}

	/**
	* Sets the ngay sinh nguoi nhan of this ho so t t h c cong.
	*
	* @param ngaySinhNguoiNhan the ngay sinh nguoi nhan of this ho so t t h c cong
	*/
	public void setNgaySinhNguoiNhan(java.util.Date ngaySinhNguoiNhan) {
		_hoSoTTHCCong.setNgaySinhNguoiNhan(ngaySinhNguoiNhan);
	}

	/**
	* Returns the dien thoi co dinh nguoi nhan of this ho so t t h c cong.
	*
	* @return the dien thoi co dinh nguoi nhan of this ho so t t h c cong
	*/
	public java.lang.String getDienThoiCoDinhNguoiNhan() {
		return _hoSoTTHCCong.getDienThoiCoDinhNguoiNhan();
	}

	/**
	* Sets the dien thoi co dinh nguoi nhan of this ho so t t h c cong.
	*
	* @param dienThoiCoDinhNguoiNhan the dien thoi co dinh nguoi nhan of this ho so t t h c cong
	*/
	public void setDienThoiCoDinhNguoiNhan(
		java.lang.String dienThoiCoDinhNguoiNhan) {
		_hoSoTTHCCong.setDienThoiCoDinhNguoiNhan(dienThoiCoDinhNguoiNhan);
	}

	/**
	* Returns the cmnd nguoi nhan of this ho so t t h c cong.
	*
	* @return the cmnd nguoi nhan of this ho so t t h c cong
	*/
	public java.lang.String getCmndNguoiNhan() {
		return _hoSoTTHCCong.getCmndNguoiNhan();
	}

	/**
	* Sets the cmnd nguoi nhan of this ho so t t h c cong.
	*
	* @param cmndNguoiNhan the cmnd nguoi nhan of this ho so t t h c cong
	*/
	public void setCmndNguoiNhan(java.lang.String cmndNguoiNhan) {
		_hoSoTTHCCong.setCmndNguoiNhan(cmndNguoiNhan);
	}

	/**
	* Returns the gioi tinh of this ho so t t h c cong.
	*
	* @return the gioi tinh of this ho so t t h c cong
	*/
	public int getGioiTinh() {
		return _hoSoTTHCCong.getGioiTinh();
	}

	/**
	* Sets the gioi tinh of this ho so t t h c cong.
	*
	* @param gioiTinh the gioi tinh of this ho so t t h c cong
	*/
	public void setGioiTinh(int gioiTinh) {
		_hoSoTTHCCong.setGioiTinh(gioiTinh);
	}

	/**
	* Returns the dung xu ly of this ho so t t h c cong.
	*
	* @return the dung xu ly of this ho so t t h c cong
	*/
	public boolean getDungXuLy() {
		return _hoSoTTHCCong.getDungXuLy();
	}

	/**
	* Returns <code>true</code> if this ho so t t h c cong is dung xu ly.
	*
	* @return <code>true</code> if this ho so t t h c cong is dung xu ly; <code>false</code> otherwise
	*/
	public boolean isDungXuLy() {
		return _hoSoTTHCCong.isDungXuLy();
	}

	/**
	* Sets whether this ho so t t h c cong is dung xu ly.
	*
	* @param dungXuLy the dung xu ly of this ho so t t h c cong
	*/
	public void setDungXuLy(boolean dungXuLy) {
		_hoSoTTHCCong.setDungXuLy(dungXuLy);
	}

	/**
	* Returns the ngay bo sung of this ho so t t h c cong.
	*
	* @return the ngay bo sung of this ho so t t h c cong
	*/
	public java.util.Date getNgayBoSung() {
		return _hoSoTTHCCong.getNgayBoSung();
	}

	/**
	* Sets the ngay bo sung of this ho so t t h c cong.
	*
	* @param ngayBoSung the ngay bo sung of this ho so t t h c cong
	*/
	public void setNgayBoSung(java.util.Date ngayBoSung) {
		_hoSoTTHCCong.setNgayBoSung(ngayBoSung);
	}

	/**
	* Returns the ghi chu giay to dinh kem of this ho so t t h c cong.
	*
	* @return the ghi chu giay to dinh kem of this ho so t t h c cong
	*/
	public java.lang.String getGhiChuGiayToDinhKem() {
		return _hoSoTTHCCong.getGhiChuGiayToDinhKem();
	}

	/**
	* Sets the ghi chu giay to dinh kem of this ho so t t h c cong.
	*
	* @param ghiChuGiayToDinhKem the ghi chu giay to dinh kem of this ho so t t h c cong
	*/
	public void setGhiChuGiayToDinhKem(java.lang.String ghiChuGiayToDinhKem) {
		_hoSoTTHCCong.setGhiChuGiayToDinhKem(ghiChuGiayToDinhKem);
	}

	/**
	* Returns the da dang ky nhan s m s of this ho so t t h c cong.
	*
	* @return the da dang ky nhan s m s of this ho so t t h c cong
	*/
	public int getDaDangKyNhanSMS() {
		return _hoSoTTHCCong.getDaDangKyNhanSMS();
	}

	/**
	* Sets the da dang ky nhan s m s of this ho so t t h c cong.
	*
	* @param daDangKyNhanSMS the da dang ky nhan s m s of this ho so t t h c cong
	*/
	public void setDaDangKyNhanSMS(int daDangKyNhanSMS) {
		_hoSoTTHCCong.setDaDangKyNhanSMS(daDangKyNhanSMS);
	}

	/**
	* Returns the da dang ky chuyen phat nhanh of this ho so t t h c cong.
	*
	* @return the da dang ky chuyen phat nhanh of this ho so t t h c cong
	*/
	public int getDaDangKyChuyenPhatNhanh() {
		return _hoSoTTHCCong.getDaDangKyChuyenPhatNhanh();
	}

	/**
	* Sets the da dang ky chuyen phat nhanh of this ho so t t h c cong.
	*
	* @param daDangKyChuyenPhatNhanh the da dang ky chuyen phat nhanh of this ho so t t h c cong
	*/
	public void setDaDangKyChuyenPhatNhanh(int daDangKyChuyenPhatNhanh) {
		_hoSoTTHCCong.setDaDangKyChuyenPhatNhanh(daDangKyChuyenPhatNhanh);
	}

	/**
	* Returns the dia chi chu ho so of this ho so t t h c cong.
	*
	* @return the dia chi chu ho so of this ho so t t h c cong
	*/
	public java.lang.String getDiaChiChuHoSo() {
		return _hoSoTTHCCong.getDiaChiChuHoSo();
	}

	/**
	* Sets the dia chi chu ho so of this ho so t t h c cong.
	*
	* @param diaChiChuHoSo the dia chi chu ho so of this ho so t t h c cong
	*/
	public void setDiaChiChuHoSo(java.lang.String diaChiChuHoSo) {
		_hoSoTTHCCong.setDiaChiChuHoSo(diaChiChuHoSo);
	}

	public boolean isNew() {
		return _hoSoTTHCCong.isNew();
	}

	public void setNew(boolean n) {
		_hoSoTTHCCong.setNew(n);
	}

	public boolean isCachedModel() {
		return _hoSoTTHCCong.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_hoSoTTHCCong.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _hoSoTTHCCong.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _hoSoTTHCCong.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_hoSoTTHCCong.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _hoSoTTHCCong.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_hoSoTTHCCong.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HoSoTTHCCongWrapper((HoSoTTHCCong)_hoSoTTHCCong.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong hoSoTTHCCong) {
		return _hoSoTTHCCong.compareTo(hoSoTTHCCong);
	}

	@Override
	public int hashCode() {
		return _hoSoTTHCCong.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong> toCacheModel() {
		return _hoSoTTHCCong.toCacheModel();
	}

	public org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong toEscapedModel() {
		return new HoSoTTHCCongWrapper(_hoSoTTHCCong.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _hoSoTTHCCong.toString();
	}

	public java.lang.String toXmlString() {
		return _hoSoTTHCCong.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_hoSoTTHCCong.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public HoSoTTHCCong getWrappedHoSoTTHCCong() {
		return _hoSoTTHCCong;
	}

	public HoSoTTHCCong getWrappedModel() {
		return _hoSoTTHCCong;
	}

	public void resetOriginalValues() {
		_hoSoTTHCCong.resetOriginalValues();
	}

	private HoSoTTHCCong _hoSoTTHCCong;
}