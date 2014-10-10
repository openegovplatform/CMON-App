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
public class HoChieuCMNDSoap implements Serializable {
	public static HoChieuCMNDSoap toSoapModel(HoChieuCMND model) {
		HoChieuCMNDSoap soapModel = new HoChieuCMNDSoap();

		soapModel.setId(model.getId());
		soapModel.setSo(model.getSo());
		soapModel.setNgayCap(model.getNgayCap());
		soapModel.setNgayHetHan(model.getNgayHetHan());
		soapModel.setNoiCapId(model.getNoiCapId());
		soapModel.setNoiCap(model.getNoiCap());
		soapModel.setGiChu(model.getGiChu());
		soapModel.setLoai(model.getLoai());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setCongDanID(model.getCongDanID());

		return soapModel;
	}

	public static HoChieuCMNDSoap[] toSoapModels(HoChieuCMND[] models) {
		HoChieuCMNDSoap[] soapModels = new HoChieuCMNDSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoChieuCMNDSoap[][] toSoapModels(HoChieuCMND[][] models) {
		HoChieuCMNDSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoChieuCMNDSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoChieuCMNDSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoChieuCMNDSoap[] toSoapModels(List<HoChieuCMND> models) {
		List<HoChieuCMNDSoap> soapModels = new ArrayList<HoChieuCMNDSoap>(models.size());

		for (HoChieuCMND model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoChieuCMNDSoap[soapModels.size()]);
	}

	public HoChieuCMNDSoap() {
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

	public String getSo() {
		return _so;
	}

	public void setSo(String so) {
		_so = so;
	}

	public Date getNgayCap() {
		return _ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		_ngayCap = ngayCap;
	}

	public Date getNgayHetHan() {
		return _ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		_ngayHetHan = ngayHetHan;
	}

	public Long getNoiCapId() {
		return _noiCapId;
	}

	public void setNoiCapId(Long noiCapId) {
		_noiCapId = noiCapId;
	}

	public String getNoiCap() {
		return _noiCap;
	}

	public void setNoiCap(String noiCap) {
		_noiCap = noiCap;
	}

	public String getGiChu() {
		return _giChu;
	}

	public void setGiChu(String giChu) {
		_giChu = giChu;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public Long getCongDanID() {
		return _congDanID;
	}

	public void setCongDanID(Long congDanID) {
		_congDanID = congDanID;
	}

	private long _id;
	private String _so;
	private Date _ngayCap;
	private Date _ngayHetHan;
	private Long _noiCapId;
	private String _noiCap;
	private String _giChu;
	private int _loai;
	private int _trangThai;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private Long _congDanID;
}