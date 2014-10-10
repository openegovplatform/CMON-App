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

package org.oep.cmon.dao.qlhc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.qlhc.model.CoQuanHanhChinhSuNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CoQuanHanhChinhSuNghiep in entity cache.
 *
 * @author LIEMNN
 * @see CoQuanHanhChinhSuNghiep
 * @generated
 */
public class CoQuanHanhChinhSuNghiepCacheModel implements CacheModel<CoQuanHanhChinhSuNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", soDTDuongDayNong=");
		sb.append(soDTDuongDayNong);
		sb.append(", noiBo=");
		sb.append(noiBo);
		sb.append(", chucNang=");
		sb.append(chucNang);
		sb.append(", tongSoCBNV=");
		sb.append(tongSoCBNV);
		sb.append(", soDT=");
		sb.append(soDT);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", email=");
		sb.append(email);
		sb.append(", tongSoGiuongBenh=");
		sb.append(tongSoGiuongBenh);
		sb.append(", viDo=");
		sb.append(viDo);
		sb.append(", kinhDo=");
		sb.append(kinhDo);
		sb.append(", diaChiCoQuanHCSNXaId=");
		sb.append(diaChiCoQuanHCSNXaId);
		sb.append(", tuyenId=");
		sb.append(tuyenId);
		sb.append(", diaChiCoQuanHCSNTinhId=");
		sb.append(diaChiCoQuanHCSNTinhId);
		sb.append(", nguoiDaiDienId=");
		sb.append(nguoiDaiDienId);
		sb.append(", diaChiCoQuanHCSNHuyenId=");
		sb.append(diaChiCoQuanHCSNHuyenId);
		sb.append(", hangId=");
		sb.append(hangId);
		sb.append(", coQuanQuanLyId=");
		sb.append(coQuanQuanLyId);
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", soQdThanhLap=");
		sb.append(soQdThanhLap);
		sb.append(", moTaDiaChi=");
		sb.append(moTaDiaChi);
		sb.append(", tenNguoiDaiDien=");
		sb.append(tenNguoiDaiDien);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public CoQuanHanhChinhSuNghiep toEntityModel() {
		CoQuanHanhChinhSuNghiepImpl coQuanHanhChinhSuNghiepImpl = new CoQuanHanhChinhSuNghiepImpl();

		coQuanHanhChinhSuNghiepImpl.setId(id);

		if (ma == null) {
			coQuanHanhChinhSuNghiepImpl.setMa(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setMa(ma);
		}

		if (ten == null) {
			coQuanHanhChinhSuNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setTen(ten);
		}

		if (soDTDuongDayNong == null) {
			coQuanHanhChinhSuNghiepImpl.setSoDTDuongDayNong(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setSoDTDuongDayNong(soDTDuongDayNong);
		}

		coQuanHanhChinhSuNghiepImpl.setNoiBo(noiBo);

		if (chucNang == null) {
			coQuanHanhChinhSuNghiepImpl.setChucNang(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setChucNang(chucNang);
		}

		coQuanHanhChinhSuNghiepImpl.setTongSoCBNV(tongSoCBNV);

		if (soDT == null) {
			coQuanHanhChinhSuNghiepImpl.setSoDT(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setSoDT(soDT);
		}

		if (fax == null) {
			coQuanHanhChinhSuNghiepImpl.setFax(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setFax(fax);
		}

		if (email == null) {
			coQuanHanhChinhSuNghiepImpl.setEmail(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setEmail(email);
		}

		coQuanHanhChinhSuNghiepImpl.setTongSoGiuongBenh(tongSoGiuongBenh);

		if (viDo == null) {
			coQuanHanhChinhSuNghiepImpl.setViDo(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setViDo(viDo);
		}

		if (kinhDo == null) {
			coQuanHanhChinhSuNghiepImpl.setKinhDo(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setKinhDo(kinhDo);
		}

		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNXaId(diaChiCoQuanHCSNXaId);
		coQuanHanhChinhSuNghiepImpl.setTuyenId(tuyenId);
		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNTinhId(diaChiCoQuanHCSNTinhId);
		coQuanHanhChinhSuNghiepImpl.setNguoiDaiDienId(nguoiDaiDienId);
		coQuanHanhChinhSuNghiepImpl.setDiaChiCoQuanHCSNHuyenId(diaChiCoQuanHCSNHuyenId);
		coQuanHanhChinhSuNghiepImpl.setHangId(hangId);

		if (coQuanQuanLyId == null) {
			coQuanHanhChinhSuNghiepImpl.setCoQuanQuanLyId(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setCoQuanQuanLyId(coQuanQuanLyId);
		}

		if (loaiId == null) {
			coQuanHanhChinhSuNghiepImpl.setLoaiId(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setLoaiId(loaiId);
		}

		if (soQdThanhLap == null) {
			coQuanHanhChinhSuNghiepImpl.setSoQdThanhLap(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setSoQdThanhLap(soQdThanhLap);
		}

		if (moTaDiaChi == null) {
			coQuanHanhChinhSuNghiepImpl.setMoTaDiaChi(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setMoTaDiaChi(moTaDiaChi);
		}

		if (tenNguoiDaiDien == null) {
			coQuanHanhChinhSuNghiepImpl.setTenNguoiDaiDien(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setTenNguoiDaiDien(tenNguoiDaiDien);
		}

		if (ngayTao == Long.MIN_VALUE) {
			coQuanHanhChinhSuNghiepImpl.setNgayTao(null);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setNgayTao(new Date(ngayTao));
		}

		coQuanHanhChinhSuNghiepImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			coQuanHanhChinhSuNghiepImpl.setNgaySua(null);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setNgaySua(new Date(ngaySua));
		}

		coQuanHanhChinhSuNghiepImpl.setChaId(chaId);

		if (nguoiTao == null) {
			coQuanHanhChinhSuNghiepImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			coQuanHanhChinhSuNghiepImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			coQuanHanhChinhSuNghiepImpl.setNguoiSua(nguoiSua);
		}

		coQuanHanhChinhSuNghiepImpl.resetOriginalValues();

		return coQuanHanhChinhSuNghiepImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String soDTDuongDayNong;
	public long noiBo;
	public String chucNang;
	public long tongSoCBNV;
	public String soDT;
	public String fax;
	public String email;
	public long tongSoGiuongBenh;
	public String viDo;
	public String kinhDo;
	public long diaChiCoQuanHCSNXaId;
	public long tuyenId;
	public long diaChiCoQuanHCSNTinhId;
	public long nguoiDaiDienId;
	public long diaChiCoQuanHCSNHuyenId;
	public long hangId;
	public String coQuanQuanLyId;
	public String loaiId;
	public String soQdThanhLap;
	public String moTaDiaChi;
	public String tenNguoiDaiDien;
	public long ngayTao;
	public int daXoa;
	public long ngaySua;
	public Long chaId;
	public String nguoiTao;
	public String nguoiSua;
}