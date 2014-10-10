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
public class ChuyenMonSoap implements Serializable {
	public static ChuyenMonSoap toSoapModel(ChuyenMon model) {
		ChuyenMonSoap soapModel = new ChuyenMonSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setPhienban(model.getPhienban());
		soapModel.setNgaytao(model.getNgaytao());
		soapModel.setNguoitao(model.getNguoitao());
		soapModel.setNgaysua(model.getNgaysua());
		soapModel.setNguoisua(model.getNguoisua());
		soapModel.setDaxoa(model.getDaxoa());

		return soapModel;
	}

	public static ChuyenMonSoap[] toSoapModels(ChuyenMon[] models) {
		ChuyenMonSoap[] soapModels = new ChuyenMonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChuyenMonSoap[][] toSoapModels(ChuyenMon[][] models) {
		ChuyenMonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChuyenMonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChuyenMonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChuyenMonSoap[] toSoapModels(List<ChuyenMon> models) {
		List<ChuyenMonSoap> soapModels = new ArrayList<ChuyenMonSoap>(models.size());

		for (ChuyenMon model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChuyenMonSoap[soapModels.size()]);
	}

	public ChuyenMonSoap() {
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

	public long getPhienban() {
		return _phienban;
	}

	public void setPhienban(long phienban) {
		_phienban = phienban;
	}

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public String getNguoitao() {
		return _nguoitao;
	}

	public void setNguoitao(String nguoitao) {
		_nguoitao = nguoitao;
	}

	public Date getNgaysua() {
		return _ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		_ngaysua = ngaysua;
	}

	public String getNguoisua() {
		return _nguoisua;
	}

	public void setNguoisua(String nguoisua) {
		_nguoisua = nguoisua;
	}

	public long getDaxoa() {
		return _daxoa;
	}

	public void setDaxoa(long daxoa) {
		_daxoa = daxoa;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _phienban;
	private Date _ngaytao;
	private String _nguoitao;
	private Date _ngaysua;
	private String _nguoisua;
	private long _daxoa;
}