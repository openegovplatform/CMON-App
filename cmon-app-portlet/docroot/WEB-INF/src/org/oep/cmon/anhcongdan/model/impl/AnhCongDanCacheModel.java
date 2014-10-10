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

package org.oep.cmon.anhcongdan.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.anhcongdan.model.AnhCongDan;

import java.io.Serializable;

/**
 * The cache model class for representing AnhCongDan in entity cache.
 *
 * @author BinhNT
 * @see AnhCongDan
 * @generated
 */
public class AnhCongDanCacheModel implements CacheModel<AnhCongDan>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ma=");
		sb.append(ma);
		sb.append(", email=");
		sb.append(email);
		sb.append(", anh=");
		sb.append(anh);
		sb.append("}");

		return sb.toString();
	}

	public AnhCongDan toEntityModel() {
		AnhCongDanImpl anhCongDanImpl = new AnhCongDanImpl();

		anhCongDanImpl.setId(id);

		if (ma == null) {
			anhCongDanImpl.setMa(StringPool.BLANK);
		}
		else {
			anhCongDanImpl.setMa(ma);
		}

		if (email == null) {
			anhCongDanImpl.setEmail(StringPool.BLANK);
		}
		else {
			anhCongDanImpl.setEmail(email);
		}

		if (anh == null) {
			anhCongDanImpl.setAnh(StringPool.BLANK);
		}
		else {
			anhCongDanImpl.setAnh(anh);
		}

		anhCongDanImpl.resetOriginalValues();

		return anhCongDanImpl;
	}

	public long id;
	public String ma;
	public String email;
	public String anh;
}