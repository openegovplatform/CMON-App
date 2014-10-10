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

package org.oep.cmon.dao.ttthanhtoan.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.ttthanhtoan.model.TienTe;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TienTe in entity cache.
 *
 * @author Thanhdd
 * @see TienTe
 * @generated
 */
public class TienTeCacheModel implements CacheModel<TienTe>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", tyGia=");
		sb.append(tyGia);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public TienTe toEntityModel() {
		TienTeImpl tienTeImpl = new TienTeImpl();

		tienTeImpl.setId(id);

		if (ma == null) {
			tienTeImpl.setMa(StringPool.BLANK);
		}
		else {
			tienTeImpl.setMa(ma);
		}

		if (ten == null) {
			tienTeImpl.setTen(StringPool.BLANK);
		}
		else {
			tienTeImpl.setTen(ten);
		}

		tienTeImpl.setTyGia(tyGia);

		if (ngayTao == Long.MIN_VALUE) {
			tienTeImpl.setNgayTao(null);
		}
		else {
			tienTeImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			tienTeImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			tienTeImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			tienTeImpl.setNgaySua(null);
		}
		else {
			tienTeImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			tienTeImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			tienTeImpl.setNguoiSua(nguoiSua);
		}

		tienTeImpl.setTrangThai(trangThai);
		tienTeImpl.setPhienBan(phienBan);
		tienTeImpl.setDaXoa(daXoa);

		tienTeImpl.resetOriginalValues();

		return tienTeImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long tyGia;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int trangThai;
	public int phienBan;
	public int daXoa;
}