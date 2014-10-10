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

package org.oep.cmon.dao.dn.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dn.model.DoanhNghiep2NganhNghe;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing DoanhNghiep2NganhNghe in entity cache.
 *
 * @author Liemnn
 * @see DoanhNghiep2NganhNghe
 * @generated
 */
public class DoanhNghiep2NganhNgheCacheModel implements CacheModel<DoanhNghiep2NganhNghe>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", laNganhChinh=");
		sb.append(laNganhChinh);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", doanhNghiepId=");
		sb.append(doanhNghiepId);
		sb.append(", nganhNgheId=");
		sb.append(nganhNgheId);
		sb.append("}");

		return sb.toString();
	}

	public DoanhNghiep2NganhNghe toEntityModel() {
		DoanhNghiep2NganhNgheImpl doanhNghiep2NganhNgheImpl = new DoanhNghiep2NganhNgheImpl();

		doanhNghiep2NganhNgheImpl.setId(id);
		doanhNghiep2NganhNgheImpl.setLaNganhChinh(laNganhChinh);

		if (ngayTao == Long.MIN_VALUE) {
			doanhNghiep2NganhNgheImpl.setNgayTao(null);
		}
		else {
			doanhNghiep2NganhNgheImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			doanhNghiep2NganhNgheImpl.setNgaySua(null);
		}
		else {
			doanhNghiep2NganhNgheImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			doanhNghiep2NganhNgheImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			doanhNghiep2NganhNgheImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			doanhNghiep2NganhNgheImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			doanhNghiep2NganhNgheImpl.setNguoiSua(nguoiSua);
		}

		doanhNghiep2NganhNgheImpl.setDaXoa(daXoa);
		doanhNghiep2NganhNgheImpl.setDoanhNghiepId(doanhNghiepId);
		doanhNghiep2NganhNgheImpl.setNganhNgheId(nganhNgheId);

		doanhNghiep2NganhNgheImpl.resetOriginalValues();

		return doanhNghiep2NganhNgheImpl;
	}

	public long id;
	public int laNganhChinh;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int daXoa;
	public long doanhNghiepId;
	public long nganhNgheId;
}