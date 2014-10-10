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

package org.oep.cmon.dao.csms.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link YeuCauDangKyCongDan}.
 * </p>
 *
 * @author    NAM
 * @see       YeuCauDangKyCongDan
 * @generated
 */
public class YeuCauDangKyCongDanWrapper implements YeuCauDangKyCongDan,
	ModelWrapper<YeuCauDangKyCongDan> {
	public YeuCauDangKyCongDanWrapper(YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		_yeuCauDangKyCongDan = yeuCauDangKyCongDan;
	}

	public Class<?> getModelClass() {
		return YeuCauDangKyCongDan.class;
	}

	public String getModelClassName() {
		return YeuCauDangKyCongDan.class.getName();
	}

	/**
	* Returns the primary key of this yeu cau dang ky cong dan.
	*
	* @return the primary key of this yeu cau dang ky cong dan
	*/
	public long getPrimaryKey() {
		return _yeuCauDangKyCongDan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this yeu cau dang ky cong dan.
	*
	* @param primaryKey the primary key of this yeu cau dang ky cong dan
	*/
	public void setPrimaryKey(long primaryKey) {
		_yeuCauDangKyCongDan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this yeu cau dang ky cong dan.
	*
	* @return the ID of this yeu cau dang ky cong dan
	*/
	public long getId() {
		return _yeuCauDangKyCongDan.getId();
	}

	/**
	* Sets the ID of this yeu cau dang ky cong dan.
	*
	* @param id the ID of this yeu cau dang ky cong dan
	*/
	public void setId(long id) {
		_yeuCauDangKyCongDan.setId(id);
	}

	/**
	* Returns the ngay yeu cau of this yeu cau dang ky cong dan.
	*
	* @return the ngay yeu cau of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayYeuCau() {
		return _yeuCauDangKyCongDan.getNgayYeuCau();
	}

	/**
	* Sets the ngay yeu cau of this yeu cau dang ky cong dan.
	*
	* @param NgayYeuCau the ngay yeu cau of this yeu cau dang ky cong dan
	*/
	public void setNgayYeuCau(java.util.Date NgayYeuCau) {
		_yeuCauDangKyCongDan.setNgayYeuCau(NgayYeuCau);
	}

	/**
	* Returns the so cmnd of this yeu cau dang ky cong dan.
	*
	* @return the so cmnd of this yeu cau dang ky cong dan
	*/
	public java.lang.String getSoCmnd() {
		return _yeuCauDangKyCongDan.getSoCmnd();
	}

	/**
	* Sets the so cmnd of this yeu cau dang ky cong dan.
	*
	* @param SoCmnd the so cmnd of this yeu cau dang ky cong dan
	*/
	public void setSoCmnd(java.lang.String SoCmnd) {
		_yeuCauDangKyCongDan.setSoCmnd(SoCmnd);
	}

	/**
	* Returns the ngay cap cmnd of this yeu cau dang ky cong dan.
	*
	* @return the ngay cap cmnd of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayCapCmnd() {
		return _yeuCauDangKyCongDan.getNgayCapCmnd();
	}

	/**
	* Sets the ngay cap cmnd of this yeu cau dang ky cong dan.
	*
	* @param NgayCapCmnd the ngay cap cmnd of this yeu cau dang ky cong dan
	*/
	public void setNgayCapCmnd(java.util.Date NgayCapCmnd) {
		_yeuCauDangKyCongDan.setNgayCapCmnd(NgayCapCmnd);
	}

	/**
	* Returns the i d noi cap cmnd of this yeu cau dang ky cong dan.
	*
	* @return the i d noi cap cmnd of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDNoiCapCmnd() {
		return _yeuCauDangKyCongDan.getIDNoiCapCmnd();
	}

	/**
	* Sets the i d noi cap cmnd of this yeu cau dang ky cong dan.
	*
	* @param IDNoiCapCmnd the i d noi cap cmnd of this yeu cau dang ky cong dan
	*/
	public void setIDNoiCapCmnd(java.lang.Long IDNoiCapCmnd) {
		_yeuCauDangKyCongDan.setIDNoiCapCmnd(IDNoiCapCmnd);
	}

	/**
	* Returns the ghi chu cmnd of this yeu cau dang ky cong dan.
	*
	* @return the ghi chu cmnd of this yeu cau dang ky cong dan
	*/
	public java.lang.String getGhiChuCmnd() {
		return _yeuCauDangKyCongDan.getGhiChuCmnd();
	}

	/**
	* Sets the ghi chu cmnd of this yeu cau dang ky cong dan.
	*
	* @param GhiChuCmnd the ghi chu cmnd of this yeu cau dang ky cong dan
	*/
	public void setGhiChuCmnd(java.lang.String GhiChuCmnd) {
		_yeuCauDangKyCongDan.setGhiChuCmnd(GhiChuCmnd);
	}

	/**
	* Returns the email of this yeu cau dang ky cong dan.
	*
	* @return the email of this yeu cau dang ky cong dan
	*/
	public java.lang.String getEmail() {
		return _yeuCauDangKyCongDan.getEmail();
	}

	/**
	* Sets the email of this yeu cau dang ky cong dan.
	*
	* @param Email the email of this yeu cau dang ky cong dan
	*/
	public void setEmail(java.lang.String Email) {
		_yeuCauDangKyCongDan.setEmail(Email);
	}

	/**
	* Returns the ho cong dan of this yeu cau dang ky cong dan.
	*
	* @return the ho cong dan of this yeu cau dang ky cong dan
	*/
	public java.lang.String getHoCongDan() {
		return _yeuCauDangKyCongDan.getHoCongDan();
	}

	/**
	* Sets the ho cong dan of this yeu cau dang ky cong dan.
	*
	* @param HoCongDan the ho cong dan of this yeu cau dang ky cong dan
	*/
	public void setHoCongDan(java.lang.String HoCongDan) {
		_yeuCauDangKyCongDan.setHoCongDan(HoCongDan);
	}

	/**
	* Returns the ho va ten of this yeu cau dang ky cong dan.
	*
	* @return the ho va ten of this yeu cau dang ky cong dan
	*/
	public java.lang.String getHoVaTen() {
		return _yeuCauDangKyCongDan.getHoVaTen();
	}

	/**
	* Sets the ho va ten of this yeu cau dang ky cong dan.
	*
	* @param HoVaTen the ho va ten of this yeu cau dang ky cong dan
	*/
	public void setHoVaTen(java.lang.String HoVaTen) {
		_yeuCauDangKyCongDan.setHoVaTen(HoVaTen);
	}

	/**
	* Returns the ten dem of this yeu cau dang ky cong dan.
	*
	* @return the ten dem of this yeu cau dang ky cong dan
	*/
	public java.lang.String getTenDem() {
		return _yeuCauDangKyCongDan.getTenDem();
	}

	/**
	* Sets the ten dem of this yeu cau dang ky cong dan.
	*
	* @param TenDem the ten dem of this yeu cau dang ky cong dan
	*/
	public void setTenDem(java.lang.String TenDem) {
		_yeuCauDangKyCongDan.setTenDem(TenDem);
	}

	/**
	* Returns the ten cong dan of this yeu cau dang ky cong dan.
	*
	* @return the ten cong dan of this yeu cau dang ky cong dan
	*/
	public java.lang.String getTenCongDan() {
		return _yeuCauDangKyCongDan.getTenCongDan();
	}

	/**
	* Sets the ten cong dan of this yeu cau dang ky cong dan.
	*
	* @param TenCongDan the ten cong dan of this yeu cau dang ky cong dan
	*/
	public void setTenCongDan(java.lang.String TenCongDan) {
		_yeuCauDangKyCongDan.setTenCongDan(TenCongDan);
	}

	/**
	* Returns the ngay sinh of this yeu cau dang ky cong dan.
	*
	* @return the ngay sinh of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgaySinh() {
		return _yeuCauDangKyCongDan.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this yeu cau dang ky cong dan.
	*
	* @param NgaySinh the ngay sinh of this yeu cau dang ky cong dan
	*/
	public void setNgaySinh(java.util.Date NgaySinh) {
		_yeuCauDangKyCongDan.setNgaySinh(NgaySinh);
	}

	/**
	* Returns the gioi tinh of this yeu cau dang ky cong dan.
	*
	* @return the gioi tinh of this yeu cau dang ky cong dan
	*/
	public int getGioiTinh() {
		return _yeuCauDangKyCongDan.getGioiTinh();
	}

	/**
	* Sets the gioi tinh of this yeu cau dang ky cong dan.
	*
	* @param GioiTinh the gioi tinh of this yeu cau dang ky cong dan
	*/
	public void setGioiTinh(int GioiTinh) {
		_yeuCauDangKyCongDan.setGioiTinh(GioiTinh);
	}

	/**
	* Returns the i d dan toc of this yeu cau dang ky cong dan.
	*
	* @return the i d dan toc of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDDanToc() {
		return _yeuCauDangKyCongDan.getIDDanToc();
	}

	/**
	* Sets the i d dan toc of this yeu cau dang ky cong dan.
	*
	* @param IDDanToc the i d dan toc of this yeu cau dang ky cong dan
	*/
	public void setIDDanToc(java.lang.Long IDDanToc) {
		_yeuCauDangKyCongDan.setIDDanToc(IDDanToc);
	}

	/**
	* Returns the i d quoc tich of this yeu cau dang ky cong dan.
	*
	* @return the i d quoc tich of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDQuocTich() {
		return _yeuCauDangKyCongDan.getIDQuocTich();
	}

	/**
	* Sets the i d quoc tich of this yeu cau dang ky cong dan.
	*
	* @param IDQuocTich the i d quoc tich of this yeu cau dang ky cong dan
	*/
	public void setIDQuocTich(java.lang.Long IDQuocTich) {
		_yeuCauDangKyCongDan.setIDQuocTich(IDQuocTich);
	}

	/**
	* Returns the i d ton giao of this yeu cau dang ky cong dan.
	*
	* @return the i d ton giao of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTonGiao() {
		return _yeuCauDangKyCongDan.getIDTonGiao();
	}

	/**
	* Sets the i d ton giao of this yeu cau dang ky cong dan.
	*
	* @param IDTonGiao the i d ton giao of this yeu cau dang ky cong dan
	*/
	public void setIDTonGiao(java.lang.Long IDTonGiao) {
		_yeuCauDangKyCongDan.setIDTonGiao(IDTonGiao);
	}

	/**
	* Returns the dien thoai co dinh of this yeu cau dang ky cong dan.
	*
	* @return the dien thoai co dinh of this yeu cau dang ky cong dan
	*/
	public java.lang.String getDienThoaiCoDinh() {
		return _yeuCauDangKyCongDan.getDienThoaiCoDinh();
	}

	/**
	* Sets the dien thoai co dinh of this yeu cau dang ky cong dan.
	*
	* @param DienThoaiCoDinh the dien thoai co dinh of this yeu cau dang ky cong dan
	*/
	public void setDienThoaiCoDinh(java.lang.String DienThoaiCoDinh) {
		_yeuCauDangKyCongDan.setDienThoaiCoDinh(DienThoaiCoDinh);
	}

	/**
	* Returns the dien thoai di dong of this yeu cau dang ky cong dan.
	*
	* @return the dien thoai di dong of this yeu cau dang ky cong dan
	*/
	public java.lang.String getDienThoaiDiDong() {
		return _yeuCauDangKyCongDan.getDienThoaiDiDong();
	}

	/**
	* Sets the dien thoai di dong of this yeu cau dang ky cong dan.
	*
	* @param DienThoaiDiDong the dien thoai di dong of this yeu cau dang ky cong dan
	*/
	public void setDienThoaiDiDong(java.lang.String DienThoaiDiDong) {
		_yeuCauDangKyCongDan.setDienThoaiDiDong(DienThoaiDiDong);
	}

	/**
	* Returns the i d trinh do hoc van of this yeu cau dang ky cong dan.
	*
	* @return the i d trinh do hoc van of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTrinhDoHocVan() {
		return _yeuCauDangKyCongDan.getIDTrinhDoHocVan();
	}

	/**
	* Sets the i d trinh do hoc van of this yeu cau dang ky cong dan.
	*
	* @param IDTrinhDoHocVan the i d trinh do hoc van of this yeu cau dang ky cong dan
	*/
	public void setIDTrinhDoHocVan(java.lang.Long IDTrinhDoHocVan) {
		_yeuCauDangKyCongDan.setIDTrinhDoHocVan(IDTrinhDoHocVan);
	}

	/**
	* Returns the so ho chieu of this yeu cau dang ky cong dan.
	*
	* @return the so ho chieu of this yeu cau dang ky cong dan
	*/
	public java.lang.String getSoHoChieu() {
		return _yeuCauDangKyCongDan.getSoHoChieu();
	}

	/**
	* Sets the so ho chieu of this yeu cau dang ky cong dan.
	*
	* @param SoHoChieu the so ho chieu of this yeu cau dang ky cong dan
	*/
	public void setSoHoChieu(java.lang.String SoHoChieu) {
		_yeuCauDangKyCongDan.setSoHoChieu(SoHoChieu);
	}

	/**
	* Returns the ngay cap ho chieu of this yeu cau dang ky cong dan.
	*
	* @return the ngay cap ho chieu of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayCapHoChieu() {
		return _yeuCauDangKyCongDan.getNgayCapHoChieu();
	}

	/**
	* Sets the ngay cap ho chieu of this yeu cau dang ky cong dan.
	*
	* @param NgayCapHoChieu the ngay cap ho chieu of this yeu cau dang ky cong dan
	*/
	public void setNgayCapHoChieu(java.util.Date NgayCapHoChieu) {
		_yeuCauDangKyCongDan.setNgayCapHoChieu(NgayCapHoChieu);
	}

	/**
	* Returns the i d noi cap ho chieu of this yeu cau dang ky cong dan.
	*
	* @return the i d noi cap ho chieu of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDNoiCapHoChieu() {
		return _yeuCauDangKyCongDan.getIDNoiCapHoChieu();
	}

	/**
	* Sets the i d noi cap ho chieu of this yeu cau dang ky cong dan.
	*
	* @param IDNoiCapHoChieu the i d noi cap ho chieu of this yeu cau dang ky cong dan
	*/
	public void setIDNoiCapHoChieu(java.lang.Long IDNoiCapHoChieu) {
		_yeuCauDangKyCongDan.setIDNoiCapHoChieu(IDNoiCapHoChieu);
	}

	/**
	* Returns the ngay het han ho chieu of this yeu cau dang ky cong dan.
	*
	* @return the ngay het han ho chieu of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayHetHanHoChieu() {
		return _yeuCauDangKyCongDan.getNgayHetHanHoChieu();
	}

	/**
	* Sets the ngay het han ho chieu of this yeu cau dang ky cong dan.
	*
	* @param NgayHetHanHoChieu the ngay het han ho chieu of this yeu cau dang ky cong dan
	*/
	public void setNgayHetHanHoChieu(java.util.Date NgayHetHanHoChieu) {
		_yeuCauDangKyCongDan.setNgayHetHanHoChieu(NgayHetHanHoChieu);
	}

	/**
	* Returns the ghi chu ho chieu of this yeu cau dang ky cong dan.
	*
	* @return the ghi chu ho chieu of this yeu cau dang ky cong dan
	*/
	public java.lang.String getGhiChuHoChieu() {
		return _yeuCauDangKyCongDan.getGhiChuHoChieu();
	}

	/**
	* Sets the ghi chu ho chieu of this yeu cau dang ky cong dan.
	*
	* @param GhiChuHoChieu the ghi chu ho chieu of this yeu cau dang ky cong dan
	*/
	public void setGhiChuHoChieu(java.lang.String GhiChuHoChieu) {
		_yeuCauDangKyCongDan.setGhiChuHoChieu(GhiChuHoChieu);
	}

	/**
	* Returns the so bao hiem yte of this yeu cau dang ky cong dan.
	*
	* @return the so bao hiem yte of this yeu cau dang ky cong dan
	*/
	public java.lang.String getSoBaoHiemYte() {
		return _yeuCauDangKyCongDan.getSoBaoHiemYte();
	}

	/**
	* Sets the so bao hiem yte of this yeu cau dang ky cong dan.
	*
	* @param SoBaoHiemYte the so bao hiem yte of this yeu cau dang ky cong dan
	*/
	public void setSoBaoHiemYte(java.lang.String SoBaoHiemYte) {
		_yeuCauDangKyCongDan.setSoBaoHiemYte(SoBaoHiemYte);
	}

	/**
	* Returns the ma so thue ca nhan of this yeu cau dang ky cong dan.
	*
	* @return the ma so thue ca nhan of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaSoThueCaNhan() {
		return _yeuCauDangKyCongDan.getMaSoThueCaNhan();
	}

	/**
	* Sets the ma so thue ca nhan of this yeu cau dang ky cong dan.
	*
	* @param MaSoThueCaNhan the ma so thue ca nhan of this yeu cau dang ky cong dan
	*/
	public void setMaSoThueCaNhan(java.lang.String MaSoThueCaNhan) {
		_yeuCauDangKyCongDan.setMaSoThueCaNhan(MaSoThueCaNhan);
	}

	/**
	* Returns the i d nghe nghiep of this yeu cau dang ky cong dan.
	*
	* @return the i d nghe nghiep of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDNgheNghiep() {
		return _yeuCauDangKyCongDan.getIDNgheNghiep();
	}

	/**
	* Sets the i d nghe nghiep of this yeu cau dang ky cong dan.
	*
	* @param IDNgheNghiep the i d nghe nghiep of this yeu cau dang ky cong dan
	*/
	public void setIDNgheNghiep(java.lang.Long IDNgheNghiep) {
		_yeuCauDangKyCongDan.setIDNgheNghiep(IDNgheNghiep);
	}

	/**
	* Returns the i d trinh do chuyen mon of this yeu cau dang ky cong dan.
	*
	* @return the i d trinh do chuyen mon of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTrinhDoChuyenMon() {
		return _yeuCauDangKyCongDan.getIDTrinhDoChuyenMon();
	}

	/**
	* Sets the i d trinh do chuyen mon of this yeu cau dang ky cong dan.
	*
	* @param IDTrinhDoChuyenMon the i d trinh do chuyen mon of this yeu cau dang ky cong dan
	*/
	public void setIDTrinhDoChuyenMon(java.lang.Long IDTrinhDoChuyenMon) {
		_yeuCauDangKyCongDan.setIDTrinhDoChuyenMon(IDTrinhDoChuyenMon);
	}

	/**
	* Returns the tinh trang hon nhan of this yeu cau dang ky cong dan.
	*
	* @return the tinh trang hon nhan of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getTinhTrangHonNhan() {
		return _yeuCauDangKyCongDan.getTinhTrangHonNhan();
	}

	/**
	* Sets the tinh trang hon nhan of this yeu cau dang ky cong dan.
	*
	* @param TinhTrangHonNhan the tinh trang hon nhan of this yeu cau dang ky cong dan
	*/
	public void setTinhTrangHonNhan(java.lang.Long TinhTrangHonNhan) {
		_yeuCauDangKyCongDan.setTinhTrangHonNhan(TinhTrangHonNhan);
	}

	/**
	* Returns the ho va ten cha of this yeu cau dang ky cong dan.
	*
	* @return the ho va ten cha of this yeu cau dang ky cong dan
	*/
	public java.lang.String getHoVaTenCha() {
		return _yeuCauDangKyCongDan.getHoVaTenCha();
	}

	/**
	* Sets the ho va ten cha of this yeu cau dang ky cong dan.
	*
	* @param HoVaTenCha the ho va ten cha of this yeu cau dang ky cong dan
	*/
	public void setHoVaTenCha(java.lang.String HoVaTenCha) {
		_yeuCauDangKyCongDan.setHoVaTenCha(HoVaTenCha);
	}

	/**
	* Returns the ho va ten me of this yeu cau dang ky cong dan.
	*
	* @return the ho va ten me of this yeu cau dang ky cong dan
	*/
	public java.lang.String getHoVaTenMe() {
		return _yeuCauDangKyCongDan.getHoVaTenMe();
	}

	/**
	* Sets the ho va ten me of this yeu cau dang ky cong dan.
	*
	* @param HoVaTenMe the ho va ten me of this yeu cau dang ky cong dan
	*/
	public void setHoVaTenMe(java.lang.String HoVaTenMe) {
		_yeuCauDangKyCongDan.setHoVaTenMe(HoVaTenMe);
	}

	/**
	* Returns the ho va ten vo chong of this yeu cau dang ky cong dan.
	*
	* @return the ho va ten vo chong of this yeu cau dang ky cong dan
	*/
	public java.lang.String getHoVaTenVoChong() {
		return _yeuCauDangKyCongDan.getHoVaTenVoChong();
	}

	/**
	* Sets the ho va ten vo chong of this yeu cau dang ky cong dan.
	*
	* @param HoVaTenVoChong the ho va ten vo chong of this yeu cau dang ky cong dan
	*/
	public void setHoVaTenVoChong(java.lang.String HoVaTenVoChong) {
		_yeuCauDangKyCongDan.setHoVaTenVoChong(HoVaTenVoChong);
	}

	/**
	* Returns the so ho khau of this yeu cau dang ky cong dan.
	*
	* @return the so ho khau of this yeu cau dang ky cong dan
	*/
	public java.lang.String getSoHoKhau() {
		return _yeuCauDangKyCongDan.getSoHoKhau();
	}

	/**
	* Sets the so ho khau of this yeu cau dang ky cong dan.
	*
	* @param SoHoKhau the so ho khau of this yeu cau dang ky cong dan
	*/
	public void setSoHoKhau(java.lang.String SoHoKhau) {
		_yeuCauDangKyCongDan.setSoHoKhau(SoHoKhau);
	}

	/**
	* Returns the chu ho of this yeu cau dang ky cong dan.
	*
	* @return the chu ho of this yeu cau dang ky cong dan
	*/
	public int getChuHo() {
		return _yeuCauDangKyCongDan.getChuHo();
	}

	/**
	* Sets the chu ho of this yeu cau dang ky cong dan.
	*
	* @param ChuHo the chu ho of this yeu cau dang ky cong dan
	*/
	public void setChuHo(int ChuHo) {
		_yeuCauDangKyCongDan.setChuHo(ChuHo);
	}

	/**
	* Returns the i d quan he of this yeu cau dang ky cong dan.
	*
	* @return the i d quan he of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDQuanHe() {
		return _yeuCauDangKyCongDan.getIDQuanHe();
	}

	/**
	* Sets the i d quan he of this yeu cau dang ky cong dan.
	*
	* @param IDQuanHe the i d quan he of this yeu cau dang ky cong dan
	*/
	public void setIDQuanHe(java.lang.Long IDQuanHe) {
		_yeuCauDangKyCongDan.setIDQuanHe(IDQuanHe);
	}

	/**
	* Returns the i d tinh thanh noi sinh of this yeu cau dang ky cong dan.
	*
	* @return the i d tinh thanh noi sinh of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTinhThanhNoiSinh() {
		return _yeuCauDangKyCongDan.getIDTinhThanhNoiSinh();
	}

	/**
	* Sets the i d tinh thanh noi sinh of this yeu cau dang ky cong dan.
	*
	* @param IDTinhThanhNoiSinh the i d tinh thanh noi sinh of this yeu cau dang ky cong dan
	*/
	public void setIDTinhThanhNoiSinh(java.lang.Long IDTinhThanhNoiSinh) {
		_yeuCauDangKyCongDan.setIDTinhThanhNoiSinh(IDTinhThanhNoiSinh);
	}

	/**
	* Returns the i d quan huyen noi sinh of this yeu cau dang ky cong dan.
	*
	* @return the i d quan huyen noi sinh of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDQuanHuyenNoiSinh() {
		return _yeuCauDangKyCongDan.getIDQuanHuyenNoiSinh();
	}

	/**
	* Sets the i d quan huyen noi sinh of this yeu cau dang ky cong dan.
	*
	* @param IDQuanHuyenNoiSinh the i d quan huyen noi sinh of this yeu cau dang ky cong dan
	*/
	public void setIDQuanHuyenNoiSinh(java.lang.Long IDQuanHuyenNoiSinh) {
		_yeuCauDangKyCongDan.setIDQuanHuyenNoiSinh(IDQuanHuyenNoiSinh);
	}

	/**
	* Returns the i d phuong xa noi sinh of this yeu cau dang ky cong dan.
	*
	* @return the i d phuong xa noi sinh of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDPhuongXaNoiSinh() {
		return _yeuCauDangKyCongDan.getIDPhuongXaNoiSinh();
	}

	/**
	* Sets the i d phuong xa noi sinh of this yeu cau dang ky cong dan.
	*
	* @param IDPhuongXaNoiSinh the i d phuong xa noi sinh of this yeu cau dang ky cong dan
	*/
	public void setIDPhuongXaNoiSinh(java.lang.Long IDPhuongXaNoiSinh) {
		_yeuCauDangKyCongDan.setIDPhuongXaNoiSinh(IDPhuongXaNoiSinh);
	}

	/**
	* Returns the mo ta dia chi noi sinh of this yeu cau dang ky cong dan.
	*
	* @return the mo ta dia chi noi sinh of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMoTaDiaChiNoiSinh() {
		return _yeuCauDangKyCongDan.getMoTaDiaChiNoiSinh();
	}

	/**
	* Sets the mo ta dia chi noi sinh of this yeu cau dang ky cong dan.
	*
	* @param MoTaDiaChiNoiSinh the mo ta dia chi noi sinh of this yeu cau dang ky cong dan
	*/
	public void setMoTaDiaChiNoiSinh(java.lang.String MoTaDiaChiNoiSinh) {
		_yeuCauDangKyCongDan.setMoTaDiaChiNoiSinh(MoTaDiaChiNoiSinh);
	}

	/**
	* Returns the i d tinh thanh thuong tru of this yeu cau dang ky cong dan.
	*
	* @return the i d tinh thanh thuong tru of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTinhThanhThuongTru() {
		return _yeuCauDangKyCongDan.getIDTinhThanhThuongTru();
	}

	/**
	* Sets the i d tinh thanh thuong tru of this yeu cau dang ky cong dan.
	*
	* @param IDTinhThanhThuongTru the i d tinh thanh thuong tru of this yeu cau dang ky cong dan
	*/
	public void setIDTinhThanhThuongTru(java.lang.Long IDTinhThanhThuongTru) {
		_yeuCauDangKyCongDan.setIDTinhThanhThuongTru(IDTinhThanhThuongTru);
	}

	/**
	* Returns the i d quan huyen thuong tru of this yeu cau dang ky cong dan.
	*
	* @return the i d quan huyen thuong tru of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDQuanHuyenThuongTru() {
		return _yeuCauDangKyCongDan.getIDQuanHuyenThuongTru();
	}

	/**
	* Sets the i d quan huyen thuong tru of this yeu cau dang ky cong dan.
	*
	* @param IDQuanHuyenThuongTru the i d quan huyen thuong tru of this yeu cau dang ky cong dan
	*/
	public void setIDQuanHuyenThuongTru(java.lang.Long IDQuanHuyenThuongTru) {
		_yeuCauDangKyCongDan.setIDQuanHuyenThuongTru(IDQuanHuyenThuongTru);
	}

	/**
	* Returns the i d phuong xa thuong tru of this yeu cau dang ky cong dan.
	*
	* @return the i d phuong xa thuong tru of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDPhuongXaThuongTru() {
		return _yeuCauDangKyCongDan.getIDPhuongXaThuongTru();
	}

	/**
	* Sets the i d phuong xa thuong tru of this yeu cau dang ky cong dan.
	*
	* @param IDPhuongXaThuongTru the i d phuong xa thuong tru of this yeu cau dang ky cong dan
	*/
	public void setIDPhuongXaThuongTru(java.lang.Long IDPhuongXaThuongTru) {
		_yeuCauDangKyCongDan.setIDPhuongXaThuongTru(IDPhuongXaThuongTru);
	}

	/**
	* Returns the mo ta dia chi thuong tru of this yeu cau dang ky cong dan.
	*
	* @return the mo ta dia chi thuong tru of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMoTaDiaChiThuongTru() {
		return _yeuCauDangKyCongDan.getMoTaDiaChiThuongTru();
	}

	/**
	* Sets the mo ta dia chi thuong tru of this yeu cau dang ky cong dan.
	*
	* @param MoTaDiaChiThuongTru the mo ta dia chi thuong tru of this yeu cau dang ky cong dan
	*/
	public void setMoTaDiaChiThuongTru(java.lang.String MoTaDiaChiThuongTru) {
		_yeuCauDangKyCongDan.setMoTaDiaChiThuongTru(MoTaDiaChiThuongTru);
	}

	/**
	* Returns the i d tinh thanh hien tai of this yeu cau dang ky cong dan.
	*
	* @return the i d tinh thanh hien tai of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDTinhThanhHienTai() {
		return _yeuCauDangKyCongDan.getIDTinhThanhHienTai();
	}

	/**
	* Sets the i d tinh thanh hien tai of this yeu cau dang ky cong dan.
	*
	* @param IDTinhThanhHienTai the i d tinh thanh hien tai of this yeu cau dang ky cong dan
	*/
	public void setIDTinhThanhHienTai(java.lang.Long IDTinhThanhHienTai) {
		_yeuCauDangKyCongDan.setIDTinhThanhHienTai(IDTinhThanhHienTai);
	}

	/**
	* Returns the i d quan huyen hien tai of this yeu cau dang ky cong dan.
	*
	* @return the i d quan huyen hien tai of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDQuanHuyenHienTai() {
		return _yeuCauDangKyCongDan.getIDQuanHuyenHienTai();
	}

	/**
	* Sets the i d quan huyen hien tai of this yeu cau dang ky cong dan.
	*
	* @param IDQuanHuyenHienTai the i d quan huyen hien tai of this yeu cau dang ky cong dan
	*/
	public void setIDQuanHuyenHienTai(java.lang.Long IDQuanHuyenHienTai) {
		_yeuCauDangKyCongDan.setIDQuanHuyenHienTai(IDQuanHuyenHienTai);
	}

	/**
	* Returns the i d phuong xa hien tai of this yeu cau dang ky cong dan.
	*
	* @return the i d phuong xa hien tai of this yeu cau dang ky cong dan
	*/
	public java.lang.Long getIDPhuongXaHienTai() {
		return _yeuCauDangKyCongDan.getIDPhuongXaHienTai();
	}

	/**
	* Sets the i d phuong xa hien tai of this yeu cau dang ky cong dan.
	*
	* @param IDPhuongXaHienTai the i d phuong xa hien tai of this yeu cau dang ky cong dan
	*/
	public void setIDPhuongXaHienTai(java.lang.Long IDPhuongXaHienTai) {
		_yeuCauDangKyCongDan.setIDPhuongXaHienTai(IDPhuongXaHienTai);
	}

	/**
	* Returns the mo ta dia chi hien tai of this yeu cau dang ky cong dan.
	*
	* @return the mo ta dia chi hien tai of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMoTaDiaChiHienTai() {
		return _yeuCauDangKyCongDan.getMoTaDiaChiHienTai();
	}

	/**
	* Sets the mo ta dia chi hien tai of this yeu cau dang ky cong dan.
	*
	* @param MoTaDiaChiHienTai the mo ta dia chi hien tai of this yeu cau dang ky cong dan
	*/
	public void setMoTaDiaChiHienTai(java.lang.String MoTaDiaChiHienTai) {
		_yeuCauDangKyCongDan.setMoTaDiaChiHienTai(MoTaDiaChiHienTai);
	}

	/**
	* Returns the ma xac nhan of this yeu cau dang ky cong dan.
	*
	* @return the ma xac nhan of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaXacNhan() {
		return _yeuCauDangKyCongDan.getMaXacNhan();
	}

	/**
	* Sets the ma xac nhan of this yeu cau dang ky cong dan.
	*
	* @param MaXacNhan the ma xac nhan of this yeu cau dang ky cong dan
	*/
	public void setMaXacNhan(java.lang.String MaXacNhan) {
		_yeuCauDangKyCongDan.setMaXacNhan(MaXacNhan);
	}

	/**
	* Returns the ngay chung thuc of this yeu cau dang ky cong dan.
	*
	* @return the ngay chung thuc of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayChungThuc() {
		return _yeuCauDangKyCongDan.getNgayChungThuc();
	}

	/**
	* Sets the ngay chung thuc of this yeu cau dang ky cong dan.
	*
	* @param NgayChungThuc the ngay chung thuc of this yeu cau dang ky cong dan
	*/
	public void setNgayChungThuc(java.util.Date NgayChungThuc) {
		_yeuCauDangKyCongDan.setNgayChungThuc(NgayChungThuc);
	}

	/**
	* Returns the nguoi chung thuc of this yeu cau dang ky cong dan.
	*
	* @return the nguoi chung thuc of this yeu cau dang ky cong dan
	*/
	public java.lang.String getNguoiChungThuc() {
		return _yeuCauDangKyCongDan.getNguoiChungThuc();
	}

	/**
	* Sets the nguoi chung thuc of this yeu cau dang ky cong dan.
	*
	* @param NguoiChungThuc the nguoi chung thuc of this yeu cau dang ky cong dan
	*/
	public void setNguoiChungThuc(java.lang.String NguoiChungThuc) {
		_yeuCauDangKyCongDan.setNguoiChungThuc(NguoiChungThuc);
	}

	/**
	* Returns the ma cong dan cha of this yeu cau dang ky cong dan.
	*
	* @return the ma cong dan cha of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaCongDanCha() {
		return _yeuCauDangKyCongDan.getMaCongDanCha();
	}

	/**
	* Sets the ma cong dan cha of this yeu cau dang ky cong dan.
	*
	* @param MaCongDanCha the ma cong dan cha of this yeu cau dang ky cong dan
	*/
	public void setMaCongDanCha(java.lang.String MaCongDanCha) {
		_yeuCauDangKyCongDan.setMaCongDanCha(MaCongDanCha);
	}

	/**
	* Returns the ma cong dan me of this yeu cau dang ky cong dan.
	*
	* @return the ma cong dan me of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaCongDanMe() {
		return _yeuCauDangKyCongDan.getMaCongDanMe();
	}

	/**
	* Sets the ma cong dan me of this yeu cau dang ky cong dan.
	*
	* @param MaCongDanMe the ma cong dan me of this yeu cau dang ky cong dan
	*/
	public void setMaCongDanMe(java.lang.String MaCongDanMe) {
		_yeuCauDangKyCongDan.setMaCongDanMe(MaCongDanMe);
	}

	/**
	* Returns the ma cong dan vo chong of this yeu cau dang ky cong dan.
	*
	* @return the ma cong dan vo chong of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaCongDanVoChong() {
		return _yeuCauDangKyCongDan.getMaCongDanVoChong();
	}

	/**
	* Sets the ma cong dan vo chong of this yeu cau dang ky cong dan.
	*
	* @param MaCongDanVoChong the ma cong dan vo chong of this yeu cau dang ky cong dan
	*/
	public void setMaCongDanVoChong(java.lang.String MaCongDanVoChong) {
		_yeuCauDangKyCongDan.setMaCongDanVoChong(MaCongDanVoChong);
	}

	/**
	* Returns the ma cong dan of this yeu cau dang ky cong dan.
	*
	* @return the ma cong dan of this yeu cau dang ky cong dan
	*/
	public java.lang.String getMaCongDan() {
		return _yeuCauDangKyCongDan.getMaCongDan();
	}

	/**
	* Sets the ma cong dan of this yeu cau dang ky cong dan.
	*
	* @param MaCongDan the ma cong dan of this yeu cau dang ky cong dan
	*/
	public void setMaCongDan(java.lang.String MaCongDan) {
		_yeuCauDangKyCongDan.setMaCongDan(MaCongDan);
	}

	/**
	* Returns the loai yeu cau of this yeu cau dang ky cong dan.
	*
	* @return the loai yeu cau of this yeu cau dang ky cong dan
	*/
	public int getLoaiYeuCau() {
		return _yeuCauDangKyCongDan.getLoaiYeuCau();
	}

	/**
	* Sets the loai yeu cau of this yeu cau dang ky cong dan.
	*
	* @param LoaiYeuCau the loai yeu cau of this yeu cau dang ky cong dan
	*/
	public void setLoaiYeuCau(int LoaiYeuCau) {
		_yeuCauDangKyCongDan.setLoaiYeuCau(LoaiYeuCau);
	}

	/**
	* Returns the trang thai yeu cau of this yeu cau dang ky cong dan.
	*
	* @return the trang thai yeu cau of this yeu cau dang ky cong dan
	*/
	public int getTrangThaiYeuCau() {
		return _yeuCauDangKyCongDan.getTrangThaiYeuCau();
	}

	/**
	* Sets the trang thai yeu cau of this yeu cau dang ky cong dan.
	*
	* @param TrangThaiYeuCau the trang thai yeu cau of this yeu cau dang ky cong dan
	*/
	public void setTrangThaiYeuCau(int TrangThaiYeuCau) {
		_yeuCauDangKyCongDan.setTrangThaiYeuCau(TrangThaiYeuCau);
	}

	/**
	* Returns the ngay tao of this yeu cau dang ky cong dan.
	*
	* @return the ngay tao of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgayTao() {
		return _yeuCauDangKyCongDan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this yeu cau dang ky cong dan.
	*
	* @param NgayTao the ngay tao of this yeu cau dang ky cong dan
	*/
	public void setNgayTao(java.util.Date NgayTao) {
		_yeuCauDangKyCongDan.setNgayTao(NgayTao);
	}

	/**
	* Returns the ngay sua of this yeu cau dang ky cong dan.
	*
	* @return the ngay sua of this yeu cau dang ky cong dan
	*/
	public java.util.Date getNgaySua() {
		return _yeuCauDangKyCongDan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this yeu cau dang ky cong dan.
	*
	* @param NgaySua the ngay sua of this yeu cau dang ky cong dan
	*/
	public void setNgaySua(java.util.Date NgaySua) {
		_yeuCauDangKyCongDan.setNgaySua(NgaySua);
	}

	/**
	* Returns the nguoi tao of this yeu cau dang ky cong dan.
	*
	* @return the nguoi tao of this yeu cau dang ky cong dan
	*/
	public java.lang.String getNguoiTao() {
		return _yeuCauDangKyCongDan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this yeu cau dang ky cong dan.
	*
	* @param NguoiTao the nguoi tao of this yeu cau dang ky cong dan
	*/
	public void setNguoiTao(java.lang.String NguoiTao) {
		_yeuCauDangKyCongDan.setNguoiTao(NguoiTao);
	}

	/**
	* Returns the nguoi sua of this yeu cau dang ky cong dan.
	*
	* @return the nguoi sua of this yeu cau dang ky cong dan
	*/
	public java.lang.String getNguoiSua() {
		return _yeuCauDangKyCongDan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this yeu cau dang ky cong dan.
	*
	* @param NguoiSua the nguoi sua of this yeu cau dang ky cong dan
	*/
	public void setNguoiSua(java.lang.String NguoiSua) {
		_yeuCauDangKyCongDan.setNguoiSua(NguoiSua);
	}

	/**
	* Returns the xoa of this yeu cau dang ky cong dan.
	*
	* @return the xoa of this yeu cau dang ky cong dan
	*/
	public int getXoa() {
		return _yeuCauDangKyCongDan.getXoa();
	}

	/**
	* Sets the xoa of this yeu cau dang ky cong dan.
	*
	* @param Xoa the xoa of this yeu cau dang ky cong dan
	*/
	public void setXoa(int Xoa) {
		_yeuCauDangKyCongDan.setXoa(Xoa);
	}

	public boolean isNew() {
		return _yeuCauDangKyCongDan.isNew();
	}

	public void setNew(boolean n) {
		_yeuCauDangKyCongDan.setNew(n);
	}

	public boolean isCachedModel() {
		return _yeuCauDangKyCongDan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_yeuCauDangKyCongDan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _yeuCauDangKyCongDan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _yeuCauDangKyCongDan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_yeuCauDangKyCongDan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _yeuCauDangKyCongDan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_yeuCauDangKyCongDan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new YeuCauDangKyCongDanWrapper((YeuCauDangKyCongDan)_yeuCauDangKyCongDan.clone());
	}

	public int compareTo(
		org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan yeuCauDangKyCongDan) {
		return _yeuCauDangKyCongDan.compareTo(yeuCauDangKyCongDan);
	}

	@Override
	public int hashCode() {
		return _yeuCauDangKyCongDan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan> toCacheModel() {
		return _yeuCauDangKyCongDan.toCacheModel();
	}

	public org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan toEscapedModel() {
		return new YeuCauDangKyCongDanWrapper(_yeuCauDangKyCongDan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _yeuCauDangKyCongDan.toString();
	}

	public java.lang.String toXmlString() {
		return _yeuCauDangKyCongDan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_yeuCauDangKyCongDan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public YeuCauDangKyCongDan getWrappedYeuCauDangKyCongDan() {
		return _yeuCauDangKyCongDan;
	}

	public YeuCauDangKyCongDan getWrappedModel() {
		return _yeuCauDangKyCongDan;
	}

	public void resetOriginalValues() {
		_yeuCauDangKyCongDan.resetOriginalValues();
	}

	private YeuCauDangKyCongDan _yeuCauDangKyCongDan;
}