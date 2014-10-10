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

package org.oep.cmon.dao.hosolienthong.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    hoangtrung.nguyen
 * @generated
 */
public class HoSoLienThongSoap implements Serializable {
	public static HoSoLienThongSoap toSoapModel(HoSoLienThong model) {
		HoSoLienThongSoap soapModel = new HoSoLienThongSoap();

		soapModel.setId(model.getId());
		soapModel.setHoSoId(model.getHoSoId());
		soapModel.setCoQuanGuiId(model.getCoQuanGuiId());
		soapModel.setCoQuanNhanId(model.getCoQuanNhanId());
		soapModel.setThuTucGuiId(model.getThuTucGuiId());
		soapModel.setThuTucNhanId(model.getThuTucNhanId());
		soapModel.setMaSoBienNhanLucGui(model.getMaSoBienNhanLucGui());
		soapModel.setMaSoBienNhanLucNhan(model.getMaSoBienNhanLucNhan());
		soapModel.setCanBoGuiId(model.getCanBoGuiId());
		soapModel.setCanBoNhanId(model.getCanBoNhanId());
		soapModel.setNgayGui(model.getNgayGui());
		soapModel.setNgayNhan(model.getNgayNhan());
		soapModel.setHoTenCanBoGui(model.getHoTenCanBoGui());
		soapModel.setHoTenCanBoNhan(model.getHoTenCanBoNhan());
		soapModel.setCanBoNopHoSoGiayId(model.getCanBoNopHoSoGiayId());
		soapModel.setHoTenCanBoNopHoSoGiay(model.getHoTenCanBoNopHoSoGiay());
		soapModel.setTrangThaiLienThong(model.getTrangThaiLienThong());
		soapModel.setGhiChuGuiLienThong(model.getGhiChuGuiLienThong());
		soapModel.setHoTenCongDanNop(model.getHoTenCongDanNop());
		soapModel.setDiaChiDayDuCongDanNop(model.getDiaChiDayDuCongDanNop());
		soapModel.setNgayTuChoi(model.getNgayTuChoi());
		soapModel.setNgayNoiNhanTraKetQua(model.getNgayNoiNhanTraKetQua());
		soapModel.setNgayNoiGuiNhanKetQua(model.getNgayNoiGuiNhanKetQua());
		soapModel.setCanBoTiepNhanNoiGuiId(model.getCanBoTiepNhanNoiGuiId());
		soapModel.setHoTenCanBoTiepNhanNoiGui(model.getHoTenCanBoTiepNhanNoiGui());
		soapModel.setTenCoQuanGui(model.getTenCoQuanGui());
		soapModel.setTenThuTucGui(model.getTenThuTucGui());
		soapModel.setTenCoQuanNhan(model.getTenCoQuanNhan());
		soapModel.setTenThuTucNhan(model.getTenThuTucNhan());
		soapModel.setThuTuLienThong(model.getThuTuLienThong());
		soapModel.setNgayNoiNhanHenTra(model.getNgayNoiNhanHenTra());
		soapModel.setSoNgayNoiNhanXuLyDuKien(model.getSoNgayNoiNhanXuLyDuKien());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setDaXoa(model.getDaXoa());

		return soapModel;
	}

