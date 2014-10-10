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

package org.oep.dlms.dao.capgiaypheplaixe.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CapGiayPhepLaiXe}.
 * </p>
 *
 * @author    AnhNT
 * @see       CapGiayPhepLaiXe
 * @generated
 */
public class CapGiayPhepLaiXeWrapper implements CapGiayPhepLaiXe,
	ModelWrapper<CapGiayPhepLaiXe> {
	public CapGiayPhepLaiXeWrapper(CapGiayPhepLaiXe capGiayPhepLaiXe) {
		_capGiayPhepLaiXe = capGiayPhepLaiXe;
	}

	public Class<?> getModelClass() {
		return CapGiayPhepLaiXe.class;
	}

	public String getModelClassName() {
		return CapGiayPhepLaiXe.class.getName();
	}

	/**
	* Returns the primary key of this cap giay phep lai xe.
	*
	* @return the primary key of this cap giay phep lai xe
	*/
	public long getPrimaryKey() {
		return _capGiayPhepLaiXe.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cap giay phep lai xe.
	*
	* @param primaryKey the primary key of this cap giay phep lai xe
	*/
	public void setPrimaryKey(long primaryKey) {
		_capGiayPhepLaiXe.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cap giay phep lai xe.
	*
	* @return the ID of this cap giay phep lai xe
	*/
	public long getId() {
		return _capGiayPhepLaiXe.getId();
	}

	/**
	* Sets the ID of this cap giay phep lai xe.
	*
	* @param id the ID of this cap giay phep lai xe
	*/
	public void setId(long id) {
		_capGiayPhepLaiXe.setId(id);
	}

	/**
	* Returns the id co quan quan ly of this cap giay phep lai xe.
	*
	* @return the id co quan quan ly of this cap giay phep lai xe
	*/
	public long getIdCoQuanQuanLy() {
		return _capGiayPhepLaiXe.getIdCoQuanQuanLy();
	}

	/**
	* Sets the id co quan quan ly of this cap giay phep lai xe.
	*
	* @param idCoQuanQuanLy the id co quan quan ly of this cap giay phep lai xe
	*/
	public void setIdCoQuanQuanLy(long idCoQuanQuanLy) {
		_capGiayPhepLaiXe.setIdCoQuanQuanLy(idCoQuanQuanLy);
	}

	/**
	* Returns the id cong dan of this cap giay phep lai xe.
	*
	* @return the id cong dan of this cap giay phep lai xe
	*/
	public long getIdCongDan() {
		return _capGiayPhepLaiXe.getIdCongDan();
	}

	/**
	* Sets the id cong dan of this cap giay phep lai xe.
	*
	* @param idCongDan the id cong dan of this cap giay phep lai xe
	*/
	public void setIdCongDan(long idCongDan) {
		_capGiayPhepLaiXe.setIdCongDan(idCongDan);
	}

	/**
	* Returns the id loai ho so of this cap giay phep lai xe.
	*
	* @return the id loai ho so of this cap giay phep lai xe
	*/
	public long getIdLoaiHoSo() {
		return _capGiayPhepLaiXe.getIdLoaiHoSo();
	}

	/**
	* Sets the id loai ho so of this cap giay phep lai xe.
	*
	* @param idLoaiHoSo the id loai ho so of this cap giay phep lai xe
	*/
	public void setIdLoaiHoSo(long idLoaiHoSo) {
		_capGiayPhepLaiXe.setIdLoaiHoSo(idLoaiHoSo);
	}

	/**
	* Returns the so ho so of this cap giay phep lai xe.
	*
	* @return the so ho so of this cap giay phep lai xe
	*/
	public long getSoHoSo() {
		return _capGiayPhepLaiXe.getSoHoSo();
	}

	/**
	* Sets the so ho so of this cap giay phep lai xe.
	*
	* @param soHoSo the so ho so of this cap giay phep lai xe
	*/
	public void setSoHoSo(long soHoSo) {
		_capGiayPhepLaiXe.setSoHoSo(soHoSo);
	}

	/**
	* Returns the ho va ten of this cap giay phep lai xe.
	*
	* @return the ho va ten of this cap giay phep lai xe
	*/
	public java.lang.String getHoVaTen() {
		return _capGiayPhepLaiXe.getHoVaTen();
	}

	/**
	* Sets the ho va ten of this cap giay phep lai xe.
	*
	* @param hoVaTen the ho va ten of this cap giay phep lai xe
	*/
	public void setHoVaTen(java.lang.String hoVaTen) {
		_capGiayPhepLaiXe.setHoVaTen(hoVaTen);
	}

	/**
	* Returns the ngay sinh of this cap giay phep lai xe.
	*
	* @return the ngay sinh of this cap giay phep lai xe
	*/
	public java.util.Date getNgaySinh() {
		return _capGiayPhepLaiXe.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this cap giay phep lai xe.
	*
	* @param ngaySinh the ngay sinh of this cap giay phep lai xe
	*/
	public void setNgaySinh(java.util.Date ngaySinh) {
		_capGiayPhepLaiXe.setNgaySinh(ngaySinh);
	}

	/**
	* Returns the id gioi tinh of this cap giay phep lai xe.
	*
	* @return the id gioi tinh of this cap giay phep lai xe
	*/
	public long getIdGioiTinh() {
		return _capGiayPhepLaiXe.getIdGioiTinh();
	}

	/**
	* Sets the id gioi tinh of this cap giay phep lai xe.
	*
	* @param idGioiTinh the id gioi tinh of this cap giay phep lai xe
	*/
	public void setIdGioiTinh(long idGioiTinh) {
		_capGiayPhepLaiXe.setIdGioiTinh(idGioiTinh);
	}

	/**
	* Returns the id quoc tich of this cap giay phep lai xe.
	*
	* @return the id quoc tich of this cap giay phep lai xe
	*/
	public long getIdQuocTich() {
		return _capGiayPhepLaiXe.getIdQuocTich();
	}

	/**
	* Sets the id quoc tich of this cap giay phep lai xe.
	*
	* @param idQuocTich the id quoc tich of this cap giay phep lai xe
	*/
	public void setIdQuocTich(long idQuocTich) {
		_capGiayPhepLaiXe.setIdQuocTich(idQuocTich);
	}

	/**
	* Returns the so c m n d of this cap giay phep lai xe.
	*
	* @return the so c m n d of this cap giay phep lai xe
	*/
	public java.lang.String getSoCMND() {
		return _capGiayPhepLaiXe.getSoCMND();
	}

	/**
	* Sets the so c m n d of this cap giay phep lai xe.
	*
	* @param soCMND the so c m n d of this cap giay phep lai xe
	*/
	public void setSoCMND(java.lang.String soCMND) {
		_capGiayPhepLaiXe.setSoCMND(soCMND);
	}

	/**
	* Returns the ngay cap c m n d of this cap giay phep lai xe.
	*
	* @return the ngay cap c m n d of this cap giay phep lai xe
	*/
	public java.util.Date getNgayCapCMND() {
		return _capGiayPhepLaiXe.getNgayCapCMND();
	}

	/**
	* Sets the ngay cap c m n d of this cap giay phep lai xe.
	*
	* @param ngayCapCMND the ngay cap c m n d of this cap giay phep lai xe
	*/
	public void setNgayCapCMND(java.util.Date ngayCapCMND) {
		_capGiayPhepLaiXe.setNgayCapCMND(ngayCapCMND);
	}

	/**
	* Returns the id noi cap c m n d of this cap giay phep lai xe.
	*
	* @return the id noi cap c m n d of this cap giay phep lai xe
	*/
	public long getIdNoiCapCMND() {
		return _capGiayPhepLaiXe.getIdNoiCapCMND();
	}

	/**
	* Sets the id noi cap c m n d of this cap giay phep lai xe.
	*
	* @param idNoiCapCMND the id noi cap c m n d of this cap giay phep lai xe
	*/
	public void setIdNoiCapCMND(long idNoiCapCMND) {
		_capGiayPhepLaiXe.setIdNoiCapCMND(idNoiCapCMND);
	}

	/**
	* Returns the so ho chieu of this cap giay phep lai xe.
	*
	* @return the so ho chieu of this cap giay phep lai xe
	*/
	public java.lang.String getSoHoChieu() {
		return _capGiayPhepLaiXe.getSoHoChieu();
	}

	/**
	* Sets the so ho chieu of this cap giay phep lai xe.
	*
	* @param soHoChieu the so ho chieu of this cap giay phep lai xe
	*/
	public void setSoHoChieu(java.lang.String soHoChieu) {
		_capGiayPhepLaiXe.setSoHoChieu(soHoChieu);
	}

	/**
	* Returns the ngay cap ho chieu of this cap giay phep lai xe.
	*
	* @return the ngay cap ho chieu of this cap giay phep lai xe
	*/
	public java.util.Date getNgayCapHoChieu() {
		return _capGiayPhepLaiXe.getNgayCapHoChieu();
	}

	/**
	* Sets the ngay cap ho chieu of this cap giay phep lai xe.
	*
	* @param ngayCapHoChieu the ngay cap ho chieu of this cap giay phep lai xe
	*/
	public void setNgayCapHoChieu(java.util.Date ngayCapHoChieu) {
		_capGiayPhepLaiXe.setNgayCapHoChieu(ngayCapHoChieu);
	}

	/**
	* Returns the noi cap ho chieu of this cap giay phep lai xe.
	*
	* @return the noi cap ho chieu of this cap giay phep lai xe
	*/
	public long getNoiCapHoChieu() {
		return _capGiayPhepLaiXe.getNoiCapHoChieu();
	}

	/**
	* Sets the noi cap ho chieu of this cap giay phep lai xe.
	*
	* @param noiCapHoChieu the noi cap ho chieu of this cap giay phep lai xe
	*/
	public void setNoiCapHoChieu(long noiCapHoChieu) {
		_capGiayPhepLaiXe.setNoiCapHoChieu(noiCapHoChieu);
	}

	/**
	* Returns the dien thoai of this cap giay phep lai xe.
	*
	* @return the dien thoai of this cap giay phep lai xe
	*/
	public java.lang.String getDienThoai() {
		return _capGiayPhepLaiXe.getDienThoai();
	}

	/**
	* Sets the dien thoai of this cap giay phep lai xe.
	*
	* @param dienThoai the dien thoai of this cap giay phep lai xe
	*/
	public void setDienThoai(java.lang.String dienThoai) {
		_capGiayPhepLaiXe.setDienThoai(dienThoai);
	}

	/**
	* Returns the email of this cap giay phep lai xe.
	*
	* @return the email of this cap giay phep lai xe
	*/
	public java.lang.String getEmail() {
		return _capGiayPhepLaiXe.getEmail();
	}

	/**
	* Sets the email of this cap giay phep lai xe.
	*
	* @param email the email of this cap giay phep lai xe
	*/
	public void setEmail(java.lang.String email) {
		_capGiayPhepLaiXe.setEmail(email);
	}

	/**
	* Returns the ghi chu of this cap giay phep lai xe.
	*
	* @return the ghi chu of this cap giay phep lai xe
	*/
	public java.lang.String getGhiChu() {
		return _capGiayPhepLaiXe.getGhiChu();
	}

	/**
	* Sets the ghi chu of this cap giay phep lai xe.
	*
	* @param ghiChu the ghi chu of this cap giay phep lai xe
	*/
	public void setGhiChu(java.lang.String ghiChu) {
		_capGiayPhepLaiXe.setGhiChu(ghiChu);
	}

	/**
	* Returns the id tinh thuong tru of this cap giay phep lai xe.
	*
	* @return the id tinh thuong tru of this cap giay phep lai xe
	*/
	public long getIdTinhThuongTru() {
		return _capGiayPhepLaiXe.getIdTinhThuongTru();
	}

	/**
	* Sets the id tinh thuong tru of this cap giay phep lai xe.
	*
	* @param idTinhThuongTru the id tinh thuong tru of this cap giay phep lai xe
	*/
	public void setIdTinhThuongTru(long idTinhThuongTru) {
		_capGiayPhepLaiXe.setIdTinhThuongTru(idTinhThuongTru);
	}

	/**
	* Returns the id huyen thuong tru of this cap giay phep lai xe.
	*
	* @return the id huyen thuong tru of this cap giay phep lai xe
	*/
	public long getIdHuyenThuongTru() {
		return _capGiayPhepLaiXe.getIdHuyenThuongTru();
	}

	/**
	* Sets the id huyen thuong tru of this cap giay phep lai xe.
	*
	* @param idHuyenThuongTru the id huyen thuong tru of this cap giay phep lai xe
	*/
	public void setIdHuyenThuongTru(long idHuyenThuongTru) {
		_capGiayPhepLaiXe.setIdHuyenThuongTru(idHuyenThuongTru);
	}

	/**
	* Returns the id xa thuong tru of this cap giay phep lai xe.
	*
	* @return the id xa thuong tru of this cap giay phep lai xe
	*/
	public long getIdXaThuongTru() {
		return _capGiayPhepLaiXe.getIdXaThuongTru();
	}

	/**
	* Sets the id xa thuong tru of this cap giay phep lai xe.
	*
	* @param idXaThuongTru the id xa thuong tru of this cap giay phep lai xe
	*/
	public void setIdXaThuongTru(long idXaThuongTru) {
		_capGiayPhepLaiXe.setIdXaThuongTru(idXaThuongTru);
	}

	/**
	* Returns the dia chi thuong tru of this cap giay phep lai xe.
	*
	* @return the dia chi thuong tru of this cap giay phep lai xe
	*/
	public java.lang.String getDiaChiThuongTru() {
		return _capGiayPhepLaiXe.getDiaChiThuongTru();
	}

	/**
	* Sets the dia chi thuong tru of this cap giay phep lai xe.
	*
	* @param diaChiThuongTru the dia chi thuong tru of this cap giay phep lai xe
	*/
	public void setDiaChiThuongTru(java.lang.String diaChiThuongTru) {
		_capGiayPhepLaiXe.setDiaChiThuongTru(diaChiThuongTru);
	}

	/**
	* Returns the id tinh cu tru of this cap giay phep lai xe.
	*
	* @return the id tinh cu tru of this cap giay phep lai xe
	*/
	public long getIdTinhCuTru() {
		return _capGiayPhepLaiXe.getIdTinhCuTru();
	}

	/**
	* Sets the id tinh cu tru of this cap giay phep lai xe.
	*
	* @param idTinhCuTru the id tinh cu tru of this cap giay phep lai xe
	*/
	public void setIdTinhCuTru(long idTinhCuTru) {
		_capGiayPhepLaiXe.setIdTinhCuTru(idTinhCuTru);
	}

	/**
	* Returns the id huyen cu tru of this cap giay phep lai xe.
	*
	* @return the id huyen cu tru of this cap giay phep lai xe
	*/
	public long getIdHuyenCuTru() {
		return _capGiayPhepLaiXe.getIdHuyenCuTru();
	}

	/**
	* Sets the id huyen cu tru of this cap giay phep lai xe.
	*
	* @param idHuyenCuTru the id huyen cu tru of this cap giay phep lai xe
	*/
	public void setIdHuyenCuTru(long idHuyenCuTru) {
		_capGiayPhepLaiXe.setIdHuyenCuTru(idHuyenCuTru);
	}

	/**
	* Returns the id xa cu tru of this cap giay phep lai xe.
	*
	* @return the id xa cu tru of this cap giay phep lai xe
	*/
	public long getIdXaCuTru() {
		return _capGiayPhepLaiXe.getIdXaCuTru();
	}

	/**
	* Sets the id xa cu tru of this cap giay phep lai xe.
	*
	* @param idXaCuTru the id xa cu tru of this cap giay phep lai xe
	*/
	public void setIdXaCuTru(long idXaCuTru) {
		_capGiayPhepLaiXe.setIdXaCuTru(idXaCuTru);
	}

	/**
	* Returns the dia chi cu tru of this cap giay phep lai xe.
	*
	* @return the dia chi cu tru of this cap giay phep lai xe
	*/
	public java.lang.String getDiaChiCuTru() {
		return _capGiayPhepLaiXe.getDiaChiCuTru();
	}

	/**
	* Sets the dia chi cu tru of this cap giay phep lai xe.
	*
	* @param diaChiCuTru the dia chi cu tru of this cap giay phep lai xe
	*/
	public void setDiaChiCuTru(java.lang.String diaChiCuTru) {
		_capGiayPhepLaiXe.setDiaChiCuTru(diaChiCuTru);
	}

	/**
	* Returns the so giay phep lai xe of this cap giay phep lai xe.
	*
	* @return the so giay phep lai xe of this cap giay phep lai xe
	*/
	public java.lang.String getSoGiayPhepLaiXe() {
		return _capGiayPhepLaiXe.getSoGiayPhepLaiXe();
	}

	/**
	* Sets the so giay phep lai xe of this cap giay phep lai xe.
	*
	* @param soGiayPhepLaiXe the so giay phep lai xe of this cap giay phep lai xe
	*/
	public void setSoGiayPhepLaiXe(java.lang.String soGiayPhepLaiXe) {
		_capGiayPhepLaiXe.setSoGiayPhepLaiXe(soGiayPhepLaiXe);
	}

	/**
	* Returns the id hang giay phep lai xe of this cap giay phep lai xe.
	*
	* @return the id hang giay phep lai xe of this cap giay phep lai xe
	*/
	public long getIdHangGiayPhepLaiXe() {
		return _capGiayPhepLaiXe.getIdHangGiayPhepLaiXe();
	}

	/**
	* Sets the id hang giay phep lai xe of this cap giay phep lai xe.
	*
	* @param idHangGiayPhepLaiXe the id hang giay phep lai xe of this cap giay phep lai xe
	*/
	public void setIdHangGiayPhepLaiXe(long idHangGiayPhepLaiXe) {
		_capGiayPhepLaiXe.setIdHangGiayPhepLaiXe(idHangGiayPhepLaiXe);
	}

	/**
	* Returns the id don vi cap g p l x of this cap giay phep lai xe.
	*
	* @return the id don vi cap g p l x of this cap giay phep lai xe
	*/
	public long getIdDonViCapGPLX() {
		return _capGiayPhepLaiXe.getIdDonViCapGPLX();
	}

	/**
	* Sets the id don vi cap g p l x of this cap giay phep lai xe.
	*
	* @param idDonViCapGPLX the id don vi cap g p l x of this cap giay phep lai xe
	*/
	public void setIdDonViCapGPLX(long idDonViCapGPLX) {
		_capGiayPhepLaiXe.setIdDonViCapGPLX(idDonViCapGPLX);
	}

	/**
	* Returns the ngay cap g p l x of this cap giay phep lai xe.
	*
	* @return the ngay cap g p l x of this cap giay phep lai xe
	*/
	public java.util.Date getNgayCapGPLX() {
		return _capGiayPhepLaiXe.getNgayCapGPLX();
	}

	/**
	* Sets the ngay cap g p l x of this cap giay phep lai xe.
	*
	* @param ngayCapGPLX the ngay cap g p l x of this cap giay phep lai xe
	*/
	public void setNgayCapGPLX(java.util.Date ngayCapGPLX) {
		_capGiayPhepLaiXe.setNgayCapGPLX(ngayCapGPLX);
	}

	/**
	* Returns the id noi cap g p l x of this cap giay phep lai xe.
	*
	* @return the id noi cap g p l x of this cap giay phep lai xe
	*/
	public long getIdNoiCapGPLX() {
		return _capGiayPhepLaiXe.getIdNoiCapGPLX();
	}

	/**
	* Sets the id noi cap g p l x of this cap giay phep lai xe.
	*
	* @param idNoiCapGPLX the id noi cap g p l x of this cap giay phep lai xe
	*/
	public void setIdNoiCapGPLX(long idNoiCapGPLX) {
		_capGiayPhepLaiXe.setIdNoiCapGPLX(idNoiCapGPLX);
	}

	/**
	* Returns the ngay dau sat hach of this cap giay phep lai xe.
	*
	* @return the ngay dau sat hach of this cap giay phep lai xe
	*/
	public java.util.Date getNgayDauSatHach() {
		return _capGiayPhepLaiXe.getNgayDauSatHach();
	}

	/**
	* Sets the ngay dau sat hach of this cap giay phep lai xe.
	*
	* @param ngayDauSatHach the ngay dau sat hach of this cap giay phep lai xe
	*/
	public void setNgayDauSatHach(java.util.Date ngayDauSatHach) {
		_capGiayPhepLaiXe.setNgayDauSatHach(ngayDauSatHach);
	}

	/**
	* Returns the id noi hoc lai xe of this cap giay phep lai xe.
	*
	* @return the id noi hoc lai xe of this cap giay phep lai xe
	*/
	public long getIdNoiHocLaiXe() {
		return _capGiayPhepLaiXe.getIdNoiHocLaiXe();
	}

	/**
	* Sets the id noi hoc lai xe of this cap giay phep lai xe.
	*
	* @param idNoiHocLaiXe the id noi hoc lai xe of this cap giay phep lai xe
	*/
	public void setIdNoiHocLaiXe(long idNoiHocLaiXe) {
		_capGiayPhepLaiXe.setIdNoiHocLaiXe(idNoiHocLaiXe);
	}

	/**
	* Returns the nam hoc lai xe of this cap giay phep lai xe.
	*
	* @return the nam hoc lai xe of this cap giay phep lai xe
	*/
	public int getNamHocLaiXe() {
		return _capGiayPhepLaiXe.getNamHocLaiXe();
	}

	/**
	* Sets the nam hoc lai xe of this cap giay phep lai xe.
	*
	* @param namHocLaiXe the nam hoc lai xe of this cap giay phep lai xe
	*/
	public void setNamHocLaiXe(int namHocLaiXe) {
		_capGiayPhepLaiXe.setNamHocLaiXe(namHocLaiXe);
	}

	/**
	* Returns the nam trung tuyen hang cao nhat of this cap giay phep lai xe.
	*
	* @return the nam trung tuyen hang cao nhat of this cap giay phep lai xe
	*/
	public int getNamTrungTuyenHangCaoNhat() {
		return _capGiayPhepLaiXe.getNamTrungTuyenHangCaoNhat();
	}

	/**
	* Sets the nam trung tuyen hang cao nhat of this cap giay phep lai xe.
	*
	* @param namTrungTuyenHangCaoNhat the nam trung tuyen hang cao nhat of this cap giay phep lai xe
	*/
	public void setNamTrungTuyenHangCaoNhat(int namTrungTuyenHangCaoNhat) {
		_capGiayPhepLaiXe.setNamTrungTuyenHangCaoNhat(namTrungTuyenHangCaoNhat);
	}

	/**
	* Returns the ly do hoc of this cap giay phep lai xe.
	*
	* @return the ly do hoc of this cap giay phep lai xe
	*/
	public java.lang.String getLyDoHoc() {
		return _capGiayPhepLaiXe.getLyDoHoc();
	}

	/**
	* Sets the ly do hoc of this cap giay phep lai xe.
	*
	* @param lyDoHoc the ly do hoc of this cap giay phep lai xe
	*/
	public void setLyDoHoc(java.lang.String lyDoHoc) {
		_capGiayPhepLaiXe.setLyDoHoc(lyDoHoc);
	}

	/**
	* Returns the muc dich hoc of this cap giay phep lai xe.
	*
	* @return the muc dich hoc of this cap giay phep lai xe
	*/
	public java.lang.String getMucDichHoc() {
		return _capGiayPhepLaiXe.getMucDichHoc();
	}

	/**
	* Sets the muc dich hoc of this cap giay phep lai xe.
	*
	* @param mucDichHoc the muc dich hoc of this cap giay phep lai xe
	*/
	public void setMucDichHoc(java.lang.String mucDichHoc) {
		_capGiayPhepLaiXe.setMucDichHoc(mucDichHoc);
	}

	/**
	* Returns the so nam lai xe of this cap giay phep lai xe.
	*
	* @return the so nam lai xe of this cap giay phep lai xe
	*/
	public double getSoNamLaiXe() {
		return _capGiayPhepLaiXe.getSoNamLaiXe();
	}

	/**
	* Sets the so nam lai xe of this cap giay phep lai xe.
	*
	* @param soNamLaiXe the so nam lai xe of this cap giay phep lai xe
	*/
	public void setSoNamLaiXe(double soNamLaiXe) {
		_capGiayPhepLaiXe.setSoNamLaiXe(soNamLaiXe);
	}

	/**
	* Returns the so km lai xe of this cap giay phep lai xe.
	*
	* @return the so km lai xe of this cap giay phep lai xe
	*/
	public double getSoKmLaiXe() {
		return _capGiayPhepLaiXe.getSoKmLaiXe();
	}

	/**
	* Sets the so km lai xe of this cap giay phep lai xe.
	*
	* @param soKmLaiXe the so km lai xe of this cap giay phep lai xe
	*/
	public void setSoKmLaiXe(double soKmLaiXe) {
		_capGiayPhepLaiXe.setSoKmLaiXe(soKmLaiXe);
	}

	/**
	* Returns the ngay tra g p l x of this cap giay phep lai xe.
	*
	* @return the ngay tra g p l x of this cap giay phep lai xe
	*/
	public java.util.Date getNgayTraGPLX() {
		return _capGiayPhepLaiXe.getNgayTraGPLX();
	}

	/**
	* Sets the ngay tra g p l x of this cap giay phep lai xe.
	*
	* @param ngayTraGPLX the ngay tra g p l x of this cap giay phep lai xe
	*/
	public void setNgayTraGPLX(java.util.Date ngayTraGPLX) {
		_capGiayPhepLaiXe.setNgayTraGPLX(ngayTraGPLX);
	}

	/**
	* Returns the id ly do cap doi lai g p l x of this cap giay phep lai xe.
	*
	* @return the id ly do cap doi lai g p l x of this cap giay phep lai xe
	*/
	public long getIdLyDoCapDoiLaiGPLX() {
		return _capGiayPhepLaiXe.getIdLyDoCapDoiLaiGPLX();
	}

	/**
	* Sets the id ly do cap doi lai g p l x of this cap giay phep lai xe.
	*
	* @param idLyDoCapDoiLaiGPLX the id ly do cap doi lai g p l x of this cap giay phep lai xe
	*/
	public void setIdLyDoCapDoiLaiGPLX(long idLyDoCapDoiLaiGPLX) {
		_capGiayPhepLaiXe.setIdLyDoCapDoiLaiGPLX(idLyDoCapDoiLaiGPLX);
	}

	/**
	* Returns the ly do of this cap giay phep lai xe.
	*
	* @return the ly do of this cap giay phep lai xe
	*/
	public java.lang.String getLyDo() {
		return _capGiayPhepLaiXe.getLyDo();
	}

	/**
	* Sets the ly do of this cap giay phep lai xe.
	*
	* @param lyDo the ly do of this cap giay phep lai xe
	*/
	public void setLyDo(java.lang.String lyDo) {
		_capGiayPhepLaiXe.setLyDo(lyDo);
	}

	/**
	* Returns the ngay tao of this cap giay phep lai xe.
	*
	* @return the ngay tao of this cap giay phep lai xe
	*/
	public java.util.Date getNgayTao() {
		return _capGiayPhepLaiXe.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cap giay phep lai xe.
	*
	* @param ngayTao the ngay tao of this cap giay phep lai xe
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_capGiayPhepLaiXe.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this cap giay phep lai xe.
	*
	* @return the ngay sua of this cap giay phep lai xe
	*/
	public java.util.Date getNgaySua() {
		return _capGiayPhepLaiXe.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cap giay phep lai xe.
	*
	* @param ngaySua the ngay sua of this cap giay phep lai xe
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_capGiayPhepLaiXe.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this cap giay phep lai xe.
	*
	* @return the nguoi tao of this cap giay phep lai xe
	*/
	public java.lang.String getNguoiTao() {
		return _capGiayPhepLaiXe.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cap giay phep lai xe.
	*
	* @param nguoiTao the nguoi tao of this cap giay phep lai xe
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_capGiayPhepLaiXe.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this cap giay phep lai xe.
	*
	* @return the nguoi sua of this cap giay phep lai xe
	*/
	public java.lang.String getNguoiSua() {
		return _capGiayPhepLaiXe.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cap giay phep lai xe.
	*
	* @param nguoiSua the nguoi sua of this cap giay phep lai xe
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_capGiayPhepLaiXe.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the xoa of this cap giay phep lai xe.
	*
	* @return the xoa of this cap giay phep lai xe
	*/
	public int getXoa() {
		return _capGiayPhepLaiXe.getXoa();
	}

	/**
	* Sets the xoa of this cap giay phep lai xe.
	*
	* @param xoa the xoa of this cap giay phep lai xe
	*/
	public void setXoa(int xoa) {
		_capGiayPhepLaiXe.setXoa(xoa);
	}

	public boolean isNew() {
		return _capGiayPhepLaiXe.isNew();
	}

	public void setNew(boolean n) {
		_capGiayPhepLaiXe.setNew(n);
	}

	public boolean isCachedModel() {
		return _capGiayPhepLaiXe.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_capGiayPhepLaiXe.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _capGiayPhepLaiXe.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _capGiayPhepLaiXe.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_capGiayPhepLaiXe.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _capGiayPhepLaiXe.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_capGiayPhepLaiXe.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CapGiayPhepLaiXeWrapper((CapGiayPhepLaiXe)_capGiayPhepLaiXe.clone());
	}

	public int compareTo(
		org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe capGiayPhepLaiXe) {
		return _capGiayPhepLaiXe.compareTo(capGiayPhepLaiXe);
	}

	@Override
	public int hashCode() {
		return _capGiayPhepLaiXe.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe> toCacheModel() {
		return _capGiayPhepLaiXe.toCacheModel();
	}

	public org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe toEscapedModel() {
		return new CapGiayPhepLaiXeWrapper(_capGiayPhepLaiXe.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _capGiayPhepLaiXe.toString();
	}

	public java.lang.String toXmlString() {
		return _capGiayPhepLaiXe.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_capGiayPhepLaiXe.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CapGiayPhepLaiXe getWrappedCapGiayPhepLaiXe() {
		return _capGiayPhepLaiXe;
	}

	public CapGiayPhepLaiXe getWrappedModel() {
		return _capGiayPhepLaiXe;
	}

	public void resetOriginalValues() {
		_capGiayPhepLaiXe.resetOriginalValues();
	}

	private CapGiayPhepLaiXe _capGiayPhepLaiXe;
}