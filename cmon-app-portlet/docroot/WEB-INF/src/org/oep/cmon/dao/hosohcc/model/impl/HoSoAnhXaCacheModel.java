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

import org.oep.cmon.dao.hosohcc.model.HoSoAnhXa;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing HoSoAnhXa in entity cache.
 *
 * @author LIEMNn
 * @see HoSoAnhXa
 * @generated
 */
public class HoSoAnhXaCacheModel implements CacheModel<HoSoAnhXa>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", hoSoTTHCCongId=");
		sb.append(hoSoTTHCCongId);
		sb.append(", maHoSo=");
		sb.append(maHoSo);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append("}");

		return sb.toString();
	}

	public HoSoAnhXa toEntityModel() {
		HoSoAnhXaImpl hoSoAnhXaImpl = new HoSoAnhXaImpl();

		hoSoAnhXaImpl.setId(id);
		hoSoAnhXaImpl.setHoSoTTHCCongId(hoSoTTHCCongId);

		if (maHoSo == null) {
			hoSoAnhXaImpl.setMaHoSo(StringPool.BLANK);
		}
		else {
			hoSoAnhXaImpl.setMaHoSo(maHoSo);
		}

		hoSoAnhXaImpl.setTrangThai(trangThai);

		if (ngaySua == Long.MIN_VALUE) {
			hoSoAnhXaImpl.setNgaySua(null);
		}
		else {
			hoSoAnhXaImpl.setNgaySua(new Date(ngaySua));
		}

		if (ngayTao == Long.MIN_VALUE) {
			hoSoAnhXaImpl.setNgayTao(null);
		}
		else {
			hoSoAnhXaImpl.setNgayTao(new Date(ngayTao));
		}

		hoSoAnhXaImpl.resetOriginalValues();

		return hoSoAnhXaImpl;
	}

	public long id;
	public long hoSoTTHCCongId;
	public String maHoSo;
	public int trangThai;
	public long ngaySua;
	public long ngayTao;
}