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

import org.oep.cmon.dao.job.model.DanhSachJob;

import java.io.Serializable;

/**
 * The cache model class for representing DanhSachJob in entity cache.
 *
 * @author BinhNT
 * @see DanhSachJob
 * @generated
 */
public class DanhSachJobCacheModel implements CacheModel<DanhSachJob>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", JobClass=");
		sb.append(JobClass);
		sb.append(", JobId=");
		sb.append(JobId);
		sb.append(", JobName=");
		sb.append(JobName);
		sb.append(", Description=");
		sb.append(Description);
		sb.append("}");

		return sb.toString();
	}

	public DanhSachJob toEntityModel() {
		DanhSachJobImpl danhSachJobImpl = new DanhSachJobImpl();

		danhSachJobImpl.setID(ID);

		if (JobClass == null) {
			danhSachJobImpl.setJobClass(StringPool.BLANK);
		}
		else {
			danhSachJobImpl.setJobClass(JobClass);
		}

		danhSachJobImpl.setJobId(JobId);

		if (JobName == null) {
			danhSachJobImpl.setJobName(StringPool.BLANK);
		}
		else {
			danhSachJobImpl.setJobName(JobName);
		}

		if (Description == null) {
			danhSachJobImpl.setDescription(StringPool.BLANK);
		}
		else {
			danhSachJobImpl.setDescription(Description);
		}

		danhSachJobImpl.resetOriginalValues();

		return danhSachJobImpl;
	}

	public long ID;
	public String JobClass;
	public int JobId;
	public String JobName;
	public String Description;
}