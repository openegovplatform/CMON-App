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

import org.oep.exch.dao.hoso.model.TrangThaiHoso;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiHoso in entity cache.
 *
 * @author NAM
 * @see TrangThaiHoso
 * @generated
 */
public class TrangThaiHosoCacheModel implements CacheModel<TrangThaiHoso>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{id=");
		sb.append(id);
		sb.append(", NgayChuyen=");
		sb.append(NgayChuyen);
		sb.append(", OnlineId=");
		sb.append(OnlineId);
		sb.append(", MaSoHoSo=");
		sb.append(MaSoHoSo);
		sb.append(", NgayHenTra=");
		sb.append(NgayHenTra);
		sb.append(", MaNguoiXuLyHienTai=");
		sb.append(MaNguoiXuLyHienTai);
		sb.append(", TenNguoiXuLyHienTai=");
		sb.append(TenNguoiXuLyHienTai);
		sb.append(", TenPhongBanXuLyHienTai=");
		sb.append(TenPhongBanXuLyHienTai);
		sb.append(", NgayGioLuanChuyen=");
		sb.append(NgayGioLuanChuyen);
		sb.append(", SoGioYeuCauXuLy=");
		sb.append(SoGioYeuCauXuLy);
		sb.append(", NoiDungYeuCauXuLy=");
		sb.append(NoiDungYeuCauXuLy);
		sb.append(", SoGioThucHien=");
		sb.append(SoGioThucHien);
		sb.append(", TrangThaiHienTai=");
		sb.append(TrangThaiHienTai);
		sb.append(", MaNguoiXuLyKeTiep=");
		sb.append(MaNguoiXuLyKeTiep);
		sb.append(", TenNguoiXuLyKeTiep=");
		sb.append(TenNguoiXuLyKeTiep);
		sb.append(", TenPhongBanXuLyKeTiep=");
		sb.append(TenPhongBanXuLyKeTiep);
		sb.append(", TrangThaiKeTiep=");
		sb.append(TrangThaiKeTiep);
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

	public TrangThaiHoso toEntityModel() {
		TrangThaiHosoImpl trangThaiHosoImpl = new TrangThaiHosoImpl();

		trangThaiHosoImpl.setId(id);

		if (NgayChuyen == Long.MIN_VALUE) {
			trangThaiHosoImpl.setNgayChuyen(null);
		}
		else {
			trangThaiHosoImpl.setNgayChuyen(new Date(NgayChuyen));
		}

		trangThaiHosoImpl.setOnlineId(OnlineId);

		if (MaSoHoSo == null) {
			trangThaiHosoImpl.setMaSoHoSo(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setMaSoHoSo(MaSoHoSo);
		}

		if (NgayHenTra == null) {
			trangThaiHosoImpl.setNgayHenTra(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setNgayHenTra(NgayHenTra);
		}

		if (MaNguoiXuLyHienTai == null) {
			trangThaiHosoImpl.setMaNguoiXuLyHienTai(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setMaNguoiXuLyHienTai(MaNguoiXuLyHienTai);
		}

		if (TenNguoiXuLyHienTai == null) {
			trangThaiHosoImpl.setTenNguoiXuLyHienTai(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setTenNguoiXuLyHienTai(TenNguoiXuLyHienTai);
		}

		if (TenPhongBanXuLyHienTai == null) {
			trangThaiHosoImpl.setTenPhongBanXuLyHienTai(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setTenPhongBanXuLyHienTai(TenPhongBanXuLyHienTai);
		}

		if (NgayGioLuanChuyen == null) {
			trangThaiHosoImpl.setNgayGioLuanChuyen(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setNgayGioLuanChuyen(NgayGioLuanChuyen);
		}

		trangThaiHosoImpl.setSoGioYeuCauXuLy(SoGioYeuCauXuLy);

		if (NoiDungYeuCauXuLy == null) {
			trangThaiHosoImpl.setNoiDungYeuCauXuLy(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setNoiDungYeuCauXuLy(NoiDungYeuCauXuLy);
		}

		trangThaiHosoImpl.setSoGioThucHien(SoGioThucHien);
		trangThaiHosoImpl.setTrangThaiHienTai(TrangThaiHienTai);

		if (MaNguoiXuLyKeTiep == null) {
			trangThaiHosoImpl.setMaNguoiXuLyKeTiep(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setMaNguoiXuLyKeTiep(MaNguoiXuLyKeTiep);
		}

		if (TenNguoiXuLyKeTiep == null) {
			trangThaiHosoImpl.setTenNguoiXuLyKeTiep(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setTenNguoiXuLyKeTiep(TenNguoiXuLyKeTiep);
		}

		if (TenPhongBanXuLyKeTiep == null) {
			trangThaiHosoImpl.setTenPhongBanXuLyKeTiep(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setTenPhongBanXuLyKeTiep(TenPhongBanXuLyKeTiep);
		}

		trangThaiHosoImpl.setTrangThaiKeTiep(TrangThaiKeTiep);

		if (DonViCungCap == null) {
			trangThaiHosoImpl.setDonViCungCap(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setDonViCungCap(DonViCungCap);
		}

		trangThaiHosoImpl.setTrangThaiXuLy(TrangThaiXuLy);

		if (NgayXuLy == Long.MIN_VALUE) {
			trangThaiHosoImpl.setNgayXuLy(null);
		}
		else {
			trangThaiHosoImpl.setNgayXuLy(new Date(NgayXuLy));
		}

		if (LoiKhiXuLy == null) {
			trangThaiHosoImpl.setLoiKhiXuLy(StringPool.BLANK);
		}
		else {
			trangThaiHosoImpl.setLoiKhiXuLy(LoiKhiXuLy);
		}

		trangThaiHosoImpl.resetOriginalValues();

		return trangThaiHosoImpl;
	}

	public long id;
	public long NgayChuyen;
	public long OnlineId;
	public String MaSoHoSo;
	public String NgayHenTra;
	public String MaNguoiXuLyHienTai;
	public String TenNguoiXuLyHienTai;
	public String TenPhongBanXuLyHienTai;
	public String NgayGioLuanChuyen;
	public int SoGioYeuCauXuLy;
	public String NoiDungYeuCauXuLy;
	public int SoGioThucHien;
	public int TrangThaiHienTai;
	public String MaNguoiXuLyKeTiep;
	public String TenNguoiXuLyKeTiep;
	public String TenPhongBanXuLyKeTiep;
	public int TrangThaiKeTiep;
	public String DonViCungCap;
	public int TrangThaiXuLy;
	public long NgayXuLy;
	public String LoiKhiXuLy;
}