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

package org.oep.cmon.dao.hosohcc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.hosohcc.model.TrangThaiHoSo;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiHoSo in entity cache.
 *
 * @author LIEMNn
 * @see TrangThaiHoSo
 * @generated
 */
public class TrangThaiHoSoCacheModel implements CacheModel<TrangThaiHoSo>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public TrangThaiHoSo toEntityModel() {
		TrangThaiHoSoImpl trangThaiHoSoImpl = new TrangThaiHoSoImpl();

		trangThaiHoSoImpl.setId(id);

		if (trangThai == null) {
			trangThaiHoSoImpl.setTrangThai(StringPool.BLANK);
		}
		else {
			trangThaiHoSoImpl.setTrangThai(trangThai);
		}

		if (nguoiTao == null) {
			trangThaiHoSoImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			trangThaiHoSoImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			trangThaiHoSoImpl.setNgayTao(null);
		}
		else {
			trangThaiHoSoImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			trangThaiHoSoImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			trangThaiHoSoImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			trangThaiHoSoImpl.setNgaySua(null);
		}
		else {
			trangThaiHoSoImpl.setNgaySua(new Date(ngaySua));
		}

		trangThaiHoSoImpl.setDaXoa(daXoa);

		trangThaiHoSoImpl.resetOriginalValues();

		return trangThaiHoSoImpl;
	}

	public long id;
	public String trangThai;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public int daXoa;
}