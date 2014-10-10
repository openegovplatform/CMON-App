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

package org.oep.cmon.dao.qlhc.model;

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
public class CoQuanHanhChinhSuNghiepSoap implements Serializable {
	public static CoQuanHanhChinhSuNghiepSoap toSoapModel(
		CoQuanHanhChinhSuNghiep model) {
		CoQuanHanhChinhSuNghiepSoap soapModel = new CoQuanHanhChinhSuNghiepSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setSoDTDuongDayNong(model.getSoDTDuongDayNong());
		soapModel.setNoiBo(model.getNoiBo());
		soapModel.setChucNang(model.getChucNang());
		soapModel.setTongSoCBNV(model.getTongSoCBNV());
		soapModel.setSoDT(model.getSoDT());
		soapModel.setFax(model.getFax());
		soapModel.setEmail(model.getEmail());
		soapModel.setTongSoGiuongBenh(model.getTongSoGiuongBenh());
		soapModel.setViDo(model.getViDo());
		soapModel.setKinhDo(model.getKinhDo());
		soapModel.setDiaChiCoQuanHCSNXaId(model.getDiaChiCoQuanHCSNXaId());
		soapModel.setTuyenId(model.getTuyenId());
		soapModel.setDiaChiCoQuanHCSNTinhId(model.getDiaChiCoQuanHCSNTinhId());
		soapModel.setNguoiDaiDienId(model.getNguoiDaiDienId());
		soapModel.setDiaChiCoQuanHCSNHuyenId(model.getDiaChiCoQuanHCSNHuyenId());
		soapModel.setHangId(model.getHangId());
		soapModel.setCoQuanQuanLyId(model.getCoQuanQuanLyId());
		soapModel.setLoaiId(model.getLoaiId());
		soapModel.setSoQdThanhLap(model.getSoQdThanhLap());
		soapModel.setMoTaDiaChi(model.getMoTaDiaChi());
		soapModel.setTenNguoiDaiDien(model.getTenNguoiDaiDien());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setChaId(model.getChaId());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());

		return soapModel;
	}

	public static CoQuanHanhChinhSuNghiepSoap[] toSoapModels(
		CoQuanHanhChinhSuNghiep[] models) {
		CoQuanHanhChinhSuNghiepSoap[] soapModels = new CoQuanHanhChinhSuNghiepSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoQuanHanhChinhSuNghiepSoap[][] toSoapModels(
		CoQuanHanhChinhSuNghiep[][] models) {
		CoQuanHanhChinhSuNghiepSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoQuanHanhChinhSuNghiepSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoQuanHanhChinhSuNghiepSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoQuanHanhChinhSuNghiepSoap[] toSoapModels(
		List<CoQuanHanhChinhSuNghiep> models) {
		List<CoQuanHanhChinhSuNghiepSoap> soapModels = new ArrayList<CoQuanHanhChinhSuNghiepSoap>(models.size());

		for (CoQuanHanhChinhSuNghiep model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoQuanHanhChinhSuNghiepSoap[soapModels.size()]);
	}

	public CoQuanHanhChinhSuNghiepSoap() {
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

	public String getSoDTDuongDayNong() {
		return _soDTDuongDayNong;
	}

	public void setSoDTDuongDayNong(String soDTDuongDayNong) {
		_soDTDuongDayNong = soDTDuongDayNong;
	}

	public long getNoiBo() {
		return _noiBo;
	}

	public void setNoiBo(long noiBo) {
		_noiBo = noiBo;
	}

	public String getChucNang() {
		return _chucNang;
	}

	public void setChucNang(String chucNang) {
		_chucNang = chucNang;
	}

	public long getTongSoCBNV() {
		return _tongSoCBNV;
	}

	public void setTongSoCBNV(long tongSoCBNV) {
		_tongSoCBNV = tongSoCBNV;
	}

	public String getSoDT() {
		return _soDT;
	}

	public void setSoDT(String soDT) {
		_soDT = soDT;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getTongSoGiuongBenh() {
		return _tongSoGiuongBenh;
	}

	public void setTongSoGiuongBenh(long tongSoGiuongBenh) {
		_tongSoGiuongBenh = tongSoGiuongBenh;
	}

	public String getViDo() {
		return _viDo;
	}

	public void setViDo(String viDo) {
		_viDo = viDo;
	}

	public String getKinhDo() {
		return _kinhDo;
	}

	public void setKinhDo(String kinhDo) {
		_kinhDo = kinhDo;
	}

	public long getDiaChiCoQuanHCSNXaId() {
		return _diaChiCoQuanHCSNXaId;
	}

	public void setDiaChiCoQuanHCSNXaId(long diaChiCoQuanHCSNXaId) {
		_diaChiCoQuanHCSNXaId = diaChiCoQuanHCSNXaId;
	}

	public long getTuyenId() {
		return _tuyenId;
	}

	public void setTuyenId(long tuyenId) {
		_tuyenId = tuyenId;
	}

	public long getDiaChiCoQuanHCSNTinhId() {
		return _diaChiCoQuanHCSNTinhId;
	}

	public void setDiaChiCoQuanHCSNTinhId(long diaChiCoQuanHCSNTinhId) {
		_diaChiCoQuanHCSNTinhId = diaChiCoQuanHCSNTinhId;
	}

	public long getNguoiDaiDienId() {
		return _nguoiDaiDienId;
	}

	public void setNguoiDaiDienId(long nguoiDaiDienId) {
		_nguoiDaiDienId = nguoiDaiDienId;
	}

	public long getDiaChiCoQuanHCSNHuyenId() {
		return _diaChiCoQuanHCSNHuyenId;
	}

	public void setDiaChiCoQuanHCSNHuyenId(long diaChiCoQuanHCSNHuyenId) {
		_diaChiCoQuanHCSNHuyenId = diaChiCoQuanHCSNHuyenId;
	}

	public long getHangId() {
		return _hangId;
	}

	public void setHangId(long hangId) {
		_hangId = hangId;
	}

	public String getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(String coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public String getLoaiId() {
		return _loaiId;
	}

	public void setLoaiId(String loaiId) {
		_loaiId = loaiId;
	}

	public String getSoQdThanhLap() {
		return _soQdThanhLap;
	}

	public void setSoQdThanhLap(String soQdThanhLap) {
		_soQdThanhLap = soQdThanhLap;
	}

	public String getMoTaDiaChi() {
		return _moTaDiaChi;
	}

	public void setMoTaDiaChi(String moTaDiaChi) {
		_moTaDiaChi = moTaDiaChi;
	}

	public String getTenNguoiDaiDien() {
		return _tenNguoiDaiDien;
	}

	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		_tenNguoiDaiDien = tenNguoiDaiDien;
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

	private long _id;
	private String _ma;
	private String _ten;
	private String _soDTDuongDayNong;
	private long _noiBo;
	private String _chucNang;
	private long _tongSoCBNV;
	private String _soDT;
	private String _fax;
	private String _email;
	private long _tongSoGiuongBenh;
	private String _viDo;
	private String _kinhDo;
	private long _diaChiCoQuanHCSNXaId;
	private long _tuyenId;
	private long _diaChiCoQuanHCSNTinhId;
	private long _nguoiDaiDienId;
	private long _diaChiCoQuanHCSNHuyenId;
	private long _hangId;
	private String _coQuanQuanLyId;
	private String _loaiId;
	private String _soQdThanhLap;
	private String _moTaDiaChi;
	private String _tenNguoiDaiDien;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private Long _chaId;
	private String _nguoiTao;
	private String _nguoiSua;
}