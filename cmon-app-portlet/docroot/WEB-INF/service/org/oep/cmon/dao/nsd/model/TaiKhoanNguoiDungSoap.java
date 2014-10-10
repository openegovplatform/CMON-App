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

package org.oep.cmon.dao.nsd.model;

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
public class TaiKhoanNguoiDungSoap implements Serializable {
	public static TaiKhoanNguoiDungSoap toSoapModel(TaiKhoanNguoiDung model) {
		TaiKhoanNguoiDungSoap soapModel = new TaiKhoanNguoiDungSoap();

		soapModel.setId(model.getId());
		soapModel.setTenDangNhap(model.getTenDangNhap());
		soapModel.setMatKhau(model.getMatKhau());
		soapModel.setTenNguoiDung(model.getTenNguoiDung());
		soapModel.setCauHoiMatKhau(model.getCauHoiMatKhau());
		soapModel.setCauTraLoiMatKhau(model.getCauTraLoiMatKhau());
		soapModel.setEmail(model.getEmail());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setLoaiDoiTuongId(model.getLoaiDoiTuongId());
		soapModel.setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());

		return soapModel;
	}

	public static TaiKhoanNguoiDungSoap[] toSoapModels(
		TaiKhoanNguoiDung[] models) {
		TaiKhoanNguoiDungSoap[] soapModels = new TaiKhoanNguoiDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaiKhoanNguoiDungSoap[][] toSoapModels(
		TaiKhoanNguoiDung[][] models) {
		TaiKhoanNguoiDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaiKhoanNguoiDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaiKhoanNguoiDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaiKhoanNguoiDungSoap[] toSoapModels(
		List<TaiKhoanNguoiDung> models) {
		List<TaiKhoanNguoiDungSoap> soapModels = new ArrayList<TaiKhoanNguoiDungSoap>(models.size());

		for (TaiKhoanNguoiDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaiKhoanNguoiDungSoap[soapModels.size()]);
	}

	public TaiKhoanNguoiDungSoap() {
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

	public String getTenDangNhap() {
		return _tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		_tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return _matKhau;
	}

	public void setMatKhau(String matKhau) {
		_matKhau = matKhau;
	}

	public String getTenNguoiDung() {
		return _tenNguoiDung;
	}

	public void setTenNguoiDung(String tenNguoiDung) {
		_tenNguoiDung = tenNguoiDung;
	}

	public String getCauHoiMatKhau() {
		return _cauHoiMatKhau;
	}

	public void setCauHoiMatKhau(String cauHoiMatKhau) {
		_cauHoiMatKhau = cauHoiMatKhau;
	}

	public String getCauTraLoiMatKhau() {
		return _cauTraLoiMatKhau;
	}

	public void setCauTraLoiMatKhau(String cauTraLoiMatKhau) {
		_cauTraLoiMatKhau = cauTraLoiMatKhau;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(Long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	private long _id;
	private String _tenDangNhap;
	private String _matKhau;
	private String _tenNguoiDung;
	private String _cauHoiMatKhau;
	private String _cauTraLoiMatKhau;
	private String _email;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _trangThai;
	private Long _loaiDoiTuongId;
	private Long _taiKhoanNguoiDungId;
}