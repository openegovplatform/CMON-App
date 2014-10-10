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

package org.oep.cmon.dao.report.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.report.service.CongChuc2RoleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class CongChuc2RoleClp extends BaseModelImpl<CongChuc2Role>
	implements CongChuc2Role {
	public CongChuc2RoleClp() {
	}

	public Class<?> getModelClass() {
		return CongChuc2Role.class;
	}

	public String getModelClassName() {
		return CongChuc2Role.class.getName();
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

	public long getCONGCHUCID() {
		return _CONGCHUCID;
	}

	public void setCONGCHUCID(long CONGCHUCID) {
		_CONGCHUCID = CONGCHUCID;
	}

	public long getRPDANHMUCROLEID() {
		return _RPDANHMUCROLEID;
	}

	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_RPDANHMUCROLEID = RPDANHMUCROLEID;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CongChuc2RoleLocalServiceUtil.addCongChuc2Role(this);
		}
		else {
			CongChuc2RoleLocalServiceUtil.updateCongChuc2Role(this);
		}
	}

	@Override
	public CongChuc2Role toEscapedModel() {
		return (CongChuc2Role)Proxy.newProxyInstance(CongChuc2Role.class.getClassLoader(),
			new Class[] { CongChuc2Role.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CongChuc2RoleClp clone = new CongChuc2RoleClp();

		clone.setID(getID());
		clone.setCONGCHUCID(getCONGCHUCID());
		clone.setRPDANHMUCROLEID(getRPDANHMUCROLEID());

		return clone;
	}

	public int compareTo(CongChuc2Role congChuc2Role) {
		int value = 0;

		if (getID() < congChuc2Role.getID()) {
			value = -1;
		}
		else if (getID() > congChuc2Role.getID()) {
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

		CongChuc2RoleClp congChuc2Role = null;

		try {
			congChuc2Role = (CongChuc2RoleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = congChuc2Role.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", CONGCHUCID=");
		sb.append(getCONGCHUCID());
		sb.append(", RPDANHMUCROLEID=");
		sb.append(getRPDANHMUCROLEID());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.CongChuc2Role");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CONGCHUCID</column-name><column-value><![CDATA[");
		sb.append(getCONGCHUCID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RPDANHMUCROLEID</column-name><column-value><![CDATA[");
		sb.append(getRPDANHMUCROLEID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private long _CONGCHUCID;
	private long _RPDANHMUCROLEID;
}