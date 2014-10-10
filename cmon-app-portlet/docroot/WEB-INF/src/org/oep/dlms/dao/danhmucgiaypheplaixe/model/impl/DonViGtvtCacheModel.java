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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;


import java.io.Serializable;

import java.util.Date;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.DonViGtvt;

/**
 * The cache model class for representing DonViGtvt in entity cache.
 *
 * @author AnhNT
 * @see DonViGtvt
 * @generated
 */
public class DonViGtvtCacheModel implements CacheModel<DonViGtvt>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", coQuanQl=");
		sb.append(coQuanQl);
		sb.append(", dienThoai=");
		sb.append(dienThoai);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", lanhDao=");
		sb.append(lanhDao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", xoa=");
		sb.append(xoa);
		sb.append("}");

		return sb.toString();
	}

	public DonViGtvt toEntityModel() {
		DonViGtvtImpl donViGtvtImpl = new DonViGtvtImpl();

		donViGtvtImpl.setId(id);

		if (ma == null) {
			donViGtvtImpl.setMa(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setMa(ma);
		}

		if (ten == null) {
			donViGtvtImpl.setTen(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setTen(ten);
		}

		if (coQuanQl == null) {
			donViGtvtImpl.setCoQuanQl(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setCoQuanQl(coQuanQl);
		}

		if (dienThoai == null) {
			donViGtvtImpl.setDienThoai(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setDienThoai(dienThoai);
		}

		if (fax == null) {
			donViGtvtImpl.setFax(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setFax(fax);
		}

		if (diaChi == null) {
			donViGtvtImpl.setDiaChi(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setDiaChi(diaChi);
		}

		if (lanhDao == null) {
			donViGtvtImpl.setLanhDao(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setLanhDao(lanhDao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			donViGtvtImpl.setNgayTao(null);
		}
		else {
			donViGtvtImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			donViGtvtImpl.setNgaySua(null);
		}
		else {
			donViGtvtImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			donViGtvtImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			donViGtvtImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			donViGtvtImpl.setNguoiSua(nguoiSua);
		}

		donViGtvtImpl.setXoa(xoa);

		donViGtvtImpl.resetOriginalValues();

		return donViGtvtImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String coQuanQl;
	public String dienThoai;
	public String fax;
	public String diaChi;
	public String lanhDao;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int xoa;
}