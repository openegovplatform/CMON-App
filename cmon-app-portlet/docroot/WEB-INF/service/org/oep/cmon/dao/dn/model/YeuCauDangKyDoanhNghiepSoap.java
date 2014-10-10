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
public class YeuCauDangKyDoanhNghiepSoap implements Serializable {
	public static YeuCauDangKyDoanhNghiepSoap toSoapModel(
		YeuCauDangKyDoanhNghiep model) {
		YeuCauDangKyDoanhNghiepSoap soapModel = new YeuCauDangKyDoanhNghiepSoap();

		soapModel.setId(model.getId());
		soapModel.setLoaiDoiTuongId(model.getLoaiDoiTuongId());
		soapModel.setTen(model.getTen());
		soapModel.setMaSoThue(model.getMaSoThue());
		soapModel.setMaGiayPhep(model.getMaGiayPhep());
		soapModel.setNgayCap(model.getNgayCap());
		soapModel.setEmail(model.getEmail());
		soapModel.setHoNguoiDaiDien(model.getHoNguoiDaiDien());
		soapModel.setTenDemNguoiDaiDien(model.getTenDemNguoiDaiDien());
		soapModel.setTenNguoiDaiDien(model.getTenNguoiDaiDien());
		soapModel.setSoCMND(model.getSoCMND());
		soapModel.setNgayCapCMND(model.getNgayCapCMND());
		soapModel.setNoiCapCMND(model.getNoiCapCMND());
		soapModel.setMoTaNganhNgheKinhDoanh(model.getMoTaNganhNgheKinhDoanh());
		soapModel.setLoaiHinhDoanhNghiep(model.getLoaiHinhDoanhNghiep());
		soapModel.setTruSo(model.getTruSo());
		soapModel.setTruSoXaId(model.getTruSoXaId());
		soapModel.setTruSoHuyenId(model.getTruSoHuyenId());
		soapModel.setTruSoTinhId(model.getTruSoTinhId());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static YeuCauDangKyDoanhNghiepSoap[] toSoapModels(
		YeuCauDangKyDoanhNghiep[] models) {
		YeuCauDangKyDoanhNghiepSoap[] soapModels = new YeuCauDangKyDoanhNghiepSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyDoanhNghiepSoap[][] toSoapModels(
		YeuCauDangKyDoanhNghiep[][] models) {
		YeuCauDangKyDoanhNghiepSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YeuCauDangKyDoanhNghiepSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YeuCauDangKyDoanhNghiepSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YeuCauDangKyDoanhNghiepSoap[] toSoapModels(
		List<YeuCauDangKyDoanhNghiep> models) {
		List<YeuCauDangKyDoanhNghiepSoap> soapModels = new ArrayList<YeuCauDangKyDoanhNghiepSoap>(models.size());

		for (YeuCauDangKyDoanhNghiep model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YeuCauDangKyDoanhNghiepSoap[soapModels.size()]);
	}

	public YeuCauDangKyDoanhNghiepSoap() {
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

	public long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
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

	public String getNoiCapCMND() {
		return _noiCapCMND;
	}

	public void setNoiCapCMND(String noiCapCMND) {
		_noiCapCMND = noiCapCMND;
	}

	public String getMoTaNganhNgheKinhDoanh() {
		return _moTaNganhNgheKinhDoanh;
	}

	public void setMoTaNganhNgheKinhDoanh(String moTaNganhNgheKinhDoanh) {
		_moTaNganhNgheKinhDoanh = moTaNganhNgheKinhDoanh;
	}

	public String getLoaiHinhDoanhNghiep() {
		return _loaiHinhDoanhNghiep;
	}

	public void setLoaiHinhDoanhNghiep(String loaiHinhDoanhNghiep) {
		_loaiHinhDoanhNghiep = loaiHinhDoanhNghiep;
	}

	public String getTruSo() {
		return _truSo;
	}

	public void setTruSo(String truSo) {
		_truSo = truSo;
	}

	public long getTruSoXaId() {
		return _truSoXaId;
	}

	public void setTruSoXaId(long truSoXaId) {
		_truSoXaId = truSoXaId;
	}

	public long getTruSoHuyenId() {
		return _truSoHuyenId;
	}

	public void setTruSoHuyenId(long truSoHuyenId) {
		_truSoHuyenId = truSoHuyenId;
	}

	public long getTruSoTinhId() {
		return _truSoTinhId;
	}

	public void setTruSoTinhId(long truSoTinhId) {
		_truSoTinhId = truSoTinhId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	private long _id;
	private long _loaiDoiTuongId;
	private String _ten;
	private String _maSoThue;
	private String _maGiayPhep;
	private Date _ngayCap;
	private String _email;
	private String _hoNguoiDaiDien;
	private String _tenDemNguoiDaiDien;
	private String _tenNguoiDaiDien;
	private String _soCMND;
	private Date _ngayCapCMND;
	private String _noiCapCMND;
	private String _moTaNganhNgheKinhDoanh;
	private String _loaiHinhDoanhNghiep;
	private String _truSo;
	private long _truSoXaId;
	private long _truSoHuyenId;
	private long _truSoTinhId;
	private int _trangThai;
}