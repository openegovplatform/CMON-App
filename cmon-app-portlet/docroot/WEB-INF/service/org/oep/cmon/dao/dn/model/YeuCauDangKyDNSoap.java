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
public class YeuCauDangKyDNSoap implements Serializable {
	public static YeuCauDangKyDNSoap toSoapModel(YeuCauDangKyDN model) {
		YeuCauDangKyDNSoap soapModel = new YeuCauDangKyDNSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setMaSoThue(model.getMaSoThue());
		soapModel.setMaGiayPhep(model.getMaGiayPhep());
		soapModel.setNgayCap(model.getNgayCap());
		soapModel.setEmail(model.getEmail());
		soapModel.setHoNguoiDaiDien(model.getHoNguoiDaiDien());
		soapModel.setTenDemNguoiDaiDien(model.getTenDemNguoiDaiDien());
		soapModel.setTenNguoiDaiDien(model.getTenNguoiDaiDien());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setNgayCapCmnd(model.getNgayCapCmnd());
		soapModel.setNoiCapCmndId(model.getNoiCapCmndId());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setLoaiDoiTuongId(model.getLoaiDoiTuongId());
		soapModel.setTruSoTinhId(model.getTruSoTinhId());
		soapModel.setTruSoHuyenId(model.getTruSoHuyenId());
		soapModel.setTruSoXaId(model.getTruSoXaId());
		soapModel.setTruSo(model.getTruSo());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setLoaiHinhDoanhNghiepId(model.getLoaiHinhDoanhNghiepId());

		return soapModel;
	}

	public static YeuCauDangKyDNSoap[] toSoapModels(YeuCauDangKyDN[] models) {
		YeuCauDangKyDNSoap[] soapModels = new YeuCauDangKyDNSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyDNSoap[][] toSoapModels(YeuCauDangKyDN[][] models) {
		YeuCauDangKyDNSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YeuCauDangKyDNSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YeuCauDangKyDNSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyDNSoap[] toSoapModels(List<YeuCauDangKyDN> models) {
		List<YeuCauDangKyDNSoap> soapModels = new ArrayList<YeuCauDangKyDNSoap>(models.size());

		for (YeuCauDangKyDN model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YeuCauDangKyDNSoap[soapModels.size()]);
	}

	public YeuCauDangKyDNSoap() {
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

	public String getMaGiayPhep() {
		return _maGiayPhep;
	}

	public void setMaGiayPhep(String maGiayPhep) {
		_maGiayPhep = maGiayPhep;
	}

	public Date getNgayCap() {
		return _ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		_ngayCap = ngayCap;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getHoNguoiDaiDien() {
		return _hoNguoiDaiDien;
	}

	public void setHoNguoiDaiDien(String hoNguoiDaiDien) {
		_hoNguoiDaiDien = hoNguoiDaiDien;
	}

	public String getTenDemNguoiDaiDien() {
		return _tenDemNguoiDaiDien;
	}

	public void setTenDemNguoiDaiDien(String tenDemNguoiDaiDien) {
		_tenDemNguoiDaiDien = tenDemNguoiDaiDien;
	}

	public String getTenNguoiDaiDien() {
		return _tenNguoiDaiDien;
	}

	public void setTenNguoiDaiDien(String tenNguoiDaiDien) {
		_tenNguoiDaiDien = tenNguoiDaiDien;
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

	public Long getNoiCapCmndId() {
		return _noiCapCmndId;
	}

	public void setNoiCapCmndId(Long noiCapCmndId) {
		_noiCapCmndId = noiCapCmndId;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getTruSoTinhId() {
		return _truSoTinhId;
	}

	public void setTruSoTinhId(Long truSoTinhId) {
		_truSoTinhId = truSoTinhId;
	}

	public Long getTruSoHuyenId() {
		return _truSoHuyenId;
	}

	public void setTruSoHuyenId(Long truSoHuyenId) {
		_truSoHuyenId = truSoHuyenId;
	}

	public Long getTruSoXaId() {
		return _truSoXaId;
	}

	public void setTruSoXaId(Long truSoXaId) {
		_truSoXaId = truSoXaId;
	}

	public String getTruSo() {
		return _truSo;
	}

	public void setTruSo(String truSo) {
		_truSo = truSo;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getLoaiHinhDoanhNghiepId() {
		return _loaiHinhDoanhNghiepId;
	}

	public void setLoaiHinhDoanhNghiepId(Long loaiHinhDoanhNghiepId) {
		_loaiHinhDoanhNghiepId = loaiHinhDoanhNghiepId;
	}

	private long _id;
	private String _ten;
	private String _maSoThue;
	private String _maGiayPhep;
	private Date _ngayCap;
	private String _email;
	private String _hoNguoiDaiDien;
	private String _tenDemNguoiDaiDien;
	private String _tenNguoiDaiDien;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private Long _noiCapCmndId;
	private String _moTa;
	private Long _loaiDoiTuongId;
	private Long _truSoTinhId;
	private Long _truSoHuyenId;
	private Long _truSoXaId;
	private String _truSo;
	private int _daXoa;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _trangThai;
	private Long _loaiHinhDoanhNghiepId;
}