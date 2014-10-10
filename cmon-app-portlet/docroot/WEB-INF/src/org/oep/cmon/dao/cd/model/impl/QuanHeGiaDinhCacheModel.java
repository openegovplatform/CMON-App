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

import org.oep.cmon.dao.cd.model.QuanHeGiaDinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing QuanHeGiaDinh in entity cache.
 *
 * @author LIEMNN
 * @see QuanHeGiaDinh
 * @generated
 */
public class QuanHeGiaDinhCacheModel implements CacheModel<QuanHeGiaDinh>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	public QuanHeGiaDinh toEntityModel() {
		QuanHeGiaDinhImpl quanHeGiaDinhImpl = new QuanHeGiaDinhImpl();

		quanHeGiaDinhImpl.setId(id);

		if (ten == null) {
			quanHeGiaDinhImpl.setTen(StringPool.BLANK);
		}
		else {
			quanHeGiaDinhImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			quanHeGiaDinhImpl.setNgayTao(null);
		}
		else {
			quanHeGiaDinhImpl.setNgayTao(new Date(ngayTao));
		}

		quanHeGiaDinhImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			quanHeGiaDinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			quanHeGiaDinhImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			quanHeGiaDinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			quanHeGiaDinhImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			quanHeGiaDinhImpl.setNgaySua(null);
		}
		else {
			quanHeGiaDinhImpl.setNgaySua(new Date(ngaySua));
		}

		quanHeGiaDinhImpl.resetOriginalValues();

		return quanHeGiaDinhImpl;
	}

	public long id;
	public String ten;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
}