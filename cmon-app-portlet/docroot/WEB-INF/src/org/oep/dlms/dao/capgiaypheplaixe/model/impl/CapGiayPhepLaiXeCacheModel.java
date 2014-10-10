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

package org.oep.dlms.dao.capgiaypheplaixe.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;


import java.io.Serializable;

import java.util.Date;

import org.oep.dlms.dao.capgiaypheplaixe.model.CapGiayPhepLaiXe;

/**
 * The cache model class for representing CapGiayPhepLaiXe in entity cache.
 *
 * @author AnhNT
 * @see CapGiayPhepLaiXe
 * @generated
 */
public class CapGiayPhepLaiXeCacheModel implements CacheModel<CapGiayPhepLaiXe>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(95);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idCoQuanQuanLy=");
		sb.append(idCoQuanQuanLy);
		sb.append(", idCongDan=");
		sb.append(idCongDan);
		sb.append(", idLoaiHoSo=");
		sb.append(idLoaiHoSo);
		sb.append(", soHoSo=");
		sb.append(soHoSo);
		sb.append(", hoVaTen=");
		sb.append(hoVaTen);
		sb.append(", ngaySinh=");
		sb.append(ngaySinh);
		sb.append(", idGioiTinh=");
		sb.append(idGioiTinh);
		sb.append(", idQuocTich=");
		sb.append(idQuocTich);
		sb.append(", soCMND=");
		sb.append(soCMND);
		sb.append(", ngayCapCMND=");
		sb.append(ngayCapCMND);
		sb.append(", idNoiCapCMND=");
		sb.append(idNoiCapCMND);
		sb.append(", soHoChieu=");
		sb.append(soHoChieu);
		sb.append(", ngayCapHoChieu=");
		sb.append(ngayCapHoChieu);
		sb.append(", noiCapHoChieu=");
		sb.append(noiCapHoChieu);
		sb.append(", dienThoai=");
		sb.append(dienThoai);
		sb.append(", email=");
		sb.append(email);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", idTinhThuongTru=");
		sb.append(idTinhThuongTru);
		sb.append(", idHuyenThuongTru=");
		sb.append(idHuyenThuongTru);
		sb.append(", idXaThuongTru=");
		sb.append(idXaThuongTru);
		sb.append(", diaChiThuongTru=");
		sb.append(diaChiThuongTru);
		sb.append(", idTinhCuTru=");
		sb.append(idTinhCuTru);
		sb.append(", idHuyenCuTru=");
		sb.append(idHuyenCuTru);
		sb.append(", idXaCuTru=");
		sb.append(idXaCuTru);
		sb.append(", diaChiCuTru=");
		sb.append(diaChiCuTru);
		sb.append(", soGiayPhepLaiXe=");
		sb.append(soGiayPhepLaiXe);
		sb.append(", idHangGiayPhepLaiXe=");
		sb.append(idHangGiayPhepLaiXe);
		sb.append(", idDonViCapGPLX=");
		sb.append(idDonViCapGPLX);
		sb.append(", ngayCapGPLX=");
		sb.append(ngayCapGPLX);
		sb.append(", idNoiCapGPLX=");
		sb.append(idNoiCapGPLX);
		sb.append(", ngayDauSatHach=");
		sb.append(ngayDauSatHach);
		sb.append(", idNoiHocLaiXe=");
		sb.append(idNoiHocLaiXe);
		sb.append(", namHocLaiXe=");
		sb.append(namHocLaiXe);
		sb.append(", namTrungTuyenHangCaoNhat=");
		sb.append(namTrungTuyenHangCaoNhat);
		sb.append(", lyDoHoc=");
		sb.append(lyDoHoc);
		sb.append(", mucDichHoc=");
		sb.append(mucDichHoc);
		sb.append(", soNamLaiXe=");
		sb.append(soNamLaiXe);
		sb.append(", soKmLaiXe=");
		sb.append(soKmLaiXe);
		sb.append(", ngayTraGPLX=");
		sb.append(ngayTraGPLX);
		sb.append(", idLyDoCapDoiLaiGPLX=");
		sb.append(idLyDoCapDoiLaiGPLX);
		sb.append(", lyDo=");
		sb.append(lyDo);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", xoa=");
		sb.append(xoa);
		sb.append("}");

		return sb.toString();
	}

	public CapGiayPhepLaiXe toEntityModel() {
		CapGiayPhepLaiXeImpl capGiayPhepLaiXeImpl = new CapGiayPhepLaiXeImpl();

		capGiayPhepLaiXeImpl.setId(id);
		capGiayPhepLaiXeImpl.setIdCoQuanQuanLy(idCoQuanQuanLy);
		capGiayPhepLaiXeImpl.setIdCongDan(idCongDan);
		capGiayPhepLaiXeImpl.setIdLoaiHoSo(idLoaiHoSo);
		capGiayPhepLaiXeImpl.setSoHoSo(soHoSo);

		if (hoVaTen == null) {
			capGiayPhepLaiXeImpl.setHoVaTen(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setHoVaTen(hoVaTen);
		}

		if (ngaySinh == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgaySinh(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgaySinh(new Date(ngaySinh));
		}

		capGiayPhepLaiXeImpl.setIdGioiTinh(idGioiTinh);
		capGiayPhepLaiXeImpl.setIdQuocTich(idQuocTich);

		if (soCMND == null) {
			capGiayPhepLaiXeImpl.setSoCMND(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setSoCMND(soCMND);
		}

		if (ngayCapCMND == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayCapCMND(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayCapCMND(new Date(ngayCapCMND));
		}

		capGiayPhepLaiXeImpl.setIdNoiCapCMND(idNoiCapCMND);

		if (soHoChieu == null) {
			capGiayPhepLaiXeImpl.setSoHoChieu(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setSoHoChieu(soHoChieu);
		}

		if (ngayCapHoChieu == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayCapHoChieu(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayCapHoChieu(new Date(ngayCapHoChieu));
		}

		capGiayPhepLaiXeImpl.setNoiCapHoChieu(noiCapHoChieu);

		if (dienThoai == null) {
			capGiayPhepLaiXeImpl.setDienThoai(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setDienThoai(dienThoai);
		}

		if (email == null) {
			capGiayPhepLaiXeImpl.setEmail(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setEmail(email);
		}

		if (ghiChu == null) {
			capGiayPhepLaiXeImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setGhiChu(ghiChu);
		}

		capGiayPhepLaiXeImpl.setIdTinhThuongTru(idTinhThuongTru);
		capGiayPhepLaiXeImpl.setIdHuyenThuongTru(idHuyenThuongTru);
		capGiayPhepLaiXeImpl.setIdXaThuongTru(idXaThuongTru);

		if (diaChiThuongTru == null) {
			capGiayPhepLaiXeImpl.setDiaChiThuongTru(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setDiaChiThuongTru(diaChiThuongTru);
		}

		capGiayPhepLaiXeImpl.setIdTinhCuTru(idTinhCuTru);
		capGiayPhepLaiXeImpl.setIdHuyenCuTru(idHuyenCuTru);
		capGiayPhepLaiXeImpl.setIdXaCuTru(idXaCuTru);

		if (diaChiCuTru == null) {
			capGiayPhepLaiXeImpl.setDiaChiCuTru(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setDiaChiCuTru(diaChiCuTru);
		}

		if (soGiayPhepLaiXe == null) {
			capGiayPhepLaiXeImpl.setSoGiayPhepLaiXe(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setSoGiayPhepLaiXe(soGiayPhepLaiXe);
		}

		capGiayPhepLaiXeImpl.setIdHangGiayPhepLaiXe(idHangGiayPhepLaiXe);
		capGiayPhepLaiXeImpl.setIdDonViCapGPLX(idDonViCapGPLX);

		if (ngayCapGPLX == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayCapGPLX(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayCapGPLX(new Date(ngayCapGPLX));
		}

		capGiayPhepLaiXeImpl.setIdNoiCapGPLX(idNoiCapGPLX);

		if (ngayDauSatHach == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayDauSatHach(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayDauSatHach(new Date(ngayDauSatHach));
		}

		capGiayPhepLaiXeImpl.setIdNoiHocLaiXe(idNoiHocLaiXe);
		capGiayPhepLaiXeImpl.setNamHocLaiXe(namHocLaiXe);
		capGiayPhepLaiXeImpl.setNamTrungTuyenHangCaoNhat(namTrungTuyenHangCaoNhat);

		if (lyDoHoc == null) {
			capGiayPhepLaiXeImpl.setLyDoHoc(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setLyDoHoc(lyDoHoc);
		}

		if (mucDichHoc == null) {
			capGiayPhepLaiXeImpl.setMucDichHoc(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setMucDichHoc(mucDichHoc);
		}

		capGiayPhepLaiXeImpl.setSoNamLaiXe(soNamLaiXe);
		capGiayPhepLaiXeImpl.setSoKmLaiXe(soKmLaiXe);

		if (ngayTraGPLX == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayTraGPLX(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayTraGPLX(new Date(ngayTraGPLX));
		}

		capGiayPhepLaiXeImpl.setIdLyDoCapDoiLaiGPLX(idLyDoCapDoiLaiGPLX);

		if (lyDo == null) {
			capGiayPhepLaiXeImpl.setLyDo(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setLyDo(lyDo);
		}

		if (ngayTao == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgayTao(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			capGiayPhepLaiXeImpl.setNgaySua(null);
		}
		else {
			capGiayPhepLaiXeImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			capGiayPhepLaiXeImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			capGiayPhepLaiXeImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			capGiayPhepLaiXeImpl.setNguoiSua(nguoiSua);
		}

		capGiayPhepLaiXeImpl.setXoa(xoa);

		capGiayPhepLaiXeImpl.resetOriginalValues();

		return capGiayPhepLaiXeImpl;
	}

	public long id;
	public long idCoQuanQuanLy;
	public long idCongDan;
	public long idLoaiHoSo;
	public long soHoSo;
	public String hoVaTen;
	public long ngaySinh;
	public long idGioiTinh;
	public long idQuocTich;
	public String soCMND;
	public long ngayCapCMND;
	public long idNoiCapCMND;
	public String soHoChieu;
	public long ngayCapHoChieu;
	public long noiCapHoChieu;
	public String dienThoai;
	public String email;
	public String ghiChu;
	public long idTinhThuongTru;
	public long idHuyenThuongTru;
	public long idXaThuongTru;
	public String diaChiThuongTru;
	public long idTinhCuTru;
	public long idHuyenCuTru;
	public long idXaCuTru;
	public String diaChiCuTru;
	public String soGiayPhepLaiXe;
	public long idHangGiayPhepLaiXe;
	public long idDonViCapGPLX;
	public long ngayCapGPLX;
	public long idNoiCapGPLX;
	public long ngayDauSatHach;
	public long idNoiHocLaiXe;
	public int namHocLaiXe;
	public int namTrungTuyenHangCaoNhat;
	public String lyDoHoc;
	public String mucDichHoc;
	public double soNamLaiXe;
	public double soKmLaiXe;
	public long ngayTraGPLX;
	public long idLyDoCapDoiLaiGPLX;
	public String lyDo;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int xoa;
}