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
public class TTHC2CoQuanQuanLySoap implements Serializable {
	public static TTHC2CoQuanQuanLySoap toSoapModel(TTHC2CoQuanQuanLy model) {
		TTHC2CoQuanQuanLySoap soapModel = new TTHC2CoQuanQuanLySoap();

		soapModel.setId(model.getId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setSoNgayXyLy(model.getSoNgayXyLy());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setCoQuanQuanLyId(model.getCoQuanQuanLyId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setPhi(model.getPhi());
		soapModel.setLePhi(model.getLePhi());

		return soapModel;
	}

	public static TTHC2CoQuanQuanLySoap[] toSoapModels(
		TTHC2CoQuanQuanLy[] models) {
		TTHC2CoQuanQuanLySoap[] soapModels = new TTHC2CoQuanQuanLySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TTHC2CoQuanQuanLySoap[][] toSoapModels(
		TTHC2CoQuanQuanLy[][] models) {
		TTHC2CoQuanQuanLySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TTHC2CoQuanQuanLySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TTHC2CoQuanQuanLySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TTHC2CoQuanQuanLySoap[] toSoapModels(
		List<TTHC2CoQuanQuanLy> models) {
		List<TTHC2CoQuanQuanLySoap> soapModels = new ArrayList<TTHC2CoQuanQuanLySoap>(models.size());

		for (TTHC2CoQuanQuanLy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TTHC2CoQuanQuanLySoap[soapModels.size()]);
	}

	public TTHC2CoQuanQuanLySoap() {
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

	public int getSoNgayXyLy() {
		return _soNgayXyLy;
	}

	public void setSoNgayXyLy(int soNgayXyLy) {
		_soNgayXyLy = soNgayXyLy;
	}

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getPhi() {
		return _phi;
	}

	public void setPhi(int phi) {
		_phi = phi;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	private long _id;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _soNgayXyLy;
	private long _thuTucHanhChinhId;
	private long _coQuanQuanLyId;
	private int _trangThai;
	private int _phi;
	private int _lePhi;
}