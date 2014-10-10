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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    AnhNT
 * @generated
 */
public class HangGiayPhepLaiXeSoap implements Serializable {
	public static HangGiayPhepLaiXeSoap toSoapModel(HangGiayPhepLaiXe model) {
		HangGiayPhepLaiXeSoap soapModel = new HangGiayPhepLaiXeSoap();

		soapModel.setId(model.getId());
		soapModel.setTenHang(model.getTenHang());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());
		soapModel.setMa(model.getMa());

		return soapModel;
	}

	public static HangGiayPhepLaiXeSoap[] toSoapModels(
		HangGiayPhepLaiXe[] models) {
		HangGiayPhepLaiXeSoap[] soapModels = new HangGiayPhepLaiXeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HangGiayPhepLaiXeSoap[][] toSoapModels(
		HangGiayPhepLaiXe[][] models) {
		HangGiayPhepLaiXeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HangGiayPhepLaiXeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HangGiayPhepLaiXeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HangGiayPhepLaiXeSoap[] toSoapModels(
		List<HangGiayPhepLaiXe> models) {
		List<HangGiayPhepLaiXeSoap> soapModels = new ArrayList<HangGiayPhepLaiXeSoap>(models.size());

		for (HangGiayPhepLaiXe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HangGiayPhepLaiXeSoap[soapModels.size()]);
	}

	public HangGiayPhepLaiXeSoap() {
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

	public String getTenHang() {
		return _tenHang;
	}

	public void setTenHang(String tenHang) {
		_tenHang = tenHang;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	private long _id;
	private String _tenHang;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
	private String _ma;
}