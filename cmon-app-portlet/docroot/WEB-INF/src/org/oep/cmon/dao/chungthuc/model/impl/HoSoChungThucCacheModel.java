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

package org.oep.cmon.dao.chungthuc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.chungthuc.model.HoSoChungThuc;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoChungThuc in entity cache.
 *
 * @author vietho
 * @see HoSoChungThuc
 * @generated
 */
public class HoSoChungThucCacheModel implements CacheModel<HoSoChungThuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{hoSoChungThucId=");
		sb.append(hoSoChungThucId);
		sb.append(", tenChungThuc=");
		sb.append(tenChungThuc);
		sb.append(", soChungThuc=");
		sb.append(soChungThuc);
		sb.append(", ngayNopHoSo=");
		sb.append(ngayNopHoSo);
		sb.append(", ngayTraKetQua=");
		sb.append(ngayTraKetQua);
		sb.append(", hoTenNguoiNopHoSo=");
		sb.append(hoTenNguoiNopHoSo);
		sb.append(", diaChiThuongTruNguoiNop=");
		sb.append(diaChiThuongTruNguoiNop);
		sb.append(", soDienThoaiCoDinhNguoiNop=");
		sb.append(soDienThoaiCoDinhNguoiNop);
		sb.append(", trangThaiHoSo=");
		sb.append(trangThaiHoSo);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", canBoTiepNhanId=");
		sb.append(canBoTiepNhanId);
		sb.append(", soDienThoaiDiDongNguoiNop=");
		sb.append(soDienThoaiDiDongNguoiNop);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", mucDichChungThuc=");
		sb.append(mucDichChungThuc);
		sb.append(", maSoBienNhan=");
		sb.append(maSoBienNhan);
		sb.append(", chuSoHuu=");
		sb.append(chuSoHuu);
		sb.append(", soBoHoSo=");
		sb.append(soBoHoSo);
		sb.append(", soTo=");
		sb.append(soTo);
		sb.append(", truongHop=");
		sb.append(truongHop);
		sb.append(", lePhi=");
		sb.append(lePhi);
		sb.append(", phiHoSo=");
		sb.append(phiHoSo);
		sb.append(", emailNguoiNop=");
		sb.append(emailNguoiNop);
		sb.append(", ngaySinhNguoiNop=");
		sb.append(ngaySinhNguoiNop);
		sb.append(", soCMNDNguoiNop=");
		sb.append(soCMNDNguoiNop);
		sb.append(", gioiTinhNguoiNop=");
		sb.append(gioiTinhNguoiNop);
		sb.append(", tenCanBoKy=");
		sb.append(tenCanBoKy);
		sb.append(", chucVuCanBoKyId=");
		sb.append(chucVuCanBoKyId);
		sb.append(", soDanhMucId=");
		sb.append(soDanhMucId);
		sb.append(", thuongTruTinhId=");
		sb.append(thuongTruTinhId);
		sb.append(", thuongTruHuyenId=");
		sb.append(thuongTruHuyenId);
		sb.append(", thuongTruXaId=");
		sb.append(thuongTruXaId);
		sb.append("}");

		return sb.toString();
	}

	public HoSoChungThuc toEntityModel() {
		HoSoChungThucImpl hoSoChungThucImpl = new HoSoChungThucImpl();

		hoSoChungThucImpl.setHoSoChungThucId(hoSoChungThucId);

		if (tenChungThuc == null) {
			hoSoChungThucImpl.setTenChungThuc(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setTenChungThuc(tenChungThuc);
		}

		if (soChungThuc == null) {
			hoSoChungThucImpl.setSoChungThuc(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setSoChungThuc(soChungThuc);
		}

		if (ngayNopHoSo == Long.MIN_VALUE) {
			hoSoChungThucImpl.setNgayNopHoSo(null);
		}
		else {
			hoSoChungThucImpl.setNgayNopHoSo(new Date(ngayNopHoSo));
		}

		if (ngayTraKetQua == Long.MIN_VALUE) {
			hoSoChungThucImpl.setNgayTraKetQua(null);
		}
		else {
			hoSoChungThucImpl.setNgayTraKetQua(new Date(ngayTraKetQua));
		}

		if (hoTenNguoiNopHoSo == null) {
			hoSoChungThucImpl.setHoTenNguoiNopHoSo(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setHoTenNguoiNopHoSo(hoTenNguoiNopHoSo);
		}

		if (diaChiThuongTruNguoiNop == null) {
			hoSoChungThucImpl.setDiaChiThuongTruNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setDiaChiThuongTruNguoiNop(diaChiThuongTruNguoiNop);
		}

		if (soDienThoaiCoDinhNguoiNop == null) {
			hoSoChungThucImpl.setSoDienThoaiCoDinhNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setSoDienThoaiCoDinhNguoiNop(soDienThoaiCoDinhNguoiNop);
		}

		hoSoChungThucImpl.setTrangThaiHoSo(trangThaiHoSo);
		hoSoChungThucImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			hoSoChungThucImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			hoSoChungThucImpl.setNgayTao(null);
		}
		else {
			hoSoChungThucImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			hoSoChungThucImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			hoSoChungThucImpl.setNgaySua(null);
		}
		else {
			hoSoChungThucImpl.setNgaySua(new Date(ngaySua));
		}

		hoSoChungThucImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		hoSoChungThucImpl.setCanBoTiepNhanId(canBoTiepNhanId);

		if (soDienThoaiDiDongNguoiNop == null) {
			hoSoChungThucImpl.setSoDienThoaiDiDongNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setSoDienThoaiDiDongNguoiNop(soDienThoaiDiDongNguoiNop);
		}

		if (ghiChu == null) {
			hoSoChungThucImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setGhiChu(ghiChu);
		}

		if (mucDichChungThuc == null) {
			hoSoChungThucImpl.setMucDichChungThuc(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setMucDichChungThuc(mucDichChungThuc);
		}

		if (maSoBienNhan == null) {
			hoSoChungThucImpl.setMaSoBienNhan(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setMaSoBienNhan(maSoBienNhan);
		}

		if (chuSoHuu == null) {
			hoSoChungThucImpl.setChuSoHuu(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setChuSoHuu(chuSoHuu);
		}

		hoSoChungThucImpl.setSoBoHoSo(soBoHoSo);
		hoSoChungThucImpl.setSoTo(soTo);

		if (truongHop == null) {
			hoSoChungThucImpl.setTruongHop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setTruongHop(truongHop);
		}

		hoSoChungThucImpl.setLePhi(lePhi);
		hoSoChungThucImpl.setPhiHoSo(phiHoSo);

		if (emailNguoiNop == null) {
			hoSoChungThucImpl.setEmailNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setEmailNguoiNop(emailNguoiNop);
		}

		if (ngaySinhNguoiNop == Long.MIN_VALUE) {
			hoSoChungThucImpl.setNgaySinhNguoiNop(null);
		}
		else {
			hoSoChungThucImpl.setNgaySinhNguoiNop(new Date(ngaySinhNguoiNop));
		}

		if (soCMNDNguoiNop == null) {
			hoSoChungThucImpl.setSoCMNDNguoiNop(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setSoCMNDNguoiNop(soCMNDNguoiNop);
		}

		hoSoChungThucImpl.setGioiTinhNguoiNop(gioiTinhNguoiNop);

		if (tenCanBoKy == null) {
			hoSoChungThucImpl.setTenCanBoKy(StringPool.BLANK);
		}
		else {
			hoSoChungThucImpl.setTenCanBoKy(tenCanBoKy);
		}

		hoSoChungThucImpl.setChucVuCanBoKyId(chucVuCanBoKyId);
		hoSoChungThucImpl.setSoDanhMucId(soDanhMucId);
		hoSoChungThucImpl.setThuongTruTinhId(thuongTruTinhId);
		hoSoChungThucImpl.setThuongTruHuyenId(thuongTruHuyenId);
		hoSoChungThucImpl.setThuongTruXaId(thuongTruXaId);

		hoSoChungThucImpl.resetOriginalValues();

		return hoSoChungThucImpl;
	}

	public long hoSoChungThucId;
	public String tenChungThuc;
	public String soChungThuc;
	public long ngayNopHoSo;
	public long ngayTraKetQua;
	public String hoTenNguoiNopHoSo;
	public String diaChiThuongTruNguoiNop;
	public String soDienThoaiCoDinhNguoiNop;
	public int trangThaiHoSo;
	public int daXoa;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public Long thuTucHanhChinhId;
	public Long canBoTiepNhanId;
	public String soDienThoaiDiDongNguoiNop;
	public String ghiChu;
	public String mucDichChungThuc;
	public String maSoBienNhan;
	public String chuSoHuu;
	public int soBoHoSo;
	public int soTo;
	public String truongHop;
	public int lePhi;
	public int phiHoSo;
	public String emailNguoiNop;
	public long ngaySinhNguoiNop;
	public String soCMNDNguoiNop;
	public int gioiTinhNguoiNop;
	public String tenCanBoKy;
	public Long chucVuCanBoKyId;
	public Long soDanhMucId;
	public Long thuongTruTinhId;
	public Long thuongTruHuyenId;
	public Long thuongTruXaId;
}