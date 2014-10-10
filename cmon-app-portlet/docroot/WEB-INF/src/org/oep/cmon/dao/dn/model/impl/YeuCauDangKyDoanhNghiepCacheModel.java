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

package org.oep.cmon.dao.dn.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dn.model.YeuCauDangKyDoanhNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YeuCauDangKyDoanhNghiep in entity cache.
 *
 * @author Liemnn
 * @see YeuCauDangKyDoanhNghiep
 * @generated
 */
public class YeuCauDangKyDoanhNghiepCacheModel implements CacheModel<YeuCauDangKyDoanhNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(id);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", maSoThue=");
		sb.append(maSoThue);
		sb.append(", maGiayPhep=");
		sb.append(maGiayPhep);
		sb.append(", ngayCap=");
		sb.append(ngayCap);
		sb.append(", email=");
		sb.append(email);
		sb.append(", hoNguoiDaiDien=");
		sb.append(hoNguoiDaiDien);
		sb.append(", tenDemNguoiDaiDien=");
		sb.append(tenDemNguoiDaiDien);
		sb.append(", tenNguoiDaiDien=");
		sb.append(tenNguoiDaiDien);
		sb.append(", soCMND=");
		sb.append(soCMND);
		sb.append(", ngayCapCMND=");
		sb.append(ngayCapCMND);
		sb.append(", noiCapCMND=");
		sb.append(noiCapCMND);
		sb.append(", moTaNganhNgheKinhDoanh=");
		sb.append(moTaNganhNgheKinhDoanh);
		sb.append(", loaiHinhDoanhNghiep=");
		sb.append(loaiHinhDoanhNghiep);
		sb.append(", truSo=");
		sb.append(truSo);
		sb.append(", truSoXaId=");
		sb.append(truSoXaId);
		sb.append(", truSoHuyenId=");
		sb.append(truSoHuyenId);
		sb.append(", truSoTinhId=");
		sb.append(truSoTinhId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	public YeuCauDangKyDoanhNghiep toEntityModel() {
		YeuCauDangKyDoanhNghiepImpl yeuCauDangKyDoanhNghiepImpl = new YeuCauDangKyDoanhNghiepImpl();

		yeuCauDangKyDoanhNghiepImpl.setId(id);
		yeuCauDangKyDoanhNghiepImpl.setLoaiDoiTuongId(loaiDoiTuongId);

		if (ten == null) {
			yeuCauDangKyDoanhNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setTen(ten);
		}

		if (maSoThue == null) {
			yeuCauDangKyDoanhNghiepImpl.setMaSoThue(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setMaSoThue(maSoThue);
		}

		if (maGiayPhep == null) {
			yeuCauDangKyDoanhNghiepImpl.setMaGiayPhep(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setMaGiayPhep(maGiayPhep);
		}

		if (ngayCap == Long.MIN_VALUE) {
			yeuCauDangKyDoanhNghiepImpl.setNgayCap(null);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setNgayCap(new Date(ngayCap));
		}

		if (email == null) {
			yeuCauDangKyDoanhNghiepImpl.setEmail(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setEmail(email);
		}

		if (hoNguoiDaiDien == null) {
			yeuCauDangKyDoanhNghiepImpl.setHoNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setHoNguoiDaiDien(hoNguoiDaiDien);
		}

		if (tenDemNguoiDaiDien == null) {
			yeuCauDangKyDoanhNghiepImpl.setTenDemNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setTenDemNguoiDaiDien(tenDemNguoiDaiDien);
		}

		if (tenNguoiDaiDien == null) {
			yeuCauDangKyDoanhNghiepImpl.setTenNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setTenNguoiDaiDien(tenNguoiDaiDien);
		}

		if (soCMND == null) {
			yeuCauDangKyDoanhNghiepImpl.setSoCMND(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setSoCMND(soCMND);
		}

		if (ngayCapCMND == Long.MIN_VALUE) {
			yeuCauDangKyDoanhNghiepImpl.setNgayCapCMND(null);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setNgayCapCMND(new Date(ngayCapCMND));
		}

		if (noiCapCMND == null) {
			yeuCauDangKyDoanhNghiepImpl.setNoiCapCMND(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setNoiCapCMND(noiCapCMND);
		}

		if (moTaNganhNgheKinhDoanh == null) {
			yeuCauDangKyDoanhNghiepImpl.setMoTaNganhNgheKinhDoanh(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setMoTaNganhNgheKinhDoanh(moTaNganhNgheKinhDoanh);
		}

		if (loaiHinhDoanhNghiep == null) {
			yeuCauDangKyDoanhNghiepImpl.setLoaiHinhDoanhNghiep(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setLoaiHinhDoanhNghiep(loaiHinhDoanhNghiep);
		}

		if (truSo == null) {
			yeuCauDangKyDoanhNghiepImpl.setTruSo(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDoanhNghiepImpl.setTruSo(truSo);
		}

		yeuCauDangKyDoanhNghiepImpl.setTruSoXaId(truSoXaId);
		yeuCauDangKyDoanhNghiepImpl.setTruSoHuyenId(truSoHuyenId);
		yeuCauDangKyDoanhNghiepImpl.setTruSoTinhId(truSoTinhId);
		yeuCauDangKyDoanhNghiepImpl.setTrangThai(trangThai);

		yeuCauDangKyDoanhNghiepImpl.resetOriginalValues();

		return yeuCauDangKyDoanhNghiepImpl;
	}

	public long id;
	public long loaiDoiTuongId;
	public String ten;
	public String maSoThue;
	public String maGiayPhep;
	public long ngayCap;
	public String email;
	public String hoNguoiDaiDien;
	public String tenDemNguoiDaiDien;
	public String tenNguoiDaiDien;
	public String soCMND;
	public long ngayCapCMND;
	public String noiCapCMND;
	public String moTaNganhNgheKinhDoanh;
	public String loaiHinhDoanhNghiep;
	public String truSo;
	public long truSoXaId;
	public long truSoHuyenId;
	public long truSoTinhId;
	public int trangThai;
}