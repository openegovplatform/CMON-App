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

package org.oep.cmon.dao.job.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.oep.cmon.dao.job.model.LogMail;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LogMail in entity cache.
 *
 * @author BinhNT
 * @see LogMail
 * @generated
 */
public class LogMailCacheModel implements CacheModel<LogMail>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", type=");
		sb.append(type);
		sb.append(", hoSoTTHCCongId=");
		sb.append(hoSoTTHCCongId);
		sb.append(", createTime=");
		sb.append(createTime);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public LogMail toEntityModel() {
		LogMailImpl logMailImpl = new LogMailImpl();

		logMailImpl.setId(id);

		if (type == null) {
			logMailImpl.setType(StringPool.BLANK);
		}
		else {
			logMailImpl.setType(type);
		}

		logMailImpl.setHoSoTTHCCongId(hoSoTTHCCongId);

		if (createTime == Long.MIN_VALUE) {
			logMailImpl.setCreateTime(null);
		}
		else {
			logMailImpl.setCreateTime(new Date(createTime));
		}

		logMailImpl.setStatus(status);

		if (description == null) {
			logMailImpl.setDescription(StringPool.BLANK);
		}
		else {
			logMailImpl.setDescription(description);
		}

		logMailImpl.resetOriginalValues();

		return logMailImpl;
	}

	public long id;
	public String type;
	public long hoSoTTHCCongId;
	public long createTime;
	public int status;
	public String description;
}