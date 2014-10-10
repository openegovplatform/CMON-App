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

import org.oep.cmon.dao.dvc.model.CapNhatKetQua;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CapNhatKetQua in entity cache.
 *
 * @author liemnn
 * @see CapNhatKetQua
 * @generated
 */
public class CapNhatKetQuaCacheModel implements CacheModel<CapNhatKetQua>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenBang=");
		sb.append(tenBang);
		sb.append(", banGhiId=");
		sb.append(banGhiId);
		sb.append(", hanhDong=");
		sb.append(hanhDong);
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
		sb.append(", hosoTTHCCId=");
		sb.append(hosoTTHCCId);
		sb.append("}");

		return sb.toString();
	}

	public CapNhatKetQua toEntityModel() {
		CapNhatKetQuaImpl capNhatKetQuaImpl = new CapNhatKetQuaImpl();

		capNhatKetQuaImpl.setId(id);

		if (tenBang == null) {
			capNhatKetQuaImpl.setTenBang(StringPool.BLANK);
		}
		else {
			capNhatKetQuaImpl.setTenBang(tenBang);
		}

		capNhatKetQuaImpl.setBanGhiId(banGhiId);
		capNhatKetQuaImpl.setHanhDong(hanhDong);

		if (ngayTao == Long.MIN_VALUE) {
			capNhatKetQuaImpl.setNgayTao(null);
		}
		else {
			capNhatKetQuaImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			capNhatKetQuaImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			capNhatKetQuaImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			capNhatKetQuaImpl.setNgaySua(null);
		}
		else {
			capNhatKetQuaImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			capNhatKetQuaImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			capNhatKetQuaImpl.setNguoiSua(nguoiSua);
		}

		capNhatKetQuaImpl.setDaXoa(daXoa);
		capNhatKetQuaImpl.setHosoTTHCCId(hosoTTHCCId);

		capNhatKetQuaImpl.resetOriginalValues();

		return capNhatKetQuaImpl;
	}

	public long id;
	public String tenBang;
	public long banGhiId;
	public int hanhDong;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int daXoa;
	public long hosoTTHCCId;
}