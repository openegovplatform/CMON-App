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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    AnhNT
 * @generated
 */
public class CapGiayPhepLaiXeSoap implements Serializable {
	public static CapGiayPhepLaiXeSoap toSoapModel(CapGiayPhepLaiXe model) {
		CapGiayPhepLaiXeSoap soapModel = new CapGiayPhepLaiXeSoap();

		soapModel.setId(model.getId());
		soapModel.setIdCoQuanQuanLy(model.getIdCoQuanQuanLy());
		soapModel.setIdCongDan(model.getIdCongDan());
		soapModel.setIdLoaiHoSo(model.getIdLoaiHoSo());
		soapModel.setSoHoSo(model.getSoHoSo());
		soapModel.setHoVaTen(model.getHoVaTen());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setIdGioiTinh(model.getIdGioiTinh());
		soapModel.setIdQuocTich(model.getIdQuocTich());
		soapModel.setSoCMND(model.getSoCMND());
		soapModel.setNgayCapCMND(model.getNgayCapCMND());
		soapModel.setIdNoiCapCMND(model.getIdNoiCapCMND());
		soapModel.setSoHoChieu(model.getSoHoChieu());
		soapModel.setNgayCapHoChieu(model.getNgayCapHoChieu());
		soapModel.setNoiCapHoChieu(model.getNoiCapHoChieu());
		soapModel.setDienThoai(model.getDienThoai());
		soapModel.setEmail(model.getEmail());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setIdTinhThuongTru(model.getIdTinhThuongTru());
		soapModel.setIdHuyenThuongTru(model.getIdHuyenThuongTru());
		soapModel.setIdXaThuongTru(model.getIdXaThuongTru());
		soapModel.setDiaChiThuongTru(model.getDiaChiThuongTru());
		soapModel.setIdTinhCuTru(model.getIdTinhCuTru());
		soapModel.setIdHuyenCuTru(model.getIdHuyenCuTru());
		soapModel.setIdXaCuTru(model.getIdXaCuTru());
		soapModel.setDiaChiCuTru(model.getDiaChiCuTru());
		soapModel.setSoGiayPhepLaiXe(model.getSoGiayPhepLaiXe());
		soapModel.setIdHangGiayPhepLaiXe(model.getIdHangGiayPhepLaiXe());
		soapModel.setIdDonViCapGPLX(model.getIdDonViCapGPLX());
		soapModel.setNgayCapGPLX(model.getNgayCapGPLX());
		soapModel.setIdNoiCapGPLX(model.getIdNoiCapGPLX());
		soapModel.setNgayDauSatHach(model.getNgayDauSatHach());
		soapModel.setIdNoiHocLaiXe(model.getIdNoiHocLaiXe());
		soapModel.setNamHocLaiXe(model.getNamHocLaiXe());
		soapModel.setNamTrungTuyenHangCaoNhat(model.getNamTrungTuyenHangCaoNhat());
		soapModel.setLyDoHoc(model.getLyDoHoc());
		soapModel.setMucDichHoc(model.getMucDichHoc());
		soapModel.setSoNamLaiXe(model.getSoNamLaiXe());
		soapModel.setSoKmLaiXe(model.getSoKmLaiXe());
		soapModel.setNgayTraGPLX(model.getNgayTraGPLX());
		soapModel.setIdLyDoCapDoiLaiGPLX(model.getIdLyDoCapDoiLaiGPLX());
		soapModel.setLyDo(model.getLyDo());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());

