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

import org.oep.cmon.dao.dvc.model.DanhMucGiayTo2DoiTuongSuDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DanhMucGiayTo2DoiTuongSuDung in entity cache.
 *
 * @author liemnn
 * @see DanhMucGiayTo2DoiTuongSuDung
 * @generated
 */
public class DanhMucGiayTo2DoiTuongSuDungCacheModel implements CacheModel<DanhMucGiayTo2DoiTuongSuDung>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", loaiGiayToId=");
		sb.append(loaiGiayToId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	public DanhMucGiayTo2DoiTuongSuDung toEntityModel() {
		DanhMucGiayTo2DoiTuongSuDungImpl danhMucGiayTo2DoiTuongSuDungImpl = new DanhMucGiayTo2DoiTuongSuDungImpl();

		danhMucGiayTo2DoiTuongSuDungImpl.setId(id);

		if (ngayTao == Long.MIN_VALUE) {
			danhMucGiayTo2DoiTuongSuDungImpl.setNgayTao(null);
		}
		else {
			danhMucGiayTo2DoiTuongSuDungImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			danhMucGiayTo2DoiTuongSuDungImpl.setNgaySua(null);
		}
		else {
			danhMucGiayTo2DoiTuongSuDungImpl.setNgaySua(new Date(ngaySua));
		}

		danhMucGiayTo2DoiTuongSuDungImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			danhMucGiayTo2DoiTuongSuDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			danhMucGiayTo2DoiTuongSuDungImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			danhMucGiayTo2DoiTuongSuDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			danhMucGiayTo2DoiTuongSuDungImpl.setNguoiSua(nguoiSua);
		}

		danhMucGiayTo2DoiTuongSuDungImpl.setLoaiDoiTuongId(loaiDoiTuongId);
		danhMucGiayTo2DoiTuongSuDungImpl.setLoaiGiayToId(loaiGiayToId);
		danhMucGiayTo2DoiTuongSuDungImpl.setTrangThai(trangThai);

		danhMucGiayTo2DoiTuongSuDungImpl.resetOriginalValues();

		return danhMucGiayTo2DoiTuongSuDungImpl;
	}

	public long id;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long loaiDoiTuongId;
	public long loaiGiayToId;
	public int trangThai;
}