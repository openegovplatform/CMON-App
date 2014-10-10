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

import org.oep.cmon.dao.dvc.model.TTHC2DoiTuongSuDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TTHC2DoiTuongSuDung in entity cache.
 *
 * @author liemnn
 * @see TTHC2DoiTuongSuDung
 * @generated
 */
public class TTHC2DoiTuongSuDungCacheModel implements CacheModel<TTHC2DoiTuongSuDung>,
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
		sb.append(", thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	public TTHC2DoiTuongSuDung toEntityModel() {
		TTHC2DoiTuongSuDungImpl tthc2DoiTuongSuDungImpl = new TTHC2DoiTuongSuDungImpl();

		tthc2DoiTuongSuDungImpl.setId(id);

		if (ngayTao == Long.MIN_VALUE) {
			tthc2DoiTuongSuDungImpl.setNgayTao(null);
		}
		else {
			tthc2DoiTuongSuDungImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			tthc2DoiTuongSuDungImpl.setNgaySua(null);
		}
		else {
			tthc2DoiTuongSuDungImpl.setNgaySua(new Date(ngaySua));
		}

		tthc2DoiTuongSuDungImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			tthc2DoiTuongSuDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			tthc2DoiTuongSuDungImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			tthc2DoiTuongSuDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			tthc2DoiTuongSuDungImpl.setNguoiSua(nguoiSua);
		}

		tthc2DoiTuongSuDungImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		tthc2DoiTuongSuDungImpl.setLoaiDoiTuongId(loaiDoiTuongId);
		tthc2DoiTuongSuDungImpl.setTrangThai(trangThai);

		tthc2DoiTuongSuDungImpl.resetOriginalValues();

		return tthc2DoiTuongSuDungImpl;
	}

	public long id;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long thuTucHanhChinhId;
	public long loaiDoiTuongId;
	public int trangThai;
}