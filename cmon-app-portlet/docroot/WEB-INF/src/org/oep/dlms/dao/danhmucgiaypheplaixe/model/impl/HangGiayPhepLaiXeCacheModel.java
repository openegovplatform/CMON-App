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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;


import java.io.Serializable;

import java.util.Date;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.HangGiayPhepLaiXe;

/**
 * The cache model class for representing HangGiayPhepLaiXe in entity cache.
 *
 * @author AnhNT
 * @see HangGiayPhepLaiXe
 * @generated
 */
public class HangGiayPhepLaiXeCacheModel implements CacheModel<HangGiayPhepLaiXe>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenHang=");
		sb.append(tenHang);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", xoa=");
		sb.append(xoa);
		sb.append(", ma=");
		sb.append(ma);
		sb.append("}");

		return sb.toString();
	}

	public HangGiayPhepLaiXe toEntityModel() {
		HangGiayPhepLaiXeImpl hangGiayPhepLaiXeImpl = new HangGiayPhepLaiXeImpl();

		hangGiayPhepLaiXeImpl.setId(id);

		if (tenHang == null) {
			hangGiayPhepLaiXeImpl.setTenHang(StringPool.BLANK);
		}
		else {
			hangGiayPhepLaiXeImpl.setTenHang(tenHang);
		}

		if (ngayTao == Long.MIN_VALUE) {
			hangGiayPhepLaiXeImpl.setNgayTao(null);
		}
		else {
			hangGiayPhepLaiXeImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			hangGiayPhepLaiXeImpl.setNgaySua(null);
		}
		else {
			hangGiayPhepLaiXeImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			hangGiayPhepLaiXeImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			hangGiayPhepLaiXeImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			hangGiayPhepLaiXeImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			hangGiayPhepLaiXeImpl.setNguoiSua(nguoiSua);
		}

		hangGiayPhepLaiXeImpl.setXoa(xoa);

		if (ma == null) {
			hangGiayPhepLaiXeImpl.setMa(StringPool.BLANK);
		}
		else {
			hangGiayPhepLaiXeImpl.setMa(ma);
		}

		hangGiayPhepLaiXeImpl.resetOriginalValues();

		return hangGiayPhepLaiXeImpl;
	}

	public long id;
	public String tenHang;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int xoa;
	public String ma;
}