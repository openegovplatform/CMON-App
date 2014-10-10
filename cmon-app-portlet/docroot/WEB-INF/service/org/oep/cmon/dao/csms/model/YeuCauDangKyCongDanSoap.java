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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    NAM
 * @generated
 */
public class YeuCauDangKyCongDanSoap implements Serializable {
	public static YeuCauDangKyCongDanSoap toSoapModel(YeuCauDangKyCongDan model) {
		YeuCauDangKyCongDanSoap soapModel = new YeuCauDangKyCongDanSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayYeuCau(model.getNgayYeuCau());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setNgayCapCmnd(model.getNgayCapCmnd());
		soapModel.setIDNoiCapCmnd(model.getIDNoiCapCmnd());
		soapModel.setGhiChuCmnd(model.getGhiChuCmnd());
		soapModel.setEmail(model.getEmail());
		soapModel.setHoCongDan(model.getHoCongDan());
		soapModel.setHoVaTen(model.getHoVaTen());
		soapModel.setTenDem(model.getTenDem());
		soapModel.setTenCongDan(model.getTenCongDan());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setGioiTinh(model.getGioiTinh());
		soapModel.setIDDanToc(model.getIDDanToc());
		soapModel.setIDQuocTich(model.getIDQuocTich());
		soapModel.setIDTonGiao(model.getIDTonGiao());
		soapModel.setDienThoaiCoDinh(model.getDienThoaiCoDinh());
		soapModel.setDienThoaiDiDong(model.getDienThoaiDiDong());
		soapModel.setIDTrinhDoHocVan(model.getIDTrinhDoHocVan());
		soapModel.setSoHoChieu(model.getSoHoChieu());
		soapModel.setNgayCapHoChieu(model.getNgayCapHoChieu());
		soapModel.setIDNoiCapHoChieu(model.getIDNoiCapHoChieu());
		soapModel.setNgayHetHanHoChieu(model.getNgayHetHanHoChieu());
		soapModel.setGhiChuHoChieu(model.getGhiChuHoChieu());
		soapModel.setSoBaoHiemYte(model.getSoBaoHiemYte());
		soapModel.setMaSoThueCaNhan(model.getMaSoThueCaNhan());
		soapModel.setIDNgheNghiep(model.getIDNgheNghiep());
		soapModel.setIDTrinhDoChuyenMon(model.getIDTrinhDoChuyenMon());
		soapModel.setTinhTrangHonNhan(model.getTinhTrangHonNhan());
		soapModel.setHoVaTenCha(model.getHoVaTenCha());
		soapModel.setHoVaTenMe(model.getHoVaTenMe());
		soapModel.setHoVaTenVoChong(model.getHoVaTenVoChong());
		soapModel.setSoHoKhau(model.getSoHoKhau());
		soapModel.setChuHo(model.getChuHo());
		soapModel.setIDQuanHe(model.getIDQuanHe());
		soapModel.setIDTinhThanhNoiSinh(model.getIDTinhThanhNoiSinh());
		soapModel.setIDQuanHuyenNoiSinh(model.getIDQuanHuyenNoiSinh());
		soapModel.setIDPhuongXaNoiSinh(model.getIDPhuongXaNoiSinh());
		soapModel.setMoTaDiaChiNoiSinh(model.getMoTaDiaChiNoiSinh());
		soapModel.setIDTinhThanhThuongTru(model.getIDTinhThanhThuongTru());
		soapModel.setIDQuanHuyenThuongTru(model.getIDQuanHuyenThuongTru());
		soapModel.setIDPhuongXaThuongTru(model.getIDPhuongXaThuongTru());
		soapModel.setMoTaDiaChiThuongTru(model.getMoTaDiaChiThuongTru());
		soapModel.setIDTinhThanhHienTai(model.getIDTinhThanhHienTai());
		soapModel.setIDQuanHuyenHienTai(model.getIDQuanHuyenHienTai());
		soapModel.setIDPhuongXaHienTai(model.getIDPhuongXaHienTai());
		soapModel.setMoTaDiaChiHienTai(model.getMoTaDiaChiHienTai());
		soapModel.setMaXacNhan(model.getMaXacNhan());
		soapModel.setNgayChungThuc(model.getNgayChungThuc());
		soapModel.setNguoiChungThuc(model.getNguoiChungThuc());
		soapModel.setMaCongDanCha(model.getMaCongDanCha());
		soapModel.setMaCongDanMe(model.getMaCongDanMe());
		soapModel.setMaCongDanVoChong(model.getMaCongDanVoChong());
		soapModel.setMaCongDan(model.getMaCongDan());
		soapModel.setLoaiYeuCau(model.getLoaiYeuCau());
		soapModel.setTrangThaiYeuCau(model.getTrangThaiYeuCau());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());

