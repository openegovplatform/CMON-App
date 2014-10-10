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

package org.oep.cmon.dao.nsd.model;

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
public class NhomNguoiDungSoap implements Serializable {
	public static NhomNguoiDungSoap toSoapModel(NhomNguoiDung model) {
		NhomNguoiDungSoap soapModel = new NhomNguoiDungSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static NhomNguoiDungSoap[] toSoapModels(NhomNguoiDung[] models) {
		NhomNguoiDungSoap[] soapModels = new NhomNguoiDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NhomNguoiDungSoap[][] toSoapModels(NhomNguoiDung[][] models) {
		NhomNguoiDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NhomNguoiDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NhomNguoiDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NhomNguoiDungSoap[] toSoapModels(List<NhomNguoiDung> models) {
		List<NhomNguoiDungSoap> soapModels = new ArrayList<NhomNguoiDungSoap>(models.size());

		for (NhomNguoiDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NhomNguoiDungSoap[soapModels.size()]);
	}

	public NhomNguoiDungSoap() {
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	private long _id;
	private String _ten;
	private String _moTa;
	private Date _ngayTao;
	private int _daXoa;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _trangThai;
}