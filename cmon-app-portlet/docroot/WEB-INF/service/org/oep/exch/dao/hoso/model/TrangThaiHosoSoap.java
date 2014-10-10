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
public class TrangThaiHosoSoap implements Serializable {
	public static TrangThaiHosoSoap toSoapModel(TrangThaiHoso model) {
		TrangThaiHosoSoap soapModel = new TrangThaiHosoSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayChuyen(model.getNgayChuyen());
		soapModel.setOnlineId(model.getOnlineId());
		soapModel.setMaSoHoSo(model.getMaSoHoSo());
		soapModel.setNgayHenTra(model.getNgayHenTra());
		soapModel.setMaNguoiXuLyHienTai(model.getMaNguoiXuLyHienTai());
		soapModel.setTenNguoiXuLyHienTai(model.getTenNguoiXuLyHienTai());
		soapModel.setTenPhongBanXuLyHienTai(model.getTenPhongBanXuLyHienTai());
		soapModel.setNgayGioLuanChuyen(model.getNgayGioLuanChuyen());
		soapModel.setSoGioYeuCauXuLy(model.getSoGioYeuCauXuLy());
		soapModel.setNoiDungYeuCauXuLy(model.getNoiDungYeuCauXuLy());
		soapModel.setSoGioThucHien(model.getSoGioThucHien());
		soapModel.setTrangThaiHienTai(model.getTrangThaiHienTai());
		soapModel.setMaNguoiXuLyKeTiep(model.getMaNguoiXuLyKeTiep());
		soapModel.setTenNguoiXuLyKeTiep(model.getTenNguoiXuLyKeTiep());
		soapModel.setTenPhongBanXuLyKeTiep(model.getTenPhongBanXuLyKeTiep());
		soapModel.setTrangThaiKeTiep(model.getTrangThaiKeTiep());
		soapModel.setDonViCungCap(model.getDonViCungCap());
		soapModel.setTrangThaiXuLy(model.getTrangThaiXuLy());
		soapModel.setNgayXuLy(model.getNgayXuLy());
		soapModel.setLoiKhiXuLy(model.getLoiKhiXuLy());

		return soapModel;
	}

