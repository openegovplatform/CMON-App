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

package org.oep.cmon.dao.kios.model;

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
public class DanhSachHoSoSoap implements Serializable {
	public static DanhSachHoSoSoap toSoapModel(DanhSachHoSo model) {
		DanhSachHoSoSoap soapModel = new DanhSachHoSoSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayNhanHoSo(model.getNgayNhanHoSo());
		soapModel.setTenCoQuanTiepNhan(model.getTenCoQuanTiepNhan());
		soapModel.setTenThuTucHanhChinh(model.getTenThuTucHanhChinh());
		soapModel.setNgayHenTraKetQua(model.getNgayHenTraKetQua());
		soapModel.setNgayTraKetQua(model.getNgayTraKetQua());
		soapModel.setHoTenNguoiNopHoSo(model.getHoTenNguoiNopHoSo());
		soapModel.setDiaChiThuongTruNguoiNop(model.getDiaChiThuongTruNguoiNop());
		soapModel.setSoDienThoaiDiDongNguoiNop(model.getSoDienThoaiDiDongNguoiNop());
		soapModel.setNgayKetThucXuLy(model.getNgayKetThucXuLy());
		soapModel.setLoaiHoSo(model.getLoaiHoSo());
		soapModel.setMaSoBienNhan(model.getMaSoBienNhan());
		soapModel.setChuSoHuu(model.getChuSoHuu());
		soapModel.setLePhi(model.getLePhi());
		soapModel.setPhiHoSo(model.getPhiHoSo());
		soapModel.setEmailNguoiNop(model.getEmailNguoiNop());
		soapModel.setSoDienThoaiCoDinhNguoiNop(model.getSoDienThoaiCoDinhNguoiNop());
		soapModel.setNhomThuTucHanhChinhTen(model.getNhomThuTucHanhChinhTen());
		soapModel.setTrangThaiHoSoTen(model.getTrangThaiHoSoTen());
		soapModel.setRNum(model.getRNum());

		return soapModel;
	}

	public static DanhSachHoSoSoap[] toSoapModels(DanhSachHoSo[] models) {
		DanhSachHoSoSoap[] soapModels = new DanhSachHoSoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhSachHoSoSoap[][] toSoapModels(DanhSachHoSo[][] models) {
		DanhSachHoSoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhSachHoSoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhSachHoSoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhSachHoSoSoap[] toSoapModels(List<DanhSachHoSo> models) {
		List<DanhSachHoSoSoap> soapModels = new ArrayList<DanhSachHoSoSoap>(models.size());

		for (DanhSachHoSo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhSachHoSoSoap[soapModels.size()]);
	}

	public DanhSachHoSoSoap() {
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

	public Date getNgayNhanHoSo() {
		return _ngayNhanHoSo;
	}

	public void setNgayNhanHoSo(Date ngayNhanHoSo) {
		_ngayNhanHoSo = ngayNhanHoSo;
	}

	public String getTenCoQuanTiepNhan() {
		return _tenCoQuanTiepNhan;
	}

	public void setTenCoQuanTiepNhan(String tenCoQuanTiepNhan) {
		_tenCoQuanTiepNhan = tenCoQuanTiepNhan;
	}

	public String getTenThuTucHanhChinh() {
		return _tenThuTucHanhChinh;
	}

	public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
		_tenThuTucHanhChinh = tenThuTucHanhChinh;
	}

	public Date getNgayHenTraKetQua() {
		return _ngayHenTraKetQua;
	}

	public void setNgayHenTraKetQua(Date ngayHenTraKetQua) {
		_ngayHenTraKetQua = ngayHenTraKetQua;
	}

	public Date getNgayTraKetQua() {
		return _ngayTraKetQua;
	}

	public void setNgayTraKetQua(Date ngayTraKetQua) {
		_ngayTraKetQua = ngayTraKetQua;
	}

	public String getHoTenNguoiNopHoSo() {
		return _hoTenNguoiNopHoSo;
	}

	public void setHoTenNguoiNopHoSo(String hoTenNguoiNopHoSo) {
		_hoTenNguoiNopHoSo = hoTenNguoiNopHoSo;
	}

	public String getDiaChiThuongTruNguoiNop() {
		return _diaChiThuongTruNguoiNop;
	}

	public void setDiaChiThuongTruNguoiNop(String diaChiThuongTruNguoiNop) {
		_diaChiThuongTruNguoiNop = diaChiThuongTruNguoiNop;
	}

	public String getSoDienThoaiDiDongNguoiNop() {
		return _soDienThoaiDiDongNguoiNop;
	}

	public void setSoDienThoaiDiDongNguoiNop(String soDienThoaiDiDongNguoiNop) {
		_soDienThoaiDiDongNguoiNop = soDienThoaiDiDongNguoiNop;
	}

	public Date getNgayKetThucXuLy() {
		return _ngayKetThucXuLy;
	}

	public void setNgayKetThucXuLy(Date ngayKetThucXuLy) {
		_ngayKetThucXuLy = ngayKetThucXuLy;
	}

	public int getLoaiHoSo() {
		return _loaiHoSo;
	}

	public void setLoaiHoSo(int loaiHoSo) {
		_loaiHoSo = loaiHoSo;
	}

	public String getMaSoBienNhan() {
		return _maSoBienNhan;
	}

	public void setMaSoBienNhan(String maSoBienNhan) {
		_maSoBienNhan = maSoBienNhan;
	}

	public String getChuSoHuu() {
		return _chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		_chuSoHuu = chuSoHuu;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public String getEmailNguoiNop() {
		return _emailNguoiNop;
	}

	public void setEmailNguoiNop(String emailNguoiNop) {
		_emailNguoiNop = emailNguoiNop;
	}

	public String getSoDienThoaiCoDinhNguoiNop() {
		return _soDienThoaiCoDinhNguoiNop;
	}

	public void setSoDienThoaiCoDinhNguoiNop(String soDienThoaiCoDinhNguoiNop) {
		_soDienThoaiCoDinhNguoiNop = soDienThoaiCoDinhNguoiNop;
	}

	public String getNhomThuTucHanhChinhTen() {
		return _nhomThuTucHanhChinhTen;
	}

	public void setNhomThuTucHanhChinhTen(String nhomThuTucHanhChinhTen) {
		_nhomThuTucHanhChinhTen = nhomThuTucHanhChinhTen;
	}

	public String getTrangThaiHoSoTen() {
		return _trangThaiHoSoTen;
	}

	public void setTrangThaiHoSoTen(String trangThaiHoSoTen) {
		_trangThaiHoSoTen = trangThaiHoSoTen;
	}

	public int getRNum() {
		return _rNum;
	}

	public void setRNum(int rNum) {
		_rNum = rNum;
	}

	private long _id;
	private Date _ngayNhanHoSo;
	private String _tenCoQuanTiepNhan;
	private String _tenThuTucHanhChinh;
	private Date _ngayHenTraKetQua;
	private Date _ngayTraKetQua;
	private String _hoTenNguoiNopHoSo;
	private String _diaChiThuongTruNguoiNop;
	private String _soDienThoaiDiDongNguoiNop;
	private Date _ngayKetThucXuLy;
	private int _loaiHoSo;
	private String _maSoBienNhan;
	private String _chuSoHuu;
	private int _lePhi;
	private int _phiHoSo;
	private String _emailNguoiNop;
	private String _soDienThoaiCoDinhNguoiNop;
	private String _nhomThuTucHanhChinhTen;
	private String _trangThaiHoSoTen;
	private int _rNum;
}