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
public class ThuTuc2GiayToSoap implements Serializable {
	public static ThuTuc2GiayToSoap toSoapModel(ThuTuc2GiayTo model) {
		ThuTuc2GiayToSoap soapModel = new ThuTuc2GiayToSoap();

		soapModel.setId(model.getId());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setBatBuoc(model.getBatBuoc());
		soapModel.setThuTuHienThi(model.getThuTuHienThi());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setDanhMucGiayToId(model.getDanhMucGiayToId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setGiaidoan(model.getGiaidoan());

		return soapModel;
	}

	public static ThuTuc2GiayToSoap[] toSoapModels(ThuTuc2GiayTo[] models) {
		ThuTuc2GiayToSoap[] soapModels = new ThuTuc2GiayToSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThuTuc2GiayToSoap[][] toSoapModels(ThuTuc2GiayTo[][] models) {
		ThuTuc2GiayToSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThuTuc2GiayToSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThuTuc2GiayToSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThuTuc2GiayToSoap[] toSoapModels(List<ThuTuc2GiayTo> models) {
		List<ThuTuc2GiayToSoap> soapModels = new ArrayList<ThuTuc2GiayToSoap>(models.size());

		for (ThuTuc2GiayTo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThuTuc2GiayToSoap[soapModels.size()]);
	}

	public ThuTuc2GiayToSoap() {
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

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public int getBatBuoc() {
		return _batBuoc;
	}

	public void setBatBuoc(int batBuoc) {
		_batBuoc = batBuoc;
	}

	public long getThuTuHienThi() {
		return _thuTuHienThi;
	}

	public void setThuTuHienThi(long thuTuHienThi) {
		_thuTuHienThi = thuTuHienThi;
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

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public int getGiaidoan() {
		return _giaidoan;
	}

	public void setGiaidoan(int giaidoan) {
		_giaidoan = giaidoan;
	}

	private long _id;
	private String _ghiChu;
	private int _batBuoc;
	private long _thuTuHienThi;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _thuTucHanhChinhId;
	private long _danhMucGiayToId;
	private int _trangThai;
	private int _giaidoan;
}