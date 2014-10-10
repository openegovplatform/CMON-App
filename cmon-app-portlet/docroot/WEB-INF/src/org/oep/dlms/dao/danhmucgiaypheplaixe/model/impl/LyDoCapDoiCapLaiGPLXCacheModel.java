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

package org.oep.dlms.dao.danhmucgiaypheplaixe.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;


import java.io.Serializable;

import java.util.Date;

import org.oep.dlms.dao.danhmucgiaypheplaixe.model.LyDoCapDoiCapLaiGPLX;

/**
 * The cache model class for representing LyDoCapDoiCapLaiGPLX in entity cache.
 *
 * @author AnhNT
 * @see LyDoCapDoiCapLaiGPLX
 * @generated
 */
public class LyDoCapDoiCapLaiGPLXCacheModel implements CacheModel<LyDoCapDoiCapLaiGPLX>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", lyDo=");
		sb.append(lyDo);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", xoa=");
		sb.append(xoa);
		sb.append("}");

		return sb.toString();
	}

	public LyDoCapDoiCapLaiGPLX toEntityModel() {
		LyDoCapDoiCapLaiGPLXImpl lyDoCapDoiCapLaiGPLXImpl = new LyDoCapDoiCapLaiGPLXImpl();

		lyDoCapDoiCapLaiGPLXImpl.setId(id);

		if (lyDo == null) {
			lyDoCapDoiCapLaiGPLXImpl.setLyDo(StringPool.BLANK);
		}
		else {
			lyDoCapDoiCapLaiGPLXImpl.setLyDo(lyDo);
		}

		if (ngayTao == Long.MIN_VALUE) {
			lyDoCapDoiCapLaiGPLXImpl.setNgayTao(null);
		}
		else {
			lyDoCapDoiCapLaiGPLXImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			lyDoCapDoiCapLaiGPLXImpl.setNgaySua(null);
		}
		else {
			lyDoCapDoiCapLaiGPLXImpl.setNgaySua(new Date(ngaySua));
		}

		if (nguoiTao == null) {
			lyDoCapDoiCapLaiGPLXImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			lyDoCapDoiCapLaiGPLXImpl.setNguoiTao(nguoiTao);
		}

		if (nguoiSua == null) {
			lyDoCapDoiCapLaiGPLXImpl.setNguoiSua(StringPool.BLANK);
		}
		else {
			lyDoCapDoiCapLaiGPLXImpl.setNguoiSua(nguoiSua);
		}

		lyDoCapDoiCapLaiGPLXImpl.setXoa(xoa);

		lyDoCapDoiCapLaiGPLXImpl.resetOriginalValues();

		return lyDoCapDoiCapLaiGPLXImpl;
	}

	public long id;
	public String lyDo;
	public long ngayTao;
	public long ngaySua;
	public String nguoiTao;
	public String nguoiSua;
	public int xoa;
}