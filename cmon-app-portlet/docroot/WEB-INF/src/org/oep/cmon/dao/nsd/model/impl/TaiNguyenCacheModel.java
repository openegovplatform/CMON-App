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

package org.oep.cmon.dao.nsd.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.nsd.model.TaiNguyen;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TaiNguyen in entity cache.
 *
 * @author Liemnn
 * @see TaiNguyen
 * @generated
 */
public class TaiNguyenCacheModel implements CacheModel<TaiNguyen>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", giaTri=");
		sb.append(giaTri);
		sb.append(", trangThai=");
		sb.append(trangThai);
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
		sb.append(", ungDungId=");
		sb.append(ungDungId);
		sb.append(", heThongId=");
		sb.append(heThongId);
		sb.append("}");

		return sb.toString();
	}

	public TaiNguyen toEntityModel() {
		TaiNguyenImpl taiNguyenImpl = new TaiNguyenImpl();

		taiNguyenImpl.setId(id);

		if (ten == null) {
			taiNguyenImpl.setTen(StringPool.BLANK);
		}
		else {
			taiNguyenImpl.setTen(ten);
		}

		if (moTa == null) {
			taiNguyenImpl.setMoTa(StringPool.BLANK);
		}
		else {
			taiNguyenImpl.setMoTa(moTa);
		}

		taiNguyenImpl.setLoai(loai);

		if (giaTri == null) {
			taiNguyenImpl.setGiaTri(StringPool.BLANK);
		}
		else {
			taiNguyenImpl.setGiaTri(giaTri);
		}

		taiNguyenImpl.setTrangThai(trangThai);

		if (ngayTao == Long.MIN_VALUE) {
			taiNguyenImpl.setNgayTao(null);
		}
		else {
			taiNguyenImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			taiNguyenImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			taiNguyenImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			taiNguyenImpl.setNgaySua(null);
		}
		else {
			taiNguyenImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			taiNguyenImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			taiNguyenImpl.setNguoiSua(nguoiSua);
		}

		taiNguyenImpl.setDaXoa(daXoa);
		taiNguyenImpl.setUngDungId(ungDungId);
		taiNguyenImpl.setHeThongId(heThongId);

		taiNguyenImpl.resetOriginalValues();

		return taiNguyenImpl;
	}

	public long id;
	public String ten;
	public String moTa;
	public int loai;
	public String giaTri;
	public int trangThai;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int daXoa;
	public Long ungDungId;
	public Long heThongId;
}