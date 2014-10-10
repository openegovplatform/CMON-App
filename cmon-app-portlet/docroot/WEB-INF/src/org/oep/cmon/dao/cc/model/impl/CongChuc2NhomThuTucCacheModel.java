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

package org.oep.cmon.dao.cc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.cc.model.CongChuc2NhomThuTuc;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CongChuc2NhomThuTuc in entity cache.
 *
 * @author Liemnn
 * @see CongChuc2NhomThuTuc
 * @generated
 */
public class CongChuc2NhomThuTucCacheModel implements CacheModel<CongChuc2NhomThuTuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", congChucId=");
		sb.append(congChucId);
		sb.append(", nhomThuTucId=");
		sb.append(nhomThuTucId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", duocPhepEditCongDan=");
		sb.append(duocPhepEditCongDan);
		sb.append("}");

		return sb.toString();
	}

	public CongChuc2NhomThuTuc toEntityModel() {
		CongChuc2NhomThuTucImpl congChuc2NhomThuTucImpl = new CongChuc2NhomThuTucImpl();

		congChuc2NhomThuTucImpl.setId(id);
		congChuc2NhomThuTucImpl.setCongChucId(congChucId);
		congChuc2NhomThuTucImpl.setNhomThuTucId(nhomThuTucId);

		if (ngayTao == Long.MIN_VALUE) {
			congChuc2NhomThuTucImpl.setNgayTao(null);
		}
		else {
			congChuc2NhomThuTucImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			congChuc2NhomThuTucImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			congChuc2NhomThuTucImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			congChuc2NhomThuTucImpl.setNgaySua(null);
		}
		else {
			congChuc2NhomThuTucImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			congChuc2NhomThuTucImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			congChuc2NhomThuTucImpl.setNguoiSua(nguoiSua);
		}

		congChuc2NhomThuTucImpl.setDaXoa(daXoa);
		congChuc2NhomThuTucImpl.setDuocPhepEditCongDan(duocPhepEditCongDan);

		congChuc2NhomThuTucImpl.resetOriginalValues();

		return congChuc2NhomThuTucImpl;
	}

	public long id;
	public long congChucId;
	public long nhomThuTucId;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int daXoa;
	public int duocPhepEditCongDan;
}