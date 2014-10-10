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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.hosohcc.service.HoSoTTHCCongLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author LIEMNn
 */
public class HoSoTTHCCongClp extends BaseModelImpl<HoSoTTHCCong>
	implements HoSoTTHCCong {
	public HoSoTTHCCongClp() {
	}

	public Class<?> getModelClass() {
		return HoSoTTHCCong.class;
	}

	public String getModelClassName() {
		return HoSoTTHCCong.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			HoSoTTHCCongLocalServiceUtil.addHoSoTTHCCong(this);
		}
		else {
			HoSoTTHCCongLocalServiceUtil.updateHoSoTTHCCong(this);
		}
	}

	@Override
	public HoSoTTHCCong toEscapedModel() {
		return (HoSoTTHCCong)Proxy.newProxyInstance(HoSoTTHCCong.class.getClassLoader(),
			new Class[] { HoSoTTHCCong.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HoSoTTHCCongClp clone = new HoSoTTHCCongClp();

		clone.setId(getId());
		clone.setMaSoHoSo(getMaSoHoSo());
		clone.setNgayNopHoSo(getNgayNopHoSo());
		clone.setNgayNhanHoSo(getNgayNhanHoSo());
		clone.setTenCoQuanTiepNhan(getTenCoQuanTiepNhan());
		clone.setTenThuTucHanhChinh(getTenThuTucHanhChinh());
		clone.setNgayHenTraKetQua(getNgayHenTraKetQua());
		clone.setNgayTraKetQua(getNgayTraKetQua());
		clone.setNgayNopHoSoGoc(getNgayNopHoSoGoc());
		clone.setNgayHenNopHoSoGoc(getNgayHenNopHoSoGoc());
		clone.setTenCanBoTiepNhan(getTenCanBoTiepNhan());
		clone.setChucVuCanBoTiepNhan(getChucVuCanBoTiepNhan());
		clone.setHoTenNguoiNopHoSo(getHoTenNguoiNopHoSo());
		clone.setDiaChiThuongTruNguoiNop(getDiaChiThuongTruNguoiNop());
		clone.setSoDienThoaiCoDinhNguoiNop(getSoDienThoaiCoDinhNguoiNop());
		clone.setTenCanBoTraKetQua(getTenCanBoTraKetQua());
		clone.setChucVuCanBoTraKetQua(getChucVuCanBoTraKetQua());
		clone.setHoTenNguoiNhanKetQua(getHoTenNguoiNhanKetQua());
		clone.setDiaChiThuongTruNguoiNhanKQ(getDiaChiThuongTruNguoiNhanKQ());
		clone.setSoDienThoaiNguoiNhan(getSoDienThoaiNguoiNhan());
		clone.setNgayCap(getNgayCap());
		clone.setLanCap(getLanCap());
		clone.setTenCoQuanCap(getTenCoQuanCap());
		clone.setHieuLucTuNgay(getHieuLucTuNgay());
		clone.setHieuLucDenNgay(getHieuLucDenNgay());
		clone.setTrangThaiHoSo(getTrangThaiHoSo());
		clone.setDaXoa(getDaXoa());
		clone.setNguoiTao(getNguoiTao());
		clone.setNgayTao(getNgayTao());
		clone.setNguoiSua(getNguoiSua());
		clone.setNgaySua(getNgaySua());
		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setCongDanNopId(getCongDanNopId());
		clone.setDiaChiThuongTruNguoiNhanKQId(getDiaChiThuongTruNguoiNhanKQId());
		clone.setCoQuanTiepNhanId(getCoQuanTiepNhanId());
		clone.setCanBoTraKetQuaId(getCanBoTraKetQuaId());
		clone.setCanBoTiepNhanId(getCanBoTiepNhanId());
		clone.setDiaChiThuongTruNguoiNopId(getDiaChiThuongTruNguoiNopId());
		clone.setSoDienThoaiDiDongNguoiNop(getSoDienThoaiDiDongNguoiNop());
		clone.setPhongBanXuLyHienThoiId(getPhongBanXuLyHienThoiId());
		clone.setTenPhongBanXuLyHienThoi(getTenPhongBanXuLyHienThoi());
		clone.setCanBoXuLyHienThoiId(getCanBoXuLyHienThoiId());
		clone.setTenCanBoXuLyHienThoi(getTenCanBoXuLyHienThoi());
		clone.setDanhGiaKetQua(getDanhGiaKetQua());
		clone.setGhiChu(getGhiChu());
		clone.setNgayKetThucXuLy(getNgayKetThucXuLy());
		clone.setLoaiHoSo(getLoaiHoSo());
		clone.setYeuCauHuyHoSo(getYeuCauHuyHoSo());
		clone.setMaSoBienNhan(getMaSoBienNhan());
		clone.setTenBangChuaHoSo(getTenBangChuaHoSo());
		clone.setChuSoHuu(getChuSoHuu());
		clone.setSoBoHoSo(getSoBoHoSo());
		clone.setLePhi(getLePhi());
		clone.setPhiHoSo(getPhiHoSo());
		clone.setTrichYeu(getTrichYeu());
		clone.setNgayHenTBThue(getNgayHenTBThue());
		clone.setEmailNguoiNop(getEmailNguoiNop());
		clone.setMaUngDung(getMaUngDung());
		clone.setDaGuiGiayHen(getDaGuiGiayHen());
		clone.setNguoiDaiDienPhapLuat(getNguoiDaiDienPhapLuat());
		clone.setNguoiDaiDienPhapLuatId(getNguoiDaiDienPhapLuatId());
		clone.setChuyenSangMotCua(getChuyenSangMotCua());
		clone.setDoiTuongCanXuLyId(getDoiTuongCanXuLyId());
		clone.setLyDo(getLyDo());
		clone.setMoTaThanhPhanHoSo(getMoTaThanhPhanHoSo());
		clone.setLienKetThanhPhanHoSo(getLienKetThanhPhanHoSo());
		clone.setSoNgayXuLy(getSoNgayXuLy());
		clone.setDaTraKetQuaTrucTuyen(getDaTraKetQuaTrucTuyen());
		clone.setEMailNguoiNhan(getEMailNguoiNhan());
		clone.setNgaySinhNguoiNhan(getNgaySinhNguoiNhan());
		clone.setDienThoiCoDinhNguoiNhan(getDienThoiCoDinhNguoiNhan());
		clone.setCmndNguoiNhan(getCmndNguoiNhan());
		clone.setGioiTinh(getGioiTinh());
		clone.setDungXuLy(getDungXuLy());
		clone.setNgayBoSung(getNgayBoSung());
		clone.setGhiChuGiayToDinhKem(getGhiChuGiayToDinhKem());
		clone.setDaDangKyNhanSMS(getDaDangKyNhanSMS());
		clone.setDaDangKyChuyenPhatNhanh(getDaDangKyChuyenPhatNhanh());
		clone.setDiaChiChuHoSo(getDiaChiChuHoSo());

		return clone;
	}

	public int compareTo(HoSoTTHCCong hoSoTTHCCong) {
		int value = 0;

		if (getId() < hoSoTTHCCong.getId()) {
			value = -1;
		}
		else if (getId() > hoSoTTHCCong.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		HoSoTTHCCongClp hoSoTTHCCong = null;

		try {
			hoSoTTHCCong = (HoSoTTHCCongClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = hoSoTTHCCong.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(159);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", maSoHoSo=");
		sb.append(getMaSoHoSo());
		sb.append(", ngayNopHoSo=");
		sb.append(getNgayNopHoSo());
		sb.append(", ngayNhanHoSo=");
		sb.append(getNgayNhanHoSo());
		sb.append(", tenCoQuanTiepNhan=");
		sb.append(getTenCoQuanTiepNhan());
		sb.append(", tenThuTucHanhChinh=");
		sb.append(getTenThuTucHanhChinh());
		sb.append(", ngayHenTraKetQua=");
		sb.append(getNgayHenTraKetQua());
		sb.append(", ngayTraKetQua=");
		sb.append(getNgayTraKetQua());
		sb.append(", ngayNopHoSoGoc=");
		sb.append(getNgayNopHoSoGoc());
		sb.append(", ngayHenNopHoSoGoc=");
		sb.append(getNgayHenNopHoSoGoc());
		sb.append(", tenCanBoTiepNhan=");
		sb.append(getTenCanBoTiepNhan());
		sb.append(", chucVuCanBoTiepNhan=");
		sb.append(getChucVuCanBoTiepNhan());
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append(", tenCanBoTraKetQua=");
		sb.append(getTenCanBoTraKetQua());
		sb.append(", chucVuCanBoTraKetQua=");
		sb.append(getChucVuCanBoTraKetQua());
		sb.append(", hoTenNguoiNhanKetQua=");
		sb.append(getHoTenNguoiNhanKetQua());
		sb.append(", diaChiThuongTruNguoiNhanKQ=");
		sb.append(getDiaChiThuongTruNguoiNhanKQ());
		sb.append(", soDienThoaiNguoiNhan=");
		sb.append(getSoDienThoaiNguoiNhan());
		sb.append(", ngayCap=");
		sb.append(getNgayCap());
		sb.append(", lanCap=");
		sb.append(getLanCap());
		sb.append(", tenCoQuanCap=");
		sb.append(getTenCoQuanCap());
		sb.append(", hieuLucTuNgay=");
		sb.append(getHieuLucTuNgay());
		sb.append(", hieuLucDenNgay=");
		sb.append(getHieuLucDenNgay());
		sb.append(", trangThaiHoSo=");
		sb.append(getTrangThaiHoSo());
		sb.append(", daXoa=");
		sb.append(getDaXoa());
		sb.append(", nguoiTao=");
		sb.append(getNguoiTao());
		sb.append(", ngayTao=");
		sb.append(getNgayTao());
		sb.append(", nguoiSua=");
		sb.append(getNguoiSua());
		sb.append(", ngaySua=");
		sb.append(getNgaySua());
		sb.append(", thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", congDanNopId=");
		sb.append(getCongDanNopId());
		sb.append(", diaChiThuongTruNguoiNhanKQId=");
		sb.append(getDiaChiThuongTruNguoiNhanKQId());
		sb.append(", coQuanTiepNhanId=");
		sb.append(getCoQuanTiepNhanId());
		sb.append(", canBoTraKetQuaId=");
		sb.append(getCanBoTraKetQuaId());
		sb.append(", canBoTiepNhanId=");
		sb.append(getCanBoTiepNhanId());
		sb.append(", diaChiThuongTruNguoiNopId=");
		sb.append(getDiaChiThuongTruNguoiNopId());
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append(", phongBanXuLyHienThoiId=");
		sb.append(getPhongBanXuLyHienThoiId());
		sb.append(", tenPhongBanXuLyHienThoi=");
		sb.append(getTenPhongBanXuLyHienThoi());
		sb.append(", canBoXuLyHienThoiId=");
		sb.append(getCanBoXuLyHienThoiId());
		sb.append(", tenCanBoXuLyHienThoi=");
		sb.append(getTenCanBoXuLyHienThoi());
		sb.append(", danhGiaKetQua=");
		sb.append(getDanhGiaKetQua());
		sb.append(", ghiChu=");
		sb.append(getGhiChu());
		sb.append(", ngayKetThucXuLy=");
		sb.append(getNgayKetThucXuLy());
		sb.append(", loaiHoSo=");
		sb.append(getLoaiHoSo());
		sb.append(", yeuCauHuyHoSo=");
		sb.append(getYeuCauHuyHoSo());
		sb.append(", maSoBienNhan=");
		sb.append(getMaSoBienNhan());
		sb.append(", tenBangChuaHoSo=");
		sb.append(getTenBangChuaHoSo());
		sb.append(", chuSoHuu=");
		sb.append(getChuSoHuu());
		sb.append(", soBoHoSo=");
		sb.append(getSoBoHoSo());
		sb.append(", lePhi=");
		sb.append(getLePhi());
		sb.append(", phiHoSo=");
		sb.append(getPhiHoSo());
		sb.append(", trichYeu=");
		sb.append(getTrichYeu());
		sb.append(", ngayHenTBThue=");
		sb.append(getNgayHenTBThue());
		sb.append(", emailNguoiNop=");
		sb.append(getEmailNguoiNop());
		sb.append(", maUngDung=");
		sb.append(getMaUngDung());
		sb.append(", daGuiGiayHen=");
		sb.append(getDaGuiGiayHen());
		sb.append(", nguoiDaiDienPhapLuat=");
		sb.append(getNguoiDaiDienPhapLuat());
		sb.append(", nguoiDaiDienPhapLuatId=");
		sb.append(getNguoiDaiDienPhapLuatId());
		sb.append(", chuyenSangMotCua=");
		sb.append(getChuyenSangMotCua());
		sb.append(", doiTuongCanXuLyId=");
		sb.append(getDoiTuongCanXuLyId());
		sb.append(", lyDo=");
		sb.append(getLyDo());
		sb.append(", moTaThanhPhanHoSo=");
		sb.append(getMoTaThanhPhanHoSo());
		sb.append(", lienKetThanhPhanHoSo=");
		sb.append(getLienKetThanhPhanHoSo());
		sb.append(", soNgayXuLy=");
		sb.append(getSoNgayXuLy());
		sb.append(", daTraKetQuaTrucTuyen=");
		sb.append(getDaTraKetQuaTrucTuyen());
		sb.append(", eMailNguoiNhan=");
		sb.append(getEMailNguoiNhan());
		sb.append(", ngaySinhNguoiNhan=");
		sb.append(getNgaySinhNguoiNhan());
		sb.append(", dienThoiCoDinhNguoiNhan=");
		sb.append(getDienThoiCoDinhNguoiNhan());
		sb.append(", cmndNguoiNhan=");
		sb.append(getCmndNguoiNhan());
		sb.append(", gioiTinh=");
		sb.append(getGioiTinh());
		sb.append(", dungXuLy=");
		sb.append(getDungXuLy());
		sb.append(", ngayBoSung=");
		sb.append(getNgayBoSung());
		sb.append(", ghiChuGiayToDinhKem=");
		sb.append(getGhiChuGiayToDinhKem());
		sb.append(", daDangKyNhanSMS=");
		sb.append(getDaDangKyNhanSMS());
		sb.append(", daDangKyChuyenPhatNhanh=");
		sb.append(getDaDangKyChuyenPhatNhanh());
		sb.append(", diaChiChuHoSo=");
		sb.append(getDiaChiChuHoSo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(241);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoHoSo</column-name><column-value><![CDATA[");
		sb.append(getMaSoHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNhanHoSo</column-name><column-value><![CDATA[");
		sb.append(getNgayNhanHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenThuTucHanhChinh</column-name><column-value><![CDATA[");
		sb.append(getTenThuTucHanhChinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHenTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayHenTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getNgayTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayNopHoSoGoc</column-name><column-value><![CDATA[");
		sb.append(getNgayNopHoSoGoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHenNopHoSoGoc</column-name><column-value><![CDATA[");
		sb.append(getNgayHenNopHoSoGoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCanBoTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuCanBoTiepNhan</column-name><column-value><![CDATA[");
		sb.append(getChucVuCanBoTiepNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenNguoiNopHoSo</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNopHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiCoDinhNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiCoDinhNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCanBoTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chucVuCanBoTraKetQua</column-name><column-value><![CDATA[");
		sb.append(getChucVuCanBoTraKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoTenNguoiNhanKetQua</column-name><column-value><![CDATA[");
		sb.append(getHoTenNguoiNhanKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNhanKQ</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNhanKQ());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiNguoiNhan</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiNguoiNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayCap</column-name><column-value><![CDATA[");
		sb.append(getNgayCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lanCap</column-name><column-value><![CDATA[");
		sb.append(getLanCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCoQuanCap</column-name><column-value><![CDATA[");
		sb.append(getTenCoQuanCap());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hieuLucTuNgay</column-name><column-value><![CDATA[");
		sb.append(getHieuLucTuNgay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hieuLucDenNgay</column-name><column-value><![CDATA[");
		sb.append(getHieuLucDenNgay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trangThaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getTrangThaiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daXoa</column-name><column-value><![CDATA[");
		sb.append(getDaXoa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiTao</column-name><column-value><![CDATA[");
		sb.append(getNguoiTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayTao</column-name><column-value><![CDATA[");
		sb.append(getNgayTao());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiSua</column-name><column-value><![CDATA[");
		sb.append(getNguoiSua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySua</column-name><column-value><![CDATA[");
		sb.append(getNgaySua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>congDanNopId</column-name><column-value><![CDATA[");
		sb.append(getCongDanNopId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNhanKQId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNhanKQId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coQuanTiepNhanId</column-name><column-value><![CDATA[");
		sb.append(getCoQuanTiepNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoTraKetQuaId</column-name><column-value><![CDATA[");
		sb.append(getCanBoTraKetQuaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoTiepNhanId</column-name><column-value><![CDATA[");
		sb.append(getCanBoTiepNhanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiThuongTruNguoiNopId</column-name><column-value><![CDATA[");
		sb.append(getDiaChiThuongTruNguoiNopId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soDienThoaiDiDongNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getSoDienThoaiDiDongNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phongBanXuLyHienThoiId</column-name><column-value><![CDATA[");
		sb.append(getPhongBanXuLyHienThoiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenPhongBanXuLyHienThoi</column-name><column-value><![CDATA[");
		sb.append(getTenPhongBanXuLyHienThoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>canBoXuLyHienThoiId</column-name><column-value><![CDATA[");
		sb.append(getCanBoXuLyHienThoiId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenCanBoXuLyHienThoi</column-name><column-value><![CDATA[");
		sb.append(getTenCanBoXuLyHienThoi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>danhGiaKetQua</column-name><column-value><![CDATA[");
		sb.append(getDanhGiaKetQua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChu</column-name><column-value><![CDATA[");
		sb.append(getGhiChu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayKetThucXuLy</column-name><column-value><![CDATA[");
		sb.append(getNgayKetThucXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loaiHoSo</column-name><column-value><![CDATA[");
		sb.append(getLoaiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yeuCauHuyHoSo</column-name><column-value><![CDATA[");
		sb.append(getYeuCauHuyHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maSoBienNhan</column-name><column-value><![CDATA[");
		sb.append(getMaSoBienNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tenBangChuaHoSo</column-name><column-value><![CDATA[");
		sb.append(getTenBangChuaHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chuSoHuu</column-name><column-value><![CDATA[");
		sb.append(getChuSoHuu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soBoHoSo</column-name><column-value><![CDATA[");
		sb.append(getSoBoHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lePhi</column-name><column-value><![CDATA[");
		sb.append(getLePhi());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phiHoSo</column-name><column-value><![CDATA[");
		sb.append(getPhiHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trichYeu</column-name><column-value><![CDATA[");
		sb.append(getTrichYeu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayHenTBThue</column-name><column-value><![CDATA[");
		sb.append(getNgayHenTBThue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailNguoiNop</column-name><column-value><![CDATA[");
		sb.append(getEmailNguoiNop());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maUngDung</column-name><column-value><![CDATA[");
		sb.append(getMaUngDung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daGuiGiayHen</column-name><column-value><![CDATA[");
		sb.append(getDaGuiGiayHen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiDaiDienPhapLuat</column-name><column-value><![CDATA[");
		sb.append(getNguoiDaiDienPhapLuat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nguoiDaiDienPhapLuatId</column-name><column-value><![CDATA[");
		sb.append(getNguoiDaiDienPhapLuatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chuyenSangMotCua</column-name><column-value><![CDATA[");
		sb.append(getChuyenSangMotCua());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>doiTuongCanXuLyId</column-name><column-value><![CDATA[");
		sb.append(getDoiTuongCanXuLyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lyDo</column-name><column-value><![CDATA[");
		sb.append(getLyDo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moTaThanhPhanHoSo</column-name><column-value><![CDATA[");
		sb.append(getMoTaThanhPhanHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lienKetThanhPhanHoSo</column-name><column-value><![CDATA[");
		sb.append(getLienKetThanhPhanHoSo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNgayXuLy</column-name><column-value><![CDATA[");
		sb.append(getSoNgayXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daTraKetQuaTrucTuyen</column-name><column-value><![CDATA[");
		sb.append(getDaTraKetQuaTrucTuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eMailNguoiNhan</column-name><column-value><![CDATA[");
		sb.append(getEMailNguoiNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngaySinhNguoiNhan</column-name><column-value><![CDATA[");
		sb.append(getNgaySinhNguoiNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dienThoiCoDinhNguoiNhan</column-name><column-value><![CDATA[");
		sb.append(getDienThoiCoDinhNguoiNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmndNguoiNhan</column-name><column-value><![CDATA[");
		sb.append(getCmndNguoiNhan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gioiTinh</column-name><column-value><![CDATA[");
		sb.append(getGioiTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dungXuLy</column-name><column-value><![CDATA[");
		sb.append(getDungXuLy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ngayBoSung</column-name><column-value><![CDATA[");
		sb.append(getNgayBoSung());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ghiChuGiayToDinhKem</column-name><column-value><![CDATA[");
		sb.append(getGhiChuGiayToDinhKem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daDangKyNhanSMS</column-name><column-value><![CDATA[");
		sb.append(getDaDangKyNhanSMS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daDangKyChuyenPhatNhanh</column-name><column-value><![CDATA[");
		sb.append(getDaDangKyChuyenPhatNhanh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>diaChiChuHoSo</column-name><column-value><![CDATA[");
		sb.append(getDiaChiChuHoSo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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