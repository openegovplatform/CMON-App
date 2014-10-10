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

import org.oep.cmon.dao.dvc.model.ThuTucHanhChinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ThuTucHanhChinh in entity cache.
 *
 * @author liemnn
 * @see ThuTucHanhChinh
 * @generated
 */
public class ThuTucHanhChinhCacheModel implements CacheModel<ThuTucHanhChinh>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

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

	public ThuTucHanhChinh toEntityModel() {
		ThuTucHanhChinhImpl thuTucHanhChinhImpl = new ThuTucHanhChinhImpl();

		thuTucHanhChinhImpl.setId(id);

		if (ma == null) {
			thuTucHanhChinhImpl.setMa(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			thuTucHanhChinhImpl.setTen(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setTen(ten);
		}

		thuTucHanhChinhImpl.setSoNgayXuLy(soNgayXuLy);

		if (ngayTao == Long.MIN_VALUE) {
			thuTucHanhChinhImpl.setNgayTao(null);
		}
		else {
			thuTucHanhChinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			thuTucHanhChinhImpl.setNgaySua(null);
		}
		else {
			thuTucHanhChinhImpl.setNgaySua(new Date(ngaySua));
		}

		thuTucHanhChinhImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			thuTucHanhChinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			thuTucHanhChinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setNguoiSua(nguoiSua);
		}

		thuTucHanhChinhImpl.setNhomThuTucHanhChinhId(nhomThuTucHanhChinhId);
		thuTucHanhChinhImpl.setTrangThai(trangThai);
		thuTucHanhChinhImpl.setPhienBan(phienBan);
		thuTucHanhChinhImpl.setCanTichHop(canTichHop);

		if (trinhTuThucHien == null) {
			thuTucHanhChinhImpl.setTrinhTuThucHien(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setTrinhTuThucHien(trinhTuThucHien);
		}

		if (cachThucHien == null) {
			thuTucHanhChinhImpl.setCachThucHien(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setCachThucHien(cachThucHien);
		}

		if (thanhPhanHoSo == null) {
			thuTucHanhChinhImpl.setThanhPhanHoSo(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setThanhPhanHoSo(thanhPhanHoSo);
		}

		thuTucHanhChinhImpl.setLePhi(lePhi);

		if (donViLePhi == null) {
			thuTucHanhChinhImpl.setDonViLePhi(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setDonViLePhi(donViLePhi);
		}

		thuTucHanhChinhImpl.setPhi(phi);

		if (donViPhi == null) {
			thuTucHanhChinhImpl.setDonViPhi(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setDonViPhi(donViPhi);
		}

		if (tenMauDonToKhai == null) {
			thuTucHanhChinhImpl.setTenMauDonToKhai(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setTenMauDonToKhai(tenMauDonToKhai);
		}

		if (yeuCauDieuKienThucHien == null) {
			thuTucHanhChinhImpl.setYeuCauDieuKienThucHien(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setYeuCauDieuKienThucHien(yeuCauDieuKienThucHien);
		}

		if (canCuPhapLy == null) {
			thuTucHanhChinhImpl.setCanCuPhapLy(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setCanCuPhapLy(canCuPhapLy);
		}

		thuTucHanhChinhImpl.setCapCoQuanQuanLyId(capCoQuanQuanLyId);

		if (linhVucThucHien == null) {
			thuTucHanhChinhImpl.setLinhVucThucHien(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setLinhVucThucHien(linhVucThucHien);
		}

		if (maDNG == null) {
			thuTucHanhChinhImpl.setMaDNG(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setMaDNG(maDNG);
		}

		if (uengineProcessName == null) {
			thuTucHanhChinhImpl.setUengineProcessName(StringPool.BLANK);
		}
		else {
			thuTucHanhChinhImpl.setUengineProcessName(uengineProcessName);
		}

		thuTucHanhChinhImpl.setThuTucLienThongId(thuTucLienThongId);

		thuTucHanhChinhImpl.resetOriginalValues();

		return thuTucHanhChinhImpl;
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