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

import org.oep.cmon.dao.job.service.TrangThaiJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author BinhNT
 */
public class TrangThaiJobClp extends BaseModelImpl<TrangThaiJob>
	implements TrangThaiJob {
	public TrangThaiJobClp() {
	}

	public Class<?> getModelClass() {
		return TrangThaiJob.class;
	}

	public String getModelClassName() {
		return TrangThaiJob.class.getName();
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

	public Date getStartTime() {
		return _StartTime;
	}

	public void setStartTime(Date StartTime) {
		_StartTime = StartTime;
	}

	public Date getEndTime() {
		return _EndTime;
	}

	public void setEndTime(Date EndTime) {
		_EndTime = EndTime;
	}

	public int getStatus() {
		return _Status;
	}

	public void setStatus(int Status) {
		_Status = Status;
	}

	public int getRunMode() {
		return _RunMode;
	}

	public void setRunMode(int RunMode) {
		_RunMode = RunMode;
	}

	public String getMessage() {
		return _Message;
	}

	public void setMessage(String Message) {
		_Message = Message;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TrangThaiJobLocalServiceUtil.addTrangThaiJob(this);
		}
		else {
			TrangThaiJobLocalServiceUtil.updateTrangThaiJob(this);
		}
	}

	@Override
	public TrangThaiJob toEscapedModel() {
		return (TrangThaiJob)Proxy.newProxyInstance(TrangThaiJob.class.getClassLoader(),
			new Class[] { TrangThaiJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TrangThaiJobClp clone = new TrangThaiJobClp();

		clone.setID(getID());
		clone.setJobId(getJobId());
		clone.setJobName(getJobName());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setStatus(getStatus());
		clone.setRunMode(getRunMode());
		clone.setMessage(getMessage());

		return clone;
	}

	public int compareTo(TrangThaiJob trangThaiJob) {
		int value = 0;

		if (getID() < trangThaiJob.getID()) {
			value = -1;
		}
		else if (getID() > trangThaiJob.getID()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TrangThaiJobClp trangThaiJob = null;

		try {
			trangThaiJob = (TrangThaiJobClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = trangThaiJob.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", JobId=");
		sb.append(getJobId());
		sb.append(", JobName=");
		sb.append(getJobName());
		sb.append(", StartTime=");
		sb.append(getStartTime());
		sb.append(", EndTime=");
		sb.append(getEndTime());
		sb.append(", Status=");
		sb.append(getStatus());
		sb.append(", RunMode=");
		sb.append(getRunMode());
		sb.append(", Message=");
		sb.append(getMessage());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.job.model.TrangThaiJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
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
			"<column><column-name>StartTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EndTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RunMode</column-name><column-value><![CDATA[");
		sb.append(getRunMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private int _JobId;
	private String _JobName;
	private Date _StartTime;
	private Date _EndTime;
	private int _Status;
	private int _RunMode;
	private String _Message;
}