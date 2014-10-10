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

import org.oep.cmon.dao.cd.model.ChuyenMon;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ChuyenMon in entity cache.
 *
 * @author LIEMNN
 * @see ChuyenMon
 * @generated
 */
public class ChuyenMonCacheModel implements CacheModel<ChuyenMon>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", phienban=");
		sb.append(phienban);
		sb.append(", ngaytao=");
		sb.append(ngaytao);
		sb.append(", nguoitao=");
		sb.append(nguoitao);
		sb.append(", ngaysua=");
		sb.append(ngaysua);
		sb.append(", nguoisua=");
		sb.append(nguoisua);
		sb.append(", daxoa=");
		sb.append(daxoa);
		sb.append("}");

		return sb.toString();
	}

	public ChuyenMon toEntityModel() {
		ChuyenMonImpl chuyenMonImpl = new ChuyenMonImpl();

		chuyenMonImpl.setId(id);

		if (ma == null) {
			chuyenMonImpl.setMa(StringPool.BLANK);
		}
		else {
			chuyenMonImpl.setMa(ma);
		}

		if (ten == null) {
			chuyenMonImpl.setTen(StringPool.BLANK);
		}
		else {
			chuyenMonImpl.setTen(ten);
		}

		chuyenMonImpl.setPhienban(phienban);

		if (ngaytao == Long.MIN_VALUE) {
			chuyenMonImpl.setNgaytao(null);
		}
		else {
			chuyenMonImpl.setNgaytao(new Date(ngaytao));
		}

		if (nguoitao == null) {
			chuyenMonImpl.setNguoitao(StringPool.BLANK);
		}
		else {
			chuyenMonImpl.setNguoitao(nguoitao);
		}

		if (ngaysua == Long.MIN_VALUE) {
			chuyenMonImpl.setNgaysua(null);
		}
		else {
			chuyenMonImpl.setNgaysua(new Date(ngaysua));
		}

		if (nguoisua == null) {
			chuyenMonImpl.setNguoisua(StringPool.BLANK);
		}
		else {
			chuyenMonImpl.setNguoisua(nguoisua);
		}

		chuyenMonImpl.setDaxoa(daxoa);

		chuyenMonImpl.resetOriginalValues();

		return chuyenMonImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long phienban;
	public long ngaytao;
	public String nguoitao;
	public long ngaysua;
	public String nguoisua;
	public long daxoa;
}