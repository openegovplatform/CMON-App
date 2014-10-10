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

import org.oep.cmon.dao.dvc.model.VanBanHuongDan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VanBanHuongDan in entity cache.
 *
 * @author liemnn
 * @see VanBanHuongDan
 * @generated
 */
public class VanBanHuongDanCacheModel implements CacheModel<VanBanHuongDan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", noiLuuTruId=");
		sb.append(noiLuuTruId);
		sb.append(", tenTaiLieu=");
		sb.append(tenTaiLieu);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", loaiTaiLieu=");
		sb.append(loaiTaiLieu);
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
		sb.append("}");

		return sb.toString();
	}

	public VanBanHuongDan toEntityModel() {
		VanBanHuongDanImpl vanBanHuongDanImpl = new VanBanHuongDanImpl();

		vanBanHuongDanImpl.setId(id);
		vanBanHuongDanImpl.setNoiLuuTruId(noiLuuTruId);

		if (tenTaiLieu == null) {
			vanBanHuongDanImpl.setTenTaiLieu(StringPool.BLANK);
		}
		else {
			vanBanHuongDanImpl.setTenTaiLieu(tenTaiLieu);
		}

		if (moTa == null) {
			vanBanHuongDanImpl.setMoTa(StringPool.BLANK);
		}
		else {
			vanBanHuongDanImpl.setMoTa(moTa);
		}

		vanBanHuongDanImpl.setLoaiTaiLieu(loaiTaiLieu);

		if (ngayTao == Long.MIN_VALUE) {
			vanBanHuongDanImpl.setNgayTao(null);
		}
		else {
			vanBanHuongDanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			vanBanHuongDanImpl.setNgaySua(null);
		}
		else {
			vanBanHuongDanImpl.setNgaySua(new Date(ngaySua));
		}

		vanBanHuongDanImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			vanBanHuongDanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			vanBanHuongDanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			vanBanHuongDanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			vanBanHuongDanImpl.setNguoiSua(nguoiSua);
		}

		vanBanHuongDanImpl.setThuTucHanhChinhId(thuTucHanhChinhId);

		vanBanHuongDanImpl.resetOriginalValues();

		return vanBanHuongDanImpl;
	}

	public long id;
	public long noiLuuTruId;
	public String tenTaiLieu;
	public String moTa;
	public long loaiTaiLieu;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long thuTucHanhChinhId;
}