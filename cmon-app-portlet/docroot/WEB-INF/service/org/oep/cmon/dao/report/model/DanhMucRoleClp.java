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

import org.oep.cmon.dao.report.service.DanhMucRoleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class DanhMucRoleClp extends BaseModelImpl<DanhMucRole>
	implements DanhMucRole {
	public DanhMucRoleClp() {
	}

	public Class<?> getModelClass() {
		return DanhMucRole.class;
	}

	public String getModelClassName() {
		return DanhMucRole.class.getName();
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

	public String getNAME() {
		return _NAME;
	}

	public void setNAME(String NAME) {
		_NAME = NAME;
	}

	public int getORDERS() {
		return _ORDERS;
	}

	public void setORDERS(int ORDERS) {
		_ORDERS = ORDERS;
	}

	public int getSTATUS() {
		return _STATUS;
	}

	public void setSTATUS(int STATUS) {
		_STATUS = STATUS;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DanhMucRoleLocalServiceUtil.addDanhMucRole(this);
		}
		else {
			DanhMucRoleLocalServiceUtil.updateDanhMucRole(this);
		}
	}

	@Override
	public DanhMucRole toEscapedModel() {
		return (DanhMucRole)Proxy.newProxyInstance(DanhMucRole.class.getClassLoader(),
			new Class[] { DanhMucRole.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DanhMucRoleClp clone = new DanhMucRoleClp();

		clone.setID(getID());
		clone.setNAME(getNAME());
		clone.setORDERS(getORDERS());
		clone.setSTATUS(getSTATUS());

		return clone;
	}

	public int compareTo(DanhMucRole danhMucRole) {
		int value = 0;

		if (getID() < danhMucRole.getID()) {
			value = -1;
		}
		else if (getID() > danhMucRole.getID()) {
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

		DanhMucRoleClp danhMucRole = null;

		try {
			danhMucRole = (DanhMucRoleClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = danhMucRole.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", NAME=");
		sb.append(getNAME());
		sb.append(", ORDERS=");
		sb.append(getORDERS());
		sb.append(", STATUS=");
		sb.append(getSTATUS());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.DanhMucRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NAME</column-name><column-value><![CDATA[");
		sb.append(getNAME());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ORDERS</column-name><column-value><![CDATA[");
		sb.append(getORDERS());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>STATUS</column-name><column-value><![CDATA[");
		sb.append(getSTATUS());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _NAME;
	private int _ORDERS;
	private int _STATUS;
}