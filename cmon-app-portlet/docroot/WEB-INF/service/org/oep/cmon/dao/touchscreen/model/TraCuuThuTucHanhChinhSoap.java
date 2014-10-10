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

package org.oep.cmon.dao.touchscreen.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class TraCuuThuTucHanhChinhSoap implements Serializable {
	public static TraCuuThuTucHanhChinhSoap toSoapModel(
		TraCuuThuTucHanhChinh model) {
		TraCuuThuTucHanhChinhSoap soapModel = new TraCuuThuTucHanhChinhSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setSoNgayXuLy(model.getSoNgayXuLy());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNhomThuTucHanhChinhId(model.getNhomThuTucHanhChinhId());
		soapModel.setNhomThuTucHanhChinhTen(model.getNhomThuTucHanhChinhTen());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setCanTichHop(model.getCanTichHop());
		soapModel.setTrinhTuThucHien(model.getTrinhTuThucHien());
		soapModel.setCachThucHien(model.getCachThucHien());
		soapModel.setThanhPhanHoSo(model.getThanhPhanHoSo());
		soapModel.setLePhi(model.getLePhi());
		soapModel.setDonViLePhi(model.getDonViLePhi());
		soapModel.setPhi(model.getPhi());
		soapModel.setDonViPhi(model.getDonViPhi());
		soapModel.setTenMauDonToKhai(model.getTenMauDonToKhai());
		soapModel.setYeuCauDieuKienThucHien(model.getYeuCauDieuKienThucHien());
		soapModel.setCanCuPhapLy(model.getCanCuPhapLy());
		soapModel.setCapCoQuanQuanLyId(model.getCapCoQuanQuanLyId());
		soapModel.setLinhVucThucHien(model.getLinhVucThucHien());
		soapModel.setMaDNG(model.getMaDNG());
		soapModel.setUengineProcessName(model.getUengineProcessName());
		soapModel.setThuTucLienThongId(model.getThuTucLienThongId());

		return soapModel;
	}

	public static TraCuuThuTucHanhChinhSoap[] toSoapModels(
		TraCuuThuTucHanhChinh[] models) {
		TraCuuThuTucHanhChinhSoap[] soapModels = new TraCuuThuTucHanhChinhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TraCuuThuTucHanhChinhSoap[][] toSoapModels(
		TraCuuThuTucHanhChinh[][] models) {
		TraCuuThuTucHanhChinhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TraCuuThuTucHanhChinhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TraCuuThuTucHanhChinhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TraCuuThuTucHanhChinhSoap[] toSoapModels(
		List<TraCuuThuTucHanhChinh> models) {
		List<TraCuuThuTucHanhChinhSoap> soapModels = new ArrayList<TraCuuThuTucHanhChinhSoap>(models.size());

		for (TraCuuThuTucHanhChinh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TraCuuThuTucHanhChinhSoap[soapModels.size()]);
	}

	public TraCuuThuTucHanhChinhSoap() {
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

	public long getSoNgayXuLy() {
		return _soNgayXuLy;
	}

	public void setSoNgayXuLy(long soNgayXuLy) {
		_soNgayXuLy = soNgayXuLy;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
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

	public long getNhomThuTucHanhChinhId() {
		return _nhomThuTucHanhChinhId;
	}

	public void setNhomThuTucHanhChinhId(long nhomThuTucHanhChinhId) {
		_nhomThuTucHanhChinhId = nhomThuTucHanhChinhId;
	}

	public String getNhomThuTucHanhChinhTen() {
		return _nhomThuTucHanhChinhTen;
	}

	public void setNhomThuTucHanhChinhTen(String nhomThuTucHanhChinhTen) {
		_nhomThuTucHanhChinhTen = nhomThuTucHanhChinhTen;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public int getCanTichHop() {
		return _canTichHop;
	}

	public void setCanTichHop(int canTichHop) {
		_canTichHop = canTichHop;
	}

	public String getTrinhTuThucHien() {
		return _trinhTuThucHien;
	}

	public void setTrinhTuThucHien(String trinhTuThucHien) {
		_trinhTuThucHien = trinhTuThucHien;
	}

	public String getCachThucHien() {
		return _cachThucHien;
	}

	public void setCachThucHien(String cachThucHien) {
		_cachThucHien = cachThucHien;
	}

	public String getThanhPhanHoSo() {
		return _thanhPhanHoSo;
	}

	public void setThanhPhanHoSo(String thanhPhanHoSo) {
		_thanhPhanHoSo = thanhPhanHoSo;
	}

	public long getLePhi() {
		return _lePhi;
	}

	public void setLePhi(long lePhi) {
		_lePhi = lePhi;
	}

	public String getDonViLePhi() {
		return _donViLePhi;
	}

	public void setDonViLePhi(String donViLePhi) {
		_donViLePhi = donViLePhi;
	}

	public long getPhi() {
		return _phi;
	}

	public void setPhi(long phi) {
		_phi = phi;
	}

	public String getDonViPhi() {
		return _donViPhi;
	}

	public void setDonViPhi(String donViPhi) {
		_donViPhi = donViPhi;
	}

	public String getTenMauDonToKhai() {
		return _tenMauDonToKhai;
	}

	public void setTenMauDonToKhai(String tenMauDonToKhai) {
		_tenMauDonToKhai = tenMauDonToKhai;
	}

	public String getYeuCauDieuKienThucHien() {
		return _yeuCauDieuKienThucHien;
	}

	public void setYeuCauDieuKienThucHien(String yeuCauDieuKienThucHien) {
		_yeuCauDieuKienThucHien = yeuCauDieuKienThucHien;
	}

	public String getCanCuPhapLy() {
		return _canCuPhapLy;
	}

	public void setCanCuPhapLy(String canCuPhapLy) {
		_canCuPhapLy = canCuPhapLy;
	}

	public Long getCapCoQuanQuanLyId() {
		return _capCoQuanQuanLyId;
	}

	public void setCapCoQuanQuanLyId(Long capCoQuanQuanLyId) {
		_capCoQuanQuanLyId = capCoQuanQuanLyId;
	}

	public String getLinhVucThucHien() {
		return _linhVucThucHien;
	}

	public void setLinhVucThucHien(String linhVucThucHien) {
		_linhVucThucHien = linhVucThucHien;
	}

	public String getMaDNG() {
		return _maDNG;
	}

	public void setMaDNG(String maDNG) {
		_maDNG = maDNG;
	}

	public String getUengineProcessName() {
		return _uengineProcessName;
	}

	public void setUengineProcessName(String uengineProcessName) {
		_uengineProcessName = uengineProcessName;
	}

	public Long getThuTucLienThongId() {
		return _thuTucLienThongId;
	}

	public void setThuTucLienThongId(Long thuTucLienThongId) {
		_thuTucLienThongId = thuTucLienThongId;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _soNgayXuLy;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _nhomThuTucHanhChinhId;
	private String _nhomThuTucHanhChinhTen;
	private int _trangThai;
	private long _phienBan;
	private int _canTichHop;
	private String _trinhTuThucHien;
	private String _cachThucHien;
	private String _thanhPhanHoSo;
	private long _lePhi;
	private String _donViLePhi;
	private long _phi;
	private String _donViPhi;
	private String _tenMauDonToKhai;
	private String _yeuCauDieuKienThucHien;
	private String _canCuPhapLy;
	private Long _capCoQuanQuanLyId;
	private String _linhVucThucHien;
	private String _maDNG;
	private String _uengineProcessName;
	private Long _thuTucLienThongId;
}