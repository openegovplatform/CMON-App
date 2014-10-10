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

package org.oep.cmon.dao.tlct.model;

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
public class LichSuGiayToDinhKemSoap implements Serializable {
	public static LichSuGiayToDinhKemSoap toSoapModel(LichSuGiayToDinhKem model) {
		LichSuGiayToDinhKemSoap soapModel = new LichSuGiayToDinhKemSoap();

		soapModel.setId(model.getId());
		soapModel.setGiayToDinhKemHoSoId(model.getGiayToDinhKemHoSoId());
		soapModel.setHanhDong(model.getHanhDong());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNoiLuuTruTaiLieuId(model.getNoiLuuTruTaiLieuId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setTenTaiLieu(model.getTenTaiLieu());

		return soapModel;
	}

	public static LichSuGiayToDinhKemSoap[] toSoapModels(
		LichSuGiayToDinhKem[] models) {
		LichSuGiayToDinhKemSoap[] soapModels = new LichSuGiayToDinhKemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichSuGiayToDinhKemSoap[][] toSoapModels(
		LichSuGiayToDinhKem[][] models) {
		LichSuGiayToDinhKemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LichSuGiayToDinhKemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichSuGiayToDinhKemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichSuGiayToDinhKemSoap[] toSoapModels(
		List<LichSuGiayToDinhKem> models) {
		List<LichSuGiayToDinhKemSoap> soapModels = new ArrayList<LichSuGiayToDinhKemSoap>(models.size());

		for (LichSuGiayToDinhKem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LichSuGiayToDinhKemSoap[soapModels.size()]);
	}

	public LichSuGiayToDinhKemSoap() {
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

	public Long getGiayToDinhKemHoSoId() {
		return _giayToDinhKemHoSoId;
	}

	public void setGiayToDinhKemHoSoId(Long giayToDinhKemHoSoId) {
		_giayToDinhKemHoSoId = giayToDinhKemHoSoId;
	}

	public int getHanhDong() {
		return _hanhDong;
	}

	public void setHanhDong(int hanhDong) {
		_hanhDong = hanhDong;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public long getNoiLuuTruTaiLieuId() {
		return _noiLuuTruTaiLieuId;
	}

	public void setNoiLuuTruTaiLieuId(long noiLuuTruTaiLieuId) {
		_noiLuuTruTaiLieuId = noiLuuTruTaiLieuId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getTenTaiLieu() {
		return _tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		_tenTaiLieu = tenTaiLieu;
	}

	private long _id;
	private Long _giayToDinhKemHoSoId;
	private int _hanhDong;
	private String _nguoiTao;
	private long _noiLuuTruTaiLieuId;
	private Date _ngayTao;
	private String _tenTaiLieu;
}