	public static HoSoLienThongSoap[] toSoapModels(HoSoLienThong[] models) {
		HoSoLienThongSoap[] soapModels = new HoSoLienThongSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoLienThongSoap[][] toSoapModels(HoSoLienThong[][] models) {
		HoSoLienThongSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoLienThongSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoLienThongSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoLienThongSoap[] toSoapModels(List<HoSoLienThong> models) {
		List<HoSoLienThongSoap> soapModels = new ArrayList<HoSoLienThongSoap>(models.size());

		for (HoSoLienThong model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoLienThongSoap[soapModels.size()]);
	}

	public HoSoLienThongSoap() {
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

	public long getHoSoId() {
		return _hoSoId;
	}

	public void setHoSoId(long hoSoId) {
		_hoSoId = hoSoId;
	}

	public long getCoQuanGuiId() {
		return _coQuanGuiId;
	}

	public void setCoQuanGuiId(long coQuanGuiId) {
		_coQuanGuiId = coQuanGuiId;
	}

	public long getCoQuanNhanId() {
		return _coQuanNhanId;
	}

	public void setCoQuanNhanId(long coQuanNhanId) {
		_coQuanNhanId = coQuanNhanId;
	}

	public long getThuTucGuiId() {
		return _thuTucGuiId;
	}

	public void setThuTucGuiId(long thuTucGuiId) {
		_thuTucGuiId = thuTucGuiId;
	}

	public long getThuTucNhanId() {
		return _thuTucNhanId;
	}

	public void setThuTucNhanId(long thuTucNhanId) {
		_thuTucNhanId = thuTucNhanId;
	}

	public String getMaSoBienNhanLucGui() {
		return _maSoBienNhanLucGui;
	}

	public void setMaSoBienNhanLucGui(String maSoBienNhanLucGui) {
		_maSoBienNhanLucGui = maSoBienNhanLucGui;
	}

	public String getMaSoBienNhanLucNhan() {
		return _maSoBienNhanLucNhan;
	}

	public void setMaSoBienNhanLucNhan(String maSoBienNhanLucNhan) {
		_maSoBienNhanLucNhan = maSoBienNhanLucNhan;
	}

	public long getCanBoGuiId() {
		return _canBoGuiId;
	}

	public void setCanBoGuiId(long canBoGuiId) {
		_canBoGuiId = canBoGuiId;
	}

	public Long getCanBoNhanId() {
		return _canBoNhanId;
	}

	public void setCanBoNhanId(Long canBoNhanId) {
		_canBoNhanId = canBoNhanId;
	}

	public Date getNgayGui() {
		return _ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		_ngayGui = ngayGui;
	}

	public Date getNgayNhan() {
		return _ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		_ngayNhan = ngayNhan;
	}

	public String getHoTenCanBoGui() {
		return _hoTenCanBoGui;
	}

	public void setHoTenCanBoGui(String hoTenCanBoGui) {
		_hoTenCanBoGui = hoTenCanBoGui;
	}

	public String getHoTenCanBoNhan() {
		return _hoTenCanBoNhan;
	}

	public void setHoTenCanBoNhan(String hoTenCanBoNhan) {
		_hoTenCanBoNhan = hoTenCanBoNhan;
	}

	public Long getCanBoNopHoSoGiayId() {
		return _canBoNopHoSoGiayId;
	}

	public void setCanBoNopHoSoGiayId(Long canBoNopHoSoGiayId) {
		_canBoNopHoSoGiayId = canBoNopHoSoGiayId;
	}

	public String getHoTenCanBoNopHoSoGiay() {
		return _hoTenCanBoNopHoSoGiay;
	}

	public void setHoTenCanBoNopHoSoGiay(String hoTenCanBoNopHoSoGiay) {
		_hoTenCanBoNopHoSoGiay = hoTenCanBoNopHoSoGiay;
	}

	public int getTrangThaiLienThong() {
		return _trangThaiLienThong;
	}

	public void setTrangThaiLienThong(int trangThaiLienThong) {
		_trangThaiLienThong = trangThaiLienThong;
	}

	public String getGhiChuGuiLienThong() {
		return _ghiChuGuiLienThong;
	}

	public void setGhiChuGuiLienThong(String ghiChuGuiLienThong) {
		_ghiChuGuiLienThong = ghiChuGuiLienThong;
	}

	public String getHoTenCongDanNop() {
		return _hoTenCongDanNop;
	}

	public void setHoTenCongDanNop(String hoTenCongDanNop) {
		_hoTenCongDanNop = hoTenCongDanNop;
	}

	public String getDiaChiDayDuCongDanNop() {
		return _diaChiDayDuCongDanNop;
	}

	public void setDiaChiDayDuCongDanNop(String diaChiDayDuCongDanNop) {
		_diaChiDayDuCongDanNop = diaChiDayDuCongDanNop;
	}

	public Date getNgayTuChoi() {
		return _ngayTuChoi;
	}

	public void setNgayTuChoi(Date ngayTuChoi) {
		_ngayTuChoi = ngayTuChoi;
	}

	public Date getNgayNoiNhanTraKetQua() {
		return _ngayNoiNhanTraKetQua;
	}

	public void setNgayNoiNhanTraKetQua(Date ngayNoiNhanTraKetQua) {
		_ngayNoiNhanTraKetQua = ngayNoiNhanTraKetQua;
	}

	public Date getNgayNoiGuiNhanKetQua() {
		return _ngayNoiGuiNhanKetQua;
	}

	public void setNgayNoiGuiNhanKetQua(Date ngayNoiGuiNhanKetQua) {
		_ngayNoiGuiNhanKetQua = ngayNoiGuiNhanKetQua;
	}

	public long getCanBoTiepNhanNoiGuiId() {
		return _canBoTiepNhanNoiGuiId;
	}

	public void setCanBoTiepNhanNoiGuiId(long canBoTiepNhanNoiGuiId) {
		_canBoTiepNhanNoiGuiId = canBoTiepNhanNoiGuiId;
	}

	public String getHoTenCanBoTiepNhanNoiGui() {
		return _hoTenCanBoTiepNhanNoiGui;
	}

	public void setHoTenCanBoTiepNhanNoiGui(String hoTenCanBoTiepNhanNoiGui) {
		_hoTenCanBoTiepNhanNoiGui = hoTenCanBoTiepNhanNoiGui;
	}

	public String getTenCoQuanGui() {
		return _tenCoQuanGui;
	}

	public void setTenCoQuanGui(String tenCoQuanGui) {
		_tenCoQuanGui = tenCoQuanGui;
	}

	public String getTenThuTucGui() {
		return _tenThuTucGui;
	}

	public void setTenThuTucGui(String tenThuTucGui) {
		_tenThuTucGui = tenThuTucGui;
	}

	public String getTenCoQuanNhan() {
		return _tenCoQuanNhan;
	}

	public void setTenCoQuanNhan(String tenCoQuanNhan) {
		_tenCoQuanNhan = tenCoQuanNhan;
	}

	public String getTenThuTucNhan() {
		return _tenThuTucNhan;
	}

	public void setTenThuTucNhan(String tenThuTucNhan) {
		_tenThuTucNhan = tenThuTucNhan;
	}

	public int getThuTuLienThong() {
		return _thuTuLienThong;
	}

	public void setThuTuLienThong(int thuTuLienThong) {
		_thuTuLienThong = thuTuLienThong;
	}

	public Date getNgayNoiNhanHenTra() {
		return _ngayNoiNhanHenTra;
	}

	public void setNgayNoiNhanHenTra(Date ngayNoiNhanHenTra) {
		_ngayNoiNhanHenTra = ngayNoiNhanHenTra;
	}

	public int getSoNgayNoiNhanXuLyDuKien() {
		return _soNgayNoiNhanXuLyDuKien;
	}

	public void setSoNgayNoiNhanXuLyDuKien(int soNgayNoiNhanXuLyDuKien) {
		_soNgayNoiNhanXuLyDuKien = soNgayNoiNhanXuLyDuKien;
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

	public int getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(int daXoa) {
		_daXoa = daXoa;
	}

	private long _id;
	private long _hoSoId;
	private long _coQuanGuiId;
	private long _coQuanNhanId;
	private long _thuTucGuiId;
	private long _thuTucNhanId;
	private String _maSoBienNhanLucGui;
	private String _maSoBienNhanLucNhan;
	private long _canBoGuiId;
	private Long _canBoNhanId;
	private Date _ngayGui;
	private Date _ngayNhan;
	private String _hoTenCanBoGui;
	private String _hoTenCanBoNhan;
	private Long _canBoNopHoSoGiayId;
	private String _hoTenCanBoNopHoSoGiay;
	private int _trangThaiLienThong;
	private String _ghiChuGuiLienThong;
	private String _hoTenCongDanNop;
	private String _diaChiDayDuCongDanNop;
	private Date _ngayTuChoi;
	private Date _ngayNoiNhanTraKetQua;
	private Date _ngayNoiGuiNhanKetQua;
	private long _canBoTiepNhanNoiGuiId;
	private String _hoTenCanBoTiepNhanNoiGui;
	private String _tenCoQuanGui;
	private String _tenThuTucGui;
	private String _tenCoQuanNhan;
	private String _tenThuTucNhan;
	private int _thuTuLienThong;
	private Date _ngayNoiNhanHenTra;
	private int _soNgayNoiNhanXuLyDuKien;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private int _daXoa;
}