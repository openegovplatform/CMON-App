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

package org.oep.cmon.dao.kios.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.kios.model.DanhSachHoSo;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DanhSachHoSo in entity cache.
 *
 * @author VIENPN
 * @see DanhSachHoSo
 * @generated
 */
public class DanhSachHoSoCacheModel implements CacheModel<DanhSachHoSo>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ngayNhanHoSo=");
		sb.append(ngayNhanHoSo);
		sb.append(", tenCoQuanTiepNhan=");
		sb.append(tenCoQuanTiepNhan);
		sb.append(", tenThuTucHanhChinh=");
		sb.append(tenThuTucHanhChinh);
		sb.append(", ngayHenTraKetQua=");
		sb.append(ngayHenTraKetQua);
		sb.append(", ngayTraKetQua=");
		sb.append(ngayTraKetQua);
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(hoTenNguoiNopHoSo);
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(diaChiThuongTruNguoiNop);
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(soDienThoaiDiDongNguoiNop);
		sb.append(", ngayKetThucXuLy=");
		sb.append(ngayKetThucXuLy);
		sb.append(", loaiHoSo=");
		sb.append(loaiHoSo);
		sb.append(", maSoBienNhan=");
		sb.append(maSoBienNhan);
		sb.append(", chuSoHuu=");
		sb.append(chuSoHuu);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append(", phiHoSo=");
		sb.append(phiHoSo);
		sb.append(", emailNguoiNop=");
		sb.append(emailNguoiNop);
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(soDienThoaiCoDinhNguoiNop);
		sb.append(", nhomThuTucHanhChinhTen=");
		sb.append(nhomThuTucHanhChinhTen);
		sb.append(", trangThaiHoSoTen=");
		sb.append(trangThaiHoSoTen);
		sb.append(", rNum=");
		sb.append(rNum);
		sb.append("}");

		return sb.toString();
	}

	public DanhSachHoSo toEntityModel() {
		DanhSachHoSoImpl danhSachHoSoImpl = new DanhSachHoSoImpl();

		danhSachHoSoImpl.setId(id);

		if (ngayNhanHoSo == Long.MIN_VALUE) {
			danhSachHoSoImpl.setNgayNhanHoSo(null);
		}
		else {
			danhSachHoSoImpl.setNgayNhanHoSo(new Date(ngayNhanHoSo));
		}

		if (tenCoQuanTiepNhan == null) {
			danhSachHoSoImpl.setTenCoQuanTiepNhan(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setTenCoQuanTiepNhan(tenCoQuanTiepNhan);
		}

		if (tenThuTucHanhChinh == null) {
			danhSachHoSoImpl.setTenThuTucHanhChinh(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setTenThuTucHanhChinh(tenThuTucHanhChinh);
		}

		if (ngayHenTraKetQua == Long.MIN_VALUE) {
			danhSachHoSoImpl.setNgayHenTraKetQua(null);
		}
		else {
			danhSachHoSoImpl.setNgayHenTraKetQua(new Date(ngayHenTraKetQua));
		}

		if (ngayTraKetQua == Long.MIN_VALUE) {
			danhSachHoSoImpl.setNgayTraKetQua(null);
		}
		else {
			danhSachHoSoImpl.setNgayTraKetQua(new Date(ngayTraKetQua));
		}

		if (hoTenNguoiNopHoSo == null) {
			danhSachHoSoImpl.setHoTenNguoiNopHoSo(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
		}

		if (diaChiThuongTruNguoiNop == null) {
			danhSachHoSoImpl.setDiaChiThuongTruNguoiNop(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
		}

		if (soDienThoaiDiDongNguoiNop == null) {
			danhSachHoSoImpl.setSoDienThoaiDiDongNguoiNop(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
		}

		if (ngayKetThucXuLy == Long.MIN_VALUE) {
			danhSachHoSoImpl.setNgayKetThucXuLy(null);
		}
		else {
			danhSachHoSoImpl.setNgayKetThucXuLy(new Date(ngayKetThucXuLy));
		}

		danhSachHoSoImpl.setLoaiHoSo(loaiHoSo);

		if (maSoBienNhan == null) {
			danhSachHoSoImpl.setMaSoBienNhan(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setMaSoBienNhan(maSoBienNhan);
		}

		if (chuSoHuu == null) {
			danhSachHoSoImpl.setChuSoHuu(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setChuSoHuu(chuSoHuu);
		}

		danhSachHoSoImpl.setLePhi(lePhi);
		danhSachHoSoImpl.setPhiHoSo(phiHoSo);

		if (emailNguoiNop == null) {
			danhSachHoSoImpl.setEmailNguoiNop(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setEmailNguoiNop(emailNguoiNop);
		}

		if (soDienThoaiCoDinhNguoiNop == null) {
			danhSachHoSoImpl.setSoDienThoaiCoDinhNguoiNop(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
		}

		if (nhomThuTucHanhChinhTen == null) {
			danhSachHoSoImpl.setNhomThuTucHanhChinhTen(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinhTen);
		}

		if (trangThaiHoSoTen == null) {
			danhSachHoSoImpl.setTrangThaiHoSoTen(StringPool.BLANK);
		}
		else {
			danhSachHoSoImpl.setTrangThaiHoSoTen(trangThaiHoSoTen);
		}

		danhSachHoSoImpl.setRNum(rNum);

		danhSachHoSoImpl.resetOriginalValues();

		return danhSachHoSoImpl;
	}

	public long id;
	public long ngayNhanHoSo;
	public String tenCoQuanTiepNhan;
	public String tenThuTucHanhChinh;
	public long ngayHenTraKetQua;
	public long ngayTraKetQua;
	public String hoTenNguoiNopHoSo;
	public String diaChiThuongTruNguoiNop;
	public String soDienThoaiDiDongNguoiNop;
	public long ngayKetThucXuLy;
	public int loaiHoSo;
	public String maSoBienNhan;
	public String chuSoHuu;
	public int lePhi;
	public int phiHoSo;
	public String emailNguoiNop;
	public String soDienThoaiCoDinhNguoiNop;
	public String nhomThuTucHanhChinhTen;
	public String trangThaiHoSoTen;
	public int rNum;
}