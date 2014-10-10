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

import org.oep.cmon.dao.dn.model.NganhNgheKinhDoanh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NganhNgheKinhDoanh in entity cache.
 *
 * @author Liemnn
 * @see NganhNgheKinhDoanh
 * @generated
 */
public class NganhNgheKinhDoanhCacheModel implements CacheModel<NganhNgheKinhDoanh>,
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
		sb.append(", chaId=");
		sb.append(chaId);
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
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append("}");

		return sb.toString();
	}

	public NganhNgheKinhDoanh toEntityModel() {
		NganhNgheKinhDoanhImpl nganhNgheKinhDoanhImpl = new NganhNgheKinhDoanhImpl();

		nganhNgheKinhDoanhImpl.setId(id);

		if (ma == null) {
			nganhNgheKinhDoanhImpl.setMa(StringPool.BLANK);
		}
		else {
			nganhNgheKinhDoanhImpl.setMa(ma);
		}

		if (ten == null) {
			nganhNgheKinhDoanhImpl.setTen(StringPool.BLANK);
		}
		else {
			nganhNgheKinhDoanhImpl.setTen(ten);
		}

		nganhNgheKinhDoanhImpl.setChaId(chaId);

		if (ngayTao == Long.MIN_VALUE) {
			nganhNgheKinhDoanhImpl.setNgayTao(null);
		}
		else {
			nganhNgheKinhDoanhImpl.setNgayTao(new Date(ngayTao));
		}

		nganhNgheKinhDoanhImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			nganhNgheKinhDoanhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			nganhNgheKinhDoanhImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			nganhNgheKinhDoanhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			nganhNgheKinhDoanhImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			nganhNgheKinhDoanhImpl.setNgaySua(null);
		}
		else {
			nganhNgheKinhDoanhImpl.setNgaySua(new Date(ngaySua));
		}

		nganhNgheKinhDoanhImpl.setCap(cap);
		nganhNgheKinhDoanhImpl.setPhienBan(phienBan);

		nganhNgheKinhDoanhImpl.resetOriginalValues();

		return nganhNgheKinhDoanhImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long chaId;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
	public long cap;
	public long phienBan;
}