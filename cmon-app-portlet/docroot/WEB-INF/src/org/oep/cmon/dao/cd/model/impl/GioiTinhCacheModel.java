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

import org.oep.cmon.dao.cd.model.GioiTinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing GioiTinh in entity cache.
 *
 * @author LIEMNN
 * @see GioiTinh
 * @generated
 */
public class GioiTinhCacheModel implements CacheModel<GioiTinh>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public GioiTinh toEntityModel() {
		GioiTinhImpl gioiTinhImpl = new GioiTinhImpl();

		gioiTinhImpl.setId(id);

		if (ten == null) {
			gioiTinhImpl.setTen(StringPool.BLANK);
		}
		else {
			gioiTinhImpl.setTen(ten);
		}

		if (ma == null) {
			gioiTinhImpl.setMa(StringPool.BLANK);
		}
		else {
			gioiTinhImpl.setMa(ma);
		}

		if (ngayTao == Long.MIN_VALUE) {
			gioiTinhImpl.setNgayTao(null);
		}
		else {
			gioiTinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			gioiTinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			gioiTinhImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			gioiTinhImpl.setNgaySua(null);
		}
		else {
			gioiTinhImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			gioiTinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			gioiTinhImpl.setNguoiSua(nguoiSua);
		}

		gioiTinhImpl.setDaXoa(daXoa);

		gioiTinhImpl.resetOriginalValues();

		return gioiTinhImpl;
	}

	public long id;
	public String ten;
	public String ma;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int daXoa;
}