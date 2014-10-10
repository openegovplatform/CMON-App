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

package org.oep.cmon.dao.cc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.cc.model.ChucVu;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChucVu in entity cache.
 *
 * @author Liemnn
 * @see ChucVu
 * @generated
 */
public class ChucVuCacheModel implements CacheModel<ChucVu>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public ChucVu toEntityModel() {
		ChucVuImpl chucVuImpl = new ChucVuImpl();

		chucVuImpl.setId(id);

		if (ma == null) {
			chucVuImpl.setMa(StringPool.BLANK);
		}
		else {
			chucVuImpl.setMa(ma);
		}

		if (ten == null) {
			chucVuImpl.setTen(StringPool.BLANK);
		}
		else {
			chucVuImpl.setTen(ten);
		}

		chucVuImpl.setPhienBan(phienBan);

		if (ngayTao == Long.MIN_VALUE) {
			chucVuImpl.setNgayTao(null);
		}
		else {
			chucVuImpl.setNgayTao(new Date(ngayTao));
		}

		chucVuImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			chucVuImpl.setNgaySua(null);
		}
		else {
			chucVuImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			chucVuImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			chucVuImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			chucVuImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			chucVuImpl.setNguoiSua(nguoiSua);
		}

		chucVuImpl.resetOriginalValues();

		return chucVuImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long phienBan;
	public long ngayTao;
	public int daXoa;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
}