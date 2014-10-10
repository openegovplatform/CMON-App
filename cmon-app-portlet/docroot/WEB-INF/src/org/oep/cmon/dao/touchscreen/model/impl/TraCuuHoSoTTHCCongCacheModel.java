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

package org.oep.cmon.dao.touchscreen.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.touchscreen.model.TraCuuHoSoTTHCCong;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TraCuuHoSoTTHCCong in entity cache.
 *
 * @author VIENPN
 * @see TraCuuHoSoTTHCCong
 * @generated
 */
public class TraCuuHoSoTTHCCongCacheModel implements CacheModel<TraCuuHoSoTTHCCong>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
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
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(hoTenNguoiNopHoSo);
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(diaChiThuongTruNguoiNop);
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(soDienThoaiDiDongNguoiNop);
		sb.append(", ngayKetThucXuLy=");
		sb.append(ngayKetThucXuLy);
		sb.append(", loaiHoSo=");
		sb.append(loaiHoSo);
		sb.append(", maSoBienNhan=");
		sb.append(maSoBienNhan);
		sb.append(", chuSoHuu=");
		sb.append(chuSoHuu);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append(", phiHoSo=");
		sb.append(phiHoSo);
		sb.append(", emailNguoiNop=");
		sb.append(emailNguoiNop);
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(soDienThoaiCoDinhNguoiNop);
		sb.append(", nhomThuTucHanhChinhTen=");
		sb.append(nhomThuTucHanhChinhTen);
		sb.append(", trangThaiHoSoTen=");
		sb.append(trangThaiHoSoTen);
		sb.append("}");

		return sb.toString();
	}

	public TraCuuHoSoTTHCCong toEntityModel() {
		TraCuuHoSoTTHCCongImpl traCuuHoSoTTHCCongImpl = new TraCuuHoSoTTHCCongImpl();

		traCuuHoSoTTHCCongImpl.setId(id);

		if (ngayNhanHoSo == Long.MIN_VALUE) {
			traCuuHoSoTTHCCongImpl.setNgayNhanHoSo(null);
		}
		else {
			traCuuHoSoTTHCCongImpl.setNgayNhanHoSo(new Date(ngayNhanHoSo));
		}

		if (tenCoQuanTiepNhan == null) {
			traCuuHoSoTTHCCongImpl.setTenCoQuanTiepNhan(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setTenCoQuanTiepNhan(tenCoQuanTiepNhan);
		}

		if (tenThuTucHanhChinh == null) {
			traCuuHoSoTTHCCongImpl.setTenThuTucHanhChinh(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setTenThuTucHanhChinh(tenThuTucHanhChinh);
		}

		if (ngayHenTraKetQua == Long.MIN_VALUE) {
			traCuuHoSoTTHCCongImpl.setNgayHenTraKetQua(null);
		}
		else {
			traCuuHoSoTTHCCongImpl.setNgayHenTraKetQua(new Date(
					ngayHenTraKetQua));
		}

		if (ngayTraKetQua == Long.MIN_VALUE) {
			traCuuHoSoTTHCCongImpl.setNgayTraKetQua(null);
		}
		else {
			traCuuHoSoTTHCCongImpl.setNgayTraKetQua(new Date(ngayTraKetQua));
		}

		if (hoTenNguoiNopHoSo == null) {
			traCuuHoSoTTHCCongImpl.setHoTenNguoiNopHoSo(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
		}

		if (diaChiThuongTruNguoiNop == null) {
			traCuuHoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
		}

		if (soDienThoaiDiDongNguoiNop == null) {
			traCuuHoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
		}

		if (ngayKetThucXuLy == Long.MIN_VALUE) {
			traCuuHoSoTTHCCongImpl.setNgayKetThucXuLy(null);
		}
		else {
			traCuuHoSoTTHCCongImpl.setNgayKetThucXuLy(new Date(ngayKetThucXuLy));
		}

		traCuuHoSoTTHCCongImpl.setLoaiHoSo(loaiHoSo);

		if (maSoBienNhan == null) {
			traCuuHoSoTTHCCongImpl.setMaSoBienNhan(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setMaSoBienNhan(maSoBienNhan);
		}

		if (chuSoHuu == null) {
			traCuuHoSoTTHCCongImpl.setChuSoHuu(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setChuSoHuu(chuSoHuu);
		}

		traCuuHoSoTTHCCongImpl.setLePhi(lePhi);
		traCuuHoSoTTHCCongImpl.setPhiHoSo(phiHoSo);

		if (emailNguoiNop == null) {
			traCuuHoSoTTHCCongImpl.setEmailNguoiNop(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setEmailNguoiNop(emailNguoiNop);
		}

		if (soDienThoaiCoDinhNguoiNop == null) {
			traCuuHoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
		}

		if (nhomThuTucHanhChinhTen == null) {
			traCuuHoSoTTHCCongImpl.setNhomThuTucHanhChinhTen(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinhTen);
		}

		if (trangThaiHoSoTen == null) {
			traCuuHoSoTTHCCongImpl.setTrangThaiHoSoTen(StringPool.BLANK);
		}
		else {
			traCuuHoSoTTHCCongImpl.setTrangThaiHoSoTen(trangThaiHoSoTen);
		}

		traCuuHoSoTTHCCongImpl.resetOriginalValues();

		return traCuuHoSoTTHCCongImpl;
	}

	public long id;
	public long ngayNhanHoSo;
	public String tenCoQuanTiepNhan;
	public String tenThuTucHanhChinh;
	public long ngayHenTraKetQua;
	public long ngayTraKetQua;
	public String hoTenNguoiNopHoSo;
	public String diaChiThuongTruNguoiNop;
	public String soDienThoaiDiDongNguoiNop;
	public long ngayKetThucXuLy;
	public int loaiHoSo;
	public String maSoBienNhan;
	public String chuSoHuu;
	public int lePhi;
	public int phiHoSo;
	public String emailNguoiNop;
	public String soDienThoaiCoDinhNguoiNop;
	public String nhomThuTucHanhChinhTen;
	public String trangThaiHoSoTen;
}