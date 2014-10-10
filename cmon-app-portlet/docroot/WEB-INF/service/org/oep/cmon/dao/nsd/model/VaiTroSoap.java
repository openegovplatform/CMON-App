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
public class VaiTroSoap implements Serializable {
	public static VaiTroSoap toSoapModel(VaiTro model) {
		VaiTroSoap soapModel = new VaiTroSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setUngDungId(model.getUngDungId());

		return soapModel;
	}

	public static VaiTroSoap[] toSoapModels(VaiTro[] models) {
		VaiTroSoap[] soapModels = new VaiTroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VaiTroSoap[][] toSoapModels(VaiTro[][] models) {
		VaiTroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VaiTroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VaiTroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VaiTroSoap[] toSoapModels(List<VaiTro> models) {
		List<VaiTroSoap> soapModels = new ArrayList<VaiTroSoap>(models.size());

		for (VaiTro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VaiTroSoap[soapModels.size()]);
	}

	public VaiTroSoap() {
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getUngDungId() {
		return _ungDungId;
	}

	public void setUngDungId(Long ungDungId) {
		_ungDungId = ungDungId;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _moTa;
	private Date _ngayTao;
	private int _daXoa;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _trangThai;
	private Long _ungDungId;
}