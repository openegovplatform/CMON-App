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

package org.oep.cmon.dao.qlhc.model;

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
public class ChucVu2VaiTroSoap implements Serializable {
	public static ChucVu2VaiTroSoap toSoapModel(ChucVu2VaiTro model) {
		ChucVu2VaiTroSoap soapModel = new ChucVu2VaiTroSoap();

		soapModel.setId(model.getId());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setVaiTroId(model.getVaiTroId());
		soapModel.setCoQuanQuanLyId(model.getCoQuanQuanLyId());
		soapModel.setChucVuId(model.getChucVuId());

		return soapModel;
	}

	public static ChucVu2VaiTroSoap[] toSoapModels(ChucVu2VaiTro[] models) {
		ChucVu2VaiTroSoap[] soapModels = new ChucVu2VaiTroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChucVu2VaiTroSoap[][] toSoapModels(ChucVu2VaiTro[][] models) {
		ChucVu2VaiTroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChucVu2VaiTroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChucVu2VaiTroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChucVu2VaiTroSoap[] toSoapModels(List<ChucVu2VaiTro> models) {
		List<ChucVu2VaiTroSoap> soapModels = new ArrayList<ChucVu2VaiTroSoap>(models.size());

		for (ChucVu2VaiTro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChucVu2VaiTroSoap[soapModels.size()]);
	}

	public ChucVu2VaiTroSoap() {
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

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
	}

	public Long getCoQuanQuanLyId() {
		return _coQuanQuanLyId;
	}

	public void setCoQuanQuanLyId(Long coQuanQuanLyId) {
		_coQuanQuanLyId = coQuanQuanLyId;
	}

	public Long getChucVuId() {
		return _chucVuId;
	}

	public void setChucVuId(Long chucVuId) {
		_chucVuId = chucVuId;
	}

	private long _id;
	private Date _ngayTao;
	private Date _ngaySua;
	private int _daXoa;
	private String _nguoiTao;
	private String _nguoiSua;
	private Long _vaiTroId;
	private Long _coQuanQuanLyId;
	private Long _chucVuId;
}