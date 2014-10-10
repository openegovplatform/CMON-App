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

package org.oep.cmon.dao.dvc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    liemnn
 * @generated
 */
public class CapNhatKetQuaSoap implements Serializable {
	public static CapNhatKetQuaSoap toSoapModel(CapNhatKetQua model) {
		CapNhatKetQuaSoap soapModel = new CapNhatKetQuaSoap();

		soapModel.setId(model.getId());
		soapModel.setTenBang(model.getTenBang());
		soapModel.setBanGhiId(model.getBanGhiId());
		soapModel.setHanhDong(model.getHanhDong());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setHosoTTHCCId(model.getHosoTTHCCId());

		return soapModel;
	}

	public static CapNhatKetQuaSoap[] toSoapModels(CapNhatKetQua[] models) {
		CapNhatKetQuaSoap[] soapModels = new CapNhatKetQuaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CapNhatKetQuaSoap[][] toSoapModels(CapNhatKetQua[][] models) {
		CapNhatKetQuaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CapNhatKetQuaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CapNhatKetQuaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CapNhatKetQuaSoap[] toSoapModels(List<CapNhatKetQua> models) {
		List<CapNhatKetQuaSoap> soapModels = new ArrayList<CapNhatKetQuaSoap>(models.size());

		for (CapNhatKetQua model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CapNhatKetQuaSoap[soapModels.size()]);
	}

	public CapNhatKetQuaSoap() {
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

	public String getTenBang() {
		return _tenBang;
	}

	public void setTenBang(String tenBang) {
		_tenBang = tenBang;
	}

	public long getBanGhiId() {
		return _banGhiId;
	}

	public void setBanGhiId(long banGhiId) {
		_banGhiId = banGhiId;
	}

	public int getHanhDong() {
		return _hanhDong;
	}

	public void setHanhDong(int hanhDong) {
		_hanhDong = hanhDong;
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

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
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

	public long getHosoTTHCCId() {
		return _hosoTTHCCId;
	}

	public void setHosoTTHCCId(long hosoTTHCCId) {
		_hosoTTHCCId = hosoTTHCCId;
	}

	private long _id;
	private String _tenBang;
	private long _banGhiId;
	private int _hanhDong;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
	private long _hosoTTHCCId;
}