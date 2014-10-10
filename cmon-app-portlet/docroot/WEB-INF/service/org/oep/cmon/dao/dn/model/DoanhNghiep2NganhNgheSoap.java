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

package org.oep.cmon.dao.dn.model;

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
public class DoanhNghiep2NganhNgheSoap implements Serializable {
	public static DoanhNghiep2NganhNgheSoap toSoapModel(
		DoanhNghiep2NganhNghe model) {
		DoanhNghiep2NganhNgheSoap soapModel = new DoanhNghiep2NganhNgheSoap();

		soapModel.setId(model.getId());
		soapModel.setLaNganhChinh(model.getLaNganhChinh());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setDoanhNghiepId(model.getDoanhNghiepId());
		soapModel.setNganhNgheId(model.getNganhNgheId());

		return soapModel;
	}

	public static DoanhNghiep2NganhNgheSoap[] toSoapModels(
		DoanhNghiep2NganhNghe[] models) {
		DoanhNghiep2NganhNgheSoap[] soapModels = new DoanhNghiep2NganhNgheSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DoanhNghiep2NganhNgheSoap[][] toSoapModels(
		DoanhNghiep2NganhNghe[][] models) {
		DoanhNghiep2NganhNgheSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DoanhNghiep2NganhNgheSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DoanhNghiep2NganhNgheSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DoanhNghiep2NganhNgheSoap[] toSoapModels(
		List<DoanhNghiep2NganhNghe> models) {
		List<DoanhNghiep2NganhNgheSoap> soapModels = new ArrayList<DoanhNghiep2NganhNgheSoap>(models.size());

		for (DoanhNghiep2NganhNghe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DoanhNghiep2NganhNgheSoap[soapModels.size()]);
	}

	public DoanhNghiep2NganhNgheSoap() {
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

	public int getLaNganhChinh() {
		return _laNganhChinh;
	}

	public void setLaNganhChinh(int laNganhChinh) {
		_laNganhChinh = laNganhChinh;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public long getDoanhNghiepId() {
		return _doanhNghiepId;
	}

	public void setDoanhNghiepId(long doanhNghiepId) {
		_doanhNghiepId = doanhNghiepId;
	}

	public long getNganhNgheId() {
		return _nganhNgheId;
	}

	public void setNganhNgheId(long nganhNgheId) {
		_nganhNgheId = nganhNgheId;
	}

	private long _id;
	private int _laNganhChinh;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _daXoa;
	private long _doanhNghiepId;
	private long _nganhNgheId;
}