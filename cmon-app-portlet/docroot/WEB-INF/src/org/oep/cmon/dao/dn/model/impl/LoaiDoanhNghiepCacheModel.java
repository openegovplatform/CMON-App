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

import org.oep.cmon.dao.dn.model.LoaiDoanhNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LoaiDoanhNghiep in entity cache.
 *
 * @author Liemnn
 * @see LoaiDoanhNghiep
 * @generated
 */
public class LoaiDoanhNghiepCacheModel implements CacheModel<LoaiDoanhNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public LoaiDoanhNghiep toEntityModel() {
		LoaiDoanhNghiepImpl loaiDoanhNghiepImpl = new LoaiDoanhNghiepImpl();

		loaiDoanhNghiepImpl.setId(id);

		if (ma == null) {
			loaiDoanhNghiepImpl.setMa(StringPool.BLANK);
		}
		else {
			loaiDoanhNghiepImpl.setMa(ma);
		}

		if (ten == null) {
			loaiDoanhNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			loaiDoanhNghiepImpl.setTen(ten);
		}

		if (moTa == null) {
			loaiDoanhNghiepImpl.setMoTa(StringPool.BLANK);
		}
		else {
			loaiDoanhNghiepImpl.setMoTa(moTa);
		}

		if (ngayTao == Long.MIN_VALUE) {
			loaiDoanhNghiepImpl.setNgayTao(null);
		}
		else {
			loaiDoanhNghiepImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			loaiDoanhNghiepImpl.setNgaySua(null);
		}
		else {
			loaiDoanhNghiepImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			loaiDoanhNghiepImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			loaiDoanhNghiepImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			loaiDoanhNghiepImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			loaiDoanhNghiepImpl.setNguoiSua(nguoiSua);
		}

		loaiDoanhNghiepImpl.setPhienBan(phienBan);
		loaiDoanhNghiepImpl.setDaXoa(daXoa);

		loaiDoanhNghiepImpl.resetOriginalValues();

		return loaiDoanhNghiepImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String moTa;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int phienBan;
	public int daXoa;
}