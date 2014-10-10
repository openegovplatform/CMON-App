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

package org.oep.cmon.dao.hosohcc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    LIEMNn
 * @generated
 */
public class YKienTraoDoiSoap implements Serializable {
	public static YKienTraoDoiSoap toSoapModel(YKienTraoDoi model) {
		YKienTraoDoiSoap soapModel = new YKienTraoDoiSoap();

		soapModel.setId(model.getId());
		soapModel.setTieuDe(model.getTieuDe());
		soapModel.setNoiDungYKien(model.getNoiDungYKien());
		soapModel.setThoiGianGuiYKien(model.getThoiGianGuiYKien());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setHoSoTTHCCongId(model.getHoSoTTHCCongId());
		soapModel.setNguoiNhanId(model.getNguoiNhanId());
		soapModel.setNguoiGuiId(model.getNguoiGuiId());
		soapModel.setChaiId(model.getChaiId());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setLoai(model.getLoai());

		return soapModel;
	}

	public static YKienTraoDoiSoap[] toSoapModels(YKienTraoDoi[] models) {
		YKienTraoDoiSoap[] soapModels = new YKienTraoDoiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static YKienTraoDoiSoap[][] toSoapModels(YKienTraoDoi[][] models) {
		YKienTraoDoiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new YKienTraoDoiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new YKienTraoDoiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static YKienTraoDoiSoap[] toSoapModels(List<YKienTraoDoi> models) {
		List<YKienTraoDoiSoap> soapModels = new ArrayList<YKienTraoDoiSoap>(models.size());

		for (YKienTraoDoi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new YKienTraoDoiSoap[soapModels.size()]);
	}

	public YKienTraoDoiSoap() {
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

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getNoiDungYKien() {
		return _noiDungYKien;
	}

	public void setNoiDungYKien(String noiDungYKien) {
		_noiDungYKien = noiDungYKien;
	}

	public Date getThoiGianGuiYKien() {
		return _thoiGianGuiYKien;
	}

	public void setThoiGianGuiYKien(Date thoiGianGuiYKien) {
		_thoiGianGuiYKien = thoiGianGuiYKien;
	}

	public long getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(long trangThai) {
		_trangThai = trangThai;
	}

	public Long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(Long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getNguoiNhanId() {
		return _nguoiNhanId;
	}

	public void setNguoiNhanId(Long nguoiNhanId) {
		_nguoiNhanId = nguoiNhanId;
	}

	public Long getNguoiGuiId() {
		return _nguoiGuiId;
	}

	public void setNguoiGuiId(Long nguoiGuiId) {
		_nguoiGuiId = nguoiGuiId;
	}

	public Long getChaiId() {
		return _chaiId;
	}

	public void setChaiId(Long chaiId) {
		_chaiId = chaiId;
	}

	public Long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(Long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public long getLoai() {
		return _loai;
	}

	public void setLoai(long loai) {
		_loai = loai;
	}

	private long _id;
	private String _tieuDe;
	private String _noiDungYKien;
	private Date _thoiGianGuiYKien;
	private long _trangThai;
	private Long _hoSoTTHCCongId;
	private Long _nguoiNhanId;
	private Long _nguoiGuiId;
	private Long _chaiId;
	private Long _noiLuuTruId;
	private long _loai;
}