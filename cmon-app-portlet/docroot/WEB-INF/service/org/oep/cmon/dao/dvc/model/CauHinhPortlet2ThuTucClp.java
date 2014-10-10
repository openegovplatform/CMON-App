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

package org.oep.cmon.dao.dvc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.dvc.service.CauHinhPortlet2ThuTucLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author liemnn
 */
public class CauHinhPortlet2ThuTucClp extends BaseModelImpl<CauHinhPortlet2ThuTuc>
	implements CauHinhPortlet2ThuTuc {
	public CauHinhPortlet2ThuTucClp() {
	}

	public Class<?> getModelClass() {
		return CauHinhPortlet2ThuTuc.class;
	}

	public String getModelClassName() {
		return CauHinhPortlet2ThuTuc.class.getName();
	}

	public long getPrimaryKey() {
		return _thuTucHanhChinhId;
	}

	public void setPrimaryKey(long primaryKey) {
		setThuTucHanhChinhId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_thuTucHanhChinhId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getThuTucHanhChinhId() {
		return _thuTucHanhChinhId;
	}

	public void setThuTucHanhChinhId(long thuTucHanhChinhId) {
		_thuTucHanhChinhId = thuTucHanhChinhId;
	}

	public long getPortletId() {
		return _portletId;
	}

	public void setPortletId(long portletId) {
		_portletId = portletId;
	}

	public String getPortletName() {
		return _portletName;
	}

	public void setPortletName(String portletName) {
		_portletName = portletName;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CauHinhPortlet2ThuTucLocalServiceUtil.addCauHinhPortlet2ThuTuc(this);
		}
		else {
			CauHinhPortlet2ThuTucLocalServiceUtil.updateCauHinhPortlet2ThuTuc(this);
		}
	}

	@Override
	public CauHinhPortlet2ThuTuc toEscapedModel() {
		return (CauHinhPortlet2ThuTuc)Proxy.newProxyInstance(CauHinhPortlet2ThuTuc.class.getClassLoader(),
			new Class[] { CauHinhPortlet2ThuTuc.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CauHinhPortlet2ThuTucClp clone = new CauHinhPortlet2ThuTucClp();

		clone.setThuTucHanhChinhId(getThuTucHanhChinhId());
		clone.setPortletId(getPortletId());
		clone.setPortletName(getPortletName());

		return clone;
	}

	public int compareTo(CauHinhPortlet2ThuTuc cauHinhPortlet2ThuTuc) {
		int value = 0;

		if (getThuTucHanhChinhId() < cauHinhPortlet2ThuTuc.getThuTucHanhChinhId()) {
			value = -1;
		}
		else if (getThuTucHanhChinhId() > cauHinhPortlet2ThuTuc.getThuTucHanhChinhId()) {
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

		CauHinhPortlet2ThuTucClp cauHinhPortlet2ThuTuc = null;

		try {
			cauHinhPortlet2ThuTuc = (CauHinhPortlet2ThuTucClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cauHinhPortlet2ThuTuc.getPrimaryKey();

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

		sb.append("{thuTucHanhChinhId=");
		sb.append(getThuTucHanhChinhId());
		sb.append(", portletId=");
		sb.append(getPortletId());
		sb.append(", portletName=");
		sb.append(getPortletName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.dvc.model.CauHinhPortlet2ThuTuc");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>thuTucHanhChinhId</column-name><column-value><![CDATA[");
		sb.append(getThuTucHanhChinhId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletId</column-name><column-value><![CDATA[");
		sb.append(getPortletId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portletName</column-name><column-value><![CDATA[");
		sb.append(getPortletName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _thuTucHanhChinhId;
	private long _portletId;
	private String _portletName;
}