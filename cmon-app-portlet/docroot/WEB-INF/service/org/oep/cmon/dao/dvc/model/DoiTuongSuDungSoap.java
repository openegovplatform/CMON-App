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

package org.oep.cmon.dao.dvc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    liemnn
 * @generated
 */
public class DoiTuongSuDungSoap implements Serializable {
	public static DoiTuongSuDungSoap toSoapModel(DoiTuongSuDung model) {
		DoiTuongSuDungSoap soapModel = new DoiTuongSuDungSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setMa(model.getMa());
		soapModel.setMota(model.getMota());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static DoiTuongSuDungSoap[] toSoapModels(DoiTuongSuDung[] models) {
		DoiTuongSuDungSoap[] soapModels = new DoiTuongSuDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DoiTuongSuDungSoap[][] toSoapModels(DoiTuongSuDung[][] models) {
		DoiTuongSuDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DoiTuongSuDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DoiTuongSuDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DoiTuongSuDungSoap[] toSoapModels(List<DoiTuongSuDung> models) {
		List<DoiTuongSuDungSoap> soapModels = new ArrayList<DoiTuongSuDungSoap>(models.size());

		for (DoiTuongSuDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DoiTuongSuDungSoap[soapModels.size()]);
	}

	public DoiTuongSuDungSoap() {
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	private long _id;
	private String _ten;
	private String _ma;
	private String _mota;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _trangThai;
	private int _daXoa;
}