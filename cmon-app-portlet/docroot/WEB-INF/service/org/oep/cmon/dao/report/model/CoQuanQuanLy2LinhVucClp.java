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

import org.oep.cmon.dao.report.service.CoQuanQuanLy2LinhVucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class CoQuanQuanLy2LinhVucClp extends BaseModelImpl<CoQuanQuanLy2LinhVuc>
	implements CoQuanQuanLy2LinhVuc {
	public CoQuanQuanLy2LinhVucClp() {
	}

	public Class<?> getModelClass() {
		return CoQuanQuanLy2LinhVuc.class;
	}

	public String getModelClassName() {
		return CoQuanQuanLy2LinhVuc.class.getName();
	}

	public long getPrimaryKey() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setPrimaryKey(long primaryKey) {
		setNHOMTHUTUCHANHCHINHID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_NHOMTHUTUCHANHCHINHID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getNHOMTHUTUCHANHCHINHID() {
		return _NHOMTHUTUCHANHCHINHID;
	}

	public void setNHOMTHUTUCHANHCHINHID(long NHOMTHUTUCHANHCHINHID) {
		_NHOMTHUTUCHANHCHINHID = NHOMTHUTUCHANHCHINHID;
	}

	public String getTENNHOMTTHC() {
		return _TENNHOMTTHC;
	}

	public void setTENNHOMTTHC(String TENNHOMTTHC) {
		_TENNHOMTTHC = TENNHOMTTHC;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CoQuanQuanLy2LinhVucLocalServiceUtil.addCoQuanQuanLy2LinhVuc(this);
		}
		else {
			CoQuanQuanLy2LinhVucLocalServiceUtil.updateCoQuanQuanLy2LinhVuc(this);
		}
	}

	@Override
	public CoQuanQuanLy2LinhVuc toEscapedModel() {
		return (CoQuanQuanLy2LinhVuc)Proxy.newProxyInstance(CoQuanQuanLy2LinhVuc.class.getClassLoader(),
			new Class[] { CoQuanQuanLy2LinhVuc.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CoQuanQuanLy2LinhVucClp clone = new CoQuanQuanLy2LinhVucClp();

		clone.setNHOMTHUTUCHANHCHINHID(getNHOMTHUTUCHANHCHINHID());
		clone.setTENNHOMTTHC(getTENNHOMTTHC());

		return clone;
	}

	public int compareTo(CoQuanQuanLy2LinhVuc coQuanQuanLy2LinhVuc) {
		int value = 0;

		if (getNHOMTHUTUCHANHCHINHID() < coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID()) {
			value = -1;
		}
		else if (getNHOMTHUTUCHANHCHINHID() > coQuanQuanLy2LinhVuc.getNHOMTHUTUCHANHCHINHID()) {
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

		CoQuanQuanLy2LinhVucClp coQuanQuanLy2LinhVuc = null;

		try {
			coQuanQuanLy2LinhVuc = (CoQuanQuanLy2LinhVucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = coQuanQuanLy2LinhVuc.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{NHOMTHUTUCHANHCHINHID=");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append(", TENNHOMTTHC=");
		sb.append(getTENNHOMTTHC());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.report.model.CoQuanQuanLy2LinhVuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>NHOMTHUTUCHANHCHINHID</column-name><column-value><![CDATA[");
		sb.append(getNHOMTHUTUCHANHCHINHID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TENNHOMTTHC</column-name><column-value><![CDATA[");
		sb.append(getTENNHOMTTHC());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _NHOMTHUTUCHANHCHINHID;
	private String _TENNHOMTTHC;
}