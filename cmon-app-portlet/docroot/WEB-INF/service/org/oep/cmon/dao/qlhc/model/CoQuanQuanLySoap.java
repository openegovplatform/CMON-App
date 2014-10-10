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
public class CoQuanQuanLySoap implements Serializable {
	public static CoQuanQuanLySoap toSoapModel(CoQuanQuanLy model) {
		CoQuanQuanLySoap soapModel = new CoQuanQuanLySoap();

		soapModel.setId(model.getId());
		soapModel.setMa(model.getMa());
		soapModel.setTen(model.getTen());
		soapModel.setDiaChi(model.getDiaChi());
		soapModel.setDienThoai(model.getDienThoai());
		soapModel.setEmail(model.getEmail());
		soapModel.setFax(model.getFax());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setNoiBo(model.getNoiBo());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setDonViHanhChinhId(model.getDonViHanhChinhId());
		soapModel.setCapCoQuanQuanlyId(model.getCapCoQuanQuanlyId());
		soapModel.setChaId(model.getChaId());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setMerchant(model.getMerchant());
		soapModel.setAccessCode(model.getAccessCode());
		soapModel.setSecureSecret(model.getSecureSecret());
		soapModel.setMaCapSoBienNhan(model.getMaCapSoBienNhan());

		return soapModel;
	}

	public static CoQuanQuanLySoap[] toSoapModels(CoQuanQuanLy[] models) {
		CoQuanQuanLySoap[] soapModels = new CoQuanQuanLySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CoQuanQuanLySoap[][] toSoapModels(CoQuanQuanLy[][] models) {
		CoQuanQuanLySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CoQuanQuanLySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CoQuanQuanLySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CoQuanQuanLySoap[] toSoapModels(List<CoQuanQuanLy> models) {
		List<CoQuanQuanLySoap> soapModels = new ArrayList<CoQuanQuanLySoap>(models.size());

		for (CoQuanQuanLy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CoQuanQuanLySoap[soapModels.size()]);
	}

	public CoQuanQuanLySoap() {
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

	public String getDiaChi() {
		return _diaChi;
	}

	public void setDiaChi(String diaChi) {
		_diaChi = diaChi;
	}

	public String getDienThoai() {
		return _dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		_dienThoai = dienThoai;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getFax() {
		return _fax;
	}

	public void setFax(String fax) {
		_fax = fax;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public int getNoiBo() {
		return _noiBo;
	}

	public void setNoiBo(int noiBo) {
		_noiBo = noiBo;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	public Long getDonViHanhChinhId() {
		return _donViHanhChinhId;
	}

	public void setDonViHanhChinhId(Long donViHanhChinhId) {
		_donViHanhChinhId = donViHanhChinhId;
	}

	public Long getCapCoQuanQuanlyId() {
		return _capCoQuanQuanlyId;
	}

	public void setCapCoQuanQuanlyId(Long capCoQuanQuanlyId) {
		_capCoQuanQuanlyId = capCoQuanQuanlyId;
	}

	public Long getChaId() {
		return _chaId;
	}

	public void setChaId(Long chaId) {
		_chaId = chaId;
	}

	public String getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public String getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(String nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getMerchant() {
		return _merchant;
	}

	public void setMerchant(String merchant) {
		_merchant = merchant;
	}

	public String getAccessCode() {
		return _accessCode;
	}

	public void setAccessCode(String accessCode) {
		_accessCode = accessCode;
	}

	public String getSecureSecret() {
		return _secureSecret;
	}

	public void setSecureSecret(String secureSecret) {
		_secureSecret = secureSecret;
	}

	public String getMaCapSoBienNhan() {
		return _maCapSoBienNhan;
	}

	public void setMaCapSoBienNhan(String maCapSoBienNhan) {
		_maCapSoBienNhan = maCapSoBienNhan;
	}

	private long _id;
	private String _ma;
	private String _ten;
	private String _diaChi;
	private String _dienThoai;
	private String _email;
	private String _fax;
	private String _website;
	private int _noiBo;
	private long _phienBan;
	private int _daXoa;
	private Long _donViHanhChinhId;
	private Long _capCoQuanQuanlyId;
	private Long _chaId;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private String _merchant;
	private String _accessCode;
	private String _secureSecret;
	private String _maCapSoBienNhan;
}