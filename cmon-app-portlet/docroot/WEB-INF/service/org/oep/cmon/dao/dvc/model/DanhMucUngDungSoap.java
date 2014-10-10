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
public class DanhMucUngDungSoap implements Serializable {
	public static DanhMucUngDungSoap toSoapModel(DanhMucUngDung model) {
		DanhMucUngDungSoap soapModel = new DanhMucUngDungSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNguoiTao(model.getNguoiTao());

		return soapModel;
	}

	public static DanhMucUngDungSoap[] toSoapModels(DanhMucUngDung[] models) {
		DanhMucUngDungSoap[] soapModels = new DanhMucUngDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucUngDungSoap[][] toSoapModels(DanhMucUngDung[][] models) {
		DanhMucUngDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucUngDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucUngDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucUngDungSoap[] toSoapModels(List<DanhMucUngDung> models) {
		List<DanhMucUngDungSoap> soapModels = new ArrayList<DanhMucUngDungSoap>(models.size());

		for (DanhMucUngDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucUngDungSoap[soapModels.size()]);
	}

	public DanhMucUngDungSoap() {
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

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiSua;
	private String _nguoiTao;
}