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

package org.oep.cmon.dao.csms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.csms.model.YeuCauDangKyCongDan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YeuCauDangKyCongDan in entity cache.
 *
 * @author NAM
 * @see YeuCauDangKyCongDan
 * @generated
 */
public class YeuCauDangKyCongDanCacheModel implements CacheModel<YeuCauDangKyCongDan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(123);

		sb.append("{id=");
		sb.append(id);
		sb.append(", NgayYeuCau=");
		sb.append(NgayYeuCau);
		sb.append(", SoCmnd=");
		sb.append(SoCmnd);
		sb.append(", NgayCapCmnd=");
		sb.append(NgayCapCmnd);
		sb.append(", IDNoiCapCmnd=");
		sb.append(IDNoiCapCmnd);
		sb.append(", GhiChuCmnd=");
		sb.append(GhiChuCmnd);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", HoCongDan=");
		sb.append(HoCongDan);
		sb.append(", HoVaTen=");
		sb.append(HoVaTen);
		sb.append(", TenDem=");
		sb.append(TenDem);
		sb.append(", TenCongDan=");
		sb.append(TenCongDan);
		sb.append(", NgaySinh=");
		sb.append(NgaySinh);
		sb.append(", GioiTinh=");
		sb.append(GioiTinh);
		sb.append(", IDDanToc=");
		sb.append(IDDanToc);
		sb.append(", IDQuocTich=");
		sb.append(IDQuocTich);
		sb.append(", IDTonGiao=");
		sb.append(IDTonGiao);
		sb.append(", DienThoaiCoDinh=");
		sb.append(DienThoaiCoDinh);
		sb.append(", DienThoaiDiDong=");
		sb.append(DienThoaiDiDong);
		sb.append(", IDTrinhDoHocVan=");
		sb.append(IDTrinhDoHocVan);
		sb.append(", SoHoChieu=");
		sb.append(SoHoChieu);
		sb.append(", NgayCapHoChieu=");
		sb.append(NgayCapHoChieu);
		sb.append(", IDNoiCapHoChieu=");
		sb.append(IDNoiCapHoChieu);
		sb.append(", NgayHetHanHoChieu=");
		sb.append(NgayHetHanHoChieu);
		sb.append(", GhiChuHoChieu=");
		sb.append(GhiChuHoChieu);
		sb.append(", SoBaoHiemYte=");
		sb.append(SoBaoHiemYte);
		sb.append(", MaSoThueCaNhan=");
		sb.append(MaSoThueCaNhan);
		sb.append(", IDNgheNghiep=");
		sb.append(IDNgheNghiep);
		sb.append(", IDTrinhDoChuyenMon=");
		sb.append(IDTrinhDoChuyenMon);
		sb.append(", TinhTrangHonNhan=");
		sb.append(TinhTrangHonNhan);
		sb.append(", HoVaTenCha=");
		sb.append(HoVaTenCha);
		sb.append(", HoVaTenMe=");
		sb.append(HoVaTenMe);
		sb.append(", HoVaTenVoChong=");
		sb.append(HoVaTenVoChong);
		sb.append(", SoHoKhau=");
		sb.append(SoHoKhau);
		sb.append(", ChuHo=");
		sb.append(ChuHo);
		sb.append(", IDQuanHe=");
		sb.append(IDQuanHe);
		sb.append(", IDTinhThanhNoiSinh=");
		sb.append(IDTinhThanhNoiSinh);
		sb.append(", IDQuanHuyenNoiSinh=");
		sb.append(IDQuanHuyenNoiSinh);
		sb.append(", IDPhuongXaNoiSinh=");
		sb.append(IDPhuongXaNoiSinh);
		sb.append(", MoTaDiaChiNoiSinh=");
		sb.append(MoTaDiaChiNoiSinh);
		sb.append(", IDTinhThanhThuongTru=");
		sb.append(IDTinhThanhThuongTru);
		sb.append(", IDQuanHuyenThuongTru=");
		sb.append(IDQuanHuyenThuongTru);
		sb.append(", IDPhuongXaThuongTru=");
		sb.append(IDPhuongXaThuongTru);
		sb.append(", MoTaDiaChiThuongTru=");
		sb.append(MoTaDiaChiThuongTru);
		sb.append(", IDTinhThanhHienTai=");
		sb.append(IDTinhThanhHienTai);
		sb.append(", IDQuanHuyenHienTai=");
		sb.append(IDQuanHuyenHienTai);
		sb.append(", IDPhuongXaHienTai=");
		sb.append(IDPhuongXaHienTai);
		sb.append(", MoTaDiaChiHienTai=");
		sb.append(MoTaDiaChiHienTai);
		sb.append(", MaXacNhan=");
		sb.append(MaXacNhan);
		sb.append(", NgayChungThuc=");
		sb.append(NgayChungThuc);
		sb.append(", NguoiChungThuc=");
		sb.append(NguoiChungThuc);
		sb.append(", MaCongDanCha=");
		sb.append(MaCongDanCha);
		sb.append(", MaCongDanMe=");
		sb.append(MaCongDanMe);
		sb.append(", MaCongDanVoChong=");
		sb.append(MaCongDanVoChong);
		sb.append(", MaCongDan=");
		sb.append(MaCongDan);
		sb.append(", LoaiYeuCau=");
		sb.append(LoaiYeuCau);
		sb.append(", TrangThaiYeuCau=");
		sb.append(TrangThaiYeuCau);
		sb.append(", NgayTao=");
		sb.append(NgayTao);
		sb.append(", NgaySua=");
		sb.append(NgaySua);
		sb.append(", NguoiTao=");
		sb.append(NguoiTao);
		sb.append(", NguoiSua=");
		sb.append(NguoiSua);
		sb.append(", Xoa=");
		sb.append(Xoa);
		sb.append("}");

		return sb.toString();
	}

	public YeuCauDangKyCongDan toEntityModel() {
		YeuCauDangKyCongDanImpl yeuCauDangKyCongDanImpl = new YeuCauDangKyCongDanImpl();

		yeuCauDangKyCongDanImpl.setId(id);

		if (NgayYeuCau == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayYeuCau(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayYeuCau(new Date(NgayYeuCau));
		}

		if (SoCmnd == null) {
			yeuCauDangKyCongDanImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setSoCmnd(SoCmnd);
		}

		if (NgayCapCmnd == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayCapCmnd(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayCapCmnd(new Date(NgayCapCmnd));
		}

		yeuCauDangKyCongDanImpl.setIDNoiCapCmnd(IDNoiCapCmnd);

		if (GhiChuCmnd == null) {
			yeuCauDangKyCongDanImpl.setGhiChuCmnd(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setGhiChuCmnd(GhiChuCmnd);
		}

		if (Email == null) {
			yeuCauDangKyCongDanImpl.setEmail(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setEmail(Email);
		}

		if (HoCongDan == null) {
			yeuCauDangKyCongDanImpl.setHoCongDan(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setHoCongDan(HoCongDan);
		}

		if (HoVaTen == null) {
			yeuCauDangKyCongDanImpl.setHoVaTen(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setHoVaTen(HoVaTen);
		}

		if (TenDem == null) {
			yeuCauDangKyCongDanImpl.setTenDem(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setTenDem(TenDem);
		}

		if (TenCongDan == null) {
			yeuCauDangKyCongDanImpl.setTenCongDan(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setTenCongDan(TenCongDan);
		}

		if (NgaySinh == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgaySinh(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgaySinh(new Date(NgaySinh));
		}

		yeuCauDangKyCongDanImpl.setGioiTinh(GioiTinh);
		yeuCauDangKyCongDanImpl.setIDDanToc(IDDanToc);
		yeuCauDangKyCongDanImpl.setIDQuocTich(IDQuocTich);
		yeuCauDangKyCongDanImpl.setIDTonGiao(IDTonGiao);

		if (DienThoaiCoDinh == null) {
			yeuCauDangKyCongDanImpl.setDienThoaiCoDinh(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setDienThoaiCoDinh(DienThoaiCoDinh);
		}

		if (DienThoaiDiDong == null) {
			yeuCauDangKyCongDanImpl.setDienThoaiDiDong(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setDienThoaiDiDong(DienThoaiDiDong);
		}

		yeuCauDangKyCongDanImpl.setIDTrinhDoHocVan(IDTrinhDoHocVan);

		if (SoHoChieu == null) {
			yeuCauDangKyCongDanImpl.setSoHoChieu(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setSoHoChieu(SoHoChieu);
		}

		if (NgayCapHoChieu == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayCapHoChieu(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayCapHoChieu(new Date(NgayCapHoChieu));
		}

		yeuCauDangKyCongDanImpl.setIDNoiCapHoChieu(IDNoiCapHoChieu);

		if (NgayHetHanHoChieu == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayHetHanHoChieu(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayHetHanHoChieu(new Date(
					NgayHetHanHoChieu));
		}

		if (GhiChuHoChieu == null) {
			yeuCauDangKyCongDanImpl.setGhiChuHoChieu(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setGhiChuHoChieu(GhiChuHoChieu);
		}

		if (SoBaoHiemYte == null) {
			yeuCauDangKyCongDanImpl.setSoBaoHiemYte(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setSoBaoHiemYte(SoBaoHiemYte);
		}

		if (MaSoThueCaNhan == null) {
			yeuCauDangKyCongDanImpl.setMaSoThueCaNhan(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaSoThueCaNhan(MaSoThueCaNhan);
		}

		yeuCauDangKyCongDanImpl.setIDNgheNghiep(IDNgheNghiep);
		yeuCauDangKyCongDanImpl.setIDTrinhDoChuyenMon(IDTrinhDoChuyenMon);
		yeuCauDangKyCongDanImpl.setTinhTrangHonNhan(TinhTrangHonNhan);

		if (HoVaTenCha == null) {
			yeuCauDangKyCongDanImpl.setHoVaTenCha(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setHoVaTenCha(HoVaTenCha);
		}

		if (HoVaTenMe == null) {
			yeuCauDangKyCongDanImpl.setHoVaTenMe(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setHoVaTenMe(HoVaTenMe);
		}

		if (HoVaTenVoChong == null) {
			yeuCauDangKyCongDanImpl.setHoVaTenVoChong(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setHoVaTenVoChong(HoVaTenVoChong);
		}

		if (SoHoKhau == null) {
			yeuCauDangKyCongDanImpl.setSoHoKhau(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setSoHoKhau(SoHoKhau);
		}

		yeuCauDangKyCongDanImpl.setChuHo(ChuHo);
		yeuCauDangKyCongDanImpl.setIDQuanHe(IDQuanHe);
		yeuCauDangKyCongDanImpl.setIDTinhThanhNoiSinh(IDTinhThanhNoiSinh);
		yeuCauDangKyCongDanImpl.setIDQuanHuyenNoiSinh(IDQuanHuyenNoiSinh);
		yeuCauDangKyCongDanImpl.setIDPhuongXaNoiSinh(IDPhuongXaNoiSinh);

		if (MoTaDiaChiNoiSinh == null) {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiNoiSinh(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiNoiSinh(MoTaDiaChiNoiSinh);
		}

		yeuCauDangKyCongDanImpl.setIDTinhThanhThuongTru(IDTinhThanhThuongTru);
		yeuCauDangKyCongDanImpl.setIDQuanHuyenThuongTru(IDQuanHuyenThuongTru);
		yeuCauDangKyCongDanImpl.setIDPhuongXaThuongTru(IDPhuongXaThuongTru);

		if (MoTaDiaChiThuongTru == null) {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiThuongTru(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiThuongTru(MoTaDiaChiThuongTru);
		}

		yeuCauDangKyCongDanImpl.setIDTinhThanhHienTai(IDTinhThanhHienTai);
		yeuCauDangKyCongDanImpl.setIDQuanHuyenHienTai(IDQuanHuyenHienTai);
		yeuCauDangKyCongDanImpl.setIDPhuongXaHienTai(IDPhuongXaHienTai);

		if (MoTaDiaChiHienTai == null) {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiHienTai(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMoTaDiaChiHienTai(MoTaDiaChiHienTai);
		}

		if (MaXacNhan == null) {
			yeuCauDangKyCongDanImpl.setMaXacNhan(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaXacNhan(MaXacNhan);
		}

		if (NgayChungThuc == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayChungThuc(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayChungThuc(new Date(NgayChungThuc));
		}

		if (NguoiChungThuc == null) {
			yeuCauDangKyCongDanImpl.setNguoiChungThuc(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setNguoiChungThuc(NguoiChungThuc);
		}

		if (MaCongDanCha == null) {
			yeuCauDangKyCongDanImpl.setMaCongDanCha(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaCongDanCha(MaCongDanCha);
		}

		if (MaCongDanMe == null) {
			yeuCauDangKyCongDanImpl.setMaCongDanMe(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaCongDanMe(MaCongDanMe);
		}

		if (MaCongDanVoChong == null) {
			yeuCauDangKyCongDanImpl.setMaCongDanVoChong(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaCongDanVoChong(MaCongDanVoChong);
		}

		if (MaCongDan == null) {
			yeuCauDangKyCongDanImpl.setMaCongDan(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setMaCongDan(MaCongDan);
		}

		yeuCauDangKyCongDanImpl.setLoaiYeuCau(LoaiYeuCau);
		yeuCauDangKyCongDanImpl.setTrangThaiYeuCau(TrangThaiYeuCau);

		if (NgayTao == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgayTao(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgayTao(new Date(NgayTao));
		}

		if (NgaySua == Long.MIN_VALUE) {
			yeuCauDangKyCongDanImpl.setNgaySua(null);
		}
		else {
			yeuCauDangKyCongDanImpl.setNgaySua(new Date(NgaySua));
		}

		if (NguoiTao == null) {
			yeuCauDangKyCongDanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setNguoiTao(NguoiTao);
		}

		if (NguoiSua == null) {
			yeuCauDangKyCongDanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			yeuCauDangKyCongDanImpl.setNguoiSua(NguoiSua);
		}

		yeuCauDangKyCongDanImpl.setXoa(Xoa);

		yeuCauDangKyCongDanImpl.resetOriginalValues();

		return yeuCauDangKyCongDanImpl;
	}

	public long id;
	public long NgayYeuCau;
	public String SoCmnd;
	public long NgayCapCmnd;
	public Long IDNoiCapCmnd;
	public String GhiChuCmnd;
	public String Email;
	public String HoCongDan;
	public String HoVaTen;
	public String TenDem;
	public String TenCongDan;
	public long NgaySinh;
	public int GioiTinh;
	public Long IDDanToc;
	public Long IDQuocTich;
	public Long IDTonGiao;
	public String DienThoaiCoDinh;
	public String DienThoaiDiDong;
	public Long IDTrinhDoHocVan;
	public String SoHoChieu;
	public long NgayCapHoChieu;
	public Long IDNoiCapHoChieu;
	public long NgayHetHanHoChieu;
	public String GhiChuHoChieu;
	public String SoBaoHiemYte;
	public String MaSoThueCaNhan;
	public Long IDNgheNghiep;
	public Long IDTrinhDoChuyenMon;
	public Long TinhTrangHonNhan;
	public String HoVaTenCha;
	public String HoVaTenMe;
	public String HoVaTenVoChong;
	public String SoHoKhau;
	public int ChuHo;
	public Long IDQuanHe;
	public Long IDTinhThanhNoiSinh;
	public Long IDQuanHuyenNoiSinh;
	public Long IDPhuongXaNoiSinh;
	public String MoTaDiaChiNoiSinh;
	public Long IDTinhThanhThuongTru;
	public Long IDQuanHuyenThuongTru;
	public Long IDPhuongXaThuongTru;
	public String MoTaDiaChiThuongTru;
	public Long IDTinhThanhHienTai;
	public Long IDQuanHuyenHienTai;
	public Long IDPhuongXaHienTai;
	public String MoTaDiaChiHienTai;
	public String MaXacNhan;
	public long NgayChungThuc;
	public String NguoiChungThuc;
	public String MaCongDanCha;
	public String MaCongDanMe;
	public String MaCongDanVoChong;
	public String MaCongDan;
	public int LoaiYeuCau;
	public int TrangThaiYeuCau;
	public long NgayTao;
	public long NgaySua;
	public String NguoiTao;
	public String NguoiSua;
	public int Xoa;
}