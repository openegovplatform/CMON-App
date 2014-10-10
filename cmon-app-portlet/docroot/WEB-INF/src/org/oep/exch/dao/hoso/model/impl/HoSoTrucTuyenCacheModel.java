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

package org.oep.exch.dao.hoso.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.exch.dao.hoso.model.HoSoTrucTuyen;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoTrucTuyen in entity cache.
 *
 * @author NAM
 * @see HoSoTrucTuyen
 * @generated
 */
public class HoSoTrucTuyenCacheModel implements CacheModel<HoSoTrucTuyen>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
		sb.append(", NgayTrichXuat=");
		sb.append(NgayTrichXuat);
		sb.append(", OnlineId=");
		sb.append(OnlineId);
		sb.append(", MaLoaiHoSo=");
		sb.append(MaLoaiHoSo);
		sb.append(", MaDonViTiepNhan=");
		sb.append(MaDonViTiepNhan);
		sb.append(", HoTenNguoiNop=");
		sb.append(HoTenNguoiNop);
		sb.append(", DiaChiNguoiNop=");
		sb.append(DiaChiNguoiNop);
		sb.append(", NgaySinh=");
		sb.append(NgaySinh);
		sb.append(", SoCmnd=");
		sb.append(SoCmnd);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", SoDtDiDong=");
		sb.append(SoDtDiDong);
		sb.append(", SoDtCoDinh=");
		sb.append(SoDtCoDinh);
		sb.append(", NgayDangKyHoSo=");
		sb.append(NgayDangKyHoSo);
		sb.append(", NoiChuyenHoSo=");
		sb.append(NoiChuyenHoSo);
		sb.append(", TrangThaiXuLy=");
		sb.append(TrangThaiXuLy);
		sb.append(", NgayChuyen=");
		sb.append(NgayChuyen);
		sb.append(", GioiTinh=");
		sb.append(GioiTinh);
		sb.append(", ChuSoHuuHoSo=");
		sb.append(ChuSoHuuHoSo);
		sb.append("}");

		return sb.toString();
	}

	public HoSoTrucTuyen toEntityModel() {
		HoSoTrucTuyenImpl hoSoTrucTuyenImpl = new HoSoTrucTuyenImpl();

		hoSoTrucTuyenImpl.setId(id);

		if (NgayTrichXuat == Long.MIN_VALUE) {
			hoSoTrucTuyenImpl.setNgayTrichXuat(null);
		}
		else {
			hoSoTrucTuyenImpl.setNgayTrichXuat(new Date(NgayTrichXuat));
		}

		hoSoTrucTuyenImpl.setOnlineId(OnlineId);

		if (MaLoaiHoSo == null) {
			hoSoTrucTuyenImpl.setMaLoaiHoSo(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setMaLoaiHoSo(MaLoaiHoSo);
		}

		if (MaDonViTiepNhan == null) {
			hoSoTrucTuyenImpl.setMaDonViTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setMaDonViTiepNhan(MaDonViTiepNhan);
		}

		if (HoTenNguoiNop == null) {
			hoSoTrucTuyenImpl.setHoTenNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setHoTenNguoiNop(HoTenNguoiNop);
		}

		if (DiaChiNguoiNop == null) {
			hoSoTrucTuyenImpl.setDiaChiNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setDiaChiNguoiNop(DiaChiNguoiNop);
		}

		if (NgaySinh == Long.MIN_VALUE) {
			hoSoTrucTuyenImpl.setNgaySinh(null);
		}
		else {
			hoSoTrucTuyenImpl.setNgaySinh(new Date(NgaySinh));
		}

		if (SoCmnd == null) {
			hoSoTrucTuyenImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setSoCmnd(SoCmnd);
		}

		if (Email == null) {
			hoSoTrucTuyenImpl.setEmail(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setEmail(Email);
		}

		if (SoDtDiDong == null) {
			hoSoTrucTuyenImpl.setSoDtDiDong(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setSoDtDiDong(SoDtDiDong);
		}

		if (SoDtCoDinh == null) {
			hoSoTrucTuyenImpl.setSoDtCoDinh(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setSoDtCoDinh(SoDtCoDinh);
		}

		if (NgayDangKyHoSo == Long.MIN_VALUE) {
			hoSoTrucTuyenImpl.setNgayDangKyHoSo(null);
		}
		else {
			hoSoTrucTuyenImpl.setNgayDangKyHoSo(new Date(NgayDangKyHoSo));
		}

		if (NoiChuyenHoSo == null) {
			hoSoTrucTuyenImpl.setNoiChuyenHoSo(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setNoiChuyenHoSo(NoiChuyenHoSo);
		}

		hoSoTrucTuyenImpl.setTrangThaiXuLy(TrangThaiXuLy);

		if (NgayChuyen == Long.MIN_VALUE) {
			hoSoTrucTuyenImpl.setNgayChuyen(null);
		}
		else {
			hoSoTrucTuyenImpl.setNgayChuyen(new Date(NgayChuyen));
		}

		hoSoTrucTuyenImpl.setGioiTinh(GioiTinh);

		if (ChuSoHuuHoSo == null) {
			hoSoTrucTuyenImpl.setChuSoHuuHoSo(StringPool.BLANK);
		}
		else {
			hoSoTrucTuyenImpl.setChuSoHuuHoSo(ChuSoHuuHoSo);
		}

		hoSoTrucTuyenImpl.resetOriginalValues();

		return hoSoTrucTuyenImpl;
	}

	public long id;
	public long NgayTrichXuat;
	public long OnlineId;
	public String MaLoaiHoSo;
	public String MaDonViTiepNhan;
	public String HoTenNguoiNop;
	public String DiaChiNguoiNop;
	public long NgaySinh;
	public String SoCmnd;
	public String Email;
	public String SoDtDiDong;
	public String SoDtCoDinh;
	public long NgayDangKyHoSo;
	public String NoiChuyenHoSo;
	public int TrangThaiXuLy;
	public long NgayChuyen;
	public int GioiTinh;
	public String ChuSoHuuHoSo;
}