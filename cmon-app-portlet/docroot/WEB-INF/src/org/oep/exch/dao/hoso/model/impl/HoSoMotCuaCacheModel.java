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

import org.oep.exch.dao.hoso.model.HoSoMotCua;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoMotCua in entity cache.
 *
 * @author NAM
 * @see HoSoMotCua
 * @generated
 */
public class HoSoMotCuaCacheModel implements CacheModel<HoSoMotCua>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
		sb.append(", NgayChuyen=");
		sb.append(NgayChuyen);
		sb.append(", MaSoHoSo=");
		sb.append(MaSoHoSo);
		sb.append(", MaLoaiHoSo=");
		sb.append(MaLoaiHoSo);
		sb.append(", MaDonViTiepNhan=");
		sb.append(MaDonViTiepNhan);
		sb.append(", NgayNopHoSo=");
		sb.append(NgayNopHoSo);
		sb.append(", NgayHenTra=");
		sb.append(NgayHenTra);
		sb.append(", HoTenNguoiNop=");
		sb.append(HoTenNguoiNop);
		sb.append(", SoCmnd=");
		sb.append(SoCmnd);
		sb.append(", NgaySinh=");
		sb.append(NgaySinh);
		sb.append(", MaTinhThuongTru=");
		sb.append(MaTinhThuongTru);
		sb.append(", MoTaDiaChiThuongTru=");
		sb.append(MoTaDiaChiThuongTru);
		sb.append(", GioiTinh=");
		sb.append(GioiTinh);
		sb.append(", MaNguoiTiepNhan=");
		sb.append(MaNguoiTiepNhan);
		sb.append(", TenNguoiTiepNhan=");
		sb.append(TenNguoiTiepNhan);
		sb.append(", DonViCungCap=");
		sb.append(DonViCungCap);
		sb.append(", TrangThaiXuLy=");
		sb.append(TrangThaiXuLy);
		sb.append(", NgayXuLy=");
		sb.append(NgayXuLy);
		sb.append(", LoiKhiXuLy=");
		sb.append(LoiKhiXuLy);
		sb.append("}");

		return sb.toString();
	}

	public HoSoMotCua toEntityModel() {
		HoSoMotCuaImpl hoSoMotCuaImpl = new HoSoMotCuaImpl();

		hoSoMotCuaImpl.setId(id);

		if (NgayChuyen == Long.MIN_VALUE) {
			hoSoMotCuaImpl.setNgayChuyen(null);
		}
		else {
			hoSoMotCuaImpl.setNgayChuyen(new Date(NgayChuyen));
		}

		if (MaSoHoSo == null) {
			hoSoMotCuaImpl.setMaSoHoSo(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMaSoHoSo(MaSoHoSo);
		}

		if (MaLoaiHoSo == null) {
			hoSoMotCuaImpl.setMaLoaiHoSo(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMaLoaiHoSo(MaLoaiHoSo);
		}

		if (MaDonViTiepNhan == null) {
			hoSoMotCuaImpl.setMaDonViTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMaDonViTiepNhan(MaDonViTiepNhan);
		}

		if (NgayNopHoSo == null) {
			hoSoMotCuaImpl.setNgayNopHoSo(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setNgayNopHoSo(NgayNopHoSo);
		}

		if (NgayHenTra == null) {
			hoSoMotCuaImpl.setNgayHenTra(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setNgayHenTra(NgayHenTra);
		}

		if (HoTenNguoiNop == null) {
			hoSoMotCuaImpl.setHoTenNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setHoTenNguoiNop(HoTenNguoiNop);
		}

		if (SoCmnd == null) {
			hoSoMotCuaImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setSoCmnd(SoCmnd);
		}

		if (NgaySinh == null) {
			hoSoMotCuaImpl.setNgaySinh(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setNgaySinh(NgaySinh);
		}

		if (MaTinhThuongTru == null) {
			hoSoMotCuaImpl.setMaTinhThuongTru(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMaTinhThuongTru(MaTinhThuongTru);
		}

		if (MoTaDiaChiThuongTru == null) {
			hoSoMotCuaImpl.setMoTaDiaChiThuongTru(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMoTaDiaChiThuongTru(MoTaDiaChiThuongTru);
		}

		hoSoMotCuaImpl.setGioiTinh(GioiTinh);

		if (MaNguoiTiepNhan == null) {
			hoSoMotCuaImpl.setMaNguoiTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setMaNguoiTiepNhan(MaNguoiTiepNhan);
		}

		if (TenNguoiTiepNhan == null) {
			hoSoMotCuaImpl.setTenNguoiTiepNhan(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setTenNguoiTiepNhan(TenNguoiTiepNhan);
		}

		if (DonViCungCap == null) {
			hoSoMotCuaImpl.setDonViCungCap(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setDonViCungCap(DonViCungCap);
		}

		hoSoMotCuaImpl.setTrangThaiXuLy(TrangThaiXuLy);

		if (NgayXuLy == Long.MIN_VALUE) {
			hoSoMotCuaImpl.setNgayXuLy(null);
		}
		else {
			hoSoMotCuaImpl.setNgayXuLy(new Date(NgayXuLy));
		}

		if (LoiKhiXuLy == null) {
			hoSoMotCuaImpl.setLoiKhiXuLy(StringPool.BLANK);
		}
		else {
			hoSoMotCuaImpl.setLoiKhiXuLy(LoiKhiXuLy);
		}

		hoSoMotCuaImpl.resetOriginalValues();

		return hoSoMotCuaImpl;
	}

	public long id;
	public long NgayChuyen;
	public String MaSoHoSo;
	public String MaLoaiHoSo;
	public String MaDonViTiepNhan;
	public String NgayNopHoSo;
	public String NgayHenTra;
	public String HoTenNguoiNop;
	public String SoCmnd;
	public String NgaySinh;
	public String MaTinhThuongTru;
	public String MoTaDiaChiThuongTru;
	public int GioiTinh;
	public String MaNguoiTiepNhan;
	public String TenNguoiTiepNhan;
	public String DonViCungCap;
	public int TrangThaiXuLy;
	public long NgayXuLy;
	public String LoiKhiXuLy;
}