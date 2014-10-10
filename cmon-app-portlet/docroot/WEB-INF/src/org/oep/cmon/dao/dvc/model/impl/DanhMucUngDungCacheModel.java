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

package org.oep.cmon.dao.dvc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dvc.model.DanhMucUngDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DanhMucUngDung in entity cache.
 *
 * @author liemnn
 * @see DanhMucUngDung
 * @generated
 */
public class DanhMucUngDungCacheModel implements CacheModel<DanhMucUngDung>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

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
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append("}");

		return sb.toString();
	}

	public DanhMucUngDung toEntityModel() {
		DanhMucUngDungImpl danhMucUngDungImpl = new DanhMucUngDungImpl();

		danhMucUngDungImpl.setId(id);

		if (ma == null) {
			danhMucUngDungImpl.setMa(StringPool.BLANK);
		}
		else {
			danhMucUngDungImpl.setMa(ma);
		}

		if (ten == null) {
			danhMucUngDungImpl.setTen(StringPool.BLANK);
		}
		else {
			danhMucUngDungImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			danhMucUngDungImpl.setNgayTao(null);
		}
		else {
			danhMucUngDungImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			danhMucUngDungImpl.setNgaySua(null);
		}
		else {
			danhMucUngDungImpl.setNgaySua(new Date(ngaySua));
		}

		danhMucUngDungImpl.setDaXoa(daXoa);

		if (nguoiSua == null) {
			danhMucUngDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			danhMucUngDungImpl.setNguoiSua(nguoiSua);
		}

		if (nguoiTao == null) {
			danhMucUngDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			danhMucUngDungImpl.setNguoiTao(nguoiTao);
		}

		danhMucUngDungImpl.resetOriginalValues();

		return danhMucUngDungImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiSua;
	public String nguoiTao;
}