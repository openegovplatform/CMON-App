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

package org.oep.cmon.dao.tlct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.tlct.model.TaiLieuChungThuc;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TaiLieuChungThuc in entity cache.
 *
 * @author Liemnn
 * @see TaiLieuChungThuc
 * @generated
 */
public class TaiLieuChungThucCacheModel implements CacheModel<TaiLieuChungThuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", noiLuuTruId=");
		sb.append(noiLuuTruId);
		sb.append(", ngayUpload=");
		sb.append(ngayUpload);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", ngayDuyet=");
		sb.append(ngayDuyet);
		sb.append(", hieuLucTuNgay=");
		sb.append(hieuLucTuNgay);
		sb.append(", hieuLucDenNgay=");
		sb.append(hieuLucDenNgay);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", danhMucGiayToId=");
		sb.append(danhMucGiayToId);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", chuSohuuId=");
		sb.append(chuSohuuId);
		sb.append(", nguoiUploadId=");
		sb.append(nguoiUploadId);
		sb.append(", nguoiduyetId=");
		sb.append(nguoiduyetId);
		sb.append(", hoSoTTHCCId=");
		sb.append(hoSoTTHCCId);
		sb.append(", maUngDung=");
		sb.append(maUngDung);
		sb.append(", loai=");
		sb.append(loai);
		sb.append("}");

		return sb.toString();
	}

	public TaiLieuChungThuc toEntityModel() {
		TaiLieuChungThucImpl taiLieuChungThucImpl = new TaiLieuChungThucImpl();

		taiLieuChungThucImpl.setId(id);

		if (ten == null) {
			taiLieuChungThucImpl.setTen(StringPool.BLANK);
		}
		else {
			taiLieuChungThucImpl.setTen(ten);
		}

		if (ghiChu == null) {
			taiLieuChungThucImpl.setGhiChu(StringPool.BLANK);
		}
		else {
			taiLieuChungThucImpl.setGhiChu(ghiChu);
		}

		taiLieuChungThucImpl.setNoiLuuTruId(noiLuuTruId);

		if (ngayUpload == Long.MIN_VALUE) {
			taiLieuChungThucImpl.setNgayUpload(null);
		}
		else {
			taiLieuChungThucImpl.setNgayUpload(new Date(ngayUpload));
		}

		taiLieuChungThucImpl.setPhienBan(phienBan);

		if (ngayDuyet == Long.MIN_VALUE) {
			taiLieuChungThucImpl.setNgayDuyet(null);
		}
		else {
			taiLieuChungThucImpl.setNgayDuyet(new Date(ngayDuyet));
		}

		if (hieuLucTuNgay == Long.MIN_VALUE) {
			taiLieuChungThucImpl.setHieuLucTuNgay(null);
		}
		else {
			taiLieuChungThucImpl.setHieuLucTuNgay(new Date(hieuLucTuNgay));
		}

		if (hieuLucDenNgay == Long.MIN_VALUE) {
			taiLieuChungThucImpl.setHieuLucDenNgay(null);
		}
		else {
			taiLieuChungThucImpl.setHieuLucDenNgay(new Date(hieuLucDenNgay));
		}

		if (ngaySua == Long.MIN_VALUE) {
			taiLieuChungThucImpl.setNgaySua(null);
		}
		else {
			taiLieuChungThucImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			taiLieuChungThucImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			taiLieuChungThucImpl.setNguoiSua(nguoiSua);
		}

		taiLieuChungThucImpl.setDanhMucGiayToId(danhMucGiayToId);
		taiLieuChungThucImpl.setTrangThai(trangThai);
		taiLieuChungThucImpl.setChuSohuuId(chuSohuuId);
		taiLieuChungThucImpl.setNguoiUploadId(nguoiUploadId);
		taiLieuChungThucImpl.setNguoiduyetId(nguoiduyetId);
		taiLieuChungThucImpl.setHoSoTTHCCId(hoSoTTHCCId);

		if (maUngDung == null) {
			taiLieuChungThucImpl.setMaUngDung(StringPool.BLANK);
		}
		else {
			taiLieuChungThucImpl.setMaUngDung(maUngDung);
		}

		taiLieuChungThucImpl.setLoai(loai);

		taiLieuChungThucImpl.resetOriginalValues();

		return taiLieuChungThucImpl;
	}

	public long id;
	public String ten;
	public String ghiChu;
	public long noiLuuTruId;
	public long ngayUpload;
	public int phienBan;
	public long ngayDuyet;
	public long hieuLucTuNgay;
	public long hieuLucDenNgay;
	public long ngaySua;
	public String nguoiSua;
	public Long danhMucGiayToId;
	public int trangThai;
	public Long chuSohuuId;
	public Long nguoiUploadId;
	public Long nguoiduyetId;
	public Long hoSoTTHCCId;
	public String maUngDung;
	public int loai;
}