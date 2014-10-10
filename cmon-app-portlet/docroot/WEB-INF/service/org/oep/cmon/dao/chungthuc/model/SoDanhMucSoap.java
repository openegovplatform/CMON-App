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
public class SoDanhMucSoap implements Serializable {
	public static SoDanhMucSoap toSoapModel(SoDanhMuc model) {
		SoDanhMucSoap soapModel = new SoDanhMucSoap();

		soapModel.setId(model.getId());
		soapModel.setTenSo(model.getTenSo());
		soapModel.setSoSo(model.getSoSo());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setNam(model.getNam());
		soapModel.setTheoQuyetDinh(model.getTheoQuyetDinh());
		soapModel.setCoQuanQuanLiId(model.getCoQuanQuanLiId());

		return soapModel;
	}

	public static SoDanhMucSoap[] toSoapModels(SoDanhMuc[] models) {
		SoDanhMucSoap[] soapModels = new SoDanhMucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SoDanhMucSoap[][] toSoapModels(SoDanhMuc[][] models) {
		SoDanhMucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SoDanhMucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SoDanhMucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SoDanhMucSoap[] toSoapModels(List<SoDanhMuc> models) {
		List<SoDanhMucSoap> soapModels = new ArrayList<SoDanhMucSoap>(models.size());

		for (SoDanhMuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SoDanhMucSoap[soapModels.size()]);
	}

	public SoDanhMucSoap() {
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

	public String getTenSo() {
		return _tenSo;
	}

	public void setTenSo(String tenSo) {
		_tenSo = tenSo;
	}

	public String getSoSo() {
		return _soSo;
	}

	public void setSoSo(String soSo) {
		_soSo = soSo;
	}

	public Long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(Long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public Long getNam() {
		return _nam;
	}

	public void setNam(Long nam) {
		_nam = nam;
	}

	public String getTheoQuyetDinh() {
		return _theoQuyetDinh;
	}

	public void setTheoQuyetDinh(String theoQuyetDinh) {
		_theoQuyetDinh = theoQuyetDinh;
	}

	public Long getCoQuanQuanLiId() {
		return _coQuanQuanLiId;
	}

	public void setCoQuanQuanLiId(Long coQuanQuanLiId) {
		_coQuanQuanLiId = coQuanQuanLiId;
	}

	private long _id;
	private String _tenSo;
	private String _soSo;
	private Long _thuTucHanhChinhId;
	private Long _nam;
	private String _theoQuyetDinh;
	private Long _coQuanQuanLiId;
}