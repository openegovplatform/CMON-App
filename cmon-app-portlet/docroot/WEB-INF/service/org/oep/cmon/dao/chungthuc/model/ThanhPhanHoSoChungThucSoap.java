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

package org.oep.cmon.dao.chungthuc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    vietho
 * @generated
 */
public class ThanhPhanHoSoChungThucSoap implements Serializable {
	public static ThanhPhanHoSoChungThucSoap toSoapModel(
		ThanhPhanHoSoChungThuc model) {
		ThanhPhanHoSoChungThucSoap soapModel = new ThanhPhanHoSoChungThucSoap();

		soapModel.setThanhPhanHoSoId(model.getThanhPhanHoSoId());
		soapModel.setTieuDe(model.getTieuDe());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setHoSoChungThucId(model.getHoSoChungThucId());
		soapModel.setThuTuc2GiayToId(model.getThuTuc2GiayToId());
		soapModel.setNoiLuuTruHoSoDinhKemId(model.getNoiLuuTruHoSoDinhKemId());

		return soapModel;
	}

	public static ThanhPhanHoSoChungThucSoap[] toSoapModels(
		ThanhPhanHoSoChungThuc[] models) {
		ThanhPhanHoSoChungThucSoap[] soapModels = new ThanhPhanHoSoChungThucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThanhPhanHoSoChungThucSoap[][] toSoapModels(
		ThanhPhanHoSoChungThuc[][] models) {
		ThanhPhanHoSoChungThucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThanhPhanHoSoChungThucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThanhPhanHoSoChungThucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThanhPhanHoSoChungThucSoap[] toSoapModels(
		List<ThanhPhanHoSoChungThuc> models) {
		List<ThanhPhanHoSoChungThucSoap> soapModels = new ArrayList<ThanhPhanHoSoChungThucSoap>(models.size());

		for (ThanhPhanHoSoChungThuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThanhPhanHoSoChungThucSoap[soapModels.size()]);
	}

	public ThanhPhanHoSoChungThucSoap() {
	}

	public long getPrimaryKey() {
		return _thanhPhanHoSoId;
	}

	public void setPrimaryKey(long pk) {
		setThanhPhanHoSoId(pk);
	}

	public long getThanhPhanHoSoId() {
		return _thanhPhanHoSoId;
	}

	public void setThanhPhanHoSoId(long thanhPhanHoSoId) {
		_thanhPhanHoSoId = thanhPhanHoSoId;
	}

	public String getTieuDe() {
		return _tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		_tieuDe = tieuDe;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public Long getHoSoChungThucId() {
		return _hoSoChungThucId;
	}

	public void setHoSoChungThucId(Long hoSoChungThucId) {
		_hoSoChungThucId = hoSoChungThucId;
	}

	public Long getThuTuc2GiayToId() {
		return _thuTuc2GiayToId;
	}

	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		_thuTuc2GiayToId = thuTuc2GiayToId;
	}

	public Long getNoiLuuTruHoSoDinhKemId() {
		return _noiLuuTruHoSoDinhKemId;
	}

	public void setNoiLuuTruHoSoDinhKemId(Long noiLuuTruHoSoDinhKemId) {
		_noiLuuTruHoSoDinhKemId = noiLuuTruHoSoDinhKemId;
	}

	private long _thanhPhanHoSoId;
	private String _tieuDe;
	private String _moTa;
	private Long _hoSoChungThucId;
	private Long _thuTuc2GiayToId;
	private Long _noiLuuTruHoSoDinhKemId;
}