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
 * This class is a wrapper for {@link DoanhNghiep}.
 * </p>
 *
 * @author    Liemnn
 * @see       DoanhNghiep
 * @generated
 */
public class DoanhNghiepWrapper implements DoanhNghiep,
	ModelWrapper<DoanhNghiep> {
	public DoanhNghiepWrapper(DoanhNghiep doanhNghiep) {
		_doanhNghiep = doanhNghiep;
	}

	public Class<?> getModelClass() {
		return DoanhNghiep.class;
	}

	public String getModelClassName() {
		return DoanhNghiep.class.getName();
	}

	/**
	* Returns the primary key of this doanh nghiep.
	*
	* @return the primary key of this doanh nghiep
	*/
	public long getPrimaryKey() {
		return _doanhNghiep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this doanh nghiep.
	*
	* @param primaryKey the primary key of this doanh nghiep
	*/
	public void setPrimaryKey(long primaryKey) {
		_doanhNghiep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this doanh nghiep.
	*
	* @return the ID of this doanh nghiep
	*/
	public long getId() {
		return _doanhNghiep.getId();
	}

	/**
	* Sets the ID of this doanh nghiep.
	*
	* @param id the ID of this doanh nghiep
	*/
	public void setId(long id) {
		_doanhNghiep.setId(id);
	}

	/**
	* Returns the ma of this doanh nghiep.
	*
	* @return the ma of this doanh nghiep
	*/
	public java.lang.String getMa() {
		return _doanhNghiep.getMa();
	}

	/**
	* Sets the ma of this doanh nghiep.
	*
	* @param ma the ma of this doanh nghiep
	*/
	public void setMa(java.lang.String ma) {
		_doanhNghiep.setMa(ma);
	}

	/**
	* Returns the ten of this doanh nghiep.
	*
	* @return the ten of this doanh nghiep
	*/
	public java.lang.String getTen() {
		return _doanhNghiep.getTen();
	}

	/**
	* Sets the ten of this doanh nghiep.
	*
	* @param ten the ten of this doanh nghiep
	*/
	public void setTen(java.lang.String ten) {
		_doanhNghiep.setTen(ten);
	}

	/**
	* Returns the ma so thue of this doanh nghiep.
	*
	* @return the ma so thue of this doanh nghiep
	*/
	public java.lang.String getMaSoThue() {
		return _doanhNghiep.getMaSoThue();
	}

	/**
	* Sets the ma so thue of this doanh nghiep.
	*
	* @param maSoThue the ma so thue of this doanh nghiep
	*/
	public void setMaSoThue(java.lang.String maSoThue) {
		_doanhNghiep.setMaSoThue(maSoThue);
	}

	/**
	* Returns the ten tieng nuoc ngoai of this doanh nghiep.
	*
	* @return the ten tieng nuoc ngoai of this doanh nghiep
	*/
	public java.lang.String getTenTiengNuocNgoai() {
		return _doanhNghiep.getTenTiengNuocNgoai();
	}

	/**
	* Sets the ten tieng nuoc ngoai of this doanh nghiep.
	*
	* @param tenTiengNuocNgoai the ten tieng nuoc ngoai of this doanh nghiep
	*/
	public void setTenTiengNuocNgoai(java.lang.String tenTiengNuocNgoai) {
		_doanhNghiep.setTenTiengNuocNgoai(tenTiengNuocNgoai);
	}

	/**
	* Returns the ten viet tat of this doanh nghiep.
	*
	* @return the ten viet tat of this doanh nghiep
	*/
	public java.lang.String getTenVietTat() {
		return _doanhNghiep.getTenVietTat();
	}

	/**
	* Sets the ten viet tat of this doanh nghiep.
	*
	* @param tenVietTat the ten viet tat of this doanh nghiep
	*/
	public void setTenVietTat(java.lang.String tenVietTat) {
		_doanhNghiep.setTenVietTat(tenVietTat);
	}

	/**
	* Returns the dia chi doanh nghiep of this doanh nghiep.
	*
	* @return the dia chi doanh nghiep of this doanh nghiep
	*/
	public java.lang.String getDiaChiDoanhNghiep() {
		return _doanhNghiep.getDiaChiDoanhNghiep();
	}

	/**
	* Sets the dia chi doanh nghiep of this doanh nghiep.
	*
	* @param diaChiDoanhNghiep the dia chi doanh nghiep of this doanh nghiep
	*/
	public void setDiaChiDoanhNghiep(java.lang.String diaChiDoanhNghiep) {
		_doanhNghiep.setDiaChiDoanhNghiep(diaChiDoanhNghiep);
	}

	/**
	* Returns the dien thoai doanh nghiep of this doanh nghiep.
	*
	* @return the dien thoai doanh nghiep of this doanh nghiep
	*/
	public java.lang.String getDienThoaiDoanhNghiep() {
		return _doanhNghiep.getDienThoaiDoanhNghiep();
	}

	/**
	* Sets the dien thoai doanh nghiep of this doanh nghiep.
	*
	* @param dienThoaiDoanhNghiep the dien thoai doanh nghiep of this doanh nghiep
	*/
	public void setDienThoaiDoanhNghiep(java.lang.String dienThoaiDoanhNghiep) {
		_doanhNghiep.setDienThoaiDoanhNghiep(dienThoaiDoanhNghiep);
	}

	/**
	* Returns the fax of this doanh nghiep.
	*
	* @return the fax of this doanh nghiep
	*/
	public java.lang.String getFax() {
		return _doanhNghiep.getFax();
	}

	/**
	* Sets the fax of this doanh nghiep.
	*
	* @param fax the fax of this doanh nghiep
	*/
	public void setFax(java.lang.String fax) {
		_doanhNghiep.setFax(fax);
	}

	/**
	* Returns the email doanh nghiep of this doanh nghiep.
	*
	* @return the email doanh nghiep of this doanh nghiep
	*/
	public java.lang.String getEmailDoanhNghiep() {
		return _doanhNghiep.getEmailDoanhNghiep();
	}

	/**
	* Sets the email doanh nghiep of this doanh nghiep.
	*
	* @param emailDoanhNghiep the email doanh nghiep of this doanh nghiep
	*/
	public void setEmailDoanhNghiep(java.lang.String emailDoanhNghiep) {
		_doanhNghiep.setEmailDoanhNghiep(emailDoanhNghiep);
	}

	/**
	* Returns the website of this doanh nghiep.
	*
	* @return the website of this doanh nghiep
	*/
	public java.lang.String getWebsite() {
		return _doanhNghiep.getWebsite();
	}

	/**
	* Sets the website of this doanh nghiep.
	*
	* @param website the website of this doanh nghiep
	*/
	public void setWebsite(java.lang.String website) {
		_doanhNghiep.setWebsite(website);
	}

	/**
	* Returns the tong so von of this doanh nghiep.
	*
	* @return the tong so von of this doanh nghiep
	*/
	public long getTongSoVon() {
		return _doanhNghiep.getTongSoVon();
	}

	/**
	* Sets the tong so von of this doanh nghiep.
	*
	* @param tongSoVon the tong so von of this doanh nghiep
	*/
	public void setTongSoVon(long tongSoVon) {
		_doanhNghiep.setTongSoVon(tongSoVon);
	}

	/**
	* Returns the mo ta nganh nghe kinh doanh of this doanh nghiep.
	*
	* @return the mo ta nganh nghe kinh doanh of this doanh nghiep
	*/
	public java.lang.String getMoTaNganhNgheKinhDoanh() {
		return _doanhNghiep.getMoTaNganhNgheKinhDoanh();
	}

	/**
	* Sets the mo ta nganh nghe kinh doanh of this doanh nghiep.
	*
	* @param moTaNganhNgheKinhDoanh the mo ta nganh nghe kinh doanh of this doanh nghiep
	*/
	public void setMoTaNganhNgheKinhDoanh(
		java.lang.String moTaNganhNgheKinhDoanh) {
		_doanhNghiep.setMoTaNganhNgheKinhDoanh(moTaNganhNgheKinhDoanh);
	}

	/**
	* Returns the so g c n d k k d of this doanh nghiep.
	*
	* @return the so g c n d k k d of this doanh nghiep
	*/
	public java.lang.String getSoGCNDKKD() {
		return _doanhNghiep.getSoGCNDKKD();
	}

	/**
	* Sets the so g c n d k k d of this doanh nghiep.
	*
	* @param soGCNDKKD the so g c n d k k d of this doanh nghiep
	*/
	public void setSoGCNDKKD(java.lang.String soGCNDKKD) {
		_doanhNghiep.setSoGCNDKKD(soGCNDKKD);
	}

	/**
	* Returns the ngay cap g c n d k k d of this doanh nghiep.
	*
	* @return the ngay cap g c n d k k d of this doanh nghiep
	*/
	public java.util.Date getNgayCapGCNDKKD() {
		return _doanhNghiep.getNgayCapGCNDKKD();
	}

	/**
	* Sets the ngay cap g c n d k k d of this doanh nghiep.
	*
	* @param ngayCapGCNDKKD the ngay cap g c n d k k d of this doanh nghiep
	*/
	public void setNgayCapGCNDKKD(java.util.Date ngayCapGCNDKKD) {
		_doanhNghiep.setNgayCapGCNDKKD(ngayCapGCNDKKD);
	}

	/**
	* Returns the noi luu tru ID of this doanh nghiep.
	*
	* @return the noi luu tru ID of this doanh nghiep
	*/
	public long getNoiLuuTruId() {
		return _doanhNghiep.getNoiLuuTruId();
	}

	/**
	* Sets the noi luu tru ID of this doanh nghiep.
	*
	* @param noiLuuTruId the noi luu tru ID of this doanh nghiep
	*/
	public void setNoiLuuTruId(long noiLuuTruId) {
		_doanhNghiep.setNoiLuuTruId(noiLuuTruId);
	}

	/**
	* Returns the ngay dieu le duoc thong qua of this doanh nghiep.
	*
	* @return the ngay dieu le duoc thong qua of this doanh nghiep
	*/
	public java.util.Date getNgayDieuLeDuocThongQua() {
		return _doanhNghiep.getNgayDieuLeDuocThongQua();
	}

	/**
	* Sets the ngay dieu le duoc thong qua of this doanh nghiep.
	*
	* @param ngayDieuLeDuocThongQua the ngay dieu le duoc thong qua of this doanh nghiep
	*/
	public void setNgayDieuLeDuocThongQua(java.util.Date ngayDieuLeDuocThongQua) {
		_doanhNghiep.setNgayDieuLeDuocThongQua(ngayDieuLeDuocThongQua);
	}

	/**
	* Returns the ten chi nhanh of this doanh nghiep.
	*
	* @return the ten chi nhanh of this doanh nghiep
	*/
	public java.lang.String getTenChiNhanh() {
		return _doanhNghiep.getTenChiNhanh();
	}

	/**
	* Sets the ten chi nhanh of this doanh nghiep.
	*
	* @param tenChiNhanh the ten chi nhanh of this doanh nghiep
	*/
	public void setTenChiNhanh(java.lang.String tenChiNhanh) {
		_doanhNghiep.setTenChiNhanh(tenChiNhanh);
	}

	/**
	* Returns the dia chi chi nhanh of this doanh nghiep.
	*
	* @return the dia chi chi nhanh of this doanh nghiep
	*/
	public java.lang.String getDiaChiChiNhanh() {
		return _doanhNghiep.getDiaChiChiNhanh();
	}

	/**
	* Sets the dia chi chi nhanh of this doanh nghiep.
	*
	* @param diaChiChiNhanh the dia chi chi nhanh of this doanh nghiep
	*/
	public void setDiaChiChiNhanh(java.lang.String diaChiChiNhanh) {
		_doanhNghiep.setDiaChiChiNhanh(diaChiChiNhanh);
	}

	/**
	* Returns the ten van phong dai dien of this doanh nghiep.
	*
	* @return the ten van phong dai dien of this doanh nghiep
	*/
	public java.lang.String getTenVanPhongDaiDien() {
		return _doanhNghiep.getTenVanPhongDaiDien();
	}

	/**
	* Sets the ten van phong dai dien of this doanh nghiep.
	*
	* @param tenVanPhongDaiDien the ten van phong dai dien of this doanh nghiep
	*/
	public void setTenVanPhongDaiDien(java.lang.String tenVanPhongDaiDien) {
		_doanhNghiep.setTenVanPhongDaiDien(tenVanPhongDaiDien);
	}

	/**
	* Returns the dia chi van phong dai dien of this doanh nghiep.
	*
	* @return the dia chi van phong dai dien of this doanh nghiep
	*/
	public java.lang.String getDiaChiVanPhongDaiDien() {
		return _doanhNghiep.getDiaChiVanPhongDaiDien();
	}

	/**
	* Sets the dia chi van phong dai dien of this doanh nghiep.
	*
	* @param diaChiVanPhongDaiDien the dia chi van phong dai dien of this doanh nghiep
	*/
	public void setDiaChiVanPhongDaiDien(java.lang.String diaChiVanPhongDaiDien) {
		_doanhNghiep.setDiaChiVanPhongDaiDien(diaChiVanPhongDaiDien);
	}

	/**
	* Returns the ngay bat dau tam ngung of this doanh nghiep.
	*
	* @return the ngay bat dau tam ngung of this doanh nghiep
	*/
	public java.util.Date getNgayBatDauTamNgung() {
		return _doanhNghiep.getNgayBatDauTamNgung();
	}

	/**
	* Sets the ngay bat dau tam ngung of this doanh nghiep.
	*
	* @param ngayBatDauTamNgung the ngay bat dau tam ngung of this doanh nghiep
	*/
	public void setNgayBatDauTamNgung(java.util.Date ngayBatDauTamNgung) {
		_doanhNghiep.setNgayBatDauTamNgung(ngayBatDauTamNgung);
	}

	/**
	* Returns the ngay ket thuc tam ngung of this doanh nghiep.
	*
	* @return the ngay ket thuc tam ngung of this doanh nghiep
	*/
	public java.util.Date getNgayKetThucTamNgung() {
		return _doanhNghiep.getNgayKetThucTamNgung();
	}

	/**
	* Sets the ngay ket thuc tam ngung of this doanh nghiep.
	*
	* @param ngayKetThucTamNgung the ngay ket thuc tam ngung of this doanh nghiep
	*/
	public void setNgayKetThucTamNgung(java.util.Date ngayKetThucTamNgung) {
		_doanhNghiep.setNgayKetThucTamNgung(ngayKetThucTamNgung);
	}

	/**
	* Returns the ly do tam ngung of this doanh nghiep.
	*
	* @return the ly do tam ngung of this doanh nghiep
	*/
	public java.lang.String getLyDoTamNgung() {
		return _doanhNghiep.getLyDoTamNgung();
	}

	/**
	* Sets the ly do tam ngung of this doanh nghiep.
	*
	* @param lyDoTamNgung the ly do tam ngung of this doanh nghiep
	*/
	public void setLyDoTamNgung(java.lang.String lyDoTamNgung) {
		_doanhNghiep.setLyDoTamNgung(lyDoTamNgung);
	}

	/**
	* Returns the ngay cham dut hoat dong k d of this doanh nghiep.
	*
	* @return the ngay cham dut hoat dong k d of this doanh nghiep
	*/
	public java.util.Date getNgayChamDutHoatDongKD() {
		return _doanhNghiep.getNgayChamDutHoatDongKD();
	}

	/**
	* Sets the ngay cham dut hoat dong k d of this doanh nghiep.
	*
	* @param ngayChamDutHoatDongKD the ngay cham dut hoat dong k d of this doanh nghiep
	*/
	public void setNgayChamDutHoatDongKD(java.util.Date ngayChamDutHoatDongKD) {
		_doanhNghiep.setNgayChamDutHoatDongKD(ngayChamDutHoatDongKD);
	}

	/**
	* Returns the loai of this doanh nghiep.
	*
	* @return the loai of this doanh nghiep
	*/
	public long getLoai() {
		return _doanhNghiep.getLoai();
	}

	/**
	* Sets the loai of this doanh nghiep.
	*
	* @param loai the loai of this doanh nghiep
	*/
	public void setLoai(long loai) {
		_doanhNghiep.setLoai(loai);
	}

	/**
	* Returns the dia chi doanh nghiep huyen ID of this doanh nghiep.
	*
	* @return the dia chi doanh nghiep huyen ID of this doanh nghiep
	*/
	public java.lang.Long getDiaChiDoanhNghiepHuyenId() {
		return _doanhNghiep.getDiaChiDoanhNghiepHuyenId();
	}

	/**
	* Sets the dia chi doanh nghiep huyen ID of this doanh nghiep.
	*
	* @param diaChiDoanhNghiepHuyenId the dia chi doanh nghiep huyen ID of this doanh nghiep
	*/
	public void setDiaChiDoanhNghiepHuyenId(
		java.lang.Long diaChiDoanhNghiepHuyenId) {
		_doanhNghiep.setDiaChiDoanhNghiepHuyenId(diaChiDoanhNghiepHuyenId);
	}

	/**
	* Returns the dia chi doanh nghiep tinh ID of this doanh nghiep.
	*
	* @return the dia chi doanh nghiep tinh ID of this doanh nghiep
	*/
	public java.lang.Long getDiaChiDoanhNghiepTinhId() {
		return _doanhNghiep.getDiaChiDoanhNghiepTinhId();
	}

	/**
	* Sets the dia chi doanh nghiep tinh ID of this doanh nghiep.
	*
	* @param diaChiDoanhNghiepTinhId the dia chi doanh nghiep tinh ID of this doanh nghiep
	*/
	public void setDiaChiDoanhNghiepTinhId(
		java.lang.Long diaChiDoanhNghiepTinhId) {
		_doanhNghiep.setDiaChiDoanhNghiepTinhId(diaChiDoanhNghiepTinhId);
	}

	/**
	* Returns the dia chi doanh nghiep xa ID of this doanh nghiep.
	*
	* @return the dia chi doanh nghiep xa ID of this doanh nghiep
	*/
	public java.lang.Long getDiaChiDoanhNghiepXaId() {
		return _doanhNghiep.getDiaChiDoanhNghiepXaId();
	}

	/**
	* Sets the dia chi doanh nghiep xa ID of this doanh nghiep.
	*
	* @param diaChiDoanhNghiepXaId the dia chi doanh nghiep xa ID of this doanh nghiep
	*/
	public void setDiaChiDoanhNghiepXaId(java.lang.Long diaChiDoanhNghiepXaId) {
		_doanhNghiep.setDiaChiDoanhNghiepXaId(diaChiDoanhNghiepXaId);
	}

	/**
	* Returns the loai doi tuong ID of this doanh nghiep.
	*
	* @return the loai doi tuong ID of this doanh nghiep
	*/
	public java.lang.Long getLoaiDoiTuongId() {
		return _doanhNghiep.getLoaiDoiTuongId();
	}

	/**
	* Sets the loai doi tuong ID of this doanh nghiep.
	*
	* @param loaiDoiTuongId the loai doi tuong ID of this doanh nghiep
	*/
	public void setLoaiDoiTuongId(java.lang.Long loaiDoiTuongId) {
		_doanhNghiep.setLoaiDoiTuongId(loaiDoiTuongId);
	}

	/**
	* Returns the nguoi dai dien ID of this doanh nghiep.
	*
	* @return the nguoi dai dien ID of this doanh nghiep
	*/
	public java.lang.Long getNguoiDaiDienId() {
		return _doanhNghiep.getNguoiDaiDienId();
	}

	/**
	* Sets the nguoi dai dien ID of this doanh nghiep.
	*
	* @param nguoiDaiDienId the nguoi dai dien ID of this doanh nghiep
	*/
	public void setNguoiDaiDienId(java.lang.Long nguoiDaiDienId) {
		_doanhNghiep.setNguoiDaiDienId(nguoiDaiDienId);
	}

	/**
	* Returns the trang thai doanh nghiep ID of this doanh nghiep.
	*
	* @return the trang thai doanh nghiep ID of this doanh nghiep
	*/
	public java.lang.Long getTrangThaiDoanhNghiepId() {
		return _doanhNghiep.getTrangThaiDoanhNghiepId();
	}

	/**
	* Sets the trang thai doanh nghiep ID of this doanh nghiep.
	*
	* @param trangThaiDoanhNghiepId the trang thai doanh nghiep ID of this doanh nghiep
	*/
	public void setTrangThaiDoanhNghiepId(java.lang.Long trangThaiDoanhNghiepId) {
		_doanhNghiep.setTrangThaiDoanhNghiepId(trangThaiDoanhNghiepId);
	}

	/**
	* Returns the von dieu le of this doanh nghiep.
	*
	* @return the von dieu le of this doanh nghiep
	*/
	public long getVonDieuLe() {
		return _doanhNghiep.getVonDieuLe();
	}

	/**
	* Sets the von dieu le of this doanh nghiep.
	*
	* @param vonDieuLe the von dieu le of this doanh nghiep
	*/
	public void setVonDieuLe(long vonDieuLe) {
		_doanhNghiep.setVonDieuLe(vonDieuLe);
	}

	/**
	* Returns the von toi thieu mot xa vien of this doanh nghiep.
	*
	* @return the von toi thieu mot xa vien of this doanh nghiep
	*/
	public long getVonToiThieuMotXaVien() {
		return _doanhNghiep.getVonToiThieuMotXaVien();
	}

	/**
	* Sets the von toi thieu mot xa vien of this doanh nghiep.
	*
	* @param vonToiThieuMotXaVien the von toi thieu mot xa vien of this doanh nghiep
	*/
	public void setVonToiThieuMotXaVien(long vonToiThieuMotXaVien) {
		_doanhNghiep.setVonToiThieuMotXaVien(vonToiThieuMotXaVien);
	}

	/**
	* Returns the ghi chu of this doanh nghiep.
	*
	* @return the ghi chu of this doanh nghiep
	*/
	public java.lang.String getGhiChu() {
		return _doanhNghiep.getGhiChu();
	}

	/**
	* Sets the ghi chu of this doanh nghiep.
	*
	* @param ghiChu the ghi chu of this doanh nghiep
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_doanhNghiep.setGhiChu(ghiChu);
	}

	/**
	* Returns the quoc gia ID of this doanh nghiep.
	*
	* @return the quoc gia ID of this doanh nghiep
	*/
	public java.lang.Long getQuocGiaId() {
		return _doanhNghiep.getQuocGiaId();
	}

	/**
	* Sets the quoc gia ID of this doanh nghiep.
	*
	* @param quocGiaId the quoc gia ID of this doanh nghiep
	*/
	public void setQuocGiaId(java.lang.Long quocGiaId) {
		_doanhNghiep.setQuocGiaId(quocGiaId);
	}

	/**
	* Returns the co quan cap ID of this doanh nghiep.
	*
	* @return the co quan cap ID of this doanh nghiep
	*/
	public java.lang.Long getCoQuanCapId() {
		return _doanhNghiep.getCoQuanCapId();
	}

	/**
	* Sets the co quan cap ID of this doanh nghiep.
	*
	* @param coQuanCapId the co quan cap ID of this doanh nghiep
	*/
	public void setCoQuanCapId(java.lang.Long coQuanCapId) {
		_doanhNghiep.setCoQuanCapId(coQuanCapId);
	}

	/**
	* Returns the ten co quan cap of this doanh nghiep.
	*
	* @return the ten co quan cap of this doanh nghiep
	*/
	public long getTenCoQuanCap() {
		return _doanhNghiep.getTenCoQuanCap();
	}

	/**
	* Sets the ten co quan cap of this doanh nghiep.
	*
	* @param tenCoQuanCap the ten co quan cap of this doanh nghiep
	*/
	public void setTenCoQuanCap(long tenCoQuanCap) {
		_doanhNghiep.setTenCoQuanCap(tenCoQuanCap);
	}

	/**
	* Returns the so lan dieu chinh of this doanh nghiep.
	*
	* @return the so lan dieu chinh of this doanh nghiep
	*/
	public java.lang.String getSoLanDieuChinh() {
		return _doanhNghiep.getSoLanDieuChinh();
	}

	/**
	* Sets the so lan dieu chinh of this doanh nghiep.
	*
	* @param soLanDieuChinh the so lan dieu chinh of this doanh nghiep
	*/
	public void setSoLanDieuChinh(java.lang.String soLanDieuChinh) {
		_doanhNghiep.setSoLanDieuChinh(soLanDieuChinh);
	}

	/**
	* Returns the ngay dieu chinh of this doanh nghiep.
	*
	* @return the ngay dieu chinh of this doanh nghiep
	*/
	public java.util.Date getNgayDieuChinh() {
		return _doanhNghiep.getNgayDieuChinh();
	}

	/**
	* Sets the ngay dieu chinh of this doanh nghiep.
	*
	* @param ngayDieuChinh the ngay dieu chinh of this doanh nghiep
	*/
	public void setNgayDieuChinh(java.util.Date ngayDieuChinh) {
		_doanhNghiep.setNgayDieuChinh(ngayDieuChinh);
	}

	/**
	* Returns the chuc vu nguoi dai dien of this doanh nghiep.
	*
	* @return the chuc vu nguoi dai dien of this doanh nghiep
	*/
	public java.lang.String getChucVuNguoiDaiDien() {
		return _doanhNghiep.getChucVuNguoiDaiDien();
	}

	/**
	* Sets the chuc vu nguoi dai dien of this doanh nghiep.
	*
	* @param chucVuNguoiDaiDien the chuc vu nguoi dai dien of this doanh nghiep
	*/
	public void setChucVuNguoiDaiDien(java.lang.String chucVuNguoiDaiDien) {
		_doanhNghiep.setChucVuNguoiDaiDien(chucVuNguoiDaiDien);
	}

	/**
	* Returns the ngay tao of this doanh nghiep.
	*
	* @return the ngay tao of this doanh nghiep
	*/
	public java.util.Date getNgayTao() {
		return _doanhNghiep.getNgayTao();
	}

	/**
	* Sets the ngay tao of this doanh nghiep.
	*
	* @param ngayTao the ngay tao of this doanh nghiep
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_doanhNghiep.setNgayTao(ngayTao);
	}

	/**
	* Returns the da xoa of this doanh nghiep.
	*
	* @return the da xoa of this doanh nghiep
	*/
	public int getDaXoa() {
		return _doanhNghiep.getDaXoa();
	}

	/**
	* Sets the da xoa of this doanh nghiep.
	*
	* @param daXoa the da xoa of this doanh nghiep
	*/
	public void setDaXoa(int daXoa) {
		_doanhNghiep.setDaXoa(daXoa);
	}

	/**
	* Returns the ngay sua of this doanh nghiep.
	*
	* @return the ngay sua of this doanh nghiep
	*/
	public java.util.Date getNgaySua() {
		return _doanhNghiep.getNgaySua();
	}

	/**
	* Sets the ngay sua of this doanh nghiep.
	*
	* @param ngaySua the ngay sua of this doanh nghiep
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_doanhNghiep.setNgaySua(ngaySua);
	}

	/**
	* Returns the cha ID of this doanh nghiep.
	*
	* @return the cha ID of this doanh nghiep
	*/
	public java.lang.Long getChaId() {
		return _doanhNghiep.getChaId();
	}

	/**
	* Sets the cha ID of this doanh nghiep.
	*
	* @param chaId the cha ID of this doanh nghiep
	*/
	public void setChaId(java.lang.Long chaId) {
		_doanhNghiep.setChaId(chaId);
	}

	/**
	* Returns the nguoi tao of this doanh nghiep.
	*
	* @return the nguoi tao of this doanh nghiep
	*/
	public java.lang.String getNguoiTao() {
		return _doanhNghiep.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this doanh nghiep.
	*
	* @param nguoiTao the nguoi tao of this doanh nghiep
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_doanhNghiep.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this doanh nghiep.
	*
	* @return the nguoi sua of this doanh nghiep
	*/
	public java.lang.String getNguoiSua() {
		return _doanhNghiep.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this doanh nghiep.
	*
	* @param nguoiSua the nguoi sua of this doanh nghiep
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_doanhNghiep.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the tai khoan nguoi dung ID of this doanh nghiep.
	*
	* @return the tai khoan nguoi dung ID of this doanh nghiep
	*/
	public java.lang.Long getTaiKhoanNguoiDungId() {
		return _doanhNghiep.getTaiKhoanNguoiDungId();
	}

	/**
	* Sets the tai khoan nguoi dung ID of this doanh nghiep.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID of this doanh nghiep
	*/
	public void setTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId) {
		_doanhNghiep.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns the ten dia diem kinh doanh of this doanh nghiep.
	*
	* @return the ten dia diem kinh doanh of this doanh nghiep
	*/
	public java.lang.String getTenDiaDiemKinhDoanh() {
		return _doanhNghiep.getTenDiaDiemKinhDoanh();
	}

	/**
	* Sets the ten dia diem kinh doanh of this doanh nghiep.
	*
	* @param tenDiaDiemKinhDoanh the ten dia diem kinh doanh of this doanh nghiep
	*/
	public void setTenDiaDiemKinhDoanh(java.lang.String tenDiaDiemKinhDoanh) {
		_doanhNghiep.setTenDiaDiemKinhDoanh(tenDiaDiemKinhDoanh);
	}

	/**
	* Returns the ngay dang ky kinh doanh of this doanh nghiep.
	*
	* @return the ngay dang ky kinh doanh of this doanh nghiep
	*/
	public java.util.Date getNgayDangKyKinhDoanh() {
		return _doanhNghiep.getNgayDangKyKinhDoanh();
	}

	/**
	* Sets the ngay dang ky kinh doanh of this doanh nghiep.
	*
	* @param ngayDangKyKinhDoanh the ngay dang ky kinh doanh of this doanh nghiep
	*/
	public void setNgayDangKyKinhDoanh(java.util.Date ngayDangKyKinhDoanh) {
		_doanhNghiep.setNgayDangKyKinhDoanh(ngayDangKyKinhDoanh);
	}

	/**
	* Returns the loai hinh doanh nghiep ID of this doanh nghiep.
	*
	* @return the loai hinh doanh nghiep ID of this doanh nghiep
	*/
	public java.lang.Long getLoaiHinhDoanhNghiepId() {
		return _doanhNghiep.getLoaiHinhDoanhNghiepId();
	}

	/**
	* Sets the loai hinh doanh nghiep ID of this doanh nghiep.
	*
	* @param loaiHinhDoanhNghiepId the loai hinh doanh nghiep ID of this doanh nghiep
	*/
	public void setLoaiHinhDoanhNghiepId(java.lang.Long loaiHinhDoanhNghiepId) {
		_doanhNghiep.setLoaiHinhDoanhNghiepId(loaiHinhDoanhNghiepId);
	}

	public boolean isNew() {
		return _doanhNghiep.isNew();
	}

	public void setNew(boolean n) {
		_doanhNghiep.setNew(n);
	}

	public boolean isCachedModel() {
		return _doanhNghiep.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_doanhNghiep.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _doanhNghiep.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _doanhNghiep.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_doanhNghiep.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _doanhNghiep.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_doanhNghiep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DoanhNghiepWrapper((DoanhNghiep)_doanhNghiep.clone());
	}

	public int compareTo(org.oep.cmon.dao.dn.model.DoanhNghiep doanhNghiep) {
		return _doanhNghiep.compareTo(doanhNghiep);
	}

	@Override
	public int hashCode() {
		return _doanhNghiep.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.dn.model.DoanhNghiep> toCacheModel() {
		return _doanhNghiep.toCacheModel();
	}

	public org.oep.cmon.dao.dn.model.DoanhNghiep toEscapedModel() {
		return new DoanhNghiepWrapper(_doanhNghiep.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _doanhNghiep.toString();
	}

	public java.lang.String toXmlString() {
		return _doanhNghiep.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_doanhNghiep.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public DoanhNghiep getWrappedDoanhNghiep() {
		return _doanhNghiep;
	}

	public DoanhNghiep getWrappedModel() {
		return _doanhNghiep;
	}

	public void resetOriginalValues() {
		_doanhNghiep.resetOriginalValues();
	}

	private DoanhNghiep _doanhNghiep;
}