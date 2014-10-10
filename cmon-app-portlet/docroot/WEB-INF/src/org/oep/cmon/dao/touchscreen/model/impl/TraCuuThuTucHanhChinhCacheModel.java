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

package org.oep.cmon.dao.touchscreen.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.touchscreen.model.TraCuuThuTucHanhChinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TraCuuThuTucHanhChinh in entity cache.
 *
 * @author VIENPN
 * @see TraCuuThuTucHanhChinh
 * @generated
 */
public class TraCuuThuTucHanhChinhCacheModel implements CacheModel<TraCuuThuTucHanhChinh>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", soNgayXuLy=");
		sb.append(soNgayXuLy);
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
		sb.append(", nhomThuTucHanhChinhId=");
		sb.append(nhomThuTucHanhChinhId);
		sb.append(", nhomThuTucHanhChinhTen=");
		sb.append(nhomThuTucHanhChinhTen);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", canTichHop=");
		sb.append(canTichHop);
		sb.append(", trinhTuThucHien=");
		sb.append(trinhTuThucHien);
		sb.append(", cachThucHien=");
		sb.append(cachThucHien);
		sb.append(", thanhPhanHoSo=");
		sb.append(thanhPhanHoSo);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append(", donViLePhi=");
		sb.append(donViLePhi);
		sb.append(", phi=");
		sb.append(phi);
		sb.append(", donViPhi=");
		sb.append(donViPhi);
		sb.append(", tenMauDonToKhai=");
		sb.append(tenMauDonToKhai);
		sb.append(", yeuCauDieuKienThucHien=");
		sb.append(yeuCauDieuKienThucHien);
		sb.append(", canCuPhapLy=");
		sb.append(canCuPhapLy);
		sb.append(", capCoQuanQuanLyId=");
		sb.append(capCoQuanQuanLyId);
		sb.append(", linhVucThucHien=");
		sb.append(linhVucThucHien);
		sb.append(", maDNG=");
		sb.append(maDNG);
		sb.append(", uengineProcessName=");
		sb.append(uengineProcessName);
		sb.append(", thuTucLienThongId=");
		sb.append(thuTucLienThongId);
		sb.append("}");

		return sb.toString();
	}

	public TraCuuThuTucHanhChinh toEntityModel() {
		TraCuuThuTucHanhChinhImpl traCuuThuTucHanhChinhImpl = new TraCuuThuTucHanhChinhImpl();

		traCuuThuTucHanhChinhImpl.setId(id);

		if (ma == null) {
			traCuuThuTucHanhChinhImpl.setMa(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			traCuuThuTucHanhChinhImpl.setTen(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setTen(ten);
		}

		traCuuThuTucHanhChinhImpl.setSoNgayXuLy(soNgayXuLy);

		if (ngayTao == Long.MIN_VALUE) {
			traCuuThuTucHanhChinhImpl.setNgayTao(null);
		}
		else {
			traCuuThuTucHanhChinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			traCuuThuTucHanhChinhImpl.setNgaySua(null);
		}
		else {
			traCuuThuTucHanhChinhImpl.setNgaySua(new Date(ngaySua));
		}

		traCuuThuTucHanhChinhImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			traCuuThuTucHanhChinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			traCuuThuTucHanhChinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setNguoiSua(nguoiSua);
		}

		traCuuThuTucHanhChinhImpl.setNhomThuTucHanhChinhId(nhomThuTucHanhChinhId);

		if (nhomThuTucHanhChinhTen == null) {
			traCuuThuTucHanhChinhImpl.setNhomThuTucHanhChinhTen(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setNhomThuTucHanhChinhTen(nhomThuTucHanhChinhTen);
		}

		traCuuThuTucHanhChinhImpl.setTrangThai(trangThai);
		traCuuThuTucHanhChinhImpl.setPhienBan(phienBan);
		traCuuThuTucHanhChinhImpl.setCanTichHop(canTichHop);

		if (trinhTuThucHien == null) {
			traCuuThuTucHanhChinhImpl.setTrinhTuThucHien(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setTrinhTuThucHien(trinhTuThucHien);
		}

		if (cachThucHien == null) {
			traCuuThuTucHanhChinhImpl.setCachThucHien(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setCachThucHien(cachThucHien);
		}

		if (thanhPhanHoSo == null) {
			traCuuThuTucHanhChinhImpl.setThanhPhanHoSo(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setThanhPhanHoSo(thanhPhanHoSo);
		}

		traCuuThuTucHanhChinhImpl.setLePhi(lePhi);

		if (donViLePhi == null) {
			traCuuThuTucHanhChinhImpl.setDonViLePhi(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setDonViLePhi(donViLePhi);
		}

		traCuuThuTucHanhChinhImpl.setPhi(phi);

		if (donViPhi == null) {
			traCuuThuTucHanhChinhImpl.setDonViPhi(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setDonViPhi(donViPhi);
		}

		if (tenMauDonToKhai == null) {
			traCuuThuTucHanhChinhImpl.setTenMauDonToKhai(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setTenMauDonToKhai(tenMauDonToKhai);
		}

		if (yeuCauDieuKienThucHien == null) {
			traCuuThuTucHanhChinhImpl.setYeuCauDieuKienThucHien(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien);
		}

		if (canCuPhapLy == null) {
			traCuuThuTucHanhChinhImpl.setCanCuPhapLy(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setCanCuPhapLy(canCuPhapLy);
		}

		traCuuThuTucHanhChinhImpl.setCapCoQuanQuanLyId(capCoQuanQuanLyId);

		if (linhVucThucHien == null) {
			traCuuThuTucHanhChinhImpl.setLinhVucThucHien(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setLinhVucThucHien(linhVucThucHien);
		}

		if (maDNG == null) {
			traCuuThuTucHanhChinhImpl.setMaDNG(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setMaDNG(maDNG);
		}

		if (uengineProcessName == null) {
			traCuuThuTucHanhChinhImpl.setUengineProcessName(StringPool.BLANK);
		}
		else {
			traCuuThuTucHanhChinhImpl.setUengineProcessName(uengineProcessName);
		}

		traCuuThuTucHanhChinhImpl.setThuTucLienThongId(thuTucLienThongId);

		traCuuThuTucHanhChinhImpl.resetOriginalValues();

		return traCuuThuTucHanhChinhImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long soNgayXuLy;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long nhomThuTucHanhChinhId;
	public String nhomThuTucHanhChinhTen;
	public int trangThai;
	public long phienBan;
	public int canTichHop;
	public String trinhTuThucHien;
	public String cachThucHien;
	public String thanhPhanHoSo;
	public long lePhi;
	public String donViLePhi;
	public long phi;
	public String donViPhi;
	public String tenMauDonToKhai;
	public String yeuCauDieuKienThucHien;
	public String canCuPhapLy;
	public Long capCoQuanQuanLyId;
	public String linhVucThucHien;
	public String maDNG;
	public String uengineProcessName;
	public Long thuTucLienThongId;
}