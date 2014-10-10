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

package org.oep.cmon.dao.hosohcc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.oep.cmon.dao.hosohcc.service.http.FileDinhKemServiceSoap}.
 *
 * @author    LIEMNn
 * @see       org.oep.cmon.dao.hosohcc.service.http.FileDinhKemServiceSoap
 * @generated
 */
public class FileDinhKemSoap implements Serializable {
	public static FileDinhKemSoap toSoapModel(FileDinhKem model) {
		FileDinhKemSoap soapModel = new FileDinhKemSoap();

		soapModel.setId(model.getId());
		soapModel.setSoBanGiay(model.getSoBanGiay());
		soapModel.setDaDoiChieu(model.getDaDoiChieu());
		soapModel.setTrangThaiHoSoTaiThoiDiemDinhKem(model.getTrangThaiHoSoTaiThoiDiemDinhKem());
		soapModel.setNoiLuuTruTaiLieuId(model.getNoiLuuTruTaiLieuId());
		soapModel.setCanBoId(model.getCanBoId());
		soapModel.setHoSoTTHCCongId(model.getHoSoTTHCCongId());
		soapModel.setThuTuc2GiayToId(model.getThuTuc2GiayToId());
		soapModel.setDanhMucGiayToId(model.getDanhMucGiayToId());
		soapModel.setNgayUpload(model.getNgayUpload());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiUpload(model.getNguoiUpload());
		soapModel.setMaLoaiTaiLieuDuocThayThe(model.getMaLoaiTaiLieuDuocThayThe());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setXoa(model.getXoa());
		soapModel.setDaTra(model.getDaTra());
		soapModel.setBanChinh(model.getBanChinh());
		soapModel.setGhiChu(model.getGhiChu());

		return soapModel;
	}

	public static FileDinhKemSoap[] toSoapModels(FileDinhKem[] models) {
		FileDinhKemSoap[] soapModels = new FileDinhKemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FileDinhKemSoap[][] toSoapModels(FileDinhKem[][] models) {
		FileDinhKemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FileDinhKemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FileDinhKemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FileDinhKemSoap[] toSoapModels(List<FileDinhKem> models) {
		List<FileDinhKemSoap> soapModels = new ArrayList<FileDinhKemSoap>(models.size());

		for (FileDinhKem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FileDinhKemSoap[soapModels.size()]);
	}

	public FileDinhKemSoap() {
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

	public long getSoBanGiay() {
		return _soBanGiay;
	}

	public void setSoBanGiay(long soBanGiay) {
		_soBanGiay = soBanGiay;
	}

	public int getDaDoiChieu() {
		return _daDoiChieu;
	}

	public void setDaDoiChieu(int daDoiChieu) {
		_daDoiChieu = daDoiChieu;
	}

	public int getTrangThaiHoSoTaiThoiDiemDinhKem() {
		return _trangThaiHoSoTaiThoiDiemDinhKem;
	}

	public void setTrangThaiHoSoTaiThoiDiemDinhKem(
		int trangThaiHoSoTaiThoiDiemDinhKem) {
		_trangThaiHoSoTaiThoiDiemDinhKem = trangThaiHoSoTaiThoiDiemDinhKem;
	}

	public Long getNoiLuuTruTaiLieuId() {
		return _noiLuuTruTaiLieuId;
	}

	public void setNoiLuuTruTaiLieuId(Long noiLuuTruTaiLieuId) {
		_noiLuuTruTaiLieuId = noiLuuTruTaiLieuId;
	}

	public Long getCanBoId() {
		return _canBoId;
	}

	public void setCanBoId(Long canBoId) {
		_canBoId = canBoId;
	}

	public Long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(Long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Long getThuTuc2GiayToId() {
		return _thuTuc2GiayToId;
	}

	public void setThuTuc2GiayToId(Long thuTuc2GiayToId) {
		_thuTuc2GiayToId = thuTuc2GiayToId;
	}

	public Long getDanhMucGiayToId() {
		return _danhMucGiayToId;
	}

	public void setDanhMucGiayToId(Long danhMucGiayToId) {
		_danhMucGiayToId = danhMucGiayToId;
	}

	public Date getNgayUpload() {
		return _ngayUpload;
	}

	public void setNgayUpload(Date ngayUpload) {
		_ngayUpload = ngayUpload;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public String getNguoiUpload() {
		return _nguoiUpload;
	}

	public void setNguoiUpload(String nguoiUpload) {
		_nguoiUpload = nguoiUpload;
	}

	public String getMaLoaiTaiLieuDuocThayThe() {
		return _maLoaiTaiLieuDuocThayThe;
	}

	public void setMaLoaiTaiLieuDuocThayThe(String maLoaiTaiLieuDuocThayThe) {
		_maLoaiTaiLieuDuocThayThe = maLoaiTaiLieuDuocThayThe;
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

	public int getDaTra() {
		return _daTra;
	}

	public void setDaTra(int daTra) {
		_daTra = daTra;
	}

	public long getBanChinh() {
		return _banChinh;
	}

	public void setBanChinh(long banChinh) {
		_banChinh = banChinh;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	private long _id;
	private long _soBanGiay;
	private int _daDoiChieu;
	private int _trangThaiHoSoTaiThoiDiemDinhKem;
	private Long _noiLuuTruTaiLieuId;
	private Long _canBoId;
	private Long _hoSoTTHCCongId;
	private Long _thuTuc2GiayToId;
	private Long _danhMucGiayToId;
	private Date _ngayUpload;
	private Date _ngaySua;
	private String _nguoiUpload;
	private String _maLoaiTaiLieuDuocThayThe;
	private String _nguoiSua;
	private int _xoa;
	private int _daTra;
	private long _banChinh;
	private String _ghiChu;
}