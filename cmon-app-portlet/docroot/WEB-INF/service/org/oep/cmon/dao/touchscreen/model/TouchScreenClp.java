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

package org.oep.cmon.dao.touchscreen.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.touchscreen.service.TouchScreenLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author VIENPN
 */
public class TouchScreenClp extends BaseModelImpl<TouchScreen>
	implements TouchScreen {
	public TouchScreenClp() {
	}

	public Class<?> getModelClass() {
		return TouchScreen.class;
	}

	public String getModelClassName() {
		return TouchScreen.class.getName();
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			TouchScreenLocalServiceUtil.addTouchScreen(this);
		}
		else {
			TouchScreenLocalServiceUtil.updateTouchScreen(this);
		}
	}

	@Override
	public TouchScreen toEscapedModel() {
		return (TouchScreen)Proxy.newProxyInstance(TouchScreen.class.getClassLoader(),
			new Class[] { TouchScreen.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TouchScreenClp clone = new TouchScreenClp();

		clone.setID(getID());
		clone.setNAME(getNAME());

		return clone;
	}

	public int compareTo(TouchScreen touchScreen) {
		long primaryKey = touchScreen.getPrimaryKey();

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

		TouchScreenClp touchScreen = null;

		try {
			touchScreen = (TouchScreenClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = touchScreen.getPrimaryKey();

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

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", NAME=");
		sb.append(getNAME());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.touchscreen.model.TouchScreen");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>NAME</column-name><column-value><![CDATA[");
		sb.append(getNAME());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ID;
	private String _NAME;
}