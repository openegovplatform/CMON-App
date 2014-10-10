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

import org.oep.cmon.dao.job.service.LogMailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author BinhNT
 */
public class LogMailClp extends BaseModelImpl<LogMail> implements LogMail {
	public LogMailClp() {
	}

	public Class<?> getModelClass() {
		return LogMail.class;
	}

	public String getModelClassName() {
		return LogMail.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getHoSoTTHCCongId() {
		return _hoSoTTHCCongId;
	}

	public void setHoSoTTHCCongId(long hoSoTTHCCongId) {
		_hoSoTTHCCongId = hoSoTTHCCongId;
	}

	public Date getCreateTime() {
		return _createTime;
	}

	public void setCreateTime(Date createTime) {
		_createTime = createTime;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LogMailLocalServiceUtil.addLogMail(this);
		}
		else {
			LogMailLocalServiceUtil.updateLogMail(this);
		}
	}

	@Override
	public LogMail toEscapedModel() {
		return (LogMail)Proxy.newProxyInstance(LogMail.class.getClassLoader(),
			new Class[] { LogMail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LogMailClp clone = new LogMailClp();

		clone.setId(getId());
		clone.setType(getType());
		clone.setHoSoTTHCCongId(getHoSoTTHCCongId());
		clone.setCreateTime(getCreateTime());
		clone.setStatus(getStatus());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(LogMail logMail) {
		int value = 0;

		if (getId() < logMail.getId()) {
			value = -1;
		}
		else if (getId() > logMail.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		LogMailClp logMail = null;

		try {
			logMail = (LogMailClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = logMail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", hoSoTTHCCongId=");
		sb.append(getHoSoTTHCCongId());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.job.model.LogMail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoSoTTHCCongId</column-name><column-value><![CDATA[");
		sb.append(getHoSoTTHCCongId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _type;
	private long _hoSoTTHCCongId;
	private Date _createTime;
	private int _status;
	private String _description;
}