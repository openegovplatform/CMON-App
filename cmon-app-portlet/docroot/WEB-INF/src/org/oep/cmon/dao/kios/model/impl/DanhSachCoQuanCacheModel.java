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

package org.oep.cmon.dao.kios.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.kios.model.DanhSachCoQuan;

import java.io.Serializable;

/**
 * The cache model class for representing DanhSachCoQuan in entity cache.
 *
 * @author VIENPN
 * @see DanhSachCoQuan
 * @generated
 */
public class DanhSachCoQuanCacheModel implements CacheModel<DanhSachCoQuan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", chaId=");
		sb.append(chaId);
		sb.append(", tenCapCoQuanQuanly=");
		sb.append(tenCapCoQuanQuanly);
		sb.append(", capCoQuanQuanLyId=");
		sb.append(capCoQuanQuanLyId);
		sb.append("}");

		return sb.toString();
	}

	public DanhSachCoQuan toEntityModel() {
		DanhSachCoQuanImpl danhSachCoQuanImpl = new DanhSachCoQuanImpl();

		danhSachCoQuanImpl.setId(id);

		if (ten == null) {
			danhSachCoQuanImpl.setTen(StringPool.BLANK);
		}
		else {
			danhSachCoQuanImpl.setTen(ten);
		}

		danhSachCoQuanImpl.setChaId(chaId);

		if (tenCapCoQuanQuanly == null) {
			danhSachCoQuanImpl.setTenCapCoQuanQuanly(StringPool.BLANK);
		}
		else {
			danhSachCoQuanImpl.setTenCapCoQuanQuanly(tenCapCoQuanQuanly);
		}

		danhSachCoQuanImpl.setCapCoQuanQuanLyId(capCoQuanQuanLyId);

		danhSachCoQuanImpl.resetOriginalValues();

		return danhSachCoQuanImpl;
	}

	public long id;
	public String ten;
	public Long chaId;
	public String tenCapCoQuanQuanly;
	public Long capCoQuanQuanLyId;
}