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

package org.oep.cmon.dao.nsd.model;

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
public class NguoiDung2VaiTroSoap implements Serializable {
	public static NguoiDung2VaiTroSoap toSoapModel(NguoiDung2VaiTro model) {
		NguoiDung2VaiTroSoap soapModel = new NguoiDung2VaiTroSoap();

		soapModel.setId(model.getId());
		soapModel.setVaiTroId(model.getVaiTroId());
		soapModel.setTaiKhoanNguoiDungId(model.getTaiKhoanNguoiDungId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static NguoiDung2VaiTroSoap[] toSoapModels(NguoiDung2VaiTro[] models) {
		NguoiDung2VaiTroSoap[] soapModels = new NguoiDung2VaiTroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NguoiDung2VaiTroSoap[][] toSoapModels(
		NguoiDung2VaiTro[][] models) {
		NguoiDung2VaiTroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NguoiDung2VaiTroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NguoiDung2VaiTroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NguoiDung2VaiTroSoap[] toSoapModels(
		List<NguoiDung2VaiTro> models) {
		List<NguoiDung2VaiTroSoap> soapModels = new ArrayList<NguoiDung2VaiTroSoap>(models.size());

		for (NguoiDung2VaiTro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NguoiDung2VaiTroSoap[soapModels.size()]);
	}

	public NguoiDung2VaiTroSoap() {
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

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
	}

	public Long getTaiKhoanNguoiDungId() {
		return _taiKhoanNguoiDungId;
	}

	public void setTaiKhoanNguoiDungId(Long taiKhoanNguoiDungId) {
		_taiKhoanNguoiDungId = taiKhoanNguoiDungId;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	private long _id;
	private Long _vaiTroId;
	private Long _taiKhoanNguoiDungId;
	private Date _ngayTao;
	private String _nguoiTao;
	private int _daXoa;
}