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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Liemnn
 * @generated
 */
public class DoanhNghiepSoap implements Serializable {
	public static DoanhNghiepSoap toSoapModel(DoanhNghiep model) {
		DoanhNghiepSoap soapModel = new DoanhNghiepSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setMaSoThue(model.getMaSoThue());
		soapModel.setTenTiengNuocNgoai(model.getTenTiengNuocNgoai());
		soapModel.setTenVietTat(model.getTenVietTat());
		soapModel.setDiaChiDoanhNghiep(model.getDiaChiDoanhNghiep());
		soapModel.setDienThoaiDoanhNghiep(model.getDienThoaiDoanhNghiep());
		soapModel.setFax(model.getFax());
		soapModel.setEmailDoanhNghiep(model.getEmailDoanhNghiep());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setTongSoVon(model.getTongSoVon());
		soapModel.setMoTaNganhNgheKinhDoanh(model.getMoTaNganhNgheKinhDoanh());
		soapModel.setSoGCNDKKD(model.getSoGCNDKKD());
		soapModel.setNgayCapGCNDKKD(model.getNgayCapGCNDKKD());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setNgayDieuLeDuocThongQua(model.getNgayDieuLeDuocThongQua());
		soapModel.setTenChiNhanh(model.getTenChiNhanh());
		soapModel.setDiaChiChiNhanh(model.getDiaChiChiNhanh());
		soapModel.setTenVanPhongDaiDien(model.getTenVanPhongDaiDien());
		soapModel.setDiaChiVanPhongDaiDien(model.getDiaChiVanPhongDaiDien());
		soapModel.setNgayBatDauTamNgung(model.getNgayBatDauTamNgung());
		soapModel.setNgayKetThucTamNgung(model.getNgayKetThucTamNgung());
		soapModel.setLyDoTamNgung(model.getLyDoTamNgung());
		soapModel.setNgayChamDutHoatDongKD(model.getNgayChamDutHoatDongKD());
		soapModel.setLoai(model.getLoai());
		soapModel.setDiaChiDoanhNghiepHuyenId(model.getDiaChiDoanhNghiepHuyenId());
		soapModel.setDiaChiDoanhNghiepTinhId(model.getDiaChiDoanhNghiepTinhId());
		soapModel.setDiaChiDoanhNghiepXaId(model.getDiaChiDoanhNghiepXaId());
		soapModel.setLoaiDoiTuongId(model.getLoaiDoiTuongId());
		soapModel.setNguoiDaiDienId(model.getNguoiDaiDienId());
		soapModel.setTrangThaiDoanhNghiepId(model.getTrangThaiDoanhNghiepId());
		soapModel.setVonDieuLe(model.getVonDieuLe());
		soapModel.setVonToiThieuMotXaVien(model.getVonToiThieuMotXaVien());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setQuocGiaId(model.getQuocGiaId());
		soapModel.setCoQuanCapId(model.getCoQuanCapId());
		soapModel.setTenCoQuanCap(model.getTenCoQuanCap());
		soapModel.setSoLanDieuChinh(model.getSoLanDieuChinh());
		soapModel.setNgayDieuChinh(model.getNgayDieuChinh());
		soapModel.setChucVuNguoiDaiDien(model.getChucVuNguoiDaiDien());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setChaId(model.getChaId());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());
		soapModel.setTenDiaDiemKinhDoanh(model.getTenDiaDiemKinhDoanh());
		soapModel.setNgayDangKyKinhDoanh(model.getNgayDangKyKinhDoanh());
		soapModel.setLoaiHinhDoanhNghiepId(model.getLoaiHinhDoanhNghiepId());

