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

import org.oep.cmon.dao.cd.model.TonGiao;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TonGiao in entity cache.
 *
 * @author LIEMNN
 * @see TonGiao
 * @generated
 */
public class TonGiaoCacheModel implements CacheModel<TonGiao>, Serializable {
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

	public TonGiao toEntityModel() {
		TonGiaoImpl tonGiaoImpl = new TonGiaoImpl();

		tonGiaoImpl.setId(id);

		if (ma == null) {
			tonGiaoImpl.setMa(StringPool.BLANK);
		}
		else {
			tonGiaoImpl.setMa(ma);
		}

		if (ten == null) {
			tonGiaoImpl.setTen(StringPool.BLANK);
		}
		else {
			tonGiaoImpl.setTen(ten);
		}

		if (ngayTao == Long.MIN_VALUE) {
			tonGiaoImpl.setNgayTao(null);
		}
		else {
			tonGiaoImpl.setNgayTao(new Date(ngayTao));
		}

		tonGiaoImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			tonGiaoImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			tonGiaoImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			tonGiaoImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			tonGiaoImpl.setNguoiSua(nguoiSua);
		}

		if (ngaySua == Long.MIN_VALUE) {
			tonGiaoImpl.setNgaySua(null);
		}
		else {
			tonGiaoImpl.setNgaySua(new Date(ngaySua));
		}

		tonGiaoImpl.setPhienBan(phienBan);

		tonGiaoImpl.resetOriginalValues();

		return tonGiaoImpl;
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