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

import org.oep.cmon.dao.report.service.Role2BaoCaoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class Role2BaoCaoClp extends BaseModelImpl<Role2BaoCao>
	implements Role2BaoCao {
	public Role2BaoCaoClp() {
	}

	public Class<?> getModelClass() {
		return Role2BaoCao.class;
	}

	public String getModelClassName() {
		return Role2BaoCao.class.getName();
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

	public long getRPDANHMUCROLEID() {
		return _RPDANHMUCROLEID;
	}

	public void setRPDANHMUCROLEID(long RPDANHMUCROLEID) {
		_RPDANHMUCROLEID = RPDANHMUCROLEID;
	}

	public long getRPDANHMUCBAOCAOID() {
		return _RPDANHMUCBAOCAOID;
	}

	public void setRPDANHMUCBAOCAOID(long RPDANHMUCBAOCAOID) {
		_RPDANHMUCBAOCAOID = RPDANHMUCBAOCAOID;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			Role2BaoCaoLocalServiceUtil.addRole2BaoCao(this);
		}
		else {
			Role2BaoCaoLocalServiceUtil.updateRole2BaoCao(this);
		}
	}

	@Override
	public Role2BaoCao toEscapedModel() {
		return (Role2BaoCao)Proxy.newProxyInstance(Role2BaoCao.class.getClassLoader(),
			new Class[] { Role2BaoCao.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		Role2BaoCaoClp clone = new Role2BaoCaoClp();

		clone.setID(getID());
		clone.setRPDANHMUCROLEID(getRPDANHMUCROLEID());
		clone.setRPDANHMUCBAOCAOID(getRPDANHMUCBAOCAOID());

		return clone;
	}

	public int compareTo(Role2BaoCao role2BaoCao) {
		int value = 0;

		if (getID() < role2BaoCao.getID()) {
			value = -1;
		}
		else if (getID() > role2BaoCao.getID()) {
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

		Role2BaoCaoClp role2BaoCao = null;

		try {
			role2BaoCao = (Role2BaoCaoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = role2BaoCao.getPrimaryKey();

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
		sb.append(", RPDANHMUCROLEID=");
		sb.append(getRPDANHMUCROLEID());
		sb.append(", RPDANHMUCBAOCAOID=");
		sb.append(getRPDANHMUCBAOCAOID());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.Role2BaoCao");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RPDANHMUCROLEID</column-name><column-value><![CDATA[");
		sb.append(getRPDANHMUCROLEID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RPDANHMUCBAOCAOID</column-name><column-value><![CDATA[");
		sb.append(getRPDANHMUCBAOCAOID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private long _RPDANHMUCROLEID;
	private long _RPDANHMUCBAOCAOID;
}