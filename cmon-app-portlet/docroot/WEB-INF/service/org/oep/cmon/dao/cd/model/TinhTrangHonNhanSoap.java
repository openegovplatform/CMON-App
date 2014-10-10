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

package org.oep.cmon.dao.cd.model;

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
public class TinhTrangHonNhanSoap implements Serializable {
	public static TinhTrangHonNhanSoap toSoapModel(TinhTrangHonNhan model) {
		TinhTrangHonNhanSoap soapModel = new TinhTrangHonNhanSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiSua(model.getNguoiSua());

		return soapModel;
	}

	public static TinhTrangHonNhanSoap[] toSoapModels(TinhTrangHonNhan[] models) {
		TinhTrangHonNhanSoap[] soapModels = new TinhTrangHonNhanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TinhTrangHonNhanSoap[][] toSoapModels(
		TinhTrangHonNhan[][] models) {
		TinhTrangHonNhanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TinhTrangHonNhanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TinhTrangHonNhanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TinhTrangHonNhanSoap[] toSoapModels(
		List<TinhTrangHonNhan> models) {
		List<TinhTrangHonNhanSoap> soapModels = new ArrayList<TinhTrangHonNhanSoap>(models.size());

		for (TinhTrangHonNhan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TinhTrangHonNhanSoap[soapModels.size()]);
	}

	public TinhTrangHonNhanSoap() {
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	private long _id;
	private String _ten;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private int _daXoa;
	private String _nguoiSua;
}