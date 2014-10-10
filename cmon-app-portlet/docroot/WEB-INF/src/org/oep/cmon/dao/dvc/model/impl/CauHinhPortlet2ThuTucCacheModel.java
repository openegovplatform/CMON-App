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

package org.oep.cmon.dao.dvc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc;

import java.io.Serializable;

/**
 * The cache model class for representing CauHinhPortlet2ThuTuc in entity cache.
 *
 * @author liemnn
 * @see CauHinhPortlet2ThuTuc
 * @generated
 */
public class CauHinhPortlet2ThuTucCacheModel implements CacheModel<CauHinhPortlet2ThuTuc>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{thuTucHanhChinhId=");
		sb.append(thuTucHanhChinhId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", portletName=");
		sb.append(portletName);
		sb.append("}");

		return sb.toString();
	}

	public CauHinhPortlet2ThuTuc toEntityModel() {
		CauHinhPortlet2ThuTucImpl cauHinhPortlet2ThuTucImpl = new CauHinhPortlet2ThuTucImpl();

		cauHinhPortlet2ThuTucImpl.setThuTucHanhChinhId(thuTucHanhChinhId);
		cauHinhPortlet2ThuTucImpl.setPortletId(portletId);

		if (portletName == null) {
			cauHinhPortlet2ThuTucImpl.setPortletName(StringPool.BLANK);
		}
		else {
			cauHinhPortlet2ThuTucImpl.setPortletName(portletName);
		}

		cauHinhPortlet2ThuTucImpl.resetOriginalValues();

		return cauHinhPortlet2ThuTucImpl;
	}

	public long thuTucHanhChinhId;
	public long portletId;
	public String portletName;
}