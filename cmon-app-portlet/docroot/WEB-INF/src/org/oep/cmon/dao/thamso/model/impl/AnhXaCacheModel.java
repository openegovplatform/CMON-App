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

package org.oep.cmon.dao.thamso.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.thamso.model.AnhXa;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AnhXa in entity cache.
 *
 * @author LIEMNN
 * @see AnhXa
 * @generated
 */
public class AnhXaCacheModel implements CacheModel<AnhXa>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", maDNG=");
		sb.append(maDNG);
		sb.append(", tenDNG=");
		sb.append(tenDNG);
		sb.append(", maKhac=");
		sb.append(maKhac);
		sb.append(", tenKhac=");
		sb.append(tenKhac);
		sb.append(", tenBang=");
		sb.append(tenBang);
		sb.append(", UngDungId=");
		sb.append(UngDungId);
		sb.append(", NgayTao=");
		sb.append(NgayTao);
		sb.append(", NguoiTao=");
		sb.append(NguoiTao);
		sb.append(", NgaySua=");
		sb.append(NgaySua);
		sb.append(", NguoiSua=");
		sb.append(NguoiSua);
		sb.append(", DaXoa=");
		sb.append(DaXoa);
		sb.append("}");

		return sb.toString();
	}

	public AnhXa toEntityModel() {
		AnhXaImpl anhXaImpl = new AnhXaImpl();

		anhXaImpl.setId(Id);

		if (maDNG == null) {
			anhXaImpl.setMaDNG(StringPool.BLANK);
		}
		else {
			anhXaImpl.setMaDNG(maDNG);
		}

		if (tenDNG == null) {
			anhXaImpl.setTenDNG(StringPool.BLANK);
		}
		else {
			anhXaImpl.setTenDNG(tenDNG);
		}

		if (maKhac == null) {
			anhXaImpl.setMaKhac(StringPool.BLANK);
		}
		else {
			anhXaImpl.setMaKhac(maKhac);
		}

		if (tenKhac == null) {
			anhXaImpl.setTenKhac(StringPool.BLANK);
		}
		else {
			anhXaImpl.setTenKhac(tenKhac);
		}

		if (tenBang == null) {
			anhXaImpl.setTenBang(StringPool.BLANK);
		}
		else {
			anhXaImpl.setTenBang(tenBang);
		}

		anhXaImpl.setUngDungId(UngDungId);

		if (NgayTao == Long.MIN_VALUE) {
			anhXaImpl.setNgayTao(null);
		}
		else {
			anhXaImpl.setNgayTao(new Date(NgayTao));
		}

		if (NguoiTao == null) {
			anhXaImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			anhXaImpl.setNguoiTao(NguoiTao);
		}

		if (NgaySua == Long.MIN_VALUE) {
			anhXaImpl.setNgaySua(null);
		}
		else {
			anhXaImpl.setNgaySua(new Date(NgaySua));
		}

		if (NguoiSua == null) {
			anhXaImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			anhXaImpl.setNguoiSua(NguoiSua);
		}

		anhXaImpl.setDaXoa(DaXoa);

		anhXaImpl.resetOriginalValues();

		return anhXaImpl;
	}

	public long Id;
	public String maDNG;
	public String tenDNG;
	public String maKhac;
	public String tenKhac;
	public String tenBang;
	public long UngDungId;
	public long NgayTao;
	public String NguoiTao;
	public long NgaySua;
	public String NguoiSua;
	public int DaXoa;
}