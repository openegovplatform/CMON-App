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

package org.oep.cmon.dao.cd.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CongDan}.
 * </p>
 *
 * @author    LIEMNN
 * @see       CongDan
 * @generated
 */
public class CongDanWrapper implements CongDan, ModelWrapper<CongDan> {
	public CongDanWrapper(CongDan congDan) {
		_congDan = congDan;
	}

	public Class<?> getModelClass() {
		return CongDan.class;
	}

	public String getModelClassName() {
		return CongDan.class.getName();
	}

	/**
	* Returns the primary key of this cong dan.
	*
	* @return the primary key of this cong dan
	*/
	public long getPrimaryKey() {
		return _congDan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cong dan.
	*
	* @param primaryKey the primary key of this cong dan
	*/
	public void setPrimaryKey(long primaryKey) {
		_congDan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this cong dan.
	*
	* @return the ID of this cong dan
	*/
	public long getId() {
		return _congDan.getId();
	}

	/**
	* Sets the ID of this cong dan.
	*
	* @param id the ID of this cong dan
	*/
	public void setId(long id) {
		_congDan.setId(id);
	}

	/**
	* Returns the ma of this cong dan.
	*
	* @return the ma of this cong dan
	*/
	public java.lang.String getMa() {
		return _congDan.getMa();
	}

	/**
	* Sets the ma of this cong dan.
	*
	* @param ma the ma of this cong dan
	*/
	public void setMa(java.lang.String ma) {
		_congDan.setMa(ma);
	}

	/**
	* Returns the ho of this cong dan.
	*
	* @return the ho of this cong dan
	*/
	public java.lang.String getHo() {
		return _congDan.getHo();
	}

	/**
	* Sets the ho of this cong dan.
	*
	* @param ho the ho of this cong dan
	*/
	public void setHo(java.lang.String ho) {
		_congDan.setHo(ho);
	}

	/**
	* Returns the dem of this cong dan.
	*
	* @return the dem of this cong dan
	*/
	public java.lang.String getDem() {
		return _congDan.getDem();
	}

	/**
	* Sets the dem of this cong dan.
	*
	* @param dem the dem of this cong dan
	*/
	public void setDem(java.lang.String dem) {
		_congDan.setDem(dem);
	}

	/**
	* Returns the ten of this cong dan.
	*
	* @return the ten of this cong dan
	*/
	public java.lang.String getTen() {
		return _congDan.getTen();
	}

	/**
	* Sets the ten of this cong dan.
	*
	* @param ten the ten of this cong dan
	*/
	public void setTen(java.lang.String ten) {
		_congDan.setTen(ten);
	}

	/**
	* Returns the ngay sinh of this cong dan.
	*
	* @return the ngay sinh of this cong dan
	*/
	public java.util.Date getNgaySinh() {
		return _congDan.getNgaySinh();
	}

	/**
	* Sets the ngay sinh of this cong dan.
	*
	* @param ngaySinh the ngay sinh of this cong dan
	*/
	public void setNgaySinh(java.util.Date ngaySinh) {
		_congDan.setNgaySinh(ngaySinh);
	}

	/**
	* Returns the so cmnd of this cong dan.
	*
	* @return the so cmnd of this cong dan
	*/
	public java.lang.String getSoCmnd() {
		return _congDan.getSoCmnd();
	}

	/**
	* Sets the so cmnd of this cong dan.
	*
	* @param soCmnd the so cmnd of this cong dan
	*/
	public void setSoCmnd(java.lang.String soCmnd) {
		_congDan.setSoCmnd(soCmnd);
	}

	/**
	* Returns the ngay cap cmnd of this cong dan.
	*
	* @return the ngay cap cmnd of this cong dan
	*/
	public java.util.Date getNgayCapCmnd() {
		return _congDan.getNgayCapCmnd();
	}

	/**
	* Sets the ngay cap cmnd of this cong dan.
	*
	* @param ngayCapCmnd the ngay cap cmnd of this cong dan
	*/
	public void setNgayCapCmnd(java.util.Date ngayCapCmnd) {
		_congDan.setNgayCapCmnd(ngayCapCmnd);
	}

	/**
	* Returns the ghi chu cmnd of this cong dan.
	*
	* @return the ghi chu cmnd of this cong dan
	*/
	public java.lang.String getGhiChuCmnd() {
		return _congDan.getGhiChuCmnd();
	}

	/**
	* Sets the ghi chu cmnd of this cong dan.
	*
	* @param ghiChuCmnd the ghi chu cmnd of this cong dan
	*/
	public void setGhiChuCmnd(java.lang.String ghiChuCmnd) {
		_congDan.setGhiChuCmnd(ghiChuCmnd);
	}

	/**
	* Returns the so ho chieu of this cong dan.
	*
	* @return the so ho chieu of this cong dan
	*/
	public java.lang.String getSoHoChieu() {
		return _congDan.getSoHoChieu();
	}

	/**
	* Sets the so ho chieu of this cong dan.
	*
	* @param soHoChieu the so ho chieu of this cong dan
	*/
	public void setSoHoChieu(java.lang.String soHoChieu) {
		_congDan.setSoHoChieu(soHoChieu);
	}

	/**
	* Returns the ngay cap ho chieu of this cong dan.
	*
	* @return the ngay cap ho chieu of this cong dan
	*/
	public java.util.Date getNgayCapHoChieu() {
		return _congDan.getNgayCapHoChieu();
	}

	/**
	* Sets the ngay cap ho chieu of this cong dan.
	*
	* @param ngayCapHoChieu the ngay cap ho chieu of this cong dan
	*/
	public void setNgayCapHoChieu(java.util.Date ngayCapHoChieu) {
		_congDan.setNgayCapHoChieu(ngayCapHoChieu);
	}

	/**
	* Returns the ngay het han ho chieu of this cong dan.
	*
	* @return the ngay het han ho chieu of this cong dan
	*/
	public java.util.Date getNgayHetHanHoChieu() {
		return _congDan.getNgayHetHanHoChieu();
	}

	/**
	* Sets the ngay het han ho chieu of this cong dan.
	*
	* @param ngayHetHanHoChieu the ngay het han ho chieu of this cong dan
	*/
	public void setNgayHetHanHoChieu(java.util.Date ngayHetHanHoChieu) {
		_congDan.setNgayHetHanHoChieu(ngayHetHanHoChieu);
	}

	/**
	* Returns the noi cap ho chieu ID of this cong dan.
	*
	* @return the noi cap ho chieu ID of this cong dan
	*/
	public java.lang.Long getNoiCapHoChieuId() {
		return _congDan.getNoiCapHoChieuId();
	}

	/**
	* Sets the noi cap ho chieu ID of this cong dan.
	*
	* @param noiCapHoChieuId the noi cap ho chieu ID of this cong dan
	*/
	public void setNoiCapHoChieuId(java.lang.Long noiCapHoChieuId) {
		_congDan.setNoiCapHoChieuId(noiCapHoChieuId);
	}

	/**
	* Returns the ghi chu ho chieu of this cong dan.
	*
	* @return the ghi chu ho chieu of this cong dan
	*/
	public java.lang.String getGhiChuHoChieu() {
		return _congDan.getGhiChuHoChieu();
	}

	/**
	* Sets the ghi chu ho chieu of this cong dan.
	*
	* @param ghiChuHoChieu the ghi chu ho chieu of this cong dan
	*/
	public void setGhiChuHoChieu(java.lang.String ghiChuHoChieu) {
		_congDan.setGhiChuHoChieu(ghiChuHoChieu);
	}

	/**
	* Returns the so bao hiem y te of this cong dan.
	*
	* @return the so bao hiem y te of this cong dan
	*/
	public java.lang.String getSoBaoHiemYTe() {
		return _congDan.getSoBaoHiemYTe();
	}

	/**
	* Sets the so bao hiem y te of this cong dan.
	*
	* @param soBaoHiemYTe the so bao hiem y te of this cong dan
	*/
	public void setSoBaoHiemYTe(java.lang.String soBaoHiemYTe) {
		_congDan.setSoBaoHiemYTe(soBaoHiemYTe);
	}

	/**
	* Returns the ma so thue ca nhan of this cong dan.
	*
	* @return the ma so thue ca nhan of this cong dan
	*/
	public java.lang.String getMaSoThueCaNhan() {
		return _congDan.getMaSoThueCaNhan();
	}

	/**
	* Sets the ma so thue ca nhan of this cong dan.
	*
	* @param maSoThueCaNhan the ma so thue ca nhan of this cong dan
	*/
	public void setMaSoThueCaNhan(java.lang.String maSoThueCaNhan) {
		_congDan.setMaSoThueCaNhan(maSoThueCaNhan);
	}

	/**
	* Returns the dia chi thuong tru of this cong dan.
	*
	* @return the dia chi thuong tru of this cong dan
	*/
	public java.lang.String getDiaChiThuongTru() {
		return _congDan.getDiaChiThuongTru();
	}

	/**
	* Sets the dia chi thuong tru of this cong dan.
	*
	* @param diaChiThuongTru the dia chi thuong tru of this cong dan
	*/
	public void setDiaChiThuongTru(java.lang.String diaChiThuongTru) {
		_congDan.setDiaChiThuongTru(diaChiThuongTru);
	}

	/**
	* Returns the dia chi hien nay of this cong dan.
	*
	* @return the dia chi hien nay of this cong dan
	*/
	public java.lang.String getDiaChiHienNay() {
		return _congDan.getDiaChiHienNay();
	}

	/**
	* Sets the dia chi hien nay of this cong dan.
	*
	* @param diaChiHienNay the dia chi hien nay of this cong dan
	*/
	public void setDiaChiHienNay(java.lang.String diaChiHienNay) {
		_congDan.setDiaChiHienNay(diaChiHienNay);
	}

	/**
	* Returns the dien thoai co dinh of this cong dan.
	*
	* @return the dien thoai co dinh of this cong dan
	*/
	public java.lang.String getDienThoaiCoDinh() {
		return _congDan.getDienThoaiCoDinh();
	}

	/**
	* Sets the dien thoai co dinh of this cong dan.
	*
	* @param dienThoaiCoDinh the dien thoai co dinh of this cong dan
	*/
	public void setDienThoaiCoDinh(java.lang.String dienThoaiCoDinh) {
		_congDan.setDienThoaiCoDinh(dienThoaiCoDinh);
	}

	/**
	* Returns the dien thoai di dong of this cong dan.
	*
	* @return the dien thoai di dong of this cong dan
	*/
	public java.lang.String getDienThoaiDiDong() {
		return _congDan.getDienThoaiDiDong();
	}

	/**
	* Sets the dien thoai di dong of this cong dan.
	*
	* @param dienThoaiDiDong the dien thoai di dong of this cong dan
	*/
	public void setDienThoaiDiDong(java.lang.String dienThoaiDiDong) {
		_congDan.setDienThoaiDiDong(dienThoaiDiDong);
	}

	/**
	* Returns the ho ten cha of this cong dan.
	*
	* @return the ho ten cha of this cong dan
	*/
	public java.lang.String getHoTenCha() {
		return _congDan.getHoTenCha();
	}

	/**
	* Sets the ho ten cha of this cong dan.
	*
	* @param hoTenCha the ho ten cha of this cong dan
	*/
	public void setHoTenCha(java.lang.String hoTenCha) {
		_congDan.setHoTenCha(hoTenCha);
	}

	/**
	* Returns the ho ten me of this cong dan.
	*
	* @return the ho ten me of this cong dan
	*/
	public java.lang.String getHoTenMe() {
		return _congDan.getHoTenMe();
	}

	/**
	* Sets the ho ten me of this cong dan.
	*
	* @param hoTenMe the ho ten me of this cong dan
	*/
	public void setHoTenMe(java.lang.String hoTenMe) {
		_congDan.setHoTenMe(hoTenMe);
	}

	/**
	* Returns the ho ten vo hoac chong of this cong dan.
	*
	* @return the ho ten vo hoac chong of this cong dan
	*/
	public java.lang.String getHoTenVoHoacChong() {
		return _congDan.getHoTenVoHoacChong();
	}

	/**
	* Sets the ho ten vo hoac chong of this cong dan.
	*
	* @param hoTenVoHoacChong the ho ten vo hoac chong of this cong dan
	*/
	public void setHoTenVoHoacChong(java.lang.String hoTenVoHoacChong) {
		_congDan.setHoTenVoHoacChong(hoTenVoHoacChong);
	}

	/**
	* Returns the so ho khau of this cong dan.
	*
	* @return the so ho khau of this cong dan
	*/
	public java.lang.String getSoHoKhau() {
		return _congDan.getSoHoKhau();
	}

	/**
	* Sets the so ho khau of this cong dan.
	*
	* @param soHoKhau the so ho khau of this cong dan
	*/
	public void setSoHoKhau(java.lang.String soHoKhau) {
		_congDan.setSoHoKhau(soHoKhau);
	}

	/**
	* Returns the la chu ho of this cong dan.
	*
	* @return the la chu ho of this cong dan
	*/
	public int getLaChuHo() {
		return _congDan.getLaChuHo();
	}

	/**
	* Sets the la chu ho of this cong dan.
	*
	* @param laChuHo the la chu ho of this cong dan
	*/
	public void setLaChuHo(int laChuHo) {
		_congDan.setLaChuHo(laChuHo);
	}

	/**
	* Returns the tinh trang hon nhan ID of this cong dan.
	*
	* @return the tinh trang hon nhan ID of this cong dan
	*/
	public java.lang.Long getTinhTrangHonNhanId() {
		return _congDan.getTinhTrangHonNhanId();
	}

	/**
	* Sets the tinh trang hon nhan ID of this cong dan.
	*
	* @param tinhTrangHonNhanId the tinh trang hon nhan ID of this cong dan
	*/
	public void setTinhTrangHonNhanId(java.lang.Long tinhTrangHonNhanId) {
		_congDan.setTinhTrangHonNhanId(tinhTrangHonNhanId);
	}

	/**
	* Returns the email of this cong dan.
	*
	* @return the email of this cong dan
	*/
	public java.lang.String getEmail() {
		return _congDan.getEmail();
	}

	/**
	* Sets the email of this cong dan.
	*
	* @param email the email of this cong dan
	*/
	public void setEmail(java.lang.String email) {
		_congDan.setEmail(email);
	}

	/**
	* Returns the trinh do chuyen mon ID of this cong dan.
	*
	* @return the trinh do chuyen mon ID of this cong dan
	*/
	public java.lang.Long getTrinhDoChuyenMonId() {
		return _congDan.getTrinhDoChuyenMonId();
	}

	/**
	* Sets the trinh do chuyen mon ID of this cong dan.
	*
	* @param trinhDoChuyenMonId the trinh do chuyen mon ID of this cong dan
	*/
	public void setTrinhDoChuyenMonId(java.lang.Long trinhDoChuyenMonId) {
		_congDan.setTrinhDoChuyenMonId(trinhDoChuyenMonId);
	}

	/**
	* Returns the so dinh danh cha ID of this cong dan.
	*
	* @return the so dinh danh cha ID of this cong dan
	*/
	public java.lang.Long getSoDinhDanhChaId() {
		return _congDan.getSoDinhDanhChaId();
	}

	/**
	* Sets the so dinh danh cha ID of this cong dan.
	*
	* @param soDinhDanhChaId the so dinh danh cha ID of this cong dan
	*/
	public void setSoDinhDanhChaId(java.lang.Long soDinhDanhChaId) {
		_congDan.setSoDinhDanhChaId(soDinhDanhChaId);
	}

	/**
	* Returns the so dinh danh vo hoac chong ID of this cong dan.
	*
	* @return the so dinh danh vo hoac chong ID of this cong dan
	*/
	public java.lang.Long getSoDinhDanhVoHoacChongId() {
		return _congDan.getSoDinhDanhVoHoacChongId();
	}

	/**
	* Sets the so dinh danh vo hoac chong ID of this cong dan.
	*
	* @param soDinhDanhVoHoacChongId the so dinh danh vo hoac chong ID of this cong dan
	*/
	public void setSoDinhDanhVoHoacChongId(
		java.lang.Long soDinhDanhVoHoacChongId) {
		_congDan.setSoDinhDanhVoHoacChongId(soDinhDanhVoHoacChongId);
	}

	/**
	* Returns the dan toc ID of this cong dan.
	*
	* @return the dan toc ID of this cong dan
	*/
	public java.lang.Long getDanTocId() {
		return _congDan.getDanTocId();
	}

	/**
	* Sets the dan toc ID of this cong dan.
	*
	* @param danTocId the dan toc ID of this cong dan
	*/
	public void setDanTocId(java.lang.Long danTocId) {
		_congDan.setDanTocId(danTocId);
	}

	/**
	* Returns the dia chi hien nay huyen ID of this cong dan.
	*
	* @return the dia chi hien nay huyen ID of this cong dan
	*/
	public java.lang.Long getDiaChiHienNayHuyenId() {
		return _congDan.getDiaChiHienNayHuyenId();
	}

	/**
	* Sets the dia chi hien nay huyen ID of this cong dan.
	*
	* @param diaChiHienNayHuyenId the dia chi hien nay huyen ID of this cong dan
	*/
	public void setDiaChiHienNayHuyenId(java.lang.Long diaChiHienNayHuyenId) {
		_congDan.setDiaChiHienNayHuyenId(diaChiHienNayHuyenId);
	}

	/**
	* Returns the dia chi hien nay tinh ID of this cong dan.
	*
	* @return the dia chi hien nay tinh ID of this cong dan
	*/
	public java.lang.Long getDiaChiHienNayTinhId() {
		return _congDan.getDiaChiHienNayTinhId();
	}

	/**
	* Sets the dia chi hien nay tinh ID of this cong dan.
	*
	* @param diaChiHienNayTinhId the dia chi hien nay tinh ID of this cong dan
	*/
	public void setDiaChiHienNayTinhId(java.lang.Long diaChiHienNayTinhId) {
		_congDan.setDiaChiHienNayTinhId(diaChiHienNayTinhId);
	}

	/**
	* Returns the dia chi hien nay xa ID of this cong dan.
	*
	* @return the dia chi hien nay xa ID of this cong dan
	*/
	public java.lang.Long getDiaChiHienNayXaId() {
		return _congDan.getDiaChiHienNayXaId();
	}

	/**
	* Sets the dia chi hien nay xa ID of this cong dan.
	*
	* @param diaChiHienNayXaId the dia chi hien nay xa ID of this cong dan
	*/
	public void setDiaChiHienNayXaId(java.lang.Long diaChiHienNayXaId) {
		_congDan.setDiaChiHienNayXaId(diaChiHienNayXaId);
	}

	/**
	* Returns the dia chi thuong tru huyen ID of this cong dan.
	*
	* @return the dia chi thuong tru huyen ID of this cong dan
	*/
	public java.lang.Long getDiaChiThuongTruHuyenId() {
		return _congDan.getDiaChiThuongTruHuyenId();
	}

	/**
	* Sets the dia chi thuong tru huyen ID of this cong dan.
	*
	* @param diaChiThuongTruHuyenId the dia chi thuong tru huyen ID of this cong dan
	*/
	public void setDiaChiThuongTruHuyenId(java.lang.Long diaChiThuongTruHuyenId) {
		_congDan.setDiaChiThuongTruHuyenId(diaChiThuongTruHuyenId);
	}

	/**
	* Returns the dia chi thuong tru tinh ID of this cong dan.
	*
	* @return the dia chi thuong tru tinh ID of this cong dan
	*/
	public java.lang.Long getDiaChiThuongTruTinhId() {
		return _congDan.getDiaChiThuongTruTinhId();
	}

	/**
	* Sets the dia chi thuong tru tinh ID of this cong dan.
	*
	* @param diaChiThuongTruTinhId the dia chi thuong tru tinh ID of this cong dan
	*/
	public void setDiaChiThuongTruTinhId(java.lang.Long diaChiThuongTruTinhId) {
		_congDan.setDiaChiThuongTruTinhId(diaChiThuongTruTinhId);
	}

	/**
	* Returns the dia chi thuong tru xa ID of this cong dan.
	*
	* @return the dia chi thuong tru xa ID of this cong dan
	*/
	public java.lang.Long getDiaChiThuongTruXaId() {
		return _congDan.getDiaChiThuongTruXaId();
	}

	/**
	* Sets the dia chi thuong tru xa ID of this cong dan.
	*
	* @param diaChiThuongTruXaId the dia chi thuong tru xa ID of this cong dan
	*/
	public void setDiaChiThuongTruXaId(java.lang.Long diaChiThuongTruXaId) {
		_congDan.setDiaChiThuongTruXaId(diaChiThuongTruXaId);
	}

	/**
	* Returns the gioi tinh of this cong dan.
	*
	* @return the gioi tinh of this cong dan
	*/
	public int getGioiTinh() {
		return _congDan.getGioiTinh();
	}

	/**
	* Sets the gioi tinh of this cong dan.
	*
	* @param gioiTinh the gioi tinh of this cong dan
	*/
	public void setGioiTinh(int gioiTinh) {
		_congDan.setGioiTinh(gioiTinh);
	}

	/**
	* Returns the nghe nghiep ID of this cong dan.
	*
	* @return the nghe nghiep ID of this cong dan
	*/
	public java.lang.Long getNgheNghiepId() {
		return _congDan.getNgheNghiepId();
	}

	/**
	* Sets the nghe nghiep ID of this cong dan.
	*
	* @param ngheNghiepId the nghe nghiep ID of this cong dan
	*/
	public void setNgheNghiepId(java.lang.Long ngheNghiepId) {
		_congDan.setNgheNghiepId(ngheNghiepId);
	}

	/**
	* Returns the noi sinh huyen ID of this cong dan.
	*
	* @return the noi sinh huyen ID of this cong dan
	*/
	public java.lang.Long getNoiSinhHuyenId() {
		return _congDan.getNoiSinhHuyenId();
	}

	/**
	* Sets the noi sinh huyen ID of this cong dan.
	*
	* @param noiSinhHuyenId the noi sinh huyen ID of this cong dan
	*/
	public void setNoiSinhHuyenId(java.lang.Long noiSinhHuyenId) {
		_congDan.setNoiSinhHuyenId(noiSinhHuyenId);
	}

	/**
	* Returns the noi sinh tinh ID of this cong dan.
	*
	* @return the noi sinh tinh ID of this cong dan
	*/
	public java.lang.Long getNoiSinhTinhId() {
		return _congDan.getNoiSinhTinhId();
	}

	/**
	* Sets the noi sinh tinh ID of this cong dan.
	*
	* @param noiSinhTinhId the noi sinh tinh ID of this cong dan
	*/
	public void setNoiSinhTinhId(java.lang.Long noiSinhTinhId) {
		_congDan.setNoiSinhTinhId(noiSinhTinhId);
	}

	/**
	* Returns the noi sinh xa ID of this cong dan.
	*
	* @return the noi sinh xa ID of this cong dan
	*/
	public java.lang.Long getNoiSinhXaId() {
		return _congDan.getNoiSinhXaId();
	}

	/**
	* Sets the noi sinh xa ID of this cong dan.
	*
	* @param noiSinhXaId the noi sinh xa ID of this cong dan
	*/
	public void setNoiSinhXaId(java.lang.Long noiSinhXaId) {
		_congDan.setNoiSinhXaId(noiSinhXaId);
	}

	/**
	* Returns the noi sinh chi tiet of this cong dan.
	*
	* @return the noi sinh chi tiet of this cong dan
	*/
	public java.lang.String getNoiSinhChiTiet() {
		return _congDan.getNoiSinhChiTiet();
	}

	/**
	* Sets the noi sinh chi tiet of this cong dan.
	*
	* @param noiSinhChiTiet the noi sinh chi tiet of this cong dan
	*/
	public void setNoiSinhChiTiet(java.lang.String noiSinhChiTiet) {
		_congDan.setNoiSinhChiTiet(noiSinhChiTiet);
	}

	/**
	* Returns the noi cap cmnd ID of this cong dan.
	*
	* @return the noi cap cmnd ID of this cong dan
	*/
	public java.lang.Long getNoiCapCmndId() {
		return _congDan.getNoiCapCmndId();
	}

	/**
	* Sets the noi cap cmnd ID of this cong dan.
	*
	* @param noiCapCmndId the noi cap cmnd ID of this cong dan
	*/
	public void setNoiCapCmndId(java.lang.Long noiCapCmndId) {
		_congDan.setNoiCapCmndId(noiCapCmndId);
	}

	/**
	* Returns the ton giao ID of this cong dan.
	*
	* @return the ton giao ID of this cong dan
	*/
	public java.lang.Long getTonGiaoId() {
		return _congDan.getTonGiaoId();
	}

	/**
	* Sets the ton giao ID of this cong dan.
	*
	* @param tonGiaoId the ton giao ID of this cong dan
	*/
	public void setTonGiaoId(java.lang.Long tonGiaoId) {
		_congDan.setTonGiaoId(tonGiaoId);
	}

	/**
	* Returns the so dinh danh me ID of this cong dan.
	*
	* @return the so dinh danh me ID of this cong dan
	*/
	public java.lang.Long getSoDinhDanhMeId() {
		return _congDan.getSoDinhDanhMeId();
	}

	/**
	* Sets the so dinh danh me ID of this cong dan.
	*
	* @param soDinhDanhMeId the so dinh danh me ID of this cong dan
	*/
	public void setSoDinhDanhMeId(java.lang.Long soDinhDanhMeId) {
		_congDan.setSoDinhDanhMeId(soDinhDanhMeId);
	}

	/**
	* Returns the trinh do hoc van ID of this cong dan.
	*
	* @return the trinh do hoc van ID of this cong dan
	*/
	public java.lang.Long getTrinhDoHocVanId() {
		return _congDan.getTrinhDoHocVanId();
	}

	/**
	* Sets the trinh do hoc van ID of this cong dan.
	*
	* @param trinhDoHocVanId the trinh do hoc van ID of this cong dan
	*/
	public void setTrinhDoHocVanId(java.lang.Long trinhDoHocVanId) {
		_congDan.setTrinhDoHocVanId(trinhDoHocVanId);
	}

	/**
	* Returns the tai khoan nguoi dung ID of this cong dan.
	*
	* @return the tai khoan nguoi dung ID of this cong dan
	*/
	public java.lang.Long getTaiKhoanNguoiDungId() {
		return _congDan.getTaiKhoanNguoiDungId();
	}

	/**
	* Sets the tai khoan nguoi dung ID of this cong dan.
	*
	* @param taiKhoanNguoiDungId the tai khoan nguoi dung ID of this cong dan
	*/
	public void setTaiKhoanNguoiDungId(java.lang.Long taiKhoanNguoiDungId) {
		_congDan.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
	}

	/**
	* Returns the quan he chu ho ID of this cong dan.
	*
	* @return the quan he chu ho ID of this cong dan
	*/
	public java.lang.Long getQuanHeChuHoId() {
		return _congDan.getQuanHeChuHoId();
	}

	/**
	* Sets the quan he chu ho ID of this cong dan.
	*
	* @param quanHeChuHoId the quan he chu ho ID of this cong dan
	*/
	public void setQuanHeChuHoId(java.lang.Long quanHeChuHoId) {
		_congDan.setQuanHeChuHoId(quanHeChuHoId);
	}

	/**
	* Returns the quoc tich ID of this cong dan.
	*
	* @return the quoc tich ID of this cong dan
	*/
	public java.lang.Long getQuocTichId() {
		return _congDan.getQuocTichId();
	}

	/**
	* Sets the quoc tich ID of this cong dan.
	*
	* @param quocTichId the quoc tich ID of this cong dan
	*/
	public void setQuocTichId(java.lang.Long quocTichId) {
		_congDan.setQuocTichId(quocTichId);
	}

	/**
	* Returns the doanh nghiep ID of this cong dan.
	*
	* @return the doanh nghiep ID of this cong dan
	*/
	public java.lang.Long getDoanhNghiepId() {
		return _congDan.getDoanhNghiepId();
	}

	/**
	* Sets the doanh nghiep ID of this cong dan.
	*
	* @param doanhNghiepId the doanh nghiep ID of this cong dan
	*/
	public void setDoanhNghiepId(java.lang.Long doanhNghiepId) {
		_congDan.setDoanhNghiepId(doanhNghiepId);
	}

	/**
	* Returns the ten day du of this cong dan.
	*
	* @return the ten day du of this cong dan
	*/
	public java.lang.String getTenDayDu() {
		return _congDan.getTenDayDu();
	}

	/**
	* Sets the ten day du of this cong dan.
	*
	* @param tenDayDu the ten day du of this cong dan
	*/
	public void setTenDayDu(java.lang.String tenDayDu) {
		_congDan.setTenDayDu(tenDayDu);
	}

	/**
	* Returns the ngay tao of this cong dan.
	*
	* @return the ngay tao of this cong dan
	*/
	public java.util.Date getNgayTao() {
		return _congDan.getNgayTao();
	}

	/**
	* Sets the ngay tao of this cong dan.
	*
	* @param ngayTao the ngay tao of this cong dan
	*/
	public void setNgayTao(java.util.Date ngayTao) {
		_congDan.setNgayTao(ngayTao);
	}

	/**
	* Returns the ngay sua of this cong dan.
	*
	* @return the ngay sua of this cong dan
	*/
	public java.util.Date getNgaySua() {
		return _congDan.getNgaySua();
	}

	/**
	* Sets the ngay sua of this cong dan.
	*
	* @param ngaySua the ngay sua of this cong dan
	*/
	public void setNgaySua(java.util.Date ngaySua) {
		_congDan.setNgaySua(ngaySua);
	}

	/**
	* Returns the nguoi tao of this cong dan.
	*
	* @return the nguoi tao of this cong dan
	*/
	public java.lang.String getNguoiTao() {
		return _congDan.getNguoiTao();
	}

	/**
	* Sets the nguoi tao of this cong dan.
	*
	* @param nguoiTao the nguoi tao of this cong dan
	*/
	public void setNguoiTao(java.lang.String nguoiTao) {
		_congDan.setNguoiTao(nguoiTao);
	}

	/**
	* Returns the nguoi sua of this cong dan.
	*
	* @return the nguoi sua of this cong dan
	*/
	public java.lang.String getNguoiSua() {
		return _congDan.getNguoiSua();
	}

	/**
	* Sets the nguoi sua of this cong dan.
	*
	* @param nguoiSua the nguoi sua of this cong dan
	*/
	public void setNguoiSua(java.lang.String nguoiSua) {
		_congDan.setNguoiSua(nguoiSua);
	}

	/**
	* Returns the da xoa of this cong dan.
	*
	* @return the da xoa of this cong dan
	*/
	public int getDaXoa() {
		return _congDan.getDaXoa();
	}

	/**
	* Sets the da xoa of this cong dan.
	*
	* @param daXoa the da xoa of this cong dan
	*/
	public void setDaXoa(int daXoa) {
		_congDan.setDaXoa(daXoa);
	}

	/**
	* Returns the fax of this cong dan.
	*
	* @return the fax of this cong dan
	*/
	public java.lang.String getFax() {
		return _congDan.getFax();
	}

	/**
	* Sets the fax of this cong dan.
	*
	* @param fax the fax of this cong dan
	*/
	public void setFax(java.lang.String fax) {
		_congDan.setFax(fax);
	}

	/**
	* Returns the website of this cong dan.
	*
	* @return the website of this cong dan
	*/
	public java.lang.String getWebsite() {
		return _congDan.getWebsite();
	}

	/**
	* Sets the website of this cong dan.
	*
	* @param website the website of this cong dan
	*/
	public void setWebsite(java.lang.String website) {
		_congDan.setWebsite(website);
	}

	/**
	* Returns the tinhtrang of this cong dan.
	*
	* @return the tinhtrang of this cong dan
	*/
	public int getTinhtrang() {
		return _congDan.getTinhtrang();
	}

	/**
	* Sets the tinhtrang of this cong dan.
	*
	* @param tinhtrang the tinhtrang of this cong dan
	*/
	public void setTinhtrang(int tinhtrang) {
		_congDan.setTinhtrang(tinhtrang);
	}

	public boolean isNew() {
		return _congDan.isNew();
	}

	public void setNew(boolean n) {
		_congDan.setNew(n);
	}

	public boolean isCachedModel() {
		return _congDan.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_congDan.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _congDan.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _congDan.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_congDan.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _congDan.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_congDan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CongDanWrapper((CongDan)_congDan.clone());
	}

	public int compareTo(org.oep.cmon.dao.cd.model.CongDan congDan) {
		return _congDan.compareTo(congDan);
	}

	@Override
	public int hashCode() {
		return _congDan.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.oep.cmon.dao.cd.model.CongDan> toCacheModel() {
		return _congDan.toCacheModel();
	}

	public org.oep.cmon.dao.cd.model.CongDan toEscapedModel() {
		return new CongDanWrapper(_congDan.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _congDan.toString();
	}

	public java.lang.String toXmlString() {
		return _congDan.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_congDan.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CongDan getWrappedCongDan() {
		return _congDan;
	}

	public CongDan getWrappedModel() {
		return _congDan;
	}

	public void resetOriginalValues() {
		_congDan.resetOriginalValues();
	}

	private CongDan _congDan;
}