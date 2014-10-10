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

import org.oep.cmon.dao.qlhc.model.CapDonViHanhChinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CapDonViHanhChinh in entity cache.
 *
 * @author LIEMNN
 * @see CapDonViHanhChinh
 * @generated
 */
public class CapDonViHanhChinhCacheModel implements CacheModel<CapDonViHanhChinh>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", cap=");
		sb.append(cap);
		sb.append(", phienBan=");
		sb.append(phienBan);
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
		sb.append(", mota=");
		sb.append(mota);
		sb.append("}");

		return sb.toString();
	}

	public CapDonViHanhChinh toEntityModel() {
		CapDonViHanhChinhImpl capDonViHanhChinhImpl = new CapDonViHanhChinhImpl();

		capDonViHanhChinhImpl.setId(id);

		if (ma == null) {
			capDonViHanhChinhImpl.setMa(StringPool.BLANK);
		}
		else {
			capDonViHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			capDonViHanhChinhImpl.setTen(StringPool.BLANK);
		}
		else {
			capDonViHanhChinhImpl.setTen(ten);
		}

		capDonViHanhChinhImpl.setCap(cap);
		capDonViHanhChinhImpl.setPhienBan(phienBan);

		if (ngayTao == Long.MIN_VALUE) {
			capDonViHanhChinhImpl.setNgayTao(null);
		}
		else {
			capDonViHanhChinhImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			capDonViHanhChinhImpl.setNgaySua(null);
		}
		else {
			capDonViHanhChinhImpl.setNgaySua(new Date(ngaySua));
		}

		capDonViHanhChinhImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			capDonViHanhChinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			capDonViHanhChinhImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			capDonViHanhChinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			capDonViHanhChinhImpl.setNguoiSua(nguoiSua);
		}

		if (mota == null) {
			capDonViHanhChinhImpl.setMota(StringPool.BLANK);
		}
		else {
			capDonViHanhChinhImpl.setMota(mota);
		}

		capDonViHanhChinhImpl.resetOriginalValues();

		return capDonViHanhChinhImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long cap;
	public long phienBan;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public String mota;
}