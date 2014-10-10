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

import org.oep.cmon.dao.dvc.model.TTHC2CoQuanQuanLy;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TTHC2CoQuanQuanLy in entity cache.
 *
 * @author liemnn
 * @see TTHC2CoQuanQuanLy
 * @generated
 */
public class TTHC2CoQuanQuanLyCacheModel implements CacheModel<TTHC2CoQuanQuanLy>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

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
		sb.append(", soNgayXyLy=");
		sb.append(soNgayXyLy);
		sb.append(", thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", coQuanQuanLyId=");
		sb.append(coQuanQuanLyId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", phi=");
		sb.append(phi);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append("}");

		return sb.toString();
	}

	public TTHC2CoQuanQuanLy toEntityModel() {
		TTHC2CoQuanQuanLyImpl tthc2CoQuanQuanLyImpl = new TTHC2CoQuanQuanLyImpl();

		tthc2CoQuanQuanLyImpl.setId(id);

		if (ngayTao == Long.MIN_VALUE) {
			tthc2CoQuanQuanLyImpl.setNgayTao(null);
		}
		else {
			tthc2CoQuanQuanLyImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			tthc2CoQuanQuanLyImpl.setNgaySua(null);
		}
		else {
			tthc2CoQuanQuanLyImpl.setNgaySua(new Date(ngaySua));
		}

		tthc2CoQuanQuanLyImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			tthc2CoQuanQuanLyImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			tthc2CoQuanQuanLyImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			tthc2CoQuanQuanLyImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			tthc2CoQuanQuanLyImpl.setNguoiSua(nguoiSua);
		}

		tthc2CoQuanQuanLyImpl.setSoNgayXyLy(soNgayXyLy);
		tthc2CoQuanQuanLyImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		tthc2CoQuanQuanLyImpl.setCoQuanQuanLyId(coQuanQuanLyId);
		tthc2CoQuanQuanLyImpl.setTrangThai(trangThai);
		tthc2CoQuanQuanLyImpl.setPhi(phi);
		tthc2CoQuanQuanLyImpl.setLePhi(lePhi);

		tthc2CoQuanQuanLyImpl.resetOriginalValues();

		return tthc2CoQuanQuanLyImpl;
	}

	public long id;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public int soNgayXyLy;
	public long thuTucHanhChinhId;
	public long coQuanQuanLyId;
	public int trangThai;
	public int phi;
	public int lePhi;
}