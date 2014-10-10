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

package org.oep.cmon.dao.cc.model;

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
public class CongChuc2NhomThuTucSoap implements Serializable {
	public static CongChuc2NhomThuTucSoap toSoapModel(CongChuc2NhomThuTuc model) {
		CongChuc2NhomThuTucSoap soapModel = new CongChuc2NhomThuTucSoap();

		soapModel.setId(model.getId());
		soapModel.setCongChucId(model.getCongChucId());
		soapModel.setNhomThuTucId(model.getNhomThuTucId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setDuocPhepEditCongDan(model.getDuocPhepEditCongDan());

		return soapModel;
	}

	public static CongChuc2NhomThuTucSoap[] toSoapModels(
		CongChuc2NhomThuTuc[] models) {
		CongChuc2NhomThuTucSoap[] soapModels = new CongChuc2NhomThuTucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CongChuc2NhomThuTucSoap[][] toSoapModels(
		CongChuc2NhomThuTuc[][] models) {
		CongChuc2NhomThuTucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CongChuc2NhomThuTucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CongChuc2NhomThuTucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CongChuc2NhomThuTucSoap[] toSoapModels(
		List<CongChuc2NhomThuTuc> models) {
		List<CongChuc2NhomThuTucSoap> soapModels = new ArrayList<CongChuc2NhomThuTucSoap>(models.size());

		for (CongChuc2NhomThuTuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CongChuc2NhomThuTucSoap[soapModels.size()]);
	}

	public CongChuc2NhomThuTucSoap() {
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

	public long getCongChucId() {
		return _congChucId;
	}

	public void setCongChucId(long congChucId) {
		_congChucId = congChucId;
	}

	public long getNhomThuTucId() {
		return _nhomThuTucId;
	}

	public void setNhomThuTucId(long nhomThuTucId) {
		_nhomThuTucId = nhomThuTucId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public int getDuocPhepEditCongDan() {
		return _duocPhepEditCongDan;
	}

	public void setDuocPhepEditCongDan(int duocPhepEditCongDan) {
		_duocPhepEditCongDan = duocPhepEditCongDan;
	}

	private long _id;
	private long _congChucId;
	private long _nhomThuTucId;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
	private int _duocPhepEditCongDan;
}