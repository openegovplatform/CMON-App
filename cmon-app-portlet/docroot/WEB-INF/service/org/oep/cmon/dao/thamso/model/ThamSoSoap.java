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

package org.oep.cmon.dao.thamso.model;

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
public class ThamSoSoap implements Serializable {
	public static ThamSoSoap toSoapModel(ThamSo model) {
		ThamSoSoap soapModel = new ThamSoSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setGiaTri(model.getGiaTri());
		soapModel.setKieuDuLieu(model.getKieuDuLieu());
		soapModel.setMota(model.getMota());
		soapModel.setUngDungId(model.getUngDungId());
		soapModel.setHeThongId(model.getHeThongId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static ThamSoSoap[] toSoapModels(ThamSo[] models) {
		ThamSoSoap[] soapModels = new ThamSoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThamSoSoap[][] toSoapModels(ThamSo[][] models) {
		ThamSoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThamSoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThamSoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThamSoSoap[] toSoapModels(List<ThamSo> models) {
		List<ThamSoSoap> soapModels = new ArrayList<ThamSoSoap>(models.size());

		for (ThamSo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThamSoSoap[soapModels.size()]);
	}

	public ThamSoSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getTen() {
		return _Ten;
	}

	public void setTen(String Ten) {
		_Ten = Ten;
	}

	public String getGiaTri() {
		return _giaTri;
	}

	public void setGiaTri(String giaTri) {
		_giaTri = giaTri;
	}

	public int getKieuDuLieu() {
		return _kieuDuLieu;
	}

	public void setKieuDuLieu(int kieuDuLieu) {
		_kieuDuLieu = kieuDuLieu;
	}

	public String getMota() {
		return _Mota;
	}

	public void setMota(String Mota) {
		_Mota = Mota;
	}

	public Long getUngDungId() {
		return _UngDungId;
	}

	public void setUngDungId(Long UngDungId) {
		_UngDungId = UngDungId;
	}

	public Long getHeThongId() {
		return _HeThongId;
	}

	public void setHeThongId(Long HeThongId) {
		_HeThongId = HeThongId;
	}

	public Date getNgayTao() {
		return _NgayTao;
	}

	public void setNgayTao(Date NgayTao) {
		_NgayTao = NgayTao;
	}

	public String getNguoiTao() {
		return _NguoiTao;
	}

	public void setNguoiTao(String NguoiTao) {
		_NguoiTao = NguoiTao;
	}

	public Date getNgaySua() {
		return _NgaySua;
	}

	public void setNgaySua(Date NgaySua) {
		_NgaySua = NgaySua;
	}

	public String getNguoiSua() {
		return _NguoiSua;
	}

	public void setNguoiSua(String NguoiSua) {
		_NguoiSua = NguoiSua;
	}

	public int getDaXoa() {
		return _DaXoa;
	}

	public void setDaXoa(int DaXoa) {
		_DaXoa = DaXoa;
	}

	private long _Id;
	private String _Ten;
	private String _giaTri;
	private int _kieuDuLieu;
	private String _Mota;
	private Long _UngDungId;
	private Long _HeThongId;
	private Date _NgayTao;
	private String _NguoiTao;
	private Date _NgaySua;
	private String _NguoiSua;
	private int _DaXoa;
}