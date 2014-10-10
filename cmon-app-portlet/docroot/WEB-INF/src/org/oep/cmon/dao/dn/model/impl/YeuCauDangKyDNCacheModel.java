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

import org.oep.cmon.dao.dn.model.YeuCauDangKyDN;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YeuCauDangKyDN in entity cache.
 *
 * @author Liemnn
 * @see YeuCauDangKyDN
 * @generated
 */
public class YeuCauDangKyDNCacheModel implements CacheModel<YeuCauDangKyDN>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{id=");
		sb.append(id);
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
		sb.append(", soCmnd=");
		sb.append(soCmnd);
		sb.append(", ngayCapCmnd=");
		sb.append(ngayCapCmnd);
		sb.append(", noiCapCmndId=");
		sb.append(noiCapCmndId);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", truSoTinhId=");
		sb.append(truSoTinhId);
		sb.append(", truSoHuyenId=");
		sb.append(truSoHuyenId);
		sb.append(", truSoXaId=");
		sb.append(truSoXaId);
		sb.append(", truSo=");
		sb.append(truSo);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", loaiHinhDoanhNghiepId=");
		sb.append(loaiHinhDoanhNghiepId);
		sb.append("}");

		return sb.toString();
	}

	public YeuCauDangKyDN toEntityModel() {
		YeuCauDangKyDNImpl yeuCauDangKyDNImpl = new YeuCauDangKyDNImpl();

		yeuCauDangKyDNImpl.setId(id);

		if (ten == null) {
			yeuCauDangKyDNImpl.setTen(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setTen(ten);
		}

		if (maSoThue == null) {
			yeuCauDangKyDNImpl.setMaSoThue(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setMaSoThue(maSoThue);
		}

		if (maGiayPhep == null) {
			yeuCauDangKyDNImpl.setMaGiayPhep(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setMaGiayPhep(maGiayPhep);
		}

		if (ngayCap == Long.MIN_VALUE) {
			yeuCauDangKyDNImpl.setNgayCap(null);
		}
		else {
			yeuCauDangKyDNImpl.setNgayCap(new Date(ngayCap));
		}

		if (email == null) {
			yeuCauDangKyDNImpl.setEmail(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setEmail(email);
		}

		if (hoNguoiDaiDien == null) {
			yeuCauDangKyDNImpl.setHoNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setHoNguoiDaiDien(hoNguoiDaiDien);
		}

		if (tenDemNguoiDaiDien == null) {
			yeuCauDangKyDNImpl.setTenDemNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setTenDemNguoiDaiDien(tenDemNguoiDaiDien);
		}

		if (tenNguoiDaiDien == null) {
			yeuCauDangKyDNImpl.setTenNguoiDaiDien(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setTenNguoiDaiDien(tenNguoiDaiDien);
		}

		if (soCmnd == null) {
			yeuCauDangKyDNImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setSoCmnd(soCmnd);
		}

		if (ngayCapCmnd == Long.MIN_VALUE) {
			yeuCauDangKyDNImpl.setNgayCapCmnd(null);
		}
		else {
			yeuCauDangKyDNImpl.setNgayCapCmnd(new Date(ngayCapCmnd));
		}

		yeuCauDangKyDNImpl.setNoiCapCmndId(noiCapCmndId);

		if (moTa == null) {
			yeuCauDangKyDNImpl.setMoTa(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setMoTa(moTa);
		}

		yeuCauDangKyDNImpl.setLoaiDoiTuongId(loaiDoiTuongId);
		yeuCauDangKyDNImpl.setTruSoTinhId(truSoTinhId);
		yeuCauDangKyDNImpl.setTruSoHuyenId(truSoHuyenId);
		yeuCauDangKyDNImpl.setTruSoXaId(truSoXaId);

		if (truSo == null) {
			yeuCauDangKyDNImpl.setTruSo(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setTruSo(truSo);
		}

		yeuCauDangKyDNImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			yeuCauDangKyDNImpl.setNgayTao(null);
		}
		else {
			yeuCauDangKyDNImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			yeuCauDangKyDNImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			yeuCauDangKyDNImpl.setNgaySua(null);
		}
		else {
			yeuCauDangKyDNImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			yeuCauDangKyDNImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			yeuCauDangKyDNImpl.setNguoiSua(nguoiSua);
		}

		yeuCauDangKyDNImpl.setTrangThai(trangThai);
		yeuCauDangKyDNImpl.setLoaiHinhDoanhNghiepId(loaiHinhDoanhNghiepId);

		yeuCauDangKyDNImpl.resetOriginalValues();

		return yeuCauDangKyDNImpl;
	}

	public long id;
	public String ten;
	public String maSoThue;
	public String maGiayPhep;
	public long ngayCap;
	public String email;
	public String hoNguoiDaiDien;
	public String tenDemNguoiDaiDien;
	public String tenNguoiDaiDien;
	public String soCmnd;
	public long ngayCapCmnd;
	public Long noiCapCmndId;
	public String moTa;
	public Long loaiDoiTuongId;
	public Long truSoTinhId;
	public Long truSoHuyenId;
	public Long truSoXaId;
	public String truSo;
	public int daXoa;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int trangThai;
	public Long loaiHinhDoanhNghiepId;
}