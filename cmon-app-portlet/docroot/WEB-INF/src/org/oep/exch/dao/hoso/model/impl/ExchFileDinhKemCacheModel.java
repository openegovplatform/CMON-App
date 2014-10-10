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

package org.oep.exch.dao.hoso.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.exch.dao.hoso.model.ExchFileDinhKem;

import java.io.Serializable;

/**
 * The cache model class for representing ExchFileDinhKem in entity cache.
 *
 * @author NAM
 * @see ExchFileDinhKem
 * @generated
 */
public class ExchFileDinhKemCacheModel implements CacheModel<ExchFileDinhKem>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", OnlineId=");
		sb.append(OnlineId);
		sb.append(", TenTaiLieuDinhKem=");
		sb.append(TenTaiLieuDinhKem);
		sb.append(", UrlTaiLieuDinhKem=");
		sb.append(UrlTaiLieuDinhKem);
		sb.append(", TenFile=");
		sb.append(TenFile);
		sb.append("}");

		return sb.toString();
	}

	public ExchFileDinhKem toEntityModel() {
		ExchFileDinhKemImpl exchFileDinhKemImpl = new ExchFileDinhKemImpl();

		exchFileDinhKemImpl.setId(id);
		exchFileDinhKemImpl.setOnlineId(OnlineId);

		if (TenTaiLieuDinhKem == null) {
			exchFileDinhKemImpl.setTenTaiLieuDinhKem(StringPool.BLANK);
		}
		else {
			exchFileDinhKemImpl.setTenTaiLieuDinhKem(TenTaiLieuDinhKem);
		}

		if (UrlTaiLieuDinhKem == null) {
			exchFileDinhKemImpl.setUrlTaiLieuDinhKem(StringPool.BLANK);
		}
		else {
			exchFileDinhKemImpl.setUrlTaiLieuDinhKem(UrlTaiLieuDinhKem);
		}

		if (TenFile == null) {
			exchFileDinhKemImpl.setTenFile(StringPool.BLANK);
		}
		else {
			exchFileDinhKemImpl.setTenFile(TenFile);
		}

		exchFileDinhKemImpl.resetOriginalValues();

		return exchFileDinhKemImpl;
	}

	public long id;
	public long OnlineId;
	public String TenTaiLieuDinhKem;
	public String UrlTaiLieuDinhKem;
	public String TenFile;
}