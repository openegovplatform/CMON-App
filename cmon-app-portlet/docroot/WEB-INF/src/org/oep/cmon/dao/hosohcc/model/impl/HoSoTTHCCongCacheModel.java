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

package org.oep.cmon.dao.hosohcc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.hosohcc.model.HoSoTTHCCong;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoTTHCCong in entity cache.
 *
 * @author LIEMNn
 * @see HoSoTTHCCong
 * @generated
 */
public class HoSoTTHCCongCacheModel implements CacheModel<HoSoTTHCCong>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(159);

		sb.append("{id=");
		sb.append(id);
		sb.append(", maSoHoSo=");
		sb.append(maSoHoSo);
		sb.append(", ngayNopHoSo=");
		sb.append(ngayNopHoSo);
		sb.append(", ngayNhanHoSo=");
		sb.append(ngayNhanHoSo);
		sb.append(", tenCoQuanTiepNhan=");
		sb.append(tenCoQuanTiepNhan);
		sb.append(", tenThuTucHanhChinh=");
		sb.append(tenThuTucHanhChinh);
		sb.append(", ngayHenTraKetQua=");
		sb.append(ngayHenTraKetQua);
		sb.append(", ngayTraKetQua=");
		sb.append(ngayTraKetQua);
		sb.append(", ngayNopHoSoGoc=");
		sb.append(ngayNopHoSoGoc);
		sb.append(", ngayHenNopHoSoGoc=");
		sb.append(ngayHenNopHoSoGoc);
		sb.append(", tenCanBoTiepNhan=");
		sb.append(tenCanBoTiepNhan);
		sb.append(", chucVuCanBoTiepNhan=");
		sb.append(chucVuCanBoTiepNhan);
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(hoTenNguoiNopHoSo);
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(diaChiThuongTruNguoiNop);
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(soDienThoaiCoDinhNguoiNop);
		sb.append(", tenCanBoTraKetQua=");
		sb.append(tenCanBoTraKetQua);
		sb.append(", chucVuCanBoTraKetQua=");
		sb.append(chucVuCanBoTraKetQua);
		sb.append(", hoTenNguoiNhanKetQua=");
		sb.append(hoTenNguoiNhanKetQua);
		sb.append(", diaChiThuongTruNguoiNhanKQ=");
		sb.append(diaChiThuongTruNguoiNhanKQ);
		sb.append(", soDienThoaiNguoiNhan=");
		sb.append(soDienThoaiNguoiNhan);
		sb.append(", ngayCap=");
		sb.append(ngayCap);
		sb.append(", lanCap=");
		sb.append(lanCap);
		sb.append(", tenCoQuanCap=");
		sb.append(tenCoQuanCap);
		sb.append(", hieuLucTuNgay=");
		sb.append(hieuLucTuNgay);
		sb.append(", hieuLucDenNgay=");
		sb.append(hieuLucDenNgay);
		sb.append(", trangThaiHoSo=");
		sb.append(trangThaiHoSo);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", congDanNopId=");
		sb.append(congDanNopId);
		sb.append(", diaChiThuongTruNguoiNhanKQId=");
		sb.append(diaChiThuongTruNguoiNhanKQId);
		sb.append(", coQuanTiepNhanId=");
		sb.append(coQuanTiepNhanId);
		sb.append(", canBoTraKetQuaId=");
		sb.append(canBoTraKetQuaId);
		sb.append(", canBoTiepNhanId=");
		sb.append(canBoTiepNhanId);
		sb.append(", diaChiThuongTruNguoiNopId=");
		sb.append(diaChiThuongTruNguoiNopId);
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(soDienThoaiDiDongNguoiNop);
		sb.append(", phongBanXuLyHienThoiId=");
		sb.append(phongBanXuLyHienThoiId);
		sb.append(", tenPhongBanXuLyHienThoi=");
		sb.append(tenPhongBanXuLyHienThoi);
		sb.append(", canBoXuLyHienThoiId=");
		sb.append(canBoXuLyHienThoiId);
		sb.append(", tenCanBoXuLyHienThoi=");
		sb.append(tenCanBoXuLyHienThoi);
		sb.append(", danhGiaKetQua=");
		sb.append(danhGiaKetQua);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", ngayKetThucXuLy=");
		sb.append(ngayKetThucXuLy);
		sb.append(", loaiHoSo=");
		sb.append(loaiHoSo);
		sb.append(", yeuCauHuyHoSo=");
		sb.append(yeuCauHuyHoSo);
		sb.append(", maSoBienNhan=");
		sb.append(maSoBienNhan);
		sb.append(", tenBangChuaHoSo=");
		sb.append(tenBangChuaHoSo);
		sb.append(", chuSoHuu=");
		sb.append(chuSoHuu);
		sb.append(", soBoHoSo=");
		sb.append(soBoHoSo);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append(", phiHoSo=");
		sb.append(phiHoSo);
		sb.append(", trichYeu=");
		sb.append(trichYeu);
		sb.append(", ngayHenTBThue=");
		sb.append(ngayHenTBThue);
		sb.append(", emailNguoiNop=");
		sb.append(emailNguoiNop);
		sb.append(", maUngDung=");
		sb.append(maUngDung);
		sb.append(", daGuiGiayHen=");
		sb.append(daGuiGiayHen);
		sb.append(", nguoiDaiDienPhapLuat=");
		sb.append(nguoiDaiDienPhapLuat);
		sb.append(", nguoiDaiDienPhapLuatId=");
		sb.append(nguoiDaiDienPhapLuatId);
		sb.append(", chuyenSangMotCua=");
		sb.append(chuyenSangMotCua);
		sb.append(", doiTuongCanXuLyId=");
		sb.append(doiTuongCanXuLyId);
		sb.append(", lyDo=");
		sb.append(lyDo);
		sb.append(", moTaThanhPhanHoSo=");
		sb.append(moTaThanhPhanHoSo);
		sb.append(", lienKetThanhPhanHoSo=");
		sb.append(lienKetThanhPhanHoSo);
		sb.append(", soNgayXuLy=");
		sb.append(soNgayXuLy);
		sb.append(", daTraKetQuaTrucTuyen=");
		sb.append(daTraKetQuaTrucTuyen);
		sb.append(", eMailNguoiNhan=");
		sb.append(eMailNguoiNhan);
		sb.append(", ngaySinhNguoiNhan=");
		sb.append(ngaySinhNguoiNhan);
		sb.append(", dienThoiCoDinhNguoiNhan=");
		sb.append(dienThoiCoDinhNguoiNhan);
		sb.append(", cmndNguoiNhan=");
		sb.append(cmndNguoiNhan);
		sb.append(", gioiTinh=");
		sb.append(gioiTinh);
		sb.append(", dungXuLy=");
		sb.append(dungXuLy);
		sb.append(", ngayBoSung=");
		sb.append(ngayBoSung);
		sb.append(", ghiChuGiayToDinhKem=");
		sb.append(ghiChuGiayToDinhKem);
		sb.append(", daDangKyNhanSMS=");
		sb.append(daDangKyNhanSMS);
		sb.append(", daDangKyChuyenPhatNhanh=");
		sb.append(daDangKyChuyenPhatNhanh);
		sb.append(", diaChiChuHoSo=");
		sb.append(diaChiChuHoSo);
		sb.append("}");

		return sb.toString();
	}

	public HoSoTTHCCong toEntityModel() {
		HoSoTTHCCongImpl hoSoTTHCCongImpl = new HoSoTTHCCongImpl();

		hoSoTTHCCongImpl.setId(id);

		if (maSoHoSo == null) {
			hoSoTTHCCongImpl.setMaSoHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setMaSoHoSo(maSoHoSo);
		}

		if (ngayNopHoSo == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayNopHoSo(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayNopHoSo(new Date(ngayNopHoSo));
		}

		if (ngayNhanHoSo == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayNhanHoSo(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayNhanHoSo(new Date(ngayNhanHoSo));
		}

		if (tenCoQuanTiepNhan == null) {
			hoSoTTHCCongImpl.setTenCoQuanTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenCoQuanTiepNhan(tenCoQuanTiepNhan);
		}

		if (tenThuTucHanhChinh == null) {
			hoSoTTHCCongImpl.setTenThuTucHanhChinh(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenThuTucHanhChinh(tenThuTucHanhChinh);
		}

		if (ngayHenTraKetQua == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayHenTraKetQua(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayHenTraKetQua(new Date(ngayHenTraKetQua));
		}

		if (ngayTraKetQua == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayTraKetQua(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayTraKetQua(new Date(ngayTraKetQua));
		}

		if (ngayNopHoSoGoc == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayNopHoSoGoc(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayNopHoSoGoc(new Date(ngayNopHoSoGoc));
		}

		if (ngayHenNopHoSoGoc == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayHenNopHoSoGoc(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayHenNopHoSoGoc(new Date(ngayHenNopHoSoGoc));
		}

		if (tenCanBoTiepNhan == null) {
			hoSoTTHCCongImpl.setTenCanBoTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenCanBoTiepNhan(tenCanBoTiepNhan);
		}

		if (chucVuCanBoTiepNhan == null) {
			hoSoTTHCCongImpl.setChucVuCanBoTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setChucVuCanBoTiepNhan(chucVuCanBoTiepNhan);
		}

		if (hoTenNguoiNopHoSo == null) {
			hoSoTTHCCongImpl.setHoTenNguoiNopHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
		}

		if (diaChiThuongTruNguoiNop == null) {
			hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
		}

		if (soDienThoaiCoDinhNguoiNop == null) {
			hoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
		}

		if (tenCanBoTraKetQua == null) {
			hoSoTTHCCongImpl.setTenCanBoTraKetQua(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenCanBoTraKetQua(tenCanBoTraKetQua);
		}

		if (chucVuCanBoTraKetQua == null) {
			hoSoTTHCCongImpl.setChucVuCanBoTraKetQua(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setChucVuCanBoTraKetQua(chucVuCanBoTraKetQua);
		}

		if (hoTenNguoiNhanKetQua == null) {
			hoSoTTHCCongImpl.setHoTenNguoiNhanKetQua(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setHoTenNguoiNhanKetQua(hoTenNguoiNhanKetQua);
		}

		if (diaChiThuongTruNguoiNhanKQ == null) {
			hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNhanKQ(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNhanKQ(diaChiThuongTruNguoiNhanKQ);
		}

		if (soDienThoaiNguoiNhan == null) {
			hoSoTTHCCongImpl.setSoDienThoaiNguoiNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setSoDienThoaiNguoiNhan(soDienThoaiNguoiNhan);
		}

		if (ngayCap == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayCap(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayCap(new Date(ngayCap));
		}

		hoSoTTHCCongImpl.setLanCap(lanCap);

		if (tenCoQuanCap == null) {
			hoSoTTHCCongImpl.setTenCoQuanCap(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenCoQuanCap(tenCoQuanCap);
		}

		if (hieuLucTuNgay == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setHieuLucTuNgay(null);
		}
		else {
			hoSoTTHCCongImpl.setHieuLucTuNgay(new Date(hieuLucTuNgay));
		}

		if (hieuLucDenNgay == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setHieuLucDenNgay(null);
		}
		else {
			hoSoTTHCCongImpl.setHieuLucDenNgay(new Date(hieuLucDenNgay));
		}

		hoSoTTHCCongImpl.setTrangThaiHoSo(trangThaiHoSo);
		hoSoTTHCCongImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			hoSoTTHCCongImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayTao(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			hoSoTTHCCongImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgaySua(null);
		}
		else {
			hoSoTTHCCongImpl.setNgaySua(new Date(ngaySua));
		}

		hoSoTTHCCongImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		hoSoTTHCCongImpl.setCongDanNopId(congDanNopId);
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNhanKQId(diaChiThuongTruNguoiNhanKQId);
		hoSoTTHCCongImpl.setCoQuanTiepNhanId(coQuanTiepNhanId);
		hoSoTTHCCongImpl.setCanBoTraKetQuaId(canBoTraKetQuaId);
		hoSoTTHCCongImpl.setCanBoTiepNhanId(canBoTiepNhanId);
		hoSoTTHCCongImpl.setDiaChiThuongTruNguoiNopId(diaChiThuongTruNguoiNopId);

		if (soDienThoaiDiDongNguoiNop == null) {
			hoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
		}

		hoSoTTHCCongImpl.setPhongBanXuLyHienThoiId(phongBanXuLyHienThoiId);

		if (tenPhongBanXuLyHienThoi == null) {
			hoSoTTHCCongImpl.setTenPhongBanXuLyHienThoi(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenPhongBanXuLyHienThoi(tenPhongBanXuLyHienThoi);
		}

		hoSoTTHCCongImpl.setCanBoXuLyHienThoiId(canBoXuLyHienThoiId);

		if (tenCanBoXuLyHienThoi == null) {
			hoSoTTHCCongImpl.setTenCanBoXuLyHienThoi(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenCanBoXuLyHienThoi(tenCanBoXuLyHienThoi);
		}

		hoSoTTHCCongImpl.setDanhGiaKetQua(danhGiaKetQua);

		if (ghiChu == null) {
			hoSoTTHCCongImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setGhiChu(ghiChu);
		}

		if (ngayKetThucXuLy == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayKetThucXuLy(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayKetThucXuLy(new Date(ngayKetThucXuLy));
		}

		hoSoTTHCCongImpl.setLoaiHoSo(loaiHoSo);
		hoSoTTHCCongImpl.setYeuCauHuyHoSo(yeuCauHuyHoSo);

		if (maSoBienNhan == null) {
			hoSoTTHCCongImpl.setMaSoBienNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setMaSoBienNhan(maSoBienNhan);
		}

		if (tenBangChuaHoSo == null) {
			hoSoTTHCCongImpl.setTenBangChuaHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTenBangChuaHoSo(tenBangChuaHoSo);
		}

		if (chuSoHuu == null) {
			hoSoTTHCCongImpl.setChuSoHuu(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setChuSoHuu(chuSoHuu);
		}

		hoSoTTHCCongImpl.setSoBoHoSo(soBoHoSo);
		hoSoTTHCCongImpl.setLePhi(lePhi);
		hoSoTTHCCongImpl.setPhiHoSo(phiHoSo);

		if (trichYeu == null) {
			hoSoTTHCCongImpl.setTrichYeu(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setTrichYeu(trichYeu);
		}

		if (ngayHenTBThue == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayHenTBThue(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayHenTBThue(new Date(ngayHenTBThue));
		}

		if (emailNguoiNop == null) {
			hoSoTTHCCongImpl.setEmailNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setEmailNguoiNop(emailNguoiNop);
		}

		if (maUngDung == null) {
			hoSoTTHCCongImpl.setMaUngDung(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setMaUngDung(maUngDung);
		}

		hoSoTTHCCongImpl.setDaGuiGiayHen(daGuiGiayHen);

		if (nguoiDaiDienPhapLuat == null) {
			hoSoTTHCCongImpl.setNguoiDaiDienPhapLuat(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setNguoiDaiDienPhapLuat(nguoiDaiDienPhapLuat);
		}

		hoSoTTHCCongImpl.setNguoiDaiDienPhapLuatId(nguoiDaiDienPhapLuatId);
		hoSoTTHCCongImpl.setChuyenSangMotCua(chuyenSangMotCua);
		hoSoTTHCCongImpl.setDoiTuongCanXuLyId(doiTuongCanXuLyId);

		if (lyDo == null) {
			hoSoTTHCCongImpl.setLyDo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setLyDo(lyDo);
		}

		if (moTaThanhPhanHoSo == null) {
			hoSoTTHCCongImpl.setMoTaThanhPhanHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setMoTaThanhPhanHoSo(moTaThanhPhanHoSo);
		}

		if (lienKetThanhPhanHoSo == null) {
			hoSoTTHCCongImpl.setLienKetThanhPhanHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setLienKetThanhPhanHoSo(lienKetThanhPhanHoSo);
		}

		hoSoTTHCCongImpl.setSoNgayXuLy(soNgayXuLy);
		hoSoTTHCCongImpl.setDaTraKetQuaTrucTuyen(daTraKetQuaTrucTuyen);

		if (eMailNguoiNhan == null) {
			hoSoTTHCCongImpl.setEMailNguoiNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setEMailNguoiNhan(eMailNguoiNhan);
		}

		if (ngaySinhNguoiNhan == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgaySinhNguoiNhan(null);
		}
		else {
			hoSoTTHCCongImpl.setNgaySinhNguoiNhan(new Date(ngaySinhNguoiNhan));
		}

		if (dienThoiCoDinhNguoiNhan == null) {
			hoSoTTHCCongImpl.setDienThoiCoDinhNguoiNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setDienThoiCoDinhNguoiNhan(dienThoiCoDinhNguoiNhan);
		}

		if (cmndNguoiNhan == null) {
			hoSoTTHCCongImpl.setCmndNguoiNhan(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setCmndNguoiNhan(cmndNguoiNhan);
		}

		hoSoTTHCCongImpl.setGioiTinh(gioiTinh);
		hoSoTTHCCongImpl.setDungXuLy(dungXuLy);

		if (ngayBoSung == Long.MIN_VALUE) {
			hoSoTTHCCongImpl.setNgayBoSung(null);
		}
		else {
			hoSoTTHCCongImpl.setNgayBoSung(new Date(ngayBoSung));
		}

		if (ghiChuGiayToDinhKem == null) {
			hoSoTTHCCongImpl.setGhiChuGiayToDinhKem(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setGhiChuGiayToDinhKem(ghiChuGiayToDinhKem);
		}

		hoSoTTHCCongImpl.setDaDangKyNhanSMS(daDangKyNhanSMS);
		hoSoTTHCCongImpl.setDaDangKyChuyenPhatNhanh(daDangKyChuyenPhatNhanh);

		if (diaChiChuHoSo == null) {
			hoSoTTHCCongImpl.setDiaChiChuHoSo(StringPool.BLANK);
		}
		else {
			hoSoTTHCCongImpl.setDiaChiChuHoSo(diaChiChuHoSo);
		}

		hoSoTTHCCongImpl.resetOriginalValues();

		return hoSoTTHCCongImpl;
	}

	public long id;
	public String maSoHoSo;
	public long ngayNopHoSo;
	public long ngayNhanHoSo;
	public String tenCoQuanTiepNhan;
	public String tenThuTucHanhChinh;
	public long ngayHenTraKetQua;
	public long ngayTraKetQua;
	public long ngayNopHoSoGoc;
	public long ngayHenNopHoSoGoc;
	public String tenCanBoTiepNhan;
	public String chucVuCanBoTiepNhan;
	public String hoTenNguoiNopHoSo;
	public String diaChiThuongTruNguoiNop;
	public String soDienThoaiCoDinhNguoiNop;
	public String tenCanBoTraKetQua;
	public String chucVuCanBoTraKetQua;
	public String hoTenNguoiNhanKetQua;
	public String diaChiThuongTruNguoiNhanKQ;
	public String soDienThoaiNguoiNhan;
	public long ngayCap;
	public long lanCap;
	public String tenCoQuanCap;
	public long hieuLucTuNgay;
	public long hieuLucDenNgay;
	public int trangThaiHoSo;
	public int daXoa;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public Long thuTucHanhChinhId;
	public Long congDanNopId;
	public Long diaChiThuongTruNguoiNhanKQId;
	public Long coQuanTiepNhanId;
	public Long canBoTraKetQuaId;
	public Long canBoTiepNhanId;
	public Long diaChiThuongTruNguoiNopId;
	public String soDienThoaiDiDongNguoiNop;
	public Long phongBanXuLyHienThoiId;
	public String tenPhongBanXuLyHienThoi;
	public Long canBoXuLyHienThoiId;
	public String tenCanBoXuLyHienThoi;
	public int danhGiaKetQua;
	public String ghiChu;
	public long ngayKetThucXuLy;
	public int loaiHoSo;
	public int yeuCauHuyHoSo;
	public String maSoBienNhan;
	public String tenBangChuaHoSo;
	public String chuSoHuu;
	public int soBoHoSo;
	public int lePhi;
	public int phiHoSo;
	public String trichYeu;
	public long ngayHenTBThue;
	public String emailNguoiNop;
	public String maUngDung;
	public int daGuiGiayHen;
	public String nguoiDaiDienPhapLuat;
	public Long nguoiDaiDienPhapLuatId;
	public int chuyenSangMotCua;
	public Long doiTuongCanXuLyId;
	public String lyDo;
	public String moTaThanhPhanHoSo;
	public String lienKetThanhPhanHoSo;
	public Long soNgayXuLy;
	public Long daTraKetQuaTrucTuyen;
	public String eMailNguoiNhan;
	public long ngaySinhNguoiNhan;
	public String dienThoiCoDinhNguoiNhan;
	public String cmndNguoiNhan;
	public int gioiTinh;
	public boolean dungXuLy;
	public long ngayBoSung;
	public String ghiChuGiayToDinhKem;
	public int daDangKyNhanSMS;
	public int daDangKyChuyenPhatNhanh;
	public String diaChiChuHoSo;
}