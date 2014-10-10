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
public class KetQuaHosoSoap implements Serializable {
	public static KetQuaHosoSoap toSoapModel(KetQuaHoso model) {
		KetQuaHosoSoap soapModel = new KetQuaHosoSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayChuyen(model.getNgayChuyen());
		soapModel.setMaSoHoSo(model.getMaSoHoSo());
		soapModel.setTenNguoiNhanKetQua(model.getTenNguoiNhanKetQua());
		soapModel.setNgayNhanKetQua(model.getNgayNhanKetQua());
		soapModel.setLePhiHoSo(model.getLePhiHoSo());
		soapModel.setPhiXuLyHoSo(model.getPhiXuLyHoSo());
		soapModel.setNgayHoanThanh(model.getNgayHoanThanh());
		soapModel.setMaCanBoTraKetQua(model.getMaCanBoTraKetQua());
		soapModel.setTenCanBoTraKetQua(model.getTenCanBoTraKetQua());
		soapModel.setDonViCungCap(model.getDonViCungCap());
		soapModel.setTrangThaiXuLy(model.getTrangThaiXuLy());
		soapModel.setNgayXuLy(model.getNgayXuLy());
		soapModel.setLoiKhiXuLy(model.getLoiKhiXuLy());

		return soapModel;
	}

	public static KetQuaHosoSoap[] toSoapModels(KetQuaHoso[] models) {
		KetQuaHosoSoap[] soapModels = new KetQuaHosoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KetQuaHosoSoap[][] toSoapModels(KetQuaHoso[][] models) {
		KetQuaHosoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KetQuaHosoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KetQuaHosoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KetQuaHosoSoap[] toSoapModels(List<KetQuaHoso> models) {
		List<KetQuaHosoSoap> soapModels = new ArrayList<KetQuaHosoSoap>(models.size());

		for (KetQuaHoso model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KetQuaHosoSoap[soapModels.size()]);
	}

	public KetQuaHosoSoap() {
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

	public String getTenNguoiNhanKetQua() {
		return _TenNguoiNhanKetQua;
	}

	public void setTenNguoiNhanKetQua(String TenNguoiNhanKetQua) {
		_TenNguoiNhanKetQua = TenNguoiNhanKetQua;
	}

	public String getNgayNhanKetQua() {
		return _NgayNhanKetQua;
	}

	public void setNgayNhanKetQua(String NgayNhanKetQua) {
		_NgayNhanKetQua = NgayNhanKetQua;
	}

	public int getLePhiHoSo() {
		return _LePhiHoSo;
	}

	public void setLePhiHoSo(int LePhiHoSo) {
		_LePhiHoSo = LePhiHoSo;
	}

	public int getPhiXuLyHoSo() {
		return _PhiXuLyHoSo;
	}

	public void setPhiXuLyHoSo(int PhiXuLyHoSo) {
		_PhiXuLyHoSo = PhiXuLyHoSo;
	}

	public String getNgayHoanThanh() {
		return _NgayHoanThanh;
	}

	public void setNgayHoanThanh(String NgayHoanThanh) {
		_NgayHoanThanh = NgayHoanThanh;
	}

	public String getMaCanBoTraKetQua() {
		return _MaCanBoTraKetQua;
	}

	public void setMaCanBoTraKetQua(String MaCanBoTraKetQua) {
		_MaCanBoTraKetQua = MaCanBoTraKetQua;
	}

	public String getTenCanBoTraKetQua() {
		return _TenCanBoTraKetQua;
	}

	public void setTenCanBoTraKetQua(String TenCanBoTraKetQua) {
		_TenCanBoTraKetQua = TenCanBoTraKetQua;
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
	private String _TenNguoiNhanKetQua;
	private String _NgayNhanKetQua;
	private int _LePhiHoSo;
	private int _PhiXuLyHoSo;
	private String _NgayHoanThanh;
	private String _MaCanBoTraKetQua;
	private String _TenCanBoTraKetQua;
	private String _DonViCungCap;
	private int _TrangThaiXuLy;
	private Date _NgayXuLy;
	private String _LoiKhiXuLy;
}