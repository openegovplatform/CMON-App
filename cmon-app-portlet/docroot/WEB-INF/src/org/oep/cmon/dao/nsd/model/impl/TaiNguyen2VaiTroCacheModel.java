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

package org.oep.cmon.dao.nsd.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.nsd.model.TaiNguyen2VaiTro;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TaiNguyen2VaiTro in entity cache.
 *
 * @author Liemnn
 * @see TaiNguyen2VaiTro
 * @generated
 */
public class TaiNguyen2VaiTroCacheModel implements CacheModel<TaiNguyen2VaiTro>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", taiNguyenId=");
		sb.append(taiNguyenId);
		sb.append(", vaiTroId=");
		sb.append(vaiTroId);
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
		sb.append("}");

		return sb.toString();
	}

	public TaiNguyen2VaiTro toEntityModel() {
		TaiNguyen2VaiTroImpl taiNguyen2VaiTroImpl = new TaiNguyen2VaiTroImpl();

		taiNguyen2VaiTroImpl.setId(id);
		taiNguyen2VaiTroImpl.setTaiNguyenId(taiNguyenId);
		taiNguyen2VaiTroImpl.setVaiTroId(vaiTroId);
		taiNguyen2VaiTroImpl.setHanhDong(hanhDong);

		if (ngayTao == Long.MIN_VALUE) {
			taiNguyen2VaiTroImpl.setNgayTao(null);
		}
		else {
			taiNguyen2VaiTroImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			taiNguyen2VaiTroImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			taiNguyen2VaiTroImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			taiNguyen2VaiTroImpl.setNgaySua(null);
		}
		else {
			taiNguyen2VaiTroImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			taiNguyen2VaiTroImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			taiNguyen2VaiTroImpl.setNguoiSua(nguoiSua);
		}

		taiNguyen2VaiTroImpl.setDaXoa(daXoa);

		taiNguyen2VaiTroImpl.resetOriginalValues();

		return taiNguyen2VaiTroImpl;
	}

	public long id;
	public Long taiNguyenId;
	public Long vaiTroId;
	public int hanhDong;
	public long ngayTao;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int daXoa;
}