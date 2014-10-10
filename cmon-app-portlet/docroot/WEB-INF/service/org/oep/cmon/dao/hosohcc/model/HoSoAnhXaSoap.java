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

package org.oep.cmon.dao.hosohcc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    LIEMNn
 * @generated
 */
public class HoSoAnhXaSoap implements Serializable {
	public static HoSoAnhXaSoap toSoapModel(HoSoAnhXa model) {
		HoSoAnhXaSoap soapModel = new HoSoAnhXaSoap();

		soapModel.setId(model.getId());
		soapModel.setHoSoTTHCCongId(model.getHoSoTTHCCongId());
		soapModel.setMaHoSo(model.getMaHoSo());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNgayTao(model.getNgayTao());

		return soapModel;
	}

	public static HoSoAnhXaSoap[] toSoapModels(HoSoAnhXa[] models) {
		HoSoAnhXaSoap[] soapModels = new HoSoAnhXaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoAnhXaSoap[][] toSoapModels(HoSoAnhXa[][] models) {
		HoSoAnhXaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoAnhXaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoAnhXaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoAnhXaSoap[] toSoapModels(List<HoSoAnhXa> models) {
		List<HoSoAnhXaSoap> soapModels = new ArrayList<HoSoAnhXaSoap>(models.size());

		for (HoSoAnhXa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoAnhXaSoap[soapModels.size()]);
	}

	public HoSoAnhXaSoap() {
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

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public String getMaHoSo() {
		return _maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		_maHoSo = maHoSo;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	private long _id;
	private long _hoSoTTHCCongId;
	private String _maHoSo;
	private int _trangThai;
	private Date _ngaySua;
	private Date _ngayTao;
}