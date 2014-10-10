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
public class TrangThaiDoanhNghiepSoap implements Serializable {
	public static TrangThaiDoanhNghiepSoap toSoapModel(
		TrangThaiDoanhNghiep model) {
		TrangThaiDoanhNghiepSoap soapModel = new TrangThaiDoanhNghiepSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static TrangThaiDoanhNghiepSoap[] toSoapModels(
		TrangThaiDoanhNghiep[] models) {
		TrangThaiDoanhNghiepSoap[] soapModels = new TrangThaiDoanhNghiepSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiDoanhNghiepSoap[][] toSoapModels(
		TrangThaiDoanhNghiep[][] models) {
		TrangThaiDoanhNghiepSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TrangThaiDoanhNghiepSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TrangThaiDoanhNghiepSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TrangThaiDoanhNghiepSoap[] toSoapModels(
		List<TrangThaiDoanhNghiep> models) {
		List<TrangThaiDoanhNghiepSoap> soapModels = new ArrayList<TrangThaiDoanhNghiepSoap>(models.size());

		for (TrangThaiDoanhNghiep model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TrangThaiDoanhNghiepSoap[soapModels.size()]);
	}

	public TrangThaiDoanhNghiepSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
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

	private long _id;
	private String _ten;
	private String _moTa;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
}