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

package org.oep.cmon.dao.kios.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    VIENPN
 * @generated
 */
public class DanhSachCoQuanSoap implements Serializable {
	public static DanhSachCoQuanSoap toSoapModel(DanhSachCoQuan model) {
		DanhSachCoQuanSoap soapModel = new DanhSachCoQuanSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setChaId(model.getChaId());
		soapModel.setTenCapCoQuanQuanly(model.getTenCapCoQuanQuanly());
		soapModel.setCapCoQuanQuanLyId(model.getCapCoQuanQuanLyId());

		return soapModel;
	}

	public static DanhSachCoQuanSoap[] toSoapModels(DanhSachCoQuan[] models) {
		DanhSachCoQuanSoap[] soapModels = new DanhSachCoQuanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DanhSachCoQuanSoap[][] toSoapModels(DanhSachCoQuan[][] models) {
		DanhSachCoQuanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DanhSachCoQuanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DanhSachCoQuanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DanhSachCoQuanSoap[] toSoapModels(List<DanhSachCoQuan> models) {
		List<DanhSachCoQuanSoap> soapModels = new ArrayList<DanhSachCoQuanSoap>(models.size());

		for (DanhSachCoQuan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DanhSachCoQuanSoap[soapModels.size()]);
	}

	public DanhSachCoQuanSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getTenCapCoQuanQuanly() {
		return _tenCapCoQuanQuanly;
	}

	public void setTenCapCoQuanQuanly(String tenCapCoQuanQuanly) {
		_tenCapCoQuanQuanly = tenCapCoQuanQuanly;
	}

	public Long getCapCoQuanQuanLyId() {
		return _capCoQuanQuanLyId;
	}

	public void setCapCoQuanQuanLyId(Long capCoQuanQuanLyId) {
		_capCoQuanQuanLyId = capCoQuanQuanLyId;
	}

	private long _id;
	private String _ten;
	private Long _chaId;
	private String _tenCapCoQuanQuanly;
	private Long _capCoQuanQuanLyId;
}