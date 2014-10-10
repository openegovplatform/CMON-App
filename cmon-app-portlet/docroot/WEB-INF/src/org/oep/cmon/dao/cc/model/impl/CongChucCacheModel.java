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

package org.oep.cmon.dao.cc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.cc.model.CongChuc;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CongChuc in entity cache.
 *
 * @author Liemnn
 * @see CongChuc
 * @generated
 */
public class CongChucCacheModel implements CacheModel<CongChuc>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", hoVaTen=");
		sb.append(hoVaTen);
		sb.append(", ngaySinh=");
		sb.append(ngaySinh);
		sb.append(", soCmnd=");
		sb.append(soCmnd);
		sb.append(", ngayCapCmnd=");
		sb.append(ngayCapCmnd);
		sb.append(", noiCapCmnd=");
		sb.append(noiCapCmnd);
		sb.append(", gioiTinhId=");
		sb.append(gioiTinhId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(taiKhoanNguoiDungId);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", chucVuId=");
		sb.append(chucVuId);
		sb.append(", coQuanQuanLyId=");
		sb.append(coQuanQuanLyId);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append("}");

		return sb.toString();
	}

	public CongChuc toEntityModel() {
		CongChucImpl congChucImpl = new CongChucImpl();

		congChucImpl.setId(id);

		if (ma == null) {
			congChucImpl.setMa(StringPool.BLANK);
		}
		else {
			congChucImpl.setMa(ma);
		}

		if (hoVaTen == null) {
			congChucImpl.setHoVaTen(StringPool.BLANK);
		}
		else {
			congChucImpl.setHoVaTen(hoVaTen);
		}

		if (ngaySinh == Long.MIN_VALUE) {
			congChucImpl.setNgaySinh(null);
		}
		else {
			congChucImpl.setNgaySinh(new Date(ngaySinh));
		}

		if (soCmnd == null) {
			congChucImpl.setSoCmnd(StringPool.BLANK);
		}
		else {
			congChucImpl.setSoCmnd(soCmnd);
		}

		if (ngayCapCmnd == Long.MIN_VALUE) {
			congChucImpl.setNgayCapCmnd(null);
		}
		else {
			congChucImpl.setNgayCapCmnd(new Date(ngayCapCmnd));
		}

		if (noiCapCmnd == null) {
			congChucImpl.setNoiCapCmnd(StringPool.BLANK);
		}
		else {
			congChucImpl.setNoiCapCmnd(noiCapCmnd);
		}

		congChucImpl.setGioiTinhId(gioiTinhId);

		if (ngayTao == Long.MIN_VALUE) {
			congChucImpl.setNgayTao(null);
		}
		else {
			congChucImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			congChucImpl.setNgaySua(null);
		}
		else {
			congChucImpl.setNgaySua(new Date(ngaySua));
		}

		congChucImpl.setDaXoa(daXoa);
		congChucImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);

		if (nguoiSua == null) {
			congChucImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			congChucImpl.setNguoiSua(nguoiSua);
		}

		congChucImpl.setChucVuId(chucVuId);
		congChucImpl.setCoQuanQuanLyId(coQuanQuanLyId);

		if (nguoiTao == null) {
			congChucImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			congChucImpl.setNguoiTao(nguoiTao);
		}

		congChucImpl.resetOriginalValues();

		return congChucImpl;
	}

	public long id;
	public String ma;
	public String hoVaTen;
	public long ngaySinh;
	public String soCmnd;
	public long ngayCapCmnd;
	public String noiCapCmnd;
	public long gioiTinhId;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public Long taiKhoanNguoiDungId;
	public String nguoiSua;
	public long chucVuId;
	public long coQuanQuanLyId;
	public String nguoiTao;
}