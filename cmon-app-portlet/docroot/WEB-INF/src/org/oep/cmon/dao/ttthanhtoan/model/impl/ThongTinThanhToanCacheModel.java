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

import org.oep.cmon.dao.ttthanhtoan.model.ThongTinThanhToan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ThongTinThanhToan in entity cache.
 *
 * @author Thanhdd
 * @see ThongTinThanhToan
 * @generated
 */
public class ThongTinThanhToanCacheModel implements CacheModel<ThongTinThanhToan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
		sb.append(", hoSoTTHCCongId=");
		sb.append(hoSoTTHCCongId);
		sb.append(", taiKhoanNguoiDungNopId=");
		sb.append(taiKhoanNguoiDungNopId);
		sb.append(", taiKhoanNguoiDungNhanId=");
		sb.append(taiKhoanNguoiDungNhanId);
		sb.append(", loaiThanhToan=");
		sb.append(loaiThanhToan);
		sb.append(", tenNguoiNopTien=");
		sb.append(tenNguoiNopTien);
		sb.append(", tenCanBoNhanTien=");
		sb.append(tenCanBoNhanTien);
		sb.append(", xacNhan=");
		sb.append(xacNhan);
		sb.append(", loaiPhi=");
		sb.append(loaiPhi);
		sb.append(", soTien=");
		sb.append(soTien);
		sb.append(", ngayThuTien=");
		sb.append(ngayThuTien);
		sb.append(", ngayXacNhan=");
		sb.append(ngayXacNhan);
		sb.append(", ngayChuyenTien=");
		sb.append(ngayChuyenTien);
		sb.append(", yKien=");
		sb.append(yKien);
		sb.append(", noiLuuTruId=");
		sb.append(noiLuuTruId);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	public ThongTinThanhToan toEntityModel() {
		ThongTinThanhToanImpl thongTinThanhToanImpl = new ThongTinThanhToanImpl();

		thongTinThanhToanImpl.setId(id);
		thongTinThanhToanImpl.setHoSoTTHCCongId(hoSoTTHCCongId);
		thongTinThanhToanImpl.setTaiKhoanNguoiDungNopId(taiKhoanNguoiDungNopId);
		thongTinThanhToanImpl.setTaiKhoanNguoiDungNhanId(taiKhoanNguoiDungNhanId);
		thongTinThanhToanImpl.setLoaiThanhToan(loaiThanhToan);

		if (tenNguoiNopTien == null) {
			thongTinThanhToanImpl.setTenNguoiNopTien(StringPool.BLANK);
		}
		else {
			thongTinThanhToanImpl.setTenNguoiNopTien(tenNguoiNopTien);
		}

		if (tenCanBoNhanTien == null) {
			thongTinThanhToanImpl.setTenCanBoNhanTien(StringPool.BLANK);
		}
		else {
			thongTinThanhToanImpl.setTenCanBoNhanTien(tenCanBoNhanTien);
		}

		thongTinThanhToanImpl.setXacNhan(xacNhan);
		thongTinThanhToanImpl.setLoaiPhi(loaiPhi);
		thongTinThanhToanImpl.setSoTien(soTien);

		if (ngayThuTien == Long.MIN_VALUE) {
			thongTinThanhToanImpl.setNgayThuTien(null);
		}
		else {
			thongTinThanhToanImpl.setNgayThuTien(new Date(ngayThuTien));
		}

		if (ngayXacNhan == Long.MIN_VALUE) {
			thongTinThanhToanImpl.setNgayXacNhan(null);
		}
		else {
			thongTinThanhToanImpl.setNgayXacNhan(new Date(ngayXacNhan));
		}

		if (ngayChuyenTien == Long.MIN_VALUE) {
			thongTinThanhToanImpl.setNgayChuyenTien(null);
		}
		else {
			thongTinThanhToanImpl.setNgayChuyenTien(new Date(ngayChuyenTien));
		}

		if (yKien == null) {
			thongTinThanhToanImpl.setYKien(StringPool.BLANK);
		}
		else {
			thongTinThanhToanImpl.setYKien(yKien);
		}

		thongTinThanhToanImpl.setNoiLuuTruId(noiLuuTruId);

		if (nguoiTao == null) {
			thongTinThanhToanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			thongTinThanhToanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			thongTinThanhToanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			thongTinThanhToanImpl.setNguoiSua(nguoiSua);
		}

		if (ngayTao == Long.MIN_VALUE) {
			thongTinThanhToanImpl.setNgayTao(null);
		}
		else {
			thongTinThanhToanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			thongTinThanhToanImpl.setNgaySua(null);
		}
		else {
			thongTinThanhToanImpl.setNgaySua(new Date(ngaySua));
		}

		thongTinThanhToanImpl.resetOriginalValues();

		return thongTinThanhToanImpl;
	}

	public long id;
	public long hoSoTTHCCongId;
	public Long taiKhoanNguoiDungNopId;
	public Long taiKhoanNguoiDungNhanId;
	public long loaiThanhToan;
	public String tenNguoiNopTien;
	public String tenCanBoNhanTien;
	public long xacNhan;
	public long loaiPhi;
	public long soTien;
	public long ngayThuTien;
	public long ngayXacNhan;
	public long ngayChuyenTien;
	public String yKien;
	public long noiLuuTruId;
	public String nguoiTao;
	public String nguoiSua;
	public long ngayTao;
	public long ngaySua;
}