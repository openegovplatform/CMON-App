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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    LIEMNN
 * @generated
 */
public class CongDanSoap implements Serializable {
	public static CongDanSoap toSoapModel(CongDan model) {
		CongDanSoap soapModel = new CongDanSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setHo(model.getHo());
		soapModel.setDem(model.getDem());
		soapModel.setTen(model.getTen());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setNgayCapCmnd(model.getNgayCapCmnd());
		soapModel.setGhiChuCmnd(model.getGhiChuCmnd());
		soapModel.setSoHoChieu(model.getSoHoChieu());
		soapModel.setNgayCapHoChieu(model.getNgayCapHoChieu());
		soapModel.setNgayHetHanHoChieu(model.getNgayHetHanHoChieu());
		soapModel.setNoiCapHoChieuId(model.getNoiCapHoChieuId());
		soapModel.setGhiChuHoChieu(model.getGhiChuHoChieu());
		soapModel.setSoBaoHiemYTe(model.getSoBaoHiemYTe());
		soapModel.setMaSoThueCaNhan(model.getMaSoThueCaNhan());
		soapModel.setDiaChiThuongTru(model.getDiaChiThuongTru());
		soapModel.setDiaChiHienNay(model.getDiaChiHienNay());
		soapModel.setDienThoaiCoDinh(model.getDienThoaiCoDinh());
		soapModel.setDienThoaiDiDong(model.getDienThoaiDiDong());
		soapModel.setHoTenCha(model.getHoTenCha());
		soapModel.setHoTenMe(model.getHoTenMe());
		soapModel.setHoTenVoHoacChong(model.getHoTenVoHoacChong());
		soapModel.setSoHoKhau(model.getSoHoKhau());
		soapModel.setLaChuHo(model.getLaChuHo());
		soapModel.setTinhTrangHonNhanId(model.getTinhTrangHonNhanId());
		soapModel.setEmail(model.getEmail());
		soapModel.setTrinhDoChuyenMonId(model.getTrinhDoChuyenMonId());
		soapModel.setSoDinhDanhChaId(model.getSoDinhDanhChaId());
		soapModel.setSoDinhDanhVoHoacChongId(model.getSoDinhDanhVoHoacChongId());
		soapModel.setDanTocId(model.getDanTocId());
		soapModel.setDiaChiHienNayHuyenId(model.getDiaChiHienNayHuyenId());
		soapModel.setDiaChiHienNayTinhId(model.getDiaChiHienNayTinhId());
		soapModel.setDiaChiHienNayXaId(model.getDiaChiHienNayXaId());
		soapModel.setDiaChiThuongTruHuyenId(model.getDiaChiThuongTruHuyenId());
		soapModel.setDiaChiThuongTruTinhId(model.getDiaChiThuongTruTinhId());
		soapModel.setDiaChiThuongTruXaId(model.getDiaChiThuongTruXaId());
		soapModel.setGioiTinh(model.getGioiTinh());
		soapModel.setNgheNghiepId(model.getNgheNghiepId());
		soapModel.setNoiSinhHuyenId(model.getNoiSinhHuyenId());
		soapModel.setNoiSinhTinhId(model.getNoiSinhTinhId());
		soapModel.setNoiSinhXaId(model.getNoiSinhXaId());
		soapModel.setNoiSinhChiTiet(model.getNoiSinhChiTiet());
		soapModel.setNoiCapCmndId(model.getNoiCapCmndId());
		soapModel.setTonGiaoId(model.getTonGiaoId());
		soapModel.setSoDinhDanhMeId(model.getSoDinhDanhMeId());
		soapModel.setTrinhDoHocVanId(model.getTrinhDoHocVanId());
		soapModel.setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());
		soapModel.setQuanHeChuHoId(model.getQuanHeChuHoId());
		soapModel.setQuocTichId(model.getQuocTichId());
		soapModel.setDoanhNghiepId(model.getDoanhNghiepId());
		soapModel.setTenDayDu(model.getTenDayDu());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setFax(model.getFax());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setTinhtrang(model.getTinhtrang());

