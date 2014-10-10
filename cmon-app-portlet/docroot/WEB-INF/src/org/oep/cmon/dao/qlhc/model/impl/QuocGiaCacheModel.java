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

package org.oep.cmon.dao.qlhc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.qlhc.model.QuocGia;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing QuocGia in entity cache.
 *
 * @author LIEMNN
 * @see QuocGia
 * @generated
 */
public class QuocGiaCacheModel implements CacheModel<QuocGia>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append("}");

		return sb.toString();
	}

	public QuocGia toEntityModel() {
		QuocGiaImpl quocGiaImpl = new QuocGiaImpl();

		quocGiaImpl.setId(id);

		if (ma == null) {
			quocGiaImpl.setMa(StringPool.BLANK);
		}
		else {
			quocGiaImpl.setMa(ma);
		}

		if (ten == null) {
			quocGiaImpl.setTen(StringPool.BLANK);
		}
		else {
			quocGiaImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			quocGiaImpl.setNgayTao(null);
		}
		else {
			quocGiaImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			quocGiaImpl.setNgaySua(null);
		}
		else {
			quocGiaImpl.setNgaySua(new Date(ngaySua));
		}

		quocGiaImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			quocGiaImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			quocGiaImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			quocGiaImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			quocGiaImpl.setNguoiSua(nguoiSua);
		}

		quocGiaImpl.setPhienBan(phienBan);

		quocGiaImpl.resetOriginalValues();

		return quocGiaImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public int phienBan;
}