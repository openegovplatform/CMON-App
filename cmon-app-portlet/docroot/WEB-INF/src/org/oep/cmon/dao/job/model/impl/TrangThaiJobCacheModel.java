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

import org.oep.cmon.dao.job.model.TrangThaiJob;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing TrangThaiJob in entity cache.
 *
 * @author BinhNT
 * @see TrangThaiJob
 * @generated
 */
public class TrangThaiJobCacheModel implements CacheModel<TrangThaiJob>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", JobId=");
		sb.append(JobId);
		sb.append(", JobName=");
		sb.append(JobName);
		sb.append(", StartTime=");
		sb.append(StartTime);
		sb.append(", EndTime=");
		sb.append(EndTime);
		sb.append(", Status=");
		sb.append(Status);
		sb.append(", RunMode=");
		sb.append(RunMode);
		sb.append(", Message=");
		sb.append(Message);
		sb.append("}");

		return sb.toString();
	}

	public TrangThaiJob toEntityModel() {
		TrangThaiJobImpl trangThaiJobImpl = new TrangThaiJobImpl();

		trangThaiJobImpl.setID(ID);
		trangThaiJobImpl.setJobId(JobId);

		if (JobName == null) {
			trangThaiJobImpl.setJobName(StringPool.BLANK);
		}
		else {
			trangThaiJobImpl.setJobName(JobName);
		}

		if (StartTime == Long.MIN_VALUE) {
			trangThaiJobImpl.setStartTime(null);
		}
		else {
			trangThaiJobImpl.setStartTime(new Date(StartTime));
		}

		if (EndTime == Long.MIN_VALUE) {
			trangThaiJobImpl.setEndTime(null);
		}
		else {
			trangThaiJobImpl.setEndTime(new Date(EndTime));
		}

		trangThaiJobImpl.setStatus(Status);
		trangThaiJobImpl.setRunMode(RunMode);

		if (Message == null) {
			trangThaiJobImpl.setMessage(StringPool.BLANK);
		}
		else {
			trangThaiJobImpl.setMessage(Message);
		}

		trangThaiJobImpl.resetOriginalValues();

		return trangThaiJobImpl;
	}

	public long ID;
	public int JobId;
	public String JobName;
	public long StartTime;
	public long EndTime;
	public int Status;
	public int RunMode;
	public String Message;
}