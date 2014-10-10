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

package org.oep.cmon.dao.tlct.model;

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
public class DanhMucGiayToSoap implements Serializable {
	public static DanhMucGiayToSoap toSoapModel(DanhMucGiayTo model) {
		DanhMucGiayToSoap soapModel = new DanhMucGiayToSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setMota(model.getMota());
		soapModel.setGioiHanDungLuong(model.getGioiHanDungLuong());
		soapModel.setKieuTaiLieu(model.getKieuTaiLieu());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setTailieuThayTheId(model.getTailieuThayTheId());

		return soapModel;
	}

	public static DanhMucGiayToSoap[] toSoapModels(DanhMucGiayTo[] models) {
		DanhMucGiayToSoap[] soapModels = new DanhMucGiayToSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucGiayToSoap[][] toSoapModels(DanhMucGiayTo[][] models) {
		DanhMucGiayToSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucGiayToSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucGiayToSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucGiayToSoap[] toSoapModels(List<DanhMucGiayTo> models) {
		List<DanhMucGiayToSoap> soapModels = new ArrayList<DanhMucGiayToSoap>(models.size());

		for (DanhMucGiayTo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucGiayToSoap[soapModels.size()]);
	}

	public DanhMucGiayToSoap() {
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

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
	}

	public long getGioiHanDungLuong() {
		return _gioiHanDungLuong;
	}

	public void setGioiHanDungLuong(long gioiHanDungLuong) {
		_gioiHanDungLuong = gioiHanDungLuong;
	}

	public String getKieuTaiLieu() {
		return _kieuTaiLieu;
	}

	public void setKieuTaiLieu(String kieuTaiLieu) {
		_kieuTaiLieu = kieuTaiLieu;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
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

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public Long getTailieuThayTheId() {
		return _tailieuThayTheId;
	}

	public void setTailieuThayTheId(Long tailieuThayTheId) {
		_tailieuThayTheId = tailieuThayTheId;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _mota;
	private long _gioiHanDungLuong;
	private String _kieuTaiLieu;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
	private long _phienBan;
	private Long _tailieuThayTheId;
}