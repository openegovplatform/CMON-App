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
public class TonGiaoSoap implements Serializable {
	public static TonGiaoSoap toSoapModel(TonGiao model) {
		TonGiaoSoap soapModel = new TonGiaoSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setPhienBan(model.getPhienBan());

		return soapModel;
	}

	public static TonGiaoSoap[] toSoapModels(TonGiao[] models) {
		TonGiaoSoap[] soapModels = new TonGiaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TonGiaoSoap[][] toSoapModels(TonGiao[][] models) {
		TonGiaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TonGiaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TonGiaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TonGiaoSoap[] toSoapModels(List<TonGiao> models) {
		List<TonGiaoSoap> soapModels = new ArrayList<TonGiaoSoap>(models.size());

		for (TonGiao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TonGiaoSoap[soapModels.size()]);
	}

	public TonGiaoSoap() {
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

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private Date _ngayTao;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private long _phienBan;
}