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
public class DanhMucGiayTo2DoiTuongSuDungSoap implements Serializable {
	public static DanhMucGiayTo2DoiTuongSuDungSoap toSoapModel(
		DanhMucGiayTo2DoiTuongSuDung model) {
		DanhMucGiayTo2DoiTuongSuDungSoap soapModel = new DanhMucGiayTo2DoiTuongSuDungSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setLoaiDoiTuongId(model.getLoaiDoiTuongId());
		soapModel.setLoaiGiayToId(model.getLoaiGiayToId());
		soapModel.setTrangThai(model.getTrangThai());

		return soapModel;
	}

	public static DanhMucGiayTo2DoiTuongSuDungSoap[] toSoapModels(
		DanhMucGiayTo2DoiTuongSuDung[] models) {
		DanhMucGiayTo2DoiTuongSuDungSoap[] soapModels = new DanhMucGiayTo2DoiTuongSuDungSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhMucGiayTo2DoiTuongSuDungSoap[][] toSoapModels(
		DanhMucGiayTo2DoiTuongSuDung[][] models) {
		DanhMucGiayTo2DoiTuongSuDungSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhMucGiayTo2DoiTuongSuDungSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhMucGiayTo2DoiTuongSuDungSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhMucGiayTo2DoiTuongSuDungSoap[] toSoapModels(
		List<DanhMucGiayTo2DoiTuongSuDung> models) {
		List<DanhMucGiayTo2DoiTuongSuDungSoap> soapModels = new ArrayList<DanhMucGiayTo2DoiTuongSuDungSoap>(models.size());

		for (DanhMucGiayTo2DoiTuongSuDung model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhMucGiayTo2DoiTuongSuDungSoap[soapModels.size()]);
	}

	public DanhMucGiayTo2DoiTuongSuDungSoap() {
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

	public long getLoaiDoiTuongId() {
		return _loaiDoiTuongId;
	}

	public void setLoaiDoiTuongId(long loaiDoiTuongId) {
		_loaiDoiTuongId = loaiDoiTuongId;
	}

	public long getLoaiGiayToId() {
		return _loaiGiayToId;
	}

	public void setLoaiGiayToId(long loaiGiayToId) {
		_loaiGiayToId = loaiGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	private long _id;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _loaiDoiTuongId;
	private long _loaiGiayToId;
	private int _trangThai;
}