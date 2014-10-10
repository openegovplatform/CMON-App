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

package org.oep.cmon.dao.chungthuc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.chungthuc.model.ThanhPhanHoSoChungThuc;

import java.io.Serializable;

/**
 * The cache model class for representing ThanhPhanHoSoChungThuc in entity cache.
 *
 * @author vietho
 * @see ThanhPhanHoSoChungThuc
 * @generated
 */
public class ThanhPhanHoSoChungThucCacheModel implements CacheModel<ThanhPhanHoSoChungThuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{thanhPhanHoSoId=");
		sb.append(thanhPhanHoSoId);
		sb.append(", tieuDe=");
		sb.append(tieuDe);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", hoSoChungThucId=");
		sb.append(hoSoChungThucId);
		sb.append(", thuTuc2GiayToId=");
		sb.append(thuTuc2GiayToId);
		sb.append(", noiLuuTruHoSoDinhKemId=");
		sb.append(noiLuuTruHoSoDinhKemId);
		sb.append("}");

		return sb.toString();
	}

	public ThanhPhanHoSoChungThuc toEntityModel() {
		ThanhPhanHoSoChungThucImpl thanhPhanHoSoChungThucImpl = new ThanhPhanHoSoChungThucImpl();

		thanhPhanHoSoChungThucImpl.setThanhPhanHoSoId(thanhPhanHoSoId);

		if (tieuDe == null) {
			thanhPhanHoSoChungThucImpl.setTieuDe(StringPool.BLANK);
		}
		else {
			thanhPhanHoSoChungThucImpl.setTieuDe(tieuDe);
		}

		if (moTa == null) {
			thanhPhanHoSoChungThucImpl.setMoTa(StringPool.BLANK);
		}
		else {
			thanhPhanHoSoChungThucImpl.setMoTa(moTa);
		}

		thanhPhanHoSoChungThucImpl.setHoSoChungThucId(hoSoChungThucId);
		thanhPhanHoSoChungThucImpl.setThuTuc2GiayToId(thuTuc2GiayToId);
		thanhPhanHoSoChungThucImpl.setNoiLuuTruHoSoDinhKemId(noiLuuTruHoSoDinhKemId);

		thanhPhanHoSoChungThucImpl.resetOriginalValues();

		return thanhPhanHoSoChungThucImpl;
	}

	public long thanhPhanHoSoId;
	public String tieuDe;
	public String moTa;
	public Long hoSoChungThucId;
	public Long thuTuc2GiayToId;
	public Long noiLuuTruHoSoDinhKemId;
}