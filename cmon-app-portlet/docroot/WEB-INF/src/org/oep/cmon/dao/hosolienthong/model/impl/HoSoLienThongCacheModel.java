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

package org.oep.cmon.dao.hosolienthong.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.hosolienthong.model.HoSoLienThong;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoLienThong in entity cache.
 *
 * @author hoangtrung.nguyen
 * @see HoSoLienThong
 * @generated
 */
public class HoSoLienThongCacheModel implements CacheModel<HoSoLienThong>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(75);

		sb.append("{id=");
		sb.append(id);
		sb.append(", hoSoId=");
		sb.append(hoSoId);
		sb.append(", coQuanGuiId=");
		sb.append(coQuanGuiId);
		sb.append(", coQuanNhanId=");
		sb.append(coQuanNhanId);
		sb.append(", thuTucGuiId=");
		sb.append(thuTucGuiId);
		sb.append(", thuTucNhanId=");
		sb.append(thuTucNhanId);
		sb.append(", maSoBienNhanLucGui=");
		sb.append(maSoBienNhanLucGui);
		sb.append(", maSoBienNhanLucNhan=");
		sb.append(maSoBienNhanLucNhan);
		sb.append(", canBoGuiId=");
		sb.append(canBoGuiId);
		sb.append(", canBoNhanId=");
		sb.append(canBoNhanId);
		sb.append(", ngayGui=");
		sb.append(ngayGui);
		sb.append(", ngayNhan=");
		sb.append(ngayNhan);
		sb.append(", hoTenCanBoGui=");
		sb.append(hoTenCanBoGui);
		sb.append(", hoTenCanBoNhan=");
		sb.append(hoTenCanBoNhan);
		sb.append(", canBoNopHoSoGiayId=");
		sb.append(canBoNopHoSoGiayId);
		sb.append(", hoTenCanBoNopHoSoGiay=");
		sb.append(hoTenCanBoNopHoSoGiay);
		sb.append(", trangThaiLienThong=");
		sb.append(trangThaiLienThong);
		sb.append(", ghiChuGuiLienThong=");
		sb.append(ghiChuGuiLienThong);
		sb.append(", hoTenCongDanNop=");
		sb.append(hoTenCongDanNop);
		sb.append(", diaChiDayDuCongDanNop=");
		sb.append(diaChiDayDuCongDanNop);
		sb.append(", ngayTuChoi=");
		sb.append(ngayTuChoi);
		sb.append(", ngayNoiNhanTraKetQua=");
		sb.append(ngayNoiNhanTraKetQua);
		sb.append(", ngayNoiGuiNhanKetQua=");
		sb.append(ngayNoiGuiNhanKetQua);
		sb.append(", canBoTiepNhanNoiGuiId=");
		sb.append(canBoTiepNhanNoiGuiId);
		sb.append(", hoTenCanBoTiepNhanNoiGui=");
		sb.append(hoTenCanBoTiepNhanNoiGui);
		sb.append(", tenCoQuanGui=");
		sb.append(tenCoQuanGui);
		sb.append(", tenThuTucGui=");
		sb.append(tenThuTucGui);
		sb.append(", tenCoQuanNhan=");
		sb.append(tenCoQuanNhan);
		sb.append(", tenThuTucNhan=");
		sb.append(tenThuTucNhan);
		sb.append(", thuTuLienThong=");
		sb.append(thuTuLienThong);
		sb.append(", ngayNoiNhanHenTra=");
		sb.append(ngayNoiNhanHenTra);
		sb.append(", soNgayNoiNhanXuLyDuKien=");
		sb.append(soNgayNoiNhanXuLyDuKien);
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

	public HoSoLienThong toEntityModel() {
		HoSoLienThongImpl hoSoLienThongImpl = new HoSoLienThongImpl();

		hoSoLienThongImpl.setId(id);
		hoSoLienThongImpl.setHoSoId(hoSoId);
		hoSoLienThongImpl.setCoQuanGuiId(coQuanGuiId);
		hoSoLienThongImpl.setCoQuanNhanId(coQuanNhanId);
		hoSoLienThongImpl.setThuTucGuiId(thuTucGuiId);
		hoSoLienThongImpl.setThuTucNhanId(thuTucNhanId);

		if (maSoBienNhanLucGui == null) {
			hoSoLienThongImpl.setMaSoBienNhanLucGui(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setMaSoBienNhanLucGui(maSoBienNhanLucGui);
		}

		if (maSoBienNhanLucNhan == null) {
			hoSoLienThongImpl.setMaSoBienNhanLucNhan(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setMaSoBienNhanLucNhan(maSoBienNhanLucNhan);
		}

		hoSoLienThongImpl.setCanBoGuiId(canBoGuiId);
		hoSoLienThongImpl.setCanBoNhanId(canBoNhanId);

		if (ngayGui == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayGui(null);
		}
		else {
			hoSoLienThongImpl.setNgayGui(new Date(ngayGui));
		}

		if (ngayNhan == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayNhan(null);
		}
		else {
			hoSoLienThongImpl.setNgayNhan(new Date(ngayNhan));
		}

		if (hoTenCanBoGui == null) {
			hoSoLienThongImpl.setHoTenCanBoGui(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setHoTenCanBoGui(hoTenCanBoGui);
		}

		if (hoTenCanBoNhan == null) {
			hoSoLienThongImpl.setHoTenCanBoNhan(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setHoTenCanBoNhan(hoTenCanBoNhan);
		}

		hoSoLienThongImpl.setCanBoNopHoSoGiayId(canBoNopHoSoGiayId);

		if (hoTenCanBoNopHoSoGiay == null) {
			hoSoLienThongImpl.setHoTenCanBoNopHoSoGiay(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setHoTenCanBoNopHoSoGiay(hoTenCanBoNopHoSoGiay);
		}

		hoSoLienThongImpl.setTrangThaiLienThong(trangThaiLienThong);

		if (ghiChuGuiLienThong == null) {
			hoSoLienThongImpl.setGhiChuGuiLienThong(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setGhiChuGuiLienThong(ghiChuGuiLienThong);
		}

		if (hoTenCongDanNop == null) {
			hoSoLienThongImpl.setHoTenCongDanNop(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setHoTenCongDanNop(hoTenCongDanNop);
		}

		if (diaChiDayDuCongDanNop == null) {
			hoSoLienThongImpl.setDiaChiDayDuCongDanNop(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setDiaChiDayDuCongDanNop(diaChiDayDuCongDanNop);
		}

		if (ngayTuChoi == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayTuChoi(null);
		}
		else {
			hoSoLienThongImpl.setNgayTuChoi(new Date(ngayTuChoi));
		}

		if (ngayNoiNhanTraKetQua == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayNoiNhanTraKetQua(null);
		}
		else {
			hoSoLienThongImpl.setNgayNoiNhanTraKetQua(new Date(
					ngayNoiNhanTraKetQua));
		}

		if (ngayNoiGuiNhanKetQua == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayNoiGuiNhanKetQua(null);
		}
		else {
			hoSoLienThongImpl.setNgayNoiGuiNhanKetQua(new Date(
					ngayNoiGuiNhanKetQua));
		}

		hoSoLienThongImpl.setCanBoTiepNhanNoiGuiId(canBoTiepNhanNoiGuiId);

		if (hoTenCanBoTiepNhanNoiGui == null) {
			hoSoLienThongImpl.setHoTenCanBoTiepNhanNoiGui(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setHoTenCanBoTiepNhanNoiGui(hoTenCanBoTiepNhanNoiGui);
		}

		if (tenCoQuanGui == null) {
			hoSoLienThongImpl.setTenCoQuanGui(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setTenCoQuanGui(tenCoQuanGui);
		}

		if (tenThuTucGui == null) {
			hoSoLienThongImpl.setTenThuTucGui(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setTenThuTucGui(tenThuTucGui);
		}

		if (tenCoQuanNhan == null) {
			hoSoLienThongImpl.setTenCoQuanNhan(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setTenCoQuanNhan(tenCoQuanNhan);
		}

		if (tenThuTucNhan == null) {
			hoSoLienThongImpl.setTenThuTucNhan(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setTenThuTucNhan(tenThuTucNhan);
		}

		hoSoLienThongImpl.setThuTuLienThong(thuTuLienThong);

		if (ngayNoiNhanHenTra == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayNoiNhanHenTra(null);
		}
		else {
			hoSoLienThongImpl.setNgayNoiNhanHenTra(new Date(ngayNoiNhanHenTra));
		}

		hoSoLienThongImpl.setSoNgayNoiNhanXuLyDuKien(soNgayNoiNhanXuLyDuKien);

		if (nguoiTao == null) {
			hoSoLienThongImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgayTao(null);
		}
		else {
			hoSoLienThongImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			hoSoLienThongImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			hoSoLienThongImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			hoSoLienThongImpl.setNgaySua(null);
		}
		else {
			hoSoLienThongImpl.setNgaySua(new Date(ngaySua));
		}

		hoSoLienThongImpl.setDaXoa(daXoa);

		hoSoLienThongImpl.resetOriginalValues();

		return hoSoLienThongImpl;
	}

	public long id;
	public long hoSoId;
	public long coQuanGuiId;
	public long coQuanNhanId;
	public long thuTucGuiId;
	public long thuTucNhanId;
	public String maSoBienNhanLucGui;
	public String maSoBienNhanLucNhan;
	public long canBoGuiId;
	public Long canBoNhanId;
	public long ngayGui;
	public long ngayNhan;
	public String hoTenCanBoGui;
	public String hoTenCanBoNhan;
	public Long canBoNopHoSoGiayId;
	public String hoTenCanBoNopHoSoGiay;
	public int trangThaiLienThong;
	public String ghiChuGuiLienThong;
	public String hoTenCongDanNop;
	public String diaChiDayDuCongDanNop;
	public long ngayTuChoi;
	public long ngayNoiNhanTraKetQua;
	public long ngayNoiGuiNhanKetQua;
	public long canBoTiepNhanNoiGuiId;
	public String hoTenCanBoTiepNhanNoiGui;
	public String tenCoQuanGui;
	public String tenThuTucGui;
	public String tenCoQuanNhan;
	public String tenThuTucNhan;
	public int thuTuLienThong;
	public long ngayNoiNhanHenTra;
	public int soNgayNoiNhanXuLyDuKien;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public int daXoa;
}