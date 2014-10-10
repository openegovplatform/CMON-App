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

import org.oep.cmon.dao.nsd.model.NguoiDung2VaiTro;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NguoiDung2VaiTro in entity cache.
 *
 * @author Liemnn
 * @see NguoiDung2VaiTro
 * @generated
 */
public class NguoiDung2VaiTroCacheModel implements CacheModel<NguoiDung2VaiTro>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", vaiTroId=");
		sb.append(vaiTroId);
		sb.append(", taiKhoanNguoiDungId=");
		sb.append(taiKhoanNguoiDungId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append("}");

		return sb.toString();
	}

	public NguoiDung2VaiTro toEntityModel() {
		NguoiDung2VaiTroImpl nguoiDung2VaiTroImpl = new NguoiDung2VaiTroImpl();

		nguoiDung2VaiTroImpl.setId(id);
		nguoiDung2VaiTroImpl.setVaiTroId(vaiTroId);
		nguoiDung2VaiTroImpl.setTaiKhoanNguoiDungId(taiKhoanNguoiDungId);

		if (ngayTao == Long.MIN_VALUE) {
			nguoiDung2VaiTroImpl.setNgayTao(null);
		}
		else {
			nguoiDung2VaiTroImpl.setNgayTao(new Date(ngayTao));
		}

		if (nguoiTao == null) {
			nguoiDung2VaiTroImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			nguoiDung2VaiTroImpl.setNguoiTao(nguoiTao);
		}

		nguoiDung2VaiTroImpl.setDaXoa(daXoa);

		nguoiDung2VaiTroImpl.resetOriginalValues();

		return nguoiDung2VaiTroImpl;
	}

	public long id;
	public Long vaiTroId;
	public Long taiKhoanNguoiDungId;
	public long ngayTao;
	public String nguoiTao;
	public int daXoa;
}