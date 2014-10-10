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

package org.oep.cmon.dao.nsd.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.nsd.model.NhomNguoiDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NhomNguoiDung in entity cache.
 *
 * @author Liemnn
 * @see NhomNguoiDung
 * @generated
 */
public class NhomNguoiDungCacheModel implements CacheModel<NhomNguoiDung>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append("}");

		return sb.toString();
	}

	public NhomNguoiDung toEntityModel() {
		NhomNguoiDungImpl nhomNguoiDungImpl = new NhomNguoiDungImpl();

		nhomNguoiDungImpl.setId(id);

		if (ten == null) {
			nhomNguoiDungImpl.setTen(StringPool.BLANK);
		}
		else {
			nhomNguoiDungImpl.setTen(ten);
		}

		if (moTa == null) {
			nhomNguoiDungImpl.setMoTa(StringPool.BLANK);
		}
		else {
			nhomNguoiDungImpl.setMoTa(moTa);
		}

		if (ngayTao == Long.MIN_VALUE) {
			nhomNguoiDungImpl.setNgayTao(null);
		}
		else {
			nhomNguoiDungImpl.setNgayTao(new Date(ngayTao));
		}

		nhomNguoiDungImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			nhomNguoiDungImpl.setNgaySua(null);
		}
		else {
			nhomNguoiDungImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			nhomNguoiDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			nhomNguoiDungImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			nhomNguoiDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			nhomNguoiDungImpl.setNguoiSua(nguoiSua);
		}

		nhomNguoiDungImpl.setTrangThai(trangThai);

		nhomNguoiDungImpl.resetOriginalValues();

		return nhomNguoiDungImpl;
	}

	public long id;
	public String ten;
	public String moTa;
	public long ngayTao;
	public int daXoa;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int trangThai;
}