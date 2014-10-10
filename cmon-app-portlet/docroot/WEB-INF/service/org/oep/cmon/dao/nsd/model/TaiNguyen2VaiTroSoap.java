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
public class TaiNguyen2VaiTroSoap implements Serializable {
	public static TaiNguyen2VaiTroSoap toSoapModel(TaiNguyen2VaiTro model) {
		TaiNguyen2VaiTroSoap soapModel = new TaiNguyen2VaiTroSoap();

		soapModel.setId(model.getId());
		soapModel.setTaiNguyenId(model.getTaiNguyenId());
		soapModel.setVaiTroId(model.getVaiTroId());
		soapModel.setHanhDong(model.getHanhDong());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static TaiNguyen2VaiTroSoap[] toSoapModels(TaiNguyen2VaiTro[] models) {
		TaiNguyen2VaiTroSoap[] soapModels = new TaiNguyen2VaiTroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaiNguyen2VaiTroSoap[][] toSoapModels(
		TaiNguyen2VaiTro[][] models) {
		TaiNguyen2VaiTroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaiNguyen2VaiTroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaiNguyen2VaiTroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaiNguyen2VaiTroSoap[] toSoapModels(
		List<TaiNguyen2VaiTro> models) {
		List<TaiNguyen2VaiTroSoap> soapModels = new ArrayList<TaiNguyen2VaiTroSoap>(models.size());

		for (TaiNguyen2VaiTro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaiNguyen2VaiTroSoap[soapModels.size()]);
	}

	public TaiNguyen2VaiTroSoap() {
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

	public Long getTaiNguyenId() {
		return _taiNguyenId;
	}

	public void setTaiNguyenId(Long taiNguyenId) {
		_taiNguyenId = taiNguyenId;
	}

	public Long getVaiTroId() {
		return _vaiTroId;
	}

	public void setVaiTroId(Long vaiTroId) {
		_vaiTroId = vaiTroId;
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

	private long _id;
	private Long _taiNguyenId;
	private Long _vaiTroId;
	private int _hanhDong;
	private Date _ngayTao;
	private String _nguoiTao;
	private Date _ngaySua;
	private String _nguoiSua;
	private int _daXoa;
}