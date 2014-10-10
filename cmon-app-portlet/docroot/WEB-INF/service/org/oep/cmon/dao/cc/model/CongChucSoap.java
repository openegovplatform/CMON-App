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

package org.oep.cmon.dao.cc.model;

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
public class CongChucSoap implements Serializable {
	public static CongChucSoap toSoapModel(CongChuc model) {
		CongChucSoap soapModel = new CongChucSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setHoVaTen(model.getHoVaTen());
		soapModel.setNgaySinh(model.getNgaySinh());
		soapModel.setSoCmnd(model.getSoCmnd());
		soapModel.setNgayCapCmnd(model.getNgayCapCmnd());
		soapModel.setNoiCapCmnd(model.getNoiCapCmnd());
		soapModel.setGioiTinhId(model.getGioiTinhId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setChucVuId(model.getChucVuId());
		soapModel.setCoQuanQuanLyId(model.getCoQuanQuanLyId());
		soapModel.setNguoiTao(model.getNguoiTao());

		return soapModel;
	}

	public static CongChucSoap[] toSoapModels(CongChuc[] models) {
		CongChucSoap[] soapModels = new CongChucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CongChucSoap[][] toSoapModels(CongChuc[][] models) {
		CongChucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CongChucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CongChucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CongChucSoap[] toSoapModels(List<CongChuc> models) {
		List<CongChucSoap> soapModels = new ArrayList<CongChucSoap>(models.size());

		for (CongChuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CongChucSoap[soapModels.size()]);
	}

	public CongChucSoap() {
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

	public String getHoVaTen() {
		return _hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		_hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return _ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		_ngaySinh = ngaySinh;
	}

	public String getSoCmnd() {
		return _soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		_soCmnd = soCmnd;
	}

	public Date getNgayCapCmnd() {
		return _ngayCapCmnd;
	}

	public void setNgayCapCmnd(Date ngayCapCmnd) {
		_ngayCapCmnd = ngayCapCmnd;
	}

	public String getNoiCapCmnd() {
		return _noiCapCmnd;
	}

	public void setNoiCapCmnd(String noiCapCmnd) {
		_noiCapCmnd = noiCapCmnd;
	}

	public long getGioiTinhId() {
		return _gioiTinhId;
	}

	public void setGioiTinhId(long gioiTinhId) {
		_gioiTinhId = gioiTinhId;
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

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public long getChucVuId() {
		return _chucVuId;
	}

	public void setChucVuId(long chucVuId) {
		_chucVuId = chucVuId;
	}

	public long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	private long _id;
	private String _ma;
	private String _hoVaTen;
	private Date _ngaySinh;
	private String _soCmnd;
	private Date _ngayCapCmnd;
	private String _noiCapCmnd;
	private long _gioiTinhId;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private Long _taiKhoanNguoiDungId;
	private String _nguoiSua;
	private long _chucVuId;
	private long _coQuanQuanLyId;
	private String _nguoiTao;
}