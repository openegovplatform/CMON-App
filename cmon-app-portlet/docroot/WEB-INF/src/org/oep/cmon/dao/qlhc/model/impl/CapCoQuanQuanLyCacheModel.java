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

package org.oep.cmon.dao.qlhc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.qlhc.model.CapCoQuanQuanLy;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CapCoQuanQuanLy in entity cache.
 *
 * @author LIEMNN
 * @see CapCoQuanQuanLy
 * @generated
 */
public class CapCoQuanQuanLyCacheModel implements CacheModel<CapCoQuanQuanLy>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public CapCoQuanQuanLy toEntityModel() {
		CapCoQuanQuanLyImpl capCoQuanQuanLyImpl = new CapCoQuanQuanLyImpl();

		capCoQuanQuanLyImpl.setId(id);

		if (ma == null) {
			capCoQuanQuanLyImpl.setMa(StringPool.BLANK);
		}
		else {
			capCoQuanQuanLyImpl.setMa(ma);
		}

		if (ten == null) {
			capCoQuanQuanLyImpl.setTen(StringPool.BLANK);
		}
		else {
			capCoQuanQuanLyImpl.setTen(ten);
		}

		capCoQuanQuanLyImpl.setCap(cap);
		capCoQuanQuanLyImpl.setChaId(chaId);

		if (ngayTao == Long.MIN_VALUE) {
			capCoQuanQuanLyImpl.setNgayTao(null);
		}
		else {
			capCoQuanQuanLyImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			capCoQuanQuanLyImpl.setNgaySua(null);
		}
		else {
			capCoQuanQuanLyImpl.setNgaySua(new Date(ngaySua));
		}

		capCoQuanQuanLyImpl.setDaXoa(daXoa);
		capCoQuanQuanLyImpl.setPhienBan(phienBan);

		if (nguoiTao == null) {
			capCoQuanQuanLyImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			capCoQuanQuanLyImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			capCoQuanQuanLyImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			capCoQuanQuanLyImpl.setNguoiSua(nguoiSua);
		}

		capCoQuanQuanLyImpl.resetOriginalValues();

		return capCoQuanQuanLyImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long cap;
	public Long chaId;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public int phienBan;
	public String nguoiTao;
	public String nguoiSua;
}