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

import org.oep.cmon.dao.nsd.model.TaiKhoanNguoiDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TaiKhoanNguoiDung in entity cache.
 *
 * @author Liemnn
 * @see TaiKhoanNguoiDung
 * @generated
 */
public class TaiKhoanNguoiDungCacheModel implements CacheModel<TaiKhoanNguoiDung>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenDangNhap=");
		sb.append(tenDangNhap);
		sb.append(", matKhau=");
		sb.append(matKhau);
		sb.append(", tenNguoiDung=");
		sb.append(tenNguoiDung);
		sb.append(", cauHoiMatKhau=");
		sb.append(cauHoiMatKhau);
		sb.append(", cauTraLoiMatKhau=");
		sb.append(cauTraLoiMatKhau);
		sb.append(", email=");
		sb.append(email);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(taiKhoanNguoiDungId);
		sb.append("}");

		return sb.toString();
	}

	public TaiKhoanNguoiDung toEntityModel() {
		TaiKhoanNguoiDungImpl taiKhoanNguoiDungImpl = new TaiKhoanNguoiDungImpl();

		taiKhoanNguoiDungImpl.setId(id);

		if (tenDangNhap == null) {
			taiKhoanNguoiDungImpl.setTenDangNhap(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setTenDangNhap(tenDangNhap);
		}

		if (matKhau == null) {
			taiKhoanNguoiDungImpl.setMatKhau(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setMatKhau(matKhau);
		}

		if (tenNguoiDung == null) {
			taiKhoanNguoiDungImpl.setTenNguoiDung(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setTenNguoiDung(tenNguoiDung);
		}

		if (cauHoiMatKhau == null) {
			taiKhoanNguoiDungImpl.setCauHoiMatKhau(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setCauHoiMatKhau(cauHoiMatKhau);
		}

		if (cauTraLoiMatKhau == null) {
			taiKhoanNguoiDungImpl.setCauTraLoiMatKhau(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setCauTraLoiMatKhau(cauTraLoiMatKhau);
		}

		if (email == null) {
			taiKhoanNguoiDungImpl.setEmail(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setEmail(email);
		}

		if (ngayTao == Long.MIN_VALUE) {
			taiKhoanNguoiDungImpl.setNgayTao(null);
		}
		else {
			taiKhoanNguoiDungImpl.setNgayTao(new Date(ngayTao));
		}

		taiKhoanNguoiDungImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			taiKhoanNguoiDungImpl.setNgaySua(null);
		}
		else {
			taiKhoanNguoiDungImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			taiKhoanNguoiDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			taiKhoanNguoiDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			taiKhoanNguoiDungImpl.setNguoiSua(nguoiSua);
		}

		taiKhoanNguoiDungImpl.setTrangThai(trangThai);
		taiKhoanNguoiDungImpl.setLoaiDoiTuongId(loaiDoiTuongId);
		taiKhoanNguoiDungImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);

		taiKhoanNguoiDungImpl.resetOriginalValues();

		return taiKhoanNguoiDungImpl;
	}

	public long id;
	public String tenDangNhap;
	public String matKhau;
	public String tenNguoiDung;
	public String cauHoiMatKhau;
	public String cauTraLoiMatKhau;
	public String email;
	public long ngayTao;
	public int daXoa;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int trangThai;
	public Long loaiDoiTuongId;
	public Long taiKhoanNguoiDungId;
}