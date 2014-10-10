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

import org.oep.cmon.dao.cd.model.TrinhDoHocVan;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrinhDoHocVan in entity cache.
 *
 * @author LIEMNN
 * @see TrinhDoHocVan
 * @generated
 */
public class TrinhDoHocVanCacheModel implements CacheModel<TrinhDoHocVan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append("}");

		return sb.toString();
	}

	public TrinhDoHocVan toEntityModel() {
		TrinhDoHocVanImpl trinhDoHocVanImpl = new TrinhDoHocVanImpl();

		trinhDoHocVanImpl.setId(id);

		if (ma == null) {
			trinhDoHocVanImpl.setMa(StringPool.BLANK);
		}
		else {
			trinhDoHocVanImpl.setMa(ma);
		}

		if (ten == null) {
			trinhDoHocVanImpl.setTen(StringPool.BLANK);
		}
		else {
			trinhDoHocVanImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			trinhDoHocVanImpl.setNgayTao(null);
		}
		else {
			trinhDoHocVanImpl.setNgayTao(new Date(ngayTao));
		}

		trinhDoHocVanImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			trinhDoHocVanImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			trinhDoHocVanImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			trinhDoHocVanImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			trinhDoHocVanImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			trinhDoHocVanImpl.setNgaySua(null);
		}
		else {
			trinhDoHocVanImpl.setNgaySua(new Date(ngaySua));
		}

		trinhDoHocVanImpl.setPhienBan(phienBan);

		trinhDoHocVanImpl.resetOriginalValues();

		return trinhDoHocVanImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
	public long phienBan;
}