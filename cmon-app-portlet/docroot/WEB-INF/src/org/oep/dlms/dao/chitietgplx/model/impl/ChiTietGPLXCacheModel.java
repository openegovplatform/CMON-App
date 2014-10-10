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

package org.oep.dlms.dao.chitietgplx.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;


import java.io.Serializable;

import java.util.Date;

import org.oep.dlms.dao.chitietgplx.model.ChiTietGPLX;

/**
 * The cache model class for representing ChiTietGPLX in entity cache.
 *
 * @author hunghq
 * @see ChiTietGPLX
 * @generated
 */
public class ChiTietGPLXCacheModel implements CacheModel<ChiTietGPLX>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idGPLX=");
		sb.append(idGPLX);
		sb.append(", soGPLX=");
		sb.append(soGPLX);
		sb.append(", idHangGPLX=");
		sb.append(idHangGPLX);
		sb.append(", idNoiCapGPLX=");
		sb.append(idNoiCapGPLX);
		sb.append(", idNoiCapGPLXNuocNgoai=");
		sb.append(idNoiCapGPLXNuocNgoai);
		sb.append(", ngayCapGPLX=");
		sb.append(ngayCapGPLX);
		sb.append(", ngayTrungTuyen=");
		sb.append(ngayTrungTuyen);
		sb.append(", ngayHetHan=");
		sb.append(ngayHetHan);
		sb.append(", idNoiHocLaiXe=");
		sb.append(idNoiHocLaiXe);
		sb.append(", idNoiHocLaiXeNuocNgoai=");
		sb.append(idNoiHocLaiXeNuocNgoai);
		sb.append(", namHocLaiXe=");
		sb.append(namHocLaiXe);
		sb.append(", noiHocLaiXeNuocNgoai=");
		sb.append(noiHocLaiXeNuocNgoai);
		sb.append(", noiHocLaiXe=");
		sb.append(noiHocLaiXe);
		sb.append(", noiCapGPLXNuocNgoai=");
		sb.append(noiCapGPLXNuocNgoai);
		sb.append(", noiCapGPLX=");
		sb.append(noiCapGPLX);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append("}");

		return sb.toString();
	}

	public ChiTietGPLX toEntityModel() {
		ChiTietGPLXImpl chiTietGPLXImpl = new ChiTietGPLXImpl();

		chiTietGPLXImpl.setId(id);
		chiTietGPLXImpl.setIdGPLX(idGPLX);

		if (soGPLX == null) {
			chiTietGPLXImpl.setSoGPLX(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setSoGPLX(soGPLX);
		}

		chiTietGPLXImpl.setIdHangGPLX(idHangGPLX);
		chiTietGPLXImpl.setIdNoiCapGPLX(idNoiCapGPLX);
		chiTietGPLXImpl.setIdNoiCapGPLXNuocNgoai(idNoiCapGPLXNuocNgoai);

		if (ngayCapGPLX == Long.MIN_VALUE) {
			chiTietGPLXImpl.setNgayCapGPLX(null);
		}
		else {
			chiTietGPLXImpl.setNgayCapGPLX(new Date(ngayCapGPLX));
		}

		if (ngayTrungTuyen == Long.MIN_VALUE) {
			chiTietGPLXImpl.setNgayTrungTuyen(null);
		}
		else {
			chiTietGPLXImpl.setNgayTrungTuyen(new Date(ngayTrungTuyen));
		}

		if (ngayHetHan == Long.MIN_VALUE) {
			chiTietGPLXImpl.setNgayHetHan(null);
		}
		else {
			chiTietGPLXImpl.setNgayHetHan(new Date(ngayHetHan));
		}

		chiTietGPLXImpl.setIdNoiHocLaiXe(idNoiHocLaiXe);
		chiTietGPLXImpl.setIdNoiHocLaiXeNuocNgoai(idNoiHocLaiXeNuocNgoai);
		chiTietGPLXImpl.setNamHocLaiXe(namHocLaiXe);

		if (noiHocLaiXeNuocNgoai == null) {
			chiTietGPLXImpl.setNoiHocLaiXeNuocNgoai(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNoiHocLaiXeNuocNgoai(noiHocLaiXeNuocNgoai);
		}

		if (noiHocLaiXe == null) {
			chiTietGPLXImpl.setNoiHocLaiXe(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNoiHocLaiXe(noiHocLaiXe);
		}

		if (noiCapGPLXNuocNgoai == null) {
			chiTietGPLXImpl.setNoiCapGPLXNuocNgoai(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNoiCapGPLXNuocNgoai(noiCapGPLXNuocNgoai);
		}

		if (noiCapGPLX == null) {
			chiTietGPLXImpl.setNoiCapGPLX(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNoiCapGPLX(noiCapGPLX);
		}

		if (ngayTao == Long.MIN_VALUE) {
			chiTietGPLXImpl.setNgayTao(null);
		}
		else {
			chiTietGPLXImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			chiTietGPLXImpl.setNgaySua(null);
		}
		else {
			chiTietGPLXImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			chiTietGPLXImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			chiTietGPLXImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			chiTietGPLXImpl.setNguoiSua(nguoiSua);
		}

		chiTietGPLXImpl.resetOriginalValues();

		return chiTietGPLXImpl;
	}

	public long id;
	public long idGPLX;
	public String soGPLX;
	public long idHangGPLX;
	public long idNoiCapGPLX;
	public long idNoiCapGPLXNuocNgoai;
	public long ngayCapGPLX;
	public long ngayTrungTuyen;
	public long ngayHetHan;
	public long idNoiHocLaiXe;
	public long idNoiHocLaiXeNuocNgoai;
	public long namHocLaiXe;
	public String noiHocLaiXeNuocNgoai;
	public String noiHocLaiXe;
	public String noiCapGPLXNuocNgoai;
	public String noiCapGPLX;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
}