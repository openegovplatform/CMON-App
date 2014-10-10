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

package org.oep.exch.dao.hoso.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.exch.dao.hoso.service.ExchFileDinhKemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author NAM
 */
public class ExchFileDinhKemClp extends BaseModelImpl<ExchFileDinhKem>
	implements ExchFileDinhKem {
	public ExchFileDinhKemClp() {
	}

	public Class<?> getModelClass() {
		return ExchFileDinhKem.class;
	}

	public String getModelClassName() {
		return ExchFileDinhKem.class.getName();
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

	public long getOnlineId() {
		return _OnlineId;
	}

	public void setOnlineId(long OnlineId) {
		_OnlineId = OnlineId;
	}

	public String getTenTaiLieuDinhKem() {
		return _TenTaiLieuDinhKem;
	}

	public void setTenTaiLieuDinhKem(String TenTaiLieuDinhKem) {
		_TenTaiLieuDinhKem = TenTaiLieuDinhKem;
	}

	public String getUrlTaiLieuDinhKem() {
		return _UrlTaiLieuDinhKem;
	}

	public void setUrlTaiLieuDinhKem(String UrlTaiLieuDinhKem) {
		_UrlTaiLieuDinhKem = UrlTaiLieuDinhKem;
	}

	public String getTenFile() {
		return _TenFile;
	}

	public void setTenFile(String TenFile) {
		_TenFile = TenFile;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ExchFileDinhKemLocalServiceUtil.addExchFileDinhKem(this);
		}
		else {
			ExchFileDinhKemLocalServiceUtil.updateExchFileDinhKem(this);
		}
	}

	@Override
	public ExchFileDinhKem toEscapedModel() {
		return (ExchFileDinhKem)Proxy.newProxyInstance(ExchFileDinhKem.class.getClassLoader(),
			new Class[] { ExchFileDinhKem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExchFileDinhKemClp clone = new ExchFileDinhKemClp();

		clone.setId(getId());
		clone.setOnlineId(getOnlineId());
		clone.setTenTaiLieuDinhKem(getTenTaiLieuDinhKem());
		clone.setUrlTaiLieuDinhKem(getUrlTaiLieuDinhKem());
		clone.setTenFile(getTenFile());

		return clone;
	}

	public int compareTo(ExchFileDinhKem exchFileDinhKem) {
		long primaryKey = exchFileDinhKem.getPrimaryKey();

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

		ExchFileDinhKemClp exchFileDinhKem = null;

		try {
			exchFileDinhKem = (ExchFileDinhKemClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = exchFileDinhKem.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", OnlineId=");
		sb.append(getOnlineId());
		sb.append(", TenTaiLieuDinhKem=");
		sb.append(getTenTaiLieuDinhKem());
		sb.append(", UrlTaiLieuDinhKem=");
		sb.append(getUrlTaiLieuDinhKem());
		sb.append(", TenFile=");
		sb.append(getTenFile());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.oep.exch.dao.hoso.model.ExchFileDinhKem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>OnlineId</column-name><column-value><![CDATA[");
		sb.append(getOnlineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenTaiLieuDinhKem</column-name><column-value><![CDATA[");
		sb.append(getTenTaiLieuDinhKem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UrlTaiLieuDinhKem</column-name><column-value><![CDATA[");
		sb.append(getUrlTaiLieuDinhKem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>TenFile</column-name><column-value><![CDATA[");
		sb.append(getTenFile());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _OnlineId;
	private String _TenTaiLieuDinhKem;
	private String _UrlTaiLieuDinhKem;
	private String _TenFile;
}