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

package org.oep.cmon.dao.report.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc;

import java.io.Serializable;

/**
 * The cache model class for representing CoQuanQuanLy2LinhVuc in entity cache.
 *
 * @author VIENPN
 * @see CoQuanQuanLy2LinhVuc
 * @generated
 */
public class CoQuanQuanLy2LinhVucCacheModel implements CacheModel<CoQuanQuanLy2LinhVuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(NHOMTHUTUCHANHCHINHID);
		sb.append(", TENNHOMTTHC=");
		sb.append(TENNHOMTTHC);
		sb.append("}");

		return sb.toString();
	}

	public CoQuanQuanLy2LinhVuc toEntityModel() {
		CoQuanQuanLy2LinhVucImpl coQuanQuanLy2LinhVucImpl = new CoQuanQuanLy2LinhVucImpl();

		coQuanQuanLy2LinhVucImpl.setNHOMTHUTUCHANHCHINHID(NHOMTHUTUCHANHCHINHID);

		if (TENNHOMTTHC == null) {
			coQuanQuanLy2LinhVucImpl.setTENNHOMTTHC(StringPool.BLANK);
		}
		else {
			coQuanQuanLy2LinhVucImpl.setTENNHOMTTHC(TENNHOMTTHC);
		}

		coQuanQuanLy2LinhVucImpl.resetOriginalValues();

		return coQuanQuanLy2LinhVucImpl;
	}

	public long NHOMTHUTUCHANHCHINHID;
	public String TENNHOMTTHC;
}