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

import org.oep.cmon.dao.cd.model.TrinhDoChuyenMon;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrinhDoChuyenMon in entity cache.
 *
 * @author LIEMNN
 * @see TrinhDoChuyenMon
 * @generated
 */
public class TrinhDoChuyenMonCacheModel implements CacheModel<TrinhDoChuyenMon>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

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
		sb.append(", chuyenMonId=");
		sb.append(chuyenMonId);
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

	public TrinhDoChuyenMon toEntityModel() {
		TrinhDoChuyenMonImpl trinhDoChuyenMonImpl = new TrinhDoChuyenMonImpl();

		trinhDoChuyenMonImpl.setId(id);

		if (ma == null) {
			trinhDoChuyenMonImpl.setMa(StringPool.BLANK);
		}
		else {
			trinhDoChuyenMonImpl.setMa(ma);
		}

		if (ten == null) {
			trinhDoChuyenMonImpl.setTen(StringPool.BLANK);
		}
		else {
			trinhDoChuyenMonImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			trinhDoChuyenMonImpl.setNgayTao(null);
		}
		else {
			trinhDoChuyenMonImpl.setNgayTao(new Date(ngayTao));
		}

		trinhDoChuyenMonImpl.setDaXoa(daXoa);
		trinhDoChuyenMonImpl.setChuyenMonId(chuyenMonId);

		if (nguoiTao == null) {
			trinhDoChuyenMonImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			trinhDoChuyenMonImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			trinhDoChuyenMonImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			trinhDoChuyenMonImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			trinhDoChuyenMonImpl.setNgaySua(null);
		}
		else {
			trinhDoChuyenMonImpl.setNgaySua(new Date(ngaySua));
		}

		trinhDoChuyenMonImpl.setPhienBan(phienBan);

		trinhDoChuyenMonImpl.resetOriginalValues();

		return trinhDoChuyenMonImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public long ngayTao;
	public int daXoa;
	public int chuyenMonId;
	public String nguoiTao;
	public String nguoiSua;
	public long ngaySua;
	public long phienBan;
}