		return soapModel;
	}

	public static CapGiayPhepLaiXeSoap[] toSoapModels(CapGiayPhepLaiXe[] models) {
		CapGiayPhepLaiXeSoap[] soapModels = new CapGiayPhepLaiXeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CapGiayPhepLaiXeSoap[][] toSoapModels(
		CapGiayPhepLaiXe[][] models) {
		CapGiayPhepLaiXeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CapGiayPhepLaiXeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CapGiayPhepLaiXeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CapGiayPhepLaiXeSoap[] toSoapModels(
		List<CapGiayPhepLaiXe> models) {
		List<CapGiayPhepLaiXeSoap> soapModels = new ArrayList<CapGiayPhepLaiXeSoap>(models.size());

		for (CapGiayPhepLaiXe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CapGiayPhepLaiXeSoap[soapModels.size()]);
	}

	public CapGiayPhepLaiXeSoap() {
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

	public long getIdCoQuanQuanLy() {
		return _idCoQuanQuanLy;
	}

	public void setIdCoQuanQuanLy(long idCoQuanQuanLy) {
		_idCoQuanQuanLy = idCoQuanQuanLy;
	}

	public long getIdCongDan() {
		return _idCongDan;
	}

	public void setIdCongDan(long idCongDan) {
		_idCongDan = idCongDan;
	}

	public long getIdLoaiHoSo() {
		return _idLoaiHoSo;
	}

	public void setIdLoaiHoSo(long idLoaiHoSo) {
		_idLoaiHoSo = idLoaiHoSo;
	}

	public long getSoHoSo() {
		return _soHoSo;
	}

	public void setSoHoSo(long soHoSo) {
		_soHoSo = soHoSo;
	}

	public String getHoVaTen() {
		return _hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		_hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public long getIdGioiTinh() {
		return _idGioiTinh;
	}

	public void setIdGioiTinh(long idGioiTinh) {
		_idGioiTinh = idGioiTinh;
	}

	public long getIdQuocTich() {
		return _idQuocTich;
	}

	public void setIdQuocTich(long idQuocTich) {
		_idQuocTich = idQuocTich;
	}

	public String getSoCMND() {
		return _soCMND;
	}

	public void setSoCMND(String soCMND) {
		_soCMND = soCMND;
	}

	public Date getNgayCapCMND() {
		return _ngayCapCMND;
	}

	public void setNgayCapCMND(Date ngayCapCMND) {
		_ngayCapCMND = ngayCapCMND;
	}

	public long getIdNoiCapCMND() {
		return _idNoiCapCMND;
	}

	public void setIdNoiCapCMND(long idNoiCapCMND) {
		_idNoiCapCMND = idNoiCapCMND;
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

	public long getNoiCapHoChieu() {
		return _noiCapHoChieu;
	}

	public void setNoiCapHoChieu(long noiCapHoChieu) {
		_noiCapHoChieu = noiCapHoChieu;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public long getIdTinhThuongTru() {
		return _idTinhThuongTru;
	}

	public void setIdTinhThuongTru(long idTinhThuongTru) {
		_idTinhThuongTru = idTinhThuongTru;
	}

	public long getIdHuyenThuongTru() {
		return _idHuyenThuongTru;
	}

	public void setIdHuyenThuongTru(long idHuyenThuongTru) {
		_idHuyenThuongTru = idHuyenThuongTru;
	}

	public long getIdXaThuongTru() {
		return _idXaThuongTru;
	}

	public void setIdXaThuongTru(long idXaThuongTru) {
		_idXaThuongTru = idXaThuongTru;
	}

	public String getDiaChiThuongTru() {
		return _diaChiThuongTru;
	}

	public void setDiaChiThuongTru(String diaChiThuongTru) {
		_diaChiThuongTru = diaChiThuongTru;
	}

	public long getIdTinhCuTru() {
		return _idTinhCuTru;
	}

	public void setIdTinhCuTru(long idTinhCuTru) {
		_idTinhCuTru = idTinhCuTru;
	}

	public long getIdHuyenCuTru() {
		return _idHuyenCuTru;
	}

	public void setIdHuyenCuTru(long idHuyenCuTru) {
		_idHuyenCuTru = idHuyenCuTru;
	}

	public long getIdXaCuTru() {
		return _idXaCuTru;
	}

	public void setIdXaCuTru(long idXaCuTru) {
		_idXaCuTru = idXaCuTru;
	}

	public String getDiaChiCuTru() {
		return _diaChiCuTru;
	}

	public void setDiaChiCuTru(String diaChiCuTru) {
		_diaChiCuTru = diaChiCuTru;
	}

	public String getSoGiayPhepLaiXe() {
		return _soGiayPhepLaiXe;
	}

	public void setSoGiayPhepLaiXe(String soGiayPhepLaiXe) {
		_soGiayPhepLaiXe = soGiayPhepLaiXe;
	}

	public long getIdHangGiayPhepLaiXe() {
		return _idHangGiayPhepLaiXe;
	}

	public void setIdHangGiayPhepLaiXe(long idHangGiayPhepLaiXe) {
		_idHangGiayPhepLaiXe = idHangGiayPhepLaiXe;
	}

	public long getIdDonViCapGPLX() {
		return _idDonViCapGPLX;
	}

	public void setIdDonViCapGPLX(long idDonViCapGPLX) {
		_idDonViCapGPLX = idDonViCapGPLX;
	}

	public Date getNgayCapGPLX() {
		return _ngayCapGPLX;
	}

	public void setNgayCapGPLX(Date ngayCapGPLX) {
		_ngayCapGPLX = ngayCapGPLX;
	}

	public long getIdNoiCapGPLX() {
		return _idNoiCapGPLX;
	}

	public void setIdNoiCapGPLX(long idNoiCapGPLX) {
		_idNoiCapGPLX = idNoiCapGPLX;
	}

	public Date getNgayDauSatHach() {
		return _ngayDauSatHach;
	}

	public void setNgayDauSatHach(Date ngayDauSatHach) {
		_ngayDauSatHach = ngayDauSatHach;
	}

	public long getIdNoiHocLaiXe() {
		return _idNoiHocLaiXe;
	}

	public void setIdNoiHocLaiXe(long idNoiHocLaiXe) {
		_idNoiHocLaiXe = idNoiHocLaiXe;
	}

	public int getNamHocLaiXe() {
		return _namHocLaiXe;
	}

	public void setNamHocLaiXe(int namHocLaiXe) {
		_namHocLaiXe = namHocLaiXe;
	}

	public int getNamTrungTuyenHangCaoNhat() {
		return _namTrungTuyenHangCaoNhat;
	}

	public void setNamTrungTuyenHangCaoNhat(int namTrungTuyenHangCaoNhat) {
		_namTrungTuyenHangCaoNhat = namTrungTuyenHangCaoNhat;
	}

	public String getLyDoHoc() {
		return _lyDoHoc;
	}

	public void setLyDoHoc(String lyDoHoc) {
		_lyDoHoc = lyDoHoc;
	}

	public String getMucDichHoc() {
		return _mucDichHoc;
	}

	public void setMucDichHoc(String mucDichHoc) {
		_mucDichHoc = mucDichHoc;
	}

	public double getSoNamLaiXe() {
		return _soNamLaiXe;
	}

	public void setSoNamLaiXe(double soNamLaiXe) {
		_soNamLaiXe = soNamLaiXe;
	}

	public double getSoKmLaiXe() {
		return _soKmLaiXe;
	}

	public void setSoKmLaiXe(double soKmLaiXe) {
		_soKmLaiXe = soKmLaiXe;
	}

	public Date getNgayTraGPLX() {
		return _ngayTraGPLX;
	}

	public void setNgayTraGPLX(Date ngayTraGPLX) {
		_ngayTraGPLX = ngayTraGPLX;
	}

	public long getIdLyDoCapDoiLaiGPLX() {
		return _idLyDoCapDoiLaiGPLX;
	}

	public void setIdLyDoCapDoiLaiGPLX(long idLyDoCapDoiLaiGPLX) {
		_idLyDoCapDoiLaiGPLX = idLyDoCapDoiLaiGPLX;
	}

	public String getLyDo() {
		return _lyDo;
	}

	public void setLyDo(String lyDo) {
		_lyDo = lyDo;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	private long _id;
	private long _idCoQuanQuanLy;
	private long _idCongDan;
	private long _idLoaiHoSo;
	private long _soHoSo;
	private String _hoVaTen;
	private Date _ngaySinh;
	private long _idGioiTinh;
	private long _idQuocTich;
	private String _soCMND;
	private Date _ngayCapCMND;
	private long _idNoiCapCMND;
	private String _soHoChieu;
	private Date _ngayCapHoChieu;
	private long _noiCapHoChieu;
	private String _dienThoai;
	private String _email;
	private String _ghiChu;
	private long _idTinhThuongTru;
	private long _idHuyenThuongTru;
	private long _idXaThuongTru;
	private String _diaChiThuongTru;
	private long _idTinhCuTru;
	private long _idHuyenCuTru;
	private long _idXaCuTru;
	private String _diaChiCuTru;
	private String _soGiayPhepLaiXe;
	private long _idHangGiayPhepLaiXe;
	private long _idDonViCapGPLX;
	private Date _ngayCapGPLX;
	private long _idNoiCapGPLX;
	private Date _ngayDauSatHach;
	private long _idNoiHocLaiXe;
	private int _namHocLaiXe;
	private int _namTrungTuyenHangCaoNhat;
	private String _lyDoHoc;
	private String _mucDichHoc;
	private double _soNamLaiXe;
	private double _soKmLaiXe;
	private Date _ngayTraGPLX;
	private long _idLyDoCapDoiLaiGPLX;
	private String _lyDo;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}