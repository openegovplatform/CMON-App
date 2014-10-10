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

import org.oep.cmon.dao.cd.model.NgheNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NgheNghiep in entity cache.
 *
 * @author LIEMNN
 * @see NgheNghiep
 * @generated
 */
public class NgheNghiepCacheModel implements CacheModel<NgheNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
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
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append("}");

		return sb.toString();
	}

	public NgheNghiep toEntityModel() {
		NgheNghiepImpl ngheNghiepImpl = new NgheNghiepImpl();

		ngheNghiepImpl.setId(id);

		if (ma == null) {
			ngheNghiepImpl.setMa(StringPool.BLANK);
		}
		else {
			ngheNghiepImpl.setMa(ma);
		}

		if (ten == null) {
			ngheNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			ngheNghiepImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			ngheNghiepImpl.setNgayTao(null);
		}
		else {
			ngheNghiepImpl.setNgayTao(new Date(ngayTao));
		}

		ngheNghiepImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			ngheNghiepImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			ngheNghiepImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			ngheNghiepImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			ngheNghiepImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			ngheNghiepImpl.setNgaySua(null);
		}
		else {
			ngheNghiepImpl.setNgaySua(new Date(ngaySua));
		}

		ngheNghiepImpl.setPhienBan(phienBan);

		ngheNghiepImpl.resetOriginalValues();

		return ngheNghiepImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
	public long phienBan;
}