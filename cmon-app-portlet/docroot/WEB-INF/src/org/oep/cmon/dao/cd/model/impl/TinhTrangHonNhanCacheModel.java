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

import org.oep.cmon.dao.cd.model.TinhTrangHonNhan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TinhTrangHonNhan in entity cache.
 *
 * @author LIEMNN
 * @see TinhTrangHonNhan
 * @generated
 */
public class TinhTrangHonNhanCacheModel implements CacheModel<TinhTrangHonNhan>,
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
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public TinhTrangHonNhan toEntityModel() {
		TinhTrangHonNhanImpl tinhTrangHonNhanImpl = new TinhTrangHonNhanImpl();

		tinhTrangHonNhanImpl.setId(id);

		if (ten == null) {
			tinhTrangHonNhanImpl.setTen(StringPool.BLANK);
		}
		else {
			tinhTrangHonNhanImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			tinhTrangHonNhanImpl.setNgayTao(null);
		}
		else {
			tinhTrangHonNhanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			tinhTrangHonNhanImpl.setNgaySua(null);
		}
		else {
			tinhTrangHonNhanImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			tinhTrangHonNhanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			tinhTrangHonNhanImpl.setNguoiTao(nguoiTao);
		}

		tinhTrangHonNhanImpl.setDaXoa(daXoa);

		if (nguoiSua == null) {
			tinhTrangHonNhanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			tinhTrangHonNhanImpl.setNguoiSua(nguoiSua);
		}

		tinhTrangHonNhanImpl.resetOriginalValues();

		return tinhTrangHonNhanImpl;
	}

	public long id;
	public String ten;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public int daXoa;
	public String nguoiSua;
}