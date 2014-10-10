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

import org.oep.cmon.dao.chungthuc.model.SoDanhMuc;

import java.io.Serializable;

/**
 * The cache model class for representing SoDanhMuc in entity cache.
 *
 * @author vietho
 * @see SoDanhMuc
 * @generated
 */
public class SoDanhMucCacheModel implements CacheModel<SoDanhMuc>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tenSo=");
		sb.append(tenSo);
		sb.append(", soSo=");
		sb.append(soSo);
		sb.append(", thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", nam=");
		sb.append(nam);
		sb.append(", theoQuyetDinh=");
		sb.append(theoQuyetDinh);
		sb.append(", coQuanQuanLiId=");
		sb.append(coQuanQuanLiId);
		sb.append("}");

		return sb.toString();
	}

	public SoDanhMuc toEntityModel() {
		SoDanhMucImpl soDanhMucImpl = new SoDanhMucImpl();

		soDanhMucImpl.setId(id);

		if (tenSo == null) {
			soDanhMucImpl.setTenSo(StringPool.BLANK);
		}
		else {
			soDanhMucImpl.setTenSo(tenSo);
		}

		if (soSo == null) {
			soDanhMucImpl.setSoSo(StringPool.BLANK);
		}
		else {
			soDanhMucImpl.setSoSo(soSo);
		}

		soDanhMucImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		soDanhMucImpl.setNam(nam);

		if (theoQuyetDinh == null) {
			soDanhMucImpl.setTheoQuyetDinh(StringPool.BLANK);
		}
		else {
			soDanhMucImpl.setTheoQuyetDinh(theoQuyetDinh);
		}

		soDanhMucImpl.setCoQuanQuanLiId(coQuanQuanLiId);

		soDanhMucImpl.resetOriginalValues();

		return soDanhMucImpl;
	}

	public long id;
	public String tenSo;
	public String soSo;
	public Long thuTucHanhChinhId;
	public Long nam;
	public String theoQuyetDinh;
	public Long coQuanQuanLiId;
}