		return soapModel;
	}

	public static YeuCauDangKyCongDanSoap[] toSoapModels(
		YeuCauDangKyCongDan[] models) {
		YeuCauDangKyCongDanSoap[] soapModels = new YeuCauDangKyCongDanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyCongDanSoap[][] toSoapModels(
		YeuCauDangKyCongDan[][] models) {
		YeuCauDangKyCongDanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YeuCauDangKyCongDanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YeuCauDangKyCongDanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyCongDanSoap[] toSoapModels(
		List<YeuCauDangKyCongDan> models) {
		List<YeuCauDangKyCongDanSoap> soapModels = new ArrayList<YeuCauDangKyCongDanSoap>(models.size());

		for (YeuCauDangKyCongDan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YeuCauDangKyCongDanSoap[soapModels.size()]);
	}

	public YeuCauDangKyCongDanSoap() {
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

	public Date getNgayYeuCau() {
		return _NgayYeuCau;
	}

	public void setNgayYeuCau(Date NgayYeuCau) {
		_NgayYeuCau = NgayYeuCau;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public Date getNgayCapCmnd() {
		return _NgayCapCmnd;
	}

	public void setNgayCapCmnd(Date NgayCapCmnd) {
		_NgayCapCmnd = NgayCapCmnd;
	}

	public Long getIDNoiCapCmnd() {
		return _IDNoiCapCmnd;
	}

	public void setIDNoiCapCmnd(Long IDNoiCapCmnd) {
		_IDNoiCapCmnd = IDNoiCapCmnd;
	}

	public String getGhiChuCmnd() {
		return _GhiChuCmnd;
	}

	public void setGhiChuCmnd(String GhiChuCmnd) {
		_GhiChuCmnd = GhiChuCmnd;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getHoCongDan() {
		return _HoCongDan;
	}

	public void setHoCongDan(String HoCongDan) {
		_HoCongDan = HoCongDan;
	}

	public String getHoVaTen() {
		return _HoVaTen;
	}

	public void setHoVaTen(String HoVaTen) {
		_HoVaTen = HoVaTen;
	}

	public String getTenDem() {
		return _TenDem;
	}

	public void setTenDem(String TenDem) {
		_TenDem = TenDem;
	}

	public String getTenCongDan() {
		return _TenCongDan;
	}

	public void setTenCongDan(String TenCongDan) {
		_TenCongDan = TenCongDan;
	}

	public Date getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public Long getIDDanToc() {
		return _IDDanToc;
	}

	public void setIDDanToc(Long IDDanToc) {
		_IDDanToc = IDDanToc;
	}

	public Long getIDQuocTich() {
		return _IDQuocTich;
	}

	public void setIDQuocTich(Long IDQuocTich) {
		_IDQuocTich = IDQuocTich;
	}

	public Long getIDTonGiao() {
		return _IDTonGiao;
	}

	public void setIDTonGiao(Long IDTonGiao) {
		_IDTonGiao = IDTonGiao;
	}

	public String getDienThoaiCoDinh() {
		return _DienThoaiCoDinh;
	}

	public void setDienThoaiCoDinh(String DienThoaiCoDinh) {
		_DienThoaiCoDinh = DienThoaiCoDinh;
	}

	public String getDienThoaiDiDong() {
		return _DienThoaiDiDong;
	}

	public void setDienThoaiDiDong(String DienThoaiDiDong) {
		_DienThoaiDiDong = DienThoaiDiDong;
	}

	public Long getIDTrinhDoHocVan() {
		return _IDTrinhDoHocVan;
	}

	public void setIDTrinhDoHocVan(Long IDTrinhDoHocVan) {
		_IDTrinhDoHocVan = IDTrinhDoHocVan;
	}

	public String getSoHoChieu() {
		return _SoHoChieu;
	}

	public void setSoHoChieu(String SoHoChieu) {
		_SoHoChieu = SoHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return _NgayCapHoChieu;
	}

	public void setNgayCapHoChieu(Date NgayCapHoChieu) {
		_NgayCapHoChieu = NgayCapHoChieu;
	}

	public Long getIDNoiCapHoChieu() {
		return _IDNoiCapHoChieu;
	}

	public void setIDNoiCapHoChieu(Long IDNoiCapHoChieu) {
		_IDNoiCapHoChieu = IDNoiCapHoChieu;
	}

	public Date getNgayHetHanHoChieu() {
		return _NgayHetHanHoChieu;
	}

	public void setNgayHetHanHoChieu(Date NgayHetHanHoChieu) {
		_NgayHetHanHoChieu = NgayHetHanHoChieu;
	}

	public String getGhiChuHoChieu() {
		return _GhiChuHoChieu;
	}

	public void setGhiChuHoChieu(String GhiChuHoChieu) {
		_GhiChuHoChieu = GhiChuHoChieu;
	}

	public String getSoBaoHiemYte() {
		return _SoBaoHiemYte;
	}

	public void setSoBaoHiemYte(String SoBaoHiemYte) {
		_SoBaoHiemYte = SoBaoHiemYte;
	}

	public String getMaSoThueCaNhan() {
		return _MaSoThueCaNhan;
	}

	public void setMaSoThueCaNhan(String MaSoThueCaNhan) {
		_MaSoThueCaNhan = MaSoThueCaNhan;
	}

	public Long getIDNgheNghiep() {
		return _IDNgheNghiep;
	}

	public void setIDNgheNghiep(Long IDNgheNghiep) {
		_IDNgheNghiep = IDNgheNghiep;
	}

	public Long getIDTrinhDoChuyenMon() {
		return _IDTrinhDoChuyenMon;
	}

	public void setIDTrinhDoChuyenMon(Long IDTrinhDoChuyenMon) {
		_IDTrinhDoChuyenMon = IDTrinhDoChuyenMon;
	}

	public Long getTinhTrangHonNhan() {
		return _TinhTrangHonNhan;
	}

	public void setTinhTrangHonNhan(Long TinhTrangHonNhan) {
		_TinhTrangHonNhan = TinhTrangHonNhan;
	}

	public String getHoVaTenCha() {
		return _HoVaTenCha;
	}

	public void setHoVaTenCha(String HoVaTenCha) {
		_HoVaTenCha = HoVaTenCha;
	}

	public String getHoVaTenMe() {
		return _HoVaTenMe;
	}

	public void setHoVaTenMe(String HoVaTenMe) {
		_HoVaTenMe = HoVaTenMe;
	}

	public String getHoVaTenVoChong() {
		return _HoVaTenVoChong;
	}

	public void setHoVaTenVoChong(String HoVaTenVoChong) {
		_HoVaTenVoChong = HoVaTenVoChong;
	}

	public String getSoHoKhau() {
		return _SoHoKhau;
	}

	public void setSoHoKhau(String SoHoKhau) {
		_SoHoKhau = SoHoKhau;
	}

	public int getChuHo() {
		return _ChuHo;
	}

	public void setChuHo(int ChuHo) {
		_ChuHo = ChuHo;
	}

	public Long getIDQuanHe() {
		return _IDQuanHe;
	}

	public void setIDQuanHe(Long IDQuanHe) {
		_IDQuanHe = IDQuanHe;
	}

	public Long getIDTinhThanhNoiSinh() {
		return _IDTinhThanhNoiSinh;
	}

	public void setIDTinhThanhNoiSinh(Long IDTinhThanhNoiSinh) {
		_IDTinhThanhNoiSinh = IDTinhThanhNoiSinh;
	}

	public Long getIDQuanHuyenNoiSinh() {
		return _IDQuanHuyenNoiSinh;
	}

	public void setIDQuanHuyenNoiSinh(Long IDQuanHuyenNoiSinh) {
		_IDQuanHuyenNoiSinh = IDQuanHuyenNoiSinh;
	}

	public Long getIDPhuongXaNoiSinh() {
		return _IDPhuongXaNoiSinh;
	}

	public void setIDPhuongXaNoiSinh(Long IDPhuongXaNoiSinh) {
		_IDPhuongXaNoiSinh = IDPhuongXaNoiSinh;
	}

	public String getMoTaDiaChiNoiSinh() {
		return _MoTaDiaChiNoiSinh;
	}

	public void setMoTaDiaChiNoiSinh(String MoTaDiaChiNoiSinh) {
		_MoTaDiaChiNoiSinh = MoTaDiaChiNoiSinh;
	}

	public Long getIDTinhThanhThuongTru() {
		return _IDTinhThanhThuongTru;
	}

	public void setIDTinhThanhThuongTru(Long IDTinhThanhThuongTru) {
		_IDTinhThanhThuongTru = IDTinhThanhThuongTru;
	}

	public Long getIDQuanHuyenThuongTru() {
		return _IDQuanHuyenThuongTru;
	}

	public void setIDQuanHuyenThuongTru(Long IDQuanHuyenThuongTru) {
		_IDQuanHuyenThuongTru = IDQuanHuyenThuongTru;
	}

	public Long getIDPhuongXaThuongTru() {
		return _IDPhuongXaThuongTru;
	}

	public void setIDPhuongXaThuongTru(Long IDPhuongXaThuongTru) {
		_IDPhuongXaThuongTru = IDPhuongXaThuongTru;
	}

	public String getMoTaDiaChiThuongTru() {
		return _MoTaDiaChiThuongTru;
	}

	public void setMoTaDiaChiThuongTru(String MoTaDiaChiThuongTru) {
		_MoTaDiaChiThuongTru = MoTaDiaChiThuongTru;
	}

	public Long getIDTinhThanhHienTai() {
		return _IDTinhThanhHienTai;
	}

	public void setIDTinhThanhHienTai(Long IDTinhThanhHienTai) {
		_IDTinhThanhHienTai = IDTinhThanhHienTai;
	}

	public Long getIDQuanHuyenHienTai() {
		return _IDQuanHuyenHienTai;
	}

	public void setIDQuanHuyenHienTai(Long IDQuanHuyenHienTai) {
		_IDQuanHuyenHienTai = IDQuanHuyenHienTai;
	}

	public Long getIDPhuongXaHienTai() {
		return _IDPhuongXaHienTai;
	}

	public void setIDPhuongXaHienTai(Long IDPhuongXaHienTai) {
		_IDPhuongXaHienTai = IDPhuongXaHienTai;
	}

	public String getMoTaDiaChiHienTai() {
		return _MoTaDiaChiHienTai;
	}

	public void setMoTaDiaChiHienTai(String MoTaDiaChiHienTai) {
		_MoTaDiaChiHienTai = MoTaDiaChiHienTai;
	}

	public String getMaXacNhan() {
		return _MaXacNhan;
	}

	public void setMaXacNhan(String MaXacNhan) {
		_MaXacNhan = MaXacNhan;
	}

	public Date getNgayChungThuc() {
		return _NgayChungThuc;
	}

	public void setNgayChungThuc(Date NgayChungThuc) {
		_NgayChungThuc = NgayChungThuc;
	}

	public String getNguoiChungThuc() {
		return _NguoiChungThuc;
	}

	public void setNguoiChungThuc(String NguoiChungThuc) {
		_NguoiChungThuc = NguoiChungThuc;
	}

	public String getMaCongDanCha() {
		return _MaCongDanCha;
	}

	public void setMaCongDanCha(String MaCongDanCha) {
		_MaCongDanCha = MaCongDanCha;
	}

	public String getMaCongDanMe() {
		return _MaCongDanMe;
	}

	public void setMaCongDanMe(String MaCongDanMe) {
		_MaCongDanMe = MaCongDanMe;
	}

	public String getMaCongDanVoChong() {
		return _MaCongDanVoChong;
	}

	public void setMaCongDanVoChong(String MaCongDanVoChong) {
		_MaCongDanVoChong = MaCongDanVoChong;
	}

	public String getMaCongDan() {
		return _MaCongDan;
	}

	public void setMaCongDan(String MaCongDan) {
		_MaCongDan = MaCongDan;
	}

	public int getLoaiYeuCau() {
		return _LoaiYeuCau;
	}

	public void setLoaiYeuCau(int LoaiYeuCau) {
		_LoaiYeuCau = LoaiYeuCau;
	}

	public int getTrangThaiYeuCau() {
		return _TrangThaiYeuCau;
	}

	public void setTrangThaiYeuCau(int TrangThaiYeuCau) {
		_TrangThaiYeuCau = TrangThaiYeuCau;
	}

	public Date getNgayTao() {
		return _NgayTao;
	}

	public void setNgayTao(Date NgayTao) {
		_NgayTao = NgayTao;
	}

	public Date getNgaySua() {
		return _NgaySua;
	}

	public void setNgaySua(Date NgaySua) {
		_NgaySua = NgaySua;
	}

	public String getNguoiTao() {
		return _NguoiTao;
	}

	public void setNguoiTao(String NguoiTao) {
		_NguoiTao = NguoiTao;
	}

	public String getNguoiSua() {
		return _NguoiSua;
	}

	public void setNguoiSua(String NguoiSua) {
		_NguoiSua = NguoiSua;
	}

	public int getXoa() {
		return _Xoa;
	}

	public void setXoa(int Xoa) {
		_Xoa = Xoa;
	}

	private long _id;
	private Date _NgayYeuCau;
	private String _SoCmnd;
	private Date _NgayCapCmnd;
	private Long _IDNoiCapCmnd;
	private String _GhiChuCmnd;
	private String _Email;
	private String _HoCongDan;
	private String _HoVaTen;
	private String _TenDem;
	private String _TenCongDan;
	private Date _NgaySinh;
	private int _GioiTinh;
	private Long _IDDanToc;
	private Long _IDQuocTich;
	private Long _IDTonGiao;
	private String _DienThoaiCoDinh;
	private String _DienThoaiDiDong;
	private Long _IDTrinhDoHocVan;
	private String _SoHoChieu;
	private Date _NgayCapHoChieu;
	private Long _IDNoiCapHoChieu;
	private Date _NgayHetHanHoChieu;
	private String _GhiChuHoChieu;
	private String _SoBaoHiemYte;
	private String _MaSoThueCaNhan;
	private Long _IDNgheNghiep;
	private Long _IDTrinhDoChuyenMon;
	private Long _TinhTrangHonNhan;
	private String _HoVaTenCha;
	private String _HoVaTenMe;
	private String _HoVaTenVoChong;
	private String _SoHoKhau;
	private int _ChuHo;
	private Long _IDQuanHe;
	private Long _IDTinhThanhNoiSinh;
	private Long _IDQuanHuyenNoiSinh;
	private Long _IDPhuongXaNoiSinh;
	private String _MoTaDiaChiNoiSinh;
	private Long _IDTinhThanhThuongTru;
	private Long _IDQuanHuyenThuongTru;
	private Long _IDPhuongXaThuongTru;
	private String _MoTaDiaChiThuongTru;
	private Long _IDTinhThanhHienTai;
	private Long _IDQuanHuyenHienTai;
	private Long _IDPhuongXaHienTai;
	private String _MoTaDiaChiHienTai;
	private String _MaXacNhan;
	private Date _NgayChungThuc;
	private String _NguoiChungThuc;
	private String _MaCongDanCha;
	private String _MaCongDanMe;
	private String _MaCongDanVoChong;
	private String _MaCongDan;
	private int _LoaiYeuCau;
	private int _TrangThaiYeuCau;
	private Date _NgayTao;
	private Date _NgaySua;
	private String _NguoiTao;
	private String _NguoiSua;
	private int _Xoa;
}