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

package org.oep.cmon.dao.tlct.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.tlct.model.LichSuGiayToDinhKem;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LichSuGiayToDinhKem in entity cache.
 *
 * @author Liemnn
 * @see LichSuGiayToDinhKem
 * @generated
 */
public class LichSuGiayToDinhKemCacheModel implements CacheModel<LichSuGiayToDinhKem>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", giayToDinhKemHoSoId=");
		sb.append(giayToDinhKemHoSoId);
		sb.append(", hanhDong=");
		sb.append(hanhDong);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", noiLuuTruTaiLieuId=");
		sb.append(noiLuuTruTaiLieuId);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", tenTaiLieu=");
		sb.append(tenTaiLieu);
		sb.append("}");

		return sb.toString();
	}

	public LichSuGiayToDinhKem toEntityModel() {
		LichSuGiayToDinhKemImpl lichSuGiayToDinhKemImpl = new LichSuGiayToDinhKemImpl();

		lichSuGiayToDinhKemImpl.setId(id);
		lichSuGiayToDinhKemImpl.setGiayToDinhKemHoSoId(giayToDinhKemHoSoId);
		lichSuGiayToDinhKemImpl.setHanhDong(hanhDong);

		if (nguoiTao == null) {
			lichSuGiayToDinhKemImpl.setNguoiTao(StringPool.BLANK);
		}
		else {
			lichSuGiayToDinhKemImpl.setNguoiTao(nguoiTao);
		}

		lichSuGiayToDinhKemImpl.setNoiLuuTruTaiLieuId(noiLuuTruTaiLieuId);

		if (ngayTao == Long.MIN_VALUE) {
			lichSuGiayToDinhKemImpl.setNgayTao(null);
		}
		else {
			lichSuGiayToDinhKemImpl.setNgayTao(new Date(ngayTao));
		}

		if (tenTaiLieu == null) {
			lichSuGiayToDinhKemImpl.setTenTaiLieu(StringPool.BLANK);
		}
		else {
			lichSuGiayToDinhKemImpl.setTenTaiLieu(tenTaiLieu);
		}

		lichSuGiayToDinhKemImpl.resetOriginalValues();

		return lichSuGiayToDinhKemImpl;
	}

	public long id;
	public Long giayToDinhKemHoSoId;
	public int hanhDong;
	public String nguoiTao;
	public long noiLuuTruTaiLieuId;
	public long ngayTao;
	public String tenTaiLieu;
}