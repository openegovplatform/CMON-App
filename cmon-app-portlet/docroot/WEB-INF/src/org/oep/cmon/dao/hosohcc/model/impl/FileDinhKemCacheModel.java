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

package org.oep.cmon.dao.hosohcc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.hosohcc.model.FileDinhKem;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FileDinhKem in entity cache.
 *
 * @author LIEMNn
 * @see FileDinhKem
 * @generated
 */
public class FileDinhKemCacheModel implements CacheModel<FileDinhKem>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{id=");
		sb.append(id);
		sb.append(", soBanGiay=");
		sb.append(soBanGiay);
		sb.append(", daDoiChieu=");
		sb.append(daDoiChieu);
		sb.append(", trangThaiHoSoTaiThoiDiemDinhKem=");
		sb.append(trangThaiHoSoTaiThoiDiemDinhKem);
		sb.append(", noiLuuTruTaiLieuId=");
		sb.append(noiLuuTruTaiLieuId);
		sb.append(", canBoId=");
		sb.append(canBoId);
		sb.append(", hoSoTTHCCongId=");
		sb.append(hoSoTTHCCongId);
		sb.append(", thuTuc2GiayToId=");
		sb.append(thuTuc2GiayToId);
		sb.append(", danhMucGiayToId=");
		sb.append(danhMucGiayToId);
		sb.append(", ngayUpload=");
		sb.append(ngayUpload);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiUpload=");
		sb.append(nguoiUpload);
		sb.append(", maLoaiTaiLieuDuocThayThe=");
		sb.append(maLoaiTaiLieuDuocThayThe);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", xoa=");
		sb.append(xoa);
		sb.append(", daTra=");
		sb.append(daTra);
		sb.append(", banChinh=");
		sb.append(banChinh);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append("}");

		return sb.toString();
	}

	public FileDinhKem toEntityModel() {
		FileDinhKemImpl fileDinhKemImpl = new FileDinhKemImpl();

		fileDinhKemImpl.setId(id);
		fileDinhKemImpl.setSoBanGiay(soBanGiay);
		fileDinhKemImpl.setDaDoiChieu(daDoiChieu);
		fileDinhKemImpl.setTrangThaiHoSoTaiThoiDiemDinhKem(trangThaiHoSoTaiThoiDiemDinhKem);
		fileDinhKemImpl.setNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);
		fileDinhKemImpl.setCanBoId(canBoId);
		fileDinhKemImpl.setHoSoTTHCCongId(hoSoTTHCCongId);
		fileDinhKemImpl.setThuTuc2GiayToId(thuTuc2GiayToId);
		fileDinhKemImpl.setDanhMucGiayToId(danhMucGiayToId);

		if (ngayUpload == Long.MIN_VALUE) {
			fileDinhKemImpl.setNgayUpload(null);
		}
		else {
			fileDinhKemImpl.setNgayUpload(new Date(ngayUpload));
		}

		if (ngaySua == Long.MIN_VALUE) {
			fileDinhKemImpl.setNgaySua(null);
		}
		else {
			fileDinhKemImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiUpload == null) {
			fileDinhKemImpl.setNguoiUpload(StringPool.BLANK);
		}
		else {
			fileDinhKemImpl.setNguoiUpload(nguoiUpload);
		}

		if (maLoaiTaiLieuDuocThayThe == null) {
			fileDinhKemImpl.setMaLoaiTaiLieuDuocThayThe(StringPool.BLANK);
		}
		else {
			fileDinhKemImpl.setMaLoaiTaiLieuDuocThayThe(maLoaiTaiLieuDuocThayThe);
		}

		if (nguoiSua == null) {
			fileDinhKemImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			fileDinhKemImpl.setNguoiSua(nguoiSua);
		}

		fileDinhKemImpl.setXoa(xoa);
		fileDinhKemImpl.setDaTra(daTra);
		fileDinhKemImpl.setBanChinh(banChinh);

		if (ghiChu == null) {
			fileDinhKemImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			fileDinhKemImpl.setGhiChu(ghiChu);
		}

		fileDinhKemImpl.resetOriginalValues();

		return fileDinhKemImpl;
	}

	public long id;
	public long soBanGiay;
	public int daDoiChieu;
	public int trangThaiHoSoTaiThoiDiemDinhKem;
	public Long noiLuuTruTaiLieuId;
	public Long canBoId;
	public Long hoSoTTHCCongId;
	public Long thuTuc2GiayToId;
	public Long danhMucGiayToId;
	public long ngayUpload;
	public long ngaySua;
	public String nguoiUpload;
	public String maLoaiTaiLieuDuocThayThe;
	public String nguoiSua;
	public int xoa;
	public int daTra;
	public long banChinh;
	public String ghiChu;
}