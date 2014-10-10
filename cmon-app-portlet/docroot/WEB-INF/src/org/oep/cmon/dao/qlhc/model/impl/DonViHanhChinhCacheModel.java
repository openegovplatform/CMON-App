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

import org.oep.cmon.dao.qlhc.model.DonViHanhChinh;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DonViHanhChinh in entity cache.
 *
 * @author LIEMNN
 * @see DonViHanhChinh
 * @generated
 */
public class DonViHanhChinhCacheModel implements CacheModel<DonViHanhChinh>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", capDonViHanhChinhId=");
		sb.append(capDonViHanhChinhId);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", quocGiaId=");
		sb.append(quocGiaId);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public DonViHanhChinh toEntityModel() {
		DonViHanhChinhImpl donViHanhChinhImpl = new DonViHanhChinhImpl();

		donViHanhChinhImpl.setId(id);

		if (ma == null) {
			donViHanhChinhImpl.setMa(StringPool.BLANK);
		}
		else {
			donViHanhChinhImpl.setMa(ma);
		}

		if (ten == null) {
			donViHanhChinhImpl.setTen(StringPool.BLANK);
		}
		else {
			donViHanhChinhImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			donViHanhChinhImpl.setNgayTao(null);
		}
		else {
			donViHanhChinhImpl.setNgayTao(new Date(ngayTao));
		}

		donViHanhChinhImpl.setPhienBan(phienBan);
		donViHanhChinhImpl.setDaXoa(daXoa);

		if (ngaySua == Long.MIN_VALUE) {
			donViHanhChinhImpl.setNgaySua(null);
		}
		else {
			donViHanhChinhImpl.setNgaySua(new Date(ngaySua));
		}

		donViHanhChinhImpl.setCapDonViHanhChinhId(capDonViHanhChinhId);
		donViHanhChinhImpl.setChaId(chaId);

		if (nguoiTao == null) {
			donViHanhChinhImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			donViHanhChinhImpl.setNguoiTao(nguoiTao);
		}

		donViHanhChinhImpl.setQuocGiaId(quocGiaId);

		if (nguoiSua == null) {
			donViHanhChinhImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			donViHanhChinhImpl.setNguoiSua(nguoiSua);
		}

		donViHanhChinhImpl.resetOriginalValues();

		return donViHanhChinhImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public long phienBan;
	public int daXoa;
	public long ngaySua;
	public long capDonViHanhChinhId;
	public Long chaId;
	public String nguoiTao;
	public long quocGiaId;
	public String nguoiSua;
}