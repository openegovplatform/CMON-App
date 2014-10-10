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

package org.oep.cmon.dao.qlhc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    LIEMNN
 * @generated
 */
public class CapCoQuanQuanLySoap implements Serializable {
	public static CapCoQuanQuanLySoap toSoapModel(CapCoQuanQuanLy model) {
		CapCoQuanQuanLySoap soapModel = new CapCoQuanQuanLySoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setCap(model.getCap());
		soapModel.setChaId(model.getChaId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());

		return soapModel;
	}

	public static CapCoQuanQuanLySoap[] toSoapModels(CapCoQuanQuanLy[] models) {
		CapCoQuanQuanLySoap[] soapModels = new CapCoQuanQuanLySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CapCoQuanQuanLySoap[][] toSoapModels(
		CapCoQuanQuanLy[][] models) {
		CapCoQuanQuanLySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CapCoQuanQuanLySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CapCoQuanQuanLySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CapCoQuanQuanLySoap[] toSoapModels(
		List<CapCoQuanQuanLy> models) {
		List<CapCoQuanQuanLySoap> soapModels = new ArrayList<CapCoQuanQuanLySoap>(models.size());

		for (CapCoQuanQuanLy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CapCoQuanQuanLySoap[soapModels.size()]);
	}

	public CapCoQuanQuanLySoap() {
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

	public long getCap() {
		return _cap;
	}

	public void setCap(long cap) {
		_cap = cap;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public int getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(int phienBan) {
		_phienBan = phienBan;
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

	private long _id;
	private String _ma;
	private String _ten;
	private long _cap;
	private Long _chaId;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private int _phienBan;
	private String _nguoiTao;
	private String _nguoiSua;
}