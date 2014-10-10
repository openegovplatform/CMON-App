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

package org.oep.cmon.dao.csms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.oep.cmon.dao.csms.service.AnhChanDungYeuCauDangKyCongDanLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author NAM
 */
public class AnhChanDungYeuCauDangKyCongDanClp extends BaseModelImpl<AnhChanDungYeuCauDangKyCongDan>
	implements AnhChanDungYeuCauDangKyCongDan {
	public AnhChanDungYeuCauDangKyCongDanClp() {
	}

	public Class<?> getModelClass() {
		return AnhChanDungYeuCauDangKyCongDan.class;
	}

	public String getModelClassName() {
		return AnhChanDungYeuCauDangKyCongDan.class.getName();
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

	public String getAnhChanDung() {
		return _AnhChanDung;
	}

	public void setAnhChanDung(String AnhChanDung) {
		_AnhChanDung = AnhChanDung;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.addAnhChanDungYeuCauDangKyCongDan(this);
		}
		else {
			AnhChanDungYeuCauDangKyCongDanLocalServiceUtil.updateAnhChanDungYeuCauDangKyCongDan(this);
		}
	}

	@Override
	public AnhChanDungYeuCauDangKyCongDan toEscapedModel() {
		return (AnhChanDungYeuCauDangKyCongDan)Proxy.newProxyInstance(AnhChanDungYeuCauDangKyCongDan.class.getClassLoader(),
			new Class[] { AnhChanDungYeuCauDangKyCongDan.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AnhChanDungYeuCauDangKyCongDanClp clone = new AnhChanDungYeuCauDangKyCongDanClp();

		clone.setId(getId());
		clone.setAnhChanDung(getAnhChanDung());

		return clone;
	}

	public int compareTo(
		AnhChanDungYeuCauDangKyCongDan anhChanDungYeuCauDangKyCongDan) {
		long primaryKey = anhChanDungYeuCauDangKyCongDan.getPrimaryKey();

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

		AnhChanDungYeuCauDangKyCongDanClp anhChanDungYeuCauDangKyCongDan = null;

		try {
			anhChanDungYeuCauDangKyCongDan = (AnhChanDungYeuCauDangKyCongDanClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = anhChanDungYeuCauDangKyCongDan.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", AnhChanDung=");
		sb.append(getAnhChanDung());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.oep.cmon.dao.csms.model.AnhChanDungYeuCauDangKyCongDan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AnhChanDung</column-name><column-value><![CDATA[");
		sb.append(getAnhChanDung());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _AnhChanDung;
}