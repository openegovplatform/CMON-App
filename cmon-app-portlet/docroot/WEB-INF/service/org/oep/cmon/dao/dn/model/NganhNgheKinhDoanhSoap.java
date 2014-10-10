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

package org.oep.cmon.dao.dn.model;

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
public class NganhNgheKinhDoanhSoap implements Serializable {
	public static NganhNgheKinhDoanhSoap toSoapModel(NganhNgheKinhDoanh model) {
		NganhNgheKinhDoanhSoap soapModel = new NganhNgheKinhDoanhSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setChaId(model.getChaId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setCap(model.getCap());
		soapModel.setPhienBan(model.getPhienBan());

		return soapModel;
	}

	public static NganhNgheKinhDoanhSoap[] toSoapModels(
		NganhNgheKinhDoanh[] models) {
		NganhNgheKinhDoanhSoap[] soapModels = new NganhNgheKinhDoanhSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NganhNgheKinhDoanhSoap[][] toSoapModels(
		NganhNgheKinhDoanh[][] models) {
		NganhNgheKinhDoanhSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NganhNgheKinhDoanhSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NganhNgheKinhDoanhSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NganhNgheKinhDoanhSoap[] toSoapModels(
		List<NganhNgheKinhDoanh> models) {
		List<NganhNgheKinhDoanhSoap> soapModels = new ArrayList<NganhNgheKinhDoanhSoap>(models.size());

		for (NganhNgheKinhDoanh model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NganhNgheKinhDoanhSoap[soapModels.size()]);
	}

	public NganhNgheKinhDoanhSoap() {
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

	public long getChaId() {
		return _chaId;
	}

	public void setChaId(long chaId) {
		_chaId = chaId;
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

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public long getCap() {
		return _cap;
	}

	public void setCap(long cap) {
		_cap = cap;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _chaId;
	private Date _ngayTao;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private long _cap;
	private long _phienBan;
}