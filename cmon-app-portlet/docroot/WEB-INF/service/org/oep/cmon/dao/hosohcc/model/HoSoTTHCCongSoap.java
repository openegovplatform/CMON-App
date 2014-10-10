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
 * This class is used by SOAP remote services, specifically {@link org.oep.cmon.dao.hosohcc.service.http.HoSoTTHCCongServiceSoap}.
 *
 * @author    LIEMNn
 * @see       org.oep.cmon.dao.hosohcc.service.http.HoSoTTHCCongServiceSoap
 * @generated
 */
public class HoSoTTHCCongSoap implements Serializable {
	public static HoSoTTHCCongSoap toSoapModel(HoSoTTHCCong model) {
		HoSoTTHCCongSoap soapModel = new HoSoTTHCCongSoap();

		soapModel.setId(model.getId());
		soapModel.setMaSoHoSo(model.getMaSoHoSo());
		soapModel.setNgayNopHoSo(model.getNgayNopHoSo());
		soapModel.setNgayNhanHoSo(model.getNgayNhanHoSo());
		soapModel.setTenCoQuanTiepNhan(model.getTenCoQuanTiepNhan());
		soapModel.setTenThuTucHanhChinh(model.getTenThuTucHanhChinh());
		soapModel.setNgayHenTraKetQua(model.getNgayHenTraKetQua());
		soapModel.setNgayTraKetQua(model.getNgayTraKetQua());
		soapModel.setNgayNopHoSoGoc(model.getNgayNopHoSoGoc());
		soapModel.setNgayHenNopHoSoGoc(model.getNgayHenNopHoSoGoc());
		soapModel.setTenCanBoTiepNhan(model.getTenCanBoTiepNhan());
		soapModel.setChucVuCanBoTiepNhan(model.getChucVuCanBoTiepNhan());
		soapModel.setHoTenNguoiNopHoSo(model.getHoTenNguoiNopHoSo());
		soapModel.setDiaChiThuongTruNguoiNop(model.getDiaChiThuongTruNguoiNop());
		soapModel.setSoDienThoaiCoDinhNguoiNop(model.getSoDienThoaiCoDinhNguoiNop());
		soapModel.setTenCanBoTraKetQua(model.getTenCanBoTraKetQua());
		soapModel.setChucVuCanBoTraKetQua(model.getChucVuCanBoTraKetQua());
		soapModel.setHoTenNguoiNhanKetQua(model.getHoTenNguoiNhanKetQua());
		soapModel.setDiaChiThuongTruNguoiNhanKQ(model.getDiaChiThuongTruNguoiNhanKQ());
		soapModel.setSoDienThoaiNguoiNhan(model.getSoDienThoaiNguoiNhan());
		soapModel.setNgayCap(model.getNgayCap());
		soapModel.setLanCap(model.getLanCap());
		soapModel.setTenCoQuanCap(model.getTenCoQuanCap());
		soapModel.setHieuLucTuNgay(model.getHieuLucTuNgay());
		soapModel.setHieuLucDenNgay(model.getHieuLucDenNgay());
		soapModel.setTrangThaiHoSo(model.getTrangThaiHoSo());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setThuTucHanhChinhId(model.getThuTucHanhChinhId());
		soapModel.setCongDanNopId(model.getCongDanNopId());
		soapModel.setDiaChiThuongTruNguoiNhanKQId(model.getDiaChiThuongTruNguoiNhanKQId());
		soapModel.setCoQuanTiepNhanId(model.getCoQuanTiepNhanId());
		soapModel.setCanBoTraKetQuaId(model.getCanBoTraKetQuaId());
		soapModel.setCanBoTiepNhanId(model.getCanBoTiepNhanId());
		soapModel.setDiaChiThuongTruNguoiNopId(model.getDiaChiThuongTruNguoiNopId());
		soapModel.setSoDienThoaiDiDongNguoiNop(model.getSoDienThoaiDiDongNguoiNop());
		soapModel.setPhongBanXuLyHienThoiId(model.getPhongBanXuLyHienThoiId());
		soapModel.setTenPhongBanXuLyHienThoi(model.getTenPhongBanXuLyHienThoi());
		soapModel.setCanBoXuLyHienThoiId(model.getCanBoXuLyHienThoiId());
		soapModel.setTenCanBoXuLyHienThoi(model.getTenCanBoXuLyHienThoi());
		soapModel.setDanhGiaKetQua(model.getDanhGiaKetQua());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setNgayKetThucXuLy(model.getNgayKetThucXuLy());
		soapModel.setLoaiHoSo(model.getLoaiHoSo());
		soapModel.setYeuCauHuyHoSo(model.getYeuCauHuyHoSo());
		soapModel.setMaSoBienNhan(model.getMaSoBienNhan());
		soapModel.setTenBangChuaHoSo(model.getTenBangChuaHoSo());
		soapModel.setChuSoHuu(model.getChuSoHuu());
		soapModel.setSoBoHoSo(model.getSoBoHoSo());
		soapModel.setLePhi(model.getLePhi());
		soapModel.setPhiHoSo(model.getPhiHoSo());
		soapModel.setTrichYeu(model.getTrichYeu());
		soapModel.setNgayHenTBThue(model.getNgayHenTBThue());
		soapModel.setEmailNguoiNop(model.getEmailNguoiNop());
		soapModel.setMaUngDung(model.getMaUngDung());
		soapModel.setDaGuiGiayHen(model.getDaGuiGiayHen());
		soapModel.setNguoiDaiDienPhapLuat(model.getNguoiDaiDienPhapLuat());
		soapModel.setNguoiDaiDienPhapLuatId(model.getNguoiDaiDienPhapLuatId());
		soapModel.setChuyenSangMotCua(model.getChuyenSangMotCua());
		soapModel.setDoiTuongCanXuLyId(model.getDoiTuongCanXuLyId());
		soapModel.setLyDo(model.getLyDo());
		soapModel.setMoTaThanhPhanHoSo(model.getMoTaThanhPhanHoSo());
		soapModel.setLienKetThanhPhanHoSo(model.getLienKetThanhPhanHoSo());
		soapModel.setSoNgayXuLy(model.getSoNgayXuLy());
		soapModel.setDaTraKetQuaTrucTuyen(model.getDaTraKetQuaTrucTuyen());
		soapModel.setEMailNguoiNhan(model.getEMailNguoiNhan());
		soapModel.setNgaySinhNguoiNhan(model.getNgaySinhNguoiNhan());
		soapModel.setDienThoiCoDinhNguoiNhan(model.getDienThoiCoDinhNguoiNhan());
		soapModel.setCmndNguoiNhan(model.getCmndNguoiNhan());
		soapModel.setGioiTinh(model.getGioiTinh());
		soapModel.setDungXuLy(model.getDungXuLy());
		soapModel.setNgayBoSung(model.getNgayBoSung());
		soapModel.setGhiChuGiayToDinhKem(model.getGhiChuGiayToDinhKem());
		soapModel.setDaDangKyNhanSMS(model.getDaDangKyNhanSMS());
		soapModel.setDaDangKyChuyenPhatNhanh(model.getDaDangKyChuyenPhatNhanh());
		soapModel.setDiaChiChuHoSo(model.getDiaChiChuHoSo());

		return soapModel;
	}

