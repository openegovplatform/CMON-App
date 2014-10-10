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

package org.oep.cmon.dao.cd.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.cd.model.CongDan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CongDan in entity cache.
 *
 * @author LIEMNN
 * @see CongDan
 * @generated
 */
public class CongDanCacheModel implements CacheModel<CongDan>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ho=");
		sb.append(ho);
		sb.append(", dem=");
		sb.append(dem);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngaySinh=");
		sb.append(ngaySinh);
		sb.append(", soCmnd=");
		sb.append(soCmnd);
		sb.append(", ngayCapCmnd=");
		sb.append(ngayCapCmnd);
		sb.append(", ghiChuCmnd=");
		sb.append(ghiChuCmnd);
		sb.append(", soHoChieu=");
		sb.append(soHoChieu);
		sb.append(", ngayCapHoChieu=");
		sb.append(ngayCapHoChieu);
		sb.append(", ngayHetHanHoChieu=");
		sb.append(ngayHetHanHoChieu);
		sb.append(", noiCapHoChieuId=");
		sb.append(noiCapHoChieuId);
		sb.append(", ghiChuHoChieu=");
		sb.append(ghiChuHoChieu);
		sb.append(", soBaoHiemYTe=");
		sb.append(soBaoHiemYTe);
		sb.append(", maSoThueCaNhan=");
		sb.append(maSoThueCaNhan);
		sb.append(", diaChiThuongTru=");
		sb.append(diaChiThuongTru);
		sb.append(", diaChiHienNay=");
		sb.append(diaChiHienNay);
		sb.append(", dienThoaiCoDinh=");
		sb.append(dienThoaiCoDinh);
		sb.append(", dienThoaiDiDong=");
		sb.append(dienThoaiDiDong);
		sb.append(", hoTenCha=");
		sb.append(hoTenCha);
		sb.append(", hoTenMe=");
		sb.append(hoTenMe);
		sb.append(", hoTenVoHoacChong=");
		sb.append(hoTenVoHoacChong);
		sb.append(", soHoKhau=");
		sb.append(soHoKhau);
		sb.append(", laChuHo=");
		sb.append(laChuHo);
		sb.append(", tinhTrangHonNhanId=");
		sb.append(tinhTrangHonNhanId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", trinhDoChuyenMonId=");
		sb.append(trinhDoChuyenMonId);
		sb.append(", soDinhDanhChaId=");
		sb.append(soDinhDanhChaId);
		sb.append(", soDinhDanhVoHoacChongId=");
		sb.append(soDinhDanhVoHoacChongId);
		sb.append(", danTocId=");
		sb.append(danTocId);
		sb.append(", diaChiHienNayHuyenId=");
		sb.append(diaChiHienNayHuyenId);
		sb.append(", diaChiHienNayTinhId=");
		sb.append(diaChiHienNayTinhId);
		sb.append(", diaChiHienNayXaId=");
		sb.append(diaChiHienNayXaId);
		sb.append(", diaChiThuongTruHuyenId=");
		sb.append(diaChiThuongTruHuyenId);
		sb.append(", diaChiThuongTruTinhId=");
		sb.append(diaChiThuongTruTinhId);
		sb.append(", diaChiThuongTruXaId=");
		sb.append(diaChiThuongTruXaId);
		sb.append(", gioiTinh=");
		sb.append(gioiTinh);
		sb.append(", ngheNghiepId=");
		sb.append(ngheNghiepId);
		sb.append(", noiSinhHuyenId=");
		sb.append(noiSinhHuyenId);
		sb.append(", noiSinhTinhId=");
		sb.append(noiSinhTinhId);
		sb.append(", noiSinhXaId=");
		sb.append(noiSinhXaId);
		sb.append(", noiSinhChiTiet=");
		sb.append(noiSinhChiTiet);
		sb.append(", noiCapCmndId=");
		sb.append(noiCapCmndId);
		sb.append(", tonGiaoId=");
		sb.append(tonGiaoId);
		sb.append(", soDinhDanhMeId=");
		sb.append(soDinhDanhMeId);
		sb.append(", trinhDoHocVanId=");
		sb.append(trinhDoHocVanId);
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(taiKhoanNguoiDungId);
		sb.append(", quanHeChuHoId=");
		sb.append(quanHeChuHoId);
		sb.append(", quocTichId=");
		sb.append(quocTichId);
		sb.append(", doanhNghiepId=");
		sb.append(doanhNghiepId);
		sb.append(", tenDayDu=");
		sb.append(tenDayDu);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", website=");
		sb.append(website);
		sb.append(", tinhtrang=");
		sb.append(tinhtrang);
		sb.append("}");

		return sb.toString();
	}

	public CongDan toEntityModel() {
		CongDanImpl congDanImpl = new CongDanImpl();

		congDanImpl.setId(id);

		if (ma == null) {
			congDanImpl.setMa(StringPool.BLANK);
		}
		else {
			congDanImpl.setMa(ma);
		}

		if (ho == null) {
			congDanImpl.setHo(StringPool.BLANK);
		}
		else {
			congDanImpl.setHo(ho);
		}

		if (dem == null) {
			congDanImpl.setDem(StringPool.BLANK);
		}
		else {
			congDanImpl.setDem(dem);
		}

		if (ten == null) {
			congDanImpl.setTen(StringPool.BLANK);
		}
		else {
			congDanImpl.setTen(ten);
		}

		if (ngaySinh == Long.MIN_VALUE) {
			congDanImpl.setNgaySinh(null);
		}
		else {
			congDanImpl.setNgaySinh(new Date(ngaySinh));
		}

		if (soCmnd == null) {
			congDanImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			congDanImpl.setSoCmnd(soCmnd);
		}

		if (ngayCapCmnd == Long.MIN_VALUE) {
			congDanImpl.setNgayCapCmnd(null);
		}
		else {
			congDanImpl.setNgayCapCmnd(new Date(ngayCapCmnd));
		}

		if (ghiChuCmnd == null) {
			congDanImpl.setGhiChuCmnd(StringPool.BLANK);
		}
		else {
			congDanImpl.setGhiChuCmnd(ghiChuCmnd);
		}

		if (soHoChieu == null) {
			congDanImpl.setSoHoChieu(StringPool.BLANK);
		}
		else {
			congDanImpl.setSoHoChieu(soHoChieu);
		}

		if (ngayCapHoChieu == Long.MIN_VALUE) {
			congDanImpl.setNgayCapHoChieu(null);
		}
		else {
			congDanImpl.setNgayCapHoChieu(new Date(ngayCapHoChieu));
		}

		if (ngayHetHanHoChieu == Long.MIN_VALUE) {
			congDanImpl.setNgayHetHanHoChieu(null);
		}
		else {
			congDanImpl.setNgayHetHanHoChieu(new Date(ngayHetHanHoChieu));
		}

		congDanImpl.setNoiCapHoChieuId(noiCapHoChieuId);

		if (ghiChuHoChieu == null) {
			congDanImpl.setGhiChuHoChieu(StringPool.BLANK);
		}
		else {
			congDanImpl.setGhiChuHoChieu(ghiChuHoChieu);
		}

		if (soBaoHiemYTe == null) {
			congDanImpl.setSoBaoHiemYTe(StringPool.BLANK);
		}
		else {
			congDanImpl.setSoBaoHiemYTe(soBaoHiemYTe);
		}

		if (maSoThueCaNhan == null) {
			congDanImpl.setMaSoThueCaNhan(StringPool.BLANK);
		}
		else {
			congDanImpl.setMaSoThueCaNhan(maSoThueCaNhan);
		}

		if (diaChiThuongTru == null) {
			congDanImpl.setDiaChiThuongTru(StringPool.BLANK);
		}
		else {
			congDanImpl.setDiaChiThuongTru(diaChiThuongTru);
		}

		if (diaChiHienNay == null) {
			congDanImpl.setDiaChiHienNay(StringPool.BLANK);
		}
		else {
			congDanImpl.setDiaChiHienNay(diaChiHienNay);
		}

		if (dienThoaiCoDinh == null) {
			congDanImpl.setDienThoaiCoDinh(StringPool.BLANK);
		}
		else {
			congDanImpl.setDienThoaiCoDinh(dienThoaiCoDinh);
		}

		if (dienThoaiDiDong == null) {
			congDanImpl.setDienThoaiDiDong(StringPool.BLANK);
		}
		else {
			congDanImpl.setDienThoaiDiDong(dienThoaiDiDong);
		}

		if (hoTenCha == null) {
			congDanImpl.setHoTenCha(StringPool.BLANK);
		}
		else {
			congDanImpl.setHoTenCha(hoTenCha);
		}

		if (hoTenMe == null) {
			congDanImpl.setHoTenMe(StringPool.BLANK);
		}
		else {
			congDanImpl.setHoTenMe(hoTenMe);
		}

		if (hoTenVoHoacChong == null) {
			congDanImpl.setHoTenVoHoacChong(StringPool.BLANK);
		}
		else {
			congDanImpl.setHoTenVoHoacChong(hoTenVoHoacChong);
		}

		if (soHoKhau == null) {
			congDanImpl.setSoHoKhau(StringPool.BLANK);
		}
		else {
			congDanImpl.setSoHoKhau(soHoKhau);
		}

		congDanImpl.setLaChuHo(laChuHo);
		congDanImpl.setTinhTrangHonNhanId(tinhTrangHonNhanId);

		if (email == null) {
			congDanImpl.setEmail(StringPool.BLANK);
		}
		else {
			congDanImpl.setEmail(email);
		}

		congDanImpl.setTrinhDoChuyenMonId(trinhDoChuyenMonId);
		congDanImpl.setSoDinhDanhChaId(soDinhDanhChaId);
		congDanImpl.setSoDinhDanhVoHoacChongId(soDinhDanhVoHoacChongId);
		congDanImpl.setDanTocId(danTocId);
		congDanImpl.setDiaChiHienNayHuyenId(diaChiHienNayHuyenId);
		congDanImpl.setDiaChiHienNayTinhId(diaChiHienNayTinhId);
		congDanImpl.setDiaChiHienNayXaId(diaChiHienNayXaId);
		congDanImpl.setDiaChiThuongTruHuyenId(diaChiThuongTruHuyenId);
		congDanImpl.setDiaChiThuongTruTinhId(diaChiThuongTruTinhId);
		congDanImpl.setDiaChiThuongTruXaId(diaChiThuongTruXaId);
		congDanImpl.setGioiTinh(gioiTinh);
		congDanImpl.setNgheNghiepId(ngheNghiepId);
		congDanImpl.setNoiSinhHuyenId(noiSinhHuyenId);
		congDanImpl.setNoiSinhTinhId(noiSinhTinhId);
		congDanImpl.setNoiSinhXaId(noiSinhXaId);

		if (noiSinhChiTiet == null) {
			congDanImpl.setNoiSinhChiTiet(StringPool.BLANK);
		}
		else {
			congDanImpl.setNoiSinhChiTiet(noiSinhChiTiet);
		}

		congDanImpl.setNoiCapCmndId(noiCapCmndId);
		congDanImpl.setTonGiaoId(tonGiaoId);
		congDanImpl.setSoDinhDanhMeId(soDinhDanhMeId);
		congDanImpl.setTrinhDoHocVanId(trinhDoHocVanId);
		congDanImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);
		congDanImpl.setQuanHeChuHoId(quanHeChuHoId);
		congDanImpl.setQuocTichId(quocTichId);
		congDanImpl.setDoanhNghiepId(doanhNghiepId);

		if (tenDayDu == null) {
			congDanImpl.setTenDayDu(StringPool.BLANK);
		}
		else {
			congDanImpl.setTenDayDu(tenDayDu);
		}

		if (ngayTao == Long.MIN_VALUE) {
			congDanImpl.setNgayTao(null);
		}
		else {
			congDanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			congDanImpl.setNgaySua(null);
		}
		else {
			congDanImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			congDanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			congDanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			congDanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			congDanImpl.setNguoiSua(nguoiSua);
		}

		congDanImpl.setDaXoa(daXoa);

		if (fax == null) {
			congDanImpl.setFax(StringPool.BLANK);
		}
		else {
			congDanImpl.setFax(fax);
		}

		if (website == null) {
			congDanImpl.setWebsite(StringPool.BLANK);
		}
		else {
			congDanImpl.setWebsite(website);
		}

		congDanImpl.setTinhtrang(tinhtrang);

		congDanImpl.resetOriginalValues();

		return congDanImpl;
	}

	public long id;
	public String ma;
	public String ho;
	public String dem;
	public String ten;
	public long ngaySinh;
	public String soCmnd;
	public long ngayCapCmnd;
	public String ghiChuCmnd;
	public String soHoChieu;
	public long ngayCapHoChieu;
	public long ngayHetHanHoChieu;
	public Long noiCapHoChieuId;
	public String ghiChuHoChieu;
	public String soBaoHiemYTe;
	public String maSoThueCaNhan;
	public String diaChiThuongTru;
	public String diaChiHienNay;
	public String dienThoaiCoDinh;
	public String dienThoaiDiDong;
	public String hoTenCha;
	public String hoTenMe;
	public String hoTenVoHoacChong;
	public String soHoKhau;
	public int laChuHo;
	public Long tinhTrangHonNhanId;
	public String email;
	public Long trinhDoChuyenMonId;
	public Long soDinhDanhChaId;
	public Long soDinhDanhVoHoacChongId;
	public Long danTocId;
	public Long diaChiHienNayHuyenId;
	public Long diaChiHienNayTinhId;
	public Long diaChiHienNayXaId;
	public Long diaChiThuongTruHuyenId;
	public Long diaChiThuongTruTinhId;
	public Long diaChiThuongTruXaId;
	public int gioiTinh;
	public Long ngheNghiepId;
	public Long noiSinhHuyenId;
	public Long noiSinhTinhId;
	public Long noiSinhXaId;
	public String noiSinhChiTiet;
	public Long noiCapCmndId;
	public Long tonGiaoId;
	public Long soDinhDanhMeId;
	public Long trinhDoHocVanId;
	public Long taiKhoanNguoiDungId;
	public Long quanHeChuHoId;
	public Long quocTichId;
	public Long doanhNghiepId;
	public String tenDayDu;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int daXoa;
	public String fax;
	public String website;
	public int tinhtrang;
}