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

import org.oep.cmon.dao.nsd.model.VaiTro;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VaiTro in entity cache.
 *
 * @author Liemnn
 * @see VaiTro
 * @generated
 */
public class VaiTroCacheModel implements CacheModel<VaiTro>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", ungDungId=");
		sb.append(ungDungId);
		sb.append("}");

		return sb.toString();
	}

	public VaiTro toEntityModel() {
		VaiTroImpl vaiTroImpl = new VaiTroImpl();

		vaiTroImpl.setId(id);

		if (ma == null) {
			vaiTroImpl.setMa(StringPool.BLANK);
		}
		else {
			vaiTroImpl.setMa(ma);
		}

		if (ten == null) {
			vaiTroImpl.setTen(StringPool.BLANK);
		}
		else {
			vaiTroImpl.setTen(ten);
		}

		if (moTa == null) {
			vaiTroImpl.setMoTa(StringPool.BLANK);
		}
		else {
			vaiTroImpl.setMoTa(moTa);
		}

		if (ngayTao == Long.MIN_VALUE) {
			vaiTroImpl.setNgayTao(null);
		}
		else {
			vaiTroImpl.setNgayTao(new Date(ngayTao));
		}

		vaiTroImpl.setDaXoa(daXoa);

		if (nguoiTao == null) {
			vaiTroImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			vaiTroImpl.setNguoiTao(nguoiTao);
		}

		if (ngaySua == Long.MIN_VALUE) {
			vaiTroImpl.setNgaySua(null);
		}
		else {
			vaiTroImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiSua == null) {
			vaiTroImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			vaiTroImpl.setNguoiSua(nguoiSua);
		}

		vaiTroImpl.setTrangThai(trangThai);
		vaiTroImpl.setUngDungId(ungDungId);

		vaiTroImpl.resetOriginalValues();

		return vaiTroImpl;
	}

	public long id;
	public String ma;
	public String ten;
	public String moTa;
	public long ngayTao;
	public int daXoa;
	public String nguoiTao;
	public long ngaySua;
	public String nguoiSua;
	public int trangThai;
	public Long ungDungId;
}