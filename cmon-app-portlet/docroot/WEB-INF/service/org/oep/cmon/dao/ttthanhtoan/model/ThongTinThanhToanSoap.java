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

package org.oep.cmon.dao.ttthanhtoan.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Thanhdd
 * @generated
 */
public class ThongTinThanhToanSoap implements Serializable {
	public static ThongTinThanhToanSoap toSoapModel(ThongTinThanhToan model) {
		ThongTinThanhToanSoap soapModel = new ThongTinThanhToanSoap();

		soapModel.setId(model.getId());
		soapModel.setHoSoTTHCCongId(model.getHoSoTTHCCongId());
		soapModel.setTaiKhoanNguoiDungNopId(model.getTaiKhoanNguoiDungNopId());
		soapModel.setTaiKhoanNguoiDungNhanId(model.getTaiKhoanNguoiDungNhanId());
		soapModel.setLoaiThanhToan(model.getLoaiThanhToan());
		soapModel.setTenNguoiNopTien(model.getTenNguoiNopTien());
		soapModel.setTenCanBoNhanTien(model.getTenCanBoNhanTien());
		soapModel.setXacNhan(model.getXacNhan());
		soapModel.setLoaiPhi(model.getLoaiPhi());
		soapModel.setSoTien(model.getSoTien());
		soapModel.setNgayThuTien(model.getNgayThuTien());
		soapModel.setNgayXacNhan(model.getNgayXacNhan());
		soapModel.setNgayChuyenTien(model.getNgayChuyenTien());
		soapModel.setYKien(model.getYKien());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static ThongTinThanhToanSoap[] toSoapModels(
		ThongTinThanhToan[] models) {
		ThongTinThanhToanSoap[] soapModels = new ThongTinThanhToanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThongTinThanhToanSoap[][] toSoapModels(
		ThongTinThanhToan[][] models) {
		ThongTinThanhToanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThongTinThanhToanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThongTinThanhToanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThongTinThanhToanSoap[] toSoapModels(
		List<ThongTinThanhToan> models) {
		List<ThongTinThanhToanSoap> soapModels = new ArrayList<ThongTinThanhToanSoap>(models.size());

		for (ThongTinThanhToan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThongTinThanhToanSoap[soapModels.size()]);
	}

	public ThongTinThanhToanSoap() {
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

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getTaiKhoanNguoiDungNopId() {
		return _taiKhoanNguoiDungNopId;
	}

	public void setTaiKhoanNguoiDungNopId(Long taiKhoanNguoiDungNopId) {
		_taiKhoanNguoiDungNopId = taiKhoanNguoiDungNopId;
	}

	public Long getTaiKhoanNguoiDungNhanId() {
		return _taiKhoanNguoiDungNhanId;
	}

	public void setTaiKhoanNguoiDungNhanId(Long taiKhoanNguoiDungNhanId) {
		_taiKhoanNguoiDungNhanId = taiKhoanNguoiDungNhanId;
	}

	public long getLoaiThanhToan() {
		return _loaiThanhToan;
	}

	public void setLoaiThanhToan(long loaiThanhToan) {
		_loaiThanhToan = loaiThanhToan;
	}

	public String getTenNguoiNopTien() {
		return _tenNguoiNopTien;
	}

	public void setTenNguoiNopTien(String tenNguoiNopTien) {
		_tenNguoiNopTien = tenNguoiNopTien;
	}

	public String getTenCanBoNhanTien() {
		return _tenCanBoNhanTien;
	}

	public void setTenCanBoNhanTien(String tenCanBoNhanTien) {
		_tenCanBoNhanTien = tenCanBoNhanTien;
	}

	public long getXacNhan() {
		return _xacNhan;
	}

	public void setXacNhan(long xacNhan) {
		_xacNhan = xacNhan;
	}

	public long getLoaiPhi() {
		return _loaiPhi;
	}

	public void setLoaiPhi(long loaiPhi) {
		_loaiPhi = loaiPhi;
	}

	public long getSoTien() {
		return _soTien;
	}

	public void setSoTien(long soTien) {
		_soTien = soTien;
	}

	public Date getNgayThuTien() {
		return _ngayThuTien;
	}

	public void setNgayThuTien(Date ngayThuTien) {
		_ngayThuTien = ngayThuTien;
	}

	public Date getNgayXacNhan() {
		return _ngayXacNhan;
	}

	public void setNgayXacNhan(Date ngayXacNhan) {
		_ngayXacNhan = ngayXacNhan;
	}

	public Date getNgayChuyenTien() {
		return _ngayChuyenTien;
	}

	public void setNgayChuyenTien(Date ngayChuyenTien) {
		_ngayChuyenTien = ngayChuyenTien;
	}

	public String getYKien() {
		return _yKien;
	}

	public void setYKien(String yKien) {
		_yKien = yKien;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
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

	private long _id;
	private long _hoSoTTHCCongId;
	private Long _taiKhoanNguoiDungNopId;
	private Long _taiKhoanNguoiDungNhanId;
	private long _loaiThanhToan;
	private String _tenNguoiNopTien;
	private String _tenCanBoNhanTien;
	private long _xacNhan;
	private long _loaiPhi;
	private long _soTien;
	private Date _ngayThuTien;
	private Date _ngayXacNhan;
	private Date _ngayChuyenTien;
	private String _yKien;
	private long _noiLuuTruId;
	private String _nguoiTao;
	private String _nguoiSua;
	private Date _ngayTao;
	private Date _ngaySua;
}