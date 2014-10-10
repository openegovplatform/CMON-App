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

import org.oep.cmon.dao.cd.model.HoChieuCMND;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoChieuCMND in entity cache.
 *
 * @author LIEMNN
 * @see HoChieuCMND
 * @generated
 */
public class HoChieuCMNDCacheModel implements CacheModel<HoChieuCMND>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", so=");
		sb.append(so);
		sb.append(", ngayCap=");
		sb.append(ngayCap);
		sb.append(", ngayHetHan=");
		sb.append(ngayHetHan);
		sb.append(", noiCapId=");
		sb.append(noiCapId);
		sb.append(", noiCap=");
		sb.append(noiCap);
		sb.append(", giChu=");
		sb.append(giChu);
		sb.append(", loai=");
		sb.append(loai);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", congDanID=");
		sb.append(congDanID);
		sb.append("}");

		return sb.toString();
	}

	public HoChieuCMND toEntityModel() {
		HoChieuCMNDImpl hoChieuCMNDImpl = new HoChieuCMNDImpl();

		hoChieuCMNDImpl.setId(id);

		if (so == null) {
			hoChieuCMNDImpl.setSo(StringPool.BLANK);
		}
		else {
			hoChieuCMNDImpl.setSo(so);
		}

		if (ngayCap == Long.MIN_VALUE) {
			hoChieuCMNDImpl.setNgayCap(null);
		}
		else {
			hoChieuCMNDImpl.setNgayCap(new Date(ngayCap));
		}

		if (ngayHetHan == Long.MIN_VALUE) {
			hoChieuCMNDImpl.setNgayHetHan(null);
		}
		else {
			hoChieuCMNDImpl.setNgayHetHan(new Date(ngayHetHan));
		}

		hoChieuCMNDImpl.setNoiCapId(noiCapId);

		if (noiCap == null) {
			hoChieuCMNDImpl.setNoiCap(StringPool.BLANK);
		}
		else {
			hoChieuCMNDImpl.setNoiCap(noiCap);
		}

		if (giChu == null) {
			hoChieuCMNDImpl.setGiChu(StringPool.BLANK);
		}
		else {
			hoChieuCMNDImpl.setGiChu(giChu);
		}

		hoChieuCMNDImpl.setLoai(loai);
		hoChieuCMNDImpl.setTrangThai(trangThai);

		if (nguoiTao == null) {
			hoChieuCMNDImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			hoChieuCMNDImpl.setNguoiTao(nguoiTao);
		}

		if (ngayTao == Long.MIN_VALUE) {
			hoChieuCMNDImpl.setNgayTao(null);
		}
		else {
			hoChieuCMNDImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiSua == null) {
			hoChieuCMNDImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			hoChieuCMNDImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			hoChieuCMNDImpl.setNgaySua(null);
		}
		else {
			hoChieuCMNDImpl.setNgaySua(new Date(ngaySua));
		}

		hoChieuCMNDImpl.setCongDanID(congDanID);

		hoChieuCMNDImpl.resetOriginalValues();

		return hoChieuCMNDImpl;
	}

	public long id;
	public String so;
	public long ngayCap;
	public long ngayHetHan;
	public Long noiCapId;
	public String noiCap;
	public String giChu;
	public int loai;
	public int trangThai;
	public String nguoiTao;
	public long ngayTao;
	public String nguoiSua;
	public long ngaySua;
	public Long congDanID;
}