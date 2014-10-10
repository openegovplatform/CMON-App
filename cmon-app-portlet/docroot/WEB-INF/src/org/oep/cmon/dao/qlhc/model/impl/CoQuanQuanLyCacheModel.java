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

import org.oep.cmon.dao.qlhc.model.CoQuanQuanLy;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CoQuanQuanLy in entity cache.
 *
 * @author LIEMNN
 * @see CoQuanQuanLy
 * @generated
 */
public class CoQuanQuanLyCacheModel implements CacheModel<CoQuanQuanLy>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", diaChi=");
		sb.append(diaChi);
		sb.append(", dienThoai=");
		sb.append(dienThoai);
		sb.append(", email=");
		sb.append(email);
		sb.append(", fax=");
		sb.append(fax);
		sb.append(", website=");
		sb.append(website);
		sb.append(", noiBo=");
		sb.append(noiBo);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", donViHanhChinhId=");
		sb.append(donViHanhChinhId);
		sb.append(", capCoQuanQuanlyId=");
		sb.append(capCoQuanQuanlyId);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", merchant=");
		sb.append(merchant);
		sb.append(", accessCode=");
		sb.append(accessCode);
		sb.append(", secureSecret=");
		sb.append(secureSecret);
		sb.append(", maCapSoBienNhan=");
		sb.append(maCapSoBienNhan);
		sb.append("}");

		return sb.toString();
	}

	public CoQuanQuanLy toEntityModel() {
		CoQuanQuanLyImpl coQuanQuanLyImpl = new CoQuanQuanLyImpl();

		coQuanQuanLyImpl.setId(id);

		if (ma == null) {
			coQuanQuanLyImpl.setMa(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setMa(ma);
		}

		if (ten == null) {
			coQuanQuanLyImpl.setTen(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setTen(ten);
		}

		if (diaChi == null) {
			coQuanQuanLyImpl.setDiaChi(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setDiaChi(diaChi);
		}

		if (dienThoai == null) {
			coQuanQuanLyImpl.setDienThoai(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setDienThoai(dienThoai);
		}

		if (email == null) {
			coQuanQuanLyImpl.setEmail(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setEmail(email);
		}

		if (fax == null) {
			coQuanQuanLyImpl.setFax(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setFax(fax);
		}

		if (website == null) {
			coQuanQuanLyImpl.setWebsite(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setWebsite(website);
		}

		coQuanQuanLyImpl.setNoiBo(noiBo);
		coQuanQuanLyImpl.setPhienBan(phienBan);
		coQuanQuanLyImpl.setDaXoa(daXoa);
		coQuanQuanLyImpl.setDonViHanhChinhId(donViHanhChinhId);
		coQuanQuanLyImpl.setCapCoQuanQuanlyId(capCoQuanQuanlyId);
		coQuanQuanLyImpl.setChaId(chaId);

		if (nguoiTao == null) {
			coQuanQuanLyImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			coQuanQuanLyImpl.setNgayTao(null);
		}
		else {
			coQuanQuanLyImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			coQuanQuanLyImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			coQuanQuanLyImpl.setNgaySua(null);
		}
		else {
			coQuanQuanLyImpl.setNgaySua(new Date(ngaySua));
		}

		if (merchant == null) {
			coQuanQuanLyImpl.setMerchant(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setMerchant(merchant);
		}

		if (accessCode == null) {
			coQuanQuanLyImpl.setAccessCode(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setAccessCode(accessCode);
		}

		if (secureSecret == null) {
			coQuanQuanLyImpl.setSecureSecret(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setSecureSecret(secureSecret);
		}

		if (maCapSoBienNhan == null) {
			coQuanQuanLyImpl.setMaCapSoBienNhan(StringPool.BLANK);
		}
		else {
			coQuanQuanLyImpl.setMaCapSoBienNhan(maCapSoBienNhan);
		}

		coQuanQuanLyImpl.resetOriginalValues();

		return coQuanQuanLyImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String diaChi;
	public String dienThoai;
	public String email;
	public String fax;
	public String website;
	public int noiBo;
	public long phienBan;
	public int daXoa;
	public Long donViHanhChinhId;
	public Long capCoQuanQuanlyId;
	public Long chaId;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public String merchant;
	public String accessCode;
	public String secureSecret;
	public String maCapSoBienNhan;
}