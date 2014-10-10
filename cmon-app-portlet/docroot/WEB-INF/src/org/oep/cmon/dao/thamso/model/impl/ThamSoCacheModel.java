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

import org.oep.cmon.dao.thamso.model.ThamSo;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ThamSo in entity cache.
 *
 * @author LIEMNN
 * @see ThamSo
 * @generated
 */
public class ThamSoCacheModel implements CacheModel<ThamSo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", Ten=");
		sb.append(Ten);
		sb.append(", giaTri=");
		sb.append(giaTri);
		sb.append(", kieuDuLieu=");
		sb.append(kieuDuLieu);
		sb.append(", Mota=");
		sb.append(Mota);
		sb.append(", UngDungId=");
		sb.append(UngDungId);
		sb.append(", HeThongId=");
		sb.append(HeThongId);
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

	public ThamSo toEntityModel() {
		ThamSoImpl thamSoImpl = new ThamSoImpl();

		thamSoImpl.setId(Id);

		if (Ten == null) {
			thamSoImpl.setTen(StringPool.BLANK);
		}
		else {
			thamSoImpl.setTen(Ten);
		}

		if (giaTri == null) {
			thamSoImpl.setGiaTri(StringPool.BLANK);
		}
		else {
			thamSoImpl.setGiaTri(giaTri);
		}

		thamSoImpl.setKieuDuLieu(kieuDuLieu);

		if (Mota == null) {
			thamSoImpl.setMota(StringPool.BLANK);
		}
		else {
			thamSoImpl.setMota(Mota);
		}

		thamSoImpl.setUngDungId(UngDungId);
		thamSoImpl.setHeThongId(HeThongId);

		if (NgayTao == Long.MIN_VALUE) {
			thamSoImpl.setNgayTao(null);
		}
		else {
			thamSoImpl.setNgayTao(new Date(NgayTao));
		}

		if (NguoiTao == null) {
			thamSoImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			thamSoImpl.setNguoiTao(NguoiTao);
		}

		if (NgaySua == Long.MIN_VALUE) {
			thamSoImpl.setNgaySua(null);
		}
		else {
			thamSoImpl.setNgaySua(new Date(NgaySua));
		}

		if (NguoiSua == null) {
			thamSoImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			thamSoImpl.setNguoiSua(NguoiSua);
		}

		thamSoImpl.setDaXoa(DaXoa);

		thamSoImpl.resetOriginalValues();

		return thamSoImpl;
	}

	public long Id;
	public String Ten;
	public String giaTri;
	public int kieuDuLieu;
	public String Mota;
	public Long UngDungId;
	public Long HeThongId;
	public long NgayTao;
	public String NguoiTao;
	public long NgaySua;
	public String NguoiSua;
	public int DaXoa;
}