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

import org.oep.cmon.dao.qlhc.model.ChucVu2VaiTro;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChucVu2VaiTro in entity cache.
 *
 * @author LIEMNN
 * @see ChucVu2VaiTro
 * @generated
 */
public class ChucVu2VaiTroCacheModel implements CacheModel<ChucVu2VaiTro>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
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
		sb.append(", vaiTroId=");
		sb.append(vaiTroId);
		sb.append(", coQuanQuanLyId=");
		sb.append(coQuanQuanLyId);
		sb.append(", chucVuId=");
		sb.append(chucVuId);
		sb.append("}");

		return sb.toString();
	}

	public ChucVu2VaiTro toEntityModel() {
		ChucVu2VaiTroImpl chucVu2VaiTroImpl = new ChucVu2VaiTroImpl();

		chucVu2VaiTroImpl.setId(id);

		if (ngayTao == Long.MIN_VALUE) {
			chucVu2VaiTroImpl.setNgayTao(null);
		}
		else {
			chucVu2VaiTroImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			chucVu2VaiTroImpl.setNgaySua(null);
		}
		else {
			chucVu2VaiTroImpl.setNgaySua(new Date(ngaySua));
		}

		chucVu2VaiTroImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			chucVu2VaiTroImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			chucVu2VaiTroImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			chucVu2VaiTroImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			chucVu2VaiTroImpl.setNguoiSua(nguoiSua);
		}

		chucVu2VaiTroImpl.setVaiTroId(vaiTroId);
		chucVu2VaiTroImpl.setCoQuanQuanLyId(coQuanQuanLyId);
		chucVu2VaiTroImpl.setChucVuId(chucVuId);

		chucVu2VaiTroImpl.resetOriginalValues();

		return chucVu2VaiTroImpl;
	}

	public long id;
	public long ngayTao;
	public long ngaySua;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public Long vaiTroId;
	public Long coQuanQuanLyId;
	public Long chucVuId;
}