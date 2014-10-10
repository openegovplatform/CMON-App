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
public class VanBanHuongDanSoap implements Serializable {
	public static VanBanHuongDanSoap toSoapModel(VanBanHuongDan model) {
		VanBanHuongDanSoap soapModel = new VanBanHuongDanSoap();

		soapModel.setId(model.getId());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setTenTaiLieu(model.getTenTaiLieu());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setLoaiTaiLieu(model.getLoaiTaiLieu());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());

		return soapModel;
	}

	public static VanBanHuongDanSoap[] toSoapModels(VanBanHuongDan[] models) {
		VanBanHuongDanSoap[] soapModels = new VanBanHuongDanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VanBanHuongDanSoap[][] toSoapModels(VanBanHuongDan[][] models) {
		VanBanHuongDanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VanBanHuongDanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VanBanHuongDanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VanBanHuongDanSoap[] toSoapModels(List<VanBanHuongDan> models) {
		List<VanBanHuongDanSoap> soapModels = new ArrayList<VanBanHuongDanSoap>(models.size());

		for (VanBanHuongDan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VanBanHuongDanSoap[soapModels.size()]);
	}

	public VanBanHuongDanSoap() {
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

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public String getTenTaiLieu() {
		return _tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		_tenTaiLieu = tenTaiLieu;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public long getLoaiTaiLieu() {
		return _loaiTaiLieu;
	}

	public void setLoaiTaiLieu(long loaiTaiLieu) {
		_loaiTaiLieu = loaiTaiLieu;
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

	private long _id;
	private long _noiLuuTruId;
	private String _tenTaiLieu;
	private String _moTa;
	private long _loaiTaiLieu;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private long _thuTucHanhChinhId;
}