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

package org.oep.cmon.dao.dvc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dvc.model.NhomThuTucHanhChinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NhomThuTucHanhChinh in entity cache.
 *
 * @author liemnn
 * @see NhomThuTucHanhChinh
 * @generated
 */
public class NhomThuTucHanhChinhCacheModel implements CacheModel<NhomThuTucHanhChinh>,
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
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", danhMucUngDungId=");
		sb.append(danhMucUngDungId);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append("}");

		return sb.toString();
	}

	public NhomThuTucHanhChinh toEntityModel() {
		NhomThuTucHanhChinhImpl nhomThuTucHanhChinhImpl = new NhomThuTucHanhChinhImpl();

		nhomThuTucHanhChinhImpl.setId(id);

		if (ma == null) {
			nhomThuTucHanhChinhImpl.setMa(StringPool.BLANK);
		}
		else {
			nhomThuTucHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			nhomThuTucHanhChinhImpl.setTen(StringPool.BLANK);
		}
		else {
			nhomThuTucHanhChinhImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			nhomThuTucHanhChinhImpl.setNgayTao(null);
		}
		else {
			nhomThuTucHanhChinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			nhomThuTucHanhChinhImpl.setNgaySua(null);
		}
		else {
			nhomThuTucHanhChinhImpl.setNgaySua(new Date(ngaySua));
		}

		nhomThuTucHanhChinhImpl.setDaXoa(daXoa);

		if (nguoiSua == null) {
			nhomThuTucHanhChinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			nhomThuTucHanhChinhImpl.setNguoiSua(nguoiSua);
		}

		if (nguoiTao == null) {
			nhomThuTucHanhChinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			nhomThuTucHanhChinhImpl.setNguoiTao(nguoiTao);
		}

		nhomThuTucHanhChinhImpl.setDanhMucUngDungId(danhMucUngDungId);
		nhomThuTucHanhChinhImpl.setPhienBan(phienBan);

		nhomThuTucHanhChinhImpl.resetOriginalValues();

		return nhomThuTucHanhChinhImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiSua;
	public String nguoiTao;
	public long danhMucUngDungId;
	public long phienBan;
}