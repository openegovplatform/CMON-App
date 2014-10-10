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

import org.oep.cmon.dao.dvc.model.DoiTuongSuDung;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DoiTuongSuDung in entity cache.
 *
 * @author liemnn
 * @see DoiTuongSuDung
 * @generated
 */
public class DoiTuongSuDungCacheModel implements CacheModel<DoiTuongSuDung>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", mota=");
		sb.append(mota);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public DoiTuongSuDung toEntityModel() {
		DoiTuongSuDungImpl doiTuongSuDungImpl = new DoiTuongSuDungImpl();

		doiTuongSuDungImpl.setId(id);

		if (ten == null) {
			doiTuongSuDungImpl.setTen(StringPool.BLANK);
		}
		else {
			doiTuongSuDungImpl.setTen(ten);
		}

		if (ma == null) {
			doiTuongSuDungImpl.setMa(StringPool.BLANK);
		}
		else {
			doiTuongSuDungImpl.setMa(ma);
		}

		if (mota == null) {
			doiTuongSuDungImpl.setMota(StringPool.BLANK);
		}
		else {
			doiTuongSuDungImpl.setMota(mota);
		}

		if (nguoiTao == null) {
			doiTuongSuDungImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			doiTuongSuDungImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			doiTuongSuDungImpl.setNgayTao(null);
		}
		else {
			doiTuongSuDungImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			doiTuongSuDungImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			doiTuongSuDungImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			doiTuongSuDungImpl.setNgaySua(null);
		}
		else {
			doiTuongSuDungImpl.setNgaySua(new Date(ngaySua));
		}

		doiTuongSuDungImpl.setTrangThai(trangThai);
		doiTuongSuDungImpl.setDaXoa(daXoa);

		doiTuongSuDungImpl.resetOriginalValues();

		return doiTuongSuDungImpl;
	}

	public long id;
	public String ten;
	public String ma;
	public String mota;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public int trangThai;
	public int daXoa;
}