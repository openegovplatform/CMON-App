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

package org.oep.cmon.dao.hosohcc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.hosohcc.model.YKienTraoDoi;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing YKienTraoDoi in entity cache.
 *
 * @author LIEMNn
 * @see YKienTraoDoi
 * @generated
 */
public class YKienTraoDoiCacheModel implements CacheModel<YKienTraoDoi>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tieuDe=");
		sb.append(tieuDe);
		sb.append(", noiDungYKien=");
		sb.append(noiDungYKien);
		sb.append(", thoiGianGuiYKien=");
		sb.append(thoiGianGuiYKien);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", hoSoTTHCCongId=");
		sb.append(hoSoTTHCCongId);
		sb.append(", nguoiNhanId=");
		sb.append(nguoiNhanId);
		sb.append(", nguoiGuiId=");
		sb.append(nguoiGuiId);
		sb.append(", chaiId=");
		sb.append(chaiId);
		sb.append(", noiLuuTruId=");
		sb.append(noiLuuTruId);
		sb.append(", loai=");
		sb.append(loai);
		sb.append("}");

		return sb.toString();
	}

	public YKienTraoDoi toEntityModel() {
		YKienTraoDoiImpl yKienTraoDoiImpl = new YKienTraoDoiImpl();

		yKienTraoDoiImpl.setId(id);

		if (tieuDe == null) {
			yKienTraoDoiImpl.setTieuDe(StringPool.BLANK);
		}
		else {
			yKienTraoDoiImpl.setTieuDe(tieuDe);
		}

		if (noiDungYKien == null) {
			yKienTraoDoiImpl.setNoiDungYKien(StringPool.BLANK);
		}
		else {
			yKienTraoDoiImpl.setNoiDungYKien(noiDungYKien);
		}

		if (thoiGianGuiYKien == Long.MIN_VALUE) {
			yKienTraoDoiImpl.setThoiGianGuiYKien(null);
		}
		else {
			yKienTraoDoiImpl.setThoiGianGuiYKien(new Date(thoiGianGuiYKien));
		}

		yKienTraoDoiImpl.setTrangThai(trangThai);
		yKienTraoDoiImpl.setHoSoTTHCCongId(hoSoTTHCCongId);
		yKienTraoDoiImpl.setNguoiNhanId(nguoiNhanId);
		yKienTraoDoiImpl.setNguoiGuiId(nguoiGuiId);
		yKienTraoDoiImpl.setChaiId(chaiId);
		yKienTraoDoiImpl.setNoiLuuTruId(noiLuuTruId);
		yKienTraoDoiImpl.setLoai(loai);

		yKienTraoDoiImpl.resetOriginalValues();

		return yKienTraoDoiImpl;
	}

	public long id;
	public String tieuDe;
	public String noiDungYKien;
	public long thoiGianGuiYKien;
	public long trangThai;
	public Long hoSoTTHCCongId;
	public Long nguoiNhanId;
	public Long nguoiGuiId;
	public Long chaiId;
	public Long noiLuuTruId;
	public long loai;
}