	public static HoSoTTHCCongSoap[] toSoapModels(HoSoTTHCCong[] models) {
		HoSoTTHCCongSoap[] soapModels = new HoSoTTHCCongSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoSoTTHCCongSoap[][] toSoapModels(HoSoTTHCCong[][] models) {
		HoSoTTHCCongSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoSoTTHCCongSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoSoTTHCCongSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoSoTTHCCongSoap[] toSoapModels(List<HoSoTTHCCong> models) {
		List<HoSoTTHCCongSoap> soapModels = new ArrayList<HoSoTTHCCongSoap>(models.size());

		for (HoSoTTHCCong model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoSoTTHCCongSoap[soapModels.size()]);
	}

	public HoSoTTHCCongSoap() {
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

	public String getMaSoHoSo() {
		return _maSoHoSo;
	}

	public void setMaSoHoSo(String maSoHoSo) {
		_maSoHoSo = maSoHoSo;
	}

	public Date getNgayNopHoSo() {
		return _ngayNopHoSo;
	}

	public void setNgayNopHoSo(Date ngayNopHoSo) {
		_ngayNopHoSo = ngayNopHoSo;
	}

	public Date getNgayNhanHoSo() {
		return _ngayNhanHoSo;
	}

	public void setNgayNhanHoSo(Date ngayNhanHoSo) {
		_ngayNhanHoSo = ngayNhanHoSo;
	}

	public String getTenCoQuanTiepNhan() {
		return _tenCoQuanTiepNhan;
	}

	public void setTenCoQuanTiepNhan(String tenCoQuanTiepNhan) {
		_tenCoQuanTiepNhan = tenCoQuanTiepNhan;
	}

	public String getTenThuTucHanhChinh() {
		return _tenThuTucHanhChinh;
	}

	public void setTenThuTucHanhChinh(String tenThuTucHanhChinh) {
		_tenThuTucHanhChinh = tenThuTucHanhChinh;
	}

	public Date getNgayHenTraKetQua() {
		return _ngayHenTraKetQua;
	}

	public void setNgayHenTraKetQua(Date ngayHenTraKetQua) {
		_ngayHenTraKetQua = ngayHenTraKetQua;
	}

	public Date getNgayTraKetQua() {
		return _ngayTraKetQua;
	}

	public void setNgayTraKetQua(Date ngayTraKetQua) {
		_ngayTraKetQua = ngayTraKetQua;
	}

	public Date getNgayNopHoSoGoc() {
		return _ngayNopHoSoGoc;
	}

	public void setNgayNopHoSoGoc(Date ngayNopHoSoGoc) {
		_ngayNopHoSoGoc = ngayNopHoSoGoc;
	}

	public Date getNgayHenNopHoSoGoc() {
		return _ngayHenNopHoSoGoc;
	}

	public void setNgayHenNopHoSoGoc(Date ngayHenNopHoSoGoc) {
		_ngayHenNopHoSoGoc = ngayHenNopHoSoGoc;
	}

	public String getTenCanBoTiepNhan() {
		return _tenCanBoTiepNhan;
	}

	public void setTenCanBoTiepNhan(String tenCanBoTiepNhan) {
		_tenCanBoTiepNhan = tenCanBoTiepNhan;
	}

	public String getChucVuCanBoTiepNhan() {
		return _chucVuCanBoTiepNhan;
	}

	public void setChucVuCanBoTiepNhan(String chucVuCanBoTiepNhan) {
		_chucVuCanBoTiepNhan = chucVuCanBoTiepNhan;
	}

	public String getHoTenNguoiNopHoSo() {
		return _hoTenNguoiNopHoSo;
	}

	public void setHoTenNguoiNopHoSo(String hoTenNguoiNopHoSo) {
		_hoTenNguoiNopHoSo = hoTenNguoiNopHoSo;
	}

	public String getDiaChiThuongTruNguoiNop() {
		return _diaChiThuongTruNguoiNop;
	}

	public void setDiaChiThuongTruNguoiNop(String diaChiThuongTruNguoiNop) {
		_diaChiThuongTruNguoiNop = diaChiThuongTruNguoiNop;
	}

	public String getSoDienThoaiCoDinhNguoiNop() {
		return _soDienThoaiCoDinhNguoiNop;
	}

	public void setSoDienThoaiCoDinhNguoiNop(String soDienThoaiCoDinhNguoiNop) {
		_soDienThoaiCoDinhNguoiNop = soDienThoaiCoDinhNguoiNop;
	}

	public String getTenCanBoTraKetQua() {
		return _tenCanBoTraKetQua;
	}

	public void setTenCanBoTraKetQua(String tenCanBoTraKetQua) {
		_tenCanBoTraKetQua = tenCanBoTraKetQua;
	}

	public String getChucVuCanBoTraKetQua() {
		return _chucVuCanBoTraKetQua;
	}

	public void setChucVuCanBoTraKetQua(String chucVuCanBoTraKetQua) {
		_chucVuCanBoTraKetQua = chucVuCanBoTraKetQua;
	}

	public String getHoTenNguoiNhanKetQua() {
		return _hoTenNguoiNhanKetQua;
	}

	public void setHoTenNguoiNhanKetQua(String hoTenNguoiNhanKetQua) {
		_hoTenNguoiNhanKetQua = hoTenNguoiNhanKetQua;
	}

	public String getDiaChiThuongTruNguoiNhanKQ() {
		return _diaChiThuongTruNguoiNhanKQ;
	}

	public void setDiaChiThuongTruNguoiNhanKQ(String diaChiThuongTruNguoiNhanKQ) {
		_diaChiThuongTruNguoiNhanKQ = diaChiThuongTruNguoiNhanKQ;
	}

	public String getSoDienThoaiNguoiNhan() {
		return _soDienThoaiNguoiNhan;
	}

	public void setSoDienThoaiNguoiNhan(String soDienThoaiNguoiNhan) {
		_soDienThoaiNguoiNhan = soDienThoaiNguoiNhan;
	}

	public Date getNgayCap() {
		return _ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		_ngayCap = ngayCap;
	}

	public long getLanCap() {
		return _lanCap;
	}

	public void setLanCap(long lanCap) {
		_lanCap = lanCap;
	}

	public String getTenCoQuanCap() {
		return _tenCoQuanCap;
	}

	public void setTenCoQuanCap(String tenCoQuanCap) {
		_tenCoQuanCap = tenCoQuanCap;
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

	public int getTrangThaiHoSo() {
		return _trangThaiHoSo;
	}

	public void setTrangThaiHoSo(int trangThaiHoSo) {
		_trangThaiHoSo = trangThaiHoSo;
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

	public Long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(Long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public Long getCongDanNopId() {
		return _congDanNopId;
	}

	public void setCongDanNopId(Long congDanNopId) {
		_congDanNopId = congDanNopId;
	}

	public Long getDiaChiThuongTruNguoiNhanKQId() {
		return _diaChiThuongTruNguoiNhanKQId;
	}

	public void setDiaChiThuongTruNguoiNhanKQId(
		Long diaChiThuongTruNguoiNhanKQId) {
		_diaChiThuongTruNguoiNhanKQId = diaChiThuongTruNguoiNhanKQId;
	}

	public Long getCoQuanTiepNhanId() {
		return _coQuanTiepNhanId;
	}

	public void setCoQuanTiepNhanId(Long coQuanTiepNhanId) {
		_coQuanTiepNhanId = coQuanTiepNhanId;
	}

	public Long getCanBoTraKetQuaId() {
		return _canBoTraKetQuaId;
	}

	public void setCanBoTraKetQuaId(Long canBoTraKetQuaId) {
		_canBoTraKetQuaId = canBoTraKetQuaId;
	}

	public Long getCanBoTiepNhanId() {
		return _canBoTiepNhanId;
	}

	public void setCanBoTiepNhanId(Long canBoTiepNhanId) {
		_canBoTiepNhanId = canBoTiepNhanId;
	}

	public Long getDiaChiThuongTruNguoiNopId() {
		return _diaChiThuongTruNguoiNopId;
	}

	public void setDiaChiThuongTruNguoiNopId(Long diaChiThuongTruNguoiNopId) {
		_diaChiThuongTruNguoiNopId = diaChiThuongTruNguoiNopId;
	}

	public String getSoDienThoaiDiDongNguoiNop() {
		return _soDienThoaiDiDongNguoiNop;
	}

	public void setSoDienThoaiDiDongNguoiNop(String soDienThoaiDiDongNguoiNop) {
		_soDienThoaiDiDongNguoiNop = soDienThoaiDiDongNguoiNop;
	}

	public Long getPhongBanXuLyHienThoiId() {
		return _phongBanXuLyHienThoiId;
	}

	public void setPhongBanXuLyHienThoiId(Long phongBanXuLyHienThoiId) {
		_phongBanXuLyHienThoiId = phongBanXuLyHienThoiId;
	}

	public String getTenPhongBanXuLyHienThoi() {
		return _tenPhongBanXuLyHienThoi;
	}

	public void setTenPhongBanXuLyHienThoi(String tenPhongBanXuLyHienThoi) {
		_tenPhongBanXuLyHienThoi = tenPhongBanXuLyHienThoi;
	}

	public Long getCanBoXuLyHienThoiId() {
		return _canBoXuLyHienThoiId;
	}

	public void setCanBoXuLyHienThoiId(Long canBoXuLyHienThoiId) {
		_canBoXuLyHienThoiId = canBoXuLyHienThoiId;
	}

	public String getTenCanBoXuLyHienThoi() {
		return _tenCanBoXuLyHienThoi;
	}

	public void setTenCanBoXuLyHienThoi(String tenCanBoXuLyHienThoi) {
		_tenCanBoXuLyHienThoi = tenCanBoXuLyHienThoi;
	}

	public int getDanhGiaKetQua() {
		return _danhGiaKetQua;
	}

	public void setDanhGiaKetQua(int danhGiaKetQua) {
		_danhGiaKetQua = danhGiaKetQua;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public Date getNgayKetThucXuLy() {
		return _ngayKetThucXuLy;
	}

	public void setNgayKetThucXuLy(Date ngayKetThucXuLy) {
		_ngayKetThucXuLy = ngayKetThucXuLy;
	}

	public int getLoaiHoSo() {
		return _loaiHoSo;
	}

	public void setLoaiHoSo(int loaiHoSo) {
		_loaiHoSo = loaiHoSo;
	}

	public int getYeuCauHuyHoSo() {
		return _yeuCauHuyHoSo;
	}

	public void setYeuCauHuyHoSo(int yeuCauHuyHoSo) {
		_yeuCauHuyHoSo = yeuCauHuyHoSo;
	}

	public String getMaSoBienNhan() {
		return _maSoBienNhan;
	}

	public void setMaSoBienNhan(String maSoBienNhan) {
		_maSoBienNhan = maSoBienNhan;
	}

	public String getTenBangChuaHoSo() {
		return _tenBangChuaHoSo;
	}

	public void setTenBangChuaHoSo(String tenBangChuaHoSo) {
		_tenBangChuaHoSo = tenBangChuaHoSo;
	}

	public String getChuSoHuu() {
		return _chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) {
		_chuSoHuu = chuSoHuu;
	}

	public int getSoBoHoSo() {
		return _soBoHoSo;
	}

	public void setSoBoHoSo(int soBoHoSo) {
		_soBoHoSo = soBoHoSo;
	}

	public int getLePhi() {
		return _lePhi;
	}

	public void setLePhi(int lePhi) {
		_lePhi = lePhi;
	}

	public int getPhiHoSo() {
		return _phiHoSo;
	}

	public void setPhiHoSo(int phiHoSo) {
		_phiHoSo = phiHoSo;
	}

	public String getTrichYeu() {
		return _trichYeu;
	}

	public void setTrichYeu(String trichYeu) {
		_trichYeu = trichYeu;
	}

	public Date getNgayHenTBThue() {
		return _ngayHenTBThue;
	}

	public void setNgayHenTBThue(Date ngayHenTBThue) {
		_ngayHenTBThue = ngayHenTBThue;
	}

	public String getEmailNguoiNop() {
		return _emailNguoiNop;
	}

	public void setEmailNguoiNop(String emailNguoiNop) {
		_emailNguoiNop = emailNguoiNop;
	}

	public String getMaUngDung() {
		return _maUngDung;
	}

	public void setMaUngDung(String maUngDung) {
		_maUngDung = maUngDung;
	}

	public int getDaGuiGiayHen() {
		return _daGuiGiayHen;
	}

	public void setDaGuiGiayHen(int daGuiGiayHen) {
		_daGuiGiayHen = daGuiGiayHen;
	}

	public String getNguoiDaiDienPhapLuat() {
		return _nguoiDaiDienPhapLuat;
	}

	public void setNguoiDaiDienPhapLuat(String nguoiDaiDienPhapLuat) {
		_nguoiDaiDienPhapLuat = nguoiDaiDienPhapLuat;
	}

	public Long getNguoiDaiDienPhapLuatId() {
		return _nguoiDaiDienPhapLuatId;
	}

	public void setNguoiDaiDienPhapLuatId(Long nguoiDaiDienPhapLuatId) {
		_nguoiDaiDienPhapLuatId = nguoiDaiDienPhapLuatId;
	}

	public int getChuyenSangMotCua() {
		return _chuyenSangMotCua;
	}

	public void setChuyenSangMotCua(int chuyenSangMotCua) {
		_chuyenSangMotCua = chuyenSangMotCua;
	}

	public Long getDoiTuongCanXuLyId() {
		return _doiTuongCanXuLyId;
	}

	public void setDoiTuongCanXuLyId(Long doiTuongCanXuLyId) {
		_doiTuongCanXuLyId = doiTuongCanXuLyId;
	}

	public String getLyDo() {
		return _lyDo;
	}

	public void setLyDo(String lyDo) {
		_lyDo = lyDo;
	}

	public String getMoTaThanhPhanHoSo() {
		return _moTaThanhPhanHoSo;
	}

	public void setMoTaThanhPhanHoSo(String moTaThanhPhanHoSo) {
		_moTaThanhPhanHoSo = moTaThanhPhanHoSo;
	}

	public String getLienKetThanhPhanHoSo() {
		return _lienKetThanhPhanHoSo;
	}

	public void setLienKetThanhPhanHoSo(String lienKetThanhPhanHoSo) {
		_lienKetThanhPhanHoSo = lienKetThanhPhanHoSo;
	}

	public Long getSoNgayXuLy() {
		return _soNgayXuLy;
	}

	public void setSoNgayXuLy(Long soNgayXuLy) {
		_soNgayXuLy = soNgayXuLy;
	}

	public Long getDaTraKetQuaTrucTuyen() {
		return _daTraKetQuaTrucTuyen;
	}

	public void setDaTraKetQuaTrucTuyen(Long daTraKetQuaTrucTuyen) {
		_daTraKetQuaTrucTuyen = daTraKetQuaTrucTuyen;
	}

	public String getEMailNguoiNhan() {
		return _eMailNguoiNhan;
	}

	public void setEMailNguoiNhan(String eMailNguoiNhan) {
		_eMailNguoiNhan = eMailNguoiNhan;
	}

	public Date getNgaySinhNguoiNhan() {
		return _ngaySinhNguoiNhan;
	}

	public void setNgaySinhNguoiNhan(Date ngaySinhNguoiNhan) {
		_ngaySinhNguoiNhan = ngaySinhNguoiNhan;
	}

	public String getDienThoiCoDinhNguoiNhan() {
		return _dienThoiCoDinhNguoiNhan;
	}

	public void setDienThoiCoDinhNguoiNhan(String dienThoiCoDinhNguoiNhan) {
		_dienThoiCoDinhNguoiNhan = dienThoiCoDinhNguoiNhan;
	}

	public String getCmndNguoiNhan() {
		return _cmndNguoiNhan;
	}

	public void setCmndNguoiNhan(String cmndNguoiNhan) {
		_cmndNguoiNhan = cmndNguoiNhan;
	}

	public int getGioiTinh() {
		return _gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		_gioiTinh = gioiTinh;
	}

	public boolean getDungXuLy() {
		return _dungXuLy;
	}

	public boolean isDungXuLy() {
		return _dungXuLy;
	}

	public void setDungXuLy(boolean dungXuLy) {
		_dungXuLy = dungXuLy;
	}

	public Date getNgayBoSung() {
		return _ngayBoSung;
	}

	public void setNgayBoSung(Date ngayBoSung) {
		_ngayBoSung = ngayBoSung;
	}

	public String getGhiChuGiayToDinhKem() {
		return _ghiChuGiayToDinhKem;
	}

	public void setGhiChuGiayToDinhKem(String ghiChuGiayToDinhKem) {
		_ghiChuGiayToDinhKem = ghiChuGiayToDinhKem;
	}

	public int getDaDangKyNhanSMS() {
		return _daDangKyNhanSMS;
	}

	public void setDaDangKyNhanSMS(int daDangKyNhanSMS) {
		_daDangKyNhanSMS = daDangKyNhanSMS;
	}

	public int getDaDangKyChuyenPhatNhanh() {
		return _daDangKyChuyenPhatNhanh;
	}

	public void setDaDangKyChuyenPhatNhanh(int daDangKyChuyenPhatNhanh) {
		_daDangKyChuyenPhatNhanh = daDangKyChuyenPhatNhanh;
	}

	public String getDiaChiChuHoSo() {
		return _diaChiChuHoSo;
	}

	public void setDiaChiChuHoSo(String diaChiChuHoSo) {
		_diaChiChuHoSo = diaChiChuHoSo;
	}

	private long _id;
	private String _maSoHoSo;
	private Date _ngayNopHoSo;
	private Date _ngayNhanHoSo;
	private String _tenCoQuanTiepNhan;
	private String _tenThuTucHanhChinh;
	private Date _ngayHenTraKetQua;
	private Date _ngayTraKetQua;
	private Date _ngayNopHoSoGoc;
	private Date _ngayHenNopHoSoGoc;
	private String _tenCanBoTiepNhan;
	private String _chucVuCanBoTiepNhan;
	private String _hoTenNguoiNopHoSo;
	private String _diaChiThuongTruNguoiNop;
	private String _soDienThoaiCoDinhNguoiNop;
	private String _tenCanBoTraKetQua;
	private String _chucVuCanBoTraKetQua;
	private String _hoTenNguoiNhanKetQua;
	private String _diaChiThuongTruNguoiNhanKQ;
	private String _soDienThoaiNguoiNhan;
	private Date _ngayCap;
	private long _lanCap;
	private String _tenCoQuanCap;
	private Date _hieuLucTuNgay;
	private Date _hieuLucDenNgay;
	private int _trangThaiHoSo;
	private int _daXoa;
	private String _nguoiTao;
	private Date _ngayTao;
	private String _nguoiSua;
	private Date _ngaySua;
	private Long _thuTucHanhChinhId;
	private Long _congDanNopId;
	private Long _diaChiThuongTruNguoiNhanKQId;
	private Long _coQuanTiepNhanId;
	private Long _canBoTraKetQuaId;
	private Long _canBoTiepNhanId;
	private Long _diaChiThuongTruNguoiNopId;
	private String _soDienThoaiDiDongNguoiNop;
	private Long _phongBanXuLyHienThoiId;
	private String _tenPhongBanXuLyHienThoi;
	private Long _canBoXuLyHienThoiId;
	private String _tenCanBoXuLyHienThoi;
	private int _danhGiaKetQua;
	private String _ghiChu;
	private Date _ngayKetThucXuLy;
	private int _loaiHoSo;
	private int _yeuCauHuyHoSo;
	private String _maSoBienNhan;
	private String _tenBangChuaHoSo;
	private String _chuSoHuu;
	private int _soBoHoSo;
	private int _lePhi;
	private int _phiHoSo;
	private String _trichYeu;
	private Date _ngayHenTBThue;
	private String _emailNguoiNop;
	private String _maUngDung;
	private int _daGuiGiayHen;
	private String _nguoiDaiDienPhapLuat;
	private Long _nguoiDaiDienPhapLuatId;
	private int _chuyenSangMotCua;
	private Long _doiTuongCanXuLyId;
	private String _lyDo;
	private String _moTaThanhPhanHoSo;
	private String _lienKetThanhPhanHoSo;
	private Long _soNgayXuLy;
	private Long _daTraKetQuaTrucTuyen;
	private String _eMailNguoiNhan;
	private Date _ngaySinhNguoiNhan;
	private String _dienThoiCoDinhNguoiNhan;
	private String _cmndNguoiNhan;
	private int _gioiTinh;
	private boolean _dungXuLy;
	private Date _ngayBoSung;
	private String _ghiChuGiayToDinhKem;
	private int _daDangKyNhanSMS;
	private int _daDangKyChuyenPhatNhanh;
	private String _diaChiChuHoSo;
}