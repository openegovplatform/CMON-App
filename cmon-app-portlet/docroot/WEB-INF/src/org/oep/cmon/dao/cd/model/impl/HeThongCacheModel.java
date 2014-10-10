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

package org.oep.cmon.dao.cd.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.cd.model.HeThong;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HeThong in entity cache.
 *
 * @author LIEMNN
 * @see HeThong
 * @generated
 */
public class HeThongCacheModel implements CacheModel<HeThong>, Serializable {
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
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	public HeThong toEntityModel() {
		HeThongImpl heThongImpl = new HeThongImpl();

		heThongImpl.setId(id);

		if (ma == null) {
			heThongImpl.setMa(StringPool.BLANK);
		}
		else {
			heThongImpl.setMa(ma);
		}

		if (ten == null) {
			heThongImpl.setTen(StringPool.BLANK);
		}
		else {
			heThongImpl.setTen(ten);
		}

		if (moTa == null) {
			heThongImpl.setMoTa(StringPool.BLANK);
		}
		else {
			heThongImpl.setMoTa(moTa);
		}

		if (ngayTao == Long.MIN_VALUE) {
			heThongImpl.setNgayTao(null);
		}
		else {
			heThongImpl.setNgayTao(new Date(ngayTao));
		}

		heThongImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			heThongImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			heThongImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			heThongImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			heThongImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			heThongImpl.setNgaySua(null);
		}
		else {
			heThongImpl.setNgaySua(new Date(ngaySua));
		}

		heThongImpl.setTrangThai(trangThai);

		heThongImpl.resetOriginalValues();

		return heThongImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String moTa;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
	public int trangThai;
}