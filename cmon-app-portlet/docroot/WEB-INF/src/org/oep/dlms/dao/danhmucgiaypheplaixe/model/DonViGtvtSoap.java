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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    AnhNT
 * @generated
 */
public class DonViGtvtSoap implements Serializable {
	public static DonViGtvtSoap toSoapModel(DonViGtvt model) {
		DonViGtvtSoap soapModel = new DonViGtvtSoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setCoQuanQl(model.getCoQuanQl());
		soapModel.setDienThoai(model.getDienThoai());
		soapModel.setFax(model.getFax());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setLanhDao(model.getLanhDao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());

		return soapModel;
	}

	public static DonViGtvtSoap[] toSoapModels(DonViGtvt[] models) {
		DonViGtvtSoap[] soapModels = new DonViGtvtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DonViGtvtSoap[][] toSoapModels(DonViGtvt[][] models) {
		DonViGtvtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DonViGtvtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DonViGtvtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DonViGtvtSoap[] toSoapModels(List<DonViGtvt> models) {
		List<DonViGtvtSoap> soapModels = new ArrayList<DonViGtvtSoap>(models.size());

		for (DonViGtvt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DonViGtvtSoap[soapModels.size()]);
	}

	public DonViGtvtSoap() {
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

	public String getMa() {
		return _ma;
	}

	public void setMa(String ma) {
		_ma = ma;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getCoQuanQl() {
		return _coQuanQl;
	}

	public void setCoQuanQl(String coQuanQl) {
		_coQuanQl = coQuanQl;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public String getLanhDao() {
		return _lanhDao;
	}

	public void setLanhDao(String lanhDao) {
		_lanhDao = lanhDao;
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

	public int getXoa() {
		return _xoa;
	}

	public void setXoa(int xoa) {
		_xoa = xoa;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _coQuanQl;
	private String _dienThoai;
	private String _fax;
	private String _diaChi;
	private String _lanhDao;
	private Date _ngayTao;
	private Date _ngaySua;
	private String _nguoiTao;
	private String _nguoiSua;
	private int _xoa;
}