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

import org.oep.exch.dao.hoso.model.KetQuaHoso;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing KetQuaHoso in entity cache.
 *
 * @author NAM
 * @see KetQuaHoso
 * @generated
 */
public class KetQuaHosoCacheModel implements CacheModel<KetQuaHoso>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", NgayChuyen=");
		sb.append(NgayChuyen);
		sb.append(", MaSoHoSo=");
		sb.append(MaSoHoSo);
		sb.append(", TenNguoiNhanKetQua=");
		sb.append(TenNguoiNhanKetQua);
		sb.append(", NgayNhanKetQua=");
		sb.append(NgayNhanKetQua);
		sb.append(", LePhiHoSo=");
		sb.append(LePhiHoSo);
		sb.append(", PhiXuLyHoSo=");
		sb.append(PhiXuLyHoSo);
		sb.append(", NgayHoanThanh=");
		sb.append(NgayHoanThanh);
		sb.append(", MaCanBoTraKetQua=");
		sb.append(MaCanBoTraKetQua);
		sb.append(", TenCanBoTraKetQua=");
		sb.append(TenCanBoTraKetQua);
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

	public KetQuaHoso toEntityModel() {
		KetQuaHosoImpl ketQuaHosoImpl = new KetQuaHosoImpl();

		ketQuaHosoImpl.setId(id);

		if (NgayChuyen == Long.MIN_VALUE) {
			ketQuaHosoImpl.setNgayChuyen(null);
		}
		else {
			ketQuaHosoImpl.setNgayChuyen(new Date(NgayChuyen));
		}

		if (MaSoHoSo == null) {
			ketQuaHosoImpl.setMaSoHoSo(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setMaSoHoSo(MaSoHoSo);
		}

		if (TenNguoiNhanKetQua == null) {
			ketQuaHosoImpl.setTenNguoiNhanKetQua(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setTenNguoiNhanKetQua(TenNguoiNhanKetQua);
		}

		if (NgayNhanKetQua == null) {
			ketQuaHosoImpl.setNgayNhanKetQua(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setNgayNhanKetQua(NgayNhanKetQua);
		}

		ketQuaHosoImpl.setLePhiHoSo(LePhiHoSo);
		ketQuaHosoImpl.setPhiXuLyHoSo(PhiXuLyHoSo);

		if (NgayHoanThanh == null) {
			ketQuaHosoImpl.setNgayHoanThanh(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setNgayHoanThanh(NgayHoanThanh);
		}

		if (MaCanBoTraKetQua == null) {
			ketQuaHosoImpl.setMaCanBoTraKetQua(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setMaCanBoTraKetQua(MaCanBoTraKetQua);
		}

		if (TenCanBoTraKetQua == null) {
			ketQuaHosoImpl.setTenCanBoTraKetQua(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setTenCanBoTraKetQua(TenCanBoTraKetQua);
		}

		if (DonViCungCap == null) {
			ketQuaHosoImpl.setDonViCungCap(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setDonViCungCap(DonViCungCap);
		}

		ketQuaHosoImpl.setTrangThaiXuLy(TrangThaiXuLy);

		if (NgayXuLy == Long.MIN_VALUE) {
			ketQuaHosoImpl.setNgayXuLy(null);
		}
		else {
			ketQuaHosoImpl.setNgayXuLy(new Date(NgayXuLy));
		}

		if (LoiKhiXuLy == null) {
			ketQuaHosoImpl.setLoiKhiXuLy(StringPool.BLANK);
		}
		else {
			ketQuaHosoImpl.setLoiKhiXuLy(LoiKhiXuLy);
		}

		ketQuaHosoImpl.resetOriginalValues();

		return ketQuaHosoImpl;
	}

	public long id;
	public long NgayChuyen;
	public String MaSoHoSo;
	public String TenNguoiNhanKetQua;
	public String NgayNhanKetQua;
	public int LePhiHoSo;
	public int PhiXuLyHoSo;
	public String NgayHoanThanh;
	public String MaCanBoTraKetQua;
	public String TenCanBoTraKetQua;
	public String DonViCungCap;
	public int TrangThaiXuLy;
	public long NgayXuLy;
	public String LoiKhiXuLy;
}