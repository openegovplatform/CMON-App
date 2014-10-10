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

package org.oep.dlms.dao.chitietgplx.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    hunghq
 * @generated
 */
public class ChiTietGPLXSoap implements Serializable {
	public static ChiTietGPLXSoap toSoapModel(ChiTietGPLX model) {
		ChiTietGPLXSoap soapModel = new ChiTietGPLXSoap();

		soapModel.setId(model.getId());
		soapModel.setIdGPLX(model.getIdGPLX());
		soapModel.setSoGPLX(model.getSoGPLX());
		soapModel.setIdHangGPLX(model.getIdHangGPLX());
		soapModel.setIdNoiCapGPLX(model.getIdNoiCapGPLX());
		soapModel.setIdNoiCapGPLXNuocNgoai(model.getIdNoiCapGPLXNuocNgoai());
		soapModel.setNgayCapGPLX(model.getNgayCapGPLX());
		soapModel.setNgayTrungTuyen(model.getNgayTrungTuyen());
		soapModel.setNgayHetHan(model.getNgayHetHan());
		soapModel.setIdNoiHocLaiXe(model.getIdNoiHocLaiXe());
		soapModel.setIdNoiHocLaiXeNuocNgoai(model.getIdNoiHocLaiXeNuocNgoai());
		soapModel.setNamHocLaiXe(model.getNamHocLaiXe());
		soapModel.setNoiHocLaiXeNuocNgoai(model.getNoiHocLaiXeNuocNgoai());
		soapModel.setNoiHocLaiXe(model.getNoiHocLaiXe());
		soapModel.setNoiCapGPLXNuocNgoai(model.getNoiCapGPLXNuocNgoai());
		soapModel.setNoiCapGPLX(model.getNoiCapGPLX());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());

		return soapModel;
	}

	public static ChiTietGPLXSoap[] toSoapModels(ChiTietGPLX[] models) {
		ChiTietGPLXSoap[] soapModels = new ChiTietGPLXSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChiTietGPLXSoap[][] toSoapModels(ChiTietGPLX[][] models) {
		ChiTietGPLXSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChiTietGPLXSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChiTietGPLXSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChiTietGPLXSoap[] toSoapModels(List<ChiTietGPLX> models) {
		List<ChiTietGPLXSoap> soapModels = new ArrayList<ChiTietGPLXSoap>(models.size());

		for (ChiTietGPLX model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChiTietGPLXSoap[soapModels.size()]);
	}

	public ChiTietGPLXSoap() {
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

	public long getIdGPLX() {
		return _idGPLX;
	}

	public void setIdGPLX(long idGPLX) {
		_idGPLX = idGPLX;
	}

	public String getSoGPLX() {
		return _soGPLX;
	}

	public void setSoGPLX(String soGPLX) {
		_soGPLX = soGPLX;
	}

	public long getIdHangGPLX() {
		return _idHangGPLX;
	}

	public void setIdHangGPLX(long idHangGPLX) {
		_idHangGPLX = idHangGPLX;
	}

	public long getIdNoiCapGPLX() {
		return _idNoiCapGPLX;
	}

	public void setIdNoiCapGPLX(long idNoiCapGPLX) {
		_idNoiCapGPLX = idNoiCapGPLX;
	}

	public long getIdNoiCapGPLXNuocNgoai() {
		return _idNoiCapGPLXNuocNgoai;
	}

	public void setIdNoiCapGPLXNuocNgoai(long idNoiCapGPLXNuocNgoai) {
		_idNoiCapGPLXNuocNgoai = idNoiCapGPLXNuocNgoai;
	}

	public Date getNgayCapGPLX() {
		return _ngayCapGPLX;
	}

	public void setNgayCapGPLX(Date ngayCapGPLX) {
		_ngayCapGPLX = ngayCapGPLX;
	}

	public Date getNgayTrungTuyen() {
		return _ngayTrungTuyen;
	}

	public void setNgayTrungTuyen(Date ngayTrungTuyen) {
		_ngayTrungTuyen = ngayTrungTuyen;
	}

	public Date getNgayHetHan() {
		return _ngayHetHan;
	}

	public void setNgayHetHan(Date ngayHetHan) {
		_ngayHetHan = ngayHetHan;
	}

	public long getIdNoiHocLaiXe() {
		return _idNoiHocLaiXe;
	}

	public void setIdNoiHocLaiXe(long idNoiHocLaiXe) {
		_idNoiHocLaiXe = idNoiHocLaiXe;
	}

	public long getIdNoiHocLaiXeNuocNgoai() {
		return _idNoiHocLaiXeNuocNgoai;
	}

	public void setIdNoiHocLaiXeNuocNgoai(long idNoiHocLaiXeNuocNgoai) {
		_idNoiHocLaiXeNuocNgoai = idNoiHocLaiXeNuocNgoai;
	}

	public long getNamHocLaiXe() {
		return _namHocLaiXe;
	}

	public void setNamHocLaiXe(long namHocLaiXe) {
		_namHocLaiXe = namHocLaiXe;
	}

	public String getNoiHocLaiXeNuocNgoai() {
		return _noiHocLaiXeNuocNgoai;
	}

	public void setNoiHocLaiXeNuocNgoai(String noiHocLaiXeNuocNgoai) {
		_noiHocLaiXeNuocNgoai = noiHocLaiXeNuocNgoai;
	}

	public String getNoiHocLaiXe() {
		return _noiHocLaiXe;
	}

	public void setNoiHocLaiXe(String noiHocLaiXe) {
		_noiHocLaiXe = noiHocLaiXe;
	}

	public String getNoiCapGPLXNuocNgoai() {
		return _noiCapGPLXNuocNgoai;
	}

	public void setNoiCapGPLXNuocNgoai(String noiCapGPLXNuocNgoai) {
		_noiCapGPLXNuocNgoai = noiCapGPLXNuocNgoai;
	}

	public String getNoiCapGPLX() {
		return _noiCapGPLX;
	}

	public void setNoiCapGPLX(String noiCapGPLX) {
		_noiCapGPLX = noiCapGPLX;
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

	private long _id;
	private long _idGPLX;
	private String _soGPLX;
	private long _idHangGPLX;
	private long _idNoiCapGPLX;
	private long _idNoiCapGPLXNuocNgoai;
	private Date _ngayCapGPLX;
	private Date _ngayTrungTuyen;
	private Date _ngayHetHan;
	private long _idNoiHocLaiXe;
	private long _idNoiHocLaiXeNuocNgoai;
	private long _namHocLaiXe;
	private String _noiHocLaiXeNuocNgoai;
	private String _noiHocLaiXe;
	private String _noiCapGPLXNuocNgoai;
	private String _noiCapGPLX;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
}