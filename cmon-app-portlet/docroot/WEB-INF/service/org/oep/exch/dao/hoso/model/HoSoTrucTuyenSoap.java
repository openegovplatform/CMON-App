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

package org.oep.exch.dao.hoso.model;

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
public class HoSoTrucTuyenSoap implements Serializable {
	public static HoSoTrucTuyenSoap toSoapModel(HoSoTrucTuyen model) {
		HoSoTrucTuyenSoap soapModel = new HoSoTrucTuyenSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayTrichXuat(model.getNgayTrichXuat());
		soapModel.setOnlineId(model.getOnlineId());
		soapModel.setMaLoaiHoSo(model.getMaLoaiHoSo());
		soapModel.setMaDonViTiepNhan(model.getMaDonViTiepNhan());
		soapModel.setHoTenNguoiNop(model.getHoTenNguoiNop());
		soapModel.setDiaChiNguoiNop(model.getDiaChiNguoiNop());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setEmail(model.getEmail());
		soapModel.setSoDtDiDong(model.getSoDtDiDong());
		soapModel.setSoDtCoDinh(model.getSoDtCoDinh());
		soapModel.setNgayDangKyHoSo(model.getNgayDangKyHoSo());
		soapModel.setNoiChuyenHoSo(model.getNoiChuyenHoSo());
		soapModel.setTrangThaiXuLy(model.getTrangThaiXuLy());
		soapModel.setNgayChuyen(model.getNgayChuyen());
		soapModel.setGioiTinh(model.getGioiTinh());
		soapModel.setChuSoHuuHoSo(model.getChuSoHuuHoSo());

		return soapModel;
	}

	public static HoSoTrucTuyenSoap[] toSoapModels(HoSoTrucTuyen[] models) {
		HoSoTrucTuyenSoap[] soapModels = new HoSoTrucTuyenSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoTrucTuyenSoap[][] toSoapModels(HoSoTrucTuyen[][] models) {
		HoSoTrucTuyenSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoTrucTuyenSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoTrucTuyenSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoTrucTuyenSoap[] toSoapModels(List<HoSoTrucTuyen> models) {
		List<HoSoTrucTuyenSoap> soapModels = new ArrayList<HoSoTrucTuyenSoap>(models.size());

		for (HoSoTrucTuyen model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoTrucTuyenSoap[soapModels.size()]);
	}

	public HoSoTrucTuyenSoap() {
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

	public Date getNgayTrichXuat() {
		return _NgayTrichXuat;
	}

	public void setNgayTrichXuat(Date NgayTrichXuat) {
		_NgayTrichXuat = NgayTrichXuat;
	}

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getMaLoaiHoSo() {
		return _MaLoaiHoSo;
	}

	public void setMaLoaiHoSo(String MaLoaiHoSo) {
		_MaLoaiHoSo = MaLoaiHoSo;
	}

	public String getMaDonViTiepNhan() {
		return _MaDonViTiepNhan;
	}

	public void setMaDonViTiepNhan(String MaDonViTiepNhan) {
		_MaDonViTiepNhan = MaDonViTiepNhan;
	}

	public String getHoTenNguoiNop() {
		return _HoTenNguoiNop;
	}

	public void setHoTenNguoiNop(String HoTenNguoiNop) {
		_HoTenNguoiNop = HoTenNguoiNop;
	}

	public String getDiaChiNguoiNop() {
		return _DiaChiNguoiNop;
	}

	public void setDiaChiNguoiNop(String DiaChiNguoiNop) {
		_DiaChiNguoiNop = DiaChiNguoiNop;
	}

	public Date getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(Date NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getSoDtDiDong() {
		return _SoDtDiDong;
	}

	public void setSoDtDiDong(String SoDtDiDong) {
		_SoDtDiDong = SoDtDiDong;
	}

	public String getSoDtCoDinh() {
		return _SoDtCoDinh;
	}

	public void setSoDtCoDinh(String SoDtCoDinh) {
		_SoDtCoDinh = SoDtCoDinh;
	}

	public Date getNgayDangKyHoSo() {
		return _NgayDangKyHoSo;
	}

	public void setNgayDangKyHoSo(Date NgayDangKyHoSo) {
		_NgayDangKyHoSo = NgayDangKyHoSo;
	}

	public String getNoiChuyenHoSo() {
		return _NoiChuyenHoSo;
	}

	public void setNoiChuyenHoSo(String NoiChuyenHoSo) {
		_NoiChuyenHoSo = NoiChuyenHoSo;
	}

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public String getChuSoHuuHoSo() {
		return _ChuSoHuuHoSo;
	}

	public void setChuSoHuuHoSo(String ChuSoHuuHoSo) {
		_ChuSoHuuHoSo = ChuSoHuuHoSo;
	}

	private long _id;
	private Date _NgayTrichXuat;
	private long _OnlineId;
	private String _MaLoaiHoSo;
	private String _MaDonViTiepNhan;
	private String _HoTenNguoiNop;
	private String _DiaChiNguoiNop;
	private Date _NgaySinh;
	private String _SoCmnd;
	private String _Email;
	private String _SoDtDiDong;
	private String _SoDtCoDinh;
	private Date _NgayDangKyHoSo;
	private String _NoiChuyenHoSo;
	private int _TrangThaiXuLy;
	private Date _NgayChuyen;
	private int _GioiTinh;
	private String _ChuSoHuuHoSo;
}