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

package org.oep.cmon.dao.job.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.job.service.DanhSachJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author BinhNT
 */
public class DanhSachJobClp extends BaseModelImpl<DanhSachJob>
	implements DanhSachJob {
	public DanhSachJobClp() {
	}

	public Class<?> getModelClass() {
		return DanhSachJob.class;
	}

	public String getModelClassName() {
		return DanhSachJob.class.getName();
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getJobClass() {
		return _JobClass;
	}

	public void setJobClass(String JobClass) {
		_JobClass = JobClass;
	}

	public int getJobId() {
		return _JobId;
	}

	public void setJobId(int JobId) {
		_JobId = JobId;
	}

	public String getJobName() {
		return _JobName;
	}

	public void setJobName(String JobName) {
		_JobName = JobName;
	}

	public String getDescription() {
		return _Description;
	}

	public void setDescription(String Description) {
		_Description = Description;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhSachJobLocalServiceUtil.addDanhSachJob(this);
		}
		else {
			DanhSachJobLocalServiceUtil.updateDanhSachJob(this);
		}
	}

	@Override
	public DanhSachJob toEscapedModel() {
		return (DanhSachJob)Proxy.newProxyInstance(DanhSachJob.class.getClassLoader(),
			new Class[] { DanhSachJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhSachJobClp clone = new DanhSachJobClp();

		clone.setID(getID());
		clone.setJobClass(getJobClass());
		clone.setJobId(getJobId());
		clone.setJobName(getJobName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(DanhSachJob danhSachJob) {
		long primaryKey = danhSachJob.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		DanhSachJobClp danhSachJob = null;

		try {
			danhSachJob = (DanhSachJobClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhSachJob.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", JobClass=");
		sb.append(getJobClass());
		sb.append(", JobId=");
		sb.append(getJobId());
		sb.append(", JobName=");
		sb.append(getJobName());
		sb.append(", Description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.job.model.DanhSachJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JobClass</column-name><column-value><![CDATA[");
		sb.append(getJobClass());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>JobName</column-name><column-value><![CDATA[");
		sb.append(getJobName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _JobClass;
	private int _JobId;
	private String _JobName;
	private String _Description;
}