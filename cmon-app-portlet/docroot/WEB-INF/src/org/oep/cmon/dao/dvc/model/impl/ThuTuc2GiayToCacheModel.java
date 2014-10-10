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

import org.oep.cmon.dao.dvc.model.ThuTuc2GiayTo;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ThuTuc2GiayTo in entity cache.
 *
 * @author liemnn
 * @see ThuTuc2GiayTo
 * @generated
 */
public class ThuTuc2GiayToCacheModel implements CacheModel<ThuTuc2GiayTo>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", batBuoc=");
		sb.append(batBuoc);
		sb.append(", thuTuHienThi=");
		sb.append(thuTuHienThi);
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
		sb.append(", danhMucGiayToId=");
		sb.append(danhMucGiayToId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", giaidoan=");
		sb.append(giaidoan);
		sb.append("}");

		return sb.toString();
	}

	public ThuTuc2GiayTo toEntityModel() {
		ThuTuc2GiayToImpl thuTuc2GiayToImpl = new ThuTuc2GiayToImpl();

		thuTuc2GiayToImpl.setId(id);

		if (ghiChu == null) {
			thuTuc2GiayToImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			thuTuc2GiayToImpl.setGhiChu(ghiChu);
		}

		thuTuc2GiayToImpl.setBatBuoc(batBuoc);
		thuTuc2GiayToImpl.setThuTuHienThi(thuTuHienThi);

		if (ngayTao == Long.MIN_VALUE) {
			thuTuc2GiayToImpl.setNgayTao(null);
		}
		else {
			thuTuc2GiayToImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			thuTuc2GiayToImpl.setNgaySua(null);
		}
		else {
			thuTuc2GiayToImpl.setNgaySua(new Date(ngaySua));
		}

		thuTuc2GiayToImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			thuTuc2GiayToImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			thuTuc2GiayToImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			thuTuc2GiayToImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			thuTuc2GiayToImpl.setNguoiSua(nguoiSua);
		}

		thuTuc2GiayToImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		thuTuc2GiayToImpl.setDanhMucGiayToId(danhMucGiayToId);
		thuTuc2GiayToImpl.setTrangThai(trangThai);
		thuTuc2GiayToImpl.setGiaidoan(giaidoan);

		thuTuc2GiayToImpl.resetOriginalValues();

		return thuTuc2GiayToImpl;
	}

	public long id;
	public String ghiChu;
	public int batBuoc;
	public long thuTuHienThi;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long thuTucHanhChinhId;
	public long danhMucGiayToId;
	public int trangThai;
	public int giaidoan;
}