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

import org.oep.cmon.dao.cd.model.DanToc;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DanToc in entity cache.
 *
 * @author LIEMNN
 * @see DanToc
 * @generated
 */
public class DanTocCacheModel implements CacheModel<DanToc>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", laThieuSo=");
		sb.append(laThieuSo);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", tenKhac=");
		sb.append(tenKhac);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	public DanToc toEntityModel() {
		DanTocImpl danTocImpl = new DanTocImpl();

		danTocImpl.setId(id);

		if (ma == null) {
			danTocImpl.setMa(StringPool.BLANK);
		}
		else {
			danTocImpl.setMa(ma);
		}

		if (ten == null) {
			danTocImpl.setTen(StringPool.BLANK);
		}
		else {
			danTocImpl.setTen(ten);
		}

		danTocImpl.setPhienBan(phienBan);
		danTocImpl.setLaThieuSo(laThieuSo);

		if (ngayTao == Long.MIN_VALUE) {
			danTocImpl.setNgayTao(null);
		}
		else {
			danTocImpl.setNgayTao(new Date(ngayTao));
		}

		danTocImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			danTocImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			danTocImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			danTocImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			danTocImpl.setNguoiSua(nguoiSua);
		}

		if (tenKhac == null) {
			danTocImpl.setTenKhac(StringPool.BLANK);
		}
		else {
			danTocImpl.setTenKhac(tenKhac);
		}

		if (ngaySua == Long.MIN_VALUE) {
			danTocImpl.setNgaySua(null);
		}
		else {
			danTocImpl.setNgaySua(new Date(ngaySua));
		}

		danTocImpl.resetOriginalValues();

		return danTocImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long phienBan;
	public long laThieuSo;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public String tenKhac;
	public long ngaySua;
}