	public static TrangThaiHosoSoap[] toSoapModels(TrangThaiHoso[] models) {
		TrangThaiHosoSoap[] soapModels = new TrangThaiHosoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiHosoSoap[][] toSoapModels(TrangThaiHoso[][] models) {
		TrangThaiHosoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrangThaiHosoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrangThaiHosoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiHosoSoap[] toSoapModels(List<TrangThaiHoso> models) {
		List<TrangThaiHosoSoap> soapModels = new ArrayList<TrangThaiHosoSoap>(models.size());

		for (TrangThaiHoso model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrangThaiHosoSoap[soapModels.size()]);
	}

	public TrangThaiHosoSoap() {
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

	public Date getNgayChuyen() {
		return _NgayChuyen;
	}

	public void setNgayChuyen(Date NgayChuyen) {
		_NgayChuyen = NgayChuyen;
	}

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getMaSoHoSo() {
		return _MaSoHoSo;
	}

	public void setMaSoHoSo(String MaSoHoSo) {
		_MaSoHoSo = MaSoHoSo;
	}

	public String getNgayHenTra() {
		return _NgayHenTra;
	}

	public void setNgayHenTra(String NgayHenTra) {
		_NgayHenTra = NgayHenTra;
	}

	public String getMaNguoiXuLyHienTai() {
		return _MaNguoiXuLyHienTai;
	}

	public void setMaNguoiXuLyHienTai(String MaNguoiXuLyHienTai) {
		_MaNguoiXuLyHienTai = MaNguoiXuLyHienTai;
	}

	public String getTenNguoiXuLyHienTai() {
		return _TenNguoiXuLyHienTai;
	}

	public void setTenNguoiXuLyHienTai(String TenNguoiXuLyHienTai) {
		_TenNguoiXuLyHienTai = TenNguoiXuLyHienTai;
	}

	public String getTenPhongBanXuLyHienTai() {
		return _TenPhongBanXuLyHienTai;
	}

	public void setTenPhongBanXuLyHienTai(String TenPhongBanXuLyHienTai) {
		_TenPhongBanXuLyHienTai = TenPhongBanXuLyHienTai;
	}

	public String getNgayGioLuanChuyen() {
		return _NgayGioLuanChuyen;
	}

	public void setNgayGioLuanChuyen(String NgayGioLuanChuyen) {
		_NgayGioLuanChuyen = NgayGioLuanChuyen;
	}

	public int getSoGioYeuCauXuLy() {
		return _SoGioYeuCauXuLy;
	}

	public void setSoGioYeuCauXuLy(int SoGioYeuCauXuLy) {
		_SoGioYeuCauXuLy = SoGioYeuCauXuLy;
	}

	public String getNoiDungYeuCauXuLy() {
		return _NoiDungYeuCauXuLy;
	}

	public void setNoiDungYeuCauXuLy(String NoiDungYeuCauXuLy) {
		_NoiDungYeuCauXuLy = NoiDungYeuCauXuLy;
	}

	public int getSoGioThucHien() {
		return _SoGioThucHien;
	}

	public void setSoGioThucHien(int SoGioThucHien) {
		_SoGioThucHien = SoGioThucHien;
	}

	public int getTrangThaiHienTai() {
		return _TrangThaiHienTai;
	}

	public void setTrangThaiHienTai(int TrangThaiHienTai) {
		_TrangThaiHienTai = TrangThaiHienTai;
	}

	public String getMaNguoiXuLyKeTiep() {
		return _MaNguoiXuLyKeTiep;
	}

	public void setMaNguoiXuLyKeTiep(String MaNguoiXuLyKeTiep) {
		_MaNguoiXuLyKeTiep = MaNguoiXuLyKeTiep;
	}

	public String getTenNguoiXuLyKeTiep() {
		return _TenNguoiXuLyKeTiep;
	}

	public void setTenNguoiXuLyKeTiep(String TenNguoiXuLyKeTiep) {
		_TenNguoiXuLyKeTiep = TenNguoiXuLyKeTiep;
	}

	public String getTenPhongBanXuLyKeTiep() {
		return _TenPhongBanXuLyKeTiep;
	}

	public void setTenPhongBanXuLyKeTiep(String TenPhongBanXuLyKeTiep) {
		_TenPhongBanXuLyKeTiep = TenPhongBanXuLyKeTiep;
	}

	public int getTrangThaiKeTiep() {
		return _TrangThaiKeTiep;
	}

	public void setTrangThaiKeTiep(int TrangThaiKeTiep) {
		_TrangThaiKeTiep = TrangThaiKeTiep;
	}

	public String getDonViCungCap() {
		return _DonViCungCap;
	}

	public void setDonViCungCap(String DonViCungCap) {
		_DonViCungCap = DonViCungCap;
	}

	public int getTrangThaiXuLy() {
		return _TrangThaiXuLy;
	}

	public void setTrangThaiXuLy(int TrangThaiXuLy) {
		_TrangThaiXuLy = TrangThaiXuLy;
	}

	public Date getNgayXuLy() {
		return _NgayXuLy;
	}

	public void setNgayXuLy(Date NgayXuLy) {
		_NgayXuLy = NgayXuLy;
	}

	public String getLoiKhiXuLy() {
		return _LoiKhiXuLy;
	}

	public void setLoiKhiXuLy(String LoiKhiXuLy) {
		_LoiKhiXuLy = LoiKhiXuLy;
	}

	private long _id;
	private Date _NgayChuyen;
	private long _OnlineId;
	private String _MaSoHoSo;
	private String _NgayHenTra;
	private String _MaNguoiXuLyHienTai;
	private String _TenNguoiXuLyHienTai;
	private String _TenPhongBanXuLyHienTai;
	private String _NgayGioLuanChuyen;
	private int _SoGioYeuCauXuLy;
	private String _NoiDungYeuCauXuLy;
	private int _SoGioThucHien;
	private int _TrangThaiHienTai;
	private String _MaNguoiXuLyKeTiep;
	private String _TenNguoiXuLyKeTiep;
	private String _TenPhongBanXuLyKeTiep;
	private int _TrangThaiKeTiep;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}