		return soapModel;
	}

	public static DoanhNghiepSoap[] toSoapModels(DoanhNghiep[] models) {
		DoanhNghiepSoap[] soapModels = new DoanhNghiepSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DoanhNghiepSoap[][] toSoapModels(DoanhNghiep[][] models) {
		DoanhNghiepSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DoanhNghiepSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DoanhNghiepSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DoanhNghiepSoap[] toSoapModels(List<DoanhNghiep> models) {
		List<DoanhNghiepSoap> soapModels = new ArrayList<DoanhNghiepSoap>(models.size());

		for (DoanhNghiep model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DoanhNghiepSoap[soapModels.size()]);
	}

	public DoanhNghiepSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMaSoThue() {
		return _maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		_maSoThue = maSoThue;
	}

	public String getTenTiengNuocNgoai() {
		return _tenTiengNuocNgoai;
	}

	public void setTenTiengNuocNgoai(String tenTiengNuocNgoai) {
		_tenTiengNuocNgoai = tenTiengNuocNgoai;
	}

	public String getTenVietTat() {
		return _tenVietTat;
	}

	public void setTenVietTat(String tenVietTat) {
		_tenVietTat = tenVietTat;
	}

	public String getDiaChiDoanhNghiep() {
		return _diaChiDoanhNghiep;
	}

	public void setDiaChiDoanhNghiep(String diaChiDoanhNghiep) {
		_diaChiDoanhNghiep = diaChiDoanhNghiep;
	}

	public String getDienThoaiDoanhNghiep() {
		return _dienThoaiDoanhNghiep;
	}

	public void setDienThoaiDoanhNghiep(String dienThoaiDoanhNghiep) {
		_dienThoaiDoanhNghiep = dienThoaiDoanhNghiep;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getEmailDoanhNghiep() {
		return _emailDoanhNghiep;
	}

	public void setEmailDoanhNghiep(String emailDoanhNghiep) {
		_emailDoanhNghiep = emailDoanhNghiep;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public long getTongSoVon() {
		return _tongSoVon;
	}

	public void setTongSoVon(long tongSoVon) {
		_tongSoVon = tongSoVon;
	}

	public String getMoTaNganhNgheKinhDoanh() {
		return _moTaNganhNgheKinhDoanh;
	}

	public void setMoTaNganhNgheKinhDoanh(String moTaNganhNgheKinhDoanh) {
		_moTaNganhNgheKinhDoanh = moTaNganhNgheKinhDoanh;
	}

	public String getSoGCNDKKD() {
		return _soGCNDKKD;
	}

	public void setSoGCNDKKD(String soGCNDKKD) {
		_soGCNDKKD = soGCNDKKD;
	}

	public Date getNgayCapGCNDKKD() {
		return _ngayCapGCNDKKD;
	}

	public void setNgayCapGCNDKKD(Date ngayCapGCNDKKD) {
		_ngayCapGCNDKKD = ngayCapGCNDKKD;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public Date getNgayDieuLeDuocThongQua() {
		return _ngayDieuLeDuocThongQua;
	}

	public void setNgayDieuLeDuocThongQua(Date ngayDieuLeDuocThongQua) {
		_ngayDieuLeDuocThongQua = ngayDieuLeDuocThongQua;
	}

	public String getTenChiNhanh() {
		return _tenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		_tenChiNhanh = tenChiNhanh;
	}

	public String getDiaChiChiNhanh() {
		return _diaChiChiNhanh;
	}

	public void setDiaChiChiNhanh(String diaChiChiNhanh) {
		_diaChiChiNhanh = diaChiChiNhanh;
	}

	public String getTenVanPhongDaiDien() {
		return _tenVanPhongDaiDien;
	}

	public void setTenVanPhongDaiDien(String tenVanPhongDaiDien) {
		_tenVanPhongDaiDien = tenVanPhongDaiDien;
	}

	public String getDiaChiVanPhongDaiDien() {
		return _diaChiVanPhongDaiDien;
	}

	public void setDiaChiVanPhongDaiDien(String diaChiVanPhongDaiDien) {
		_diaChiVanPhongDaiDien = diaChiVanPhongDaiDien;
	}

	public Date getNgayBatDauTamNgung() {
		return _ngayBatDauTamNgung;
	}

	public void setNgayBatDauTamNgung(Date ngayBatDauTamNgung) {
		_ngayBatDauTamNgung = ngayBatDauTamNgung;
	}

	public Date getNgayKetThucTamNgung() {
		return _ngayKetThucTamNgung;
	}

	public void setNgayKetThucTamNgung(Date ngayKetThucTamNgung) {
		_ngayKetThucTamNgung = ngayKetThucTamNgung;
	}

	public String getLyDoTamNgung() {
		return _lyDoTamNgung;
	}

	public void setLyDoTamNgung(String lyDoTamNgung) {
		_lyDoTamNgung = lyDoTamNgung;
	}

	public Date getNgayChamDutHoatDongKD() {
		return _ngayChamDutHoatDongKD;
	}

	public void setNgayChamDutHoatDongKD(Date ngayChamDutHoatDongKD) {
		_ngayChamDutHoatDongKD = ngayChamDutHoatDongKD;
	}

	public long getLoai() {
		return _loai;
	}

	public void setLoai(long loai) {
		_loai = loai;
	}

	public Long getDiaChiDoanhNghiepHuyenId() {
		return _diaChiDoanhNghiepHuyenId;
	}

	public void setDiaChiDoanhNghiepHuyenId(Long diaChiDoanhNghiepHuyenId) {
		_diaChiDoanhNghiepHuyenId = diaChiDoanhNghiepHuyenId;
	}

	public Long getDiaChiDoanhNghiepTinhId() {
		return _diaChiDoanhNghiepTinhId;
	}

	public void setDiaChiDoanhNghiepTinhId(Long diaChiDoanhNghiepTinhId) {
		_diaChiDoanhNghiepTinhId = diaChiDoanhNghiepTinhId;
	}

	public Long getDiaChiDoanhNghiepXaId() {
		return _diaChiDoanhNghiepXaId;
	}

	public void setDiaChiDoanhNghiepXaId(Long diaChiDoanhNghiepXaId) {
		_diaChiDoanhNghiepXaId = diaChiDoanhNghiepXaId;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getNguoiDaiDienId() {
		return _nguoiDaiDienId;
	}

	public void setNguoiDaiDienId(Long nguoiDaiDienId) {
		_nguoiDaiDienId = nguoiDaiDienId;
	}

	public Long getTrangThaiDoanhNghiepId() {
		return _trangThaiDoanhNghiepId;
	}

	public void setTrangThaiDoanhNghiepId(Long trangThaiDoanhNghiepId) {
		_trangThaiDoanhNghiepId = trangThaiDoanhNghiepId;
	}

	public long getVonDieuLe() {
		return _vonDieuLe;
	}

	public void setVonDieuLe(long vonDieuLe) {
		_vonDieuLe = vonDieuLe;
	}

	public long getVonToiThieuMotXaVien() {
		return _vonToiThieuMotXaVien;
	}

	public void setVonToiThieuMotXaVien(long vonToiThieuMotXaVien) {
		_vonToiThieuMotXaVien = vonToiThieuMotXaVien;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public Long getQuocGiaId() {
		return _quocGiaId;
	}

	public void setQuocGiaId(Long quocGiaId) {
		_quocGiaId = quocGiaId;
	}

	public Long getCoQuanCapId() {
		return _coQuanCapId;
	}

	public void setCoQuanCapId(Long coQuanCapId) {
		_coQuanCapId = coQuanCapId;
	}

	public long getTenCoQuanCap() {
		return _tenCoQuanCap;
	}

	public void setTenCoQuanCap(long tenCoQuanCap) {
		_tenCoQuanCap = tenCoQuanCap;
	}

	public String getSoLanDieuChinh() {
		return _soLanDieuChinh;
	}

	public void setSoLanDieuChinh(String soLanDieuChinh) {
		_soLanDieuChinh = soLanDieuChinh;
	}

	public Date getNgayDieuChinh() {
		return _ngayDieuChinh;
	}

	public void setNgayDieuChinh(Date ngayDieuChinh) {
		_ngayDieuChinh = ngayDieuChinh;
	}

	public String getChucVuNguoiDaiDien() {
		return _chucVuNguoiDaiDien;
	}

	public void setChucVuNguoiDaiDien(String chucVuNguoiDaiDien) {
		_chucVuNguoiDaiDien = chucVuNguoiDaiDien;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public String getTenDiaDiemKinhDoanh() {
		return _tenDiaDiemKinhDoanh;
	}

	public void setTenDiaDiemKinhDoanh(String tenDiaDiemKinhDoanh) {
		_tenDiaDiemKinhDoanh = tenDiaDiemKinhDoanh;
	}

	public Date getNgayDangKyKinhDoanh() {
		return _ngayDangKyKinhDoanh;
	}

	public void setNgayDangKyKinhDoanh(Date ngayDangKyKinhDoanh) {
		_ngayDangKyKinhDoanh = ngayDangKyKinhDoanh;
	}

	public Long getLoaiHinhDoanhNghiepId() {
		return _loaiHinhDoanhNghiepId;
	}

	public void setLoaiHinhDoanhNghiepId(Long loaiHinhDoanhNghiepId) {
		_loaiHinhDoanhNghiepId = loaiHinhDoanhNghiepId;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _maSoThue;
	private String _tenTiengNuocNgoai;
	private String _tenVietTat;
	private String _diaChiDoanhNghiep;
	private String _dienThoaiDoanhNghiep;
	private String _fax;
	private String _emailDoanhNghiep;
	private String _website;
	private long _tongSoVon;
	private String _moTaNganhNgheKinhDoanh;
	private String _soGCNDKKD;
	private Date _ngayCapGCNDKKD;
	private long _noiLuuTruId;
	private Date _ngayDieuLeDuocThongQua;
	private String _tenChiNhanh;
	private String _diaChiChiNhanh;
	private String _tenVanPhongDaiDien;
	private String _diaChiVanPhongDaiDien;
	private Date _ngayBatDauTamNgung;
	private Date _ngayKetThucTamNgung;
	private String _lyDoTamNgung;
	private Date _ngayChamDutHoatDongKD;
	private long _loai;
	private Long _diaChiDoanhNghiepHuyenId;
	private Long _diaChiDoanhNghiepTinhId;
	private Long _diaChiDoanhNghiepXaId;
	private Long _loaiDoiTuongId;
	private Long _nguoiDaiDienId;
	private Long _trangThaiDoanhNghiepId;
	private long _vonDieuLe;
	private long _vonToiThieuMotXaVien;
	private String _ghiChu;
	private Long _quocGiaId;
	private Long _coQuanCapId;
	private long _tenCoQuanCap;
	private String _soLanDieuChinh;
	private Date _ngayDieuChinh;
	private String _chucVuNguoiDaiDien;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private Long _chaId;
	private String _nguoiTao;
	private String _nguoiSua;
	private Long _taiKhoanNguoiDungId;
	private String _tenDiaDiemKinhDoanh;
	private Date _ngayDangKyKinhDoanh;
	private Long _loaiHinhDoanhNghiepId;
}