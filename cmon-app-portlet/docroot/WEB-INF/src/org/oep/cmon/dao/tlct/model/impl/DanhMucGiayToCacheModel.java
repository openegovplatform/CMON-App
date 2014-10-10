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

package org.oep.cmon.dao.tlct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.tlct.model.DanhMucGiayTo;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DanhMucGiayTo in entity cache.
 *
 * @author Liemnn
 * @see DanhMucGiayTo
 * @generated
 */
public class DanhMucGiayToCacheModel implements CacheModel<DanhMucGiayTo>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", mota=");
		sb.append(mota);
		sb.append(", gioiHanDungLuong=");
		sb.append(gioiHanDungLuong);
		sb.append(", kieuTaiLieu=");
		sb.append(kieuTaiLieu);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", tailieuThayTheId=");
		sb.append(tailieuThayTheId);
		sb.append("}");

		return sb.toString();
	}

	public DanhMucGiayTo toEntityModel() {
		DanhMucGiayToImpl danhMucGiayToImpl = new DanhMucGiayToImpl();

		danhMucGiayToImpl.setId(id);

		if (ma == null) {
			danhMucGiayToImpl.setMa(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setMa(ma);
		}

		if (ten == null) {
			danhMucGiayToImpl.setTen(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setTen(ten);
		}

		if (mota == null) {
			danhMucGiayToImpl.setMota(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setMota(mota);
		}

		danhMucGiayToImpl.setGioiHanDungLuong(gioiHanDungLuong);

		if (kieuTaiLieu == null) {
			danhMucGiayToImpl.setKieuTaiLieu(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setKieuTaiLieu(kieuTaiLieu);
		}

		if (nguoiTao == null) {
			danhMucGiayToImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			danhMucGiayToImpl.setNgayTao(null);
		}
		else {
			danhMucGiayToImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			danhMucGiayToImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			danhMucGiayToImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			danhMucGiayToImpl.setNgaySua(null);
		}
		else {
			danhMucGiayToImpl.setNgaySua(new Date(ngaySua));
		}

		danhMucGiayToImpl.setDaXoa(daXoa);
		danhMucGiayToImpl.setPhienBan(phienBan);
		danhMucGiayToImpl.setTailieuThayTheId(tailieuThayTheId);

		danhMucGiayToImpl.resetOriginalValues();

		return danhMucGiayToImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String mota;
	public long gioiHanDungLuong;
	public String kieuTaiLieu;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public int daXoa;
	public long phienBan;
	public Long tailieuThayTheId;
}