		return soapModel;
	}

	public static CongDanSoap[] toSoapModels(CongDan[] models) {
		CongDanSoap[] soapModels = new CongDanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CongDanSoap[][] toSoapModels(CongDan[][] models) {
		CongDanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CongDanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CongDanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CongDanSoap[] toSoapModels(List<CongDan> models) {
		List<CongDanSoap> soapModels = new ArrayList<CongDanSoap>(models.size());

		for (CongDan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CongDanSoap[soapModels.size()]);
	}

	public CongDanSoap() {
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

	public String getHo() {
		return _ho;
	}

	public void setHo(String ho) {
		_ho = ho;
	}

	public String getDem() {
		return _dem;
	}

	public void setDem(String dem) {
		_dem = dem;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public String getSoCmnd() {
		return _soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		_soCmnd = soCmnd;
	}

	public Date getNgayCapCmnd() {
		return _ngayCapCmnd;
	}

	public void setNgayCapCmnd(Date ngayCapCmnd) {
		_ngayCapCmnd = ngayCapCmnd;
	}

	public String getGhiChuCmnd() {
		return _ghiChuCmnd;
	}

	public void setGhiChuCmnd(String ghiChuCmnd) {
		_ghiChuCmnd = ghiChuCmnd;
	}

	public String getSoHoChieu() {
		return _soHoChieu;
	}

	public void setSoHoChieu(String soHoChieu) {
		_soHoChieu = soHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return _ngayCapHoChieu;
	}

	public void setNgayCapHoChieu(Date ngayCapHoChieu) {
		_ngayCapHoChieu = ngayCapHoChieu;
	}

	public Date getNgayHetHanHoChieu() {
		return _ngayHetHanHoChieu;
	}

	public void setNgayHetHanHoChieu(Date ngayHetHanHoChieu) {
		_ngayHetHanHoChieu = ngayHetHanHoChieu;
	}

	public Long getNoiCapHoChieuId() {
		return _noiCapHoChieuId;
	}

	public void setNoiCapHoChieuId(Long noiCapHoChieuId) {
		_noiCapHoChieuId = noiCapHoChieuId;
	}

	public String getGhiChuHoChieu() {
		return _ghiChuHoChieu;
	}

	public void setGhiChuHoChieu(String ghiChuHoChieu) {
		_ghiChuHoChieu = ghiChuHoChieu;
	}

	public String getSoBaoHiemYTe() {
		return _soBaoHiemYTe;
	}

	public void setSoBaoHiemYTe(String soBaoHiemYTe) {
		_soBaoHiemYTe = soBaoHiemYTe;
	}

	public String getMaSoThueCaNhan() {
		return _maSoThueCaNhan;
	}

	public void setMaSoThueCaNhan(String maSoThueCaNhan) {
		_maSoThueCaNhan = maSoThueCaNhan;
	}

	public String getDiaChiThuongTru() {
		return _diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		_diaChiThuongTru = diaChiThuongTru;
	}

	public String getDiaChiHienNay() {
		return _diaChiHienNay;
	}

	public void setDiaChiHienNay(String diaChiHienNay) {
		_diaChiHienNay = diaChiHienNay;
	}

	public String getDienThoaiCoDinh() {
		return _dienThoaiCoDinh;
	}

	public void setDienThoaiCoDinh(String dienThoaiCoDinh) {
		_dienThoaiCoDinh = dienThoaiCoDinh;
	}

	public String getDienThoaiDiDong() {
		return _dienThoaiDiDong;
	}

	public void setDienThoaiDiDong(String dienThoaiDiDong) {
		_dienThoaiDiDong = dienThoaiDiDong;
	}

	public String getHoTenCha() {
		return _hoTenCha;
	}

	public void setHoTenCha(String hoTenCha) {
		_hoTenCha = hoTenCha;
	}

	public String getHoTenMe() {
		return _hoTenMe;
	}

	public void setHoTenMe(String hoTenMe) {
		_hoTenMe = hoTenMe;
	}

	public String getHoTenVoHoacChong() {
		return _hoTenVoHoacChong;
	}

	public void setHoTenVoHoacChong(String hoTenVoHoacChong) {
		_hoTenVoHoacChong = hoTenVoHoacChong;
	}

	public String getSoHoKhau() {
		return _soHoKhau;
	}

	public void setSoHoKhau(String soHoKhau) {
		_soHoKhau = soHoKhau;
	}

	public int getLaChuHo() {
		return _laChuHo;
	}

	public void setLaChuHo(int laChuHo) {
		_laChuHo = laChuHo;
	}

	public Long getTinhTrangHonNhanId() {
		return _tinhTrangHonNhanId;
	}

	public void setTinhTrangHonNhanId(Long tinhTrangHonNhanId) {
		_tinhTrangHonNhanId = tinhTrangHonNhanId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Long getTrinhDoChuyenMonId() {
		return _trinhDoChuyenMonId;
	}

	public void setTrinhDoChuyenMonId(Long trinhDoChuyenMonId) {
		_trinhDoChuyenMonId = trinhDoChuyenMonId;
	}

	public Long getSoDinhDanhChaId() {
		return _soDinhDanhChaId;
	}

	public void setSoDinhDanhChaId(Long soDinhDanhChaId) {
		_soDinhDanhChaId = soDinhDanhChaId;
	}

	public Long getSoDinhDanhVoHoacChongId() {
		return _soDinhDanhVoHoacChongId;
	}

	public void setSoDinhDanhVoHoacChongId(Long soDinhDanhVoHoacChongId) {
		_soDinhDanhVoHoacChongId = soDinhDanhVoHoacChongId;
	}

	public Long getDanTocId() {
		return _danTocId;
	}

	public void setDanTocId(Long danTocId) {
		_danTocId = danTocId;
	}

	public Long getDiaChiHienNayHuyenId() {
		return _diaChiHienNayHuyenId;
	}

	public void setDiaChiHienNayHuyenId(Long diaChiHienNayHuyenId) {
		_diaChiHienNayHuyenId = diaChiHienNayHuyenId;
	}

	public Long getDiaChiHienNayTinhId() {
		return _diaChiHienNayTinhId;
	}

	public void setDiaChiHienNayTinhId(Long diaChiHienNayTinhId) {
		_diaChiHienNayTinhId = diaChiHienNayTinhId;
	}

	public Long getDiaChiHienNayXaId() {
		return _diaChiHienNayXaId;
	}

	public void setDiaChiHienNayXaId(Long diaChiHienNayXaId) {
		_diaChiHienNayXaId = diaChiHienNayXaId;
	}

	public Long getDiaChiThuongTruHuyenId() {
		return _diaChiThuongTruHuyenId;
	}

	public void setDiaChiThuongTruHuyenId(Long diaChiThuongTruHuyenId) {
		_diaChiThuongTruHuyenId = diaChiThuongTruHuyenId;
	}

	public Long getDiaChiThuongTruTinhId() {
		return _diaChiThuongTruTinhId;
	}

	public void setDiaChiThuongTruTinhId(Long diaChiThuongTruTinhId) {
		_diaChiThuongTruTinhId = diaChiThuongTruTinhId;
	}

	public Long getDiaChiThuongTruXaId() {
		return _diaChiThuongTruXaId;
	}

	public void setDiaChiThuongTruXaId(Long diaChiThuongTruXaId) {
		_diaChiThuongTruXaId = diaChiThuongTruXaId;
	}

	public int getGioiTinh() {
		return _gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		_gioiTinh = gioiTinh;
	}

	public Long getNgheNghiepId() {
		return _ngheNghiepId;
	}

	public void setNgheNghiepId(Long ngheNghiepId) {
		_ngheNghiepId = ngheNghiepId;
	}

	public Long getNoiSinhHuyenId() {
		return _noiSinhHuyenId;
	}

	public void setNoiSinhHuyenId(Long noiSinhHuyenId) {
		_noiSinhHuyenId = noiSinhHuyenId;
	}

	public Long getNoiSinhTinhId() {
		return _noiSinhTinhId;
	}

	public void setNoiSinhTinhId(Long noiSinhTinhId) {
		_noiSinhTinhId = noiSinhTinhId;
	}

	public Long getNoiSinhXaId() {
		return _noiSinhXaId;
	}

	public void setNoiSinhXaId(Long noiSinhXaId) {
		_noiSinhXaId = noiSinhXaId;
	}

	public String getNoiSinhChiTiet() {
		return _noiSinhChiTiet;
	}

	public void setNoiSinhChiTiet(String noiSinhChiTiet) {
		_noiSinhChiTiet = noiSinhChiTiet;
	}

	public Long getNoiCapCmndId() {
		return _noiCapCmndId;
	}

	public void setNoiCapCmndId(Long noiCapCmndId) {
		_noiCapCmndId = noiCapCmndId;
	}

	public Long getTonGiaoId() {
		return _tonGiaoId;
	}

	public void setTonGiaoId(Long tonGiaoId) {
		_tonGiaoId = tonGiaoId;
	}

	public Long getSoDinhDanhMeId() {
		return _soDinhDanhMeId;
	}

	public void setSoDinhDanhMeId(Long soDinhDanhMeId) {
		_soDinhDanhMeId = soDinhDanhMeId;
	}

	public Long getTrinhDoHocVanId() {
		return _trinhDoHocVanId;
	}

	public void setTrinhDoHocVanId(Long trinhDoHocVanId) {
		_trinhDoHocVanId = trinhDoHocVanId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public Long getQuanHeChuHoId() {
		return _quanHeChuHoId;
	}

	public void setQuanHeChuHoId(Long quanHeChuHoId) {
		_quanHeChuHoId = quanHeChuHoId;
	}

	public Long getQuocTichId() {
		return _quocTichId;
	}

	public void setQuocTichId(Long quocTichId) {
		_quocTichId = quocTichId;
	}

	public Long getDoanhNghiepId() {
		return _doanhNghiepId;
	}

	public void setDoanhNghiepId(Long doanhNghiepId) {
		_doanhNghiepId = doanhNghiepId;
	}

	public String getTenDayDu() {
		return _tenDayDu;
	}

	public void setTenDayDu(String tenDayDu) {
		_tenDayDu = tenDayDu;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public int getTinhtrang() {
		return _tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		_tinhtrang = tinhtrang;
	}

	private long _id;
	private String _ma;
	private String _ho;
	private String _dem;
	private String _ten;
	private Date _ngaySinh;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private String _ghiChuCmnd;
	private String _soHoChieu;
	private Date _ngayCapHoChieu;
	private Date _ngayHetHanHoChieu;
	private Long _noiCapHoChieuId;
	private String _ghiChuHoChieu;
	private String _soBaoHiemYTe;
	private String _maSoThueCaNhan;
	private String _diaChiThuongTru;
	private String _diaChiHienNay;
	private String _dienThoaiCoDinh;
	private String _dienThoaiDiDong;
	private String _hoTenCha;
	private String _hoTenMe;
	private String _hoTenVoHoacChong;
	private String _soHoKhau;
	private int _laChuHo;
	private Long _tinhTrangHonNhanId;
	private String _email;
	private Long _trinhDoChuyenMonId;
	private Long _soDinhDanhChaId;
	private Long _soDinhDanhVoHoacChongId;
	private Long _danTocId;
	private Long _diaChiHienNayHuyenId;
	private Long _diaChiHienNayTinhId;
	private Long _diaChiHienNayXaId;
	private Long _diaChiThuongTruHuyenId;
	private Long _diaChiThuongTruTinhId;
	private Long _diaChiThuongTruXaId;
	private int _gioiTinh;
	private Long _ngheNghiepId;
	private Long _noiSinhHuyenId;
	private Long _noiSinhTinhId;
	private Long _noiSinhXaId;
	private String _noiSinhChiTiet;
	private Long _noiCapCmndId;
	private Long _tonGiaoId;
	private Long _soDinhDanhMeId;
	private Long _trinhDoHocVanId;
	private Long _taiKhoanNguoiDungId;
	private Long _quanHeChuHoId;
	private Long _quocTichId;
	private Long _doanhNghiepId;
	private String _tenDayDu;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _daXoa;
	private String _fax;
	private String _website;
	private int _tinhtrang;
}