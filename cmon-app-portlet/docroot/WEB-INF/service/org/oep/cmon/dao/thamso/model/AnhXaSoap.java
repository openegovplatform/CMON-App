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

package org.oep.cmon.dao.thamso.model;

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
public class AnhXaSoap implements Serializable {
	public static AnhXaSoap toSoapModel(AnhXa model) {
		AnhXaSoap soapModel = new AnhXaSoap();

		soapModel.setId(model.getId());
		soapModel.setMaDNG(model.getMaDNG());
		soapModel.setTenDNG(model.getTenDNG());
		soapModel.setMaKhac(model.getMaKhac());
		soapModel.setTenKhac(model.getTenKhac());
		soapModel.setTenBang(model.getTenBang());
		soapModel.setUngDungId(model.getUngDungId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static AnhXaSoap[] toSoapModels(AnhXa[] models) {
		AnhXaSoap[] soapModels = new AnhXaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnhXaSoap[][] toSoapModels(AnhXa[][] models) {
		AnhXaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnhXaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnhXaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnhXaSoap[] toSoapModels(List<AnhXa> models) {
		List<AnhXaSoap> soapModels = new ArrayList<AnhXaSoap>(models.size());

		for (AnhXa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnhXaSoap[soapModels.size()]);
	}

	public AnhXaSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getMaDNG() {
		return _maDNG;
	}

	public void setMaDNG(String maDNG) {
		_maDNG = maDNG;
	}

	public String getTenDNG() {
		return _tenDNG;
	}

	public void setTenDNG(String tenDNG) {
		_tenDNG = tenDNG;
	}

	public String getMaKhac() {
		return _maKhac;
	}

	public void setMaKhac(String maKhac) {
		_maKhac = maKhac;
	}

	public String getTenKhac() {
		return _tenKhac;
	}

	public void setTenKhac(String tenKhac) {
		_tenKhac = tenKhac;
	}

	public String getTenBang() {
		return _tenBang;
	}

	public void setTenBang(String tenBang) {
		_tenBang = tenBang;
	}

	public long getUngDungId() {
		return _UngDungId;
	}

	public void setUngDungId(long UngDungId) {
		_UngDungId = UngDungId;
	}

	public Date getNgayTao() {
		return _NgayTao;
	}

	public void setNgayTao(Date NgayTao) {
		_NgayTao = NgayTao;
	}

	public String getNguoiTao() {
		return _NguoiTao;
	}

	public void setNguoiTao(String NguoiTao) {
		_NguoiTao = NguoiTao;
	}

	public Date getNgaySua() {
		return _NgaySua;
	}

	public void setNgaySua(Date NgaySua) {
		_NgaySua = NgaySua;
	}

	public String getNguoiSua() {
		return _NguoiSua;
	}

	public void setNguoiSua(String NguoiSua) {
		_NguoiSua = NguoiSua;
	}

	public int getDaXoa() {
		return _DaXoa;
	}

	public void setDaXoa(int DaXoa) {
		_DaXoa = DaXoa;
	}

	private long _Id;
	private String _maDNG;
	private String _tenDNG;
	private String _maKhac;
	private String _tenKhac;
	private String _tenBang;
	private long _UngDungId;
	private Date _NgayTao;
	private String _NguoiTao;
	private Date _NgaySua;
	private String _NguoiSua;
	private int _DaXoa;
}