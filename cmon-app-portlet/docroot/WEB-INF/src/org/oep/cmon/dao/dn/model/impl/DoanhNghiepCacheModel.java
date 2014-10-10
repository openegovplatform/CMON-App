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

package org.oep.cmon.dao.dn.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dn.model.DoanhNghiep;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DoanhNghiep in entity cache.
 *
 * @author Liemnn
 * @see DoanhNghiep
 * @generated
 */
public class DoanhNghiepCacheModel implements CacheModel<DoanhNghiep>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(103);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", maSoThue=");
		sb.append(maSoThue);
		sb.append(", tenTiengNuocNgoai=");
		sb.append(tenTiengNuocNgoai);
		sb.append(", tenVietTat=");
		sb.append(tenVietTat);
		sb.append(", diaChiDoanhNghiep=");
		sb.append(diaChiDoanhNghiep);
		sb.append(", dienThoaiDoanhNghiep=");
		sb.append(dienThoaiDoanhNghiep);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", emailDoanhNghiep=");
		sb.append(emailDoanhNghiep);
		sb.append(", website=");
		sb.append(website);
		sb.append(", tongSoVon=");
		sb.append(tongSoVon);
		sb.append(", moTaNganhNgheKinhDoanh=");
		sb.append(moTaNganhNgheKinhDoanh);
		sb.append(", soGCNDKKD=");
		sb.append(soGCNDKKD);
		sb.append(", ngayCapGCNDKKD=");
		sb.append(ngayCapGCNDKKD);
		sb.append(", noiLuuTruId=");
		sb.append(noiLuuTruId);
		sb.append(", ngayDieuLeDuocThongQua=");
		sb.append(ngayDieuLeDuocThongQua);
		sb.append(", tenChiNhanh=");
		sb.append(tenChiNhanh);
		sb.append(", diaChiChiNhanh=");
		sb.append(diaChiChiNhanh);
		sb.append(", tenVanPhongDaiDien=");
		sb.append(tenVanPhongDaiDien);
		sb.append(", diaChiVanPhongDaiDien=");
		sb.append(diaChiVanPhongDaiDien);
		sb.append(", ngayBatDauTamNgung=");
		sb.append(ngayBatDauTamNgung);
		sb.append(", ngayKetThucTamNgung=");
		sb.append(ngayKetThucTamNgung);
		sb.append(", lyDoTamNgung=");
		sb.append(lyDoTamNgung);
		sb.append(", ngayChamDutHoatDongKD=");
		sb.append(ngayChamDutHoatDongKD);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", diaChiDoanhNghiepHuyenId=");
		sb.append(diaChiDoanhNghiepHuyenId);
		sb.append(", diaChiDoanhNghiepTinhId=");
		sb.append(diaChiDoanhNghiepTinhId);
		sb.append(", diaChiDoanhNghiepXaId=");
		sb.append(diaChiDoanhNghiepXaId);
		sb.append(", loaiDoiTuongId=");
		sb.append(loaiDoiTuongId);
		sb.append(", nguoiDaiDienId=");
		sb.append(nguoiDaiDienId);
		sb.append(", trangThaiDoanhNghiepId=");
		sb.append(trangThaiDoanhNghiepId);
		sb.append(", vonDieuLe=");
		sb.append(vonDieuLe);
		sb.append(", vonToiThieuMotXaVien=");
		sb.append(vonToiThieuMotXaVien);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", quocGiaId=");
		sb.append(quocGiaId);
		sb.append(", coQuanCapId=");
		sb.append(coQuanCapId);
		sb.append(", tenCoQuanCap=");
		sb.append(tenCoQuanCap);
		sb.append(", soLanDieuChinh=");
		sb.append(soLanDieuChinh);
		sb.append(", ngayDieuChinh=");
		sb.append(ngayDieuChinh);
		sb.append(", chucVuNguoiDaiDien=");
		sb.append(chucVuNguoiDaiDien);
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
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(taiKhoanNguoiDungId);
		sb.append(", tenDiaDiemKinhDoanh=");
		sb.append(tenDiaDiemKinhDoanh);
		sb.append(", ngayDangKyKinhDoanh=");
		sb.append(ngayDangKyKinhDoanh);
		sb.append(", loaiHinhDoanhNghiepId=");
		sb.append(loaiHinhDoanhNghiepId);
		sb.append("}");

		return sb.toString();
	}

	public DoanhNghiep toEntityModel() {
		DoanhNghiepImpl doanhNghiepImpl = new DoanhNghiepImpl();

		doanhNghiepImpl.setId(id);

		if (ma == null) {
			doanhNghiepImpl.setMa(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setMa(ma);
		}

		if (ten == null) {
			doanhNghiepImpl.setTen(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTen(ten);
		}

		if (maSoThue == null) {
			doanhNghiepImpl.setMaSoThue(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setMaSoThue(maSoThue);
		}

		if (tenTiengNuocNgoai == null) {
			doanhNghiepImpl.setTenTiengNuocNgoai(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTenTiengNuocNgoai(tenTiengNuocNgoai);
		}

		if (tenVietTat == null) {
			doanhNghiepImpl.setTenVietTat(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTenVietTat(tenVietTat);
		}

		if (diaChiDoanhNghiep == null) {
			doanhNghiepImpl.setDiaChiDoanhNghiep(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setDiaChiDoanhNghiep(diaChiDoanhNghiep);
		}

		if (dienThoaiDoanhNghiep == null) {
			doanhNghiepImpl.setDienThoaiDoanhNghiep(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setDienThoaiDoanhNghiep(dienThoaiDoanhNghiep);
		}

		if (fax == null) {
			doanhNghiepImpl.setFax(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setFax(fax);
		}

		if (emailDoanhNghiep == null) {
			doanhNghiepImpl.setEmailDoanhNghiep(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setEmailDoanhNghiep(emailDoanhNghiep);
		}

		if (website == null) {
			doanhNghiepImpl.setWebsite(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setWebsite(website);
		}

		doanhNghiepImpl.setTongSoVon(tongSoVon);

		if (moTaNganhNgheKinhDoanh == null) {
			doanhNghiepImpl.setMoTaNganhNgheKinhDoanh(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setMoTaNganhNgheKinhDoanh(moTaNganhNgheKinhDoanh);
		}

		if (soGCNDKKD == null) {
			doanhNghiepImpl.setSoGCNDKKD(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setSoGCNDKKD(soGCNDKKD);
		}

		if (ngayCapGCNDKKD == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayCapGCNDKKD(null);
		}
		else {
			doanhNghiepImpl.setNgayCapGCNDKKD(new Date(ngayCapGCNDKKD));
		}

		doanhNghiepImpl.setNoiLuuTruId(noiLuuTruId);

		if (ngayDieuLeDuocThongQua == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayDieuLeDuocThongQua(null);
		}
		else {
			doanhNghiepImpl.setNgayDieuLeDuocThongQua(new Date(
					ngayDieuLeDuocThongQua));
		}

		if (tenChiNhanh == null) {
			doanhNghiepImpl.setTenChiNhanh(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTenChiNhanh(tenChiNhanh);
		}

		if (diaChiChiNhanh == null) {
			doanhNghiepImpl.setDiaChiChiNhanh(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setDiaChiChiNhanh(diaChiChiNhanh);
		}

		if (tenVanPhongDaiDien == null) {
			doanhNghiepImpl.setTenVanPhongDaiDien(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTenVanPhongDaiDien(tenVanPhongDaiDien);
		}

		if (diaChiVanPhongDaiDien == null) {
			doanhNghiepImpl.setDiaChiVanPhongDaiDien(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setDiaChiVanPhongDaiDien(diaChiVanPhongDaiDien);
		}

		if (ngayBatDauTamNgung == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayBatDauTamNgung(null);
		}
		else {
			doanhNghiepImpl.setNgayBatDauTamNgung(new Date(ngayBatDauTamNgung));
		}

		if (ngayKetThucTamNgung == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayKetThucTamNgung(null);
		}
		else {
			doanhNghiepImpl.setNgayKetThucTamNgung(new Date(ngayKetThucTamNgung));
		}

		if (lyDoTamNgung == null) {
			doanhNghiepImpl.setLyDoTamNgung(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setLyDoTamNgung(lyDoTamNgung);
		}

		if (ngayChamDutHoatDongKD == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayChamDutHoatDongKD(null);
		}
		else {
			doanhNghiepImpl.setNgayChamDutHoatDongKD(new Date(
					ngayChamDutHoatDongKD));
		}

		doanhNghiepImpl.setLoai(loai);
		doanhNghiepImpl.setDiaChiDoanhNghiepHuyenId(diaChiDoanhNghiepHuyenId);
		doanhNghiepImpl.setDiaChiDoanhNghiepTinhId(diaChiDoanhNghiepTinhId);
		doanhNghiepImpl.setDiaChiDoanhNghiepXaId(diaChiDoanhNghiepXaId);
		doanhNghiepImpl.setLoaiDoiTuongId(loaiDoiTuongId);
		doanhNghiepImpl.setNguoiDaiDienId(nguoiDaiDienId);
		doanhNghiepImpl.setTrangThaiDoanhNghiepId(trangThaiDoanhNghiepId);
		doanhNghiepImpl.setVonDieuLe(vonDieuLe);
		doanhNghiepImpl.setVonToiThieuMotXaVien(vonToiThieuMotXaVien);

		if (ghiChu == null) {
			doanhNghiepImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setGhiChu(ghiChu);
		}

		doanhNghiepImpl.setQuocGiaId(quocGiaId);
		doanhNghiepImpl.setCoQuanCapId(coQuanCapId);
		doanhNghiepImpl.setTenCoQuanCap(tenCoQuanCap);

		if (soLanDieuChinh == null) {
			doanhNghiepImpl.setSoLanDieuChinh(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setSoLanDieuChinh(soLanDieuChinh);
		}

		if (ngayDieuChinh == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayDieuChinh(null);
		}
		else {
			doanhNghiepImpl.setNgayDieuChinh(new Date(ngayDieuChinh));
		}

		if (chucVuNguoiDaiDien == null) {
			doanhNghiepImpl.setChucVuNguoiDaiDien(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setChucVuNguoiDaiDien(chucVuNguoiDaiDien);
		}

		if (ngayTao == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayTao(null);
		}
		else {
			doanhNghiepImpl.setNgayTao(new Date(ngayTao));
		}

		doanhNghiepImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgaySua(null);
		}
		else {
			doanhNghiepImpl.setNgaySua(new Date(ngaySua));
		}

		doanhNghiepImpl.setChaId(chaId);

		if (nguoiTao == null) {
			doanhNghiepImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			doanhNghiepImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setNguoiSua(nguoiSua);
		}

		doanhNghiepImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);

		if (tenDiaDiemKinhDoanh == null) {
			doanhNghiepImpl.setTenDiaDiemKinhDoanh(StringPool.BLANK);
		}
		else {
			doanhNghiepImpl.setTenDiaDiemKinhDoanh(tenDiaDiemKinhDoanh);
		}

		if (ngayDangKyKinhDoanh == Long.MIN_VALUE) {
			doanhNghiepImpl.setNgayDangKyKinhDoanh(null);
		}
		else {
			doanhNghiepImpl.setNgayDangKyKinhDoanh(new Date(ngayDangKyKinhDoanh));
		}

		doanhNghiepImpl.setLoaiHinhDoanhNghiepId(loaiHinhDoanhNghiepId);

		doanhNghiepImpl.resetOriginalValues();

		return doanhNghiepImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String maSoThue;
	public String tenTiengNuocNgoai;
	public String tenVietTat;
	public String diaChiDoanhNghiep;
	public String dienThoaiDoanhNghiep;
	public String fax;
	public String emailDoanhNghiep;
	public String website;
	public long tongSoVon;
	public String moTaNganhNgheKinhDoanh;
	public String soGCNDKKD;
	public long ngayCapGCNDKKD;
	public long noiLuuTruId;
	public long ngayDieuLeDuocThongQua;
	public String tenChiNhanh;
	public String diaChiChiNhanh;
	public String tenVanPhongDaiDien;
	public String diaChiVanPhongDaiDien;
	public long ngayBatDauTamNgung;
	public long ngayKetThucTamNgung;
	public String lyDoTamNgung;
	public long ngayChamDutHoatDongKD;
	public long loai;
	public Long diaChiDoanhNghiepHuyenId;
	public Long diaChiDoanhNghiepTinhId;
	public Long diaChiDoanhNghiepXaId;
	public Long loaiDoiTuongId;
	public Long nguoiDaiDienId;
	public Long trangThaiDoanhNghiepId;
	public long vonDieuLe;
	public long vonToiThieuMotXaVien;
	public String ghiChu;
	public Long quocGiaId;
	public Long coQuanCapId;
	public long tenCoQuanCap;
	public String soLanDieuChinh;
	public long ngayDieuChinh;
	public String chucVuNguoiDaiDien;
	public long ngayTao;
	public int daXoa;
	public long ngaySua;
	public Long chaId;
	public String nguoiTao;
	public String nguoiSua;
	public Long taiKhoanNguoiDungId;
	public String tenDiaDiemKinhDoanh;
	public long ngayDangKyKinhDoanh;
	public Long loaiHinhDoanhNghiepId;
}