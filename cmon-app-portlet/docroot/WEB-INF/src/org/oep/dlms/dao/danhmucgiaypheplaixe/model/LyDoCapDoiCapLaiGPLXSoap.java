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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    AnhNT
 * @generated
 */
public class LyDoCapDoiCapLaiGPLXSoap implements Serializable {
	public static LyDoCapDoiCapLaiGPLXSoap toSoapModel(
		LyDoCapDoiCapLaiGPLX model) {
		LyDoCapDoiCapLaiGPLXSoap soapModel = new LyDoCapDoiCapLaiGPLXSoap();

		soapModel.setId(model.getId());
		soapModel.setLyDo(model.getLyDo());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());

		return soapModel;
	}

	public static LyDoCapDoiCapLaiGPLXSoap[] toSoapModels(
		LyDoCapDoiCapLaiGPLX[] models) {
		LyDoCapDoiCapLaiGPLXSoap[] soapModels = new LyDoCapDoiCapLaiGPLXSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LyDoCapDoiCapLaiGPLXSoap[][] toSoapModels(
		LyDoCapDoiCapLaiGPLX[][] models) {
		LyDoCapDoiCapLaiGPLXSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LyDoCapDoiCapLaiGPLXSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LyDoCapDoiCapLaiGPLXSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LyDoCapDoiCapLaiGPLXSoap[] toSoapModels(
		List<LyDoCapDoiCapLaiGPLX> models) {
		List<LyDoCapDoiCapLaiGPLXSoap> soapModels = new ArrayList<LyDoCapDoiCapLaiGPLXSoap>(models.size());

		for (LyDoCapDoiCapLaiGPLX model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LyDoCapDoiCapLaiGPLXSoap[soapModels.size()]);
	}

	public LyDoCapDoiCapLaiGPLXSoap() {
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

	public String getLyDo() {
		return _lyDo;
	}

	public void setLyDo(String lyDo) {
		_lyDo = lyDo;
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

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	private long _id;
	private String _lyDo;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}