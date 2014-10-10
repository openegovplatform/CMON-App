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

import org.oep.cmon.dao.dn.model.TrangThaiDoanhNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiDoanhNghiep in entity cache.
 *
 * @author Liemnn
 * @see TrangThaiDoanhNghiep
 * @generated
 */
public class TrangThaiDoanhNghiepCacheModel implements CacheModel<TrangThaiDoanhNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
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
		sb.append("}");

		return sb.toString();
	}

	public TrangThaiDoanhNghiep toEntityModel() {
		TrangThaiDoanhNghiepImpl trangThaiDoanhNghiepImpl = new TrangThaiDoanhNghiepImpl();

		trangThaiDoanhNghiepImpl.setId(id);

		if (ten == null) {
			trangThaiDoanhNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			trangThaiDoanhNghiepImpl.setTen(ten);
		}

		if (moTa == null) {
			trangThaiDoanhNghiepImpl.setMoTa(StringPool.BLANK);
		}
		else {
			trangThaiDoanhNghiepImpl.setMoTa(moTa);
		}

		if (nguoiTao == null) {
			trangThaiDoanhNghiepImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			trangThaiDoanhNghiepImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			trangThaiDoanhNghiepImpl.setNgayTao(null);
		}
		else {
			trangThaiDoanhNghiepImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			trangThaiDoanhNghiepImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			trangThaiDoanhNghiepImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			trangThaiDoanhNghiepImpl.setNgaySua(null);
		}
		else {
			trangThaiDoanhNghiepImpl.setNgaySua(new Date(ngaySua));
		}

		trangThaiDoanhNghiepImpl.setDaXoa(daXoa);

		trangThaiDoanhNghiepImpl.resetOriginalValues();

		return trangThaiDoanhNghiepImpl;
	}

	public long id;
	public String ten;
	public String moTa;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public int daXoa;
}