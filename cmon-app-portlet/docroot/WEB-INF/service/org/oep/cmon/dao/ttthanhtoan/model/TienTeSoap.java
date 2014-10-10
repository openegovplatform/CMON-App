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

package org.oep.cmon.dao.ttthanhtoan.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Thanhdd
 * @generated
 */
public class TienTeSoap implements Serializable {
	public static TienTeSoap toSoapModel(TienTe model) {
		TienTeSoap soapModel = new TienTeSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setTyGia(model.getTyGia());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static TienTeSoap[] toSoapModels(TienTe[] models) {
		TienTeSoap[] soapModels = new TienTeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TienTeSoap[][] toSoapModels(TienTe[][] models) {
		TienTeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TienTeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TienTeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TienTeSoap[] toSoapModels(List<TienTe> models) {
		List<TienTeSoap> soapModels = new ArrayList<TienTeSoap>(models.size());

		for (TienTe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TienTeSoap[soapModels.size()]);
	}

	public TienTeSoap() {
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

	public long getTyGia() {
		return _tyGia;
	}

	public void setTyGia(long tyGia) {
		_tyGia = tyGia;
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

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(int phienBan) {
		_phienBan = phienBan;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private long _tyGia;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _trangThai;
	private int _phienBan;
	private int _daXoa;
}