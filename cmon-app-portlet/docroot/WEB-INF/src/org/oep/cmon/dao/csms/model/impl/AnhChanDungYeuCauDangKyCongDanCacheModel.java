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

package org.oep.cmon.dao.csms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan;

import java.io.Serializable;

/**
 * The cache model class for representing AnhChanDungYeuCauDangKyCongDan in entity cache.
 *
 * @author NAM
 * @see AnhChanDungYeuCauDangKyCongDan
 * @generated
 */
public class AnhChanDungYeuCauDangKyCongDanCacheModel implements CacheModel<AnhChanDungYeuCauDangKyCongDan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", AnhChanDung=");
		sb.append(AnhChanDung);
		sb.append("}");

		return sb.toString();
	}

	public AnhChanDungYeuCauDangKyCongDan toEntityModel() {
		AnhChanDungYeuCauDangKyCongDanImpl anhChanDungYeuCauDangKyCongDanImpl = new AnhChanDungYeuCauDangKyCongDanImpl();

		anhChanDungYeuCauDangKyCongDanImpl.setId(id);

		if (AnhChanDung == null) {
			anhChanDungYeuCauDangKyCongDanImpl.setAnhChanDung(StringPool.BLANK);
		}
		else {
			anhChanDungYeuCauDangKyCongDanImpl.setAnhChanDung(AnhChanDung);
		}

		anhChanDungYeuCauDangKyCongDanImpl.resetOriginalValues();

		return anhChanDungYeuCauDangKyCongDanImpl;
	}

	public long id;
	public String AnhChanDung;
}