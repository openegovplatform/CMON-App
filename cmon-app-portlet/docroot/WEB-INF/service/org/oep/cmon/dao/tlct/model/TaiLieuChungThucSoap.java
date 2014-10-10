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

package org.oep.cmon.dao.tlct.model;

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
public class TaiLieuChungThucSoap implements Serializable {
	public static TaiLieuChungThucSoap toSoapModel(TaiLieuChungThuc model) {
		TaiLieuChungThucSoap soapModel = new TaiLieuChungThucSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setNoiLuuTruId(model.getNoiLuuTruId());
		soapModel.setNgayUpload(model.getNgayUpload());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setNgayDuyet(model.getNgayDuyet());
		soapModel.setHieuLucTuNgay(model.getHieuLucTuNgay());
		soapModel.setHieuLucDenNgay(model.getHieuLucDenNgay());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setDanhMucGiayToId(model.getDanhMucGiayToId());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setChuSohuuId(model.getChuSohuuId());
		soapModel.setNguoiUploadId(model.getNguoiUploadId());
		soapModel.setNguoiduyetId(model.getNguoiduyetId());
		soapModel.setHoSoTTHCCId(model.getHoSoTTHCCId());
		soapModel.setMaUngDung(model.getMaUngDung());
		soapModel.setLoai(model.getLoai());

		return soapModel;
	}

	public static TaiLieuChungThucSoap[] toSoapModels(TaiLieuChungThuc[] models) {
		TaiLieuChungThucSoap[] soapModels = new TaiLieuChungThucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaiLieuChungThucSoap[][] toSoapModels(
		TaiLieuChungThuc[][] models) {
		TaiLieuChungThucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaiLieuChungThucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaiLieuChungThucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaiLieuChungThucSoap[] toSoapModels(
		List<TaiLieuChungThuc> models) {
		List<TaiLieuChungThucSoap> soapModels = new ArrayList<TaiLieuChungThucSoap>(models.size());

		for (TaiLieuChungThuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaiLieuChungThucSoap[soapModels.size()]);
	}

	public TaiLieuChungThucSoap() {
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

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public long getNoiLuuTruId() {
		return _noiLuuTruId;
	}

	public void setNoiLuuTruId(long noiLuuTruId) {
		_noiLuuTruId = noiLuuTruId;
	}

	public Date getNgayUpload() {
		return _ngayUpload;
	}

	public void setNgayUpload(Date ngayUpload) {
		_ngayUpload = ngayUpload;
	}

	public int getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(int phienBan) {
		_phienBan = phienBan;
	}

	public Date getNgayDuyet() {
		return _ngayDuyet;
	}

	public void setNgayDuyet(Date ngayDuyet) {
		_ngayDuyet = ngayDuyet;
	}

	public Date getHieuLucTuNgay() {
		return _hieuLucTuNgay;
	}

	public void setHieuLucTuNgay(Date hieuLucTuNgay) {
		_hieuLucTuNgay = hieuLucTuNgay;
	}

	public Date getHieuLucDenNgay() {
		return _hieuLucDenNgay;
	}

	public void setHieuLucDenNgay(Date hieuLucDenNgay) {
		_hieuLucDenNgay = hieuLucDenNgay;
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

	public Long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(Long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public int getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(int trangThai) {
		_trangThai = trangThai;
	}

	public Long getChuSohuuId() {
		return _chuSohuuId;
	}

	public void setChuSohuuId(Long chuSohuuId) {
		_chuSohuuId = chuSohuuId;
	}

	public Long getNguoiUploadId() {
		return _nguoiUploadId;
	}

	public void setNguoiUploadId(Long nguoiUploadId) {
		_nguoiUploadId = nguoiUploadId;
	}

	public Long getNguoiduyetId() {
		return _nguoiduyetId;
	}

	public void setNguoiduyetId(Long nguoiduyetId) {
		_nguoiduyetId = nguoiduyetId;
	}

	public Long getHoSoTTHCCId() {
		return _hoSoTTHCCId;
	}

	public void setHoSoTTHCCId(Long hoSoTTHCCId) {
		_hoSoTTHCCId = hoSoTTHCCId;
	}

	public String getMaUngDung() {
		return _maUngDung;
	}

	public void setMaUngDung(String maUngDung) {
		_maUngDung = maUngDung;
	}

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	private long _id;
	private String _ten;
	private String _ghiChu;
	private long _noiLuuTruId;
	private Date _ngayUpload;
	private int _phienBan;
	private Date _ngayDuyet;
	private Date _hieuLucTuNgay;
	private Date _hieuLucDenNgay;
	private Date _ngaySua;
	private String _nguoiSua;
	private Long _danhMucGiayToId;
	private int _trangThai;
	private Long _chuSohuuId;
	private Long _nguoiUploadId;
	private Long _nguoiduyetId;
	private Long _hoSoTTHCCId;
	private String _maUngDung;
	private int _loai;
}