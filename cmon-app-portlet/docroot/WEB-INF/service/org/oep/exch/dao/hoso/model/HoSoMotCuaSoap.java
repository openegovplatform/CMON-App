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
public class HoSoMotCuaSoap implements Serializable {
	public static HoSoMotCuaSoap toSoapModel(HoSoMotCua model) {
		HoSoMotCuaSoap soapModel = new HoSoMotCuaSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayChuyen(model.getNgayChuyen());
		soapModel.setMaSoHoSo(model.getMaSoHoSo());
		soapModel.setMaLoaiHoSo(model.getMaLoaiHoSo());
		soapModel.setMaDonViTiepNhan(model.getMaDonViTiepNhan());
		soapModel.setNgayNopHoSo(model.getNgayNopHoSo());
		soapModel.setNgayHenTra(model.getNgayHenTra());
		soapModel.setHoTenNguoiNop(model.getHoTenNguoiNop());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setMaTinhThuongTru(model.getMaTinhThuongTru());
		soapModel.setMoTaDiaChiThuongTru(model.getMoTaDiaChiThuongTru());
		soapModel.setGioiTinh(model.getGioiTinh());
		soapModel.setMaNguoiTiepNhan(model.getMaNguoiTiepNhan());
		soapModel.setTenNguoiTiepNhan(model.getTenNguoiTiepNhan());
		soapModel.setDonViCungCap(model.getDonViCungCap());
		soapModel.setTrangThaiXuLy(model.getTrangThaiXuLy());
		soapModel.setNgayXuLy(model.getNgayXuLy());
		soapModel.setLoiKhiXuLy(model.getLoiKhiXuLy());

		return soapModel;
	}

	public static HoSoMotCuaSoap[] toSoapModels(HoSoMotCua[] models) {
		HoSoMotCuaSoap[] soapModels = new HoSoMotCuaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoMotCuaSoap[][] toSoapModels(HoSoMotCua[][] models) {
		HoSoMotCuaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoMotCuaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoMotCuaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoMotCuaSoap[] toSoapModels(List<HoSoMotCua> models) {
		List<HoSoMotCuaSoap> soapModels = new ArrayList<HoSoMotCuaSoap>(models.size());

		for (HoSoMotCua model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoMotCuaSoap[soapModels.size()]);
	}

	public HoSoMotCuaSoap() {
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

	public String getMaSoHoSo() {
		return _MaSoHoSo;
	}

	public void setMaSoHoSo(String MaSoHoSo) {
		_MaSoHoSo = MaSoHoSo;
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

	public String getNgayNopHoSo() {
		return _NgayNopHoSo;
	}

	public void setNgayNopHoSo(String NgayNopHoSo) {
		_NgayNopHoSo = NgayNopHoSo;
	}

	public String getNgayHenTra() {
		return _NgayHenTra;
	}

	public void setNgayHenTra(String NgayHenTra) {
		_NgayHenTra = NgayHenTra;
	}

	public String getHoTenNguoiNop() {
		return _HoTenNguoiNop;
	}

	public void setHoTenNguoiNop(String HoTenNguoiNop) {
		_HoTenNguoiNop = HoTenNguoiNop;
	}

	public String getSoCmnd() {
		return _SoCmnd;
	}

	public void setSoCmnd(String SoCmnd) {
		_SoCmnd = SoCmnd;
	}

	public String getNgaySinh() {
		return _NgaySinh;
	}

	public void setNgaySinh(String NgaySinh) {
		_NgaySinh = NgaySinh;
	}

	public String getMaTinhThuongTru() {
		return _MaTinhThuongTru;
	}

	public void setMaTinhThuongTru(String MaTinhThuongTru) {
		_MaTinhThuongTru = MaTinhThuongTru;
	}

	public String getMoTaDiaChiThuongTru() {
		return _MoTaDiaChiThuongTru;
	}

	public void setMoTaDiaChiThuongTru(String MoTaDiaChiThuongTru) {
		_MoTaDiaChiThuongTru = MoTaDiaChiThuongTru;
	}

	public int getGioiTinh() {
		return _GioiTinh;
	}

	public void setGioiTinh(int GioiTinh) {
		_GioiTinh = GioiTinh;
	}

	public String getMaNguoiTiepNhan() {
		return _MaNguoiTiepNhan;
	}

	public void setMaNguoiTiepNhan(String MaNguoiTiepNhan) {
		_MaNguoiTiepNhan = MaNguoiTiepNhan;
	}

	public String getTenNguoiTiepNhan() {
		return _TenNguoiTiepNhan;
	}

	public void setTenNguoiTiepNhan(String TenNguoiTiepNhan) {
		_TenNguoiTiepNhan = TenNguoiTiepNhan;
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
	private String _MaSoHoSo;
	private String _MaLoaiHoSo;
	private String _MaDonViTiepNhan;
	private String _NgayNopHoSo;
	private String _NgayHenTra;
	private String _HoTenNguoiNop;
	private String _SoCmnd;
	private String _NgaySinh;
	private String _MaTinhThuongTru;
	private String _MoTaDiaChiThuongTru;
	private int _GioiTinh;
	private String _MaNguoiTiepNhan;
	private String _TenNguoiTiepNhan;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}